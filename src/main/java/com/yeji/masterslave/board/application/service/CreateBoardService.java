package com.yeji.masterslave.board.application.service;

import com.yeji.masterslave.board.application.in.CreateBoardCommand;
import com.yeji.masterslave.board.application.in.CreateBoardUseCase;
import com.yeji.masterslave.board.application.port.out.CreateBoardOutPort;
import com.yeji.masterslave.board.domain.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateBoardService implements CreateBoardUseCase {

    private final CreateBoardOutPort createBoardOutPort;

    @Override
    public Board createBoard(CreateBoardCommand createBoardCommand) {
        return createBoardOutPort.createBoard(createBoardCommand.mapToDomain());
    }

}
