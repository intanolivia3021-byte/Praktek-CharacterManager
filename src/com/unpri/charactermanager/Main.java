
package com.unpri.charactermanager;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;
import com.unpri.charactermanager.model.CharacterManager;
import com.unpri.charactermanager.view.MainWindow;

import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {

        CharacterManager manager = new CharacterManager();

        manager.addCharacter(new Character(
            "Arthur", 10, CharacterType.WARRIOR));

        manager.addCharacter(new Character(
            "Merlin", 15, CharacterType.MAGE));

        manager.addCharacter(new Character(
            "Robin", 8, CharacterType.ARCHER));

        manager.addCharacter(new Character(
            "Luna", 12, CharacterType.MAGE));

        manager.addCharacter(new Character(
            "Darius", 20, CharacterType.WARRIOR));

        manager.addCharacter(new Character(
            "Elara", 18, CharacterType.HEALER));

        SwingUtilities.invokeLater(() -> {
            MainWindow window = new MainWindow(manager);
            window.setVisible(true);
        });
    }
}
