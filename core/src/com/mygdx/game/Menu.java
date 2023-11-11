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
    private Texture menu1Texture;
    private Texture menu2Texture;
    private Texture menu3Texture;
    private Texture regleTexture;
    private Texture choixForce;
    private Texture choixDexterite;
    private Texture choixIntelligence;
    private Texture currentTexture;
    private long startTime;
    private boolean showMenu1 = true;
    private boolean cliqueBouton1 = false;
    private boolean cliqueBouton2 = false;
    private boolean cliqueBouton3 = false;
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
                    cliqueBouton1 = false;
                    cliqueBouton2 = false;
                    cliqueBouton3 = false;

                    return false;
            }

            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int bouton) {

                if(screenX >= 485 && screenX <= 930 && screenY >= 360 && screenY <= 510)
                {
                    cliqueBouton1=true;
                }
                if(screenX >= 485 && screenX <= 930 && screenY >= 590 && screenY <= 740)
                {
                    cliqueBouton2=true;
                }
                if(screenX >= 485 && screenX <= 930 && screenY >= 830 && screenY <= 980)
                {
                    cliqueBouton3=true;
                }
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
        batch.dispose();
        menu1Texture.dispose();
        menu2Texture.dispose();
        menu3Texture.dispose();
        regleTexture.dispose();
        choixForce.dispose();
        choixDexterite.dispose();
        choixIntelligence.dispose();
    }
}
