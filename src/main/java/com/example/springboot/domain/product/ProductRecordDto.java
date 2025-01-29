package com.example.springboot.domain.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProductRecordDto(@NotBlank(message = "Product name is mandatory.") String name,
                               @NotNull(message = "Product value is mandatory.")
                               BigDecimal value) {}
