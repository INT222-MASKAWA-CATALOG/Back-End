package int222.integrated.Exception;

import java.time.LocalDateTime;

public class ExceptionResponse {

	public static enum ERROR_CODE {
		PRODUCT_ID_DOES_NOT_EXIST(1000), PRODUCT_NAME_ALREADY_EXIST(1001),

		BRAND_ID_DOES_NOT_EXIST(2000), COLOR_ID_DOES_NOT_EXIST(3000),

		ONLINE_ID_DOES_NOT_EXIST(4000), SHOP_ID_DOES_NOT_EXIST(5000), USERNAME_ALREADY_EXIST(6000),
		EMAIL_ALREADY_EXIST(7000), USER_ID_DOES_NOT_PRODUCT(8000),

		PRODUCT_ALREADY_EXIST(2001), IMAGES_NAME_ALREADY_EXIST(3001), PRODUCT_ID_ALREADY_EXIST(5001);

		private int errorValue;

		ERROR_CODE(int errorValue) {
			this.errorValue = errorValue;
		}
	}

	private ERROR_CODE errorCode;
	private String message;
	private LocalDateTime dateTime;

	public ExceptionResponse(ERROR_CODE errorCode, String message, LocalDateTime dateTime) {
		this.errorCode = errorCode;
		this.message = message;
		this.dateTime = dateTime;
	}

	public ERROR_CODE getErrorCode() {
		return errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
}