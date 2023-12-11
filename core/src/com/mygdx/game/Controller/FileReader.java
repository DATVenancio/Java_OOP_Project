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
					characterInfos.put("speed", lineParts[4]);
					characterInfos.put("attackBonus", lineParts[5]);
					characterInfos.put("life", lineParts[6]);
				}
			}
			

		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		return characterInfos;
	}
}
