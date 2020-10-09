package funcionalidades.addCarrinho.model;

public class Produto {
	
	public String nomeProduto, pontosProduto, parceiroProduto;
	public int quantidade = 1;
	
	public static int maxPoint = 0;
	
	public Produto(String nomeProduto, String pontosProduto) {
		this.nomeProduto = nomeProduto;
		this.pontosProduto = pontosProduto;
	}

	public static int getMaxPoint() {
		return maxPoint;
	}

	public static void setMaxPoint(int maxPoint) {
		Produto.maxPoint += maxPoint;
	}
	
}
