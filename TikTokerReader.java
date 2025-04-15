import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TikTokerReader {
    // Method pertama (asli)
    public List<TikToker> readTikTokers(String filePath) {
        return readTikTokers(filePath, true); // default skip header
    }

    // Method overloading (tambahan)
    public List<TikToker> readTikTokers(String filePath, boolean skipHeader) {
        List<TikToker> tikTokers = new ArrayList<>();
        String line;
        String csvSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            if (skipHeader) {
                br.readLine(); // lewati header
            }
            while ((line = br.readLine()) != null) {
                String[] data = line.split(csvSplitBy);
                int rank = Integer.parseInt(data[0]);
                String username = data[1];
                long followers = Long.parseLong(data[2]);
                int following = Integer.parseInt(data[3]);
                int uploads = Integer.parseInt(data[4]);
                long likes = Long.parseLong(data[5]);

                TikToker tikToker = new TikToker(rank, username, followers, following, uploads, likes);
                tikTokers.add(tikToker);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tikTokers;
    }
}
