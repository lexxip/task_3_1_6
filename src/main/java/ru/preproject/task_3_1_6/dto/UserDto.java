package ru.preproject.task_3_1_6.dto;

public class UserDto {
    private Long id;
    private String name;
    private String lastName;
    private Byte age;

    public UserDto() {

    }

    public UserDto(Long id, String name, String lastName, Byte age) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Byte getAge() {
        return age;
    }

    public void setAge(Byte age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "[ID: " + this.getId()
                + ", Name: " + this.getName()
                + ", LastName: " + this.getLastName()
                + ", Age: " + this.getAge() + "]"
                ;
    }
}
