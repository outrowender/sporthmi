/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.dsi.fastlist.navi;

import de.audi.app.combi.bap.dsi.fastlist.navi.IDSIFastListNavi;
import org.dsi.ifc.kombifastlist.DataAddress;

public interface IDSIFastListFavoriteDestinations
extends IDSIFastListNavi {
    default public void pushUpdateFavoriteDestinations(DataAddress[] dataAddressArray) {
    }

    default public void pushCurrentListSizeFavoriteDestinations(int n) {
    }

    default public void responseNotifyFavoriteDestinations(boolean bl) {
    }
}

