package br.com.youtube.apirest.service;

import br.com.youtube.apirest.model.request.UserRequest;
import br.com.youtube.apirest.model.response.UserResponse;

public interface UserService {

    UserResponse create(UserRequest request);
}
