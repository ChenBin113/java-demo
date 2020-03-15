package _07_io.externalizable;

import lombok.Data;

import java.io.*;

/**
 * 实现 Externalizable 接口
 */
@Data
public class User implements Externalizable {
    private String name;
    private int age;

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(name);
        out.writeInt(age);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = (String)in.readObject();
        age = in.readInt();
    }
}