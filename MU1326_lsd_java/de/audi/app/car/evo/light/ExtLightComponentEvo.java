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

    protected void updateMenuEntryVisibility(ExtLightViewOptions extLightViewOptions) {
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600193, this.getMenuEntryVisibilityState(new CarViewOption[]{extLightViewOptions.getComingHome(), extLightViewOptions.getLeavingHome()}));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600194, this.getMenuEntryVisibilityState(extLightViewOptions.getDayLight()));
        if (extLightViewOptions.getExtLightConfig().isLeftHandTraffic()) {
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600195, 1);
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600196, this.getMenuEntryVisibilityState(extLightViewOptions.getTouristLight()));
        } else {
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600195, this.getMenuEntryVisibilityState(extLightViewOptions.getTouristLight()));
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600196, 1);
        }
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600188, this.getMenuEntryVisibilityState(extLightViewOptions.getSwitchOnSensitivity()));
        boolean bl = false;
        if (this.hasExtlightViewOptionObjectMethodForLaserlight(extLightViewOptions)) {
            boolean bl2 = bl = this.getMenuEntryVisibilityState(extLightViewOptions.getLaserLight()) != 1;
        }
        if (bl) {
            boolean bl3;
            boolean bl4;
            boolean bl5;
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600190, 1);
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600189, 1);
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600191, 1);
            boolean bl6 = bl5 = this.getMenuEntryVisibilityState(extLightViewOptions.getMaskedHighBeam()) != 1;
            if (bl5) {
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600537, this.getMenuEntryVisibilityState(extLightViewOptions.getLaserLight()));
                this.getChoiceModel(601732).setValue(1);
            } else {
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600537, 1);
            }
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600541, this.getMenuEntryVisibilityState(extLightViewOptions.getMaskedHighBeam()));
            boolean bl7 = bl4 = this.getMenuEntryVisibilityState(extLightViewOptions.getGlidingLightSystem()) != 1;
            if (bl4) {
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600546, this.getMenuEntryVisibilityState(extLightViewOptions.getLaserLight()));
                this.getChoiceModel(601732).setValue(2);
            } else {
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600546, 1);
            }
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600540, this.getMenuEntryVisibilityState(extLightViewOptions.getGlidingLightSystem()));
            boolean bl8 = bl3 = this.getMenuEntryVisibilityState(extLightViewOptions.getHeadlightSystem()) != 1;
            if (bl3) {
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600545, this.getMenuEntryVisibilityState(extLightViewOptions.getLaserLight()));
                this.getChoiceModel(601732).setValue(3);
            } else {
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600545, 1);
            }
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600539, this.getMenuEntryVisibilityState(extLightViewOptions.getHeadlightSystem()));
        } else {
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600190, this.getMenuEntryVisibilityState(extLightViewOptions.getHeadlightSystem()));
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600189, this.getMenuEntryVisibilityState(extLightViewOptions.getGlidingLightSystem()));
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600191, this.getMenuEntryVisibilityState(extLightViewOptions.getMaskedHighBeam()));
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600537, 1);
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600541, 1);
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600546, 1);
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600540, 1);
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600545, 1);
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600539, 1);
        }
    }

    protected void initVisibility() {
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600193, (short)6);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600194, (short)6);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600195, (short)6);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600196, (short)6);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600188, (short)6);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600190, (short)6);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600189, (short)6);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600191, (short)6);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600545, (short)6);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600546, (short)6);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600537, (short)6);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600539, (short)6);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600540, (short)6);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600541, (short)6);
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600190, 2);
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600189, 1);
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600191, 1);
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600537, 1);
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600541, 1);
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600546, 1);
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600540, 1);
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600545, 1);
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600539, 1);
    }

    protected void deinitVisibility() {
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600193);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600194);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600195);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600196);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600188);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600190);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600189);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600191);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600545);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600546);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600537);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600539);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600540);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600541);
    }

    public int getID() {
        return 15;
    }

    private boolean hasExtlightViewOptionObjectMethodForLaserlight(ExtLightViewOptions extLightViewOptions) {
        Method[] methodArray = extLightViewOptions.getClass().getMethods();
        for (int i2 = 0; i2 < methodArray.length; ++i2) {
            if (!methodArray[i2].getName().equals("getLaserLight")) continue;
            return true;
        }
        return false;
    }
}

