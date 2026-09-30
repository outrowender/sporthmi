/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.parking.pla;

import org.dsi.ifc.carparkingsystem.DisplayContent;
import org.dsi.ifc.carparkingsystem.PDCPLAStatus;

public interface IPLAPopinHandler {
    public void init();

    public void deinit();

    public void updateVpsOpsPopup(DisplayContent var1, boolean var2);

    public void updatePDCPLAStatus(PDCPLAStatus var1);

    public void setCanceledByHMI();

    public boolean isPlaInOutActiveOpsStandalone();
}

