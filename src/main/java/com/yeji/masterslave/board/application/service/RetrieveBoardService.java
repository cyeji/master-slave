package com.yeji.masterslave.board.application.service;

import com.yeji.masterslave.board.application.in.RetrieveBoardUseCase;
import com.yeji.masterslave.board.application.port.out.RetrieveBoardOutPort;
import com.yeji.masterslave.board.domain.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RetrieveBoardService implements RetrieveBoardUseCase {

    private final RetrieveBoardOutPort retrieveBoardOutPort;

    @Override
    public List<Board> retrieveBoard() {
        return retrieveBoardOutPort.retrieveBoard();
    }

}
