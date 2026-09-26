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
    public void pushFunctionAvailabilityNavigation(int n) {
    }

    @Override
    public void pushMOSTOperationStateNavigation(int n) {
    }

    @Override
    public void responseNavBook(int n, int n2, int n3, int n4, int n5, long l, int n6, int n7, int n8, int n9, int n10, int n11, int n12) {
    }

    @Override
    public void responseNavBookArray(int n, int n2, DataAddress[] dataAddressArray) {
    }

    @Override
    public void responseGetInitialsNavigation(int n, int n2, int n3, int n4, DataInitials[] dataInitialsArray) {
    }

    @Override
    public void pushLastDestList(int n, int n2, DataAddress[] dataAddressArray) {
    }

    @Override
    public void pushUpdateFavoriteDestList(int n, int n2, DataAddress[] dataAddressArray) {
    }

    @Override
    public void pushCurrentListSizeNavigation(int n, int n2, int n3) {
    }

    @Override
    public void responseNavBookJobs(int n, int n2, int n3) {
    }

    @Override
    public void responseNotifyCurrentListSizesNavigation(boolean bl) {
    }

    @Override
    public void responseNotifyFavoriteDestList(boolean bl) {
    }

    @Override
    public void responseNotifyLastDestList(boolean bl) {
    }
}

