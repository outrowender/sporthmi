/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.prpframework;

import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.WidgetConstants;
import de.esolutions.hmi.widgets.audi.evo.prpframework.CharacterRegisterBinarySearch;
import de.esolutions.hmi.widgets.audi.evo.prpframework.ITouchCharacterDefinition;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.prpframework.ICharacterRegister;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TouchCharacterDefinitionEurope
implements ITouchCharacterDefinition {
    private static final TouchCharacterDefinitionEurope SINGLETON_INSTANCE = new TouchCharacterDefinitionEurope();
    private static boolean isNAR = false;
    private static final String SPACE = " ";
    private static final String CARRIAGE_RETURN = "\r";
    private static final String LATIN = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz";
    private static final String LATIN_EXTENDED = "\u00c0\u00c1\u00c2\u00c3\u00c4\u00c5\u00c6\u00c7\u00c8\u00c9\u00ca\u00cb\u00cc\u00cd\u00ce\u00cf\u00d1\u00d2\u00d3\u00d4\u00d5\u00d6\u00d8\u00d9\u00da\u00db\u00dc\u00dd\u00de\u00df\u00e0\u00e1\u00e2\u00e3\u00e4\u00e5\u00e6\u00e7\u00e8\u00e9\u00ea\u00eb\u00ec\u00ed\u00ee\u00ef\u00f0\u00f1\u00f2\u00f3\u00f4\u00f5\u00f6\u00f8\u00f9\u00fa\u00fb\u00fc\u00fd\u00fe\u00ff\u0100\u0101\u0102\u0103\u0104\u0105\u0106\u0107\u010a\u010b\u010c\u010d\u010e\u010f\u0110\u0111\u0112\u0113\u0116\u0117\u0118\u0119\u011a\u011b\u011e\u011f\u0120\u0121\u0122\u0123\u0126\u0127\u0128\u0129\u012a\u012b\u012e\u012f\u0130\u0131\u0136\u0137\u0139\u013a\u013b\u013c\u013d\u013e\u0141\u0142\u0143\u0144\u0145\u0146\u0147\u0148\u0150\u0151\u0152\u0153\u0154\u0155\u0158\u0159\u015a\u015b\u015e\u015f\u0160\u0161\u0162\u0163\u0164\u0165\u0168\u0169\u016a\u016b\u016e\u016f\u0170\u0171\u0172\u0173\u0179\u017a\u017b\u017c\u017d\u017e";
    private static final String CONTROL = "\r ";
    private static final String CYRILLIC = "\u0401\u0402\u0403\u0404\u0405\u0406\u0407\u0408\u0409\u040a\u040b\u040c\u040e\u040f\u0410\u0411\u0412\u0413\u0414\u0415\u0416\u0417\u0418\u0419\u041a\u041b\u041c\u041d\u041e\u041f\u0420\u0421\u0422\u0423\u0424\u0425\u0426\u0427\u0428\u0429\u042a\u042b\u042c\u042d\u042e\u042f\u0430\u0431\u0432\u0433\u0434\u0435\u0436\u0437\u0438\u0439\u043a\u043b\u043c\u043d\u043e\u043f\u0440\u0441\u0442\u0443\u0444\u0445\u0446\u0447\u0448\u0449\u044a\u044b\u044c\u044d\u044e\u044f\u0451\u0452\u0453\u0454\u0455\u0456\u0457\u0458\u0459\u045a\u045b\u045c\u045e\u045f\u0490\u0491\u0492\u0493\u049a\u049b\u04a2\u04a3\u04ae\u04af\u04b0\u04b1\u04ba\u04bb\u04c0\u04c1\u04c2\u04d2\u04d3\u04d8\u04d9\u04e6\u04e7\u04e8\u04e9\u04f0\u04f1";
    private static final String ARABIC = "\u0627\u0628\u062a\u062b\u062c\u062d\u062e\u062f\u0630\u0631\u0632\u0633\u0634\u0635\u0636\u0637\u0638\u0639\u063a\u0641\u0642\u0643\u0644\u0645\u0646\u0647\u0648\u064a\u0629\u0649\ufefb\u0621 ";
    public static final String NUMBERS = "0123456789";
    private static final String NUMBERS_AND_TOUCH_SYMBOLS = "!\"#$%&'()*+,-./0123456789:;<=>?@~\u00a1\u00a2\u00a3\u00a7\u00bf\u20ac";
    private static final String NUMBERS_AND_TOUCH_SYMBOLS_PASSWORD = "!#$%&*+-./0123456789:=?@~\u00a1\u00a2\u00a3\u00a7\u00bf\u20ac";
    private static final String DIACRITC_CZ = "\u00c1\u00c9\u00cd\u00d3\u00da\u00dd\u00e1\u00e9\u00ed\u00f3\u00fa\u00fd\u010c\u010d\u010e\u010f\u011a\u011b\u0139\u013a\u0147\u0148\u0154\u0155\u0158\u0159\u0160\u0161\u0164\u0165\u016e\u016f\u017d\u017e";
    private static final String DIACRITC_FR = "\u00c0\u00c2\u00c6\u00c7\u00c8\u00c9\u00ca\u00cb\u00ce\u00cf\u00d4\u00d9\u00db\u00dc\u00e0\u00e2\u00e6\u00e7\u00e8\u00e9\u00ea\u00eb\u00ee\u00ef\u00f4\u00f9\u00fb\u00fc\u00ff\u008c\u009c";
    private static final String DIACRITC_DE = "\u00c4\u00c9\u00d6\u00dc\u00df\u00e4\u00e9\u00f6\u00fc";
    private static final String DIACRITC_IT = "\u00c0\u00c1\u00c4\u00c8\u00c9\u00cc\u00d2\u00d3\u00d6\u00d9\u00da\u00dc\u00e0\u00e1\u00e4\u00e8\u00e9\u00ec\u00f2\u00f3\u00f6\u00f9\u00fa\u00fc";
    private static final String DIACRITC_NL = "\u00c0\u00c1\u00c2\u00c7\u00c8\u00c9\u00ca\u00cb\u00ce\u00cf\u00d4\u00d6\u00db\u00dc\u00e0\u00e1\u00e2\u00e7\u00e8\u00e9\u00ea\u00eb\u00ee\u00ef\u00f4\u00f6\u00fb\u00fc";
    private static final String DIACRITC_NO = "\u00c5\u00c6\u00c8\u00c9\u00d8\u00dc\u00e5\u00e6\u00e8\u00e9\u00f8\u00fc";
    private static final String DIACRITC_PL = "\u00d3\u00f3\u0104\u0105\u0106\u0107\u0118\u0119\u0139\u013a\u0141\u0142\u0143\u0144\u0154\u0155\u015a\u015b\u0179\u017a\u017b\u017c";
    private static final String DIACRITC_PO = "\u00c0\u00c1\u00c2\u00c3\u00c7\u00c9\u00ca\u00cd\u00d3\u00d4\u00d5\u00da\u00e0\u00e1\u00e2\u00e3\u00e7\u00e9\u00ea\u00ed\u00f3\u00f4\u00f5\u00fa\u0128\u0129\u0168\u0169";
    private static final String DIACRITC_ES = "\u00c0\u00c1\u00c7\u00c8\u00c9\u00cd\u00cf\u00d1\u00d2\u00d3\u00d6\u00da\u00dc\u00e0\u00e1\u00e7\u00e8\u00e9\u00ed\u00ef\u00f1\u00f2\u00f3\u00f6\u00fa\u00fc\u0128\u0129";
    private static final String DIACRITC_RU = "\u040c\u045c\u045f\u0490\u0491\u0492\u0493\u049a\u049b\u04a2\u04a3\u04ae\u04af\u04b0\u04b1\u04ba\u04bb\u04c0\u04c1\u04c2\u04d2\u04d3\u04d8\u04d9\u04e6\u04e7\u04e8\u04e9\u04f0\u04f1";
    private static final String DIACRITC_SE = "\u00c4\u00c5\u00c8\u00c9\u00d6\u00dc\u00e4\u00e5\u00e8\u00e9\u00f6\u00fc";
    private static final String DIACRITC_TR = "\u00c7\u00d6\u00dc\u00e7\u00f6\u00fc\u011e\u011f\u0130\u0131\u015e\u015f";
    private static final String DIACRITC_HU = "\u00c1\u00c9\u00cd\u00d3\u00d6\u00da\u00dc\u00e1\u00e9\u00ed\u00f3\u00f6\u00fa\u00fc\u0150\u0151\u0170\u0171";
    private static final String DIACRITC_AR = "\u0623\u0625\u0622\ufef5\ufef7\ufef9\u0626\u0624";
    private static final String LATIN_COMPLETE = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz\u00c0\u00c1\u00c2\u00c3\u00c4\u00c5\u00c6\u00c7\u00c8\u00c9\u00ca\u00cb\u00cc\u00cd\u00ce\u00cf\u00d1\u00d2\u00d3\u00d4\u00d5\u00d6\u00d8\u00d9\u00da\u00db\u00dc\u00dd\u00de\u00df\u00e0\u00e1\u00e2\u00e3\u00e4\u00e5\u00e6\u00e7\u00e8\u00e9\u00ea\u00eb\u00ec\u00ed\u00ee\u00ef\u00f0\u00f1\u00f2\u00f3\u00f4\u00f5\u00f6\u00f8\u00f9\u00fa\u00fb\u00fc\u00fd\u00fe\u00ff\u0100\u0101\u0102\u0103\u0104\u0105\u0106\u0107\u010a\u010b\u010c\u010d\u010e\u010f\u0110\u0111\u0112\u0113\u0116\u0117\u0118\u0119\u011a\u011b\u011e\u011f\u0120\u0121\u0122\u0123\u0126\u0127\u0128\u0129\u012a\u012b\u012e\u012f\u0130\u0131\u0136\u0137\u0139\u013a\u013b\u013c\u013d\u013e\u0141\u0142\u0143\u0144\u0145\u0146\u0147\u0148\u0150\u0151\u0152\u0153\u0154\u0155\u0158\u0159\u015a\u015b\u015e\u015f\u0160\u0161\u0162\u0163\u0164\u0165\u0168\u0169\u016a\u016b\u016e\u016f\u0170\u0171\u0172\u0173\u0179\u017a\u017b\u017c\u017d\u017e\r !\"#$%&'()*+,-./0123456789:;<=>?@~\u00a1\u00a2\u00a3\u00a7\u00bf\u20ac";
    private static final String CYRILLIC_COMPLETE = "\u0401\u0402\u0403\u0404\u0405\u0406\u0407\u0408\u0409\u040a\u040b\u040c\u040e\u040f\u0410\u0411\u0412\u0413\u0414\u0415\u0416\u0417\u0418\u0419\u041a\u041b\u041c\u041d\u041e\u041f\u0420\u0421\u0422\u0423\u0424\u0425\u0426\u0427\u0428\u0429\u042a\u042b\u042c\u042d\u042e\u042f\u0430\u0431\u0432\u0433\u0434\u0435\u0436\u0437\u0438\u0439\u043a\u043b\u043c\u043d\u043e\u043f\u0440\u0441\u0442\u0443\u0444\u0445\u0446\u0447\u0448\u0449\u044a\u044b\u044c\u044d\u044e\u044f\u0451\u0452\u0453\u0454\u0455\u0456\u0457\u0458\u0459\u045a\u045b\u045c\u045e\u045f\u0490\u0491\u0492\u0493\u049a\u049b\u04a2\u04a3\u04ae\u04af\u04b0\u04b1\u04ba\u04bb\u04c0\u04c1\u04c2\u04d2\u04d3\u04d8\u04d9\u04e6\u04e7\u04e8\u04e9\u04f0\u04f1\r !\"#$%&'()*+,-./0123456789:;<=>?@~\u00a1\u00a2\u00a3\u00a7\u00bf\u20ac";
    private static final String ARABIC_COMPLETE = "\u0627\u0628\u062a\u062b\u062c\u062d\u062e\u062f\u0630\u0631\u0632\u0633\u0634\u0635\u0636\u0637\u0638\u0639\u063a\u0641\u0642\u0643\u0644\u0645\u0646\u0647\u0648\u064a\u0629\u0649\ufefb\u0621 \r \u0623\u0625\u0622\ufef5\ufef7\ufef9\u0626\u0624!\"#$%&'()*+,-./0123456789:;<=>?@~\u00a1\u00a2\u00a3\u00a7\u00bf\u20ac";
    private static final String PIN = "0123456789";
    private static final String SPECIAL_CHARS_FREETEXT_GENERAL = " +,-.";
    private static final String SPECIAL_CHARS_FREETEXT_WLAN = "#*+-_";
    private static final String SPECIAL_CHARS_SEARCHTEXT_GENERAL = " +,-.&'";
    private static final String SPECIAL_CHARS_SEARCHTEXT_NAVI = " +,-.&'/";
    private static final String SPECIAL_CHARS_SEARCHTEXT_NAVI_NAR = " -.&'";
    private static final String SPECIAL_CHARS_SEARCHTEXT_SMS_EMAIL = " ";
    private static final String SPECIAL_CHARS_SEARCHTEXT_FAVORITES_AND_ADB = " +,-";
    private static final String SPECIAL_CHARS_SEARCHTEXT_PHONE = " +,-#*";
    private static final String SPECIAL_CHARS_PHONE_NUMBER_INPUT = " +-#*";
    private static final String SPECIAL_CHARS_MESSAGING_MULTILINE = " \r?,.'!:-;";
    private static final String SPECIAL_CHARS_MESSAGING_EMAIL_RECIPIENT = "+-.@_";
    private static final String SPECIAL_CHARS_MESSAGING_SMS_RECIPIENT = " +,-#*";
    private static final String BLACKLIST_SEARCHINPUT_START_OF_WORD = "\u00df,.'";
    private static final String BLACKLIST_SEARCHINPUT_START_OF_TEXT = "\u00df\b +,-.&'";
    private static final String BLACKLIST_SEARCHINPUT_NAVI_START_OF_WORD = "\u00df,.'";
    private static final String BLACKLIST_SEARCHINPUT_NAVI_START_OF_TEXT = "\u00df\b +,-.&'/";
    private static final String BLACKLIST_SEARCHINPUT_SMS_START_OF_WORD = "";
    private static final String BLACKLIST_SEARCHINPUT_SMS_START_OF_TEXT = "\u00df \b";
    private static final String BLACKLIST_SEARCHINPUT_FAVORITEN_START_OF_WORD = "\u00df,";
    private static final String BLACKLIST_SEARCHINPUT_FAVORITEN_START_OF_TEXT = "\u00df\b +,-";
    private static final String BLACKLIST_SEARCHINPUT_PHONE_START_OF_WORD = ",";
    private static final String BLACKLIST_SEARCHINPUT_PHONE_START_OF_TEXT = " ,-\b";
    private static final String BLACKLIST_PASSWORD_START_OF_WORD = " *,.";
    private static final String BLACKLIST_PASSWORD_START_OF_TEXT = "\b *+,-.";
    private static final String BLACKLIST_FREETEXT_START_OF_WORD = "\u00df,.";
    private static final String BLACKLIST_FREETEXT_START_OF_TEXT = " \u00df+,-.\b";
    private static final String BLACKLIST_MESSAGING_START_OF_WORD = ",.!?':\u00df";
    private static final String BLACKLIST_MESSAGING_START_OF_TEXT = "\u00df\b+,-.!?':";
    private static final String BLACKLIST_MESSAGING_SINGLELINE_MAIL_START_OF_WORD = "\u00df@.";
    private static final String BLACKLIST_MESSAGING_SINGLELINE_MAIL_START_OF_TEXT = "\b\u00df@.-";
    private static final String BLACKLIST_MESSAGING_SINGLELINE_SMS_START_OF_WORD = "\u00df.,";
    private static final String BLACKLIST_MESSAGING_SINGLELINE_SMS_START_OF_TEXT = "\b \u00df+-.,";
    private static final Map charSetCache = new HashMap(10);

    private TouchCharacterDefinitionEurope() {
    }

    public static ITouchCharacterDefinition getInstance() {
        return SINGLETON_INSTANCE;
    }

    public static ITouchCharacterDefinition getInstance(boolean bl) {
        isNAR = bl;
        return SINGLETON_INSTANCE;
    }

    public ICharacterRegister getHWRSymbols(int n, int n2, int n3) {
        String string = TouchCharacterDefinitionEurope.getHWRSymbolsAsString(n, n3);
        char[] cArray = this.getSortedCharArray(string);
        return CharacterRegisterBinarySearch.createInstance(TouchCharacterDefinitionEurope.createRegisterName(n, n3, true), cArray, WidgetConstants.EMPTY_CHAR_ARRAY, WidgetConstants.EMPTY_CHAR_ARRAY);
    }

    public static String getHWRSymbolsAsString(int n, int n2) {
        String string;
        block0 : switch (n) {
            case 16: 
            case 17: 
            case 18: 
            case 19: 
            case 20: 
            case 21: {
                switch (n2) {
                    case 7: {
                        string = CYRILLIC_COMPLETE;
                        break block0;
                    }
                    case 26: {
                        string = ARABIC_COMPLETE;
                        break block0;
                    }
                }
                string = LATIN_COMPLETE;
                break;
            }
            case 32: {
                string = TouchCharacterDefinitionEurope.getBaseSymbolSet(n2) + TouchCharacterDefinitionEurope.getExtendedDiacrciticSymbols(n2) + "0123456789" + SPECIAL_CHARS_FREETEXT_GENERAL;
                break;
            }
            case 48: 
            case 54: {
                string = TouchCharacterDefinitionEurope.getBaseSymbolSet(n2) + TouchCharacterDefinitionEurope.getExtendedDiacrciticSymbols(n2) + "0123456789" + SPECIAL_CHARS_SEARCHTEXT_GENERAL;
                break;
            }
            case 51: {
                if (isNAR) {
                    string = TouchCharacterDefinitionEurope.getBaseSymbolSet(n2) + TouchCharacterDefinitionEurope.getExtendedDiacrciticSymbols(n2) + "0123456789" + SPECIAL_CHARS_SEARCHTEXT_NAVI_NAR;
                    break;
                }
                string = TouchCharacterDefinitionEurope.getBaseSymbolSet(n2) + TouchCharacterDefinitionEurope.getExtendedDiacrciticSymbols(n2) + "0123456789" + SPECIAL_CHARS_SEARCHTEXT_NAVI;
                break;
            }
            case 53: {
                string = TouchCharacterDefinitionEurope.getBaseSymbolSet(n2) + TouchCharacterDefinitionEurope.getExtendedDiacrciticSymbols(n2) + "0123456789" + " ";
                break;
            }
            case 49: 
            case 50: {
                string = TouchCharacterDefinitionEurope.getBaseSymbolSet(n2) + TouchCharacterDefinitionEurope.getExtendedDiacrciticSymbols(n2) + "0123456789" + SPECIAL_CHARS_SEARCHTEXT_FAVORITES_AND_ADB;
                break;
            }
            case 52: 
            case 55: {
                string = TouchCharacterDefinitionEurope.getBaseSymbolSet(n2) + TouchCharacterDefinitionEurope.getExtendedDiacrciticSymbols(n2) + "0123456789" + " +,-#*";
                break;
            }
            case 64: {
                string = "0123456789";
                break;
            }
            case 23: 
            case 114: {
                string = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz0123456789 +-#*";
                break;
            }
            case 113: {
                string = "0123456789#*";
                break;
            }
            case 80: {
                string = TouchCharacterDefinitionEurope.getBaseSymbolSet(n2) + TouchCharacterDefinitionEurope.getExtendedDiacrciticSymbols(n2) + NUMBERS_AND_TOUCH_SYMBOLS_PASSWORD;
                break;
            }
            case 33: 
            case 81: 
            case 82: {
                string = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz0123456789#*+-_";
                break;
            }
            case 96: {
                string = TouchCharacterDefinitionEurope.getBaseSymbolSet(n2) + TouchCharacterDefinitionEurope.getDiacriticSymbols(n2) + "0123456789" + TouchCharacterDefinitionEurope.getMultiLineSpecialChars(n2);
                break;
            }
            case 97: {
                string = TouchCharacterDefinitionEurope.getBaseSymbolSet(n2) + TouchCharacterDefinitionEurope.getExtendedDiacrciticSymbols(n2) + "0123456789" + SPECIAL_CHARS_MESSAGING_EMAIL_RECIPIENT;
                break;
            }
            case 98: {
                string = TouchCharacterDefinitionEurope.getBaseSymbolSet(n2) + TouchCharacterDefinitionEurope.getExtendedDiacrciticSymbols(n2) + "0123456789" + " +,-#*";
                break;
            }
            case 22: {
                string = "0123456789";
                break;
            }
            default: {
                IWidgetLogChannel.tpLogChannelInternal.log(10000, "TouchChararacterDefinition#getHWRSymbols: invalid touchpadMode: %1 - Defaulting to LATIN_COMPLETE/CYRILLIC_COMPLETE", (long)n);
                switch (n2) {
                    case 7: {
                        string = CYRILLIC_COMPLETE;
                        break block0;
                    }
                    case 26: {
                        string = ARABIC_COMPLETE;
                        break block0;
                    }
                }
                string = LATIN_COMPLETE;
            }
        }
        return string;
    }

    private static String getBaseSymbolSet(int n) {
        switch (n) {
            case 7: {
                return CYRILLIC;
            }
            case 26: {
                return ARABIC;
            }
        }
        return LATIN;
    }

    static String getExtendedDiacrciticSymbols(int n) {
        switch (n) {
            case 7: {
                return DIACRITC_RU;
            }
            case 26: {
                return DIACRITC_AR;
            }
        }
        return LATIN_EXTENDED;
    }

    static String getMultiLineSpecialChars(int n) {
        boolean bl;
        boolean bl2 = bl = n == 22 || n == 5 || n == 3 || n == 11;
        if (bl) {
            return "\u00a1\u00bf \r?,.'!:-;";
        }
        return SPECIAL_CHARS_MESSAGING_MULTILINE;
    }

    static String getDiacriticSymbols(int n) {
        switch (n) {
            case 0: {
                return DIACRITC_DE;
            }
            case 2: {
                return DIACRITC_FR;
            }
            case 3: {
                return DIACRITC_ES;
            }
            case 4: {
                return DIACRITC_IT;
            }
            case 5: {
                return DIACRITC_PO;
            }
            case 6: {
                return DIACRITC_NL;
            }
            case 11: {
                return DIACRITC_ES;
            }
            case 18: {
                return DIACRITC_PL;
            }
            case 19: {
                return DIACRITC_SE;
            }
            case 20: {
                return DIACRITC_CZ;
            }
            case 21: {
                return DIACRITC_TR;
            }
            case 22: {
                return DIACRITC_PO;
            }
            case 7: {
                return DIACRITC_RU;
            }
            case 10: {
                return DIACRITC_FR;
            }
            case 27: {
                return DIACRITC_NO;
            }
            case 28: {
                return DIACRITC_HU;
            }
            case 26: {
                return DIACRITC_AR;
            }
        }
        return BLACKLIST_SEARCHINPUT_SMS_START_OF_WORD;
    }

    public ICharacterRegister getBlackList(int n, boolean bl) {
        String string = TouchCharacterDefinitionEurope.getBlackListedAsString(n, bl);
        char[] cArray = this.getSortedCharArray(string);
        return CharacterRegisterBinarySearch.createInstance(TouchCharacterDefinitionEurope.createRegisterName(n), cArray, WidgetConstants.EMPTY_CHAR_ARRAY, WidgetConstants.EMPTY_CHAR_ARRAY);
    }

    private char[] getSortedCharArray(String string) {
        if (charSetCache.containsKey(string)) {
            return (char[])charSetCache.get(string);
        }
        char[] cArray = string.toCharArray();
        Arrays.sort(cArray);
        charSetCache.put(string, cArray);
        return cArray;
    }

    private static String createRegisterName(int n) {
        return TouchCharacterDefinitionEurope.createRegisterName(n, -1, false);
    }

    private static String createRegisterName(int n, int n2, boolean bl) {
        String string = n == 50 || n == 49 || n == 48 || n == 54 || n == 51 || n == 52 || n == 55 ? "truffle" : (n == 18 || n == 17 || n == 19 || n == 21 || n == 16 ? "general matchspeller" : TouchCharacterDefinitionEurope.touchpadModeToString(n));
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

    private static String getBlackListedAsString(int n, boolean bl) {
        switch (n) {
            case 32: {
                return bl ? BLACKLIST_FREETEXT_START_OF_WORD : BLACKLIST_FREETEXT_START_OF_TEXT;
            }
            case 80: {
                return bl ? BLACKLIST_PASSWORD_START_OF_WORD : BLACKLIST_PASSWORD_START_OF_TEXT;
            }
            case 53: {
                return bl ? BLACKLIST_SEARCHINPUT_SMS_START_OF_WORD : BLACKLIST_SEARCHINPUT_SMS_START_OF_TEXT;
            }
            case 51: {
                return bl ? "\u00df,.'" : BLACKLIST_SEARCHINPUT_NAVI_START_OF_TEXT;
            }
            case 17: 
            case 18: 
            case 19: 
            case 20: {
                return bl ? "\u00df,.'" : BLACKLIST_SEARCHINPUT_NAVI_START_OF_TEXT;
            }
            case 16: 
            case 48: 
            case 54: {
                return bl ? "\u00df,.'" : BLACKLIST_SEARCHINPUT_START_OF_TEXT;
            }
            case 49: 
            case 50: {
                return bl ? BLACKLIST_SEARCHINPUT_FAVORITEN_START_OF_WORD : BLACKLIST_SEARCHINPUT_FAVORITEN_START_OF_TEXT;
            }
            case 52: 
            case 55: {
                return bl ? BLACKLIST_SEARCHINPUT_PHONE_START_OF_WORD : BLACKLIST_SEARCHINPUT_PHONE_START_OF_TEXT;
            }
            case 113: {
                return bl ? BLACKLIST_SEARCHINPUT_SMS_START_OF_WORD : "\b";
            }
            case 96: {
                return bl ? BLACKLIST_MESSAGING_START_OF_WORD : BLACKLIST_MESSAGING_START_OF_TEXT;
            }
            case 97: {
                return bl ? BLACKLIST_MESSAGING_SINGLELINE_MAIL_START_OF_WORD : BLACKLIST_MESSAGING_SINGLELINE_MAIL_START_OF_TEXT;
            }
            case 98: {
                return bl ? BLACKLIST_MESSAGING_SINGLELINE_SMS_START_OF_WORD : BLACKLIST_MESSAGING_SINGLELINE_SMS_START_OF_TEXT;
            }
            case 114: {
                return bl ? BLACKLIST_SEARCHINPUT_SMS_START_OF_WORD : "\b -";
            }
            case 64: {
                return bl ? BLACKLIST_SEARCHINPUT_SMS_START_OF_WORD : "\b";
            }
        }
        return BLACKLIST_SEARCHINPUT_SMS_START_OF_WORD;
    }
}

