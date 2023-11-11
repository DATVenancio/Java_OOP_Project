package com.mygdx.game;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Gdx;

public abstract class MyGameInputProcessor implements InputProcessor {
    private boolean showMenu1;

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        if (!showMenu1) {
            if (screenX >= 485 && screenX <= 930 && screenY >= 360 && screenY <= 510) {
                afficherMenu3();
            } else if (screenX >= 485 && screenX <= 930 && screenY >= 590 && screenY <= 740) {
                afficherReglesDuJeu();
            } else if (screenX >= 485 && screenX <= 930 && screenY >= 830 && screenY <= 980) {
                quitterApplication();
            }
        }
        return true;
    }

    protected abstract void afficherMenu3();

    private void afficherReglesDuJeu() {
        System.out.println("Afficher reglesdujeu.jpg");
    }

    private void quitterApplication() {
        System.out.println("Quitter l'application");
        Gdx.app.exit();
    }
}