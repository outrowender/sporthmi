/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.comp;

import de.audi.app.car.common.adapter.AbstractDSICarDrivingCharacteristicsAdapter;
import de.audi.app.car.common.app.ICarApplication;

public abstract class AbstractBaseCharismaComponent
extends AbstractDSICarDrivingCharacteristicsAdapter {
    public static final int CHARISMA_POPUP_ID_INVALID = -1;

    public AbstractBaseCharismaComponent(ICarApplication iCarApplication, String string) {
        super(iCarApplication, string);
    }

    public abstract int getPopUpID();

    public abstract void showCharismaPopup(int var1, int var2);

    public abstract void cancelCharismaPopup(int var1, int var2);

    public abstract boolean isDriveSelectScreenVisible();

    public abstract int getStandbyPopupID();

    public void setDriveSelectPowerManagementActive(boolean bl) {
        if (this.hasToWakeMUFromStandby()) {
            this.getLogChannel().log(1000000, "[AbstractCharismaComponent#setDriveSelectPowerManagementActive] powerManager.setExtendedPowerState: active='%1'", bl);
            try {
                this.getApplication().getFrameworkAccess().getPowerMgr().setExtendedPowerState(bl ? 132 : 133, 0);
            }
            catch (Exception exception) {
                this.getLogChannel().log(1000, "[AbstractCharismaComponent#setDriveSelectPowerManagementActive] exception occured during setting extended power state", (Throwable)exception);
            }
        }
    }

    public boolean hasToWakeMUFromStandby() {
        return this.getApplication().getFrameworkAccess().getKombiType() == 4;
    }
}

