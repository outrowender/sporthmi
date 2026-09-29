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

    @Override
    protected void initVisibility() {
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(-1792538368, (short)30);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(-1775761152, (short)30);
        this.updateSpeedWarningCameraVisibilityState(this.speedWarningCameraVisiblityState);
    }

    @Override
    protected void deinitVisibility() {
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(-1792538368);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(-1775761152);
    }

    @Override
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
            this.getLogChannel().log(1078071040, "[SpeedWarningCameraComponentEvo#selectVariant] variant='%1', menu entry manual speedwarning has been moved = '%2'", (Object)string, (Object)bl);
        }
    }

    @Override
    public int getID() {
        return 24;
    }

    private void updateMenuEntryVisibilitySpeedWarningCamera(boolean bl, int n) {
        if (bl) {
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-1792538368, n);
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-1775761152, 1);
        } else {
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-1775761152, n);
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-1792538368, 1);
        }
    }

    @Override
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

