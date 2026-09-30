/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.balancefader;

import de.audi.atip.hmi.event.ATIPEvent;
import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.modelaccess.RangeModel2DGUI;
import de.audi.atip.log.LogChannel;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.evo.widgets.balancefader.IWrappedRangeModel2DGUI;
import de.esolutions.hmi.widgets.audi.evo.widgets.balancefader.ValuePair;

public class WrappedRangeModel2DGUI
implements IWrappedRangeModel2DGUI,
IWidgetLogChannel {
    private RangeModel2DGUI rangeModel;
    private ValuePair cachedPosition;
    private ValuePair steps;
    private ValuePair modelMinima;
    private ValuePair modelSize;
    private int terminalID;
    private LogChannel lc;

    public WrappedRangeModel2DGUI(Object object, LogChannel logChannel, int n) {
        this.terminalID = n;
        this.lc = logChannel;
        this.rangeModel = (RangeModel2DGUI)object;
        this.updateModelSizeAndSteps();
        this.cachedPosition = new ValuePair(this.rangeModel.getValueX(), this.rangeModel.getValueY());
    }

    public void updateModelSizeAndSteps() {
        this.updateModelSize();
        this.updateSteps();
    }

    private void updateModelSize() {
        float f2 = this.rangeModel.getMaximumX() - this.rangeModel.getMinimumX();
        float f3 = this.rangeModel.getMaximumY() - this.rangeModel.getMinimumY();
        this.modelSize = new ValuePair(f2, f3);
        this.modelMinima = new ValuePair(this.rangeModel.getMinimumX(), this.rangeModel.getMinimumY());
        this.lc.log(10000000, "WrappedRangeModel2DGUI#updateModelSize modelSize = %1", (Object)this.modelSize);
    }

    private void updateSteps() {
        this.steps = new ValuePair(this.rangeModel.getStepX(), this.rangeModel.getStepY());
        this.steps = this.steps.divideBy(this.modelSize);
        this.lc.log(10000000, "WrappedRangeModel2DGUI#updateSteps steps = %1", (Object)this.steps);
    }

    public ValuePair processEvent(ATIPEvent aTIPEvent) {
        if (aTIPEvent instanceof ModelUpdateEvent) {
            ModelUpdateEvent modelUpdateEvent = (ModelUpdateEvent)aTIPEvent;
            if (modelUpdateEvent.getUpdateType() == 4) {
                this.updateModelSizeAndSteps();
                this.lc.log(10000000, "WrappedRangeModel2DGUI#processEvent LIMITS_CHANGED");
            } else if (modelUpdateEvent.getUpdateType() == 1) {
                this.cachedPosition = new ValuePair(this.rangeModel.getValueX(), this.rangeModel.getValueY());
                this.lc.log(10000000, "WrappedRangeModel2DGUI#processEvent VALUE_UPDATED");
            } else {
                this.lc.log(100000, "WrappedRangeModel2DGUI#processEvent ModelUpdateEvent updateType not supported!");
            }
        }
        return this.normToInterval(this.cachedPosition);
    }

    public ValuePair getPosition() {
        return this.normToInterval(this.cachedPosition);
    }

    private ValuePair normToInterval(ValuePair valuePair) {
        valuePair = valuePair.divideBy(this.modelSize);
        valuePair = valuePair.multiplyWith(new ValuePair(1.0f, -1.0f));
        return valuePair.add(0.5f);
    }

    public void setPosition(ValuePair valuePair) {
        this.cachedPosition = this.normToModel(valuePair);
        this.updateModel();
    }

    private ValuePair normToModel(ValuePair valuePair) {
        valuePair = valuePair.clamp(0.0f, 1.0f);
        ValuePair valuePair2 = valuePair.multiplyWith(this.modelSize);
        ValuePair valuePair3 = this.modelMinima.add(valuePair2);
        return valuePair3.multiplyWith(new ValuePair(1.0f, -1.0f));
    }

    private void updateModel() {
        ValuePair valuePair = new ValuePair(this.rangeModel.getValueX(), this.rangeModel.getValueY());
        if (!valuePair.equals(this.cachedPosition)) {
            ValuePair valuePair2 = this.cachedPosition.subtract(valuePair);
            int n = Math.round(valuePair2.getX());
            int n2 = Math.round(valuePair2.getY());
            this.rangeModel.setValueHit(n, n2, this.terminalID);
        }
    }

    public ValuePair getSteps() {
        return this.steps;
    }
}

