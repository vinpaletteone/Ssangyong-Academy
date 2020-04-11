package teacher;

public class ProcTScoreCheckDTO {
	private String processName;	
	private String processStart;
	private String processEnd;
	private String ClassName;
	private String subjectSeq;
	private String subjectName;
	private String subjectStart;
	private String subjectEnd;
	private String regScore;
	public String getProcessName() {
		return processName;
	}
	public void setProcessName(String processName) {
		this.processName = processName;
	}
	public String getProcessStart() {
		return processStart;
	}
	public void setProcessStart(String processStart) {
		this.processStart = processStart;
	}
	public String getProcessEnd() {
		return processEnd;
	}
	public void setProcessEnd(String processEnd) {
		this.processEnd = processEnd;
	}
	public String getClassName() {
		return ClassName;
	}
	public void setClassName(String className) {
		ClassName = className;
	}
	public String getSubjectSeq() {
		return subjectSeq;
	}
	public void setSubjectSeq(String subjectSeq) {
		this.subjectSeq = subjectSeq;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public String getSubjectStart() {
		return subjectStart;
	}
	public void setSubjectStart(String subjectStart) {
		this.subjectStart = subjectStart;
	}
	public String getSubjectEnd() {
		return subjectEnd;
	}
	public void setSubjectEnd(String subjectEnd) {
		this.subjectEnd = subjectEnd;
	}
	public String getRegScore() {
		return regScore;
	}
	public void setRegScore(String regScore) {
		this.regScore = regScore;
	}
	
}
