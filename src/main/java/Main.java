import java.util.Scanner;

public class Main {

    public static void showStatus(Factory factory){
        System.out.println("unsold inventory: " + factory.getUnsoldInventory().get());
        System.out.println("wire: " + factory.getWire().get());
        System.out.println("created paperclips: " + factory.getCreatedPaperclips().get());
    }

    public static void main(String[] args) {
        Factory factory = new Factory();
        showStatus(factory);
        System.out.println("What do you want to do:");

        while(true){
            Scanner myObj = new Scanner(System.in);
            String command = myObj.nextLine();
            switch(command) {
                case "clip":
                    // code block
                    factory.makePaperclip();
                    showStatus(factory);
                    break;
                case "add autoclipper":
                    Paperclips paperclips   = new Paperclips(factory);
                    paperclips.addAutoClipper();
                    paperclips.startAutoClippers();
                    // TODO: add an autoclipper thread
                     break;
                default:
                    // code block
            }
        }


    }
}
