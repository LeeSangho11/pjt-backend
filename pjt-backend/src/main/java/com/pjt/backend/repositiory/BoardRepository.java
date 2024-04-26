package com.pjt.backend.repositiory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pjt.backend.entity.Board;


public interface BoardRepository extends JpaRepository<Board, Long>{


}
