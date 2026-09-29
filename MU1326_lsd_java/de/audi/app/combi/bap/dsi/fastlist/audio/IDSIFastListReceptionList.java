/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.dsi.fastlist.audio;

import de.audi.app.combi.bap.dsi.fastlist.audio.IDSIFastListAudio;
import org.dsi.ifc.kombifastlist.DataReceptionList;

public interface IDSIFastListReceptionList
extends IDSIFastListAudio {
    default public void pushReceptionList(DataReceptionList[] dataReceptionListArray) {
    }

    default public void pushCurrentListSizeReceptionList(int n) {
    }

    default public void responseNotifyReceptionList(boolean bl) {
    }
}

