package in.dhananjaygore.expensetrackerapi.entity;

import java.util.Objects;

public class AuthModel {

	private String email;
	
	private String password;

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	public AuthModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AuthModel(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	@Override
	public String toString() {
		return "AuthModel [email=" + email + ", password=" + password + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AuthModel other = (AuthModel) obj;
		return Objects.equals(email, other.email) && Objects.equals(password, other.password);
	}
	
}
