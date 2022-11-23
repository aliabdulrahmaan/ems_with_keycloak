//package com.ems.EmployeeManagementService.controllers;
//
//
//import com.ems.EmployeeManagementService.entites.Token;
//import com.ems.EmployeeManagementService.service.TokenService;
//import com.ems.EmployeeManagementService.service.dtos.CredentialDTO;
//import com.ems.EmployeeManagementService.service.dtos.RefreshTokenDTO;
//import com.ems.EmployeeManagementService.service.dtos.TokenDTO;
//import com.ems.EmployeeManagementService.service.security.UserDetailsImp;
//import lombok.AllArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.validation.Valid;
//
//@RestController
//@RequestMapping("/api")
//@AllArgsConstructor
//public class TokenController {
//
//    private final TokenService tokenService;
//
//
////    @PostMapping("/token/re-create")
////    public ResponseEntity<TokenDTO> login(@RequestBody @Valid RefreshTokenDTO refreshTokenDTO){
////
////
////
////        TokenDTO tokenDTO=tokenService.recreateToken(refreshTokenDTO);
////        return ResponseEntity.ok(tokenDTO);
////    }
//
//}
