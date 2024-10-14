package ${package}.infrastructure.adapters.input.rest.model.response;

import java.util.List;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
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
public class ${mainClassName}Response {
	@Schema(description = "Unique identifier")
    private String id;

    @Schema(description = "Description")
    private String description;
}
