package com.yeji.masterslave.board.domain;

import com.yeji.masterslave.board.adapter.out.persistence.BoardDTO;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record Board(Long boardId, String title, String content, boolean active, boolean isOpen, LocalDateTime startedDate,
                    LocalDateTime expiredDate) {

    public static Board convert(BoardDTO boardDTO) {
        return Board.builder()
            .boardId(boardDTO.getBoardId())
            .title(boardDTO.getTitle())
            .content(boardDTO.getContent())
            .active(boardDTO.isActive())
            .isOpen(boardDTO.isOpen())
            .startedDate(boardDTO.getStartedDate())
            .expiredDate(boardDTO.getExpiredDate())
            .build();
    }

}
