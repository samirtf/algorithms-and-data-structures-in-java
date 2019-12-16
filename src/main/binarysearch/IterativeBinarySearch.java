package main.binarysearch;

public class IterativeBinarySearch {

    private Integer binarySearch(final Integer[] data, Integer element) {
        if(data == null || element == null) {
            return null;
        }
        int leftBound = 0;
        int rightBound = data.length - 1;
        while((rightBound - leftBound) != 0) {
            int mid = leftBound + (rightBound - leftBound) / 2;
            if(data[mid].equals(element)) {
                return mid;
            }
            if(element < data[mid]) {
                rightBound = mid - 1;
            } else {
                leftBound = mid + 1;
            }
        }
        if((rightBound - leftBound) == 0) {
            if(data[leftBound] == element) {
                return leftBound;
            }
        }
        return null;
    }

    public Integer search(Integer[] data, Integer element) {
        return binarySearch(data, element);
    }


}
