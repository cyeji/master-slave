package com.yeji.masterslave.board.adapter.out.persistence;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class BoardDTO {

    private Long boardId;

    private String title;

    private String content;

    private boolean active;

    private boolean isOpen;

    private LocalDateTime startedDate;

    private LocalDateTime expiredDate;

}
