/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.dsi.fastlist.audio;

import de.audi.app.combi.bap.dsi.fastlist.audio.DSIFastListAudio;
import de.audi.app.combi.bap.dsi.fastlist.audio.FastListAudioSizes;
import de.audi.app.combi.bap.dsi.fastlist.audio.IDSIFastListCommonList;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.kombifastlist.DataCommonList;

public final class DSIFastListCommonList
extends DSIFastListAudio
implements IDSIFastListCommonList {
    @Override
    public void pushCommonList(DataCommonList[] dataCommonListArray) {
        this.dsiLogChannel.log(1078071040, "[DSIFastListCommonList#pushCommonList] data.length=%1", (long)dataCommonListArray.length);
        if (this.dsiLogChannel.isDebug2()) {
            Buffer buffer = new Buffer();
            for (int i2 = 0; i2 < dataCommonListArray.length; ++i2) {
                buffer.append(dataCommonListArray[i2]);
                buffer.append('\n');
            }
            this.dsiLogChannel.log(14808325, "[DSIFastListCommonList#pushCommonList] DataCommonList[] {\n%1}", (Object)buffer);
        }
        this.dsi.pushCommonList(0L, 0, dataCommonListArray);
    }

    @Override
    public void pushCurrentListSizeCommonList(int n) {
        this.dsiLogChannel.log(1078071040, "[DSIFastListCommonList#pushCurrentListSizeCommonList] listSize=%1", (long)n);
        FastListAudioSizes.pushListSizeCommonList(this.dsi, n);
    }

    @Override
    public void responseNotifyCommonListPush(boolean bl) {
        this.dsiLogChannel.log(1078071040, "[DSIFastListCommonList#responseNotifyCommonListPush] successful=%1", bl);
        this.dsi.responseNotifyCommonListPush(bl);
    }
}

