/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.hybrid;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.mer.IMERVisibilityChangeListener;
import de.audi.app.car.common.mer.IMenuEntry;
import de.audi.app.car.common.mer.IMenuEntryStructure;
import de.audi.app.car.common.screenstate.IScreenStateListener;
import de.audi.app.car.common.service.CarServiceProvider;
import de.audi.app.car.common.util.ConcurrentIntArray;
import de.audi.app.earlyfunc.core.hybrid.AbstractAuxACComponent;
import de.audi.atip.hmi.view.IPartialPopupListener;
import de.audi.atip.interapp.IBatteryControlListHandlingConstants;
import de.audi.atip.log.LogChannel;
import java.util.List;
import org.dsi.ifc.carhybrid.BatteryControlChargeState;
import org.dsi.ifc.carhybrid.BatteryControlClimateState;
import org.dsi.ifc.carhybrid.BatteryControlViewOptions;

public class AuxACComponentEvo
extends AbstractAuxACComponent
implements IScreenStateListener,
IBatteryControlListHandlingConstants,
IMERVisibilityChangeListener {
    private static final int TIMER_IMMEDIATE = 0;
    private static final int TIMER_TIMER1 = 1;
    private static final int TIMER_TIMER2 = 2;
    private static final int MENU_ENTRY_CLIMATESTATE_ERROR_GENERAL_DEVICE_ERROR = 11;
    private static final int MENU_ENTRY_CLIMATESTATE_ERROR_BATTERY_LOW = 12;
    private static final int MENU_ENTRY_CLIMATESTATE_ERROR_PARKHEATER_NOFUEL = 13;
    private static final int CLIMATE_SYSTEM_VARIANT_COOLER = 2;
    private static final int CLIMATE_SYSTEM_VARIANT_COMBINED = 3;
    private boolean auxAcImmediateOn = false;
    private int auxACImmediateVisiblityState = 0;
    private ImmediateOnPopupHandler popupHandler;
    private ConcurrentIntArray lastKnownClimateSystemType = new ConcurrentIntArray(2);
    private static final int TIMER_ARRAY_SIZE = 2;
    private static final int ARRAY_INDEX_TIMER1 = 0;
    private static final int ARRAY_INDEX_TIMER2 = 1;
    private static final int ICON_STATE_FUNCTIONAL = 0;
    private static final int ICON_STATE_DISABLED = 1;
    private static final int ICON_STATE_INVISIBLE = 13;
    static /* synthetic */ Class class$de$audi$atip$hmi$view$IPartialPopupListener;

    public AuxACComponentEvo(ICarApplication iCarApplication) {
        super(iCarApplication);
        int n = -1;
        if (this.getClimateSystemVariant() == 2) {
            n = 600298;
        } else if (this.getClimateSystemVariant() == 3) {
            n = 600293;
        }
        this.popupHandler = new ImmediateOnPopupHandler(iCarApplication, this.getLogChannel(), n);
    }

    public int getID() {
        return 16;
    }

    public void init() {
        super.init();
        this.getApplication().getScreenStateDispatcher().addScreenStateListener(600259, this);
        this.getApplication().getScreenStateDispatcher().addScreenStateListener(600287, this);
        this.getApplication().getMenuEntryRegistry().registerVisibilityChangeListener(this);
        this.popupHandler.initServiceProvider();
    }

    public void deinit() {
        this.popupHandler.deinitServiceProvider();
        super.deinit();
    }

    protected void initVisibility() {
        this.initVisibility(238, (short)46);
        this.initVisibility(239, (short)46);
        if (this.getClimateSystemVariant() == 3) {
            this.getChoiceModel(2100490).setValue(3);
            this.initVisibility(224, (short)46);
            this.initVisibility(225, (short)46);
        } else if (this.getClimateSystemVariant() == 2) {
            this.getChoiceModel(2100490).setValue(2);
            this.initVisibility(226, (short)46);
            this.initVisibility(227, (short)46);
            this.getLogChannel().log(1000000, "initVisibility state for HEAT COIL ICON=%1", 13L);
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

    protected void updateMenuEntryVisibility(BatteryControlViewOptions batteryControlViewOptions) {
        this.getLogChannel().log(1000000, "updateMenuEntryVisibility: viewOptions=%1", (Object)batteryControlViewOptions);
        this.updateAuxACImmediateVisibilityState(this.getMenuEntryVisibilityState(batteryControlViewOptions.getImmediately()));
        this.updateMenuEntryVisibility(231, this.getMenuEntryVisibilityState(batteryControlViewOptions.getTimer3()));
        this.updateMenuEntryVisibility(232, this.getMenuEntryVisibilityState(batteryControlViewOptions.getTimer4()));
        this.updateClimateTypeVisibility(0, 0);
        this.updateClimateTypeVisibility(1, 0);
        this.updateClimateTypeVisibility(2, 0);
        this.updateMenuEntryVisibility(244, this.getMenuEntryVisibilityState(batteryControlViewOptions.getTimer3()));
        this.updateMenuEntryVisibility(245, this.getMenuEntryVisibilityState(batteryControlViewOptions.getTimer4()));
        if (batteryControlViewOptions != null && batteryControlViewOptions.getConfiguration() != null && !batteryControlViewOptions.getConfiguration().isParkheaterInstallation()) {
            this.getLogChannel().log(1000000, "updateEntryVisibilityForStateChange for HEAT COIL ICON 1 and 2 = %1", 13L);
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
        this.getLogChannel().log(1000000, "updateMenuEntryVisibilityNow: on=%1, state=%2", bl, (long)n);
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
            this.getLogChannel().log(100000, "[AuxACComponentEvo]#updateThermometerIconVisibility: called with illegal timerId %1", (long)n);
            return;
        }
        if (this.isOperationMode(n)) {
            switch (n2) {
                case 2: {
                    this.getLogChannel().log(1000000, "updateThermometerIconVisibility (climateType = AUX_HEATING) for HEAT COIL ICON %1 = %2", (long)n, 0L);
                    this.updateMenuEntryVisibility(n4, bl ? 1 : 0);
                    this.updateMenuEntryVisibility(n3, 1);
                    break;
                }
                case 1: {
                    this.getLogChannel().log(1000000, "updateThermometerIconVisibility (climateType = AUX_CLIMATE) for HEAT COIL ICON %1 = %2", (long)n, 1L);
                    this.updateMenuEntryVisibility(n4, 1);
                    this.updateMenuEntryVisibility(n3, bl ? 1 : 0);
                    break;
                }
                case 0: {
                    this.getLogChannel().log(1000000, "updateThermometerIconVisibility (climateType = AUX_COMBINED) for HEAT COIL ICON %1 = %2", (long)n, 0L);
                    this.updateMenuEntryVisibility(n4, bl ? 1 : 0);
                    this.updateMenuEntryVisibility(n3, bl ? 1 : 0);
                    break;
                }
            }
        } else {
            this.getLogChannel().log(1000000, "updateThermometerIconVisibility: setting both the heat coil and the thermometer visible for timer %1", (long)n);
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
                    this.getLogChannel().log(1000000, "isOperationMode: trying to get invalid menu Entry for timer: %1", (long)n);
                }
            }
        }
        return bl;
    }

    protected void updateAuxACImmediateOn(boolean bl) {
        this.auxAcImmediateOn = bl;
        this.updateMenuEntryVisibilityNow(bl, this.auxACImmediateVisiblityState);
    }

    protected void updateAuxACImmediateVisibilityState(int n) {
        this.auxACImmediateVisiblityState = n;
        this.updateMenuEntryVisibilityNow(this.auxAcImmediateOn, n);
    }

    private int getClimateSystemVariant() {
        return this.getApplication().getClimateSystemVariant();
    }

    protected void updateEntryVisibilityForStateChange(BatteryControlClimateState batteryControlClimateState, BatteryControlChargeState batteryControlChargeState, BatteryControlViewOptions batteryControlViewOptions) {
        this.getLogChannel().log(1000000, "updateEntryVisibilityForError with climateState %1 and chargeState %2", (Object)batteryControlClimateState, (Object)batteryControlChargeState);
        if (batteryControlChargeState != null) {
            this.updateVisibilityForChargeStateChange(batteryControlClimateState, batteryControlChargeState, batteryControlViewOptions);
        }
        if (batteryControlClimateState != null) {
            this.updateVisibilityForClimateStateChange(batteryControlClimateState, batteryControlChargeState, batteryControlViewOptions);
        }
        if (batteryControlViewOptions != null && batteryControlViewOptions.getConfiguration() != null && !batteryControlViewOptions.getConfiguration().isParkheaterInstallation()) {
            this.getLogChannel().log(1000000, "updateEntryVisibilityForStateChange for HEAT COIL ICON 1 and 2 = %1", 13L);
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

    public void notifyScreenVisible(int n) {
    }

    public void notifyScreenHidden(int n) {
    }

    public void notifyScreenConnected(int n) {
    }

    public void notifyScreenFadedOut(int n) {
        this.getLogChannel().log(1000000, "[AuxAcComponentEvo#notifyScreenFadedOut] screenID='%1'", (long)n);
        if (n == 600259 || n == 600287) {
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

    public void notifyVisibilityChange(List list) {
        this.getLogChannel().log(1000000, "[AuxAcComponentEvo#notifyVisibilityChange]");
        Object[] objectArray = list.toArray();
        for (int i2 = 0; i2 < objectArray.length; ++i2) {
            IMenuEntry iMenuEntry = (IMenuEntry)objectArray[i2];
            if (iMenuEntry.getID() == 231) {
                if (iMenuEntry.getState() > 1) {
                    this.getLogChannel().log(1000000, "notifyVisibilityChange state for HEAT COIL ICON 1 = %1", 1L);
                    this.updateMenuEntryVisibility(238, 1);
                    this.updateMenuEntryVisibility(236, 1);
                } else {
                    this.updateThermometerIconVisibility(1, this.lastKnownClimateSystemType.get(0));
                }
            }
            if (iMenuEntry.getID() != 232) continue;
            if (iMenuEntry.getState() > 1) {
                this.getLogChannel().log(1000000, "notifyVisibilityChange state for HEAT COIL ICON 2 = %1", 1L);
                this.updateMenuEntryVisibility(239, 1);
                this.updateMenuEntryVisibility(237, 1);
                continue;
            }
            this.updateThermometerIconVisibility(2, this.lastKnownClimateSystemType.get(1));
        }
    }

    public void initUseOfMenuStructure(IMenuEntryStructure iMenuEntryStructure) {
    }

    public void acknowledgeBatteryControlImmediately(boolean bl, int n) {
        super.acknowledgeBatteryControlImmediately(bl, n);
        switch (n) {
            case 0: {
                this.getLogChannel().log(10000000, "acknowledgeBatteryControlImmediately: stop - %1", (Object)(bl ? "successful" : "unsuccessful"));
                this.popupHandler.removePopup();
                break;
            }
            case 1: {
                this.getLogChannel().log(10000000, "acknowledgeBatteryControlImmediately: start - %1", (Object)(bl ? "successful" : "unsuccessful"));
                this.popupHandler.showPopup();
                break;
            }
            default: {
                this.getLogChannel().log(10000, "acknowledgeBatteryControlImmediately: invalid control=%1", (long)n);
            }
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

    private class ImmediateOnPopupHandler
    implements IPartialPopupListener {
        public static final int POPUP_INVALID = -1;
        private int popupID = -1;
        private CarServiceProvider partialPopupServiceProvider;
        private final ICarApplication application;
        private final LogChannel logChannel;
        private volatile boolean popupVisible = false;
        private final Object mutex = new Object();

        public ImmediateOnPopupHandler(ICarApplication iCarApplication, LogChannel logChannel, int n) {
            this.application = iCarApplication;
            this.logChannel = logChannel;
            this.popupID = n;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void showPopup() {
            if (this.popupID == -1) {
                this.logChannel.log(10000, "[ImmediateOnPopupHandler#showPopup] No popup defined for config=%1", (long)AuxACComponentEvo.this.getClimateSystemVariant());
            } else {
                Object object = this.mutex;
                synchronized (object) {
                    if (!this.popupVisible) {
                        this.application.getFrameworkAccess().getHMIService().showPartialPopup(0, this.popupID);
                        this.logChannel.log(1000000, "[ImmediateOnPopupHandler#showPopup] Requesting popup at HMI Service");
                    } else {
                        this.logChannel.log(1000000, "[ImmediateOnPopupHandler#showPopup] Cannot request popup - already visible");
                    }
                }
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void removePopup() {
            Object object = this.mutex;
            synchronized (object) {
                if (this.popupVisible) {
                    this.application.getFrameworkAccess().getHMIService().removePartialPopup(0, this.popupID);
                    this.logChannel.log(1000000, "[ImmediateOnPopupHandler#removePopup] Removing popup from HMI Service");
                } else {
                    this.logChannel.log(1000000, "[ImmediateOnPopupHandler#removePopup] Cannot remove popup - not visible");
                }
            }
        }

        public void initServiceProvider() {
            this.partialPopupServiceProvider = new CarServiceProvider((class$de$audi$atip$hmi$view$IPartialPopupListener == null ? (class$de$audi$atip$hmi$view$IPartialPopupListener = AuxACComponentEvo.class$("de.audi.atip.hmi.view.IPartialPopupListener")) : class$de$audi$atip$hmi$view$IPartialPopupListener).getName(), this, null, this.application.getBundleContext(), this.logChannel);
            this.partialPopupServiceProvider.startService();
            this.logChannel.log(1000000, "[ParkingPartialPopupHandler#initServiceProvider] Service provider initialized");
        }

        public void deinitServiceProvider() {
            this.partialPopupServiceProvider.stopService();
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void partialPopupVisible(int n, int n2) {
            this.logChannel.log(1000000, "[ImmediateOnPopupHandler#partialPopupVisible] partialPopupID = %1", (long)n);
            Object object = this.mutex;
            synchronized (object) {
                this.popupVisible = true;
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void partialPopupHidden(int n, int n2) {
            this.logChannel.log(1000000, "[ImmediateOnPopupHandler#partialPopupHidden] partialPopupID = %1", (long)n);
            Object object = this.mutex;
            synchronized (object) {
                if (this.popupVisible) {
                    this.popupVisible = false;
                    this.application.getFrameworkAccess().getHMIService().removePartialPopup(0, n);
                }
            }
        }

        public void partialPopupRemoved(int n, int n2) {
            this.logChannel.log(1000000, "[ImmediateOnPopupHandler#partialPopupRemoved] partialPopupID = %1", (long)n);
        }

        public int[] getPPIDsForCallbacks() {
            return new int[]{this.popupID};
        }

        public void partialPopupListenerRegistered(int n, int n2, boolean bl) {
        }

        public void informAboutPPCoordinates(int n, int n2, int n3, int n4, int n5, int n6) {
        }
    }
}

