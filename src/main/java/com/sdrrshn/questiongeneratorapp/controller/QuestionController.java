package com.sdrrshn.questiongeneratorapp.controller;

import com.sdrrshn.questiongeneratorapp.data.dto.QuestionAdd;
import com.sdrrshn.questiongeneratorapp.service.abstracts.IQuestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${project.server.port}/question")
public class QuestionController {
    private final IQuestionService questionService;


    public QuestionController(IQuestionService questionService) {
        this.questionService = questionService;
    }
    @PostMapping
    public ResponseEntity<?> add(@RequestBody QuestionAdd questionAdd){
        return ResponseEntity.ok(questionService.add(questionAdd));
    }
    @GetMapping()
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(questionService.getAll());
    }
}
