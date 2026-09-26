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
    private static final String LOGCLASS;
    static /* synthetic */ Class class$de$audi$app$media$interapp$ITransferStateListener;

    public TransferStateNotifier(LogChannel logChannel, IServiceManager iServiceManager) {
        super(logChannel, iServiceManager);
    }

    @Override
    protected Class getTrackedServiceClass() {
        return class$de$audi$app$media$interapp$ITransferStateListener == null ? (class$de$audi$app$media$interapp$ITransferStateListener = TransferStateNotifier.class$("de.audi.app.media.interapp.ITransferStateListener")) : class$de$audi$app$media$interapp$ITransferStateListener;
    }

    @Override
    protected void serviceAdded(Object object) {
    }

    @Override
    protected void serviceRemoved(Object object) {
    }

    @Override
    protected boolean checkServiceProperties(Dictionary dictionary) {
        return true;
    }

    public void notifyImportStarted(ISourceSlot iSourceSlot) {
        this.logger.log(1078071040, "[%1.notifyImportStarted] '%2'", (Object)"TransferStateNotifier", (Object)iSourceSlot);
        Iterator iterator = this.getServices().iterator();
        while (iterator.hasNext()) {
            try {
                ((ITransferStateListener)iterator.next()).importStarted(iSourceSlot);
            }
            catch (Exception exception) {
                this.logger.log(-1601830656, "[%1.notifyImportStarted]", (Object)"TransferStateNotifier", (Throwable)exception);
            }
        }
    }

    public void notifyImportProgressChanged(int n) {
        this.logger.log(1078071040, "[%1.notifyImportProgressChanged]", (Object)"TransferStateNotifier");
        Iterator iterator = this.getServices().iterator();
        while (iterator.hasNext()) {
            try {
                ((ITransferStateListener)iterator.next()).importProgressChanged(n);
            }
            catch (Exception exception) {
                this.logger.log(-1601830656, "[%1.notifyImportProgressChanged]", (Object)"TransferStateNotifier", (Throwable)exception);
            }
        }
    }

    public void notifyImportStopped() {
        this.logger.log(1078071040, "[%1.notifyImportStopped]", (Object)"TransferStateNotifier");
        Iterator iterator = this.getServices().iterator();
        while (iterator.hasNext()) {
            try {
                ((ITransferStateListener)iterator.next()).importStopped();
            }
            catch (Exception exception) {
                this.logger.log(-1601830656, "[%1.notifyImportStopped]", (Object)"TransferStateNotifier", (Throwable)exception);
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

