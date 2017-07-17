package students;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.jetbrains.annotations.NotNull;

/**
 * Created by NoahGleason on 7/16/17.
 */
@JsonIdentityInfo(generator = ObjectIdGenerators.StringIdGenerator.class)
public class LiveInStudent extends Student{
	private int buildingNum;
	private boolean hasMealPlan;

	@JsonCreator
	public LiveInStudent(@JsonProperty(required = true) int grade,
	                     @NotNull @JsonProperty(required = true) String name,
	                     Double gpa,
	                     @JsonProperty(required = true) int buildingNum,
	                     boolean hasMealPlan) {
		super(grade, name, gpa);
		this.buildingNum = buildingNum;
		this.hasMealPlan = hasMealPlan;
	}

	public int getBuildingNum() {
		return buildingNum;
	}

	public boolean isHasMealPlan() {
		return hasMealPlan;
	}

	@Override
	public String toString() {
		return "students.LiveInStudent{" +
				"grade=" + getGrade() +
				", name='" + getName() + '\'' +
				", gpa=" + getGpa() +
				", buildingNum=" + buildingNum +
				", hasMealPlan=" + hasMealPlan +
				'}';
	}
}
