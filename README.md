# RSACryptosystem
I re-created the RSA public key cryptosystem in my CSC 590: Selected Topics in Computer Science - Creating and Cracking Secret Codes in spring 2019.

Here are the steps to run the program:
1. Go into bob.java class, and scroll until you find the inputM() method. This is where the user (Bob) can choose any BigInteger message. Feel free to adjust the way you would like.
2. Go into command prompt, and cd into whatever folder you are in where all of the files for the project are located and accessible.
3. javac alice.java
4. java alice > alicesecret.txt
5. Replace the code in alice.java by copying and pasting the code from step2.java . It is slightly different with some parts of the main method commented and uncommented. Essentially, alice.java is originally the same as step1.java. step1.java allows Alice to store her p1 and p2 values into alicesecret.txt file. We will need to access these values later.
6. javac alice.java
7. java alice > alicemande.txt (This step stores Alice's m and e values in a file that Bob can access.)
8. javac bob.java
9. java bob > bobcvalue.txt
10. Replace the code in alice.java by copying and pasting the code from step3.java . step3.java is also slightly different from step1.java and step2.java, and in step3.java, Alice is decrypting Bob’s message by reading the c-value from a file into which Bob inputted his c value. We also refer to the stored p1 and p2 values in alicesecret.txt file, which we use to calculate d and n.
11. javac alice.java
12. java alice
13. Voila! The console should print exactly the message (the number) that Bob encrypted.

NOTE: If you would like to re-run the program, please make sure to replace the code in alice.java with the code in step1.java .
