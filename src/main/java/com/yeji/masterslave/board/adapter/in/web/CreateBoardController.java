package com.yeji.masterslave.board.adapter.in.web;

import com.yeji.masterslave.board.application.in.CreateBoardUseCase;
import com.yeji.masterslave.board.common.ApiUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.yeji.masterslave.board.common.ApiUtil.success;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class CreateBoardController {

    private final CreateBoardUseCase createBoardUseCase;

    @PostMapping
    public ApiUtil.ApiResult<CreateBoardResponse> createBoard(@RequestBody CreateBoardRequest request) {
        return success(CreateBoardResponse.of(createBoardUseCase.createBoard(request.mapToCommand())));
    }

}
