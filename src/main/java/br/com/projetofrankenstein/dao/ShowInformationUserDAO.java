package br.com.projetofrankenstein.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.projetofrankenstein.dto.ShowInformationUserDTO;

public class ShowInformationUserDAO {

	@PersistenceContext(unitName="PE-DATASOURCE")
	private EntityManager entityManager;
	
	private static final String QUERY_SELECT_USERS = "select id, name from LOGIN_USERS";

	
	@SuppressWarnings("unchecked")
	public List<ShowInformationUserDTO> showInformationAllUsers(List<ShowInformationUserDTO> listUsers) {
		Query sql = entityManager.createNativeQuery(QUERY_SELECT_USERS);

		
		List<Object[]> results = sql.getResultList();

		for (Object[] obj : results) {

			listUsers.add(new ShowInformationUserDTO(Long.valueOf(String.valueOf(obj[0])), String.valueOf(obj[1])));
		}
		
		return listUsers;
	}
}
