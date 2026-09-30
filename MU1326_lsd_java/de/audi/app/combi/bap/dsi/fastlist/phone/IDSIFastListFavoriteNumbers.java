/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.dsi.fastlist.phone;

import de.audi.app.combi.bap.dsi.fastlist.phone.IDSIFastListPhone;
import org.dsi.ifc.kombifastlist.DataFavoriteList;

public interface IDSIFastListFavoriteNumbers
extends IDSIFastListPhone {
    public void pushupdateFavoriteNumbers(DataFavoriteList[] var1);

    public void pushCurrentListSizeFavoriteNumbers(int var1);

    public void responseNotifyFavoriteNumbersPush(boolean var1);
}

