package com.cv2.onboarding.entity;

import com.cv2.onboarding.util.EntityStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@NoArgsConstructor
public class EntityDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int tinNo;
	private String name;
	private  String  contactNo;
	private String mailId;
	private String password;
	@Enumerated(EnumType.STRING)
	private EntityStatus   status;
	
	@OneToOne(cascade = CascadeType.ALL)
	private AddressDetails address;

}
