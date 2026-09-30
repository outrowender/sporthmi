/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerCharsetDefinitionEurope;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.SpellerCharsetDefinitionAsia;
import java.util.ArrayList;
import java.util.List;

public class SpellerCharsetDefinition {
    protected static final int DE = 0;
    protected static final int EN = 1;
    protected static final int FR = 2;
    protected static final int ES = 3;
    protected static final int IT = 4;
    protected static final int CZ = 20;
    protected static final int NL = 6;
    protected static final int NO = 27;
    protected static final int PL = 18;
    protected static final int PT = 5;
    protected static final int SE = 19;
    protected static final int TR = 21;
    protected static final int HU = 28;
    protected static final int RU = 7;
    protected static final int AR = 26;
    protected static final int DK = 29;
    protected static final int FI = 30;
    protected static final int SI = 31;
    protected static final int RO = 33;
    protected static final int GR = 34;
    protected static final int MY = 35;
    protected static final int UA = 32;
    protected static final int PINYIN = 14;
    protected static final int STROKE = 23;
    protected static final int ZHUYIN = 24;
    protected static final int HIRAGANA = 12;
    protected static final int JAMO = 16;
    protected static final int KOREANENGLISH = 17;

    protected static List createCharacterBand(String string, String string2, boolean bl) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < string.length(); ++i2) {
            SpellerController.SingleCharItem singleCharItem = !bl && string2 != null ? SpellerController.SingleCharItem.createInstance(string.substring(i2, i2 + 1), string2.substring(i2, i2 + 1)) : SpellerController.SingleCharItem.createInstance(string.substring(i2, i2 + 1));
            arrayList.add(singleCharItem);
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
            SpellerController.ButtonItem buttonItem;
            Object object = list.get(i2);
            if (!(object instanceof SpellerController.ButtonItem) || (buttonItem = (SpellerController.ButtonItem)object).getButtonType() != SpellerController.SpellerButtonType.SHIFT) continue;
            buttonItem.setEnabled(false);
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

