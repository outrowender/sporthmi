/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model;

import de.audi.atip.hmi.model.AbstractModel;
import de.audi.atip.hmi.model.ButtonModel;
import de.audi.atip.hmi.model.RangeListener;
import de.audi.atip.hmi.modelaccess.RangeModelApp;
import de.audi.atip.hmi.modelaccess.RangeModelGUI;
import de.esolutions.fw.util.commons.Buffer;

public class RangeModel
extends ButtonModel
implements RangeModelGUI,
RangeModelApp {
    private int maximum = 9;
    private int minimum;
    private int step = 1;
    private int value;
    private int medialPosition = 5;
    private volatile boolean forceUpdate = true;

    public RangeModel(int n) {
        super(n);
    }

    public RangeModel(int n, int n2) {
        super(n, n2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public String dumpContent() {
        Buffer buffer = new Buffer(100);
        buffer.append(super.dumpContent());
        Object object = this.mutex;
        synchronized (object) {
            buffer.append("\nvalue: ");
            buffer.append(this.value);
            buffer.append("\nmaximum: ");
            buffer.append(this.maximum);
            buffer.append("\nminimum: ");
            buffer.append(this.minimum);
            buffer.append("\nstep: ");
            buffer.append(this.step);
            buffer.append("\nmedialPosition: ");
            buffer.append(this.medialPosition);
            buffer.append("\nforceUpdate: ");
            buffer.append(this.forceUpdate);
        }
        return buffer.toString();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void copy(AbstractModel abstractModel) {
        try {
            Object object = this.mutex;
            synchronized (object) {
                RangeModel rangeModel = (RangeModel)abstractModel;
                this.minimum = rangeModel.minimum;
                this.maximum = rangeModel.maximum;
                this.value = rangeModel.value;
                this.step = rangeModel.step;
                this.medialPosition = rangeModel.medialPosition;
                super.copy(abstractModel);
            }
        }
        catch (Exception exception) {
            this.lc.log(10000, "(%2) RangeModel.copy( %1 ) failed! ", (Object)abstractModel, (long)this.id);
            this.lc.log(10000, "ERROR: ", (Throwable)exception);
        }
    }

    public int getModelType() {
        return 5;
    }

    public boolean isEmpty() {
        return false;
    }

    public int getMaximum() {
        return this.maximum;
    }

    public int getMinimum() {
        return this.minimum;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int getStep() {
        Object object = this.mutex;
        synchronized (object) {
            return this.step;
        }
    }

    public int getValue() {
        return this.value;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setLimits(int n, int n2, int n3) {
        boolean bl;
        this.lc.log(10000000, "(%1) RangeModel.setLimits() min:%2 max:%3", (long)this.id, (long)n, (long)n2);
        Object object = this.mutex;
        synchronized (object) {
            this.step = n3;
            bl = this.updateData(this.value, n, n2);
        }
        if (bl) {
            this.fireModelUpdateEvent(1, this.value);
        }
        this.fireModelUpdateEvent(4, n, n2);
    }

    public void setLimits(int n, int n2, int n3, int n4) {
        this.medialPosition = n4;
        this.setLimits(n, n2, n3);
    }

    public void setMedialPosition(int n) {
        this.medialPosition = n;
    }

    public void setRangeListener(RangeListener rangeListener2) {
        this.setButtonListener(rangeListener2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setValue(int n) {
        this.lc.log(10000000, "(%1) RangeModel.setValue( %2 )", (long)this.id, (long)n);
        Object object = this.mutex;
        synchronized (object) {
            this.updateData(n);
        }
        this.fireModelUpdateEvent(1, n);
    }

    protected void updateData(int n) {
        this.updateData(n, this.minimum, this.maximum);
    }

    private boolean updateData(int n, int n2, int n3) {
        this.minimum = n2;
        this.maximum = n3;
        boolean bl = false;
        if (n < n2) {
            this.lc.log(1000000, "(%1) RangeModel.updateData() --> correct value:%2 to min:%3", (long)this.id, (long)n, (long)n2);
            n = n2;
            bl = true;
        } else if (n > n3) {
            this.lc.log(1000000, "(%1) RangeModel.updateData() --> correct value:%2 to max:%3", (long)this.id, (long)n, (long)n3);
            n = n3;
            bl = true;
        }
        if (n != this.value) {
            this.value = n;
            this.stateChanged();
        }
        return bl;
    }

    public void decrement(int n, int n2) {
        try {
            ((RangeListener)this.buttonListener).decrement(this.id, n, n2);
        }
        catch (Exception exception) {
            this.handleListenerException(exception);
        }
    }

    public void increment(int n, int n2) {
        try {
            ((RangeListener)this.buttonListener).increment(this.id, n, n2);
        }
        catch (Exception exception) {
            this.handleListenerException(exception);
        }
    }

    public int getMedialPosition() {
        return this.medialPosition;
    }

    public void forceUpdate(boolean bl) {
        this.forceUpdate = bl;
    }

    public boolean isForceUpdateEnabled() {
        return this.forceUpdate;
    }
}

