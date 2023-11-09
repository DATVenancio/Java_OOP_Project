package com.mygdx.game;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Gdx;

public abstract class MyGameInputProcessor implements InputProcessor {
    private boolean showMenu1; // Ajoutez la déclaration de showMenu1 ici

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        if (!showMenu1) {
            if (screenX >= 345 && screenX <= 790 && screenY >= 360 && screenY <= 510) {
                afficherMenu3();
            } else if (screenX >= 345 && screenX <= 790 && screenY >= 590 && screenY <= 740) {
                afficherReglesDuJeu();
            } else if (screenX >= 345 && screenX <= 790 && screenY >= 830 && screenY <= 980) {
                quitterApplication();
            }
        }
        return true;
    }

    protected abstract void afficherMenu3();

    // Les autres méthodes de l'interface InputProcessor doivent être implémentées ici
    
    private void afficherReglesDuJeu() {
        System.out.println("Afficher reglesdujeu.jpg");
        // Ajoutez votre logique pour afficher reglesdujeu.jpg ici
    }

    private void quitterApplication() {
        System.out.println("Quitter l'application");
        // Ajoutez votre logique pour quitter l'application ici
        Gdx.app.exit();
    }
}
