/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.oneshot;

import de.audi.app.sdsmanager.nbest.IPicklist;

public interface IOneshotFilterStrategy {
    default public IPicklist filterEntryPicklist(IPicklist iPicklist, String[] stringArray, int n) {
    }
}

