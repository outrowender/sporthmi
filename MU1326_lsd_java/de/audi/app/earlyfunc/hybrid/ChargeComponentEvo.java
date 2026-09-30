/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.hybrid;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.mer.IMERVisibilityChangeListener;
import de.audi.app.car.common.mer.IMenuEntry;
import de.audi.app.car.common.mer.IMenuEntryStructure;
import de.audi.app.car.common.screenstate.IScreenStateListener;
import de.audi.app.car.common.util.ConcurrentBooleanArray;
import de.audi.app.car.common.util.ConcurrentIntArray;
import de.audi.app.earlyfunc.core.hybrid.AbstractChargeComponent;
import java.util.List;
import org.dsi.ifc.carhybrid.BatteryControlChargeState;
import org.dsi.ifc.carhybrid.BatteryControlViewOptions;

public class ChargeComponentEvo
extends AbstractChargeComponent
implements IScreenStateListener,
IMERVisibilityChangeListener {
    private static final int ICON_STATE_FUNCTIONAL = 0;
    private static final int ICON_STATE_DISABLED = 1;
    private static final int ICON_STATE_INVISIBLE = 13;
    private static final int TIMER_ARRAY_SIZE = 2;
    private static final int ARRAY_INDEX_TIMER1 = 0;
    private static final int ARRAY_INDEX_TIMER2 = 1;
    private ConcurrentBooleanArray lastKnownThermometerIconState = new ConcurrentBooleanArray(2);
    public static final int CLIMATE_SYSTEM_VARIANT_NONE = 0;
    public static final int CLIMATE_SYSTEM_VARIANT_HEATER = 1;
    public static final int CLIMATE_SYSTEM_VARIANT_COOLER = 2;
    public static final int CLIMATE_SYSTEM_VARIANT_COMBINED = 3;
    private ConcurrentIntArray lastKnownClimateSystemType = new ConcurrentIntArray(2);

    public ChargeComponentEvo(ICarApplication iCarApplication) {
        super(iCarApplication);
    }

    public void init() {
        super.init();
        this.getApplication().getScreenStateDispatcher().addScreenStateListener(600284, this);
        this.getApplication().getScreenStateDispatcher().addScreenStateListener(600285, this);
        this.getApplication().getMenuEntryRegistry().registerVisibilityChangeListener(this);
    }

    protected void initVisibility() {
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(247, (short)41);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(248, (short)41);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(234, (short)41);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(235, (short)41);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(233, (short)41);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(243, (short)41);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(242, (short)41);
        if (this.getClimateSystemVariant() == 2) {
            this.updateMenuEntryVisibility(233, 13);
            this.updateMenuEntryVisibility(243, 13);
        }
        if (this.getClimateSystemVariant() == 1 || this.getClimateSystemVariant() == 0) {
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(242, 1);
            this.updateMenuEntryVisibility(234, 13);
            this.updateMenuEntryVisibility(235, 13);
        }
    }

    protected void deinitVisibility() {
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(247);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(248);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(234);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(235);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(233);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(243);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(242);
    }

    public int getID() {
        return 15;
    }

    protected void updateMenuEntryVisibility(BatteryControlViewOptions batteryControlViewOptions) {
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(247, this.getMenuEntryVisibilityState(batteryControlViewOptions.getTimer1()));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(248, this.getMenuEntryVisibilityState(batteryControlViewOptions.getTimer2()));
        if (this.getClimateSystemVariant() == 2 || this.getClimateSystemVariant() == 3) {
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(242, 0);
        } else {
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(242, 1);
            this.updateMenuEntryVisibility(234, 13);
            this.updateMenuEntryVisibility(235, 13);
        }
        if (this.getClimateSystemVariant() == 2) {
            this.updateMenuEntryVisibility(233, 13);
            this.updateMenuEntryVisibility(243, 13);
        }
    }

    protected void updateThermometerIconVisibility(int n, boolean bl) {
        if (n == 1) {
            this.lastKnownThermometerIconState.set(0, bl);
        }
        if (n == 2) {
            this.lastKnownThermometerIconState.set(1, bl);
        }
        if (this.getClimateSystemVariant() == 2 || this.getClimateSystemVariant() == 3) {
            if (n == 1) {
                if (bl) {
                    this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(234, 0);
                } else {
                    this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(234, 1);
                }
            }
            if (n == 2) {
                if (bl) {
                    this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(235, 0);
                } else {
                    this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(235, 1);
                }
            }
        }
    }

    public int getPopUpID() {
        return -1;
    }

    protected void updateEntryVisibilityForError(BatteryControlChargeState batteryControlChargeState, BatteryControlViewOptions batteryControlViewOptions) {
        if (batteryControlChargeState.getChargeState() == 7) {
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(247, this.getHighestPrioVisibilityState(2, this.getMenuEntryVisibilityState(batteryControlViewOptions.getTimer1())));
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(248, this.getHighestPrioVisibilityState(2, this.getMenuEntryVisibilityState(batteryControlViewOptions.getTimer2())));
        } else {
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(247, this.getMenuEntryVisibilityState(batteryControlViewOptions.getTimer1()));
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(248, this.getMenuEntryVisibilityState(batteryControlViewOptions.getTimer2()));
        }
    }

    private int getHighestPrioVisibilityState(int n, int n2) {
        if (n == 1 || n2 == 1) {
            return 1;
        }
        return Math.max(n, n2);
    }

    private int getCurrentMenuEntryState(int n) {
        return this.getApplication().getMenuEntryRegistry().getCurrentMenuEntryState(n);
    }

    public void notifyScreenFadedOut(int n) {
        this.getLogChannel().log(1000000, "[AuxAcComponentEvo#notifyScreenFadedOut] screenID='%1'", (long)n);
        if (n == 600284) {
            this.resetPastError();
        } else if (n == 600285) {
            this.updateCurrentErrorDisclaimer(this.chargeState);
        }
    }

    public void notifyScreenVisible(int n) {
    }

    public void notifyScreenHidden(int n) {
    }

    public void notifyScreenConnected(int n) {
    }

    private int getClimateSystemVariant() {
        boolean bl = this.getApplication().getCarMenuCoding().isMenuDisplayActivated((short)9);
        boolean bl2 = this.getApplication().getCarMenuCoding().isMenuDisplayActivated((short)46);
        if (bl && bl2) {
            return 3;
        }
        if (bl) {
            return 1;
        }
        if (bl2) {
            return 2;
        }
        return 0;
    }

    protected void updateHeatCoilIconVisibility(int n, int n2) {
        if (n == 1) {
            this.lastKnownClimateSystemType.set(0, n2);
        }
        if (n == 2) {
            this.lastKnownClimateSystemType.set(1, n2);
        }
        if (this.getClimateSystemVariant() == 2) {
            this.updateMenuEntryVisibility(233, 13);
            this.updateMenuEntryVisibility(243, 13);
        } else {
            switch (n2) {
                case 2: {
                    if (n == 1) {
                        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(233, 0);
                        break;
                    }
                    if (n != 2) break;
                    this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(243, 0);
                    break;
                }
                case 1: {
                    if (n == 1) {
                        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(233, 1);
                        break;
                    }
                    if (n != 2) break;
                    this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(243, 1);
                    break;
                }
                case 0: {
                    if (n == 1) {
                        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(233, 0);
                        break;
                    }
                    if (n != 2) break;
                    this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(243, 0);
                    break;
                }
            }
        }
    }

    public void notifyVisibilityChange(List list) {
        Object[] objectArray = list.toArray();
        for (int i2 = 0; i2 < objectArray.length; ++i2) {
            IMenuEntry iMenuEntry = (IMenuEntry)objectArray[i2];
            if (iMenuEntry.getID() == 247) {
                if (iMenuEntry.getState() > 1) {
                    if (this.getClimateSystemVariant() == 3) {
                        this.updateMenuEntryVisibility(233, 1);
                    }
                    this.updateMenuEntryVisibility(234, 1);
                } else {
                    this.updateThermometerIconVisibility(1, this.lastKnownThermometerIconState.get(0));
                    this.updateHeatCoilIconVisibility(1, this.lastKnownClimateSystemType.get(0));
                }
            }
            if (iMenuEntry.getID() != 248) continue;
            if (iMenuEntry.getState() > 1) {
                if (this.getClimateSystemVariant() == 3) {
                    this.updateMenuEntryVisibility(243, 1);
                }
                this.updateMenuEntryVisibility(235, 1);
                continue;
            }
            this.updateThermometerIconVisibility(2, this.lastKnownThermometerIconState.get(1));
            this.updateHeatCoilIconVisibility(2, this.lastKnownClimateSystemType.get(1));
        }
    }

    private void updateMenuEntryVisibility(int n, int n2) {
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(n, n2);
    }

    public void initUseOfMenuStructure(IMenuEntryStructure iMenuEntryStructure) {
    }
}

