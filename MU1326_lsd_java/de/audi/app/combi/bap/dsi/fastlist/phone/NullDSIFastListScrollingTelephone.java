/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.dsi.fastlist.phone;

import de.audi.atip.interapp.def.NullService;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.kombifastlist.DSIFastListScrollingTelephone;
import org.dsi.ifc.kombifastlist.DataCombinedNumbers;
import org.dsi.ifc.kombifastlist.DataFavoriteList;
import org.dsi.ifc.kombifastlist.DataInitials;
import org.dsi.ifc.kombifastlist.DataPhonebook;

public final class NullDSIFastListScrollingTelephone
extends NullService
implements DSIFastListScrollingTelephone {
    public NullDSIFastListScrollingTelephone(LogChannel logChannel) {
        super(logChannel, "DSIFastListScrollingTelephone");
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

    public void pushFunctionAvailabilityTelephone(int n) {
    }

    public void pushMOSTOperationStateTelephone(short s) {
    }

    public void responsePhonebook(int n, int n2, int n3, int n4, int n5, long l, int n6, int n7, int n8, int n9, int n10, int n11, int n12) {
    }

    public void responsePhonebookArray(int n, int n2, DataPhonebook[] dataPhonebookArray) {
    }

    public void responseGetInitialsTelephone(int n, int n2, int n3, int n4, DataInitials[] dataInitialsArray) {
    }

    public void pushupdateFavoriteList(int n, int n2, DataFavoriteList[] dataFavoriteListArray) {
    }

    public void pushCombinedNumbers(int n, int n2, DataCombinedNumbers[] dataCombinedNumbersArray) {
    }

    public void pushCurrentListSizeTelephone(int n, int n2, int n3) {
    }

    public void responsePhonebookJobs(int n, int n2, int n3) {
    }

    public void responseNotifyCombinedNumbersPush(boolean bl) {
    }

    public void responseNotifyCurrentListSizes(boolean bl) {
    }

    public void responseNotifyFavoriteListPush(boolean bl) {
    }
}

