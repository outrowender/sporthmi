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
    public static final short CODING_ID = 15;
    private static final String LOGCHANNEL_NAME = "App.Car.DoorLocking";
    private volatile DoorLockingViewOptions currentViewOptions;
    private volatile DoorLockingComfortOpenSettings doorLockingComfort = new DoorLockingComfortOpenSettings();
    private volatile DoorLockingRearBlind rearBlind = new DoorLockingRearBlind();
    private static final Object mutex = new Object();

    public AbstractDoorLockingComponent(ICarApplication iCarApplication) {
        super(iCarApplication, LOGCHANNEL_NAME);
    }

    protected void initModels() {
        this.getChoiceModel(600878).setChoiceListener(this);
        this.getChoiceModel(600880).setChoiceListener(this);
        this.getChoiceModel(600876).setChoiceListener(this);
        this.getChoiceModel(600884).setChoiceListener(this);
        this.getChoiceModel(600871).setChoiceListener(this);
        this.getChoiceModel(600882).setChoiceListener(this);
        this.getChoiceModel(600869).setChoiceListener(this);
        this.getChoiceModel(600866).setChoiceListener(this);
        this.getChoiceModel(600873).setChoiceListener(this);
        this.getChoiceModel(602732).setChoiceListener(this);
    }

    protected void deinitModels() {
        this.getChoiceModel(600884).resetListener();
        this.getChoiceModel(600871).resetListener();
        this.getChoiceModel(600882).resetListener();
        this.getChoiceModel(600869).resetListener();
        this.getChoiceModel(600866).resetListener();
        this.getChoiceModel(600873).resetListener();
        this.getChoiceModel(602732).resetListener();
    }

    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{5}, new int[]{17, 16, 9, 20, 14, 13, 18, 85})};
    }

    public String getCurrentViewOptions() {
        if (this.currentViewOptions == null) {
            return "no view options received yet";
        }
        return this.currentViewOptions.toString();
    }

    public void updateDoorLockingViewOptions(DoorLockingViewOptions doorLockingViewOptions, int n) {
        this.getLogChannel().log(1000000, "updateDoorLockingViewOptions: doorLockingCapabilities=%1, validFlag=%2", (Object)doorLockingViewOptions, (long)n);
        if (doorLockingViewOptions != null && n == 1) {
            this.currentViewOptions = doorLockingViewOptions;
            this.updateMenuEntryVisibility(this.currentViewOptions);
            this.primaryAttributeReceived(0, 5);
        }
    }

    public void updateDoorLockingUnlockingMode(int n, int n2) {
        this.getLogChannel().log(1000000, "updateDoorLockingUnlockingMode: mode=%1, validFlag=%2", (long)n, (long)n2);
        if (n2 == 1) {
            this.getChoiceModel(600884).setValue(n == 3 ? 0 : 1);
        }
    }

    public void updateDoorLockingMirrorProtection(boolean bl, int n) {
        this.getLogChannel().log(1000000, "updateDoorLockingMirrorProtection: doorLockingMirrorProtection=%1, validFlag=%2", bl, (long)n);
        if (n == 1) {
            this.getChoiceModel(600882).setValue(bl ? 1 : 0);
        }
    }

    public void updateDoorLockingAutoLock(int n, int n2) {
        this.getLogChannel().log(1000000, "updateDoorLockingAutoLock: doorLockingAutoLock=%1, validFlag=%2", (long)n, (long)n2);
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
            this.getChoiceModel(600866).setValue(n3);
        }
    }

    public void updateDoorLockingRearBlind(DoorLockingRearBlind doorLockingRearBlind, int n) {
        this.getLogChannel().log(1000000, "updateDoorLockingRearBlind: rearBlind.isRearBlindReverseGear()=%1, validFlag=%2", (Object)(doorLockingRearBlind == null ? "null" : Boolean.toString(doorLockingRearBlind.isRearBlindReverseGear())), (long)n);
        if (doorLockingRearBlind != null && n == 1) {
            this.getChoiceModel(600873).setValue(doorLockingRearBlind.isRearBlindReverseGear() ? 1 : 0);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateDoorLockingComfortOpenSettings(DoorLockingComfortOpenSettings doorLockingComfortOpenSettings, int n) {
        this.getLogChannel().log(1000000, "updateDoorLockingComfortOpenSettings: doorLockingComfort=%1, validFlag=%2", (Object)doorLockingComfortOpenSettings, (long)n);
        if (doorLockingComfortOpenSettings != null && n == 1) {
            boolean bl = doorLockingComfortOpenSettings.isDriverWindow() && doorLockingComfortOpenSettings.isCodriverWindow();
            boolean bl2 = doorLockingComfortOpenSettings.isDriverRearWindow() && doorLockingComfortOpenSettings.isCodriverRearWindow();
            this.getChoiceModel(600878).setValue(bl ? 1 : 0);
            this.getChoiceModel(600880).setValue(bl2 ? 1 : 0);
            this.getChoiceModel(600876).setValue(doorLockingComfortOpenSettings.isSunRoof() ? 1 : 0);
            Object object = mutex;
            synchronized (object) {
                this.doorLockingComfort = doorLockingComfortOpenSettings;
            }
        }
    }

    public void updateDoorLockingBootLock(boolean bl, int n) {
        this.getLogChannel().log(10000000, "updateDoorLockingBootLock: bootLock=%1, validFlag=%2", bl, (long)n);
        if (n == 1) {
            this.getChoiceModel(600871).setValue(bl ? 1 : 0);
        }
    }

    public void updateDoorLockingClBootLock(boolean bl, int n) {
        this.getLogChannel().log(10000000, "updateDoorLockingClBootLock: bootLock=%1, validFlag=%2", bl, (long)n);
        if (n == 1) {
            this.getChoiceModel(600871).setValue(bl ? 1 : 0);
        }
    }

    public void updateDoorLockingKeyless(boolean bl, int n) {
        this.getLogChannel().log(10000000, "updateDoorLockingKeyless: keylessEntry=%1, validFlag=%2", bl, (long)n);
        if (n == 1) {
            this.getChoiceModel(602732).setValue(bl ? 1 : 0);
        }
    }

    public void updateDoorLockingConfirmation(boolean bl, int n) {
        this.getLogChannel().log(10000000, "updateDoorLockingConfirmation: confirmation=%1, validFlag=%2", bl, (long)n);
        if (n == 1) {
            this.getChoiceModel(600869).setValue(bl ? 1 : 0);
        }
    }

    public void keyPressed(int n, int n2, int n3) {
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void keyTyped(int n, int n2, int n3) {
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }

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
        this.getLogChannel().log(1000000, "dsi.setDoorLockingKeyless(%1)", bl);
        this.getDSI().setDoorLockingKeyless(bl);
    }

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
            this.getLogChannel().log(1000000, "dsi.setDoorLockingComfort(%1)", (Object)this.doorLockingComfort);
            this.getDSI().setDoorLockingComfortOpenSettings(this.doorLockingComfort);
        }
    }

    private void setItemSelectedOfRearBlind(boolean bl) {
        this.rearBlind.rearBlindReverseGear = bl;
        this.getLogChannel().log(1000000, "dsi.setRearBlind(%1)", bl);
        this.getDSI().setDoorLockingRearBlind(this.rearBlind);
    }

    private void setItemSelectedOfAutoLock(boolean bl) {
        int n = bl ? 2 : 0;
        this.getLogChannel().log(1000000, "dsi.setDoorLockingAutoLock(%1)", (long)n);
        this.getDSI().setDoorLockingAutoLock(n);
    }

    private void setItemSelectedBootLock(boolean bl) {
        this.getLogChannel().log(1000000, "dsi.setDoorLockingBootLock(%1)", bl);
        this.getDSI().setDoorLockingClBootLock(bl);
    }

    private void setItemSelectedConfirmationTone(boolean bl) {
        this.getLogChannel().log(1000000, "dsi.setDoorLockingConfirmation(%1)", bl);
        this.getDSI().setDoorLockingConfirmation(bl);
    }

    private void setItemSelectedMirrors(boolean bl) {
        this.getLogChannel().log(1000000, "dsi.setDoorLockingMirrorProtection(%1)", bl);
        this.getDSI().setDoorLockingMirrorProtection(bl);
    }

    private void setItemSelectedUnLockingMode(int n) {
        int n2 = n == 0 ? 3 : 1;
        this.getLogChannel().log(1000000, "dsi.setDoorLockingUnlockingMode(%1)", (long)n2);
        this.getDSI().setDoorLockingUnlockingMode(n2);
    }

    protected abstract void updateMenuEntryVisibility(DoorLockingViewOptions var1);

    public String getName() {
        return "Door Locking";
    }
}

