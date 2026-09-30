/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.prpframework;

import de.esolutions.hmi.widgets.audi.base.WidgetConstants;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.prpframework.ICharacterRegister;
import java.util.Arrays;

public final class CharacterRegisterBinarySearch
implements ICharacterRegister {
    private final String name;
    private final char[] characters;
    private final char[] additionalCharacters;
    private final char[] subtractedCharacters;

    private CharacterRegisterBinarySearch(String string, char[] cArray, char[] cArray2, char[] cArray3) {
        this.name = string;
        this.characters = cArray;
        this.additionalCharacters = cArray2;
        this.subtractedCharacters = cArray3;
    }

    public static ICharacterRegister createInstance(String string, char[] cArray) {
        return new CharacterRegisterBinarySearch(string, cArray, WidgetConstants.EMPTY_CHAR_ARRAY, WidgetConstants.EMPTY_CHAR_ARRAY);
    }

    public static ICharacterRegister createInstance(String string, char[] cArray, char[] cArray2, char[] cArray3) {
        return new CharacterRegisterBinarySearch(string, cArray, cArray2, cArray3);
    }

    public boolean contains(char c2) {
        if (Arrays.binarySearch(this.subtractedCharacters, c2) >= 0) {
            return false;
        }
        if (Arrays.binarySearch(this.additionalCharacters, c2) >= 0) {
            return true;
        }
        return Arrays.binarySearch(this.characters, c2) >= 0;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return "CharacterRegisterBinarySearch [name=" + this.name + "]";
    }

    protected char[] getCharacters() {
        return (char[])this.characters.clone();
    }

    protected char[] getAdditionalCharacters() {
        return (char[])this.additionalCharacters.clone();
    }

    protected char[] getBlacklistedCharacters() {
        return (char[])this.subtractedCharacters.clone();
    }

    public int getSize() {
        int n;
        int n2 = this.characters.length;
        for (n = 0; n < this.additionalCharacters.length; ++n) {
            if (Arrays.binarySearch(this.characters, this.additionalCharacters[n]) == -1) continue;
            ++n2;
        }
        for (n = 0; n < this.subtractedCharacters.length; ++n) {
            if (Arrays.binarySearch(this.characters, this.subtractedCharacters[n]) == -1 && Arrays.binarySearch(this.additionalCharacters, this.subtractedCharacters[n]) == -1) continue;
            --n2;
        }
        return n2;
    }

    public boolean containsIgnoreCase(char c2) {
        if (Arrays.binarySearch(this.subtractedCharacters, c2) >= 0 || Arrays.binarySearch(this.subtractedCharacters, this.convertCase(c2)) >= 0) {
            return false;
        }
        if (Arrays.binarySearch(this.additionalCharacters, c2) >= 0 || Arrays.binarySearch(this.additionalCharacters, this.convertCase(c2)) >= 0) {
            return true;
        }
        return Arrays.binarySearch(this.characters, c2) >= 0 || Arrays.binarySearch(this.characters, this.convertCase(c2)) >= 0;
    }

    private char convertCase(char c2) {
        if (c2 == '\u0131') {
            return '\u0130';
        }
        if (c2 == '\u0130') {
            return '\u0131';
        }
        return Character.isLowerCase(c2) ? Character.toUpperCase(c2) : Character.toLowerCase(c2);
    }
}

