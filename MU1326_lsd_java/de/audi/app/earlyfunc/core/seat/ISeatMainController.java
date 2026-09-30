/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.seat;

import de.audi.app.earlyfunc.core.seat.SeatPopinConfigurationHandler;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.carseat.SeatContent;
import org.dsi.ifc.carseat.SeatPneumaticContent;
import org.dsi.ifc.carseat.SeatPneumaticViewOptions;
import org.dsi.ifc.carseat.SeatViewOptions;

public interface ISeatMainController {
    public static final int PARTIAL_POPUP_ID_INVALID = -1;

    public void init();

    public void deinit();

    public void callDSIcancelPopup(SeatPneumaticContent var1, int var2);

    public void callDSIcancelPopup(SeatContent var1, int var2);

    public void callDSIshowPopup(SeatContent var1);

    public void callDSIshowPopup(SeatPneumaticContent var1);

    public void updateConfigurationHandler(SeatViewOptions var1);

    public void updateConfigurationHandler(SeatPneumaticViewOptions var1);

    public void updateSeatContent(SeatContent var1);

    public void updateSeatContent(SeatPneumaticContent var1);

    public void requestSeatPopin(SeatContent var1);

    public void requestSeatPopin(SeatPneumaticContent var1);

    public void acknowledgeSeatPopup(SeatContent var1);

    public void acknowledgeSeatPopup(SeatPneumaticContent var1);

    public LogChannel getLogChannel();

    public void setSeatPopinListenerServiceTracked(boolean var1);

    public void setSeatControlPowerManagementActive(boolean var1);

    public SeatPopinConfigurationHandler getConfigurationHandler();

    public void processDeferredRequest();

    public boolean isStandbyPopupVisible();
}

