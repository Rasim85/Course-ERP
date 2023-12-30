package com.webperside.courseerpbackend.services.user;

import com.webperside.courseerpbackend.exception.BaseException;
import com.webperside.courseerpbackend.models.enums.response.ErrorResponseMessages;
import com.webperside.courseerpbackend.models.enums.response.ResponseMessage;
import com.webperside.courseerpbackend.models.mybatis.user.User;
import com.webperside.courseerpbackend.models.security.LoggedInUserDetails;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getByEmail(username);
        if (!user.isActive()) {
            throw new UsernameNotFoundException(
                    ErrorResponseMessages.USER_NOT_ACTIVE.message(),
                    BaseException.of(ErrorResponseMessages.USER_NOT_ACTIVE)
            );
        }
        return new LoggedInUserDetails(user.getEmail(), user.getPassword(), new ArrayList<>());
    }
}
