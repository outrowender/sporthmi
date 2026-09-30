/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.transfer;

import de.audi.app.media.interapp.ITransferStateListener;
import de.audi.app.media.osgi.AbstractServiceListTracker;
import de.audi.app.media.osgi.IServiceManager;
import de.audi.app.media.source.ISourceSlot;
import de.audi.atip.log.LogChannel;
import java.util.Dictionary;
import java.util.Iterator;

public class TransferStateNotifier
extends AbstractServiceListTracker {
    private static final String LOGCLASS = "TransferStateNotifier";
    static /* synthetic */ Class class$de$audi$app$media$interapp$ITransferStateListener;

    public TransferStateNotifier(LogChannel logChannel, IServiceManager iServiceManager) {
        super(logChannel, iServiceManager);
    }

    protected Class getTrackedServiceClass() {
        return class$de$audi$app$media$interapp$ITransferStateListener == null ? (class$de$audi$app$media$interapp$ITransferStateListener = TransferStateNotifier.class$("de.audi.app.media.interapp.ITransferStateListener")) : class$de$audi$app$media$interapp$ITransferStateListener;
    }

    protected void serviceAdded(Object object) {
    }

    protected void serviceRemoved(Object object) {
    }

    protected boolean checkServiceProperties(Dictionary dictionary) {
        return true;
    }

    public void notifyImportStarted(ISourceSlot iSourceSlot) {
        this.logger.log(1000000, "[%1.notifyImportStarted] '%2'", (Object)LOGCLASS, (Object)iSourceSlot);
        Iterator iterator = this.getServices().iterator();
        while (iterator.hasNext()) {
            try {
                ((ITransferStateListener)iterator.next()).importStarted(iSourceSlot);
            }
            catch (Exception exception) {
                this.logger.log(100000, "[%1.notifyImportStarted]", (Object)LOGCLASS, (Throwable)exception);
            }
        }
    }

    public void notifyImportProgressChanged(int n) {
        this.logger.log(1000000, "[%1.notifyImportProgressChanged]", (Object)LOGCLASS);
        Iterator iterator = this.getServices().iterator();
        while (iterator.hasNext()) {
            try {
                ((ITransferStateListener)iterator.next()).importProgressChanged(n);
            }
            catch (Exception exception) {
                this.logger.log(100000, "[%1.notifyImportProgressChanged]", (Object)LOGCLASS, (Throwable)exception);
            }
        }
    }

    public void notifyImportStopped() {
        this.logger.log(1000000, "[%1.notifyImportStopped]", (Object)LOGCLASS);
        Iterator iterator = this.getServices().iterator();
        while (iterator.hasNext()) {
            try {
                ((ITransferStateListener)iterator.next()).importStopped();
            }
            catch (Exception exception) {
                this.logger.log(100000, "[%1.notifyImportStopped]", (Object)LOGCLASS, (Throwable)exception);
            }
        }
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

