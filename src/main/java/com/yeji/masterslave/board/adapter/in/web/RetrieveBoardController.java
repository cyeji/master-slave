package com.yeji.masterslave.board.adapter.in.web;

import com.yeji.masterslave.board.application.in.RetrieveBoardUseCase;
import com.yeji.masterslave.board.common.ApiUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.yeji.masterslave.board.common.ApiUtil.success;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class RetrieveBoardController {

    private final RetrieveBoardUseCase retrieveBoardUseCase;

    @GetMapping
    public ApiUtil.ApiResult<RetrieveBoardResponse> retrieveBoard() {
        return success(RetrieveBoardResponse.of(retrieveBoardUseCase.retrieveBoard()));
    }

}
