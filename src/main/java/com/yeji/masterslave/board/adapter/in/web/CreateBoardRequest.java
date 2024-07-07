package com.yeji.masterslave.board.adapter.in.web;

import com.yeji.masterslave.board.application.in.CreateBoardCommand;
import lombok.Data;

import java.time.LocalDateTime;

import static org.springframework.beans.BeanUtils.copyProperties;

@Data
public class CreateBoardRequest {

    private String title;

    private String content;

    private boolean active;

    private boolean isOpen;

    private LocalDateTime startedDate;

    private LocalDateTime expiredDate;

    public CreateBoardCommand mapToCommand() {
        CreateBoardCommand command = new CreateBoardCommand();
        copyProperties(this, command);
        return command;
    }

}
