/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

import de.audi.atip.hmi.model.HMIResourceLocator;
import de.audi.atip.log.LogChannel;
import de.audi.atip.sysapp.SpeedThresholdListener;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.ifc.ISimpleTuner;
import org.dsi.ifc.global.ResourceLocator;

public abstract class AbstractSlsSpeedManagerBase
implements SpeedThresholdListener {
    private boolean speedOverLimit;
    private final LogChannel lc;
    private final int lowerDuration;
    private final int upperDuration;
    private HMIResourceLocator slsImage = ISimpleTuner.EMPTY_RL;

    public AbstractSlsSpeedManagerBase(LogChannel logChannel) {
        this.lc = logChannel;
        this.lowerDuration = 1000 * Utilities.getSlideshowDisplayDuration1();
        this.upperDuration = 1000 * Utilities.getSlideshowDisplayDuration2();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void clear() {
        AbstractSlsSpeedManagerBase abstractSlsSpeedManagerBase = this;
        synchronized (abstractSlsSpeedManagerBase) {
            this.slsImage = ISimpleTuner.EMPTY_RL;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setImage(ResourceLocator resourceLocator) {
        AbstractSlsSpeedManagerBase abstractSlsSpeedManagerBase = this;
        synchronized (abstractSlsSpeedManagerBase) {
            this.slsImage = new HMIResourceLocator(resourceLocator.url);
            this.slsImage.setMinDisplayDuration(this.getDuration());
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public HMIResourceLocator getSlsImage() {
        AbstractSlsSpeedManagerBase abstractSlsSpeedManagerBase = this;
        synchronized (abstractSlsSpeedManagerBase) {
            return this.slsImage;
        }
    }

    private int getDuration() {
        if (this.speedOverLimit) {
            return this.upperDuration;
        }
        return this.lowerDuration;
    }

    public void exceedsUpperThreshold(int n) {
        this.lc.log(10000000, "DABSlideShowHandler#exceedsUpperThreshold");
        this.speedOverLimit = true;
        this.speedChanged();
    }

    public void belowLowerThreshold(int n) {
        this.lc.log(10000000, "DABSlideShowHandler#belowLowerThreshold");
        this.speedOverLimit = false;
        this.speedChanged();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void speedChanged() {
        boolean bl = false;
        AbstractSlsSpeedManagerBase abstractSlsSpeedManagerBase = this;
        synchronized (abstractSlsSpeedManagerBase) {
            this.slsImage.setMinDisplayDuration(this.getDuration());
            bl = this.slsImage.containsResourceURI();
        }
        if (bl) {
            this.update();
        }
    }

    protected abstract void update();
}

