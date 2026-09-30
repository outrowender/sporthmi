/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.oneshot;

import de.audi.app.sdsmanager.nbest.IPicklist;

public interface IOneshotFilterStrategy {
    public IPicklist filterEntryPicklist(IPicklist var1, String[] var2, int var3);
}

