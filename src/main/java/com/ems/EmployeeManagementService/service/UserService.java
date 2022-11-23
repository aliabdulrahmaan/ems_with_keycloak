//package com.ems.EmployeeManagementService.service;
//
//
//import com.ems.EmployeeManagementService.entites.User;
//import com.ems.EmployeeManagementService.exception.BadRequestAlertException;
//import com.ems.EmployeeManagementService.repositories.jpa.UserRepository;
//import lombok.AllArgsConstructor;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//
//@Service
//@Transactional
//@AllArgsConstructor
//public class UserService {
//
//    private final UserRepository userRepository;
//    private static final  String ENTITY_NAME= "User";
//
//    public User save(User user){
//        return userRepository.save(user);
//    }
//
//    @Transactional(readOnly = true)
//    public User findById(long id){
//
//        User result =userRepository.findById(id).orElseThrow(()->
//                new BadRequestAlertException("There is no user with this id",ENTITY_NAME,"userNotExists"));
//
//        return result;
//    }
//
//
//
//    @Transactional(readOnly = true)
//    public Page<User> findAll(int page, int size){
//        Pageable paging = PageRequest.of(page, size);
//        return userRepository.findAll(paging);
//    }
//
//    public void deleteById(Long id){
//        userRepository.deleteById(id);
//    }
//
//}
