/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.version;

import de.audi.app.navi.evo.version.EvoNavVersionInfoList;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.util.Util;
import de.audi.tghu.navi.app.version.INavVersionInfoButtonListModelAccess;

public class EvoNavVersionInfoButtonListModelAccess
implements INavVersionInfoButtonListModelAccess {
    private final NavigationEnv env;
    private static final int navVersionButton;
    private static final int navVersionList;
    private LogChannel logChannel;

    public EvoNavVersionInfoButtonListModelAccess(NavigationEnv navigationEnv, LogChannel logChannel) {
        this.env = navigationEnv;
        this.logChannel = logChannel;
    }

    @Override
    public void update(String[] stringArray) {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(14808325, "NavVersionInfoHandler#update(String[] navVersionInfo) %1", (Object)stringArray);
        }
        ButtonModelApp buttonModelApp = this.env.getButtonModel(343);
        BaseListModelApp baseListModelApp = this.env.getBaseListModel(3840);
        BaseListModelApp baseListModelApp2 = baseListModelApp.getEmptyCopy();
        boolean bl = false;
        EvoNavVersionInfoList evoNavVersionInfoList = new EvoNavVersionInfoList(stringArray);
        bl = evoNavVersionInfoList.showNavDbSubmenuButton();
        if (!evoNavVersionInfoList.isEmpty()) {
            evoNavVersionInfoList.fillBaseListModel(baseListModelApp2);
        } else {
            this.logChannel.log(10000, "NavVersionInfoHandler#updateNavVersionInfo() - navVersion array is null or empty!");
        }
        baseListModelApp.update(baseListModelApp2);
        if (bl) {
            if (this.logChannel.isDebug2()) {
                this.logChannel.log(14808325, "NavVersionInfoHandler#updateNavVersionInfo() - show submenu button");
            }
            Util.setModelStatus(buttonModelApp, 1);
        } else {
            if (this.logChannel.isDebug2()) {
                this.logChannel.log(14808325, "NavVersionInfoHandler#updateNavVersionInfo() - hide submenu button");
            }
            Util.setModelStatus(buttonModelApp, 0);
        }
    }
}

