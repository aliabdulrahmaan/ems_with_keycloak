//package com.ems.EmployeeManagementService.config.security;
//
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.JWTVerifier;
//import com.auth0.jwt.algorithms.Algorithm;
//import com.auth0.jwt.exceptions.JWTCreationException;
//import com.auth0.jwt.exceptions.JWTVerificationException;
//import com.auth0.jwt.interfaces.DecodedJWT;
//import com.ems.EmployeeManagementService.entites.Token;
//import com.ems.EmployeeManagementService.exception.BadRequestAlertException;
//import com.ems.EmployeeManagementService.repositories.jpa.TokenRepository;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.Date;
//import java.util.Optional;
//
//@Component
//@Slf4j
//public class JWTUtil {
//
//    @Value("${jwt_secret}")
//    private String secret;
//    @Value("${jwtExpirationMs}")
//    private Long tokenDurationMs;
//
//    private final TokenRepository tokenRepository;
//
//    public JWTUtil(TokenRepository tokenRepository) {
//        this.tokenRepository = tokenRepository;
//    }
//
//
//    public String generateToken(UserDetails userDetails) throws IllegalArgumentException, JWTCreationException {
//        return JWT.create()
//                .withSubject("User Details")
//                .withClaim("userName", userDetails.getUsername())
//                .withClaim("roles", userDetails.getAuthorities().toString())
//                .withIssuedAt(new Date())
////                .withExpiresAt(Date.from(Instant.now().plusMillis(tokenDurationMs)))
//                .withIssuer("EMS/TABADUL")
//                .sign(Algorithm.HMAC256(secret));
//    }
//
//
//    public String validateTokenAndRetrieveSubject(String token,HttpServletRequest httpServletRequest)throws JWTVerificationException,BadRequestAlertException{
//        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secret))
//                .withSubject("User Details")
//                .withIssuer("EMS/TABADUL")
//                .build();
//        DecodedJWT jwt = verifier.verify(token);
////        if( jwt.getExpiresAt().before(new Date())) {
////           throw new BadRequestAlertException("Token has been expired","Token","tokenExpired");
////        }
//
//        Optional<Token> accessToken = tokenRepository.findByAccessToken(token);
//        if(accessToken.isPresent()&&accessToken.get().isAccessTokenExpired()){
//            httpServletRequest.setAttribute("expired","Token has been expired");
//            throw new BadRequestAlertException("Token has been expired","Token","tokenExpired");
//        }
//        return jwt.getClaim("userName").asString();
//    }
//
////    public boolean validateJwtToken(String authToken) {
////        try {
////            Jwts.parser().setSigningKey(secret).parseClaimsJws(authToken);
////            return true;
////
////        } catch (MalformedJwtException e) {
////            log.error("Invalid JWT token: {}", e.getMessage());
////        } catch (ExpiredJwtException e) {
////            log.error("JWT token is expired: {}", e.getMessage());
////        } catch (UnsupportedJwtException e) {
////            log.error("JWT token is unsupported: {}", e.getMessage());
////        } catch (IllegalArgumentException e) {
////            log.error("JWT claims string is empty: {}", e.getMessage());
////        }
////
////        return false;
////    }
////    public String getUserNameFromJwtToken(String token) {
////        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
////    }
////
////    public String generateTokenFromUsername(String username) {
////        return Jwts.builder().setSubject(username).setIssuedAt(new Date())
////                .setExpiration(new Date((new Date()).getTime() + tokenDurationMs)).signWith(SignatureAlgorithm.HS512, secret)
////                .compact();
////    }
////    private String parseJwt(HttpServletRequest request) {
////        String headerAuth = request.getHeader("Authorization");
////
////        if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")) {
////            return headerAuth.substring(7, headerAuth.length());
////        }
////
////        return null;
////    }
//}