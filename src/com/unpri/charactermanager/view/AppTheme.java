package com.unpri.charactermanager.view;

import com.unpri.charactermanager.model.CharacterType;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

public final class AppTheme {

    private AppTheme() {
    }

    // Warna
    public static final Color BACKGROUND =
            new Color(245, 247, 250);

    public static final Color CARD_BACKGROUND =
            Color.WHITE;

    public static final Color PRIMARY =
            new Color(35, 55, 80);

    public static final Color TEXT =
            new Color(45, 52, 60);

    public static final Color GOLD =
            new Color(190, 145, 20);

    public static final Color BORDER_COLOR =
            new Color(220, 225, 232);

    // Font
    public static final Font TITLE_FONT =
            new Font("SansSerif", Font.BOLD, 24);

    public static final Font NORMAL_FONT =
            new Font("SansSerif", Font.PLAIN, 14);

    public static final Font BOLD_FONT =
            new Font("SansSerif", Font.BOLD, 14);

    public static final Font LEVEL_FONT =
            new Font("Monospaced", Font.BOLD, 16);

    // Border
    public static final Border CARD_BORDER =
            BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(BORDER_COLOR),
                    BorderFactory.createEmptyBorder(12, 12, 12, 12)
            );

    // Warna berdasarkan role
    public static Color colorFor(CharacterType type) {
        if (type == null) {
            return BORDER_COLOR;
        }

        switch (type) {
            case WARRIOR:
                return new Color(255, 228, 225);
            case MAGE:
                return new Color(230, 225, 255);
            case ARCHER:
                return new Color(220, 245, 225);
            case HEALER:
                return new Color(220, 240, 250);
            default:
                return BORDER_COLOR;
        }
    }

    // Border berdasarkan role
    public static Border borderFor(CharacterType type) {
        return BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(colorFor(type), 3),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        );
    }
}