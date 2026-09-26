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
    public static final int TYPE_UNDEFINED;
    public static final int TYPE_SELECTION_DRAWER;
    public static final int TYPE_OPTION_DRAWER;
    public static final int TYPE_ENTERTAINMENT_DRAWER;
    public static final int MMI_COMBI_SYNC_MODE_STANDARD;
    public static final int MMI_COMBI_SYNC_MODE_HIDDEN_BUT_ANIMATED;

    default public void setClosedIconVisible(boolean bl) {
    }

    default public void setDrawerType(int n) {
    }

    default public void setMMICombiSyncMode(int n) {
    }

    default public boolean canOpen() {
    }

    default public boolean canClose() {
    }

    default public boolean isVerticalLineVisible() {
    }

    default public void setVerticalLineVisible(boolean bl) {
    }

    default public int getCurrentAudioSource() {
    }

    default public void setTransitionForward(boolean bl) {
    }

    default public boolean isSDSAudioSource(int n) {
    }

    default public boolean isPhoneAudioSource(int n) {
    }

    default public void setIsBlockedWhileLockingIsActive(boolean bl) {
    }

    default public boolean isBlockedWhileLockingIsActive() {
    }
}

