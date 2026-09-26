/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base;

import de.audi.tghu.hmi.evo.DrawerAnimationListener;
import de.audi.tghu.hmi.evo.ScreenChangeAnimationItem;

public interface DrawerItem
extends ScreenChangeAnimationItem,
DrawerAnimationListener {
    default public void setMMICombiSyncMode(int n) {
    }

    default public int getMMICombiSyncMode() {
    }

    default public void setAnimationType(int n) {
    }

    default public void showDrawerItem(boolean bl, boolean bl2) {
    }

    default public void hideDrawerItem(boolean bl, boolean bl2) {
    }

    default public void setDrawerAnimationMask(int n) {
    }

    default public void setTransitionForward(boolean bl) {
    }

    default public boolean isTransitionForward() {
    }

    default public void setDrawerAnimationType(int n) {
    }

    default public void hideDrawerItem() {
    }
}

