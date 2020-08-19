import java.util.Scanner;

public class Sparrow {
    public static void main(String[] args) {
        String welcome = "  _  _ _   ___ _                    \n" +
                " | || (_) |_ _( )_ __               \n" +
                " | __ | |  | ||/| '  \\              \n" +
                " |_||_|_| |___| |_|_|_|             \n" +
                " / __|_ __  __ _ _ _ _ _ _____ __ __\n" +
                " \\__ \\ '_ \\/ _` | '_| '_/ _ \\ V  V /\n" +
                " |___/ .__/\\__,_|_| |_| \\___/\\_/\\_/ \n" +
                "     |_|                            ";
        System.out.println(welcome);
        reply("How can I help ye?");
        echo();
    }

    public static void reply(String message) {
        System.out.println("    ________________________________________");
        System.out.println("      " + message);
        System.out.println("    ________________________________________");
    }

    public static void echo() {
        Scanner sc = new Scanner(System.in);
        String message = sc.nextLine();
        while (!message.equals("bye")) {
            reply(message);
            message = sc.nextLine();
        }
        reply("Bye. Hope t' see ye again soon!");
    }



}