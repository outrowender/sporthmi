/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.onlinedest.commands;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.CommandListManager;
import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.command.ICommandResponseSupplier;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.online.DSIDestinationImportListener;
import org.dsi.ifc.online.PortalADBEntry;

public class OnlineDestinationListener
implements DSIDestinationImportListener,
ICommandResponseSupplier {
    private static final String LOGCLASS = (class$de$audi$tghu$online$app$onlinedest$commands$OnlineDestinationListener == null ? (class$de$audi$tghu$online$app$onlinedest$commands$OnlineDestinationListener = OnlineDestinationListener.class$("de.audi.tghu.online.app.onlinedest.commands.OnlineDestinationListener")) : class$de$audi$tghu$online$app$onlinedest$commands$OnlineDestinationListener).getName();
    private CommandListManager cmdListMgr;
    private LogChannel log;
    private DSIDestinationImportListener defaultListener;
    static /* synthetic */ Class class$de$audi$tghu$online$app$onlinedest$commands$OnlineDestinationListener;

    public OnlineDestinationListener(LogChannel logChannel, CommandListManager commandListManager, DSIDestinationImportListener dSIDestinationImportListener) {
        this.cmdListMgr = commandListManager;
        this.defaultListener = dSIDestinationImportListener;
        this.log = logChannel;
    }

    public void asyncException(final int n, final String string, final int n2) {
        this.log.log(1000000, "OnlineDestinationListener#asyncException() passing forward...");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIDestinationImportListener)dSIListener).asyncException(n, string, n2);
            }
        });
    }

    public void downloadAddressListResult(final PortalADBEntry[] portalADBEntryArray, final int n, final int n2) {
        this.log.log(1000000, "OnlineDestinationListener#downloadAddressListResult() passing forward...");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIDestinationImportListener)dSIListener).downloadAddressListResult(portalADBEntryArray, n, n2);
            }
        });
    }

    public void stopActionResult(final int n) {
        this.log.log(1000000, "OnlineDestinationListener#stopActionResult() passing forward...");
        CommandResponse.execute(this, new CommandResponse(){

            public void call(DSIListener dSIListener) {
                ((DSIDestinationImportListener)dSIListener).stopActionResult(n);
            }
        });
    }

    public void updateEntries(int n, int n2) {
        this.defaultListener.updateEntries(n, n2);
    }

    public DSIListener getDSIDefaultHandler() {
        return this.defaultListener;
    }

    public CommandList getActiveCommandList() {
        return this.cmdListMgr.getActiveCommandList();
    }

    public LogChannel getLogChannel() {
        return this.log;
    }

    public String getHandlerName() {
        return this.getClass().getName();
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

