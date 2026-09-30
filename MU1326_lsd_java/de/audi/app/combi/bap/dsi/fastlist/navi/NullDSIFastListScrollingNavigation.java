/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.dsi.fastlist.navi;

import de.audi.atip.interapp.def.NullService;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.kombifastlist.DSIFastListScrollingNavigation;
import org.dsi.ifc.kombifastlist.DataAddress;
import org.dsi.ifc.kombifastlist.DataInitials;

public final class NullDSIFastListScrollingNavigation
extends NullService
implements DSIFastListScrollingNavigation {
    public NullDSIFastListScrollingNavigation(LogChannel logChannel) {
        super(logChannel, "DSIFastListScrollingNavigation");
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

    public void pushFunctionAvailabilityNavigation(int n) {
    }

    public void pushMOSTOperationStateNavigation(int n) {
    }

    public void responseNavBook(int n, int n2, int n3, int n4, int n5, long l, int n6, int n7, int n8, int n9, int n10, int n11, int n12) {
    }

    public void responseNavBookArray(int n, int n2, DataAddress[] dataAddressArray) {
    }

    public void responseGetInitialsNavigation(int n, int n2, int n3, int n4, DataInitials[] dataInitialsArray) {
    }

    public void pushLastDestList(int n, int n2, DataAddress[] dataAddressArray) {
    }

    public void pushUpdateFavoriteDestList(int n, int n2, DataAddress[] dataAddressArray) {
    }

    public void pushCurrentListSizeNavigation(int n, int n2, int n3) {
    }

    public void responseNavBookJobs(int n, int n2, int n3) {
    }

    public void responseNotifyCurrentListSizesNavigation(boolean bl) {
    }

    public void responseNotifyFavoriteDestList(boolean bl) {
    }

    public void responseNotifyLastDestList(boolean bl) {
    }
}

