package com.yeji.masterslave.board.adapter.in.web;

import com.yeji.masterslave.board.domain.Board;
import lombok.Data;

import java.util.List;

@Data
public class RetrieveBoardResponse {

    private List<Board> boardList;

    public static RetrieveBoardResponse of(List<Board> board) {
        RetrieveBoardResponse response = new RetrieveBoardResponse();
        response.boardList = board;
        return response;
    }

}
