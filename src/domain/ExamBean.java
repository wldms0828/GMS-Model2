package domain;

public class ExamBean {
	private String examSeq, memId, score, month, subSeq, recordSeq;

	public String getExamSeq() {
		return examSeq;
	}
	public void setExamSeq(String examSeq) {
		this.examSeq = examSeq;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getSubSeq() {
		return subSeq;
	}
	public void setSubSeq(String subSeq) {
		this.subSeq = subSeq;
	}
	public String getRecordSeq() {
		return recordSeq;
	}
	public void setRecordSeq(String recordSeq) {
		this.recordSeq = recordSeq;
	}
	
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
