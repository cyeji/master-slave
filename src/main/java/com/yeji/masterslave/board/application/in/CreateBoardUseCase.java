package com.yeji.masterslave.board.application.in;

import com.yeji.masterslave.board.domain.Board;

public interface CreateBoardUseCase {

    Board createBoard(CreateBoardCommand createBoardCommand);

}
