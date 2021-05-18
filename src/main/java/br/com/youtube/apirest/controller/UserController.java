package br.com.youtube.apirest.controller;

import br.com.youtube.apirest.model.request.UserRequest;
import br.com.youtube.apirest.model.response.UserResponse;
import br.com.youtube.apirest.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/v1")
public class UserController {

    //CRU Missing D(elete)

    @Autowired
    private UserService service;

    @PostMapping
    @ApiOperation("API responsável pela criação de usuários")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Sucesso! Cria uma usuário"),
            @ApiResponse(code = 500, message = "Ocorreu uma exceção ao criar um usuário!"),
    })
    public ResponseEntity<UserResponse> create(@RequestBody UserRequest request) {
        return ResponseEntity.ok(service.create(request));
    }

    @GetMapping
    public ResponseEntity<Page<UserResponse>> getAll(Pageable pageable) {
        Page<UserResponse> responses = service.getAll(pageable);
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> get(@PathVariable("id") Long id) {
        Optional<UserResponse> userResponse = service.get(id);
        return userResponse.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> update(@PathVariable("id") Long id, @RequestBody UserRequest request) {
        Optional<UserResponse> update = service.update(id, request);
        return update.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
