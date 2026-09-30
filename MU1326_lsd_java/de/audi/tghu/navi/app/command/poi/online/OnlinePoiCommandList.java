/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command.poi.online;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.CommandListManager;
import de.audi.tghu.navi.app.command.poi.online.OnlineDSIPoiListener;
import org.dsi.ifc.online.DSIPoiOnlineSearch;

public class OnlinePoiCommandList
extends CommandList {
    private OnlineDSIPoiListener dsiOnlineListener;
    private volatile DSIPoiOnlineSearch dsiOnlineSearch;
    private LogChannel logger;

    public OnlinePoiCommandList(CommandListManager commandListManager, OnlineDSIPoiListener onlineDSIPoiListener, DSIPoiOnlineSearch dSIPoiOnlineSearch) {
        super(commandListManager);
        this.logger = commandListManager.getLogChannel();
        this.dsiOnlineListener = onlineDSIPoiListener;
        this.dsiOnlineSearch = dSIPoiOnlineSearch;
        this.logger.log(1000000, "OnlinePoiCommandList#OnlinePoiCommandList()");
    }

    public OnlinePoiCommandList(CommandListManager commandListManager, OnlineDSIPoiListener onlineDSIPoiListener, int n, DSIPoiOnlineSearch dSIPoiOnlineSearch) {
        super(commandListManager, n);
        this.logger = commandListManager.getLogChannel();
        this.dsiOnlineListener = onlineDSIPoiListener;
        this.dsiOnlineSearch = dSIPoiOnlineSearch;
    }

    public OnlineDSIPoiListener getDefaultHandler() {
        this.logger.log(1000000, "OnlinePoiCommandList#getDefaultHandler()");
        return (OnlineDSIPoiListener)this.dsiOnlineListener.getDSIDefaultHandler();
    }

    public DSIPoiOnlineSearch getOnlineSearch() {
        return this.dsiOnlineSearch;
    }
}

