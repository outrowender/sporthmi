/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.fuelwarning;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.OperationManager;
import de.audi.tghu.navi.app.addressinput.poi.IPoiSpellerModelAccess;
import de.audi.tghu.navi.app.addressinput.poi.fuelwarning.FuelWarningTimer;
import de.audi.tghu.navi.app.addressinput.poi.fuelwarning.IFuelWarningModelAccess;
import de.audi.tghu.navi.app.addressinput.poi.fuelwarning.IPoiFuelWarningService;
import de.audi.tghu.navi.app.addressinput.poi.fuelwarning.PoiFuelWarningLocationHandler;
import de.audi.tghu.navi.app.addressinput.poi.fuelwarning.PoiFuelWarningSetup;
import de.audi.tghu.navi.app.addressinput.poi.sequences.wrappers.FuelWarningWrapperSequence;
import de.audi.tghu.navi.app.car.IUpdateTankInfoObserver;
import de.audi.tghu.navi.app.car.kombi.ICarKombiService;
import de.audi.tghu.navi.app.command.LISPCancelSpellerCommand;
import de.audi.tghu.navi.app.details.IDetailsScreen;
import de.audi.tghu.navi.app.guidance.IVehicle;
import de.audi.tghu.navi.app.routeguidance.IRouteManager;
import de.audi.tghu.navi.app.routeguidance.IStartGuidanceToDestinationSequence;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.RouteUtil;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.generalvehiclestates.TankInfo;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIValueListElement;
import org.dsi.ifc.navigation.Route;
import org.dsi.ifc.navigation.RouteDestination;

public class PoiFuelWarningService
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
    private final String CLASS_NAME = Util.getClassNameFromPackageName(super.getClass());
    protected final IVehicle vehicle;
    protected final ICommandListFactory commandListFactory;
    private final ICarKombiService carKombiService;
    protected final NavigationEnv env;
    private final LogChannel logChannel;
    private final IRouteManager routeManager;
    private final IFuelWarningModelAccess fuelWarningModelAccess;
    private final PoiFuelWarningSetup poiFuelWarningSetup;
    private OperationManager operationManager;
    private boolean pendingFuelWarning = false;
    private int pendingFuelWarningTankIndex = 1;
    protected final IDetailsScreen detailsScreen;
    private FuelWarningTimer fuelWarningTimer;
    protected FuelWarningWrapperSequence fuelWarningWrapperSequence;
    private boolean fuelWarningValue = false;
    private boolean fuelWarningSecondaryValue = false;
    protected int pendingWarningCategory = 101;

    public PoiFuelWarningService(NavigationEnv navigationEnv, ICarKombiService iCarKombiService, IFuelWarningModelAccess iFuelWarningModelAccess, IRouteManager iRouteManager, PoiFuelWarningSetup poiFuelWarningSetup, ICommandListFactory iCommandListFactory, IVehicle iVehicle, OperationManager operationManager, IDetailsScreen iDetailsScreen) {
        this.env = navigationEnv;
        this.logChannel = navigationEnv.getLogChannel();
        this.commandListFactory = iCommandListFactory;
        this.carKombiService = iCarKombiService;
        this.fuelWarningModelAccess = iFuelWarningModelAccess;
        this.routeManager = iRouteManager;
        this.poiFuelWarningSetup = poiFuelWarningSetup;
        this.vehicle = iVehicle;
        this.operationManager = operationManager;
        this.detailsScreen = iDetailsScreen;
        this.fuelWarningTimer = new FuelWarningTimer(this.env, this.logChannel, this);
        this.setFuelWarningSelection();
    }

    @Override
    public void checkPendingEvents() {
        this.logChannel.log(1078071040, "%1#checkPendingEvents() - pendingFuelWarning=%2", (Object)this.CLASS_NAME, (Object)this.pendingFuelWarning);
        if (!this.env.getFramework().isFrontMU()) {
            this.logChannel.log(-2137614336, "%1#checkPendingEvents() - not supported for RSE!", (Object)this.CLASS_NAME);
            return;
        }
        if (!this.poiFuelWarningSetup.isFuelWarningActive()) {
            this.logChannel.log(-2137614336, "%1#checkPendingEvents() - fuelWarningRecommendation off.", (Object)this.CLASS_NAME);
            return;
        }
        if (!this.operationManager.isFullyOperable()) {
            this.logChannel.log(-2137614336, "%1#checkPendingEvents() - navigation currently not fully operable.", (Object)this.CLASS_NAME);
            return;
        }
        if (Util.isEtronActivated()) {
            this.logChannel.log(-2137614336, "%1#checkPendingEvents() - not supported for RS-etron!", (Object)this.CLASS_NAME);
            return;
        }
        if (this.pendingFuelWarning) {
            if (this.pendingFuelWarningTankIndex == 2 && this.carKombiService.getEngineTypeSecondary() == 3) {
                this.logChannel.log(1078071040, "%1#checkPendingEvents() - fuel warning is for electric -> ignore event!", (Object)this.CLASS_NAME);
                return;
            }
            this.fuelLevelLow(this.pendingFuelWarningTankIndex);
            this.pendingFuelWarning = false;
        }
    }

    public void preparePetrolStationSearch(IPoiSpellerModelAccess iPoiSpellerModelAccess, IPoiSpellerModelAccess iPoiSpellerModelAccess2, int n, int n2, IPoiSpellerModelAccess iPoiSpellerModelAccess3) {
        this.fuelWarningWrapperSequence = new FuelWarningWrapperSequence(iPoiSpellerModelAccess, iPoiSpellerModelAccess2, this.commandListFactory, this.env, this.pendingWarningCategory, this.vehicle, n, n2, iPoiSpellerModelAccess3, this.detailsScreen);
        this.fuelWarningWrapperSequence.start();
    }

    public void startGuidance(LIValueListElement lIValueListElement, IStartGuidanceToDestinationSequence iStartGuidanceToDestinationSequence, boolean bl) {
        this.fuelWarningWrapperSequence.selectListElement(lIValueListElement, bl);
        this.fuelWarningWrapperSequence.startGuidance(new PoiFuelWarningLocationHandler(this.logChannel, this.pendingWarningCategory), iStartGuidanceToDestinationSequence);
    }

    public void finish() {
        CommandList commandList = this.commandListFactory.createCommandList(1);
        commandList.add(new LISPCancelSpellerCommand());
        commandList.execute("PoiFuelWarningService#finish");
    }

    @Override
    public void updateTankInfo(TankInfo tankInfo) {
        this.logChannel.log(-2137614336, "%1#updateTankInfo - tankInfo=%2", (Object)this.CLASS_NAME, (Object)tankInfo);
        this.logChannel.log(-2137614336, "%1#updateTankInfo - fuelWarningValue=%2; fuelWarningSecondaryValue=%3", (Object)this.CLASS_NAME, (Object)this.fuelWarningValue, (Object)this.fuelWarningSecondaryValue);
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
            this.logChannel.log(-2137614336, "%1#updateTankInfo - tankIndex=%2", (Object)this.CLASS_NAME, (long)n);
            this.fuelWarningTimer.start();
            this.pendingFuelWarning = true;
            this.pendingFuelWarningTankIndex = n;
        } else {
            this.fuelWarningTimer.stop();
            this.fuelWarningModelAccess.hidePopUp();
        }
    }

    private void fuelLevelLow(int n) {
        int n2 = this.determinePOICategory(n);
        boolean bl = this.routeContainsPetrolStation(this.routeManager.getRoute(), n2);
        this.logChannel.log(-1601830656, "%1#fuelLevelLow() - routeContainsPetrolStation=%2", (Object)this.CLASS_NAME, (Object)bl);
        this.pendingWarningCategory = n2;
        if (!bl) {
            this.fuelWarningModelAccess.showPopUp(n2);
        }
    }

    private boolean routeContainsPetrolStation(Route route, int n) {
        this.logChannel.log(-2137614336, "%1#routeContainsPetrolStation - route=%2", (Object)this.CLASS_NAME, (Object)route);
        if (RouteUtil.getRouteLength(route) <= 0) {
            return false;
        }
        String string = PoiFuelWarningService.getPOICatogoryPersistencyConst(this.logChannel, n);
        RouteDestination[] routeDestinationArray = route.getRoutelist();
        for (int i2 = (int)route.getIndexOfCurrentDestination(); i2 < routeDestinationArray.length; ++i2) {
            NavLocation navLocation = routeDestinationArray[i2].getRouteLocation();
            if (!this.isPetrolStation(navLocation, string)) continue;
            this.logChannel.log(1078071040, "%1#fuelLevelLow() - route already contains a petrol station! ", (Object)this.CLASS_NAME);
            return true;
        }
        return false;
    }

    public static void setPetrolStationFlagToLocation(LogChannel logChannel, NavLocation navLocation, int n) {
        logChannel.log(-2137614336, "PoiFuelWarningService#setPetrolStationFlagToLocation - petrolStationCategory=%1; location=%2", (Object)LocationFormatter.formatLocationShort(navLocation));
        String string = PoiFuelWarningService.getPOICatogoryPersistencyConst(logChannel, n);
        Util.setPetrolStationValue(navLocation, string);
    }

    private boolean isPetrolStation(NavLocation navLocation, String string) {
        this.logChannel.log(1078071040, "%1#isPetrolStation - location=%2", (Object)this.CLASS_NAME, (Object)navLocation);
        String string2 = Util.getPetrolStationValue(navLocation);
        this.logChannel.log(1078071040, "%1#isPetrolStation - categoryStr=%2; petrolStationStr=%3", (Object)this.CLASS_NAME, (Object)string, (Object)string2);
        return string2 != null && string2.equals(string);
    }

    private int determinePOICategory(int n) {
        this.logChannel.log(1078071040, "%1#determinePOICategory - pendingFuelWarningTankIndex=%2", (Object)this.CLASS_NAME, (long)n);
        int n2 = this.carKombiService.getConventionalEngineType();
        if (n == 2 || n == 3) {
            n2 = this.carKombiService.getAlternativeEngineType();
        }
        return this.getPOICategoryForFuelType(n2);
    }

    private int getPOICategoryForFuelType(int n) {
        this.logChannel.log(1078071040, "%1#getPOICategoryForFuelType - engineType=%2", (Object)this.CLASS_NAME, (long)n);
        int n2 = 101;
        if (n == 3) {
            n2 = 134;
        } else if (n == 2) {
            this.logChannel.log(1078071040, "%1#getPOICategoryForFuelType - Unsupported BCENGINETYPE_GAS.", (Object)this.CLASS_NAME);
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
            this.logChannel.log(1078071040, "%1#getPOICategoryForFuelType - No match found.", (Object)this.CLASS_NAME);
        }
        this.logChannel.log(1078071040, "%1#getPOICategoryForFuelType - resultCategory=%2", (Object)this.CLASS_NAME, (long)n2);
        return n2;
    }

    private static String getPOICatogoryPersistencyConst(LogChannel logChannel, int n) {
        logChannel.log(1078071040, "PoiFuelWarningService#getPOICatogoryPersistencyConst - currentPOICategory=%1", (long)n);
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
            logChannel.log(1078071040, "PoiFuelWarningService#getPOICatogoryPersistencyConst - no match found");
        }
        logChannel.log(1078071040, "PoiFuelWarningService#getPOICatogoryPersistencyConst - result=%1", (Object)string);
        return string;
    }

    public void toggleFuelWarningSelection() {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(14808325, "%1#toggleFuelWarningSelection()", (Object)this.CLASS_NAME);
        }
        boolean bl = !this.poiFuelWarningSetup.isFuelWarningActive();
        this.poiFuelWarningSetup.setFuelWarningActive(bl, true);
        this.fuelWarningModelAccess.setFuelWarningChoiceModel(bl);
    }

    private void setFuelWarningSelection() {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(14808325, "%1#setFuelWarningSelection()", (Object)this.CLASS_NAME);
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
    }
}

