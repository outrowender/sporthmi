/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerCharsetDefinition;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController;
import java.util.ArrayList;
import java.util.List;

public class SpellerCharsetDefinitionEurope
extends SpellerCharsetDefinition {
    private static List getumlaut_a_arBand(int n) {
        ArrayList arrayList = new ArrayList(30);
        arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u0623\u0625\u0622", null, true));
        return arrayList;
    }

    private static List getumlaut_w_arBand(int n) {
        ArrayList arrayList = new ArrayList(30);
        arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u0624", null, true));
        return arrayList;
    }

    private static List getumlaut_m_arBand(int n) {
        ArrayList arrayList = new ArrayList(30);
        arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u0626", null, true));
        return arrayList;
    }

    private static List getumlaut_l_arBand(int n) {
        ArrayList arrayList = new ArrayList(30);
        arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\ufef5\ufef7\ufef9", null, true));
        return arrayList;
    }

    private static List getumlaut_h_arBand(int n) {
        ArrayList arrayList = new ArrayList(30);
        arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u0623\u0625\u0626\u0624", null, true));
        return arrayList;
    }

    private static List getlatinExpandableAZ_arBand(int n) {
        ArrayList arrayList = new ArrayList(30);
        SpellerController.AbstractExpandableItem.Char char_ = SpellerController.AbstractExpandableItem.Char.createInstance(SpellerCharsetDefinitionEurope.getumlaut_a_arBand(n), "\u0627");
        arrayList.add(char_);
        SpellerController.SingleCharItem singleCharItem = SpellerController.SingleCharItem.createInstance("\u0628");
        arrayList.add(singleCharItem);
        SpellerController.SingleCharItem singleCharItem2 = SpellerController.SingleCharItem.createInstance("\u062a");
        arrayList.add(singleCharItem2);
        SpellerController.SingleCharItem singleCharItem3 = SpellerController.SingleCharItem.createInstance("\u062b");
        arrayList.add(singleCharItem3);
        SpellerController.SingleCharItem singleCharItem4 = SpellerController.SingleCharItem.createInstance("\u062c");
        arrayList.add(singleCharItem4);
        SpellerController.SingleCharItem singleCharItem5 = SpellerController.SingleCharItem.createInstance("\u062d");
        arrayList.add(singleCharItem5);
        SpellerController.SingleCharItem singleCharItem6 = SpellerController.SingleCharItem.createInstance("\u062e");
        arrayList.add(singleCharItem6);
        SpellerController.SingleCharItem singleCharItem7 = SpellerController.SingleCharItem.createInstance("\u062f");
        arrayList.add(singleCharItem7);
        SpellerController.SingleCharItem singleCharItem8 = SpellerController.SingleCharItem.createInstance("\u0630");
        arrayList.add(singleCharItem8);
        SpellerController.SingleCharItem singleCharItem9 = SpellerController.SingleCharItem.createInstance("\u0631");
        arrayList.add(singleCharItem9);
        SpellerController.SingleCharItem singleCharItem10 = SpellerController.SingleCharItem.createInstance("\u0632");
        arrayList.add(singleCharItem10);
        SpellerController.SingleCharItem singleCharItem11 = SpellerController.SingleCharItem.createInstance("\u0633");
        arrayList.add(singleCharItem11);
        SpellerController.SingleCharItem singleCharItem12 = SpellerController.SingleCharItem.createInstance("\u0634");
        arrayList.add(singleCharItem12);
        SpellerController.SingleCharItem singleCharItem13 = SpellerController.SingleCharItem.createInstance("\u0635");
        arrayList.add(singleCharItem13);
        SpellerController.SingleCharItem singleCharItem14 = SpellerController.SingleCharItem.createInstance("\u0636");
        arrayList.add(singleCharItem14);
        SpellerController.SingleCharItem singleCharItem15 = SpellerController.SingleCharItem.createInstance("\u0637");
        arrayList.add(singleCharItem15);
        SpellerController.SingleCharItem singleCharItem16 = SpellerController.SingleCharItem.createInstance("\u0638");
        arrayList.add(singleCharItem16);
        SpellerController.SingleCharItem singleCharItem17 = SpellerController.SingleCharItem.createInstance("\u0639");
        arrayList.add(singleCharItem17);
        SpellerController.SingleCharItem singleCharItem18 = SpellerController.SingleCharItem.createInstance("\u063a");
        arrayList.add(singleCharItem18);
        SpellerController.SingleCharItem singleCharItem19 = SpellerController.SingleCharItem.createInstance("\u0641");
        arrayList.add(singleCharItem19);
        SpellerController.SingleCharItem singleCharItem20 = SpellerController.SingleCharItem.createInstance("\u0642");
        arrayList.add(singleCharItem20);
        SpellerController.SingleCharItem singleCharItem21 = SpellerController.SingleCharItem.createInstance("\u0643");
        arrayList.add(singleCharItem21);
        SpellerController.SingleCharItem singleCharItem22 = SpellerController.SingleCharItem.createInstance("\u0644");
        arrayList.add(singleCharItem22);
        SpellerController.SingleCharItem singleCharItem23 = SpellerController.SingleCharItem.createInstance("\u0645");
        arrayList.add(singleCharItem23);
        SpellerController.SingleCharItem singleCharItem24 = SpellerController.SingleCharItem.createInstance("\u0646");
        arrayList.add(singleCharItem24);
        SpellerController.SingleCharItem singleCharItem25 = SpellerController.SingleCharItem.createInstance("\u0647");
        arrayList.add(singleCharItem25);
        SpellerController.AbstractExpandableItem.Char char_2 = SpellerController.AbstractExpandableItem.Char.createInstance(SpellerCharsetDefinitionEurope.getumlaut_w_arBand(n), "\u0648");
        arrayList.add(char_2);
        SpellerController.SingleCharItem singleCharItem26 = SpellerController.SingleCharItem.createInstance("\u064a");
        arrayList.add(singleCharItem26);
        SpellerController.SingleCharItem singleCharItem27 = SpellerController.SingleCharItem.createInstance("\u0629");
        arrayList.add(singleCharItem27);
        SpellerController.AbstractExpandableItem.Char char_3 = SpellerController.AbstractExpandableItem.Char.createInstance(SpellerCharsetDefinitionEurope.getumlaut_m_arBand(n), "\u0649");
        arrayList.add(char_3);
        SpellerController.AbstractExpandableItem.Char char_4 = SpellerController.AbstractExpandableItem.Char.createInstance(SpellerCharsetDefinitionEurope.getumlaut_l_arBand(n), "\ufefb");
        arrayList.add(char_4);
        SpellerController.AbstractExpandableItem.Char char_5 = SpellerController.AbstractExpandableItem.Char.createInstance(SpellerCharsetDefinitionEurope.getumlaut_h_arBand(n), "\u0621");
        arrayList.add(char_5);
        return arrayList;
    }

    private static List getmainBand(int n) {
        ArrayList arrayList = new ArrayList(30);
        switch (n) {
            case 0: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand(" \u00c4\u00d6\u00dc\u00df", " \u00e4\u00f6\u00fc\u00df", false));
                break;
            }
            case 27: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand(" \u00c6\u00d8\u00c5", " \u00e6\u00f8\u00e5", false));
                break;
            }
            case 19: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand(" \u00c5\u00c4\u00d6", " \u00e5\u00e4\u00f6", false));
                break;
            }
            case 30: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand(" \u00c5\u00c4\u00d6", " \u00e5\u00e4\u00f6", false));
                break;
            }
            case 31: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand(" \u010c\u0160\u017d", " \u010d\u0161\u017e", false));
                break;
            }
            case 29: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand(" \u00c6\u00d8\u00c5", " \u00e6\u00f8\u00e5", false));
                break;
            }
            default: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand(" ", " ", false));
            }
        }
        return arrayList;
    }

    private static List getnumbersBand(int n) {
        ArrayList arrayList = new ArrayList(30);
        arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("0123456789", null, true));
        return arrayList;
    }

    private static List getumlauts_arabicBand(int n) {
        ArrayList arrayList = new ArrayList(30);
        arrayList.addAll(SpellerCharsetDefinitionEurope.getumlaut_a_arBand(n));
        arrayList.addAll(SpellerCharsetDefinitionEurope.getumlaut_l_arBand(n));
        arrayList.addAll(SpellerCharsetDefinitionEurope.getumlaut_m_arBand(n));
        arrayList.addAll(SpellerCharsetDefinitionEurope.getumlaut_w_arBand(n));
        return arrayList;
    }

    private static List getspecialBand(int n) {
        ArrayList arrayList = new ArrayList(30);
        switch (n) {
            case 26: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand(" \u060c.:\u061f!\u061b,'-\\/_()\u20ac$&@\"#%*+<=>[]~", null, true));
                break;
            }
            default: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand(" .,?!'-/_:;()\u20ac$&@\"#%*+<=>[\\]~\u00a1\u00a2\u00a3\u00a7\u00bf", null, true));
            }
        }
        return arrayList;
    }

    private static List getcyrillicBand(int n) {
        ArrayList arrayList = new ArrayList(30);
        arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u0410\u0411\u0412\u0413\u0414\u0415\u0401\u0416\u0417\u0418\u0419\u041a\u041b\u041c\u041d\u041e\u041f\u0420\u0421\u0422\u0423\u0424\u0425\u0426\u0427\u0428\u0429\u042a\u042b\u042c\u042d\u042e\u042f", "\u0430\u0431\u0432\u0433\u0434\u0435\u0451\u0436\u0437\u0438\u0439\u043a\u043b\u043c\u043d\u043e\u043f\u0440\u0441\u0442\u0443\u0444\u0445\u0446\u0447\u0448\u0449\u044a\u044b\u044c\u044d\u044e\u044f", false));
        return arrayList;
    }

    private static List getumlauts_cyrillicBand(int n) {
        ArrayList arrayList = new ArrayList(30);
        arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u0402\u0403\u0404\u0405\u0406\u0407\u0408\u0409\u040a\u040b\u040c\u040e\u040f\u0490\u0492\u049a\u04a2\u04ae\u04b0\u04ba\u04c1\u04d8\u04e8", "\u0452\u0453\u0454\u0455\u0456\u0457\u0458\u0459\u045a\u045b\u045c\u045e\u045f\u0491\u0493\u049b\u04a3\u04af\u04b1\u04bb\u04c2\u04d9\u04e9", false));
        return arrayList;
    }

    private static List getumlaut_aBand(int n) {
        ArrayList arrayList = new ArrayList(30);
        switch (n) {
            case 27: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u00c0\u00c4\u00c1\u00c2\u00c3\u0100\u00c6\u00c5\u0102\u0104", "\u00e0\u00e4\u00e1\u00e2\u00e3\u0101\u00e6\u00e5\u0103\u0105", false));
                break;
            }
            case 30: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u00c5\u00c4\u00c0\u00c1\u00c2\u00c3\u00c6\u0100\u0102\u0104", "\u00e5\u00e4\u00e0\u00e1\u00e2\u00e3\u00e6\u0101\u0103\u0105", false));
                break;
            }
            case 5: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u00c1\u00c3\u00c0\u00c2\u00c4\u00c5\u00c6\u0100\u0104\u0102", "\u00e1\u00e3\u00e0\u00e2\u00e4\u00e5\u00e6\u0101\u0105\u0103", false));
                break;
            }
            case 29: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u00c6\u00c5\u00c1\u00c4\u00c0\u00c2\u00c3\u0100\u0102\u0104", "\u00e6\u00e5\u00e1\u00e4\u00e0\u00e2\u00e3\u0101\u0103\u0105", false));
                break;
            }
            case 1: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u00c0\u00c1\u00c2\u00c4\u00c6\u00c3\u00c5\u0100\u0104\u0102", "\u00e0\u00e1\u00e2\u00e4\u00e6\u00e3\u00e5\u0101\u0105\u0103", false));
                break;
            }
            case 4: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u00c0\u00c1\u00c2\u00c4\u00c6\u00c3\u00c5\u0100\u0104\u0102", "\u00e0\u00e1\u00e2\u00e4\u00e6\u00e3\u00e5\u0101\u0105\u0103", false));
                break;
            }
            case 2: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u00c0\u00c2\u00c6\u00c1\u00c4\u00c3\u00c5\u0100\u0102\u0104", "\u00e0\u00e2\u00e6\u00e1\u00e4\u00e3\u00e5\u0101\u0103\u0105", false));
                break;
            }
            case 28: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u00c1\u00c0\u00c2\u00c4\u00c6\u00c3\u00c5\u0100\u0104\u0102", "\u00e1\u00e0\u00e2\u00e4\u00e6\u00e3\u00e5\u0101\u0105\u0103", false));
                break;
            }
            case 3: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u00c1\u00c0\u00c4\u00c2\u00c3\u00c5\u0104\u00c6\u0100\u0102", "\u00e1\u00e0\u00e4\u00e2\u00e3\u00e5\u0105\u00e6\u0101\u0103", false));
                break;
            }
            case 26: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u0623\u0625\u0622", null, true));
                break;
            }
            case 19: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u00c1\u00c0\u00c2\u00c4\u00c6\u00c3\u00c5\u0100\u0104\u0102", "\u00e1\u00e0\u00e2\u00e4\u00e6\u00e3\u00e5\u0101\u0105\u0103", false));
                break;
            }
            case 31: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u00c0\u00c1\u00c2\u00c3\u00c4\u00c5\u00c6\u0100\u0102\u0104", "\u00e0\u00e1\u00e2\u00e3\u00e4\u00e5\u00e6\u0101\u0103\u0105", false));
                break;
            }
            case 20: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u00c1\u00c0\u0104\u00c2\u00c4\u00c6\u00c3\u00c5\u0100\u0102", "\u00e1\u00e0\u0105\u00e2\u00e4\u00e6\u00e3\u00e5\u0101\u0103", false));
                break;
            }
            case 18: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u0104\u00c0\u00c1\u00c2\u00c4\u00c6\u00c3\u00c5\u0100\u0102", "\u0105\u00e0\u00e1\u00e2\u00e4\u00e6\u00e3\u00e5\u0101\u0103", false));
                break;
            }
            case 33: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u0102\u00c2\u00c1\u00c0\u00c4\u00c6\u00c3\u00c5\u0100\u0104", "\u0103\u00e2\u00e1\u00e0\u00e4\u00e6\u00e3\u00e5\u0101\u0105", false));
                break;
            }
            case 6: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u00c1\u00c4\u00c2\u00c0\u00c6\u00c3\u00c5\u0100\u0102\u0104", "\u00e1\u00e4\u00e2\u00e0\u00e6\u00e3\u00e5\u0101\u0103\u0105", false));
                break;
            }
            case 21: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u00c0\u00c1\u00c2\u00c4\u00c6\u00c3\u00c5\u0100\u0104\u0102", "\u00e0\u00e1\u00e2\u00e4\u00e6\u00e3\u00e5\u0101\u0105\u0103", false));
                break;
            }
            default: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u00c4\u00c2\u00c0\u00c1\u00c6\u00c3\u00c5\u0100\u0102\u0104", "\u00e4\u00e2\u00e0\u00e1\u00e6\u00e3\u00e5\u0101\u0103\u0105", false));
            }
        }
        return arrayList;
    }

    private static List getumlaut_cBand(int n) {
        ArrayList arrayList = new ArrayList(30);
        switch (n) {
            case 30: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u010c\u00c7\u0106\u010a", "\u010d\u00e7\u0107\u010b", false));
                break;
            }
            case 5: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u00c7\u010c\u0106\u010a", "\u00e7\u010d\u0107\u010b", false));
                break;
            }
            case 31: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u010c\u0106\u00c7\u010a", "\u010d\u0107\u00e7\u010b", false));
                break;
            }
            case 20: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u010c\u00c7\u0106\u010a", "\u010d\u00e7\u0107\u010b", false));
                break;
            }
            case 18: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u0106\u00c7\u010c\u010a", "\u0107\u00e7\u010d\u010b", false));
                break;
            }
            default: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u00c7\u0106\u010c\u010a", "\u00e7\u0107\u010d\u010b", false));
            }
        }
        return arrayList;
    }

    private static List getumlaut_dBand(int n) {
        ArrayList arrayList = new ArrayList(30);
        switch (n) {
            case 31: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u0110\u010e", "\u0111\u010f", false));
                break;
            }
            default: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u010e\u0110", "\u010f\u0111", false));
            }
        }
        return arrayList;
    }

    private static List getumlaut_eBand(int n) {
        ArrayList arrayList = new ArrayList(30);
        switch (n) {
            case 27: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u00c8\u00c9\u00ca\u00cb\u0118\u0116\u0112\u011a\u018f", "\u00e8\u00e9\u00ea\u00eb\u0119\u0117\u0113\u011b\u0259", false));
                break;
            }
            case 5: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u00c9\u00ca\u00c8\u0118\u0116\u0112\u00cb\u011a\u018f", "\u00e9\u00ea\u00e8\u0119\u0117\u0113\u00eb\u011b\u0259", false));
                break;
            }
            case 1: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u00c8\u00c9\u00ca\u00cb\u0112\u0116\u0118\u011a\u018f", "\u00e8\u00e9\u00ea\u00eb\u0113\u0117\u0119\u011b\u0259", false));
                break;
            }
            case 4: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u00c8\u00c9\u00ca\u00cb\u0118\u0116\u0112\u011a\u018f", "\u00e8\u00e9\u00ea\u00eb\u0119\u0117\u0113\u011b\u0259", false));
                break;
            }
            case 2: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u00c9\u00c8\u00ca\u00cb\u0116\u0112\u0118\u011a\u018f", "\u00e9\u00e8\u00ea\u00eb\u0117\u0113\u0119\u011b\u0259", false));
                break;
            }
            case 28: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u00c9\u00c8\u00ca\u00cb\u0118\u0116\u0112\u011a\u018f", "\u00e9\u00e8\u00ea\u00eb\u0119\u0117\u0113\u011b\u0259", false));
                break;
            }
            case 3: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u00c9\u00c8\u00cb\u00ca\u0116\u0112\u0118\u011a\u018f", "\u00e9\u00e8\u00eb\u00ea\u0117\u0113\u0119\u011b\u0259", false));
                break;
            }
            case 19: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u00c9\u00c8\u00ca\u00cb\u0118\u0112\u0116\u011a\u018f", "\u00e9\u00e8\u00ea\u00eb\u0119\u0113\u0117\u011b\u0259", false));
                break;
            }
            case 31: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u00c8\u00c9\u00ca\u00cb\u0112\u0116\u0118\u011a\u018f", "\u00e8\u00e9\u00ea\u00eb\u0113\u0117\u0119\u011b\u0259", false));
                break;
            }
            case 20: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u011a\u00c9\u00c8\u00ca\u00cb\u0118\u0116\u0112\u018f", "\u011b\u00e9\u00e8\u00ea\u00eb\u0119\u0117\u0113\u0259", false));
                break;
            }
            case 18: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u0118\u00c8\u00c9\u00ca\u00cb\u0116\u0112\u011a\u018f", "\u0119\u00e8\u00e9\u00ea\u00eb\u0117\u0113\u011b\u0259", false));
                break;
            }
            case 33: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u00c9\u00c8\u00ca\u00cb\u0118\u0116\u0112\u011a\u018f", "\u00e9\u00e8\u00ea\u00eb\u0119\u0117\u0113\u011b\u0259", false));
                break;
            }
            case 21: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u00c8\u00c9\u00ca\u00cb\u0112\u0116\u0118\u011a\u018f", "\u00e8\u00e9\u00ea\u00eb\u0113\u0117\u0119\u011b\u0259", false));
                break;
            }
            case 6: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u00c9\u00cb\u00ca\u00c8\u0118\u0116\u0112\u011a\u018f", "\u00e9\u00eb\u00ea\u00e8\u0119\u0117\u0113\u011b\u0259", false));
                break;
            }
            default: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u00c9\u00c8\u00ca\u00cb\u0112\u0116\u0118\u011a\u018f", "\u00e9\u00e8\u00ea\u00eb\u0113\u0117\u0119\u011b\u0259", false));
            }
        }
        return arrayList;
    }

    private static List getumlaut_gBand(int n) {
        ArrayList arrayList = new ArrayList(30);
        switch (n) {
            case 31: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u0122\u011e\u0120", "\u0123\u011f\u0121", false));
                break;
            }
            default: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u011e\u0120\u0122", "\u011f\u0121\u0123", false));
            }
        }
        return arrayList;
    }

    private static List getumlaut_hBand(int n) {
        ArrayList arrayList = new ArrayList(30);
        switch (n) {
            case 26: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u0623\u0625\u0626\u0624", null, true));
                break;
            }
            default: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u0126", "\u0127", false));
            }
        }
        return arrayList;
    }

    private static List getumlaut_iBand(int n) {
        ArrayList arrayList = new ArrayList(30);
        switch (n) {
            case 30: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u00cc\u00cd\u00ce\u00cf\u012a\u012e\u0130\u0128", "\u00ec\u00ed\u00ee\u00ef\u012b\u012fi\u0129", false));
                break;
            }
            case 5: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u00cd\u00ce\u00cc\u00cf\u012e\u012a\u0130\u0128", "\u00ed\u00ee\u00ec\u00ef\u012f\u012b\u0131\u0129", false));
                break;
            }
            case 29: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u00cc\u00cd\u00ce\u00cf\u012a\u0130\u012e\u0128", "\u00ec\u00ed\u00ee\u00ef\u012bi\u012f\u0129", false));
                break;
            }
            case 1: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u00ce\u00cf\u00cd\u012a\u012e\u0130\u00cc\u0128", "\u00ee\u00ef\u00ed\u012b\u012f\u0131\u00ec\u0129", false));
                break;
            }
            case 4: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u00cc\u00cd\u00ce\u00cf\u012e\u012a\u0130\u0128", "\u00ec\u00ed\u00ee\u00ef\u012f\u012b\u0131\u0129", false));
                break;
            }
            case 2: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u00ce\u00cf\u00cc\u00cd\u012e\u012a\u0130\u0128", "\u00ee\u00ef\u00ec\u00ed\u012f\u012b\u0131\u0129", false));
                break;
            }
            case 28: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u00cd\u00ce\u00cf\u00cc\u012e\u012a\u0130\u0128", "\u00ed\u00ee\u00ef\u00ec\u012f\u012b\u0131\u0129", false));
                break;
            }
            case 3: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u00cd\u00cf\u00cc\u00ce\u012e\u012a\u0130\u0128", "\u00ed\u00ef\u00ec\u00ee\u012f\u012b\u0131\u0129", false));
                break;
            }
            case 19: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u00ce\u00cf\u00cd\u012a\u012e\u0130\u00cc\u0128", "\u00ee\u00ef\u00ed\u012b\u012f\u0131\u00ec\u0129", false));
                break;
            }
            case 31: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u00cc\u00cd\u00ce\u00cf\u012a\u012e\u0130\u0128", "\u00ec\u00ed\u00ee\u00ef\u012b\u012fi\u0129", false));
                break;
            }
            case 20: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u00cd\u00ce\u00cf\u00cc\u012e\u012a\u0130\u0128", "\u00ed\u00ee\u00ef\u00ec\u012f\u012b\u0131\u0129", false));
                break;
            }
            case 18: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u00cd\u00cf\u00cc\u00ce\u012e\u012a\u0130\u0128", "\u00ed\u00ef\u00ec\u00ee\u012f\u012b\u0131\u0129", false));
                break;
            }
            case 33: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u00ce\u00cd\u00cf\u00cc\u012e\u012a\u0130\u0128", "\u00ee\u00ed\u00ef\u00ec\u012f\u012bi\u0129", false));
                break;
            }
            case 21: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u00ce\u00cf\u00cd\u012a\u012e\u00cc\u0130\u0128", "\u00ee\u00ef\u00ed\u012b\u012f\u00ec\u0131\u0129", false));
                break;
            }
            default: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u00ce\u00cf\u00cd\u012a\u00cc\u012e\u0130\u0128", "\u00ee\u00ef\u00ed\u012b\u00ec\u012f\u0131\u0129", false));
            }
        }
        return arrayList;
    }

    private static List getumlaut_kBand(int n) {
        ArrayList arrayList = new ArrayList(30);
        arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u0136", "\u0137", false));
        return arrayList;
    }

    private static List getumlaut_lBand(int n) {
        ArrayList arrayList = new ArrayList(30);
        switch (n) {
            case 26: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\ufef5\ufef7\ufef9", null, true));
                break;
            }
            case 20: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u0141\u013d\u0139\u013b", "\u0142\u013e\u013a\u013c", false));
                break;
            }
            case 18: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u0141\u013b\u013d\u0139", "\u0142\u013c\u013e\u013a", false));
                break;
            }
            case 21: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u0141\u013b\u013d\u0139", "\u0142\u013c\u013e\u013a", false));
                break;
            }
            default: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u013b\u013d\u0141\u0139", "\u013c\u013e\u0142\u013a", false));
            }
        }
        return arrayList;
    }

    private static List getumlaut_nBand(int n) {
        ArrayList arrayList = new ArrayList(30);
        switch (n) {
            case 30: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u0143\u0145\u0147\u00d1", "\u0144\u0146\u0148\u00f1", false));
                break;
            }
            case 20: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u0147\u00d1\u0143\u0145", "\u0148\u00f1\u0144\u0146", false));
                break;
            }
            case 29: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u0143\u0145\u0147\u00d1", "\u0144\u0146\u0148\u00f1", false));
                break;
            }
            case 18: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u0143\u00d1\u0145\u0147", "\u0144\u00f1\u0146\u0148", false));
                break;
            }
            default: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u00d1\u0143\u0145\u0147", "\u00f1\u0144\u0146\u0148", false));
            }
        }
        return arrayList;
    }

    private static List getumlaut_oBand(int n) {
        ArrayList arrayList = new ArrayList(30);
        switch (n) {
            case 27: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u00d4\u00d2\u00d3\u00d6\u00d5\u0152\u00d8\u0150", "\u00f4\u00f2\u00f3\u00f6\u00f5\u0153\u00f8\u0151", false));
                break;
            }
            case 30: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u00d6\u00d2\u00d3\u00d4\u00d5\u00d8\u0150\u0152", "\u00f6\u00f2\u00f3\u00f4\u00f5\u00f8\u0151\u0153", false));
                break;
            }
            case 5: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u00d3\u00d5\u00d4\u00d2\u00d6\u0152\u00d8\u0150", "\u00f3\u00f5\u00f4\u00f2\u00f6\u0153\u00f8\u0151", false));
                break;
            }
            case 29: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u00d8\u00d4\u00d6\u00d2\u00d3\u00d5\u0150\u0152", "\u00f8\u00f4\u00f6\u00f2\u00f3\u00f5\u0151\u0153", false));
                break;
            }
            case 1: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u00d4\u00d6\u00d2\u00d3\u0152\u00d5\u00d8\u0150", "\u00f4\u00f6\u00f2\u00f3\u0153\u00f5\u00f8\u0151", false));
                break;
            }
            case 4: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u00d2\u00d3\u00d4\u00d6\u00d5\u0152\u00d8\u0150", "\u00f2\u00f3\u00f4\u00f6\u00f5\u0153\u00f8\u0151", false));
                break;
            }
            case 2: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u00d4\u0152\u00d6\u00d2\u00d3\u00d5\u00d8\u0150", "\u00f4\u0153\u00f6\u00f2\u00f3\u00f5\u00f8\u0151", false));
                break;
            }
            case 28: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u00d3\u00d6\u0150\u00d4\u00d2\u00d5\u0152\u00d8", "\u00f3\u00f6\u0151\u00f4\u00f2\u00f5\u0153\u00f8", false));
                break;
            }
            case 3: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u00d3\u00d2\u00d6\u00d4\u00d5\u00d8\u0152\u0150", "\u00f3\u00f2\u00f6\u00f4\u00f5\u00f8\u0153\u0151", false));
                break;
            }
            case 19: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u0152\u00d4\u00d2\u00d3\u00d5\u00d8\u0150\u00d6", "\u0153\u00f4\u00f2\u00f3\u00f5\u00f8\u0151\u00f6", false));
                break;
            }
            case 31: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u00d2\u00d3\u00d4\u00d5\u00d6\u00d8\u0150\u0152", "\u00f2\u00f3\u00f4\u00f5\u00f6\u00f8\u0151\u0153", false));
                break;
            }
            case 20: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u00d3\u00d4\u00d6\u00d2\u00d5\u0152\u00d8\u0150", "\u00f3\u00f4\u00f6\u00f2\u00f5\u0153\u00f8\u0151", false));
                break;
            }
            case 18: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u00d3\u00d4\u00d6\u00d2\u00d5\u0152\u00d8\u0150", "\u00f3\u00f4\u00f6\u00f2\u00f5\u0153\u00f8\u0151", false));
                break;
            }
            case 33: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u00d3\u00d6\u0150\u00d4\u00d2\u00d5\u0152\u00d8", "\u00f3\u00f6\u0151\u00f4\u00f2\u00f5\u0153\u00f8", false));
                break;
            }
            case 21: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u00d4\u00d6\u00d2\u00d3\u0152\u00d8\u00d5\u0150", "\u00f4\u00f6\u00f2\u00f3\u0153\u00f8\u00f5\u0151", false));
                break;
            }
            case 6: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u00d3\u00d6\u00d4\u00d2\u00d5\u0152\u00d8\u0150", "\u00f3\u00f6\u00f4\u00f2\u00f5\u0153\u00f8\u0151", false));
                break;
            }
            default: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u00d6\u00d4\u00d2\u00d3\u00d5\u0152\u00d8\u0150", "\u00f6\u00f4\u00f2\u00f3\u00f5\u0153\u00f8\u0151", false));
            }
        }
        return arrayList;
    }

    private static List getumlaut_rBand(int n) {
        ArrayList arrayList = new ArrayList(30);
        switch (n) {
            case 31: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u0154\u0158", "\u0155\u0159", false));
                break;
            }
            case 20: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u0154\u0158", "\u0155\u0159", false));
                break;
            }
            default: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u0158\u0154", "\u0159\u0155", false));
            }
        }
        return arrayList;
    }

    private static List getumlaut_sBand(int n) {
        ArrayList arrayList = new ArrayList(30);
        switch (n) {
            case 31: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u0160\u00df\u015a\u015e", "\u0161\u00df\u015b\u015f", false));
                break;
            }
            case 20: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u0160\u015a\u015e\u00df", "\u0161\u015b\u015f\u00df", false));
                break;
            }
            case 4: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u015a\u015e\u0160\u00df", "\u015b\u015f\u0161\u00df", false));
                break;
            }
            case 2: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u015a\u015e\u0160\u00df", "\u015b\u015f\u0161\u00df", false));
                break;
            }
            case 18: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u015a\u00df\u0160\u015e", "\u015b\u00df\u0161\u015f", false));
                break;
            }
            case 33: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u015e\u00df\u015a\u0160", "\u015f\u00df\u015b\u0161", false));
                break;
            }
            case 3: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u015a\u015e\u0160\u00df", "\u015b\u015f\u0161\u00df", false));
                break;
            }
            default: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u00df\u015a\u0160\u015e", "\u00df\u015b\u0161\u015f", false));
            }
        }
        return arrayList;
    }

    private static List getumlaut_tBand(int n) {
        ArrayList arrayList = new ArrayList(30);
        switch (n) {
            case 30: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u0164\u0162", "\u0165\u0163", false));
                break;
            }
            case 31: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u0164\u0162", "\u0165\u0163", false));
                break;
            }
            case 20: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u0164\u0162", "\u0165\u0163", false));
                break;
            }
            default: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u0162\u0164", "\u0163\u0165", false));
            }
        }
        return arrayList;
    }

    private static List getumlaut_uBand(int n) {
        ArrayList arrayList = new ArrayList(30);
        switch (n) {
            case 30: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u00d9\u00da\u00db\u00dc\u016a\u016e\u0170\u0172", "\u00f9\u00fa\u00fb\u00fc\u016b\u016f\u0171\u0173", false));
                break;
            }
            case 5: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u00da\u00dc\u00d9\u00db\u016a\u0170\u0172\u016e", "\u00fa\u00fc\u00f9\u00fb\u016b\u0171\u0173\u016f", false));
                break;
            }
            case 29: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u00dc\u00d9\u00da\u00db\u016a\u016e\u0170\u0172", "\u00fc\u00f9\u00fa\u00fb\u016b\u016f\u0171\u0173", false));
                break;
            }
            case 1: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u00db\u00dc\u00d9\u00da\u016a\u0170\u0172\u016e", "\u00fb\u00fc\u00f9\u00fa\u016b\u0171\u0173\u016f", false));
                break;
            }
            case 4: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u00d9\u00da\u00db\u00dc\u016a\u0170\u0172\u016e", "\u00f9\u00fa\u00fb\u00fc\u016b\u0171\u0173\u016f", false));
                break;
            }
            case 2: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u00db\u00d9\u00dc\u00da\u016a\u0170\u0172\u016e", "\u00fb\u00f9\u00fc\u00fa\u016b\u0171\u0173\u016f", false));
                break;
            }
            case 28: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u00da\u00dc\u0170\u00db\u00d9\u016a\u0172\u016e", "\u00fa\u00fc\u0171\u00fb\u00f9\u016b\u0173\u016f", false));
                break;
            }
            case 3: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u00da\u00dc\u00d9\u00db\u016a\u0170\u0172\u016e", "\u00fa\u00fc\u00f9\u00fb\u016b\u0171\u0173\u016f", false));
                break;
            }
            case 31: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u00d9\u00da\u00db\u00dc\u016a\u016e\u0170\u0172", "\u00f9\u00fa\u00fb\u00fc\u016b\u016f\u0171\u0173", false));
                break;
            }
            case 20: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u00da\u016e\u00db\u00dc\u00d9\u016a\u0170\u0172", "\u00fa\u016f\u00fb\u00fc\u00f9\u016b\u0171\u0173", false));
                break;
            }
            case 18: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u00da\u00dc\u00d9\u00db\u016a\u0170\u0172\u016e", "\u00fa\u00fc\u00f9\u00fb\u016b\u0171\u0173\u016f", false));
                break;
            }
            case 33: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u00da\u00dc\u0170\u00db\u00d9\u016a\u0172\u016e", "\u00fa\u00fc\u0171\u00fb\u00f9\u016b\u0173\u016f", false));
                break;
            }
            case 21: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u00db\u00dc\u00d9\u00da\u016a\u0170\u0172\u016e", "\u00fb\u00fc\u00f9\u00fa\u016b\u0171\u0173\u016f", false));
                break;
            }
            case 6: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u00da\u00dc\u00db\u00d9\u016a\u0170\u0172\u016e", "\u00fa\u00fc\u00fb\u00f9\u016b\u0171\u0173\u016f", false));
                break;
            }
            default: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u00dc\u00db\u00d9\u00da\u016a\u0170\u0172\u016e", "\u00fc\u00fb\u00f9\u00fa\u016b\u0171\u0173\u016f", false));
            }
        }
        return arrayList;
    }

    private static List getumlaut_yBand(int n) {
        ArrayList arrayList = new ArrayList(30);
        switch (n) {
            case 21: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u0178\u00dd", "\u00ff\u00fd", false));
                break;
            }
            default: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u00dd\u0178", "\u00fd\u00ff", false));
            }
        }
        return arrayList;
    }

    private static List getumlaut_zBand(int n) {
        ArrayList arrayList = new ArrayList(30);
        switch (n) {
            case 19: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u017d\u0179\u017b", "\u017e\u017a\u017c", false));
                break;
            }
            case 30: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u017b\u017d\u0179", "\u017c\u017e\u017a", false));
                break;
            }
            case 5: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u017d\u0179\u017b", "\u017e\u017a\u017c", false));
                break;
            }
            case 31: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u017d\u0179\u017b", "\u017e\u017a\u017c", false));
                break;
            }
            case 20: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u017d\u0179\u017b", "\u017e\u017a\u017c", false));
                break;
            }
            case 1: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u017d\u0179\u017b", "\u017e\u017a\u017c", false));
                break;
            }
            case 18: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u017b\u0179\u017d", "\u017c\u017a\u017e", false));
                break;
            }
            case 28: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u017d\u0179\u017b", "\u017e\u017a\u017c", false));
                break;
            }
            case 33: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u017d\u0179\u017b", "\u017e\u017a\u017c", false));
                break;
            }
            case 21: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u017d\u0179\u017b", "\u017e\u017a\u017c", false));
                break;
            }
            default: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("\u0179\u017b\u017d", "\u017a\u017c\u017e", false));
            }
        }
        return arrayList;
    }

    private static List getlatinExpandableAZBand(int n) {
        ArrayList arrayList = new ArrayList(30);
        switch (n) {
            case 26: {
                SpellerController.AbstractExpandableItem.Char char_ = SpellerController.AbstractExpandableItem.Char.createInstance(SpellerCharsetDefinitionEurope.getumlaut_a_arBand(n), "\u0627");
                arrayList.add(char_);
                SpellerController.SingleCharItem singleCharItem = SpellerController.SingleCharItem.createInstance("\u0628");
                arrayList.add(singleCharItem);
                SpellerController.SingleCharItem singleCharItem2 = SpellerController.SingleCharItem.createInstance("\u062a");
                arrayList.add(singleCharItem2);
                SpellerController.SingleCharItem singleCharItem3 = SpellerController.SingleCharItem.createInstance("\u062b");
                arrayList.add(singleCharItem3);
                SpellerController.SingleCharItem singleCharItem4 = SpellerController.SingleCharItem.createInstance("\u062c");
                arrayList.add(singleCharItem4);
                SpellerController.SingleCharItem singleCharItem5 = SpellerController.SingleCharItem.createInstance("\u062d");
                arrayList.add(singleCharItem5);
                SpellerController.SingleCharItem singleCharItem6 = SpellerController.SingleCharItem.createInstance("\u062e");
                arrayList.add(singleCharItem6);
                SpellerController.SingleCharItem singleCharItem7 = SpellerController.SingleCharItem.createInstance("\u062f");
                arrayList.add(singleCharItem7);
                SpellerController.SingleCharItem singleCharItem8 = SpellerController.SingleCharItem.createInstance("\u0630");
                arrayList.add(singleCharItem8);
                SpellerController.SingleCharItem singleCharItem9 = SpellerController.SingleCharItem.createInstance("\u0631");
                arrayList.add(singleCharItem9);
                SpellerController.SingleCharItem singleCharItem10 = SpellerController.SingleCharItem.createInstance("\u0632");
                arrayList.add(singleCharItem10);
                SpellerController.SingleCharItem singleCharItem11 = SpellerController.SingleCharItem.createInstance("\u0633");
                arrayList.add(singleCharItem11);
                SpellerController.SingleCharItem singleCharItem12 = SpellerController.SingleCharItem.createInstance("\u0634");
                arrayList.add(singleCharItem12);
                SpellerController.SingleCharItem singleCharItem13 = SpellerController.SingleCharItem.createInstance("\u0635");
                arrayList.add(singleCharItem13);
                SpellerController.SingleCharItem singleCharItem14 = SpellerController.SingleCharItem.createInstance("\u0636");
                arrayList.add(singleCharItem14);
                SpellerController.SingleCharItem singleCharItem15 = SpellerController.SingleCharItem.createInstance("\u0637");
                arrayList.add(singleCharItem15);
                SpellerController.SingleCharItem singleCharItem16 = SpellerController.SingleCharItem.createInstance("\u0638");
                arrayList.add(singleCharItem16);
                SpellerController.SingleCharItem singleCharItem17 = SpellerController.SingleCharItem.createInstance("\u0639");
                arrayList.add(singleCharItem17);
                SpellerController.SingleCharItem singleCharItem18 = SpellerController.SingleCharItem.createInstance("\u063a");
                arrayList.add(singleCharItem18);
                SpellerController.SingleCharItem singleCharItem19 = SpellerController.SingleCharItem.createInstance("\u0641");
                arrayList.add(singleCharItem19);
                SpellerController.SingleCharItem singleCharItem20 = SpellerController.SingleCharItem.createInstance("\u0642");
                arrayList.add(singleCharItem20);
                SpellerController.SingleCharItem singleCharItem21 = SpellerController.SingleCharItem.createInstance("\u0643");
                arrayList.add(singleCharItem21);
                SpellerController.SingleCharItem singleCharItem22 = SpellerController.SingleCharItem.createInstance("\u0644");
                arrayList.add(singleCharItem22);
                SpellerController.SingleCharItem singleCharItem23 = SpellerController.SingleCharItem.createInstance("\u0645");
                arrayList.add(singleCharItem23);
                SpellerController.SingleCharItem singleCharItem24 = SpellerController.SingleCharItem.createInstance("\u0646");
                arrayList.add(singleCharItem24);
                SpellerController.SingleCharItem singleCharItem25 = SpellerController.SingleCharItem.createInstance("\u0647");
                arrayList.add(singleCharItem25);
                SpellerController.AbstractExpandableItem.Char char_2 = SpellerController.AbstractExpandableItem.Char.createInstance(SpellerCharsetDefinitionEurope.getumlaut_w_arBand(n), "\u0648");
                arrayList.add(char_2);
                SpellerController.SingleCharItem singleCharItem26 = SpellerController.SingleCharItem.createInstance("\u064a");
                arrayList.add(singleCharItem26);
                SpellerController.SingleCharItem singleCharItem27 = SpellerController.SingleCharItem.createInstance("\u0629");
                arrayList.add(singleCharItem27);
                SpellerController.AbstractExpandableItem.Char char_3 = SpellerController.AbstractExpandableItem.Char.createInstance(SpellerCharsetDefinitionEurope.getumlaut_m_arBand(n), "\u0649");
                arrayList.add(char_3);
                SpellerController.AbstractExpandableItem.Char char_4 = SpellerController.AbstractExpandableItem.Char.createInstance(SpellerCharsetDefinitionEurope.getumlaut_l_arBand(n), "\ufefb");
                arrayList.add(char_4);
                SpellerController.AbstractExpandableItem.Char char_5 = SpellerController.AbstractExpandableItem.Char.createInstance(SpellerCharsetDefinitionEurope.getumlaut_h_arBand(n), "\u0621");
                arrayList.add(char_5);
                break;
            }
            case 3: {
                SpellerController.AbstractExpandableItem.Char char_ = SpellerController.AbstractExpandableItem.Char.createInstance(SpellerCharsetDefinitionEurope.getumlaut_aBand(n), "A", "a");
                arrayList.add(char_);
                SpellerController.SingleCharItem singleCharItem = SpellerController.SingleCharItem.createInstance("B", "b");
                arrayList.add(singleCharItem);
                SpellerController.AbstractExpandableItem.Char char_6 = SpellerController.AbstractExpandableItem.Char.createInstance(SpellerCharsetDefinitionEurope.getumlaut_cBand(n), "C", "c");
                arrayList.add(char_6);
                SpellerController.AbstractExpandableItem.Char char_7 = SpellerController.AbstractExpandableItem.Char.createInstance(SpellerCharsetDefinitionEurope.getumlaut_dBand(n), "D", "d");
                arrayList.add(char_7);
                SpellerController.AbstractExpandableItem.Char char_8 = SpellerController.AbstractExpandableItem.Char.createInstance(SpellerCharsetDefinitionEurope.getumlaut_eBand(n), "E", "e");
                arrayList.add(char_8);
                SpellerController.SingleCharItem singleCharItem28 = SpellerController.SingleCharItem.createInstance("F", "f");
                arrayList.add(singleCharItem28);
                SpellerController.AbstractExpandableItem.Char char_9 = SpellerController.AbstractExpandableItem.Char.createInstance(SpellerCharsetDefinitionEurope.getumlaut_gBand(n), "G", "g");
                arrayList.add(char_9);
                SpellerController.AbstractExpandableItem.Char char_10 = SpellerController.AbstractExpandableItem.Char.createInstance(SpellerCharsetDefinitionEurope.getumlaut_hBand(n), "H", "h");
                arrayList.add(char_10);
                SpellerController.AbstractExpandableItem.Char char_11 = SpellerController.AbstractExpandableItem.Char.createInstance(SpellerCharsetDefinitionEurope.getumlaut_iBand(n), "I", "i");
                arrayList.add(char_11);
                SpellerController.SingleCharItem singleCharItem29 = SpellerController.SingleCharItem.createInstance("J", "j");
                arrayList.add(singleCharItem29);
                SpellerController.AbstractExpandableItem.Char char_12 = SpellerController.AbstractExpandableItem.Char.createInstance(SpellerCharsetDefinitionEurope.getumlaut_kBand(n), "K", "k");
                arrayList.add(char_12);
                SpellerController.AbstractExpandableItem.Char char_13 = SpellerController.AbstractExpandableItem.Char.createInstance(SpellerCharsetDefinitionEurope.getumlaut_lBand(n), "L", "l");
                arrayList.add(char_13);
                SpellerController.SingleCharItem singleCharItem30 = SpellerController.SingleCharItem.createInstance("M", "m");
                arrayList.add(singleCharItem30);
                SpellerController.AbstractExpandableItem.Char char_14 = SpellerController.AbstractExpandableItem.Char.createInstance(SpellerCharsetDefinitionEurope.getumlaut_nBand(n), "N", "n");
                arrayList.add(char_14);
                SpellerController.SingleCharItem singleCharItem31 = SpellerController.SingleCharItem.createInstance("\u00d1", "\u00f1");
                arrayList.add(singleCharItem31);
                SpellerController.AbstractExpandableItem.Char char_15 = SpellerController.AbstractExpandableItem.Char.createInstance(SpellerCharsetDefinitionEurope.getumlaut_oBand(n), "O", "o");
                arrayList.add(char_15);
                SpellerController.SingleCharItem singleCharItem32 = SpellerController.SingleCharItem.createInstance("P", "p");
                arrayList.add(singleCharItem32);
                SpellerController.SingleCharItem singleCharItem33 = SpellerController.SingleCharItem.createInstance("Q", "q");
                arrayList.add(singleCharItem33);
                SpellerController.AbstractExpandableItem.Char char_16 = SpellerController.AbstractExpandableItem.Char.createInstance(SpellerCharsetDefinitionEurope.getumlaut_rBand(n), "R", "r");
                arrayList.add(char_16);
                SpellerController.AbstractExpandableItem.Char char_17 = SpellerController.AbstractExpandableItem.Char.createInstance(SpellerCharsetDefinitionEurope.getumlaut_sBand(n), "S", "s");
                arrayList.add(char_17);
                SpellerController.AbstractExpandableItem.Char char_18 = SpellerController.AbstractExpandableItem.Char.createInstance(SpellerCharsetDefinitionEurope.getumlaut_tBand(n), "T", "t");
                arrayList.add(char_18);
                SpellerController.AbstractExpandableItem.Char char_19 = SpellerController.AbstractExpandableItem.Char.createInstance(SpellerCharsetDefinitionEurope.getumlaut_uBand(n), "U", "u");
                arrayList.add(char_19);
                SpellerController.SingleCharItem singleCharItem34 = SpellerController.SingleCharItem.createInstance("V", "v");
                arrayList.add(singleCharItem34);
                SpellerController.SingleCharItem singleCharItem35 = SpellerController.SingleCharItem.createInstance("W", "w");
                arrayList.add(singleCharItem35);
                SpellerController.SingleCharItem singleCharItem36 = SpellerController.SingleCharItem.createInstance("X", "x");
                arrayList.add(singleCharItem36);
                SpellerController.AbstractExpandableItem.Char char_20 = SpellerController.AbstractExpandableItem.Char.createInstance(SpellerCharsetDefinitionEurope.getumlaut_yBand(n), "Y", "y");
                arrayList.add(char_20);
                SpellerController.AbstractExpandableItem.Char char_21 = SpellerController.AbstractExpandableItem.Char.createInstance(SpellerCharsetDefinitionEurope.getumlaut_zBand(n), "Z", "z");
                arrayList.add(char_21);
                break;
            }
            default: {
                SpellerController.AbstractExpandableItem.Char char_ = SpellerController.AbstractExpandableItem.Char.createInstance(SpellerCharsetDefinitionEurope.getumlaut_aBand(n), "A", "a");
                arrayList.add(char_);
                SpellerController.SingleCharItem singleCharItem = SpellerController.SingleCharItem.createInstance("B", "b");
                arrayList.add(singleCharItem);
                SpellerController.AbstractExpandableItem.Char char_22 = SpellerController.AbstractExpandableItem.Char.createInstance(SpellerCharsetDefinitionEurope.getumlaut_cBand(n), "C", "c");
                arrayList.add(char_22);
                SpellerController.AbstractExpandableItem.Char char_23 = SpellerController.AbstractExpandableItem.Char.createInstance(SpellerCharsetDefinitionEurope.getumlaut_dBand(n), "D", "d");
                arrayList.add(char_23);
                SpellerController.AbstractExpandableItem.Char char_24 = SpellerController.AbstractExpandableItem.Char.createInstance(SpellerCharsetDefinitionEurope.getumlaut_eBand(n), "E", "e");
                arrayList.add(char_24);
                SpellerController.SingleCharItem singleCharItem37 = SpellerController.SingleCharItem.createInstance("F", "f");
                arrayList.add(singleCharItem37);
                SpellerController.AbstractExpandableItem.Char char_25 = SpellerController.AbstractExpandableItem.Char.createInstance(SpellerCharsetDefinitionEurope.getumlaut_gBand(n), "G", "g");
                arrayList.add(char_25);
                SpellerController.AbstractExpandableItem.Char char_26 = SpellerController.AbstractExpandableItem.Char.createInstance(SpellerCharsetDefinitionEurope.getumlaut_hBand(n), "H", "h");
                arrayList.add(char_26);
                SpellerController.AbstractExpandableItem.Char char_27 = SpellerController.AbstractExpandableItem.Char.createInstance(SpellerCharsetDefinitionEurope.getumlaut_iBand(n), "I", "i");
                arrayList.add(char_27);
                SpellerController.SingleCharItem singleCharItem38 = SpellerController.SingleCharItem.createInstance("J", "j");
                arrayList.add(singleCharItem38);
                SpellerController.AbstractExpandableItem.Char char_28 = SpellerController.AbstractExpandableItem.Char.createInstance(SpellerCharsetDefinitionEurope.getumlaut_kBand(n), "K", "k");
                arrayList.add(char_28);
                SpellerController.AbstractExpandableItem.Char char_29 = SpellerController.AbstractExpandableItem.Char.createInstance(SpellerCharsetDefinitionEurope.getumlaut_lBand(n), "L", "l");
                arrayList.add(char_29);
                SpellerController.SingleCharItem singleCharItem39 = SpellerController.SingleCharItem.createInstance("M", "m");
                arrayList.add(singleCharItem39);
                SpellerController.AbstractExpandableItem.Char char_30 = SpellerController.AbstractExpandableItem.Char.createInstance(SpellerCharsetDefinitionEurope.getumlaut_nBand(n), "N", "n");
                arrayList.add(char_30);
                SpellerController.AbstractExpandableItem.Char char_31 = SpellerController.AbstractExpandableItem.Char.createInstance(SpellerCharsetDefinitionEurope.getumlaut_oBand(n), "O", "o");
                arrayList.add(char_31);
                SpellerController.SingleCharItem singleCharItem40 = SpellerController.SingleCharItem.createInstance("P", "p");
                arrayList.add(singleCharItem40);
                SpellerController.SingleCharItem singleCharItem41 = SpellerController.SingleCharItem.createInstance("Q", "q");
                arrayList.add(singleCharItem41);
                SpellerController.AbstractExpandableItem.Char char_32 = SpellerController.AbstractExpandableItem.Char.createInstance(SpellerCharsetDefinitionEurope.getumlaut_rBand(n), "R", "r");
                arrayList.add(char_32);
                SpellerController.AbstractExpandableItem.Char char_33 = SpellerController.AbstractExpandableItem.Char.createInstance(SpellerCharsetDefinitionEurope.getumlaut_sBand(n), "S", "s");
                arrayList.add(char_33);
                SpellerController.AbstractExpandableItem.Char char_34 = SpellerController.AbstractExpandableItem.Char.createInstance(SpellerCharsetDefinitionEurope.getumlaut_tBand(n), "T", "t");
                arrayList.add(char_34);
                SpellerController.AbstractExpandableItem.Char char_35 = SpellerController.AbstractExpandableItem.Char.createInstance(SpellerCharsetDefinitionEurope.getumlaut_uBand(n), "U", "u");
                arrayList.add(char_35);
                SpellerController.SingleCharItem singleCharItem42 = SpellerController.SingleCharItem.createInstance("V", "v");
                arrayList.add(singleCharItem42);
                SpellerController.SingleCharItem singleCharItem43 = SpellerController.SingleCharItem.createInstance("W", "w");
                arrayList.add(singleCharItem43);
                SpellerController.SingleCharItem singleCharItem44 = SpellerController.SingleCharItem.createInstance("X", "x");
                arrayList.add(singleCharItem44);
                SpellerController.AbstractExpandableItem.Char char_36 = SpellerController.AbstractExpandableItem.Char.createInstance(SpellerCharsetDefinitionEurope.getumlaut_yBand(n), "Y", "y");
                arrayList.add(char_36);
                SpellerController.AbstractExpandableItem.Char char_37 = SpellerController.AbstractExpandableItem.Char.createInstance(SpellerCharsetDefinitionEurope.getumlaut_zBand(n), "Z", "z");
                arrayList.add(char_37);
            }
        }
        return arrayList;
    }

    private static List getumlauts_latinBand(int n) {
        ArrayList arrayList = new ArrayList(30);
        arrayList.addAll(SpellerCharsetDefinitionEurope.getumlaut_aBand(n));
        arrayList.addAll(SpellerCharsetDefinitionEurope.getumlaut_cBand(n));
        arrayList.addAll(SpellerCharsetDefinitionEurope.getumlaut_dBand(n));
        arrayList.addAll(SpellerCharsetDefinitionEurope.getumlaut_eBand(n));
        arrayList.addAll(SpellerCharsetDefinitionEurope.getumlaut_gBand(n));
        arrayList.addAll(SpellerCharsetDefinitionEurope.getumlaut_hBand(n));
        arrayList.addAll(SpellerCharsetDefinitionEurope.getumlaut_iBand(n));
        arrayList.addAll(SpellerCharsetDefinitionEurope.getumlaut_kBand(n));
        arrayList.addAll(SpellerCharsetDefinitionEurope.getumlaut_lBand(n));
        arrayList.addAll(SpellerCharsetDefinitionEurope.getumlaut_nBand(n));
        arrayList.addAll(SpellerCharsetDefinitionEurope.getumlaut_oBand(n));
        arrayList.addAll(SpellerCharsetDefinitionEurope.getumlaut_rBand(n));
        arrayList.addAll(SpellerCharsetDefinitionEurope.getumlaut_sBand(n));
        arrayList.addAll(SpellerCharsetDefinitionEurope.getumlaut_tBand(n));
        arrayList.addAll(SpellerCharsetDefinitionEurope.getumlaut_uBand(n));
        arrayList.addAll(SpellerCharsetDefinitionEurope.getumlaut_yBand(n));
        arrayList.addAll(SpellerCharsetDefinitionEurope.getumlaut_zBand(n));
        return arrayList;
    }

    private static List getspecial_arBand(int n) {
        ArrayList arrayList = new ArrayList(30);
        arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand(" \u060c.:\u061f!\u061b,'-\\/_()\u20ac$&@\"#%*+<=>[]~", null, true));
        return arrayList;
    }

    private static List getsmileysBand(int n) {
        ArrayList arrayList = new ArrayList(30);
        SpellerController.ButtonItem buttonItem = SpellerController.ButtonItem.createInstance(SpellerController.SpellerButtonType.getSpellerButtonType(30));
        arrayList.add(buttonItem);
        SpellerController.ButtonItem buttonItem2 = SpellerController.ButtonItem.createInstance(SpellerController.SpellerButtonType.getSpellerButtonType(31));
        arrayList.add(buttonItem2);
        SpellerController.ButtonItem buttonItem3 = SpellerController.ButtonItem.createInstance(SpellerController.SpellerButtonType.getSpellerButtonType(32));
        arrayList.add(buttonItem3);
        SpellerController.ButtonItem buttonItem4 = SpellerController.ButtonItem.createInstance(SpellerController.SpellerButtonType.getSpellerButtonType(33));
        arrayList.add(buttonItem4);
        return arrayList;
    }

    private static List getdomainBand(int n) {
        ArrayList arrayList = new ArrayList(30);
        switch (n) {
            case 0: {
                SpellerController.SingleCharItem singleCharItem = SpellerController.SingleCharItem.createInstance(".de");
                arrayList.add(singleCharItem);
                SpellerController.SingleCharItem singleCharItem2 = SpellerController.SingleCharItem.createInstance(".net");
                arrayList.add(singleCharItem2);
                SpellerController.SingleCharItem singleCharItem3 = SpellerController.SingleCharItem.createInstance(".org");
                arrayList.add(singleCharItem3);
                SpellerController.SingleCharItem singleCharItem4 = SpellerController.SingleCharItem.createInstance(".info");
                arrayList.add(singleCharItem4);
                break;
            }
            case 27: {
                SpellerController.SingleCharItem singleCharItem = SpellerController.SingleCharItem.createInstance(".no");
                arrayList.add(singleCharItem);
                SpellerController.SingleCharItem singleCharItem5 = SpellerController.SingleCharItem.createInstance(".net");
                arrayList.add(singleCharItem5);
                SpellerController.SingleCharItem singleCharItem6 = SpellerController.SingleCharItem.createInstance(".org");
                arrayList.add(singleCharItem6);
                SpellerController.SingleCharItem singleCharItem7 = SpellerController.SingleCharItem.createInstance(".info");
                arrayList.add(singleCharItem7);
                break;
            }
            case 30: {
                SpellerController.SingleCharItem singleCharItem = SpellerController.SingleCharItem.createInstance(".fi");
                arrayList.add(singleCharItem);
                SpellerController.SingleCharItem singleCharItem8 = SpellerController.SingleCharItem.createInstance(".net");
                arrayList.add(singleCharItem8);
                SpellerController.SingleCharItem singleCharItem9 = SpellerController.SingleCharItem.createInstance(".org");
                arrayList.add(singleCharItem9);
                SpellerController.SingleCharItem singleCharItem10 = SpellerController.SingleCharItem.createInstance(".info");
                arrayList.add(singleCharItem10);
                break;
            }
            case 7: {
                SpellerController.SingleCharItem singleCharItem = SpellerController.SingleCharItem.createInstance(".ru");
                arrayList.add(singleCharItem);
                SpellerController.SingleCharItem singleCharItem11 = SpellerController.SingleCharItem.createInstance(".net");
                arrayList.add(singleCharItem11);
                SpellerController.SingleCharItem singleCharItem12 = SpellerController.SingleCharItem.createInstance(".org");
                arrayList.add(singleCharItem12);
                SpellerController.SingleCharItem singleCharItem13 = SpellerController.SingleCharItem.createInstance(".info");
                arrayList.add(singleCharItem13);
                break;
            }
            case 5: {
                SpellerController.SingleCharItem singleCharItem = SpellerController.SingleCharItem.createInstance(".pt");
                arrayList.add(singleCharItem);
                SpellerController.SingleCharItem singleCharItem14 = SpellerController.SingleCharItem.createInstance(".net");
                arrayList.add(singleCharItem14);
                SpellerController.SingleCharItem singleCharItem15 = SpellerController.SingleCharItem.createInstance(".org");
                arrayList.add(singleCharItem15);
                SpellerController.SingleCharItem singleCharItem16 = SpellerController.SingleCharItem.createInstance(".info");
                arrayList.add(singleCharItem16);
                break;
            }
            case 29: {
                SpellerController.SingleCharItem singleCharItem = SpellerController.SingleCharItem.createInstance(".dk");
                arrayList.add(singleCharItem);
                SpellerController.SingleCharItem singleCharItem17 = SpellerController.SingleCharItem.createInstance(".net");
                arrayList.add(singleCharItem17);
                SpellerController.SingleCharItem singleCharItem18 = SpellerController.SingleCharItem.createInstance(".org");
                arrayList.add(singleCharItem18);
                SpellerController.SingleCharItem singleCharItem19 = SpellerController.SingleCharItem.createInstance(".info");
                arrayList.add(singleCharItem19);
                break;
            }
            case 4: {
                SpellerController.SingleCharItem singleCharItem = SpellerController.SingleCharItem.createInstance(".it");
                arrayList.add(singleCharItem);
                SpellerController.SingleCharItem singleCharItem20 = SpellerController.SingleCharItem.createInstance(".net");
                arrayList.add(singleCharItem20);
                SpellerController.SingleCharItem singleCharItem21 = SpellerController.SingleCharItem.createInstance(".org");
                arrayList.add(singleCharItem21);
                SpellerController.SingleCharItem singleCharItem22 = SpellerController.SingleCharItem.createInstance(".info");
                arrayList.add(singleCharItem22);
                break;
            }
            case 34: {
                SpellerController.SingleCharItem singleCharItem = SpellerController.SingleCharItem.createInstance(".gr");
                arrayList.add(singleCharItem);
                SpellerController.SingleCharItem singleCharItem23 = SpellerController.SingleCharItem.createInstance(".net");
                arrayList.add(singleCharItem23);
                SpellerController.SingleCharItem singleCharItem24 = SpellerController.SingleCharItem.createInstance(".org");
                arrayList.add(singleCharItem24);
                SpellerController.SingleCharItem singleCharItem25 = SpellerController.SingleCharItem.createInstance(".info");
                arrayList.add(singleCharItem25);
                break;
            }
            case 2: {
                SpellerController.SingleCharItem singleCharItem = SpellerController.SingleCharItem.createInstance(".fr");
                arrayList.add(singleCharItem);
                SpellerController.SingleCharItem singleCharItem26 = SpellerController.SingleCharItem.createInstance(".net");
                arrayList.add(singleCharItem26);
                SpellerController.SingleCharItem singleCharItem27 = SpellerController.SingleCharItem.createInstance(".org");
                arrayList.add(singleCharItem27);
                SpellerController.SingleCharItem singleCharItem28 = SpellerController.SingleCharItem.createInstance(".info");
                arrayList.add(singleCharItem28);
                break;
            }
            case 32: {
                SpellerController.SingleCharItem singleCharItem = SpellerController.SingleCharItem.createInstance(".ua");
                arrayList.add(singleCharItem);
                SpellerController.SingleCharItem singleCharItem29 = SpellerController.SingleCharItem.createInstance(".net");
                arrayList.add(singleCharItem29);
                SpellerController.SingleCharItem singleCharItem30 = SpellerController.SingleCharItem.createInstance(".org");
                arrayList.add(singleCharItem30);
                SpellerController.SingleCharItem singleCharItem31 = SpellerController.SingleCharItem.createInstance(".info");
                arrayList.add(singleCharItem31);
                break;
            }
            case 35: {
                SpellerController.SingleCharItem singleCharItem = SpellerController.SingleCharItem.createInstance(".my");
                arrayList.add(singleCharItem);
                SpellerController.SingleCharItem singleCharItem32 = SpellerController.SingleCharItem.createInstance(".net");
                arrayList.add(singleCharItem32);
                SpellerController.SingleCharItem singleCharItem33 = SpellerController.SingleCharItem.createInstance(".org");
                arrayList.add(singleCharItem33);
                SpellerController.SingleCharItem singleCharItem34 = SpellerController.SingleCharItem.createInstance(".info");
                arrayList.add(singleCharItem34);
                break;
            }
            case 28: {
                SpellerController.SingleCharItem singleCharItem = SpellerController.SingleCharItem.createInstance(".hu");
                arrayList.add(singleCharItem);
                SpellerController.SingleCharItem singleCharItem35 = SpellerController.SingleCharItem.createInstance(".net");
                arrayList.add(singleCharItem35);
                SpellerController.SingleCharItem singleCharItem36 = SpellerController.SingleCharItem.createInstance(".org");
                arrayList.add(singleCharItem36);
                SpellerController.SingleCharItem singleCharItem37 = SpellerController.SingleCharItem.createInstance(".info");
                arrayList.add(singleCharItem37);
                break;
            }
            case 3: {
                SpellerController.SingleCharItem singleCharItem = SpellerController.SingleCharItem.createInstance(".es");
                arrayList.add(singleCharItem);
                SpellerController.SingleCharItem singleCharItem38 = SpellerController.SingleCharItem.createInstance(".net");
                arrayList.add(singleCharItem38);
                SpellerController.SingleCharItem singleCharItem39 = SpellerController.SingleCharItem.createInstance(".org");
                arrayList.add(singleCharItem39);
                SpellerController.SingleCharItem singleCharItem40 = SpellerController.SingleCharItem.createInstance(".info");
                arrayList.add(singleCharItem40);
                break;
            }
            case 19: {
                SpellerController.SingleCharItem singleCharItem = SpellerController.SingleCharItem.createInstance(".se");
                arrayList.add(singleCharItem);
                SpellerController.SingleCharItem singleCharItem41 = SpellerController.SingleCharItem.createInstance(".net");
                arrayList.add(singleCharItem41);
                SpellerController.SingleCharItem singleCharItem42 = SpellerController.SingleCharItem.createInstance(".org");
                arrayList.add(singleCharItem42);
                SpellerController.SingleCharItem singleCharItem43 = SpellerController.SingleCharItem.createInstance(".info");
                arrayList.add(singleCharItem43);
                break;
            }
            case 31: {
                SpellerController.SingleCharItem singleCharItem = SpellerController.SingleCharItem.createInstance(".si");
                arrayList.add(singleCharItem);
                SpellerController.SingleCharItem singleCharItem44 = SpellerController.SingleCharItem.createInstance(".net");
                arrayList.add(singleCharItem44);
                SpellerController.SingleCharItem singleCharItem45 = SpellerController.SingleCharItem.createInstance(".org");
                arrayList.add(singleCharItem45);
                SpellerController.SingleCharItem singleCharItem46 = SpellerController.SingleCharItem.createInstance(".info");
                arrayList.add(singleCharItem46);
                break;
            }
            case 20: {
                SpellerController.SingleCharItem singleCharItem = SpellerController.SingleCharItem.createInstance(".cz");
                arrayList.add(singleCharItem);
                SpellerController.SingleCharItem singleCharItem47 = SpellerController.SingleCharItem.createInstance(".net");
                arrayList.add(singleCharItem47);
                SpellerController.SingleCharItem singleCharItem48 = SpellerController.SingleCharItem.createInstance(".org");
                arrayList.add(singleCharItem48);
                SpellerController.SingleCharItem singleCharItem49 = SpellerController.SingleCharItem.createInstance(".info");
                arrayList.add(singleCharItem49);
                break;
            }
            case 18: {
                SpellerController.SingleCharItem singleCharItem = SpellerController.SingleCharItem.createInstance(".pl");
                arrayList.add(singleCharItem);
                SpellerController.SingleCharItem singleCharItem50 = SpellerController.SingleCharItem.createInstance(".net");
                arrayList.add(singleCharItem50);
                SpellerController.SingleCharItem singleCharItem51 = SpellerController.SingleCharItem.createInstance(".org");
                arrayList.add(singleCharItem51);
                SpellerController.SingleCharItem singleCharItem52 = SpellerController.SingleCharItem.createInstance(".info");
                arrayList.add(singleCharItem52);
                break;
            }
            case 33: {
                SpellerController.SingleCharItem singleCharItem = SpellerController.SingleCharItem.createInstance(".ro");
                arrayList.add(singleCharItem);
                SpellerController.SingleCharItem singleCharItem53 = SpellerController.SingleCharItem.createInstance(".net");
                arrayList.add(singleCharItem53);
                SpellerController.SingleCharItem singleCharItem54 = SpellerController.SingleCharItem.createInstance(".org");
                arrayList.add(singleCharItem54);
                SpellerController.SingleCharItem singleCharItem55 = SpellerController.SingleCharItem.createInstance(".info");
                arrayList.add(singleCharItem55);
                break;
            }
            case 21: {
                SpellerController.SingleCharItem singleCharItem = SpellerController.SingleCharItem.createInstance(".tr");
                arrayList.add(singleCharItem);
                SpellerController.SingleCharItem singleCharItem56 = SpellerController.SingleCharItem.createInstance(".net");
                arrayList.add(singleCharItem56);
                SpellerController.SingleCharItem singleCharItem57 = SpellerController.SingleCharItem.createInstance(".org");
                arrayList.add(singleCharItem57);
                SpellerController.SingleCharItem singleCharItem58 = SpellerController.SingleCharItem.createInstance(".info");
                arrayList.add(singleCharItem58);
                break;
            }
            case 6: {
                SpellerController.SingleCharItem singleCharItem = SpellerController.SingleCharItem.createInstance(".nl");
                arrayList.add(singleCharItem);
                SpellerController.SingleCharItem singleCharItem59 = SpellerController.SingleCharItem.createInstance(".net");
                arrayList.add(singleCharItem59);
                SpellerController.SingleCharItem singleCharItem60 = SpellerController.SingleCharItem.createInstance(".org");
                arrayList.add(singleCharItem60);
                SpellerController.SingleCharItem singleCharItem61 = SpellerController.SingleCharItem.createInstance(".info");
                arrayList.add(singleCharItem61);
                break;
            }
            default: {
                SpellerController.SingleCharItem singleCharItem = SpellerController.SingleCharItem.createInstance(".net");
                arrayList.add(singleCharItem);
                SpellerController.SingleCharItem singleCharItem62 = SpellerController.SingleCharItem.createInstance(".org");
                arrayList.add(singleCharItem62);
                SpellerController.SingleCharItem singleCharItem63 = SpellerController.SingleCharItem.createInstance(".info");
                arrayList.add(singleCharItem63);
            }
        }
        return arrayList;
    }

    private static List getlatinAZBand(int n) {
        ArrayList arrayList = new ArrayList(30);
        arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("ABCDEFGHIJKLMNOPQRSTUVWXYZ", "abcdefghijklmnopqrstuvwxyz", false));
        return arrayList;
    }

    private static List getcallistnumbersBand(int n) {
        ArrayList arrayList = new ArrayList(30);
        arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("0123456789+*#", null, true));
        return arrayList;
    }

    private static List getsonderZeichenForWlanBand(int n) {
        ArrayList arrayList = new ArrayList(30);
        arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand(" .,?!'-/_:;()&@#%*+<=>[\\]~^{|}", null, true));
        return arrayList;
    }

    public static List getFreetextBand(int n) {
        ArrayList arrayList = new ArrayList(30);
        switch (n) {
            case 26: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.getlatinExpandableAZ_arBand(n));
                arrayList.addAll(SpellerCharsetDefinitionEurope.getmainBand(n));
                SpellerController.AbstractExpandableItem.CharSet charSet = SpellerController.AbstractExpandableItem.CharSet.createInstance(SpellerCharsetDefinitionEurope.getnumbersBand(n), 1);
                arrayList.add(charSet);
                SpellerController.AbstractExpandableItem.CharSet charSet2 = SpellerController.AbstractExpandableItem.CharSet.createInstance(SpellerCharsetDefinitionEurope.getumlauts_arabicBand(n), 2);
                arrayList.add(charSet2);
                SpellerController.AbstractExpandableItem.CharSet charSet3 = SpellerController.AbstractExpandableItem.CharSet.createInstance(SpellerCharsetDefinitionEurope.getspecialBand(n), 0);
                arrayList.add(charSet3);
                break;
            }
            case 7: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.getcyrillicBand(n));
                arrayList.addAll(SpellerCharsetDefinitionEurope.getmainBand(n));
                SpellerController.ButtonItem buttonItem = SpellerController.ButtonItem.createInstance(SpellerController.SpellerButtonType.getSpellerButtonType(4));
                arrayList.add(buttonItem);
                SpellerController.AbstractExpandableItem.CharSet charSet = SpellerController.AbstractExpandableItem.CharSet.createInstance(SpellerCharsetDefinitionEurope.getnumbersBand(n), 1);
                arrayList.add(charSet);
                SpellerController.AbstractExpandableItem.CharSet charSet4 = SpellerController.AbstractExpandableItem.CharSet.createInstance(SpellerCharsetDefinitionEurope.getumlauts_cyrillicBand(n), 2);
                arrayList.add(charSet4);
                SpellerController.AbstractExpandableItem.CharSet charSet5 = SpellerController.AbstractExpandableItem.CharSet.createInstance(SpellerCharsetDefinitionEurope.getspecialBand(n), 0);
                arrayList.add(charSet5);
                break;
            }
            default: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.getlatinExpandableAZBand(n));
                arrayList.addAll(SpellerCharsetDefinitionEurope.getmainBand(n));
                SpellerController.ButtonItem buttonItem = SpellerController.ButtonItem.createInstance(SpellerController.SpellerButtonType.getSpellerButtonType(4));
                arrayList.add(buttonItem);
                SpellerController.AbstractExpandableItem.CharSet charSet = SpellerController.AbstractExpandableItem.CharSet.createInstance(SpellerCharsetDefinitionEurope.getnumbersBand(n), 1);
                arrayList.add(charSet);
                SpellerController.AbstractExpandableItem.CharSet charSet6 = SpellerController.AbstractExpandableItem.CharSet.createInstance(SpellerCharsetDefinitionEurope.getumlauts_latinBand(n), 2);
                arrayList.add(charSet6);
                SpellerController.AbstractExpandableItem.CharSet charSet7 = SpellerController.AbstractExpandableItem.CharSet.createInstance(SpellerCharsetDefinitionEurope.getspecialBand(n), 0);
                arrayList.add(charSet7);
            }
        }
        return arrayList;
    }

    public static List getMatchHousenumberBand(int n) {
        ArrayList arrayList = new ArrayList(30);
        switch (n) {
            case 26: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.getnumbersBand(n));
                SpellerController.SingleCharItem singleCharItem = SpellerController.SingleCharItem.createInstance(" ");
                arrayList.add(singleCharItem);
                arrayList.addAll(SpellerCharsetDefinitionEurope.getlatinExpandableAZ_arBand(n));
                SpellerController.AbstractExpandableItem.CharSet charSet = SpellerController.AbstractExpandableItem.CharSet.createInstance(SpellerCharsetDefinitionEurope.getumlauts_arabicBand(n), 2);
                arrayList.add(charSet);
                SpellerController.AbstractExpandableItem.CharSet charSet2 = SpellerController.AbstractExpandableItem.CharSet.createInstance(SpellerCharsetDefinitionEurope.getspecial_arBand(n), 0);
                arrayList.add(charSet2);
                break;
            }
            case 7: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.getnumbersBand(n));
                SpellerController.SingleCharItem singleCharItem = SpellerController.SingleCharItem.createInstance(" ");
                arrayList.add(singleCharItem);
                arrayList.addAll(SpellerCharsetDefinitionEurope.getcyrillicBand(n));
                SpellerController.ButtonItem buttonItem = SpellerController.ButtonItem.createInstance(SpellerController.SpellerButtonType.getSpellerButtonType(4));
                arrayList.add(buttonItem);
                SpellerController.AbstractExpandableItem.CharSet charSet = SpellerController.AbstractExpandableItem.CharSet.createInstance(SpellerCharsetDefinitionEurope.getumlauts_cyrillicBand(n), 2);
                arrayList.add(charSet);
                SpellerController.AbstractExpandableItem.CharSet charSet3 = SpellerController.AbstractExpandableItem.CharSet.createInstance(SpellerCharsetDefinitionEurope.getspecialBand(n), 0);
                arrayList.add(charSet3);
                break;
            }
            default: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.getnumbersBand(n));
                SpellerController.SingleCharItem singleCharItem = SpellerController.SingleCharItem.createInstance(" ");
                arrayList.add(singleCharItem);
                arrayList.addAll(SpellerCharsetDefinitionEurope.getlatinExpandableAZBand(n));
                SpellerController.ButtonItem buttonItem = SpellerController.ButtonItem.createInstance(SpellerController.SpellerButtonType.getSpellerButtonType(4));
                arrayList.add(buttonItem);
                SpellerController.AbstractExpandableItem.CharSet charSet = SpellerController.AbstractExpandableItem.CharSet.createInstance(SpellerCharsetDefinitionEurope.getumlauts_latinBand(n), 2);
                arrayList.add(charSet);
                SpellerController.AbstractExpandableItem.CharSet charSet4 = SpellerController.AbstractExpandableItem.CharSet.createInstance(SpellerCharsetDefinitionEurope.getspecialBand(n), 0);
                arrayList.add(charSet4);
            }
        }
        return arrayList;
    }

    public static List getMessagingBand(int n) {
        ArrayList arrayList = new ArrayList(30);
        switch (n) {
            case 26: {
                SpellerController.ButtonItem buttonItem = SpellerController.ButtonItem.createInstance(SpellerController.SpellerButtonType.getSpellerButtonType(5));
                arrayList.add(buttonItem);
                SpellerController.ButtonItem buttonItem2 = SpellerController.ButtonItem.createInstance(SpellerController.SpellerButtonType.getSpellerButtonType(6));
                arrayList.add(buttonItem2);
                arrayList.addAll(SpellerCharsetDefinitionEurope.getlatinExpandableAZ_arBand(n));
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand(" .,'\u061f!-", null, true));
                SpellerController.ButtonItem buttonItem3 = SpellerController.ButtonItem.createInstance(SpellerController.SpellerButtonType.getSpellerButtonType(29));
                arrayList.add(buttonItem3);
                arrayList.addAll(SpellerCharsetDefinitionEurope.getsmileysBand(n));
                SpellerController.AbstractExpandableItem.CharSet charSet = SpellerController.AbstractExpandableItem.CharSet.createInstance(SpellerCharsetDefinitionEurope.getnumbersBand(n), 1);
                arrayList.add(charSet);
                SpellerController.AbstractExpandableItem.CharSet charSet2 = SpellerController.AbstractExpandableItem.CharSet.createInstance(SpellerCharsetDefinitionEurope.getumlauts_arabicBand(n), 2);
                arrayList.add(charSet2);
                SpellerController.AbstractExpandableItem.CharSet charSet3 = SpellerController.AbstractExpandableItem.CharSet.createInstance(SpellerCharsetDefinitionEurope.getspecial_arBand(n), 0);
                arrayList.add(charSet3);
                break;
            }
            case 7: {
                SpellerController.ButtonItem buttonItem = SpellerController.ButtonItem.createInstance(SpellerController.SpellerButtonType.getSpellerButtonType(5));
                arrayList.add(buttonItem);
                SpellerController.ButtonItem buttonItem4 = SpellerController.ButtonItem.createInstance(SpellerController.SpellerButtonType.getSpellerButtonType(6));
                arrayList.add(buttonItem4);
                arrayList.addAll(SpellerCharsetDefinitionEurope.getcyrillicBand(n));
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand(" .,'?!-", null, true));
                SpellerController.ButtonItem buttonItem5 = SpellerController.ButtonItem.createInstance(SpellerController.SpellerButtonType.getSpellerButtonType(4));
                arrayList.add(buttonItem5);
                SpellerController.ButtonItem buttonItem6 = SpellerController.ButtonItem.createInstance(SpellerController.SpellerButtonType.getSpellerButtonType(29));
                arrayList.add(buttonItem6);
                arrayList.addAll(SpellerCharsetDefinitionEurope.getsmileysBand(n));
                SpellerController.AbstractExpandableItem.CharSet charSet = SpellerController.AbstractExpandableItem.CharSet.createInstance(SpellerCharsetDefinitionEurope.getnumbersBand(n), 1);
                arrayList.add(charSet);
                SpellerController.AbstractExpandableItem.CharSet charSet4 = SpellerController.AbstractExpandableItem.CharSet.createInstance(SpellerCharsetDefinitionEurope.getumlauts_cyrillicBand(n), 2);
                arrayList.add(charSet4);
                SpellerController.AbstractExpandableItem.CharSet charSet5 = SpellerController.AbstractExpandableItem.CharSet.createInstance(SpellerCharsetDefinitionEurope.getspecialBand(n), 0);
                arrayList.add(charSet5);
                break;
            }
            default: {
                SpellerController.ButtonItem buttonItem = SpellerController.ButtonItem.createInstance(SpellerController.SpellerButtonType.getSpellerButtonType(5));
                arrayList.add(buttonItem);
                SpellerController.ButtonItem buttonItem7 = SpellerController.ButtonItem.createInstance(SpellerController.SpellerButtonType.getSpellerButtonType(6));
                arrayList.add(buttonItem7);
                arrayList.addAll(SpellerCharsetDefinitionEurope.getlatinExpandableAZBand(n));
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand(" .,'?!-", null, true));
                SpellerController.ButtonItem buttonItem8 = SpellerController.ButtonItem.createInstance(SpellerController.SpellerButtonType.getSpellerButtonType(4));
                arrayList.add(buttonItem8);
                SpellerController.ButtonItem buttonItem9 = SpellerController.ButtonItem.createInstance(SpellerController.SpellerButtonType.getSpellerButtonType(29));
                arrayList.add(buttonItem9);
                arrayList.addAll(SpellerCharsetDefinitionEurope.getsmileysBand(n));
                SpellerController.AbstractExpandableItem.CharSet charSet = SpellerController.AbstractExpandableItem.CharSet.createInstance(SpellerCharsetDefinitionEurope.getnumbersBand(n), 1);
                arrayList.add(charSet);
                SpellerController.AbstractExpandableItem.CharSet charSet6 = SpellerController.AbstractExpandableItem.CharSet.createInstance(SpellerCharsetDefinitionEurope.getumlauts_latinBand(n), 2);
                arrayList.add(charSet6);
                SpellerController.AbstractExpandableItem.CharSet charSet7 = SpellerController.AbstractExpandableItem.CharSet.createInstance(SpellerCharsetDefinitionEurope.getspecialBand(n), 0);
                arrayList.add(charSet7);
            }
        }
        return arrayList;
    }

    public static List getAdressingBand(int n) {
        ArrayList arrayList = new ArrayList(30);
        switch (n) {
            case 26: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.getlatinExpandableAZ_arBand(n));
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand(".@", null, true));
                SpellerController.AbstractExpandableItem.Char char_ = SpellerController.AbstractExpandableItem.Char.createInstance(SpellerCharsetDefinitionEurope.getdomainBand(n), ".com");
                arrayList.add(char_);
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("-\u061f!", null, true));
                SpellerController.AbstractExpandableItem.CharSet charSet = SpellerController.AbstractExpandableItem.CharSet.createInstance(SpellerCharsetDefinitionEurope.getnumbersBand(n), 1);
                arrayList.add(charSet);
                SpellerController.AbstractExpandableItem.CharSet charSet2 = SpellerController.AbstractExpandableItem.CharSet.createInstance(SpellerCharsetDefinitionEurope.getumlauts_arabicBand(n), 2);
                arrayList.add(charSet2);
                SpellerController.AbstractExpandableItem.CharSet charSet3 = SpellerController.AbstractExpandableItem.CharSet.createInstance(SpellerCharsetDefinitionEurope.getspecial_arBand(n), 0);
                arrayList.add(charSet3);
                break;
            }
            case 7: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.getcyrillicBand(n));
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand(".@", null, true));
                SpellerController.AbstractExpandableItem.Char char_ = SpellerController.AbstractExpandableItem.Char.createInstance(SpellerCharsetDefinitionEurope.getdomainBand(n), ".com");
                arrayList.add(char_);
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("-?!", null, true));
                SpellerController.ButtonItem buttonItem = SpellerController.ButtonItem.createInstance(SpellerController.SpellerButtonType.getSpellerButtonType(4));
                arrayList.add(buttonItem);
                SpellerController.AbstractExpandableItem.CharSet charSet = SpellerController.AbstractExpandableItem.CharSet.createInstance(SpellerCharsetDefinitionEurope.getnumbersBand(n), 1);
                arrayList.add(charSet);
                SpellerController.AbstractExpandableItem.CharSet charSet4 = SpellerController.AbstractExpandableItem.CharSet.createInstance(SpellerCharsetDefinitionEurope.getumlauts_cyrillicBand(n), 2);
                arrayList.add(charSet4);
                SpellerController.AbstractExpandableItem.CharSet charSet5 = SpellerController.AbstractExpandableItem.CharSet.createInstance(SpellerCharsetDefinitionEurope.getspecialBand(n), 0);
                arrayList.add(charSet5);
                break;
            }
            default: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.getlatinExpandableAZBand(n));
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand(".@", null, true));
                SpellerController.AbstractExpandableItem.Char char_ = SpellerController.AbstractExpandableItem.Char.createInstance(SpellerCharsetDefinitionEurope.getdomainBand(n), ".com");
                arrayList.add(char_);
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("-?!", null, true));
                SpellerController.ButtonItem buttonItem = SpellerController.ButtonItem.createInstance(SpellerController.SpellerButtonType.getSpellerButtonType(4));
                arrayList.add(buttonItem);
                SpellerController.AbstractExpandableItem.CharSet charSet = SpellerController.AbstractExpandableItem.CharSet.createInstance(SpellerCharsetDefinitionEurope.getnumbersBand(n), 1);
                arrayList.add(charSet);
                SpellerController.AbstractExpandableItem.CharSet charSet6 = SpellerController.AbstractExpandableItem.CharSet.createInstance(SpellerCharsetDefinitionEurope.getumlauts_latinBand(n), 2);
                arrayList.add(charSet6);
                SpellerController.AbstractExpandableItem.CharSet charSet7 = SpellerController.AbstractExpandableItem.CharSet.createInstance(SpellerCharsetDefinitionEurope.getspecialBand(n), 0);
                arrayList.add(charSet7);
            }
        }
        return arrayList;
    }

    public static List getPhoneBand(int n) {
        ArrayList arrayList = new ArrayList(30);
        switch (n) {
            case 26: {
                SpellerController.ButtonItem buttonItem = SpellerController.ButtonItem.createInstance(SpellerController.SpellerButtonType.getSpellerButtonType(6));
                arrayList.add(buttonItem);
                SpellerController.ButtonItem buttonItem2 = SpellerController.ButtonItem.createInstance(SpellerController.SpellerButtonType.getSpellerButtonType(5));
                arrayList.add(buttonItem2);
                SpellerController.SingleCharItem singleCharItem = SpellerController.SingleCharItem.createInstance("+");
                arrayList.add(singleCharItem);
                arrayList.addAll(SpellerCharsetDefinitionEurope.getnumbersBand(n));
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("*#", null, true));
                SpellerController.AbstractExpandableItem.CharSet charSet = SpellerController.AbstractExpandableItem.CharSet.createInstance(SpellerCharsetDefinitionEurope.getlatinAZBand(n), 3);
                arrayList.add(charSet);
                break;
            }
            default: {
                SpellerController.ButtonItem buttonItem = SpellerController.ButtonItem.createInstance(SpellerController.SpellerButtonType.getSpellerButtonType(5));
                arrayList.add(buttonItem);
                SpellerController.ButtonItem buttonItem3 = SpellerController.ButtonItem.createInstance(SpellerController.SpellerButtonType.getSpellerButtonType(6));
                arrayList.add(buttonItem3);
                SpellerController.SingleCharItem singleCharItem = SpellerController.SingleCharItem.createInstance("+");
                arrayList.add(singleCharItem);
                arrayList.addAll(SpellerCharsetDefinitionEurope.getnumbersBand(n));
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("*#", null, true));
                SpellerController.AbstractExpandableItem.CharSet charSet = SpellerController.AbstractExpandableItem.CharSet.createInstance(SpellerCharsetDefinitionEurope.getlatinAZBand(n), 3);
                arrayList.add(charSet);
            }
        }
        return arrayList;
    }

    public static List getCallListPhoneBand(int n) {
        ArrayList arrayList = new ArrayList(30);
        switch (n) {
            case 26: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.getlatinExpandableAZ_arBand(n));
                arrayList.addAll(SpellerCharsetDefinitionEurope.getmainBand(n));
                SpellerController.AbstractExpandableItem.CharSet charSet = SpellerController.AbstractExpandableItem.CharSet.createInstance(SpellerCharsetDefinitionEurope.getcallistnumbersBand(n), 1);
                arrayList.add(charSet);
                SpellerController.AbstractExpandableItem.CharSet charSet2 = SpellerController.AbstractExpandableItem.CharSet.createInstance(SpellerCharsetDefinitionEurope.getumlauts_arabicBand(n), 2);
                arrayList.add(charSet2);
                SpellerController.AbstractExpandableItem.CharSet charSet3 = SpellerController.AbstractExpandableItem.CharSet.createInstance(SpellerCharsetDefinitionEurope.getspecialBand(n), 0);
                arrayList.add(charSet3);
                break;
            }
            case 7: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.getcyrillicBand(n));
                arrayList.addAll(SpellerCharsetDefinitionEurope.getmainBand(n));
                SpellerController.AbstractExpandableItem.CharSet charSet = SpellerController.AbstractExpandableItem.CharSet.createInstance(SpellerCharsetDefinitionEurope.getcallistnumbersBand(n), 1);
                arrayList.add(charSet);
                SpellerController.AbstractExpandableItem.CharSet charSet4 = SpellerController.AbstractExpandableItem.CharSet.createInstance(SpellerCharsetDefinitionEurope.getumlauts_cyrillicBand(n), 2);
                arrayList.add(charSet4);
                SpellerController.AbstractExpandableItem.CharSet charSet5 = SpellerController.AbstractExpandableItem.CharSet.createInstance(SpellerCharsetDefinitionEurope.getspecialBand(n), 0);
                arrayList.add(charSet5);
                break;
            }
            default: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.getlatinExpandableAZBand(n));
                arrayList.addAll(SpellerCharsetDefinitionEurope.getmainBand(n));
                SpellerController.AbstractExpandableItem.CharSet charSet = SpellerController.AbstractExpandableItem.CharSet.createInstance(SpellerCharsetDefinitionEurope.getcallistnumbersBand(n), 1);
                arrayList.add(charSet);
                SpellerController.AbstractExpandableItem.CharSet charSet6 = SpellerController.AbstractExpandableItem.CharSet.createInstance(SpellerCharsetDefinitionEurope.getumlauts_latinBand(n), 2);
                arrayList.add(charSet6);
                SpellerController.AbstractExpandableItem.CharSet charSet7 = SpellerController.AbstractExpandableItem.CharSet.createInstance(SpellerCharsetDefinitionEurope.getspecialBand(n), 0);
                arrayList.add(charSet7);
            }
        }
        return arrayList;
    }

    public static List getPinBand(int n) {
        ArrayList arrayList = new ArrayList(30);
        arrayList.addAll(SpellerCharsetDefinitionEurope.getnumbersBand(n));
        return arrayList;
    }

    public static List getDtmfBand(int n) {
        ArrayList arrayList = new ArrayList(30);
        arrayList.addAll(SpellerCharsetDefinitionEurope.getnumbersBand(n));
        arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("*#", null, true));
        return arrayList;
    }

    public static List getWlanBand(int n) {
        ArrayList arrayList = new ArrayList(30);
        arrayList.addAll(SpellerCharsetDefinitionEurope.getlatinAZBand(n));
        arrayList.addAll(SpellerCharsetDefinitionEurope.getnumbersBand(n));
        SpellerController.ButtonItem buttonItem = SpellerController.ButtonItem.createInstance(SpellerController.SpellerButtonType.getSpellerButtonType(4));
        arrayList.add(buttonItem);
        SpellerController.AbstractExpandableItem.CharSet charSet = SpellerController.AbstractExpandableItem.CharSet.createInstance(SpellerCharsetDefinitionEurope.getsonderZeichenForWlanBand(n), 0);
        arrayList.add(charSet);
        return arrayList;
    }

    public static List getTunertvBand(int n) {
        ArrayList arrayList = new ArrayList(30);
        switch (n) {
            case 26: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.getlatinExpandableAZ_arBand(n));
                arrayList.addAll(SpellerCharsetDefinitionEurope.getnumbersBand(n));
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand(".,", null, true));
                SpellerController.AbstractExpandableItem.CharSet charSet = SpellerController.AbstractExpandableItem.CharSet.createInstance(SpellerCharsetDefinitionEurope.getumlauts_arabicBand(n), 2);
                arrayList.add(charSet);
                SpellerController.AbstractExpandableItem.CharSet charSet2 = SpellerController.AbstractExpandableItem.CharSet.createInstance(SpellerCharsetDefinitionEurope.getspecial_arBand(n), 0);
                arrayList.add(charSet2);
                break;
            }
            case 7: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.getcyrillicBand(n));
                arrayList.addAll(SpellerCharsetDefinitionEurope.getnumbersBand(n));
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand(".,", null, true));
                SpellerController.ButtonItem buttonItem = SpellerController.ButtonItem.createInstance(SpellerController.SpellerButtonType.getSpellerButtonType(4));
                arrayList.add(buttonItem);
                SpellerController.AbstractExpandableItem.CharSet charSet = SpellerController.AbstractExpandableItem.CharSet.createInstance(SpellerCharsetDefinitionEurope.getumlauts_cyrillicBand(n), 2);
                arrayList.add(charSet);
                SpellerController.AbstractExpandableItem.CharSet charSet3 = SpellerController.AbstractExpandableItem.CharSet.createInstance(SpellerCharsetDefinitionEurope.getspecialBand(n), 0);
                arrayList.add(charSet3);
                break;
            }
            default: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.getlatinExpandableAZBand(n));
                arrayList.addAll(SpellerCharsetDefinitionEurope.getnumbersBand(n));
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand(".,", null, true));
                SpellerController.ButtonItem buttonItem = SpellerController.ButtonItem.createInstance(SpellerController.SpellerButtonType.getSpellerButtonType(4));
                arrayList.add(buttonItem);
                SpellerController.AbstractExpandableItem.CharSet charSet = SpellerController.AbstractExpandableItem.CharSet.createInstance(SpellerCharsetDefinitionEurope.getumlauts_latinBand(n), 2);
                arrayList.add(charSet);
                SpellerController.AbstractExpandableItem.CharSet charSet4 = SpellerController.AbstractExpandableItem.CharSet.createInstance(SpellerCharsetDefinitionEurope.getspecialBand(n), 0);
                arrayList.add(charSet4);
            }
        }
        return arrayList;
    }

    public static List getVehicleCodeBand(int n) {
        ArrayList arrayList = new ArrayList(30);
        arrayList.addAll(SpellerCharsetDefinitionEurope.getlatinAZBand(n));
        SpellerController.AbstractExpandableItem.CharSet charSet = SpellerController.AbstractExpandableItem.CharSet.createInstance(SpellerCharsetDefinitionEurope.getnumbersBand(n), 1);
        arrayList.add(charSet);
        return arrayList;
    }
}

