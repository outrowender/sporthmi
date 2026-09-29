/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.dsi.fastlist.audio;

import de.audi.app.combi.bap.dsi.fastlist.audio.DSIFastListAudio;
import de.audi.app.combi.bap.dsi.fastlist.audio.FastListAudioSizes;
import de.audi.app.combi.bap.dsi.fastlist.audio.IDSIFastListMediaBrowser;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.kombifastlist.ArrayHeader;
import org.dsi.ifc.kombifastlist.DataMediaBrowser;

public final class DSIFastListMediaBrowser
extends DSIFastListAudio
implements IDSIFastListMediaBrowser {
    @Override
    public void responseMediaBrowser(int n, int n2, int n3, int n4, int n5, ArrayHeader arrayHeader) {
        this.dsiLogChannel.log(1078071040, "[DSIFastListMediaBrowser#responseMediaBrowser] asgID=%1, taID=%2, ...", (long)n, (long)n2);
        this.dsiLogChannel.log(1078071040, "[DSIFastListMediaBrowser#responseMediaBrowser] totalNumListElements=%1, activeListPos=%2, ...", (long)n3, (long)n4);
        this.dsiLogChannel.log(1078071040, "[DSIFastListMediaBrowser#responseMediaBrowser] sendReason=%2, arrayHeader=%1, ...", (Object)arrayHeader, (long)n5);
        this.dsi.responseMediaBrowser(n, n2, n3, n4, n5, arrayHeader.mode, arrayHeader.recordAddress, arrayHeader.start, arrayHeader.relativeJump, arrayHeader.elements, arrayHeader.absoluteListPos, arrayHeader.jobModification, arrayHeader.jobID, arrayHeader.jobPriority);
    }

    @Override
    public void responseMediaBrowserArray(DataMediaBrowser[] dataMediaBrowserArray) {
        this.dsiLogChannel.log(1078071040, "[DSIFastListMediaBrowser#responseMediaBrowserArray] data.length=%1", (long)dataMediaBrowserArray.length);
        if (this.dsiLogChannel.isDebug2()) {
            Buffer buffer = new Buffer();
            for (int i2 = 0; i2 < dataMediaBrowserArray.length; ++i2) {
                buffer.append(dataMediaBrowserArray[i2]);
                buffer.append('\n');
            }
            this.dsiLogChannel.log(14808325, "[DSIFastListMediaBrowser#responseMediaBrowserArray] DataMediaBrowser[] {\n%1}", (Object)buffer);
        }
        this.dsi.responseMediaBrowserArray(0L, 0, dataMediaBrowserArray);
    }

    @Override
    public void responseMediaBrowserJobs(int n, int n2) {
        this.dsiLogChannel.log(1078071040, "[DSIFastListMediaBrowser#responseMediaBrowserJobs] jobID=%1, jobsResult=%2", (long)n, (long)n2);
        this.dsi.responseMediaBrowserJobs(0L, n, n2);
    }

    @Override
    public void pushCurrentListSizeMediaBrowser(int n) {
        this.dsiLogChannel.log(1078071040, "[DSIFastListMediaBrowser#pushCurrentListSizeMediaBrowser] listSize=%1", (long)n);
        FastListAudioSizes.pushListSizeMediaBrowser(this.dsi, n);
    }
}

