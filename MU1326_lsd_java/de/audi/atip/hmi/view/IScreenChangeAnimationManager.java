/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.view;

import de.audi.atip.hmi.view.IScreenData;

public interface IScreenChangeAnimationManager {
    public static final int SCREENCHANGE_STATE_INIT;
    public static final int SCREENCHANGE_STATE_SCREEN_EXIT;
    public static final int SCREENCHANGE_STATE_SCREEN_ENTER;

    default public boolean startScreenChangeAnimation(IScreenData iScreenData, IScreenData iScreenData2) {
    }

    default public boolean wasPopupFadedOut() {
    }

    default public int getScreenChangeState() {
    }

    default public void rollBackEnterAnimation(boolean bl) {
    }

    default public void setFocus(int n) {
    }
}

