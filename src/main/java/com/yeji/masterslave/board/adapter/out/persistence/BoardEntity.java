package com.yeji.masterslave.board.adapter.out.persistence;

import com.yeji.masterslave.board.domain.Board;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.proxy.HibernateProxy;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "T_BOARD")
@Getter
@ToString
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

    @Override
    public final boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ?
            ((HibernateProxy)o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ?
            ((HibernateProxy)this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass)
            return false;
        BoardEntity entity = (BoardEntity)o;
        return getId() != null && Objects.equals(getId(), entity.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy)this).getHibernateLazyInitializer().getPersistentClass().hashCode() :
            getClass().hashCode();
    }

}
