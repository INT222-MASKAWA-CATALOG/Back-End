package int222.integrated.Models;

import java.io.Serializable;

public class JwtResponse implements Serializable {
	
	//private static final long serialVersionUID = -2364848278148277027L;
	private final String jwttoken;
	
	public JwtResponse(String jwttoken) {
		this.jwttoken = jwttoken;
	}
	
	public String getToken() {
		return this.jwttoken;
	}
	
	
}
