package in.dhananjaygore.expensetrackerapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class JwtResponse {

	private final String jwtToken ;

	public String getJwtToken() {
		return jwtToken;
	}

	public JwtResponse(String jwtToken) {
		super();
		this.jwtToken = jwtToken;
	}	
}
