package com.yeji.masterslave.board.application.in;

import com.yeji.masterslave.board.domain.Board;

import java.util.List;

public interface RetrieveBoardUseCase {

    List<Board> retrieveBoard();

}
