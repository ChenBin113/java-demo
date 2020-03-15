package _07_io.externalizable;

import java.io.*;

public class ExternalizableDemo {
    public static void main(String[] args) {
        User user = new User();
        user.setName("Lin");
        user.setAge(18);
        System.out.println(user);


        try (FileOutputStream fos = new FileOutputStream("tmpFile");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(user);
        } catch (IOException e) {
            e.printStackTrace();
        }


        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("tmpFile"))) {
            Object o = ois.readObject();
            System.out.println(o);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
