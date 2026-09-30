/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.prpframework;

import java.lang.reflect.Field;
import java.util.Arrays;

public class SortChars {
    private static final String SPACE = " ";
    private static final String CARRIAGE_RETURN = "\r";
    private static final String LATIN_ORI = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz";
    private static final String LATIN = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final String LATIN_EXTENDED = "\u00c0\u00c1\u00c2\u00c3\u00c4\u00c5\u00c6\u00c7\u00c8\u00c9\u00ca\u00cb\u00cc\u00cd\u00ce\u00cf\u00d1\u00d2\u00d3\u00d4\u00d5\u00d6\u00d8\u00d9\u00da\u00db\u00dc\u00dd\u00de\u00df\u00e0\u00e1\u00e2\u00e3\u00e4\u00e5\u00e6\u00e7\u00e8\u00e9\u00ea\u00eb\u00ec\u00ed\u00ee\u00ef\u00f0\u00f1\u00f2\u00f3\u00f4\u00f5\u00f6\u00f8\u00f9\u00fa\u00fb\u00fc\u00fd\u00fe\u00ff\u0100\u0101\u0102\u0103\u0104\u0105\u0106\u0107\u010a\u010b\u010c\u010d\u010e\u010f\u0110\u0111\u0112\u0113\u0116\u0117\u0118\u0119\u011a\u011b\u011e\u011f\u0120\u0121\u0122\u0123\u0126\u0127\u0128\u0129\u012a\u012b\u012e\u012f\u0130\u0131\u0136\u0137\u0139\u013a\u013b\u013c\u013d\u013e\u0141\u0142\u0143\u0144\u0145\u0146\u0147\u0148\u0150\u0151\u0152\u0153\u0154\u0155\u0158\u0159\u015a\u015b\u015e\u015f\u0160\u0161\u0162\u0163\u0164\u0165\u0168\u0169\u016a\u016b\u016e\u016f\u0170\u0171\u0172\u0173\u0179\u017a\u017b\u017c\u017d\u017e";
    private static final String CONTROL = "\r ";
    private static final String CYRILLIC = "\u0401\u0402\u0403\u0404\u0405\u0406\u0407\u0408\u0409\u040a\u040b\u040c\u040e\u040f\u0410\u0411\u0412\u0413\u0414\u0415\u0416\u0417\u0418\u0419\u041a\u041b\u041c\u041d\u041e\u041f\u0420\u0421\u0422\u0423\u0424\u0425\u0426\u0427\u0428\u0429\u042a\u042b\u042c\u042d\u042e\u042f\u0430\u0431\u0432\u0433\u0434\u0435\u0436\u0437\u0438\u0439\u043a\u043b\u043c\u043d\u043e\u043f\u0440\u0441\u0442\u0443\u0444\u0445\u0446\u0447\u0448\u0449\u044a\u044b\u044c\u044d\u044e\u044f\u0451\u0452\u0453\u0454\u0455\u0456\u0457\u0458\u0459\u045a\u045b\u045c\u045e\u045f\u0490\u0491\u0492\u0493\u049a\u049b\u04a2\u04a3\u04ae\u04af\u04b0\u04b1\u04ba\u04bb\u04c0\u04c1\u04c2\u04d2\u04d3\u04d8\u04d9\u04e6\u04e7\u04e8\u04e9\u04f0\u04f1";
    private static final String ARABIC_ORI = "\u0627\u0628\u062a\u062b\u062c\u062d\u062e\u062f\u0630\u0631\u0632\u0633\u0634\u0635\u0636\u0637\u0638\u0639\u063a\u0641\u0642\u0643\u0644\u0645\u0646\u0647\u0648\u064a\u0629\u0649\ufefb\u0621 ";
    private static final String ARABIC = " \u0621\u0627\u0628\u0629\u062a\u062b\u062c\u062d\u062e\u062f\u0630\u0631\u0632\u0633\u0634\u0635\u0636\u0637\u0638\u0639\u063a\u0641\u0642\u0643\u0644\u0645\u0646\u0647\u0648\u0649\u064a\ufefb";
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
    private static final String DIACRITC_AR_ORI = "\u0623\u0625\u0622\ufef5\ufef7\ufef9\u0626\u0624";
    private static final String DIACRITC_AR = "\u0622\u0623\u0624\u0625\u0626\ufef5\ufef7\ufef9";
    private static final String LATIN_COMPLETE_ORI = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz\u00c0\u00c1\u00c2\u00c3\u00c4\u00c5\u00c6\u00c7\u00c8\u00c9\u00ca\u00cb\u00cc\u00cd\u00ce\u00cf\u00d1\u00d2\u00d3\u00d4\u00d5\u00d6\u00d8\u00d9\u00da\u00db\u00dc\u00dd\u00de\u00df\u00e0\u00e1\u00e2\u00e3\u00e4\u00e5\u00e6\u00e7\u00e8\u00e9\u00ea\u00eb\u00ec\u00ed\u00ee\u00ef\u00f0\u00f1\u00f2\u00f3\u00f4\u00f5\u00f6\u00f8\u00f9\u00fa\u00fb\u00fc\u00fd\u00fe\u00ff\u0100\u0101\u0102\u0103\u0104\u0105\u0106\u0107\u010a\u010b\u010c\u010d\u010e\u010f\u0110\u0111\u0112\u0113\u0116\u0117\u0118\u0119\u011a\u011b\u011e\u011f\u0120\u0121\u0122\u0123\u0126\u0127\u0128\u0129\u012a\u012b\u012e\u012f\u0130\u0131\u0136\u0137\u0139\u013a\u013b\u013c\u013d\u013e\u0141\u0142\u0143\u0144\u0145\u0146\u0147\u0148\u0150\u0151\u0152\u0153\u0154\u0155\u0158\u0159\u015a\u015b\u015e\u015f\u0160\u0161\u0162\u0163\u0164\u0165\u0168\u0169\u016a\u016b\u016e\u016f\u0170\u0171\u0172\u0173\u0179\u017a\u017b\u017c\u017d\u017e\r !\"#$%&'()*+,-./0123456789:;<=>?@~\u00a1\u00a2\u00a3\u00a7\u00bf\u20ac";
    private static final String LATIN_COMPLETE = "\r !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz~\u00a1\u00a2\u00a3\u00a7\u00bf\u00c0\u00c1\u00c2\u00c3\u00c4\u00c5\u00c6\u00c7\u00c8\u00c9\u00ca\u00cb\u00cc\u00cd\u00ce\u00cf\u00d1\u00d2\u00d3\u00d4\u00d5\u00d6\u00d8\u00d9\u00da\u00db\u00dc\u00dd\u00de\u00df\u00e0\u00e1\u00e2\u00e3\u00e4\u00e5\u00e6\u00e7\u00e8\u00e9\u00ea\u00eb\u00ec\u00ed\u00ee\u00ef\u00f0\u00f1\u00f2\u00f3\u00f4\u00f5\u00f6\u00f8\u00f9\u00fa\u00fb\u00fc\u00fd\u00fe\u00ff\u0100\u0101\u0102\u0103\u0104\u0105\u0106\u0107\u010a\u010b\u010c\u010d\u010e\u010f\u0110\u0111\u0112\u0113\u0116\u0117\u0118\u0119\u011a\u011b\u011e\u011f\u0120\u0121\u0122\u0123\u0126\u0127\u0128\u0129\u012a\u012b\u012e\u012f\u0130\u0131\u0136\u0137\u0139\u013a\u013b\u013c\u013d\u013e\u0141\u0142\u0143\u0144\u0145\u0146\u0147\u0148\u0150\u0151\u0152\u0153\u0154\u0155\u0158\u0159\u015a\u015b\u015e\u015f\u0160\u0161\u0162\u0163\u0164\u0165\u0168\u0169\u016a\u016b\u016e\u016f\u0170\u0171\u0172\u0173\u0179\u017a\u017b\u017c\u017d\u017e\u20ac";
    private static final String CYRILLIC_COMPLETE_ORI = "\u0401\u0402\u0403\u0404\u0405\u0406\u0407\u0408\u0409\u040a\u040b\u040c\u040e\u040f\u0410\u0411\u0412\u0413\u0414\u0415\u0416\u0417\u0418\u0419\u041a\u041b\u041c\u041d\u041e\u041f\u0420\u0421\u0422\u0423\u0424\u0425\u0426\u0427\u0428\u0429\u042a\u042b\u042c\u042d\u042e\u042f\u0430\u0431\u0432\u0433\u0434\u0435\u0436\u0437\u0438\u0439\u043a\u043b\u043c\u043d\u043e\u043f\u0440\u0441\u0442\u0443\u0444\u0445\u0446\u0447\u0448\u0449\u044a\u044b\u044c\u044d\u044e\u044f\u0451\u0452\u0453\u0454\u0455\u0456\u0457\u0458\u0459\u045a\u045b\u045c\u045e\u045f\u0490\u0491\u0492\u0493\u049a\u049b\u04a2\u04a3\u04ae\u04af\u04b0\u04b1\u04ba\u04bb\u04c0\u04c1\u04c2\u04d2\u04d3\u04d8\u04d9\u04e6\u04e7\u04e8\u04e9\u04f0\u04f1\r !\"#$%&'()*+,-./0123456789:;<=>?@~\u00a1\u00a2\u00a3\u00a7\u00bf\u20ac";
    private static final String CYRILLIC_COMPLETE = "\r !\"#$%&'()*+,-./0123456789:;<=>?@~\u00a1\u00a2\u00a3\u00a7\u00bf\u0401\u0402\u0403\u0404\u0405\u0406\u0407\u0408\u0409\u040a\u040b\u040c\u040e\u040f\u0410\u0411\u0412\u0413\u0414\u0415\u0416\u0417\u0418\u0419\u041a\u041b\u041c\u041d\u041e\u041f\u0420\u0421\u0422\u0423\u0424\u0425\u0426\u0427\u0428\u0429\u042a\u042b\u042c\u042d\u042e\u042f\u0430\u0431\u0432\u0433\u0434\u0435\u0436\u0437\u0438\u0439\u043a\u043b\u043c\u043d\u043e\u043f\u0440\u0441\u0442\u0443\u0444\u0445\u0446\u0447\u0448\u0449\u044a\u044b\u044c\u044d\u044e\u044f\u0451\u0452\u0453\u0454\u0455\u0456\u0457\u0458\u0459\u045a\u045b\u045c\u045e\u045f\u0490\u0491\u0492\u0493\u049a\u049b\u04a2\u04a3\u04ae\u04af\u04b0\u04b1\u04ba\u04bb\u04c0\u04c1\u04c2\u04d2\u04d3\u04d8\u04d9\u04e6\u04e7\u04e8\u04e9\u04f0\u04f1\u20ac";
    private static final String ARABIC_COMPLETE_ORI = " \u0621\u0627\u0628\u0629\u062a\u062b\u062c\u062d\u062e\u062f\u0630\u0631\u0632\u0633\u0634\u0635\u0636\u0637\u0638\u0639\u063a\u0641\u0642\u0643\u0644\u0645\u0646\u0647\u0648\u0649\u064a\ufefb\r \u0622\u0623\u0624\u0625\u0626\ufef5\ufef7\ufef9!\"#$%&'()*+,-./0123456789:;<=>?@~\u00a1\u00a2\u00a3\u00a7\u00bf\u20ac";
    private static final String ARABIC_COMPLETE = "\r  !\"#$%&'()*+,-./0123456789:;<=>?@~\u00a1\u00a2\u00a3\u00a7\u00bf\u0621\u0622\u0623\u0624\u0625\u0626\u0627\u0628\u0629\u062a\u062b\u062c\u062d\u062e\u062f\u0630\u0631\u0632\u0633\u0634\u0635\u0636\u0637\u0638\u0639\u063a\u0641\u0642\u0643\u0644\u0645\u0646\u0647\u0648\u0649\u064a\u20ac\ufef5\ufef7\ufef9\ufefb";
    private static final String PIN = "0123456789";
    private static final String SPECIAL_CHARS_FREETEXT_GENERAL = " +,-.";
    private static final String SPECIAL_CHARS_FREETEXT_WLAN = "#*+-_";
    private static final String SPECIAL_CHARS_SEARCHTEXT_GENERAL_ORI = " +,-.&'";
    private static final String SPECIAL_CHARS_SEARCHTEXT_GENERAL = " &'+,-.";
    private static final String SPECIAL_CHARS_SEARCHTEXT_NAVI_ORI = " +,-.&'/";
    private static final String SPECIAL_CHARS_SEARCHTEXT_NAVI = " &'+,-./";
    private static final String SPECIAL_CHARS_SEARCHTEXT_SMS_EMAIL = " ";
    private static final String SPECIAL_CHARS_SEARCHTEXT_FAVORITES_AND_ADB = " +,-";
    private static final String SPECIAL_CHARS_SEARCHTEXT_PHONE_ORI = " +,-#*";
    private static final String SPECIAL_CHARS_SEARCHTEXT_PHONE = " #*+,-";
    private static final String SPECIAL_CHARS_PHONE_NUMBER_INPUT_ORI = " +-#*";
    private static final String SPECIAL_CHARS_PHONE_NUMBER_INPUT = " #*+-";
    private static final String SPECIAL_CHARS_MESSAGING_MULTILINE_ORI = " +,:-.'!?\r";
    private static final String SPECIAL_CHARS_MESSAGING_MULTILINE = "\r !'+,-.:?";
    private static final String SPECIAL_CHARS_MESSAGING_EMAIL_RECIPIENT = "+-.@_";
    private static final String SPECIAL_CHARS_MESSAGING_SMS_RECIPIENT_ORI = " +,-#*";
    private static final String SPECIAL_CHARS_MESSAGING_SMS_RECIPIENT = " #*+,-";
    private static final String BLACKLIST_SEARCHINPUT_START_OF_WORD_ORI = "\u00df,.'";
    private static final String BLACKLIST_SEARCHINPUT_START_OF_WORD = "',.\u00df";
    private static final String BLACKLIST_SEARCHINPUT_START_OF_TEXT_ORI = "\u00df\b +,-.&'";
    private static final String BLACKLIST_SEARCHINPUT_START_OF_TEXT = "\b &'+,-.\u00df";
    private static final String BLACKLIST_SEARCHINPUT_NAVI_START_OF_WORD_ORI = "\u00df,.'";
    private static final String BLACKLIST_SEARCHINPUT_NAVI_START_OF_WORD = "',.\u00df";
    private static final String BLACKLIST_SEARCHINPUT_NAVI_START_OF_TEXT_ORI = "\u00df\b +,-.&'/";
    private static final String BLACKLIST_SEARCHINPUT_NAVI_START_OF_TEXT = "\b &'+,-./\u00df";
    private static final String BLACKLIST_SEARCHINPUT_SMS_START_OF_WORD = "";
    private static final String BLACKLIST_SEARCHINPUT_SMS_START_OF_TEXT_ORI = "\u00df \b";
    private static final String BLACKLIST_SEARCHINPUT_SMS_START_OF_TEXT = "\b \u00df";
    private static final String BLACKLIST_SEARCHINPUT_FAVORITEN_START_OF_WORD_ORI = "\u00df,";
    private static final String BLACKLIST_SEARCHINPUT_FAVORITEN_START_OF_WORD = ",\u00df";
    private static final String BLACKLIST_SEARCHINPUT_FAVORITEN_START_OF_TEXT_ORI = "\u00df\b +,-";
    private static final String BLACKLIST_SEARCHINPUT_FAVORITEN_START_OF_TEXT = "\b +,-\u00df";
    private static final String BLACKLIST_SEARCHINPUT_PHONE_START_OF_WORD = ",";
    private static final String BLACKLIST_SEARCHINPUT_PHONE_START_OF_TEXT_ORI = " ,-\b";
    private static final String BLACKLIST_SEARCHINPUT_PHONE_START_OF_TEXT = "\b ,-";
    private static final String BLACKLIST_PASSWORD_START_OF_WORD = " *,.";
    private static final String BLACKLIST_PASSWORD_START_OF_TEXT = "\b *+,-.";
    private static final String BLACKLIST_FREETEXT_START_OF_WORD_ORI = "\u00df,.";
    private static final String BLACKLIST_FREETEXT_START_OF_WORD = ",.\u00df";
    private static final String BLACKLIST_FREETEXT_START_OF_TEXT_ORI = " \u00df+,-.\b";
    private static final String BLACKLIST_FREETEXT_START_OF_TEXT = "\b +,-.\u00df";
    private static final String BLACKLIST_MESSAGING_START_OF_WORD_ORI = ",.!?':";
    private static final String BLACKLIST_MESSAGING_START_OF_WORD = "!',.:?";
    private static final String BLACKLIST_MESSAGING_START_OF_TEXT_ORI = " +,-.!?':";
    private static final String BLACKLIST_MESSAGING_START_OF_TEXT = " !'+,-.:?";
    private static final String BLACKLIST_MESSAGING_SINGLELINE_MAIL_START_OF_WORD_ORI = "\u00df@.";
    private static final String BLACKLIST_MESSAGING_SINGLELINE_MAIL_START_OF_WORD = ".@\u00df";
    private static final String BLACKLIST_MESSAGING_SINGLELINE_MAIL_START_OF_TEXT_ORI = "\b\u00df@.-";
    private static final String BLACKLIST_MESSAGING_SINGLELINE_MAIL_START_OF_TEXT = "\b-.@\u00df";
    private static final String BLACKLIST_MESSAGING_SINGLELINE_SMS_START_OF_WORD_ORI = "\u00df.,";
    private static final String BLACKLIST_MESSAGING_SINGLELINE_SMS_START_OF_WORD = ",.\u00df";
    private static final String BLACKLIST_MESSAGING_SINGLELINE_SMS_START_OF_TEXT_ORI = "\b \u00df+-.,";
    private static final String BLACKLIST_MESSAGING_SINGLELINE_SMS_START_OF_TEXT = "\b +,-.\u00df";
    static /* synthetic */ Class class$de$esolutions$hmi$widgets$audi$evo$prpframework$SortChars;
    static /* synthetic */ Class class$java$lang$String;

    public static void main(String[] stringArray) {
        Class clazz = class$de$esolutions$hmi$widgets$audi$evo$prpframework$SortChars == null ? (class$de$esolutions$hmi$widgets$audi$evo$prpframework$SortChars = SortChars.class$("de.esolutions.hmi.widgets.audi.evo.prpframework.SortChars")) : class$de$esolutions$hmi$widgets$audi$evo$prpframework$SortChars;
        Field[] fieldArray = clazz.getDeclaredFields();
        int n = 0;
        if (null != fieldArray && fieldArray.length > 0) {
            for (int i2 = 0; i2 < fieldArray.length; ++i2) {
                Field field = fieldArray[i2];
                field.setAccessible(true);
                if (field.getType() != (class$java$lang$String == null ? SortChars.class$("java.lang.String") : class$java$lang$String)) continue;
                try {
                    String string = (String)field.get(clazz);
                    char[] cArray = string.toCharArray();
                    Arrays.sort(cArray);
                    String string2 = new String(cArray);
                    if (string.equals(string2)) continue;
                    ++n;
                    char[] cArray2 = string2.toCharArray();
                    StringBuffer stringBuffer = new StringBuffer();
                    StringBuffer stringBuffer2 = new StringBuffer();
                    for (int i3 = 0; i3 < cArray2.length; ++i3) {
                        char c2 = cArray2[i3];
                        if (c2 < '\u007f' && !Character.isSpaceChar(c2) && c2 != '\b' && c2 != '\r' && c2 != '@') {
                            stringBuffer.append(c2);
                            stringBuffer2.append(c2);
                            continue;
                        }
                        String string3 = String.valueOf(c2);
                        stringBuffer.append(SortChars.bytesToHexString(string3.getBytes()));
                    }
                    String string4 = stringBuffer.toString();
                    System.out.println(new StringBuffer().append(field.getName()).append("->").append(string4).toString());
                    continue;
                }
                catch (IllegalArgumentException illegalArgumentException) {
                    illegalArgumentException.printStackTrace();
                    continue;
                }
                catch (IllegalAccessException illegalAccessException) {
                    illegalAccessException.printStackTrace();
                }
            }
        }
        System.out.println(new StringBuffer().append("total different list: ").append(n).toString());
    }

    public static final String bytesToHexString(byte[] byArray) {
        StringBuffer stringBuffer = new StringBuffer(byArray.length);
        stringBuffer.insert(0, '0');
        stringBuffer.insert(0, '0');
        for (int i2 = 0; i2 < byArray.length; ++i2) {
            String string = Integer.toHexString(0xFF & byArray[i2]);
            if (string.length() < 2) {
                stringBuffer.append(0);
            }
            stringBuffer.append(string.toUpperCase());
        }
        return new StringBuffer().append("\\u").append(stringBuffer.toString().subSequence(stringBuffer.length() - 4, stringBuffer.length())).toString();
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

