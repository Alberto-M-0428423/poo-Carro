public class Carro{

	public double tanque;
	public double pessoas;
	public double q;
	public static final double INFINITO = 999999999;
	
	public void abastecer (double valorDaRecarga){
		this.tanque += valorDaRecarga;
		if(this.tanque > 10) this.tanque = 10;
	}
	
	public void embarque (double entpessoas){
		this.pessoas++;
	}
	public void desembarque (double despessoas){
		this.pessoas--;
	}
	public void kilomet (double kilom){
		this.tanque -= (kilom/10);
		this.q += kilom;
	}
	
	}
