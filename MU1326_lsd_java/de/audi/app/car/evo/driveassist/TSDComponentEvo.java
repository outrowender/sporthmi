/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.evo.driveassist;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.core.driveassist.AbstractTSDComponent;
import org.dsi.ifc.cardriverassistance.TSDViewOptions;

public class TSDComponentEvo
extends AbstractTSDComponent {
    public TSDComponentEvo(ICarApplication iCarApplication) {
        super(iCarApplication);
    }

    @Override
    protected void updateMenuEntryVisibility(TSDViewOptions tSDViewOptions) {
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-1389885184, this.getMenuEntryVisibilityState(tSDViewOptions.getRoadSignFilter()));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(807930112, this.getMenuEntryVisibilityState(tSDViewOptions.getTrailerSpeedLimit()));
    }

    @Override
    protected void initVisibility() {
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(-1389885184, (short)30);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(807930112, (short)30);
    }

    @Override
    protected void deinitVisibility() {
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(-1389885184);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(807930112);
    }

    @Override
    public int getID() {
        return 19;
    }
}

