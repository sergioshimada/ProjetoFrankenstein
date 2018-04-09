package br.com.projetofrankenstein.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.naming.OperationNotSupportedException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.projetofrankenstein.dto.ShowInformationUserDTO;
import br.com.projetofrankenstein.model.RegisterUserModel;
import br.com.projetofrankenstein.utils.StringUtils;

@Stateless
@Remote
public class UserController {

	@PersistenceContext(unitName = "PE-DATASOURCE")
	private EntityManager entityManager;

	private static final String QUERY_SELECT_USERS = "select id, name from LOGIN_USERS";

	private static final String QUERY_DELETE_USER_BY_ID = "DELETE FROM LOGIN_USERS WHERE ID = :1";

	@SuppressWarnings("unchecked")
	public List<ShowInformationUserDTO> showAllUsers() {

		List<ShowInformationUserDTO> listUsers = new ArrayList<ShowInformationUserDTO>();

		Query sql = this.entityManager.createNativeQuery(QUERY_SELECT_USERS);

		List<Object[]> results = sql.getResultList();

		for (Object[] obj : results) {

			listUsers.add(new ShowInformationUserDTO(Long.valueOf(String.valueOf(obj[0])), String.valueOf(obj[1])));
		}

		return listUsers;
	}

	public void saveUser(RegisterUserModel registerUserModel) throws OperationNotSupportedException {

		validateConfirmPassword(registerUserModel);

		this.entityManager.persist(registerUserModel);
	}

	private void validateConfirmPassword(RegisterUserModel registerUserModel) throws OperationNotSupportedException {
		if (!registerUserModel.getPassword().equalsIgnoreCase(registerUserModel.getConfirmPassword())) {
			throw new OperationNotSupportedException("Confirmação de senha invalida");
		}
	}

	public void deleteUser(Long id) {
		System.out.println("dhasudhsaudhausdhsua");
		try {
		entityManager.createNativeQuery(QUERY_DELETE_USER_BY_ID).setParameter("1", id).getSingleResult();
		}catch(Exception e) {
			System.out.println(e);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, StringUtils.MSG_DELETE_ERROR, ""));
		}
	}
}
