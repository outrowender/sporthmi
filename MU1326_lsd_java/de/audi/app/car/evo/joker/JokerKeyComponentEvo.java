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

    @Override
    public void init() {
        super.init();
        this.getApplication().getFrameworkAccess().getAppStateMgr().registerComponentStateListener(this);
    }

    @Override
    public void deinit() {
        this.getApplication().getFrameworkAccess().getAppStateMgr().unregisterComponentStateListener(this);
        super.deinit();
    }

    @Override
    public int getID() {
        return 22;
    }

    @Override
    protected void initVisibility() {
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(-47773440, (short)29);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(1814563072, (short)29);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(1797785856, (short)29);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(1915226368, (short)29);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(71, (short)29);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(1076431104, (short)29);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(1831340288, (short)29);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(1848117504, (short)29);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(70, (short)29);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(1898449152, (short)29);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(1881671936, (short)29);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(1948780800, (short)29);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(1965558016, (short)29);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(-735508224, (short)29);
    }

    @Override
    protected void deinitVisibility() {
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(-47773440);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(1797785856);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(1814563072);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(1831340288);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(1848117504);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(70);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(1898449152);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(1881671936);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(1915226368);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(71);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(1076431104);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(1948780800);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(1965558016);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(-735508224);
    }

    @Override
    protected void registerJokerKeyFunctions() {
        this.registerJokerKeyFunction(1, 1797785856);
        this.registerJokerKeyFunction(2, 1814563072);
        this.registerJokerKeyFunction(3, 1831340288);
        this.registerJokerKeyFunction(4, 1848117504);
        this.registerJokerKeyFunction(5, 70);
        this.registerJokerKeyFunction(10, 1898449152);
        this.registerJokerKeyFunction(7, 1881671936);
        this.registerJokerKeyFunction(8, 1948780800);
        this.registerJokerKeyFunction(9, 1965558016);
        this.registerJokerKeyFunction(11, -735508224);
        this.registerJokerKeyFunction(15, 1915226368);
        this.registerJokerKeyFunction(16, 71);
        this.registerJokerKeyFunction(19, 1076431104);
    }

    @Override
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

    @Override
    protected void handleJokerKeyNotAssigned() {
        this.getLogChannel().log(-2137614336, "[JokerKeyComponentEvo#handleJokerKeyNotAssigned] show joker key popup");
        this.getApplication().getFrameworkAccess().getHmiServiceApp().showPopup(-953743104);
    }

    @Override
    protected void handleJokerKeyLongpress() {
        this.getLogChannel().log(-2137614336, "[JokerKeyComponentEvo#handleJokerKeyLongPress] show joker key popup");
        this.getApplication().getFrameworkAccess().getHmiServiceApp().showPopup(-953743104);
    }

    @Override
    public void appStateChanged(String string, int n) {
        if ("Navi".equals(string) || "AppNavAsia".equals(string)) {
            this.getLogChannel().log(-2137614336, "[JokerKeyComponentEvo#appStateChanged] appName=%1 value=%2", (Object)(string == null ? "null" : string), (long)n);
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

