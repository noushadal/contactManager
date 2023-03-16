package com.contact.service;

import com.contact.request.AddContactRequest;
import com.contact.request.UpadetContactRequest;
import com.contact.response.AddContactResponse;
import com.contact.response.DeleteContactResponse;
import com.contact.response.GetAllContactResponse;
import com.contact.response.UpdateContactResponse;

public interface IContactService
{
	
	//adding contact
	public AddContactResponse  addContact(AddContactRequest addContactRequest);
	
	//fecth all contact
	public GetAllContactResponse  getContact();
	
	//updateing  contact
	public UpdateContactResponse updateContact(Integer id,UpadetContactRequest ct);
	
	
	//deleting contact
	public DeleteContactResponse   deleteContact(Integer id);
	
	//feching contact by fristName
	
	public GetAllContactResponse  fecthContact(String fristName);
	
	//feching contact by lastName
	
	public GetAllContactResponse  fecthContactByLastName(String lastName);
	
	//feching contact by phoneNumber
	
	public GetAllContactResponse fechContactByPhoneNumber(String phoneNumber);
	
	

}
