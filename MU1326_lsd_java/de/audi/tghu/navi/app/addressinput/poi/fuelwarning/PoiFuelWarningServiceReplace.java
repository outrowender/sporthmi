/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.fuelwarning;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.OperationManager;
import de.audi.tghu.navi.app.addressinput.poi.fuelwarning.FuelWarningTimer;
import de.audi.tghu.navi.app.addressinput.poi.fuelwarning.IFuelWarningModelAccess;
import de.audi.tghu.navi.app.addressinput.poi.fuelwarning.IPoiFuelWarningService;
import de.audi.tghu.navi.app.addressinput.poi.fuelwarning.PoiFuelWarningSetup;
import de.audi.tghu.navi.app.car.IUpdateTankInfoObserver;
import de.audi.tghu.navi.app.car.kombi.ICarKombiService;
import de.audi.tghu.navi.app.routeguidance.IRouteManager;
import de.audi.tghu.navi.app.util.RouteUtil;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.generalvehiclestates.TankInfo;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.Route;
import org.dsi.ifc.navigation.RouteDestination;

public class PoiFuelWarningServiceReplace
implements IPoiFuelWarningService,
IUpdateTankInfoObserver {
    private static final int FUEL_TANK_INDEX_PRIMARY;
    private static final int FUEL_TANK_INDEX_SECONDARY;
    private static final int FUEL_TANK_INDEX_PRIMARY_SECONDARY;
    private static final String CATEGORY_NEXT_PETROLSTATION;
    private static final String CATEGORY_NEXT_CHARGINGSTATION;
    private static final String CATEGORY_NEXT_CNGSTATION;
    private static final String CATEGORY_NEXT_LPGSTATION;
    private static final String CATEGORY_NEXT_PETROLSTATION_DIESEL_NAR;
    private final ICarKombiService carKombiService;
    private final NavigationEnv env;
    private final LogChannel logChannel;
    private final IRouteManager routeManager;
    private final IFuelWarningModelAccess fuelWarningModelAccess;
    private final PoiFuelWarningSetup poiFuelWarningSetup;
    private OperationManager operationManager;
    private boolean pendingFuelWarning = false;
    private int pendingFuelWarningTankIndex = 1;
    private FuelWarningTimer fuelWarningTimer;
    private boolean fuelWarningValue = false;
    private boolean fuelWarningSecondaryValue = false;
    private int pendingWarningCategory = 101;

    public PoiFuelWarningServiceReplace(NavigationEnv navigationEnv, ICarKombiService iCarKombiService, IFuelWarningModelAccess iFuelWarningModelAccess, IRouteManager iRouteManager, PoiFuelWarningSetup poiFuelWarningSetup, OperationManager operationManager) {
        this.env = navigationEnv;
        this.logChannel = navigationEnv.getLogChannel();
        this.carKombiService = iCarKombiService;
        this.fuelWarningModelAccess = iFuelWarningModelAccess;
        this.routeManager = iRouteManager;
        this.poiFuelWarningSetup = poiFuelWarningSetup;
        this.operationManager = operationManager;
        this.fuelWarningTimer = new FuelWarningTimer(this.env, this.logChannel, this);
        this.setFuelWarningSelection();
    }

    @Override
    public void checkPendingEvents() {
        this.logChannel.log(-1601830656, "PoiFuelWarningServiceReplace#checkPendingEvents() - pendingFuelWarning: %1 ", this.pendingFuelWarning);
        if (!this.env.getFramework().isFrontMU()) {
            this.logChannel.log(-2137614336, "PoiFuelWarningServiceReplace#checkPendingEvents() - not supported for RSE!");
            return;
        }
        if (!this.poiFuelWarningSetup.isFuelWarningActive()) {
            this.logChannel.log(-2137614336, "PoiFuelWarningServiceReplace#checkPendingEvents() - fuelWarningRecommendation off.");
            return;
        }
        if (!this.operationManager.isFullyOperable()) {
            this.logChannel.log(-2137614336, "PoiFuelWarningServiceReplace#checkPendingEvents() - navigation currently not fully operable.");
            return;
        }
        if (Util.isEtronActivated()) {
            this.logChannel.log(-2137614336, "PoiFuelWarningServiceReplace#checkPendingEvents() - not supported for RS-etron!");
            return;
        }
        if (this.pendingFuelWarning) {
            if (this.pendingFuelWarningTankIndex == 2 && this.carKombiService.getEngineTypeSecondary() == 3) {
                this.logChannel.log(1078071040, "PoiFuelWarningServiceReplace#checkPendingEvents() - fuel warning is for electric -> ignore event!");
                return;
            }
            this.fuelLevelLow(this.pendingFuelWarningTankIndex);
            this.pendingFuelWarning = false;
        }
    }

    @Override
    public void updateTankInfo(TankInfo tankInfo) {
        this.logChannel.log(-2137614336, "PoiFuelWarningServiceReplace#updateTankInfo( %1 ) ", (Object)tankInfo);
        int n = 1;
        boolean bl = false;
        if (this.fuelWarningValue != tankInfo.isFuelWarning() && tankInfo.isFuelWarning()) {
            bl = true;
            n = this.fuelWarningSecondaryValue != tankInfo.isFuelWarningSecondary() && tankInfo.isFuelWarningSecondary() ? 3 : 1;
        } else if (this.fuelWarningSecondaryValue != tankInfo.isFuelWarningSecondary() && tankInfo.isFuelWarningSecondary()) {
            bl = true;
            n = 2;
        }
        this.fuelWarningValue = tankInfo.isFuelWarning();
        this.fuelWarningSecondaryValue = tankInfo.isFuelWarningSecondary();
        if (bl) {
            this.logChannel.log(-1601830656, "PoiFuelWarningServiceReplace#updateFuelWarning( %1 ) ", (long)n);
            this.fuelWarningTimer.start();
            this.pendingFuelWarning = true;
            this.pendingFuelWarningTankIndex = n;
        } else {
            this.fuelWarningTimer.stop();
            this.fuelWarningModelAccess.hidePopUp();
        }
    }

    public int getPendingWarningCategory() {
        return this.pendingWarningCategory;
    }

    private void fuelLevelLow(int n) {
        int n2 = this.determinePOICategory(n);
        boolean bl = this.routeContainsPetrolStation(this.routeManager.getRoute(), n2);
        this.logChannel.log(-1601830656, "PoiFuelWarningServiceReplace#fuelLevelLow() - routeContainsPetrolStation: %1 ", bl);
        this.pendingWarningCategory = n2;
        if (!bl) {
            this.fuelWarningModelAccess.showPopUp(n2);
        }
    }

    private boolean routeContainsPetrolStation(Route route, int n) {
        if (!this.env.getContainer().isRgActive()) {
            return false;
        }
        if (RouteUtil.getRouteLength(route) <= 0) {
            return false;
        }
        RouteDestination[] routeDestinationArray = route.getRoutelist();
        for (int i2 = (int)route.getIndexOfCurrentDestination(); i2 < routeDestinationArray.length; ++i2) {
            NavLocation navLocation = routeDestinationArray[i2].getRouteLocation();
            int n2 = Util.getLocationAccessor(navLocation).getPoiCategoryNumber();
            if (n2 != 56 && n2 != 101) continue;
            return true;
        }
        return false;
    }

    public static void setPetrolStationFlagToLocation(LogChannel logChannel, NavLocation navLocation, int n) {
        String string = PoiFuelWarningServiceReplace.getPOICatogoryPersistencyConst(logChannel, n);
        Util.setPetrolStationValue(navLocation, string);
    }

    private int determinePOICategory(int n) {
        this.logChannel.log(1078071040, "PoiFuelWarningServiceReplace#determinePOICategory()");
        int n2 = this.carKombiService.getEngineTypePrimary();
        if (n == 2 || n == 3) {
            n2 = this.carKombiService.getEngineTypeSecondary();
        }
        return this.getPOICategoryForFuelType(n2);
    }

    private int getPOICategoryForFuelType(int n) {
        this.logChannel.log(1078071040, "PoiFuelWarningServiceReplace#getPOICategoryForFuelType( %1 )", (long)n);
        int n2 = 101;
        if (n == 3) {
            n2 = 134;
        } else if (n == 2) {
            this.logChannel.log(1078071040, "PoiFuelWarningServiceReplace#getPOICategoryForFuelType( %1 ) - Unsupported BCENGINETYPE_GAS.", (long)n);
        } else if (n == 8) {
            n2 = 135;
        } else if (n == 9) {
            n2 = 136;
        } else if (n == 1) {
            n2 = 101;
        } else if (n == 6) {
            if (Util.isHURegionNAR()) {
                n2 = 121;
            }
        } else if (n == 7) {
            n2 = 101;
        } else {
            this.logChannel.log(1078071040, "PoiFuelWarningServiceReplace#getPOICategoryForFuelType( %1 ) - No match found.", (long)n);
        }
        this.logChannel.log(1078071040, "PoiFuelWarningServiceReplace#getPOICategoryForFuelType( %1 ) - result category ( %2 )", (long)n, (long)n2);
        return n2;
    }

    private static String getPOICatogoryPersistencyConst(LogChannel logChannel, int n) {
        logChannel.log(1078071040, "PoiFuelWarningServiceReplace#getPOICatogoryPersistencyConst( %1 )", (long)n);
        String string = "CATEGORY_NEXT_PETROLSTATION";
        if (n == 101) {
            string = "CATEGORY_NEXT_PETROLSTATION";
        } else if (n == 134) {
            string = "CATEGORY_NEXT_CHARGINGSTATION";
        } else if (n == 135) {
            string = "CATEGORY_NEXT_CNGSTATION";
        } else if (n == 136) {
            string = "CATEGORY_NEXT_LPGSTATION";
        } else if (n == 121) {
            string = "CATEGORY_NEXT_PETROLSTATION_DIESEL_NAR";
        } else {
            logChannel.log(1078071040, "PoiFuelWarningServiceReplace#getPOICatogoryPersistencyConst( %1 ) - no match found", (long)n);
        }
        logChannel.log(1078071040, "PoiFuelWarningServiceReplace#getPOICatogoryPersistencyConst( %2 ) - result ( %1 )", (Object)string, (long)n);
        return string;
    }

    public void toggleFuelWarningSelection() {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(14808325, "PoiFuelWarningServiceReplace#toggleFuelWarningSelection()");
        }
        boolean bl = !this.poiFuelWarningSetup.isFuelWarningActive();
        this.poiFuelWarningSetup.setFuelWarningActive(bl, true);
        this.fuelWarningModelAccess.setFuelWarningChoiceModel(bl);
    }

    private void setFuelWarningSelection() {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(14808325, "PoiFuelWarningServiceReplace#setFuelWarningSelection()");
        }
        boolean bl = this.poiFuelWarningSetup.isFuelWarningActive();
        this.fuelWarningModelAccess.setFuelWarningChoiceModel(bl);
    }

    @Override
    public void resetSettings() {
        this.poiFuelWarningSetup.resetSettings();
        this.setFuelWarningSelection();
    }

    public void cleanUp() {
        if (this.fuelWarningModelAccess != null) {
            this.fuelWarningModelAccess.cleanup();
        }
        if (this.fuelWarningTimer != null) {
            this.fuelWarningTimer.stop();
        }
        this.operationManager = null;
    }

    @Override
    public boolean isFuelWarningActive() {
        return this.fuelWarningModelAccess.isFuelWarningActive();
    }

    @Override
    public void setFuelWarningActive(boolean bl) {
        this.fuelWarningModelAccess.setFuelWarningActive(bl);
    }
}

