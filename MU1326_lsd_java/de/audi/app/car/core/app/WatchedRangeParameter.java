/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.app;

import de.audi.app.car.common.comp.AbstractCarComponent;
import de.audi.app.car.core.app.IRangeModelSyncListener;
import de.audi.app.car.core.app.IRangeModelSyncParameterAccess;
import de.audi.atip.hmi.modelaccess.RangeModelApp;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;

public class WatchedRangeParameter
implements IRangeModelSyncParameterAccess {
    private final LogChannel logChannel;
    private final int attributeID;
    private int currentValue;
    private int lastValidValue = 128;
    private int lastSentValue = 128;
    private boolean dsiSetterBlocked = false;
    private boolean valueChange = false;
    private final boolean boundToRangeModel;
    private final int maxValue;
    private final int minValue;
    private RangeModelApp rangeModel;
    private final int rangeModelID;

    protected WatchedRangeParameter(LogChannel logChannel, int n, boolean bl, int n2, int n3, int n4) {
        this.logChannel = logChannel;
        this.attributeID = n;
        this.currentValue = n2;
        this.maxValue = n3;
        this.minValue = n4;
        this.boundToRangeModel = bl;
        this.rangeModelID = -1;
    }

    public WatchedRangeParameter(LogChannel logChannel, int n, boolean bl, RangeModelApp rangeModelApp) {
        this.logChannel = logChannel;
        this.attributeID = n;
        this.currentValue = rangeModelApp.getValue();
        this.maxValue = rangeModelApp.getMaximum();
        this.minValue = rangeModelApp.getMinimum();
        this.boundToRangeModel = bl;
        this.rangeModelID = rangeModelApp.getID();
        this.rangeModel = rangeModelApp;
    }

    public String toString() {
        Buffer buffer = new Buffer(120);
        buffer.append("WatchedRangeParameter(");
        buffer.append("attributeID=").append(this.attributeID);
        buffer.append(",currentValue=").append(this.currentValue);
        buffer.append(",maxValue=").append(this.maxValue);
        buffer.append(",minValue=").append(this.minValue);
        buffer.append(",bound=").append(this.boundToRangeModel);
        buffer.append(",modelID=").append(this.rangeModelID);
        buffer.append(")");
        return buffer.toString();
    }

    @Override
    public int getAttributeID() {
        return this.attributeID;
    }

    protected void setDsiSetterBlocked(boolean bl) {
        this.dsiSetterBlocked = bl;
    }

    public Integer getAttributeIDInteger() {
        return new Integer(this.attributeID);
    }

    @Override
    public int getCurrentValue() {
        return this.currentValue;
    }

    private int getCurrentValue(boolean bl) {
        if (bl && this.rangeModel != null) {
            return this.rangeModel.getValue();
        }
        return this.currentValue;
    }

    @Override
    public int getLastSentValue() {
        return this.lastSentValue;
    }

    private void setLastSentValue(int n) {
        if (this.logChannel.isDebug()) {
            this.logChannel.log(-2137614336, "[WatchedRangeParameter#setLastSentValue] lastSentValue='%1' ", (long)n);
        }
        this.lastSentValue = n;
    }

    public boolean isDsiSetterBlocked() {
        return this.dsiSetterBlocked;
    }

    public int getMaxValue() {
        if (this.boundToRangeModel && this.rangeModel != null) {
            return this.rangeModel.getMaximum();
        }
        return this.maxValue;
    }

    public int getMinValue() {
        if (this.boundToRangeModel && this.rangeModel != null) {
            return this.rangeModel.getMinimum();
        }
        return this.minValue;
    }

    @Override
    public int getRangeModelID() {
        return this.rangeModelID;
    }

    public boolean isValueChange() {
        return this.valueChange;
    }

    public void updateCurrentValueBySteps(int n, IRangeModelSyncListener iRangeModelSyncListener) {
        this.currentValue = AbstractCarComponent.clip(this.getCurrentValue(this.boundToRangeModel) + n, this.getMinValue(), this.getMaxValue());
        this.valueChange = true;
        if (this.boundToRangeModel) {
            if (this.logChannel.isDebug()) {
                this.logChannel.log(-2137614336, "[WatchedRangeParameter#updateCurrentValueBySteps] gives clearance to write current value into the RangeModel: attributeID='%1' , currentValue='%2' , isDSISetterBlocked='%3'", (long)this.getAttributeID(), (long)this.getCurrentValue(), this.isDsiSetterBlocked());
            }
            iRangeModelSyncListener.updateRangeModelByTurningRotary(this);
        }
    }

    public void notifyDSIUpdateReceived(int n, IRangeModelSyncListener iRangeModelSyncListener) {
        if (this.isDsiSetterBlocked()) {
            this.setDsiSetterBlocked(false);
            if (this.getLastSentValue() != n) {
                this.logChannel.log(-1601830656, "[WatchedRangeParameter#notifyDSIUpdateReceived] Updated value is not the same as sent value. This could result in flickering of the rotary.: sentValue=%1 , updatedValue=%2 , rangeModelID=%3", (long)this.getLastSentValue(), (long)n, (long)this.rangeModelID);
            }
        }
        if (!this.valueChange) {
            this.currentValue = AbstractCarComponent.clip(n, this.getMinValue(), this.getMaxValue());
        }
        this.lastValidValue = n;
    }

    private void updateCurrentRangeModelValue(IRangeModelSyncListener iRangeModelSyncListener) {
        if (this.boundToRangeModel) {
            if (this.logChannel.isDebug()) {
                this.logChannel.log(-2137614336, "[WatchedRangeParameter#updateCurrentValueBySteps] gives clearance to write current value into the RangeModel: attributeID='%1' , currentValue='%2' ", (long)this.getAttributeID(), (long)this.getCurrentValue());
            }
            iRangeModelSyncListener.updateRangeModelByDSINotitification(this);
        }
    }

    public void activateDSISetter(IRangeModelSyncListener iRangeModelSyncListener) {
        if (this.valueChange) {
            if (this.logChannel.isDebug()) {
                this.logChannel.log(-2137614336, "[WatchedRangeParameter#activateDSISetter] gives clearance to send DSI call (future set calls are blocked until this value change is acknowledged by the FSG): attributeID='%1' , currentValue='%2' ", (long)this.getAttributeID(), (long)this.getCurrentValue());
            }
            this.setDsiSetterBlocked(this.getLastSentValue() != this.getCurrentValue());
            this.valueChange = false;
            iRangeModelSyncListener.setDSIParameter(this);
            this.setLastSentValue(this.getCurrentValue());
        } else {
            this.updateCurrentRangeModelValue(iRangeModelSyncListener);
        }
    }

    @Override
    public void resetRangeModelParameter(IRangeModelSyncListener iRangeModelSyncListener) {
        this.valueChange = false;
        this.currentValue = this.lastValidValue;
        this.lastSentValue = this.lastValidValue;
        this.setDsiSetterBlocked(false);
        this.activateDSISetter(iRangeModelSyncListener);
    }
}

