/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.customer;

import de.audi.atip.base.ComponentStateListener;
import de.audi.tghu.swdl.app.SwdlEnv;

public abstract class AbstractDriverResetHandler
implements ComponentStateListener {
    private final SwdlEnv swdlEnv;
    private boolean waitMediaIsRunning = false;

    public AbstractDriverResetHandler(SwdlEnv swdlEnv) {
        this.swdlEnv = swdlEnv;
    }

    protected SwdlEnv getSwdlEnv() {
        return this.swdlEnv;
    }

    public boolean isResetInProgress() {
        return this.getSwdlEnv().isResetDriverActiv();
    }

    protected void setResetInProgress(boolean bl) {
        this.getSwdlEnv().getHMIService().getChoiceModel(543).setValue(bl ? 1 : 0);
    }

    protected void doResetDriver(int n) {
        Thread.currentThread().setName(Thread.currentThread().getName() + "CustomerUpdate:DriverResetHandler");
        this.waitMediaIsRunning = true;
        this.getSwdlEnv().getMsgDistributor().sendMessage(89);
    }

    public void appStateChanged(String string, int n) {
        if (this.waitMediaIsRunning && "Media".equalsIgnoreCase(string) && 1 == n) {
            this.getSwdlEnv().getLogDSI().log(10000000, "AbstractDriverResetHandler.appStateChanged(%1, %2): STOP reset driver", (Object)string, (long)n);
            this.stopReset();
        }
    }

    protected void stopReset() {
        this.setResetInProgress(false);
        this.waitMediaIsRunning = false;
    }

    public abstract void handleDriverResetError(int var1);

    public void resetDriver(final int n) {
        if (!this.isResetInProgress()) {
            this.getSwdlEnv().getLogDSI().log(10000, "DriverResetHandler::resetDriver()");
            this.setResetInProgress(true);
            this.getSwdlEnv().getSwdlModels().getResetDriverButton().setStatus(0);
            this.getSwdlEnv().executeInUtilThread(new Runnable(){

                public void run() {
                    AbstractDriverResetHandler.this.doResetDriver(n);
                }
            });
            this.getSwdlEnv().getSwdlModels().getResetDriverButton().fireEvent(n);
            this.getSwdlEnv().getSwdlModels().getResetDriverButton().setStatus(1);
        } else {
            this.getSwdlEnv().getLogDSI().log(10000, "DriverResetHandler::resetDriver(): Resetting of driver is already in progress! No new driver reset can be started.", (Throwable)new Exception());
        }
    }
}

