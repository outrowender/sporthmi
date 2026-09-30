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
    private static final int[][] modelIDtoMappingID = new int[][]{{300680, 1}, {700594, 10}, {700595, 11}, {700527, 12}, {700525, 13}, {700526, 14}, {4137, 20}, {4141, 22}, {4143, 21}, {4142, 23}, {4145, 24}, {2301342, 25}, {401316, 26}, {5578, 28}, {4595, 29}, {5573, 31}, {5620, 32}, {5621, 33}, {5623, 34}};
    private static int[][] remoteHMI2LineNumber = new int[][]{{2360, 0}, {2361, 1}, {2363, 10}, {2364, 11}, {2365, 12}, {2366, 13}, {2367, 14}, {2368, 15}, {2369, 16}, {2370, 17}, {2371, 18}, {2372, 19}, {2362, 2}, {2373, 20}, {2374, 21}, {2375, 22}, {2376, 23}, {2377, 3}, {2378, 4}, {2379, 5}, {2380, 6}, {2381, 7}, {2382, 8}, {2383, 9}};
    private static int[][] screenMappingToScreenID = new int[][]{{1, 100}, {2, 400111}, {39, 400212}, {3, 300045}, {4, 300148}, {7, 700018}, {8, 400015}, {5, 2300008}, {6, 2300010}, {11, 2300056}, {12, 2300058}, {9, 2300072}, {10, 2300073}, {14, 600111}, {15, 200099}, {16, 200098}, {17, 200100}, {18, 200101}, {19, 200102}, {20, 0x219221}, {21, 400071}, {22, 400074}, {23, 400075}, {24, 400076}, {25, 400084}, {26, 2300050}, {27, 2300052}, {28, 300050}, {29, 300049}, {30, 300051}, {31, 300048}, {32, 300053}, {33, 300054}, {34, 100084}, {35, 100085}, {36, 100086}, {37, 100087}, {38, 55}, {40, 400088}, {41, 400049}, {42, 2200053}, {43, 2200050}, {13, 57}, {44, 161}, {45, 162}, {46, 163}, {47, 164}, {48, 165}, {49, 166}, {50, 167}, {51, 168}, {52, 169}, {53, 176}, {54, 177}, {55, 35}};
    private static final int[][] sdsEventToSdsEvent = new int[0][];

    public boolean isSDSPopup(int n) {
        return PopupMapperEvo.isSDSPopup(n);
    }

    public int[] getBigCommandPopups() {
        return PopupMapperEvo.getBigCommandPopups();
    }

    public int[] getFurtherCommandPopups() {
        return PopupMapperEvo.getFurtherCommandPopups();
    }

    public int[] getDisambiguationPopups() {
        return PopupMapperEvo.getDisambiguationPopups();
    }

    public int getCommandScreenPopupMapping(int n, LogChannel logChannel) {
        return PopupMapperEvo.getCommandScreenPopupMapping(n, logChannel);
    }

    public int getHelpScreenPopupMapping(int n, LogChannel logChannel) {
        return PopupMapperEvo.getHelpScreenPopupMapping(n, logChannel);
    }

    public int getPopupID(int n) {
        return PopupMapperEvo.getPopupID(n);
    }

    public int getPopupMappingID(int n) {
        return PopupMapperEvo.getPopupMappingID(n);
    }

    public int getEventID(int n) {
        return EventMapperEvo.getEventID(n);
    }

    public int[] getHMISlotGrammarArray() {
        return HMISlotGrammars.HMISlotGrammarArray;
    }

    public int[] getSlotOrder(int n) {
        return HMISlotGrammars.getSlotOrder(n);
    }

    public int getEventIdForRule(int n) {
        return RuleEventMapping.getEventIdForRule(n);
    }

    public int getHMISlotGrammar(int n) {
        int n2 = SDSUtils.translate(n, grammarMappingToHMISlotGrammar);
        return n2 == Integer.MIN_VALUE ? -1 : n2;
    }

    public int getHMISlotGrammarMapping(int n) {
        int n2 = SDSUtils.reverseTranslate(n, grammarMappingToHMISlotGrammar);
        return n2 == Integer.MIN_VALUE ? -1 : n2;
    }

    public int getSlotTypeMapping(int n) {
        int n2 = SDSUtils.reverseTranslate(SlotGrammars.getSlotTypeForSlot(n), slotTypeMappingToSlotType);
        return n2 == Integer.MIN_VALUE ? -1 : n2;
    }

    public int getSUITypeForRule(int n) {
        int n2 = SDSUtils.translate(SUIGrammars.getSUITypeForRule(n), suiTypeToMappingType);
        return n2 == Integer.MIN_VALUE ? 0 : n2;
    }

    public int getModelMappingID(int n) {
        int n2 = SDSUtils.translate(n, modelIDtoMappingID);
        return n2 == Integer.MIN_VALUE ? -1 : n2;
    }

    public int getModelID(int n) {
        int n2 = SDSUtils.reverseTranslate(n, modelIDtoMappingID);
        return n2 == Integer.MIN_VALUE ? -1 : n2;
    }

    public int[] getSDSPopups() {
        return PopupMapperEvo.getSDSPopups();
    }

    public int getRemoteHMILineNumberForEvent(int n) {
        return SDSUtils.translate(n, remoteHMI2LineNumber);
    }

    public int[] getSUIGrammars(int n) {
        return SUIGrammars.getRulesForType(SDSUtils.reverseTranslate(n, suiTypeToMappingType));
    }

    public int[] getTruffleGrammars(int n) {
        return SUIGrammars.getRulesForType(SDSUtils.reverseTranslate(n, truffleTypeToMappingType));
    }

    public boolean isSUIGrammar(int n) {
        return SUIGrammars.getSUITypeForRule(n) != -1;
    }

    public boolean isOneshotGrammar(int n) {
        return SUIGrammars.getSUITypeForRule(n) == 2;
    }

    public boolean isNaviTrufflesInitialEvent(int n) {
        return n == 2421 || n == 1815 || n == 2420;
    }

    public boolean isBigCommandDisplay(int n) {
        return n == 600122 || n == 200109 || n == 2200024 || n == 2200029 || n == 400086 || n == 400087 || n == 2300033 || n == 2300053 || n == 300068 || n == 100088 || n == 56;
    }

    public boolean isFurtherCommandDisplay(int n) {
        return n == 57 || n == 167 || n == 168 || n == 176 || n == 162 || n == 164 || n == 163 || n == 166 || n == 165 || n == 169 || n == 177 || n == 161;
    }

    public int getScreenID(int n) {
        int n2 = SDSUtils.translate(n, screenMappingToScreenID);
        n2 = n2 == Integer.MIN_VALUE ? -1 : n2;
        return n2;
    }

    public int getScreenMapping(int n) {
        int n2 = SDSUtils.reverseTranslate(n, screenMappingToScreenID);
        n2 = n2 == Integer.MIN_VALUE ? -1 : n2;
        return n2;
    }

    public int getProgressIconTimeout() {
        return 2000;
    }

    public int getSdsEvent(int n) {
        int n2 = SDSUtils.translate(n, sdsEventToSdsEvent);
        return n2 == Integer.MIN_VALUE ? n : n2;
    }

    public boolean isOnlineRecogFinishedSMEvent(int n) {
        return n == 1128;
    }
}

