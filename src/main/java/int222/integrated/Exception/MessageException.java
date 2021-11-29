package int222.integrated.Exception;

public class MessageException extends RuntimeException {
	ExceptionResponse.ERROR_CODE errorCode;

	public MessageException(ExceptionResponse.ERROR_CODE errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
	}

	public ExceptionResponse.ERROR_CODE getErrorCode() {
		return this.errorCode;
	}
}
