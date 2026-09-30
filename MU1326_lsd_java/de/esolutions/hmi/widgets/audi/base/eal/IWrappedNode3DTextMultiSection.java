/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.eal;

import de.esolutions.graphics.eal.api.ITextLayout;
import de.esolutions.hmi.widgets.audi.base.eal.IBaseWrappedNode3DText;

public interface IWrappedNode3DTextMultiSection
extends IBaseWrappedNode3DText {
    public void setText(String var1);

    public ITextLayout getLayout();

    public void notifyLayoutChanged(boolean var1);

    public int[] getOnScreenCharPosition(int var1);
}

