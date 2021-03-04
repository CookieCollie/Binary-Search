import java.util.ArrayList;
import java.util.Random;

public class BinarySearch {
	public int Midpoint, Head, Tail;
	public int Target, FoundNum;
	
	ArrayList<Integer> array = new ArrayList<>();
	Random RandomNum = new Random();
	
	
	//Method to create array of random number and size
	public BinarySearch(int target) {
		Target = target;
		for (int i=0; i<RandomNum.nextInt(100); i++) {
			array.add(RandomNum.nextInt(100));
		}
	}
	
	
	//Method to create a test array
	public BinarySearch(String test, int target) {
		Target = target;
		array.add(10);
		array.add(1);
		array.add(0);
		array.add(4);
		array.add(23);
		array.add(26);
		array.add(7);
		array.add(67);
		array.add(12);
		array.add(78);
	}
	
	
	//Print array before and after the sort
	public void PrintArray() {
		System.out.print("Before sort: ");
		for (int i=0; i<array.size(); i++) {
			System.out.print(array.get(i) + "  ");
		}
		Sort();
		System.out.print("\nAfter sort: ");
		for (int i=0; i<array.size(); i++) {
			System.out.print(array.get(i) + "  ");
		}
	}
	
	
	//Sort method
	public void Sort() {
		getArray().sort(null);
	}
	
	
	//Binary search method
	public void BinarySearch() {
		Head = 0;
		Tail = getArray().size();
		do {
			if (Head < Tail) {							//Check if the 1st point is smaller than the end point
				Midpoint = (Head + Tail)/2;				//Find the midpoint
				FoundNum = getArray().get(Midpoint);	//Get the value at the midpoint
				if (Target != FoundNum) {
					if (Target < FoundNum) {			
						Tail = Midpoint;				//If the target number smaller than the number at midpoint => Shift endpoint to midpoint
					}
					else if (Target > FoundNum) {
						Head = Midpoint+1;				//If the target number larger than the number at midpoint => Shift 1st point to midpoint + 1
					}
				}
				else if (Target == FoundNum){			//If target number = number at midpoint => Found the target!!!
					System.out.println("\nTarget: " + Target + "\nPosition: " + getArray().indexOf(FoundNum));
					break;
				}
			}
			else {
				System.out.println("\nCan't find target (" + Target + ")");			//If none of criteria were met => Can't find the target TmT
				break;
			}
		} while (true);
	}
	
	public ArrayList<Integer> getArray() {
		return array;
	}
}
