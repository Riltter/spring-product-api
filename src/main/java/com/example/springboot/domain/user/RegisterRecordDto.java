package com.example.springboot.domain.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegisterRecordDto(@NotBlank(message = "login is mandatory.") String login,
                                @NotBlank(message = "password is mandatory") String password,
                                @NotNull(message = "role is mandatory") UserRole role){
}
