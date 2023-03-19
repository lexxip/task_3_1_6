package ru.preproject.task_3_1_6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import ru.preproject.task_3_1_6.dto.UserDto;
import ru.preproject.task_3_1_6.service.RestService;

import java.util.List;

@SpringBootApplication
public class Task316Application {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Task316Application.class, args);
		RestService restService = ctx.getBean(RestService.class);

		String result = "";
		String serverUrl = "http://94.198.50.185:7081/api/users";

		ResponseEntity<List<UserDto>> listUsers = restService.findAll(serverUrl);
		HttpHeaders header = listUsers.getHeaders();
		System.out.println(header);
		String cookie = header.get("Set-Cookie").get(0);
		String jSessionId = cookie.split(";")[0].split("=")[1];
		System.out.println(jSessionId);
		List<UserDto> list = listUsers.getBody();
		list.stream().limit(10).map(userDto -> userDto.toString()).forEach(System.out::println);

		UserDto userDto = new UserDto(3L, "James", "Brown", (byte) 18);
		System.out.println(userDto);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Cookie", "JSESSIONID=" + jSessionId);
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		ResponseEntity<String> processUser = restService.requestUser(serverUrl, HttpMethod.POST, httpHeaders, userDto);
		String body = processUser.getBody();
		result = result.concat(body);

		userDto.setName("Thomas");
		userDto.setLastName("Shelby");
		System.out.println(userDto);
		httpHeaders = new HttpHeaders();
		httpHeaders.add("Cookie", "JSESSIONID=" + jSessionId);
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		processUser = restService.requestUser(serverUrl, HttpMethod.PUT, httpHeaders, userDto);
		body = processUser.getBody();
		result = result.concat(body);

		httpHeaders = new HttpHeaders();
		httpHeaders.add("Cookie", "JSESSIONID=" + jSessionId);
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		processUser = restService.requestUser(serverUrl + "/3", HttpMethod.DELETE, httpHeaders, userDto);
		body = processUser.getBody();
		result = result.concat(body);

		System.out.println("\n Результат: " + result);
	}

}
