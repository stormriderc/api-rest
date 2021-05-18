package br.com.youtube.apirest.service.impl;

import br.com.youtube.apirest.model.request.UserRequest;
import br.com.youtube.apirest.model.response.UserResponse;
import br.com.youtube.apirest.persistence.entity.User;
import br.com.youtube.apirest.persistence.repository.UserRepository;
import br.com.youtube.apirest.service.Mapper;
import br.com.youtube.apirest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

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


    /**
     * Esse método é semelhante ao retorno de uma tabela de dados
     */
    @Override
    public Page<UserResponse> getAll(Pageable pageable) {
        return repository.findAll(pageable).map(user -> this.responseMapper.map(user));
    }

    @Override
    public Optional<UserResponse> get(Long id) {
        return repository.findById(id).map(this.responseMapper::map);
    }

    @Override
    public Optional<UserResponse> update(Long id, UserRequest request) {

        //Já temos um registro (isso justifica receber o id)
        //Nós receberemos dados novos (isso justifica receber o userRequest)

        User updateData = this.requestMapper.map(request);

        return repository.findById(id)
                .map(user -> {
                    user.setEmail(updateData.getEmail());

                    return this.responseMapper.map(repository.saveAndFlush(user));
                });
    }
}
