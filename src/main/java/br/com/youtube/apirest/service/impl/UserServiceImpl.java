package br.com.youtube.apirest.service.impl;

import br.com.youtube.apirest.model.request.UserRequest;
import br.com.youtube.apirest.model.response.UserResponse;
import br.com.youtube.apirest.persistence.entity.User;
import br.com.youtube.apirest.persistence.repository.UserRepository;
import br.com.youtube.apirest.service.Mapper;
import br.com.youtube.apirest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private Mapper<UserRequest, User> requestMapper;

    @Autowired
    private Mapper<User, UserResponse> responseMapper;

    @Override
    public UserResponse create(UserRequest request) {
        User user = requestMapper.map(request);
        return repository.saveAndFlush(user).map((User input) -> responseMapper.map(input));
    }
}
