/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.dsi.fastlist.audio;

import de.audi.app.combi.bap.dsi.fastlist.audio.IDSIFastListAudio;
import org.dsi.ifc.kombifastlist.DataReceptionList;

public interface IDSIFastListReceptionList
extends IDSIFastListAudio {
    public void pushReceptionList(DataReceptionList[] var1);

    public void pushCurrentListSizeReceptionList(int var1);

    public void responseNotifyReceptionList(boolean var1);
}

