
package com.unpri.charactermanager.model;

import java.util.ArrayList;

public class CharacterManager {

    private final ArrayList<Character> characters = new ArrayList<>();

    // Menambahkan karakter jika namanya belum terdaftar
    public boolean addCharacter(Character character) {
        if (character == null) {
            return false;
        }

        if (findByName(character.getName()) != null) {
            System.out.println(
                "Karakter dengan nama " + character.getName()
                + " sudah ada."
            );
            return false;
        }

        characters.add(character);
        return true;
    }

    // Mencari karakter berdasarkan nama
    public Character findByName(String name) {
        if (name == null) {
            return null;
        }

        for (Character character : characters) {
            if (character.getName().equalsIgnoreCase(name)) {
                return character;
            }
        }

        return null;
    }

    // Menghapus karakter berdasarkan nama
    public boolean removeCharacter(String name) {
        Character character = findByName(name);

        if (character != null) {
            characters.remove(character);
            return true;
        }

        return false;
    }

    // Menghitung jumlah karakter
    public int getTotalCharacters() {
        return characters.size();
    }

    // Mengambil daftar karakter
    public ArrayList<Character> getAllCharacters() {
        return new ArrayList<>(characters);
    }

    // Menghitung rata-rata level karakter
    public double getAverageLevel() {
        if (characters.isEmpty()) {
            return 0.0;
        }

        int totalLevel = 0;

        for (Character character : characters) {
            totalLevel += character.getLevel();
        }

        return (double) totalLevel / characters.size();
    }

    // Mencari karakter berdasarkan tipe
    public ArrayList<Character> findByType(CharacterType type) {
        ArrayList<Character> result = new ArrayList<>();

        for (Character character : characters) {
            if (character.getType() == type) {
                result.add(character);
            }
        }

        return result;
    }

    // Menghitung jumlah karakter berdasarkan tipe
    public int countByType(CharacterType type) {
        int count = 0;

        for (Character character : characters) {
            if (character.getType() == type) {
                count++;
            }
        }

        return count;
    }
}
