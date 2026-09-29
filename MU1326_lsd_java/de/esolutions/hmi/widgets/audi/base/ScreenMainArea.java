/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base;

import de.esolutions.hmi.widgets.audi.base.Rectangular;
import de.esolutions.hmi.widgets.audi.base.ScreenArea;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;

public interface ScreenMainArea
extends ScreenArea {
    default public void setMainAreaState(int n, int n2, boolean bl) {
    }

    default public boolean isFocusableInSmallStage() {
    }

    default public void setFocusableInSmallStage(boolean bl) {
    }

    default public void setNotFocusableIcon(AbstractWidgetController abstractWidgetController) {
    }

    default public AbstractWidgetController getNotFocusableIcon() {
    }

    default public void initializeScreenChangeAnimation(Rectangular rectangular) {
    }

    default public void setPPDesaturation(float f2) {
    }

    default public boolean hasVisibleFocusCursor() {
    }
}

