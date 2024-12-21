package lab10;

import java.io.*;

public class FileCopier {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("from.txt"))) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("to.txt"))) {
                String line;
                while (br.ready() && (line = br.readLine()) != null) {
                    line = line.replaceAll(" ", "-");
                    bw.write(line);
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
//        File f1 = new File("from.txt");
//        f1.createNewFile();
//        File f2 = new File("to.txt");
//        f2.createNewFile();
    }
}
