/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.parking.pla;

import org.dsi.ifc.carparkingsystem.PDCPLAStatus;

public interface IPLAAdditionalInfoHandler {
    default public void init() {
    }

    default public void deinit() {
    }

    default public void updatePLAStatus(PDCPLAStatus pDCPLAStatus) {
    }
}

