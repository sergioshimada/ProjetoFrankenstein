package br.com.projetofrankenstein.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.projetofrankenstein.dto.ShowInformationCustomerDTO;
import br.com.projetofrankenstein.model.RegisterCustomerModel;
import br.com.projetofrankenstein.utils.StringUtils;

@Stateless
@Remote
public class CustomerController implements Serializable{

	private static final long serialVersionUID = 5764285462230984121L;

	@PersistenceContext(unitName="PE-DATASOURCE")
	private EntityManager entityManager;
	
	private String QUERY_SELECT_CUSTOMERS = "SELECT ID_CUSTOMER, NAME_CUSTOMER, CPF_CUSTOMER FROM CUSTOMER_INFORMATION";
	private String QUERY_DELETE_BY_ID = "DELETE FROM CUSTOMER_INFORMATION WHERE ID_CUSTOMER = :1";
	
	public void saveCustomer(RegisterCustomerModel registerCustomerModel) {
		
		entityManager.persist(registerCustomerModel);
	}
	
	public void deleteCustomer(Long id) {
		System.out.println("dhasudhsaudhausdhsua");
		try {
		entityManager.createNativeQuery(QUERY_DELETE_BY_ID).setParameter("1", id).getSingleResult();
		}catch(Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, StringUtils.MSG_DELETE_ERROR, ""));
		}
	}
	

	@SuppressWarnings("unchecked")
	public List<ShowInformationCustomerDTO> showAllCustomers() {
		
		List<ShowInformationCustomerDTO> listCustomers = new ArrayList<ShowInformationCustomerDTO>();

		Query sql = entityManager.createNativeQuery(QUERY_SELECT_CUSTOMERS);
		
		List<Object[]> results = sql.getResultList();
		
		for (Object[] obj : results) {
			ShowInformationCustomerDTO customer = new ShowInformationCustomerDTO();
			customer.setId(Long.valueOf(String.valueOf(obj[0])));
			customer.setName(String.valueOf(obj[1]));
			customer.setCpf(Long.valueOf(String.valueOf(obj[2])));
			listCustomers.add(customer);
		}
		
		return listCustomers;
	}
}
