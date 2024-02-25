package org.example;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
public class SerDeser {

    private static final String filepath = "C:\\Users\\user\\IdeaProjects\\magazin\\JsonData\\";

    public static <T>void SerData(List<T> data, String fileName){
        Gson gson = new Gson();
        String json = gson.toJson(data);

        try (FileWriter fileWriter = new FileWriter(filepath + fileName)) {
            fileWriter.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T>List<T> DeserData(String filename, Class<T> type){
        Gson gson = new Gson();
        Type listType = TypeToken.getParameterized(List.class, type).getType();

        File file = new File(filepath + filename);

        if (!file.exists()) {
            try {
                if (file.createNewFile()) {
                    CreateRoot();
                    System.out.println(" ");
                } else {
                    System.out.println(" ");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println(" ");
        }

        try (FileReader reader = new FileReader(filepath + filename)) {
            return gson.fromJson(reader, listType);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void CreateRoot(){
        Gson gson = new Gson();
        File file = new File(filepath + "user.json");

        if (!file.exists()) {
            try {
                if (file.createNewFile()) {
                    User user = new User("root", "1234", "Admin");
                    List<User> users = new ArrayList<>();
                    users.add(user);
                    String json = gson.toJson(users);
                    try (FileWriter fileWriter = new FileWriter(filepath + "user.json")) {
                        fileWriter.write(json);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println(" ");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println(" ");
        }

    }
}
