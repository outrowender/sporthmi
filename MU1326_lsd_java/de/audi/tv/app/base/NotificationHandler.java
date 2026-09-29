/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.base;

import de.audi.atip.log.LogChannel;
import de.audi.tv.app.base.INotificationHandler;
import de.audi.tv.app.base.NotificationHandler$TVListener;
import de.audi.tv.app.dsi.DSIHandler;
import de.audi.tv.app.dsi.DSITVTunerListenerImpl;
import de.audi.tv.app.dsi.DefaultTVListener;
import de.audi.tv.app.dsi.NullDSITVTuner;
import de.esolutions.fw.util.commons.IntList;
import org.dsi.ifc.tvtuner.DSITVTuner;
import org.dsi.ifc.tvtuner.StartUpConfig;

public class NotificationHandler
implements INotificationHandler {
    private final LogChannel lc;
    private final DSIHandler dsiHandler;
    private final DSITVTunerListenerImpl listener;
    final DefaultTVListener tvListener = new NotificationHandler$TVListener(this, null);
    private boolean dsiRegistered = false;

    NotificationHandler(LogChannel logChannel, DSIHandler dSIHandler, DSITVTunerListenerImpl dSITVTunerListenerImpl) {
        this.lc = logChannel;
        this.dsiHandler = dSIHandler;
        this.listener = dSITVTunerListenerImpl;
    }

    void setNotifications(DSITVTuner dSITVTuner) {
        boolean bl = this.dsiRegistered = !(dSITVTuner instanceof NullDSITVTuner);
        if (this.dsiRegistered) {
            int[] nArray = new int[]{1, 16, 17};
            this.lc.log(1078071040, "[NotificationHandler.setNotifications] set base notifications: %1", (Object)nArray);
            this.dsiHandler.setNotification(nArray, this.listener);
        }
    }

    @Override
    public void setNotification(int n) {
        this.setNotification(n, false);
    }

    @Override
    public void setNotification(int n, boolean bl) {
        if (!this.dsiRegistered) {
            this.lc.log(-1601830656, "[NotificationHandler.setNotification] No DSI registered! ");
        } else if (bl && this.dsiHandler.isBlocked()) {
            this.lc.log(-1601830656, "[NotificationHandler.setNotification] Ignore notification for attr %1, DSI is blocked!", (long)n);
        } else {
            this.lc.log(1078071040, "[NotificationHandler.setNotification] set notification for attribute: %1", (long)n);
            this.dsiHandler.setNotification(new int[]{n}, this.listener);
        }
    }

    @Override
    public void clearNotification(int n) {
        if (this.dsiRegistered) {
            this.lc.log(1078071040, "[NotificationHandler.clearNotification] set notification for attribute: %1", (long)n);
            this.dsiHandler.clearNotification(new int[]{n}, this.listener);
        }
    }

    private int[] getFullNotifications(StartUpConfig startUpConfig) {
        IntList intList = new IntList();
        if (startUpConfig.avNormAvail) {
            intList.add(10);
        }
        if (startUpConfig.browserListSortAvail) {
            intList.add(22);
        }
        if (startUpConfig.casAvail) {
            intList.add(19);
        }
        if (startUpConfig.linkingAvail) {
            intList.add(8);
        }
        if (startUpConfig.subtitleAvail) {
            intList.add(9);
        }
        if (startUpConfig.logoListAvail) {
            intList.add(21);
        }
        if (startUpConfig.ewsAvail) {
            intList.add(15);
        }
        if (startUpConfig.tvNormAvail) {
            intList.add(11);
            intList.add(13);
            intList.add(12);
        }
        intList.add(6);
        intList.add(5);
        intList.add(4);
        intList.add(2);
        intList.add(3);
        intList.add(14);
        intList.add(20);
        intList.add(18);
        return intList.toArray();
    }

    static /* synthetic */ boolean access$100(NotificationHandler notificationHandler) {
        return notificationHandler.dsiRegistered;
    }

    static /* synthetic */ int[] access$200(NotificationHandler notificationHandler, StartUpConfig startUpConfig) {
        return notificationHandler.getFullNotifications(startUpConfig);
    }

    static /* synthetic */ LogChannel access$300(NotificationHandler notificationHandler) {
        return notificationHandler.lc;
    }

    static /* synthetic */ DSITVTunerListenerImpl access$400(NotificationHandler notificationHandler) {
        return notificationHandler.listener;
    }

    static /* synthetic */ DSIHandler access$500(NotificationHandler notificationHandler) {
        return notificationHandler.dsiHandler;
    }
}

