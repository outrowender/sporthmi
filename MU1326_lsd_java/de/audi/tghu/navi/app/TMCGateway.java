/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app;

import de.audi.atip.interapp.navtmc.TMCService;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.setup.IRouteCriteria;
import org.dsi.ifc.navigation.NavRouteListData;
import org.dsi.ifc.navigation.RgInfoForNextDestination;
import org.dsi.ifc.tmc.TmcMessage;

public final class TMCGateway
implements TMCService {
    private final NavigationEnv env;
    private TMCService service;
    private LogChannel logChannel;

    public TMCGateway(NavigationEnv navigationEnv) {
        this.env = navigationEnv;
        this.logChannel = navigationEnv.getLogChannel();
    }

    public void setService(TMCService tMCService) {
        this.service = tMCService;
    }

    public void propagateNaviState(IRouteCriteria iRouteCriteria, NavigationEnv navigationEnv, boolean bl) {
        int n;
        boolean bl2;
        if (this.service == null) {
            return;
        }
        if (navigationEnv.getFramework().isFrontMU()) {
            RgInfoForNextDestination rgInfoForNextDestination = navigationEnv.getContainer().getRgInfoForNextDestination();
            bl2 = navigationEnv.getContainer().isRgActive();
        } else {
            RgInfoForNextDestination rgInfoForNextDestination = navigationEnv.getRemoteContainer().getRgInfoForNextDestination();
            bl2 = navigationEnv.getRemoteContainer().isRgActive();
        }
        this.updateRgActive(bl2);
        int n2 = n = iRouteCriteria == null ? 0 : iRouteCriteria.getTrafficRerouting();
        if (n == 3) {
            n = 0;
        } else if (n == 4) {
            n = 1;
        } else if (n == 6) {
            n = 2;
        }
        this.updateTrafficRerouting(n);
        this.updateNaviFullyOperable(bl);
        this.refreshTimeToNextAnnouncement();
    }

    public int repeatOrAbortTmcMessageReadOutSince(long l) {
        int n = -1;
        if (this.service != null) {
            try {
                n = this.service.repeatOrAbortTmcMessageReadOutSince(l);
            }
            catch (Exception exception) {
                this.logChannel.log(100000, "TMCGateway#repeatOrAbortTmcMessageReadOutSince()", (Throwable)exception);
            }
        } else {
            this.logChannel.log(100000, "TMCGateway#repeatOrAbortTmcMessageReadOutSince() - service not registered! ");
        }
        return n;
    }

    public void updateDistanceToFinalDestination(int n) {
        if (this.service != null) {
            try {
                this.service.updateDistanceToFinalDestination(n);
            }
            catch (Exception exception) {
                this.logChannel.log(100000, "TMCGateway#updateDistanceToDestination()", (Throwable)exception);
            }
        } else {
            this.logChannel.log(100000, "TMCGateway#updateDistanceToDestination() - service not registered! ");
        }
    }

    public void updateTMCMapActive(boolean bl) {
        if (this.service != null) {
            try {
                this.service.updateTMCMapActive(bl);
            }
            catch (Exception exception) {
                this.logChannel.log(100000, "TMCGateway#updateTMCMapActive()", (Throwable)exception);
            }
        } else {
            this.logChannel.log(100000, "TMCGateway#updateTMCMapActive() - service not registered! ");
        }
    }

    public void updateRgActive(boolean bl) {
        if (this.service != null) {
            try {
                this.service.updateRgActive(bl);
            }
            catch (Exception exception) {
                this.logChannel.log(100000, "TMCGateway#updateRgActive()", (Throwable)exception);
            }
        } else {
            this.logChannel.log(100000, "TMCGateway#updateRgActive() - service not registered! ");
        }
    }

    public void updateRouteCriteria(IRouteCriteria iRouteCriteria) {
        int n = iRouteCriteria.getTrafficRerouting();
        if (n == 3) {
            this.updateTrafficRerouting(0);
        } else if (n == 4) {
            this.updateTrafficRerouting(1);
        } else if (n == 6) {
            this.updateTrafficRerouting(2);
        }
    }

    public void updateNaviFullyOperable(boolean bl) {
        if (this.service != null) {
            try {
                this.service.updateNaviFullyOperable(bl);
            }
            catch (Exception exception) {
                this.logChannel.log(100000, "TMCGateway#updateNaviFullyOperable()", (Throwable)exception);
            }
        } else {
            this.logChannel.log(100000, "TMCGateway#updateNaviFullyOperable() - service not registered! ");
        }
    }

    public void updateTimeToNextAnnouncement(long l) {
        if (!this.env.getFramework().isFrontMU()) {
            this.logChannel.log(10000000, "TMCGateway#updateTimeToNextAnnouncement() - only supported on front unit.");
            return;
        }
        if (this.service != null) {
            try {
                this.service.updateTimeToNextAnnouncement(l);
            }
            catch (Exception exception) {
                this.logChannel.log(100000, "TMCGateway#updateTimeToNextAnnouncement()", (Throwable)exception);
            }
        } else {
            this.logChannel.log(100000, "TMCGateway#updateTimeToNextAnnouncement() - service not registered! ");
        }
    }

    public void updateTrafficRerouting(int n) {
        if (this.service != null) {
            try {
                this.service.updateTrafficRerouting(n);
            }
            catch (Exception exception) {
                this.logChannel.log(100000, "TMCGateway#updateTrafficRerouting()", (Throwable)exception);
            }
        } else {
            this.logChannel.log(100000, "TMCGateway#updateTrafficRerouting() - service not registered! ");
        }
    }

    public void refreshTimeToNextAnnouncement() {
        if (!this.env.getFramework().isFrontMU()) {
            this.logChannel.log(10000000, "TMCGateway#refreshTimeToNextAnnouncement() - only supported on front unit.");
            return;
        }
        RgInfoForNextDestination rgInfoForNextDestination = this.env.getContainer().getRgInfoForNextDestination();
        long l = rgInfoForNextDestination != null ? rgInfoForNextDestination.getTimeToNextDest() : 0L;
        long l2 = this.env.getContainer().getRgTimeAfaToDestination();
        long l3 = l - l2;
        this.logChannel.log(10000000, "TMCGateway#refreshTimeToNextAnnouncement() - timeToNextAnnouncement: %1 ", l3 *= 1000L);
        this.updateTimeToNextAnnouncement(l3 > 0L ? l3 : 0L);
    }

    public void updateDynamicRgActive(boolean bl) {
    }

    public void showHideTMCPopup() {
        this.logChannel.log(10000000, "TMCGateway#showHideTMCPopup()");
        if (this.service != null) {
            try {
                this.service.showHideTMCPopup();
            }
            catch (Exception exception) {
                this.logChannel.log(100000, "TMCGateway#showHideTMCPopup()", (Throwable)exception);
            }
        } else {
            this.logChannel.log(100000, "TMCGateway#showHideTMCPopup() - service not registered! ");
        }
    }

    public void fillDetailScreen(TmcMessage tmcMessage) {
        this.logChannel.log(10000000, "TMCGateway#fillDetailScreen(%1)", (Object)tmcMessage);
        if (this.service != null) {
            try {
                this.service.fillDetailScreen(tmcMessage);
            }
            catch (Exception exception) {
                this.logChannel.log(100000, "TMCGateway#fillDetailScreen()", (Throwable)exception);
            }
        } else {
            this.logChannel.log(100000, "TMCGateway#fillDetailScreen() - service not registered! ");
        }
    }

    public void fillDetailScreen(TmcMessage tmcMessage, int n) {
        this.logChannel.log(10000000, "TMCGateway#fillDetailScreen(%1, %2)", (Object)tmcMessage, (long)n);
        if (this.service != null) {
            try {
                this.service.fillDetailScreen(tmcMessage, n);
            }
            catch (Exception exception) {
                this.logChannel.log(100000, "TMCGateway#fillDetailScreen()", (Throwable)exception);
            }
        } else {
            this.logChannel.log(100000, "TMCGateway#fillDetailScreen() - service not registered! ");
        }
    }

    public void setPreviewTrafficInfoTmcEvent(TmcMessage tmcMessage) {
        this.logChannel.log(10000000, "TMCGateway#focusPreviewMapOnTmcMessage(%1)", (Object)tmcMessage);
        if (this.service != null) {
            try {
                this.service.setPreviewTrafficInfoTmcEvent(tmcMessage);
            }
            catch (Exception exception) {
                this.logChannel.log(100000, "TMCGateway#focusPreviewMapOnTmcMessage()", (Throwable)exception);
            }
        } else {
            this.logChannel.log(100000, "TMCGateway#focusPreviewMapOnTmcMessage() - service not registered! ");
        }
    }

    public void setPreviewTrafficInfoTmcEvent(TmcMessage tmcMessage, int n) {
        this.setPreviewTrafficInfoTmcEvent(tmcMessage, n, true);
    }

    public void setPreviewTrafficInfoTmcEvent(TmcMessage tmcMessage, int n, boolean bl) {
        this.logChannel.log(10000000, "TMCGateway#focusPreviewMapOnTmcMessage() msg=%1 previewMapClientId=%2 isPreviewMapPositionRefreshActive=%3", (Object)tmcMessage, (Object)new Integer(n), (Object)new Boolean(bl));
        if (this.service != null) {
            try {
                this.service.setPreviewTrafficInfoTmcEvent(tmcMessage, n, bl);
            }
            catch (Exception exception) {
                this.logChannel.log(100000, "TMCGateway#focusPreviewMapOnTmcMessage()", (Throwable)exception);
            }
        } else {
            this.logChannel.log(100000, "TMCGateway#focusPreviewMapOnTmcMessage() - service not registered! ");
        }
    }

    public void updateRgDestinationInfo(NavRouteListData[] navRouteListDataArray) {
        this.logChannel.log(10000000, "TMCGateway#updateRgDestinationInfo()");
        if (this.service != null) {
            try {
                this.service.updateRgDestinationInfo(navRouteListDataArray);
            }
            catch (Exception exception) {
                this.logChannel.log(100000, "TMCGateway#updateRgDestinationInfo()", (Throwable)exception);
            }
        } else {
            this.logChannel.log(100000, "TMCGateway#updateRgDestinationInfo() - service not registered! ");
        }
    }

    public void updateIndexOfCurrentDestination(int n) {
        this.logChannel.log(10000000, "TMCGateway#updateIndexOfCurrentDestination() indexOfCurrentDestination:%1", (long)n);
        if (this.service != null) {
            try {
                this.service.updateIndexOfCurrentDestination(n);
            }
            catch (Exception exception) {
                this.logChannel.log(100000, "TMCGateway#updateIndexOfCurrentDestination()", (Throwable)exception);
            }
        } else {
            this.logChannel.log(100000, "TMCGateway#updateIndexOfCurrentDestination() - service not registered! ");
        }
    }

    public void updateSemidynamicRouteGuidance(long l, boolean bl, boolean bl2, int n) {
        this.logChannel.log(10000000, "TMCGateway#updateSemidynamicRouteGuidance()");
        if (this.service != null) {
            try {
                this.service.updateSemidynamicRouteGuidance(l, bl, bl2, n);
            }
            catch (Exception exception) {
                this.logChannel.log(100000, "TMCGateway#updateSemidynamicRouteGuidance()", (Throwable)exception);
            }
        } else {
            this.logChannel.log(100000, "TMCGateway#updateSemidynamicRouteGuidance() - service not registered! ");
        }
    }

    public void leaveMapSemidynamicRouteScreen() {
        this.logChannel.log(10000000, "TMCGateway#leaveMapSemidynamicRouteScreen()");
        if (this.service != null) {
            try {
                this.service.leaveMapSemidynamicRouteScreen();
            }
            catch (Exception exception) {
                this.logChannel.log(100000, "TMCGateway#leaveMapSemidynamicRouteScreen()", (Throwable)exception);
            }
        } else {
            this.logChannel.log(100000, "TMCGateway#leaveMapSemidynamicRouteScreen() - service not registered! ");
        }
    }

    public void showTMCWarningPopup() {
        this.logChannel.log(10000000, "TMCGateway#showTMCWarningPopup()");
        if (this.service != null) {
            try {
                this.service.showTMCWarningPopup();
            }
            catch (Exception exception) {
                this.logChannel.log(100000, "TMCGateway#showTMCWarningPopup()", (Throwable)exception);
            }
        } else {
            this.logChannel.log(100000, "TMCGateway#showTMCWarningPopup() - service not registered! ");
        }
    }

    public void updateTmcMessagesAhead(TmcMessage[] tmcMessageArray) {
        this.logChannel.log(10000000, "TMCGateway#updateTmcMessagesAhead(%1)", (Object)tmcMessageArray);
        if (this.service != null) {
            try {
                this.service.updateTmcMessagesAhead(tmcMessageArray);
            }
            catch (Exception exception) {
                this.logChannel.log(100000, "TMCGateway#updateTmcMessagesAhead()", (Throwable)exception);
            }
        } else {
            this.logChannel.log(100000, "TMCGateway#updateTmcMessagesAhead() - service not registered! ");
        }
    }
}

