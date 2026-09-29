/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.geocoordinput;

import de.audi.atip.interapp.NaviADBService$LocationInputHandler;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.atip.interapp.navigation.previewmap.gui.GuiTooltipInformationContainer;
import de.audi.atip.log.LogChannel;
import de.audi.atip.metrics.GeoMetric;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.ADBInterAppService;
import de.audi.tghu.navi.app.HomeAddressHandler;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.command.LIGetLocationDescriptionTransformCommand;
import de.audi.tghu.navi.app.geocoordinput.GeoCoordInputManager$1;
import de.audi.tghu.navi.app.geocoordinput.GuiModelAccessInputGeoCoordinate;
import de.audi.tghu.navi.app.guidance.IVehicle;
import de.audi.tghu.navi.app.map.MapInterface;
import de.audi.tghu.navi.app.routeguidance.IStartGuidanceToDestinationSequence;
import org.dsi.ifc.global.NavLocation;

public class GeoCoordInputManager {
    protected final NavigationEnv env;
    protected final LogChannel logChannel;
    private final ICommandListFactory commandListFactory;
    private final IVehicle vehicle;
    private final GuiModelAccessInputGeoCoordinate geoCoordModelAccess;
    private final IPreviewMap previewMap;
    private final IStartGuidanceToDestinationSequence startGuidanceDependantSequence;
    private final ADBInterAppService adbInterAppService;
    private final MapInterface mapInterface;
    private final HomeAddressHandler homeAddressHandler;
    protected NavLocation coordinates;
    private static final int CURSOR_POSITION_ON_LATITUDE;
    private static final int CURSOR_POSITION_ON_LONGITUDE;
    private static final int CURSOR_POSITION_ON_START;
    protected static final boolean PREVIEWMAP_LOCATION_SET;
    protected static final boolean PREVIEWMAP_LOCATION_DO_NOT_SET;
    private boolean latitudeChanged = false;
    private boolean longitudeChanged = false;

    public GeoCoordInputManager(NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory, IVehicle iVehicle, GuiModelAccessInputGeoCoordinate guiModelAccessInputGeoCoordinate, IPreviewMap iPreviewMap, IStartGuidanceToDestinationSequence iStartGuidanceToDestinationSequence, ADBInterAppService aDBInterAppService, MapInterface mapInterface, HomeAddressHandler homeAddressHandler) {
        this.env = navigationEnv;
        this.previewMap = iPreviewMap;
        this.startGuidanceDependantSequence = iStartGuidanceToDestinationSequence;
        this.adbInterAppService = aDBInterAppService;
        this.mapInterface = mapInterface;
        this.logChannel = navigationEnv.getGeoCoordInputLogChannel();
        this.commandListFactory = iCommandListFactory;
        this.vehicle = iVehicle;
        this.geoCoordModelAccess = guiModelAccessInputGeoCoordinate;
        this.homeAddressHandler = homeAddressHandler;
    }

    public void start() {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(14808325, "GeoCoordInputManager#start()");
        }
        this.startGuidanceDependantSequence.start(this.env.getContainer().getTransformedLocation());
    }

    public void storeToAdb() {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(14808325, "GeoCoordInputManager#storeToAdb()");
        }
        byte[] byArray = this.adbInterAppService.resolveGeoCoords(this.coordinates.longitude, this.coordinates.latitude, "");
        NaviADBService$LocationInputHandler naviADBService$LocationInputHandler = this.adbInterAppService.getCurrentLocationInputHandler();
        if (naviADBService$LocationInputHandler != null) {
            naviADBService$LocationInputHandler.updateLocation(byArray);
            this.adbInterAppService.removeHandler();
        }
    }

    public void storeHomeAddress() {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(14808325, "GeoCoordInputManager#storeHomeAddress()");
        }
        this.homeAddressHandler.onCreateEditHomeAddress(this.coordinates);
    }

    public void enterWithCCPAsCoordinates() {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(14808325, "GeoCoordInputManager#enterWithCCPAsCoordinates()");
        }
        this.coordinates = this.vehicle.getVehicleLocation();
        this.getDetailedLocationInformation(this.coordinates, false);
        this.geoCoordModelAccess.setCoordinates(this.coordinates, 0);
        this.enter();
    }

    public void enter() {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(14808325, "GeoCoordInputManager#enter()");
        }
        this.previewMap.setPreviewLocationDistant(this.getCurrentCoordinates(), 1, null, null);
    }

    public void coordinateUpdate(GeoMetric geoMetric, int n) {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(14808325, "GeoCoordInputManager#coordinateUpdate()");
            this.logChannel.log(14808325, "GeoCoordInputManager#coordinateUpdate() --> Status: %1", (long)n);
        }
        if (n == 0) {
            this.latitudeChanged = true;
        } else if (n == 1) {
            this.longitudeChanged = true;
        }
        if (this.latitudeChanged || this.longitudeChanged) {
            this.coordinates.latitude = geoMetric.getLatitude();
            this.coordinates.longitude = geoMetric.getLongitude();
            this.coordinateUpdateSetPreviewMapLocationAndFillTooltip();
            if (this.latitudeChanged) {
                this.geoCoordModelAccess.setCoordinates(this.coordinates, 1);
            }
            if (this.longitudeChanged) {
                this.geoCoordModelAccess.setCoordinates(this.coordinates, 2);
            }
        }
        this.latitudeChanged = false;
        this.longitudeChanged = false;
        if (n < 0 || n > 1) {
            this.logChannel.log(10000, "GeoCoordInputManager#coordinateUpdate() --> Wrong status received - Status: %1", (long)n);
        }
    }

    protected void coordinateUpdateSetPreviewMapLocationAndFillTooltip() {
        GuiTooltipInformationContainer guiTooltipInformationContainer = this.geoCoordModelAccess.createMapTooltipInformationContainer(this.coordinates, null);
        this.coordinateUpdateSetPreviewMap(guiTooltipInformationContainer);
        this.getDetailedLocationInformation(this.coordinates, false);
    }

    protected void coordinateUpdateSetPreviewMap(GuiTooltipInformationContainer guiTooltipInformationContainer) {
        this.previewMap.setPreviewLocationDistant(this.coordinates, 1, this.geoCoordModelAccess, guiTooltipInformationContainer);
    }

    protected void getDetailedLocationInformation(NavLocation navLocation, boolean bl) {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(14808325, "GeoCoordInputManager#getDetailedLocationInformation()");
        }
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LIGetLocationDescriptionTransformCommand(navLocation));
        commandList.add(new GeoCoordInputManager$1(this, bl));
        commandList.execute("GeoCoordInputManager#coordinateUpdate()");
    }

    public NavLocation getCurrentCoordinates() {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(14808325, "GeoCoordInputManager#getCurrentCoordinates()");
        }
        return this.coordinates;
    }

    public void destOptShowInMap() {
        if (this.coordinates == null) {
            if (this.logChannel.isDebug2()) {
                this.logChannel.log(14808325, "GeoCoordInputManager#destOptShowInMap() --- Coordinates is NULL");
            }
            return;
        }
        this.mapInterface.destOptShowInMap(this.coordinates);
    }

    static /* synthetic */ GuiModelAccessInputGeoCoordinate access$000(GeoCoordInputManager geoCoordInputManager) {
        return geoCoordInputManager.geoCoordModelAccess;
    }
}

