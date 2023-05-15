package com.sdrrshn.questiongeneratorapp.data.dto;

import com.sdrrshn.questiongeneratorapp.data.enums.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TokenPayload {
    private Long id;
    private String username;
    private UserStatus userStatus;
}
