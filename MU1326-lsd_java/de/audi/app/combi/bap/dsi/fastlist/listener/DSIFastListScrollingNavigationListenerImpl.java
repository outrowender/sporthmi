/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.dsi.fastlist.listener;

import de.audi.app.combi.bap.app.navi.list.AbstractListAdapterFastListNavi;
import de.audi.app.combi.bap.dsi.fastlist.listener.IDSIFastListScrollingListener;
import de.audi.app.combi.bap.utils.CombiLogger;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.kombifastlist.ArrayHeader;
import org.dsi.ifc.kombifastlist.DSIFastListScrollingNavigationListener;

public class DSIFastListScrollingNavigationListenerImpl
implements IDSIFastListScrollingListener,
DSIFastListScrollingNavigationListener {
    private final AbstractListAdapterFastListNavi listAdapter;
    private final LogChannel logChannel;
    static /* synthetic */ Class class$org$dsi$ifc$kombifastlist$DSIFastListScrollingNavigationListener;

    public DSIFastListScrollingNavigationListenerImpl(AbstractListAdapterFastListNavi abstractListAdapterFastListNavi) {
        this.listAdapter = abstractListAdapterFastListNavi;
        this.logChannel = CombiLogger.getFastListDSILog();
    }

    @Override
    public Class getDSIListenerClass() {
        return class$org$dsi$ifc$kombifastlist$DSIFastListScrollingNavigationListener == null ? (class$org$dsi$ifc$kombifastlist$DSIFastListScrollingNavigationListener = DSIFastListScrollingNavigationListenerImpl.class$("org.dsi.ifc.kombifastlist.DSIFastListScrollingNavigationListener")) : class$org$dsi$ifc$kombifastlist$DSIFastListScrollingNavigationListener;
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        this.logChannel.log(1078071040, "[DSIFastListScrollingNavigationListenerImpl#asyncException] errorCode=%1, errorMsg=%2, requestType=%3", (Object)string, (long)n, (long)n2);
    }

    @Override
    public void indicationNavBook(int n, int n2, int n3, int n4, long l, int n5, int n6, int n7, int n8, int n9, int n10) {
        this.logChannel.log(-2137614336, "[DSIFastListScrollingNavigationListenerImpl#indicationNavBook] aSGID=%1, tAID=%2, ...", (long)n, (long)n2);
        this.logChannel.log(-2137614336, "[DSIFastListScrollingNavigationListenerImpl#indicationNavBook] ..., mode=%1, recordAddress=%2, start=%3, ...", (long)n3, (long)n4, l);
        this.logChannel.log(-2137614336, "[DSIFastListScrollingNavigationListenerImpl#indicationNavBook] ..., relativeJump=%1, elements=%2, absoluteListPos=%3, ...", (long)n5, (long)n6, (long)n7);
        this.logChannel.log(-2137614336, "[DSIFastListScrollingNavigationListenerImpl#indicationNavBook] ..., jobModification=%1, jobID=%2, jobPriority=%3, ...", (long)n8, (long)n9, (long)n10);
        this.listAdapter.addNavBookJob(n, n2, new ArrayHeader(n3, n4, l, n5, n6, n7, n8, n9, n10));
    }

    @Override
    public void indicationGetInitialsNavigation(int n, int n2, int n3, int n4) {
        this.logChannel.log(-2137614336, "[DSIFastListScrollingNavigationListenerImpl#indicationGetInitialsNavigation] senderHandle=%1, aSGID=%2, tAID=%3, ...", (long)n, (long)n2, (long)n3);
        this.logChannel.log(-2137614336, "[DSIFastListScrollingNavigationListenerImpl#indicationGetInitialsNavigation] ..., requestedList=%1", (long)n4);
        this.listAdapter.getListInitials(n2, n3, n4);
    }

    @Override
    public void indicationNotifyLastDestListPUSH(boolean bl, boolean bl2) {
        this.logChannel.log(-2137614336, "[DSIFastListScrollingNavigationListenerImpl#indicationNotifyLastDestListPUSH] valid=%1, notified=%2", bl, bl2);
        if (bl) {
            this.listAdapter.setNotificationLastDestinationsList(bl2);
        }
    }

    @Override
    public void indicationNotifyFavoriteDestListPUSH(boolean bl, boolean bl2) {
        this.logChannel.log(-2137614336, "[DSIFastListScrollingNavigationListenerImpl#indicationNotifyFavoriteDestListPUSH] valid=%1, notified=%2", bl, bl2);
        if (bl) {
            this.listAdapter.setNotificationFavoriteDestinationsList(bl2);
        }
    }

    @Override
    public void indicationNotifyCurrentListSizeNavigation(boolean bl, boolean bl2) {
        this.logChannel.log(-2137614336, "[DSIFastListScrollingNavigationListenerImpl#indicationNotifyCurrentListSizeNavigation] valid=%1, notified=%2", bl, bl2);
        if (bl) {
            this.listAdapter.setNotificationCurrentListSizes(bl2);
        }
    }

    @Override
    public void indicationNavBookJobs(int n, int n2, int n3, ArrayHeader[] arrayHeaderArray) {
        this.logChannel.log(-2137614336, "[DSIFastListScrollingNavigationListenerImpl#indicationNavBookJobs] senderHandle=%1, asgId=%2, tAId=%3", (long)n, (long)n2, (long)n3);
        this.listAdapter.addNavBookJobs(n2, n3, arrayHeaderArray);
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

