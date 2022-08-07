package yte.intern.springweb.responsebody;

public class Course {

    private String code;
    private String instructor;

    public Course(String code, String instructor) {
        this.code = code;
        this.instructor = instructor;
    }

    public String getCode() {
        return code;
    }

    public String getInstructor() {
        return instructor;
    }
}
