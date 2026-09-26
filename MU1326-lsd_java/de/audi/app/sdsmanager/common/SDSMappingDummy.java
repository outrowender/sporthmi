/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.common;

import de.audi.app.sdsmanager.common.ISDSMapping;
import de.audi.atip.log.LogChannel;

public class SDSMappingDummy
implements ISDSMapping {
    @Override
    public int getPopupID(int n) {
        return 0;
    }

    @Override
    public int getEventID(int n) {
        return 0;
    }

    @Override
    public int[] getBigCommandPopups() {
        return new int[0];
    }

    @Override
    public int[] getFurtherCommandPopups() {
        return new int[0];
    }

    @Override
    public int getCommandScreenPopupMapping(int n, LogChannel logChannel) {
        return 0;
    }

    @Override
    public int getHelpScreenPopupMapping(int n, LogChannel logChannel) {
        return 0;
    }

    @Override
    public int[] getHMISlotGrammarArray() {
        return new int[0];
    }

    @Override
    public int[] getSlotOrder(int n) {
        switch (n) {
            case 400166: {
                return new int[]{370869760, 404424192, 387646976};
            }
        }
        return null;
    }

    @Override
    public int getEventIdForRule(int n) {
        return 0;
    }

    @Override
    public int getHMISlotGrammar(int n) {
        if (n == 41) {
            return 2081956608;
        }
        if (n == 43) {
            return 2132288256;
        }
        if (n == 42) {
            return 2031624960;
        }
        if (n == 56) {
            return -197850112;
        }
        return -1;
    }

    @Override
    public int getHMISlotGrammarMapping(int n) {
        return -1;
    }

    @Override
    public int[] getDisambiguationPopups() {
        return new int[0];
    }

    @Override
    public int getSUITypeForRule(int n) {
        return 0;
    }

    @Override
    public int getModelMappingID(int n) {
        return 0;
    }

    @Override
    public int getPopupMappingID(int n) {
        return 0;
    }

    @Override
    public int[] getSDSPopups() {
        return new int[0];
    }

    @Override
    public int getRemoteHMILineNumberForEvent(int n) {
        return 0;
    }

    @Override
    public int getModelID(int n) {
        return 0;
    }

    @Override
    public int[] getSUIGrammars(int n) {
        return new int[0];
    }

    @Override
    public int[] getTruffleGrammars(int n) {
        return new int[0];
    }

    @Override
    public boolean isSUIGrammar(int n) {
        return false;
    }

    @Override
    public boolean isOneshotGrammar(int n) {
        return false;
    }

    @Override
    public boolean isNaviTrufflesInitialEvent(int n) {
        return false;
    }

    @Override
    public boolean isSDSPopup(int n) {
        return false;
    }

    @Override
    public int getScreenID(int n) {
        return 0;
    }

    @Override
    public boolean isBigCommandDisplay(int n) {
        return false;
    }

    @Override
    public boolean isFurtherCommandDisplay(int n) {
        return false;
    }

    @Override
    public int getScreenMapping(int n) {
        return -1;
    }

    @Override
    public int getProgressIconTimeout() {
        return 2000;
    }

    @Override
    public int getSlotTypeMapping(int n) {
        return 0;
    }

    @Override
    public int getSdsEvent(int n) {
        return 0;
    }

    @Override
    public boolean isOnlineRecogFinishedSMEvent(int n) {
        return false;
    }
}

