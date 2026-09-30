/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.dsi.fastlist.audio;

import de.audi.app.combi.bap.dsi.fastlist.audio.IDSIFastListAudio;
import org.dsi.ifc.kombifastlist.DataCommonList;

public interface IDSIFastListCommonList
extends IDSIFastListAudio {
    public void pushCommonList(DataCommonList[] var1);

    public void pushCurrentListSizeCommonList(int var1);

    public void responseNotifyCommonListPush(boolean var1);
}

