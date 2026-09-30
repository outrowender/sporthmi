/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command;

import de.audi.atip.timer.Timer;
import de.audi.tghu.navi.app.NavigationStartup;
import de.audi.tghu.navi.app.command.DelayCommand;
import de.audi.tghu.navi.app.util.Util;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.navigation.PosPosition;
import org.dsi.ifc.navigation.Route;

public class NotifyRemoteCommand
extends DelayCommand {
    public static final long MAX_WAIT_DELAY = 30000L;
    private static final int[] NAV_ATTRIBUTES = new int[]{57, 75, 11, 23, Util.useDSIUpdateBapManeuverInformation() ? 106 : 76, 25, 54, 38, 84, 28, 29};
    private boolean rgActiveReported;
    private boolean rmPersistentRouteReported;
    private boolean soPosPositionReported;

    public NotifyRemoteCommand() {
        super(30000L);
    }

    public long getTimeout() {
        return -1L;
    }

    public void execute() {
        NavigationStartup navigationStartup = this.navigation.getNavigationStartup();
        if (navigationStartup.isNotificationSet()) {
            this.logger.log(1000000, "NotifyRemoteCommand#execute() - notification already set.");
            this.getCommandList().commandFinished();
        } else {
            this.logger.log(10000000, "NotifyRemoteCommand#execute() - calling setNotification( %1 ) and starting wait timer..", (long)NAV_ATTRIBUTES.length);
            this.getDSINavigation().setNotification(NAV_ATTRIBUTES, (DSIListener)this.getDispatcher());
            navigationStartup.setNotificationSet(true);
            super.execute();
        }
    }

    private void checkFinished() {
        if (this.rgActiveReported && this.rmPersistentRouteReported && this.soPosPositionReported) {
            this.timer.cancel();
            Util.logStartupEvent(this.env.getFramework(), "NotifyRemoteCommand#checkFinished() - main remote notifications received!");
            this.navigation.getOperationManager().taskCompleted(3);
            this.getCommandList().commandFinished();
        }
    }

    public void fireTimer(Timer timer) {
        this.logger.log(10000000, "NotifyRemoteCommand#fireTimer()");
        if (timer == this.timer) {
            String string = this.printNotificationStatus();
            this.logger.log(100000, "NotifyRestCommand#fireTimer() - Still waiting for some notifications after %2ms! %1 ", (Object)string, 30000L);
            System.err.println("NotifyRemoteCommand#fireTimer() - Still waiting for some notifications after 30000ms!");
            System.err.println(string);
        }
    }

    private String printNotificationStatus() {
        return new Buffer().append("rgActiveReported: ").append(this.rgActiveReported).append("\n\t").append("rmPersistentRouteReported: ").append(this.rmPersistentRouteReported).append("\n\t").append("soPosPositionReported: ").append(this.soPosPositionReported).toString();
    }

    public void updateRmPersistentRoute(Route route) {
        super.updateRmPersistentRoute(route);
        this.rmPersistentRouteReported = true;
        this.checkFinished();
    }

    public void updateRgActive(boolean bl) {
        super.updateRgActive(bl);
        this.rgActiveReported = true;
        this.checkFinished();
    }

    public void updateSoPosPosition(PosPosition posPosition) {
        super.updateSoPosPosition(posPosition);
        this.soPosPositionReported = true;
        this.checkFinished();
    }
}

