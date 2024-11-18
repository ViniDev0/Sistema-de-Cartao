package cartaoConsumo;

public class CartaoConsumo {
	private String nrCartao;
	private	String chavePix;
	private char tipoParticipacao;
	private char status;
	private double valorCredito;
	private double consumoAlimento;
	private double consumoBebida;
	
	public CartaoConsumo(String nrCartao, String chavePix, char tipoParticipacao) {
		this.nrCartao = nrCartao;
		this.chavePix = chavePix;
		this.tipoParticipacao = tipoParticipacao;
		this.status = 'A';
		this.valorCredito = 50.00;
	}

	public char getTipoParticipacao() {
		return tipoParticipacao;
	}

	public void setTipoParticipacao(char tipoParticipacao) {
		this.tipoParticipacao = tipoParticipacao;
	}

	public double getValorCredito() {
		return valorCredito;
	}

	public void setValorCredito(double valorCredito) {
		this.valorCredito = valorCredito;
	}

	public String getNrCartao() {
		return nrCartao;
	}

	public String getChavePix() {
		return chavePix;
	}

	public char getStatus() {
		return status;
	}

	public double getConsumoAlimento() {
		return consumoAlimento;
	}

	public double getConsumoBebida() {
		return consumoBebida;
	}
	
	public void carga(double valor) {
		this.valorCredito += valor;
	}
	
	public boolean consumoAlimento(double pesoEmGramas) {
		final double CONVERSOR = 1000;
		final double CONVERSORPRECOCLIENTE = 49.00;
		final double CONVERSORPRECOFORNECEDOR = 39.00;
		double calculoEmQuilo;
		double calculoDoValor;
		
		calculoEmQuilo = pesoEmGramas / CONVERSOR;
		
		if (this.tipoParticipacao == 'C') {
			calculoDoValor = calculoEmQuilo * CONVERSORPRECOCLIENTE;
		} else {
			calculoDoValor = calculoEmQuilo * CONVERSORPRECOFORNECEDOR;
		}
		
		if (this.valorCredito >= calculoDoValor) {
			this.consumoAlimento += calculoDoValor;
			return true;
		}
		return false;
	}
	public boolean consumoBebida (double valor) {
		if (this.valorCredito >= valor) {
			this.consumoBebida += valor;
			return true;
		}
		return false;
	}
	public double fecharConta() {
		double consumacaoMinima = 25;
		double juncaoDeValores;
		double troco;
		this.status = 'E';
		
		juncaoDeValores = this.consumoAlimento + this.consumoBebida;
		
		if (juncaoDeValores <= consumacaoMinima) {
			return consumacaoMinima;
		}
		troco = this.valorCredito - juncaoDeValores;
		return troco;
	}
	
}
