package students;

import com.fasterxml.jackson.annotation.*;
import org.jetbrains.annotations.NotNull;

/**
 * Created by NoahGleason on 7/16/17.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.WRAPPER_OBJECT, property = "@class")
@JsonIdentityInfo(generator = ObjectIdGenerators.StringIdGenerator.class)
public class Student {
	private int grade;
	@NotNull
	private String name;
	private double gpa;

	@JsonCreator
	public Student(@JsonProperty(required = true) int grade,
	               @NotNull @JsonProperty(required = true) String name, Double gpa) {
		this.grade = grade;
		this.name = name;
		this.gpa = gpa != null ? gpa : 4.0;
	}

	public int getGrade() {
		return grade;
	}

	@NotNull
	public String getName() {
		return name;
	}

	public double getGpa() {
		return gpa;
	}

	@Override
	public String toString() {
		return "students.Student{" +
				"grade=" + grade +
				", name='" + name + '\'' +
				", gpa=" + gpa +
				'}';
	}
}
