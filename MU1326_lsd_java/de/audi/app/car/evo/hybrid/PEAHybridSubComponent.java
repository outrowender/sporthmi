/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.evo.hybrid;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.core.hybrid.AbstractPEAHybridSubComponent;
import de.audi.app.car.evo.eco.PEAComponentHybridAccess;
import org.dsi.ifc.carhybrid.HybridViewOptions;

public class PEAHybridSubComponent
extends AbstractPEAHybridSubComponent {
    private final PEAComponentHybridAccess peaComponent;

    public PEAHybridSubComponent(ICarApplication iCarApplication, PEAComponentHybridAccess pEAComponentHybridAccess) {
        super(iCarApplication);
        this.peaComponent = pEAComponentHybridAccess;
    }

    protected void initVisibility() {
    }

    protected void deinitVisibility() {
    }

    public void updateMenuEntryVisibility(HybridViewOptions hybridViewOptions) {
        int n = this.getMenuEntryVisibilityState(hybridViewOptions.hybridActivePedal);
        this.peaComponent.updateHybridFunctionVisibility(n);
    }

    public int getID() {
        return 50;
    }
}

