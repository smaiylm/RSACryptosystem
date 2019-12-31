

import java.io.File;
import java.io.FileNotFoundException;
//import java.io.File;
import java.math.BigInteger;
import java.util.Scanner;

public class bob {
	
	//does m need to be the computer input?
	public static void main(String args[]) throws FileNotFoundException{//bob should read input from the text file alicemandn.txt: sort < alicemandn.txt
		
		
		
		
		Scanner read = new Scanner(System.in);
		
		String file = "alicemande.txt"; //read from alicemandn
		
		Scanner scan = new Scanner(new File(file));
		
		//BigInteger mvalue = new BigInteger(args[0]);
		
		BigInteger mvalue = inputM();//input changes based on what user wants to change
	
		//int m = Integer.parseInt(args[0]);//message can be an integer. Doesn't have to be a BigInt
		
		//c is calculated. C should be sent back to Alice.
		BigInteger nvalue = new BigInteger("0"); 
		
		nvalue = scan.nextBigInteger();//reading from the file that Alice outputted to.
				
		BigInteger evalue = scan.nextBigInteger();//reading from the file that Alice outputted to.
		
		
		
		System.out.println(calculateLock(mvalue,nvalue,evalue));//redirect the output to bobcvalue.txt. 
		
		//Final COMMAND LINE INSTRUCTION: java bob sort < alicemandn.txt ls > bobcvalue.txt
		
		
		
		
		
	}
	
	
	private static BigInteger inputM() {//private so that no party can see it except Bob
		
		BigInteger m = new BigInteger("962"); //CHANGE THIS TO WHATEVER YOU'D LIKE 
		
		
		return m;
	}
	
	
	/*public static BigInteger makeM(int m){
		
		BigInteger bobM = new BigInteger("0");
		
		bobM = m;
		
	}
	
	*/
	public static BigInteger receiveN(BigInteger n){//n is called from Alice's class.
		
		BigInteger bobN = new BigInteger("1");
		
		bobN = n;
		
		return bobN;
		
		

	}
	
	
	public static int receiveE(int e) {// e is called from Alice's class.
		
		int bobE = 1;
		
		bobE = e;
		
		return bobE;
		
	}
	
	
	
	
	public static BigInteger calculateLock(BigInteger m, BigInteger bobN, BigInteger bobE) {//E must be an integer! the lock, C, will be sent back to Alice.
		
		BigInteger c = new BigInteger("0");
		
		c = (m.modPow(bobE, bobN));//bobE is the power and bobN is the mod.
		
		return c;
		//calculate m^e mod n
	}
	
	//PRINT OUT 
	//submit instructions
	
	//you need 
	
	

}

