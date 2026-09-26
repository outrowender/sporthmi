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

    @Override
    public void showPopupSemidynBlockMain() {
        this.getLogger().log(-2137614336, "DefaultMapPartialPopupHandler#showPopupSemidynBlockMain() - not initiated, method in DefaultMapPartialPopupHandler is called!");
    }

    @Override
    public void showPopupSemidynBetterMain() {
        this.getLogger().log(-2137614336, "DefaultMapPartialPopupHandler#showPopupSemidynBetterMain() - not initiated, method in DefaultMapPartialPopupHandler is called!");
    }

    @Override
    public void showPopupGoogleOfflineNoCache() {
        this.getLogger().log(-2137614336, "DefaultMapPartialPopupHandler#showPopupGoogleOfflineNoCache() - not initiated, method in DefaultMapPartialPopupHandler is called!");
    }

    @Override
    public void hidePopupSemidynBlockMain() {
        this.getLogger().log(-2137614336, "DefaultMapPartialPopupHandler#hidePopupSemidynBlockMain() - not initiated, method in DefaultMapPartialPopupHandler is called!");
    }

    @Override
    public void hidePopupSemidynBetterMain() {
        this.getLogger().log(-2137614336, "DefaultMapPartialPopupHandler#hidePopupSemidynBetterMain() - not initiated, method in DefaultMapPartialPopupHandler is called!");
    }

    @Override
    public void showPopupTrafficeNoticeMap(boolean bl) {
        this.getLogger().log(-2137614336, "DefaultMapPartialPopupHandler#showPopupTrafficeNoticeMap() - not initiated, method in DefaultMapPartialPopupHandler is called!");
    }

    @Override
    public void showOnlineTrafficWarningPPU(boolean bl) {
        this.getLogger().log(-2137614336, "DefaultMapPartialPopupHandler#showOnlineTrafficWarningPPU() - not initiated, method in DefaultMapPartialPopupHandler is called!");
    }
}

