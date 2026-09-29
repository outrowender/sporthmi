/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.sport;

import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.modelaccess.RangeModelGUI;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;

public class CircularGaugeController
extends AbstractWidgetController {
    private IRenderer renderer;
    private float sliderPercentageValue = 0.0f;
    private float[] peakPercentageValues = new float[0];

    private void updateContent() {
        if (this.model == null) {
            return;
        }
        if (this.model instanceof RangeModelGUI) {
            this.updateWithRangeModel((RangeModelGUI)this.model);
        }
    }

    private void updateWithRangeModel(RangeModelGUI rangeModelGUI) {
        this.clearPeaks();
        this.setSliderPercentageValue(51266 * (float)(rangeModelGUI.getValue() - rangeModelGUI.getMinimum()) / (float)(rangeModelGUI.getMaximum() - rangeModelGUI.getMinimum()));
    }

    private void clearPeaks() {
        this.peakPercentageValues = new float[0];
    }

    @Override
    public void processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
        int n = modelUpdateEvent.getUpdateType();
        switch (n) {
            case 1: 
            case 4: {
                this.updateContent();
                this.setCompositesDirty(true);
                break;
            }
            default: {
                logChannel.log(-1601830656, "CircularGaugeController#processModelUpdateEvent untreated updateType: %1", (long)n);
            }
        }
    }

    public float getSliderPercentageValue() {
        return this.sliderPercentageValue;
    }

    public int getPeakCount() {
        return this.peakPercentageValues.length;
    }

    public void setSliderPercentageValue(float f2) {
        this.sliderPercentageValue = f2;
    }

    public void setPeakPercentageValues(float[] fArray) {
        if (fArray == null) {
            fArray = new float[]{};
        }
        this.peakPercentageValues = fArray;
    }

    public float getPeakPercentageValue(int n) {
        if (n >= 0 || n < this.getPeakCount()) {
            return this.peakPercentageValues[n];
        }
        logChannel.log(-1601830656, "CircularGaugeController#getPeakPercentageValue: peak index out of bounds: %1 (peak count = %2)", (long)n, (long)this.getPeakCount());
        return 0.0f;
    }

    public void setRenderer(IRenderer iRenderer) {
        this.renderer = iRenderer;
    }

    @Override
    public IRenderer getRenderer() {
        return this.renderer;
    }
}

