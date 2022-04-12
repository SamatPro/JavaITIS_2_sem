package ru.kpfu.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.dtos.RegistrationDto;
import ru.kpfu.itis.dtos.UserDto;
import ru.kpfu.itis.enums.Gender;
import ru.kpfu.itis.enums.Role;
import ru.kpfu.itis.exceptions.UserAlreadyExistException;
import ru.kpfu.itis.models.User;
import ru.kpfu.itis.repositories.UserRepository;

import java.util.List;

@Service("userService")
public class UsersServicesImpl implements UserService {

    @Autowired
    private UserRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public void addUser(UserDto userDto) {
        User user = User.builder()
                        .lastName(userDto.getLastName())
                                .firstName(userDto.getFirstName())
                                        .build();
        usersRepository.save(user);
    }

    @Override
    public void signUp(RegistrationDto userDto) {
        if (!usersRepository.existsByEmail(userDto.getEmail())) {
            User user = User.builder()
                    .lastName(userDto.getLastName())
                    .firstName(userDto.getFirstName())
                    .gender(Gender.valueOf(userDto.getGender()))
                    .email(userDto.getEmail())
                    .passwordHash(passwordEncoder.encode(userDto.getPassword()))
                    .role(Role.ROLE_USER)
                    .build();
            usersRepository.save(user);
        } else {
            throw new UserAlreadyExistException(String.format("Пользователь с email=%s уже существует", userDto.getEmail()));
        }
    }

    @Override
    public List<User> getUsers() {
        return (List<User>) usersRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return usersRepository.findById(id).get();
    }

    @Override
    public int getUserCountByLastName(String lastName) {
        return usersRepository.countUserByLastName(lastName);
    }

    @Override
    public boolean emailDoesntExist(String email) {
        return usersRepository.existsByEmail(email);
    }
}
