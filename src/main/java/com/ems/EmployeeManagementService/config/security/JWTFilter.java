//package com.ems.EmployeeManagementService.config.security;
//
//import com.auth0.jwt.exceptions.JWTVerificationException;
//import com.ems.EmployeeManagementService.exception.BadRequestAlertException;
//import lombok.AllArgsConstructor;
//import lombok.NoArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.stereotype.Component;
//import org.springframework.util.StringUtils;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@Component
//@AllArgsConstructor
//@NoArgsConstructor
//public class JWTFilter extends OncePerRequestFilter {
//
//
//    @Autowired
//    private  UserDetailsService userDetailsService;
//
//    @Autowired
//    private  JWTUtil jwtUtil;
//
////    @Override
////    protected void doFilterInternal(HttpServletRequest request,
////                                    HttpServletResponse response,
////                                    FilterChain filterChain) throws ServletException, IOException {
////        String authHeader = request.getHeader("Authorization");
////        if(authHeader != null && !authHeader.isEmpty() && authHeader.startsWith("Bearer ")){
////            String jwt = authHeader.substring(7);
////            if(jwt == null || jwt.isEmpty()){
////                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid JWT Token in Bearer Header");
////            }else {
////                try{
////                    String userName = jwtUtil.validateTokenAndRetrieveSubject(jwt);
////                    UserDetails userDetails = userDetailsService.loadUserByUsername(userName);
////                    UsernamePasswordAuthenticationToken authToken =
////                            new UsernamePasswordAuthenticationToken(userName, userDetails.getPassword(), userDetails.getAuthorities());
////                    if(SecurityContextHolder.getContext().getAuthentication() == null){
////                        SecurityContextHolder.getContext().setAuthentication(authToken);
////                    }
////                }catch(JWTVerificationException exc){
////                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid JWT Token");
////                }
////            }
////        }
////
////        filterChain.doFilter(request, response);
////    }
//
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//            throws ServletException, IOException, BadRequestAlertException {
//        try {
//            String jwt = parseJwt(request);
//            if (jwt != null && !jwtUtil.validateTokenAndRetrieveSubject(jwt,request).isEmpty()) {
//                String username = jwtUtil.validateTokenAndRetrieveSubject(jwt,request);
//
//                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
//                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null,
//                        userDetails.getAuthorities());
//                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//
//                SecurityContextHolder.getContext().setAuthentication(authentication);
//            }
//
//
//        }catch (BadRequestAlertException e){
//            logger.error("Cannot set user authentication: {}  "+e.getMessage(),e.getCause());
//        }
//        catch (Exception e) {
//            logger.error("Cannot set user authentication: {}  "+e.getMessage(),e.getCause());
//        }
//
//        filterChain.doFilter(request, response);
//    }
//
//
//
//    private String parseJwt(HttpServletRequest request) {
//        String headerAuth = request.getHeader("Authorization");
//
//        if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")) {
//            return headerAuth.substring(7, headerAuth.length());
//        }
//
//        return null;
//    }
//}
