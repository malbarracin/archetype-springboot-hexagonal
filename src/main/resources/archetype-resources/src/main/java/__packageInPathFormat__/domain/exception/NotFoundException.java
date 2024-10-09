package ${package}.domain.exception;

public class MoodNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public MoodNotFoundException(String message) {
		super(message);
	}
}



