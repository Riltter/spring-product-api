package com.example.springboot.domain.user;

import jakarta.validation.constraints.NotBlank;

public record AuthRecordDto(@NotBlank(message = "login is mandatory.") String login,
                            @NotBlank(message = "password is mandatory") String password) {
}
