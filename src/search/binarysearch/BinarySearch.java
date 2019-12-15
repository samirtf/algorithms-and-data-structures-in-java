package search.binarysearch;

public class BinarySearch {

    private Integer binarySearch(final Integer[] data, int leftBound, int rightBound, Integer element) {
        if(data == null || element == null) {
            return null;
        }
        if((rightBound - leftBound) == 0) {
            if(data[leftBound] == element) {
                return leftBound;
            }
            return null;
        }
        int mid = leftBound + (rightBound - leftBound) / 2;
        if(data[mid].equals(element)) {
            return mid;
        }
        if(element < data[mid]) {
            return binarySearch(data, leftBound, mid - 1, element);
        } else {
            return binarySearch(data, mid + 1, rightBound, element);
        }
    }

    public void search(Integer[] data, Integer element) {
        System.out.println(binarySearch(data, 0, data.length - 1, element));
    }


}
