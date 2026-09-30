/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.dsi.fastlist.audio;

import de.audi.app.combi.bap.dsi.fastlist.audio.IDSIFastListAudio;
import org.dsi.ifc.kombifastlist.ArrayHeader;
import org.dsi.ifc.kombifastlist.DataMediaBrowser;

public interface IDSIFastListMediaBrowser
extends IDSIFastListAudio {
    public void responseMediaBrowser(int var1, int var2, int var3, int var4, int var5, ArrayHeader var6);

    public void responseMediaBrowserArray(DataMediaBrowser[] var1);

    public void responseMediaBrowserJobs(int var1, int var2);

    public void pushCurrentListSizeMediaBrowser(int var1);
}

