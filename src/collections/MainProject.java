package collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainProject {
	static Scanner sc = new Scanner(System.in);
	static Logger log = LoggerFactory.getLogger(MainProject.class);

	public static void main(String[] args) {

		primoEsercizio();

		boolean uscitaSecondoEsercioA = false;
		do {
			try {

				System.out.println("Inserire un numero di numeri casuali da voler creare (Max 20 - '0' -> per uscire)");
				int n = Integer.parseInt(sc.nextLine());
				if (n >= 1 && n <= 20) {
					
					List <Integer> listaDue=secondoEsercizioA(n);
					//Primo array:
					/*for(int s=0;s<listaDue.size();s++){
						System.out.println(s+" : " + listaDue.get(s));
					}*/
					List <Integer> listaTre =secondoEsercizioB(listaDue);
					System.out.println("Secondo array: " +secondoEsercizioB(listaDue));
					System.out.println("Vuoi procedere con il terzo esercizio? ('s' -> per procedere)");
					String r=sc.nextLine();
					if(r.equals("s")){
						System.out.println("Vuoi vedere i numeri casuali di posizione pari o dispari?\n('p' -> per Pari - 'd' -> per Dispari)");
						String scelta=sc.nextLine();
						if(scelta.equals("p")){
							secondoEsercizioC(listaTre,true);
						}else if(scelta.equals("d")){
							secondoEsercizioC(listaTre,false);
						}
					}

				} else if (n == 0) {
					System.out.println("Grazie per aver utilizzato il sistema di generazione di numeri casuali");
					uscitaSecondoEsercioA = true;
				}
			} catch (NumberFormatException e) {
				log.error(" ERRORE! Valore inserito sbagliato digitare un numero");
			} catch (Exception e) {
				log.error("ERRORE!!" + e);
			}
		} while (!uscitaSecondoEsercioA);

	}

	public static void primoEsercizio() {

		boolean uscita = false;
		do {
			try {
				System.out.println("Digita quanti elementi vuoi inserire ( Max '10' | '0' -> per uscire)");
				int n = Integer.parseInt(sc.nextLine());
				if (n >= 1 && n <= 10) {
					Set<String> insiemeParole = new HashSet<>();
					List<String> listaDuplicati = new ArrayList<String>();
					List<String> listaDistinte = new ArrayList<String>();
					for (int i = 0; i < n; i++) {
						System.out.println("Digita la " + (i + 1) + "º parola");
						String parola = sc.nextLine();
						boolean verifica = insiemeParole.contains(parola);
						insiemeParole.add(parola);
						if (verifica) {
							listaDuplicati.add(parola);
						} else {
							listaDistinte.add(parola);
						}
						if (i == n - 1) {
							System.out.println("Ecco la lista di parole duplicate:");
							for (int h = 0; h < listaDuplicati.size(); h++) {
								if (h == listaDuplicati.size() - 1) {
									System.out.println(listaDuplicati.get(h));
								} else {
									System.out.println(listaDuplicati.get(h));
								}
							}
							System.out.println("Ecco la lista di parole distinte:");
							for (int s = 0; s < listaDistinte.size(); s++) {
								for (int h = 0; h < listaDuplicati.size(); h++) {
									if (listaDistinte.get(s).contains(listaDuplicati.get(h))) {
										listaDistinte.remove(s);
									}
								}
								if (s == listaDistinte.size() - 1) {
									System.out.println(listaDistinte.get(s));
								} else {
									System.out.println(listaDistinte.get(s));
								}
							}
						}
					}
				} else if (n == 0) {
					System.out.println("Grazie per aver utilizzato il nostro sistema di controllo duplicazioni");
					uscita = true;
				}
			} catch (NumberFormatException e) {
				log.error(" ERRORE! Valore inserito sbagliato digitare un numero");
			} catch (Exception e) {
				log.error("ERRORE!");
			}
		} while (!uscita);
	}

	public static List<Integer> secondoEsercizioA(int numero) {
		 List<Integer> listaNumeriCasuali = new ArrayList<Integer>();
		for (int i = 0; i < numero; i++) {
			int numeroCasuale = (int) (Math.random() * 100);
			listaNumeriCasuali.add(numeroCasuale);
		}
		 listaNumeriCasuali.sort(null);
		return listaNumeriCasuali;
	}

	public static List<Integer> secondoEsercizioB(List<Integer> arr){
		List<Integer> listaOrdinata= new ArrayList<Integer>();
		for (int i = 0; i < arr.size(); i++) {
			//System.out.println(arr.get(i));
			listaOrdinata.add(arr.get(i));
		}
		for(int j=arr.size()-1;j>=0;j--){
			listaOrdinata.add(arr.get(j));
		}
		return listaOrdinata;
	}

	public static void secondoEsercizioC(List<Integer> arrayInteri,boolean c){
		if(c){
			System.out.println("Ecco l'elenco dei numeri in posizone pari: ");
			for(int i=0;i<arrayInteri.size();i++){
				
				if(i%2==0 && !(i==arrayInteri.size()-2)  ){
					System.out.print(arrayInteri.get(i+1)+" , ");
				}
				 if(i%2==0 && i==arrayInteri.size()-2){
					System.out.println(arrayInteri.get(i+1));
				}
			}
		}else if(!c){
			System.out.println("Ecco l'elenco dei numeri in posizone dispari: ");
			for(int h=0;h<arrayInteri.size();h++){
				if(h%2!=0 && !(h==arrayInteri.size()-1 )){
					System.out.print(arrayInteri.get(h-1)+" , ");
				}
				if(h%2!=0 && h==arrayInteri.size()-1 ){
					System.out.println(arrayInteri.get(h-1));
				}
			}
		}
	}
}
