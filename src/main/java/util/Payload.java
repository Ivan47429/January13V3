package util;

public class Payload {

    public static String unsuccessfulLoginUser(){
        String e = "{\n" +
                "    \"email\": \"peter@klaven\"\n" +
                "}";
        return e;
    }

    public static String bodyForCreatingUser() {
        String a = "{\n" +
                "    \"name\": \"Morfi\",\n" +
                "    \"job\": \"bo$$\"\n" +
                "}";
        return a;
    }

    public static String bodyForUpdatingUser(){
        String b = "{\n" +
                "    \"name\": \"MORFImorpheus\",\n" +
                "    \"job\": \"ZITELzion resident\"\n" +
                "}";
        return b;
    }

    public static String bodyForLogInUser(){
        String d ="{\n" +
                "    \"email\": \"eve.holt@reqres.in\",\n" +
                "    \"password\": \"cityslicka\"\n" +
                "}";
        return d;
    }

}
