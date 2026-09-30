/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.upnp;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.upnp.ListEntry;

public interface DSIUPNPBrowserListener
extends DSIListener {
    public void updateBrowseFolder(ListEntry[] var1, int var2);

    public void updateListSize(int var1, int var2, int var3);

    public void responseList(ListEntry[] var1, int var2);

    public void invalidBrowsePath();
}

