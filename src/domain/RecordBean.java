package domain;

public class RecordBean {
	private String recordSeq,grade,age;

	public String getRecordSeq() {
		return recordSeq;
	}
	public void setRecordSeq(String recordSeq) {
		this.recordSeq = recordSeq;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "RecordBean [recordSeq=" + recordSeq + ", grade=" + grade + ", age=" + age + "]";
	}
}
