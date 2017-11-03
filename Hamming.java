import java.util.Scanner;
public class Hamming {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the length of codeword : ");
		int length = scanner.nextInt();

		System.out.println("Enter the received message : ");
		int[] data = new int[length];
		for(int i = 0; i < length; i++ ) {
			data[i] = scanner.nextInt();
		} 

		System.out.println("Enter the number of parity bits : ");
		int error_length = scanner.nextInt();

		System.out.println("Enter the parity :\n0. Even\n1. Odd:  ");
		int parity = scanner.nextInt();

		int power = 0;
		int count = 0;
		int j,i;

		int error[] = new int[error_length];
		int error_count = 0;
		
		for(i=0;i<length;i++) {
			if(data[i] == Math.pow(2,power) ) {
				//parity bit spotted
				j = i;
				while(j < length) {
					for(int k = j; k < j+Math.pow(2,power);k++) {
						if(data[k] == 1) count++;	
					}
					j += Math.pow(2,power);
				}
				if(parity == 0) {
					if(count % 2 == 0) {
						error[error_count++] = 0;
					}
					else{
						error[error_count++] = 1;
					}
				} 
				else if(parity == 1) {
					if(count % 2 == 1) {
						error[error_count++] = 0;
					}
					else{
						error[error_count++] = 1;
					}
				}
			}
			power++;			
		}
		for(i=0;i<error_length;i++) {
			System.out.println(error[i]);
		}
	}
}