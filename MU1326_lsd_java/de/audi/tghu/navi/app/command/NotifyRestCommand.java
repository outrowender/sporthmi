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
import org.dsi.ifc.navigation.Route;

public class NotifyRestCommand
extends DelayCommand {
    public static final long MAX_WAIT_DELAY = 30000L;
    private static final int[] NAV_ATTRIBUTES = new int[]{1, 2, 4, 5, 6, 7, 8, 9, 10, 94, 11, 13, 14, 64, 21, 22, 23, 24, 25, 29, 31, 32, 28, 34, 37, 38, 39, 42, 43, 45, 46, 47, 48, 49, 54, 57, 61, 95, 62, 63, 65, 66, 93, 67, 68, 69, 70, 84, 81, 75, Util.useDSIUpdateBapManeuverInformation() ? 106 : 76, 77, 78, 81, 82, 85, 86, 88, 89, 91, 92, 104};
    private static final int[] BLK_ATTRIBUTES = new int[]{2, 6, 8, 3, 5, 4, 7, 1};
    private static final int[] CRL_ATTRIBUTES = new int[]{1};
    private boolean rgActiveReported;
    private boolean lispIsSpellerActiveReported;
    private boolean etcDemoModeStateReported;
    private boolean rmPersistentRouteReported;

    public NotifyRestCommand() {
        super(30000L);
    }

    public long getTimeout() {
        return -1L;
    }

    public void execute() {
        NavigationStartup navigationStartup = this.navigation.getNavigationStartup();
        if (navigationStartup.isNotificationSet()) {
            this.logger.log(1000000, "NotifyRestCommand#execute() - notification already set.");
            this.getCommandList().commandFinished();
        } else {
            this.logger.log(10000000, "NotifyRestCommand#execute() - calling setNotification() and starting wait timer...");
            this.getDSINavigation().setNotification(NAV_ATTRIBUTES, (DSIListener)this.getDispatcher());
            if (Util.isPartialMapUpdateAvailable()) {
                this.getDSINavigation().setNotification(102, (DSIListener)this.getDispatcher());
            }
            this.getDSIBlocking().setNotification(BLK_ATTRIBUTES, (DSIListener)this.getDispatcher());
            navigationStartup.setNotificationSet(true);
            super.execute();
        }
    }

    private void checkFinished() {
        if (this.rgActiveReported && this.lispIsSpellerActiveReported && this.etcDemoModeStateReported && this.rmPersistentRouteReported) {
            this.timer.cancel();
            Util.logStartupEvent(this.env.getFramework(), "[Startup] NotifyRestCommand#checkFinished() - main notifications received! ");
            this.navigation.getOperationManager().taskCompleted(3);
            this.getCommandList().commandFinished();
        }
    }

    public void fireTimer(Timer timer) {
        this.logger.log(10000000, "NotifyRestCommand#fireTimer() ");
        if (timer == this.timer) {
            String string = this.printNotificationStatus();
            this.logger.log(100000, "NotifyRestCommand#fireTimer() - Still waiting for some notifications after %2ms! %1 ", (Object)string, 30000L);
            System.err.println("NotifyRestCommand#fireTimer() - Still waiting for some notifications after 30000ms!");
            System.err.println(string);
        }
    }

    private String printNotificationStatus() {
        return new Buffer().append("\n\t").append("rgActiveReported: ").append(this.rgActiveReported).append("\n\t").append("lispIsSpellerActiveReported: ").append(this.lispIsSpellerActiveReported).append("\n\t").append("etcDemoModeStateReported: ").append(this.etcDemoModeStateReported).append("\n\t").append("rmPersistentRouteReported: ").append(this.rmPersistentRouteReported).toString();
    }

    public void updateRmPersistentRoute(Route route) {
        super.updateRmPersistentRoute(route);
        this.rmPersistentRouteReported = true;
        Util.logStartupEvent(this.env.getFramework(), "[Startup] NotifyRestCommand#updateRmPersistentRoute()");
        this.checkFinished();
    }

    public void updateEtcDemoModeState(boolean bl) {
        super.updateEtcDemoModeState(bl);
        this.etcDemoModeStateReported = true;
        Util.logStartupEvent(this.env.getFramework(), "[Startup] NotifyRestCommand#updateEtcDemoModeState()");
        this.checkFinished();
    }

    public void updateLispIsSpellerActive(boolean bl) {
        super.updateLispIsSpellerActive(bl);
        this.lispIsSpellerActiveReported = true;
        Util.logStartupEvent(this.env.getFramework(), "[Startup] NotifyRestCommand#updateLispIsSpellerActive()");
        this.checkFinished();
    }

    public void updateRgActive(boolean bl) {
        super.updateRgActive(bl);
        this.rgActiveReported = true;
        Util.logStartupEvent(this.env.getFramework(), "[Startup] NotifyRestCommand#updateRgActive()");
        this.checkFinished();
    }
}

