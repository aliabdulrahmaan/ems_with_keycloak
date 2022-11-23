//package com.ems.EmployeeManagementService.service.security;
//
//import com.ems.EmployeeManagementService.entites.User;
//import lombok.Getter;
//import lombok.Setter;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Arrays;
//import java.util.Collection;
//import java.util.List;
//import java.util.Set;
//import java.util.stream.Collectors;
//
//@Setter
//@Getter
//public class UserDetailsImp implements UserDetails {
//
//    private long id;
//    private String userName;
//    private String password;
//    private Boolean active;
//    private Set<GrantedAuthority> authorities;
//
//    public UserDetailsImp(User user) {
//        this.id = user.getId();
//        this.userName = user.getUsername();
//        this.password = user.getPassword();
//        this.active = user.getActive();
////        this.authorities = Arrays.stream(user.getRoles().split(","))
////                .map(SimpleGrantedAuthority::new)
////                .collect(Collectors.toList());
//        this.authorities=user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getName().name())).collect(Collectors.toSet());
//
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return authorities;
//    }
//
//    @Override
//    public String getPassword() {
//        return password;
//    }
//
//    @Override
//    public String getUsername() {
//        return userName;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//}
