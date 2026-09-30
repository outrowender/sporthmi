/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.dsi.fastlist.navi;

import de.audi.app.combi.bap.dsi.fastlist.navi.IDSIFastListNavi;
import org.dsi.ifc.kombifastlist.DataAddress;

public interface IDSIFastListFavoriteDestinations
extends IDSIFastListNavi {
    public void pushUpdateFavoriteDestinations(DataAddress[] var1);

    public void pushCurrentListSizeFavoriteDestinations(int var1);

    public void responseNotifyFavoriteDestinations(boolean var1);
}

