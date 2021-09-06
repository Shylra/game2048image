package fr.shylra.game2048image;

import java.util.Random;

public class Grille {
	int[][] map = new int [4][4];
	
	Grille() {
		int a;
		int b;
		int k = 0;
		Random random = new Random();
		
		a = random.nextInt(16);
		do {
			b = random.nextInt(16);
		} while (a == b);
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (k == a || k == b) {
					this.map[i][j] = 2;
				}
				k++;
			}
		}
	}
	
	public boolean IsOver() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (this.map[i][j] == 0) {
					return (false);
				}
			}
		}
		return(true);
	}
	
	public void Next() {
		int a;
		int b;
		int i;
		int j;
		boolean done = false;
		Random random = new Random();
		b = random.nextInt(10);
		while (!done) {
			a = random.nextInt(16);
			i = a / 4;
			j = a % 4;
			if (this.map[i][j] == 0) {
				if (b == 0) {
					this.map[i][j] = 4;
				} else {
					this.map[i][j] = 2;
				}
				done = true;
			}
		}
	}
	
	public boolean bas() {
		boolean change = false;
		int l;
		for (int i = 3; i >= 0; i--) {
			for (int j = 0; j < 4; j++) {
				if (this.map[i][j] != 0 && i > 0) {
					for (int k = i-1; k >= 0; k--) {
						if (this.map[k][j] != 0) {
							if (this.map[i][j] == this.map[k][j]) {
								this.map[i][j] *= 2;
								this.map[k][j] = 0;
								change = true;
							}
							k = -1;
						}
					}
				}
			}
		}
		for (int i = 3; i >= 0; i--) {
			for (int j = 0; j < 4; j++) {
				l = i;
				if (this.map[i][j] != 0) {
					for (int k = i+1; k < 4; k++) {
						if (this.map[k][j] == 0) {
							this.map[k][j] = this.map[l][j];
							this.map[l][j] = 0;
							l = k;
							change = true;
						}
					}
				}
			}
		}
		return (change);
	}
	
	public boolean gauche() {
		boolean change = false;
		int l;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (this.map[i][j] != 0 && j < 3) {
					for (int k = j+1; k < 4; k++) {
						if (this.map[i][k] != 0) {
							if (this.map[i][j] == this.map[i][k]) {
								this.map[i][j] *= 2;
								this.map[i][k] = 0;
								change = true;
							}
							k = 4;
						}
					}
				}
			}
		}
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				l = j;
				if (this.map[i][j] != 0) {
					for (int k = j-1; k >= 0; k--) {
						if (this.map[i][k] == 0) {
							this.map[i][k] = this.map[i][l];
							this.map[i][l] = 0;
							l = k;
							change = true;
						}
					}
				}
			}
		}
		return (change);
	}
	
	public boolean droite() {
		boolean change = false;
		int l;
		for (int i = 0; i < 4; i++) {
			for (int j = 3; j >= 0; j--) {
				if (this.map[i][j] != 0 && j > 0) {
					for (int k = j-1; k >= 0; k--) {
						if (this.map[i][k] != 0) {
							if (this.map[i][j] == this.map[i][k]) {
								this.map[i][j] *= 2;
								this.map[i][k] = 0;
								change = true;
							}
							k = -1;
						}
					}
				}
			}
		}
		for (int i = 0; i < 4; i++) {
			for (int j = 3; j >= 0; j--) {
				l = j;
				if (this.map[i][j] != 0) {
					for (int k = j+1; k < 4; k++) {
						if (this.map[i][k] == 0) {
							this.map[i][k] = this.map[i][l];
							this.map[i][l] = 0;
							l = k;
							change = true;
						}
					}
				}
			}
		}
		return (change);
	}
	
	public boolean haut() {
		boolean change = false;
		int l;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (this.map[i][j] != 0 && i < 3) {
					for (int k = i+1; k < 4; k++) {
						if (this.map[k][j] != 0) {
							if (this.map[i][j] == this.map[k][j]) {
								this.map[i][j] *= 2;
								this.map[k][j] = 0;
								change = true;
							}
							k = 4;
						}
					}
				}
			}
		}
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				l = i;
				if (this.map[i][j] != 0) {
					for (int k = i-1; k >= 0; k--) {
						if (this.map[k][j] == 0) {
							this.map[k][j] = this.map[l][j];
							this.map[l][j] = 0;
							l = k;
							change = true;
						}
					}
				}
			}
		}
		return (change);
	}
}

