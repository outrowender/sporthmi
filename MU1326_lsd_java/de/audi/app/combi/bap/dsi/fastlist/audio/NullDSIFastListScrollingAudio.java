/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.dsi.fastlist.audio;

import de.audi.atip.interapp.def.NullService;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.kombifastlist.DSIFastListScrollingAudio;
import org.dsi.ifc.kombifastlist.DataCommonList;
import org.dsi.ifc.kombifastlist.DataMediaBrowser;
import org.dsi.ifc.kombifastlist.DataReceptionList;

public class NullDSIFastListScrollingAudio
extends NullService
implements DSIFastListScrollingAudio {
    public NullDSIFastListScrollingAudio(LogChannel logChannel) {
        super(logChannel, "DSIFastListScrollingAudio");
    }

    public void setNotification(int[] nArray, DSIListener dSIListener) {
    }

    public void setNotification(int n, DSIListener dSIListener) {
    }

    public void setNotification(DSIListener dSIListener) {
    }

    public void clearNotification(int[] nArray, DSIListener dSIListener) {
    }

    public void clearNotification(int n, DSIListener dSIListener) {
    }

    public void clearNotification(DSIListener dSIListener) {
    }

    public void pushFunctionAvailabilityAudio(int n) {
    }

    public void pushMOSTOperationStateAudio(int n) {
    }

    public void responseMediaBrowser(int n, int n2, int n3, int n4, int n5, int n6, int n7, long l, int n8, long l2, long l3, int n9, int n10, int n11) {
    }

    public void responseMediaBrowserArray(long l, int n, DataMediaBrowser[] dataMediaBrowserArray) {
    }

    public void pushCommonList(long l, int n, DataCommonList[] dataCommonListArray) {
    }

    public void pushReceptionList(long l, int n, DataReceptionList[] dataReceptionListArray) {
    }

    public void pushCurrentListSizeAudio(int n, int n2, int n3) {
    }

    public void responseMediaBrowserJobs(long l, int n, int n2) {
    }

    public void responseNotifyCommonListPush(boolean bl) {
    }

    public void responseNotifyCurrentListSizeAudio(boolean bl) {
    }

    public void responseNotifyReceptionList(boolean bl) {
    }
}

