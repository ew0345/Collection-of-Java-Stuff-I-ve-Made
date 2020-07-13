import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class StringGenV3_2 {
	public static void main(String[] args) {
		String[] rand_c = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","0","1","2","3","4","5","6","7","8","9","`","~","!","@","#","$","%","^","&","*","(",")","-","_","=","+","[","{","]","}",";",":","\'","\"",",","<",".",">","/","?","\\","|"};
		

		try (Scanner in = new Scanner(System.in)) {
			System.out.print("\nWrite Strings to file: ");
			String answer = in.nextLine();

			System.out.print("Amount of Strings to Generate: ");
			int amount = in.nextInt();

			System.out.print("String Length: ");
			int slength = in.nextInt();

			System.out.print("Letters Only (1), Letters and Numbers (2), All (3): ");
			int type = in.nextInt();
			
			System.out.print("\n");

			switch (answer.toLowerCase()) {
				case "yes":case "y":case "true":case "t":case "1":
					if (type != 1 && type != 2 && type != 3) {
						System.out.println("Defaulted to mode: All");
					}
					File file = new File(System.getProperty("user.home")+"/Desktop/RandomStrings.txt");
					if (!file.exists()) file.createNewFile();
					BufferedWriter bw = new BufferedWriter(new FileWriter(file.getAbsolutePath()));
					for (int i = 0; i < amount; i++) {
						bw.write("String "+(i+1)+": ");
						System.out.print("String "+(i+1)+": ");
						for (int ff = 0; ff < slength; ff++) {
							if (type == 3) {
								int r = (int) Math.floor((Math.random()*94));
								System.out.print(""+rand_c[r]);
								bw.write(""+rand_c[r]);
							} else if (type == 2) {
								int r = (int) Math.floor((Math.random()*57));
								System.out.print(""+rand_c[r]);
								bw.write(""+rand_c[r]);
							} else if (type == 1) {
								int r = (int) Math.floor((Math.random()*47));
								System.out.print(""+rand_c[r]);
								bw.write(""+rand_c[r]);
							} else {
								int r = (int) Math.floor((Math.random()*94));
								System.out.print(""+rand_c[r]);
								bw.write(""+rand_c[r]);
							}
						}
						System.out.print("\n");
						bw.newLine();
					}
					bw.close();
					System.out.println("Written Strings to File: "+file);
					break;

				case "no":case "n":case "false":case "f":case "0":
					if (type != 1 && type != 2 && type != 3) {
						System.out.println("Defaulted to mode: All");
					}
					for (int i = 0; i < amount; i++) {
						System.out.print("String "+(i+1)+": ");
						for (int ff = 0; ff < slength; ff++) {
							if (type == 3) {
								System.out.print(""+rand_c[(int) Math.floor((Math.random()*94))]);
							} else if (type == 2) {
								System.out.print(""+rand_c[(int) Math.floor((Math.random()*57))]);
							} else if (type == 1) {
								System.out.print(""+rand_c[(int) Math.floor((Math.random()*47))]);
							} else {
								System.out.print(""+rand_c[(int) Math.floor((Math.random()*94))]);
							}
						}
						System.out.print("\n");
					}
					break;

				default:
					System.out.println("Invalid Choice.");
					main(args);
					break;
			}
			System.out.print("\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}