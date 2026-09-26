/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.hybrid;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.mer.IMERVisibilityChangeListener;
import de.audi.app.car.common.mer.IMenuEntry;
import de.audi.app.car.common.mer.IMenuEntryStructure;
import de.audi.app.car.common.screenstate.IScreenStateListener;
import de.audi.app.car.common.util.ConcurrentIntArray;
import de.audi.app.earlyfunc.core.hybrid.AbstractAuxACComponent;
import de.audi.app.earlyfunc.hybrid.AuxACComponentEvo$ImmediateOnPopupHandler;
import de.audi.atip.interapp.IBatteryControlListHandlingConstants;
import java.util.List;
import org.dsi.ifc.carhybrid.BatteryControlChargeState;
import org.dsi.ifc.carhybrid.BatteryControlClimateState;
import org.dsi.ifc.carhybrid.BatteryControlViewOptions;

public class AuxACComponentEvo
extends AbstractAuxACComponent
implements IScreenStateListener,
IBatteryControlListHandlingConstants,
IMERVisibilityChangeListener {
    private static final int TIMER_IMMEDIATE;
    private static final int TIMER_TIMER1;
    private static final int TIMER_TIMER2;
    private static final int MENU_ENTRY_CLIMATESTATE_ERROR_GENERAL_DEVICE_ERROR;
    private static final int MENU_ENTRY_CLIMATESTATE_ERROR_BATTERY_LOW;
    private static final int MENU_ENTRY_CLIMATESTATE_ERROR_PARKHEATER_NOFUEL;
    private static final int CLIMATE_SYSTEM_VARIANT_COOLER;
    private static final int CLIMATE_SYSTEM_VARIANT_COMBINED;
    private boolean auxAcImmediateOn = false;
    private int auxACImmediateVisiblityState = 0;
    private AuxACComponentEvo$ImmediateOnPopupHandler popupHandler;
    private ConcurrentIntArray lastKnownClimateSystemType = new ConcurrentIntArray(2);
    private static final int TIMER_ARRAY_SIZE;
    private static final int ARRAY_INDEX_TIMER1;
    private static final int ARRAY_INDEX_TIMER2;
    private static final int ICON_STATE_FUNCTIONAL;
    private static final int ICON_STATE_DISABLED;
    private static final int ICON_STATE_INVISIBLE;
    static /* synthetic */ Class class$de$audi$atip$hmi$view$IPartialPopupListener;

    public AuxACComponentEvo(ICarApplication iCarApplication) {
        super(iCarApplication);
        int n = -1;
        if (this.getClimateSystemVariant() == 2) {
            n = -366475008;
        } else if (this.getClimateSystemVariant() == 3) {
            n = -450361088;
        }
        this.popupHandler = new AuxACComponentEvo$ImmediateOnPopupHandler(this, iCarApplication, this.getLogChannel(), n);
    }

    @Override
    public int getID() {
        return 16;
    }

    @Override
    public void init() {
        super.init();
        this.getApplication().getScreenStateDispatcher().addScreenStateListener(-1020786432, this);
        this.getApplication().getScreenStateDispatcher().addScreenStateListener(-551024384, this);
        this.getApplication().getMenuEntryRegistry().registerVisibilityChangeListener(this);
        this.popupHandler.initServiceProvider();
    }

    @Override
    public void deinit() {
        this.popupHandler.deinitServiceProvider();
        super.deinit();
    }

    @Override
    protected void initVisibility() {
        this.initVisibility(238, (short)46);
        this.initVisibility(239, (short)46);
        if (this.getClimateSystemVariant() == 3) {
            this.getChoiceModel(168632320).setValue(3);
            this.initVisibility(224, (short)46);
            this.initVisibility(225, (short)46);
        } else if (this.getClimateSystemVariant() == 2) {
            this.getChoiceModel(168632320).setValue(2);
            this.initVisibility(226, (short)46);
            this.initVisibility(227, (short)46);
            this.getLogChannel().log(1078071040, "initVisibility state for HEAT COIL ICON=%1", (long)0);
            this.updateMenuEntryVisibility(238, 13);
            this.updateMenuEntryVisibility(239, 13);
        }
        this.initVisibility(222, (short)46);
        this.initVisibility(223, (short)46);
        this.initVisibility(231, (short)46);
        this.initVisibility(232, (short)46);
        this.initVisibility(228, (short)46);
        this.initVisibility(229, (short)46);
        this.initVisibility(230, (short)46);
        this.initVisibility(244, (short)46);
        this.initVisibility(245, (short)46);
        this.initVisibility(236, (short)46);
        this.initVisibility(237, (short)46);
    }

    @Override
    protected void deinitVisibility() {
        if (this.getClimateSystemVariant() == 3) {
            this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(224);
            this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(225);
        } else if (this.getClimateSystemVariant() == 2) {
            this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(226);
            this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(227);
        }
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(231);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(232);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(228);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(229);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(230);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(244);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(245);
    }

    @Override
    protected void updateMenuEntryVisibility(BatteryControlViewOptions batteryControlViewOptions) {
        this.getLogChannel().log(1078071040, "updateMenuEntryVisibility: viewOptions=%1", (Object)batteryControlViewOptions);
        this.updateAuxACImmediateVisibilityState(this.getMenuEntryVisibilityState(batteryControlViewOptions.getImmediately()));
        this.updateMenuEntryVisibility(231, this.getMenuEntryVisibilityState(batteryControlViewOptions.getTimer3()));
        this.updateMenuEntryVisibility(232, this.getMenuEntryVisibilityState(batteryControlViewOptions.getTimer4()));
        this.updateClimateTypeVisibility(0, 0);
        this.updateClimateTypeVisibility(1, 0);
        this.updateClimateTypeVisibility(2, 0);
        this.updateMenuEntryVisibility(244, this.getMenuEntryVisibilityState(batteryControlViewOptions.getTimer3()));
        this.updateMenuEntryVisibility(245, this.getMenuEntryVisibilityState(batteryControlViewOptions.getTimer4()));
        if (batteryControlViewOptions != null && batteryControlViewOptions.getConfiguration() != null && !batteryControlViewOptions.getConfiguration().isParkheaterInstallation()) {
            this.getLogChannel().log(1078071040, "updateEntryVisibilityForStateChange for HEAT COIL ICON 1 and 2 = %1", (long)0);
            this.updateMenuEntryVisibility(238, 13);
            this.updateMenuEntryVisibility(239, 13);
        } else {
            this.updateThermometerIconVisibility(1, this.lastKnownClimateSystemType.get(0));
            this.updateThermometerIconVisibility(2, this.lastKnownClimateSystemType.get(1));
        }
    }

    private void updateClimateTypeVisibility(int n, int n2) {
        if (this.isOperationMode(n)) {
            this.updateMenuEntryVisibility(this.getClimateTypeMenuEntry(n), n2);
        } else {
            this.updateMenuEntryVisibility(this.getClimateTypeMenuEntry(n), 1);
        }
    }

    private int getClimateTypeMenuEntry(int n) {
        int n2 = -1;
        switch (n) {
            case 0: {
                n2 = 228;
                break;
            }
            case 1: {
                n2 = 229;
                break;
            }
            case 2: {
                n2 = 230;
                break;
            }
            default: {
                this.getLogChannel().log(10000, "getClimateTypeMenuEntry: trying to get invalid menu Entry for timer: %1", (long)n);
            }
        }
        return n2;
    }

    private void updateMenuEntryVisibilityNow(boolean bl, int n) {
        this.getLogChannel().log(1078071040, "updateMenuEntryVisibilityNow: on=%1, state=%2", bl, (long)n);
        if (this.getClimateSystemVariant() == 3) {
            if (bl) {
                this.updateMenuEntryVisibility(224, 1);
                this.updateMenuEntryVisibility(225, n);
            } else {
                this.updateMenuEntryVisibility(224, n);
                this.updateMenuEntryVisibility(225, 1);
            }
        } else if (this.getClimateSystemVariant() == 2) {
            if (bl) {
                this.updateMenuEntryVisibility(226, 1);
                this.updateMenuEntryVisibility(227, n);
            } else {
                this.updateMenuEntryVisibility(226, n);
                this.updateMenuEntryVisibility(227, 1);
            }
        }
    }

    @Override
    protected void updateThermometerIconVisibility(int n, int n2) {
        boolean bl;
        int n3;
        int n4;
        if (n == 1) {
            this.lastKnownClimateSystemType.set(0, n2);
            n4 = 238;
            n3 = 236;
            bl = this.getCurrentMenuEntryState(231) > 1;
        } else if (n == 2) {
            this.lastKnownClimateSystemType.set(1, n2);
            n4 = 239;
            n3 = 237;
            bl = this.getCurrentMenuEntryState(232) > 1;
        } else {
            this.getLogChannel().log(-1601830656, "[AuxACComponentEvo]#updateThermometerIconVisibility: called with illegal timerId %1", (long)n);
            return;
        }
        if (this.isOperationMode(n)) {
            switch (n2) {
                case 2: {
                    this.getLogChannel().log(1078071040, "updateThermometerIconVisibility (climateType = AUX_HEATING) for HEAT COIL ICON %1 = %2", (long)n, 0L);
                    this.updateMenuEntryVisibility(n4, bl ? 1 : 0);
                    this.updateMenuEntryVisibility(n3, 1);
                    break;
                }
                case 1: {
                    this.getLogChannel().log(1078071040, "updateThermometerIconVisibility (climateType = AUX_CLIMATE) for HEAT COIL ICON %1 = %2", (long)n, 1L);
                    this.updateMenuEntryVisibility(n4, 1);
                    this.updateMenuEntryVisibility(n3, bl ? 1 : 0);
                    break;
                }
                case 0: {
                    this.getLogChannel().log(1078071040, "updateThermometerIconVisibility (climateType = AUX_COMBINED) for HEAT COIL ICON %1 = %2", (long)n, 0L);
                    this.updateMenuEntryVisibility(n4, bl ? 1 : 0);
                    this.updateMenuEntryVisibility(n3, bl ? 1 : 0);
                    break;
                }
            }
        } else {
            this.getLogChannel().log(1078071040, "updateThermometerIconVisibility: setting both the heat coil and the thermometer visible for timer %1", (long)n);
            if (this.currViewOptions != null && this.currViewOptions.getConfiguration() != null && this.currViewOptions.getConfiguration().isParkheaterInstallation()) {
                this.updateMenuEntryVisibility(n4, bl ? 1 : 0);
            }
            this.updateMenuEntryVisibility(n3, bl ? 1 : 0);
        }
    }

    private boolean isOperationMode(int n) {
        boolean bl = false;
        if (this.currViewOptions != null && this.currViewOptions.getConfiguration() != null && this.currViewOptions.getConfiguration().getClimateOperationModeInstallation() != null) {
            switch (n) {
                case 0: {
                    bl = this.currViewOptions.getConfiguration().getClimateOperationModeInstallation().isOperationModeImmediatly();
                    break;
                }
                case 1: {
                    bl = this.currViewOptions.getConfiguration().getClimateOperationModeInstallation().isOperationModeTimer3();
                    break;
                }
                case 2: {
                    bl = this.currViewOptions.getConfiguration().getClimateOperationModeInstallation().isOperationModeTimer4();
                    break;
                }
                default: {
                    this.getLogChannel().log(1078071040, "isOperationMode: trying to get invalid menu Entry for timer: %1", (long)n);
                }
            }
        }
        return bl;
    }

    @Override
    protected void updateAuxACImmediateOn(boolean bl) {
        this.auxAcImmediateOn = bl;
        this.updateMenuEntryVisibilityNow(bl, this.auxACImmediateVisiblityState);
    }

    @Override
    protected void updateAuxACImmediateVisibilityState(int n) {
        this.auxACImmediateVisiblityState = n;
        this.updateMenuEntryVisibilityNow(this.auxAcImmediateOn, n);
    }

    private int getClimateSystemVariant() {
        return this.getApplication().getClimateSystemVariant();
    }

    @Override
    protected void updateEntryVisibilityForStateChange(BatteryControlClimateState batteryControlClimateState, BatteryControlChargeState batteryControlChargeState, BatteryControlViewOptions batteryControlViewOptions) {
        this.getLogChannel().log(1078071040, "updateEntryVisibilityForError with climateState %1 and chargeState %2", (Object)batteryControlClimateState, (Object)batteryControlChargeState);
        if (batteryControlChargeState != null) {
            this.updateVisibilityForChargeStateChange(batteryControlClimateState, batteryControlChargeState, batteryControlViewOptions);
        }
        if (batteryControlClimateState != null) {
            this.updateVisibilityForClimateStateChange(batteryControlClimateState, batteryControlChargeState, batteryControlViewOptions);
        }
        if (batteryControlViewOptions != null && batteryControlViewOptions.getConfiguration() != null && !batteryControlViewOptions.getConfiguration().isParkheaterInstallation()) {
            this.getLogChannel().log(1078071040, "updateEntryVisibilityForStateChange for HEAT COIL ICON 1 and 2 = %1", (long)0);
            this.updateMenuEntryVisibility(238, 13);
            this.updateMenuEntryVisibility(239, 13);
        } else {
            this.updateThermometerIconVisibility(1, this.lastKnownClimateSystemType.get(0));
            this.updateThermometerIconVisibility(2, this.lastKnownClimateSystemType.get(1));
        }
    }

    private void updateVisibilityForChargeStateChange(BatteryControlClimateState batteryControlClimateState, BatteryControlChargeState batteryControlChargeState, BatteryControlViewOptions batteryControlViewOptions) {
        if (batteryControlChargeState.getChargeState() == 2) {
            if (batteryControlClimateState.climateMode != null) {
                this.auxAcImmediateOn = batteryControlClimateState.climateMode.isClimating();
                this.updateMenuEntryVisibilityNow(this.auxAcImmediateOn, 2);
                this.updateClimateTypeVisibility(0, 2);
            }
            this.updateMenuEntryVisibility(231, this.getHighestPrioVisibilityState(this.getCurrentMenuEntryState(231), this.getMenuEntryVisibilityState(batteryControlViewOptions.getTimer3())));
            this.updateMenuEntryVisibility(232, this.getHighestPrioVisibilityState(this.getCurrentMenuEntryState(232), this.getMenuEntryVisibilityState(batteryControlViewOptions.getTimer4())));
            this.updateMenuEntryVisibility(244, this.getHighestPrioVisibilityState(this.getCurrentMenuEntryState(244), this.getMenuEntryVisibilityState(batteryControlViewOptions.getTimer3())));
            this.updateMenuEntryVisibility(245, this.getHighestPrioVisibilityState(this.getCurrentMenuEntryState(245), this.getMenuEntryVisibilityState(batteryControlViewOptions.getTimer3())));
            this.updateClimateTypeVisibility(1, this.getHighestPrioVisibilityState(this.getCurrentMenuEntryState(229), this.getMenuEntryVisibilityState(batteryControlViewOptions.getTimer3())));
            this.updateClimateTypeVisibility(2, this.getHighestPrioVisibilityState(this.getCurrentMenuEntryState(230), this.getMenuEntryVisibilityState(batteryControlViewOptions.getTimer4())));
        }
    }

    private void updateVisibilityForClimateStateChange(BatteryControlClimateState batteryControlClimateState, BatteryControlChargeState batteryControlChargeState, BatteryControlViewOptions batteryControlViewOptions) {
        if (batteryControlClimateState.climateState == 7) {
            this.updateMenuEntryVisibilityNow(batteryControlClimateState.climateMode.isClimating(), this.getHighestPrioVisibilityState(11, this.getMenuEntryVisibilityState(batteryControlViewOptions.getImmediately())));
            this.updateMenuEntryVisibility(231, this.getHighestPrioVisibilityState(11, this.getMenuEntryVisibilityState(batteryControlViewOptions.getTimer3())));
            this.updateMenuEntryVisibility(232, this.getHighestPrioVisibilityState(11, this.getMenuEntryVisibilityState(batteryControlViewOptions.getTimer4())));
            this.updateClimateTypeVisibility(0, 2);
            this.updateClimateTypeVisibility(1, 2);
            this.updateClimateTypeVisibility(2, 2);
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(244, this.getHighestPrioVisibilityState(2, this.getMenuEntryVisibilityState(batteryControlViewOptions.getTimer3())));
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(245, this.getHighestPrioVisibilityState(2, this.getMenuEntryVisibilityState(batteryControlViewOptions.getTimer4())));
        } else if (batteryControlClimateState.climateState == 10) {
            if (this.getClimateSystemVariant() == 3) {
                this.updateMenuEntryVisibilityNow(batteryControlClimateState.climateMode.isClimating(), this.getMenuEntryVisibilityState(batteryControlViewOptions.getImmediately()));
                this.updateMenuEntryVisibility(231, this.getMenuEntryVisibilityState(batteryControlViewOptions.getTimer3()));
                this.updateMenuEntryVisibility(232, this.getMenuEntryVisibilityState(batteryControlViewOptions.getTimer4()));
                this.updateClimateTypeVisibility(0, 0);
                this.updateClimateTypeVisibility(1, this.getMenuEntryVisibilityState(batteryControlViewOptions.getTimer3()));
                this.updateClimateTypeVisibility(2, this.getMenuEntryVisibilityState(batteryControlViewOptions.getTimer4()));
                this.updateMenuEntryVisibility(244, this.getMenuEntryVisibilityState(batteryControlViewOptions.getTimer3()));
                this.updateMenuEntryVisibility(245, this.getMenuEntryVisibilityState(batteryControlViewOptions.getTimer4()));
            } else if (this.getClimateSystemVariant() == 2) {
                this.updateMenuEntryVisibilityNow(batteryControlClimateState.climateMode.isClimating(), 12);
                this.updateMenuEntryVisibility(231, this.getMenuEntryVisibilityState(batteryControlViewOptions.getTimer3()));
                this.updateMenuEntryVisibility(232, this.getMenuEntryVisibilityState(batteryControlViewOptions.getTimer4()));
                this.updateMenuEntryVisibility(244, this.getMenuEntryVisibilityState(batteryControlViewOptions.getTimer3()));
                this.updateMenuEntryVisibility(245, this.getMenuEntryVisibilityState(batteryControlViewOptions.getTimer4()));
            }
        } else if (batteryControlClimateState.climateState == 3) {
            this.updateMenuEntryVisibilityNow(batteryControlClimateState.climateMode.isClimating(), this.getHighestPrioVisibilityState(13, this.getMenuEntryVisibilityState(batteryControlViewOptions.getImmediately())));
            this.updateMenuEntryVisibility(231, this.getMenuEntryVisibilityState(batteryControlViewOptions.getTimer3()));
            this.updateMenuEntryVisibility(232, this.getMenuEntryVisibilityState(batteryControlViewOptions.getTimer4()));
            this.updateClimateTypeVisibility(0, 2);
            this.updateClimateTypeVisibility(1, this.getMenuEntryVisibilityState(batteryControlViewOptions.getTimer3()));
            this.updateClimateTypeVisibility(2, this.getMenuEntryVisibilityState(batteryControlViewOptions.getTimer4()));
            this.updateMenuEntryVisibility(244, this.getMenuEntryVisibilityState(batteryControlViewOptions.getTimer3()));
            this.updateMenuEntryVisibility(245, this.getMenuEntryVisibilityState(batteryControlViewOptions.getTimer4()));
        } else if (batteryControlClimateState.climateState == 12) {
            this.updateMenuEntryVisibilityNow(batteryControlClimateState.climateMode.isClimating(), batteryControlChargeState != null && batteryControlChargeState.chargeState == 2 ? this.getHighestPrioVisibilityState(this.getLogicalMenuEntryStateForImmediateButton(), this.getMenuEntryVisibilityState(batteryControlViewOptions.getImmediately())) : this.getMenuEntryVisibilityState(batteryControlViewOptions.getImmediately()));
            this.updateMenuEntryVisibility(231, this.getMenuEntryVisibilityState(batteryControlViewOptions.getTimer3()));
            this.updateMenuEntryVisibility(232, this.getMenuEntryVisibilityState(batteryControlViewOptions.getTimer4()));
            this.updateClimateTypeVisibility(0, 2);
            this.updateClimateTypeVisibility(1, 2);
            this.updateClimateTypeVisibility(2, 2);
            this.updateMenuEntryVisibility(244, this.getMenuEntryVisibilityState(batteryControlViewOptions.getTimer3()));
            this.updateMenuEntryVisibility(245, this.getMenuEntryVisibilityState(batteryControlViewOptions.getTimer4()));
        } else {
            this.updateMenuEntryVisibilityNow(batteryControlClimateState.climateMode.isClimating(), batteryControlChargeState != null && batteryControlChargeState.chargeState == 2 ? this.getHighestPrioVisibilityState(this.getLogicalMenuEntryStateForImmediateButton(), this.getMenuEntryVisibilityState(batteryControlViewOptions.immediately)) : this.getMenuEntryVisibilityState(batteryControlViewOptions.immediately));
            this.updateMenuEntryVisibility(231, this.getMenuEntryVisibilityState(batteryControlViewOptions.getTimer3()));
            this.updateMenuEntryVisibility(232, this.getMenuEntryVisibilityState(batteryControlViewOptions.getTimer4()));
            this.updateClimateTypeVisibility(0, batteryControlChargeState != null && batteryControlChargeState.chargeState == 2 ? this.getHighestPrioVisibilityState(this.getCurrentMenuEntryState(228), this.getMenuEntryVisibilityState(batteryControlViewOptions.immediately)) : this.getMenuEntryVisibilityState(batteryControlViewOptions.immediately));
            this.updateClimateTypeVisibility(1, this.getMenuEntryVisibilityState(batteryControlViewOptions.getTimer3()));
            this.updateClimateTypeVisibility(2, this.getMenuEntryVisibilityState(batteryControlViewOptions.getTimer4()));
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(244, this.getMenuEntryVisibilityState(batteryControlViewOptions.getTimer3()));
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(245, this.getMenuEntryVisibilityState(batteryControlViewOptions.getTimer4()));
        }
    }

    @Override
    public void notifyScreenVisible(int n) {
    }

    @Override
    public void notifyScreenHidden(int n) {
    }

    @Override
    public void notifyScreenConnected(int n) {
    }

    @Override
    public void notifyScreenFadedOut(int n) {
        this.getLogChannel().log(1078071040, "[AuxAcComponentEvo#notifyScreenFadedOut] screenID='%1'", (long)n);
        if (n == -1020786432 || n == -551024384) {
            this.resetPastError();
        }
    }

    public void notifyPowerListenerOnEnterState(int n) {
    }

    public void notifyPowerListenerOnExitState(int n) {
    }

    public void notifyPowerTriggerAction(int n) {
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

    private int getLogicalMenuEntryStateForImmediateButton() {
        if (this.getClimateSystemVariant() == 3) {
            if (this.getCurrentMenuEntryState(224) > 1 || this.getCurrentMenuEntryState(225) > 1) {
                return Math.max(this.getCurrentMenuEntryState(224), this.getCurrentMenuEntryState(225));
            }
            if (this.getCurrentMenuEntryState(224) == 1 && this.getCurrentMenuEntryState(225) == 1) {
                return 1;
            }
            return 0;
        }
        if (this.getClimateSystemVariant() == 2) {
            if (this.getCurrentMenuEntryState(226) > 1 || this.getCurrentMenuEntryState(227) > 1) {
                return Math.max(this.getCurrentMenuEntryState(226), this.getCurrentMenuEntryState(227));
            }
            if (this.getCurrentMenuEntryState(226) == 1 && this.getCurrentMenuEntryState(227) == 1) {
                return 1;
            }
            return 0;
        }
        return 1;
    }

    private void updateMenuEntryVisibility(int n, int n2) {
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(n, n2);
    }

    private void initVisibility(int n, short s) {
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(n, s);
    }

    @Override
    public void notifyVisibilityChange(List list) {
        this.getLogChannel().log(1078071040, "[AuxAcComponentEvo#notifyVisibilityChange]");
        Object[] objectArray = list.toArray();
        for (int i2 = 0; i2 < objectArray.length; ++i2) {
            IMenuEntry iMenuEntry = (IMenuEntry)objectArray[i2];
            if (iMenuEntry.getID() == 231) {
                if (iMenuEntry.getState() > 1) {
                    this.getLogChannel().log(1078071040, "notifyVisibilityChange state for HEAT COIL ICON 1 = %1", 1L);
                    this.updateMenuEntryVisibility(238, 1);
                    this.updateMenuEntryVisibility(236, 1);
                } else {
                    this.updateThermometerIconVisibility(1, this.lastKnownClimateSystemType.get(0));
                }
            }
            if (iMenuEntry.getID() != 232) continue;
            if (iMenuEntry.getState() > 1) {
                this.getLogChannel().log(1078071040, "notifyVisibilityChange state for HEAT COIL ICON 2 = %1", 1L);
                this.updateMenuEntryVisibility(239, 1);
                this.updateMenuEntryVisibility(237, 1);
                continue;
            }
            this.updateThermometerIconVisibility(2, this.lastKnownClimateSystemType.get(1));
        }
    }

    @Override
    public void initUseOfMenuStructure(IMenuEntryStructure iMenuEntryStructure) {
    }

    @Override
    public void acknowledgeBatteryControlImmediately(boolean bl, int n) {
        super.acknowledgeBatteryControlImmediately(bl, n);
        switch (n) {
            case 0: {
                this.getLogChannel().log(-2137614336, "acknowledgeBatteryControlImmediately: stop - %1", (Object)(bl ? "successful" : "unsuccessful"));
                this.popupHandler.removePopup();
                break;
            }
            case 1: {
                this.getLogChannel().log(-2137614336, "acknowledgeBatteryControlImmediately: start - %1", (Object)(bl ? "successful" : "unsuccessful"));
                this.popupHandler.showPopup();
                break;
            }
            default: {
                this.getLogChannel().log(10000, "acknowledgeBatteryControlImmediately: invalid control=%1", (long)n);
            }
        }
    }

    static /* synthetic */ int access$000(AuxACComponentEvo auxACComponentEvo) {
        return auxACComponentEvo.getClimateSystemVariant();
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

