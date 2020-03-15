package _07_io.serializable;

import java.io.*;

public class SerializableDemo {
    public static void main(String[] args) {
        User user = new User();
        user.setName("Chen");
        user.setAge(18);
        System.out.println(user);


        try (FileOutputStream fos = new FileOutputStream("tmpFile");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(user);
        } catch (IOException e) {
            e.printStackTrace();
        }


        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("tmpFile"))) {
            User u = (User)ois.readObject();
            System.out.println(u);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
