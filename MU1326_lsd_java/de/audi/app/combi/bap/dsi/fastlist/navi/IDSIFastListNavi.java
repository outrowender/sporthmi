/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.dsi.fastlist.navi;

import de.audi.app.combi.bap.dsi.fastlist.IDSIFastListScrollingController;
import org.dsi.ifc.kombifastlist.DataInitials;

public interface IDSIFastListNavi
extends IDSIFastListScrollingController {
    public void responseGetInitialsNavigation(int var1, int var2, int var3, DataInitials[] var4);

    public void pushFunctionAvailabilityNavigation(int var1);

    public void responseNotifyCurrentListSizesNavigation(boolean var1);
}

