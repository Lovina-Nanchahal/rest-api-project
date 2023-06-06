package com.example.demo.supplier;

import com.example.demo.dto.*;

import java.util.*;

public class InstructionDTOSupplier {

    public static InstructionDTO getInstructionDto() {
        return InstructionDTO.builder()
                .id(3L)
                .instructionName("TestInstruction")
                .build();
    }

    public static List<InstructionDTO> getInstructionDtoList() {
        return Collections.singletonList(getInstructionDto());
    }
}
