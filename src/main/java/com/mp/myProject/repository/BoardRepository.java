package com.mp.myProject.repository;

import com.mp.myProject.dto.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board,Long> {

    /*검색기능*/
    Page<Board> findByTitleContainingOrContentContaining(String title, String content, Pageable pageable);

}
