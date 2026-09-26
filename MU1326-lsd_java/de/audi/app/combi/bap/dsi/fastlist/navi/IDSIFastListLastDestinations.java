/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.dsi.fastlist.navi;

import de.audi.app.combi.bap.dsi.fastlist.navi.IDSIFastListNavi;
import org.dsi.ifc.kombifastlist.DataAddress;

public interface IDSIFastListLastDestinations
extends IDSIFastListNavi {
    default public void pushLastDestinations(DataAddress[] dataAddressArray) {
    }

    default public void pushCurrentListSizeLastDestinations(int n) {
    }

    default public void responseNotifyLastDestinations(boolean bl) {
    }
}

