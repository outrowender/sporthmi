/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerCharsetDefinition;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$AbstractExpandableItem$Char;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$AbstractExpandableItem$CharSet;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$ButtonItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$SingleCharItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$SpellerButtonType;
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
        SpellerController$AbstractExpandableItem$Char spellerController$AbstractExpandableItem$Char = SpellerController$AbstractExpandableItem$Char.createInstance(SpellerCharsetDefinitionEurope.getumlaut_a_arBand(n), "\u0627");
        arrayList.add(spellerController$AbstractExpandableItem$Char);
        SpellerController$SingleCharItem spellerController$SingleCharItem = SpellerController$SingleCharItem.createInstance("\u0628");
        arrayList.add(spellerController$SingleCharItem);
        SpellerController$SingleCharItem spellerController$SingleCharItem2 = SpellerController$SingleCharItem.createInstance("\u062a");
        arrayList.add(spellerController$SingleCharItem2);
        SpellerController$SingleCharItem spellerController$SingleCharItem3 = SpellerController$SingleCharItem.createInstance("\u062b");
        arrayList.add(spellerController$SingleCharItem3);
        SpellerController$SingleCharItem spellerController$SingleCharItem4 = SpellerController$SingleCharItem.createInstance("\u062c");
        arrayList.add(spellerController$SingleCharItem4);
        SpellerController$SingleCharItem spellerController$SingleCharItem5 = SpellerController$SingleCharItem.createInstance("\u062d");
        arrayList.add(spellerController$SingleCharItem5);
        SpellerController$SingleCharItem spellerController$SingleCharItem6 = SpellerController$SingleCharItem.createInstance("\u062e");
        arrayList.add(spellerController$SingleCharItem6);
        SpellerController$SingleCharItem spellerController$SingleCharItem7 = SpellerController$SingleCharItem.createInstance("\u062f");
        arrayList.add(spellerController$SingleCharItem7);
        SpellerController$SingleCharItem spellerController$SingleCharItem8 = SpellerController$SingleCharItem.createInstance("\u0630");
        arrayList.add(spellerController$SingleCharItem8);
        SpellerController$SingleCharItem spellerController$SingleCharItem9 = SpellerController$SingleCharItem.createInstance("\u0631");
        arrayList.add(spellerController$SingleCharItem9);
        SpellerController$SingleCharItem spellerController$SingleCharItem10 = SpellerController$SingleCharItem.createInstance("\u0632");
        arrayList.add(spellerController$SingleCharItem10);
        SpellerController$SingleCharItem spellerController$SingleCharItem11 = SpellerController$SingleCharItem.createInstance("\u0633");
        arrayList.add(spellerController$SingleCharItem11);
        SpellerController$SingleCharItem spellerController$SingleCharItem12 = SpellerController$SingleCharItem.createInstance("\u0634");
        arrayList.add(spellerController$SingleCharItem12);
        SpellerController$SingleCharItem spellerController$SingleCharItem13 = SpellerController$SingleCharItem.createInstance("\u0635");
        arrayList.add(spellerController$SingleCharItem13);
        SpellerController$SingleCharItem spellerController$SingleCharItem14 = SpellerController$SingleCharItem.createInstance("\u0636");
        arrayList.add(spellerController$SingleCharItem14);
        SpellerController$SingleCharItem spellerController$SingleCharItem15 = SpellerController$SingleCharItem.createInstance("\u0637");
        arrayList.add(spellerController$SingleCharItem15);
        SpellerController$SingleCharItem spellerController$SingleCharItem16 = SpellerController$SingleCharItem.createInstance("\u0638");
        arrayList.add(spellerController$SingleCharItem16);
        SpellerController$SingleCharItem spellerController$SingleCharItem17 = SpellerController$SingleCharItem.createInstance("\u0639");
        arrayList.add(spellerController$SingleCharItem17);
        SpellerController$SingleCharItem spellerController$SingleCharItem18 = SpellerController$SingleCharItem.createInstance("\u063a");
        arrayList.add(spellerController$SingleCharItem18);
        SpellerController$SingleCharItem spellerController$SingleCharItem19 = SpellerController$SingleCharItem.createInstance("\u0641");
        arrayList.add(spellerController$SingleCharItem19);
        SpellerController$SingleCharItem spellerController$SingleCharItem20 = SpellerController$SingleCharItem.createInstance("\u0642");
        arrayList.add(spellerController$SingleCharItem20);
        SpellerController$SingleCharItem spellerController$SingleCharItem21 = SpellerController$SingleCharItem.createInstance("\u0643");
        arrayList.add(spellerController$SingleCharItem21);
        SpellerController$SingleCharItem spellerController$SingleCharItem22 = SpellerController$SingleCharItem.createInstance("\u0644");
        arrayList.add(spellerController$SingleCharItem22);
        SpellerController$SingleCharItem spellerController$SingleCharItem23 = SpellerController$SingleCharItem.createInstance("\u0645");
        arrayList.add(spellerController$SingleCharItem23);
        SpellerController$SingleCharItem spellerController$SingleCharItem24 = SpellerController$SingleCharItem.createInstance("\u0646");
        arrayList.add(spellerController$SingleCharItem24);
        SpellerController$SingleCharItem spellerController$SingleCharItem25 = SpellerController$SingleCharItem.createInstance("\u0647");
        arrayList.add(spellerController$SingleCharItem25);
        SpellerController$AbstractExpandableItem$Char spellerController$AbstractExpandableItem$Char2 = SpellerController$AbstractExpandableItem$Char.createInstance(SpellerCharsetDefinitionEurope.getumlaut_w_arBand(n), "\u0648");
        arrayList.add(spellerController$AbstractExpandableItem$Char2);
        SpellerController$SingleCharItem spellerController$SingleCharItem26 = SpellerController$SingleCharItem.createInstance("\u064a");
        arrayList.add(spellerController$SingleCharItem26);
        SpellerController$SingleCharItem spellerController$SingleCharItem27 = SpellerController$SingleCharItem.createInstance("\u0629");
        arrayList.add(spellerController$SingleCharItem27);
        SpellerController$AbstractExpandableItem$Char spellerController$AbstractExpandableItem$Char3 = SpellerController$AbstractExpandableItem$Char.createInstance(SpellerCharsetDefinitionEurope.getumlaut_m_arBand(n), "\u0649");
        arrayList.add(spellerController$AbstractExpandableItem$Char3);
        SpellerController$AbstractExpandableItem$Char spellerController$AbstractExpandableItem$Char4 = SpellerController$AbstractExpandableItem$Char.createInstance(SpellerCharsetDefinitionEurope.getumlaut_l_arBand(n), "\ufefb");
        arrayList.add(spellerController$AbstractExpandableItem$Char4);
        SpellerController$AbstractExpandableItem$Char spellerController$AbstractExpandableItem$Char5 = SpellerController$AbstractExpandableItem$Char.createInstance(SpellerCharsetDefinitionEurope.getumlaut_h_arBand(n), "\u0621");
        arrayList.add(spellerController$AbstractExpandableItem$Char5);
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
                SpellerController$AbstractExpandableItem$Char spellerController$AbstractExpandableItem$Char = SpellerController$AbstractExpandableItem$Char.createInstance(SpellerCharsetDefinitionEurope.getumlaut_a_arBand(n), "\u0627");
                arrayList.add(spellerController$AbstractExpandableItem$Char);
                SpellerController$SingleCharItem spellerController$SingleCharItem = SpellerController$SingleCharItem.createInstance("\u0628");
                arrayList.add(spellerController$SingleCharItem);
                SpellerController$SingleCharItem spellerController$SingleCharItem2 = SpellerController$SingleCharItem.createInstance("\u062a");
                arrayList.add(spellerController$SingleCharItem2);
                SpellerController$SingleCharItem spellerController$SingleCharItem3 = SpellerController$SingleCharItem.createInstance("\u062b");
                arrayList.add(spellerController$SingleCharItem3);
                SpellerController$SingleCharItem spellerController$SingleCharItem4 = SpellerController$SingleCharItem.createInstance("\u062c");
                arrayList.add(spellerController$SingleCharItem4);
                SpellerController$SingleCharItem spellerController$SingleCharItem5 = SpellerController$SingleCharItem.createInstance("\u062d");
                arrayList.add(spellerController$SingleCharItem5);
                SpellerController$SingleCharItem spellerController$SingleCharItem6 = SpellerController$SingleCharItem.createInstance("\u062e");
                arrayList.add(spellerController$SingleCharItem6);
                SpellerController$SingleCharItem spellerController$SingleCharItem7 = SpellerController$SingleCharItem.createInstance("\u062f");
                arrayList.add(spellerController$SingleCharItem7);
                SpellerController$SingleCharItem spellerController$SingleCharItem8 = SpellerController$SingleCharItem.createInstance("\u0630");
                arrayList.add(spellerController$SingleCharItem8);
                SpellerController$SingleCharItem spellerController$SingleCharItem9 = SpellerController$SingleCharItem.createInstance("\u0631");
                arrayList.add(spellerController$SingleCharItem9);
                SpellerController$SingleCharItem spellerController$SingleCharItem10 = SpellerController$SingleCharItem.createInstance("\u0632");
                arrayList.add(spellerController$SingleCharItem10);
                SpellerController$SingleCharItem spellerController$SingleCharItem11 = SpellerController$SingleCharItem.createInstance("\u0633");
                arrayList.add(spellerController$SingleCharItem11);
                SpellerController$SingleCharItem spellerController$SingleCharItem12 = SpellerController$SingleCharItem.createInstance("\u0634");
                arrayList.add(spellerController$SingleCharItem12);
                SpellerController$SingleCharItem spellerController$SingleCharItem13 = SpellerController$SingleCharItem.createInstance("\u0635");
                arrayList.add(spellerController$SingleCharItem13);
                SpellerController$SingleCharItem spellerController$SingleCharItem14 = SpellerController$SingleCharItem.createInstance("\u0636");
                arrayList.add(spellerController$SingleCharItem14);
                SpellerController$SingleCharItem spellerController$SingleCharItem15 = SpellerController$SingleCharItem.createInstance("\u0637");
                arrayList.add(spellerController$SingleCharItem15);
                SpellerController$SingleCharItem spellerController$SingleCharItem16 = SpellerController$SingleCharItem.createInstance("\u0638");
                arrayList.add(spellerController$SingleCharItem16);
                SpellerController$SingleCharItem spellerController$SingleCharItem17 = SpellerController$SingleCharItem.createInstance("\u0639");
                arrayList.add(spellerController$SingleCharItem17);
                SpellerController$SingleCharItem spellerController$SingleCharItem18 = SpellerController$SingleCharItem.createInstance("\u063a");
                arrayList.add(spellerController$SingleCharItem18);
                SpellerController$SingleCharItem spellerController$SingleCharItem19 = SpellerController$SingleCharItem.createInstance("\u0641");
                arrayList.add(spellerController$SingleCharItem19);
                SpellerController$SingleCharItem spellerController$SingleCharItem20 = SpellerController$SingleCharItem.createInstance("\u0642");
                arrayList.add(spellerController$SingleCharItem20);
                SpellerController$SingleCharItem spellerController$SingleCharItem21 = SpellerController$SingleCharItem.createInstance("\u0643");
                arrayList.add(spellerController$SingleCharItem21);
                SpellerController$SingleCharItem spellerController$SingleCharItem22 = SpellerController$SingleCharItem.createInstance("\u0644");
                arrayList.add(spellerController$SingleCharItem22);
                SpellerController$SingleCharItem spellerController$SingleCharItem23 = SpellerController$SingleCharItem.createInstance("\u0645");
                arrayList.add(spellerController$SingleCharItem23);
                SpellerController$SingleCharItem spellerController$SingleCharItem24 = SpellerController$SingleCharItem.createInstance("\u0646");
                arrayList.add(spellerController$SingleCharItem24);
                SpellerController$SingleCharItem spellerController$SingleCharItem25 = SpellerController$SingleCharItem.createInstance("\u0647");
                arrayList.add(spellerController$SingleCharItem25);
                SpellerController$AbstractExpandableItem$Char spellerController$AbstractExpandableItem$Char2 = SpellerController$AbstractExpandableItem$Char.createInstance(SpellerCharsetDefinitionEurope.getumlaut_w_arBand(n), "\u0648");
                arrayList.add(spellerController$AbstractExpandableItem$Char2);
                SpellerController$SingleCharItem spellerController$SingleCharItem26 = SpellerController$SingleCharItem.createInstance("\u064a");
                arrayList.add(spellerController$SingleCharItem26);
                SpellerController$SingleCharItem spellerController$SingleCharItem27 = SpellerController$SingleCharItem.createInstance("\u0629");
                arrayList.add(spellerController$SingleCharItem27);
                SpellerController$AbstractExpandableItem$Char spellerController$AbstractExpandableItem$Char3 = SpellerController$AbstractExpandableItem$Char.createInstance(SpellerCharsetDefinitionEurope.getumlaut_m_arBand(n), "\u0649");
                arrayList.add(spellerController$AbstractExpandableItem$Char3);
                SpellerController$AbstractExpandableItem$Char spellerController$AbstractExpandableItem$Char4 = SpellerController$AbstractExpandableItem$Char.createInstance(SpellerCharsetDefinitionEurope.getumlaut_l_arBand(n), "\ufefb");
                arrayList.add(spellerController$AbstractExpandableItem$Char4);
                SpellerController$AbstractExpandableItem$Char spellerController$AbstractExpandableItem$Char5 = SpellerController$AbstractExpandableItem$Char.createInstance(SpellerCharsetDefinitionEurope.getumlaut_h_arBand(n), "\u0621");
                arrayList.add(spellerController$AbstractExpandableItem$Char5);
                break;
            }
            case 3: {
                SpellerController$AbstractExpandableItem$Char spellerController$AbstractExpandableItem$Char = SpellerController$AbstractExpandableItem$Char.createInstance(SpellerCharsetDefinitionEurope.getumlaut_aBand(n), "A", "a");
                arrayList.add(spellerController$AbstractExpandableItem$Char);
                SpellerController$SingleCharItem spellerController$SingleCharItem = SpellerController$SingleCharItem.createInstance("B", "b");
                arrayList.add(spellerController$SingleCharItem);
                SpellerController$AbstractExpandableItem$Char spellerController$AbstractExpandableItem$Char6 = SpellerController$AbstractExpandableItem$Char.createInstance(SpellerCharsetDefinitionEurope.getumlaut_cBand(n), "C", "c");
                arrayList.add(spellerController$AbstractExpandableItem$Char6);
                SpellerController$AbstractExpandableItem$Char spellerController$AbstractExpandableItem$Char7 = SpellerController$AbstractExpandableItem$Char.createInstance(SpellerCharsetDefinitionEurope.getumlaut_dBand(n), "D", "d");
                arrayList.add(spellerController$AbstractExpandableItem$Char7);
                SpellerController$AbstractExpandableItem$Char spellerController$AbstractExpandableItem$Char8 = SpellerController$AbstractExpandableItem$Char.createInstance(SpellerCharsetDefinitionEurope.getumlaut_eBand(n), "E", "e");
                arrayList.add(spellerController$AbstractExpandableItem$Char8);
                SpellerController$SingleCharItem spellerController$SingleCharItem28 = SpellerController$SingleCharItem.createInstance("F", "f");
                arrayList.add(spellerController$SingleCharItem28);
                SpellerController$AbstractExpandableItem$Char spellerController$AbstractExpandableItem$Char9 = SpellerController$AbstractExpandableItem$Char.createInstance(SpellerCharsetDefinitionEurope.getumlaut_gBand(n), "G", "g");
                arrayList.add(spellerController$AbstractExpandableItem$Char9);
                SpellerController$AbstractExpandableItem$Char spellerController$AbstractExpandableItem$Char10 = SpellerController$AbstractExpandableItem$Char.createInstance(SpellerCharsetDefinitionEurope.getumlaut_hBand(n), "H", "h");
                arrayList.add(spellerController$AbstractExpandableItem$Char10);
                SpellerController$AbstractExpandableItem$Char spellerController$AbstractExpandableItem$Char11 = SpellerController$AbstractExpandableItem$Char.createInstance(SpellerCharsetDefinitionEurope.getumlaut_iBand(n), "I", "i");
                arrayList.add(spellerController$AbstractExpandableItem$Char11);
                SpellerController$SingleCharItem spellerController$SingleCharItem29 = SpellerController$SingleCharItem.createInstance("J", "j");
                arrayList.add(spellerController$SingleCharItem29);
                SpellerController$AbstractExpandableItem$Char spellerController$AbstractExpandableItem$Char12 = SpellerController$AbstractExpandableItem$Char.createInstance(SpellerCharsetDefinitionEurope.getumlaut_kBand(n), "K", "k");
                arrayList.add(spellerController$AbstractExpandableItem$Char12);
                SpellerController$AbstractExpandableItem$Char spellerController$AbstractExpandableItem$Char13 = SpellerController$AbstractExpandableItem$Char.createInstance(SpellerCharsetDefinitionEurope.getumlaut_lBand(n), "L", "l");
                arrayList.add(spellerController$AbstractExpandableItem$Char13);
                SpellerController$SingleCharItem spellerController$SingleCharItem30 = SpellerController$SingleCharItem.createInstance("M", "m");
                arrayList.add(spellerController$SingleCharItem30);
                SpellerController$AbstractExpandableItem$Char spellerController$AbstractExpandableItem$Char14 = SpellerController$AbstractExpandableItem$Char.createInstance(SpellerCharsetDefinitionEurope.getumlaut_nBand(n), "N", "n");
                arrayList.add(spellerController$AbstractExpandableItem$Char14);
                SpellerController$SingleCharItem spellerController$SingleCharItem31 = SpellerController$SingleCharItem.createInstance("\u00d1", "\u00f1");
                arrayList.add(spellerController$SingleCharItem31);
                SpellerController$AbstractExpandableItem$Char spellerController$AbstractExpandableItem$Char15 = SpellerController$AbstractExpandableItem$Char.createInstance(SpellerCharsetDefinitionEurope.getumlaut_oBand(n), "O", "o");
                arrayList.add(spellerController$AbstractExpandableItem$Char15);
                SpellerController$SingleCharItem spellerController$SingleCharItem32 = SpellerController$SingleCharItem.createInstance("P", "p");
                arrayList.add(spellerController$SingleCharItem32);
                SpellerController$SingleCharItem spellerController$SingleCharItem33 = SpellerController$SingleCharItem.createInstance("Q", "q");
                arrayList.add(spellerController$SingleCharItem33);
                SpellerController$AbstractExpandableItem$Char spellerController$AbstractExpandableItem$Char16 = SpellerController$AbstractExpandableItem$Char.createInstance(SpellerCharsetDefinitionEurope.getumlaut_rBand(n), "R", "r");
                arrayList.add(spellerController$AbstractExpandableItem$Char16);
                SpellerController$AbstractExpandableItem$Char spellerController$AbstractExpandableItem$Char17 = SpellerController$AbstractExpandableItem$Char.createInstance(SpellerCharsetDefinitionEurope.getumlaut_sBand(n), "S", "s");
                arrayList.add(spellerController$AbstractExpandableItem$Char17);
                SpellerController$AbstractExpandableItem$Char spellerController$AbstractExpandableItem$Char18 = SpellerController$AbstractExpandableItem$Char.createInstance(SpellerCharsetDefinitionEurope.getumlaut_tBand(n), "T", "t");
                arrayList.add(spellerController$AbstractExpandableItem$Char18);
                SpellerController$AbstractExpandableItem$Char spellerController$AbstractExpandableItem$Char19 = SpellerController$AbstractExpandableItem$Char.createInstance(SpellerCharsetDefinitionEurope.getumlaut_uBand(n), "U", "u");
                arrayList.add(spellerController$AbstractExpandableItem$Char19);
                SpellerController$SingleCharItem spellerController$SingleCharItem34 = SpellerController$SingleCharItem.createInstance("V", "v");
                arrayList.add(spellerController$SingleCharItem34);
                SpellerController$SingleCharItem spellerController$SingleCharItem35 = SpellerController$SingleCharItem.createInstance("W", "w");
                arrayList.add(spellerController$SingleCharItem35);
                SpellerController$SingleCharItem spellerController$SingleCharItem36 = SpellerController$SingleCharItem.createInstance("X", "x");
                arrayList.add(spellerController$SingleCharItem36);
                SpellerController$AbstractExpandableItem$Char spellerController$AbstractExpandableItem$Char20 = SpellerController$AbstractExpandableItem$Char.createInstance(SpellerCharsetDefinitionEurope.getumlaut_yBand(n), "Y", "y");
                arrayList.add(spellerController$AbstractExpandableItem$Char20);
                SpellerController$AbstractExpandableItem$Char spellerController$AbstractExpandableItem$Char21 = SpellerController$AbstractExpandableItem$Char.createInstance(SpellerCharsetDefinitionEurope.getumlaut_zBand(n), "Z", "z");
                arrayList.add(spellerController$AbstractExpandableItem$Char21);
                break;
            }
            default: {
                SpellerController$AbstractExpandableItem$Char spellerController$AbstractExpandableItem$Char = SpellerController$AbstractExpandableItem$Char.createInstance(SpellerCharsetDefinitionEurope.getumlaut_aBand(n), "A", "a");
                arrayList.add(spellerController$AbstractExpandableItem$Char);
                SpellerController$SingleCharItem spellerController$SingleCharItem = SpellerController$SingleCharItem.createInstance("B", "b");
                arrayList.add(spellerController$SingleCharItem);
                SpellerController$AbstractExpandableItem$Char spellerController$AbstractExpandableItem$Char22 = SpellerController$AbstractExpandableItem$Char.createInstance(SpellerCharsetDefinitionEurope.getumlaut_cBand(n), "C", "c");
                arrayList.add(spellerController$AbstractExpandableItem$Char22);
                SpellerController$AbstractExpandableItem$Char spellerController$AbstractExpandableItem$Char23 = SpellerController$AbstractExpandableItem$Char.createInstance(SpellerCharsetDefinitionEurope.getumlaut_dBand(n), "D", "d");
                arrayList.add(spellerController$AbstractExpandableItem$Char23);
                SpellerController$AbstractExpandableItem$Char spellerController$AbstractExpandableItem$Char24 = SpellerController$AbstractExpandableItem$Char.createInstance(SpellerCharsetDefinitionEurope.getumlaut_eBand(n), "E", "e");
                arrayList.add(spellerController$AbstractExpandableItem$Char24);
                SpellerController$SingleCharItem spellerController$SingleCharItem37 = SpellerController$SingleCharItem.createInstance("F", "f");
                arrayList.add(spellerController$SingleCharItem37);
                SpellerController$AbstractExpandableItem$Char spellerController$AbstractExpandableItem$Char25 = SpellerController$AbstractExpandableItem$Char.createInstance(SpellerCharsetDefinitionEurope.getumlaut_gBand(n), "G", "g");
                arrayList.add(spellerController$AbstractExpandableItem$Char25);
                SpellerController$AbstractExpandableItem$Char spellerController$AbstractExpandableItem$Char26 = SpellerController$AbstractExpandableItem$Char.createInstance(SpellerCharsetDefinitionEurope.getumlaut_hBand(n), "H", "h");
                arrayList.add(spellerController$AbstractExpandableItem$Char26);
                SpellerController$AbstractExpandableItem$Char spellerController$AbstractExpandableItem$Char27 = SpellerController$AbstractExpandableItem$Char.createInstance(SpellerCharsetDefinitionEurope.getumlaut_iBand(n), "I", "i");
                arrayList.add(spellerController$AbstractExpandableItem$Char27);
                SpellerController$SingleCharItem spellerController$SingleCharItem38 = SpellerController$SingleCharItem.createInstance("J", "j");
                arrayList.add(spellerController$SingleCharItem38);
                SpellerController$AbstractExpandableItem$Char spellerController$AbstractExpandableItem$Char28 = SpellerController$AbstractExpandableItem$Char.createInstance(SpellerCharsetDefinitionEurope.getumlaut_kBand(n), "K", "k");
                arrayList.add(spellerController$AbstractExpandableItem$Char28);
                SpellerController$AbstractExpandableItem$Char spellerController$AbstractExpandableItem$Char29 = SpellerController$AbstractExpandableItem$Char.createInstance(SpellerCharsetDefinitionEurope.getumlaut_lBand(n), "L", "l");
                arrayList.add(spellerController$AbstractExpandableItem$Char29);
                SpellerController$SingleCharItem spellerController$SingleCharItem39 = SpellerController$SingleCharItem.createInstance("M", "m");
                arrayList.add(spellerController$SingleCharItem39);
                SpellerController$AbstractExpandableItem$Char spellerController$AbstractExpandableItem$Char30 = SpellerController$AbstractExpandableItem$Char.createInstance(SpellerCharsetDefinitionEurope.getumlaut_nBand(n), "N", "n");
                arrayList.add(spellerController$AbstractExpandableItem$Char30);
                SpellerController$AbstractExpandableItem$Char spellerController$AbstractExpandableItem$Char31 = SpellerController$AbstractExpandableItem$Char.createInstance(SpellerCharsetDefinitionEurope.getumlaut_oBand(n), "O", "o");
                arrayList.add(spellerController$AbstractExpandableItem$Char31);
                SpellerController$SingleCharItem spellerController$SingleCharItem40 = SpellerController$SingleCharItem.createInstance("P", "p");
                arrayList.add(spellerController$SingleCharItem40);
                SpellerController$SingleCharItem spellerController$SingleCharItem41 = SpellerController$SingleCharItem.createInstance("Q", "q");
                arrayList.add(spellerController$SingleCharItem41);
                SpellerController$AbstractExpandableItem$Char spellerController$AbstractExpandableItem$Char32 = SpellerController$AbstractExpandableItem$Char.createInstance(SpellerCharsetDefinitionEurope.getumlaut_rBand(n), "R", "r");
                arrayList.add(spellerController$AbstractExpandableItem$Char32);
                SpellerController$AbstractExpandableItem$Char spellerController$AbstractExpandableItem$Char33 = SpellerController$AbstractExpandableItem$Char.createInstance(SpellerCharsetDefinitionEurope.getumlaut_sBand(n), "S", "s");
                arrayList.add(spellerController$AbstractExpandableItem$Char33);
                SpellerController$AbstractExpandableItem$Char spellerController$AbstractExpandableItem$Char34 = SpellerController$AbstractExpandableItem$Char.createInstance(SpellerCharsetDefinitionEurope.getumlaut_tBand(n), "T", "t");
                arrayList.add(spellerController$AbstractExpandableItem$Char34);
                SpellerController$AbstractExpandableItem$Char spellerController$AbstractExpandableItem$Char35 = SpellerController$AbstractExpandableItem$Char.createInstance(SpellerCharsetDefinitionEurope.getumlaut_uBand(n), "U", "u");
                arrayList.add(spellerController$AbstractExpandableItem$Char35);
                SpellerController$SingleCharItem spellerController$SingleCharItem42 = SpellerController$SingleCharItem.createInstance("V", "v");
                arrayList.add(spellerController$SingleCharItem42);
                SpellerController$SingleCharItem spellerController$SingleCharItem43 = SpellerController$SingleCharItem.createInstance("W", "w");
                arrayList.add(spellerController$SingleCharItem43);
                SpellerController$SingleCharItem spellerController$SingleCharItem44 = SpellerController$SingleCharItem.createInstance("X", "x");
                arrayList.add(spellerController$SingleCharItem44);
                SpellerController$AbstractExpandableItem$Char spellerController$AbstractExpandableItem$Char36 = SpellerController$AbstractExpandableItem$Char.createInstance(SpellerCharsetDefinitionEurope.getumlaut_yBand(n), "Y", "y");
                arrayList.add(spellerController$AbstractExpandableItem$Char36);
                SpellerController$AbstractExpandableItem$Char spellerController$AbstractExpandableItem$Char37 = SpellerController$AbstractExpandableItem$Char.createInstance(SpellerCharsetDefinitionEurope.getumlaut_zBand(n), "Z", "z");
                arrayList.add(spellerController$AbstractExpandableItem$Char37);
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
        SpellerController$ButtonItem spellerController$ButtonItem = SpellerController$ButtonItem.createInstance(SpellerController$SpellerButtonType.getSpellerButtonType(30));
        arrayList.add(spellerController$ButtonItem);
        SpellerController$ButtonItem spellerController$ButtonItem2 = SpellerController$ButtonItem.createInstance(SpellerController$SpellerButtonType.getSpellerButtonType(31));
        arrayList.add(spellerController$ButtonItem2);
        SpellerController$ButtonItem spellerController$ButtonItem3 = SpellerController$ButtonItem.createInstance(SpellerController$SpellerButtonType.getSpellerButtonType(32));
        arrayList.add(spellerController$ButtonItem3);
        SpellerController$ButtonItem spellerController$ButtonItem4 = SpellerController$ButtonItem.createInstance(SpellerController$SpellerButtonType.getSpellerButtonType(33));
        arrayList.add(spellerController$ButtonItem4);
        return arrayList;
    }

    private static List getdomainBand(int n) {
        ArrayList arrayList = new ArrayList(30);
        switch (n) {
            case 0: {
                SpellerController$SingleCharItem spellerController$SingleCharItem = SpellerController$SingleCharItem.createInstance(".de");
                arrayList.add(spellerController$SingleCharItem);
                SpellerController$SingleCharItem spellerController$SingleCharItem2 = SpellerController$SingleCharItem.createInstance(".net");
                arrayList.add(spellerController$SingleCharItem2);
                SpellerController$SingleCharItem spellerController$SingleCharItem3 = SpellerController$SingleCharItem.createInstance(".org");
                arrayList.add(spellerController$SingleCharItem3);
                SpellerController$SingleCharItem spellerController$SingleCharItem4 = SpellerController$SingleCharItem.createInstance(".info");
                arrayList.add(spellerController$SingleCharItem4);
                break;
            }
            case 27: {
                SpellerController$SingleCharItem spellerController$SingleCharItem = SpellerController$SingleCharItem.createInstance(".no");
                arrayList.add(spellerController$SingleCharItem);
                SpellerController$SingleCharItem spellerController$SingleCharItem5 = SpellerController$SingleCharItem.createInstance(".net");
                arrayList.add(spellerController$SingleCharItem5);
                SpellerController$SingleCharItem spellerController$SingleCharItem6 = SpellerController$SingleCharItem.createInstance(".org");
                arrayList.add(spellerController$SingleCharItem6);
                SpellerController$SingleCharItem spellerController$SingleCharItem7 = SpellerController$SingleCharItem.createInstance(".info");
                arrayList.add(spellerController$SingleCharItem7);
                break;
            }
            case 30: {
                SpellerController$SingleCharItem spellerController$SingleCharItem = SpellerController$SingleCharItem.createInstance(".fi");
                arrayList.add(spellerController$SingleCharItem);
                SpellerController$SingleCharItem spellerController$SingleCharItem8 = SpellerController$SingleCharItem.createInstance(".net");
                arrayList.add(spellerController$SingleCharItem8);
                SpellerController$SingleCharItem spellerController$SingleCharItem9 = SpellerController$SingleCharItem.createInstance(".org");
                arrayList.add(spellerController$SingleCharItem9);
                SpellerController$SingleCharItem spellerController$SingleCharItem10 = SpellerController$SingleCharItem.createInstance(".info");
                arrayList.add(spellerController$SingleCharItem10);
                break;
            }
            case 7: {
                SpellerController$SingleCharItem spellerController$SingleCharItem = SpellerController$SingleCharItem.createInstance(".ru");
                arrayList.add(spellerController$SingleCharItem);
                SpellerController$SingleCharItem spellerController$SingleCharItem11 = SpellerController$SingleCharItem.createInstance(".net");
                arrayList.add(spellerController$SingleCharItem11);
                SpellerController$SingleCharItem spellerController$SingleCharItem12 = SpellerController$SingleCharItem.createInstance(".org");
                arrayList.add(spellerController$SingleCharItem12);
                SpellerController$SingleCharItem spellerController$SingleCharItem13 = SpellerController$SingleCharItem.createInstance(".info");
                arrayList.add(spellerController$SingleCharItem13);
                break;
            }
            case 5: {
                SpellerController$SingleCharItem spellerController$SingleCharItem = SpellerController$SingleCharItem.createInstance(".pt");
                arrayList.add(spellerController$SingleCharItem);
                SpellerController$SingleCharItem spellerController$SingleCharItem14 = SpellerController$SingleCharItem.createInstance(".net");
                arrayList.add(spellerController$SingleCharItem14);
                SpellerController$SingleCharItem spellerController$SingleCharItem15 = SpellerController$SingleCharItem.createInstance(".org");
                arrayList.add(spellerController$SingleCharItem15);
                SpellerController$SingleCharItem spellerController$SingleCharItem16 = SpellerController$SingleCharItem.createInstance(".info");
                arrayList.add(spellerController$SingleCharItem16);
                break;
            }
            case 29: {
                SpellerController$SingleCharItem spellerController$SingleCharItem = SpellerController$SingleCharItem.createInstance(".dk");
                arrayList.add(spellerController$SingleCharItem);
                SpellerController$SingleCharItem spellerController$SingleCharItem17 = SpellerController$SingleCharItem.createInstance(".net");
                arrayList.add(spellerController$SingleCharItem17);
                SpellerController$SingleCharItem spellerController$SingleCharItem18 = SpellerController$SingleCharItem.createInstance(".org");
                arrayList.add(spellerController$SingleCharItem18);
                SpellerController$SingleCharItem spellerController$SingleCharItem19 = SpellerController$SingleCharItem.createInstance(".info");
                arrayList.add(spellerController$SingleCharItem19);
                break;
            }
            case 4: {
                SpellerController$SingleCharItem spellerController$SingleCharItem = SpellerController$SingleCharItem.createInstance(".it");
                arrayList.add(spellerController$SingleCharItem);
                SpellerController$SingleCharItem spellerController$SingleCharItem20 = SpellerController$SingleCharItem.createInstance(".net");
                arrayList.add(spellerController$SingleCharItem20);
                SpellerController$SingleCharItem spellerController$SingleCharItem21 = SpellerController$SingleCharItem.createInstance(".org");
                arrayList.add(spellerController$SingleCharItem21);
                SpellerController$SingleCharItem spellerController$SingleCharItem22 = SpellerController$SingleCharItem.createInstance(".info");
                arrayList.add(spellerController$SingleCharItem22);
                break;
            }
            case 34: {
                SpellerController$SingleCharItem spellerController$SingleCharItem = SpellerController$SingleCharItem.createInstance(".gr");
                arrayList.add(spellerController$SingleCharItem);
                SpellerController$SingleCharItem spellerController$SingleCharItem23 = SpellerController$SingleCharItem.createInstance(".net");
                arrayList.add(spellerController$SingleCharItem23);
                SpellerController$SingleCharItem spellerController$SingleCharItem24 = SpellerController$SingleCharItem.createInstance(".org");
                arrayList.add(spellerController$SingleCharItem24);
                SpellerController$SingleCharItem spellerController$SingleCharItem25 = SpellerController$SingleCharItem.createInstance(".info");
                arrayList.add(spellerController$SingleCharItem25);
                break;
            }
            case 2: {
                SpellerController$SingleCharItem spellerController$SingleCharItem = SpellerController$SingleCharItem.createInstance(".fr");
                arrayList.add(spellerController$SingleCharItem);
                SpellerController$SingleCharItem spellerController$SingleCharItem26 = SpellerController$SingleCharItem.createInstance(".net");
                arrayList.add(spellerController$SingleCharItem26);
                SpellerController$SingleCharItem spellerController$SingleCharItem27 = SpellerController$SingleCharItem.createInstance(".org");
                arrayList.add(spellerController$SingleCharItem27);
                SpellerController$SingleCharItem spellerController$SingleCharItem28 = SpellerController$SingleCharItem.createInstance(".info");
                arrayList.add(spellerController$SingleCharItem28);
                break;
            }
            case 32: {
                SpellerController$SingleCharItem spellerController$SingleCharItem = SpellerController$SingleCharItem.createInstance(".ua");
                arrayList.add(spellerController$SingleCharItem);
                SpellerController$SingleCharItem spellerController$SingleCharItem29 = SpellerController$SingleCharItem.createInstance(".net");
                arrayList.add(spellerController$SingleCharItem29);
                SpellerController$SingleCharItem spellerController$SingleCharItem30 = SpellerController$SingleCharItem.createInstance(".org");
                arrayList.add(spellerController$SingleCharItem30);
                SpellerController$SingleCharItem spellerController$SingleCharItem31 = SpellerController$SingleCharItem.createInstance(".info");
                arrayList.add(spellerController$SingleCharItem31);
                break;
            }
            case 35: {
                SpellerController$SingleCharItem spellerController$SingleCharItem = SpellerController$SingleCharItem.createInstance(".my");
                arrayList.add(spellerController$SingleCharItem);
                SpellerController$SingleCharItem spellerController$SingleCharItem32 = SpellerController$SingleCharItem.createInstance(".net");
                arrayList.add(spellerController$SingleCharItem32);
                SpellerController$SingleCharItem spellerController$SingleCharItem33 = SpellerController$SingleCharItem.createInstance(".org");
                arrayList.add(spellerController$SingleCharItem33);
                SpellerController$SingleCharItem spellerController$SingleCharItem34 = SpellerController$SingleCharItem.createInstance(".info");
                arrayList.add(spellerController$SingleCharItem34);
                break;
            }
            case 28: {
                SpellerController$SingleCharItem spellerController$SingleCharItem = SpellerController$SingleCharItem.createInstance(".hu");
                arrayList.add(spellerController$SingleCharItem);
                SpellerController$SingleCharItem spellerController$SingleCharItem35 = SpellerController$SingleCharItem.createInstance(".net");
                arrayList.add(spellerController$SingleCharItem35);
                SpellerController$SingleCharItem spellerController$SingleCharItem36 = SpellerController$SingleCharItem.createInstance(".org");
                arrayList.add(spellerController$SingleCharItem36);
                SpellerController$SingleCharItem spellerController$SingleCharItem37 = SpellerController$SingleCharItem.createInstance(".info");
                arrayList.add(spellerController$SingleCharItem37);
                break;
            }
            case 3: {
                SpellerController$SingleCharItem spellerController$SingleCharItem = SpellerController$SingleCharItem.createInstance(".es");
                arrayList.add(spellerController$SingleCharItem);
                SpellerController$SingleCharItem spellerController$SingleCharItem38 = SpellerController$SingleCharItem.createInstance(".net");
                arrayList.add(spellerController$SingleCharItem38);
                SpellerController$SingleCharItem spellerController$SingleCharItem39 = SpellerController$SingleCharItem.createInstance(".org");
                arrayList.add(spellerController$SingleCharItem39);
                SpellerController$SingleCharItem spellerController$SingleCharItem40 = SpellerController$SingleCharItem.createInstance(".info");
                arrayList.add(spellerController$SingleCharItem40);
                break;
            }
            case 19: {
                SpellerController$SingleCharItem spellerController$SingleCharItem = SpellerController$SingleCharItem.createInstance(".se");
                arrayList.add(spellerController$SingleCharItem);
                SpellerController$SingleCharItem spellerController$SingleCharItem41 = SpellerController$SingleCharItem.createInstance(".net");
                arrayList.add(spellerController$SingleCharItem41);
                SpellerController$SingleCharItem spellerController$SingleCharItem42 = SpellerController$SingleCharItem.createInstance(".org");
                arrayList.add(spellerController$SingleCharItem42);
                SpellerController$SingleCharItem spellerController$SingleCharItem43 = SpellerController$SingleCharItem.createInstance(".info");
                arrayList.add(spellerController$SingleCharItem43);
                break;
            }
            case 31: {
                SpellerController$SingleCharItem spellerController$SingleCharItem = SpellerController$SingleCharItem.createInstance(".si");
                arrayList.add(spellerController$SingleCharItem);
                SpellerController$SingleCharItem spellerController$SingleCharItem44 = SpellerController$SingleCharItem.createInstance(".net");
                arrayList.add(spellerController$SingleCharItem44);
                SpellerController$SingleCharItem spellerController$SingleCharItem45 = SpellerController$SingleCharItem.createInstance(".org");
                arrayList.add(spellerController$SingleCharItem45);
                SpellerController$SingleCharItem spellerController$SingleCharItem46 = SpellerController$SingleCharItem.createInstance(".info");
                arrayList.add(spellerController$SingleCharItem46);
                break;
            }
            case 20: {
                SpellerController$SingleCharItem spellerController$SingleCharItem = SpellerController$SingleCharItem.createInstance(".cz");
                arrayList.add(spellerController$SingleCharItem);
                SpellerController$SingleCharItem spellerController$SingleCharItem47 = SpellerController$SingleCharItem.createInstance(".net");
                arrayList.add(spellerController$SingleCharItem47);
                SpellerController$SingleCharItem spellerController$SingleCharItem48 = SpellerController$SingleCharItem.createInstance(".org");
                arrayList.add(spellerController$SingleCharItem48);
                SpellerController$SingleCharItem spellerController$SingleCharItem49 = SpellerController$SingleCharItem.createInstance(".info");
                arrayList.add(spellerController$SingleCharItem49);
                break;
            }
            case 18: {
                SpellerController$SingleCharItem spellerController$SingleCharItem = SpellerController$SingleCharItem.createInstance(".pl");
                arrayList.add(spellerController$SingleCharItem);
                SpellerController$SingleCharItem spellerController$SingleCharItem50 = SpellerController$SingleCharItem.createInstance(".net");
                arrayList.add(spellerController$SingleCharItem50);
                SpellerController$SingleCharItem spellerController$SingleCharItem51 = SpellerController$SingleCharItem.createInstance(".org");
                arrayList.add(spellerController$SingleCharItem51);
                SpellerController$SingleCharItem spellerController$SingleCharItem52 = SpellerController$SingleCharItem.createInstance(".info");
                arrayList.add(spellerController$SingleCharItem52);
                break;
            }
            case 33: {
                SpellerController$SingleCharItem spellerController$SingleCharItem = SpellerController$SingleCharItem.createInstance(".ro");
                arrayList.add(spellerController$SingleCharItem);
                SpellerController$SingleCharItem spellerController$SingleCharItem53 = SpellerController$SingleCharItem.createInstance(".net");
                arrayList.add(spellerController$SingleCharItem53);
                SpellerController$SingleCharItem spellerController$SingleCharItem54 = SpellerController$SingleCharItem.createInstance(".org");
                arrayList.add(spellerController$SingleCharItem54);
                SpellerController$SingleCharItem spellerController$SingleCharItem55 = SpellerController$SingleCharItem.createInstance(".info");
                arrayList.add(spellerController$SingleCharItem55);
                break;
            }
            case 21: {
                SpellerController$SingleCharItem spellerController$SingleCharItem = SpellerController$SingleCharItem.createInstance(".tr");
                arrayList.add(spellerController$SingleCharItem);
                SpellerController$SingleCharItem spellerController$SingleCharItem56 = SpellerController$SingleCharItem.createInstance(".net");
                arrayList.add(spellerController$SingleCharItem56);
                SpellerController$SingleCharItem spellerController$SingleCharItem57 = SpellerController$SingleCharItem.createInstance(".org");
                arrayList.add(spellerController$SingleCharItem57);
                SpellerController$SingleCharItem spellerController$SingleCharItem58 = SpellerController$SingleCharItem.createInstance(".info");
                arrayList.add(spellerController$SingleCharItem58);
                break;
            }
            case 6: {
                SpellerController$SingleCharItem spellerController$SingleCharItem = SpellerController$SingleCharItem.createInstance(".nl");
                arrayList.add(spellerController$SingleCharItem);
                SpellerController$SingleCharItem spellerController$SingleCharItem59 = SpellerController$SingleCharItem.createInstance(".net");
                arrayList.add(spellerController$SingleCharItem59);
                SpellerController$SingleCharItem spellerController$SingleCharItem60 = SpellerController$SingleCharItem.createInstance(".org");
                arrayList.add(spellerController$SingleCharItem60);
                SpellerController$SingleCharItem spellerController$SingleCharItem61 = SpellerController$SingleCharItem.createInstance(".info");
                arrayList.add(spellerController$SingleCharItem61);
                break;
            }
            default: {
                SpellerController$SingleCharItem spellerController$SingleCharItem = SpellerController$SingleCharItem.createInstance(".net");
                arrayList.add(spellerController$SingleCharItem);
                SpellerController$SingleCharItem spellerController$SingleCharItem62 = SpellerController$SingleCharItem.createInstance(".org");
                arrayList.add(spellerController$SingleCharItem62);
                SpellerController$SingleCharItem spellerController$SingleCharItem63 = SpellerController$SingleCharItem.createInstance(".info");
                arrayList.add(spellerController$SingleCharItem63);
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
                SpellerController$AbstractExpandableItem$CharSet spellerController$AbstractExpandableItem$CharSet = SpellerController$AbstractExpandableItem$CharSet.createInstance(SpellerCharsetDefinitionEurope.getnumbersBand(n), 1);
                arrayList.add(spellerController$AbstractExpandableItem$CharSet);
                SpellerController$AbstractExpandableItem$CharSet spellerController$AbstractExpandableItem$CharSet2 = SpellerController$AbstractExpandableItem$CharSet.createInstance(SpellerCharsetDefinitionEurope.getumlauts_arabicBand(n), 2);
                arrayList.add(spellerController$AbstractExpandableItem$CharSet2);
                SpellerController$AbstractExpandableItem$CharSet spellerController$AbstractExpandableItem$CharSet3 = SpellerController$AbstractExpandableItem$CharSet.createInstance(SpellerCharsetDefinitionEurope.getspecialBand(n), 0);
                arrayList.add(spellerController$AbstractExpandableItem$CharSet3);
                break;
            }
            case 7: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.getcyrillicBand(n));
                arrayList.addAll(SpellerCharsetDefinitionEurope.getmainBand(n));
                SpellerController$ButtonItem spellerController$ButtonItem = SpellerController$ButtonItem.createInstance(SpellerController$SpellerButtonType.getSpellerButtonType(4));
                arrayList.add(spellerController$ButtonItem);
                SpellerController$AbstractExpandableItem$CharSet spellerController$AbstractExpandableItem$CharSet = SpellerController$AbstractExpandableItem$CharSet.createInstance(SpellerCharsetDefinitionEurope.getnumbersBand(n), 1);
                arrayList.add(spellerController$AbstractExpandableItem$CharSet);
                SpellerController$AbstractExpandableItem$CharSet spellerController$AbstractExpandableItem$CharSet4 = SpellerController$AbstractExpandableItem$CharSet.createInstance(SpellerCharsetDefinitionEurope.getumlauts_cyrillicBand(n), 2);
                arrayList.add(spellerController$AbstractExpandableItem$CharSet4);
                SpellerController$AbstractExpandableItem$CharSet spellerController$AbstractExpandableItem$CharSet5 = SpellerController$AbstractExpandableItem$CharSet.createInstance(SpellerCharsetDefinitionEurope.getspecialBand(n), 0);
                arrayList.add(spellerController$AbstractExpandableItem$CharSet5);
                break;
            }
            default: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.getlatinExpandableAZBand(n));
                arrayList.addAll(SpellerCharsetDefinitionEurope.getmainBand(n));
                SpellerController$ButtonItem spellerController$ButtonItem = SpellerController$ButtonItem.createInstance(SpellerController$SpellerButtonType.getSpellerButtonType(4));
                arrayList.add(spellerController$ButtonItem);
                SpellerController$AbstractExpandableItem$CharSet spellerController$AbstractExpandableItem$CharSet = SpellerController$AbstractExpandableItem$CharSet.createInstance(SpellerCharsetDefinitionEurope.getnumbersBand(n), 1);
                arrayList.add(spellerController$AbstractExpandableItem$CharSet);
                SpellerController$AbstractExpandableItem$CharSet spellerController$AbstractExpandableItem$CharSet6 = SpellerController$AbstractExpandableItem$CharSet.createInstance(SpellerCharsetDefinitionEurope.getumlauts_latinBand(n), 2);
                arrayList.add(spellerController$AbstractExpandableItem$CharSet6);
                SpellerController$AbstractExpandableItem$CharSet spellerController$AbstractExpandableItem$CharSet7 = SpellerController$AbstractExpandableItem$CharSet.createInstance(SpellerCharsetDefinitionEurope.getspecialBand(n), 0);
                arrayList.add(spellerController$AbstractExpandableItem$CharSet7);
            }
        }
        return arrayList;
    }

    public static List getMatchHousenumberBand(int n) {
        ArrayList arrayList = new ArrayList(30);
        switch (n) {
            case 26: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.getnumbersBand(n));
                SpellerController$SingleCharItem spellerController$SingleCharItem = SpellerController$SingleCharItem.createInstance(" ");
                arrayList.add(spellerController$SingleCharItem);
                arrayList.addAll(SpellerCharsetDefinitionEurope.getlatinExpandableAZ_arBand(n));
                SpellerController$AbstractExpandableItem$CharSet spellerController$AbstractExpandableItem$CharSet = SpellerController$AbstractExpandableItem$CharSet.createInstance(SpellerCharsetDefinitionEurope.getumlauts_arabicBand(n), 2);
                arrayList.add(spellerController$AbstractExpandableItem$CharSet);
                SpellerController$AbstractExpandableItem$CharSet spellerController$AbstractExpandableItem$CharSet2 = SpellerController$AbstractExpandableItem$CharSet.createInstance(SpellerCharsetDefinitionEurope.getspecial_arBand(n), 0);
                arrayList.add(spellerController$AbstractExpandableItem$CharSet2);
                break;
            }
            case 7: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.getnumbersBand(n));
                SpellerController$SingleCharItem spellerController$SingleCharItem = SpellerController$SingleCharItem.createInstance(" ");
                arrayList.add(spellerController$SingleCharItem);
                arrayList.addAll(SpellerCharsetDefinitionEurope.getcyrillicBand(n));
                SpellerController$ButtonItem spellerController$ButtonItem = SpellerController$ButtonItem.createInstance(SpellerController$SpellerButtonType.getSpellerButtonType(4));
                arrayList.add(spellerController$ButtonItem);
                SpellerController$AbstractExpandableItem$CharSet spellerController$AbstractExpandableItem$CharSet = SpellerController$AbstractExpandableItem$CharSet.createInstance(SpellerCharsetDefinitionEurope.getumlauts_cyrillicBand(n), 2);
                arrayList.add(spellerController$AbstractExpandableItem$CharSet);
                SpellerController$AbstractExpandableItem$CharSet spellerController$AbstractExpandableItem$CharSet3 = SpellerController$AbstractExpandableItem$CharSet.createInstance(SpellerCharsetDefinitionEurope.getspecialBand(n), 0);
                arrayList.add(spellerController$AbstractExpandableItem$CharSet3);
                break;
            }
            default: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.getnumbersBand(n));
                SpellerController$SingleCharItem spellerController$SingleCharItem = SpellerController$SingleCharItem.createInstance(" ");
                arrayList.add(spellerController$SingleCharItem);
                arrayList.addAll(SpellerCharsetDefinitionEurope.getlatinExpandableAZBand(n));
                SpellerController$ButtonItem spellerController$ButtonItem = SpellerController$ButtonItem.createInstance(SpellerController$SpellerButtonType.getSpellerButtonType(4));
                arrayList.add(spellerController$ButtonItem);
                SpellerController$AbstractExpandableItem$CharSet spellerController$AbstractExpandableItem$CharSet = SpellerController$AbstractExpandableItem$CharSet.createInstance(SpellerCharsetDefinitionEurope.getumlauts_latinBand(n), 2);
                arrayList.add(spellerController$AbstractExpandableItem$CharSet);
                SpellerController$AbstractExpandableItem$CharSet spellerController$AbstractExpandableItem$CharSet4 = SpellerController$AbstractExpandableItem$CharSet.createInstance(SpellerCharsetDefinitionEurope.getspecialBand(n), 0);
                arrayList.add(spellerController$AbstractExpandableItem$CharSet4);
            }
        }
        return arrayList;
    }

    public static List getMessagingBand(int n) {
        ArrayList arrayList = new ArrayList(30);
        switch (n) {
            case 26: {
                SpellerController$ButtonItem spellerController$ButtonItem = SpellerController$ButtonItem.createInstance(SpellerController$SpellerButtonType.getSpellerButtonType(5));
                arrayList.add(spellerController$ButtonItem);
                SpellerController$ButtonItem spellerController$ButtonItem2 = SpellerController$ButtonItem.createInstance(SpellerController$SpellerButtonType.getSpellerButtonType(6));
                arrayList.add(spellerController$ButtonItem2);
                arrayList.addAll(SpellerCharsetDefinitionEurope.getlatinExpandableAZ_arBand(n));
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand(" .,'\u061f!-", null, true));
                SpellerController$ButtonItem spellerController$ButtonItem3 = SpellerController$ButtonItem.createInstance(SpellerController$SpellerButtonType.getSpellerButtonType(29));
                arrayList.add(spellerController$ButtonItem3);
                arrayList.addAll(SpellerCharsetDefinitionEurope.getsmileysBand(n));
                SpellerController$AbstractExpandableItem$CharSet spellerController$AbstractExpandableItem$CharSet = SpellerController$AbstractExpandableItem$CharSet.createInstance(SpellerCharsetDefinitionEurope.getnumbersBand(n), 1);
                arrayList.add(spellerController$AbstractExpandableItem$CharSet);
                SpellerController$AbstractExpandableItem$CharSet spellerController$AbstractExpandableItem$CharSet2 = SpellerController$AbstractExpandableItem$CharSet.createInstance(SpellerCharsetDefinitionEurope.getumlauts_arabicBand(n), 2);
                arrayList.add(spellerController$AbstractExpandableItem$CharSet2);
                SpellerController$AbstractExpandableItem$CharSet spellerController$AbstractExpandableItem$CharSet3 = SpellerController$AbstractExpandableItem$CharSet.createInstance(SpellerCharsetDefinitionEurope.getspecial_arBand(n), 0);
                arrayList.add(spellerController$AbstractExpandableItem$CharSet3);
                break;
            }
            case 7: {
                SpellerController$ButtonItem spellerController$ButtonItem = SpellerController$ButtonItem.createInstance(SpellerController$SpellerButtonType.getSpellerButtonType(5));
                arrayList.add(spellerController$ButtonItem);
                SpellerController$ButtonItem spellerController$ButtonItem4 = SpellerController$ButtonItem.createInstance(SpellerController$SpellerButtonType.getSpellerButtonType(6));
                arrayList.add(spellerController$ButtonItem4);
                arrayList.addAll(SpellerCharsetDefinitionEurope.getcyrillicBand(n));
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand(" .,'?!-", null, true));
                SpellerController$ButtonItem spellerController$ButtonItem5 = SpellerController$ButtonItem.createInstance(SpellerController$SpellerButtonType.getSpellerButtonType(4));
                arrayList.add(spellerController$ButtonItem5);
                SpellerController$ButtonItem spellerController$ButtonItem6 = SpellerController$ButtonItem.createInstance(SpellerController$SpellerButtonType.getSpellerButtonType(29));
                arrayList.add(spellerController$ButtonItem6);
                arrayList.addAll(SpellerCharsetDefinitionEurope.getsmileysBand(n));
                SpellerController$AbstractExpandableItem$CharSet spellerController$AbstractExpandableItem$CharSet = SpellerController$AbstractExpandableItem$CharSet.createInstance(SpellerCharsetDefinitionEurope.getnumbersBand(n), 1);
                arrayList.add(spellerController$AbstractExpandableItem$CharSet);
                SpellerController$AbstractExpandableItem$CharSet spellerController$AbstractExpandableItem$CharSet4 = SpellerController$AbstractExpandableItem$CharSet.createInstance(SpellerCharsetDefinitionEurope.getumlauts_cyrillicBand(n), 2);
                arrayList.add(spellerController$AbstractExpandableItem$CharSet4);
                SpellerController$AbstractExpandableItem$CharSet spellerController$AbstractExpandableItem$CharSet5 = SpellerController$AbstractExpandableItem$CharSet.createInstance(SpellerCharsetDefinitionEurope.getspecialBand(n), 0);
                arrayList.add(spellerController$AbstractExpandableItem$CharSet5);
                break;
            }
            default: {
                SpellerController$ButtonItem spellerController$ButtonItem = SpellerController$ButtonItem.createInstance(SpellerController$SpellerButtonType.getSpellerButtonType(5));
                arrayList.add(spellerController$ButtonItem);
                SpellerController$ButtonItem spellerController$ButtonItem7 = SpellerController$ButtonItem.createInstance(SpellerController$SpellerButtonType.getSpellerButtonType(6));
                arrayList.add(spellerController$ButtonItem7);
                arrayList.addAll(SpellerCharsetDefinitionEurope.getlatinExpandableAZBand(n));
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand(" .,'?!-", null, true));
                SpellerController$ButtonItem spellerController$ButtonItem8 = SpellerController$ButtonItem.createInstance(SpellerController$SpellerButtonType.getSpellerButtonType(4));
                arrayList.add(spellerController$ButtonItem8);
                SpellerController$ButtonItem spellerController$ButtonItem9 = SpellerController$ButtonItem.createInstance(SpellerController$SpellerButtonType.getSpellerButtonType(29));
                arrayList.add(spellerController$ButtonItem9);
                arrayList.addAll(SpellerCharsetDefinitionEurope.getsmileysBand(n));
                SpellerController$AbstractExpandableItem$CharSet spellerController$AbstractExpandableItem$CharSet = SpellerController$AbstractExpandableItem$CharSet.createInstance(SpellerCharsetDefinitionEurope.getnumbersBand(n), 1);
                arrayList.add(spellerController$AbstractExpandableItem$CharSet);
                SpellerController$AbstractExpandableItem$CharSet spellerController$AbstractExpandableItem$CharSet6 = SpellerController$AbstractExpandableItem$CharSet.createInstance(SpellerCharsetDefinitionEurope.getumlauts_latinBand(n), 2);
                arrayList.add(spellerController$AbstractExpandableItem$CharSet6);
                SpellerController$AbstractExpandableItem$CharSet spellerController$AbstractExpandableItem$CharSet7 = SpellerController$AbstractExpandableItem$CharSet.createInstance(SpellerCharsetDefinitionEurope.getspecialBand(n), 0);
                arrayList.add(spellerController$AbstractExpandableItem$CharSet7);
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
                SpellerController$AbstractExpandableItem$Char spellerController$AbstractExpandableItem$Char = SpellerController$AbstractExpandableItem$Char.createInstance(SpellerCharsetDefinitionEurope.getdomainBand(n), ".com");
                arrayList.add(spellerController$AbstractExpandableItem$Char);
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("-\u061f!", null, true));
                SpellerController$AbstractExpandableItem$CharSet spellerController$AbstractExpandableItem$CharSet = SpellerController$AbstractExpandableItem$CharSet.createInstance(SpellerCharsetDefinitionEurope.getnumbersBand(n), 1);
                arrayList.add(spellerController$AbstractExpandableItem$CharSet);
                SpellerController$AbstractExpandableItem$CharSet spellerController$AbstractExpandableItem$CharSet2 = SpellerController$AbstractExpandableItem$CharSet.createInstance(SpellerCharsetDefinitionEurope.getumlauts_arabicBand(n), 2);
                arrayList.add(spellerController$AbstractExpandableItem$CharSet2);
                SpellerController$AbstractExpandableItem$CharSet spellerController$AbstractExpandableItem$CharSet3 = SpellerController$AbstractExpandableItem$CharSet.createInstance(SpellerCharsetDefinitionEurope.getspecial_arBand(n), 0);
                arrayList.add(spellerController$AbstractExpandableItem$CharSet3);
                break;
            }
            case 7: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.getcyrillicBand(n));
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand(".@", null, true));
                SpellerController$AbstractExpandableItem$Char spellerController$AbstractExpandableItem$Char = SpellerController$AbstractExpandableItem$Char.createInstance(SpellerCharsetDefinitionEurope.getdomainBand(n), ".com");
                arrayList.add(spellerController$AbstractExpandableItem$Char);
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("-?!", null, true));
                SpellerController$ButtonItem spellerController$ButtonItem = SpellerController$ButtonItem.createInstance(SpellerController$SpellerButtonType.getSpellerButtonType(4));
                arrayList.add(spellerController$ButtonItem);
                SpellerController$AbstractExpandableItem$CharSet spellerController$AbstractExpandableItem$CharSet = SpellerController$AbstractExpandableItem$CharSet.createInstance(SpellerCharsetDefinitionEurope.getnumbersBand(n), 1);
                arrayList.add(spellerController$AbstractExpandableItem$CharSet);
                SpellerController$AbstractExpandableItem$CharSet spellerController$AbstractExpandableItem$CharSet4 = SpellerController$AbstractExpandableItem$CharSet.createInstance(SpellerCharsetDefinitionEurope.getumlauts_cyrillicBand(n), 2);
                arrayList.add(spellerController$AbstractExpandableItem$CharSet4);
                SpellerController$AbstractExpandableItem$CharSet spellerController$AbstractExpandableItem$CharSet5 = SpellerController$AbstractExpandableItem$CharSet.createInstance(SpellerCharsetDefinitionEurope.getspecialBand(n), 0);
                arrayList.add(spellerController$AbstractExpandableItem$CharSet5);
                break;
            }
            default: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.getlatinExpandableAZBand(n));
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand(".@", null, true));
                SpellerController$AbstractExpandableItem$Char spellerController$AbstractExpandableItem$Char = SpellerController$AbstractExpandableItem$Char.createInstance(SpellerCharsetDefinitionEurope.getdomainBand(n), ".com");
                arrayList.add(spellerController$AbstractExpandableItem$Char);
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("-?!", null, true));
                SpellerController$ButtonItem spellerController$ButtonItem = SpellerController$ButtonItem.createInstance(SpellerController$SpellerButtonType.getSpellerButtonType(4));
                arrayList.add(spellerController$ButtonItem);
                SpellerController$AbstractExpandableItem$CharSet spellerController$AbstractExpandableItem$CharSet = SpellerController$AbstractExpandableItem$CharSet.createInstance(SpellerCharsetDefinitionEurope.getnumbersBand(n), 1);
                arrayList.add(spellerController$AbstractExpandableItem$CharSet);
                SpellerController$AbstractExpandableItem$CharSet spellerController$AbstractExpandableItem$CharSet6 = SpellerController$AbstractExpandableItem$CharSet.createInstance(SpellerCharsetDefinitionEurope.getumlauts_latinBand(n), 2);
                arrayList.add(spellerController$AbstractExpandableItem$CharSet6);
                SpellerController$AbstractExpandableItem$CharSet spellerController$AbstractExpandableItem$CharSet7 = SpellerController$AbstractExpandableItem$CharSet.createInstance(SpellerCharsetDefinitionEurope.getspecialBand(n), 0);
                arrayList.add(spellerController$AbstractExpandableItem$CharSet7);
            }
        }
        return arrayList;
    }

    public static List getPhoneBand(int n) {
        ArrayList arrayList = new ArrayList(30);
        switch (n) {
            case 26: {
                SpellerController$ButtonItem spellerController$ButtonItem = SpellerController$ButtonItem.createInstance(SpellerController$SpellerButtonType.getSpellerButtonType(6));
                arrayList.add(spellerController$ButtonItem);
                SpellerController$ButtonItem spellerController$ButtonItem2 = SpellerController$ButtonItem.createInstance(SpellerController$SpellerButtonType.getSpellerButtonType(5));
                arrayList.add(spellerController$ButtonItem2);
                SpellerController$SingleCharItem spellerController$SingleCharItem = SpellerController$SingleCharItem.createInstance("+");
                arrayList.add(spellerController$SingleCharItem);
                arrayList.addAll(SpellerCharsetDefinitionEurope.getnumbersBand(n));
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("*#", null, true));
                SpellerController$AbstractExpandableItem$CharSet spellerController$AbstractExpandableItem$CharSet = SpellerController$AbstractExpandableItem$CharSet.createInstance(SpellerCharsetDefinitionEurope.getlatinAZBand(n), 3);
                arrayList.add(spellerController$AbstractExpandableItem$CharSet);
                break;
            }
            default: {
                SpellerController$ButtonItem spellerController$ButtonItem = SpellerController$ButtonItem.createInstance(SpellerController$SpellerButtonType.getSpellerButtonType(5));
                arrayList.add(spellerController$ButtonItem);
                SpellerController$ButtonItem spellerController$ButtonItem3 = SpellerController$ButtonItem.createInstance(SpellerController$SpellerButtonType.getSpellerButtonType(6));
                arrayList.add(spellerController$ButtonItem3);
                SpellerController$SingleCharItem spellerController$SingleCharItem = SpellerController$SingleCharItem.createInstance("+");
                arrayList.add(spellerController$SingleCharItem);
                arrayList.addAll(SpellerCharsetDefinitionEurope.getnumbersBand(n));
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand("*#", null, true));
                SpellerController$AbstractExpandableItem$CharSet spellerController$AbstractExpandableItem$CharSet = SpellerController$AbstractExpandableItem$CharSet.createInstance(SpellerCharsetDefinitionEurope.getlatinAZBand(n), 3);
                arrayList.add(spellerController$AbstractExpandableItem$CharSet);
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
                SpellerController$AbstractExpandableItem$CharSet spellerController$AbstractExpandableItem$CharSet = SpellerController$AbstractExpandableItem$CharSet.createInstance(SpellerCharsetDefinitionEurope.getcallistnumbersBand(n), 1);
                arrayList.add(spellerController$AbstractExpandableItem$CharSet);
                SpellerController$AbstractExpandableItem$CharSet spellerController$AbstractExpandableItem$CharSet2 = SpellerController$AbstractExpandableItem$CharSet.createInstance(SpellerCharsetDefinitionEurope.getumlauts_arabicBand(n), 2);
                arrayList.add(spellerController$AbstractExpandableItem$CharSet2);
                SpellerController$AbstractExpandableItem$CharSet spellerController$AbstractExpandableItem$CharSet3 = SpellerController$AbstractExpandableItem$CharSet.createInstance(SpellerCharsetDefinitionEurope.getspecialBand(n), 0);
                arrayList.add(spellerController$AbstractExpandableItem$CharSet3);
                break;
            }
            case 7: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.getcyrillicBand(n));
                arrayList.addAll(SpellerCharsetDefinitionEurope.getmainBand(n));
                SpellerController$AbstractExpandableItem$CharSet spellerController$AbstractExpandableItem$CharSet = SpellerController$AbstractExpandableItem$CharSet.createInstance(SpellerCharsetDefinitionEurope.getcallistnumbersBand(n), 1);
                arrayList.add(spellerController$AbstractExpandableItem$CharSet);
                SpellerController$AbstractExpandableItem$CharSet spellerController$AbstractExpandableItem$CharSet4 = SpellerController$AbstractExpandableItem$CharSet.createInstance(SpellerCharsetDefinitionEurope.getumlauts_cyrillicBand(n), 2);
                arrayList.add(spellerController$AbstractExpandableItem$CharSet4);
                SpellerController$AbstractExpandableItem$CharSet spellerController$AbstractExpandableItem$CharSet5 = SpellerController$AbstractExpandableItem$CharSet.createInstance(SpellerCharsetDefinitionEurope.getspecialBand(n), 0);
                arrayList.add(spellerController$AbstractExpandableItem$CharSet5);
                break;
            }
            default: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.getlatinExpandableAZBand(n));
                arrayList.addAll(SpellerCharsetDefinitionEurope.getmainBand(n));
                SpellerController$AbstractExpandableItem$CharSet spellerController$AbstractExpandableItem$CharSet = SpellerController$AbstractExpandableItem$CharSet.createInstance(SpellerCharsetDefinitionEurope.getcallistnumbersBand(n), 1);
                arrayList.add(spellerController$AbstractExpandableItem$CharSet);
                SpellerController$AbstractExpandableItem$CharSet spellerController$AbstractExpandableItem$CharSet6 = SpellerController$AbstractExpandableItem$CharSet.createInstance(SpellerCharsetDefinitionEurope.getumlauts_latinBand(n), 2);
                arrayList.add(spellerController$AbstractExpandableItem$CharSet6);
                SpellerController$AbstractExpandableItem$CharSet spellerController$AbstractExpandableItem$CharSet7 = SpellerController$AbstractExpandableItem$CharSet.createInstance(SpellerCharsetDefinitionEurope.getspecialBand(n), 0);
                arrayList.add(spellerController$AbstractExpandableItem$CharSet7);
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
        SpellerController$ButtonItem spellerController$ButtonItem = SpellerController$ButtonItem.createInstance(SpellerController$SpellerButtonType.getSpellerButtonType(4));
        arrayList.add(spellerController$ButtonItem);
        SpellerController$AbstractExpandableItem$CharSet spellerController$AbstractExpandableItem$CharSet = SpellerController$AbstractExpandableItem$CharSet.createInstance(SpellerCharsetDefinitionEurope.getsonderZeichenForWlanBand(n), 0);
        arrayList.add(spellerController$AbstractExpandableItem$CharSet);
        return arrayList;
    }

    public static List getTunertvBand(int n) {
        ArrayList arrayList = new ArrayList(30);
        switch (n) {
            case 26: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.getlatinExpandableAZ_arBand(n));
                arrayList.addAll(SpellerCharsetDefinitionEurope.getnumbersBand(n));
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand(".,", null, true));
                SpellerController$AbstractExpandableItem$CharSet spellerController$AbstractExpandableItem$CharSet = SpellerController$AbstractExpandableItem$CharSet.createInstance(SpellerCharsetDefinitionEurope.getumlauts_arabicBand(n), 2);
                arrayList.add(spellerController$AbstractExpandableItem$CharSet);
                SpellerController$AbstractExpandableItem$CharSet spellerController$AbstractExpandableItem$CharSet2 = SpellerController$AbstractExpandableItem$CharSet.createInstance(SpellerCharsetDefinitionEurope.getspecial_arBand(n), 0);
                arrayList.add(spellerController$AbstractExpandableItem$CharSet2);
                break;
            }
            case 7: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.getcyrillicBand(n));
                arrayList.addAll(SpellerCharsetDefinitionEurope.getnumbersBand(n));
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand(".,", null, true));
                SpellerController$ButtonItem spellerController$ButtonItem = SpellerController$ButtonItem.createInstance(SpellerController$SpellerButtonType.getSpellerButtonType(4));
                arrayList.add(spellerController$ButtonItem);
                SpellerController$AbstractExpandableItem$CharSet spellerController$AbstractExpandableItem$CharSet = SpellerController$AbstractExpandableItem$CharSet.createInstance(SpellerCharsetDefinitionEurope.getumlauts_cyrillicBand(n), 2);
                arrayList.add(spellerController$AbstractExpandableItem$CharSet);
                SpellerController$AbstractExpandableItem$CharSet spellerController$AbstractExpandableItem$CharSet3 = SpellerController$AbstractExpandableItem$CharSet.createInstance(SpellerCharsetDefinitionEurope.getspecialBand(n), 0);
                arrayList.add(spellerController$AbstractExpandableItem$CharSet3);
                break;
            }
            default: {
                arrayList.addAll(SpellerCharsetDefinitionEurope.getlatinExpandableAZBand(n));
                arrayList.addAll(SpellerCharsetDefinitionEurope.getnumbersBand(n));
                arrayList.addAll(SpellerCharsetDefinitionEurope.createCharacterBand(".,", null, true));
                SpellerController$ButtonItem spellerController$ButtonItem = SpellerController$ButtonItem.createInstance(SpellerController$SpellerButtonType.getSpellerButtonType(4));
                arrayList.add(spellerController$ButtonItem);
                SpellerController$AbstractExpandableItem$CharSet spellerController$AbstractExpandableItem$CharSet = SpellerController$AbstractExpandableItem$CharSet.createInstance(SpellerCharsetDefinitionEurope.getumlauts_latinBand(n), 2);
                arrayList.add(spellerController$AbstractExpandableItem$CharSet);
                SpellerController$AbstractExpandableItem$CharSet spellerController$AbstractExpandableItem$CharSet4 = SpellerController$AbstractExpandableItem$CharSet.createInstance(SpellerCharsetDefinitionEurope.getspecialBand(n), 0);
                arrayList.add(spellerController$AbstractExpandableItem$CharSet4);
            }
        }
        return arrayList;
    }

    public static List getVehicleCodeBand(int n) {
        ArrayList arrayList = new ArrayList(30);
        arrayList.addAll(SpellerCharsetDefinitionEurope.getlatinAZBand(n));
        SpellerController$AbstractExpandableItem$CharSet spellerController$AbstractExpandableItem$CharSet = SpellerController$AbstractExpandableItem$CharSet.createInstance(SpellerCharsetDefinitionEurope.getnumbersBand(n), 1);
        arrayList.add(spellerController$AbstractExpandableItem$CharSet);
        return arrayList;
    }
}

