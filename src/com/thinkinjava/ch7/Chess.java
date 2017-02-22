package com.thinkinjava.ch7;

class Game {
	public Game() {
		System.out.println("Game无参");
	}
	
	public Game(int i) {
		System.out.println("Game有参");
	}
}

class BoardGame extends Game {
	public BoardGame() {
		System.out.println("BoardGame无参");
	}
	
	public BoardGame(int i) {
		super(i);
		System.out.println("BoardGame有参");
	}
}

public class Chess extends BoardGame {
	public Chess() {
		super(11);
		System.out.println("Chess无参");
	}
	public static void main(String[] args) {
		Chess xChess = new Chess();
	}
}


