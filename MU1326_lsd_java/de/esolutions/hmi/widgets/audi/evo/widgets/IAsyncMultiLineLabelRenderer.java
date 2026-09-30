/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

public interface IAsyncMultiLineLabelRenderer {
    public void onTextChanged();

    public boolean isLineBreakingFinished();

    public boolean updateLineBreaking(boolean var1);
}

