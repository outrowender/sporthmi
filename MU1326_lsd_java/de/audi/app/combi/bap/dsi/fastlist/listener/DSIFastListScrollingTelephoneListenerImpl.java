/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.dsi.fastlist.listener;

import de.audi.app.combi.bap.app.phone.list.AbstractListAdapterFastListPhone;
import de.audi.app.combi.bap.dsi.fastlist.listener.IDSIFastListScrollingListener;
import de.audi.app.combi.bap.utils.CombiLogger;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.kombifastlist.ArrayHeader;
import org.dsi.ifc.kombifastlist.DSIFastListScrollingTelephoneListener;

public class DSIFastListScrollingTelephoneListenerImpl
implements IDSIFastListScrollingListener,
DSIFastListScrollingTelephoneListener {
    private final AbstractListAdapterFastListPhone listAdapter;
    private final LogChannel logChannel;
    static /* synthetic */ Class class$org$dsi$ifc$kombifastlist$DSIFastListScrollingTelephoneListener;

    public DSIFastListScrollingTelephoneListenerImpl(AbstractListAdapterFastListPhone abstractListAdapterFastListPhone) {
        this.listAdapter = abstractListAdapterFastListPhone;
        this.logChannel = CombiLogger.getFastListDSILog();
    }

    public Class getDSIListenerClass() {
        return class$org$dsi$ifc$kombifastlist$DSIFastListScrollingTelephoneListener == null ? (class$org$dsi$ifc$kombifastlist$DSIFastListScrollingTelephoneListener = DSIFastListScrollingTelephoneListenerImpl.class$("org.dsi.ifc.kombifastlist.DSIFastListScrollingTelephoneListener")) : class$org$dsi$ifc$kombifastlist$DSIFastListScrollingTelephoneListener;
    }

    public void asyncException(int n, String string, int n2) {
        this.logChannel.log(1000000, "[DSIFastListScrollingTelephoneListenerImpl#asyncException] errorCode=%1, errorMsg=%2, requestType=%3", (Object)string, (long)n, (long)n2);
    }

    public void indicationPhonebook(int n, int n2, int n3, int n4, long l, int n5, int n6, int n7, int n8, int n9, int n10) {
        this.logChannel.log(10000000, "[DSIFastListScrollingTelephoneListenerImpl#indicationPhonebook] aSGID=%1, tAID=%2, ...", (long)n, (long)n2);
        this.logChannel.log(10000000, "[DSIFastListScrollingTelephoneListenerImpl#indicationPhonebook] ..., mode=%1, recordAddress=%2, start=%3, ...", (long)n3, (long)n4, l);
        this.logChannel.log(10000000, "[DSIFastListScrollingTelephoneListenerImpl#indicationPhonebook] ..., relativeJump=%1, elements=%2, absoluteListPos=%3, ...", (long)n5, (long)n6, (long)n7);
        this.logChannel.log(10000000, "[DSIFastListScrollingTelephoneListenerImpl#indicationPhonebook] ..., jobModification=%1, jobID=%2, jobPriority=%3, ...", (long)n8, (long)n9, (long)n10);
        this.listAdapter.addPhonebookJob(n, n2, new ArrayHeader(n3, n4, l, n5, n6, n7, n8, n9, n10));
    }

    public void indicationGetInitialsTelephone(int n, int n2, int n3, int n4) {
        this.logChannel.log(10000000, "[DSIFastListScrollingTelephoneListenerImpl#indicationGetInitialsTelephone] senderHandle=%1, aSGID=%2, tAID=%3, ...", (long)n, (long)n2, (long)n3);
        this.logChannel.log(10000000, "[DSIFastListScrollingTelephoneListenerImpl#indicationGetInitialsTelephone] ..., requestedList=%1", (long)n4);
        this.listAdapter.getListInitials(n2, n3, n4);
    }

    public void indicationNotifyFavoriteListPush(boolean bl, boolean bl2) {
        this.logChannel.log(10000000, "[DSIFastListScrollingTelephoneListenerImpl#indicationNotifyFavoriteListPush] valid=%1, notified=%2", bl, bl2);
        if (bl) {
            this.listAdapter.setNotificationFavoriteList(bl2);
        }
    }

    public void indicationNotifyCombinedNumbersPush(boolean bl, boolean bl2) {
        this.logChannel.log(10000000, "[DSIFastListScrollingTelephoneListenerImpl#indicationNotifyCombinedNumbersPush] valid=%1, notified=%2", bl, bl2);
        if (bl) {
            this.listAdapter.setNotificationCombinedNumbers(bl2);
        }
    }

    public void indicationNotifyCurrentListSizeTelephone(boolean bl, boolean bl2) {
        this.logChannel.log(10000000, "[DSIFastListScrollingTelephoneListenerImpl#indicationNotifyCurrentListSizeTelephone] valid=%1, notified=%2", bl, bl2);
        if (bl) {
            this.listAdapter.setNotificationCurrentListSizes(bl2);
        }
    }

    public void indicationPhonebookJobs(int n, int n2, int n3, ArrayHeader[] arrayHeaderArray) {
        this.logChannel.log(10000000, "[DSIFastListScrollingTelephoneListenerImpl#indicationPhonebookJobs] senderHandle=%1, asgId=%2, tAId=%3", (long)n, (long)n2, (long)n3);
        this.listAdapter.addPhonebookJobs(n2, n3, arrayHeaderArray);
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

