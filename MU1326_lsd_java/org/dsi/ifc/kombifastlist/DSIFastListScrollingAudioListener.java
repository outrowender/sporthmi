/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.kombifastlist;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.kombifastlist.ArrayHeader;

public interface DSIFastListScrollingAudioListener
extends DSIListener {
    public void indicationMediaBrowser(int var1, int var2, int var3, int var4, long var5, int var7, int var8, int var9, int var10, int var11, int var12);

    public void indicationNotifyCommonListPUSH(boolean var1, boolean var2);

    public void indicationNotifyReceptionListPUSH(boolean var1, boolean var2);

    public void indicationNotifyCurrentListSizeAudio(boolean var1, boolean var2);

    public void indicationMediaBrowserJobs(int var1, int var2, int var3, ArrayHeader[] var4);
}

