package com.yeji.masterslave.board.application.port.out;

import com.yeji.masterslave.board.domain.Board;

public interface CreateBoardOutPort {

    Board createBoard(Board board);

}
