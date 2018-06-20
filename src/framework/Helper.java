package framework;

public class Helper {

    public static String getRandomText() {

        int random = (int) (Math.random() * 250 + 1);
        String randomText = "Catetogry" + random;
        return randomText;
        //        return "Category" + (int) (Math.random() * 500 + 1);
        
//    public static String getRandomUrl() {
//        return "";
//    }

}

}
