package domain;

import lombok.Data;
@Data
public class ExamBean {
	private String examSeq, memId, score, month, subSeq, recordSeq;
	
	@Override
	public String toString() {
		return "시험정보 [시험SEQ=" + examSeq
				+ ", 학생ID=" + memId 
				+ ", 점수=" + score 
				+ ", 월=" + month
				+ ", 과목SEQ=" + subSeq 
				+ ", 성적SEQ=" + recordSeq + "]";
	}
	
}
