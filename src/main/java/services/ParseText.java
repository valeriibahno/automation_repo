package services;

public class ParseText {

    private ParseText() {}

    public static int clearPrice(String text) {
        return Integer.parseInt(text.replaceAll("\\s+","").replaceAll("₴",""));
    }
}
