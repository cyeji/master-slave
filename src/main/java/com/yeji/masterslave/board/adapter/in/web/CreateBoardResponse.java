package com.yeji.masterslave.board.adapter.in.web;

import com.yeji.masterslave.board.domain.Board;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreateBoardResponse {

    private Long boardId;

    private String title;

    private String content;

    private boolean active;

    private boolean isOpen;

    private LocalDateTime startedDate;

    private LocalDateTime expiredDate;

    public static CreateBoardResponse of(Board board) {
        CreateBoardResponse createResponse = new CreateBoardResponse();
        createResponse.boardId = board.boardId();
        createResponse.title = board.title();
        createResponse.content = board.content();
        return createResponse;
    }

}
