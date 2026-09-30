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

    protected void updateMenuEntryVisibility(TSDViewOptions tSDViewOptions) {
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600237, this.getMenuEntryVisibilityState(tSDViewOptions.getRoadSignFilter()));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600112, this.getMenuEntryVisibilityState(tSDViewOptions.getTrailerSpeedLimit()));
    }

    protected void initVisibility() {
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600237, (short)30);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600112, (short)30);
    }

    protected void deinitVisibility() {
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600237);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600112);
    }

    public int getID() {
        return 19;
    }
}

