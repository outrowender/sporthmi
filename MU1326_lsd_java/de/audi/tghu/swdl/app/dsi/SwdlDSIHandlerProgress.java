/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.dsi;

import de.audi.tghu.swdl.app.AbstractSwdlJoinedDownloadState;
import de.audi.tghu.swdl.app.SwdlEnv;
import de.audi.tghu.swdl.app.dsi.AbstractSwdlDSIHandler;
import de.audi.tghu.swdl.app.hmiswitcher.manager.IProgressManager;
import org.dsi.ifc.swdlprogress.DSISwdlProgress;
import org.dsi.ifc.swdlprogress.DSISwdlProgressListener;
import org.dsi.ifc.swdlprogress.DeviceOverviewProgress;
import org.dsi.ifc.swdlprogress.GeneralProgress;

public class SwdlDSIHandlerProgress
extends AbstractSwdlDSIHandler
implements DSISwdlProgressListener {
    private static final String CLASSNAME;
    private static final int SWDL_AUTO_RETRIES;
    private int autoRetryCounter = 0;
    private final AbstractSwdlJoinedDownloadState swdlJoinedDownloadState;
    private boolean ignoreFirstOverviewProgress = false;
    protected IProgressManager progressManager = null;
    int latestPanel = -1;

    SwdlDSIHandlerProgress(SwdlEnv swdlEnv, AbstractSwdlJoinedDownloadState abstractSwdlJoinedDownloadState) {
        super("SwdlDSIHandlerProgress", swdlEnv);
        this.swdlJoinedDownloadState = abstractSwdlJoinedDownloadState;
    }

    private DSISwdlProgress getDSISwdlProgress() {
        return (DSISwdlProgress)this.getDSI();
    }

    private String getDlProgressAsText(int n) {
        return this.getTextFactory().getDlProgressAsText(n);
    }

    public void setProgressManager(IProgressManager iProgressManager) {
        this.progressManager = iProgressManager;
    }

    public void startProgressUpdates() {
        this.getLogDSI().log(1078071040, "%1 startProgressUpdates() ", (Object)"[SwdlDSIHandlerProgress]");
        if (this.getSwdlEnv().isCustomerDownloadActive()) {
            this.ignoreFirstOverviewProgress = true;
            this.setNotification(new int[]{2});
        } else {
            this.ignoreFirstOverviewProgress = false;
            this.setNotification(new int[]{1, 2, 5, 6});
        }
    }

    public void stopProgressUpdates() {
        this.getLogDSI().log(1078071040, "%1 stopProgressUpdates() ", (Object)"[SwdlDSIHandlerProgress]");
        this.clearNotification(new int[]{1, 2, 5, 6});
    }

    public void startReadMetadataProgressUpdate() {
        this.getLogDSI().log(1078071040, "%1 startReadMetadataProgressUpdate() ", (Object)"[SwdlDSIHandlerProgress]");
        this.setNotification(new int[]{2});
    }

    public void stopReadMetadataProgressUpdate() {
        this.getLogDSI().log(1078071040, "%1 stopReadMetadataProgressUpdate() ", (Object)"[SwdlDSIHandlerProgress]");
        this.clearNotification(new int[]{2});
    }

    public void notifyForUpdateDetails(String string) {
        this.getLogDSI().log(-2137614336, "%1 -> getProgressDetails( %2 )", (Object)"[SwdlDSIHandlerProgress]", (Object)string);
        this.getDSISwdlProgress().getProgressDetails(string);
    }

    public void startPanelNotification() {
        this.getLogDSI().log(1078071040, "%1 startPanelNotification() ", (Object)"[SwdlDSIHandlerProgress]");
        this.setNotification(new int[]{3});
    }

    public void stopPanelNotification() {
    }

    public void startLostDeviceNotification() {
        this.getLogDSI().log(1078071040, "%1 startLostDeviceNotification() ", (Object)"[SwdlDSIHandlerProgress]");
        this.setNotification(new int[]{4});
    }

    public void stopLostDeviceNotification() {
        this.getLogDSI().log(1078071040, "%1 stopLostDeviceNotification() ", (Object)"[SwdlDSIHandlerProgress]");
        this.clearNotification(new int[]{4});
    }

    public void doHandleMediumSelection(int n, String string, byte by, int n2) {
        this.getLogDSI().log(-2137614336, "[SwdlProgressDSIHandler] -> handleMediumSelection( popup=%2, id=%1, medium=%3, selection=%4 )", (Object)string, (Object)new Integer(n), (Object)new Integer(by), (long)n2);
        this.getDSISwdlProgress().handleMediumSelection(n, string, by, n2);
    }

    public void doHandleUserSelection(int n, String string, int n2) {
        this.getLogDSI().log(-2137614336, "%1 -> handleUserSelection( popup=%3, id=%2, selection=%4 ) ", (Object)"[SwdlDSIHandlerProgress]", (Object)string, (Object)new Integer(n), (long)n2);
        this.getDSISwdlProgress().handleUserSelection(n, string, n2);
    }

    @Override
    public void updateGeneralProgress(GeneralProgress generalProgress, int n) {
        if (n == 1) {
            try {
                this.getLogDSI().log(1078071040, "%1 <- updateGeneralProgress: %2 ", (Object)"[SwdlDSIHandlerProgress]", (Object)generalProgress);
                if (generalProgress != null) {
                    this.progressManager.updateGeneralProgress(generalProgress);
                }
            }
            catch (Exception exception) {
                this.dsiCallbackError("updateGeneralProgress", exception);
            }
        } else {
            this.getLogDSI().log(1078071040, "%1 <- Invalid updateGeneralProgress: %2 ", (Object)"[SwdlDSIHandlerProgress]", (Object)generalProgress);
        }
    }

    @Override
    public void updateDevicesOverviewProgress(DeviceOverviewProgress[] deviceOverviewProgressArray, int n) {
        block10: {
            StringBuffer stringBuffer = new StringBuffer();
            if (deviceOverviewProgressArray == null) {
                deviceOverviewProgressArray = new DeviceOverviewProgress[]{};
            } else if (this.getLogDSI().getCurrentLogThreshold() == -2137614336) {
                stringBuffer.append(':');
                for (int i2 = 0; i2 < deviceOverviewProgressArray.length; ++i2) {
                    if (i2 > 0) {
                        stringBuffer.append(';');
                    }
                    stringBuffer.append(deviceOverviewProgressArray[i2]);
                }
            }
            if (n == 1) {
                try {
                    if (this.ignoreFirstOverviewProgress) {
                        this.getLogDSI().log(1078071040, "%1 <- updateDevicesOverviewProgress%2 : ignore this progress, becase it contains the previous attribute value ", (Object)"[SwdlDSIHandlerProgress]", (Object)stringBuffer);
                        this.ignoreFirstOverviewProgress = false;
                        break block10;
                    }
                    this.getLogDSI().log(1078071040, "%1 <- updateDevicesOverviewProgress%2", (Object)"[SwdlDSIHandlerProgress]", (Object)stringBuffer);
                    this.progressManager.updateDevicesOverviewProgress(deviceOverviewProgressArray);
                }
                catch (Exception exception) {
                    this.dsiCallbackError("updateDevicesOverviewProgress", exception);
                }
            } else {
                this.getLogDSI().log(1078071040, "%1 <- Invalid updateDevicesOverviewProgress%2 ", (Object)"[SwdlDSIHandlerProgress]", (Object)stringBuffer);
            }
        }
    }

    public int getLatestPanel() {
        return this.latestPanel;
    }

    @Override
    public void updateTriggerPanel(int n, int n2) {
        if (n2 == 1) {
            this.latestPanel = n;
            this.getLogDSI().log(1078071040, "%1 <- updateTriggerPanel: %2 ", (Object)"[SwdlDSIHandlerProgress]", (long)n);
            try {
                this.progressManager.triggerPanel(n);
            }
            catch (Exception exception) {
                this.dsiCallbackError("updateTriggerPanel", exception);
            }
        } else {
            this.getLogDSI().log(1078071040, "%1 <- Invalid updateTriggerPanel: %2 ", (Object)"[SwdlDSIHandlerProgress]", (long)n);
        }
    }

    @Override
    public void updateLostDevices(String[] stringArray, int n) {
        if (n == 1) {
            try {
                if (stringArray == null) {
                    stringArray = EMPTY_STRING_ARRAY;
                }
                this.getLogDSI().log(1078071040, "%1 <- updateLostDevices: %2 ", (Object)"[SwdlDSIHandlerProgress]", (Object)stringArray);
                this.progressManager.updateLostDevices(stringArray);
            }
            catch (Exception exception) {
                this.dsiCallbackError("updateLostDevices", exception);
            }
        } else {
            this.getLogDSI().log(1078071040, "%1 <- Invalid updateLostDevices: %2 ", (Object)"[SwdlDSIHandlerProgress]", (Object)stringArray);
        }
    }

    @Override
    public void getStaticProgressDetails(int n, int n2, short s, String string) {
        try {
            this.getLogDSI().log(1078071040, "%1 <- getStaticProgressDetails: %2 %3 %4", (Object)"[SwdlDSIHandlerProgress]", (Object)string, (Object)new Integer(n), (long)n2);
            this.getLogDSI().log(1078071040, "%1 \t\t\thwInstance %2", (Object)"[SwdlDSIHandlerProgress]", (long)s);
            this.progressManager.updateStaticProgressDetails(n, n2, s, string);
        }
        catch (Exception exception) {
            this.dsiCallbackError("getStaticProgressDetails", exception);
        }
    }

    @Override
    public void getDynamicProgressDetails(int n, byte by, String string) {
        try {
            this.getLogDSI().log(1078071040, "%1 <- getDynamicProgressDetails: %3 %4 %2 ", (Object)"[SwdlDSIHandlerProgress]", (Object)string, (Object)new Integer(n), (long)by);
            this.progressManager.updateDynamicProgressDetails(n != 8 ? this.getDlProgressAsText(n) : string, by);
        }
        catch (Exception exception) {
            this.dsiCallbackError("getDynamicProgressDetails", exception);
        }
    }

    @Override
    public void indicatePopUp(int n, String string, byte by, int n2, int n3, String string2) {
        try {
            this.getLogDSI().log(1078071040, "%1 <- indicatePopUp: id: %2 popUp: %3 prio: %4 ", (Object)"[SwdlDSIHandlerProgress]", (Object)string, (Object)new Integer(n), (long)by);
            this.getLogDSI().log(1078071040, "%1 Error Info: %3 %4 %2 ", (Object)"[SwdlDSIHandlerProgress]", (Object)string2, (Object)new Integer(n2), (long)n3);
            if ((n == 2 || n == 3 || n == 4 || n == 5 || n == 7 || n == 10 || n == 22) && this.autoRetryCounter < SWDL_AUTO_RETRIES) {
                this.getLogDSI().log(1078071040, "%1 Perform auto retry (current retries: %2, max retries: %3).", (Object)"[SwdlDSIHandlerProgress]", (long)this.autoRetryCounter, (long)SWDL_AUTO_RETRIES);
                ++this.autoRetryCounter;
                this.doHandleUserSelection(n, string, 3);
            } else {
                if (n == 12) {
                    this.swdlJoinedDownloadState.startJoinedDownload();
                }
                this.progressManager.indicatePopUp(n, string, by, n2, n3, string2);
            }
        }
        catch (Exception exception) {
            this.dsiCallbackError("indicatePopUp", exception);
        }
    }

    @Override
    public void indicateDismissPopUp(int n, String string) {
        try {
            this.getLogDSI().log(1078071040, "%1 <- indicateDismissPopUp: popUp: %3 id: %2 ", (Object)"[SwdlDSIHandlerProgress]", (Object)string, (long)n);
            this.progressManager.indicateDismissPopUp(n, string);
        }
        catch (Exception exception) {
            this.dsiCallbackError("indicateDismissPopUp", exception);
        }
    }

    @Override
    public void updateActiveDevices(String[] stringArray, int n) {
        if (n == 1) {
            try {
                if (stringArray == null) {
                    stringArray = EMPTY_STRING_ARRAY;
                }
                this.getLogDSI().log(1078071040, "%1 <- updateActiveDevices: %2 ", (Object)"[SwdlDSIHandlerProgress]", (Object)stringArray);
                this.progressManager.updateActiveDevices(stringArray);
            }
            catch (Exception exception) {
                this.dsiCallbackError("updateActiveDevices", exception);
            }
        } else {
            this.getLogDSI().log(1078071040, "%1 <- Invalid updateActiveDevices: %2 ", (Object)"[SwdlDSIHandlerProgress]", (Object)stringArray);
        }
    }

    @Override
    public void updateOverviewStatus(int n, int n2) {
        if (n2 == 1) {
            try {
                this.getLogDSI().log(1078071040, "%1 <- updateOverviewStatus: %2 ", (Object)"[SwdlDSIHandlerProgress]", (long)n);
                this.progressManager.updateOverviewStatus(n);
            }
            catch (Exception exception) {
                this.dsiCallbackError("updateOverviewStatus", exception);
            }
        } else {
            this.getLogDSI().log(1078071040, "%1 <- Invalid updateOverviewStatus: %2 ", (Object)"[SwdlDSIHandlerProgress]", (long)n);
        }
    }

    public void resetAutoRetryCounter() {
        this.autoRetryCounter = 0;
    }

    static {
        SWDL_AUTO_RETRIES = Integer.getInteger("SWDLAutoRetries", 0);
    }
}

