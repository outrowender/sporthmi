/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.evo.mer;

import de.audi.app.car.common.mer.IMenuEntryRegistry;
import de.audi.app.car.common.mer.MenuEntry;
import de.audi.app.car.common.mer.MenuEntryType;
import de.audi.app.car.common.service.CarServiceTracker;
import de.audi.app.car.common.service.CarServiceTrackerListener;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.interapp.combi.mmisync.MMICombiMenuStatesServiceListener;
import de.audi.atip.log.LogChannel;

public class MenuEntryMMICombi
extends MenuEntry
implements CarServiceTrackerListener {
    private final int contextId;
    private MMICombiMenuStatesServiceListener combiCarServiceListener;
    private CarServiceTracker carServiceTracker;
    private final Object mutex = new Object();
    private volatile boolean componentsInitialized = false;
    static /* synthetic */ Class class$de$audi$atip$interapp$combi$mmisync$MMICombiMenuStatesServiceListener;

    public MenuEntryMMICombi(int n, String string, IFrameworkAccess iFrameworkAccess, LogChannel logChannel, int n2) {
        super(n, string, -1, iFrameworkAccess, logChannel);
        this.contextId = n2;
        this.carServiceTracker = new CarServiceTracker(this, iFrameworkAccess.getBundleCxt(), logChannel);
    }

    @Override
    public void init(IMenuEntryRegistry iMenuEntryRegistry) {
        super.init(iMenuEntryRegistry);
        this.carServiceTracker.startTracking();
    }

    @Override
    public void deinit() {
        super.deinit();
        this.carServiceTracker.stopTracking();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void notifyComponentsInitialized() {
        this.componentsInitialized = true;
        Object object = this.mutex;
        synchronized (object) {
            if (this.combiCarServiceListener != null) {
                this.combiCarServiceListener.updateMenuState(this.contextId, this.convertVisibiltyStateForService(this.state));
            }
        }
    }

    @Override
    public MenuEntryType getType() {
        return MenuEntryType.MMICOMBI_MENU_ENTRY;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void setState(int n) {
        this.logChannel.log(1078071040, "[MenuEntryMMICombi(%1)#setState] state='%2'", (Object)this, (long)n);
        this.state = n;
        Object object = this.mutex;
        synchronized (object) {
            if (this.combiCarServiceListener == null) {
                this.logChannel.log(-1601830656, "[MenuEntryMMICombi#setState] combiCarService not available");
                return;
            }
            if (this.componentsInitialized) {
                this.combiCarServiceListener.updateMenuState(this.contextId, this.convertVisibiltyStateForService(n));
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void serviceAvailable(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            this.combiCarServiceListener = (MMICombiMenuStatesServiceListener)object;
            if (this.componentsInitialized) {
                this.combiCarServiceListener.updateMenuState(this.contextId, this.convertVisibiltyStateForService(this.state));
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void serviceRemoved() {
        Object object = this.mutex;
        synchronized (object) {
            this.combiCarServiceListener = null;
        }
    }

    @Override
    public String[] getTrackedServiceClazzName() {
        return new String[]{(class$de$audi$atip$interapp$combi$mmisync$MMICombiMenuStatesServiceListener == null ? (class$de$audi$atip$interapp$combi$mmisync$MMICombiMenuStatesServiceListener = MenuEntryMMICombi.class$("de.audi.atip.interapp.combi.mmisync.MMICombiMenuStatesServiceListener")) : class$de$audi$atip$interapp$combi$mmisync$MMICombiMenuStatesServiceListener).getName()};
    }

    private int convertVisibiltyStateForService(int n) {
        switch (n) {
            case 1: {
                return 3;
            }
            case 0: {
                return 2;
            }
        }
        return 1;
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

