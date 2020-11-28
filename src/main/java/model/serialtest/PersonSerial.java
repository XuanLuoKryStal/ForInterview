package model.serialtest;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class PersonSerial implements Serializable {
    private int age;
    private String name;

    public PersonSerial(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public PersonSerial() {

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

    /**
     * 重写这个方法，必须要是private而不是public，就会调用这个进行序列化
     * @param s
     * @throws IOException
     */
    private void writeObject(ObjectOutputStream s) throws IOException{
        s.writeObject(this.name);
    }

    /**
     * 同上
     * @param s
     * @throws IOException
     * @throws ClassNotFoundException
     */
    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
      this.name=(String) s.readObject();
    }

    @Override
    public String toString() {
        return "PersonSerial{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
