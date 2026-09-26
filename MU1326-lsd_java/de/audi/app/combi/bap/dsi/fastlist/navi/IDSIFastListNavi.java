/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.dsi.fastlist.navi;

import de.audi.app.combi.bap.dsi.fastlist.IDSIFastListScrollingController;
import org.dsi.ifc.kombifastlist.DataInitials;

public interface IDSIFastListNavi
extends IDSIFastListScrollingController {
    default public void responseGetInitialsNavigation(int n, int n2, int n3, DataInitials[] dataInitialsArray) {
    }

    default public void pushFunctionAvailabilityNavigation(int n) {
    }

    default public void responseNotifyCurrentListSizesNavigation(boolean bl) {
    }
}

