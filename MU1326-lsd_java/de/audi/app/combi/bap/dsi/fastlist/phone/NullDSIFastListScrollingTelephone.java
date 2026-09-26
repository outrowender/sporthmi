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

    @Override
    public void setNotification(int[] nArray, DSIListener dSIListener) {
    }

    @Override
    public void setNotification(int n, DSIListener dSIListener) {
    }

    @Override
    public void setNotification(DSIListener dSIListener) {
    }

    @Override
    public void clearNotification(int[] nArray, DSIListener dSIListener) {
    }

    @Override
    public void clearNotification(int n, DSIListener dSIListener) {
    }

    @Override
    public void clearNotification(DSIListener dSIListener) {
    }

    @Override
    public void pushFunctionAvailabilityTelephone(int n) {
    }

    @Override
    public void pushMOSTOperationStateTelephone(short s) {
    }

    @Override
    public void responsePhonebook(int n, int n2, int n3, int n4, int n5, long l, int n6, int n7, int n8, int n9, int n10, int n11, int n12) {
    }

    @Override
    public void responsePhonebookArray(int n, int n2, DataPhonebook[] dataPhonebookArray) {
    }

    @Override
    public void responseGetInitialsTelephone(int n, int n2, int n3, int n4, DataInitials[] dataInitialsArray) {
    }

    @Override
    public void pushupdateFavoriteList(int n, int n2, DataFavoriteList[] dataFavoriteListArray) {
    }

    @Override
    public void pushCombinedNumbers(int n, int n2, DataCombinedNumbers[] dataCombinedNumbersArray) {
    }

    @Override
    public void pushCurrentListSizeTelephone(int n, int n2, int n3) {
    }

    @Override
    public void responsePhonebookJobs(int n, int n2, int n3) {
    }

    @Override
    public void responseNotifyCombinedNumbersPush(boolean bl) {
    }

    @Override
    public void responseNotifyCurrentListSizes(boolean bl) {
    }

    @Override
    public void responseNotifyFavoriteListPush(boolean bl) {
    }
}

