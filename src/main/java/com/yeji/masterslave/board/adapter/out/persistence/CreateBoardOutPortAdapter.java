package com.yeji.masterslave.board.adapter.out.persistence;

import com.yeji.masterslave.board.application.port.out.CreateBoardOutPort;
import com.yeji.masterslave.board.common.PersistenceAdapter;
import com.yeji.masterslave.board.domain.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@PersistenceAdapter
@RequiredArgsConstructor
public class CreateBoardOutPortAdapter implements CreateBoardOutPort {

    private final BoardRepository boardRepository;

    @Override
    @Transactional
    public Board createBoard(Board board) {
        BoardEntity entity = BoardEntity.mapToEntity(board);
        boardRepository.save(entity);
        return entity.mapToDomain();
    }

}
