package com.hospitalreview.hospitalreviewjpaprac.service;


import com.hospitalreview.hospitalreviewjpaprac.domain.User;
import com.hospitalreview.hospitalreviewjpaprac.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository ur;

    public String join(String userName, String password) {

        //userName 중복 확인하기, 중복이면 -> exception
        ur.findByUserName(userName)
                .ifPresent(user -> {
                    throw new RuntimeException("존재하는 아이디입니다.");
                });

        //위에서 중복에 안걸리면 id/password 저장
        User user = User.builder()
                .userName(userName)
                .password(password)
                .build();
        ur.save(user);

        return "SUCCESS";
    }
}
