/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.asia.prpframework;

import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.SimpleIntObjectMap;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.StringUtility;
import de.esolutions.hmi.widgets.audi.base.WidgetConstants;
import de.esolutions.hmi.widgets.audi.evo.prpframework.CharacterRegisterBinarySearch;
import de.esolutions.hmi.widgets.audi.evo.prpframework.ITouchCharacterDefinition;
import de.esolutions.hmi.widgets.audi.evo.prpframework.TouchCharacterDefinitionEurope;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.prpframework.ICharacterRegister;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TouchCharacterDefinitionAsia
implements ITouchCharacterDefinition {
    private static final TouchCharacterDefinitionAsia SINGLETON_INSTANCE = new TouchCharacterDefinitionAsia();
    private static final SimpleIntObjectMap FREETEXT_SYMBOL_ARRAYS = new SimpleIntObjectMap(5);
    private static final SimpleIntObjectMap SYMBOL_REGISTERS_FREETEXT = new SimpleIntObjectMap(5);
    private static final SimpleIntObjectMap SYMBOL_REGISTERS_SMS_EMAIL = new SimpleIntObjectMap(5);
    private static final SimpleIntObjectMap SYMBOL_REGISTERS_GENERAL_MATCHSPELLER = new SimpleIntObjectMap(5);
    private static final SimpleIntObjectMap SYMBOL_REGISTERS_TRUFFLE = new SimpleIntObjectMap(5);
    private static final SimpleIntObjectMap SYMBOL_REGISTERS_PASSWORD = new SimpleIntObjectMap(3);
    private static final SimpleIntObjectMap SYMBOL_REGISTERS_MATCH_HOUSENUMBER = new SimpleIntObjectMap(5);
    private static final char[] SYMBOL_REGISTER_FREETEXT_ASIA_ENGLISH_ALL_COUNTRY;
    private static final ICharacterRegister SYMBOL_REGISTER_FREETEXT_SSID;
    private static final ICharacterRegister SYMBOL_REGISTER_MATCH_MAPCODE_JP;
    private static final ICharacterRegister SYMBOL_REGISTER_PHONE_NUMBER_INPUT;
    private static final ICharacterRegister SYMBOL_REGISTER_MATCH_PHONE_JP_KR;
    private static final SimpleIntObjectMap RESOURCE_PATHS_TO_PASSWORD_SYMBOLS;
    private static final SimpleIntObjectMap RESOURCE_PATHS_TO_FREETEXT_SYMBOLS;
    private static final SimpleIntObjectMap SYMBOL_REGISTERS_ECE_COPIES;

    private TouchCharacterDefinitionAsia() {
    }

    public static ITouchCharacterDefinition getInstance() {
        return SINGLETON_INSTANCE;
    }

    public ICharacterRegister getHWRSymbols(int n, int n2, int n3) {
        if (n3 == 23) {
            return TouchCharacterDefinitionAsia.getHWRSymbolsForAsianLanguages(n, n2, 23);
        }
        if (n3 == 14) {
            return TouchCharacterDefinitionAsia.getHWRSymbolsForAsianLanguages(n, n2, 14);
        }
        if (n3 == 24) {
            return TouchCharacterDefinitionAsia.getHWRSymbolsForAsianLanguages(n, n2, 24);
        }
        if (n3 == 12) {
            return TouchCharacterDefinitionAsia.getHWRSymbolsForAsianLanguages(n, n2, 12);
        }
        if (n3 == 16) {
            return TouchCharacterDefinitionAsia.getHWRSymbolsForAsianLanguages(n, n2, 16);
        }
        if (TouchCharacterDefinitionAsia.isEnglishAsia(n3)) {
            return TouchCharacterDefinitionAsia.getHWRSymbolsForAsianEnglishLanguages(n, n2, n3);
        }
        return TouchCharacterDefinitionEurope.getInstance().getHWRSymbols(n, n2, n3);
    }

    private static boolean isEnglishAsia(int n) {
        boolean bl = false;
        if (n == 15 || n == 25 || n == 13 || n == 17) {
            bl = true;
        }
        return bl;
    }

    private static ICharacterRegister getHWRSymbolsForAsianEnglishLanguages(int n, int n2, int n3) {
        if (!TouchCharacterDefinitionAsia.isEnglishAsia(n3)) {
            return TouchCharacterDefinitionEurope.getInstance().getHWRSymbols(n, n2, n3);
        }
        switch (n) {
            case 32: {
                if (n2 == 6) {
                    return SYMBOL_REGISTER_FREETEXT_SSID;
                }
                return TouchCharacterDefinitionAsia.getFreetextRegister(n3);
            }
            case 53: {
                return TouchCharacterDefinitionAsia.getRegisterBasedOnFreetext(n, n3, SYMBOL_REGISTERS_SMS_EMAIL, WidgetConstants.EMPTY_CHAR_ARRAY, "+,-.".toCharArray());
            }
            case 16: 
            case 17: 
            case 18: 
            case 19: 
            case 21: {
                return TouchCharacterDefinitionAsia.getRegisterBasedOnFreetext(n, n3, SYMBOL_REGISTERS_GENERAL_MATCHSPELLER, "&()".toCharArray(), ",.".toCharArray());
            }
            case 20: {
                return TouchCharacterDefinitionAsia.getMatchHousenumberRegister(n3);
            }
            case 22: {
                return TouchCharacterDefinitionAsia.getMatchMapcodeRegister(n3);
            }
            case 23: {
                return TouchCharacterDefinitionAsia.getMatchPhoneRegister(n3);
            }
            case 114: {
                return TouchCharacterDefinitionAsia.getPhoneNumberInputRegister();
            }
            case 80: 
            case 81: 
            case 82: {
                return TouchCharacterDefinitionAsia.getPasswordRegister(n);
            }
            case 48: 
            case 49: 
            case 50: 
            case 51: 
            case 52: 
            case 54: 
            case 55: {
                return TouchCharacterDefinitionAsia.getRegisterBasedOnFreetext(n, n3, SYMBOL_REGISTERS_TRUFFLE, "#&()*/".toCharArray(), WidgetConstants.EMPTY_CHAR_ARRAY);
            }
            case 33: {
                return SYMBOL_REGISTER_FREETEXT_SSID;
            }
            case 64: 
            case 96: 
            case 97: 
            case 98: 
            case 113: {
                return TouchCharacterDefinitionAsia.getCopyFromEceVersion(n);
            }
        }
        return ICharacterRegister.WHITELIST_ALLOWING_EVERYTHING;
    }

    private static ICharacterRegister getHWRSymbolsForAsianLanguages(int n, int n2, int n3) {
        switch (n) {
            case 32: {
                if (n2 == 6) {
                    return SYMBOL_REGISTER_FREETEXT_SSID;
                }
                return TouchCharacterDefinitionAsia.getFreetextRegister(n3);
            }
            case 53: {
                return TouchCharacterDefinitionAsia.getRegisterBasedOnFreetext(n, n3, SYMBOL_REGISTERS_SMS_EMAIL, WidgetConstants.EMPTY_CHAR_ARRAY, "+,-.\u3002".toCharArray());
            }
            case 16: 
            case 17: 
            case 18: 
            case 19: 
            case 21: {
                return TouchCharacterDefinitionAsia.getRegisterBasedOnFreetext(n, n3, SYMBOL_REGISTERS_GENERAL_MATCHSPELLER, "&()".toCharArray(), ",.\u3002".toCharArray());
            }
            case 20: {
                return TouchCharacterDefinitionAsia.getMatchHousenumberRegister(n3);
            }
            case 22: {
                return TouchCharacterDefinitionAsia.getMatchMapcodeRegister(n3);
            }
            case 23: {
                return TouchCharacterDefinitionAsia.getMatchPhoneRegister(n3);
            }
            case 114: {
                return TouchCharacterDefinitionAsia.getPhoneNumberInputRegister();
            }
            case 80: 
            case 81: 
            case 82: {
                return TouchCharacterDefinitionAsia.getPasswordRegister(n);
            }
            case 48: 
            case 49: 
            case 50: 
            case 51: 
            case 52: 
            case 54: 
            case 55: {
                return TouchCharacterDefinitionAsia.getRegisterBasedOnFreetext(n, n3, SYMBOL_REGISTERS_TRUFFLE, "#&()*/".toCharArray(), "\u3002".toCharArray());
            }
            case 33: {
                return SYMBOL_REGISTER_FREETEXT_SSID;
            }
            case 64: 
            case 96: 
            case 97: 
            case 98: 
            case 113: {
                return TouchCharacterDefinitionAsia.getCopyFromEceVersion(n);
            }
        }
        return ICharacterRegister.WHITELIST_ALLOWING_EVERYTHING;
    }

    private static ICharacterRegister getCopyFromEceVersion(int n) {
        if (SYMBOL_REGISTERS_ECE_COPIES.get(n) == null) {
            char[] cArray = TouchCharacterDefinitionEurope.getHWRSymbolsAsString(n, 1).toCharArray();
            Arrays.sort(cArray);
            ICharacterRegister iCharacterRegister = CharacterRegisterBinarySearch.createInstance(TouchCharacterDefinitionAsia.createRegisterName(n), cArray);
            SYMBOL_REGISTERS_ECE_COPIES.add(n, iCharacterRegister);
        }
        return (ICharacterRegister)SYMBOL_REGISTERS_ECE_COPIES.get(n);
    }

    private static ICharacterRegister getPasswordRegister(int n) {
        if (SYMBOL_REGISTERS_PASSWORD.get(n) == null) {
            char[] cArray = TouchCharacterDefinitionAsia.readFromResourceFile((String)RESOURCE_PATHS_TO_PASSWORD_SYMBOLS.get(n));
            if (cArray == WidgetConstants.EMPTY_CHAR_ARRAY) {
                return ICharacterRegister.WHITELIST_ALLOWING_EVERYTHING;
            }
            ICharacterRegister iCharacterRegister = CharacterRegisterBinarySearch.createInstance(TouchCharacterDefinitionAsia.createRegisterName(n), cArray);
            SYMBOL_REGISTERS_PASSWORD.add(n, iCharacterRegister);
        }
        return (ICharacterRegister)SYMBOL_REGISTERS_PASSWORD.get(n);
    }

    private static ICharacterRegister getPhoneNumberInputRegister() {
        return SYMBOL_REGISTER_PHONE_NUMBER_INPUT;
    }

    private static String createRegisterName(int n) {
        return TouchCharacterDefinitionAsia.createRegisterName(n, -1, false);
    }

    private static String createRegisterName(int n, int n2, boolean bl) {
        String string = n == 50 || n == 49 || n == 48 || n == 54 || n == 51 || n == 52 || n == 55 ? "truffle" : (n == 18 || n == 17 || n == 19 || n == 21 || n == 16 ? "general matchspeller" : TouchCharacterDefinitionAsia.touchpadModeToString(n));
        Buffer buffer = new Buffer(string);
        if (bl) {
            buffer.append(" ");
            buffer.append(n2);
        }
        return buffer.toString();
    }

    private static String touchpadModeToString(int n) {
        String string;
        switch (n) {
            case 32: {
                string = "general freetext";
                break;
            }
            case 53: {
                string = "SMS/Email";
                break;
            }
            case 18: {
                string = "matchspeller navigation destination city";
                break;
            }
            case 17: {
                string = "matchspeller navigation destination country";
                break;
            }
            case 19: {
                string = "matchspeller navigation destination street";
                break;
            }
            case 21: {
                string = "matchspeller phone standard";
                break;
            }
            case 16: {
                string = "matchspeller general";
                break;
            }
            case 20: {
                string = "match housenumber";
                break;
            }
            case 22: {
                string = "matchspeller mapcode";
                break;
            }
            case 23: {
                string = "matchspeller phone";
                break;
            }
            case 114: {
                string = "phone number input";
                break;
            }
            case 80: {
                string = "password input general";
                break;
            }
            case 81: {
                string = "password input WLAN-APN";
                break;
            }
            case 82: {
                string = "password input WLAN-Client";
                break;
            }
            case 50: {
                string = "truffle address book";
                break;
            }
            case 49: {
                string = "truffle favorites";
                break;
            }
            case 48: {
                string = "truffle general";
                break;
            }
            case 54: {
                string = "truffle google online";
                break;
            }
            case 51: {
                string = "truffle navigation";
                break;
            }
            case 52: {
                string = "truffle phone";
                break;
            }
            case 55: {
                string = "truffle phone call list";
                break;
            }
            case 33: {
                string = "freetext SSID";
                break;
            }
            case 113: {
                string = "DTMF input";
                break;
            }
            case 97: {
                string = "messaging email recipient";
                break;
            }
            case 96: {
                string = "messaging multiline";
                break;
            }
            case 98: {
                string = "messaging SMS recipient";
                break;
            }
            case 64: {
                string = "PIN input";
                break;
            }
            default: {
                string = "unknown touchpad mode";
            }
        }
        return string;
    }

    private static ICharacterRegister getMatchPhoneRegister(int n) {
        if (n == 12 || n == 16) {
            return SYMBOL_REGISTER_MATCH_PHONE_JP_KR;
        }
        return ICharacterRegister.WHITELIST_ALLOWING_EVERYTHING;
    }

    private static ICharacterRegister getMatchMapcodeRegister(int n) {
        if (n == 12) {
            return SYMBOL_REGISTER_MATCH_MAPCODE_JP;
        }
        return ICharacterRegister.WHITELIST_ALLOWING_EVERYTHING;
    }

    private static ICharacterRegister getMatchHousenumberRegister(int n) {
        return (ICharacterRegister)SYMBOL_REGISTERS_MATCH_HOUSENUMBER.get(n);
    }

    private static ICharacterRegister getFreetextRegister(int n) {
        if (SYMBOL_REGISTERS_FREETEXT.get(n) == null) {
            if (!TouchCharacterDefinitionAsia.isEnglishAsia(n) && RESOURCE_PATHS_TO_FREETEXT_SYMBOLS.get(n) == null) {
                IWidgetLogChannel.tpLogChannelInternal.log(10000, "TouchCharacterDefinitionAsia#getFreetextSymbols: Could not find resource path for language %1.", (long)n);
                return ICharacterRegister.WHITELIST_ALLOWING_EVERYTHING;
            }
            char[] cArray = TouchCharacterDefinitionAsia.getFreetextSymbolArray(n);
            if (cArray.length == 0) {
                return ICharacterRegister.WHITELIST_ALLOWING_EVERYTHING;
            }
            String string = TouchCharacterDefinitionAsia.createRegisterName(32, n, true);
            SYMBOL_REGISTERS_FREETEXT.add(n, (CharacterRegisterBinarySearch)CharacterRegisterBinarySearch.createInstance(string, cArray));
        }
        return (ICharacterRegister)SYMBOL_REGISTERS_FREETEXT.get(n);
    }

    private static char[] getFreetextSymbolArray(int n) {
        if (FREETEXT_SYMBOL_ARRAYS.get(n) == null) {
            String string = (String)RESOURCE_PATHS_TO_FREETEXT_SYMBOLS.get(n);
            char[] cArray = TouchCharacterDefinitionAsia.readFromResourceFile(string);
            if (cArray == WidgetConstants.EMPTY_CHAR_ARRAY) {
                return WidgetConstants.EMPTY_CHAR_ARRAY;
            }
            FREETEXT_SYMBOL_ARRAYS.add(n, cArray);
        }
        return (char[])FREETEXT_SYMBOL_ARRAYS.get(n);
    }

    private static ICharacterRegister getRegisterBasedOnFreetext(int n, int n2, SimpleIntObjectMap simpleIntObjectMap, char[] cArray, char[] cArray2) {
        if (simpleIntObjectMap.get(n2) == null) {
            if (TouchCharacterDefinitionAsia.getFreetextRegister(n2) == ICharacterRegister.WHITELIST_ALLOWING_EVERYTHING) {
                return ICharacterRegister.WHITELIST_ALLOWING_EVERYTHING;
            }
            char[] cArray3 = (char[])FREETEXT_SYMBOL_ARRAYS.get(n2);
            String string = TouchCharacterDefinitionAsia.createRegisterName(n, n2, true);
            CharacterRegisterBinarySearch characterRegisterBinarySearch = (CharacterRegisterBinarySearch)CharacterRegisterBinarySearch.createInstance(string, cArray3, cArray, cArray2);
            simpleIntObjectMap.add(n2, characterRegisterBinarySearch);
        }
        return (ICharacterRegister)simpleIntObjectMap.get(n2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static char[] readFromResourceFile(String string) {
        BufferedReader bufferedReader = null;
        try {
            File file = new File(string);
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
            int n = bufferedReader.read();
            char[] cArray = new char[n];
            bufferedReader.read(cArray);
            char[] cArray2 = cArray;
            return cArray2;
        }
        catch (Exception exception) {
            IWidgetLogChannel.tpLogChannelInternal.log(10000, "TouchCharacterDefinitionAsia#readFromResourceFile: Could not read resource file %1. Error message: %2", (Object)string, (Object)exception.getMessage());
            char[] cArray = WidgetConstants.EMPTY_CHAR_ARRAY;
            return cArray;
        }
        finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            }
            catch (Exception exception) {
                IWidgetLogChannel.tpLogChannelInternal.log(100000, "TouchCharacterDefinitionAsia#readFromResourceFile: Could not close BufferedReader. Error message: %1", (Object)exception.getMessage());
            }
        }
    }

    public ICharacterRegister getBlackList(int n, boolean bl) {
        return TouchCharacterDefinitionEurope.getInstance().getBlackList(n, bl);
    }

    static {
        ICharacterRegister iCharacterRegister = CharacterRegisterBinarySearch.createInstance(TouchCharacterDefinitionAsia.createRegisterName(20, 14, true), "\b-0123456789".toCharArray());
        ICharacterRegister iCharacterRegister2 = CharacterRegisterBinarySearch.createInstance(TouchCharacterDefinitionAsia.createRegisterName(20, 23, true), "0123456789".toCharArray());
        ICharacterRegister iCharacterRegister3 = CharacterRegisterBinarySearch.createInstance(TouchCharacterDefinitionAsia.createRegisterName(20, 24, true), "\b-0123456789".toCharArray());
        ICharacterRegister iCharacterRegister4 = CharacterRegisterBinarySearch.createInstance(TouchCharacterDefinitionAsia.createRegisterName(20, 12, true), "\b-0123456789".toCharArray());
        ICharacterRegister iCharacterRegister5 = CharacterRegisterBinarySearch.createInstance(TouchCharacterDefinitionAsia.createRegisterName(20, 16, true), "\b-0123456789\uc0b0".toCharArray());
        SYMBOL_REGISTERS_MATCH_HOUSENUMBER.add(14, iCharacterRegister);
        SYMBOL_REGISTERS_MATCH_HOUSENUMBER.add(23, iCharacterRegister2);
        SYMBOL_REGISTERS_MATCH_HOUSENUMBER.add(24, iCharacterRegister3);
        SYMBOL_REGISTERS_MATCH_HOUSENUMBER.add(12, iCharacterRegister4);
        SYMBOL_REGISTERS_MATCH_HOUSENUMBER.add(16, iCharacterRegister5);
        SYMBOL_REGISTER_FREETEXT_ASIA_ENGLISH_ALL_COUNTRY = " +,-.0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();
        FREETEXT_SYMBOL_ARRAYS.add(15, SYMBOL_REGISTER_FREETEXT_ASIA_ENGLISH_ALL_COUNTRY);
        FREETEXT_SYMBOL_ARRAYS.add(25, SYMBOL_REGISTER_FREETEXT_ASIA_ENGLISH_ALL_COUNTRY);
        FREETEXT_SYMBOL_ARRAYS.add(13, SYMBOL_REGISTER_FREETEXT_ASIA_ENGLISH_ALL_COUNTRY);
        FREETEXT_SYMBOL_ARRAYS.add(17, SYMBOL_REGISTER_FREETEXT_ASIA_ENGLISH_ALL_COUNTRY);
        SYMBOL_REGISTER_FREETEXT_SSID = CharacterRegisterBinarySearch.createInstance(TouchCharacterDefinitionAsia.createRegisterName(33), " +,-.0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray());
        SYMBOL_REGISTER_MATCH_MAPCODE_JP = CharacterRegisterBinarySearch.createInstance(TouchCharacterDefinitionAsia.createRegisterName(22), "*0123456789".toCharArray());
        SYMBOL_REGISTER_PHONE_NUMBER_INPUT = CharacterRegisterBinarySearch.createInstance(TouchCharacterDefinitionAsia.createRegisterName(114), "\b#*+0123456789".toCharArray());
        SYMBOL_REGISTER_MATCH_PHONE_JP_KR = CharacterRegisterBinarySearch.createInstance(TouchCharacterDefinitionAsia.createRegisterName(23), "#*+0123456789".toCharArray());
        RESOURCE_PATHS_TO_PASSWORD_SYMBOLS = new SimpleIntObjectMap(3);
        RESOURCE_PATHS_TO_PASSWORD_SYMBOLS.add(80, StringUtility.concatenate(System.getProperty("SpellerCharacterSetPath"), "/HWR_symbols_password.tcd"));
        RESOURCE_PATHS_TO_PASSWORD_SYMBOLS.add(81, StringUtility.concatenate(System.getProperty("SpellerCharacterSetPath"), "/HWR_symbols_password_wlan.tcd"));
        RESOURCE_PATHS_TO_PASSWORD_SYMBOLS.add(82, StringUtility.concatenate(System.getProperty("SpellerCharacterSetPath"), "/HWR_symbols_password_wlan.tcd"));
        RESOURCE_PATHS_TO_FREETEXT_SYMBOLS = new SimpleIntObjectMap(5);
        RESOURCE_PATHS_TO_FREETEXT_SYMBOLS.add(14, StringUtility.concatenate(System.getProperty("SpellerCharacterSetPath"), "/china/HWR_symbols_CN_general_freetext.tcd"));
        RESOURCE_PATHS_TO_FREETEXT_SYMBOLS.add(23, StringUtility.concatenate(System.getProperty("SpellerCharacterSetPath"), "/china/HWR_symbols_HK_general_freetext.tcd"));
        RESOURCE_PATHS_TO_FREETEXT_SYMBOLS.add(12, StringUtility.concatenate(System.getProperty("SpellerCharacterSetPath"), "/japan/HWR_symbols_JP_general_freetext.tcd"));
        RESOURCE_PATHS_TO_FREETEXT_SYMBOLS.add(16, StringUtility.concatenate(System.getProperty("SpellerCharacterSetPath"), "/korea/HWR_symbols_KR_general_freetext.tcd"));
        RESOURCE_PATHS_TO_FREETEXT_SYMBOLS.add(24, StringUtility.concatenate(System.getProperty("SpellerCharacterSetPath"), "/taiwan/HWR_symbols_TW_general_freetext.tcd"));
        SYMBOL_REGISTERS_ECE_COPIES = new SimpleIntObjectMap();
    }
}

