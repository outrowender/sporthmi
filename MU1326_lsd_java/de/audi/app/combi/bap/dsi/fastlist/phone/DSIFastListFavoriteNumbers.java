/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.dsi.fastlist.phone;

import de.audi.app.combi.bap.dsi.fastlist.phone.DSIFastListPhone;
import de.audi.app.combi.bap.dsi.fastlist.phone.FastListPhoneSizes;
import de.audi.app.combi.bap.dsi.fastlist.phone.IDSIFastListFavoriteNumbers;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.kombifastlist.DataFavoriteList;

public final class DSIFastListFavoriteNumbers
extends DSIFastListPhone
implements IDSIFastListFavoriteNumbers {
    public void pushupdateFavoriteNumbers(DataFavoriteList[] dataFavoriteListArray) {
        this.dsiLogChannel.log(1000000, "[DSIFastListFavoriteNumbers#pushupdateFavoriteList] data.length=%1", (long)dataFavoriteListArray.length);
        if (this.dsiLogChannel.isDebug2()) {
            Buffer buffer = new Buffer();
            for (int i2 = 0; i2 < dataFavoriteListArray.length; ++i2) {
                buffer.append(dataFavoriteListArray[i2]);
                buffer.append('\n');
            }
            this.dsiLogChannel.log(100000000, "[DSIFastListFavoriteNumbers#pushupdateFavoriteList] DataFavoriteList[] {\n%1}", (Object)buffer);
        }
        this.dsi.pushupdateFavoriteList(0, 0, dataFavoriteListArray);
    }

    public void pushCurrentListSizeFavoriteNumbers(int n) {
        this.dsiLogChannel.log(1000000, "[DSIFastListFavoriteNumbersDSIFastListFavoriteNumbers#pushCurrentListSizePhonebook] listSize=%1", (long)n);
        FastListPhoneSizes.pushListSizeFavoriteNumbers(this.dsi, n);
    }

    public void responseNotifyFavoriteNumbersPush(boolean bl) {
        this.dsiLogChannel.log(1000000, "[DSIFastListFavoriteNumbers#responseNotifyFavoriteListPush] successful=%1", bl);
        this.dsi.responseNotifyFavoriteListPush(bl);
    }
}

