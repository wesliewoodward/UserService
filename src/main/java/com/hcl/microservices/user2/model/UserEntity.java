package com.hcl.microservices.user2.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Table("user")
@Getter
@Setter
public class UserEntity {
	
	@Id
	private Long user_id;
	
	//nullable=false, unique=true
	@Column("email")
	private String email;
	
	@Column("fname")
	private String fname;
	
	@Column("lname")
	private String lname;
	
	//cannot be empty
	@Column("password")
	private String password;
	
	@Column("active")
	private boolean active;
	
	@Column("created_on")
	private String created_on;
	
	@Column("address1")
	private String address1;
	
	@Column("address2")
	private String address2;
	
	@Column("state")
	private String state;
	
	@Column("city")
	private String city;
	
	@Column("zipcode")
	private String zipcode;
	
	@Column("country")
	private String country;
	
	@Column("phone")
	private String phone;
	
	@Column("is_Admin")
	private boolean isAdmin;
	
	@Column("image_file")
	private String image_file;
	
	
	

}
