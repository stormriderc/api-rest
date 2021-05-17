package br.com.youtube.apirest.controller;

import br.com.youtube.apirest.model.request.UserRequest;
import br.com.youtube.apirest.model.response.UserResponse;
import br.com.youtube.apirest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public ResponseEntity<UserResponse> create(@RequestBody UserRequest request){
        return ResponseEntity.ok(service.create(request));
    }
}
