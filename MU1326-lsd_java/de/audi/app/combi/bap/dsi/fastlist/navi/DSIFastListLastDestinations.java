/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.dsi.fastlist.navi;

import de.audi.app.combi.bap.dsi.fastlist.navi.DSIFastListNavi;
import de.audi.app.combi.bap.dsi.fastlist.navi.FastListNaviSizes;
import de.audi.app.combi.bap.dsi.fastlist.navi.IDSIFastListLastDestinations;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.kombifastlist.DataAddress;

public final class DSIFastListLastDestinations
extends DSIFastListNavi
implements IDSIFastListLastDestinations {
    @Override
    public void pushLastDestinations(DataAddress[] dataAddressArray) {
        this.dsiLogChannel.log(1078071040, "[DSIFastListLastDestinations#pushLastDestList] data.length=%1", (long)dataAddressArray.length);
        if (this.dsiLogChannel.isDebug2()) {
            Buffer buffer = new Buffer();
            for (int i2 = 0; i2 < dataAddressArray.length; ++i2) {
                buffer.append(dataAddressArray[i2]);
                buffer.append('\n');
            }
            this.dsiLogChannel.log(14808325, "[DSIFastListLastDestinations#pushLastDestList] DataAddress[] {\n%1}", (Object)buffer);
        }
        this.dsi.pushLastDestList(0, 0, dataAddressArray);
    }

    @Override
    public void pushCurrentListSizeLastDestinations(int n) {
        this.dsiLogChannel.log(1078071040, "[DSIFastListLastDestinations#pushCurrentListSizeLastDestList] listSize=%1", (long)n);
        FastListNaviSizes.pushListSizeLastDestinationsList(this.dsi, n);
    }

    @Override
    public void responseNotifyLastDestinations(boolean bl) {
        this.dsiLogChannel.log(1078071040, "[DSIFastListLastDestinations#responseNotifyLastDestList] successful=%1", bl);
        this.dsi.responseNotifyLastDestList(bl);
    }
}

