package com.jsf;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * The persistent class for the Suppliers database table.
 * 
 */
@Entity
@Table(name="Suppliers")
@XmlRootElement(name = "supplier")
public class Supplier implements Serializable {
	private static final long serialVersionUID = 1L;


	@Column(name="Address")
	private String address;


	@Column(name="City")
	private String city;


	@Column(name="ContactName")
	private String contactName;


	@Column(name="ContactTitle")
	private String contactTitle;

	@Column(name="Country")
	private String country;


	@Column(name="EmailAddress")
	private String emailAddress;


	@Column(name="FaxNumber")
	private String faxNumber;


	@Column(name="Notes")
	private String notes;


	@Column(name="PaymentTerms")
	private String paymentTerms;


	@Column(name="PhoneNumber")
	private String phoneNumber;


	@Column(name="PostalCode")
	private String postalCode;


	@Column(name="StateOrProvince")
	private String stateOrProvince;

	@Id
	@Column(name="SupplierID")
	private int id;


	@Column(name="SupplierName")
	private String supplierName;
	
	@Column(name="canEdit")
	private boolean canEdit;

    public boolean isCanEdit() {
        return canEdit;
    }
    public void setCanEdit(boolean canEdit) {
        this.canEdit = canEdit;
    }

    public Supplier() {
    }
    
    @XmlElement(name = "address")
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    @XmlElement(name = "city")
    public String getCity() {
        return this.city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    @XmlElement(name = "contactName")
    public String getContactName() {
        return this.contactName;
    }
    
    public void setContactName(String contactName) {
        this.contactName = contactName;
    }
    @XmlElement(name = "contactTitle")
    public String getContactTitle() {
        return this.contactTitle;
    }
    
    public void setContactTitle(String contactTitle) {
        this.contactTitle = contactTitle;
    }
    
    @XmlElement(name = "country")
    public String getCountry() {
        return this.country;
    }
    
    public void setCountry(String country) {
        this.country = country;
    }
    
    public String getEmailAddress() {
        return this.emailAddress;
    }
    
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    

    @XmlElement(name = "faxNumber")
    public String getFaxNumber() {
        return this.faxNumber;
    }
    
    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }
    
    @XmlElement(name = "notes")
    public String getNotes() {
        return this.notes;
    }
    
    public void setNotes(String notes) {
        this.notes = notes;
    }
    
    @XmlElement(name = "paymentTerms")
    public String getPaymentTerms() {
        return this.paymentTerms;
    }
    
    public void setPaymentTerms(String paymentTerms) {
        this.paymentTerms = paymentTerms;
    }
    
    @XmlElement(name = "phoneNumber")
    public String getPhoneNumber() {
        return this.phoneNumber;
    }
    
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    @XmlElement(name = "postalCode")
    public String getPostalCode() {
        return this.postalCode;
    }
    
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    
    public String getStateOrProvince() {
        return this.stateOrProvince;
    }
    
    public void setStateOrProvince(String stateOrProvince) {
        this.stateOrProvince = stateOrProvince;
    }
    @XmlAttribute
    public int getId() {
        return id;
    }
    
    public void setId(int supplierId) {
        this.id = supplierId;
    }
    @XmlElement(name = "supplierName")
    public String getSupplierName() {
        return supplierName;
    }
    
    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }



}