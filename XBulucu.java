import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XBulucu {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Lütfen denklemi giriniz: ");
        String input = scanner.nextLine();

        // 'x' ifadesinin sayısını bul
        String xDeseni = "x";
        Pattern xDeseniRegex = Pattern.compile(xDeseni);
        Matcher xEslesme = xDeseniRegex.matcher(input);

        int xSayisi = 0;
        while (xEslesme.find()) {
            xSayisi++;
        }

        // Sayısal sabitleri topla
        String sabitDeseni = "[-+]?[0-9]*\\.?[0-9]+";
        Pattern sabitDeseniRegex = Pattern.compile(sabitDeseni);
        Matcher sabitEslesme = sabitDeseniRegex.matcher(input);

        double toplam = 0.0;
        while (sabitEslesme.find()) {
            toplam += Double.parseDouble(sabitEslesme.group());
        }

        // 'x' ifadesinin değerini hesapla
        double xDegeri = (xSayisi == 0) ? 0.0 : toplam / xSayisi;

        if (xSayisi == 0) {
            System.out.println("Denkleminizde 'x' bulunamadığı için 'x' ifadesinin değeri 0'dır.");
        } else {
            System.out.println("'x' ifadesinin değeri: " + xDegeri);
        }
    }
}
