/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.dsi.fastlist.phone;

import de.audi.app.combi.bap.dsi.fastlist.IDSIFastListScrollingController;
import org.dsi.ifc.kombifastlist.DataInitials;

public interface IDSIFastListPhone
extends IDSIFastListScrollingController {
    default public void responseGetInitialsTelephone(int n, int n2, int n3, DataInitials[] dataInitialsArray) {
    }

    default public void pushFunctionAvailabilityTelephone(int n) {
    }

    default public void responseNotifyCurrentListSizesTelephone(boolean bl) {
    }
}

