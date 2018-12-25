import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Edytor {

    private int nrKodowania;
    private String tekst;
    private Scanner scanner;
    private OutputStreamWriter outputStreamWriter;

    Edytor() throws IOException {
        scanner = new Scanner(System.in);
        menu();
        wprowadzanieTekstu();
        kodowanie();
        scanner.close();
    }

    private void kodowanie() throws IOException {

        FileOutputStream fileOutputStream = new FileOutputStream("d:\\output.txt");
        switch (this.nrKodowania) {
            case 1:
                outputStreamWriter = new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8);
                break;
            case 2:
                outputStreamWriter = new OutputStreamWriter(fileOutputStream, "ISO-8859-2");
                break;
            case 3:
                outputStreamWriter = new OutputStreamWriter(fileOutputStream, "windows-1250");
                break;
        }
        outputStreamWriter.write(this.tekst);
        outputStreamWriter.close();
    }

    private void menu() {
        System.out.print("Możliwe kodowania:\n1.UTF-8\n2.ISO-8859-2\n3.windows-1250\nWybierz numer kodowania: ");
        this.nrKodowania = scanner.nextInt();
        while (this.nrKodowania != 1 && this.nrKodowania != 2 && this.nrKodowania != 3) {
            System.out.print("Wprowadzono zły numer, wybierz jeszcze raz:");
            this.nrKodowania = scanner.nextInt();
        }
    }

    private void wprowadzanieTekstu() {
        System.out.println("Wprowadź tekst:");
        tekst = scanner.next();
    }
}
