package admin.dto;

/**
 * @author 유승현
 * 뷰 vwTeacherEval DTO
 */
public class Admin_vwTeacherEvalDTO {

    private String teacherName;
    private String processName;
    private String studentName;
    private String contents;
    private String score;
    private String openProcess_seq;

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getOpenProcess_seq() {
        return openProcess_seq;
    }

    public void setOpenProcess_seq(String openProcess_seq) {
        this.openProcess_seq = openProcess_seq;
    }
}
