package me.study.gofdesignpattern.creational_patterns.singleton;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class BreakSingletonWithSerializable {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        final Settings5 settings1 = Settings5.getInstance();
        Settings5 settings2 = null;

        try (final ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("settings.obj"))) {
            out.writeObject(settings1);
        }
        try (final ObjectInputStream in = new ObjectInputStream(new FileInputStream("settings.obj"))) {
            settings2 = (Settings5)in.readObject();
        }

        System.out.println(settings1 != settings2); // true : 싱글턴이 깨졌다.
    }
}
