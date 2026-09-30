/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.dsi.fastlist.phone;

import de.audi.app.combi.bap.dsi.fastlist.IDSIFastListScrollingController;
import org.dsi.ifc.kombifastlist.DataInitials;

public interface IDSIFastListPhone
extends IDSIFastListScrollingController {
    public void responseGetInitialsTelephone(int var1, int var2, int var3, DataInitials[] var4);

    public void pushFunctionAvailabilityTelephone(int var1);

    public void responseNotifyCurrentListSizesTelephone(boolean var1);
}

