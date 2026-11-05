
package com.unpri.charactermanager.view;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;
import com.unpri.charactermanager.model.CharacterManager;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;

public class MainWindow extends JFrame {

    private final CharacterManager manager;

    private JPanel cardsPanel;

    private JLabel totalLabel;
    private JLabel averageLabel;
    private JLabel roleLabel;
    private JLabel highLevelLabel;

    public MainWindow(CharacterManager manager) {

        this.manager = manager;

        setTitle("Character Manager - Sprint #5");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(
            new BorderLayout(12, 12)
        );

        mainPanel.setBorder(
            new EmptyBorder(15, 15, 15, 15)
        );

        // NORTH
        mainPanel.add(createHeader(), BorderLayout.NORTH);

        // CENTER
        mainPanel.add(createCharacterArea(), BorderLayout.CENTER);

        // EAST
        mainPanel.add(createLegend(), BorderLayout.EAST);

        // SOUTH
        mainPanel.add(createStatusBar(), BorderLayout.SOUTH);

        setContentPane(mainPanel);

        pack();

        setMinimumSize(new Dimension(650, 450));

        setLocationRelativeTo(null);
    }

    // HEADER
    private JPanel createHeader() {

        JPanel header = new JPanel(
            new BorderLayout(10, 10)
        );

        JLabel title = new JLabel("CHARACTER MANAGER");

        title.setFont(
            UIManager.getFont("Label.font")
                .deriveFont(Font.BOLD, 24f)
        );

        header.add(title, BorderLayout.NORTH);

        // Panel statistik tambahan GridLayout 2x2
        JPanel statsPanel = new JPanel(
            new GridLayout(2, 2, 10, 8)
        );

        totalLabel = new JLabel();
        averageLabel = new JLabel();
        roleLabel = new JLabel();
        highLevelLabel = new JLabel();

        statsPanel.add(totalLabel);
        statsPanel.add(averageLabel);
        statsPanel.add(roleLabel);
        statsPanel.add(highLevelLabel);

        header.add(statsPanel, BorderLayout.SOUTH);

        updateStatistics();

        return header;
    }

    // STATISTIK
    private void updateStatistics() {

        List<Character> characters =
            manager.getAllCharacters();

        int total = characters.size();
        int totalLevel = 0;
        int highLevel = 0;

        for (Character character : characters) {

            totalLevel += character.getLevel();

            if (character.getLevel() >= 5) {
                highLevel++;
            }
        }

        double average = total > 0
            ? (double) totalLevel / total
            : 0;

        totalLabel.setText("Total Karakter: " + total);

        averageLabel.setText(
            String.format("Rata-rata Level: %.2f", average)
        );

        roleLabel.setText(
            "Jenis Role: " + CharacterType.values().length
        );

        highLevelLabel.setText(
            "Level Tinggi: " + highLevel
        );
    }

    // DAFTAR KARAKTER
    private JScrollPane createCharacterArea() {

        cardsPanel = new JPanel(
            new GridLayout(0, 2, 12, 12)
        );

        cardsPanel.setBorder(
            new EmptyBorder(10, 10, 10, 10)
        );

        JPanel listContainer = new JPanel(
            new BorderLayout()
        );

        // Kartu ditempatkan pada NORTH wrapper
        listContainer.add(
            cardsPanel,
            BorderLayout.NORTH
        );

        JScrollPane scroll = new JScrollPane(
            listContainer
        );

        scroll.setPreferredSize(
            new Dimension(650, 400)
        );

        scroll.setVerticalScrollBarPolicy(
            JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
        );

        scroll.setHorizontalScrollBarPolicy(
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
        );

        refreshCards();

        return scroll;
    }

    // MEMBUAT KARTU
    private void refreshCards() {

        cardsPanel.removeAll();

        List<Character> characters =
            manager.getAllCharacters();

        for (Character character : characters) {

            cardsPanel.add(
                createCharacterCard(character)
            );
        }

        cardsPanel.revalidate();
        cardsPanel.repaint();
    }

    private JPanel createCharacterCard(
        Character character
    ) {

        JPanel card = new JPanel(
            new BorderLayout(5, 5)
        );

        card.setOpaque(true);

        card.setBackground(
            AppTheme.colorFor(character.getType())
        );

        card.setBorder(
            AppTheme.borderFor(character.getType())
        );

        JLabel name = new JLabel(
            character.getName()
        );

        name.setFont(
            UIManager.getFont("Label.font")
                .deriveFont(Font.BOLD, 16f)
        );

        JLabel level = new JLabel(
            "Level: " + character.getLevel()
        );

        JLabel role = new JLabel(
            "Role: " + character.getType()
        );

        JLabel hp = new JLabel(
            "HP: " + (100 + character.getLevel() * 10)
        );

        JPanel details = new JPanel(
            new GridLayout(3, 1)
        );

        details.setOpaque(false);

        details.add(level);
        details.add(role);
        details.add(hp);

        card.add(name, BorderLayout.NORTH);
        card.add(details, BorderLayout.CENTER);

        card.setBorder(
            BorderFactory.createCompoundBorder(
                AppTheme.borderFor(character.getType()),
                new EmptyBorder(10, 10, 10, 10)
            )
        );

        return card;
    }

    // LEGENDA
    private JPanel createLegend() {

        JPanel legendPanel = new JPanel();

        legendPanel.setLayout(
            new BoxLayout(
                legendPanel,
                BoxLayout.Y_AXIS
            )
        );

        JLabel title = new JLabel("LEGENDA ROLE");

        title.setFont(
            UIManager.getFont("Label.font")
                .deriveFont(Font.BOLD)
        );

        legendPanel.add(title);

        legendPanel.add(
            Box.createVerticalStrut(15)
        );

        for (CharacterType type :
            CharacterType.values()) {

            JPanel item = new JPanel(
                new FlowLayout(FlowLayout.LEFT)
            );

            JLabel colorBox = new JLabel("     ");

            colorBox.setOpaque(true);

            colorBox.setBackground(
                AppTheme.colorFor(type)
            );

            colorBox.setBorder(
                AppTheme.borderFor(type)
            );

            JLabel roleName = new JLabel(
                type.toString()
            );

            item.add(colorBox);
            item.add(roleName);

            legendPanel.add(item);

            legendPanel.add(
                Box.createVerticalStrut(10)
            );
        }

        legendPanel.add(
            Box.createVerticalGlue()
        );

        legendPanel.setPreferredSize(
            new Dimension(160, 300)
        );

        return legendPanel;
    }

    // STATUS BAR
    private JPanel createStatusBar() {

        JPanel status = new JPanel(
            new BorderLayout()
        );

        JLabel information = new JLabel(
            "Character Manager - Siap digunakan"
        );

        JLabel version = new JLabel("v0.5");

        status.add(
            information,
            BorderLayout.WEST
        );

        status.add(
            version,
            BorderLayout.EAST
        );

        return status;
    }
}
