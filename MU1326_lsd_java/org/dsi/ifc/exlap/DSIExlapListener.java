/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.exlap;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.exlap.Service;

public interface DSIExlapListener
extends DSIListener {
    public void startResult(int var1);

    public void stopResult(int var1);

    public void updateAvailableServices(Service[] var1, int var2);
}

