/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.dsi.fastlist.audio;

import de.audi.app.combi.bap.dsi.fastlist.audio.IDSIFastListAudio;
import org.dsi.ifc.kombifastlist.DataCommonList;

public interface IDSIFastListCommonList
extends IDSIFastListAudio {
    default public void pushCommonList(DataCommonList[] dataCommonListArray) {
    }

    default public void pushCurrentListSizeCommonList(int n) {
    }

    default public void responseNotifyCommonListPush(boolean bl) {
    }
}

