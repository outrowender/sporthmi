/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.adb;

import de.audi.atip.hmi.model.list.EvoListRow;

public interface IAddressBookPicklistHandler {
    default public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    default public void showADBPopup() {
    }

    default public void showADBNaviPopup() {
    }

    default public void removeADBPopup() {
    }

    default public void removeADBNaviPopup() {
    }

    default public void showTelContactPopup() {
    }

    default public void removeTelContactPopup() {
    }

    default public void showMailPopup() {
    }

    default public void removeMailPoup() {
    }

    default public void showADBContactPopup() {
    }

    default public void removeADBContactPopup() {
    }
}

