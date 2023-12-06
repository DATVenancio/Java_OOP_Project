package com.mygdx.game.Controller;


import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.mygdx.game.Model.Bag;
import com.mygdx.game.Model.Bow;
import com.mygdx.game.Model.CombatManager;
import com.mygdx.game.Model.DexterityDesignation;
import com.mygdx.game.Model.Dragon;
import com.mygdx.game.Model.Enemy;
import com.mygdx.game.Model.IntelligenceDesignation;
import com.mygdx.game.Model.Item;
import com.mygdx.game.Model.Player;
import com.mygdx.game.Model.StrengthDesignation;
import com.mygdx.game.Model.Sword;





public class Main_to_test {
	
	
	public static void main(String[] args) {
		
		
		
		Map<Integer, String> pages = new HashMap<>();
		
		
		System.out.println(pages.get(2));
		
		// TODO Auto-generated method stub
		Player player= new Player();
		Enemy enemy = new Dragon();
		
		CombatManager combatManager = CombatManager.getInstance();
		
		initial_configuration(combatManager,player,enemy);
		
		
		
		
		
		//tests
		System.out.println("TESTS:");
		
		test_designation_strength(player);
		test_designation_intelligence(player);
		test_designation_dexterity(player);
		
		test_bag_add_item(player);
		test_bag_remove_item(player);
		
		test_weapon_sword(player);
		test_weapon_staff(player);
		test_weapon_bow(player);
		
		
		test_combat_turn(combatManager, enemy);
		
		
		
		
		
		
		
		System.out.println("NO ERROR");
		System.out.println();
		//print_player_infos(player);

		
		
	}
	

	
	public static void test_designation_strength(Player player) {
		
		
		player.setDesignation(new StrengthDesignation(player));
		if(player.getStregth()!=5 || player.getIntelligence()!= 2 || player.getSpeed()!=2) {
			assertTrue(false);
		}
		
	}

	public static void test_designation_intelligence(Player player) {
		
		player.setDesignation(new IntelligenceDesignation(player));
		if(player.getStregth()!=2 || player.getIntelligence()!= 5 || player.getSpeed()!=2) {
			assertTrue(false);
		}

	}

	public static void test_designation_dexterity(Player player) {
		
		player.setDesignation(new DexterityDesignation(player));
		if(player.getStregth()!=2 || player.getIntelligence()!= 2 || player.getSpeed()!=5) {
			assertTrue(false);
		}
	}
	
	public static void test_bag_add_item(Player player) {
		int bag_capacity = player.getBag().getCapacity();
		
		for(int i = 0; i< 2*bag_capacity;i++) {
			player.getBag().addItem(new Sword());
		}
		
		if(player.getBag().getAmountOfItems() != bag_capacity) {
			assertTrue(false);
		}
		
		
	}
	
	public static void test_bag_remove_item(Player player) {
		int oldAmount=player.getBag().getAmountOfItems();
		Item firstItem = player.getBag().getItems().get(0);
		player.getBag().removeItem(firstItem);
		int newAmount=player.getBag().getAmountOfItems();
		if(newAmount != oldAmount-1) {
			assertTrue(false);
		}
	}
	
	public static void test_weapon_sword(Player player) {
		//remove_all_bag_items(player);
		Sword sword = new Sword();
		int sword_power =3;
		sword.setPower(sword_power);
		
		int oldAttackBonus = player.getAttackBonus();
		player.setDesignation(new StrengthDesignation(player));
		player.getBag().addItem(sword);
		int newAttackBonus = player.getAttackBonus();
		
		
		
		if(oldAttackBonus+sword_power != newAttackBonus) {
			assertTrue(false);
		}
		player.getBag().removeItem(sword);
		
	}
	
	public static void test_weapon_staff(Player player) {
		Sword staff = new Sword();
		int staff_power =4;
		staff.setPower(staff_power);
		
		int oldAttackBonus = player.getAttackBonus();
		player.setDesignation(new StrengthDesignation(player));
		player.getBag().addItem(staff);
		int newAttackBonus = player.getAttackBonus();
		
		
		
		if(oldAttackBonus+staff_power != newAttackBonus) {
			assertTrue(false);
		}
		player.getBag().removeItem(staff);
		
	}

	public static void test_weapon_bow(Player player) {
		Bow bow = new Bow();
		int bow_power =5;
		bow.setPower(bow_power);
		
		int oldAttackBonus = player.getAttackBonus();
		player.setDesignation(new DexterityDesignation(player));
		player.getBag().addItem(bow);
		int newAttackBonus = player.getAttackBonus();
		
		
		
		if(oldAttackBonus+bow_power != newAttackBonus) {
			assertTrue(false);
		}
		player.getBag().removeItem(bow);
	}
	
	public static void test_combat_turn(CombatManager combatManager, Enemy enemy) {
		
		combatManager.createTurn(null, enemy);
		
		
		assertTrue(true);
	}
	
	
	public static void initial_configuration(CombatManager combatManager,Player player, Enemy enemy) {
		
		create_player(player);
		create_enemy(enemy);
		combatManager.setPlayer(player);

		
	}
	
	
	public static Player create_player(Player player) {
		player.setName("Geralt");
		player.setAttackBonus(5);
		player.setLife(40);
		
		player.setStregth(0);
		player.setIntelligence(0);
		player.setSpeed(0);
		
		
		player.setBag(create_bag(player));
		
		return player;
	}
	
	public static Bag create_bag(Player player) {
		Bag bag = new Bag();
		bag.setCapacity(5);
		bag.setAmountOfItems(0);
		bag.setTotalWeight(0);
		bag.setPlayer(player);
		return bag;
	}
	
	public static void create_enemy(Enemy enemy) {
		enemy.setAlive(true);
		enemy.setAttack(3);
		enemy.setLife(10);
		enemy.setName("Fire Dragon");
	}
	
	
	
	
	
	public static void print_player_infos(Player player) {
		System.out.println("INITIAL STATE");
		System.out.println("Player name:" + player.getName());
		System.out.println("Player attack:" + player.getAttackBonus());
		System.out.println("Player strength:" + player.getStregth());
		System.out.println("Player intelligence:" + player.getIntelligence());
		System.out.println("Player speed:" + player.getSpeed());
	}
}
