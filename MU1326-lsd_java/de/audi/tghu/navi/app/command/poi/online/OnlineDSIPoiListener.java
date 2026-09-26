/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command.poi.online;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.CommandListManager;
import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.command.ICommandResponseSupplier;
import de.audi.tghu.navi.app.command.poi.online.OnlineDSIDefaultListener;
import de.audi.tghu.navi.app.command.poi.online.OnlineDSIPoiListener$1;
import de.audi.tghu.navi.app.command.poi.online.OnlineDSIPoiListener$2;
import de.audi.tghu.navi.app.command.poi.online.OnlineDSIPoiListener$3;
import de.audi.tghu.navi.app.command.poi.online.OnlineDSIPoiListener$4;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.online.DSIPoiOnlineSearchListener;
import org.dsi.ifc.online.OSRServiceState;
import org.dsi.ifc.online.PoiOnlineSearchValuelist;

public class OnlineDSIPoiListener
implements DSIPoiOnlineSearchListener,
ICommandResponseSupplier {
    private final CommandListManager manager;
    private final String listenerName;
    private LogChannel logChannel;
    private final OnlineDSIDefaultListener defaultListener;

    public OnlineDSIPoiListener(CommandListManager commandListManager, LogChannel logChannel) {
        this.logChannel = logChannel;
        this.manager = commandListManager;
        this.listenerName = "OnlinePoiResponseDispatcher";
        this.defaultListener = new OnlineDSIDefaultListener(logChannel);
        logChannel.log(1078071040, "OnlineDSIPoiListener#OnlinePoiListener()");
    }

    @Override
    public DSIListener getDSIDefaultHandler() {
        return this.defaultListener;
    }

    @Override
    public CommandList getActiveCommandList() {
        return this.manager.getActiveCommandList();
    }

    @Override
    public LogChannel getLogChannel() {
        return this.logChannel;
    }

    @Override
    public String getHandlerName() {
        return this.listenerName;
    }

    @Override
    public void asyncException(int n, String string, int n2) {
    }

    @Override
    public void poiResult(int n, int n2, int n3) {
        this.logChannel.log(1078071040, "OnlineDSIPoiListener#poiResult()");
        CommandResponse.execute(this, new OnlineDSIPoiListener$1(this, n, n2, n3));
    }

    @Override
    public void poiSpellingSuggestion(int n, String string, String[] stringArray) {
        this.logChannel.log(1078071040, "OnlineDSIPoiListener#poiSpellingSuggestion()");
        CommandResponse.execute(this, new OnlineDSIPoiListener$2(this, n, string, stringArray));
    }

    @Override
    public void poiValueList(int n, int n2, PoiOnlineSearchValuelist poiOnlineSearchValuelist, int n3, int n4) {
        this.logChannel.log(1078071040, "OnlineDSIPoiListener#poiValueList()");
        CommandResponse.execute(this, new OnlineDSIPoiListener$3(this, n, n2, poiOnlineSearchValuelist, n3, n4));
    }

    @Override
    public void precheckDynamicPOICategoryResponse(int n, OSRServiceState oSRServiceState) {
        this.logChannel.log(1078071040, "OnlineDSIPoiListener#precheckDynamicPOICategoryResponse()");
        CommandResponse.execute(this, new OnlineDSIPoiListener$4(this, n, oSRServiceState));
    }
}

