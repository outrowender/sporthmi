/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.kombifastlist;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.kombifastlist.ArrayHeader;

public interface DSIFastListScrollingTelephoneListener
extends DSIListener {
    public void indicationPhonebook(int var1, int var2, int var3, int var4, long var5, int var7, int var8, int var9, int var10, int var11, int var12);

    public void indicationGetInitialsTelephone(int var1, int var2, int var3, int var4);

    public void indicationNotifyFavoriteListPush(boolean var1, boolean var2);

    public void indicationNotifyCombinedNumbersPush(boolean var1, boolean var2);

    public void indicationNotifyCurrentListSizeTelephone(boolean var1, boolean var2);

    public void indicationPhonebookJobs(int var1, int var2, int var3, ArrayHeader[] var4);
}

