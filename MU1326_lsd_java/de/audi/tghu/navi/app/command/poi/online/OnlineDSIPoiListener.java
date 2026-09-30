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
        logChannel.log(1000000, "OnlineDSIPoiListener#OnlinePoiListener()");
    }

    public DSIListener getDSIDefaultHandler() {
        return this.defaultListener;
    }

    public CommandList getActiveCommandList() {
        return this.manager.getActiveCommandList();
    }

    public LogChannel getLogChannel() {
        return this.logChannel;
    }

    public String getHandlerName() {
        return this.listenerName;
    }

    public void asyncException(int n, String string, int n2) {
    }

    public void poiResult(final int n, final int n2, final int n3) {
        this.logChannel.log(1000000, "OnlineDSIPoiListener#poiResult()");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIPoiOnlineSearchListener)dSIListener).poiResult(n, n2, n3);
            }
        });
    }

    public void poiSpellingSuggestion(final int n, final String string, final String[] stringArray) {
        this.logChannel.log(1000000, "OnlineDSIPoiListener#poiSpellingSuggestion()");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIPoiOnlineSearchListener)dSIListener).poiSpellingSuggestion(n, string, stringArray);
            }
        });
    }

    public void poiValueList(final int n, final int n2, final PoiOnlineSearchValuelist poiOnlineSearchValuelist, final int n3, final int n4) {
        this.logChannel.log(1000000, "OnlineDSIPoiListener#poiValueList()");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIPoiOnlineSearchListener)dSIListener).poiValueList(n, n2, poiOnlineSearchValuelist, n3, n4);
            }
        });
    }

    public void precheckDynamicPOICategoryResponse(final int n, final OSRServiceState oSRServiceState) {
        this.logChannel.log(1000000, "OnlineDSIPoiListener#precheckDynamicPOICategoryResponse()");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIPoiOnlineSearchListener)dSIListener).precheckDynamicPOICategoryResponse(n, oSRServiceState);
            }
        });
    }
}

