/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.guidance;

import de.audi.atip.log.LogChannel;
import de.audi.atip.metrics.GeoMetric;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.command.Monitor;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.car.IUpdateESPDataObserver;
import de.audi.tghu.navi.app.car.IUpdateVehicleStandstillObserver;
import de.audi.tghu.navi.app.car.IVehicleStatesEventsProvider;
import de.audi.tghu.navi.app.car.IVehicleStatesObserver;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.command.sds.LIStripLocationCommand;
import de.audi.tghu.navi.app.guidance.CcpCountry;
import de.audi.tghu.navi.app.guidance.IVehicle;
import de.audi.tghu.navi.app.guidance.IVehicleModelAccess;
import de.audi.tghu.navi.app.navobserver.INavObserverRegistry;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.TextUtil;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.generalvehiclestates.TankInfo;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.PosPosition;

public class Vehicle
implements IVehicle,
IUpdateVehicleStandstillObserver,
IUpdateESPDataObserver,
IVehicleStatesObserver {
    protected static volatile IVehicle instance;
    private static final int VELOCITY_ERROR_THRESHOLD = 300;
    private static final int VELOCITY_DEMO_MODE = 50;
    protected final NavigationEnv env;
    protected final LogChannel guidanceLogChannel;
    private GeoMetric geoMetric = new GeoMetric(0, 0);
    private String posPositionStreet = "";
    private int carVelocity = 0;
    private volatile NavLocation vehicleCountryLocation = null;
    private final Monitor vehicleCountryLocationMonitor;
    private final ICommandListFactory commandListFactory;
    protected IVehicleModelAccess modelAccess = null;
    private String currentCity;
    private String currentCountry;
    private String currentLatitude;
    private String currentLongitude;
    private String currentStreet;
    private INavObserverRegistry navObserverRegistry;

    protected Vehicle(NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory, INavObserverRegistry iNavObserverRegistry) {
        this.commandListFactory = iCommandListFactory;
        this.env = navigationEnv;
        this.navObserverRegistry = iNavObserverRegistry;
        this.guidanceLogChannel = navigationEnv.getGuidanceLogChannel();
        this.vehicleCountryLocationMonitor = new Monitor(this.guidanceLogChannel);
    }

    public void setModelAccess(IVehicleModelAccess iVehicleModelAccess) {
        this.modelAccess = iVehicleModelAccess;
    }

    public synchronized void unitsChanged() {
        this.guidanceLogChannel.log(10000000, "Vehicle#unitsChanged()");
        this.refreshHeight();
    }

    public synchronized void refreshPositionDescription() {
        NavLocation navLocation = this.env.getContainer().getSoPosPositionDescription();
        CcpCountry.updateIfChanged(navLocation, this.navObserverRegistry);
        if (this.guidanceLogChannel.isDebug2()) {
            this.guidanceLogChannel.log(100000000, "Vehicle#refreshPositionDescription( %1 )", (Object)LocationFormatter.formatLocationShort(navLocation));
        }
        String string = LocationFormatter.formatCountry(navLocation);
        String string2 = Util.getCountryAbbreviation(navLocation);
        String string3 = LocationFormatter.formatCityTitleWithoutCityCenter(navLocation);
        String string4 = LocationFormatter.formatZIPCode(navLocation);
        this.posPositionStreet = LocationFormatter.formatStreet(navLocation);
        this.currentCity = string3;
        this.currentCountry = string;
        this.refreshCurrentStreet();
        this.refreshVehicleCountryLocation();
        if (this.modelAccess != null) {
            this.modelAccess.updateZip(string4);
            this.modelAccess.updateCountryNCity(string, string2, string3);
            this.modelAccess.buildRows();
        }
    }

    public synchronized void refreshPosPosition(PosPosition posPosition) {
        if (posPosition != null) {
            this.geoMetric.setGeoValues(posPosition.getLatitude(), posPosition.getLongitude());
            String string = this.geoMetric.formatLatitude();
            String string2 = this.geoMetric.formatLongitude();
            int n = posPosition.getDirectionAngle();
            short s = posPosition.getVisibleSatellites();
            short s2 = posPosition.getUsedSatellites();
            int n2 = posPosition.getState();
            if (this.guidanceLogChannel.isDebug2()) {
                this.guidanceLogChannel.log(100000000, "Vehicle#refreshPosition( %1, %2, %3 )", (Object)string, (Object)string2, (long)n);
            }
            this.currentLatitude = string;
            this.currentLongitude = string2;
            this.refreshHeight();
            this.refreshCurrentStreet();
            if (this.modelAccess != null) {
                this.modelAccess.updateSatInfo(string, string2, n, s, s2, n2);
                this.modelAccess.buildRows();
            }
        }
    }

    public synchronized void refreshHeight() {
        PosPosition posPosition = this.env.getContainer().getSoPosPosition();
        if (posPosition != null) {
            int n = posPosition.getHeight();
            if (this.guidanceLogChannel.isDebug2()) {
                this.guidanceLogChannel.log(100000000, "Vehicle#refreshHeight( %1 )", (Object)Util.formatHeight(n));
            }
            if (this.modelAccess != null) {
                this.modelAccess.updateHeight(n);
            }
        }
    }

    public NavLocation getVehicleLocation() {
        NavLocation navLocation;
        PosPosition posPosition = this.getPosition();
        if (posPosition == null || posPosition.latitude == 0 && posPosition.longitude == 0) {
            this.env.getLogChannel().log(10000, "Vehicle#getVehicleLocation - invalid vehicle position! Using default location!");
            navLocation = Util.getFallbackLocation();
        } else {
            navLocation = Util.getLocationFromGeoPos(posPosition.getLongitude(), posPosition.getLatitude());
        }
        return navLocation;
    }

    public NavLocation getVehicleLocationDescription() {
        NavLocation navLocation = this.env.getContainer().getSoPosPositionDescription();
        if (navLocation == null || navLocation.latitude == 0 && navLocation.longitude == 0) {
            this.env.getLogChannel().log(10000, "Vehicle#getVehicleLocationDescription - invalid vehicle position! Using default location!");
            navLocation = Util.getFallbackLocation();
        }
        return navLocation;
    }

    public NavLocation getVehicleCountryLocation() {
        if (this.vehicleCountryLocation != null) {
            if (this.env.getLogChannel().isDebug()) {
                this.env.getLogChannel().log(10000000, "Vehicle#getVehicleCountryLocation() - returning: '%1'", (Object)LocationFormatter.formatLocationShort(this.vehicleCountryLocation));
            }
            return this.vehicleCountryLocation;
        }
        this.env.getLogChannel().log(100000, "Vehicle#getVehicleCountryLocation() - failed to create location (vehicle location is null!)");
        return new NavLocation();
    }

    public void setVehicleCountryLocation(NavLocation navLocation) {
        this.vehicleCountryLocation = navLocation;
    }

    private void refreshCurrentStreet() {
        String string = this.isMatchedToDigitalMap() ? this.posPositionStreet : TextUtil.getOffRoadName();
        if (this.guidanceLogChannel.isDebug2()) {
            this.guidanceLogChannel.log(100000000, "Vehicle#refreshCurrentStreet( %1 )", (Object)string);
        }
        if (string != null && !string.equals(this.currentStreet)) {
            this.guidanceLogChannel.log(10000000, "Vehicle#refreshCurrentStreet - update label and routeplan, street: %1", (Object)string);
            this.currentStreet = string;
            if (this.modelAccess != null) {
                this.modelAccess.updateStreet(string);
            }
        }
    }

    private void refreshVehicleCountryLocation() {
        NavLocation navLocation = this.env.getContainer().getSoPosPositionDescription();
        if (!this.vehicleCountryLocationMonitor.isActive() && navLocation != null && !Util.isEmpty(navLocation.getCountryAbbreviation()) && (this.vehicleCountryLocation == null || this.hasCountryAbbreviationChanged(navLocation) || this.hasCountryChanged(navLocation))) {
            CommandList commandList = this.commandListFactory.createCommandList(1);
            commandList.addMonitor(this.vehicleCountryLocationMonitor);
            commandList.add(new LIStripLocationCommand(navLocation, 1));
            commandList.add(new NavCommand("GetCountryVehicleLocation"){

                public void execute() {
                    Vehicle.this.vehicleCountryLocation = (NavLocation)this.getCommandList().get("STRIPPED_LOCATION");
                    if (this.logger.isDebug()) {
                        this.logger.log(10000000, "GetCountryVehicleLocation#execute() - strippedLocation: %1", (Object)LocationFormatter.formatLocationShort(Vehicle.this.vehicleCountryLocation));
                    }
                    this.getCommandList().commandFinished();
                }
            });
            commandList.execute("Vehicle#refreshVehicleCountryLocation()");
        }
    }

    private boolean hasCountryAbbreviationChanged(NavLocation navLocation) {
        return !navLocation.getCountryAbbreviation().equalsIgnoreCase(this.vehicleCountryLocation.getCountryAbbreviation());
    }

    private boolean hasCountryChanged(NavLocation navLocation) {
        return !navLocation.getCountry().equalsIgnoreCase(this.vehicleCountryLocation.getCountry());
    }

    public boolean isMatchedToDigitalMap() {
        PosPosition posPosition = this.env.getContainer().getSoPosPosition();
        boolean bl = false;
        if (posPosition != null) {
            bl = posPosition.isMatchedToDigitalMap();
        }
        return bl;
    }

    public String getCountryAbbreviation() {
        return this.getVehicleCountryLocation().getCountryAbbreviation();
    }

    public String getCountry() {
        return this.currentCountry;
    }

    public String getCity() {
        return this.currentCity;
    }

    public String getStreet() {
        return this.currentStreet;
    }

    public String getLatitude() {
        return this.currentLatitude;
    }

    public String getLongitude() {
        return this.currentLongitude;
    }

    public int getHeading(PosPosition posPosition) {
        int n;
        if (posPosition == null) {
            this.env.getLogChannel().log(100000, "Vehicle#getHeading() - Invalid vehicle position null! Setting heading to 0.");
            n = 0;
        } else {
            n = posPosition.getDirectionAngle() % 360;
        }
        return n;
    }

    public PosPosition getFrontUnitPosition() {
        PosPosition posPosition = this.env.getFramework().isFrontMU() ? this.env.getContainer().getSoPosPosition() : this.env.getRemoteContainer().getSoPosPosition();
        if (posPosition == null) {
            this.env.getLogChannel().log(100000, "Vehicle#getFrontUnitPosition() - Invalid vehicle position null!");
            posPosition = new PosPosition();
        }
        return posPosition;
    }

    public PosPosition getPosition() {
        PosPosition posPosition = this.env.getContainer().getSoPosPosition();
        if (posPosition == null) {
            this.env.getLogChannel().log(100000, "Util#getPosition() - Invalid vehicle position null! ");
            posPosition = new PosPosition();
        }
        return posPosition;
    }

    public void updateESPData(int n, boolean bl) {
        this.carVelocity = n;
        if (this.carVelocity >= 300) {
            this.carVelocity /= 100;
        }
    }

    public int getCarVelocity() {
        return this.env.getContainer().isEtcDemoMode() ? 50 : this.carVelocity;
    }

    public void updateVehicleStandstill(boolean bl) {
    }

    public void vehicleStatesEventsProviderAdded(IVehicleStatesEventsProvider iVehicleStatesEventsProvider) {
        iVehicleStatesEventsProvider.registerListener(this);
    }

    public void updateTankInfo(TankInfo tankInfo) {
    }

    public void updateDisplayDayNightDesign(boolean bl) {
    }

    public void updateESPData() {
    }

    public static IVehicle getInstance() {
        return instance;
    }

    public static synchronized IVehicle createInstance(NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory, INavObserverRegistry iNavObserverRegistry) {
        if (instance == null) {
            instance = new Vehicle(navigationEnv, iCommandListFactory, iNavObserverRegistry);
        }
        return instance;
    }

    public static void useDummyInstanceForTesting(IVehicle iVehicle) {
        instance = iVehicle;
    }

    public synchronized void cleanUp() {
        if (instance != null && this.env != null) {
            this.env.getLogChannel().log(10000000, "Vehicle#cleanup()");
            instance = null;
        }
    }
}

