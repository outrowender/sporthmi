/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.parking;

import de.audi.app.earlyfunc.core.parking.IParkingPopupHandler;
import de.audi.app.earlyfunc.core.parking.IParkingSystem;
import de.audi.app.earlyfunc.core.parking.IParkingSystemHighProtocol;
import de.audi.app.earlyfunc.core.parking.ParkingPartialPopupHandler;
import de.audi.app.earlyfunc.core.parking.ParkingPopupIdentifier;
import de.audi.app.earlyfunc.core.parking.ops.OPSViewModeHandler;
import de.esolutions.fw.util.commons.SimpleIntObjectMap;
import org.dsi.ifc.carparkingsystem.DisplayContent;

public interface IParkingSystemController
extends IParkingSystemHighProtocol {
    public static final int SYSTEM_VIEW_MODE_NONE = -1;
    public static final int SYSTEM_VIEW_MODE_CAMERA = 0;
    public static final int SYSTEM_VIEW_MODE_GRAPHIC = 1;

    public void registerParkingSystemComponent(IParkingSystem var1);

    public void unregisterParkingSystemComponent(IParkingSystem var1);

    public SimpleIntObjectMap getAvailableParkingSystems();

    public IParkingPopupHandler getPopupHandler();

    public ParkingPartialPopupHandler getPartialPopupHandler();

    public OPSViewModeHandler getOPSViewModeHandler();

    public DisplayContent getCurrentDisplayContent();

    public void changeDisplayContent(DisplayContent var1);

    public void changeDisplayContent(DisplayContent var1, boolean var2);

    public void notifyPopupCanceled(int var1);

    public void notifyPartialPopupCanceled(int var1);

    public void notifyPopupVisible(int var1);

    public boolean notifyPopupHidden(int var1);

    public void notifyParkingSystemActive(IParkingSystem var1, boolean var2);

    public void notifyViewModeSettingChanged(IParkingSystem var1, int var2, int var3, int var4, boolean var5);

    public void addPopupRequest(ParkingPopupIdentifier var1, IParkingSystem var2);

    public void removePopupRequest(ParkingPopupIdentifier var1, IParkingSystem var2);

    public boolean isStandbyPopupVisible();

    public boolean hasVPSContent(DisplayContent var1);

    public boolean hasOPSContent(DisplayContent var1);

    public void addPopupRequestSuppression(ParkingPopupIdentifier var1, IParkingSystem var2);

    public void removePopupRequestSuppression(ParkingPopupIdentifier var1, IParkingSystem var2);

    public boolean equalsDisplayContent(DisplayContent var1, DisplayContent var2);
}

