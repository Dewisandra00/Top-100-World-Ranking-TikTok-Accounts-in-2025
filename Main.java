import java.util.List;

public class Main {
    public static void main(String[] args) {
        TikTokerReader reader = new TikTokerReader();
        String filePath = "data/Top100Tiktokers.csv";

        // Memanggil method yang dioverload
        List<TikToker> tikTokers = reader.readTikTokers(filePath, true);

        for (TikToker tikToker : tikTokers) {
            System.out.println(tikToker);
        }
    }
}

