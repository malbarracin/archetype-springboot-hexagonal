package ${package}.domain.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ${mainClassName} {
	/**
	 * Unique identifier for the playlist.
	 */
	private String id;
	
	private String description;

}