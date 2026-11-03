
package com.unpri.charactermanager.view;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterManager;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class MainWindow extends JFrame {

    private static final int HIGH_LEVEL_LIMIT = 5;

    private final CharacterManager manager;

    public MainWindow(CharacterManager manager) {
        this.manager = manager;

        setTitle("Character Manager v0.4");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        initComponents();

        pack();
        setMinimumSize(getSize());
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));

        mainPanel.setBackground(AppTheme.BACKGROUND);
        mainPanel.setBorder(
                BorderFactory.createEmptyBorder(15, 15, 15, 15)
        );

        JLabel titleLabel = new JLabel(
                "CHARACTER MANAGER",
                SwingConstants.CENTER
        );

        titleLabel.setFont(AppTheme.TITLE_FONT);
        titleLabel.setForeground(AppTheme.PRIMARY);
        titleLabel.setOpaque(true);
        titleLabel.setBackground(AppTheme.BACKGROUND);

        mainPanel.add(titleLabel, BorderLayout.NORTH);

        JPanel characterPanel =
                new JPanel(new GridLayout(0, 2, 12, 12));

        characterPanel.setBackground(AppTheme.BACKGROUND);
        characterPanel.setOpaque(true);

        for (Character character : manager.getAllCharacters()) {
            characterPanel.add(createCharacterCard(character));
        }

        JScrollPane scrollPane = new JScrollPane(characterPanel);
        scrollPane.setBorder(null);
        scrollPane.getViewport().setBackground(AppTheme.BACKGROUND);

        mainPanel.add(scrollPane, BorderLayout.CENTER);

        JLabel totalLabel = new JLabel(
                "Total Karakter: " + manager.getAllCharacters().size()
        );

        totalLabel.setFont(AppTheme.BOLD_FONT);
        totalLabel.setForeground(AppTheme.PRIMARY);
        totalLabel.setOpaque(true);
        totalLabel.setBackground(AppTheme.BACKGROUND);

        mainPanel.add(totalLabel, BorderLayout.SOUTH);

        add(mainPanel, BorderLayout.CENTER);
    }

    private JPanel createCharacterCard(Character character) {
        JPanel card = new JPanel(new BorderLayout(5, 8));

        card.setBackground(AppTheme.colorFor(character.getType()));
        card.setOpaque(true);
        card.setBorder(AppTheme.borderFor(character.getType()));

        JLabel nameLabel = new JLabel(character.getName());
        nameLabel.setFont(AppTheme.BOLD_FONT);
        nameLabel.setForeground(AppTheme.PRIMARY);

        JLabel levelLabel = new JLabel(
                "Level: " + character.getLevel()
        );

        levelLabel.setFont(AppTheme.NORMAL_FONT);
        levelLabel.setForeground(AppTheme.TEXT);

        if (character.getLevel() >= HIGH_LEVEL_LIMIT) {
            levelLabel.setForeground(AppTheme.GOLD);
            levelLabel.setFont(AppTheme.LEVEL_FONT);
        }

        JLabel roleLabel = new JLabel(
                "Role: " + character.getType()
        );

        roleLabel.setFont(AppTheme.NORMAL_FONT);
        roleLabel.setForeground(AppTheme.PRIMARY);

        // HP dihitung dari level tanpa memanggil getHitPoints().
        int hp = 100 + (character.getLevel() * 10);

        JLabel hpLabel = new JLabel("HP: " + hp);
        hpLabel.setFont(AppTheme.NORMAL_FONT);
        hpLabel.setForeground(AppTheme.PRIMARY);

        JPanel infoPanel = new JPanel(new GridLayout(0, 1, 3, 3));
        infoPanel.setOpaque(false);

        infoPanel.add(nameLabel);
        infoPanel.add(levelLabel);
        infoPanel.add(roleLabel);
        infoPanel.add(hpLabel);

        card.add(infoPanel, BorderLayout.CENTER);

        // Properti tambahan 1: tooltip detail karakter.
        String tooltip = "<html>"
                + "Nama: " + character.getName() + "<br>"
                + "Role: " + character.getType() + "<br>"
                + "Level: " + character.getLevel() + "<br>"
                + "HP: " + hp
                + "</html>";

        card.setToolTipText(tooltip);
        nameLabel.setToolTipText(tooltip);
        levelLabel.setToolTipText(tooltip);

        return card;
    }
}
