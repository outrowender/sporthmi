/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.dsi.fastlist.phone;

import de.audi.app.combi.bap.dsi.fastlist.phone.IDSIFastListPhone;
import org.dsi.ifc.kombifastlist.DataFavoriteList;

public interface IDSIFastListFavoriteNumbers
extends IDSIFastListPhone {
    default public void pushupdateFavoriteNumbers(DataFavoriteList[] dataFavoriteListArray) {
    }

    default public void pushCurrentListSizeFavoriteNumbers(int n) {
    }

    default public void responseNotifyFavoriteNumbersPush(boolean bl) {
    }
}

