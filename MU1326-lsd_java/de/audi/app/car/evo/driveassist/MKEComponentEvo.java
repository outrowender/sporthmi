/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.evo.driveassist;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.core.driveassist.AbstractMKEComponent;
import org.dsi.ifc.cardriverassistance.MKEViewOptions;

public class MKEComponentEvo
extends AbstractMKEComponent {
    public MKEComponentEvo(ICarApplication iCarApplication) {
        super(iCarApplication);
    }

    @Override
    protected void updateMenuEntryVisibility(MKEViewOptions mKEViewOptions) {
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-1322776320, this.getMenuEntryVisibilityState(mKEViewOptions.getSystemOnOff()));
    }

    @Override
    protected void initVisibility() {
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(-1322776320, (short)35);
    }

    @Override
    protected void deinitVisibility() {
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(-1322776320);
    }

    @Override
    public int getID() {
        return 14;
    }
}

