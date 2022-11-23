//package com.ems.EmployeeManagementService.config.security;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.http.MediaType;
//import org.springframework.security.access.AccessDeniedException;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.AuthenticationEntryPoint;
//import org.springframework.security.web.access.AccessDeniedHandler;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//
//@Component
//public class AuthEntryPointJwt implements AuthenticationEntryPoint, AccessDeniedHandler {
//
//  private static final Logger logger = LoggerFactory.getLogger(AuthEntryPointJwt.class);
//
//  @Override
//  public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
//      throws IOException, ServletException {
//    logger.error("Unauthorized error: {}", authException.getMessage());
//    final String expired = (String) request.getAttribute("expired");
//    response.setContentType(MediaType.APPLICATION_JSON_VALUE);
//    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//
//    final Map<String, Object> body = new HashMap<>();
//
//    if(expired!=null &&!expired.isEmpty()){
//      body.put("status", HttpServletResponse.SC_UNAUTHORIZED);
//      body.put("error", expired);
//      body.put("path", request.getServletPath());
//    }else {
//      body.put("status", HttpServletResponse.SC_UNAUTHORIZED);
//      body.put("error", "Unauthorized");
//      body.put("message", authException.getMessage());
//      body.put("path", request.getServletPath());
//    }
//    final ObjectMapper mapper = new ObjectMapper();
//    mapper.writeValue(response.getOutputStream(), body);
//
//
//  }
//
//  @Override
//  public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
//
//  }
//}
