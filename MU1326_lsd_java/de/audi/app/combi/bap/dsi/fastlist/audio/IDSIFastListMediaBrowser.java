/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.dsi.fastlist.audio;

import de.audi.app.combi.bap.dsi.fastlist.audio.IDSIFastListAudio;
import org.dsi.ifc.kombifastlist.ArrayHeader;
import org.dsi.ifc.kombifastlist.DataMediaBrowser;

public interface IDSIFastListMediaBrowser
extends IDSIFastListAudio {
    default public void responseMediaBrowser(int n, int n2, int n3, int n4, int n5, ArrayHeader arrayHeader) {
    }

    default public void responseMediaBrowserArray(DataMediaBrowser[] dataMediaBrowserArray) {
    }

    default public void responseMediaBrowserJobs(int n, int n2) {
    }

    default public void pushCurrentListSizeMediaBrowser(int n) {
    }
}

