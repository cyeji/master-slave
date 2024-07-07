package com.yeji.masterslave.board.application.port.out;

import com.yeji.masterslave.board.domain.Board;

import java.util.List;

public interface RetrieveBoardOutPort {

    List<Board> retrieveBoard();

}
