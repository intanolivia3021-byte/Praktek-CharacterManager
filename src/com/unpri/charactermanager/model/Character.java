package com.unpri.charactermanager.model;

import java.util.Objects;

public class Character {
    private String name;
    private int level;
    private CharacterType type;

    private static int totalCharacterCreated = 0;

    public Character(String name, int level, CharacterType type) {
        this.name = name;
        this.level = level;
        this.type = type;
        totalCharacterCreated++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public CharacterType getType() {
        return type;
    }

    public void setType(CharacterType type) {
        this.type = type;
    }

    public static int getTotalCharacterCreated() {
        return totalCharacterCreated;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Character)) {
            return false;
        }

        Character other = (Character) obj;

        return name != null
                && other.name != null
                && name.equalsIgnoreCase(other.name);
    }

    @Override
    public int hashCode() {
        return name == null ? 0 : name.toLowerCase().hashCode();
    }

    @Override
    public String toString() {
        return "Character{name='" + name
                + "', level=" + level
                + ", type=" + type + "}";
    }
}