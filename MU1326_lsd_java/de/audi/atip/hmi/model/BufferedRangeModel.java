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

    public void setLimits(int n, int n2, int n3) {
        this.getCurrent().setLimits(n, n2, n3);
        if (this.isTransactionRunning()) {
            this.limitsChanged = true;
        }
    }

    public void setLimits(int n, int n2, int n3, int n4) {
        this.getCurrent().setLimits(n, n2, n3, n4);
        if (this.isTransactionRunning()) {
            this.limitsChanged = true;
        }
    }

    public void setMedialPosition(int n) {
        this.getCurrent().setMedialPosition(n);
        if (this.isTransactionRunning()) {
            this.limitsChanged = true;
        }
    }

    public int getMaximum() {
        return this.rangeModel.getMaximum();
    }

    public int getMinimum() {
        return this.rangeModel.getMinimum();
    }

    public int getMedialPosition() {
        return this.rangeModel.getMedialPosition();
    }

    public void setPressed(boolean bl) {
        throw new UnsupportedOperationException();
    }

    public boolean getPressed() {
        throw new UnsupportedOperationException();
    }

    public void setRangeListener(RangeListener rangeListener2) {
        this.getCurrent().setRangeListener(rangeListener2);
    }

    public void setButtonListener(ButtonListener buttonListener) {
        this.getCurrent().setButtonListener(buttonListener);
    }

    public int getStep() {
        return this.rangeModel.getStep();
    }

    public void setValue(int n) {
        this.getCurrent().setValue(n);
        if (this.isTransactionRunning()) {
            this.valueChanged = true;
        }
    }

    public int getValue() {
        return this.rangeModel.getValue();
    }

    public void decrement(int n, int n2) {
        this.getCurrent().decrement(n, n2);
    }

    public void endTransaction() {
        super.endTransaction();
        if (this.valueChanged) {
            this.rangeModel.fireModelUpdateEvent(1);
        }
        if (this.limitsChanged) {
            this.rangeModel.fireModelUpdateEvent(4);
        }
    }

    public void increment(int n, int n2) {
        this.getCurrent().increment(n, n2);
    }

    public void keyPressed(int n, int n2) {
        this.rangeModel.keyPressed(n, n2);
    }

    public void keyReleased(int n, int n2) {
        this.rangeModel.keyReleased(n, n2);
    }

    public void keyTyped(int n, int n2) {
        this.rangeModel.keyTyped(n, n2);
    }

    public void keyLongTyped(int n, int n2) {
    }

    private RangeModel getCurrent() {
        return (RangeModel)super.getActiveModel();
    }

    public void forceUpdate(boolean bl) {
    }

    public boolean isForceUpdateEnabled() {
        return false;
    }
}

