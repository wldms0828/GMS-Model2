package domain;

import lombok.Data;

@Data

public class RecordBean {
	private String recordSeq,grade,age;

	@Override
	public String toString() {
		return "RecordBean [recordSeq=" + recordSeq + ", grade=" + grade + ", age=" + age + "]";
	}
}
