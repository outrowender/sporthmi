/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.media;

import de.audi.app.sdsmanager.nbest.IPicklist;

public interface IMediaSDSPicklistHandler {
    public IPicklist getEntryPicklist();

    public void setEntryPicklist(IPicklist var1);

    public void setListmode(byte var1);
}

