/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.sds;

import de.audi.atip.interapp.NaviService$NaviSUIDetails;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.sds.ISUIModelAccess;

public class SUIHandler {
    private final ISUIModelAccess modelAccess;
    private final LogChannel logChannel;

    public SUIHandler(ISUIModelAccess iSUIModelAccess, LogChannel logChannel) {
        this.modelAccess = iSUIModelAccess;
        this.logChannel = logChannel;
    }

    public byte fillNaviSUIList(NaviService$NaviSUIDetails[] naviService$NaviSUIDetailsArray) {
        this.logChannel.log(-2137614336, "SUIHandler#fillNaviSUIList()");
        return this.modelAccess.fillNaviSUIList(naviService$NaviSUIDetailsArray);
    }
}

