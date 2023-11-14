package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Input.Keys;

public class Menu extends Game {
    private SpriteBatch batch;
    private Game game;
    private String name_player;

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
    private int page = 0;

    public Menu() {
        batch = new SpriteBatch();
        game = new Game();

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

        // On vient initialiser le temps
        startTime = TimeUtils.millis();
        game.create();
    }

    public void manipulerMenu()
    {
        Gdx.input.setInputProcessor(new InputProcessor() {

            // On vient utiliser la fonction touchUp pour capter la zone d'écran cliquée
            @Override
            public boolean touchUp(int screenX, int screenY, int pointer, int bouton) {

                // Pour le bouton retour
                if (screenX >= 180 && screenX <= 380 && screenY >= 60 && screenY <= 135){
                    page = 0;
                }

                // Si la texture actuelle est celle du menu 2 (nouvelle partie/ règles du jeu/quitter)
                if (currentTexture == menu2Texture) {
                    if (screenX >= 485 && screenX <= 930 && screenY >= 360 && screenY <= 510) {
                        // bouton "Nouvelle partie"
                        page = 1;
                    }
                    if (screenX >= 485 && screenX <= 930 && screenY >= 590 && screenY <= 740) {
                        // bouton "Règles du jeu"
                        page = 2;
                    }
                    if (screenX >= 485 && screenX <= 930 && screenY >= 830 && screenY <= 980) {
                        // bouton "Quitter"
                        page = 3;
                    }
                }

                // Si la texture actuelle est celle du menu 3 (choix d'une caractéristique)
                if (currentTexture == menu3Texture) {
                    if (screenX >= 180 && screenX <= 380 && screenY >= 60 && screenY <= 135) {
                        // bouton retour
                        page = 0;
                    }
                    if (screenX >= 235 && screenX <= 680 && screenY >= 220 && screenY <= 990) {
                        // choix "Force"
                        page = 4;
                    }
                    if (screenX >= 885 && screenX <= 1330 && screenY >= 220 && screenY <= 990) {
                        // choix "Dextérité"
                        page = 5;
                    }
                    if (screenX >= 1510 && screenX <= 1955 && screenY >= 220 && screenY <= 990) {
                        // choix "Intelligence"
                        page = 6;
                    }
                }

                // Si la texture actuelle est choixForce ou choixDexterite ou choixIntelligence
                if (currentTexture == choixForce || currentTexture == choixDexterite || currentTexture == choixIntelligence) {
                    if (screenX >= 180 && screenX <= 380 && screenY >= 60 && screenY <= 135) {
                        // bouton retour
                        page = 1;
                    }

                    // Si on est dans la zone "Homme" des pages
                    if (screenX >= 600 && screenX <= 1040 && screenY >= 240 && screenY <= 965) {
                        if(currentTexture == choixForce){
                            // bouton "Choix Homme Force"
                            page = 7;
                        }
                        if(currentTexture == choixDexterite){
                            // bouton "Choix Homme Dexterite"
                            page = 9;
                        }
                        if(currentTexture == choixIntelligence){
                            // bouton "Choix Homme Intelligence
                            page = 11;
                        }
                    }

                    // Si on est dans la zone "Femme" des pages
                    if (screenX >= 1155 && screenX <= 1595 && screenY >= 240 && screenY <= 965) {
                        if(currentTexture == choixForce){
                            // bouton "Choix Femme Force"
                            page = 8;
                        }
                        if(currentTexture == choixDexterite){
                            // bouton "Choix Femme Dexterite"
                            page = 10;
                        }
                        if(currentTexture == choixIntelligence){
                            // bouton "Choix Femme Intelligence"
                            page = 12;
                        }
                    }
                }

                // Si la texture actuelle est "Choix Force Homme" ou "Choix Force Femme"
                if (currentTexture == ForceHomme || currentTexture == ForceFemme) {
                    if (screenX >= 180 && screenX <= 380 && screenY >= 60 && screenY <= 135) {
                        // bouton retour
                        page = 4;
                    }
                    if(screenX >= 1720 && screenX <= 2030 && screenY >= 935 && screenY <= 1055 && currentTexture == ForceHomme){
                        // On vient relever que le nom du player est "ForceHomme"
                        name_player = "ForceHomme";
                        // On l'affiche dans le terminal pour vérifier que ça fonctionne
                        System.out.println(name_player);
                        page = 13;
                    }
                    if(screenX >= 1720 && screenX <= 2030 && screenY >= 935 && screenY <= 1055 && currentTexture == ForceFemme){
                        // On vient relever que le nom du player est "ForceFemme"
                        name_player = "ForceFemme";
                        // On l'affiche dans le terminal pour vérifier que ça fonctionne
                        System.out.println(name_player);
                        page = 13;
                    }
                }

                // Si la texture actuelle est "Choix Dexterite Homme" ou "Choix Dexterite Femme"
                if (currentTexture == DexteriteHomme || currentTexture == DexteriteFemme) {
                    if (screenX >= 180 && screenX <= 380 && screenY >= 60 && screenY <= 135) {
                        // bouton retour
                        page = 5;
                    }
                    if(screenX >= 1720 && screenX <= 2030 && screenY >= 935 && screenY <= 1055 && currentTexture == DexteriteHomme){
                        // On vient relever que le nom du player est "DexteriteHomme" et on l'affiche
                        name_player = "DexteriteHomme";
                        System.out.println(name_player);
                        page = 13;
                    }
                    if(screenX >= 1720 && screenX <= 2030 && screenY >= 935 && screenY <= 1055 && currentTexture == DexteriteFemme){
                        // On vient relever que le nom du player est "DexteriteFemme" et on l'affiche
                        name_player = "DexteriteFemme";
                        System.out.println(name_player);
                        page = 13;
                    }
                }

                // Si la texture actuelle est "Choix Intelligence Homme" ou "Choix Intelligence Femme"
                if (currentTexture == IntelligenceHomme || currentTexture == IntelligenceFemme) {
                    if (screenX >= 180 && screenX <= 380 && screenY >= 60 && screenY <= 135) {
                        // bouton retour
                        page = 6;
                    }
                    if(screenX >= 1720 && screenX <= 2030 && screenY >= 935 && screenY <= 1055 && currentTexture == IntelligenceHomme){
                        // On vient relever le nom du player et on l'affiche
                        name_player = "IntelligenceHomme";
                        System.out.println(name_player);
                        page = 13;
                    }
                    if(screenX >= 1720 && screenX <= 2030 && screenY >= 935 && screenY <= 1055 && currentTexture == IntelligenceFemme){
                        // On vient relever le nom du player et on l'affiche
                        name_player = "IntelligenceFemme";
                        System.out.println(name_player);
                        page = 13;
                    }
                }

                // Si la texture actuelle est Prologue, on peut cliquer n'importe où sur l'écran pour continuer
                if (currentTexture == Prologue && screenX >= 0 && screenX <= 1920 && screenY >= 0 && screenY <= 1080) {
                        page = 14;
                }

                // Si la texture actuelle est Histoire page 1
                if (currentTexture == Histoire1) {
                    if (screenX >= 180 && screenX <= 380 && screenY >= 60 && screenY <= 135) {
                        // bouton retour
                        page = 1;
                    }
                    if (screenX >= 1665 && screenX <= 1900 && screenY >= 950 && screenY <= 1040) {
                        // bouton "Suivant"
                        page = 15;
                    }
                }

                // Si la texture actuelle est Histoire page 2
                if (currentTexture == Histoire2) {
                    if (screenX >= 1385 && screenX <= 1625 && screenY >= 950 && screenY <= 1040) {
                        // bouton "Précédent"
                        page = 14;
                    }
                    if (screenX >= 1665 && screenX <= 1900 && screenY >= 950 && screenY <= 1040) {
                        // bouton "Suivant"
                        page = 16;
                    }
                }

                // Si la texture actuelle est Histoire page 3
                if (currentTexture == Histoire3) {
                    if (screenX >= 1385 && screenX <= 1625 && screenY >= 950 && screenY <= 1040) {
                        // bouton "Précédent"
                        page = 15;
                    }
                    if (screenX >= 1665 && screenX <= 1900 && screenY >= 950 && screenY <= 1040) {
                        // bouton "Démarrer"
                        page = 17;
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

        if(page == 1) { // si on est à la page Menu3
            batch.draw(menu3Texture, x, y); // afficher le fond menu3
            currentTexture = menu3Texture;
        }
        if(page == 2) { // si on est à la page Regles du jeu
            batch.draw(regleTexture, x, y);
            currentTexture = regleTexture;
        }
        if(page == 3)  {// si on est à la page Quitter
            System.out.println("Quitter l'application");
            Gdx.app.exit();
        }
        if(page == 4)  {// si on est à la page Choix Force
            batch.draw(choixForce, x, y);
            currentTexture = choixForce;
        }
        if(page == 5)  {// si on est à la page Choix Dexterite
            batch.draw(choixDexterite, x, y);
            currentTexture = choixDexterite;
        }
        if(page == 6)  {// si on est à la page Choix Intelligence
            batch.draw(choixIntelligence, x, y);
            currentTexture = choixIntelligence;
        }
        if(page == 7)  {// si on est à la page Choix Force Homme
            batch.draw(ForceHomme, x, y);
            currentTexture = ForceHomme;
        }
        if(page == 8)  {// si on est à la page Choix Force Femme
            batch.draw(ForceFemme, x, y);
            currentTexture = ForceFemme;
        }
        if(page == 9)  {// si on est à la page Choix Dextérité Homme
            batch.draw(DexteriteHomme, x, y);
            currentTexture = DexteriteHomme;
        }
        if(page == 10)  {// si on est à la page Choix Dextérité Femme
            batch.draw(DexteriteFemme, x, y);
            currentTexture = DexteriteFemme;
        }
        if(page == 11)  {// si on est à la page Choix Intelligence Homme
            batch.draw(IntelligenceHomme, x, y);
            currentTexture = IntelligenceHomme;
        }
        if(page == 12)  {// si on est à la page Choix Intelligence Femme
            batch.draw(IntelligenceFemme, x, y);
            currentTexture = IntelligenceFemme;
        }
        if(page == 13)  {// si on est à la page Prologue
            batch.draw(Prologue, x, y);
            currentTexture = Prologue;
        }
        if(page == 14)  {// si on est à la page Histoire 1
            batch.draw(Histoire1, x, y);
            currentTexture = Histoire1;
        }
        if(page == 15)  {// si on est à la page Histoire 2
            batch.draw(Histoire2, x, y);
            currentTexture = Histoire2;
        }
        if(page == 16)  {// si on est à la page Histoire 3
            batch.draw(Histoire3, x, y);
            currentTexture = Histoire3;
        }
        if(page == 17){
            game.render();
        }
        batch.end();
    }

    public void render() {
        manipulerMenu();
        switch (page) {
            case 0:
                dessinerMenu();
                break;
            case 1:
                dessinerPage(1);
                break;
            case 2:
                dessinerPage(2);
                break;
            case 3:
                dessinerPage(3);
                break;
            case 4:
                dessinerPage(4);
                break;
            case 5:
                dessinerPage(5);
                break;
            case 6:
                dessinerPage(6);
                break;
            case 7:
                dessinerPage(7);
                break;
            case 8:
                dessinerPage(8);
                break;
            case 9:
                dessinerPage(9);
                break;
            case 10:
                dessinerPage(10);
                break;
            case 11:
                dessinerPage(11);
                break;
            case 12:
                dessinerPage(12);
                break;
            case 13:
                dessinerPage(13);
                break;
            case 14:
                dessinerPage(14);
                break;
            case 15:
                dessinerPage(15);
                break;
            case 16:
                dessinerPage(16);
                break;
            case 17 :
                dessinerPage(17);
                break;
        }
    }

    public void resize() {
        // logique de redimensionnement
    }

    public void pause() {
        // logique de pause
    }

    public void resume() {
        // logique de reprise
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

    public int getPage() {
        return page;
    }

    public String getNamePlayer() {
        return name_player;
    }
}
