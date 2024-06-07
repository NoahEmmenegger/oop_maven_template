package ch.hslu.SW12;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

public class StreamTest {
    private static final Logger LOG = LoggerFactory.getLogger(StreamTest.class);

    public static void main(String[] args) {
        writeTextFile("data.txt");
        readTextFile("data.txt");
    }

    public static void writeTextFile(final String file) {
        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file))) {
            dataOutputStream.writeInt(111);
            dataOutputStream.writeFloat(3.14f);
            dataOutputStream.writeUTF("Hello World.@1 ");
            LOG.info("Data written to file");
        } catch (IOException e) {
            LOG.error("Error writing to file", e);
        }
    }

    public static void readTextFile(final String file) {
        try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file))) {
            final int value = dataInputStream.readInt();
            final float floatValue = dataInputStream.readFloat();
            final String text = dataInputStream.readUTF();
            LOG.info("Value: " + value);
            LOG.info("Float Value: " + floatValue);
            LOG.info("Text: " + text);
        } catch (IOException e) {
            LOG.error("Error reading from file", e);
        }
    }
}
