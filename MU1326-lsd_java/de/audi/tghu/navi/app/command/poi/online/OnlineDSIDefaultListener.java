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
        logChannel.log(1078071040, "OnlineDSIDefaultListener#OnlineDSIDefaultListener()");
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        this.logger.log(1078071040, "OnlineDSIDefaultListener#asyncException()");
    }

    @Override
    public void poiResult(int n, int n2, int n3) {
        this.logger.log(1078071040, "OnlineDSIDefaultListener#poiResult()");
    }

    @Override
    public void poiSpellingSuggestion(int n, String string, String[] stringArray) {
        this.logger.log(1078071040, "OnlineDSIDefaultListener#poiSpellingSuggestion()");
    }

    @Override
    public void poiValueList(int n, int n2, PoiOnlineSearchValuelist poiOnlineSearchValuelist, int n3, int n4) {
        this.logger.log(1078071040, "OnlineDSIDefaultListener#poiValueList()");
    }

    @Override
    public void precheckDynamicPOICategoryResponse(int n, OSRServiceState oSRServiceState) {
        this.logger.log(1078071040, "OnlineDSIDefaultListener#precheckDynamicPOICategoryResponse()");
    }
}

