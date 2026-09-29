/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.personal;

public interface IPersonalPoiModelAccess {
    default public void onUpdateDataBaseAvailable(boolean bl) {
    }

    default public void onUpdateSearchStatus(int n) {
    }

    default public void onDatabaseDeleted(String[] stringArray) {
    }

    default public boolean isPpoiavailable() {
    }
}

