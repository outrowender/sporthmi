/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.interapp;

import de.audi.atip.mmicombi.IViewSizeListener;
import de.audi.atip.mmicombi.IViewSizeManager;
import de.audi.tghu.navi.app.interapp.IViewSizeChangeHandler;

public class NullViewSizeChangeHandler
implements IViewSizeChangeHandler {
    @Override
    public void setViewSizeManager(IViewSizeManager iViewSizeManager) {
    }

    @Override
    public void addViewSizeChangedListener(IViewSizeListener iViewSizeListener) {
    }

    @Override
    public boolean isSmallStageActive() {
        return false;
    }

    @Override
    public void requestLargeViewSize(int n) {
    }

    @Override
    public void unrequestLargeViewSize(int n) {
    }
}

