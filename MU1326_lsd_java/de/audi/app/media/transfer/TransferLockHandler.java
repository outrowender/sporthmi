/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.transfer;

import de.audi.app.media.osgi.IServiceManager;
import de.audi.app.media.osgi.IServiceTracker;
import de.audi.app.media.transfer.ITransferLockListener;
import de.audi.app.media.transfer.TransferLockHandler$1;
import de.audi.app.media.transfer.TransferLogger;
import de.audi.atip.bulkcopy.BulkCopyException;
import de.audi.atip.bulkcopy.IBulkCopyClient;
import de.audi.atip.bulkcopy.IBulkCopyManager;
import java.util.Hashtable;
import org.osgi.framework.ServiceRegistration;

public class TransferLockHandler
implements IBulkCopyClient {
    private static final String LOGCLASS;
    private final TransferLogger logger;
    private ITransferLockListener transferLockListener;
    private volatile IBulkCopyManager bulkCopyManager = null;
    private volatile boolean importActive = false;
    private volatile boolean clientStateSend = false;
    private final Object bulkCopySync = new Object();
    private final IServiceTracker bulkCopyManagerTracker;
    private volatile ServiceRegistration bulkCopyClientService;
    private final IServiceManager serviceManager;
    static /* synthetic */ Class class$de$audi$atip$bulkcopy$IBulkCopyManager;
    static /* synthetic */ Class class$de$audi$atip$bulkcopy$IBulkCopyClient;

    protected TransferLockHandler(IServiceManager iServiceManager, TransferLogger transferLogger) {
        this.logger = transferLogger;
        this.serviceManager = iServiceManager;
        this.bulkCopyManagerTracker = iServiceManager.createServiceTracker(class$de$audi$atip$bulkcopy$IBulkCopyManager == null ? (class$de$audi$atip$bulkcopy$IBulkCopyManager = TransferLockHandler.class$("de.audi.atip.bulkcopy.IBulkCopyManager")) : class$de$audi$atip$bulkcopy$IBulkCopyManager, new TransferLockHandler$1(this));
    }

    protected void init() {
        this.logger.hmi().log(1078071040, "[%1.init]", (Object)"TransferLockHandler");
        this.importActive = false;
        this.clientStateSend = false;
        this.bulkCopyManagerTracker.open();
        this.bulkCopyClientService = this.serviceManager.registerService(class$de$audi$atip$bulkcopy$IBulkCopyClient == null ? (class$de$audi$atip$bulkcopy$IBulkCopyClient = TransferLockHandler.class$("de.audi.atip.bulkcopy.IBulkCopyClient")) : class$de$audi$atip$bulkcopy$IBulkCopyClient, this, new Hashtable(0));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void deinit() {
        this.logger.hmi().log(1078071040, "[%1.deinit]", (Object)"TransferLockHandler");
        this.bulkCopyManagerTracker.close();
        this.bulkCopyClientService.unregister();
        if (this.transferLockListener != null) {
            this.transferLockListener.unblockImportFunctionality();
        }
        Object object = this.bulkCopySync;
        synchronized (object) {
            this.bulkCopyManager = null;
            this.importActive = false;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void setBulkCopyManager(IBulkCopyManager iBulkCopyManager) {
        this.logger.hmi().log(1078071040, "[%1.setBulkCopyManager]", (Object)"TransferLockHandler");
        Object object = this.bulkCopySync;
        synchronized (object) {
            this.bulkCopyManager = iBulkCopyManager;
            if (this.bulkCopyManager != null && this.importActive) {
                try {
                    this.bulkCopyManager.setClientState(this, 3);
                    this.clientStateSend = true;
                }
                catch (BulkCopyException bulkCopyException) {
                    this.logger.hmi().log(1078071040, "[%1.setBulkCopyManager] exception occured during setting clientState to BUSY", (Object)"TransferLockHandler", (Throwable)bulkCopyException);
                }
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean importActive(boolean bl) {
        this.logger.hmi().log(1078071040, "[%2.importActive] '%1'", bl, (Object)"TransferLockHandler");
        Object object = this.bulkCopySync;
        synchronized (object) {
            if (this.bulkCopyManager != null) {
                if (bl) {
                    if (!this.clientStateSend) {
                        try {
                            this.bulkCopyManager.setClientState(this, 3);
                            this.clientStateSend = true;
                        }
                        catch (BulkCopyException bulkCopyException) {
                            this.logger.hmi().log(1078071040, "[%1.importActive] exception occured during setting clientState to BUSY", (Object)"TransferLockHandler", (Throwable)bulkCopyException);
                            return false;
                        }
                    } else if (!this.bulkCopyManager.lock(this)) {
                        this.importActive = false;
                        if (this.transferLockListener != null) {
                            this.transferLockListener.blockImportFunctionality();
                        }
                        this.logger.hmi().log(-1601830656, "[%1.importActive] other resource has locks. aborting import.", (Object)"TransferLockHandler");
                        return false;
                    }
                } else if (!this.clientStateSend) {
                    try {
                        this.bulkCopyManager.setClientState(this, 4);
                        this.clientStateSend = true;
                    }
                    catch (BulkCopyException bulkCopyException) {
                        this.logger.hmi().log(1078071040, "[%1.importActive] exception occured during setting clientState to IDLE", (Object)"TransferLockHandler", (Throwable)bulkCopyException);
                        return false;
                    }
                } else {
                    this.bulkCopyManager.unlock(this);
                }
            } else {
                this.logger.hmi().log(1078071040, "[%1.importActive] no lock manager available", (Object)"TransferLockHandler");
            }
            this.importActive = bl;
        }
        return true;
    }

    public void setTransferLockListener(ITransferLockListener iTransferLockListener) {
        this.logger.main().log(1078071040, "[%1.setTransferLockListener]", (Object)"TransferLockHandler");
        this.transferLockListener = iTransferLockListener;
    }

    @Override
    public int getClientType() {
        return 2;
    }

    @Override
    public void onChangeStateBulkCopy(int n, int n2) {
        this.logger.hmi().log(1078071040, "[%1.onChangeStateBulkCopy] state='%2', initiatedByType='%3'", (Object)"TransferLockHandler", (long)n, (long)n2);
        if (n == 3) {
            this.transferLockListener.blockImportFunctionality();
        } else if (n == 4) {
            this.transferLockListener.unblockImportFunctionality();
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

    static /* synthetic */ TransferLogger access$000(TransferLockHandler transferLockHandler) {
        return transferLockHandler.logger;
    }

    static /* synthetic */ IServiceManager access$100(TransferLockHandler transferLockHandler) {
        return transferLockHandler.serviceManager;
    }

    static /* synthetic */ void access$200(TransferLockHandler transferLockHandler, IBulkCopyManager iBulkCopyManager) {
        transferLockHandler.setBulkCopyManager(iBulkCopyManager);
    }
}

