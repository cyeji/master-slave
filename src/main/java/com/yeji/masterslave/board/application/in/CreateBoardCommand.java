package com.yeji.masterslave.board.application.in;

import com.yeji.masterslave.board.domain.Board;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreateBoardCommand {

    private Long boardId;

    private String title;

    private String content;

    private boolean active;

    private boolean isOpen;

    private LocalDateTime startedDate;

    private LocalDateTime expiredDate;

    public Board mapToDomain() {

        return Board.builder()
            .boardId(this.boardId)
            .title(this.title)
            .content(this.content)
            .active(this.active)
            .isOpen(this.isOpen)
            .startedDate(this.startedDate)
            .expiredDate(this.expiredDate)
            .build();
    }

}
