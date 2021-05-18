package br.com.youtube.apirest.service.mapper.request;

import br.com.youtube.apirest.model.request.UserRequest;
import br.com.youtube.apirest.persistence.entity.User;
import br.com.youtube.apirest.service.Mapper;
import org.springframework.stereotype.Component;

@Component
public class UserRequestMapper implements Mapper<UserRequest, User> {

    @Override
    public User map(UserRequest input) {
        if(input == null){
            return null;
        }

        User user = new User();
        user.setName(input.getName());
        user.setEmail(input.getEmail());

        return user;
    }
}
