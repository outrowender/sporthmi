/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.asia.prpframework;

import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.StringUtility;
import de.esolutions.hmi.widgets.audi.base.WidgetConstants;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.prpframework.CharacterMap$InternalCharacterMap;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.prpframework.ICharacterMap;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public final class CharacterMap
implements ICharacterMap {
    protected static final String RESOURCE_PATH_SIMPLIFILED_TRADITIONAL_MAP = StringUtility.concatenate(System.getProperty("SpellerCharacterSetPath"), "/HK_TW_simplified_traditional_mapping.txt");
    protected static final String RESOURCE_PATH_WEIRD_RADICAL_SIMPLIFIED = StringUtility.concatenate(System.getProperty("SpellerCharacterSetPath"), "/Weird_Radicals_mapping_simplified.txt");
    protected static final String RESOURCE_PATH_WEIRD_RADICAL_TRADITIONAL = StringUtility.concatenate(System.getProperty("SpellerCharacterSetPath"), "/Weird_Radicals_mapping_traditional.txt");
    private static CharacterMap instance;
    private static CharacterMap$InternalCharacterMap characterSimplifiedTraditionalMap;
    private static CharacterMap$InternalCharacterMap characterWeirdRadicalSimplifiedMap;
    private static CharacterMap$InternalCharacterMap characterWeirdRadicalTraditionalMap;
    public static final int MAP_SIMPLIFIED_TRADITIONAL;
    public static final int MAP_WEIRD_RADICAL_SIMPLIFIED;
    public static final int MAP_WEIRD_RADICAL_TRADITIONAL;

    private CharacterMap() {
    }

    public static synchronized ICharacterMap getInstance() {
        if (instance == null) {
            instance = new CharacterMap();
        }
        return instance;
    }

    @Override
    public char[] getMappedCharacters(char c2, int n) {
        CharacterMap$InternalCharacterMap characterMap$InternalCharacterMap = null;
        switch (n) {
            case 0: {
                characterMap$InternalCharacterMap = characterSimplifiedTraditionalMap;
                break;
            }
            case 1: {
                characterMap$InternalCharacterMap = characterWeirdRadicalSimplifiedMap;
                break;
            }
            case 2: {
                characterMap$InternalCharacterMap = characterWeirdRadicalTraditionalMap;
                break;
            }
            default: {
                IWidgetLogChannel.logPRPEngine.log(14808325, "CharactersMap#getMappedCharacters the required map type is wrong. 1% is not defined! Return Empty Array", (long)n);
                return WidgetConstants.EMPTY_CHAR_ARRAY;
            }
        }
        if (characterMap$InternalCharacterMap == null) {
            characterMap$InternalCharacterMap = this.createCharacterMap(n);
        }
        if (characterMap$InternalCharacterMap != null) {
            return CharacterMap$InternalCharacterMap.access$000(characterMap$InternalCharacterMap, c2);
        }
        return WidgetConstants.EMPTY_CHAR_ARRAY;
    }

    private CharacterMap$InternalCharacterMap createCharacterMap(int n) {
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
        IWidgetLogChannel.logPRPEngine.log(14808325, "CharactersMap#createCharacterMap the required map type is wrong. 1% is not defined! Return Empty Array", (long)n);
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected static CharacterMap$InternalCharacterMap parseMappingsFromResourceFile(String string) {
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
            CharacterMap$InternalCharacterMap characterMap$InternalCharacterMap = new CharacterMap$InternalCharacterMap(cArray, cArrayArray, null);
            return characterMap$InternalCharacterMap;
        }
        catch (Exception exception) {
            IWidgetLogChannel.tpLogChannelInternal.log(10000, "SimplifiedTraditionalMap#parseMappingsFromResourceFile: Could not read resource file %1.", (Object)string);
            if (IWidgetLogChannel.tpLogChannelInternal.isDebug()) {
                IWidgetLogChannel.tpLogChannelInternal.log(-2137614336, "", (Throwable)exception);
            }
            CharacterMap$InternalCharacterMap characterMap$InternalCharacterMap = null;
            return characterMap$InternalCharacterMap;
        }
        finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            }
            catch (Exception exception) {
                IWidgetLogChannel.tpLogChannelInternal.log(-1601830656, "SimplifiedTraditionalMap#parseMappingsFromResourceFile: Could not close BufferedReader. Error message: %1", (Object)exception.getMessage());
            }
        }
    }

    static {
        characterSimplifiedTraditionalMap = null;
        characterWeirdRadicalSimplifiedMap = null;
        characterWeirdRadicalTraditionalMap = null;
    }
}

