/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.view;

import de.audi.atip.hmi.view.IScreenData;

public interface IScreenChangeAnimationManager {
    public static final int SCREENCHANGE_STATE_INIT = 0;
    public static final int SCREENCHANGE_STATE_SCREEN_EXIT = 1;
    public static final int SCREENCHANGE_STATE_SCREEN_ENTER = 2;

    public boolean startScreenChangeAnimation(IScreenData var1, IScreenData var2);

    public boolean wasPopupFadedOut();

    public int getScreenChangeState();

    public void rollBackEnterAnimation(boolean var1);

    public void setFocus(int var1);
}

