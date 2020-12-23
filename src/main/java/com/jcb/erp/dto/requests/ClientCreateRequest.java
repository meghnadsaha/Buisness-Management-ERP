package com.jcb.erp.dto.requests;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClientCreateRequest {

	//	@NotBlank(message = "username cannot be empty")
//    @Size(min = 3, max = 50, message = "username size must be between 3 and 50")
	private String username;
	
//	@NotBlank(message = "password cannot be empty")
//    @Size(min = 6, max = 50, message = "password size must be between 6 and 50")
	private String password;
	
//	@NotEmpty(message = "client should have a role")
//	private Set<String> roles;

	@Override
	public String toString() {
		return "{\"username\":\"" + username + "\"}";
	}
}
