package com.hospitalreview.hospitalreviewjpaprac.controller;


import com.hospitalreview.hospitalreviewjpaprac.dto.UserJoinRequest;
import com.hospitalreview.hospitalreviewjpaprac.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService us;

    @PostMapping("/join")
    public ResponseEntity join(@RequestBody UserJoinRequest requestDto) {
        us.join(requestDto.getUsername(), requestDto.getPassword());
        return ResponseEntity.ok().body("회원가입에 성공했습니다");
    }


}
