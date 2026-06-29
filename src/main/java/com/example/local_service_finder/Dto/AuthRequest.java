package com.example.local_service_finder.Dto;

import lombok.Data;

@Data
public class AuthRequest {

    private String email;
    private String password;

}