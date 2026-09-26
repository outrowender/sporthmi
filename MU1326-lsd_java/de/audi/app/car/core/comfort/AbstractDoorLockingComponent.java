/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.comfort;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import de.audi.app.car.core.comfort.AbstractDSICarComfortAdapter;
import de.audi.atip.hmi.model.ChoiceListener;
import org.dsi.ifc.carcomfort.DoorLockingComfortOpenSettings;
import org.dsi.ifc.carcomfort.DoorLockingRearBlind;
import org.dsi.ifc.carcomfort.DoorLockingViewOptions;

public abstract class AbstractDoorLockingComponent
extends AbstractDSICarComfortAdapter
implements ChoiceListener {
    public static final short CODING_ID;
    private static final String LOGCHANNEL_NAME;
    private volatile DoorLockingViewOptions currentViewOptions;
    private volatile DoorLockingComfortOpenSettings doorLockingComfort = new DoorLockingComfortOpenSettings();
    private volatile DoorLockingRearBlind rearBlind = new DoorLockingRearBlind();
    private static final Object mutex;

    public AbstractDoorLockingComponent(ICarApplication iCarApplication) {
        super(iCarApplication, "App.Car.DoorLocking");
    }

    @Override
    protected void initModels() {
        this.getChoiceModel(774572288).setChoiceListener(this);
        this.getChoiceModel(808126720).setChoiceListener(this);
        this.getChoiceModel(741017856).setChoiceListener(this);
        this.getChoiceModel(875235584).setChoiceListener(this);
        this.getChoiceModel(657131776).setChoiceListener(this);
        this.getChoiceModel(841681152).setChoiceListener(this);
        this.getChoiceModel(623577344).setChoiceListener(this);
        this.getChoiceModel(573245696).setChoiceListener(this);
        this.getChoiceModel(690686208).setChoiceListener(this);
        this.getChoiceModel(1815218432).setChoiceListener(this);
    }

    @Override
    protected void deinitModels() {
        this.getChoiceModel(875235584).resetListener();
        this.getChoiceModel(657131776).resetListener();
        this.getChoiceModel(841681152).resetListener();
        this.getChoiceModel(623577344).resetListener();
        this.getChoiceModel(573245696).resetListener();
        this.getChoiceModel(690686208).resetListener();
        this.getChoiceModel(1815218432).resetListener();
    }

    @Override
    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{5}, new int[]{17, 16, 9, 20, 14, 13, 18, 85})};
    }

    @Override
    public String getCurrentViewOptions() {
        if (this.currentViewOptions == null) {
            return "no view options received yet";
        }
        return this.currentViewOptions.toString();
    }

    @Override
    public void updateDoorLockingViewOptions(DoorLockingViewOptions doorLockingViewOptions, int n) {
        this.getLogChannel().log(1078071040, "updateDoorLockingViewOptions: doorLockingCapabilities=%1, validFlag=%2", (Object)doorLockingViewOptions, (long)n);
        if (doorLockingViewOptions != null && n == 1) {
            this.currentViewOptions = doorLockingViewOptions;
            this.updateMenuEntryVisibility(this.currentViewOptions);
            this.primaryAttributeReceived(0, 5);
        }
    }

    @Override
    public void updateDoorLockingUnlockingMode(int n, int n2) {
        this.getLogChannel().log(1078071040, "updateDoorLockingUnlockingMode: mode=%1, validFlag=%2", (long)n, (long)n2);
        if (n2 == 1) {
            this.getChoiceModel(875235584).setValue(n == 3 ? 0 : 1);
        }
    }

    @Override
    public void updateDoorLockingMirrorProtection(boolean bl, int n) {
        this.getLogChannel().log(1078071040, "updateDoorLockingMirrorProtection: doorLockingMirrorProtection=%1, validFlag=%2", bl, (long)n);
        if (n == 1) {
            this.getChoiceModel(841681152).setValue(bl ? 1 : 0);
        }
    }

    @Override
    public void updateDoorLockingAutoLock(int n, int n2) {
        this.getLogChannel().log(1078071040, "updateDoorLockingAutoLock: doorLockingAutoLock=%1, validFlag=%2", (long)n, (long)n2);
        if (n2 == 1) {
            int n3 = 0;
            switch (n) {
                case 2: {
                    n3 = 1;
                    break;
                }
                case 0: {
                    n3 = 0;
                    break;
                }
            }
            this.getChoiceModel(573245696).setValue(n3);
        }
    }

    @Override
    public void updateDoorLockingRearBlind(DoorLockingRearBlind doorLockingRearBlind, int n) {
        this.getLogChannel().log(1078071040, "updateDoorLockingRearBlind: rearBlind.isRearBlindReverseGear()=%1, validFlag=%2", (Object)(doorLockingRearBlind == null ? "null" : Boolean.toString(doorLockingRearBlind.isRearBlindReverseGear())), (long)n);
        if (doorLockingRearBlind != null && n == 1) {
            this.getChoiceModel(690686208).setValue(doorLockingRearBlind.isRearBlindReverseGear() ? 1 : 0);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updateDoorLockingComfortOpenSettings(DoorLockingComfortOpenSettings doorLockingComfortOpenSettings, int n) {
        this.getLogChannel().log(1078071040, "updateDoorLockingComfortOpenSettings: doorLockingComfort=%1, validFlag=%2", (Object)doorLockingComfortOpenSettings, (long)n);
        if (doorLockingComfortOpenSettings != null && n == 1) {
            boolean bl = doorLockingComfortOpenSettings.isDriverWindow() && doorLockingComfortOpenSettings.isCodriverWindow();
            boolean bl2 = doorLockingComfortOpenSettings.isDriverRearWindow() && doorLockingComfortOpenSettings.isCodriverRearWindow();
            this.getChoiceModel(774572288).setValue(bl ? 1 : 0);
            this.getChoiceModel(808126720).setValue(bl2 ? 1 : 0);
            this.getChoiceModel(741017856).setValue(doorLockingComfortOpenSettings.isSunRoof() ? 1 : 0);
            Object object = mutex;
            synchronized (object) {
                this.doorLockingComfort = doorLockingComfortOpenSettings;
            }
        }
    }

    @Override
    public void updateDoorLockingBootLock(boolean bl, int n) {
        this.getLogChannel().log(-2137614336, "updateDoorLockingBootLock: bootLock=%1, validFlag=%2", bl, (long)n);
        if (n == 1) {
            this.getChoiceModel(657131776).setValue(bl ? 1 : 0);
        }
    }

    @Override
    public void updateDoorLockingClBootLock(boolean bl, int n) {
        this.getLogChannel().log(-2137614336, "updateDoorLockingClBootLock: bootLock=%1, validFlag=%2", bl, (long)n);
        if (n == 1) {
            this.getChoiceModel(657131776).setValue(bl ? 1 : 0);
        }
    }

    @Override
    public void updateDoorLockingKeyless(boolean bl, int n) {
        this.getLogChannel().log(-2137614336, "updateDoorLockingKeyless: keylessEntry=%1, validFlag=%2", bl, (long)n);
        if (n == 1) {
            this.getChoiceModel(1815218432).setValue(bl ? 1 : 0);
        }
    }

    @Override
    public void updateDoorLockingConfirmation(boolean bl, int n) {
        this.getLogChannel().log(-2137614336, "updateDoorLockingConfirmation: confirmation=%1, validFlag=%2", bl, (long)n);
        if (n == 1) {
            this.getChoiceModel(623577344).setValue(bl ? 1 : 0);
        }
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        boolean bl = n2 == 1;
        this.logModelData("itemSelected", n, n2, true);
        switch (n) {
            case 600876: 
            case 600878: 
            case 600880: {
                this.setItemSelectedOfLongpress(bl);
                break;
            }
            case 600884: {
                this.setItemSelectedUnLockingMode(n2);
                break;
            }
            case 600871: {
                this.setItemSelectedBootLock(bl);
                break;
            }
            case 600882: {
                this.setItemSelectedMirrors(bl);
                break;
            }
            case 600869: {
                this.setItemSelectedConfirmationTone(bl);
                break;
            }
            case 602732: {
                this.setItemSelectedKeylessDoorlocking(bl);
                break;
            }
            case 600866: {
                this.setItemSelectedOfAutoLock(bl);
                break;
            }
            case 600873: {
                this.setItemSelectedOfRearBlind(bl);
                break;
            }
            default: {
                this.logModelData("itemSelected", n, n2, false);
            }
        }
    }

    private void setItemSelectedKeylessDoorlocking(boolean bl) {
        this.getLogChannel().log(1078071040, "dsi.setDoorLockingKeyless(%1)", bl);
        this.getDSI().setDoorLockingKeyless(bl);
    }

    @Override
    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void setItemSelectedOfLongpress(boolean bl) {
        Object object = mutex;
        synchronized (object) {
            if (this.currentViewOptions.getConfiguration().numberOfWindows >= 4) {
                this.doorLockingComfort.driverWindow = bl;
                this.doorLockingComfort.codriverWindow = bl;
                this.doorLockingComfort.driverRearWindow = bl;
                this.doorLockingComfort.codriverRearWindow = bl;
            } else {
                this.doorLockingComfort.driverWindow = bl;
                this.doorLockingComfort.codriverWindow = bl;
            }
            this.doorLockingComfort.sunRoof = this.currentViewOptions.getConfiguration().isSunRoof() ? bl : false;
            this.getLogChannel().log(1078071040, "dsi.setDoorLockingComfort(%1)", (Object)this.doorLockingComfort);
            this.getDSI().setDoorLockingComfortOpenSettings(this.doorLockingComfort);
        }
    }

    private void setItemSelectedOfRearBlind(boolean bl) {
        this.rearBlind.rearBlindReverseGear = bl;
        this.getLogChannel().log(1078071040, "dsi.setRearBlind(%1)", bl);
        this.getDSI().setDoorLockingRearBlind(this.rearBlind);
    }

    private void setItemSelectedOfAutoLock(boolean bl) {
        int n = bl ? 2 : 0;
        this.getLogChannel().log(1078071040, "dsi.setDoorLockingAutoLock(%1)", (long)n);
        this.getDSI().setDoorLockingAutoLock(n);
    }

    private void setItemSelectedBootLock(boolean bl) {
        this.getLogChannel().log(1078071040, "dsi.setDoorLockingBootLock(%1)", bl);
        this.getDSI().setDoorLockingClBootLock(bl);
    }

    private void setItemSelectedConfirmationTone(boolean bl) {
        this.getLogChannel().log(1078071040, "dsi.setDoorLockingConfirmation(%1)", bl);
        this.getDSI().setDoorLockingConfirmation(bl);
    }

    private void setItemSelectedMirrors(boolean bl) {
        this.getLogChannel().log(1078071040, "dsi.setDoorLockingMirrorProtection(%1)", bl);
        this.getDSI().setDoorLockingMirrorProtection(bl);
    }

    private void setItemSelectedUnLockingMode(int n) {
        int n2 = n == 0 ? 3 : 1;
        this.getLogChannel().log(1078071040, "dsi.setDoorLockingUnlockingMode(%1)", (long)n2);
        this.getDSI().setDoorLockingUnlockingMode(n2);
    }

    protected abstract void updateMenuEntryVisibility(DoorLockingViewOptions doorLockingViewOptions) {
    }

    @Override
    public String getName() {
        return "Door Locking";
    }

    static {
        mutex = new Object();
    }
}

