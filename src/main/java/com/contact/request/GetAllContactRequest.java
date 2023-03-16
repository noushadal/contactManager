package com.contact.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllContactRequest 
{
	
   private String fristName;
	
	
	private String lastName;

	private String email;

	private String  phoneNumber;

}
