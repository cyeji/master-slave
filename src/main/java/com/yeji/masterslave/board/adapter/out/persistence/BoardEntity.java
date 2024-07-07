package com.yeji.masterslave.board.adapter.out.persistence;

import com.yeji.masterslave.board.domain.Board;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "board")
@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    private boolean isOpen;

    private boolean active;

    private LocalDateTime startedDate;

    private LocalDateTime expiredDate;

    public static BoardEntity mapToEntity(Board board) {
        BoardEntity entity = new BoardEntity();
        entity.title = board.title();
        entity.content = board.content();
        entity.active = board.active();
        entity.isOpen = board.isOpen();
        entity.startedDate = board.startedDate();
        entity.expiredDate = board.expiredDate();
        return entity;
    }

    public Board mapToDomain() {
        return Board.builder()
            .boardId(this.id)
            .title(this.title)
            .content(this.content)
            .isOpen(this.isOpen)
            .active(this.active)
            .startedDate(this.startedDate)
            .expiredDate(this.expiredDate)
            .build();
    }

}
