package com.example.demo.supplier;

import com.example.demo.model.*;

public class InstructionSupplier {

    public static Instruction getInstruction() {
        final Instruction instruction = new Instruction();
        instruction.setId(3L);
        instruction.setInstructionName("TestInstruction");

        instruction.setRecipe(new Recipe());
        return instruction;
    }
}
