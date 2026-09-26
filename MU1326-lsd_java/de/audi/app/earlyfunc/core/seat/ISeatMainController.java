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
    public static final int PARTIAL_POPUP_ID_INVALID;

    default public void init() {
    }

    default public void deinit() {
    }

    default public void callDSIcancelPopup(SeatPneumaticContent seatPneumaticContent, int n) {
    }

    default public void callDSIcancelPopup(SeatContent seatContent, int n) {
    }

    default public void callDSIshowPopup(SeatContent seatContent) {
    }

    default public void callDSIshowPopup(SeatPneumaticContent seatPneumaticContent) {
    }

    default public void updateConfigurationHandler(SeatViewOptions seatViewOptions) {
    }

    default public void updateConfigurationHandler(SeatPneumaticViewOptions seatPneumaticViewOptions) {
    }

    default public void updateSeatContent(SeatContent seatContent) {
    }

    default public void updateSeatContent(SeatPneumaticContent seatPneumaticContent) {
    }

    default public void requestSeatPopin(SeatContent seatContent) {
    }

    default public void requestSeatPopin(SeatPneumaticContent seatPneumaticContent) {
    }

    default public void acknowledgeSeatPopup(SeatContent seatContent) {
    }

    default public void acknowledgeSeatPopup(SeatPneumaticContent seatPneumaticContent) {
    }

    default public LogChannel getLogChannel() {
    }

    default public void setSeatPopinListenerServiceTracked(boolean bl) {
    }

    default public void setSeatControlPowerManagementActive(boolean bl) {
    }

    default public SeatPopinConfigurationHandler getConfigurationHandler() {
    }

    default public void processDeferredRequest() {
    }

    default public boolean isStandbyPopupVisible() {
    }
}

