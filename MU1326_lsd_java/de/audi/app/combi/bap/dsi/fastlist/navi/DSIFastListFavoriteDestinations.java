/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.dsi.fastlist.navi;

import de.audi.app.combi.bap.dsi.fastlist.navi.DSIFastListNavi;
import de.audi.app.combi.bap.dsi.fastlist.navi.FastListNaviSizes;
import de.audi.app.combi.bap.dsi.fastlist.navi.IDSIFastListFavoriteDestinations;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.kombifastlist.DataAddress;

public final class DSIFastListFavoriteDestinations
extends DSIFastListNavi
implements IDSIFastListFavoriteDestinations {
    public void pushUpdateFavoriteDestinations(DataAddress[] dataAddressArray) {
        this.dsiLogChannel.log(1000000, "[DSIFastListFavoriteDestinations#pushUpdateFavoriteDestList] data.length=%1", (long)dataAddressArray.length);
        if (this.dsiLogChannel.isDebug2()) {
            Buffer buffer = new Buffer();
            for (int i2 = 0; i2 < dataAddressArray.length; ++i2) {
                buffer.append(dataAddressArray[i2]);
                buffer.append('\n');
            }
            this.dsiLogChannel.log(100000000, "[DSIFastListFavoriteDestinations#pushUpdateFavoriteDestList] DataAddress[] {\n%1}", (Object)buffer);
        }
        this.dsi.pushUpdateFavoriteDestList(0, 0, dataAddressArray);
    }

    public void pushCurrentListSizeFavoriteDestinations(int n) {
        this.dsiLogChannel.log(1000000, "[DSIFastListFavoriteDestinations#pushCurrentListSizeFavoriteDestList] listSize=%1", (long)n);
        FastListNaviSizes.pushListSizeFavoriteDestinations(this.dsi, n);
    }

    public void responseNotifyFavoriteDestinations(boolean bl) {
        this.dsiLogChannel.log(1000000, "[DSIFastListFavoriteDestinations#responseNotifyFavoriteDestList] successful=%1", bl);
        this.dsi.responseNotifyFavoriteDestList(bl);
    }
}

