/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.interapp;

import de.audi.atip.mmicombi.IViewSizeListener;
import de.audi.atip.mmicombi.IViewSizeManager;

public interface IViewSizeChangeHandler {
    public void setViewSizeManager(IViewSizeManager var1);

    public void addViewSizeChangedListener(IViewSizeListener var1);

    public boolean isSmallStageActive();

    public void requestLargeViewSize(int var1);

    public void unrequestLargeViewSize(int var1);
}

