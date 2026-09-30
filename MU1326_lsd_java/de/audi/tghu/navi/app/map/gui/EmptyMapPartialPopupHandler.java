/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.gui;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.map.IMapPartialPopupHandler;

public class EmptyMapPartialPopupHandler
implements IMapPartialPopupHandler {
    private LogChannel logger;

    public EmptyMapPartialPopupHandler(LogChannel logChannel) {
        this.logger = logChannel;
    }

    private LogChannel getLogger() {
        return this.logger;
    }

    public void showPopupSemidynBlockMain() {
        this.getLogger().log(10000000, "DefaultMapPartialPopupHandler#showPopupSemidynBlockMain() - not initiated, method in DefaultMapPartialPopupHandler is called!");
    }

    public void showPopupSemidynBetterMain() {
        this.getLogger().log(10000000, "DefaultMapPartialPopupHandler#showPopupSemidynBetterMain() - not initiated, method in DefaultMapPartialPopupHandler is called!");
    }

    public void showPopupGoogleOfflineNoCache() {
        this.getLogger().log(10000000, "DefaultMapPartialPopupHandler#showPopupGoogleOfflineNoCache() - not initiated, method in DefaultMapPartialPopupHandler is called!");
    }

    public void hidePopupSemidynBlockMain() {
        this.getLogger().log(10000000, "DefaultMapPartialPopupHandler#hidePopupSemidynBlockMain() - not initiated, method in DefaultMapPartialPopupHandler is called!");
    }

    public void hidePopupSemidynBetterMain() {
        this.getLogger().log(10000000, "DefaultMapPartialPopupHandler#hidePopupSemidynBetterMain() - not initiated, method in DefaultMapPartialPopupHandler is called!");
    }

    public void showPopupTrafficeNoticeMap(boolean bl) {
        this.getLogger().log(10000000, "DefaultMapPartialPopupHandler#showPopupTrafficeNoticeMap() - not initiated, method in DefaultMapPartialPopupHandler is called!");
    }

    public void showOnlineTrafficWarningPPU(boolean bl) {
        this.getLogger().log(10000000, "DefaultMapPartialPopupHandler#showOnlineTrafficWarningPPU() - not initiated, method in DefaultMapPartialPopupHandler is called!");
    }
}

