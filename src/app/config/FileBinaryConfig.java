package app.config;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class FileBinaryConfig<T> {
    private static final String FILE_NOT_FOUND_EXCEPTION = "File Not Found Exception";
    private static final String IOE_EXCEPTION = "IOE Exception";
    private static final String CLASS_NOT_FOUND_EXCEPTION = "Class Not Found Exception";

    /*----------------------------------------------------------Read-Write----------------------------------------------------------*/
    public synchronized List<T> readFile(String pathName) {
        List<T> dataList = new LinkedList<>();
        try {
            File file = new File(pathName);
            if (!file.exists()) file.createNewFile();
            FileInputStream reader = new FileInputStream(file);
            if (reader.available() != 0) {
                ObjectInputStream objectInputStream = new ObjectInputStream(reader);
                dataList = (List<T>) objectInputStream.readObject();
                reader.close();
                objectInputStream.close();
            }
        } catch (FileNotFoundException errException) {
            System.err.println(FILE_NOT_FOUND_EXCEPTION);
        } catch (IOException errException) {
            errException.printStackTrace();
            System.err.println(IOE_EXCEPTION);
        } catch (ClassNotFoundException errException) {
            System.err.println(CLASS_NOT_FOUND_EXCEPTION);
        } catch (Exception errException) {
            errException.printStackTrace();
        }
        return dataList;
    }

    public synchronized void writeFile(String pathName, boolean addContent, List<T> list) {
        try {
            File file = new File(pathName);
            if (!file.exists()) file.createNewFile();
            FileOutputStream writer = new FileOutputStream(file, addContent);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(writer);
            objectOutputStream.writeObject(list);
            objectOutputStream.flush();
            objectOutputStream.close();
        } catch (FileNotFoundException errException) {
            System.err.println(FILE_NOT_FOUND_EXCEPTION);
        } catch (IOException errException) {
            System.err.println(IOE_EXCEPTION);
        } catch (Exception errException) {
            errException.printStackTrace();
        }
    }
}