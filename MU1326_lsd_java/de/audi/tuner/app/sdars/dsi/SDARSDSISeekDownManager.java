/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars.dsi;

import de.audi.atip.log.LogChannel;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.sdars.dsi.SDARSDsiDownInfo;
import de.audi.tuner.util.NullDSISDARSSeekService;
import java.util.ArrayList;
import java.util.Iterator;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.sdars.DSISDARSSeek;
import org.dsi.ifc.sdars.DSISDARSSeekListener;

public class SDARSDSISeekDownManager {
    private static final int[] LIST_ATTRIBUTE_NOTIFICATIONS = new int[]{6, 2};
    private static final int[] DEFAULT_NOTIFICATIONS = new int[]{6, 3, 2, 1};
    private DSISDARSSeek dsi;
    private final DSISDARSSeekListener dsiListener;
    private final LogChannel lc;
    private final ArrayList sdarsDsiDownListeners = new ArrayList(4);

    public SDARSDSISeekDownManager(TunerBasics tunerBasics, DSISDARSSeekListener dSISDARSSeekListener) {
        this.lc = tunerBasics.getLogger().sdarsSeekDSI;
        this.dsi = new NullDSISDARSSeekService(this.lc);
        this.dsiListener = dSISDARSSeekListener;
    }

    public void setDeviceService(DSISDARSSeek dSISDARSSeek) {
        if (dSISDARSSeek == null) {
            this.lc.log(-2137614336, "[SDARSDSISeekDownManager.setDeviceService] called with null argument!");
            this.dsi = new NullDSISDARSSeekService(this.lc);
        } else {
            this.dsi = dSISDARSSeek;
        }
    }

    public void register(SDARSDsiDownInfo sDARSDsiDownInfo) {
        this.sdarsDsiDownListeners.add(sDARSDsiDownInfo);
    }

    public boolean isDsiSeekFound() {
        return !(this.dsi instanceof NullDSISDARSSeekService);
    }

    public void initNotifications() {
        this.setNotification(DEFAULT_NOTIFICATIONS);
    }

    public void clearSeekListNotification() {
        this.lc.log(-2137614336, "[SDARSDSISeekDownManager.clearSeekListNotification]");
        this.dsi.clearNotification(2, (DSIListener)this.dsiListener);
    }

    public void setSeekListNotification() {
        this.lc.log(-2137614336, "[SDARSDSISeekDownManager.setSeekListNotification]");
        this.dsi.setNotification(2, (DSIListener)this.dsiListener);
    }

    public void setSeekPossibliltyNotification() {
        this.lc.log(-2137614336, "[SDARSDSISeekDownManager.setSeekPossibliltyNotification]");
        this.dsi.setNotification(1, (DSIListener)this.dsiListener);
    }

    public void setNotification(int[] nArray) {
        this.lc.log(-2137614336, "[SDARSDSISeekDownManager.setNotification] %1", (Object)nArray);
        this.dsi.setNotification(nArray, (DSIListener)this.dsiListener);
    }

    public void clearNotification(int[] nArray) {
        this.lc.log(-2137614336, "[SDARSDSISeekDownManager.clearNotification] %1", (Object)nArray);
        this.dsi.clearNotification(nArray, (DSIListener)this.dsiListener);
    }

    public void setSeekCommand(int n, int n2, int n3) {
        this.lc.log(-2137614336, "[SDARSDSISeekDownManager.setSeekCommand] sID %1, seekType %2, command %3", (long)n, (long)n2, (long)n3);
        this.dsi.setSeekCommand(n, n2, n3);
    }

    public void manageSeek(int n, int n2) {
        this.lc.log(-2137614336, "[SDARSDSISeekDownManager.manageSeek] seekID %1, action %2", (long)n, (long)n2);
        this.dsi.manageSeek(n, n2);
    }

    public void manageSeek2(int n, int n2, int n3, int n4) {
        this.lc.log(-2137614336, "[SDARSDSISeekDownManager.manageSeek2] typeOfContent %1, seekID %2, optID %3, action %4", (Object)String.valueOf(n), (Object)String.valueOf(n2), (Object)String.valueOf(n3), (Object)String.valueOf(n4));
        Iterator iterator = this.sdarsDsiDownListeners.iterator();
        while (iterator.hasNext()) {
            ((SDARSDsiDownInfo)iterator.next()).manageSeek2(n, n2, n3, n4);
        }
        this.dsi.manageSeek2(n, n2, n3, n4);
    }

    public void bulkManageSeek2(int n, int[] nArray, int[] nArray2, int n2) {
        this.lc.log(-2137614336, "[SDARSDSISeekDownManager.bulkManageSeek2] typeOfContent %1, seekIDs %2, optIDs %3, action %4", (Object)String.valueOf(n), (Object)nArray, (Object)nArray2, (Object)String.valueOf(n2));
        Iterator iterator = this.sdarsDsiDownListeners.iterator();
        while (iterator.hasNext()) {
            ((SDARSDsiDownInfo)iterator.next()).bulkManageSeek2(n, nArray, nArray2, n2);
        }
        this.clearNotification(LIST_ATTRIBUTE_NOTIFICATIONS);
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            this.dsi.manageSeek2(n, nArray[i2], nArray2[i2], n2);
        }
        this.setNotification(LIST_ATTRIBUTE_NOTIFICATIONS);
    }

    public void getTeamsOfLeague(int n) {
        this.lc.log(-2137614336, "[SDARSDSISeekDownManager.getTeamsOfLeague] leagueID %1", (long)n);
        this.dsi.getTeamsOfLeague(n);
    }

    public void getLeagues() {
        this.lc.log(-2137614336, "[SDARSDSISeekDownManager.getLeagues]");
        this.dsi.getLeagues();
    }

    public void reset(int n) {
        this.lc.log(-2137614336, "[SDARSDSISeekDownManager.reset] resetSeekType %1", (long)n);
        this.dsi.reset(n);
    }
}

