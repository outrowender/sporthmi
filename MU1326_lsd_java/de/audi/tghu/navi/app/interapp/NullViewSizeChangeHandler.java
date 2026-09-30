/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.interapp;

import de.audi.atip.mmicombi.IViewSizeListener;
import de.audi.atip.mmicombi.IViewSizeManager;
import de.audi.tghu.navi.app.interapp.IViewSizeChangeHandler;

public class NullViewSizeChangeHandler
implements IViewSizeChangeHandler {
    public void setViewSizeManager(IViewSizeManager iViewSizeManager) {
    }

    public void addViewSizeChangedListener(IViewSizeListener iViewSizeListener) {
    }

    public boolean isSmallStageActive() {
        return false;
    }

    public void requestLargeViewSize(int n) {
    }

    public void unrequestLargeViewSize(int n) {
    }
}

