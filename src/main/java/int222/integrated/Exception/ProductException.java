package int222.integrated.Exception;

public class ProductException extends RuntimeException {
	// private static final long serialVersionUID;
	ExceptionResponse.ERROR_CODE errorCode;

	public ProductException(ExceptionResponse.ERROR_CODE errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
	}

	public ExceptionResponse.ERROR_CODE getErrorCode() {
		return this.errorCode;
	}
}