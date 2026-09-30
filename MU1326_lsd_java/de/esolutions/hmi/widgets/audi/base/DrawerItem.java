/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base;

import de.audi.tghu.hmi.evo.DrawerAnimationListener;
import de.audi.tghu.hmi.evo.ScreenChangeAnimationItem;

public interface DrawerItem
extends ScreenChangeAnimationItem,
DrawerAnimationListener {
    public void setMMICombiSyncMode(int var1);

    public int getMMICombiSyncMode();

    public void setAnimationType(int var1);

    public void showDrawerItem(boolean var1, boolean var2);

    public void hideDrawerItem(boolean var1, boolean var2);

    public void setDrawerAnimationMask(int var1);

    public void setTransitionForward(boolean var1);

    public boolean isTransitionForward();

    public void setDrawerAnimationType(int var1);

    public void hideDrawerItem();
}

