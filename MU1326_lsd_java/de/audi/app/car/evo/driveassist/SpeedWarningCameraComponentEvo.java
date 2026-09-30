/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.evo.driveassist;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.core.driveassist.AbstractSpeedWarningCameraComponent;
import org.dsi.ifc.cardriverassistance.TSDViewOptions;

public class SpeedWarningCameraComponentEvo
extends AbstractSpeedWarningCameraComponent {
    private boolean speedWarningUnitKMPH = true;
    private int speedWarningCameraVisiblityState = 1;

    public SpeedWarningCameraComponentEvo(ICarApplication iCarApplication) {
        super(iCarApplication);
    }

    protected void initVisibility() {
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600213, (short)30);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600214, (short)30);
        this.updateSpeedWarningCameraVisibilityState(this.speedWarningCameraVisiblityState);
    }

    protected void deinitVisibility() {
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600213);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600214);
    }

    protected void updateMenuEntryVisibility(TSDViewOptions tSDViewOptions) {
        int n = this.getMenuEntryVisibilityState(tSDViewOptions.getSpeedWarningThreshold());
        this.selectVariant(n);
        this.updateSpeedWarningCameraVisibilityState(n);
    }

    private void selectVariant(int n) {
        String string;
        int n2;
        if (n != 1) {
            n2 = 54;
            string = "HIGH_VARIANT";
        } else {
            n2 = 55;
            string = "LOW_VARIANT";
        }
        boolean bl = this.getApplication().getMenuEntryRegistry().updateSlotBinding(56, n2);
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "[SpeedWarningCameraComponentEvo#selectVariant] variant='%1', menu entry manual speedwarning has been moved = '%2'", (Object)string, (Object)bl);
        }
    }

    public int getID() {
        return 24;
    }

    private void updateMenuEntryVisibilitySpeedWarningCamera(boolean bl, int n) {
        if (bl) {
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600213, n);
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600214, 1);
        } else {
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600214, n);
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600213, 1);
        }
    }

    protected void updateSpeedWarningUnit(boolean bl) {
        this.speedWarningUnitKMPH = bl;
        this.updateMenuEntryVisibilitySpeedWarningCamera(bl, this.getSpeedWarningCameraVisiblityState());
    }

    private void updateSpeedWarningCameraVisibilityState(int n) {
        this.speedWarningCameraVisiblityState = n;
        this.updateMenuEntryVisibilitySpeedWarningCamera(this.isSpeedWarningUnitKMPH(), n);
    }

    private int getSpeedWarningCameraVisiblityState() {
        return this.speedWarningCameraVisiblityState;
    }

    private boolean isSpeedWarningUnitKMPH() {
        return this.speedWarningUnitKMPH;
    }
}

