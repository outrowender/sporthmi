/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command.poi.online;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.CommandListManager;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.command.poi.online.OnlineDSIPoiListener;
import de.audi.tghu.navi.app.command.poi.online.OnlinePoiCommandList;
import de.audi.tghu.navi.app.command.poi.online.OnlineSearchErrorCommand;
import de.audi.tghu.navi.app.poi.online.IOnlineSearchForm;
import de.audi.tghu.navi.app.poi.online.OnlineSearchContext;
import org.dsi.ifc.online.DSIPoiOnlineSearch;

public class OnlinePoiCommandListFactory
implements ICommandListFactory {
    private final CommandListManager commandListManager;
    private final OnlineDSIPoiListener onlineDSIListener;
    private volatile DSIPoiOnlineSearch dsiOnline = null;
    private LogChannel logger;
    private final IOnlineSearchForm modelAccess;
    private final OnlineSearchContext onlineSearchContext;

    public OnlinePoiCommandListFactory(CommandListManager commandListManager, OnlineDSIPoiListener onlineDSIPoiListener, IOnlineSearchForm iOnlineSearchForm, OnlineSearchContext onlineSearchContext) {
        this.commandListManager = commandListManager;
        this.onlineDSIListener = onlineDSIPoiListener;
        this.modelAccess = iOnlineSearchForm;
        this.onlineSearchContext = onlineSearchContext;
        this.logger = commandListManager.getLogChannel();
        this.logger.log(1000000, "OnlinePoiCommandListFactory#OnlinePoiCommandListFactory()");
    }

    public void setDsiOnline(DSIPoiOnlineSearch dSIPoiOnlineSearch) {
        this.logger.log(1000000, "OnlinePoiCommandListFactory#setDsiOnline()");
        this.dsiOnline = dSIPoiOnlineSearch;
    }

    public DSIPoiOnlineSearch getDsiOnline() {
        this.logger.log(1000000, "OnlinePoiCommandListFactory#getDsiOnline()");
        return this.dsiOnline;
    }

    public CommandList createCommandList() {
        this.logger.log(1000000, "OnlinePoiCommandListFactory#createCommandList()");
        OnlinePoiCommandList onlinePoiCommandList = new OnlinePoiCommandList(this.commandListManager, this.onlineDSIListener, this.dsiOnline);
        onlinePoiCommandList.setErrorCommand(new OnlineSearchErrorCommand(this.logger, this.modelAccess, this.onlineSearchContext));
        return onlinePoiCommandList;
    }

    public CommandList createCommandList(int n) {
        this.logger.log(1000000, "OnlinePoiCommandListFactory#createCommandList()");
        return new OnlinePoiCommandList(this.commandListManager, this.onlineDSIListener, n, this.dsiOnline);
    }
}

