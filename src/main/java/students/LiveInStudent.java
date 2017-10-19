package students;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.jetbrains.annotations.NotNull;

/**
 * A student who lives at the school.
 */
@JsonIdentityInfo(generator = ObjectIdGenerators.StringIdGenerator.class)
public class LiveInStudent extends Student {

	/**
	 * The building number this student lives in.
	 */
	private final int buildingNum;

	/**
	 * Whether or not this student has a meal plan.
	 */
	private final boolean hasMealPlan;

	/**
	 * Default constructor.
	 *
	 * @param grade       The grade level this student is in.
	 * @param name        This student's name.
	 * @param gpa         This student's GPA on the 4-point scale. Defaults to 4.
	 * @param buildingNum The building number this student lives in.
	 * @param hasMealPlan Whether or not this student has a meal plan. Defaults to false.
	 */
	@JsonCreator
	public LiveInStudent( int grade,
	                     @NotNull @JsonProperty(required = true) String name,
	                     Double gpa,
	                     @JsonProperty(required = true) int buildingNum,
	                     boolean hasMealPlan) {
		super(grade, name, gpa);
		this.buildingNum = buildingNum;
		this.hasMealPlan = hasMealPlan;
	}

	/**
	 * @return The building number this student lives in.
	 */
	public int getBuildingNum() {
		return buildingNum;
	}

	/**
	 * @return Whether or not this student has a meal plan.
	 */
	public boolean hasMealPlan() {
		return hasMealPlan;
	}

	/**
	 * @return A string representation of this student's grade, name, GPA, building number, and meal plan status.
	 */
	@Override
	public String toString() {
		return "students.LiveInStudent{" +
				"grade=" + getGrade() +
				", name='" + getName() + '\'' +
				", gpa=" + getGpa() +
				", buildingNum=" + getBuildingNum() +
				", hasMealPlan=" + hasMealPlan() +
				'}';
	}
}
