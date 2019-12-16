import main.binarysearch.RecursiveBinarySearch;

public class Main {

    public static void main(String[] args) {
        RecursiveBinarySearch binarySearch = new RecursiveBinarySearch();

        Integer[] data = {2, 3, 5, 6, 8, 9, 10, 12, 13, 15, 16, 17, 19, 20, 22};

        binarySearch.search(data, 6);
    }
}
