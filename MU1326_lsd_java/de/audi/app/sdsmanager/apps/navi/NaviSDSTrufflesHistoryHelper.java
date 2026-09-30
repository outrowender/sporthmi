/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.navi;

import de.audi.atip.log.LogChannel;

public class NaviSDSTrufflesHistoryHelper {
    private String lastTruffleSearchText;
    private String[] lastTruffleAlternativeSearchTexts;
    private LogChannel logger;

    public NaviSDSTrufflesHistoryHelper(LogChannel logChannel) {
        this.logger = logChannel;
    }

    public void setLastTruffleSearchText(String string) {
        this.logger.log(10000000, "NaviSDSTrufflesHistoryHelper#setLastTruffleSearchText: string=%1", (Object)string);
        this.lastTruffleSearchText = string;
    }

    public String getLastTruffleSearchText() {
        return this.lastTruffleSearchText;
    }

    public void setLastTruffleAlternativeSearchTexts(String[] stringArray) {
        this.logger.log(10000000, "NaviSDSTrufflesHistoryHelper#setLastTruffleSearchText: alternativeSearchTexts=%1", (Object)stringArray);
        if (stringArray == null) {
            this.lastTruffleAlternativeSearchTexts = null;
            return;
        }
        this.lastTruffleAlternativeSearchTexts = new String[stringArray.length];
        System.arraycopy((Object)stringArray, 0, (Object)this.lastTruffleAlternativeSearchTexts, 0, stringArray.length);
    }

    public String[] getLastTruffleAlternativeSearchTexts() {
        return this.lastTruffleAlternativeSearchTexts;
    }

    public void clearLastTruffleSearchTexts() {
        this.lastTruffleSearchText = null;
        this.lastTruffleAlternativeSearchTexts = null;
    }
}

