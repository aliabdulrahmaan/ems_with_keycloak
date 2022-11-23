//package com.ems.EmployeeManagementService.entites;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.NotNull;
//import java.time.Instant;
//
//
//@Entity
//@Table(name="token")
//@AllArgsConstructor
//@NoArgsConstructor
//@Data
//public class Token {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    @Column(name = "id")
//    private long id;
//
//    @Column(unique = true, nullable = false)
//    @NotNull
//    @NotEmpty
//    private String accessToken;
//
//    @Column(nullable = false)
//    private Instant accessTokenExpiryDate;
//
//    @Column(nullable = false)
//    private Instant refreshTokenExpiryDate;
//
//    @Column(unique = true, nullable = false)
//    @NotNull
//    @NotEmpty
//    private String refreshToken;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id", nullable = false)
//    @NotNull
//    private User user;
//
//    public Token(String accessToken, String refreshToken, User user,long tokenDurationMs,long refreshTokenDurationMs) {
//        this.accessToken = accessToken;
//        this.refreshToken = refreshToken;
//        this.user = user;
//        this.accessTokenExpiryDate=Instant.now().plusMillis(tokenDurationMs);
//        this.refreshTokenExpiryDate=Instant.now().plusMillis(refreshTokenDurationMs);
//    }
//
//
//
//    public boolean isAccessTokenExpired(){
//        return accessTokenExpiryDate.isBefore(Instant.now());
//    }
//
//    public boolean isRefreshTokenExpired(){
//        return refreshTokenExpiryDate.isBefore(Instant.now());
//    }
//
//
//}
