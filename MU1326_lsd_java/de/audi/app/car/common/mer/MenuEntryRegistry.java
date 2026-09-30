/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.mer;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.mer.IMERVisibilityChangeListener;
import de.audi.app.car.common.mer.IMenuEntry;
import de.audi.app.car.common.mer.IMenuEntryRegistry;
import de.audi.app.car.common.mer.IMenuEntryStructure;
import de.audi.app.car.common.mer.IncludeMenuEntry;
import de.audi.app.car.common.mer.MenuEntry;
import de.audi.app.car.common.mer.MenuEntryType;
import de.audi.app.car.common.mer.SlotMenuEntry;
import de.audi.app.car.common.power.IPowerEventListener;
import de.audi.atip.log.LogChannel;
import de.audi.atip.sysapp.IStandStillListener;
import de.audi.atip.sysapp.SpeedThresholdListener;
import de.audi.atip.sysapp.carcoding.CarFuncAdap;
import de.audi.atip.testsupport.TestSupportDataReceiverEntry;
import de.audi.atip.testsupport.handler.ITestSupportHandler;
import de.audi.atip.testsupport.handler.ITestSupportHandlerNotification;
import de.audi.atip.testsupport.handler.TestSupportHandler;
import de.esolutions.fw.util.commons.Buffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Vector;

public class MenuEntryRegistry
implements IMenuEntryRegistry,
IPowerEventListener,
SpeedThresholdListener,
IStandStillListener,
ITestSupportHandlerNotification {
    private volatile boolean isClamp15On = false;
    private volatile boolean isUnderVThr = true;
    private volatile boolean isStandstill = true;
    private final boolean carMenusVisible;
    private final List clamp15MenuEntries;
    private final List vThrMenuEntries;
    private final List standstillMenuEntries;
    private final ICarApplication application;
    private final IMenuEntryStructure menuStructure;
    private final LogChannel logChannel;
    private final Object mutex = new Object();
    private ITestSupportHandler testSupportHandler;
    private final List visibilityChangeListener = new Vector();
    private ArrayList changedMenuEntries = new ArrayList();
    private boolean ignoreTerminationNotification = true;

    public MenuEntryRegistry(ICarApplication iCarApplication, IMenuEntryStructure iMenuEntryStructure, boolean bl) {
        this.application = iCarApplication;
        this.menuStructure = iMenuEntryStructure;
        this.logChannel = iCarApplication.getMerLogChannel();
        this.carMenusVisible = bl;
        this.clamp15MenuEntries = new ArrayList();
        this.vThrMenuEntries = new ArrayList();
        this.standstillMenuEntries = new ArrayList();
    }

    public void init() {
        this.testSupportHandler = new TestSupportHandler(this.application.getApplicationName() + " - Menu Entries", true, false, this, this.application.getBundleContext(), this.application.getLogChannel());
        this.testSupportHandler.init();
        Iterator iterator = this.menuStructure.getMenuEntries().values().iterator();
        while (iterator.hasNext()) {
            IMenuEntry iMenuEntry = (IMenuEntry)iterator.next();
            iMenuEntry.init(this);
        }
        this.application.getPowerEventDispatcher().addPowerEventListener(this);
        this.application.getFrameworkAccess().getSysApp().registerSpeedThresholdListener(this, 1);
        this.application.getFrameworkAccess().getSysApp().registerStandStillListener(this);
    }

    public void deinit() {
        this.testSupportHandler.deinit();
        this.application.getPowerEventDispatcher().removePowerEventListener(this);
        this.application.getFrameworkAccess().getSysApp().unregisterSpeedThresholdListener(this);
        this.application.getFrameworkAccess().getSysApp().unregisterStandStillListener(this);
        Iterator iterator = this.menuStructure.getMenuEntries().values().iterator();
        while (iterator.hasNext()) {
            IMenuEntry iMenuEntry = (IMenuEntry)iterator.next();
            iMenuEntry.deinit();
        }
    }

    public void notifyComponentsInitialized() {
        Iterator iterator = this.menuStructure.getMenuEntries().values().iterator();
        while (iterator.hasNext()) {
            IMenuEntry iMenuEntry = (IMenuEntry)iterator.next();
            iMenuEntry.notifyComponentsInitialized();
        }
    }

    public Object getVehicleStatusDump() {
        Buffer buffer = new Buffer();
        buffer.append("Cl15:").append(this.isClamp15On ? "ON" : "OFF");
        buffer.append(", ").append(this.isStandstill ? "STANDSTILL" : "MOVING");
        return buffer.toString();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public IMenuEntry registerMenuEntry(int n, short s) {
        this.logChannel.log(1000000, "[MenuEntryRegistry#registerMenuEntry] id=%1", (long)n);
        Integer n2 = new Integer(n);
        CarFuncAdap carFuncAdap = this.application.getCarMenuCoding();
        Object object = this.mutex;
        synchronized (object) {
            this.ignoreTerminationNotification = true;
            IMenuEntry iMenuEntry = (IMenuEntry)this.menuStructure.getMenuEntries().get(n2);
            if (iMenuEntry == null) {
                this.logChannel.log(100000, "[MenuEntryRegistry#registerMenuEntry] Menu entry with id %1 is not in menu structure", (Object)n2);
            } else if (!carFuncAdap.isMenuDisplayActivated(s)) {
                this.logChannel.log(100000, "[MenuEntryRegistry#registerMenuEntry] Menu entry with id %1 (%2) is not coded", (Object)n2, (Object)iMenuEntry);
            } else if (iMenuEntry.isRegistered()) {
                this.logChannel.log(100000, "[MenuEntryRegistry#registerMenuEntry] Menu entry with id %1 (%2) is already registered", (Object)n2, (Object)iMenuEntry);
            } else if (!iMenuEntry.isRegistrable()) {
                if (!iMenuEntry.isLeaf()) {
                    this.logChannel.log(100000, "[MenuEntryRegistry#registerMenuEntry] component is trying to register an entry %1 (%2), which is not a leaf in the structure; aborting", (Object)n2, (Object)iMenuEntry);
                } else {
                    this.logChannel.log(100000, "[MenuEntryRegistry#registerMenuEntry] Menu entry with id %1 (%2) is not registrable due to unknown reason", (Object)n2, (Object)iMenuEntry);
                }
            } else {
                iMenuEntry.register();
                boolean bl = this.isClamp15MenuEntry(carFuncAdap, s);
                boolean bl2 = this.isVThresholdMenuEntry(carFuncAdap, s);
                boolean bl3 = this.isStandstillMenuEntry(carFuncAdap, s);
                if (bl) {
                    this.clamp15MenuEntries.add(iMenuEntry);
                }
                if (bl2) {
                    this.vThrMenuEntries.add(iMenuEntry);
                }
                if (bl3) {
                    this.standstillMenuEntries.add(iMenuEntry);
                }
                this.setStateAfterRegistration(iMenuEntry, bl, bl2, bl3);
            }
            return iMenuEntry;
        }
    }

    private boolean isAlwaysVisibleMenuEntry(CarFuncAdap carFuncAdap, short s) {
        return carFuncAdap.isMenuDisplayActivated(s) && carFuncAdap.isMenuDisClamp15OffActivated(s) && carFuncAdap.isMenuDisOverThresholdHighActivated(s);
    }

    private boolean isClamp15MenuEntry(CarFuncAdap carFuncAdap, short s) {
        return carFuncAdap.isMenuDisplayActivated(s) && !carFuncAdap.isMenuDisClamp15OffActivated(s);
    }

    private boolean isVThresholdMenuEntry(CarFuncAdap carFuncAdap, short s) {
        return carFuncAdap.isMenuDisplayActivated(s) && !carFuncAdap.isMenuDisStandstillActivated(s) && !carFuncAdap.isMenuDisOverThresholdHighActivated(s);
    }

    private boolean isStandstillMenuEntry(CarFuncAdap carFuncAdap, short s) {
        return carFuncAdap.isMenuDisplayActivated(s) && carFuncAdap.isMenuDisStandstillActivated(s);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void deregisterMenuEntry(int n) {
        this.logChannel.log(1000000, "[MenuEntryRegistry#deregisterMenuEntry] id=%1", (long)n);
        Integer n2 = new Integer(n);
        Object object = this.mutex;
        synchronized (object) {
            IMenuEntry iMenuEntry = (IMenuEntry)this.menuStructure.getMenuEntries().get(n2);
            if (iMenuEntry != null && iMenuEntry.isRegistered()) {
                iMenuEntry.updateState(1);
                iMenuEntry.deregister();
                this.clamp15MenuEntries.remove(iMenuEntry);
                this.vThrMenuEntries.remove(iMenuEntry);
                this.standstillMenuEntries.remove(iMenuEntry);
            } else if (iMenuEntry == null) {
                this.logChannel.log(100000, "[MenuEntryRegistry#deregisterMenuEntry] Menu entry %1 is not in menu structure", (Object)iMenuEntry);
            } else if (!iMenuEntry.isRegistered()) {
                this.logChannel.log(100000, "[MenuEntryRegistry#deregisterMenuEntry] Menu entry %1 (%2) is not registered", (Object)n2, (Object)iMenuEntry);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateMenuEntryCoding(int n, short s) {
        this.logChannel.log(1000000, "[MenuEntryRegistry#updateMenuEntryCoding] id=%1 codingIndex=%2", (long)n, (long)s);
        CarFuncAdap carFuncAdap = this.application.getCarMenuCoding();
        Integer n2 = new Integer(n);
        Object object = this.mutex;
        synchronized (object) {
            this.ignoreTerminationNotification = true;
            IMenuEntry iMenuEntry = (IMenuEntry)this.menuStructure.getMenuEntries().get(n2);
            if (iMenuEntry != null && carFuncAdap.isMenuDisplayActivated(s) && iMenuEntry.isRegistered()) {
                boolean bl = this.isClamp15MenuEntry(carFuncAdap, s);
                boolean bl2 = this.isVThresholdMenuEntry(carFuncAdap, s);
                boolean bl3 = this.isStandstillMenuEntry(carFuncAdap, s);
                if (bl) {
                    this.clamp15MenuEntries.add(iMenuEntry);
                }
                if (bl2) {
                    this.vThrMenuEntries.add(iMenuEntry);
                }
                if (bl3) {
                    this.standstillMenuEntries.add(iMenuEntry);
                }
                this.setStateAfterRegistration(iMenuEntry, bl, bl2, bl3);
            } else if (iMenuEntry == null) {
                this.logChannel.log(100000, "[MenuEntryRegistry#updateMenuEntryCoding] Menu entry %1 is not in menu structure", (Object)n2);
            } else if (!carFuncAdap.isMenuDisplayActivated(s)) {
                this.logChannel.log(100000, "[MenuEntryRegistry#updateMenuEntryCoding] Menu entry %1 (%2) is not coded", (Object)n2, (Object)iMenuEntry);
            } else if (!iMenuEntry.isRegistered()) {
                this.logChannel.log(100000, "[MenuEntryRegistry#updateMenuEntryCoding] Menu entry %1 (%2) is not registered", (Object)n2, (Object)iMenuEntry);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateMenuEntryVisibility(int n, int n2) {
        this.logChannel.log(1000000, "[MenuEntryRegistry#updateMenuEntryVisibility] menu entry ID='%1', visibility='%2'", (long)n, (long)n2);
        Integer n3 = new Integer(n);
        Object object = this.mutex;
        synchronized (object) {
            this.ignoreTerminationNotification = false;
            IMenuEntry iMenuEntry = (IMenuEntry)this.menuStructure.getMenuEntries().get(n3);
            if (iMenuEntry != null && iMenuEntry.isRegistered()) {
                iMenuEntry.updateStateViewOptions(n2);
            } else if (iMenuEntry == null) {
                this.logChannel.log(100000, "[MenuEntryRegistry#updateMenuEntryVisibility] Menu entry %1 is not in menu structure", (Object)n3);
            } else if (!iMenuEntry.isRegistered()) {
                this.logChannel.log(100000, "[MenuEntryRegistry#updateMenuEntryVisibility] Menu entry %1 (%2) is not registered", (Object)n3, (Object)iMenuEntry);
            }
        }
    }

    public void notifyPowerListenerOnEnterState(int n) {
    }

    public void notifyPowerListenerOnExitState(int n) {
    }

    public void notifyPowerTriggerAction(int n) {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateClampState(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        this.logChannel.log(1000000, "[MenuEntryRegistry#updateClampState] clamp15=%1", bl2);
        Object object = this.mutex;
        synchronized (object) {
            this.ignoreTerminationNotification = true;
            this.isClamp15On = bl2;
            this.setStatesAccordingToClamp15(this.clamp15MenuEntries);
            if (this.isClamp15On) {
                this.setStatesAccordingToVThreshold(this.vThrMenuEntries);
                this.setStatesAccordingToStandstill(this.standstillMenuEntries);
            }
            this.stopCollectingChanges();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void exceedsUpperThreshold(int n) {
        this.logChannel.log(1000000, "[MenuEntryRegistry#exceedsUpperThreshold] %1", (long)n);
        if (n == 1) {
            Object object = this.mutex;
            synchronized (object) {
                this.isUnderVThr = false;
                if (this.isClamp15On) {
                    this.ignoreTerminationNotification = true;
                    this.setStatesAccordingToVThreshold(this.vThrMenuEntries);
                    this.stopCollectingChanges();
                }
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void belowLowerThreshold(int n) {
        this.logChannel.log(1000000, "[MenuEntryRegistry#exceedsUpperThreshold] %1", (long)n);
        if (n == 1) {
            Object object = this.mutex;
            synchronized (object) {
                this.isUnderVThr = true;
                if (this.isClamp15On) {
                    this.ignoreTerminationNotification = true;
                    this.setStatesAccordingToVThreshold(this.vThrMenuEntries);
                    this.stopCollectingChanges();
                }
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateStandStill(boolean bl) {
        this.logChannel.log(1000000, "[MenuEntryRegistry#updateStandStill] standstill='%1'", bl);
        Object object = this.mutex;
        synchronized (object) {
            this.isStandstill = bl;
            if (this.isClamp15On) {
                this.ignoreTerminationNotification = true;
                this.setStatesAccordingToStandstill(this.standstillMenuEntries);
                this.stopCollectingChanges();
            }
        }
    }

    private void setStateAfterRegistration(IMenuEntry iMenuEntry, boolean bl, boolean bl2, boolean bl3) {
        if (this.carMenusVisible) {
            iMenuEntry.updateStateViewOptions(0);
        } else {
            iMenuEntry.updateStateViewOptions(iMenuEntry.getStateViewOptionsForRegistration());
        }
        if (bl && !this.isClamp15On) {
            this.setState(iMenuEntry, 3);
            return;
        }
        if (bl2 && !this.isUnderVThr) {
            this.setState(iMenuEntry, 4);
            return;
        }
        if (bl3 && !this.isStandstill) {
            this.setState(iMenuEntry, 6);
            return;
        }
        this.setState(iMenuEntry, 0);
    }

    private void setStatesAccordingToClamp15(List list) {
        if (!this.isClamp15On) {
            this.setStates(list, 3);
        } else {
            this.setStates(list, 0);
        }
    }

    private void setStatesAccordingToVThreshold(List list) {
        if (!this.isUnderVThr) {
            this.setStates(list, 4);
        } else {
            this.setStatesAccordingToClamp15(list);
        }
    }

    private void setStatesAccordingToStandstill(List list) {
        if (!this.isStandstill) {
            this.setStates(list, 6);
        } else {
            this.setStatesAccordingToClamp15(list);
        }
    }

    private void setStates(List list, int n) {
        ListIterator listIterator = list.listIterator(0);
        while (listIterator.hasNext()) {
            this.setState((IMenuEntry)listIterator.next(), n);
        }
    }

    private void setState(IMenuEntry iMenuEntry, int n) {
        iMenuEntry.updateStateMenuOperation(n);
    }

    public void debugDataVisible(boolean bl) {
        if (bl) {
            ArrayList arrayList = this.getDebugData();
            this.testSupportHandler.updateData((String[])arrayList.toArray(new String[arrayList.size()]));
        } else {
            this.testSupportHandler.updateData(new String[0]);
        }
    }

    public void commandEntrySelected(int n) {
    }

    public TestSupportDataReceiverEntry[] getCommandEntries() {
        return new TestSupportDataReceiverEntry[0];
    }

    public ArrayList getDebugData() {
        HashMap hashMap = this.menuStructure.getMenuEntries();
        ArrayList arrayList = new ArrayList(500);
        arrayList.add("MenuEntry Visibility - NO AUTO UPDATE");
        arrayList.add("---");
        Iterator iterator = hashMap.values().iterator();
        Buffer buffer = new Buffer(40);
        while (iterator.hasNext()) {
            try {
                MenuEntry menuEntry = (MenuEntry)iterator.next();
                if (menuEntry != null) {
                    arrayList.add(menuEntry.toString());
                    buffer.clear();
                    buffer.append("  -> State: ");
                    switch (menuEntry.getState()) {
                        case 0: {
                            buffer.append("FUNCTIONAL");
                            break;
                        }
                        case 1: {
                            buffer.append("INVISIBLE");
                            break;
                        }
                        case 2: {
                            buffer.append("DISABLED_ERROR");
                            break;
                        }
                        case 3: {
                            buffer.append("DISABLED_CLAMP15");
                            break;
                        }
                        case 4: {
                            buffer.append("DISABLED_SPEED");
                            break;
                        }
                        case 5: {
                            buffer.append("DISABLED_ENGINE");
                            break;
                        }
                        case 9: {
                            buffer.append("DISABLED_SPECIAL_ERROR");
                            break;
                        }
                        case 11: {
                            buffer.append("DISABLED_RESERVED_01");
                            break;
                        }
                        case 12: {
                            buffer.append("DISABLED_RESERVED_02");
                            break;
                        }
                        case 13: {
                            buffer.append("DISABLED_RESERVED_03");
                            break;
                        }
                        case 14: {
                            buffer.append("DISABLED_RESERVED_04");
                            break;
                        }
                        case 15: {
                            buffer.append("DISABLED_RESERVED_05");
                            break;
                        }
                        case 16: {
                            buffer.append("DISABLED_RESERVED_06");
                            break;
                        }
                        case 17: {
                            buffer.append("DISABLED_RESERVED_07");
                            break;
                        }
                        case 18: {
                            buffer.append("DISABLED_RESERVED_08");
                            break;
                        }
                        case 19: {
                            buffer.append("DISABLED_RESERVED_09");
                            break;
                        }
                        default: {
                            buffer.append("UNKNOWN:").append(menuEntry.getState());
                        }
                    }
                    arrayList.add(buffer.toString());
                    buffer.clear();
                    buffer.append("  -> ModelID: ").append(menuEntry.getModelID());
                    arrayList.add(buffer.toString());
                    buffer.clear();
                    buffer.append("  -> Parent: ");
                    if (menuEntry.getParent() != null) {
                        buffer.append(menuEntry.getParent().toString());
                    } else {
                        buffer.append("none");
                    }
                    arrayList.add(buffer.toString());
                    buffer.clear();
                    buffer.append("  -> Children: ");
                    IMenuEntry[] iMenuEntryArray = menuEntry.getChildren();
                    if (iMenuEntryArray == null) {
                        buffer.append("none");
                    }
                    arrayList.add(buffer.toString());
                    if (iMenuEntryArray == null) continue;
                    for (int i2 = 0; i2 < iMenuEntryArray.length; ++i2) {
                        buffer.clear();
                        buffer.append("     - ").append(iMenuEntryArray[i2].toString());
                        arrayList.add(buffer.toString());
                    }
                    continue;
                }
                arrayList.add("<MenuEntry is null>");
            }
            catch (ClassCastException classCastException) {
                arrayList.add("<CCE at Entry>");
            }
        }
        return arrayList;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void registerVisibilityChangeListener(IMERVisibilityChangeListener iMERVisibilityChangeListener) {
        List list = this.visibilityChangeListener;
        synchronized (list) {
            if (!this.visibilityChangeListener.contains(iMERVisibilityChangeListener)) {
                iMERVisibilityChangeListener.initUseOfMenuStructure(this.menuStructure);
                this.visibilityChangeListener.add(iMERVisibilityChangeListener);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void unregisterVisibilityChangeListener(IMERVisibilityChangeListener iMERVisibilityChangeListener) {
        List list = this.visibilityChangeListener;
        synchronized (list) {
            this.visibilityChangeListener.remove(iMERVisibilityChangeListener);
        }
    }

    public void notifyStateChange(IMenuEntry iMenuEntry) {
        if (!this.changedMenuEntries.contains(iMenuEntry)) {
            this.changedMenuEntries.add(iMenuEntry);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void stateUpdateForwardingTerminated() {
        boolean bl;
        Object object = this.mutex;
        synchronized (object) {
            bl = !this.ignoreTerminationNotification;
        }
        if (!this.changedMenuEntries.isEmpty() && bl) {
            this.notifyVisibilityChangeListeners();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void stopCollectingChanges() {
        if (!this.changedMenuEntries.isEmpty()) {
            this.notifyVisibilityChangeListeners();
            Object object = this.mutex;
            synchronized (object) {
                this.ignoreTerminationNotification = false;
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void notifyVisibilityChangeListeners() {
        Vector vector;
        Object object = this.visibilityChangeListener;
        synchronized (object) {
            vector = new Vector(this.visibilityChangeListener);
        }
        object = vector.iterator();
        while (object.hasNext()) {
            IMERVisibilityChangeListener iMERVisibilityChangeListener = (IMERVisibilityChangeListener)object.next();
            iMERVisibilityChangeListener.notifyVisibilityChange(this.changedMenuEntries);
        }
        this.changedMenuEntries = new ArrayList();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean updateSlotBinding(int n, int n2) {
        boolean bl = false;
        Object object = this.mutex;
        synchronized (object) {
            this.ignoreTerminationNotification = false;
            IMenuEntry iMenuEntry = (IMenuEntry)this.menuStructure.getMenuEntries().get(new Integer(n2));
            IMenuEntry iMenuEntry2 = (IMenuEntry)this.menuStructure.getMenuEntries().get(new Integer(n));
            bl = iMenuEntry2 != null && iMenuEntry2.isType(MenuEntryType.INCLUDE_MENU_ENTRY) ? this.moveIncludeME((IncludeMenuEntry)iMenuEntry2, iMenuEntry) : this.clearSlot(iMenuEntry);
            if (this.logChannel.isInfo()) {
                this.logChannel.log(1000000, "[MenuEntryRegistry#updateSlotBinding] meSlotID='%1' , meIncludeID='%2': menu entry structure changed='%3'", (Object)new Integer(n2), (Object)new Integer(n), (Object)bl);
            }
            if (bl) {
                this.updateStateOfAllPossibleSlotsToInvisible(n);
            }
        }
        return bl;
    }

    private boolean moveIncludeME(IncludeMenuEntry includeMenuEntry, IMenuEntry iMenuEntry) {
        if (iMenuEntry != null && iMenuEntry.isType(MenuEntryType.SLOT_MENU_ENTRY)) {
            return includeMenuEntry.moveToSlot((SlotMenuEntry)iMenuEntry);
        }
        return includeMenuEntry.leaveSlot();
    }

    private boolean clearSlot(IMenuEntry iMenuEntry) {
        if (iMenuEntry != null && iMenuEntry.isType(MenuEntryType.SLOT_MENU_ENTRY)) {
            return ((SlotMenuEntry)iMenuEntry).releaseMenuEntry();
        }
        return false;
    }

    public void updateStateOfAllPossibleSlotsToInvisible(int n) {
        IMenuEntry iMenuEntry = (IMenuEntry)this.menuStructure.getMenuEntries().get(new Integer(n));
        if (iMenuEntry != null && iMenuEntry.isType(MenuEntryType.INCLUDE_MENU_ENTRY)) {
            int[] nArray = ((IncludeMenuEntry)iMenuEntry).getAcceptedSlotIDs();
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                IMenuEntry iMenuEntry2;
                int n2;
                int n3 = n2 = iMenuEntry.getParent() != null ? iMenuEntry.getParent().getID() : -1;
                if (nArray[i2] == n2 || (iMenuEntry2 = (IMenuEntry)this.menuStructure.getMenuEntries().get(new Integer(nArray[i2]))) == null || !iMenuEntry2.isType(MenuEntryType.SLOT_MENU_ENTRY) || !((SlotMenuEntry)iMenuEntry2).isEmptySlot()) continue;
                iMenuEntry2.updateState(1);
            }
        }
    }

    public synchronized int getCurrentMenuEntryState(int n) {
        IMenuEntry iMenuEntry = (IMenuEntry)this.menuStructure.getMenuEntries().get(new Integer(n));
        return iMenuEntry.getState();
    }
}

