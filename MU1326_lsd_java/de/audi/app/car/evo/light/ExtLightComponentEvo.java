/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.evo.light;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.core.light.AbstractExtLightComponent;
import java.lang.reflect.Method;
import org.dsi.ifc.carlight.ExtLightViewOptions;
import org.dsi.ifc.global.CarViewOption;

public class ExtLightComponentEvo
extends AbstractExtLightComponent {
    public ExtLightComponentEvo(ICarApplication iCarApplication) {
        super(iCarApplication);
    }

    @Override
    protected void updateMenuEntryVisibility(ExtLightViewOptions extLightViewOptions) {
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-2128082688, this.getMenuEntryVisibilityState(new CarViewOption[]{extLightViewOptions.getComingHome(), extLightViewOptions.getLeavingHome()}));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-2111305472, this.getMenuEntryVisibilityState(extLightViewOptions.getDayLight()));
        if (extLightViewOptions.getExtLightConfig().isLeftHandTraffic()) {
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-2094528256, 1);
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-2077751040, this.getMenuEntryVisibilityState(extLightViewOptions.getTouristLight()));
        } else {
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-2094528256, this.getMenuEntryVisibilityState(extLightViewOptions.getTouristLight()));
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-2077751040, 1);
        }
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(2082998528, this.getMenuEntryVisibilityState(extLightViewOptions.getSwitchOnSensitivity()));
        boolean bl = false;
        if (this.hasExtlightViewOptionObjectMethodForLaserlight(extLightViewOptions)) {
            boolean bl2 = bl = this.getMenuEntryVisibilityState(extLightViewOptions.getLaserLight()) != 1;
        }
        if (bl) {
            boolean bl3;
            boolean bl4;
            boolean bl5;
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(2116552960, 1);
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(2099775744, 1);
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(2133330176, 1);
            boolean bl6 = bl5 = this.getMenuEntryVisibilityState(extLightViewOptions.getMaskedHighBeam()) != 1;
            if (bl5) {
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-651622144, this.getMenuEntryVisibilityState(extLightViewOptions.getLaserLight()));
                this.getChoiceModel(-2077357824).setValue(1);
            } else {
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-651622144, 1);
            }
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-584513280, this.getMenuEntryVisibilityState(extLightViewOptions.getMaskedHighBeam()));
            boolean bl7 = bl4 = this.getMenuEntryVisibilityState(extLightViewOptions.getGlidingLightSystem()) != 1;
            if (bl4) {
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-500627200, this.getMenuEntryVisibilityState(extLightViewOptions.getLaserLight()));
                this.getChoiceModel(-2077357824).setValue(2);
            } else {
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-500627200, 1);
            }
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-601290496, this.getMenuEntryVisibilityState(extLightViewOptions.getGlidingLightSystem()));
            boolean bl8 = bl3 = this.getMenuEntryVisibilityState(extLightViewOptions.getHeadlightSystem()) != 1;
            if (bl3) {
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-517404416, this.getMenuEntryVisibilityState(extLightViewOptions.getLaserLight()));
                this.getChoiceModel(-2077357824).setValue(3);
            } else {
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-517404416, 1);
            }
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-618067712, this.getMenuEntryVisibilityState(extLightViewOptions.getHeadlightSystem()));
        } else {
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(2116552960, this.getMenuEntryVisibilityState(extLightViewOptions.getHeadlightSystem()));
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(2099775744, this.getMenuEntryVisibilityState(extLightViewOptions.getGlidingLightSystem()));
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(2133330176, this.getMenuEntryVisibilityState(extLightViewOptions.getMaskedHighBeam()));
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-651622144, 1);
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-584513280, 1);
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-500627200, 1);
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-601290496, 1);
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-517404416, 1);
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-618067712, 1);
        }
    }

    @Override
    protected void initVisibility() {
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(-2128082688, (short)6);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(-2111305472, (short)6);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(-2094528256, (short)6);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(-2077751040, (short)6);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(2082998528, (short)6);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(2116552960, (short)6);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(2099775744, (short)6);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(2133330176, (short)6);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(-517404416, (short)6);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(-500627200, (short)6);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(-651622144, (short)6);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(-618067712, (short)6);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(-601290496, (short)6);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(-584513280, (short)6);
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(2116552960, 2);
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(2099775744, 1);
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(2133330176, 1);
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-651622144, 1);
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-584513280, 1);
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-500627200, 1);
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-601290496, 1);
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-517404416, 1);
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-618067712, 1);
    }

    @Override
    protected void deinitVisibility() {
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(-2128082688);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(-2111305472);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(-2094528256);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(-2077751040);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(2082998528);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(2116552960);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(2099775744);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(2133330176);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(-517404416);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(-500627200);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(-651622144);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(-618067712);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(-601290496);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(-584513280);
    }

    @Override
    public int getID() {
        return 15;
    }

    private boolean hasExtlightViewOptionObjectMethodForLaserlight(ExtLightViewOptions extLightViewOptions) {
        Method[] methodArray = super.getClass().getMethods();
        for (int i2 = 0; i2 < methodArray.length; ++i2) {
            if (!methodArray[i2].getName().equals("getLaserLight")) continue;
            return true;
        }
        return false;
    }
}

