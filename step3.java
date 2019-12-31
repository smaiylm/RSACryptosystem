

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

public class alice {
	
	
	
	public static void main(String[] args) throws FileNotFoundException {
		
		/*
		BigInteger currentn = new BigInteger("0");//COMMENT AFTER RAN FIRST ROUND
		BigInteger currentp1 = new BigInteger("0");//store p1, COMMENT AFTER RAN FIRST ROUND
		BigInteger currentp2 = new BigInteger("0");//store p2, COMMENT AFTER RAN FIRST ROUND
		
		currentp1 = generatep1();//COMMENT AFTER RAN FIRST ROUND
	    currentp2 = generatep2();//COMMENT AFTER RAN FIRST ROUND
		
	    System.out.println(currentp1);//FIRST TIME RUN: REDIRECT THESE TO alicesecret.txt
	    System.out.println(currentp2);//FIRST TIME RUN: REDIRECT THESE TO alicesecret.txt


*/
		//!!!
		//THE FOLLOWING BELOW CAN BE CALLED FROM THE FILE WHERE WE STORED p1 and p2. SECOND ROUND STARTS BELOW. COMMENT ALL OF FIRST ROUND BEFORE STARTING.
	    //!!!
		
		
	    /*
	    
	    Scanner readalicesecret = new Scanner(System.in); //SECOND ROUND
	    String alicesecretfile = "alicesecret.txt";//SECOND ROUND
	    
	    Scanner readalicesecretfile = new Scanner(new File(alicesecretfile));//SECOND ROUND
	    
	    BigInteger currentp1 = new BigInteger("0");//SECOND ROUND
	    BigInteger currentp2 = new BigInteger("0");//SECOND ROUND
	    BigInteger currentn = new BigInteger("0");//SECOND ROUND
	    
	    currentp1 = readalicesecretfile.nextBigInteger();//read the first stored p1, //SECOND ROUND
	    currentp2 = readalicesecretfile.nextBigInteger();//read the second stored p2, //SECOND ROUND
	    
	    
		
		currentn = calculateN(currentp1, currentp2); //store the n-value. //SECOND ROUND
		
		
		
		System.out.println(currentn);//print out N. //SECOND ROUND
		System.out.println(pickE());//always the same. //SECOND ROUND
		//output these into aliceeandn.txt : ls > aliceeandn.txt
		*/
		
		//!!!
		//Chunk of code that needs to be done after c-value is received from Bob: THIRD ROUND IS EVERYTHING BELOW.
		//!!!
		
	
	    String alicesecretfile = "alicesecret.txt";//THIRD ROUND. Read the secret file again.
	    
	    Scanner readalicesecretfile = new Scanner(new File(alicesecretfile));//THIRD ROUND
	    
	    BigInteger currentp1 = new BigInteger("0");//THIRD ROUND
	    BigInteger currentp2 = new BigInteger("0");//THIRD ROUND
	    BigInteger currentn = new BigInteger("0");//THIRD ROUND
	    
	    currentp1 = readalicesecretfile.nextBigInteger();//read the first stored p1, //THIRD ROUND
	    currentp2 = readalicesecretfile.nextBigInteger();//read the second stored p2, //THIRD ROUND
	    
	    currentn = calculateN(currentp1, currentp2); //THIRD ROUND. Store n.THIRD ROUND
	    
	    BigInteger currentphin = new BigInteger("0");//THIRD ROUND
	    
	    currentphin = findphi(currentp1, currentp2);//find phin using the stored secret p1 and p2 values. THIRD ROUND.
	   
	    
	
		
		String file = "bobcvalue.txt";//file that contains Bob's c value.//THIRD ROUND
		
		Scanner scanner = new Scanner(new File(file));//THIRD ROUND
		
		BigInteger c = new BigInteger("0");//THIRD ROUND
		
		c = scanner.nextBigInteger();//scan the first thing from the bobcvalue.txt file - the c-value.Store it.//THIRD ROUND
		
		BigInteger currentd = new BigInteger("0");//THIRD ROUND
		currentd = calculatekeyD(currentphin, pickE());//storing the d-value. E is always the same so we didn't need to store it.//THIRD ROUND
		
		
		
		System.out.println(decrypt(c, currentd, currentn));//THIRD ROUND
		
		
	}
	
	
	/*public static void main(String[]args)
		{
	
//	BigInteger n = new BigInteger(Integer.parseInt(args[0]));  //get N - n should be large


		BigInteger p1 = BigInteger.probablePrime(512, new Random());//generate the first prime

		BigInteger p2 = BigInteger.probablePrime(512, new Random());//generate the second prime
	
	//"probably" returns a prime number. This time, we print a 256-bit number (2^256 digits long)
	//"probable" because when we have a really large number, we don't have time or enough storage to find if it is REALLY prime.
	

		}	
	
	*/
	
	private static BigInteger generatep1(){
		//P1 and P2 has to be PRIVATE.
		
		BigInteger p1 = BigInteger.probablePrime(512, new Random());
		
		return p1;
		
	}
	
	private static BigInteger generatep2(){
		//P1 and P2 has to be PRIVATE.
		
		BigInteger p2 = BigInteger.probablePrime(512, new Random());
		
		return p2;
		
	}
	
	
	
	
	
	public static BigInteger calculateN(BigInteger p1, BigInteger p2){//PUBLIC. everything that is not "PUBLIC" is private.
		
		BigInteger n = new BigInteger("0");
		
		n = p1.multiply(p2);
		
		return n;
		
		
		
	}
	
	
	
	private static BigInteger findphi(BigInteger p1, BigInteger p2)
	{
	
		/*ArrayList<Integer> factorization = new ArrayList<Integer>();
		int phi = 0; 
		//factorization = n.primeFactors();//HOW TO CALL THIS METHOD?
		for(int i =0; i<factorization.size();i++) {
			
			if(i == 0) {
				
				phi = factorization.get(0) - 1;
			}
			
			if(i != 0) {
				
				phi = phi * (factorization.get(i) - 1);
			}
			
		}*/
		
		BigInteger phin = new BigInteger("0");
		
		BigInteger one = new BigInteger("1");
		
		phin = (p1.subtract(one)).multiply(p2.subtract(one));
		
		return phin;
		
		
	}
	

	
	
	
	public static BigInteger pickE(){//Alice then picks a small exponent e - MUST BE ODD. Can we let it be prime then? PUBLIC.
		
		BigInteger e = new BigInteger ("65537");		
		return e;//good E value
		
		/*
		int p = (int) (Math.random() * 50) ;//we can choose a prime number
		int e = 0;
		
		if (p%2 == 0) {
		
			e = p-1;
				
		}
		
		else {
			e = p;
		}
		
		return e;
		
		*/
		
		
	}
	
	
	//you can SKIP THIS WHOLE STEP if u want to use modinverse. For modinverse, you use phi(n) and e.
	//mod
	
	
	/*//WE DO NOT NEED K since modInverse already chooses a k value implicitly such that the equation is satisfied.
	private static BigInteger pickK(int phin){//Alice then picks a small exponent e - MUST BE ODD. Can we let it be prime then?
		
		
		//pick a k such that (k * phi(n) + 1 / e )
		
		
		//ed is coprime with phi(n)
		
		
		
		BigInteger k = BigInteger.probablePrime(4, new Random());//we can choose a prime number
		
		
		return k;
		
		
		
		
	}
	
	*/
	
	//d = e.modInverse(phiN)
	
	
	private static BigInteger calculatekeyD(BigInteger phin, BigInteger e) {//Alice's private key
		BigInteger d = new BigInteger("0");
		/*BigInteger d = new BigInteger("0");
		
		BigInteger one = new BigInteger("1");
		
		d = ((k.multiply(phin)).add(one)).divide(e);
		*/
		
		d = e.modInverse(phin);
	
		return d;
	}
	
	
	public static BigInteger receiveC(BigInteger c) {// c is called from Bob Class. C is the "lock" done by Bob (m^e mod n)
		
		BigInteger AliceC = new BigInteger("1");
		
		AliceC = c;
		
		return AliceC;
		
		
	}
	
	
	public static BigInteger decrypt(BigInteger c, BigInteger d, BigInteger n)//c^d mod n - After receiving c, Alice decrypts bob's message using her private key, d.
	{
		BigInteger decrypted = new BigInteger("0");
		decrypted = (c.modPow(d,n));//should equal to m - check if it is.
		
		return decrypted;
	}
	
	//Eve only has c, n, and e. Eve can only calculate d if she calculates phi(n), which requires the knowledge of prime factorization of m.


}
