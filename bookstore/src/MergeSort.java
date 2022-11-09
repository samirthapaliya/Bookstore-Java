
public class MergeSort {
    
    public void merge(Object arr[][], int left, int mid, int right, int index, String order)
    {
        // Find sizes of two subarrays to be merged
        int n1 = mid - left + 1;
        int n2 = right - mid;
 
        // Create temp arrays 
        Object[][] left_arr = new Object[n1][6];
        Object[][] right_arr = new Object[n2][6];
 
        // Copy data to temp arrays
        for (int i = 0; i < n1; ++i)
            left_arr[i] = arr[left + i];
        for (int j = 0; j < n2; ++j)
            right_arr[j] = arr[mid + 1 + j];
 
        // Merge the temp arrays 
 
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
 
        // Initial index of merged subarry array
        int k = left;
        while (i < n1 && j < n2) {
            String string_at_i = (String) left_arr[i][index];
            
            if (order.equals("Ascending")) {
                if (string_at_i.compareToIgnoreCase((String)right_arr[j][index]) < 0 ) {
                    arr[k] = left_arr[i];
                    i++;
                }
                else {
                    arr[k] = right_arr[j];
                    j++;
                }
                
            } else if (order.equals("Descending")) {
                if (string_at_i.compareToIgnoreCase((String)right_arr[j][index]) > 0 ) {
                    arr[k] = left_arr[i];
                    i++;
                }
                else {
                    arr[k] = right_arr[j];
                    j++;
                }
            }
            
            k++;
        }
 
        // Copy remaining elements of left_arr[] if any 
        while (i < n1) {
            arr[k] = left_arr[i];
            i++;
            k++;
        }
 
        // Copy remaining elements of right_arr[] if any 
        while (j < n2) {
            arr[k] = right_arr[j];
            j++;
            k++;
        }
        
    }
 
    // sort two halves and merge
    public void sort(Object arr[][], int left, int right, int index, String order)
    {
        
        if (left < right) {
            // Find the middle point
            int mid =left+ (right-left)/2;
 
            // Sort first and second halves
            sort(arr, left, mid, index, order);
            sort(arr, mid + 1, right, index, order);
 
            // Merge the sorted halves
            merge(arr, left, mid, right, index, order);
        }
    }
 
}