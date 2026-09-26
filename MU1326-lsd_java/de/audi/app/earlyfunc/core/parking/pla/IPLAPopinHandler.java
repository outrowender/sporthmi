/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.parking.pla;

import org.dsi.ifc.carparkingsystem.DisplayContent;
import org.dsi.ifc.carparkingsystem.PDCPLAStatus;

public interface IPLAPopinHandler {
    default public void init() {
    }

    default public void deinit() {
    }

    default public void updateVpsOpsPopup(DisplayContent displayContent, boolean bl) {
    }

    default public void updatePDCPLAStatus(PDCPLAStatus pDCPLAStatus) {
    }

    default public void setCanceledByHMI() {
    }

    default public boolean isPlaInOutActiveOpsStandalone() {
    }
}

