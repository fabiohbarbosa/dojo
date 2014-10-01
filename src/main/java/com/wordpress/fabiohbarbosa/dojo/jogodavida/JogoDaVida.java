package com.wordpress.fabiohbarbosa.dojo.jogodavida;

public class JogoDaVida {

	private boolean[][] tabuleiro;
	
	private int totalLinhas;
	private int totalColunas;
	
	public JogoDaVida(int totalLinhas, int totalColunas) {
		this.totalLinhas = totalLinhas;
		this.totalColunas = totalColunas;
		tabuleiro = new boolean[totalLinhas][totalColunas];
	}

	public void adicionarVizinho(int linha, int coluna) {
		tabuleiro[linha][coluna] = true;
	}
	
	protected boolean verificarCelulaViva(int linha, int coluna) {
		int vizinhos = retonarQuantidadeDeVizinhos(linha, coluna);
		
		// Baixa população
		if (vizinhos < 2) {
			return false;
		}
		// Alta população
		if (vizinhos > 3) {
			return false;
		}
		
		if (vizinhos == 2 || vizinhos == 3) {
			return true;
		}
		
		throw new RuntimeException();
		
	}

	protected int retonarQuantidadeDeVizinhos(int linha, int coluna) {
		int vizinhos = 0;
		
		// Esquerda
		if (coluna > 0) {
			if (tabuleiro[linha][coluna - 1]) {
				vizinhos++;
			}
		}

		// Direita
		if (coluna < totalColunas - 1) {
			if (tabuleiro[linha][coluna + 1]) {
				vizinhos++;
			}
		}
		
		// Acima
		if (linha > 0) {
			if (tabuleiro[linha - 1][coluna]) {
				vizinhos++;
			}
		}
		
		// Abaixo
		if (linha < totalLinhas-1) {
			if (tabuleiro[linha + 1][coluna]) {
				vizinhos++;
			}
		}
		
		return vizinhos;
	}

	public boolean movimentarCelula(boolean celula, int linha, int coluna) {
		if (celula == false && retonarQuantidadeDeVizinhos(linha, coluna) == 2) {
			return false;
		}
		return verificarCelulaViva(linha, coluna);
	}

}