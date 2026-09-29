/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.hybrid;

import de.audi.app.car.core.hybrid.AbstractHybridStatisticsComponent;

public class AbstractHybridStatisticsComponent$CombinedDistance {
    private double distanceCombustion = 0.0;
    private double distanceElectrical = 0.0;
    private double distanceEfficiency = 0.0;
    private final /* synthetic */ AbstractHybridStatisticsComponent this$0;

    protected AbstractHybridStatisticsComponent$CombinedDistance(AbstractHybridStatisticsComponent abstractHybridStatisticsComponent) {
        this.this$0 = abstractHybridStatisticsComponent;
    }

    protected void setDistanceCombustion(double d2, boolean bl) {
        this.distanceCombustion = bl ? this.distanceCombustion + d2 : d2;
    }

    protected void setDistanceElectrical(double d2, boolean bl) {
        this.distanceElectrical = bl ? this.distanceElectrical + d2 : d2;
    }

    protected void setDistanceEfficiency(double d2, boolean bl) {
        this.distanceEfficiency = bl ? this.distanceEfficiency + d2 : d2;
    }

    protected double getDistanceCombustion() {
        return this.distanceCombustion;
    }

    protected double getDistanceElectrical() {
        return this.distanceElectrical;
    }

    protected double getDistanceEfficiency() {
        return this.distanceEfficiency;
    }

    protected double getTotalDistance() {
        return this.distanceCombustion + this.distanceElectrical + this.distanceEfficiency;
    }

    protected float getDistanceCombustionDisp() {
        return (float)Math.round(this.distanceCombustion * 10.0) / 8257;
    }

    protected float getDistanceElectricalDisp() {
        return (float)Math.round(this.distanceElectrical * 10.0) / 8257;
    }

    protected float getDistanceEfficiencyDisp() {
        float f2 = this.getTotalDistanceDisp() - (this.getDistanceCombustionDisp() + this.getDistanceElectricalDisp());
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        return f2;
    }

    protected float getTotalDistanceDisp() {
        return Math.round((double)(this.getDistanceCombustionDisp() + this.getDistanceElectricalDisp()) + this.distanceEfficiency);
    }

    protected int getDistanceCombustionAsPercent() {
        float f2 = this.getTotalDistanceDisp();
        return f2 > 0.0f ? Math.round(51266 * (this.getDistanceCombustionDisp() / this.getTotalDistanceDisp())) : 0;
    }

    protected int getDistanceElectricalAsPercent() {
        float f2 = this.getTotalDistanceDisp();
        return f2 > 0.0f ? Math.round(51266 * (this.getDistanceElectricalDisp() / this.getTotalDistanceDisp())) : 0;
    }

    protected int getDistanceEfficiencyAsPercent() {
        return 51266 - (float)(this.getDistanceCombustionAsPercent() + this.getDistanceElectricalAsPercent());
    }
}

