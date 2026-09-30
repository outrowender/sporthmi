/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base;

import de.esolutions.hmi.widgets.audi.base.Rectangular;
import de.esolutions.hmi.widgets.audi.base.ScreenArea;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;

public interface ScreenMainArea
extends ScreenArea {
    public void setMainAreaState(int var1, int var2, boolean var3);

    public boolean isFocusableInSmallStage();

    public void setFocusableInSmallStage(boolean var1);

    public void setNotFocusableIcon(AbstractWidgetController var1);

    public AbstractWidgetController getNotFocusableIcon();

    public void initializeScreenChangeAnimation(Rectangular var1);

    public void setPPDesaturation(float var1);

    public boolean hasVisibleFocusCursor();
}

