package students;

import com.fasterxml.jackson.annotation.*;
import org.jetbrains.annotations.NotNull;

/**
 * A generic student.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.WRAPPER_OBJECT, property = "@class")
@JsonIdentityInfo(generator = ObjectIdGenerators.StringIdGenerator.class)
public class Student {

	/**
	 * The grade level this student is in.
	 */
	private final int grade;

	/**
	 * This student's name.
	 */
	@NotNull
	private final String name;

	/**
	 * This student's GPA on the 4-point scale.
	 */
	private final double gpa;

	/**
	 * Default constructor.
	 *
	 * @param grade The grade level this student is in.
	 * @param name  This student's name.
	 * @param gpa   This student's GPA on the 4-point scale. Defaults to 4.
	 */
	@JsonCreator
	public Student(@JsonProperty(required = true) int grade,
	               @NotNull @JsonProperty(required = true) String name, Double gpa) {
		this.grade = grade;
		this.name = name;
		this.gpa = gpa != null ? gpa : 4.0;
	}

	/**
	 * @return The grade level this student is in.
	 */
	public int getGrade() {
		return grade;
	}

	/**
	 * @return This student's name.
	 */
	@NotNull
	public String getName() {
		return name;
	}

	/**
	 * @return This student's GPA on the 4-point scale.
	 */
	public double getGpa() {
		return gpa;
	}

	/**
	 * @return A string representation of this student's grade, name, and GPA.
	 */
	@Override
	public String toString() {
		return "students.Student{" +
				"grade=" + grade +
				", name='" + name + '\'' +
				", gpa=" + gpa +
				'}';
	}
}
