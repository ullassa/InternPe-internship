import javax.sound.sampled.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


public class mp3file {
    public static void main(String[] args) {
        String filePath = "src\\blueprint for the future - Lish Grooves.wav";
        File file = new File(filePath);

try(Scanner sc=new Scanner(System.in);
    AudioInputStream audiostream= AudioSystem.getAudioInputStream(file))
{

   Clip clip=AudioSystem.getClip();
   clip.open(audiostream);
   clip.start();

   String response="";
   while(!response.equals("Q")) {
       System.out.println("P=Play");
       System.out.println("S=Stop");
       System.out.println("R=reset");
       System.out.println("Q=quit");
       System.out.print( "enter your choice: ");
        response=sc.next().toUpperCase();

   switch (response){
       case "P"->clip.start();
       case "S"->clip.stop();
       case "R"->clip.setMicrosecondPosition(0);
       case "Q"->clip.close();
       default -> System.out.println("invalid choice");
   }

   }
    //System.out.println("no problems detected");
}
catch(FileNotFoundException e){
    System.out.println("audio file is not supports");
}
catch(UnsupportedAudioFileException e){
    System.out.println("audio file is not supproted");

}
catch(LineUnavailableException e){
    System.out.println("unable to access resource");

}
catch (IOException e){
    System.out.println("something went wrong");
}
finally {
    System.out.println("bye!");

}

    }
}
