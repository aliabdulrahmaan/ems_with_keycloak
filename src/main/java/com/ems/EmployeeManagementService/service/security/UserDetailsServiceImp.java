//package com.ems.EmployeeManagementService.service.security;
//
//import com.ems.EmployeeManagementService.entites.User;
//import com.ems.EmployeeManagementService.exception.BadRequestAlertException;
//import com.ems.EmployeeManagementService.repositories.jpa.UserRepository;
//import lombok.AllArgsConstructor;
//
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//
//@Service
//@AllArgsConstructor
//public class UserDetailsServiceImp implements UserDetailsService {
//    private static final  String ENTITY_NAME= "UserDetails";
//     private final UserRepository userRepository;
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//        Optional<User> user= userRepository.findByUserNameAndActiveTrue(username);
//        if(user.isPresent()){
//            return  new UserDetailsImp(user.get());
//        }else {
//            user.orElseThrow(()-> new BadRequestAlertException("There is no user with this userName",ENTITY_NAME,"userNotExists"));
//        }
//        return null;
//
//    }
//}
