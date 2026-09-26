/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.asia.prpframework;

import de.esolutions.hmi.widgets.audi.base.WidgetConstants;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.prpframework.CharacterMap$1;
import java.util.Arrays;

public class CharacterMap$InternalCharacterMap {
    protected final char[] simplifiedCharacters;
    private final char[][] mappedCharacters;

    private CharacterMap$InternalCharacterMap(char[] cArray, char[][] cArray2) {
        this.simplifiedCharacters = cArray;
        this.mappedCharacters = cArray2;
    }

    private char[] getMappedCharacters(char c2) {
        int n = Arrays.binarySearch(this.simplifiedCharacters, c2);
        if (n < 0) {
            return WidgetConstants.EMPTY_CHAR_ARRAY;
        }
        return this.mappedCharacters[n];
    }

    static /* synthetic */ char[] access$000(CharacterMap$InternalCharacterMap characterMap$InternalCharacterMap, char c2) {
        return characterMap$InternalCharacterMap.getMappedCharacters(c2);
    }

    /* synthetic */ CharacterMap$InternalCharacterMap(char[] cArray, char[][] cArray2, CharacterMap$1 characterMap$1) {
        this(cArray, cArray2);
    }
}

