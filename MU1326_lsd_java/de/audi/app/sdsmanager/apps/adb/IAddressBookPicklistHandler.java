/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.adb;

import de.audi.atip.hmi.model.list.EvoListRow;

public interface IAddressBookPicklistHandler {
    public void itemSelected(EvoListRow var1, int var2, int var3, int var4, int var5);

    public void showADBPopup();

    public void showADBNaviPopup();

    public void removeADBPopup();

    public void removeADBNaviPopup();

    public void showTelContactPopup();

    public void removeTelContactPopup();

    public void showMailPopup();

    public void removeMailPoup();

    public void showADBContactPopup();

    public void removeADBContactPopup();
}

