/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerCharsetDefinitionEurope;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$ButtonItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$SingleCharItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$SpellerButtonType;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.SpellerCharsetDefinitionAsia;
import java.util.ArrayList;
import java.util.List;

public class SpellerCharsetDefinition {
    protected static final int DE;
    protected static final int EN;
    protected static final int FR;
    protected static final int ES;
    protected static final int IT;
    protected static final int CZ;
    protected static final int NL;
    protected static final int NO;
    protected static final int PL;
    protected static final int PT;
    protected static final int SE;
    protected static final int TR;
    protected static final int HU;
    protected static final int RU;
    protected static final int AR;
    protected static final int DK;
    protected static final int FI;
    protected static final int SI;
    protected static final int RO;
    protected static final int GR;
    protected static final int MY;
    protected static final int UA;
    protected static final int PINYIN;
    protected static final int STROKE;
    protected static final int ZHUYIN;
    protected static final int HIRAGANA;
    protected static final int JAMO;
    protected static final int KOREANENGLISH;

    protected static List createCharacterBand(String string, String string2, boolean bl) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < string.length(); ++i2) {
            SpellerController$SingleCharItem spellerController$SingleCharItem = !bl && string2 != null ? SpellerController$SingleCharItem.createInstance(string.substring(i2, i2 + 1), string2.substring(i2, i2 + 1)) : SpellerController$SingleCharItem.createInstance(string.substring(i2, i2 + 1));
            arrayList.add(spellerController$SingleCharItem);
        }
        return arrayList;
    }

    public static List initSpellerBand(int n, int n2) {
        int n3 = SpellerCharsetDefinition.mapLanguage(n2);
        switch (n) {
            case 10: {
                return SpellerCharsetDefinitionEurope.getFreetextBand(n3);
            }
            case 11: {
                List list = SpellerCharsetDefinitionEurope.getFreetextBand(n3);
                SpellerCharsetDefinition.findAndDisableShiftButton(list);
                return list;
            }
            case 0: {
                return SpellerCharsetDefinitionEurope.getFreetextBand(n3);
            }
            case 9: {
                List list = SpellerCharsetDefinitionEurope.getMatchHousenumberBand(n3);
                return list;
            }
            case 5: {
                return SpellerCharsetDefinitionEurope.getAdressingBand(n3);
            }
            case 4: {
                return SpellerCharsetDefinitionEurope.getMessagingBand(n3);
            }
            case 1: {
                return SpellerCharsetDefinitionEurope.getPhoneBand(n3);
            }
            case 8: {
                return SpellerCharsetDefinitionEurope.getCallListPhoneBand(n3);
            }
            case 2: 
            case 14: {
                return SpellerCharsetDefinitionEurope.getPinBand(n3);
            }
            case 3: {
                return SpellerCharsetDefinitionEurope.getDtmfBand(n3);
            }
            case 6: {
                return SpellerCharsetDefinitionEurope.getWlanBand(n3);
            }
            case 7: {
                return SpellerCharsetDefinitionEurope.getTunertvBand(n3);
            }
            case 15: {
                return SpellerCharsetDefinitionEurope.getAdressingBand(n3);
            }
            case 16: {
                return SpellerCharsetDefinitionEurope.getVehicleCodeBand(n3);
            }
        }
        return SpellerCharsetDefinitionEurope.getFreetextBand(n3);
    }

    private static int mapLanguage(int n) {
        if (n == 9 || n == 8 || n == 34 || n == 35) {
            return 1;
        }
        if (n == 11) {
            return 3;
        }
        if (n == 10) {
            return 2;
        }
        if (n == 32) {
            return 7;
        }
        return n;
    }

    private static void findAndDisableShiftButton(List list) {
        for (int i2 = 0; i2 < list.size(); ++i2) {
            SpellerController$ButtonItem spellerController$ButtonItem;
            Object object = list.get(i2);
            if (!(object instanceof SpellerController$ButtonItem) || (spellerController$ButtonItem = (SpellerController$ButtonItem)object).getButtonType() != SpellerController$SpellerButtonType.SHIFT) continue;
            spellerController$ButtonItem.setEnabled(false);
        }
    }

    public static List initSpellerBandAsia(int n, int n2) {
        switch (n) {
            case 0: 
            case 10: {
                return SpellerCharsetDefinitionAsia.getFreetextBand(n2);
            }
            case 11: {
                return SpellerCharsetDefinitionAsia.getMatchspellerBand(n2);
            }
            case 9: {
                return SpellerCharsetDefinitionAsia.getMatchHousenumberBand(n2);
            }
            case 5: {
                return SpellerCharsetDefinitionAsia.getAdressingBand(n2);
            }
            case 4: {
                return SpellerCharsetDefinitionAsia.getMessagingBand(n2);
            }
            case 1: 
            case 8: {
                return SpellerCharsetDefinitionAsia.getPhoneBand(n2);
            }
            case 12: {
                return SpellerCharsetDefinitionAsia.getPasswordBand(n2);
            }
            case 6: {
                return SpellerCharsetDefinitionAsia.getWlanBand(n2);
            }
            case 7: {
                return SpellerCharsetDefinitionAsia.getTunertvBand(n2);
            }
            case 13: {
                return SpellerCharsetDefinitionAsia.getMatchMapcodeBand(n2);
            }
            case 3: {
                return SpellerCharsetDefinitionEurope.getDtmfBand(n2);
            }
            case 2: 
            case 14: {
                return SpellerCharsetDefinitionEurope.getPinBand(n2);
            }
            case 15: {
                return SpellerCharsetDefinitionAsia.getAdressingBand(n2);
            }
            case 16: {
                return SpellerCharsetDefinitionEurope.getVehicleCodeBand(n2);
            }
        }
        return SpellerCharsetDefinitionAsia.getFreetextBand(n2);
    }
}

