package ${package}.infrastructure.adapters.input.rest.model.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ${mainClassName}Request {

	@Schema(description = "Description")
	@NotEmpty(message = "Field description cannot be empty or null.")
	private String description;

}
