package Arrays;

public class LinearSearch {
    public static int LinearSearch(int arr[], int val){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == val) {
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int arr[] = {4,5,6,7,8,9};
        int val = 8;
        int index = LinearSearch(arr,val);
        if (index == -1)
            System.out.println("Element is not present in the array");
        else
            System.out.println("Element found at position " + index);
    }
}
