package br.com.youtube.apirest.service;

import br.com.youtube.apirest.model.request.UserRequest;
import br.com.youtube.apirest.model.response.UserResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface UserService {

    UserResponse create(UserRequest request);

    Page<UserResponse> getAll(Pageable pageable);

    Optional<UserResponse> get(Long id);

    Optional<UserResponse> update(Long id, UserRequest request);
}
