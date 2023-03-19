package ru.preproject.task_3_1_6.service;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import ru.preproject.task_3_1_6.dto.UserDto;

import java.util.List;

public interface RestService {
    ResponseEntity<List<UserDto>> findAll(String url);
    ResponseEntity<String> requestUser(String url, HttpMethod httpMethod, HttpHeaders httpHeaders, UserDto userDto);
}
