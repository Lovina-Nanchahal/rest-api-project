package com.example.demo.mapper;

import com.example.demo.dto.*;
import com.example.demo.model.*;
import org.springframework.stereotype.*;

import java.util.*;
import java.util.stream.*;

@Service
public class InstructionMapper {
    public List<InstructionDTO> mapToInstructionDTOList(List<Instruction> instructions) {
        return instructions.stream()
                .map(this::mapToInstructionDTO)
                .collect(Collectors.toList());
    }
    private InstructionDTO mapToInstructionDTO(final Instruction instruction) {
        return InstructionDTO.builder()
                .id(instruction.getId())
                .instructionName(instruction.getInstructionName())
                .build();
    }
}
