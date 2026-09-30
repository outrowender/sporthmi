/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.hybrid;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.mer.IMERVisibilityChangeListener;
import de.audi.app.car.common.mer.IMenuEntry;
import de.audi.app.car.common.mer.IMenuEntryStructure;
import de.audi.app.earlyfunc.core.hybrid.AbstractGoodbyeComponent;
import java.util.List;
import org.dsi.ifc.carhybrid.BatteryControlViewOptions;

public class GoodbyeComponentEvo
extends AbstractGoodbyeComponent
implements IMERVisibilityChangeListener {
    private boolean auxAcImmediateOn = false;
    private int auxACImmediateVisiblityState = 0;
    public static final int CLIMATE_SYSTEM_VARIANT_NONE = 0;
    public static final int CLIMATE_SYSTEM_VARIANT_HEATER = 1;
    public static final int CLIMATE_SYSTEM_VARIANT_COOLER = 2;
    public static final int CLIMATE_SYSTEM_VARIANT_COMBINED = 3;
    boolean operationModeChargeTimer = false;
    private static final int ICON_STATE_FUNCTIONAL = 0;
    private static final int ICON_STATE_DISABLED = 1;
    private static final int ICON_STATE_INVISIBLE = 13;

    public GoodbyeComponentEvo(ICarApplication iCarApplication) {
        super(iCarApplication);
    }

    public String getName() {
        return null;
    }

    public String getCurrentViewOptions() {
        return null;
    }

    public int getPopUpID() {
        return 2100004;
    }

    protected void deinitModels() {
    }

    public int getID() {
        return 0;
    }

    protected void initVisibility() {
        this.getApplication().getMenuEntryRegistry().registerVisibilityChangeListener(this);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(226, (short)46);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(227, (short)46);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(224, (short)46);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(225, (short)46);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(511, (short)41);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(512, (short)41);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(509, (short)46);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(510, (short)46);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(14, (short)41);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(246, (short)41);
    }

    protected void deinitVisibility() {
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(226);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(227);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(511);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(512);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(509);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(510);
    }

    protected void updateMenuEntryVisibility(BatteryControlViewOptions batteryControlViewOptions) {
        if (this.getNextChargeTimerId() == 0) {
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(511, 1);
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(512, 1);
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(14, 1);
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(246, 1);
        }
        if (this.getNextChargeTimerId() == 1) {
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(511, this.getHighestPrioVisibilityState(this.getMenuEntryVisibilityState(batteryControlViewOptions.timer1), this.getCurrentMenuEntryState(247)));
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(512, 1);
            this.operationModeChargeTimer = batteryControlViewOptions.getConfiguration().getClimateOperationModeInstallation().operationModeTimer1;
        }
        if (this.getNextChargeTimerId() == 2) {
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(511, 1);
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(512, this.getHighestPrioVisibilityState(this.getMenuEntryVisibilityState(batteryControlViewOptions.timer2), this.getCurrentMenuEntryState(248)));
            this.operationModeChargeTimer = batteryControlViewOptions.getConfiguration().getClimateOperationModeInstallation().operationModeTimer2;
        }
        if (this.getNextClimateTimerId() == 0) {
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(509, 1);
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(510, 1);
        }
        if (this.getNextClimateTimerId() == 3) {
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(509, this.getHighestPrioVisibilityState(this.getMenuEntryVisibilityState(batteryControlViewOptions.timer3), this.getCurrentMenuEntryState(231)));
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(510, 1);
        }
        if (this.getNextClimateTimerId() == 4) {
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(509, 1);
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(510, this.getHighestPrioVisibilityState(this.getMenuEntryVisibilityState(batteryControlViewOptions.timer4), this.getCurrentMenuEntryState(232)));
        }
        this.updateAllowParkHeaterMEVisibility(batteryControlViewOptions);
        if (batteryControlViewOptions != null && batteryControlViewOptions.getConfiguration() != null && !batteryControlViewOptions.getConfiguration().isParkheaterInstallation()) {
            this.getLogChannel().log(1000000, "updateEntryVisibilityForStateChange for HEAT COIL ICON 1 and 2 = %1", 13L);
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(238, 13);
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(239, 13);
        }
    }

    protected void updateAllowParkHeaterMEVisibility(BatteryControlViewOptions batteryControlViewOptions) {
        if (batteryControlViewOptions.getConfiguration().isParkheaterInstallation()) {
            if (this.operationModeChargeTimer) {
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(14, this.getMenuEntryVisibilityState(batteryControlViewOptions.getProfileList()));
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(246, this.getMenuEntryVisibilityState(batteryControlViewOptions.getProfileList()));
            }
            if (this.getCurrClimateState() != null && this.getCurrClimateState().getClimateState() == 3) {
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(14, 2);
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(246, 2);
            } else if (this.getCurrClimateState() != null && this.getCurrClimateState().getClimateState() == 7) {
                if (this.operationModeChargeTimer) {
                    this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(14, 2);
                    this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(246, 2);
                }
                if (batteryControlViewOptions.getConfiguration().getClimateOperationModeInstallation().operationModeTimer3) {
                    this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(240, 2);
                }
                if (batteryControlViewOptions.getConfiguration().getClimateOperationModeInstallation().operationModeTimer4) {
                    this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(241, 2);
                }
            } else if (this.getCurrClimateState() != null && this.getCurrClimateState().getClimateState() == 12) {
                if (this.operationModeChargeTimer) {
                    this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(14, 9);
                    this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(246, 9);
                }
                if (batteryControlViewOptions.getConfiguration().getClimateOperationModeInstallation().operationModeTimer3) {
                    this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(240, 7);
                }
                if (batteryControlViewOptions.getConfiguration().getClimateOperationModeInstallation().operationModeTimer4) {
                    this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(241, 7);
                }
            } else {
                if (this.operationModeChargeTimer) {
                    this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(14, this.getMenuEntryVisibilityState(batteryControlViewOptions.getProfileList()));
                    this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(246, this.getMenuEntryVisibilityState(batteryControlViewOptions.getProfileList()));
                }
                if (batteryControlViewOptions.getConfiguration().getClimateOperationModeInstallation().operationModeTimer3) {
                    this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(240, 0);
                }
                if (batteryControlViewOptions.getConfiguration().getClimateOperationModeInstallation().operationModeTimer4) {
                    this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(241, 0);
                }
            }
        } else {
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(14, 1);
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(246, 1);
            if (batteryControlViewOptions.getConfiguration().getClimateOperationModeInstallation().operationModeTimer3) {
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(240, 1);
            }
            if (batteryControlViewOptions.getConfiguration().getClimateOperationModeInstallation().operationModeTimer4) {
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(241, 1);
            }
        }
    }

    private void updateAuxACImmediateVisibilityState(int n) {
        this.auxACImmediateVisiblityState = n;
        this.updateMenuEntryVisibilityNow(this.auxAcImmediateOn, n);
    }

    protected void updateAuxACImmediateOn(boolean bl) {
        this.auxAcImmediateOn = bl;
        this.updateMenuEntryVisibilityNow(bl, this.auxACImmediateVisiblityState);
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

    private void updateMenuEntryVisibilityNow(boolean bl, int n) {
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

    private void updateMenuEntryVisibility(int n, int n2) {
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(n, n2);
    }

    public void notifyVisibilityChange(List list) {
        Object[] objectArray = list.toArray();
        for (int i2 = 0; i2 < objectArray.length; ++i2) {
            IMenuEntry iMenuEntry = (IMenuEntry)objectArray[i2];
            if (iMenuEntry.getID() == 231 && this.getCurrentMenuEntryState(509) != 1) {
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(509, iMenuEntry.getState());
            }
            if (iMenuEntry.getID() == 232 && this.getCurrentMenuEntryState(510) != 1) {
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(510, iMenuEntry.getState());
            }
            if (iMenuEntry.getID() == 247 && this.getCurrentMenuEntryState(511) != 1) {
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(511, iMenuEntry.getState());
            }
            if (iMenuEntry.getID() != 248 || this.getCurrentMenuEntryState(512) == 1) continue;
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(512, iMenuEntry.getState());
        }
    }

    public void initUseOfMenuStructure(IMenuEntryStructure iMenuEntryStructure) {
    }
}

