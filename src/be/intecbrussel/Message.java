package be.intecbrussel;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class Message {

    public static void niceText(){

        Path path = Path.of("./FromJussiToJoey/message.txt");
        Path path2 = Path.of("./FromJussiToJoey/animal.txt");

        if (!Files.exists(path.getParent())) {
            try {
                Files.createDirectories(path.getParent());
            }
            catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }

        try (FileWriter fileWriter = new FileWriter(path.toFile());
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            bufferedWriter.write("I'm trying to teach my cat Java programming...\n");
            bufferedWriter.write("But he keeps complaining about a `NullLaserPointerException`.\n");

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        try (FileReader fileReader = new FileReader(path.toFile());
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String lines;
            while ((lines = bufferedReader.readLine()) != null) {
                System.out.println(lines);
            }
        }
        catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
