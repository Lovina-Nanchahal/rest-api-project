package com.example.demo.repository;

import com.example.demo.model.*;
import org.springframework.data.jpa.repository.*;

//@Repository
public interface InstructionRepository extends JpaRepository<Instruction, Long> {
}
