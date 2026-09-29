/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model;

import de.audi.atip.hmi.model.AbstractModel;
import de.audi.atip.hmi.model.ButtonModel;
import de.audi.atip.hmi.model.RangeListener2D;
import de.audi.atip.hmi.modelaccess.RangeModel2DApp;
import de.audi.atip.hmi.modelaccess.RangeModel2DGUI;
import de.esolutions.fw.util.commons.Buffer;

public class RangeModel2D
extends ButtonModel
implements RangeModel2DGUI,
RangeModel2DApp {
    protected final String logPrefix;
    private int maximumX = 9;
    private int maximumY = 9;
    private int minimumX = 0;
    private int minimumY = 0;
    private int stepX = 1;
    private int stepY = 1;
    private int valueX = 0;
    private int valueY = 0;
    private int medialPositionX = 5;
    private int medialPositionY = 5;
    private volatile boolean forceUpdate = true;

    public RangeModel2D(int n) {
        super(n);
        this.logPrefix = new Buffer().append('(').append(n).append(") [RangeModel2D").toString();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public String dumpContent() {
        Buffer buffer = new Buffer(100);
        buffer.append(super.dumpContent());
        Object object = this.mutex;
        synchronized (object) {
            buffer.append("\nvalueX: ");
            buffer.append(this.valueX);
            buffer.append("\nvalueY: ");
            buffer.append(this.valueY);
            buffer.append("\nmaximumX: ");
            buffer.append(this.maximumX);
            buffer.append("\nmaximumY: ");
            buffer.append(this.maximumY);
            buffer.append("\nminimumX: ");
            buffer.append(this.minimumX);
            buffer.append("\nminimumY: ");
            buffer.append(this.minimumY);
            buffer.append("\nstepX: ");
            buffer.append(this.stepX);
            buffer.append("\nstepY: ");
            buffer.append(this.stepY);
            buffer.append("\nmedialPositionX: ");
            buffer.append(this.medialPositionX);
            buffer.append("\nmedialPositionY: ");
            buffer.append(this.medialPositionY);
            buffer.append("\nforceUpdate: ");
            buffer.append(this.forceUpdate);
        }
        return buffer.toString();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    protected void copy(AbstractModel abstractModel) {
        try {
            Object object = this.mutex;
            synchronized (object) {
                RangeModel2D rangeModel2D = (RangeModel2D)abstractModel;
                this.minimumX = rangeModel2D.minimumX;
                this.minimumY = rangeModel2D.minimumY;
                this.maximumX = rangeModel2D.maximumX;
                this.maximumY = rangeModel2D.maximumY;
                this.valueX = rangeModel2D.valueX;
                this.valueY = rangeModel2D.valueY;
                this.stepX = rangeModel2D.stepX;
                this.stepY = rangeModel2D.stepY;
                this.medialPositionX = rangeModel2D.medialPositionX;
                this.medialPositionY = rangeModel2D.medialPositionY;
                super.copy(abstractModel);
            }
        }
        catch (Exception exception) {
            this.lc.log(10000, "(%2) RangeModel.copy( %1 ) failed!", (Object)abstractModel, (long)this.id);
            this.lc.log(10000, "ERROR: ", (Throwable)exception);
        }
    }

    @Override
    public int getModelType() {
        return 16;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int getMaximumX() {
        return this.maximumX;
    }

    @Override
    public int getMaximumY() {
        return this.maximumY;
    }

    @Override
    public int getMinimumX() {
        return this.minimumX;
    }

    @Override
    public int getMinimumY() {
        return this.minimumY;
    }

    @Override
    public int getStepX() {
        return this.stepX;
    }

    @Override
    public int getStepY() {
        return this.stepY;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int getValueX() {
        Object object = this.mutex;
        synchronized (object) {
            return this.valueX;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int getValueY() {
        Object object = this.mutex;
        synchronized (object) {
            return this.valueY;
        }
    }

    @Override
    public void setLimitsX(int n, int n2, int n3) {
        this.minimumX = n;
        this.maximumX = n2;
        this.stepX = n3;
        this.fireModelUpdateEvent(4, n, n2);
    }

    @Override
    public void setLimitsY(int n, int n2, int n3) {
        this.minimumY = n;
        this.maximumY = n2;
        this.stepY = n3;
        this.fireModelUpdateEvent(4, n, n2);
    }

    @Override
    public void setLimitsX(int n, int n2, int n3, int n4) {
        this.medialPositionX = n4;
        this.setLimitsX(n, n2, n3);
    }

    @Override
    public void setLimitsY(int n, int n2, int n3, int n4) {
        this.medialPositionY = n4;
        this.setLimitsY(n, n2, n3);
    }

    @Override
    public void setLimitsXY(int n, int n2, int n3, int n4, int n5, int n6) {
        this.setLimitsX(n, n2, n5);
        this.setLimitsY(n3, n4, n6);
    }

    @Override
    public void setLimitsXY(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
        this.setLimitsX(n, n2, n5, n7);
        this.setLimitsY(n3, n4, n6, n8);
    }

    @Override
    public void setMedialPositionX(int n) {
        this.medialPositionX = n;
    }

    @Override
    public void setMedialPositionY(int n) {
        this.medialPositionY = n;
    }

    @Override
    public void setRangeListener(RangeListener2D rangeListener2D) {
        this.setButtonListener(rangeListener2D);
    }

    @Override
    public void setValue(int n, int n2) {
        this.setValueNoUpdateEvent(n, n2);
        this.fireModelUpdateEvent(1, n, n2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void setValueNoUpdateEvent(int n, int n2) {
        int n3;
        int n4;
        if (n < this.minimumX) {
            this.lc.log(-2137614336, "RangeModel.setValueNoUpdateEvent( %1 ): Limited to minimum %2! ", (long)n, (long)this.minimumX);
            n4 = this.minimumX;
        } else if (n > this.maximumX) {
            this.lc.log(-2137614336, "RangeModel.setValueNoUpdateEvent( %1 ): Limited to maximum %2! ", (long)n, (long)this.maximumX);
            n4 = this.maximumX;
        } else {
            n4 = n;
        }
        if (n2 < this.minimumY) {
            this.lc.log(-2137614336, "RangeModel.setValueNoUpdateEvent( %1 ): Limited to minimum %2! ", (long)n2, (long)this.minimumY);
            n3 = this.minimumY;
        } else if (n2 > this.maximumY) {
            this.lc.log(-2137614336, "RangeModel.setValueNoUpdateEvent( %1 ): Limited to maximum %2! ", (long)n2, (long)this.maximumY);
            n3 = this.maximumY;
        } else {
            n3 = n2;
        }
        Object object = this.mutex;
        synchronized (object) {
            if (n4 != this.valueX) {
                this.valueX = n4;
                this.stateChanged();
            }
            if (n3 != this.valueY) {
                this.valueY = n3;
                this.stateChanged();
            }
        }
    }

    @Override
    public int getMedialPositionX() {
        return this.medialPositionX;
    }

    @Override
    public int getMedialPositionY() {
        return this.medialPositionY;
    }

    @Override
    public void setValueHit(int n, int n2, int n3) {
        this.lc.log(-2137614336, "%1.setValueHit] x:%2 y:%3", (Object)this.logPrefix, (long)n, (long)n2);
        try {
            ((RangeListener2D)this.buttonListener).setValueHit(this.id, n, n2, n3);
        }
        catch (Exception exception) {
            this.handleListenerException(exception);
        }
    }

    @Override
    public void forceUpdate(boolean bl) {
        this.forceUpdate = bl;
    }

    @Override
    public boolean isForceUpdateEnabled() {
        return this.forceUpdate;
    }
}

