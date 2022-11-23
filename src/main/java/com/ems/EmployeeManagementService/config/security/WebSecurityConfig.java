//package com.ems.EmployeeManagementService.config.security;
//
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class WebSecurityConfig {
//
//    private final UserDetailsService userDetailsService;
//    private  AuthenticationManager authenticationManager;
//
//
//    private final AuthEntryPointJwt unauthorizedHandler;
////    private final JWTFilter filter;
//    private static final String[] SWAGGER_WHITELIST = {
//            "/v3/api-docs/**",
//            "/swagger-ui/**",
//            "/swagger-ui.html",
//            "/api/auth/**",
//        "/api/token/re-create",
//        "/api/employees",
//        "/api/employees/search-by-elastic/**"
//    };
//
//    public WebSecurityConfig(UserDetailsService userDetailsService, AuthEntryPointJwt unauthorizedHandler) {
//        this.userDetailsService = userDetailsService;
//        this.unauthorizedHandler = unauthorizedHandler;
//    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//
////        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
////        authenticationManagerBuilder.userDetailsService(userDetailsService);
////        authenticationManager = authenticationManagerBuilder.build();
//
//        http.cors().and().csrf().disable()
//                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
//                .authorizeRequests().antMatchers("/api**").permitAll()
//                .antMatchers(SWAGGER_WHITELIST).permitAll()
//                .anyRequest().authenticated();
//
//
////
////        http
////                .authorizeHttpRequests((requests) -> {
////                    try {
////                        requests
////                                .antMatchers(SWAGGER_WHITELIST).permitAll()
////                        . antMatchers("/api**").permitAll().anyRequest()
////                                .authenticated().and()
////                                .authenticationManager(authenticationManager)
////                                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
////                                .httpBasic().disable().cors().disable().csrf().disable().exceptionHandling().authenticationEntryPoint(unauthorizedHandler);
////                    } catch (Exception e) {
////                        throw new RuntimeException(e);
////                    }
////                });
//        http.authenticationProvider(authenticationProvider());
//        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
//        return http.build();
//    }
//
////    @Bean
////    public UserDetailsService userDetailsService() {
////        UserDetails user =
////                User.withDefaultPasswordEncoder()
////                        .username("user")
////                        .password("password")
////                        .roles("USER")
////                        .build();
////        UserDetails admin =
////                User.withDefaultPasswordEncoder()
////                        .username("ali")
////                        .password("assad")
////                        .roles("USER")
////                        .build();
////
////
////        return new InMemoryUserDetailsManager(user,admin);
////    }
//
//
//    @Bean
//    public PasswordEncoder getPasswordEncoder(){
//        return NoOpPasswordEncoder.getInstance();
//    }
//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
//        return authConfig.getAuthenticationManager();
//
//}
//
//    @Bean
//    public DaoAuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//
//        authProvider.setUserDetailsService(userDetailsService);
//        authProvider.setPasswordEncoder(getPasswordEncoder());
//
//        return authProvider;
//    }
//
//
//    @Bean
//    public JWTFilter authenticationJwtTokenFilter() {
//        return new JWTFilter();
//    }
//
//}
//
//
//
//
//
