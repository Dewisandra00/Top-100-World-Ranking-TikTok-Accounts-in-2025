import java.util.*;

public class Main {
    public static void main(String[] args) {
        TikTokerReader reader = new TikTokerReader();
        String filePath = "data/Top100Tiktokers.csv";
        List<TikToker> tikTokers = reader.readTikTokers(filePath, true);

        Scanner scanner = new Scanner(System.in);

        // === BUBBLE SORT BERDASARKAN FOLLOWERS (DESCENDING) ===
        bubbleSortByFollowers(tikTokers);
        System.out.println("=== BUBBLE SORT - Berdasarkan Followers (Desc) ===");
        printList(tikTokers);

        // === MERGE SORT BERDASARKAN LIKES (ASCENDING) ===
        List<TikToker> mergeSorted = mergeSortByLikes(new ArrayList<>(tikTokers));
        System.out.println("\n=== MERGE SORT - Berdasarkan Likes (Asc) ===");
        printList(mergeSorted);

        // === LINEAR SEARCH BERDASARKAN USERNAME ===
        System.out.print("\nMasukkan keyword username untuk Linear Search: ");
        String keyword = scanner.nextLine().toLowerCase();
        System.out.println("Hasil Linear Search:");
        linearSearchByUsername(tikTokers, keyword);

        // === BINARY SEARCH BERDASARKAN RANK ===
        tikTokers.sort(Comparator.comparingInt(TikToker::getRank)); // sort ascending
        System.out.print("\nMasukkan rank untuk Binary Search: ");
        int rankToFind = scanner.nextInt();
        TikToker found = binarySearchByRank(tikTokers, rankToFind);
        System.out.println("Hasil Binary Search:");
        if (found != null) {
            System.out.println(found);
        } else {
            System.out.println("Tidak ditemukan TikToker dengan rank tersebut.");
        }

        scanner.close();
    }

    // Bubble Sort: berdasarkan followers (desc)
    public static void bubbleSortByFollowers(List<TikToker> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {
                if (list.get(j).getFollowers() < list.get(j + 1).getFollowers()) {
                    Collections.swap(list, j, j + 1);
                }
            }
        }
    }

    // Merge Sort: berdasarkan likes (asc)
    public static List<TikToker> mergeSortByLikes(List<TikToker> list) {
        if (list.size() <= 1) return list;

        int mid = list.size() / 2;
        List<TikToker> left = mergeSortByLikes(list.subList(0, mid));
        List<TikToker> right = mergeSortByLikes(list.subList(mid, list.size()));

        return merge(left, right);
    }

    public static List<TikToker> merge(List<TikToker> left, List<TikToker> right) {
        List<TikToker> result = new ArrayList<>();
        int i = 0, j = 0;
        while (i < left.size() && j < right.size()) {
            if (left.get(i).getLikes() <= right.get(j).getLikes()) {
                result.add(left.get(i++));
            } else {
                result.add(right.get(j++));
            }
        }
        while (i < left.size()) result.add(left.get(i++));
        while (j < right.size()) result.add(right.get(j++));
        return result;
    }

    // Linear Search: berdasarkan username
    public static void linearSearchByUsername(List<TikToker> list, String keyword) {
        boolean ditemukan = false;
        for (TikToker t : list) {
            if (t.getUsername().toLowerCase().contains(keyword)) {
                System.out.println(t);
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            System.out.println("Tidak ditemukan.");
        }
    }

    // Binary Search: berdasarkan rank
    public static TikToker binarySearchByRank(List<TikToker> list, int targetRank) {
        int low = 0, high = list.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int rank = list.get(mid).getRank();
            if (rank == targetRank) return list.get(mid);
            else if (rank < targetRank) low = mid + 1;
            else high = mid - 1;
        }
        return null;
    }

    public static void printList(List<TikToker> list) {
        for (TikToker t : list) {
            System.out.println(t);
        }
    }
}
