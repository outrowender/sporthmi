/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.dsi.fastlist.listener;

import de.audi.app.combi.bap.app.audio.list.AbstractListAdapterFastListAudio;
import de.audi.app.combi.bap.dsi.fastlist.listener.IDSIFastListScrollingListener;
import de.audi.app.combi.bap.utils.CombiLogger;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.kombifastlist.ArrayHeader;
import org.dsi.ifc.kombifastlist.DSIFastListScrollingAudioListener;

public class DSIFastListScrollingAudioListenerImpl
implements IDSIFastListScrollingListener,
DSIFastListScrollingAudioListener {
    private final AbstractListAdapterFastListAudio listAdapter;
    private final LogChannel logChannel;
    static /* synthetic */ Class class$org$dsi$ifc$kombifastlist$DSIFastListScrollingAudioListener;

    public DSIFastListScrollingAudioListenerImpl(AbstractListAdapterFastListAudio abstractListAdapterFastListAudio) {
        this.listAdapter = abstractListAdapterFastListAudio;
        this.logChannel = CombiLogger.getFastListDSILog();
    }

    public Class getDSIListenerClass() {
        return class$org$dsi$ifc$kombifastlist$DSIFastListScrollingAudioListener == null ? (class$org$dsi$ifc$kombifastlist$DSIFastListScrollingAudioListener = DSIFastListScrollingAudioListenerImpl.class$("org.dsi.ifc.kombifastlist.DSIFastListScrollingAudioListener")) : class$org$dsi$ifc$kombifastlist$DSIFastListScrollingAudioListener;
    }

    public void asyncException(int n, String string, int n2) {
        this.logChannel.log(1000000, "[DSIFastListScrollingAudioListenerImpl#asyncException] errorCode=%1, errorMsg=%2, requestType=%3", (Object)string, (long)n, (long)n2);
    }

    public void indicationMediaBrowser(int n, int n2, int n3, int n4, long l, int n5, int n6, int n7, int n8, int n9, int n10) {
        this.logChannel.log(10000000, "[DSIFastListScrollingAudioListenerImpl#indicationMediaBrowser] ASG_ID=%1, tAID=%2, ...", (long)n, (long)n2);
        this.logChannel.log(10000000, "[DSIFastListScrollingAudioListenerImpl#indicationMediaBrowser] ..., mode=%1, recordAddress=%2, start=%3, ...", (long)n3, (long)n4, l);
        this.logChannel.log(10000000, "[DSIFastListScrollingAudioListenerImpl#indicationMediaBrowser] ..., relativeJump=%1, elements=%2, absoluteListPos=%3, ...", (long)n5, (long)n6, (long)n7);
        this.logChannel.log(10000000, "[DSIFastListScrollingAudioListenerImpl#indicationMediaBrowser] ..., jobModification=%1, jobID=%2, jobPriority=%3, ...", (long)n8, (long)n9, (long)n10);
        this.listAdapter.addMediaBrowserJob(n, n2, new ArrayHeader(n3, n4, l, n5, n6, n7, n8, n9, n10));
    }

    public void indicationNotifyCommonListPUSH(boolean bl, boolean bl2) {
        this.logChannel.log(10000000, "[DSIFastListScrollingAudioListenerImpl#indicationNotifyCommonListPUSH] valid=%1, notified=%2", bl, bl2);
        if (bl) {
            this.listAdapter.setNotificationCommonList(bl2);
        }
    }

    public void indicationNotifyReceptionListPUSH(boolean bl, boolean bl2) {
        this.logChannel.log(10000000, "[DSIFastListScrollingAudioListenerImpl#indicationNotifyReceptionListPUSH] valid=%1, notified=%2", bl, bl2);
        if (bl) {
            this.listAdapter.setNotificationReceptionList(bl2);
        }
    }

    public void indicationNotifyCurrentListSizeAudio(boolean bl, boolean bl2) {
        this.logChannel.log(10000000, "[DSIFastListScrollingAudioListenerImpl#indicationNotifyCurrentListSizeAudio] valid=%1, notified=%2", bl, bl2);
        if (bl) {
            this.listAdapter.setNotificationCurrentListSizes(bl2);
        }
    }

    public void indicationMediaBrowserJobs(int n, int n2, int n3, ArrayHeader[] arrayHeaderArray) {
        this.logChannel.log(10000000, "[DSIFastListScrollingAudioListenerImpl#indicationMediaBrowserJobs] senderHandle=%1, asgId=%2, tAID=%3", (long)n, (long)n2, (long)n3);
        this.listAdapter.addMediaBrowserJobs(n2, n3, arrayHeaderArray);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

