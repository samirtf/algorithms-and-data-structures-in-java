import search.binarysearch.BinarySearch;

public class Main {

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();

        Integer[] data = {2, 3, 5, 6, 8, 9, 10, 12, 13, 15, 16, 17, 19, 20, 22};

        binarySearch.search(data, 6);
    }

}
