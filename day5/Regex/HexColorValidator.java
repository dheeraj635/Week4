
public class HexColorValidator {
    public static void main(String[] args) {
        String[] colors = {"#FFA500", "#ff4500", "#123", "#GGGGGG", "#1a2b3c"};

        String regex = "^#[0-9A-Fa-f]{6}$";

        for (String color : colors) {
            if (color.matches(regex)) {
                System.out.println(color + " → Valid");
            } else {
                System.out.println(color + " → Invalid");
            }
        }
    }
}

