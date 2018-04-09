package br.com.projetofrankenstein.model;




import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "CUSTOMER_INFORMATION")
public class RegisterCustomerModel {

	
	@Id
	@SequenceGenerator(name = "CUSTOMER_SEQUENCE", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUSTOMER_SEQUENCE")
	@Column(name = "ID_CUSTOMER")
	private long idCustomer;

	@Column(name = "NAME_CUSTOMER")
	private String nameCustomer;

	@Column(name = "CPF_CUSTOMER")
	private Long cpfCustomer;
	
	@Temporal(javax.persistence.TemporalType.DATE)
	@Column(name = "BIRTH_DATE_CUSTOMER")
	private Date birthDateCustomer;

	@Column(name = "EMAIL_CUSTOMER")
	private String eMailCustomer;

	@Column(name = "STARTING_WEIGHT_CUSTOMER")
	private Double startingWeightCustomer;

	@Column(name = "HEIGHT_CUSTOMER")
	private Double heightCustomer;

	@Column(name = "DESCRIPTION_CUSTOMER")
	private String descriptionCustomer;
	

	public long getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(long idCustomer) {
		this.idCustomer = idCustomer;
	}

	public String getNameCustomer() {
		return nameCustomer;
	}

	public void setNameCustomer(String nameCustomer) {
		this.nameCustomer = nameCustomer;
	}

	public Long getCpfCustomer() {
		return cpfCustomer;
	}

	public void setCpfCustomer(Long cpfCustomer) {
		this.cpfCustomer = cpfCustomer;
	}

	public Date getBirthDateCustomer() {
		return birthDateCustomer;
	}

	public void setBirthDateCustomer(Date birthDateCustomer) {
		this.birthDateCustomer = birthDateCustomer;
	}

	public String geteMailCustomer() {
		return eMailCustomer;
	}

	public void seteMailCustomer(String eMailCustomer) {
		this.eMailCustomer = eMailCustomer;
	}

	public Double getStartingWeightCustomer() {
		return startingWeightCustomer;
	}

	public void setStartingWeightCustomer(Double startingWeightCustomer) {
		this.startingWeightCustomer = startingWeightCustomer;
	}

	public Double getHeightCustomer() {
		return heightCustomer;
	}

	public void setHeightCustomer(Double heightCustomer) {
		this.heightCustomer = heightCustomer;
	}

	public String getDescriptionCustomer() {
		return descriptionCustomer;
	}

	public void setDescriptionCustomer(String descriptionCustomer) {
		this.descriptionCustomer = descriptionCustomer;
	}
}
