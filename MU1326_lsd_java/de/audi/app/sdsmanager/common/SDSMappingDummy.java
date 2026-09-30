/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.common;

import de.audi.app.sdsmanager.common.ISDSMapping;
import de.audi.atip.log.LogChannel;

public class SDSMappingDummy
implements ISDSMapping {
    public int getPopupID(int n) {
        return 0;
    }

    public int getEventID(int n) {
        return 0;
    }

    public int[] getBigCommandPopups() {
        return new int[0];
    }

    public int[] getFurtherCommandPopups() {
        return new int[0];
    }

    public int getCommandScreenPopupMapping(int n, LogChannel logChannel) {
        return 0;
    }

    public int getHelpScreenPopupMapping(int n, LogChannel logChannel) {
        return 0;
    }

    public int[] getHMISlotGrammarArray() {
        return new int[0];
    }

    public int[] getSlotOrder(int n) {
        switch (n) {
            case 400166: {
                return new int[]{400150, 400152, 400151};
            }
        }
        return null;
    }

    public int getEventIdForRule(int n) {
        return 0;
    }

    public int getHMISlotGrammar(int n) {
        if (n == 41) {
            return 2300028;
        }
        if (n == 43) {
            return 2300031;
        }
        if (n == 42) {
            return 2300025;
        }
        if (n == 56) {
            return 800244;
        }
        return -1;
    }

    public int getHMISlotGrammarMapping(int n) {
        return -1;
    }

    public int[] getDisambiguationPopups() {
        return new int[0];
    }

    public int getSUITypeForRule(int n) {
        return 0;
    }

    public int getModelMappingID(int n) {
        return 0;
    }

    public int getPopupMappingID(int n) {
        return 0;
    }

    public int[] getSDSPopups() {
        return new int[0];
    }

    public int getRemoteHMILineNumberForEvent(int n) {
        return 0;
    }

    public int getModelID(int n) {
        return 0;
    }

    public int[] getSUIGrammars(int n) {
        return new int[0];
    }

    public int[] getTruffleGrammars(int n) {
        return new int[0];
    }

    public boolean isSUIGrammar(int n) {
        return false;
    }

    public boolean isOneshotGrammar(int n) {
        return false;
    }

    public boolean isNaviTrufflesInitialEvent(int n) {
        return false;
    }

    public boolean isSDSPopup(int n) {
        return false;
    }

    public int getScreenID(int n) {
        return 0;
    }

    public boolean isBigCommandDisplay(int n) {
        return false;
    }

    public boolean isFurtherCommandDisplay(int n) {
        return false;
    }

    public int getScreenMapping(int n) {
        return -1;
    }

    public int getProgressIconTimeout() {
        return 2000;
    }

    public int getSlotTypeMapping(int n) {
        return 0;
    }

    public int getSdsEvent(int n) {
        return 0;
    }

    public boolean isOnlineRecogFinishedSMEvent(int n) {
        return false;
    }
}

