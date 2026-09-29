/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.transfer.dsi;

import de.audi.app.media.transfer.dsi.MediaDSIRecorderListener;
import de.esolutions.fw.util.commons.Buffer;

class MediaDSIRecorderListener$8
implements Runnable {
    private final /* synthetic */ long val$numberOfImportedFiles;
    private final /* synthetic */ long val$numberOfErroneousFiles;
    private final /* synthetic */ long val$numberOfProtectedFiles;
    private final /* synthetic */ long val$numberOfFilesTotalToImport;
    private final /* synthetic */ long val$numberOfImportedPlaylists;
    private final /* synthetic */ long val$numberOfPlaylistsTotalToImport;
    private final /* synthetic */ MediaDSIRecorderListener this$0;

    MediaDSIRecorderListener$8(MediaDSIRecorderListener mediaDSIRecorderListener, long l, long l2, long l3, long l4, long l5, long l6) {
        this.this$0 = mediaDSIRecorderListener;
        this.val$numberOfImportedFiles = l;
        this.val$numberOfErroneousFiles = l2;
        this.val$numberOfProtectedFiles = l3;
        this.val$numberOfFilesTotalToImport = l4;
        this.val$numberOfImportedPlaylists = l5;
        this.val$numberOfPlaylistsTotalToImport = l6;
    }

    @Override
    public void run() {
        Object object;
        if (MediaDSIRecorderListener.access$1300(this.this$0).isInfo()) {
            object = new Buffer();
            ((Buffer)object).append("#imported='").append(this.val$numberOfImportedFiles).append("',#error='").append(this.val$numberOfErroneousFiles).append("',#protected='").append(this.val$numberOfProtectedFiles).append("',#total='").append(this.val$numberOfFilesTotalToImport).append("',#playlist='").append(this.val$numberOfImportedPlaylists).append("',#totalPlaylist=").append(this.val$numberOfPlaylistsTotalToImport).append("'");
            MediaDSIRecorderListener.access$1400(this.this$0).log(1078071040, "[%1.updateImportSummary2] [%2] %3", (Object)"MediaDSIRecorderListener", (Object)new Integer(MediaDSIRecorderListener.access$200(this.this$0).getInstanceID()), object);
        }
        if ((object = MediaDSIRecorderListener.access$200(this.this$0).getRecorderListener()) == null) {
            return;
        }
        object.updateImportSummary(this.val$numberOfImportedFiles, this.val$numberOfErroneousFiles, this.val$numberOfProtectedFiles, this.val$numberOfFilesTotalToImport, this.val$numberOfImportedPlaylists, this.val$numberOfPlaylistsTotalToImport);
    }

    public String toString() {
        return "DSIMediaRecorder.updateImportSummary";
    }
}

