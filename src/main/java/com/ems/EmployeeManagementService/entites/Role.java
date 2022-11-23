//package com.ems.EmployeeManagementService.entites;
//
//import com.ems.EmployeeManagementService.entites.enumeration.ERole;
//import lombok.Getter;
//import lombok.Setter;
//import lombok.ToString;
//
//import javax.persistence.*;
//import java.util.Objects;
//
//@Entity
//@Table(name = "roles")
//@Setter
//@Getter
//@ToString
//public class Role {
//	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE)
//	private long id;
//
//	@Enumerated(EnumType.STRING)
//	@Column(length = 20)
//	private ERole name;
//
//	@Override
//	public boolean equals(Object o) {
//		if (this == o) return true;
//		if (o == null || getClass() != o.getClass()) return false;
//		Role role = (Role) o;
//		return id == role.id && name == role.name;
//	}
//
//	@Override
//	public int hashCode() {
//		 return  getClass().hashCode();
//	}
//}