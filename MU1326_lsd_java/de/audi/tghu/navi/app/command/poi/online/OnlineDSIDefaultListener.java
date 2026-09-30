/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command.poi.online;

import de.audi.atip.log.LogChannel;
import org.dsi.ifc.online.DSIPoiOnlineSearchListener;
import org.dsi.ifc.online.OSRServiceState;
import org.dsi.ifc.online.PoiOnlineSearchValuelist;

public class OnlineDSIDefaultListener
implements DSIPoiOnlineSearchListener {
    private LogChannel logger;

    public OnlineDSIDefaultListener(LogChannel logChannel) {
        this.logger = logChannel;
        logChannel.log(1000000, "OnlineDSIDefaultListener#OnlineDSIDefaultListener()");
    }

    public void asyncException(int n, String string, int n2) {
        this.logger.log(1000000, "OnlineDSIDefaultListener#asyncException()");
    }

    public void poiResult(int n, int n2, int n3) {
        this.logger.log(1000000, "OnlineDSIDefaultListener#poiResult()");
    }

    public void poiSpellingSuggestion(int n, String string, String[] stringArray) {
        this.logger.log(1000000, "OnlineDSIDefaultListener#poiSpellingSuggestion()");
    }

    public void poiValueList(int n, int n2, PoiOnlineSearchValuelist poiOnlineSearchValuelist, int n3, int n4) {
        this.logger.log(1000000, "OnlineDSIDefaultListener#poiValueList()");
    }

    public void precheckDynamicPOICategoryResponse(int n, OSRServiceState oSRServiceState) {
        this.logger.log(1000000, "OnlineDSIDefaultListener#precheckDynamicPOICategoryResponse()");
    }
}

