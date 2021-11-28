package int222.integrated.Exception;

public class UserNameException extends RuntimeException {
	ExceptionResponse.ERROR_CODE errorCode;

	public UserNameException(ExceptionResponse.ERROR_CODE errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
	}

	public ExceptionResponse.ERROR_CODE getErrorCode() {
		return this.errorCode;
	}
}
