package yte.intern.springweb.controllers.dto;

public class Student {

    private String name;
    private Long age;
    private String email;

    public Student(final String name, final Long age, final String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(final Long age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }
}
