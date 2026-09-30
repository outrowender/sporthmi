/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.personal;

public interface IPersonalPoiModelAccess {
    public void onUpdateDataBaseAvailable(boolean var1);

    public void onUpdateSearchStatus(int var1);

    public void onDatabaseDeleted(String[] var1);

    public boolean isPpoiavailable();
}

