package com.example.demo.dto;

import lombok.*;

@Data
@Builder
public class InstructionDTO {
    @NonNull
    private Long id;

    @NonNull
    private String instructionName;
}
