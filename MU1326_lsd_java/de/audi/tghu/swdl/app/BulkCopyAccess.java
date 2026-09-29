/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app;

import de.audi.atip.bulkcopy.BulkCopyException;
import de.audi.atip.bulkcopy.IBulkCopyClient;
import de.audi.atip.bulkcopy.IBulkCopyManager;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.swdl.app.SwdlEnv;
import de.audi.tghu.swdl.app.SwdlModels;

public class BulkCopyAccess
implements IBulkCopyClient {
    private static final String CLASSNAME;
    private final SwdlEnv swdlEnv;
    private final Object bulkCopySync = new Object();
    private IBulkCopyManager bulkCopyManager = null;
    private int bulkCopyClientStateCache = 0;

    public BulkCopyAccess(SwdlEnv swdlEnv) {
        this.swdlEnv = swdlEnv;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setBulkCopyManager(IBulkCopyManager iBulkCopyManager) {
        Object object = this.bulkCopySync;
        synchronized (object) {
            this.bulkCopyManager = iBulkCopyManager;
            if (this.getSwdlEnv().isUpdateOverTheAirFeatureEnabled() && this.getSwdlModels().getSwdlInProgressChoice().getValue() <= 0) {
                this.getLogMain().log(1078071040, "%1.setBulkCopyManager(): Uota is allowed, lock bulkCopyManager", (Object)"BulkCopyAccess");
                this.setInitialBulkCopyClientState(3);
                this.bulkCopyClientStateCache = 3;
            } else if (this.bulkCopyClientStateCache != 0) {
                this.setInitialBulkCopyClientState(this.bulkCopyClientStateCache);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setInitialBulkCopyClientState(int n) {
        Object object = this.bulkCopySync;
        synchronized (object) {
            if (this.bulkCopyClientStateCache != 3) {
                if (null != this.bulkCopyManager) {
                    try {
                        this.bulkCopyManager.setClientState(this, n);
                    }
                    catch (BulkCopyException bulkCopyException) {
                        this.getLogMain().log(10000, "%1.setInitialBulkCopyClientState: Failed to set client state of BulkCopyClient!", (Object)"BulkCopyAccess", (Throwable)bulkCopyException);
                    }
                    this.bulkCopyClientStateCache = 0;
                } else {
                    this.bulkCopyClientStateCache = n;
                }
            }
        }
    }

    public boolean bulkCopyLock() {
        if (null != this.bulkCopyManager) {
            return this.bulkCopyManager.lock(this);
        }
        return false;
    }

    public boolean bulkCopyUnlock() {
        if (null != this.bulkCopyManager) {
            return this.bulkCopyManager.unlock(this);
        }
        return false;
    }

    @Override
    public int getClientType() {
        return 1;
    }

    @Override
    public void onChangeStateBulkCopy(int n, int n2) {
        this.getLogMain().log(1078071040, "%1 onChangeStateBulkCopy(%2, %3)", (Object)"BulkCopyAccess", (long)n, (long)n2);
        if (4 == n || this.getSwdlEnv().isCustomerDownloadActive()) {
            this.getLogMain().log(-2137614336, "%1 onChangeStateBulkCopy: enable customer update button", (Object)"BulkCopyAccess");
            this.getSwdlModels().getCustDlDisabledChoice(0).setValue(0);
        } else {
            this.getLogMain().log(-2137614336, "%1 onChangeStateBulkCopy: disable customer update button", (Object)"BulkCopyAccess");
            this.getSwdlModels().getCustDlDisabledChoice(0).setValue(1);
        }
    }

    private SwdlEnv getSwdlEnv() {
        return this.swdlEnv;
    }

    private LogChannel getLogMain() {
        return this.getSwdlEnv().getLogMain();
    }

    private SwdlModels getSwdlModels() {
        return this.getSwdlEnv().getSwdlModels();
    }
}

