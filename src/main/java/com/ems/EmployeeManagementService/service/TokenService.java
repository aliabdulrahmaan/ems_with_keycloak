//package com.ems.EmployeeManagementService.service;
//
//
////import com.ems.EmployeeManagementService.config.security.JWTUtil;
//import com.ems.EmployeeManagementService.entites.Token;
//import com.ems.EmployeeManagementService.entites.User;
//import com.ems.EmployeeManagementService.exception.BadRequestAlertException;
//import com.ems.EmployeeManagementService.mapper.TokenMapper;
//import com.ems.EmployeeManagementService.repositories.jpa.TokenRepository;
//import com.ems.EmployeeManagementService.repositories.jpa.UserRepository;
//import com.ems.EmployeeManagementService.service.dtos.RefreshTokenDTO;
//import com.ems.EmployeeManagementService.service.dtos.TokenDTO;
//import com.ems.EmployeeManagementService.service.security.UserDetailsImp;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.UUID;
//
//@Service
//@Transactional
//
//public class TokenService {
//    @Value("${jwtExpirationMs}")
//    private long tokenDurationMs;
//    @Value("${refreshTokenDurationMs}")
//    private long refreshTokenDurationMs;
//
//    private final TokenRepository tokenRepository;
//    private final TokenMapper tokenMapper;
//    private final UserRepository userRepository;
////    private final   JWTUtil jwtUtil;
//    private static final  String ENTITY_NAME= "Employee";
//    public TokenService(TokenRepository tokenRepository, TokenMapper tokenMapper, UserRepository userRepository) {
//        this.tokenRepository = tokenRepository;
//        this.tokenMapper = tokenMapper;
//        this.userRepository = userRepository;
////        this.jwtUtil = jwtUtil;
//    }
//
//
//    public Token save(Token t){
//        return tokenRepository.save(t);
//    }
//
//    public TokenDTO createToken(UserDetailsImp userDetails,String accessToken){
//
//        User user= userRepository.findByUserNameAndActiveTrue(userDetails.getUsername()).get();
//        String refreshToken= UUID.randomUUID().toString();
//        Token token= new Token(accessToken,refreshToken,user,tokenDurationMs,refreshTokenDurationMs);
//        Token result=save(token);
//        TokenDTO tokenDTO= tokenMapper.toDTO(result);
//        return tokenDTO;
//
//    }
//
////    public TokenDTO recreateToken(RefreshTokenDTO refreshToken){
////
////        Token token= tokenRepository.findByRefreshToken(refreshToken.getRefreshToken()).orElseThrow(
////                ()->new BadRequestAlertException("Invalid Refresh token",ENTITY_NAME,"invalidToken")
////        );
////        if(token.isRefreshTokenExpired())
////           throw  new BadRequestAlertException("Refresh token has been expired, please login....",ENTITY_NAME,"refreshTokenExpired");
////
////
////            String newRefreshToken= UUID.randomUUID().toString();
////            String accessToken = jwtUtil.generateToken(token.getUser());
////            Token  newToken= new Token(accessToken,newRefreshToken,token.getUser(),tokenDurationMs,refreshTokenDurationMs);
////
////            tokenRepository.delete(token);
////        Token result=save(newToken);
////        TokenDTO tokenDTO= tokenMapper.toDTO(result);
////        return tokenDTO;
////
////    }
//
//
//}
