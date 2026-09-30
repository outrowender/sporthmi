/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.widgets.CompositeRenderer;

public interface ITimeDateSetttingsRenderer
extends CompositeRenderer {
    public int getPreferredWidth();

    public int getPreferredHeight();

    public int getBaseline();

    public AbstractWidgetController getFormfieldStub();

    public int getTextWidth(String var1);

    public void setAutoConfig(boolean var1);

    public void setBackgroundHeight(int var1);

    public void setBackgroundVerticalOffset(int var1);

    public void setTextVerticalOffset(int var1);
}

