package br.com.projetofrankenstein.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.naming.OperationNotSupportedException;

import br.com.projetofrankenstein.controller.UserController;
import br.com.projetofrankenstein.dto.ShowInformationUserDTO;
import br.com.projetofrankenstein.model.RegisterUserModel;
import br.com.projetofrankenstein.utils.StringUtils;

@ManagedBean(name = "userBean")
@ViewScoped
public class UserBean implements Serializable {

	private static final long serialVersionUID = 5212581759382162955L;

	private RegisterUserModel registerUserModel = new RegisterUserModel();
	
	private List<ShowInformationUserDTO> listUsers = new ArrayList<ShowInformationUserDTO>();

	@EJB
	private transient UserController userController;

	@PostConstruct
	public void init() {
		this.listUsers = this.userController.showAllUsers();
	}
	
	public void confirmCadastro() {

		try {

			this.userController.saveUser(this.registerUserModel);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, StringUtils.MSG_SUCESSO, ""));

		} catch (OperationNotSupportedException e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, StringUtils.HEADER_ERRO, StringUtils.MSG_ERRO_SENHA));
		}
	}
	
	public void deleteUser(ShowInformationUserDTO user) {
		this.userController.deleteUser(user.getId());
	}

	public RegisterUserModel getCadastroModel() {
		return registerUserModel;
	}

	public void setCadastroModel(RegisterUserModel cadastroModel) {
		this.registerUserModel = cadastroModel;
	}

	public List<ShowInformationUserDTO> getListUsers() {
		return listUsers;
	}

	public void setListUsers(List<ShowInformationUserDTO> listUsers) {
		this.listUsers = listUsers;
	}
}
