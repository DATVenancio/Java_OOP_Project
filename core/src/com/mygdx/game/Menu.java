package com.mygdx.game;

import com.mygdx.game.*;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.InputProcessor;


public class Menu {
    private SpriteBatch batch;

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

    // Texture du moment pour les boucles
    private Texture currentTexture;
    private long startTime;
    private boolean showMenu1 = true;
    private int page = 0;

    public Menu() {
        batch = new SpriteBatch();

        menu1Texture = new Texture("menu1.jpg");
        menu2Texture = new Texture("menu2.jpg");
        menu3Texture = new Texture("menu3.jpg");
        regleTexture = new Texture("regles.jpg");
        choixForce = new Texture("choixforce.jpg");
        choixDexterite = new Texture("choixdexterite.jpg");
        choixIntelligence = new Texture("choixintelligence.jpg");
        ForceHomme = new Texture("forcehomme.jpg");
        ForceFemme = new Texture("forcefemme.jpg");
        DexteriteHomme = new Texture("dexteritehomme.jpg");
        DexteriteFemme = new Texture("dexteritefemme.jpg");
        IntelligenceHomme = new Texture("intelligencehomme.jpg");
        IntelligenceFemme = new Texture("intelligencefemme.jpg");

        startTime = TimeUtils.millis();
    }

    public void manipulerMenu()
    {
        Gdx.input.setInputProcessor(new InputProcessor() {

            @Override
            public boolean touchUp(int screenX, int screenY, int pointer, int bouton) {

                if (screenX >= 180 && screenX <= 380 && screenY >= 60 && screenY <= 135) {
                    // bouton retour
                    page = 0;
                }

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

                if (currentTexture == menu3Texture) {
                    if (screenX >= 180 && screenX <= 380 && screenY >= 60 && screenY <= 135) {
                        // bouton retour
                        page = 0;
                    }
                    if (screenX >= 235 && screenX <= 680 && screenY >= 220 && screenY <= 990) {
                        // bouton "Force"
                        page = 4;
                    }
                    if (screenX >= 885 && screenX <= 1330 && screenY >= 220 && screenY <= 990) {
                        // bouton "Dextérité"
                        page = 5;
                    }
                    if (screenX >= 1510 && screenX <= 1955 && screenY >= 220 && screenY <= 990) {
                        // bouton "Intelligence"
                        page = 6;
                    }
                }

                if (currentTexture == choixForce || currentTexture == choixDexterite || currentTexture == choixIntelligence) {
                    if (screenX >= 180 && screenX <= 380 && screenY >= 60 && screenY <= 135) {
                        // bouton retour
                        page = 1;
                    }
                    if (screenX >= 600 && screenX <= 1040 && screenY >= 240 && screenY <= 965) {
                        if(currentTexture == choixForce){// bouton "Homme Force"
                            page = 7;
                        }
                        if(currentTexture == choixDexterite){
                            page = 9;
                        }
                        if(currentTexture == choixIntelligence){
                            page = 11;
                        }
                    }
                    if (screenX >= 1155 && screenX <= 1595 && screenY >= 240 && screenY <= 965) {
                        // bouton "Femme Force"
                        if(currentTexture == choixForce){// bouton "Homme Force"
                            page = 8;
                        }
                        if(currentTexture == choixDexterite){
                            page = 10;
                        }
                        if(currentTexture == choixIntelligence){
                            page = 12;
                        }
                    }
                }
                if (currentTexture == ForceHomme || currentTexture == ForceFemme) {
                    if (screenX >= 180 && screenX <= 380 && screenY >= 60 && screenY <= 135) {
                        // bouton retour
                        page = 4;
                    }
                }

                if (currentTexture == DexteriteHomme || currentTexture == DexteriteFemme) {
                    if (screenX >= 180 && screenX <= 380 && screenY >= 60 && screenY <= 135) {
                        // bouton retour
                        page = 5;
                    }
                }

                if (currentTexture == IntelligenceHomme || currentTexture == IntelligenceFemme) {
                    if (screenX >= 180 && screenX <= 380 && screenY >= 60 && screenY <= 135) {
                        // bouton retour
                        page = 6;
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

    public void dessinerMenu()   // dessiner le menu
    {
        batch.begin();  // obligatoire pour commencer un dessin sur le SpriteBatch

        float imageWidth = menu1Texture.getWidth();
        float imageHeight = menu1Texture.getHeight();

        float x = (Gdx.graphics.getWidth() - imageWidth) / 2;
        float y = (Gdx.graphics.getHeight() - imageHeight) / 2;

        long currentTime = TimeUtils.millis();
        long elapsedTime = currentTime - startTime;

        if (showMenu1 && elapsedTime < 3000) {
            batch.draw(menu1Texture, x, y);
            currentTexture = menu1Texture;
        } else {
            showMenu1 = false;
            batch.draw(menu2Texture, x, y);
            currentTexture = menu2Texture;
        }

        batch.end();  // obligatoire pour finir le dessin sur un SpriteBatch

    }


    public void dessinerPage(int page)
    {
        batch.begin();

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
        if(page == 7)  {// si on est à la page Choix Intelligence
            batch.draw(ForceHomme, x, y);
            currentTexture = ForceHomme;
        }
        if(page == 8)  {// si on est à la page Choix Intelligence
            batch.draw(ForceFemme, x, y);
            currentTexture = ForceFemme;
        }
        if(page == 9)  {// si on est à la page Choix Intelligence
            batch.draw(DexteriteHomme, x, y);
            currentTexture = DexteriteHomme;
        }
        if(page == 10)  {// si on est à la page Choix Intelligence
            batch.draw(DexteriteFemme, x, y);
            currentTexture = DexteriteFemme;
        }
        if(page == 11)  {// si on est à la page Choix Intelligence
            batch.draw(IntelligenceHomme, x, y);
            currentTexture = IntelligenceHomme;
        }
        if(page == 12)  {// si on est à la page Choix Intelligence
            batch.draw(IntelligenceFemme, x, y);
            currentTexture = IntelligenceFemme;
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
        }
    }

    public void resize(int width, int height) {
        // Ajoutez ici votre logique de redimensionnement
    }

    public void pause() {
        // Ajoutez ici votre logique de pause
    }

    public void resume() {
        // Ajoutez ici votre logique de reprise
    }

    public void dispose() {
        // pour la libération mémoire
        batch.dispose();
        menu1Texture.dispose();
        menu2Texture.dispose();
        menu3Texture.dispose();
        regleTexture.dispose();
        choixForce.dispose();
        choixDexterite.dispose();
        choixIntelligence.dispose();
        ForceHomme.dispose();
        ForceFemme.dispose();
        DexteriteHomme.dispose();
        DexteriteFemme.dispose();
        IntelligenceHomme.dispose();
        IntelligenceFemme.dispose();
    }
}
