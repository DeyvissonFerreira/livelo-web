package funcionalidades.addCarrinho.model;

import java.util.Locale;

public class Produto {
	
	public String nomeProduto, pontosProduto, parceiroProduto;
	public int quantidade = 1;
	
	public static int maxPoint = 0;
	
	public Produto(String nomeProduto, String pontosProduto) {
		this.nomeProduto = nomeProduto;
		this.pontosProduto = pontosProduto;
	}

	public static String getMaxPoint() {
		return String.format(new Locale("pt"), "%,d", maxPoint).concat(" Pontos");
	}

	public static void setMaxPoint(int maxPoint) {
		Produto.maxPoint += maxPoint;
	}
}