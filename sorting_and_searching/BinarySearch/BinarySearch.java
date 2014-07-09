/*
 * #### Binary Search ####
 * Time Complexity : O(log(n))
 * Space Complexity: O(1)
 *
 * */
public class BinarySearch {
	public static int binarySearch(int[] a, int key) {
		int low = 0;
		int high = a.length - 1;
		int mid;

		while (low <= high) {
			mid = (low + high) / 2;
			if (a[mid] < key) {
				low = mid + 1;
			} else if (a[mid] > key) {
				high = mid - 1;
			} else {
				return mid;
			}
		}
		return -1;
	}

	public static int binarySearchRecursive(int[] a, int key, int low, int high) {
		if (low > high) return -1; // Error

		int mid = (low + high) / 2;
		if (a[mid] < key) {
			return binarySearchRecursive(a, key, mid + 1, high);
		} else if (a[mid] > key) {
			return binarySearchRecursive(a, key, low, mid - 1);
		} else {
			return mid;
		}
	}


	public static void main(String[] args) {
		int[] a = {10, 11, 12, 16, 18, 23, 29, 33, 48, 54, 57, 68, 77, 84, 98};
		int key = 23;
		int result = binarySearch(a, key);
		System.out.println(result);
	}
}
