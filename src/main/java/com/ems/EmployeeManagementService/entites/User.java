//package com.ems.EmployeeManagementService.entites;
//
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import lombok.Data;
//import lombok.Getter;
//import lombok.Setter;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import javax.persistence.*;
//import java.util.Collection;
//import java.util.HashSet;
//import java.util.LinkedHashSet;
//import java.util.Set;
//import java.util.stream.Collectors;
//
//@Entity
//@Table(name="user")
//@Setter
//@Getter
//public class User implements UserDetails {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    @Column(name = "id")
//    private long id;
//
//    @Column(name = "name")
//    private String userName;
//    @Column(name = "password")
//    private String password;
//    @Column(name = "active")
//    private Boolean active;
////    @Column(name = "roles")
////    private String roles;
//
//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(	name = "user_roles",
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "role_id"))
//    private Set<Role> roles = new LinkedHashSet<>();
//
//    @Override
//    @JsonIgnore
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return this.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getName().name())).collect(Collectors.toSet());
//    }
//
//
//
//    @Override
//    @JsonIgnore
//    public String getUsername() {
//        return userName;
//    }
//
//    @Override
//    @JsonIgnore
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    @JsonIgnore
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    @JsonIgnore
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    @JsonIgnore
//    public boolean isEnabled() {
//        return true;
//    }
//}
