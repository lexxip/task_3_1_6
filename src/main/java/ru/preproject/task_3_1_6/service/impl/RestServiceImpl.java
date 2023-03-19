package ru.preproject.task_3_1_6.service.impl;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.preproject.task_3_1_6.dto.UserDto;
import ru.preproject.task_3_1_6.service.RestService;

import java.util.List;

@Service
public class RestServiceImpl implements RestService {
    private final RestTemplate restTemplate;

    public RestServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public ResponseEntity<List<UserDto>> findAll(String url) {
        return restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<UserDto>>() {}
        );
    }

    @Override
    public ResponseEntity<String> requestUser(String url, HttpMethod httpMethod, HttpHeaders httpHeaders, UserDto userDto) {
        HttpEntity<UserDto> httpEntity = new HttpEntity<>(userDto, httpHeaders);

        return restTemplate.exchange(
                url,
                httpMethod,
                httpEntity,
                String.class
        );
    }
}
