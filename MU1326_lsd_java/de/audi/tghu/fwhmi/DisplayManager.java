/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.fwhmi;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.event.ATIPEvent;
import de.audi.atip.hmi.event.ATIPEventListener;
import de.audi.atip.hmi.event.ActiveContextEvent;
import de.audi.atip.hmi.view.IDisplayListener;
import de.audi.atip.hmi.view.IDisplayManager;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.fwhmi.DSIDisplayListener;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import org.dsi.ifc.displaymanagement.DSIDisplayManagement;
import org.dsi.ifc.displaymanagement.DSIDisplayManagementListener;
import org.dsi.ifc.displaymanagement.DisplayContext;
import org.dsi.ifc.global.ResourceLocator;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public abstract class DisplayManager
implements ServiceTrackerCustomizer,
BundleActivator,
IDisplayManager,
ATIPEventListener {
    private static final int MAX_DISPLAYABLES = 110;
    private static final int WAIT_FOR_CONTEXT_SWITCH = 200;
    private static final int WAIT_FOR_LOCK_RESULT = 1000;
    private static int[] requestedContexts;
    private static int[] confirmedActiveContext;
    private static int[][] displayableOpacities;
    private static int[][][] displayablePositions;
    private static int[] frameDropModes;
    private static int sessionID;
    protected final IFrameworkAccess framework;
    private BundleContext bc;
    protected LogChannel log;
    private volatile boolean initialized;
    private ServiceTracker displayManagerTracker;
    private ServiceReference srDisplayManagement;
    private DSIDisplayManagement dsiDispMgmt;
    private int bufferedContext = -1;
    private int bufferedTerm = -1;
    protected DisplayContext[] dc;
    private DSIDisplayManagementListener dsiDisplayManagementListener;
    private ServiceRegistration srDSIDisplayManagementListener;
    private Object syncDisplayManagement = new Object();
    private IDisplayListener[] displayListeners = new IDisplayListener[8];
    protected Map displayableExtents;
    private int[] sessionIDs = new int[8];
    private boolean[] waitForContextSwitch = new boolean[8];
    private boolean waitForLock = false;
    private boolean waitForUnLock = false;
    private boolean lastCallWasLock = false;
    private boolean[] lastRequestAnswered = new boolean[8];
    static /* synthetic */ Class class$org$dsi$ifc$displaymanagement$DSIDisplayManagementListener;
    static /* synthetic */ Class class$org$dsi$ifc$base$DSIListener;
    static /* synthetic */ Class class$org$dsi$ifc$displaymanagement$DSIDisplayManagement;

    private static void initializeDisplayableMapping() {
        DisplayManager.displayableMapping[0] = 16;
        DisplayManager.displayableMapping[1] = 17;
        DisplayManager.displayableMapping[2] = 18;
        DisplayManager.displayableMapping[3] = 19;
        DisplayManager.displayableMapping[4] = 20;
        DisplayManager.displayableMapping[5] = 21;
        DisplayManager.displayableMapping[7] = 23;
        DisplayManager.displayableMapping[8] = 25;
        DisplayManager.displayableMapping[14] = 34;
        DisplayManager.displayableMapping[9] = 26;
        DisplayManager.displayableMapping[10] = 27;
        DisplayManager.displayableMapping[11] = 28;
        DisplayManager.displayableMapping[12] = 22;
        DisplayManager.displayableMapping[13] = 24;
        DisplayManager.displayableMapping[15] = 36;
        DisplayManager.displayableMapping[16] = 41;
        DisplayManager.displayableMapping[17] = 50;
        DisplayManager.displayableMapping[18] = 39;
    }

    private static void initializeCurrentContexts() {
        for (int i2 = 0; i2 < requestedContexts.length; ++i2) {
            DisplayManager.requestedContexts[i2] = -1;
        }
    }

    public DisplayManager(IFrameworkAccess iFrameworkAccess) {
        this.framework = iFrameworkAccess;
        this.log = iFrameworkAccess.getLogChannel("Fw.Display");
        this.initialized = false;
        this.displayableExtents = new HashMap();
    }

    LogChannel getLogChannel() {
        return this.log;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void displayManagementIsAvailable() {
        Object object = this.syncDisplayManagement;
        synchronized (object) {
            this.syncDisplayManagement.notifyAll();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void waitForDSIDisplayManagement() {
        Object object = this.syncDisplayManagement;
        synchronized (object) {
            this.log.log(10000000, "waitForDSIDisplayManagement: wait up to 5");
            if (!this.initialized) {
                try {
                    this.syncDisplayManagement.wait(5000L);
                }
                catch (InterruptedException interruptedException) {
                    Thread.interrupted();
                }
            }
        }
        if (this.initialized) {
            this.log.log(10000000, "waitForDSIDisplayManagement: succeeded!");
        } else {
            this.log.log(10000, "waitForDSIDisplayManagement: failed!");
            this.framework.getErrorMgr().handleError(null, "waitForDSIDisplayManagement: failed!", 0, 3, 1);
        }
    }

    private final void initDSI() {
        if (!this.initialized) {
            if (this.dsiDispMgmt != null) {
                this.defineContexts();
                this.dsiDispMgmt.declareContexts(this.dc);
                this.configureDM();
                this.initialized = true;
            } else {
                this.log.log(10000, "DSI service is NULL");
            }
        }
    }

    private DisplayContext getContext(int n) {
        int n2 = this.getMappedInternalContext(n);
        if (this.dc != null && this.dc.length > n2 && n2 >= 0) {
            return this.dc[n2];
        }
        return null;
    }

    public int[] getDisplayables(int n) {
        DisplayContext displayContext = this.getContext(n);
        if (displayContext != null) {
            return displayContext.getDisplayableList();
        }
        this.log.log(10000, "no context for ID: %1", (long)n);
        return null;
    }

    public synchronized void switchContext(int n, int n2, IDisplayListener iDisplayListener) {
        int n3 = n;
        this.displayListeners[n2] = iDisplayListener;
        if (n2 == 5) {
            DisplayManager.requestedContexts[n2] = n3;
            return;
        }
        if (this.dsiDispMgmt != null && this.initialized) {
            if (n2 >= 0 && n2 < 8) {
                if (this.lastRequestAnswered[n2] && confirmedActiveContext[n2] != n3 || !this.lastRequestAnswered[n2] && requestedContexts[n2] != n3) {
                    int n4 = this.getInternalDisplayID(n2);
                    int n5 = this.getMappedInternalContext(n3);
                    this.lastRequestAnswered[n2] = false;
                    this.sessionIDs[n2] = ++sessionID;
                    this.log.log(1000000, "DisplayManager#switchContext switch to external context %1 on external terminal %2 ", (long)n3, (long)n2);
                    this.log.log(10000000, "Displaymanager#switchContext using internal terminal %1, internal context %2 for switch, sessionID %3", (long)n4, (long)n5, (long)this.sessionIDs[n2]);
                    this.dsiDispMgmt.switchContext(n5, n4, this.sessionIDs[n2]);
                    this.bufferedContext = -1;
                    this.bufferedTerm = -1;
                    DisplayManager.requestedContexts[n2] = n3;
                    try {
                        this.waitForContextSwitch[n2] = true;
                        this.wait(200L);
                        this.waitForContextSwitch[n2] = false;
                    }
                    catch (InterruptedException interruptedException) {
                        this.log.log(10000, "interrupted while waiting for switch to context %1 on terminal %2", (long)n3, (long)n2);
                        this.waitForContextSwitch[n2] = false;
                    }
                    if (this.lastRequestAnswered[n2]) {
                        this.log.log(10000000, "call for switch to context %1 on terminal %2 succeeded in time inform listener directly", (long)n3, (long)n2);
                        if (this.displayListeners[n2] != null) {
                            int n6 = confirmedActiveContext[n2] % 79;
                            this.displayListeners[n2].activeContext(n6, n2);
                        }
                    } else {
                        this.log.log(10000, "DisplayManager#switchContext last active confirmed context after call for switch to context %1 on terminal %2 is %3 ", (long)n3, (long)n2, (long)confirmedActiveContext[n2]);
                        this.log.log(1000000, "DisplayManager#switchContext trying AGAIN to switch to context %1 on terminal %2 !!!", (long)n3, (long)n2);
                        this.log.log(10000000, "DisplayManager#switchContext using internal terminal %1, internal context %2 for switch", (long)n4, (long)n5);
                        this.dsiDispMgmt.switchContext(n5, n4, this.sessionIDs[n2]);
                    }
                } else {
                    DisplayManager.requestedContexts[n2] = n3;
                }
            } else {
                this.log.log(1000000, "DisplayManager#switchContext terminal with ID: %1 is not a valid terminalID", (long)n2);
            }
        } else if (this.framework.isSimulator()) {
            DisplayManager.requestedContexts[n2] = n3;
            this.lastRequestAnswered[n2] = true;
            DisplayManager.confirmedActiveContext[n2] = n3;
        } else {
            this.log.log(10000, "Displaymanager not initialized");
            this.bufferedContext = n3;
            this.bufferedTerm = n2;
        }
    }

    private int checkContextsForRSE(int n, int n2) {
        int n3 = n;
        if (!this.isVideoOnlyContext(n3)) {
            if (n2 == 4) {
                if (n3 < 35) {
                    this.log.log(10000000, "DisplayManager#switchContext changing requested context: %1  for terminal 2 to: %2", (long)n3, (long)(35 + n3));
                    n3 = 35 + n3;
                }
            } else if (n2 == 0 && n3 >= 35) {
                this.log.log(10000000, "DisplayManager#switchContext changing requested context: %1  for terminal 1 to: %2", (long)n3, (long)(35 - n3));
                n3 = 35 - n3;
            }
        }
        return n3;
    }

    private boolean isVideoOnlyContext(int n) {
        switch (n) {
            case 67: {
                return true;
            }
            case 68: {
                return true;
            }
            case 69: {
                return true;
            }
            case 70: {
                return true;
            }
            case 71: {
                return true;
            }
        }
        return false;
    }

    private int getInternalDisplayID(int n) {
        if (n == 3 || n == 0) {
            return 0;
        }
        if (n == 4 || n == 2) {
            return 1;
        }
        if (n == 1) {
            return 4;
        }
        return 0;
    }

    private int getExternalDisplayID(int n) {
        if (this.framework.isFrontMU()) {
            if (n == 0) {
                return 0;
            }
            return 1;
        }
        if (n == 0) {
            return 3;
        }
        return 4;
    }

    public void lockDisplay(int n) {
        if (this.framework.isSimulator()) {
            return;
        }
        this.log.log(1000000, "DisplayManager: Displaymanager: lockDisplay %1", (long)n);
        if (this.dsiDispMgmt != null && this.initialized) {
            this.dsiDispMgmt.lockDisplay(n);
            this.lastCallWasLock = true;
        } else {
            this.log.log(10000, "Displaymanager not initialized");
        }
    }

    public synchronized void lockDisplayAndWait(int n) {
        if (this.framework.isSimulator()) {
            return;
        }
        this.log.log(1000000, "DisplayManager: Displaymanager: lockDisplayAndWait %1", (long)n);
        if (this.dsiDispMgmt != null && this.initialized) {
            this.dsiDispMgmt.lockDisplay(n);
            this.lastCallWasLock = true;
            try {
                this.waitForLock = true;
                this.wait(1000L);
                this.log.log(10000000, "DisplayManager#lockDisplay now continue");
                this.waitForLock = false;
            }
            catch (InterruptedException interruptedException) {
                this.log.log(10000, "interrupted while waiting for lock callback on terminal %1", (long)n);
                this.waitForLock = false;
            }
        } else {
            this.log.log(10000, "Displaymanager not initialized");
        }
    }

    public void unlockDisplay(int n) {
        if (this.framework.isSimulator()) {
            return;
        }
        this.log.log(1000000, "DisplayManager: Displaymanager: unlockDisplay %1", (long)n);
        if (!this.lastCallWasLock) {
            this.log.log(1000000, "DisplayManager: unlockDisplay not calling unlock because lock was not called before");
            return;
        }
        if (this.dsiDispMgmt != null && this.initialized) {
            this.dsiDispMgmt.unlockDisplay(n);
            this.lastCallWasLock = false;
        } else {
            this.log.log(10000, "Displaymanager not initialized");
        }
    }

    public synchronized void unlockDisplayAndWait(int n) {
        if (this.framework.isSimulator()) {
            return;
        }
        this.log.log(1000000, "DisplayManager: Displaymanager: unlockDisplayAndWait %1", (long)n);
        if (!this.lastCallWasLock) {
            this.log.log(1000000, "DisplayManager: unlockDisplayAndWait not calling unlock because lock was not called before");
            return;
        }
        if (this.dsiDispMgmt != null && this.initialized) {
            this.dsiDispMgmt.unlockDisplay(n);
            this.lastCallWasLock = false;
            try {
                this.waitForUnLock = true;
                this.wait(1000L);
                this.log.log(10000000, "DisplayManager#unlockDisplay now continue");
                this.waitForUnLock = false;
            }
            catch (InterruptedException interruptedException) {
                this.log.log(10000, "interrupted while waiting for unlock callback on terminal %1", (long)n);
                this.waitForUnLock = false;
            }
        } else {
            this.log.log(10000, "Displaymanager not initialized");
        }
    }

    public synchronized int getCurrentContextID(int n) {
        if (n >= 0 && n < 8) {
            if (this.lastRequestAnswered[n]) {
                return confirmedActiveContext[n];
            }
            return requestedContexts[n];
        }
        this.log.log(1000000, "DisplayManager:getCurrentContextID terminal with ID: %1 is not a valid terminalID", (long)n);
        return -1;
    }

    public void setOpacity(int n, int n2, int n3) {
        if (this.framework.isSimulator()) {
            return;
        }
        if (n2 == 5) {
            return;
        }
        this.log.log(10000000, "DisplayManager#setOpacity displayable: %1, opacity: %2", (long)n, (long)n3);
        int n4 = this.getInternalDisplayID(n2);
        this.log.log(10000000, "DisplayManager#setOpacity using internal terminal %1 for setOpacity", (long)n4);
        if (displayableOpacities[n2][n] != n3) {
            this.dsiDispMgmt.setOpacity(n, n4, n3);
            DisplayManager.displayableOpacities[n2][n] = n3;
        } else {
            this.log.log(10000000, "DisplayManager#setOpacity displayable %1 on terminal %2 already has opacity %3", (long)n, (long)n4, (long)n3);
        }
    }

    public void fadeToOpacity(int n, int n2, int n3, int n4) {
        if (this.dsiDispMgmt != null && this.initialized) {
            this.log.log(10000000, "DisplayManager#fadeToOpacity displayable: %1, opacity: %2, time: %3", (long)n, (long)n3, (long)n4);
            this.dsiDispMgmt.fadeToOpacity(n, n2, n3, n4);
        } else {
            this.log.log(10000, "Displaymanager not initialized");
        }
    }

    public void takeScreenshot(int n, String string) {
        if (n == 5) {
            return;
        }
        this.log.log(1000000, "DisplayManager: Displaymanager: take s screenshot!");
        if (this.dsiDispMgmt != null && this.initialized) {
            int n2 = this.getInternalDisplayID(n);
            this.log.log(10000000, "DisplayManager#takeScreenshot using internal terminal %1 for takeScreenShot", (long)n2);
            System.err.println(new StringBuffer().append("DisplayManager#takeScreenshot() filename: ").append(string).toString());
            this.dsiDispMgmt.takeScreenshot(n2, string);
        } else {
            this.log.log(10000, "Displaymanager not initialized");
            System.err.println("DisplayManager#takeScreenshot() Displaymanager not initialized!");
        }
    }

    public void setDisplayBrightness(int n, int n2) {
        if (this.dsiDispMgmt != null && this.initialized) {
            this.log.log(10000000, "DisplayManager.setDisplayBrightness displayID = %1, percentage = %2", (long)n, (long)n2);
            int n3 = this.getInternalDisplayID(n);
            this.log.log(10000000, "DisplayManager#setDisplayBrightness using internal terminal %1 for setDisplayBrightness", (long)n3);
            this.dsiDispMgmt.setDisplayBrightness(n3, n2);
        } else {
            this.log.log(10000, "Displaymanager not initialized");
        }
    }

    public synchronized Object addingService(ServiceReference serviceReference) {
        this.srDisplayManagement = serviceReference;
        this.dsiDispMgmt = (DSIDisplayManagement)this.bc.getService(serviceReference);
        this.initDSI();
        if (this.bufferedContext != -1 && this.bufferedTerm != -1) {
            this.switchContext(this.bufferedContext, this.bufferedTerm, this.displayListeners[this.bufferedTerm]);
            this.log.log(10000000, "switched to buffered context: %1 on terminal: %2", (long)this.bufferedContext, (long)this.bufferedTerm);
            this.bufferedContext = -1;
            this.bufferedTerm = -1;
        }
        this.displayManagementIsAvailable();
        return this.dsiDispMgmt;
    }

    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    public void removedService(ServiceReference serviceReference, Object object) {
        this.bc.ungetService(serviceReference);
        this.srDisplayManagement = null;
        this.dsiDispMgmt = null;
        this.initialized = false;
    }

    public void start(BundleContext bundleContext) {
        this.log.log(10000000, "start");
        this.bc = bundleContext;
        Hashtable hashtable = new Hashtable();
        hashtable.put("DEVICE_NAME", (class$org$dsi$ifc$displaymanagement$DSIDisplayManagementListener == null ? (class$org$dsi$ifc$displaymanagement$DSIDisplayManagementListener = DisplayManager.class$("org.dsi.ifc.displaymanagement.DSIDisplayManagementListener")) : class$org$dsi$ifc$displaymanagement$DSIDisplayManagementListener).getName());
        hashtable.put("DEVICE_INSTANCE", new Integer(0));
        this.dsiDisplayManagementListener = new DSIDisplayListener(this);
        this.srDSIDisplayManagementListener = bundleContext.registerService((class$org$dsi$ifc$base$DSIListener == null ? (class$org$dsi$ifc$base$DSIListener = DisplayManager.class$("org.dsi.ifc.base.DSIListener")) : class$org$dsi$ifc$base$DSIListener).getName(), (Object)this.dsiDisplayManagementListener, (Dictionary)hashtable);
        this.displayManagerTracker = new ServiceTracker(this.bc, (class$org$dsi$ifc$displaymanagement$DSIDisplayManagement == null ? (class$org$dsi$ifc$displaymanagement$DSIDisplayManagement = DisplayManager.class$("org.dsi.ifc.displaymanagement.DSIDisplayManagement")) : class$org$dsi$ifc$displaymanagement$DSIDisplayManagement).getName(), (ServiceTrackerCustomizer)this);
        this.displayManagerTracker.open();
        if (this.framework.isTarget()) {
            this.waitForDSIDisplayManagement();
        }
    }

    public void stop(BundleContext bundleContext) {
        this.initialized = false;
        if (this.displayManagerTracker != null) {
            this.displayManagerTracker.close();
            this.displayManagerTracker = null;
        }
        if (this.srDisplayManagement != null) {
            bundleContext.ungetService(this.srDisplayManagement);
            this.srDisplayManagement = null;
            this.dsiDispMgmt = null;
        }
        if (this.srDSIDisplayManagementListener != null) {
            this.srDSIDisplayManagementListener.unregister();
            this.srDSIDisplayManagementListener = null;
        }
    }

    public void setPosition(int n, int n2, int n3, int n4) {
        if (this.framework.isSimulator()) {
            return;
        }
        if (n2 == 5) {
            return;
        }
        if (this.dsiDispMgmt != null && this.initialized) {
            this.log.log(10000000, "DisplayManager#setPosition displayable: %1, xPos: %2 , yPos: %3", (long)n, (long)n3, (long)n4);
            int n5 = this.getInternalDisplayID(n2);
            this.log.log(10000000, "DisplayManager#setPosition using internal terminal %1 for setPosition", (long)n5);
            if (displayablePositions[n2][n][0] != n3 || displayablePositions[n2][n][1] != n4) {
                this.dsiDispMgmt.setPosition(n, n5, n3, n4);
                DisplayManager.displayablePositions[n2][n][0] = n3;
                DisplayManager.displayablePositions[n2][n][1] = n4;
            } else {
                this.log.log(10000000, "DisplayManager#setPosition displayable %1 on terminal %2 already has desired position", (long)n, (long)n5);
            }
        } else {
            this.log.log(10000, "Displaymanager not initialized");
        }
    }

    public int[] getPosition(int n, int n2) {
        return displayablePositions[n2][n];
    }

    public int getOpacity(int n, int n2) {
        return displayableOpacities[n2][n];
    }

    protected synchronized void setActiveContext(int n, int n2, int n3) {
        int n4 = this.getExternalDisplayID(n2);
        int n5 = this.getMappedExternalContext(n);
        this.log.log(10000000, "DisplayManager#setActiveContext confirmed external active context: %1 for external terminal %2", (long)n, (long)n4);
        if (this.sessionIDs[n4] != n3 && n3 > 0) {
            this.log.log(100000, "DisplayManager#setActiveContext activeContext for terminal: %1 is confirmed for sessionID: %2, but newest session is: %3", (long)n4, (long)n3, (long)this.sessionIDs[n4]);
        } else {
            DisplayManager.confirmedActiveContext[n4] = n5;
            this.lastRequestAnswered[n4] = true;
            if (!this.waitForContextSwitch[n4] && this.displayListeners[n4] != null) {
                ActiveContextEvent activeContextEvent = new ActiveContextEvent(this, n4, n5, n3, this.displayListeners[n4]);
                this.log.log(10000000, "DisplayManager#processEvent confirmation for context: %1 for external terminal %2 comes late, now post event", (long)n5, (long)n4);
                this.framework.getHMIService().getEventDispatcher().postEvent(activeContextEvent);
            }
        }
        this.notifyAll();
    }

    protected synchronized void lockDisplayResult(int n) {
        this.log.log(10000000, "DisplayManager#lockDisplayResult received resultCode: %1", (long)n);
        if (!this.waitForLock) {
            this.log.log(10000000, "DisplayManager#lockDisplayResult received but not waiting for result any more");
        } else {
            this.notifyAll();
        }
    }

    protected synchronized void unlockDisplayResult(int n) {
        this.log.log(10000000, "DisplayManager#unlockDisplayResult received resultCode: %1", (long)n);
        if (!this.waitForUnLock) {
            this.log.log(10000000, "DisplayManager#unlockDisplayResult received but not waiting for result any more");
        } else {
            this.notifyAll();
        }
    }

    public synchronized void processEvent(ATIPEvent aTIPEvent) {
        int n = ((ActiveContextEvent)aTIPEvent).getSessionID();
        int n2 = ((ActiveContextEvent)aTIPEvent).getTerminal();
        this.log.log(10000000, "DisplayManager#processEvent process delayed confirmed context: %1 for external terminal %2", (Object)confirmedActiveContext, (long)n2);
        if (n == this.sessionIDs[n2]) {
            IDisplayListener iDisplayListener = ((ActiveContextEvent)aTIPEvent).getDisplayListener();
            int n3 = ((ActiveContextEvent)aTIPEvent).getActiveContext() % 79;
            iDisplayListener.activeContext(n3, n2);
        } else {
            this.log.log(10000000, "DisplayManager#processEvent delayed confirmed context: %1 for external terminal %2 has old sessionID,  is not processed further", (Object)confirmedActiveContext, (long)n2);
        }
    }

    protected abstract int getMappedInternalContext(int var1);

    protected abstract int getMappedExternalContext(int var1);

    protected abstract void defineContexts();

    protected abstract void configureDM();

    public void setDisplayType(int n, int n2) {
        if (this.dsiDispMgmt != null && this.initialized) {
            this.log.log(10000000, "DisplayManager.setDisplayType displayID = %1, type = %2", (long)n, (long)n2);
            int n3 = this.getInternalDisplayID(n);
            this.log.log(10000000, "DisplayManager#setUpdateRate using internal terminal %1 for setDisplayBrightness", (long)n3);
            this.dsiDispMgmt.setDisplayType(n3, n2);
        } else {
            this.log.log(10000, "Displaymanager not initialized");
        }
    }

    public void setUpdateRate(int n, int n2) {
        if (this.dsiDispMgmt != null && this.initialized) {
            this.log.log(10000000, "DisplayManager.setUpdateRate displayID = %1, updateRate = %2", (long)n, (long)n2);
            int n3 = this.getInternalDisplayID(n);
            this.log.log(10000000, "DisplayManager#setUpdateRate using internal terminal %1 for setUpdateRate", (long)n3);
            this.dsiDispMgmt.setUpdateRate(n3, n2);
        } else {
            this.log.log(10000, "Displaymanager not initialized");
        }
    }

    public void createImageDisplayable(ResourceLocator resourceLocator, int n) {
        this.setupImageDisplayable(resourceLocator, n, false);
    }

    private void setupImageDisplayable(ResourceLocator resourceLocator, int n, boolean bl) {
        if (this.framework.getKombiType() == 4) {
            this.log.log(10000000, "DisplayManager.createImageDisplayable not supported for TT, not calling not existent method on DSI");
            return;
        }
        if (this.dsiDispMgmt != null) {
            this.log.log(10000000, "DisplayManager.createImageDisplayable displayable = %2, path = %1", (Object)resourceLocator.getUrl(), (long)n);
            if (bl) {
                this.dsiDispMgmt.requestUpdateImageDisplayable(resourceLocator, n);
            } else {
                this.dsiDispMgmt.createImageDisplayable(resourceLocator, n);
            }
        } else {
            this.log.log(10000, "Displaymanager not initialized");
        }
    }

    public void updateImageDisplayable(ResourceLocator resourceLocator, int n) {
        this.setupImageDisplayable(resourceLocator, n, true);
    }

    public int[] getExtends(int n) {
        this.log.log(10000000, "DisplayManager.getExtends displayable = %1", (long)n);
        Object object = this.displayableExtents.get(new Integer(n));
        if (object != null) {
            return (int[])object;
        }
        this.dsiDispMgmt.getExtents(n);
        return null;
    }

    public void setCropping(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10) {
        if (this.framework.isSimulator()) {
            return;
        }
        if (this.dsiDispMgmt != null && this.initialized) {
            this.log.log(10000000, "DisplayManager#setCropping displayable: %1, srcX: %2, srcY: %3", (long)n, (long)n3, (long)n4);
            int n11 = this.getInternalDisplayID(n2);
            this.log.log(10000000, "DisplayManager#setCropping using internal terminal %1 for setCropping", (long)n11);
            this.dsiDispMgmt.setCropping(n11, n, n3, n4, n5, n6, n7, n8, n9, n10);
            DisplayManager.displayablePositions[n11][n][0] = n7;
            DisplayManager.displayablePositions[n11][n][1] = n8;
        } else {
            this.log.log(10000, "Displaymanager#setCropping dm not initialized");
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

    static {
        int n;
        int n2;
        requestedContexts = new int[8];
        confirmedActiveContext = new int[8];
        displayableOpacities = new int[8][110];
        displayablePositions = new int[8][110][2];
        frameDropModes = new int[8];
        sessionID = 0;
        DisplayManager.initializeDisplayableMapping();
        DisplayManager.initializeCurrentContexts();
        for (n2 = 0; n2 < confirmedActiveContext.length; ++n2) {
            DisplayManager.confirmedActiveContext[n2] = -1;
        }
        for (n2 = 0; n2 < displayableOpacities.length; ++n2) {
            for (n = 0; n < displayableOpacities[n2].length; ++n) {
                DisplayManager.displayableOpacities[n2][n] = 100;
            }
        }
        for (n2 = 0; n2 < displayablePositions.length; ++n2) {
            for (n = 0; n < displayablePositions[n2].length; ++n) {
                DisplayManager.displayablePositions[n2][n] = new int[]{0, 0};
            }
        }
    }
}

