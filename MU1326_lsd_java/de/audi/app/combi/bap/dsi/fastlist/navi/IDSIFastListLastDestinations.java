/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.dsi.fastlist.navi;

import de.audi.app.combi.bap.dsi.fastlist.navi.IDSIFastListNavi;
import org.dsi.ifc.kombifastlist.DataAddress;

public interface IDSIFastListLastDestinations
extends IDSIFastListNavi {
    public void pushLastDestinations(DataAddress[] var1);

    public void pushCurrentListSizeLastDestinations(int var1);

    public void responseNotifyLastDestinations(boolean var1);
}

