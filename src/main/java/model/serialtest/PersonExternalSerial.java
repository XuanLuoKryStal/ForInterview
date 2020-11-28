package model.serialtest;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class PersonExternalSerial implements Externalizable {
    private int age;
    private String name;


    public PersonExternalSerial() {
    }

    public PersonExternalSerial(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
         out.writeObject(name);
         out.write(age);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
         this.name= (String) in.readObject();
         this.age=in.read();
    }

    @Override
    public String toString() {
        return "PersonExternalSerial{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
