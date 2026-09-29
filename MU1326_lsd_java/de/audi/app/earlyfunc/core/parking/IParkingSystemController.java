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
    public static final int SYSTEM_VIEW_MODE_NONE;
    public static final int SYSTEM_VIEW_MODE_CAMERA;
    public static final int SYSTEM_VIEW_MODE_GRAPHIC;

    default public void registerParkingSystemComponent(IParkingSystem iParkingSystem) {
    }

    default public void unregisterParkingSystemComponent(IParkingSystem iParkingSystem) {
    }

    default public SimpleIntObjectMap getAvailableParkingSystems() {
    }

    default public IParkingPopupHandler getPopupHandler() {
    }

    default public ParkingPartialPopupHandler getPartialPopupHandler() {
    }

    default public OPSViewModeHandler getOPSViewModeHandler() {
    }

    default public DisplayContent getCurrentDisplayContent() {
    }

    default public void changeDisplayContent(DisplayContent displayContent) {
    }

    default public void changeDisplayContent(DisplayContent displayContent, boolean bl) {
    }

    default public void notifyPopupCanceled(int n) {
    }

    default public void notifyPartialPopupCanceled(int n) {
    }

    default public void notifyPopupVisible(int n) {
    }

    default public boolean notifyPopupHidden(int n) {
    }

    default public void notifyParkingSystemActive(IParkingSystem iParkingSystem, boolean bl) {
    }

    default public void notifyViewModeSettingChanged(IParkingSystem iParkingSystem, int n, int n2, int n3, boolean bl) {
    }

    default public void addPopupRequest(ParkingPopupIdentifier parkingPopupIdentifier, IParkingSystem iParkingSystem) {
    }

    default public void removePopupRequest(ParkingPopupIdentifier parkingPopupIdentifier, IParkingSystem iParkingSystem) {
    }

    default public boolean isStandbyPopupVisible() {
    }

    default public boolean hasVPSContent(DisplayContent displayContent) {
    }

    default public boolean hasOPSContent(DisplayContent displayContent) {
    }

    default public void addPopupRequestSuppression(ParkingPopupIdentifier parkingPopupIdentifier, IParkingSystem iParkingSystem) {
    }

    default public void removePopupRequestSuppression(ParkingPopupIdentifier parkingPopupIdentifier, IParkingSystem iParkingSystem) {
    }

    default public boolean equalsDisplayContent(DisplayContent displayContent, DisplayContent displayContent2) {
    }
}

