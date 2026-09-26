/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.hybrid;

import de.audi.app.car.common.adapter.AbstractDSICarHybridAdapter;
import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import de.audi.app.car.core.hybrid.AbstractZeroEmissionStatisticsComponent;
import org.dsi.ifc.carhybrid.HybridEnergyFlowState;
import org.dsi.ifc.carhybrid.HybridViewOptions;

public class AbstractZeroEmissionStatisticsComponent$ZeroEmissionStatisticsSubComponentHybrid
extends AbstractDSICarHybridAdapter {
    private final /* synthetic */ AbstractZeroEmissionStatisticsComponent this$0;

    public AbstractZeroEmissionStatisticsComponent$ZeroEmissionStatisticsSubComponentHybrid(AbstractZeroEmissionStatisticsComponent abstractZeroEmissionStatisticsComponent, ICarApplication iCarApplication) {
        this.this$0 = abstractZeroEmissionStatisticsComponent;
        super(iCarApplication, "App.Car.Hybrid.Statistics");
    }

    @Override
    public String getName() {
        return "ZeroEmissionStatistics | Hybrid";
    }

    @Override
    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{1}, new int[]{3})};
    }

    @Override
    public String getCurrentViewOptions() {
        return AbstractZeroEmissionStatisticsComponent.access$300(this.this$0);
    }

    @Override
    protected void initModels() {
    }

    @Override
    protected void deinitModels() {
    }

    @Override
    protected void initVisibility() {
    }

    @Override
    protected void deinitVisibility() {
    }

    @Override
    public int getID() {
        return this.this$0.getSubComponentHybridID();
    }

    @Override
    public void updateHybridViewOptions(HybridViewOptions hybridViewOptions, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[ZeroEmissionStatisticsSubComponentHybrid#updateHybridViewOptions] viewOptions='%1', valid='%2'", (Object)(hybridViewOptions != null ? this.formatViewOptionsLog(hybridViewOptions.toString()) : "null"), (long)n);
        }
        if (1 == n && null != hybridViewOptions) {
            this.this$0.currentHybridViewOptions = hybridViewOptions;
            this.this$0.updateMenuEntryVisibility();
            this.primaryAttributeFirstSetReceived();
            if (this.this$0.isSDISSupported() && null != this.this$0.sdisInterface) {
                this.this$0.sdisInterface.sendVisibilityStates(this.this$0.currentHybridViewOptions.getHybridEnergyFlowState());
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updateHybridEnergyFlowState(HybridEnergyFlowState hybridEnergyFlowState, int n) {
        this.getLogChannel().log(1078071040, "[ZeroEmissionStatisticsSubComponentHybrid#updateHybridEnergyFlowState] viewOptions='%1', valid='%2'", (Object)(hybridEnergyFlowState != null ? hybridEnergyFlowState.toString() : "null"), (long)n);
        if (1 == n) {
            Object object = this.this$0.mutex;
            synchronized (object) {
                this.this$0.currentEnergyFlowState = hybridEnergyFlowState;
            }
        }
    }
}

