/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.asia;

import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerCharsetDefinition;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$AbstractExpandableItem$Char;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$AbstractExpandableItem$CharSet;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$ButtonItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$SingleCharItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$SpellerButtonType;
import java.util.ArrayList;
import java.util.List;

public class SpellerCharsetDefinitionAsia
extends SpellerCharsetDefinition {
    private static List getZhuyinBand(int n) {
        ArrayList arrayList = new ArrayList(30);
        arrayList.addAll(SpellerCharsetDefinitionAsia.createCharacterBand("\u3105\u3106\u3107\u3108\u3109\u310a\u310b\u310c\u310d\u310e\u310f\u3110\u3111\u3112\u3113\u3114\u3115\u3116\u3117\u3118\u3119\u311a\u311b\u311c\u311d\u311e\u311f\u3120\u3121\u3122\u3123\u3124\u3125\u3126\u3127\u3128\u3129\u02ca\u02c7\u02cb\u02d9", null, true));
        return arrayList;
    }

    private static List getZeroFirstNumbersBand(int n) {
        ArrayList arrayList = new ArrayList(30);
        arrayList.addAll(SpellerCharsetDefinitionAsia.createCharacterBand("0123456789", null, true));
        return arrayList;
    }

    private static List getSpecialcharsBand(int n) {
        ArrayList arrayList = new ArrayList(30);
        arrayList.addAll(SpellerCharsetDefinitionAsia.createCharacterBand(",.\u3002?!\u3001\"\u2018\u2019:;()+-*/=_\u00a5$\u20ac&@#%<>\u300a\u300b[]{}~", null, true));
        return arrayList;
    }

    private static List getNumberSymbolBand(int n) {
        ArrayList arrayList = new ArrayList(30);
        SpellerController$AbstractExpandableItem$CharSet spellerController$AbstractExpandableItem$CharSet = SpellerController$AbstractExpandableItem$CharSet.createInstance(SpellerCharsetDefinitionAsia.getZeroFirstNumbersBand(n), 1);
        arrayList.add(spellerController$AbstractExpandableItem$CharSet);
        SpellerController$AbstractExpandableItem$CharSet spellerController$AbstractExpandableItem$CharSet2 = SpellerController$AbstractExpandableItem$CharSet.createInstance(SpellerCharsetDefinitionAsia.getSpecialcharsBand(n), 0);
        arrayList.add(spellerController$AbstractExpandableItem$CharSet2);
        return arrayList;
    }

    private static List getStrokeBand(int n) {
        ArrayList arrayList = new ArrayList(30);
        arrayList.addAll(SpellerCharsetDefinitionAsia.createCharacterBand("\u4e00\u4e28\u4e3f\u4e36\u4e59*", null, true));
        return arrayList;
    }

    private static List getHiddenHiragana01Band(int n) {
        ArrayList arrayList = new ArrayList(30);
        arrayList.addAll(SpellerCharsetDefinitionAsia.createCharacterBand("\u3044\u3046\u3048\u304a", null, true));
        return arrayList;
    }

    private static List getHiddenHiragana02Band(int n) {
        ArrayList arrayList = new ArrayList(30);
        arrayList.addAll(SpellerCharsetDefinitionAsia.createCharacterBand("\u304d\u304f\u3051\u3053", null, true));
        return arrayList;
    }

    private static List getHiddenHiragana03Band(int n) {
        ArrayList arrayList = new ArrayList(30);
        arrayList.addAll(SpellerCharsetDefinitionAsia.createCharacterBand("\u3057\u3059\u305b\u305d", null, true));
        return arrayList;
    }

    private static List getHiddenHiragana04Band(int n) {
        ArrayList arrayList = new ArrayList(30);
        arrayList.addAll(SpellerCharsetDefinitionAsia.createCharacterBand("\u3061\u3064\u3063\u3066\u3068", null, true));
        return arrayList;
    }

    private static List getHiddenHiragana05Band(int n) {
        ArrayList arrayList = new ArrayList(30);
        arrayList.addAll(SpellerCharsetDefinitionAsia.createCharacterBand("\u306b\u306c\u306d\u306e", null, true));
        return arrayList;
    }

    private static List getHiddenHiragana06Band(int n) {
        ArrayList arrayList = new ArrayList(30);
        arrayList.addAll(SpellerCharsetDefinitionAsia.createCharacterBand("\u3072\u3075\u3078\u307b", null, true));
        return arrayList;
    }

    private static List getHiddenHiragana07Band(int n) {
        ArrayList arrayList = new ArrayList(30);
        arrayList.addAll(SpellerCharsetDefinitionAsia.createCharacterBand("\u307f\u3080\u3081\u3082", null, true));
        return arrayList;
    }

    private static List getHiddenHiragana08Band(int n) {
        ArrayList arrayList = new ArrayList(30);
        arrayList.addAll(SpellerCharsetDefinitionAsia.createCharacterBand("\u3083\u3086\u3085\u3088\u3087", null, true));
        return arrayList;
    }

    private static List getHiddenHiragana09Band(int n) {
        ArrayList arrayList = new ArrayList(30);
        arrayList.addAll(SpellerCharsetDefinitionAsia.createCharacterBand("\u308a\u308b\u308c\u308d", null, true));
        return arrayList;
    }

    private static List getHiddenHiragana10Band(int n) {
        ArrayList arrayList = new ArrayList(30);
        arrayList.addAll(SpellerCharsetDefinitionAsia.createCharacterBand("\u3092\u3093", null, true));
        return arrayList;
    }

    private static List getHiddenHiragana11Band(int n) {
        ArrayList arrayList = new ArrayList(30);
        arrayList.addAll(SpellerCharsetDefinitionAsia.createCharacterBand("\u3043\u3045\u3047\u3049", null, true));
        return arrayList;
    }

    private static List getHiraganaBand(int n) {
        ArrayList arrayList = new ArrayList(30);
        SpellerController$AbstractExpandableItem$Char spellerController$AbstractExpandableItem$Char = SpellerController$AbstractExpandableItem$Char.createInstance(SpellerCharsetDefinitionAsia.getHiddenHiragana01Band(n), "\u3042");
        arrayList.add(spellerController$AbstractExpandableItem$Char);
        SpellerController$AbstractExpandableItem$Char spellerController$AbstractExpandableItem$Char2 = SpellerController$AbstractExpandableItem$Char.createInstance(SpellerCharsetDefinitionAsia.getHiddenHiragana02Band(n), "\u304b");
        arrayList.add(spellerController$AbstractExpandableItem$Char2);
        SpellerController$AbstractExpandableItem$Char spellerController$AbstractExpandableItem$Char3 = SpellerController$AbstractExpandableItem$Char.createInstance(SpellerCharsetDefinitionAsia.getHiddenHiragana03Band(n), "\u3055");
        arrayList.add(spellerController$AbstractExpandableItem$Char3);
        SpellerController$AbstractExpandableItem$Char spellerController$AbstractExpandableItem$Char4 = SpellerController$AbstractExpandableItem$Char.createInstance(SpellerCharsetDefinitionAsia.getHiddenHiragana04Band(n), "\u305f");
        arrayList.add(spellerController$AbstractExpandableItem$Char4);
        SpellerController$AbstractExpandableItem$Char spellerController$AbstractExpandableItem$Char5 = SpellerController$AbstractExpandableItem$Char.createInstance(SpellerCharsetDefinitionAsia.getHiddenHiragana05Band(n), "\u306a");
        arrayList.add(spellerController$AbstractExpandableItem$Char5);
        SpellerController$AbstractExpandableItem$Char spellerController$AbstractExpandableItem$Char6 = SpellerController$AbstractExpandableItem$Char.createInstance(SpellerCharsetDefinitionAsia.getHiddenHiragana06Band(n), "\u306f");
        arrayList.add(spellerController$AbstractExpandableItem$Char6);
        SpellerController$AbstractExpandableItem$Char spellerController$AbstractExpandableItem$Char7 = SpellerController$AbstractExpandableItem$Char.createInstance(SpellerCharsetDefinitionAsia.getHiddenHiragana07Band(n), "\u307e");
        arrayList.add(spellerController$AbstractExpandableItem$Char7);
        SpellerController$AbstractExpandableItem$Char spellerController$AbstractExpandableItem$Char8 = SpellerController$AbstractExpandableItem$Char.createInstance(SpellerCharsetDefinitionAsia.getHiddenHiragana08Band(n), "\u3084");
        arrayList.add(spellerController$AbstractExpandableItem$Char8);
        SpellerController$AbstractExpandableItem$Char spellerController$AbstractExpandableItem$Char9 = SpellerController$AbstractExpandableItem$Char.createInstance(SpellerCharsetDefinitionAsia.getHiddenHiragana09Band(n), "\u3089");
        arrayList.add(spellerController$AbstractExpandableItem$Char9);
        SpellerController$AbstractExpandableItem$Char spellerController$AbstractExpandableItem$Char10 = SpellerController$AbstractExpandableItem$Char.createInstance(SpellerCharsetDefinitionAsia.getHiddenHiragana10Band(n), "\u308f");
        arrayList.add(spellerController$AbstractExpandableItem$Char10);
        SpellerController$SingleCharItem spellerController$SingleCharItem = SpellerController$SingleCharItem.createInstance("\u30fc");
        arrayList.add(spellerController$SingleCharItem);
        SpellerController$AbstractExpandableItem$Char spellerController$AbstractExpandableItem$Char11 = SpellerController$AbstractExpandableItem$Char.createInstance(SpellerCharsetDefinitionAsia.getHiddenHiragana11Band(n), "\u3041");
        arrayList.add(spellerController$AbstractExpandableItem$Char11);
        return arrayList;
    }

    private static List getHiddenJamo01Band(int n) {
        ArrayList arrayList = new ArrayList(30);
        arrayList.addAll(SpellerCharsetDefinitionAsia.createCharacterBand("\u3132\u3133", null, true));
        return arrayList;
    }

    private static List getHiddenJamo02Band(int n) {
        ArrayList arrayList = new ArrayList(30);
        arrayList.addAll(SpellerCharsetDefinitionAsia.createCharacterBand("\u3135\u3136", null, true));
        return arrayList;
    }

    private static List getHiddenJamo03Band(int n) {
        ArrayList arrayList = new ArrayList(30);
        arrayList.addAll(SpellerCharsetDefinitionAsia.createCharacterBand("\u3138", null, true));
        return arrayList;
    }

    private static List getHiddenJamo04Band(int n) {
        ArrayList arrayList = new ArrayList(30);
        arrayList.addAll(SpellerCharsetDefinitionAsia.createCharacterBand("\u313a\u313b\u313c\u313d\u313e\u313f\u3140", null, true));
        return arrayList;
    }

    private static List getHiddenJamo05Band(int n) {
        ArrayList arrayList = new ArrayList(30);
        arrayList.addAll(SpellerCharsetDefinitionAsia.createCharacterBand("\u3143\u3144", null, true));
        return arrayList;
    }

    private static List getHiddenJamo06Band(int n) {
        ArrayList arrayList = new ArrayList(30);
        arrayList.addAll(SpellerCharsetDefinitionAsia.createCharacterBand("\u3146", null, true));
        return arrayList;
    }

    private static List getHiddenJamo07Band(int n) {
        ArrayList arrayList = new ArrayList(30);
        arrayList.addAll(SpellerCharsetDefinitionAsia.createCharacterBand("\u3149", null, true));
        return arrayList;
    }

    private static List getHiddenJamo08Band(int n) {
        ArrayList arrayList = new ArrayList(30);
        arrayList.addAll(SpellerCharsetDefinitionAsia.createCharacterBand("\u3158\u3159\u315a", null, true));
        return arrayList;
    }

    private static List getHiddenJamo09Band(int n) {
        ArrayList arrayList = new ArrayList(30);
        arrayList.addAll(SpellerCharsetDefinitionAsia.createCharacterBand("\u315d\u315e\u315f", null, true));
        return arrayList;
    }

    private static List getHiddenJamo10Band(int n) {
        ArrayList arrayList = new ArrayList(30);
        arrayList.addAll(SpellerCharsetDefinitionAsia.createCharacterBand("\u3162", null, true));
        return arrayList;
    }

    private static List getJamoBand(int n) {
        ArrayList arrayList = new ArrayList(30);
        SpellerController$AbstractExpandableItem$Char spellerController$AbstractExpandableItem$Char = SpellerController$AbstractExpandableItem$Char.createInstance(SpellerCharsetDefinitionAsia.getHiddenJamo01Band(n), "\u3131");
        arrayList.add(spellerController$AbstractExpandableItem$Char);
        SpellerController$AbstractExpandableItem$Char spellerController$AbstractExpandableItem$Char2 = SpellerController$AbstractExpandableItem$Char.createInstance(SpellerCharsetDefinitionAsia.getHiddenJamo02Band(n), "\u3134");
        arrayList.add(spellerController$AbstractExpandableItem$Char2);
        SpellerController$AbstractExpandableItem$Char spellerController$AbstractExpandableItem$Char3 = SpellerController$AbstractExpandableItem$Char.createInstance(SpellerCharsetDefinitionAsia.getHiddenJamo03Band(n), "\u3137");
        arrayList.add(spellerController$AbstractExpandableItem$Char3);
        SpellerController$AbstractExpandableItem$Char spellerController$AbstractExpandableItem$Char4 = SpellerController$AbstractExpandableItem$Char.createInstance(SpellerCharsetDefinitionAsia.getHiddenJamo04Band(n), "\u3139");
        arrayList.add(spellerController$AbstractExpandableItem$Char4);
        SpellerController$SingleCharItem spellerController$SingleCharItem = SpellerController$SingleCharItem.createInstance("\u3141");
        arrayList.add(spellerController$SingleCharItem);
        SpellerController$AbstractExpandableItem$Char spellerController$AbstractExpandableItem$Char5 = SpellerController$AbstractExpandableItem$Char.createInstance(SpellerCharsetDefinitionAsia.getHiddenJamo05Band(n), "\u3142");
        arrayList.add(spellerController$AbstractExpandableItem$Char5);
        SpellerController$AbstractExpandableItem$Char spellerController$AbstractExpandableItem$Char6 = SpellerController$AbstractExpandableItem$Char.createInstance(SpellerCharsetDefinitionAsia.getHiddenJamo06Band(n), "\u3145");
        arrayList.add(spellerController$AbstractExpandableItem$Char6);
        SpellerController$SingleCharItem spellerController$SingleCharItem2 = SpellerController$SingleCharItem.createInstance("\u3147");
        arrayList.add(spellerController$SingleCharItem2);
        SpellerController$AbstractExpandableItem$Char spellerController$AbstractExpandableItem$Char7 = SpellerController$AbstractExpandableItem$Char.createInstance(SpellerCharsetDefinitionAsia.getHiddenJamo07Band(n), "\u3148");
        arrayList.add(spellerController$AbstractExpandableItem$Char7);
        SpellerController$SingleCharItem spellerController$SingleCharItem3 = SpellerController$SingleCharItem.createInstance("\u314a");
        arrayList.add(spellerController$SingleCharItem3);
        SpellerController$SingleCharItem spellerController$SingleCharItem4 = SpellerController$SingleCharItem.createInstance("\u314b");
        arrayList.add(spellerController$SingleCharItem4);
        SpellerController$SingleCharItem spellerController$SingleCharItem5 = SpellerController$SingleCharItem.createInstance("\u314c");
        arrayList.add(spellerController$SingleCharItem5);
        SpellerController$SingleCharItem spellerController$SingleCharItem6 = SpellerController$SingleCharItem.createInstance("\u314d");
        arrayList.add(spellerController$SingleCharItem6);
        SpellerController$SingleCharItem spellerController$SingleCharItem7 = SpellerController$SingleCharItem.createInstance("\u314e");
        arrayList.add(spellerController$SingleCharItem7);
        SpellerController$SingleCharItem spellerController$SingleCharItem8 = SpellerController$SingleCharItem.createInstance("\u314f");
        arrayList.add(spellerController$SingleCharItem8);
        SpellerController$SingleCharItem spellerController$SingleCharItem9 = SpellerController$SingleCharItem.createInstance("\u3151");
        arrayList.add(spellerController$SingleCharItem9);
        SpellerController$SingleCharItem spellerController$SingleCharItem10 = SpellerController$SingleCharItem.createInstance("\u3153");
        arrayList.add(spellerController$SingleCharItem10);
        SpellerController$SingleCharItem spellerController$SingleCharItem11 = SpellerController$SingleCharItem.createInstance("\u3155");
        arrayList.add(spellerController$SingleCharItem11);
        SpellerController$AbstractExpandableItem$Char spellerController$AbstractExpandableItem$Char8 = SpellerController$AbstractExpandableItem$Char.createInstance(SpellerCharsetDefinitionAsia.getHiddenJamo08Band(n), "\u3157");
        arrayList.add(spellerController$AbstractExpandableItem$Char8);
        SpellerController$SingleCharItem spellerController$SingleCharItem12 = SpellerController$SingleCharItem.createInstance("\u315b");
        arrayList.add(spellerController$SingleCharItem12);
        SpellerController$AbstractExpandableItem$Char spellerController$AbstractExpandableItem$Char9 = SpellerController$AbstractExpandableItem$Char.createInstance(SpellerCharsetDefinitionAsia.getHiddenJamo09Band(n), "\u315c");
        arrayList.add(spellerController$AbstractExpandableItem$Char9);
        SpellerController$SingleCharItem spellerController$SingleCharItem13 = SpellerController$SingleCharItem.createInstance("\u3160");
        arrayList.add(spellerController$SingleCharItem13);
        SpellerController$AbstractExpandableItem$Char spellerController$AbstractExpandableItem$Char10 = SpellerController$AbstractExpandableItem$Char.createInstance(SpellerCharsetDefinitionAsia.getHiddenJamo10Band(n), "\u3161");
        arrayList.add(spellerController$AbstractExpandableItem$Char10);
        SpellerController$SingleCharItem spellerController$SingleCharItem14 = SpellerController$SingleCharItem.createInstance("\u3163");
        arrayList.add(spellerController$SingleCharItem14);
        SpellerController$SingleCharItem spellerController$SingleCharItem15 = SpellerController$SingleCharItem.createInstance("\u3150");
        arrayList.add(spellerController$SingleCharItem15);
        SpellerController$SingleCharItem spellerController$SingleCharItem16 = SpellerController$SingleCharItem.createInstance("\u3152");
        arrayList.add(spellerController$SingleCharItem16);
        SpellerController$SingleCharItem spellerController$SingleCharItem17 = SpellerController$SingleCharItem.createInstance("\u3154");
        arrayList.add(spellerController$SingleCharItem17);
        SpellerController$SingleCharItem spellerController$SingleCharItem18 = SpellerController$SingleCharItem.createInstance("\u3156");
        arrayList.add(spellerController$SingleCharItem18);
        return arrayList;
    }

    private static List getLatinazBand(int n) {
        ArrayList arrayList = new ArrayList(30);
        arrayList.addAll(SpellerCharsetDefinitionAsia.createCharacterBand("abcdefghijklmnopqrstuvwxyz", "abcdefghijklmnopqrstuvwxyz", false));
        return arrayList;
    }

    private static List getLatinAaZzBand(int n) {
        ArrayList arrayList = new ArrayList(30);
        arrayList.addAll(SpellerCharsetDefinitionAsia.createCharacterBand("ABCDEFGHIJKLMNOPQRSTUVWXYZ", "abcdefghijklmnopqrstuvwxyz", false));
        return arrayList;
    }

    private static List getSpaceShiftNumbersSymbolsBand(int n) {
        ArrayList arrayList = new ArrayList(30);
        SpellerController$SingleCharItem spellerController$SingleCharItem = SpellerController$SingleCharItem.createInstance(" ");
        arrayList.add(spellerController$SingleCharItem);
        SpellerController$ButtonItem spellerController$ButtonItem = SpellerController$ButtonItem.createInstance(SpellerController$SpellerButtonType.getSpellerButtonType(4));
        arrayList.add(spellerController$ButtonItem);
        SpellerController$AbstractExpandableItem$CharSet spellerController$AbstractExpandableItem$CharSet = SpellerController$AbstractExpandableItem$CharSet.createInstance(SpellerCharsetDefinitionAsia.getZeroFirstNumbersBand(n), 1);
        arrayList.add(spellerController$AbstractExpandableItem$CharSet);
        SpellerController$AbstractExpandableItem$CharSet spellerController$AbstractExpandableItem$CharSet2 = SpellerController$AbstractExpandableItem$CharSet.createInstance(SpellerCharsetDefinitionAsia.getSpecialcharsBand(n), 0);
        arrayList.add(spellerController$AbstractExpandableItem$CharSet2);
        return arrayList;
    }

    private static List getFreetext_zhuyinBand(int n) {
        ArrayList arrayList = new ArrayList(30);
        arrayList.addAll(SpellerCharsetDefinitionAsia.getZhuyinBand(n));
        SpellerController$SingleCharItem spellerController$SingleCharItem = SpellerController$SingleCharItem.createInstance(" ");
        arrayList.add(spellerController$SingleCharItem);
        arrayList.addAll(SpellerCharsetDefinitionAsia.getNumberSymbolBand(n));
        return arrayList;
    }

    private static List getFreetext_strokeBand(int n) {
        ArrayList arrayList = new ArrayList(30);
        arrayList.addAll(SpellerCharsetDefinitionAsia.getStrokeBand(n));
        SpellerController$SingleCharItem spellerController$SingleCharItem = SpellerController$SingleCharItem.createInstance(" ");
        arrayList.add(spellerController$SingleCharItem);
        arrayList.addAll(SpellerCharsetDefinitionAsia.getNumberSymbolBand(n));
        return arrayList;
    }

    private static List getFreetext_jamoBand(int n) {
        ArrayList arrayList = new ArrayList(30);
        arrayList.addAll(SpellerCharsetDefinitionAsia.getJamoBand(n));
        SpellerController$SingleCharItem spellerController$SingleCharItem = SpellerController$SingleCharItem.createInstance(" ");
        arrayList.add(spellerController$SingleCharItem);
        arrayList.addAll(SpellerCharsetDefinitionAsia.getNumberSymbolBand(n));
        return arrayList;
    }

    private static List getFreetext_hiraganaBand(int n) {
        ArrayList arrayList = new ArrayList(30);
        SpellerController$ButtonItem spellerController$ButtonItem = SpellerController$ButtonItem.createInstance(SpellerController$SpellerButtonType.getSpellerButtonType(18));
        arrayList.add(spellerController$ButtonItem);
        arrayList.addAll(SpellerCharsetDefinitionAsia.getHiraganaBand(n));
        SpellerController$SingleCharItem spellerController$SingleCharItem = SpellerController$SingleCharItem.createInstance(" ");
        arrayList.add(spellerController$SingleCharItem);
        arrayList.addAll(SpellerCharsetDefinitionAsia.getNumberSymbolBand(n));
        return arrayList;
    }

    private static List getLatinAZBand(int n) {
        ArrayList arrayList = new ArrayList(30);
        arrayList.addAll(SpellerCharsetDefinitionAsia.createCharacterBand("ABCDEFGHIJKLMNOPQRSTUVWXYZ", "ABCDEFGHIJKLMNOPQRSTUVWXYZ", false));
        return arrayList;
    }

    private static List getOneFirstNumbersBand(int n) {
        ArrayList arrayList = new ArrayList(30);
        arrayList.addAll(SpellerCharsetDefinitionAsia.createCharacterBand("1234567890", null, true));
        return arrayList;
    }

    private static List getPunctuationBand(int n) {
        ArrayList arrayList = new ArrayList(30);
        arrayList.addAll(SpellerCharsetDefinitionAsia.createCharacterBand(".,'?!-", null, true));
        return arrayList;
    }

    private static List getEmoticonsBand(int n) {
        ArrayList arrayList = new ArrayList(30);
        SpellerController$SingleCharItem spellerController$SingleCharItem = SpellerController$SingleCharItem.createInstance(":-D", ":-D");
        arrayList.add(spellerController$SingleCharItem);
        SpellerController$SingleCharItem spellerController$SingleCharItem2 = SpellerController$SingleCharItem.createInstance(";-)", ";-)");
        arrayList.add(spellerController$SingleCharItem2);
        SpellerController$SingleCharItem spellerController$SingleCharItem3 = SpellerController$SingleCharItem.createInstance(":-(", ":-(");
        arrayList.add(spellerController$SingleCharItem3);
        return arrayList;
    }

    private static List getNotFullWidthSpecialcharsBand(int n) {
        ArrayList arrayList = new ArrayList(30);
        arrayList.addAll(SpellerCharsetDefinitionAsia.createCharacterBand(",.?!\"\u2018\u2019:;()+-*/=_\u00a5$\u20ac&@#%<>[]{}~", null, true));
        return arrayList;
    }

    public static List getFreetextBand(int n) {
        ArrayList arrayList = new ArrayList(30);
        switch (n) {
            case 24: {
                arrayList.addAll(SpellerCharsetDefinitionAsia.getZhuyinBand(n));
                SpellerController$SingleCharItem spellerController$SingleCharItem = SpellerController$SingleCharItem.createInstance(" ");
                arrayList.add(spellerController$SingleCharItem);
                arrayList.addAll(SpellerCharsetDefinitionAsia.getNumberSymbolBand(n));
                break;
            }
            case 23: {
                arrayList.addAll(SpellerCharsetDefinitionAsia.getStrokeBand(n));
                SpellerController$SingleCharItem spellerController$SingleCharItem = SpellerController$SingleCharItem.createInstance(" ");
                arrayList.add(spellerController$SingleCharItem);
                arrayList.addAll(SpellerCharsetDefinitionAsia.getNumberSymbolBand(n));
                break;
            }
            case 12: {
                SpellerController$ButtonItem spellerController$ButtonItem = SpellerController$ButtonItem.createInstance(SpellerController$SpellerButtonType.getSpellerButtonType(18));
                arrayList.add(spellerController$ButtonItem);
                arrayList.addAll(SpellerCharsetDefinitionAsia.getHiraganaBand(n));
                SpellerController$SingleCharItem spellerController$SingleCharItem = SpellerController$SingleCharItem.createInstance(" ");
                arrayList.add(spellerController$SingleCharItem);
                arrayList.addAll(SpellerCharsetDefinitionAsia.getNumberSymbolBand(n));
                break;
            }
            case 16: {
                arrayList.addAll(SpellerCharsetDefinitionAsia.getJamoBand(n));
                SpellerController$SingleCharItem spellerController$SingleCharItem = SpellerController$SingleCharItem.createInstance(" ");
                arrayList.add(spellerController$SingleCharItem);
                arrayList.addAll(SpellerCharsetDefinitionAsia.getNumberSymbolBand(n));
                break;
            }
            case 14: {
                arrayList.addAll(SpellerCharsetDefinitionAsia.getLatinazBand(n));
                SpellerController$SingleCharItem spellerController$SingleCharItem = SpellerController$SingleCharItem.createInstance(" ");
                arrayList.add(spellerController$SingleCharItem);
                arrayList.addAll(SpellerCharsetDefinitionAsia.getNumberSymbolBand(n));
                break;
            }
            default: {
                arrayList.addAll(SpellerCharsetDefinitionAsia.getLatinAaZzBand(n));
                arrayList.addAll(SpellerCharsetDefinitionAsia.getSpaceShiftNumbersSymbolsBand(n));
            }
        }
        return arrayList;
    }

    public static List getMatchspellerBand(int n) {
        ArrayList arrayList = new ArrayList(30);
        switch (n) {
            case 24: {
                arrayList.addAll(SpellerCharsetDefinitionAsia.getFreetext_zhuyinBand(n));
                break;
            }
            case 23: {
                arrayList.addAll(SpellerCharsetDefinitionAsia.getFreetext_strokeBand(n));
                break;
            }
            case 16: {
                arrayList.addAll(SpellerCharsetDefinitionAsia.getFreetext_jamoBand(n));
                break;
            }
            case 12: {
                arrayList.addAll(SpellerCharsetDefinitionAsia.getFreetext_hiraganaBand(n));
                break;
            }
            case 14: {
                arrayList.addAll(SpellerCharsetDefinitionAsia.getLatinAZBand(n));
                SpellerController$SingleCharItem spellerController$SingleCharItem = SpellerController$SingleCharItem.createInstance(" ");
                arrayList.add(spellerController$SingleCharItem);
                arrayList.addAll(SpellerCharsetDefinitionAsia.getNumberSymbolBand(n));
                break;
            }
            default: {
                arrayList.addAll(SpellerCharsetDefinitionAsia.getLatinAZBand(n));
                SpellerController$SingleCharItem spellerController$SingleCharItem = SpellerController$SingleCharItem.createInstance(" ");
                arrayList.add(spellerController$SingleCharItem);
                arrayList.addAll(SpellerCharsetDefinitionAsia.getNumberSymbolBand(n));
            }
        }
        return arrayList;
    }

    public static List getMatchMapcodeBand(int n) {
        ArrayList arrayList = new ArrayList(30);
        arrayList.addAll(SpellerCharsetDefinitionAsia.getZeroFirstNumbersBand(n));
        SpellerController$SingleCharItem spellerController$SingleCharItem = SpellerController$SingleCharItem.createInstance("*");
        arrayList.add(spellerController$SingleCharItem);
        return arrayList;
    }

    public static List getMatchHousenumberBand(int n) {
        ArrayList arrayList = new ArrayList(30);
        switch (n) {
            case 16: {
                arrayList.addAll(SpellerCharsetDefinitionAsia.getOneFirstNumbersBand(n));
                SpellerController$SingleCharItem spellerController$SingleCharItem = SpellerController$SingleCharItem.createInstance("-");
                arrayList.add(spellerController$SingleCharItem);
                SpellerController$SingleCharItem spellerController$SingleCharItem2 = SpellerController$SingleCharItem.createInstance("\uc0b0");
                arrayList.add(spellerController$SingleCharItem2);
                break;
            }
            case 17: {
                arrayList.addAll(SpellerCharsetDefinitionAsia.getOneFirstNumbersBand(n));
                SpellerController$SingleCharItem spellerController$SingleCharItem = SpellerController$SingleCharItem.createInstance("-");
                arrayList.add(spellerController$SingleCharItem);
                SpellerController$SingleCharItem spellerController$SingleCharItem3 = SpellerController$SingleCharItem.createInstance("\uc0b0");
                arrayList.add(spellerController$SingleCharItem3);
                break;
            }
            default: {
                arrayList.addAll(SpellerCharsetDefinitionAsia.getOneFirstNumbersBand(n));
                SpellerController$SingleCharItem spellerController$SingleCharItem = SpellerController$SingleCharItem.createInstance("-");
                arrayList.add(spellerController$SingleCharItem);
            }
        }
        return arrayList;
    }

    public static List getMessagingBand(int n) {
        ArrayList arrayList = new ArrayList(30);
        switch (n) {
            case 24: {
                arrayList.addAll(SpellerCharsetDefinitionAsia.getZhuyinBand(n));
                SpellerController$SingleCharItem spellerController$SingleCharItem = SpellerController$SingleCharItem.createInstance(" ");
                arrayList.add(spellerController$SingleCharItem);
                arrayList.addAll(SpellerCharsetDefinitionAsia.getPunctuationBand(n));
                SpellerController$AbstractExpandableItem$Char spellerController$AbstractExpandableItem$Char = SpellerController$AbstractExpandableItem$Char.createInstance(SpellerCharsetDefinitionAsia.getEmoticonsBand(n), ":-)");
                arrayList.add(spellerController$AbstractExpandableItem$Char);
                arrayList.addAll(SpellerCharsetDefinitionAsia.getNumberSymbolBand(n));
                break;
            }
            case 23: {
                arrayList.addAll(SpellerCharsetDefinitionAsia.getStrokeBand(n));
                SpellerController$SingleCharItem spellerController$SingleCharItem = SpellerController$SingleCharItem.createInstance(" ");
                arrayList.add(spellerController$SingleCharItem);
                arrayList.addAll(SpellerCharsetDefinitionAsia.getPunctuationBand(n));
                SpellerController$AbstractExpandableItem$Char spellerController$AbstractExpandableItem$Char = SpellerController$AbstractExpandableItem$Char.createInstance(SpellerCharsetDefinitionAsia.getEmoticonsBand(n), ":-)");
                arrayList.add(spellerController$AbstractExpandableItem$Char);
                arrayList.addAll(SpellerCharsetDefinitionAsia.getNumberSymbolBand(n));
                break;
            }
            case 12: {
                SpellerController$ButtonItem spellerController$ButtonItem = SpellerController$ButtonItem.createInstance(SpellerController$SpellerButtonType.getSpellerButtonType(18));
                arrayList.add(spellerController$ButtonItem);
                arrayList.addAll(SpellerCharsetDefinitionAsia.getHiraganaBand(n));
                SpellerController$SingleCharItem spellerController$SingleCharItem = SpellerController$SingleCharItem.createInstance(" ");
                arrayList.add(spellerController$SingleCharItem);
                arrayList.addAll(SpellerCharsetDefinitionAsia.getPunctuationBand(n));
                SpellerController$AbstractExpandableItem$Char spellerController$AbstractExpandableItem$Char = SpellerController$AbstractExpandableItem$Char.createInstance(SpellerCharsetDefinitionAsia.getEmoticonsBand(n), ":-)");
                arrayList.add(spellerController$AbstractExpandableItem$Char);
                arrayList.addAll(SpellerCharsetDefinitionAsia.getNumberSymbolBand(n));
                break;
            }
            case 16: {
                arrayList.addAll(SpellerCharsetDefinitionAsia.getJamoBand(n));
                SpellerController$SingleCharItem spellerController$SingleCharItem = SpellerController$SingleCharItem.createInstance(" ");
                arrayList.add(spellerController$SingleCharItem);
                arrayList.addAll(SpellerCharsetDefinitionAsia.getPunctuationBand(n));
                SpellerController$AbstractExpandableItem$Char spellerController$AbstractExpandableItem$Char = SpellerController$AbstractExpandableItem$Char.createInstance(SpellerCharsetDefinitionAsia.getEmoticonsBand(n), ":-)");
                arrayList.add(spellerController$AbstractExpandableItem$Char);
                arrayList.addAll(SpellerCharsetDefinitionAsia.getNumberSymbolBand(n));
                break;
            }
            case 14: {
                arrayList.addAll(SpellerCharsetDefinitionAsia.getLatinazBand(n));
                SpellerController$SingleCharItem spellerController$SingleCharItem = SpellerController$SingleCharItem.createInstance(" ");
                arrayList.add(spellerController$SingleCharItem);
                arrayList.addAll(SpellerCharsetDefinitionAsia.getPunctuationBand(n));
                SpellerController$AbstractExpandableItem$Char spellerController$AbstractExpandableItem$Char = SpellerController$AbstractExpandableItem$Char.createInstance(SpellerCharsetDefinitionAsia.getEmoticonsBand(n), ":-)");
                arrayList.add(spellerController$AbstractExpandableItem$Char);
                arrayList.addAll(SpellerCharsetDefinitionAsia.getNumberSymbolBand(n));
                break;
            }
            default: {
                arrayList.addAll(SpellerCharsetDefinitionAsia.getLatinAaZzBand(n));
                SpellerController$SingleCharItem spellerController$SingleCharItem = SpellerController$SingleCharItem.createInstance(" ");
                arrayList.add(spellerController$SingleCharItem);
                arrayList.addAll(SpellerCharsetDefinitionAsia.getPunctuationBand(n));
                SpellerController$AbstractExpandableItem$Char spellerController$AbstractExpandableItem$Char = SpellerController$AbstractExpandableItem$Char.createInstance(SpellerCharsetDefinitionAsia.getEmoticonsBand(n), ":-)");
                arrayList.add(spellerController$AbstractExpandableItem$Char);
                SpellerController$ButtonItem spellerController$ButtonItem = SpellerController$ButtonItem.createInstance(SpellerController$SpellerButtonType.getSpellerButtonType(4));
                arrayList.add(spellerController$ButtonItem);
                arrayList.addAll(SpellerCharsetDefinitionAsia.getNumberSymbolBand(n));
            }
        }
        return arrayList;
    }

    public static List getAdressingBand(int n) {
        ArrayList arrayList = new ArrayList(30);
        arrayList.addAll(SpellerCharsetDefinitionAsia.getLatinAaZzBand(n));
        SpellerController$SingleCharItem spellerController$SingleCharItem = SpellerController$SingleCharItem.createInstance(".");
        arrayList.add(spellerController$SingleCharItem);
        SpellerController$SingleCharItem spellerController$SingleCharItem2 = SpellerController$SingleCharItem.createInstance("@");
        arrayList.add(spellerController$SingleCharItem2);
        SpellerController$SingleCharItem spellerController$SingleCharItem3 = SpellerController$SingleCharItem.createInstance(".com");
        arrayList.add(spellerController$SingleCharItem3);
        SpellerController$SingleCharItem spellerController$SingleCharItem4 = SpellerController$SingleCharItem.createInstance("-");
        arrayList.add(spellerController$SingleCharItem4);
        SpellerController$SingleCharItem spellerController$SingleCharItem5 = SpellerController$SingleCharItem.createInstance("?");
        arrayList.add(spellerController$SingleCharItem5);
        SpellerController$SingleCharItem spellerController$SingleCharItem6 = SpellerController$SingleCharItem.createInstance("!");
        arrayList.add(spellerController$SingleCharItem6);
        SpellerController$ButtonItem spellerController$ButtonItem = SpellerController$ButtonItem.createInstance(SpellerController$SpellerButtonType.getSpellerButtonType(4));
        arrayList.add(spellerController$ButtonItem);
        arrayList.addAll(SpellerCharsetDefinitionAsia.getNumberSymbolBand(n));
        return arrayList;
    }

    public static List getPhoneBand(int n) {
        ArrayList arrayList = new ArrayList(30);
        SpellerController$SingleCharItem spellerController$SingleCharItem = SpellerController$SingleCharItem.createInstance("+");
        arrayList.add(spellerController$SingleCharItem);
        arrayList.addAll(SpellerCharsetDefinitionAsia.getZeroFirstNumbersBand(n));
        SpellerController$SingleCharItem spellerController$SingleCharItem2 = SpellerController$SingleCharItem.createInstance("*");
        arrayList.add(spellerController$SingleCharItem2);
        SpellerController$SingleCharItem spellerController$SingleCharItem3 = SpellerController$SingleCharItem.createInstance("#");
        arrayList.add(spellerController$SingleCharItem3);
        return arrayList;
    }

    public static List getWlanBand(int n) {
        ArrayList arrayList = new ArrayList(30);
        arrayList.addAll(SpellerCharsetDefinitionAsia.getLatinAaZzBand(n));
        arrayList.addAll(SpellerCharsetDefinitionAsia.getZeroFirstNumbersBand(n));
        SpellerController$ButtonItem spellerController$ButtonItem = SpellerController$ButtonItem.createInstance(SpellerController$SpellerButtonType.getSpellerButtonType(4));
        arrayList.add(spellerController$ButtonItem);
        SpellerController$AbstractExpandableItem$CharSet spellerController$AbstractExpandableItem$CharSet = SpellerController$AbstractExpandableItem$CharSet.createInstance(SpellerCharsetDefinitionAsia.getNotFullWidthSpecialcharsBand(n), 0);
        arrayList.add(spellerController$AbstractExpandableItem$CharSet);
        return arrayList;
    }

    public static List getTunertvBand(int n) {
        ArrayList arrayList = new ArrayList(30);
        arrayList.addAll(SpellerCharsetDefinitionAsia.getLatinAaZzBand(n));
        arrayList.addAll(SpellerCharsetDefinitionAsia.getZeroFirstNumbersBand(n));
        SpellerController$SingleCharItem spellerController$SingleCharItem = SpellerController$SingleCharItem.createInstance(".");
        arrayList.add(spellerController$SingleCharItem);
        SpellerController$SingleCharItem spellerController$SingleCharItem2 = SpellerController$SingleCharItem.createInstance(",");
        arrayList.add(spellerController$SingleCharItem2);
        SpellerController$ButtonItem spellerController$ButtonItem = SpellerController$ButtonItem.createInstance(SpellerController$SpellerButtonType.getSpellerButtonType(4));
        arrayList.add(spellerController$ButtonItem);
        SpellerController$AbstractExpandableItem$CharSet spellerController$AbstractExpandableItem$CharSet = SpellerController$AbstractExpandableItem$CharSet.createInstance(SpellerCharsetDefinitionAsia.getSpecialcharsBand(n), 0);
        arrayList.add(spellerController$AbstractExpandableItem$CharSet);
        return arrayList;
    }

    public static List getDtmfBand(int n) {
        ArrayList arrayList = new ArrayList(30);
        arrayList.addAll(SpellerCharsetDefinitionAsia.getZeroFirstNumbersBand(n));
        SpellerController$SingleCharItem spellerController$SingleCharItem = SpellerController$SingleCharItem.createInstance("*");
        arrayList.add(spellerController$SingleCharItem);
        SpellerController$SingleCharItem spellerController$SingleCharItem2 = SpellerController$SingleCharItem.createInstance("#");
        arrayList.add(spellerController$SingleCharItem2);
        return arrayList;
    }

    public static List getPasswordBand(int n) {
        ArrayList arrayList = new ArrayList(30);
        arrayList.addAll(SpellerCharsetDefinitionAsia.getLatinAaZzBand(n));
        arrayList.addAll(SpellerCharsetDefinitionAsia.getZeroFirstNumbersBand(n));
        SpellerController$SingleCharItem spellerController$SingleCharItem = SpellerController$SingleCharItem.createInstance(" ");
        arrayList.add(spellerController$SingleCharItem);
        SpellerController$ButtonItem spellerController$ButtonItem = SpellerController$ButtonItem.createInstance(SpellerController$SpellerButtonType.getSpellerButtonType(4));
        arrayList.add(spellerController$ButtonItem);
        SpellerController$AbstractExpandableItem$CharSet spellerController$AbstractExpandableItem$CharSet = SpellerController$AbstractExpandableItem$CharSet.createInstance(SpellerCharsetDefinitionAsia.getNotFullWidthSpecialcharsBand(n), 0);
        arrayList.add(spellerController$AbstractExpandableItem$CharSet);
        return arrayList;
    }
}

