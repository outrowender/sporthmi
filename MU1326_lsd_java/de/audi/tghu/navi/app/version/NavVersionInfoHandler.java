/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.version;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.version.INavVersionInfoButtonListModelAccess;

public class NavVersionInfoHandler {
    private LogChannel logChannel;
    private String[] navVersionInfo;
    private final INavVersionInfoButtonListModelAccess buttonListModelAccess;

    public NavVersionInfoHandler(INavVersionInfoButtonListModelAccess iNavVersionInfoButtonListModelAccess, LogChannel logChannel) {
        this.logChannel = logChannel;
        this.buttonListModelAccess = iNavVersionInfoButtonListModelAccess;
    }

    public void setNavVersionInfo(String[] stringArray) {
        this.navVersionInfo = stringArray;
    }

    public void updateNavVersionInfo() {
        if (this.navVersionInfo != null && this.navVersionInfo.length > 0) {
            if (this.navVersionInfo.length > 6) {
                this.buttonListModelAccess.update(this.navVersionInfo);
            }
        } else {
            this.logChannel.log(10000, "NavVersionInfoHandler#updateNavVersionInfo() - navVersion array is null or empty!");
        }
    }
}

