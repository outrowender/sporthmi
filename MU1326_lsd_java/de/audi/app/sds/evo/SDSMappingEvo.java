/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sds.evo;

import de.audi.app.sds.evo.EventMapperEvo;
import de.audi.app.sds.evo.PopupMapperEvo;
import de.audi.app.sdsmanager.common.ISDSMapping;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.atip.log.LogChannel;
import de.audi.atip.sds.HMISlotGrammars;
import de.audi.atip.sds.RuleEventMapping;
import de.audi.atip.sds.SUIGrammars;
import de.audi.atip.sds.SlotGrammars;

public class SDSMappingEvo
implements ISDSMapping {
    private static final int[][] grammarMappingToHMISlotGrammar = new int[][]{{54, HMISlotGrammars.MEDIA_DYNAMIC_DEVICE}, {11, HMISlotGrammars.MEDIA_ONESHOT_ALBUMS}, {13, HMISlotGrammars.MEDIA_ONESHOT_ARTISTS}, {12, HMISlotGrammars.MEDIA_ONESHOT_TITLES}, {22, HMISlotGrammars.SPEECH_NAVI_FAVORITES_DYNAMIC}, {21, HMISlotGrammars.SPEECH_NAVI_LAST_DESTINATIONS_DYNAMIC}, {23, HMISlotGrammars.SPEECH_NAVI_MY_AUDI_CONTACTS_DYNAMIC}, {41, HMISlotGrammars.ONLINE_REMOTEHMI}, {42, HMISlotGrammars.ONLINE_REMOTEHMI_GLOBAL}, {43, HMISlotGrammars.ONLINE_REMOTEHMI_HELP}, {31, HMISlotGrammars.SPEECH_PHONE_CALLSTACKS_DYNAMIC}, {32, HMISlotGrammars.SPEECH_PHONE_FAVORITES_DYNAMIC}, {2, HMISlotGrammars.SPEECH_INPUT_ROWNUMBER1_6}, {3, HMISlotGrammars.SPEECH_INPUT_SDCARDNUMBER1_2}, {51, HMISlotGrammars.SPEECH_TUNER_DABENSEMBLELIST_DYNAMIC}, {53, HMISlotGrammars.SPEECH_TUNER_GENRELIST_DYNAMIC}, {52, HMISlotGrammars.SPEECH_TUNER_STATION_DYNAMIC}, {33, HMISlotGrammars.SPEECH_INPUT_MAILADDRESS}, {56, HMISlotGrammars.NAVIGATION_SPEECH_KRSIMPLEMAPS_DYNAMIC}};
    private static final int[][] slotTypeMappingToSlotType = new int[][]{{3, 1}, {2, 2}, {1, 0}, {4, 3}};
    private static final int[][] suiTypeToMappingType = new int[][]{{2, 1}, {4, 2}, {-1, 0}, {3, 3}, {1, 4}};
    private static final int[][] truffleTypeToMappingType = new int[][]{{-1, 0}, {0, 1}};
    private static final int[][] modelIDtoMappingID = new int[][]{{-2003434496, 1}, {-1297085952, 10}, {-1280308736, 11}, {1873807872, 12}, {1840253440, 13}, {1857030656, 14}, {4137, 20}, {4141, 22}, {4143, 21}, {4142, 23}, {4145, 24}, {-1642257664, 25}, {-1541470720, 26}, {5578, 28}, {4595, 29}, {5573, 31}, {5620, 32}, {5621, 33}, {5623, 34}};
    private static int[][] remoteHMI2LineNumber = new int[][]{{2360, 0}, {2361, 1}, {2363, 10}, {2364, 11}, {2365, 12}, {2366, 13}, {2367, 14}, {2368, 15}, {2369, 16}, {2370, 17}, {2371, 18}, {2372, 19}, {2362, 2}, {2373, 20}, {2374, 21}, {2375, 22}, {2376, 23}, {2377, 3}, {2378, 4}, {2379, 5}, {2380, 6}, {2381, 7}, {2382, 8}, {2383, 9}};
    private static int[][] screenMappingToScreenID = new int[][]{{1, 100}, {2, -283507200}, {39, 1411057152}, {3, 227804160}, {4, 1955857408}, {7, 1924008448}, {8, -1894119936}, {5, 1746412288}, {6, 1779966720}, {11, -1743248640}, {12, -1709694208}, {9, -1474813184}, {10, -1458035968}, {14, 791152896}, {15, -1559428352}, {16, -1576205568}, {17, -1542651136}, {18, -1525873920}, {19, -1509096704}, {20, 563224832}, {21, -954595840}, {22, -904264192}, {23, -887486976}, {24, -870709760}, {25, -736492032}, {26, -1843911936}, {27, -1810357504}, {28, 311690240}, {29, 294913024}, {30, 328467456}, {31, 278135808}, {32, 362021888}, {33, 378799104}, {34, -192544512}, {35, -175767296}, {36, -158990080}, {37, -142212864}, {38, 55}, {40, -669383168}, {41, -1323694592}, {42, -175038208}, {43, -225369856}, {13, 57}, {44, 161}, {45, 162}, {46, 163}, {47, 164}, {48, 165}, {49, 166}, {50, 167}, {51, 168}, {52, 169}, {53, 176}, {54, 177}, {55, 35}};
    private static final int[][] sdsEventToSdsEvent = new int[0][];

    @Override
    public boolean isSDSPopup(int n) {
        return PopupMapperEvo.isSDSPopup(n);
    }

    @Override
    public int[] getBigCommandPopups() {
        return PopupMapperEvo.getBigCommandPopups();
    }

    @Override
    public int[] getFurtherCommandPopups() {
        return PopupMapperEvo.getFurtherCommandPopups();
    }

    @Override
    public int[] getDisambiguationPopups() {
        return PopupMapperEvo.getDisambiguationPopups();
    }

    @Override
    public int getCommandScreenPopupMapping(int n, LogChannel logChannel) {
        return PopupMapperEvo.getCommandScreenPopupMapping(n, logChannel);
    }

    @Override
    public int getHelpScreenPopupMapping(int n, LogChannel logChannel) {
        return PopupMapperEvo.getHelpScreenPopupMapping(n, logChannel);
    }

    @Override
    public int getPopupID(int n) {
        return PopupMapperEvo.getPopupID(n);
    }

    @Override
    public int getPopupMappingID(int n) {
        return PopupMapperEvo.getPopupMappingID(n);
    }

    @Override
    public int getEventID(int n) {
        return EventMapperEvo.getEventID(n);
    }

    @Override
    public int[] getHMISlotGrammarArray() {
        return HMISlotGrammars.HMISlotGrammarArray;
    }

    @Override
    public int[] getSlotOrder(int n) {
        return HMISlotGrammars.getSlotOrder(n);
    }

    @Override
    public int getEventIdForRule(int n) {
        return RuleEventMapping.getEventIdForRule(n);
    }

    @Override
    public int getHMISlotGrammar(int n) {
        int n2 = SDSUtils.translate(n, grammarMappingToHMISlotGrammar);
        return n2 == 128 ? -1 : n2;
    }

    @Override
    public int getHMISlotGrammarMapping(int n) {
        int n2 = SDSUtils.reverseTranslate(n, grammarMappingToHMISlotGrammar);
        return n2 == 128 ? -1 : n2;
    }

    @Override
    public int getSlotTypeMapping(int n) {
        int n2 = SDSUtils.reverseTranslate(SlotGrammars.getSlotTypeForSlot(n), slotTypeMappingToSlotType);
        return n2 == 128 ? -1 : n2;
    }

    @Override
    public int getSUITypeForRule(int n) {
        int n2 = SDSUtils.translate(SUIGrammars.getSUITypeForRule(n), suiTypeToMappingType);
        return n2 == 128 ? 0 : n2;
    }

    @Override
    public int getModelMappingID(int n) {
        int n2 = SDSUtils.translate(n, modelIDtoMappingID);
        return n2 == 128 ? -1 : n2;
    }

    @Override
    public int getModelID(int n) {
        int n2 = SDSUtils.reverseTranslate(n, modelIDtoMappingID);
        return n2 == 128 ? -1 : n2;
    }

    @Override
    public int[] getSDSPopups() {
        return PopupMapperEvo.getSDSPopups();
    }

    @Override
    public int getRemoteHMILineNumberForEvent(int n) {
        return SDSUtils.translate(n, remoteHMI2LineNumber);
    }

    @Override
    public int[] getSUIGrammars(int n) {
        return SUIGrammars.getRulesForType(SDSUtils.reverseTranslate(n, suiTypeToMappingType));
    }

    @Override
    public int[] getTruffleGrammars(int n) {
        return SUIGrammars.getRulesForType(SDSUtils.reverseTranslate(n, truffleTypeToMappingType));
    }

    @Override
    public boolean isSUIGrammar(int n) {
        return SUIGrammars.getSUITypeForRule(n) != -1;
    }

    @Override
    public boolean isOneshotGrammar(int n) {
        return SUIGrammars.getSUITypeForRule(n) == 2;
    }

    @Override
    public boolean isNaviTrufflesInitialEvent(int n) {
        return n == 2421 || n == 1815 || n == 2420;
    }

    @Override
    public boolean isBigCommandDisplay(int n) {
        return n == 975702272 || n == -1391656192 || n == -661577472 || n == -577691392 || n == -702937600 || n == -686160384 || n == -2129124608 || n == -1793580288 || n == 613680128 || n == -125435648 || n == 56;
    }

    @Override
    public boolean isFurtherCommandDisplay(int n) {
        return n == 57 || n == 167 || n == 168 || n == 176 || n == 162 || n == 164 || n == 163 || n == 166 || n == 165 || n == 169 || n == 177 || n == 161;
    }

    @Override
    public int getScreenID(int n) {
        int n2 = SDSUtils.translate(n, screenMappingToScreenID);
        n2 = n2 == 128 ? -1 : n2;
        return n2;
    }

    @Override
    public int getScreenMapping(int n) {
        int n2 = SDSUtils.reverseTranslate(n, screenMappingToScreenID);
        n2 = n2 == 128 ? -1 : n2;
        return n2;
    }

    @Override
    public int getProgressIconTimeout() {
        return 2000;
    }

    @Override
    public int getSdsEvent(int n) {
        int n2 = SDSUtils.translate(n, sdsEventToSdsEvent);
        return n2 == 128 ? n : n2;
    }

    @Override
    public boolean isOnlineRecogFinishedSMEvent(int n) {
        return n == 1128;
    }
}

