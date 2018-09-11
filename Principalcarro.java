import java.util.Scanner;

public class Principalcarro{

	public static Scanner sc = new Scanner(System.in);
	public static void main(String args[]){
	
		String help = "\t================help============\n"+
					  "\tabastecer _a\n"+
					  "\testado\n"+
					  "\tembarque _a\n"+
					  "\tdesembarque _a\n"+
					  "\tandar _a\n"+
					  "\t==================================";
		Carro car = new Carro();
		car.tanque = 0;
		car.pessoas = 0;
		car.q = 0;
		while(true){
			System.out.print("Digite um comando"+
						"(help para ver os comandos): ");
			String comando = sc.nextLine();
			if(comando.equals("help")){
				System.out.println(help);
			} else if(comando.equals("sair")){
				System.out.println("\tAté a próxima :)");
				break;
			} else {
				String c[] =comando.split(" ");
				
				switch(c[0]){
					case "abastecer":
						double valorDaRecarga = Integer.parseInt(c[1]);
						car.abastecer(valorDaRecarga);
						System.out.println("\tAbastecimento efetuado com sucesso!");
						break;
					case "estado":
						System.out.print("\tTanque: "+car.tanque+"\n"+
									"\tPessoas: "+car.pessoas+"\n"+
									"\tKilometragem: "+car.q);
						break;
					case "embarque":
						double entpessoas = Integer.parseInt(c[1]);
						if (entpessoas > 1){
							System.out.println("O máximo é 1 por vez");
						} else if ((entpessoas == 1) && (car.pessoas == 2)) {
							System.out.println("O carro tá cheio");
						} else {
							car.embarque(entpessoas);
							System.out.println("Embarque efetuado com sucesso");
						}
						break;
					case "desembarque":
						double despessoas = Integer.parseInt(c[1]);
						if ((despessoas == 0) && (despessoas > 0)){
							System.out.println("Não tem ninguém no carro");
						} else if (despessoas > 1){
							System.out.println("O máximo de desembarque é 1 por vez");
							
						} else {
							car.desembarque(despessoas);
							System.out.println("Desembarque efetuado com sucesso");
						}case "andar":
							double kilom = Integer.parseInt(c[1]);
							if (((kilom > 0) && (car.tanque == 0)) || ((kilom > 0) && (car.pessoas == 0))){
								if ((kilom > 0) && (car.tanque == 0)){
									System.out.println("O carro está sem combustível");
								}
								if ((kilom > 0) && (car.pessoas == 0)){
									System.out.println("O carro está vazio");
								}	
								break;
							}
							else if (kilom/10 > car.tanque){
								System.out.println("O carro não tem combustível suficiente");
							}
							else {
								car.kilomet(kilom);
								System.out.println("Kilometragem: "+car.q+"\n"+
								"Tanque: "+car.tanque);
							}
						break;
					default:
						System.out.println("\tComando inválido.");
				}
			}
			
			}
	
		}
	}

