/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.transfer.dsi;

import de.audi.app.media.dsi.AbstractDSIListener;
import de.audi.app.media.source.ISourceResolver;
import de.audi.app.media.transfer.dsi.MediaDSIRecorderControllerImpl;
import de.audi.app.media.transfer.dsi.MediaDSIRecorderListener$1;
import de.audi.app.media.transfer.dsi.MediaDSIRecorderListener$10;
import de.audi.app.media.transfer.dsi.MediaDSIRecorderListener$2;
import de.audi.app.media.transfer.dsi.MediaDSIRecorderListener$3;
import de.audi.app.media.transfer.dsi.MediaDSIRecorderListener$4;
import de.audi.app.media.transfer.dsi.MediaDSIRecorderListener$5;
import de.audi.app.media.transfer.dsi.MediaDSIRecorderListener$6;
import de.audi.app.media.transfer.dsi.MediaDSIRecorderListener$7;
import de.audi.app.media.transfer.dsi.MediaDSIRecorderListener$8;
import de.audi.app.media.transfer.dsi.MediaDSIRecorderListener$9;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import org.dsi.ifc.media.DSIMediaRecorderListener;
import org.dsi.ifc.media.DatabaseSpace;
import org.dsi.ifc.media.ListEntry;

public class MediaDSIRecorderListener
extends AbstractDSIListener
implements DSIMediaRecorderListener {
    private static final String LOGCLASS;
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

    @Override
    public void responseSetSelection(int n, boolean bl) {
        this.dispatcher.execute(new MediaDSIRecorderListener$1(this, n, bl));
    }

    @Override
    public void updateActiveMedia(long l, long l2, int n) {
        if (!this.isUpdateValid("updateActiveMedia", this.controller.getInstanceID(), n)) {
            return;
        }
        this.dispatcher.execute(new MediaDSIRecorderListener$2(this, l, l2));
    }

    @Override
    public void updateDatabaseSpace(DatabaseSpace databaseSpace, int n) {
        if (!this.isUpdateValid("updateDatabaseSpace", this.controller.getInstanceID(), n)) {
            return;
        }
        this.dispatcher.execute(new MediaDSIRecorderListener$3(this, databaseSpace));
    }

    @Override
    public void updateDeletionProgress(long l, int n) {
        if (!this.isUpdateValid("updateDeletionProgress", this.controller.getInstanceID(), n)) {
            return;
        }
        this.dispatcher.execute(new MediaDSIRecorderListener$4(this, l));
    }

    @Override
    public void updateDeletionStatus(int n, int n2) {
        if (!this.isUpdateValid("updateDeletionStatus", this.controller.getInstanceID(), n2)) {
            return;
        }
        this.dispatcher.execute(new MediaDSIRecorderListener$5(this, n));
    }

    @Override
    public void updateImportProgress(long l, ListEntry listEntry, int n) {
        if (!this.isUpdateValid("updateImportProgress", this.controller.getInstanceID(), n)) {
            return;
        }
        this.dispatcher.execute(new MediaDSIRecorderListener$6(this, l, listEntry));
    }

    @Override
    public void updateImportStatus(int n, int n2) {
        if (!this.isUpdateValid("updateImportStatus", this.controller.getInstanceID(), n2)) {
            return;
        }
        this.dispatcher.execute(new MediaDSIRecorderListener$7(this, n));
    }

    @Override
    public void updateImportSummary(long l, long l2, long l3, long l4, long l5, long l6, int n) {
        if (!this.isUpdateValid("updateImportSummary", this.controller.getInstanceID(), n)) {
            return;
        }
        this.dispatcher.execute(new MediaDSIRecorderListener$8(this, l, l2, l3, l4, l5, l6));
    }

    @Override
    public void updateTargetMedia(long l, long l2, int n) {
    }

    @Override
    public void responseSetEncodingQuality(int n) {
        this.dispatcher.execute(new MediaDSIRecorderListener$9(this, n));
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        this.dispatcher.execute(new MediaDSIRecorderListener$10(this, n, n2, string));
    }

    @Override
    protected String getLogClass() {
        return "MediaDSIRecorderListener";
    }

    static /* synthetic */ LogChannel access$000(MediaDSIRecorderListener mediaDSIRecorderListener) {
        return mediaDSIRecorderListener.logger;
    }

    static /* synthetic */ LogChannel access$100(MediaDSIRecorderListener mediaDSIRecorderListener) {
        return mediaDSIRecorderListener.logger;
    }

    static /* synthetic */ MediaDSIRecorderControllerImpl access$200(MediaDSIRecorderListener mediaDSIRecorderListener) {
        return mediaDSIRecorderListener.controller;
    }

    static /* synthetic */ LogChannel access$300(MediaDSIRecorderListener mediaDSIRecorderListener) {
        return mediaDSIRecorderListener.logger;
    }

    static /* synthetic */ LogChannel access$400(MediaDSIRecorderListener mediaDSIRecorderListener) {
        return mediaDSIRecorderListener.logger;
    }

    static /* synthetic */ ISourceResolver access$500(MediaDSIRecorderListener mediaDSIRecorderListener) {
        return mediaDSIRecorderListener.sourceResolver;
    }

    static /* synthetic */ LogChannel access$600(MediaDSIRecorderListener mediaDSIRecorderListener) {
        return mediaDSIRecorderListener.logger;
    }

    static /* synthetic */ LogChannel access$700(MediaDSIRecorderListener mediaDSIRecorderListener) {
        return mediaDSIRecorderListener.logger;
    }

    static /* synthetic */ LogChannel access$800(MediaDSIRecorderListener mediaDSIRecorderListener) {
        return mediaDSIRecorderListener.logger;
    }

    static /* synthetic */ LogChannel access$900(MediaDSIRecorderListener mediaDSIRecorderListener) {
        return mediaDSIRecorderListener.logger;
    }

    static /* synthetic */ LogChannel access$1000(MediaDSIRecorderListener mediaDSIRecorderListener) {
        return mediaDSIRecorderListener.logger;
    }

    static /* synthetic */ LogChannel access$1100(MediaDSIRecorderListener mediaDSIRecorderListener) {
        return mediaDSIRecorderListener.logger;
    }

    static /* synthetic */ LogChannel access$1200(MediaDSIRecorderListener mediaDSIRecorderListener) {
        return mediaDSIRecorderListener.logger;
    }

    static /* synthetic */ LogChannel access$1300(MediaDSIRecorderListener mediaDSIRecorderListener) {
        return mediaDSIRecorderListener.logger;
    }

    static /* synthetic */ LogChannel access$1400(MediaDSIRecorderListener mediaDSIRecorderListener) {
        return mediaDSIRecorderListener.logger;
    }

    static /* synthetic */ LogChannel access$1500(MediaDSIRecorderListener mediaDSIRecorderListener) {
        return mediaDSIRecorderListener.logger;
    }

    static /* synthetic */ LogChannel access$1600(MediaDSIRecorderListener mediaDSIRecorderListener) {
        return mediaDSIRecorderListener.logger;
    }
}

