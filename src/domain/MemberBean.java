package domain;

import lombok.Data;

@Data
public class MemberBean {
	private String age,gender,userId, ssn, name, roll, teamId,password, subject;

	@Override
	public String toString() {
		return "MemberBean [age=" + age + ", gender=" + gender + ", userId=" + userId + ", ssn=" + ssn + ", name="
				+ name + ", roll=" + roll + ", teamId=" + teamId + ", password=" + password + ", subject=" + subject
				+ "]";
	}





	
}
