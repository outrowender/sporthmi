/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw;

import de.audi.app.bap.IPowerState;
import de.audi.app.bap.dsi.bap.IDSIBAPController;
import de.audi.app.bap.fw.AbstractBAPModule;
import de.audi.app.bap.fw.IBAPModuleInitializationManager;
import de.audi.app.bap.fw.IInitStateListener;
import de.audi.app.bap.utils.LSGIDs;
import de.audi.app.bap.utils.LoggingUtils;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandListManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractBAPModuleInitializationManager
implements IBAPModuleInitializationManager {
    public static final int FSG_OPERATION_STATE_NORMAL_OPERATION = 0;
    public static final int FSG_OPERATION_STATE_OFF_STAND_BY = 1;
    public static final int FSG_OPERATION_STATE_INITIALIZING = 2;
    public static final int FSG_OPERATION_STATE_DEFECT = 3;
    public static final int INIT_STATE_FAILED = -1;
    public static final int INIT_STATE_WAITING_FOR_BAP_STACK = 0;
    public static final int INIT_STATE_WAITING_FOR_APP_SERVICE = 1;
    public static final int INIT_STATE_WAITING_FOR_HMI_STATE_INITIALIZING_ACKNOWLEDGE = 2;
    public static final int INIT_STATE_INITIALIZED = 9;
    public static final int INIT_STATE_WAITING_FOR_HMI_STATE_READY_ACKNOWLEDGE = 10;
    public static final int INIT_STATE_COMPLETED = 11;
    protected static final int MAX_INIT_FAILS = 5;
    protected final AbstractBAPModule module;
    protected final CommandListManager cmdListManager;
    protected final IDSIBAPController dsiController;
    private final List initStateListeners;
    private volatile int bapStackState = 0;
    private volatile int hmiState = 0;
    private volatile int appState = 0;
    protected final IPowerState powerState;
    private volatile boolean appServiceAvailable = false;
    private volatile boolean dsiBapAvailable = false;
    private volatile boolean swdlRunning = false;
    private volatile int initState = 0;
    protected final LogChannel logChannel;
    protected final String lsgIDDescription;

    protected AbstractBAPModuleInitializationManager(AbstractBAPModule abstractBAPModule, IDSIBAPController iDSIBAPController, IPowerState iPowerState) {
        this.module = abstractBAPModule;
        this.logChannel = abstractBAPModule.getLogChannel();
        this.lsgIDDescription = LSGIDs.getDescription(abstractBAPModule.getLSGID());
        this.dsiController = iDSIBAPController;
        this.initStateListeners = new ArrayList();
        this.powerState = iPowerState;
        this.cmdListManager = new CommandListManager("ModuleInitializationCommandListManager", abstractBAPModule.getFrameworkAccess(), abstractBAPModule.getLogChannel(), null, null);
    }

    public synchronized void addInitStateListener(IInitStateListener iInitStateListener) {
        this.initStateListeners.add(iInitStateListener);
    }

    public int getBapStackState() {
        return this.bapStackState;
    }

    public int getHMIState() {
        return this.hmiState;
    }

    public int getInitState() {
        return this.initState;
    }

    public boolean isAppStateDefect() {
        return AbstractBAPModuleInitializationManager.isAppStateDefect(this.appState);
    }

    protected synchronized void setInitState(int n) {
        this.initState = n;
        this.logChannel.log(10000000, "[AbstractBAPModuleInitializationManager#setInitState] initState for lsgID=%1 changed to %2", (Object)this.lsgIDDescription, (Object)LoggingUtils.getInitStateDescription(n));
        Iterator iterator = this.initStateListeners.iterator();
        while (iterator.hasNext()) {
            ((IInitStateListener)iterator.next()).updateInitState(this.module, n);
        }
    }

    protected int getAppState() {
        return this.appState;
    }

    protected boolean isDsiBapAvailable() {
        return this.dsiBapAvailable;
    }

    protected boolean isSwdlRunning() {
        return this.swdlRunning;
    }

    protected synchronized void processAppStateChanged(int n) {
        if (this.appState != n) {
            this.logChannel.log(1000000, "[AbstractBAPModuleInitializationManager#processAppStateChanged] appState changed for lsgID %1: %2", (Object)LSGIDs.getDescription(this.module.getLSGID()), (long)n);
            this.appState = n;
            if (AbstractBAPModuleInitializationManager.isAppStateDefect(this.appState)) {
                this.updateHMIState();
            } else {
                this.updateOperationState();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void notifyBAPStackStateChanged(int n) {
        boolean bl = false;
        AbstractBAPModuleInitializationManager abstractBAPModuleInitializationManager = this;
        synchronized (abstractBAPModuleInitializationManager) {
            if (this.bapStackState != n) {
                this.logChannel.log(1000000, "[AbstractBAPModuleInitializationManager#notifyBAPStackStateChanged] BAPStack state changed for lsgID %1: %2", (Object)this.lsgIDDescription, (long)n);
                this.bapStackState = n;
                if (n == 0) {
                    bl = true;
                }
                this.updateHMIState();
            }
        }
        if (bl) {
            this.resetInitialization();
            this.updateOperationState();
        }
    }

    public synchronized void notifyAppServiceChanged(boolean bl) {
        if (this.appServiceAvailable != bl) {
            if (bl) {
                this.logChannel.log(1000000, "[AbstractBAPModuleInitializationManager#notifyAppServiceChanged] appService of module with lsgID=%1 is now available", (Object)this.lsgIDDescription);
            } else {
                this.logChannel.log(1000000, "[AbstractBAPModuleInitializationManager#notifyAppServiceChanged] appService of module with lsgID=%1 not available", (Object)this.lsgIDDescription);
            }
            this.appServiceAvailable = bl;
            this.updateHMIState();
        }
    }

    public synchronized void notifyHMIStateAcknowledged() {
        if (this.initState == 2) {
            this.logChannel.log(10000000, "[AbstractBAPModuleInitializationManager#notifyHMIStateAcknowledged] LSG=%1 hmiState is in INITIALIZING state now", (Object)this.lsgIDDescription);
            this.hmiState = 1;
            if (this.isAppStateDefect()) {
                this.updateOperationState();
            } else {
                this.startInitialization();
            }
        } else if (this.initState == 10) {
            this.logChannel.log(10000000, "[AbstractBAPModuleInitializationManager#notifyHMIStateAcknowledged] LSG=%1 hmiState is in RUNNING state now", (Object)this.lsgIDDescription);
            this.hmiState = 2;
            this.setInitState(11);
        } else {
            this.logChannel.log(100000, "[AbstractBAPModuleInitializationManager#notifyHMIStateAcknowledged] hmi state acknowledge ignored (lsgID=%1, initState=%2)", (Object)this.lsgIDDescription, (long)this.initState);
        }
    }

    public synchronized void notifyDSIAvailable(Class clazz, boolean bl) {
        if (this.dsiBapAvailable != bl) {
            this.dsiBapAvailable = bl;
            this.logChannel.log(1000000, "[AbstractBAPModuleInitializationManager#notifyDSIAvailable] dsiAvailability for module %2 changed: %1", this.dsiBapAvailable, (Object)this.lsgIDDescription);
            this.updateHMIState();
            this.updateOperationState();
        } else {
            this.logChannel.log(10000000, "[AbstractBAPModuleInitializationManager#notifyDSIAvailable] dsiAvailability for module %2 already set: %1", this.dsiBapAvailable, (Object)this.lsgIDDescription);
        }
    }

    protected synchronized void updateHMIState() {
        this.updateHMIState(false);
    }

    protected synchronized void updateHMIState(boolean bl) {
        int n;
        this.logChannel.log(1000000, "[AbstractBAPModuleInitializationManager#updateHMIState] called for lsgID=%1", (Object)this.lsgIDDescription);
        if (!this.isDsiBapAvailable()) {
            n = 0;
        } else if (this.bapStackState == 0) {
            n = 0;
            this.setInitState(0);
        } else if (this.bapStackState == 1) {
            if (this.appServiceAvailable) {
                n = this.initState >= 9 ? 2 : 1;
            } else if (this.isAppStateDefect()) {
                n = 1;
            } else {
                n = 0;
                this.setInitState(1);
            }
        } else {
            this.logChannel.log(10000, "[AbstractBAPModuleInitializationManager#updateHMIState] module: %1 invalid bapStackState: %2", (Object)this.lsgIDDescription, (long)this.bapStackState);
            return;
        }
        if (this.hmiState != n || bl) {
            this.logChannel.log(1000000, "[AbstractBAPModuleInitializationManager#updateHMIState] new hmi state is: %1 (bapStackState=%2, appServiceAvailable=%3 dsiAvailability=%4)", (Object)LoggingUtils.getHMIStateDescription(n), (Object)new Integer(this.bapStackState), (Object)this.appServiceAvailable, (Object)this.dsiBapAvailable);
            if (n == 1) {
                this.setInitState(2);
            } else if (n == 2) {
                this.setInitState(10);
            } else {
                this.hmiState = n;
            }
            this.dsiController.setHMIState(this.module.getLSGID(), n);
        } else {
            this.logChannel.log(10000000, "[AbstractBAPModuleInitializationManager#updateHMIState] hmi state didn't change (hmiState=%1, bapStackState=%2, appServiceAvailable=%3 dsiAvailability=%4)", (Object)new Integer(this.hmiState), (Object)new Integer(this.bapStackState), (Object)this.appServiceAvailable, (Object)this.dsiBapAvailable);
        }
    }

    protected synchronized void setHMIState(int n) {
        this.hmiState = n;
    }

    public synchronized void processMsg(int n) {
        if (n == 5 || n == 6) {
            if (this.module.bapApplication.getFrameworkAccess().getSysApp().isEngineeringDownloadActive()) {
                this.logChannel.log(10000000, "[AbstractBAPModuleInitializationManager#processMsg] SWDL started/running");
                this.swdlRunning = true;
                this.updateOperationState();
            }
        } else if ((n == 9 || n == 7) && this.module.bapApplication.getFrameworkAccess().getSysApp().isEngineeringDownloadActive()) {
            this.logChannel.log(10000000, "[AbstractBAPModuleInitializationManager#processMsg] SWDL finished");
            this.swdlRunning = false;
            this.updateOperationState();
        }
    }

    protected abstract void startInitialization();

    protected abstract void resetInitialization();

    private static boolean isAppStateDefect(int n) {
        return n != 0 && n != 1;
    }
}

