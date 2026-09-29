/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.eal;

import de.esolutions.graphics.eal.api.ITextLayout;
import de.esolutions.hmi.widgets.audi.base.eal.IBaseWrappedNode3DText;

public interface IWrappedNode3DTextMultiSection
extends IBaseWrappedNode3DText {
    default public void setText(String string) {
    }

    default public ITextLayout getLayout() {
    }

    default public void notifyLayoutChanged(boolean bl) {
    }

    default public int[] getOnScreenCharPosition(int n) {
    }
}

