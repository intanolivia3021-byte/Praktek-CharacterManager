package com.unpri.charactermanager;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterManager;
import com.unpri.charactermanager.model.CharacterType;
import com.unpri.charactermanager.view.MainWindow;

import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {

        // Membuat pengelola karakter.
        CharacterManager manager = new CharacterManager();

        // Menambahkan minimal enam karakter.
        manager.addCharacter(
                new Character("Arthur", 10, CharacterType.WARRIOR)
        );

        manager.addCharacter(
                new Character("Merlin", 15, CharacterType.MAGE)
        );

        manager.addCharacter(
                new Character("Robin", 3, CharacterType.ARCHER)
        );

        manager.addCharacter(
                new Character("Luna", 7, CharacterType.MAGE)
        );

        manager.addCharacter(
                new Character("Darius", 1, CharacterType.WARRIOR)
        );

        manager.addCharacter(
                new Character("Elara", 5, CharacterType.HEALER)
        );

        // Menjalankan GUI pada Event Dispatch Thread.
        SwingUtilities.invokeLater(() -> {
            MainWindow window = new MainWindow(manager);
            window.setVisible(true);
        });
    }
}