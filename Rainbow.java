import java.util.Scanner;

/*
* Author: Ew0345
* Version: 1.4
* Update Log:
* 	1.4 - Added ability to skip the choice section w/ command-line args & if you choose to not start, 
		the program will exit without asking for a delay.
*	1.3 - Added ability for user to decide the delay time between color change.
*	1.2 - Separated the screen clear into it's own method and called it before asking to start to clear any previous output.
*	1.1 - Added rerun main method on invalid answer (not yes/no)
*	1.0 - Released
*/

public class Rainbow {
    public static void main(String[] args) {
        try (Scanner a = new Scanner(System.in)) {
            clearScreen();

            String s = "";
            int t = 0;

			if (args.length >= 1) {
            	for (String arg : args) {
            	    if (arg.toLowerCase().contains("skip")) {
            	        s = "y";
            	        t = 500;
            	    } else if (arg.toLowerCase().contains("ep")) {
            	        s = "y";
            	        t = 10;
            	    } else if (arg.toLowerCase().contains("info")) {
						System.out.println("Author: Ew0345\n"
							+"Version: 1.4\n"
							+"Update Log:\n"
							+"1.4 - Added ability to skip the choice section w/ command-line args & if you choose to not start, " 
								+"the program will exit without asking for a delay.\n"
							+"1.3 - Added ability for user to decide the delay time between color change.\n"
							+"1.2 - Separated the screen clear into it's own method and called it before asking to start to clear any previous output.\n"
							+"1.1 - Added rerun main method on invalid answer (not yes/no)"
							+"1.0 - Released"
						);
						System.out.print("Start: ");
						s = a.nextLine();

						if (s.equalsIgnoreCase("y") || s.equalsIgnoreCase("yes")) {
							System.out.print("Delay (ms): ");
							t = a.nextInt();
						}
					}
				}
			} else {
				System.out.print("Start: ");
            	s = a.nextLine();
						
				if (s.equalsIgnoreCase("y") || s.equalsIgnoreCase("yes")) {
					System.out.print("Delay (ms): ");
					t = a.nextInt();
				}
			}
			
			if (s == null || s.isEmpty()) {
				s = "invalid";
				System.out.print("YES/NO only");
				Thread.sleep(1000);
			}

            switch(s.toLowerCase()) {
                case "y":case "yes":
                    clearScreen();
                    
                    boolean b = true;
                    
                    while (b == true) {
                        int rng = (int) Math.floor((Math.random() * 15));
                        int rng2 = (int) Math.floor((Math.random() * 15));

                        while (rng == rng2) {
                            rng = (int) Math.floor((Math.random() * 15));
                            rng2 = (int) Math.floor((Math.random() * 15));
                        }

                        String[] color = {"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f"};

                        new ProcessBuilder("cmd", "/c", "color "+color[rng]+color[rng2]).inheritIO().start();

                        System.out.print(color[rng].toUpperCase()+color[rng2].toUpperCase()+" ");

                        Thread.sleep(t);
                    }
                    break;
            
                case "n":case "no": break;
                
                default: main(args);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void clearScreen() throws Exception {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }
}
