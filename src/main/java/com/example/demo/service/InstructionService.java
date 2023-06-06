package com.example.demo.service;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import lombok.*;
import lombok.extern.slf4j.*;
import org.springframework.stereotype.*;

import java.util.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class InstructionService {
    private final InstructionRepository instructionRepository;

    public void saveInstructions(final List<Instruction> instructions, final Recipe savedRecipe) {
        if(instructions == null || instructions.isEmpty()) {
            return;
        }
        for(Instruction instruction : instructions) {
            instruction.setRecipe(savedRecipe);

            instructionRepository.save(instruction);
        }
    }

    public void deleteInstructions(final List<Instruction> instructions) {
        if(instructions == null || instructions.isEmpty()) {
            return;
        }
        instructionRepository.deleteAll(instructions);
    }
}
