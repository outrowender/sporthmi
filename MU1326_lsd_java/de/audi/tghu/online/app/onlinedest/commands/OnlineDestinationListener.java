/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.onlinedest.commands;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.CommandListManager;
import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.command.ICommandResponseSupplier;
import de.audi.tghu.online.app.onlinedest.commands.OnlineDestinationListener$1;
import de.audi.tghu.online.app.onlinedest.commands.OnlineDestinationListener$2;
import de.audi.tghu.online.app.onlinedest.commands.OnlineDestinationListener$3;
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

    @Override
    public void asyncException(int n, String string, int n2) {
        this.log.log(1078071040, "OnlineDestinationListener#asyncException() passing forward...");
        CommandResponse.execute(this, new OnlineDestinationListener$1(this, n, string, n2));
    }

    @Override
    public void downloadAddressListResult(PortalADBEntry[] portalADBEntryArray, int n, int n2) {
        this.log.log(1078071040, "OnlineDestinationListener#downloadAddressListResult() passing forward...");
        CommandResponse.execute(this, new OnlineDestinationListener$2(this, portalADBEntryArray, n, n2));
    }

    @Override
    public void stopActionResult(int n) {
        this.log.log(1078071040, "OnlineDestinationListener#stopActionResult() passing forward...");
        CommandResponse.execute(this, new OnlineDestinationListener$3(this, n));
    }

    @Override
    public void updateEntries(int n, int n2) {
        this.defaultListener.updateEntries(n, n2);
    }

    @Override
    public DSIListener getDSIDefaultHandler() {
        return this.defaultListener;
    }

    @Override
    public CommandList getActiveCommandList() {
        return this.cmdListMgr.getActiveCommandList();
    }

    @Override
    public LogChannel getLogChannel() {
        return this.log;
    }

    @Override
    public String getHandlerName() {
        return super.getClass().getName();
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

