package com.mygdx.game.Controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.badlogic.gdx.graphics.Texture;

public class FileReader {

	public Map<String,Object> readCharacterInfo(String choosenCharacter){
		
		
		Map<String,Object> characterInfos = new HashMap<String,Object>();
		
		try {
			Scanner scanner = new Scanner (new File("../assets/charactersList.txt"));
			
			while(scanner.hasNextLine()) {
				String[] lineParts = scanner.nextLine().split(",");
				if(choosenCharacter.equals(lineParts[0])) {
					characterInfos.put("name", lineParts[1]);
					characterInfos.put("strength", lineParts[2]);
					characterInfos.put("intelligence", lineParts[3]);
					characterInfos.put("wisdom", lineParts[4]);
					characterInfos.put("ruse", lineParts[5]);
					characterInfos.put("speed", lineParts[6]);
					characterInfos.put("attackBonus", lineParts[7]);
					characterInfos.put("life", lineParts[8]);
					characterInfos.put("designation", lineParts[9]);
				}
			}
			

		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		return characterInfos;
	}
	
	public ArrayList<Map<String,Object> > readPhase01Enemies(){
		ArrayList<Map<String,Object> > enemies = new ArrayList<>(); 
		try {
			Scanner scanner = new Scanner (new File("../assets/phase01EnemiesList.txt"));
			scanner.nextLine();//jump information line
			while(scanner.hasNextLine()) {
				String[] lineParts = scanner.nextLine().split(",");
				
				Map<String,Object> enemyInfos = new HashMap<String,Object>();
				enemyInfos.put("name", lineParts[0]);
				enemyInfos.put("life", lineParts[1]);
				enemyInfos.put("attack", lineParts[2]);
				enemyInfos.put("positionX", lineParts[3]);
				enemyInfos.put("positionY", lineParts[4]);
				
				enemies.add(enemyInfos);
				
			}
			

		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		return enemies;
	}
	
	
	public ArrayList<Map<String,Object> > readPhase01Items(){
		ArrayList<Map<String,Object> > items = new ArrayList<>(); 
		try {
			Scanner scanner = new Scanner (new File("../assets/phase01ItemsList.txt"));
			scanner.nextLine();//jump information line
			while(scanner.hasNextLine()) {
				String[] lineParts = scanner.nextLine().split(",");
				Map<String,Object> itemInfos = new HashMap<String,Object>();
				itemInfos.put("type", lineParts[0]);
				itemInfos.put("name", lineParts[1]);
				itemInfos.put("power", lineParts[2]);
				itemInfos.put("positionX", lineParts[3]);
				itemInfos.put("positionY", lineParts[4]);
				
				items.add(itemInfos);

			}
			

		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		return items;
	}
	
	
	
	
}
