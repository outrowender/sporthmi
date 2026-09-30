/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.dsi.fastlist.audio;

import de.audi.app.combi.bap.dsi.fastlist.audio.DSIFastListAudio;
import de.audi.app.combi.bap.dsi.fastlist.audio.FastListAudioSizes;
import de.audi.app.combi.bap.dsi.fastlist.audio.IDSIFastListReceptionList;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.kombifastlist.DataReceptionList;

public final class DSIFastListReceptionList
extends DSIFastListAudio
implements IDSIFastListReceptionList {
    public void pushReceptionList(DataReceptionList[] dataReceptionListArray) {
        this.dsiLogChannel.log(1000000, "[DSIFastListReceptionList#pushReceptionList] data.length=%1", (long)dataReceptionListArray.length);
        if (this.dsiLogChannel.isDebug2()) {
            Buffer buffer = new Buffer();
            for (int i2 = 0; i2 < dataReceptionListArray.length; ++i2) {
                buffer.append(dataReceptionListArray[i2]);
                buffer.append('\n');
            }
            this.dsiLogChannel.log(100000000, "[DSIFastListReceptionList#pushReceptionList] DataReceptionList[] {\n%1}", (Object)buffer);
        }
        this.dsi.pushReceptionList(0L, 0, dataReceptionListArray);
    }

    public void pushCurrentListSizeReceptionList(int n) {
        this.dsiLogChannel.log(1000000, "[DSIFastListReceptionList#pushCurrentListSizeReceptionList] listSize=%1", (long)n);
        FastListAudioSizes.pushListSizeReceptionList(this.dsi, n);
    }

    public void responseNotifyReceptionList(boolean bl) {
        this.dsiLogChannel.log(1000000, "[DSIFastListReceptionList#responseNotifyReceptionList] successful=%1", bl);
        this.dsi.responseNotifyReceptionList(bl);
    }
}

