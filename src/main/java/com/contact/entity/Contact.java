package com.contact.entity;

import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Contact 
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	
	@NonNull
	private String fristName;
	
	@NonNull
	private String lastName;
	@NonNull
	private String email;
	@NonNull
	private String  phoneNumber;
	@Override
	public String toString() {
		return "Contact [id=" + id + ", fristName=" + fristName + ", lastName=" + lastName + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + "]";
	}
	
	

}
