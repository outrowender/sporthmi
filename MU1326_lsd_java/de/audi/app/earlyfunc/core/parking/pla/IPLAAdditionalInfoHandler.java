/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.parking.pla;

import org.dsi.ifc.carparkingsystem.PDCPLAStatus;

public interface IPLAAdditionalInfoHandler {
    public void init();

    public void deinit();

    public void updatePLAStatus(PDCPLAStatus var1);
}

