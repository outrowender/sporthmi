/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sds;

import de.audi.atip.interapp.SDSListEntry;

public interface IPickListModelAccess {
    public void onStart();

    public void onUpdateResultList(SDSListEntry[] var1);
}

