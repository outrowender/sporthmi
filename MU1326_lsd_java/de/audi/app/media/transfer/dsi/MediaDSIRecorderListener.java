/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.transfer.dsi;

import de.audi.app.media.dsi.AbstractDSIListener;
import de.audi.app.media.source.ISourceResolver;
import de.audi.app.media.source.MediaSourceSlot;
import de.audi.app.media.transfer.dsi.IMediaRecorderListener;
import de.audi.app.media.transfer.dsi.MediaDSIRecorderControllerImpl;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import org.dsi.ifc.media.DSIMediaRecorderListener;
import org.dsi.ifc.media.DatabaseSpace;
import org.dsi.ifc.media.ListEntry;

public class MediaDSIRecorderListener
extends AbstractDSIListener
implements DSIMediaRecorderListener {
    private static final String LOGCLASS = "MediaDSIRecorderListener";
    private final MediaDSIRecorderControllerImpl controller;
    private final ISourceResolver sourceResolver;
    private final DispatcherBase dispatcher;

    public MediaDSIRecorderListener(MediaDSIRecorderControllerImpl mediaDSIRecorderControllerImpl, ISourceResolver iSourceResolver, LogChannel logChannel, DispatcherBase dispatcherBase) {
        super(logChannel);
        if (mediaDSIRecorderControllerImpl == null) {
            throw new IllegalArgumentException();
        }
        this.controller = mediaDSIRecorderControllerImpl;
        this.sourceResolver = iSourceResolver;
        this.dispatcher = dispatcherBase;
    }

    public void responseSetSelection(final int n, final boolean bl) {
        this.dispatcher.execute(new Runnable(){

            public void run() {
                IMediaRecorderListener iMediaRecorderListener;
                if (MediaDSIRecorderListener.this.logger.isInfo()) {
                    MediaDSIRecorderListener.this.logger.log(1000000, "[%1.responseSetSelection] browserID='%2', result='%3'.", (Object)MediaDSIRecorderListener.LOGCLASS, (Object)new Integer(n), (Object)bl);
                }
                if ((iMediaRecorderListener = MediaDSIRecorderListener.this.controller.getRecorderListener()) == null) {
                    return;
                }
                iMediaRecorderListener.responseSetSelection(n, bl);
            }

            public String toString() {
                return "DSIMediaRecorder.responseSetSelection";
            }
        });
    }

    public void updateActiveMedia(final long l, final long l2, int n) {
        if (!this.isUpdateValid("updateActiveMedia", this.controller.getInstanceID(), n)) {
            return;
        }
        this.dispatcher.execute(new Runnable(){

            public void run() {
                MediaDSIRecorderListener.this.logger.log(1000000, "[%1.updateActiveMedia] [%2] deviceID='%3', mediaID='%4'.", (Object)MediaDSIRecorderListener.LOGCLASS, (Object)new Integer(MediaDSIRecorderListener.this.controller.getInstanceID()), (Object)new Long(l), (Object)new Long(l2));
                MediaSourceSlot mediaSourceSlot = MediaDSIRecorderListener.this.controller.getSourceSlotToActivate();
                if (mediaSourceSlot == null) {
                    MediaDSIRecorderListener.this.logger.log(1000000, "[%1.updateActiveMedia] [%2] No request was send. Update have to be call just before a resume after startup. Trying to get the SourceSlot.", (Object)MediaDSIRecorderListener.LOGCLASS, (long)MediaDSIRecorderListener.this.controller.getInstanceID());
                    mediaSourceSlot = MediaDSIRecorderListener.this.sourceResolver.getSourceSlot(l, l2);
                    if (mediaSourceSlot == null) {
                        MediaDSIRecorderListener.this.logger.log(100000, "[%1.updateActiveMedia] [%2] Unexpected update. SlotToActive is null.", (Object)MediaDSIRecorderListener.LOGCLASS, (long)MediaDSIRecorderListener.this.controller.getInstanceID());
                        return;
                    }
                }
                if (mediaSourceSlot.getDeviceID() != l || mediaSourceSlot.getMediaID() != l2) {
                    MediaDSIRecorderListener.this.logger.log(1000000, "[%1.updateActiveMedia] [%2] Slot not triggered for activation.", (Object)MediaDSIRecorderListener.LOGCLASS, (long)MediaDSIRecorderListener.this.controller.getInstanceID());
                    return;
                }
                IMediaRecorderListener iMediaRecorderListener = MediaDSIRecorderListener.this.controller.getRecorderListener();
                if (iMediaRecorderListener == null) {
                    return;
                }
                iMediaRecorderListener.sourceSlotActivated(mediaSourceSlot);
            }

            public String toString() {
                return "DSIMediaRecorder.updateActiveMedia";
            }
        });
    }

    public void updateDatabaseSpace(final DatabaseSpace databaseSpace, int n) {
        if (!this.isUpdateValid("updateDatabaseSpace", this.controller.getInstanceID(), n)) {
            return;
        }
        this.dispatcher.execute(new Runnable(){

            public void run() {
                MediaDSIRecorderListener.this.logger.log(1000000, "[%1.updateDatabaseSpace] [%2] '%3'.", (Object)MediaDSIRecorderListener.LOGCLASS, (Object)new Integer(MediaDSIRecorderListener.this.controller.getInstanceID()), (Object)databaseSpace);
                IMediaRecorderListener iMediaRecorderListener = MediaDSIRecorderListener.this.controller.getRecorderListener();
                if (iMediaRecorderListener == null) {
                    return;
                }
                iMediaRecorderListener.updateDatabaseSpace(databaseSpace);
            }

            public String toString() {
                return "DSIMediaRecorder.updateDatabaseSpace";
            }
        });
    }

    public void updateDeletionProgress(final long l, int n) {
        if (!this.isUpdateValid("updateDeletionProgress", this.controller.getInstanceID(), n)) {
            return;
        }
        this.dispatcher.execute(new Runnable(){

            public void run() {
                MediaDSIRecorderListener.this.logger.log(1000000, "[%1.updateDeletionProgress] [%2] '%3'.", (Object)MediaDSIRecorderListener.LOGCLASS, (Object)new Integer(MediaDSIRecorderListener.this.controller.getInstanceID()), (Object)new Long(l));
                IMediaRecorderListener iMediaRecorderListener = MediaDSIRecorderListener.this.controller.getRecorderListener();
                if (iMediaRecorderListener == null) {
                    return;
                }
                iMediaRecorderListener.updateDeletionProgress(l);
            }

            public String toString() {
                return "DSIMediaRecorder.updateDeletionProgress";
            }
        });
    }

    public void updateDeletionStatus(final int n, int n2) {
        if (!this.isUpdateValid("updateDeletionStatus", this.controller.getInstanceID(), n2)) {
            return;
        }
        this.dispatcher.execute(new Runnable(){

            public void run() {
                MediaDSIRecorderListener.this.logger.log(1000000, "[%1.updateDeletionStatus] [%2] '%3'.", (Object)MediaDSIRecorderListener.LOGCLASS, (long)MediaDSIRecorderListener.this.controller.getInstanceID(), (long)n);
                IMediaRecorderListener iMediaRecorderListener = MediaDSIRecorderListener.this.controller.getRecorderListener();
                if (iMediaRecorderListener == null) {
                    return;
                }
                iMediaRecorderListener.updateDeletionStatus(n);
            }

            public String toString() {
                return "DSIMediaRecorder.updateDeletionStatus";
            }
        });
    }

    public void updateImportProgress(final long l, final ListEntry listEntry, int n) {
        if (!this.isUpdateValid("updateImportProgress", this.controller.getInstanceID(), n)) {
            return;
        }
        this.dispatcher.execute(new Runnable(){

            public void run() {
                MediaDSIRecorderListener.this.logger.log(1000000, "[%1.updateImportProgress] [%2] importProgress='%3', entry='%4'.", (Object)MediaDSIRecorderListener.LOGCLASS, (Object)new Integer(MediaDSIRecorderListener.this.controller.getInstanceID()), (Object)new Long(l), (Object)listEntry);
                IMediaRecorderListener iMediaRecorderListener = MediaDSIRecorderListener.this.controller.getRecorderListener();
                if (iMediaRecorderListener == null) {
                    return;
                }
                iMediaRecorderListener.updateImportProgress(l, listEntry);
            }

            public String toString() {
                return "DSIMediaRecorder.updateImportProgress";
            }
        });
    }

    public void updateImportStatus(final int n, int n2) {
        if (!this.isUpdateValid("updateImportStatus", this.controller.getInstanceID(), n2)) {
            return;
        }
        this.dispatcher.execute(new Runnable(){

            public void run() {
                MediaDSIRecorderListener.this.logger.log(1000000, "[%1.updateImportStatus] [%2] '%3'.", (Object)MediaDSIRecorderListener.LOGCLASS, (long)MediaDSIRecorderListener.this.controller.getInstanceID(), (long)n);
                IMediaRecorderListener iMediaRecorderListener = MediaDSIRecorderListener.this.controller.getRecorderListener();
                if (iMediaRecorderListener == null) {
                    return;
                }
                iMediaRecorderListener.updateImportStatus(n);
            }

            public String toString() {
                return "DSIMediaRecorder.updateImportStatus";
            }
        });
    }

    public void updateImportSummary(final long l, final long l2, final long l3, final long l4, final long l5, final long l6, int n) {
        if (!this.isUpdateValid("updateImportSummary", this.controller.getInstanceID(), n)) {
            return;
        }
        this.dispatcher.execute(new Runnable(){

            public void run() {
                Object object;
                if (MediaDSIRecorderListener.this.logger.isInfo()) {
                    object = new Buffer();
                    ((Buffer)object).append("#imported='").append(l).append("',#error='").append(l2).append("',#protected='").append(l3).append("',#total='").append(l4).append("',#playlist='").append(l5).append("',#totalPlaylist=").append(l6).append("'");
                    MediaDSIRecorderListener.this.logger.log(1000000, "[%1.updateImportSummary2] [%2] %3", (Object)MediaDSIRecorderListener.LOGCLASS, (Object)new Integer(MediaDSIRecorderListener.this.controller.getInstanceID()), object);
                }
                if ((object = MediaDSIRecorderListener.this.controller.getRecorderListener()) == null) {
                    return;
                }
                object.updateImportSummary(l, l2, l3, l4, l5, l6);
            }

            public String toString() {
                return "DSIMediaRecorder.updateImportSummary";
            }
        });
    }

    public void updateTargetMedia(long l, long l2, int n) {
    }

    public void responseSetEncodingQuality(final int n) {
        this.dispatcher.execute(new Runnable(){

            public void run() {
                MediaDSIRecorderListener.this.logger.log(1000000, "[%1.responseSetEncodingQuality] [%2] '%3'.", (Object)MediaDSIRecorderListener.LOGCLASS, (long)MediaDSIRecorderListener.this.controller.getInstanceID(), (long)n);
                IMediaRecorderListener iMediaRecorderListener = MediaDSIRecorderListener.this.controller.getRecorderListener();
                if (iMediaRecorderListener == null) {
                    return;
                }
                iMediaRecorderListener.responseSetEncodingQuality(n);
            }

            public String toString() {
                return "DSIMediaRecorder.responseSetEncodingQuality";
            }
        });
    }

    public void asyncException(final int n, final String string, final int n2) {
        this.dispatcher.execute(new Runnable(){

            public void run() {
                Buffer buffer = new Buffer(20);
                buffer.append("errorCode='").append(n).append("',requestType='").append(n2).append("',msg='").append(string).append("'");
                MediaDSIRecorderListener.this.logger.log(100000, "[%1.asyncException] [%2] %3", (Object)MediaDSIRecorderListener.LOGCLASS, (Object)new Integer(MediaDSIRecorderListener.this.controller.getInstanceID()), (Object)buffer);
                IMediaRecorderListener iMediaRecorderListener = MediaDSIRecorderListener.this.controller.getRecorderListener();
                if (iMediaRecorderListener == null) {
                    return;
                }
                iMediaRecorderListener.asyncException(n, string, n2);
            }

            public String toString() {
                return "DSIMediaRecorder.asyncException";
            }
        });
    }

    protected String getLogClass() {
        return LOGCLASS;
    }
}

