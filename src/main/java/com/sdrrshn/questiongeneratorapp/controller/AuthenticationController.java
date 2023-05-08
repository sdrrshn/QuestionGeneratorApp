package com.sdrrshn.questiongeneratorapp.controller;

import com.sdrrshn.questiongeneratorapp.data.dto.AuthenticationDto;
import com.sdrrshn.questiongeneratorapp.data.dto.ResetPasswordDto;
import com.sdrrshn.questiongeneratorapp.service.abstracts.IAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("${project.server.port}/authentication")
public class AuthenticationController {
    private final IAuthenticationService authenticationService;

    @Autowired
    public AuthenticationController(IAuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthenticationDto authenticationDto) throws Exception {
        return ResponseEntity.ok(this.authenticationService.login(authenticationDto));
    }

    @PostMapping("/forgetPassword")
    public ResponseEntity<?> forgetPassword(@RequestBody String email)  {
        return ResponseEntity.ok(this.authenticationService.forgetPassword(email));
    }

    @PostMapping("/resetPassword")
    public ResponseEntity<?> resetPassword(@RequestBody ResetPasswordDto resetPasswordDto) {
        return ResponseEntity.ok(this.authenticationService.resetPassword(resetPasswordDto));
    }
    @GetMapping("/user/approved/{authCode}")
    public ResponseEntity<?> userConfirm(@PathVariable(name = "authCode") String authCode) {
        return ResponseEntity.ok(authenticationService.userConfirmApprove(authCode));
    }
}
