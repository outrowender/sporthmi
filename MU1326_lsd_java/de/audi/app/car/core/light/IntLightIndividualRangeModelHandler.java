/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.light;

import de.audi.app.car.common.handler.ButtonModelHandler;
import de.audi.app.car.common.handler.RangeModelHandler;
import de.audi.app.car.common.handler.RangeModelHandlerAdapter;
import de.audi.app.car.core.app.RangeModelWatcherTimer;
import de.audi.atip.hmi.modelaccess.RangeModelApp;
import de.audi.atip.log.LogChannel;

public class IntLightIndividualRangeModelHandler
extends RangeModelHandlerAdapter {
    private RangeModelWatcherTimer watchedModelTimer;
    private static final int STEP_SIZE_OF_BRIGHTNESS_ROTARIES_IN_RIGHT_DRAWER = 20;

    protected IntLightIndividualRangeModelHandler(RangeModelApp rangeModelApp, LogChannel logChannel) {
        super(rangeModelApp, logChannel);
        this.watchedModelTimer = new RangeModelWatcherTimer("", rangeModelApp, 1000L, logChannel);
    }

    public void updateOnAdjustment(int n) {
        if (this.getBusiness() != null) {
            this.getRangeEventBusiness().processAdjustment(n, (RangeModelHandler)this);
        }
    }

    public void updateOnKeyPressed(int n) {
        if (this.getBusiness() != null) {
            this.getRangeEventBusiness().processKeyPressed(n, (ButtonModelHandler)this);
        }
    }

    public void updateOnKeyReleased(int n) {
        if (this.getBusiness() != null) {
            this.getRangeEventBusiness().processKeyReleased(n, (ButtonModelHandler)this);
        }
    }

    public void updateOnKeyTyped(int n) {
        if (this.getBusiness() != null) {
            this.getRangeEventBusiness().processKeyTyped(n, (ButtonModelHandler)this);
        }
    }

    public void updateRangeModelValue(int n) {
        this.watchedModelTimer.setValidValue(this.ceilToValidBrightness(n));
    }

    public RangeModelWatcherTimer getModelWatcherTimer() {
        return this.watchedModelTimer;
    }

    private int ceilToValidBrightness(int n) {
        int n2;
        int n3 = this.getRangeModel().getStep();
        int n4 = n;
        if (n3 > 0 && this.isCeilingRequired() && (n2 = n % n3) > 0) {
            n4 = n + n3 - n2;
            this.getLogChannel().log(1000000, "[IntLightIndividualRangeModelHandler#ceilToValidBrightness] Brightness value of %1 is not a multiple of the step width. Round up to next valid value: %2", (long)n, (long)n4);
        }
        return n4;
    }

    private boolean isCeilingRequired() {
        return this.getRangeModel().getStep() == 20;
    }
}

