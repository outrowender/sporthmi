/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.onlinedest.commands;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.online.app.onlinedest.OnlineDestinationController;
import org.dsi.ifc.online.DSIDestinationImportListener;
import org.dsi.ifc.online.PortalADBEntry;

public class OnlineDestinationDefaultListener
implements DSIDestinationImportListener {
    private static final String LOGCLASS = (class$de$audi$tghu$online$app$onlinedest$commands$OnlineDestinationDefaultListener == null ? (class$de$audi$tghu$online$app$onlinedest$commands$OnlineDestinationDefaultListener = OnlineDestinationDefaultListener.class$("de.audi.tghu.online.app.onlinedest.commands.OnlineDestinationDefaultListener")) : class$de$audi$tghu$online$app$onlinedest$commands$OnlineDestinationDefaultListener).getName();
    private OnlineDestinationController application;
    private LogChannel log;
    static /* synthetic */ Class class$de$audi$tghu$online$app$onlinedest$commands$OnlineDestinationDefaultListener;

    public OnlineDestinationDefaultListener(LogChannel logChannel, OnlineDestinationController onlineDestinationController) {
        this.application = onlineDestinationController;
        this.log = logChannel;
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        this.log.log(1078071040, "OnlineDestinationDefaultListener#asyncException() errorCode: %2, message: %1, requestType: %3", (Object)string, (long)n, (long)n2);
    }

    @Override
    public void downloadAddressListResult(PortalADBEntry[] portalADBEntryArray, int n, int n2) {
        this.log.log(1078071040, "OnlineDestinationDefaultListener#downloadAddressListResult() length:%1, status:%2, remainingEntries:%3", (long)portalADBEntryArray.length, (long)n, (long)n2);
    }

    @Override
    public void stopActionResult(int n) {
        this.log.log(1078071040, "OnlineDestinationDefaultListener#stopActionResult() success: %1", (long)n);
    }

    @Override
    public void updateEntries(int n, int n2) {
        this.log.log(1078071040, "OnlineDestinationDefaultListener#updateEntries() nrEntries: %1, valid: %2", (long)n, (long)n2);
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

