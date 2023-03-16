package com.contact.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.contact.entity.Contact;
import com.contact.request.AddContactRequest;
import com.contact.request.UpadetContactRequest;
import com.contact.response.AddContactResponse;
import com.contact.response.ApiResponse;
import com.contact.response.DeleteContactResponse;
import com.contact.response.GetAllContactResponse;
import com.contact.response.UpdateContactResponse;
import com.contact.service.IContactService;


@RestController
@RequestMapping("/contact")
public class ContactController 
{
	@Autowired
	private IContactService contactService;
	
	
	@PostMapping("/add")
	public ResponseEntity<?>  addContact(@RequestBody  AddContactRequest addContactRequest)
	{
		try {
		AddContactResponse response	=contactService.addContact(addContactRequest);
			
			return   new ResponseEntity<AddContactResponse>( response ,HttpStatus.OK);
		} catch (Exception e)
		{
			
			e.printStackTrace();
			
			return   new ResponseEntity<ApiResponse>( new ApiResponse("failed") ,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}
	
	
	
	@GetMapping("/getAll")
	public ResponseEntity<?>  getAllContact()
	{
		  try {
			GetAllContactResponse response=contactService.getContact();
			
			return new ResponseEntity<GetAllContactResponse>( response,HttpStatus.OK);
		} 
		  
		  
		  catch (Exception e) 
		  {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<ApiResponse>( new ApiResponse("failed") ,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		  
}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?>   updateRecordById(@PathVariable Integer id ,@RequestBody  UpadetContactRequest contact)
	{
		/*
		 * Contact con=new Contact(); con.setEmail(contact.getEmail());
		 * con.setFristName(contact.getFristName());
		 * con.setLastName(contact.getLastName());
		 * con.setPhoneNumber(contact.getPhoneNumber());
		 */
		
		    
		  try {
			 UpdateContactResponse response=contactService.updateContact(id,contact);
			
			return new ResponseEntity<UpdateContactResponse>(response,HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return new ResponseEntity<ApiResponse>( new ApiResponse("failed") ,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?>  deleteContact(@PathVariable Integer id)
	{
		
		try {
			DeleteContactResponse response=contactService.deleteContact(id);
			
			return new ResponseEntity<DeleteContactResponse>(response,HttpStatus.OK);
		} 
		catch (Exception e)
		{
			
			e.printStackTrace();
			
			return new  ResponseEntity<ApiResponse>( new ApiResponse("failed") ,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping("/fristName/{fristName}")
	public ResponseEntity<?>  GetDataByFristname(@PathVariable   String fristName)
	{
		
		try {
			GetAllContactResponse response=contactService.fecthContact(fristName);
			return new ResponseEntity<GetAllContactResponse>( response,HttpStatus.OK);
		} 
		catch (Exception e) 
		{
		
			e.printStackTrace();
			return new ResponseEntity<ApiResponse>( new ApiResponse("failed") ,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}
	
	
	@GetMapping("/lastName/{lastName}")
	public ResponseEntity<?>  getDataBylastName(@PathVariable String lastName)
	{
		try {
			GetAllContactResponse response   =contactService.fecthContactByLastName(lastName);
			
			return  new ResponseEntity<GetAllContactResponse>( response,HttpStatus.OK);
		}
		
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return new ResponseEntity<ApiResponse>( new ApiResponse("failed") ,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@GetMapping("/phoneNumber/{phoneNumber}")
	public ResponseEntity<?>  getDataByPhoneNumber(@PathVariable String phoneNumber)
	{
		
		try {
			GetAllContactResponse response      =contactService.fechContactByPhoneNumber(phoneNumber);
			return  new ResponseEntity<GetAllContactResponse>( response,HttpStatus.OK);
		} 
		
		catch (Exception e) 
		{
			
			e.printStackTrace();
			return new ResponseEntity<ApiResponse>( new ApiResponse("failed") ,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

}
