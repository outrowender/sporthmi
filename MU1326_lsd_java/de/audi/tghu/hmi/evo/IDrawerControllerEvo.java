/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.hmi.evo;

import de.audi.atip.hmi.view.IDrawerController;
import de.audi.tghu.hmi.evo.IDrawer;
import de.audi.tghu.hmi.evo.IScreenEvo;
import de.audi.tghu.hmi.evo.ScreenAreaFocus;
import de.audi.tghu.hmi.evo.ScreenChangeAnimationItem;

public interface IDrawerControllerEvo
extends IDrawerController,
IScreenEvo,
IDrawer,
ScreenAreaFocus,
ScreenChangeAnimationItem {
    public static final int TYPE_UNDEFINED = 0;
    public static final int TYPE_SELECTION_DRAWER = 1;
    public static final int TYPE_OPTION_DRAWER = 2;
    public static final int TYPE_ENTERTAINMENT_DRAWER = 3;
    public static final int MMI_COMBI_SYNC_MODE_STANDARD = 1;
    public static final int MMI_COMBI_SYNC_MODE_HIDDEN_BUT_ANIMATED = 2;

    public void setClosedIconVisible(boolean var1);

    public void setDrawerType(int var1);

    public void setMMICombiSyncMode(int var1);

    public boolean canOpen();

    public boolean canClose();

    public boolean isVerticalLineVisible();

    public void setVerticalLineVisible(boolean var1);

    public int getCurrentAudioSource();

    public void setTransitionForward(boolean var1);

    public boolean isSDSAudioSource(int var1);

    public boolean isPhoneAudioSource(int var1);

    public void setIsBlockedWhileLockingIsActive(boolean var1);

    public boolean isBlockedWhileLockingIsActive();
}

