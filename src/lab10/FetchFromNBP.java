package lab10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

public class FetchFromNBP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bank prefix?");
        String accnum = sc.nextLine();
        try {
            URL url = new URL("https://ewib.nbp.pl/plewibnra?dokNazwa=plewibnra.txt");
            try (BufferedReader bw = new BufferedReader(new InputStreamReader(url.openStream()))) {
                String line;
                while ((line = bw.readLine()) != null) {
                    if (!line.startsWith(accnum)) continue;
                    String[] fetched = line.split("\\s*\\t");
                    System.out.println("Bank prefix: " + accnum + "\t\t Bank: " + fetched[1]);
                    return;
                }
                System.out.println("Nie znaleziono banku");
            }
        } catch (IOException e) {
           e.printStackTrace();
        }
    }
}
