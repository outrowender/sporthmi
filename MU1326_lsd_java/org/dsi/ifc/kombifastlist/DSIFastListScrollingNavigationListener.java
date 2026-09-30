/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.kombifastlist;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.kombifastlist.ArrayHeader;

public interface DSIFastListScrollingNavigationListener
extends DSIListener {
    public void indicationNavBook(int var1, int var2, int var3, int var4, long var5, int var7, int var8, int var9, int var10, int var11, int var12);

    public void indicationGetInitialsNavigation(int var1, int var2, int var3, int var4);

    public void indicationNotifyLastDestListPUSH(boolean var1, boolean var2);

    public void indicationNotifyFavoriteDestListPUSH(boolean var1, boolean var2);

    public void indicationNotifyCurrentListSizeNavigation(boolean var1, boolean var2);

    public void indicationNavBookJobs(int var1, int var2, int var3, ArrayHeader[] var4);
}

