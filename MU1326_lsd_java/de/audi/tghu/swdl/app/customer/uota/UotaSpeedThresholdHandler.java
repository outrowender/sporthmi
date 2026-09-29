/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.customer.uota;

import de.audi.atip.log.LogChannel;
import de.audi.atip.sysapp.SpeedThresholdListener;
import de.audi.tghu.swdl.app.customer.uota.BaseUpdateOverTheAirController;
import de.audi.tghu.swdl.app.customer.uota.UotaPkgInfoWrapper;

class UotaSpeedThresholdHandler
implements SpeedThresholdListener {
    public static final int POPUP_TYPE_SYSTEM_PROPOSAL;
    public static final int POPUP_TYPE_DESTINATION_PROPOSAL;
    private final BaseUpdateOverTheAirController uotaController;
    private UotaPkgInfoWrapper[][] updatePackages = null;
    private boolean isBelowVelocityThreshold = true;
    private final LogChannel logUota;

    public UotaSpeedThresholdHandler(BaseUpdateOverTheAirController baseUpdateOverTheAirController) {
        this.uotaController = baseUpdateOverTheAirController;
        this.logUota = baseUpdateOverTheAirController.getLogUota();
        this.updatePackages = new UotaPkgInfoWrapper[2][];
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void exceedsUpperThreshold(int n) {
        if (1 == n) {
            this.getLogUota().log(1078071040, "[UotaSpeedThresholdHandler].exceedsUpperThreshold()");
            UotaSpeedThresholdHandler uotaSpeedThresholdHandler = this;
            synchronized (uotaSpeedThresholdHandler) {
                this.isBelowVelocityThreshold = false;
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void belowLowerThreshold(int n) {
        if (1 == n && this.getUotaController().isUotaUpdateAllowed(true)) {
            if (this.getUotaController().isDownloadActive() || this.getUotaController().getSwdlModels().getCustomerProgressStateChoice().getValue() != 0) {
                if (null != this.updatePackages[0]) {
                    this.getLogUota().log(1078071040, "[UotaSpeedThresholdHandler].belowLowerThreshold(): the system proposal is not up-to-date, clean up it");
                    this.cleanUpSysProposalPopupRequest();
                }
            } else {
                this.getLogUota().log(1078071040, "[UotaSpeedThresholdHandler].belowLowerThreshold()");
                UotaSpeedThresholdHandler uotaSpeedThresholdHandler = this;
                synchronized (uotaSpeedThresholdHandler) {
                    this.isBelowVelocityThreshold = true;
                    if (null != this.updatePackages[1]) {
                        this.getLogUota().log(1078071040, "[UotaSpeedThresholdHandler].belowLowerThreshold(): Triggering show destination proposal pop-up!");
                        this.getUotaController().showDestinationProposalPackagesAvailablePopup(this.updatePackages[1]);
                        this.updatePackages[1] = null;
                    } else if (null != this.updatePackages[0]) {
                        this.getLogUota().log(1078071040, "[UotaSpeedThresholdHandler].belowLowerThreshold(): Triggering show system proposal pop-up!");
                        this.getUotaController().showSystemProposalPackagesAvailablePopup(this.updatePackages[0]);
                        this.updatePackages[0] = null;
                    }
                }
            }
        }
    }

    synchronized void requestSysProposalInfoPopup(int n, UotaPkgInfoWrapper[] uotaPkgInfoWrapperArray) {
        if (n < 0 || n > 1) {
            this.getLogUota().log(-2137614336, "[UotaSpeedThresholdHandler].requestSysProposalInfoPopup(): unknown pop-up type %1", (long)n);
            return;
        }
        if (this.isBelowVelocityThreshold && this.getUotaController().isUotaUpdateAllowed(true) && !this.getUotaController().isDownloadActive()) {
            this.getLogUota().log(-2137614336, "[UotaSpeedThresholdHandler].requestSysProposalInfoPopup(): Below speed threshold, showing pop-ups");
            switch (n) {
                case 0: {
                    this.getUotaController().showSystemProposalPackagesAvailablePopup(uotaPkgInfoWrapperArray);
                    break;
                }
                case 1: {
                    this.getUotaController().showDestinationProposalPackagesAvailablePopup(uotaPkgInfoWrapperArray);
                    break;
                }
            }
        } else {
            this.getLogUota().log(-2137614336, "[UotaSpeedThresholdHandler].requestNewPopup(): Over speed threshold, delaying pop-ups");
            this.updatePackages[n] = uotaPkgInfoWrapperArray;
        }
    }

    synchronized void cleanUpPopupRequests() {
        this.updatePackages = new UotaPkgInfoWrapper[2][];
    }

    void cleanUpDestinationPopupRequest() {
        this.cleanUpPopupRequest(1);
    }

    void cleanUpSysProposalPopupRequest() {
        this.cleanUpPopupRequest(0);
    }

    private synchronized void cleanUpPopupRequest(int n) {
        this.updatePackages[n] = null;
    }

    private BaseUpdateOverTheAirController getUotaController() {
        return this.uotaController;
    }

    private LogChannel getLogUota() {
        return this.logUota;
    }
}

