/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.evo.joker;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.core.joker.AbstractJokerKeyComponent;
import de.audi.atip.base.ComponentStateListener;
import de.audi.atip.hmi.modelaccess.sysconst.SysConstModelApp;

public class JokerKeyComponentEvo
extends AbstractJokerKeyComponent
implements ComponentStateListener {
    public JokerKeyComponentEvo(ICarApplication iCarApplication) {
        super(iCarApplication);
    }

    public void init() {
        super.init();
        this.getApplication().getFrameworkAccess().getAppStateMgr().registerComponentStateListener(this);
    }

    public void deinit() {
        this.getApplication().getFrameworkAccess().getAppStateMgr().unregisterComponentStateListener(this);
        super.deinit();
    }

    public int getID() {
        return 22;
    }

    protected void initVisibility() {
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600061, (short)29);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600172, (short)29);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600171, (short)29);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600178, (short)29);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(71, (short)29);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600384, (short)29);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600173, (short)29);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600174, (short)29);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(70, (short)29);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600177, (short)29);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600176, (short)29);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600180, (short)29);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600181, (short)29);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600532, (short)29);
    }

    protected void deinitVisibility() {
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600061);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600171);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600172);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600173);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600174);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(70);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600177);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600176);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600178);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(71);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600384);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600180);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600181);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600532);
    }

    protected void registerJokerKeyFunctions() {
        this.registerJokerKeyFunction(1, 600171);
        this.registerJokerKeyFunction(2, 600172);
        this.registerJokerKeyFunction(3, 600173);
        this.registerJokerKeyFunction(4, 600174);
        this.registerJokerKeyFunction(5, 70);
        this.registerJokerKeyFunction(10, 600177);
        this.registerJokerKeyFunction(7, 600176);
        this.registerJokerKeyFunction(8, 600180);
        this.registerJokerKeyFunction(9, 600181);
        this.registerJokerKeyFunction(11, 600532);
        this.registerJokerKeyFunction(15, 600178);
        this.registerJokerKeyFunction(16, 71);
        this.registerJokerKeyFunction(19, 600384);
    }

    protected void initJokerKeyFunctionAvailability() {
        super.initJokerKeyFunctionAvailability();
        if (this.getApplication().getFrameworkAccess().getSysApp().getDiagnosisCOD().isNavigationActive()) {
            this.enableNavEntries();
        }
        if (((SysConstModelApp)((Object)this.getApplication().getFrameworkAccess().getHMIService().getModel(this.getTrafficAnnouncementAvailableConstant()))).getValue() == 1) {
            this.setFunctionAvailable(7, true);
        }
        this.setFunctionAvailable(8, true);
    }

    protected void handleJokerKeyNotAssigned() {
        this.getLogChannel().log(10000000, "[JokerKeyComponentEvo#handleJokerKeyNotAssigned] show joker key popup");
        this.getApplication().getFrameworkAccess().getHmiServiceApp().showPopup(600007);
    }

    protected void handleJokerKeyLongpress() {
        this.getLogChannel().log(10000000, "[JokerKeyComponentEvo#handleJokerKeyLongPress] show joker key popup");
        this.getApplication().getFrameworkAccess().getHmiServiceApp().showPopup(600007);
    }

    public void appStateChanged(String string, int n) {
        if ("Navi".equals(string) || "AppNavAsia".equals(string)) {
            this.getLogChannel().log(10000000, "[JokerKeyComponentEvo#appStateChanged] appName=%1 value=%2", (Object)(string == null ? "null" : string), (long)n);
            if (n == 1) {
                this.restoreJokerKeyFunction();
                this.enableNavEntries();
            } else {
                this.disableNavEntries();
            }
        }
    }

    private boolean isNaviFunctionSet() {
        int n = this.getApplication().getFrameworkAccess().getStorageMgr().getInt(1006, 10, -1);
        return n == 3 || n == 4 || n == 5 || n == 10 || n == 11;
    }

    private synchronized void enableNavEntries() {
        this.setFunctionAvailable(3, true);
        this.setFunctionAvailable(4, true);
        this.setFunctionAvailable(5, true);
        if (((SysConstModelApp)((Object)this.getApplication().getFrameworkAccess().getHMIService().getModel(4011))).getValue() == 1 && !this.getApplication().getFrameworkAccess().isJp()) {
            this.setFunctionAvailable(10, true);
        }
        if ((this.getApplication().getFrameworkAccess().isCn() || this.getApplication().getFrameworkAccess().isJp()) && this.getApplication().getFrameworkAccess().getSysConstManager().getAdaptationANP().isOperatorCallAvailable()) {
            this.setFunctionAvailable(11, true);
        }
    }

    private synchronized void disableNavEntries() {
        this.setFunctionAvailable(3, false);
        this.setFunctionAvailable(4, false);
        this.setFunctionAvailable(5, false);
        if (((SysConstModelApp)((Object)this.getApplication().getFrameworkAccess().getHMIService().getModel(4011))).getValue() == 1 && !this.getApplication().getFrameworkAccess().isJp()) {
            this.setFunctionAvailable(10, false);
        }
        if ((this.getApplication().getFrameworkAccess().isCn() || this.getApplication().getFrameworkAccess().isJp()) && this.getApplication().getFrameworkAccess().getSysConstManager().getAdaptationANP().isOperatorCallAvailable()) {
            this.setFunctionAvailable(11, false);
        }
    }
}

