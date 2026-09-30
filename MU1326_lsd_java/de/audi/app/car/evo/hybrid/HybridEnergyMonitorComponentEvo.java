/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.evo.hybrid;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.core.hybrid.AbstractHybridEnergyMonitorComponent;
import de.audi.app.car.core.hybrid.HybridEnergyMonitorViewControllerEVO;
import de.audi.app.car.core.hybrid.IHybridEnergyMonitorViewController;
import org.dsi.ifc.carhybrid.HybridViewOptions;

public class HybridEnergyMonitorComponentEvo
extends AbstractHybridEnergyMonitorComponent {
    private final IHybridEnergyMonitorViewController viewController;

    public HybridEnergyMonitorComponentEvo(ICarApplication iCarApplication) {
        super(iCarApplication);
        this.viewController = new HybridEnergyMonitorViewControllerEVO(iCarApplication.getFrameworkAccess(), this.getLogChannel());
    }

    protected void initVisibility() {
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(190, (short)24);
    }

    protected void deinitVisibility() {
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(190);
    }

    public int getID() {
        return 45;
    }

    protected void updateMenuEntryVisibility(HybridViewOptions hybridViewOptions) {
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(190, this.getMenuEntryVisibilityState(hybridViewOptions.getHybridEnergyFlowState()));
    }

    protected IHybridEnergyMonitorViewController getViewController() {
        return this.viewController;
    }
}

