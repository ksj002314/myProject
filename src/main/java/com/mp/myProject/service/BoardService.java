package com.mp.myProject.service;

import com.mp.myProject.dto.Board;
import com.mp.myProject.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class BoardService {

    /* 주입 */
    @Autowired
    private BoardRepository boardRepository;

    /* 글 쓰기*/
    public void boardWrite(Board board) {

        boardRepository.save(board);
    }

    /* 게시글 보기 */
    public Board boardView(Long id) {

        return boardRepository.findById(id).get();
    }

    /* 삭제하기 */
   public void boardDelete(Long id) {

       boardRepository.deleteById(id);

   }
}