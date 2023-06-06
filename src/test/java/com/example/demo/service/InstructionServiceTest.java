package com.example.demo.service;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.supplier.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.*;
import org.mockito.*;
import org.mockito.junit.jupiter.*;

import java.util.*;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class InstructionServiceTest {
    @InjectMocks
    private InstructionService instructionService;

    @Mock
    private InstructionRepository instructionRepository;

    @Test
    public void testSaveInstructions() {
        final Instruction instruction = InstructionSupplier.getInstruction();

        when(instructionRepository.save(instruction)).thenReturn(instruction);

        instructionService.saveInstructions(Collections.singletonList(instruction), new Recipe());
    }

    @Test
    public void testDeleteInstructions() {
        final Instruction instruction = InstructionSupplier.getInstruction();

        doNothing().when(instructionRepository).deleteAll(Collections.singletonList(instruction));

        instructionService.deleteInstructions(Collections.singletonList(instruction));
    }
}
