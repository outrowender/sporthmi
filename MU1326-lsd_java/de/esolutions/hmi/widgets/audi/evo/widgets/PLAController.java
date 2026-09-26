/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.hmi.event.KeyEvent;
import de.audi.atip.hmi.event.RunnableEvent;
import de.audi.atip.hmi.event.WheelButtonEvent;
import de.audi.atip.interapp.earlyfunc.core.parking.pla.IPLAInterappService;
import de.audi.atip.interapp.earlyfunc.core.parking.pla.IPLAStatus;
import de.audi.atip.interapp.earlyfunc.core.parking.pla.IPLAStatusCallbackListener;
import de.audi.atip.interapp.earlyfunc.core.parking.pla.IPLAStatusListener;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.evo.widgets.OPSController;
import de.esolutions.hmi.widgets.audi.evo.widgets.PLAController$1;
import de.esolutions.hmi.widgets.audi.evo.widgets.PLAController$2;
import java.util.Arrays;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class PLAController
implements IPLAStatusListener,
IWidgetLogChannel {
    private ServiceTracker serviceTracker;
    private IPLAInterappService plaInterApp;
    private int plaMode;
    private IPLAStatus plaStatus;
    private IPLAStatusCallbackListener listener;
    private OPSController opsController;
    private static final int TOOLBAR_POSITION_DISABLED;
    private static final int TOOLBAR_POSITION_ENABLED;
    private int[] toolbarPositions = new int[6];
    private int cursorPosition = 0;
    static /* synthetic */ Class class$de$audi$atip$interapp$earlyfunc$core$parking$pla$IPLAInterappService;

    public PLAController(OPSController oPSController) {
        this.opsController = oPSController;
    }

    public void initTracker() {
        this.serviceTracker = new ServiceTracker(AbstractWidget.widgetsActivator.getBundleContext(), (class$de$audi$atip$interapp$earlyfunc$core$parking$pla$IPLAInterappService == null ? (class$de$audi$atip$interapp$earlyfunc$core$parking$pla$IPLAInterappService = PLAController.class$("de.audi.atip.interapp.earlyfunc.core.parking.pla.IPLAInterappService")) : class$de$audi$atip$interapp$earlyfunc$core$parking$pla$IPLAInterappService).getName(), (ServiceTrackerCustomizer)new PLAController$1(this));
        this.serviceTracker.open();
    }

    @Override
    public void updatePLAStatusStandbyMode(IPLAStatus iPLAStatus) {
        logChannelParking.log(-2137614336, "updatePLAStatusStandbyMode status=%1", (Object)iPLAStatus);
        this.updateData(6, iPLAStatus);
    }

    @Override
    public void updatePLAStatusSearchMode(IPLAStatus iPLAStatus) {
        logChannelParking.log(-2137614336, "updatePLAStatusSearchMode status=%1", (Object)iPLAStatus);
        this.updateData(1, iPLAStatus);
    }

    @Override
    public void updatePLAStatusInSelectionMode(IPLAStatus iPLAStatus) {
        logChannelParking.log(-2137614336, "updatePLAStatusInSelectionMode status=%1", (Object)iPLAStatus);
        this.updateData(2, iPLAStatus);
    }

    @Override
    public void updatePLAStatusOutSelectionMode(IPLAStatus iPLAStatus) {
        logChannelParking.log(-2137614336, "updatePLAStatusOutSelectionMode status=%1", (Object)iPLAStatus);
        this.updateData(3, iPLAStatus);
    }

    @Override
    public void registerCallbackListener(IPLAStatusCallbackListener iPLAStatusCallbackListener) {
        logChannelParking.log(-2137614336, "registerCallbackListener listener=%1", (Object)iPLAStatusCallbackListener);
        this.listener = iPLAStatusCallbackListener;
    }

    @Override
    public void unregisterCallbackListener(IPLAStatusCallbackListener iPLAStatusCallbackListener) {
        logChannelParking.log(-2137614336, "unregisterCallbackListener listener=%1", (Object)iPLAStatusCallbackListener);
        this.listener = null;
    }

    private void updateData(int n, IPLAStatus iPLAStatus) {
        AbstractWidget.hmiService.getEventDispatcher().postEvent(new RunnableEvent(true, new PLAController$2(this, iPLAStatus, n)));
    }

    public IPLAStatus getPLAStatus() {
        return this.plaStatus;
    }

    public int getPLAMode() {
        return this.plaMode;
    }

    public int[] getToolbarPositions() {
        return this.toolbarPositions;
    }

    public int getCursorPosition() {
        return this.cursorPosition;
    }

    private void setCursorPositions(IPLAStatus iPLAStatus) {
        IPLAStatus iPLAStatus2 = null;
        if (!(iPLAStatus instanceof IPLAStatus)) {
            return;
        }
        iPLAStatus2 = iPLAStatus;
        Arrays.fill(this.toolbarPositions, 0);
        if (iPLAStatus2.isForwardParkboxSlotFound()) {
            if (iPLAStatus.getActiveSide() == 1) {
                this.toolbarPositions[4] = 1;
            } else {
                this.toolbarPositions[1] = 1;
            }
        }
        if (iPLAStatus2.isBackwardParkboxSlotFound()) {
            if (iPLAStatus.getActiveSide() == 1) {
                this.toolbarPositions[5] = 1;
            } else {
                this.toolbarPositions[2] = 1;
            }
        }
        if (iPLAStatus2.isBackwardParallelToRoadSlotFound()) {
            if (iPLAStatus.getActiveSide() == 1) {
                this.toolbarPositions[3] = 1;
            } else {
                this.toolbarPositions[0] = 1;
            }
        }
        this.setCurrentCursorPosition(iPLAStatus2);
    }

    private void setCurrentCursorPosition(IPLAStatus iPLAStatus) {
        if (iPLAStatus.getPreSelection() == -1) {
            this.cursorPosition = -1;
            return;
        }
        int n = iPLAStatus.getPreSelection();
        this.cursorPosition = this.toolbarPositions[n] == 1 ? n : -1;
    }

    public void keyTurned(WheelButtonEvent wheelButtonEvent) {
        block3: {
            int n;
            block4: {
                if (this.plaMode != 2) {
                    return;
                }
                n = this.cursorPosition;
                if (wheelButtonEvent.getKeyCode() != 17 || wheelButtonEvent.getDirection() != 1) break block4;
                while (n >= 1) {
                    if (this.toolbarPositions[--n] != 1) continue;
                    this.cursorPosition = n;
                    this.listener.updateFocusedSpotInSelectionMode(this.plaStatus.getActiveSide(), this.cursorPosition);
                    break block3;
                }
                break block3;
            }
            if (wheelButtonEvent.getKeyCode() != 17 || wheelButtonEvent.getDirection() != 0) break block3;
            while (n < this.toolbarPositions.length - 1) {
                if (this.toolbarPositions[++n] != 1) continue;
                this.cursorPosition = n;
                this.listener.updateFocusedSpotInSelectionMode(this.plaStatus.getActiveSide(), this.cursorPosition);
                break;
            }
        }
    }

    public void keyPressed(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 17) {
            if (this.plaMode == 2 && this.cursorPosition != -1) {
                this.listener.updateSelectedSpotInSelectionMode(this.plaStatus.getActiveSide(), this.cursorPosition);
            } else if (this.plaMode == 3) {
                int n = -1;
                if (this.plaStatus.getActiveSide() == 1) {
                    n = 3;
                } else if (this.plaStatus.getActiveSide() == 2) {
                    n = 0;
                }
                this.listener.updateSelectedSpotOutSelectionMode(this.plaStatus.getActiveSide(), n);
            }
        }
    }

    @Override
    public void updatePLAStatusIdleMode() {
        logChannelParking.log(-2137614336, "updatePLAStatusIdleMode");
        if (null != this.plaInterApp) {
            IPLAStatus iPLAStatus = this.plaInterApp.getDefaultPLAStatus();
            this.updateData(0, iPLAStatus);
        }
    }

    @Override
    public void updatePLAStatusParkInActive(IPLAStatus iPLAStatus) {
        logChannelParking.log(-2137614336, "updatePLAStatusStandbyMode status=%1", (Object)iPLAStatus);
    }

    @Override
    public void updatePLAStatusParkOutActive(IPLAStatus iPLAStatus) {
        logChannelParking.log(-2137614336, "updatePLAStatusStandbyMode status=%1", (Object)iPLAStatus);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ IPLAInterappService access$002(PLAController pLAController, IPLAInterappService iPLAInterappService) {
        pLAController.plaInterApp = iPLAInterappService;
        return pLAController.plaInterApp;
    }

    static /* synthetic */ IPLAInterappService access$000(PLAController pLAController) {
        return pLAController.plaInterApp;
    }

    static /* synthetic */ void access$100(PLAController pLAController, IPLAStatus iPLAStatus) {
        pLAController.setCursorPositions(iPLAStatus);
    }

    static /* synthetic */ int access$202(PLAController pLAController, int n) {
        pLAController.plaMode = n;
        return pLAController.plaMode;
    }

    static /* synthetic */ IPLAStatus access$302(PLAController pLAController, IPLAStatus iPLAStatus) {
        pLAController.plaStatus = iPLAStatus;
        return pLAController.plaStatus;
    }

    static /* synthetic */ OPSController access$400(PLAController pLAController) {
        return pLAController.opsController;
    }
}

