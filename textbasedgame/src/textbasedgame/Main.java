package textbasedgame;

import java.util.Random;
import java.util.Scanner;

public class Main {
public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	Random rand = new Random();
	
	String[] inamici = {"Fantoma lui Dan Balan", "Stefan Banica Jr", "Horia Brenciu", "Herobrine", "Fanii BTS"};
	int viataMaximaAInamicilor = 70;
	int stangaInamicilor = 25;
	
	int hpulNostru = 100;
	int stangaNoastra = 40;
	int nrDePotiuni = 3;
	int hpPotiune = 30;
	int cadouPotiune = 50;
	
	
	boolean running = true;
	
	System.out.println("Salut calatorule");
	
	JOCUL:
	while(running) {
		System.out.println("----------------------------------------------");
		
		int viataInamicilor = rand.nextInt(viataMaximaAInamicilor);
		String inamic = inamici[rand.nextInt(inamici.length)];
		System.out.println("\t#" + inamic + " apare! #\n");
			
			while (viataInamicilor > 0) {
				System.out.println("\tHP-ul tau: " + hpulNostru);
				System.out.println("\t" + inamic + " are HP-ul: " + viataInamicilor);
				System.out.println("\n\t Ce decizie vei lua?");
				System.out.println("\t1. BATAE");
				System.out.println("\t2. Be cu mine");
				System.out.println("\t3. RUUUUUUUUUUNN");
				
				String input = in.nextLine();
				if(input.equals("1")) {
					int dmgDat = rand.nextInt(stangaNoastra);
					int dmgPrimit = rand.nextInt(stangaInamicilor);
					
					viataInamicilor -= dmgDat;
					hpulNostru -= dmgPrimit;
					
					System.out.println("\t> I-ai aplicat o corectie lui " + inamic + " lasandu-l fara " + dmgDat + " HP.");
					System.out.println("\t> Dupa palma pe care ai primit-o de la inamic ai pierdut " + dmgPrimit + " HP.");
					
					if(hpulNostru < 1) {
						System.out.println("Te-au facut muci :(");
						break;
					}
					
				}else if(input.equals("2")) {
					if (nrDePotiuni > 0) {
						hpulNostru += hpPotiune;
						nrDePotiuni--;
						System.out.println("\t> Ai baut apa de izvor, ai primit " +  hpPotiune + " HP."
								         + "\n\t> Ai acum " + hpulNostru + " HP."
								         + "\n\t> Ai ramas cu " + nrDePotiuni + " potiuni.\n");
						
					}else {
						System.out.println("\t> Nu mai ai potiuni. Poate iti pica dupa ce bati un inamic.");
					}
				}else if(input.equals("3")) {
					System.out.println("\tAi fugit de " + inamic + ".");
					continue JOCUL;
				}else {
					System.out.println("\tNu merge.");
				}
			}
			if(hpulNostru < 1) {
				System.out.println("Esti prea slabit, pleaca pentru un moment.");
				break;
			}
			System.out.println("----------------------------------------------");
			System.out.println(" # " + inamic + " a fost invins. #");
			System.out.println(" # Ai ramas cu " + hpulNostru + " HP. # ");
			if(rand.nextInt(100) < cadouPotiune) {
				nrDePotiuni++;
				System.out.println(" # " + inamic + " a dropat o potiune. # ");
				System.out.println(" # Ai acum " + nrDePotiuni + "potiuni. # ");
			}
			System.out.println("----------------------------------------------");	
			System.out.println("Ce vrei sa faci acum?");
			System.out.println("1. Continua sa lupti.");
			System.out.println("2. Gata cu aventura.");
			
			String input = in.nextLine();
			
			while(!input.equals("1") && !input.equals("2")) {
				System.out.println("Nu merge.");
				input = in.nextLine();
			}
			if(input.equals("1")) {
				System.out.println("Continua aventura, strigati ura!");
				
			}else if(input.equals("2")) {
				System.out.println("Ai parasit aventura.");
				break;
			}
			
	}
	
	System.out.println("##########################");
	System.out.println("#MERSI PENTRU CA AI JUCAT#");
	System.out.println("##########################");
}
}
