/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.media;

import de.audi.app.sdsmanager.nbest.IPicklist;

public interface IMediaSDSPicklistHandler {
    default public IPicklist getEntryPicklist() {
    }

    default public void setEntryPicklist(IPicklist iPicklist) {
    }

    default public void setListmode(byte by) {
    }
}

