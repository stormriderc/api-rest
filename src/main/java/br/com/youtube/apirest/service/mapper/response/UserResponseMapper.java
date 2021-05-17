package br.com.youtube.apirest.service.mapper.response;

import br.com.youtube.apirest.model.response.UserResponse;
import br.com.youtube.apirest.persistence.entity.User;
import br.com.youtube.apirest.service.Mapper;


public class UserResponseMapper implements Mapper<User, UserResponse> {

    @Override
    public UserResponse map(User input) {
        if(input == null){
            return null;
        }

        UserResponse response = new UserResponse();
        response.setId(input.getId());
        response.setName(input.getName());
        response.setEmail(input.getEmail());

        return response;
    }
}
