/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.online;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.online.PortalADBEntry;

public interface DSIDestinationImportListener
extends DSIListener {
    public void downloadAddressListResult(PortalADBEntry[] var1, int var2, int var3);

    public void stopActionResult(int var1);

    public void updateEntries(int var1, int var2);
}

