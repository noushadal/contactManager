package com.contact.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contact.entity.Contact;
import com.contact.repository.ContactRepository;
import com.contact.request.AddContactRequest;
import com.contact.request.UpadetContactRequest;
import com.contact.response.AddContactResponse;
import com.contact.response.DeleteContactResponse;
import com.contact.response.GetAllContactResponse;
import com.contact.response.UpdateContactResponse;
import com.contact.security.exception.AppException;
import com.contact.service.IContactService;


@Service
public class ContractServiceImpl  implements IContactService
{
	
	@Autowired
	private ContactRepository contactRepository;

	@Override
	public AddContactResponse addContact(AddContactRequest addContactRequest) 
	{
		
		if(addContactRequest!=null)
		{
		Contact contact=new Contact();
		contact.setEmail(addContactRequest.getEmail());
		contact.setFristName(addContactRequest.getFristName());
		
		contact.setLastName(addContactRequest.getLastName());
		contact.setPhoneNumber(addContactRequest.getPhoneNumber());
		
		
		 contactRepository.save(contact) ; 
		
		
		return new AddContactResponse(true, "Contact added");
		}
		return new AddContactResponse(false, "details are not to be null");
	}

	@Override
	public GetAllContactResponse getContact()
	{ 
		
	try {
		List<Contact> getContact =contactRepository.findAll();
		
		
		return new GetAllContactResponse("contact is fetch"+getContact);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
		return new GetAllContactResponse("contact not found");
	}
	

	 

}

	@Override
	public UpdateContactResponse updateContact(Integer id,UpadetContactRequest ct)
	{
		
Contact	 contact=contactRepository.findById(id).orElseThrow(()-> new AppException("id not found"));
	

System.out.println("contact"+contact);
	if(contact!=null)
	{
		
		contact.setEmail(ct.getEmail());
		contact.setFristName(ct.getFristName());
		//contact.setId(ct.getId());
		contact.setLastName(ct.getLastName());
		contact.setPhoneNumber(ct.getPhoneNumber());
		  contactRepository.save(contact);
		return new UpdateContactResponse(true,"contact updated"+ id);
		
		
		
		
	}
	return new UpdateContactResponse(false,"contact not updated");
		
	
	}

	@Override
	public DeleteContactResponse deleteContact(Integer id)
	{
                contactRepository.deleteById(id);
		return new DeleteContactResponse(true,"contact deleted");
	}

	@Override
	public GetAllContactResponse fecthContact(String fristName)
	{
		Contact contact=contactRepository.findByfristName(fristName);
		System.out.println("contactc::"+contact);
	
		return  new GetAllContactResponse("data find out by fristName"+contact);
	}
	
	
	
	
	

	@Override
	public GetAllContactResponse fecthContactByLastName(String lastName) 
	{
		
		Contact contact  =contactRepository.findBylastName(lastName);
		return  new GetAllContactResponse("data find out by lastName"+contact);
		
		

	}

	@Override
	public GetAllContactResponse fechContactByPhoneNumber(String phoneNumber) 
	{
           Contact contact =contactRepository.findByphoneNumber(phoneNumber);
         
         return new GetAllContactResponse("data find out by lastName"+contact);
	}
	
	
	


}
