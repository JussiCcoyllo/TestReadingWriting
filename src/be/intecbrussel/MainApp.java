package be.intecbrussel;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class MainApp {
    public static void main(String[] args) {

        Message.niceText();

        Lion lion = new Lion("Muffasa", false);
        Lion lion2 = new Lion("Lucky", false);
        Lion lion3 = new Lion("Kaya", false);
        Lion lion4 = new Lion("Lionela", false);

        Path path = Path.of("./FromJussiToJoey/animal.txt");

        if (!Files.exists(path.getParent())) {
            try {
                Files.createDirectories(path.getParent());
            }
            catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream("./FromJussiToJoey/animal.txt"))) {
            objectOutputStream.writeObject(lion);
            objectOutputStream.writeObject(lion2);
            objectOutputStream.writeObject(lion3);
            objectOutputStream.writeObject(lion4);

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        try (ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("./FromJussiToJoey/animal.txt"))) {

            Lion myLion;
            while ((myLion = (Lion) objectInputStream.readObject()) != null) {
                System.out.println(myLion);
            }
        }
        catch (EOFException eofException) {
            System.out.println("Finish!");
        }
        catch (IOException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }
    }
}
