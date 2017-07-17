import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import org.jetbrains.annotations.NotNull;
import org.yaml.snakeyaml.Yaml;
import students.Student;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by NoahGleason on 7/16/17.
 */
public class Example {

	@NotNull
	private Student valedictorian;
	@NotNull
	private List<Student> students;
	@NotNull
	private String classname;

	@JsonCreator
	public Example(@NotNull @JsonProperty(required = true) Student valedictorian,
	               @NotNull @JsonProperty(required = true) List<Student> students,
	               @NotNull @JsonProperty(required = true) String classname) {
		this.valedictorian = valedictorian;
		this.students = students;
		this.classname = classname;
	}

	public static void main(String[] args) throws IOException {
		Yaml yaml = new Yaml();
		Map<?, ?> normalized = (Map<?, ?>) yaml.load(new FileReader("example.yml"));
		YAMLMapper mapper = new YAMLMapper();
		//Turn the Map read by SnakeYaml into a String so Jackson can read it.
		String fixed = mapper.writeValueAsString(normalized);
		//Use a parameter name module so we don't have to specify name for every field.
		mapper.registerModule(new ParameterNamesModule(JsonCreator.Mode.PROPERTIES));
		//Deserialize the map into an object.
		Example output = mapper.readValue(fixed, Example.class);
		System.out.println("Class name: "+output.classname);
		System.out.println("Valedictorian: "+output.valedictorian);
		System.out.println("Students: "+output.students);
		System.out.println("Valedictorian is first student in Students: "+(output.valedictorian == output.students.get(0)));
	}
}