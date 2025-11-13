package entity;

import util.SnowflakeIdGenerator;

import java.util.Objects;

public class Student {
    private static final SnowflakeIdGenerator ID_GEN =
            new SnowflakeIdGenerator(1, 1);
    private final Long id;
    private String name;

    ;
    private int age;
    private Gender gender;
    public Student(String name, int age, Gender gender) {
        this.id = ID_GEN.nextId();
        this.name = name;
        this.age = age;
        this.gender = gender;
        if (this.age < 0 || this.age > 120) {
            throw new IllegalArgumentException("非法年龄！");
        }
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + ", gender=" + gender + "]";
    }

    @Override
    public boolean equals(Object obj) {
        //同一对象
        if (obj == this) return true;
        //比较类型
        if (obj == null || obj.getClass() != this.getClass()) return false;
        Student other = (Student) obj;
        //返回字段比较结果
        return Objects.equals(this.name, other.name) && Objects.equals(this.age, other.age) && Objects.equals(this.gender, other.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, gender);
    }

    public enum Gender {
        MALE,
        FEMALE
    }
}
