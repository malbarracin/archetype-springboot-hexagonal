package ${package}.infrastructure.adapters.output.persistence.entity;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nonapi.io.github.classgraph.json.Id;

/**
 * ${mainClassName} entity representing a ${mainClassName} in the system.
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "${mainClassName}")
public class ${mainClassName}Entity {
	@Id
	private String id;
	private String description;
}
