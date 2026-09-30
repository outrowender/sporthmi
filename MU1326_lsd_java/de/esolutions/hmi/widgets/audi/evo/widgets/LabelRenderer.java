/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.esolutions.hmi.widgets.audi.base.PreferredSize;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;

public interface LabelRenderer
extends IRenderer,
PreferredSize {
    public String calculateDisplayData(String var1, boolean var2);

    public int getNumberOfRows(int var1);

    public String getText();

    public void setAlignment(int var1, int var2);

    public void setFirstVisibleLine(int var1);

    public int getPreferredLineHeight();

    public int getFontHeight();

    public int getBaseline();

    public boolean hasContent();

    public boolean isTextDescriptorSupported();

    public void setAutoWrap(int var1);

    public void setLineHeight(int var1);

    public int getLineHeight();
}

