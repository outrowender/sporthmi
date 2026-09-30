/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.asia.prpframework;

import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.StringUtility;
import de.esolutions.hmi.widgets.audi.base.WidgetConstants;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.prpframework.ICharacterMap;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public final class CharacterMap
implements ICharacterMap {
    protected static final String RESOURCE_PATH_SIMPLIFILED_TRADITIONAL_MAP = StringUtility.concatenate(System.getProperty("SpellerCharacterSetPath"), "/HK_TW_simplified_traditional_mapping.txt");
    protected static final String RESOURCE_PATH_WEIRD_RADICAL_SIMPLIFIED = StringUtility.concatenate(System.getProperty("SpellerCharacterSetPath"), "/Weird_Radicals_mapping_simplified.txt");
    protected static final String RESOURCE_PATH_WEIRD_RADICAL_TRADITIONAL = StringUtility.concatenate(System.getProperty("SpellerCharacterSetPath"), "/Weird_Radicals_mapping_traditional.txt");
    private static CharacterMap instance;
    private static InternalCharacterMap characterSimplifiedTraditionalMap;
    private static InternalCharacterMap characterWeirdRadicalSimplifiedMap;
    private static InternalCharacterMap characterWeirdRadicalTraditionalMap;
    public static final int MAP_SIMPLIFIED_TRADITIONAL = 0;
    public static final int MAP_WEIRD_RADICAL_SIMPLIFIED = 1;
    public static final int MAP_WEIRD_RADICAL_TRADITIONAL = 2;

    private CharacterMap() {
    }

    public static synchronized ICharacterMap getInstance() {
        if (instance == null) {
            instance = new CharacterMap();
        }
        return instance;
    }

    public char[] getMappedCharacters(char c2, int n) {
        InternalCharacterMap internalCharacterMap = null;
        switch (n) {
            case 0: {
                internalCharacterMap = characterSimplifiedTraditionalMap;
                break;
            }
            case 1: {
                internalCharacterMap = characterWeirdRadicalSimplifiedMap;
                break;
            }
            case 2: {
                internalCharacterMap = characterWeirdRadicalTraditionalMap;
                break;
            }
            default: {
                IWidgetLogChannel.logPRPEngine.log(100000000, "CharactersMap#getMappedCharacters the required map type is wrong. 1% is not defined! Return Empty Array", (long)n);
                return WidgetConstants.EMPTY_CHAR_ARRAY;
            }
        }
        if (internalCharacterMap == null) {
            internalCharacterMap = this.createCharacterMap(n);
        }
        if (internalCharacterMap != null) {
            return internalCharacterMap.getMappedCharacters(c2);
        }
        return WidgetConstants.EMPTY_CHAR_ARRAY;
    }

    private InternalCharacterMap createCharacterMap(int n) {
        switch (n) {
            case 0: {
                return CharacterMap.parseMappingsFromResourceFile(RESOURCE_PATH_SIMPLIFILED_TRADITIONAL_MAP);
            }
            case 1: {
                return CharacterMap.parseMappingsFromResourceFile(RESOURCE_PATH_WEIRD_RADICAL_SIMPLIFIED);
            }
            case 2: {
                return CharacterMap.parseMappingsFromResourceFile(RESOURCE_PATH_WEIRD_RADICAL_TRADITIONAL);
            }
        }
        IWidgetLogChannel.logPRPEngine.log(100000000, "CharactersMap#createCharacterMap the required map type is wrong. 1% is not defined! Return Empty Array", (long)n);
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected static InternalCharacterMap parseMappingsFromResourceFile(String string) {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(string), "UTF-8"));
            int n = Integer.parseInt(bufferedReader.readLine());
            char[] cArray = new char[n];
            char[][] cArrayArray = new char[n][];
            String string2 = bufferedReader.readLine();
            while (string2 != null && string2.startsWith("#")) {
                string2 = bufferedReader.readLine();
            }
            for (int i2 = 0; i2 < n; ++i2) {
                cArray[i2] = string2.charAt(0);
                int n2 = string2.length() - 1;
                cArrayArray[i2] = new char[n2];
                System.arraycopy((Object)string2.toCharArray(), 1, (Object)cArrayArray[i2], 0, n2);
                string2 = bufferedReader.readLine();
            }
            InternalCharacterMap internalCharacterMap = new InternalCharacterMap(cArray, cArrayArray);
            return internalCharacterMap;
        }
        catch (Exception exception) {
            IWidgetLogChannel.tpLogChannelInternal.log(10000, "SimplifiedTraditionalMap#parseMappingsFromResourceFile: Could not read resource file %1.", (Object)string);
            if (IWidgetLogChannel.tpLogChannelInternal.isDebug()) {
                IWidgetLogChannel.tpLogChannelInternal.log(10000000, "", (Throwable)exception);
            }
            InternalCharacterMap internalCharacterMap = null;
            return internalCharacterMap;
        }
        finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            }
            catch (Exception exception) {
                IWidgetLogChannel.tpLogChannelInternal.log(100000, "SimplifiedTraditionalMap#parseMappingsFromResourceFile: Could not close BufferedReader. Error message: %1", (Object)exception.getMessage());
            }
        }
    }

    static {
        characterSimplifiedTraditionalMap = null;
        characterWeirdRadicalSimplifiedMap = null;
        characterWeirdRadicalTraditionalMap = null;
    }

    protected static class InternalCharacterMap {
        protected final char[] simplifiedCharacters;
        private final char[][] mappedCharacters;

        private InternalCharacterMap(char[] cArray, char[][] cArray2) {
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
    }
}

