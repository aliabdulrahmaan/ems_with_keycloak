//package com.ems.EmployeeManagementService.controllers;
//
//
//import com.ems.EmployeeManagementService.config.security.JWTUtil;
//import com.ems.EmployeeManagementService.entites.Token;
//import com.ems.EmployeeManagementService.entites.User;
//import com.ems.EmployeeManagementService.exception.BadRequestAlertException;
//import com.ems.EmployeeManagementService.repositories.jpa.UserRepository;
//import com.ems.EmployeeManagementService.service.TokenService;
//import com.ems.EmployeeManagementService.service.UserService;
//
//import com.ems.EmployeeManagementService.service.dtos.CredentialDTO;
//import com.ems.EmployeeManagementService.service.dtos.TokenDTO;
//import com.ems.EmployeeManagementService.service.security.UserDetailsImp;
//import lombok.AllArgsConstructor;
//import org.springframework.data.domain.Page;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//
//@RestController
//@RequestMapping("/api/auth")
//@AllArgsConstructor
//public class UserController {
//
//    private final UserService userService;
//    private final TokenService tokenService;
//    private final UserRepository userRepository;
//
//    private final JWTUtil jwtUtils;
//
//    private static final  String ENTITY_NAME= "User";
//    private final AuthenticationManager authenticationManager;
//
//    @PostMapping("/users")
//    public ResponseEntity<User> create(@RequestBody @Valid User user){
//        User u = userService.save(user);
//        return ResponseEntity.ok(u);
//    }
//
//    @PostMapping("/signup")
//    public ResponseEntity<User> signup(@RequestBody @Valid User user){
//        if (userRepository.findByUserNameAndActiveTrue(user.getUsername()).isPresent()) {
////            return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
//          throw new BadRequestAlertException("Error: Username is already taken!",ENTITY_NAME,"userNameAlreadyTaken");
//        }
//        User u = userService.save(user);
//        return ResponseEntity.ok(u);
//    }
//
//    @PostMapping("/login")
//    public ResponseEntity<TokenDTO> login(@RequestBody @Valid CredentialDTO credentialDTO){
//
//        Authentication authentication = authenticationManager
//                .authenticate(new UsernamePasswordAuthenticationToken(credentialDTO.getUserName(), credentialDTO.getPassword()));
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        UserDetailsImp userDetails = (UserDetailsImp) authentication.getPrincipal();
//        String accessToken = jwtUtils.generateToken(userDetails);
//
//       TokenDTO tokenDto=tokenService.createToken(userDetails,accessToken);
//        return ResponseEntity.ok(tokenDto);
//    }
//
//    @PutMapping("/users")
//    public ResponseEntity<User> update(@RequestBody @Valid User user){
//        User d = userService.save(user);
//        return ResponseEntity.ok(d);
//    }
//
//
//
//    @GetMapping("/users/{id}")
//    public ResponseEntity<User> findById(@PathVariable Long id){
//        User user= userService.findById(id);
//        return ResponseEntity.ok(user);
//    }
//
//    @GetMapping("/users")
//    public Page<User> findAll(@RequestParam(defaultValue = "0") int page,
//                                       @RequestParam(defaultValue = "3") int size){
//        Page<User> userPage= userService.findAll(page, size);
//        return userPage;
//    }
//
//
//    @DeleteMapping("/users/{id}")
//    public void deleteById(@PathVariable Long id){
//        userService.deleteById(id);
//    }
//
//}
