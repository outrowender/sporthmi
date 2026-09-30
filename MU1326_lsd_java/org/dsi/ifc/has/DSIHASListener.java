/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.has;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.has.HASDataContainer;

public interface DSIHASListener
extends DSIListener {
    public void actionRequest(int var1, int var2, HASDataContainer[] var3);

    public void subscribeRequest(int var1, int var2);

    public void unsubscribeRequest(int var1);

    public void unsubscribeAllRequest();

    public void getPropertyRequest(int var1);
}

