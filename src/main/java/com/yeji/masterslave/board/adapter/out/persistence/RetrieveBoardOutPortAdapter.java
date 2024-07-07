package com.yeji.masterslave.board.adapter.out.persistence;

import com.yeji.masterslave.board.application.port.out.RetrieveBoardOutPort;
import com.yeji.masterslave.board.common.PersistenceAdapter;
import com.yeji.masterslave.board.domain.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@PersistenceAdapter
@RequiredArgsConstructor
public class RetrieveBoardOutPortAdapter implements RetrieveBoardOutPort {

    private final BoardRepository boardRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Board> retrieveBoard() {
        List<BoardEntity> boardList = boardRepository.findAll();
        return boardList.stream().map(BoardEntity::mapToDomain).toList();
    }

}
