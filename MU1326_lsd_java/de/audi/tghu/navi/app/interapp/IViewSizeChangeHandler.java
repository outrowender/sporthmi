/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.interapp;

import de.audi.atip.mmicombi.IViewSizeListener;
import de.audi.atip.mmicombi.IViewSizeManager;

public interface IViewSizeChangeHandler {
    default public void setViewSizeManager(IViewSizeManager iViewSizeManager) {
    }

    default public void addViewSizeChangedListener(IViewSizeListener iViewSizeListener) {
    }

    default public boolean isSmallStageActive() {
    }

    default public void requestLargeViewSize(int n) {
    }

    default public void unrequestLargeViewSize(int n) {
    }
}

