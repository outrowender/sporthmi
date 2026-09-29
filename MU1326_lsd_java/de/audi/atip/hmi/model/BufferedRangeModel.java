/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model;

import de.audi.atip.hmi.model.BufferedAbstractModel;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.model.RangeListener;
import de.audi.atip.hmi.model.RangeModel;
import de.audi.atip.hmi.modelaccess.RangeModelApp;
import de.audi.atip.hmi.modelaccess.RangeModelGUI;

public class BufferedRangeModel
extends BufferedAbstractModel
implements RangeModelGUI,
RangeModelApp {
    private RangeModel rangeModel = (RangeModel)super.getMainModel();
    private boolean limitsChanged;
    private boolean valueChanged;

    public BufferedRangeModel(int n) {
        super(new RangeModel(n), new RangeModel(n));
    }

    public BufferedRangeModel(int n, int n2) {
        super(new RangeModel(n, n2), new RangeModel(n, n2));
    }

    @Override
    public void setLimits(int n, int n2, int n3) {
        this.getCurrent().setLimits(n, n2, n3);
        if (this.isTransactionRunning()) {
            this.limitsChanged = true;
        }
    }

    @Override
    public void setLimits(int n, int n2, int n3, int n4) {
        this.getCurrent().setLimits(n, n2, n3, n4);
        if (this.isTransactionRunning()) {
            this.limitsChanged = true;
        }
    }

    @Override
    public void setMedialPosition(int n) {
        this.getCurrent().setMedialPosition(n);
        if (this.isTransactionRunning()) {
            this.limitsChanged = true;
        }
    }

    @Override
    public int getMaximum() {
        return this.rangeModel.getMaximum();
    }

    @Override
    public int getMinimum() {
        return this.rangeModel.getMinimum();
    }

    @Override
    public int getMedialPosition() {
        return this.rangeModel.getMedialPosition();
    }

    @Override
    public void setPressed(boolean bl) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean getPressed() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setRangeListener(RangeListener rangeListener2) {
        this.getCurrent().setRangeListener(rangeListener2);
    }

    @Override
    public void setButtonListener(ButtonListener buttonListener) {
        this.getCurrent().setButtonListener(buttonListener);
    }

    @Override
    public int getStep() {
        return this.rangeModel.getStep();
    }

    @Override
    public void setValue(int n) {
        this.getCurrent().setValue(n);
        if (this.isTransactionRunning()) {
            this.valueChanged = true;
        }
    }

    @Override
    public int getValue() {
        return this.rangeModel.getValue();
    }

    @Override
    public void decrement(int n, int n2) {
        this.getCurrent().decrement(n, n2);
    }

    @Override
    public void endTransaction() {
        super.endTransaction();
        if (this.valueChanged) {
            this.rangeModel.fireModelUpdateEvent(1);
        }
        if (this.limitsChanged) {
            this.rangeModel.fireModelUpdateEvent(4);
        }
    }

    @Override
    public void increment(int n, int n2) {
        this.getCurrent().increment(n, n2);
    }

    @Override
    public void keyPressed(int n, int n2) {
        this.rangeModel.keyPressed(n, n2);
    }

    @Override
    public void keyReleased(int n, int n2) {
        this.rangeModel.keyReleased(n, n2);
    }

    @Override
    public void keyTyped(int n, int n2) {
        this.rangeModel.keyTyped(n, n2);
    }

    @Override
    public void keyLongTyped(int n, int n2) {
    }

    private RangeModel getCurrent() {
        return (RangeModel)super.getActiveModel();
    }

    @Override
    public void forceUpdate(boolean bl) {
    }

    @Override
    public boolean isForceUpdateEnabled() {
        return false;
    }
}

