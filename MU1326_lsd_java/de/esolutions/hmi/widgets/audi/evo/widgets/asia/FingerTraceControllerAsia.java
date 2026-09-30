/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.asia;

import de.esolutions.hmi.widgets.audi.evo.widgets.FingerTraceController;
import de.esolutions.hmi.widgets.audi.evo.widgets.IFingerTraceRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.IViewSizeAnimatable;

public class FingerTraceControllerAsia
extends FingerTraceController
implements IViewSizeAnimatable {
    protected void restartFadeOutAnimation() {
    }

    public void setViewSizeAnimation(float f2, float[] fArray, float[] fArray2, boolean bl) {
        ((IFingerTraceRenderer)this.getRenderer()).onviewSizeChanging();
        this.setCompositesDirty(true);
    }

    public void setViewSizeAnimationFinished(float[] fArray, boolean bl) {
        ((IFingerTraceRenderer)this.getRenderer()).viewSizeChanged();
        this.setCompositesDirty(true);
    }

    public void viewSizeTargetChanged(float[] fArray, float[] fArray2, boolean bl) {
    }

    public void viewSizeAnimationStarted(float f2, float[] fArray, float[] fArray2) {
    }

    public void characterRecognized(char c2) {
        super.characterRecognized(c2);
        if (!super.isRenderer()) {
            return;
        }
        this.lastOpacity = 0.0f;
    }
}

