/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.search;

import org.dsi.ifc.base.DSIListener;

public interface DSISearchDataProviderListener
extends DSIListener {
    public void registerProviderSourceResult(int var1, int var2);

    public void activateProviderSource(int var1);

    public void invalidateAllDataResult(int var1, int var2);

    public void provideData(int var1, int var2, int var3);

    public void storeDataSetsResult(int var1, int var2);

    public void deleteDataSetResult(int var1, int var2, long var3);
}

