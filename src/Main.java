import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main
{

    public static void main(String[] args)
    {
        try
        {

         Pattern spz = Pattern.compile("[A-Z]{2}[0-9]{3}[A-Z]{2}+");
         Pattern mac=Pattern.compile("([0-9A-Fa-f]{2}[:]){5}([0-9A-Fa-f]{2})");
         Pattern rodc=Pattern.compile("\\d{2}([05][1-9]|[16][0-2])[0-3][0-9]/?[0-9]{4}");

         BufferedReader buffreader = new BufferedReader(new FileReader("C:\\Users\\MRTN\\Desktop\\rawText.txt"));
         String line;
         FileWriter writerspz = new FileWriter("SPZ.txt");
         FileWriter writermac = new FileWriter("MAC.txt");
         FileWriter writerrodc = new FileWriter("RODC.txt");
         while((line = buffreader.readLine())!=null)
         {
             Matcher mspz =spz.matcher(line);
             while(mspz.find())
             {
                 int start = mspz.start(0);
                 int end = mspz.end(0);
                 writerspz.write(line.substring(start,end));
                 writerspz.write(",");
                 writerspz.flush();



             }
             Matcher mmac = mac.matcher(line);
             while (mmac.find())
             {
                 int start = mmac.start(0);
                 int end = mmac.end(0);
                 writermac.write(line.substring(start,end));
                 writermac.write(",");
                 writermac.flush();
             }

             Matcher mrod = rodc.matcher(line);
             while(mrod.find())
             {
                 int start = mrod.start(0);
                 int end = mrod.end(0);
                 writerrodc.write(line.substring(start,end));
                 writerrodc.write(",");
                 writerrodc.flush();
             }

         }
                writerspz.close();
                writermac.close();
                writerrodc.close();

        }




        catch(IOException e)
        {
            e.getMessage();
        }
    }


     }
