import java.util.Scanner;
class Checksum {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the length of data array : ");
		int dataLength = scanner.nextInt();
		System.out.println("Enter size of each element : ");
		int elementLength = scanner.nextInt();
		int[] element1 = new int[elementLength];
		int[] element2 = new int[elementLength];
		System.out.println("Enter the element : " + 0);
		int i;
		for(i=0;i<elementLength;i++) {
			element1[i] = scanner.nextInt();
		}
		int j;
		int carry = 0;
		for(j=1;j<dataLength;j++) {
			System.out.println("Enter the element : " + j);
			for(i=0;i<elementLength;i++) {
				element2[i] = scanner.nextInt();
			}	
			for(i=elementLength-1;i>=0;i--) {
				int temp = (element1[i] + element2[i] +carry)%2;
				if(element1[i] == 1 &&  element2[i] == 1) {
					carry = 1;
				}
				else {
					carry = 0;
				}
				element1[i] = temp;
			}
			if(carry == 1) {

				for(i=elementLength-1;i>=0;i--) {
					int temp = (element1[i] + carry)%2;
					if(element1[i] == 1 &&  carry == 1) {
						carry = 1;
					}
					else {
						carry = 0;
					}
					element1[i] = temp;
				}
			}
		}
		System.out.println("Checksum : ");
		for(i=0;i<elementLength;i++) {
			if(element1[i] == 1) element1[i] = 0;
			else element1[i] = 1;
			System.out.print(element1[i] + " ");
		}
		System.out.println();
	}
}