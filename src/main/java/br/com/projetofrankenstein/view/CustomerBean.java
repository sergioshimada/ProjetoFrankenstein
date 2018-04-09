package br.com.projetofrankenstein.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.projetofrankenstein.controller.CustomerController;
import br.com.projetofrankenstein.dto.ShowInformationCustomerDTO;
import br.com.projetofrankenstein.model.RegisterCustomerModel;
import br.com.projetofrankenstein.utils.StringUtils;

@ManagedBean(name = "customerBean")
@ViewScoped
public class CustomerBean implements Serializable {

	private static final long serialVersionUID = -7776241571284294456L;

	private RegisterCustomerModel registerCustomerModel = new RegisterCustomerModel();
	private RegisterCustomerModelDTO dto = new RegisterCustomerModelDTO();
	private List<ShowInformationCustomerDTO> customers = new ArrayList<ShowInformationCustomerDTO>();

	@EJB
	private transient CustomerController customerController;

	@PostConstruct
	public void init() {
		this.customers = getListCustomers();
	}

	public List<ShowInformationCustomerDTO> getListCustomers() {

		return this.customerController.showAllCustomers();
	}

	public void deleteCustomer(ShowInformationCustomerDTO customer) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, StringUtils.MSG_DELETE_SUCESS, ""));
		this.customerController.deleteCustomer(customer.getId());

	}

	public void newCustomer() {

		this.registerCustomerModel.setBirthDateCustomer(dto.getBirthDateCustomer());
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, StringUtils.MSG_SUCESSO, ""));
		this.customerController.saveCustomer(this.registerCustomerModel);
	}

	public RegisterCustomerModel getRegisterCustomerModel() {
		return registerCustomerModel;
	}

	public void setRegisterCustomerModel(RegisterCustomerModel registerCustomerModel) {
		this.registerCustomerModel = registerCustomerModel;
	}

	public RegisterCustomerModelDTO getDto() {
		return dto;
	}

	public void setDto(RegisterCustomerModelDTO dto) {
		this.dto = dto;
	}

	public List<ShowInformationCustomerDTO> getCustomers() {
		return customers;
	}

	public void setCustomers(List<ShowInformationCustomerDTO> customers) {
		this.customers = customers;
	}

	public class RegisterCustomerModelDTO implements Serializable {

		/**
		 * 
		 */
		private static final long serialVersionUID = -2782336427771881679L;

		private Date birthDateCustomer;

		public Date getBirthDateCustomer() {
			return birthDateCustomer;
		}

		public void setBirthDateCustomer(Date birthDateCustomer) {
			this.birthDateCustomer = birthDateCustomer;
		}

	}

}
