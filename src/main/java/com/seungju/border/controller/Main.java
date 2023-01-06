package com.seungju.border.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.seungju.border.dto.HelloDto;

//Response로 HTML을 반환하는 Controller 가 아닌
//Response Body에 직접 데이터를 담아서 응답하는 Controller
//@RestController = @Controller + @ResponeBody
@RestController
// @RequestMapping(pattern) : http://localhost:4040/(end-point)/
// end-point의 패턴을 지정하여 해당 패턴의 end-point 일 때 해당 Controller를 실행
@RequestMapping("apis/")
public class Main {
	
	static final String HELLO = "/hello"; 
	// http방식://호스트:포트/~(/~:end-point)
	// http://localhost:4040/~~~
	
	
	// GetMapping(end-point) : 해당 end-point로 Get 방식의 Request가 왔을 때 동작
	@GetMapping("")
	public String hello() {
		return "Hello Spring Boot World!";
	}
	
	@GetMapping(HELLO)
//	 @RequestParam(name = "", value = "", required = true, defaultValue = "")
//	 : URL로 데이터를 받는 경우 (Get, Delete) 쿼리 형태로 데이터를 받음
	// http://호스트:포트/end-point?name=value&...
	public String getHello(@RequestParam(name = "name", required=false, defaultValue = "james") String name) {
		return "This is get method, end-point/'/hello'" + name;
	}
	@GetMapping(HELLO + "/{name}/spring")
	// @PathVariable(path) : URL 데이터를 받는 경우 (Get, Delete) path 형태로 데이터를 받음
	// http://호스트:포트/end-point/VARIABLE
	public String postHelloName(@PathVariable("name")String name) {
		return "This is get method, end-point/'/hello'" + name;
	}
	
	// @PostMapping(end-point) : 해당 end-point로 Post 방식의 Request가 왔을 때 동작
	@PostMapping(HELLO)
	// @RequestBody : 해당 Request의 Body에서 JSON을 인식해 인스턴스로 변경
	public HelloDto postHello(@RequestBody HelloDto requestBody) {
		return requestBody;
	}
	
	// @PutMapping(end-point) : 해당 end-point로 Put 방식의 Request가 왔을 때 동작
	@PutMapping(HELLO)
	public String putHello() {
		return "This is put method, end-point/'/hello'";
	}
	
	// @PatchMapping(end-point) : 해당 end-point로 Patch 방식의 Request가 왔을 때 동작
	@PatchMapping(HELLO)
	public String patchHello() {
		return "This is patch method, end-point/'/hello'";
	}
	// @DeleteMapping(end-point) : 해당 end-point로 Patch 방식의 Request가 왔을 때 동작
	@DeleteMapping(HELLO)
	public String deleteHello() {
		return "Hello Spring Boot";
	}
}
