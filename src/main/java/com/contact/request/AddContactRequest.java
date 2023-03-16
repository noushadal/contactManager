package com.contact.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddContactRequest 
{
	
	
	
	
	
	private String fristName;
	
	
	private String lastName;

	private String email;

	private String  phoneNumber;
	
	

}
