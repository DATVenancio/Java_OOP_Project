package com.mygdx.game.View;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.TimeUtils;
import com.mygdx.game.Controller.Game;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Input.Keys;

public class Menu_alternative {
    private SpriteBatch batch;
    private Game game;
    private String name_player;

    
    Map<Integer, Texture> pages = new HashMap<>(); 
    // Texture des menus
    private Texture menu1Texture;
    private Texture menu2Texture;
    private Texture menu3Texture;

    // Texture des règles du jeu
    private Texture regleTexture;

    // Section Force
    private Texture choixForce;
    private Texture ForceHomme;
    private Texture ForceFemme;

    // Section Dextérité
    private Texture choixDexterite;
    private Texture DexteriteHomme;
    private Texture DexteriteFemme;

    // Section Intelligence
    private Texture choixIntelligence;
    private Texture IntelligenceHomme;
    private Texture IntelligenceFemme;
    
    // Partie Prologue & Histoire
    private Texture Prologue;
    private Texture Histoire1;
    private Texture Histoire2;
    private Texture Histoire3;

    // Texture actuelle pour les boucles
    private Texture currentTexture;
    private long startTime;
    // Booléen pour passer de menu1 à menu2
    private boolean showMenu1 = true;
    // On initialise la page à 0
    private int currentPage = 0;
    
    boolean gameStarted=false;
    
    
    
    String chosenCharacter;

    public Menu_alternative() {
        batch = new SpriteBatch();
        
        configurePages();
        // On vient initialiser le temps
        startTime = TimeUtils.millis();
        //game.create();
        
    }

    

    public void dessinerMenu()   // On vient dessiner le menu initial
    {
        batch.begin();  // Obligatoire pour commencer un dessin sur le SpriteBatch

        // On vient définir la taille pour ajuster à l'écran et centrer
        float imageWidth = menu1Texture.getWidth();
        float imageHeight = menu1Texture.getHeight();

        float x = (Gdx.graphics.getWidth() - imageWidth) / 2;
        float y = (Gdx.graphics.getHeight() - imageHeight) / 2;

        // On vient définir le temps
        long currentTime = TimeUtils.millis();
        long elapsedTime = currentTime - startTime;

        // On vient afficher menu 1 pendant 3 secondes
        if (showMenu1 && elapsedTime < 3000) {
            // on affiche
            batch.draw(menu1Texture, x, y);
            // on informe que la texture actuelle est menu1
            currentTexture = menu1Texture;
        } else {
            // au dela de 3 secondes, showmenu est false donc on affiche menu2
            showMenu1 = false;
            batch.draw(menu2Texture, x, y);
            // on informe que la texture actuelle est menu2
            currentTexture = menu2Texture;
        }

        batch.end();  // Obligatoire pour finir le dessin sur un SpriteBatch

    }


    public void dessinerPage(int page)
    {
        batch.begin();

        // on vient dessiner les différentes pages en fonction de la page entrée en paramètre

        // dimensionnement de l'image
        float imageWidth = menu3Texture.getWidth();
        float imageHeight = menu3Texture.getHeight();

        float x = (Gdx.graphics.getWidth() - imageWidth) / 2;
        float y = (Gdx.graphics.getHeight() - imageHeight) / 2;

        
        if(currentPage==3) {
        	System.out.println("Quitter l'application");
            Gdx.app.exit();
        }else if(currentPage==17){
        	if(gameStarted==false) {
        		
        		game = new Game(chosenCharacter);
        		game.create();
        		
        		gameStarted=true;
        	}
        	
        	game.render();
        }else{
        	batch.draw(pages.get(currentPage),x,y);
            currentTexture= pages.get(currentPage);
        }
        
        batch.end();
    }

    
    public void render() {

        manipulerMenu();
        
        if(currentPage==0) {
        	dessinerMenu();
        }else {
        	dessinerPage(currentPage);
        }
        
    }


    public void dispose() {
        // pour la libération mémoire
        batch.dispose();
        // menu
        menu1Texture.dispose();
        menu2Texture.dispose();
        menu3Texture.dispose();
        regleTexture.dispose();
        // choix caractéristique
        choixForce.dispose();
        choixDexterite.dispose();
        choixIntelligence.dispose();
        // personnages
        ForceHomme.dispose();
        ForceFemme.dispose();
        DexteriteHomme.dispose();
        DexteriteFemme.dispose();
        IntelligenceHomme.dispose();
        IntelligenceFemme.dispose();
        // prologue et histoire
        Prologue.dispose();
        Histoire1.dispose();
        Histoire2.dispose();
        Histoire3.dispose();
        game.dispose();
    }

    
    
    public void configurePages() {

        // On vient définir les textures-images pour les menus
        menu1Texture = new Texture("menu1.jpg");
        menu2Texture = new Texture("menu2.jpg");
        menu3Texture = new Texture("menu3.jpg");
        regleTexture = new Texture("regles.jpg");

        // On vient définir les textures-images pour le choix de la caractéristique
        choixForce = new Texture("choixforce.jpg");
        choixDexterite = new Texture("choixdexterite.jpg");
        choixIntelligence = new Texture("choixintelligence.jpg");

        // On vient définir les textures-images pour les fiches personnages
        ForceHomme = new Texture("forcehomme.jpg");
        ForceFemme = new Texture("forcefemme.jpg");
        DexteriteHomme = new Texture("dexteritehomme.jpg");
        DexteriteFemme = new Texture("dexteritefemme.jpg");
        IntelligenceHomme = new Texture("intelligencehomme.jpg");
        IntelligenceFemme = new Texture("intelligencefemme.jpg");

        // On vient définir les textures-images pour le prologue et les histoires
        Prologue = new Texture("prologue.jpg");
        Histoire1 = new Texture("histoire1.jpg");
        Histoire2 = new Texture("histoire2.jpg");
        Histoire3 = new Texture("histoire3.jpg");
        
        
        pages.put(1, menu3Texture);
		pages.put(2, regleTexture);
		pages.put(4, choixForce);
		pages.put(5, choixDexterite);
		pages.put(6, choixIntelligence);
		pages.put(7, ForceHomme);
		pages.put(8, ForceFemme);
		pages.put(9, DexteriteHomme);
		pages.put(10, DexteriteFemme);
		pages.put(11, IntelligenceHomme);
		pages.put(12, IntelligenceFemme);
		pages.put(13, Prologue);
		pages.put(14, Histoire1);
		pages.put(15, Histoire2);
		pages.put(16, Histoire3);
    	
    }


    public void manipulerMenu()
    {
        Gdx.input.setInputProcessor(new InputProcessor() {

            // On vient utiliser la fonction touchUp pour capter la zone d'écran cliquée
            @Override
            public boolean touchUp(int screenX, int screenY, int pointer, int bouton) {

                // Pour le bouton retour
                if (screenX >= 80 && screenX <= 300 && screenY >= 0 && screenY <= 150){
                    currentPage = 0;
                }

                // Si la texture actuelle est celle du menu 2 (nouvelle partie/ règles du jeu/quitter)
                if (currentTexture == menu2Texture) {
                    if (screenX >= 385 && screenX <= 830 && screenY >= 360 && screenY <= 510) {
                        // bouton "Nouvelle partie"
                        currentPage = 1;
                    }
                    if (screenX >= 385 && screenX <= 830 && screenY >= 590 && screenY <= 740) {
                        // bouton "Règles du jeu"
                        currentPage = 2;
                    }
                    if (screenX >= 385 && screenX <= 830 && screenY >= 830 && screenY <= 980) {
                        // bouton "Quitter"
                        currentPage = 3;
                    }
                }

                // Si la texture actuelle est celle du menu 3 (choix d'une caractéristique)
                if (currentTexture == menu3Texture) {
                    if (screenX >= 80 && screenX <= 300 && screenY >= 0 && screenY <= 150){
                        currentPage = 0;
                    }
                    if (screenX >= 235 && screenX <= 680 && screenY >= 220 && screenY <= 990) {
                        // choix "Force"
                        currentPage = 4;
                    }
                    if (screenX >= 885 && screenX <= 1330 && screenY >= 220 && screenY <= 990) {
                        // choix "Dextérité"
                        currentPage = 5;
                    }
                    if (screenX >= 1510 && screenX <= 1955 && screenY >= 220 && screenY <= 990) {
                        // choix "Intelligence"
                        currentPage = 6;
                    }
                }

                // Si la texture actuelle est choixForce ou choixDexterite ou choixIntelligence
                if (currentTexture == choixForce || currentTexture == choixDexterite || currentTexture == choixIntelligence) {
                    if (screenX >= 80 && screenX <= 300 && screenY >= 0 && screenY <= 150){
                        currentPage = 1;
                    }

                    // Si on est dans la zone "Homme" des pages
                    if (screenX >= 600 && screenX <= 1040 && screenY >= 240 && screenY <= 965) {
                        if(currentTexture == choixForce){
                            // bouton "Choix Homme Force"
                        	System.out.println("Oi");
                            currentPage = 7;
                        }
                        if(currentTexture == choixDexterite){
                            // bouton "Choix Homme Dexterite"
                            currentPage = 9;
                        }
                        if(currentTexture == choixIntelligence){
                            // bouton "Choix Homme Intelligence
                            currentPage = 11;
                        }
                    }

                    // Si on est dans la zone "Femme" des pages
                    if (screenX >= 1155 && screenX <= 1595 && screenY >= 240 && screenY <= 965) {
                        if(currentTexture == choixForce){
                            // bouton "Choix Femme Force"
                            currentPage = 8;
                        }
                        if(currentTexture == choixDexterite){
                            // bouton "Choix Femme Dexterite"
                            currentPage = 10;
                        }
                        if(currentTexture == choixIntelligence){
                            // bouton "Choix Femme Intelligence"
                            currentPage = 12;
                        }
                    }
                }

                // Si la texture actuelle est "Choix Force Homme" ou "Choix Force Femme"
                if (currentTexture == ForceHomme || currentTexture == ForceFemme) {
                    if (screenX >= 80 && screenX <= 300 && screenY >= 0 && screenY <= 150){
                        currentPage = 4;
                    }
                    if(screenX >= 1720 && screenX <= 2030 && screenY >= 835 && screenY <= 955 && currentTexture == ForceHomme){
                        // On vient relever que le nom du player est "ForceHomme"
                    	//createForceMan()
                    	chosenCharacter = "perso_forcehomme";
                        // On l'affiche dans le terminal pour vérifier que ça fonctionne

                        currentPage = 13;
                    }
                    if(screenX >= 1720 && screenX <= 2030 && screenY >= 835 && screenY <= 955 && currentTexture == ForceFemme){
                        // On vient relever que le nom du player est "ForceFemme"
                    	chosenCharacter = "perso_forcefemme";
                        // On l'affiche dans le terminal pour vérifier que ça fonctionne
                        System.out.println(name_player);
                        currentPage = 13;
                    }
                }

                // Si la texture actuelle est "Choix Dexterite Homme" ou "Choix Dexterite Femme"
                if (currentTexture == DexteriteHomme || currentTexture == DexteriteFemme) {
                    if (screenX >= 80 && screenX <= 300 && screenY >= 0 && screenY <= 150){
                        currentPage = 5;
                    }
                    if(screenX >= 1720 && screenX <= 2030 && screenY >= 835 && screenY <= 955 && currentTexture == DexteriteHomme){
                        // On vient relever que le nom du player est "DexteriteHomme" et on l'affiche
                    	chosenCharacter = "perso_dexteritehomme";
                        System.out.println(name_player);
                        currentPage = 13;
                    }
                    if(screenX >= 1720 && screenX <= 2030 && screenY >= 835 && screenY <= 955 && currentTexture == DexteriteFemme){
                        // On vient relever que le nom du player est "DexteriteFemme" et on l'affiche
                    	chosenCharacter = "perso_dexteritefemme";
                        System.out.println(name_player);
                        currentPage = 13;
                    }
                }

                // Si la texture actuelle est "Choix Intelligence Homme" ou "Choix Intelligence Femme"
                if (currentTexture == IntelligenceHomme || currentTexture == IntelligenceFemme) {
                    if (screenX >= 80 && screenX <= 300 && screenY >= 0 && screenY <= 150){
                        currentPage = 6;
                    }
                    if(screenX >= 1620 && screenX <= 2030 && screenY >= 835 && screenY <= 955 && currentTexture == IntelligenceHomme){
                        // On vient relever le nom du player et on l'affiche
                    	chosenCharacter = "perso_intelligencehomme";
                        System.out.println(name_player);
                        currentPage = 13;
                    }
                    if(screenX >= 1620 && screenX <= 2030 && screenY >= 835 && screenY <= 955 && currentTexture == IntelligenceFemme){
                        // On vient relever le nom du player et on l'affiche
                    	chosenCharacter = "perso_intelligencefemme";
                        System.out.println(name_player);
                        currentPage = 13;
                    }
                }

                // Si la texture actuelle est Prologue, on peut cliquer n'importe où sur l'écran pour continuer
                if (currentTexture == Prologue && screenX >= 0 && screenX <= 1920 && screenY >= 0 && screenY <= 1080) {
                        currentPage = 14;
                }

                // Si la texture actuelle est Histoire page 1
                if (currentTexture == Histoire1) {
                    if (screenX >= 80 && screenX <= 300 && screenY >= 0 && screenY <= 150){
                        currentPage = 1;
                    }
                    if (screenX >= 1565 && screenX <= 1800 && screenY >= 850 && screenY <= 1040) {
                        // bouton "Suivant"
                        currentPage = 15;
                    }
                }

                // Si la texture actuelle est Histoire page 2
                if (currentTexture == Histoire2) {
                    if (screenX >= 1285 && screenX <= 1525 && screenY >= 850 && screenY <= 1040) {
                        // bouton "Précédent"
                        currentPage = 14;
                    }
                    if (screenX >= 1565 && screenX <= 1800 && screenY >= 850 && screenY <= 1040) {
                        // bouton "Suivant"
                        currentPage = 16;
                    }
                }

                // Si la texture actuelle est Histoire page 3
                if (currentTexture == Histoire3) {
                    if (screenX >= 1285 && screenX <= 1525 && screenY >= 850 && screenY <= 1040) {
                        // bouton "Précédent"
                        currentPage = 15;
                    }
                    if (screenX >= 1565 && screenX <= 1800 && screenY >= 850 && screenY <= 1040) {
                        // bouton "Démarrer"
                        currentPage = 17;
                    }
                }

                return false;
            }

            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int bouton) {
                return false;
            }

            @Override
            public boolean touchDragged(int arg0, int arg1, int arg2) {
                return false;
            }

            @Override
            public boolean touchCancelled(int screenX, int screenY, int pointer, int button) {
                return false;
            }

            @Override
            public boolean mouseMoved(int arg0, int arg1) {
                return false;
            }

            @Override
            public boolean scrolled(float amountX, float amountY) {
                return false;
            }

            @Override
            public boolean keyUp(int arg0) {
                return false;
            }

            @Override
            public boolean keyTyped(char arg0) {
                return false;
            }

            @Override
            public boolean keyDown(int arg0) {
                return false;
            }
        });
    }



}
