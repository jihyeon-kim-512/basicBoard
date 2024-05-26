package com.macaronimusic.basicBoard.board.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.macaronimusic.basicBoard.board.model.BoardEntity;
import com.macaronimusic.basicBoard.board.repository.BoardRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {
	
	private final BoardRepository boardRepository;

    public void save(BoardEntity board) {
        boardRepository.save(board);
    }

    public List<BoardEntity> findAll() {
        return boardRepository.findAll();
    }
}
