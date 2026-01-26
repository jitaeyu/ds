package com.ktdsuniversty.edu.relaygame;

import java.util.Scanner;

public class RelayGame {
	private Scanner keyboard;
	private String startWord;
	private String nextWord;
	
	public RelayGame() {

		this.keyboard = new Scanner(System.in);
	}
	public void startGame() {
		System.out.println("게임시작");
		System.out.println("시작단어입력");
		this.startWord=this.keyboard.nextLine();
		
		String lastLetter="";
		String firstLetter="";
		while(true) {
			System.out.println("다음단어입력");
			this.nextWord = this.keyboard.nextLine();
			this.nextWord=nextWord.trim();//앞뒤공백제거 이후할당
			
			//시작단어의 마지막글자 추출
			lastLetter = this.startWord.charAt(this.nextWord.length()-1)+"";// 마지막글자반환
			//다음단어의 첫번째글자
			firstLetter = this.nextWord.substring(0,1);
			
			if(lastLetter.equals(firstLetter)) {
				if(this.nextWord.length()>=3) {
					this.startWord = this.nextWord;
				}else {
					System.err.println("게임 종료");
					break;
				}
			}else {
				System.err.println("게임 종료");
				break;
			}
		}
		
		
		
	}
	
	public static void main(String[] args) {
		RelayGame game = new RelayGame();
		game.startGame();
	}
}
