import java.util.Scanner;
class CRC_GEN {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the length of data : ");
		int dataLength = scanner.nextInt();
		System.out.println("Enter the length of divisor : ");
		int divisorLength = scanner.nextInt();
		System.out.println("Enter data : ");
		int totalLength = dataLength+divisorLength-1;
		int[] data = new int[totalLength];
		int[] output = new int[totalLength];
		int i;
		for(i=0;i<dataLength;i++) {
			data[i] = scanner.nextInt();
			output[i] = data[i];
		}
		System.out.println("Enter divisor : ");
		int[] divisor = new int[divisorLength];
		for(i=0;i<divisorLength;i++) {
			divisor[i] = scanner.nextInt();
		}
		int count = 0;
		while(count < dataLength) {
			while(data[count] != 1) {
				count++;
			}
			if(count >= dataLength) {
				break;
			}
			for(i = count; i < count + divisorLength; i++) {
				if(data[i] == divisor[i-count]) {
					data[i] = 0;
				}
				else {
					data[i] = 1;
				}
			}
			for(i=0;i<totalLength;i++) {
				System.out.print(data[i]+ " ");
			}
		}
		int j = divisorLength-1;
		for(i=totalLength-1;i>=dataLength;i--) {
			output[i] = data[i];
		}
		System.out.println("OUTPUT");
		for(i=0;i<totalLength;i++) {
			System.out.print(output[i]+ " ");
		}

	}
}