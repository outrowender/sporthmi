/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.online;

import de.audi.app.navi.evo.NavigationEvo;
import de.audi.app.navi.evo.online.GeoCoordinates;
import de.audi.app.navi.evo.online.GeoCoordinatesADB;
import de.audi.app.navi.evo.online.GeoCoordinatesAddressInputForm;
import de.audi.app.navi.evo.online.GeoCoordinatesPOIOnline;
import de.audi.app.navi.evo.online.RemoteHMIAppsBaseListener;
import de.audi.atip.hmi.model.OptionModelListener;
import de.audi.atip.hmi.modelaccess.OptionModelApp;
import de.audi.atip.interapp.ADBRemoteHMIService;
import de.audi.atip.interapp.online.TransitionCallback;
import de.audi.atip.util.Util;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.ADBInterAppService;
import de.audi.tghu.navi.app.LocationSerializer;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.poi.online.OnlineSearchController;
import java.util.HashMap;
import java.util.Map;
import org.dsi.ifc.global.NavLocation;

public class RemoteHMIAppsDestinationListener
extends RemoteHMIAppsBaseListener
implements OptionModelListener {
    final Map geoCoordinatesHandlers = new HashMap();
    static final int WIDGET_ID_ADDRESS_INPUT_FORM = 1;
    public static final RemoteHMIAppsBaseListener.ModelEntry[] ONLINE_RIGHT_DRAWER_ENTRIES_MODELS_FOR_DESTINATION = new RemoteHMIAppsBaseListener.ModelEntry[]{new RemoteHMIAppsBaseListener.ModelEntry(400994, 401010), new RemoteHMIAppsBaseListener.ModelEntry(401022, 401018), new RemoteHMIAppsBaseListener.ModelEntry(401023, 401019), new RemoteHMIAppsBaseListener.ModelEntry(401024, 401020), new RemoteHMIAppsBaseListener.ModelEntry(401025, 401021), new RemoteHMIAppsBaseListener.ModelEntry(401435, 401425), new RemoteHMIAppsBaseListener.ModelEntry(401436, 401426), new RemoteHMIAppsBaseListener.ModelEntry(401437, 401427), new RemoteHMIAppsBaseListener.ModelEntry(401438, 401428), new RemoteHMIAppsBaseListener.ModelEntry(401439, 401429), new RemoteHMIAppsBaseListener.ModelEntry(401440, 401430), new RemoteHMIAppsBaseListener.ModelEntry(401441, 401431), new RemoteHMIAppsBaseListener.ModelEntry(401442, 401432), new RemoteHMIAppsBaseListener.ModelEntry(401443, 401433), new RemoteHMIAppsBaseListener.ModelEntry(401444, 401434)};
    private NavigationEvo navigationEvo;

    public RemoteHMIAppsDestinationListener(NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory, OnlineSearchController onlineSearchController, NavigationEvo navigationEvo) {
        super(navigationEnv);
        this.navigationEvo = navigationEvo;
        this.putNavLocationExtractor(400618, new GeoCoordinatesPOIOnline(this.logChannel, onlineSearchController));
        this.putNavLocationExtractor(1, new GeoCoordinatesAddressInputForm(this.logChannel, navigationEvo.getAddressInputForm()));
        int n = ONLINE_RIGHT_DRAWER_ENTRIES_MODELS_FOR_DESTINATION.length;
        for (int i2 = 0; i2 < n; ++i2) {
            RemoteHMIAppsBaseListener.ModelEntry modelEntry = ONLINE_RIGHT_DRAWER_ENTRIES_MODELS_FOR_DESTINATION[i2];
            OptionModelApp optionModelApp = navigationEnv.getHMIService().getOptionModel(modelEntry.getNonLabelModel());
            optionModelApp.setListener(this, 401316);
            optionModelApp.setListener(this, 400618);
            optionModelApp.setListener(this, 401268);
            optionModelApp.setListener(this, 401270);
            optionModelApp.setListener(this, 402576);
            optionModelApp.setListener(this, 401652);
            optionModelApp.setListener(this, 401048);
            optionModelApp.setListener(this, 402592);
            optionModelApp.setListener(this, 402742);
            optionModelApp.setListener(this, 401334);
            optionModelApp.setListener(this, 401421);
            optionModelApp.setListener(this, 400991);
            optionModelApp.setListener(this, 402586);
            optionModelApp.setListener(this, 402581);
            optionModelApp.setCustomIDListener(this, 1);
        }
    }

    private void putNavLocationExtractor(int n, GeoCoordinates geoCoordinates) {
        this.geoCoordinatesHandlers.put(new Integer(n), geoCoordinates);
    }

    public void setGeoCoordinateForIntelliDest(GeoCoordinates geoCoordinates) {
        this.putNavLocationExtractor(401316, geoCoordinates);
        this.putNavLocationExtractor(401421, geoCoordinates);
    }

    public void setGeoCoordinateForFavorites(GeoCoordinates geoCoordinates) {
        this.putNavLocationExtractor(401334, geoCoordinates);
    }

    public void setGeoCoordinateForPois(GeoCoordinates geoCoordinates) {
        this.putNavLocationExtractor(402576, geoCoordinates);
        this.putNavLocationExtractor(402586, geoCoordinates);
        this.putNavLocationExtractor(402581, geoCoordinates);
        this.putNavLocationExtractor(401652, geoCoordinates);
    }

    public void setGeoCoordinatesForParentPois(GeoCoordinates geoCoordinates) {
        this.putNavLocationExtractor(401268, geoCoordinates);
        this.putNavLocationExtractor(401270, geoCoordinates);
    }

    public void setGeoCoordinateForAddressInputForm(GeoCoordinates geoCoordinates) {
        this.putNavLocationExtractor(401048, geoCoordinates);
        this.putNavLocationExtractor(402592, geoCoordinates);
        this.putNavLocationExtractor(402742, geoCoordinates);
    }

    public void setGeoCoordinatesForADB(int n, GeoCoordinates geoCoordinates) {
        this.putNavLocationExtractor(n, geoCoordinates);
    }

    public void setGeoCoordinateForActiveDestinations(GeoCoordinates geoCoordinates) {
        this.putNavLocationExtractor(400991, geoCoordinates);
    }

    public void setADBModelListener(ADBRemoteHMIService aDBRemoteHMIService, LocationSerializer locationSerializer, ADBInterAppService aDBInterAppService) {
        ADBRemoteHMIService aDBRemoteHMIService2 = this.navigationEvo.getAdbRemoteHMIService();
        if (aDBRemoteHMIService2 == null) {
            this.logChannel.log(100000, "RemoteHMIAppsDestinationListener#setADBModelsListener: ADBRemoteHMIService is null");
            return;
        }
        int[] nArray = aDBRemoteHMIService2.getListModelIDs();
        GeoCoordinatesADB geoCoordinatesADB = new GeoCoordinatesADB(this.navigationEnv.getLogChannel(), aDBRemoteHMIService2, locationSerializer, aDBInterAppService);
        this.setGeoCoordinatesForADB(nArray[0], geoCoordinatesADB);
        this.setGeoCoordinatesForADB(nArray[1], geoCoordinatesADB);
        int n = ONLINE_RIGHT_DRAWER_ENTRIES_MODELS_FOR_DESTINATION.length;
        for (int i2 = 0; i2 < n; ++i2) {
            RemoteHMIAppsBaseListener.ModelEntry modelEntry = ONLINE_RIGHT_DRAWER_ENTRIES_MODELS_FOR_DESTINATION[i2];
            OptionModelApp optionModelApp = this.navigationEnv.getHMIService().getOptionModel(modelEntry.getNonLabelModel());
            optionModelApp.setListener(this, nArray[0]);
            optionModelApp.setListener(this, nArray[1]);
        }
    }

    public void keyPressed(int n, int n2, int n3, int n4, int n5) {
        RemoteHMIAppsBaseListener.ModelEntry modelEntry;
        this.logChannel.log(1000000, "RemoteHMIAppsDestinationListener#keyPressed: Called with model id '%1', target model id '%2', target row '%3', target widget id '%4'", (Object)Util.createInteger(n), (Object)Util.createInteger(n2), (Object)Util.createInteger(n3), (Object)Util.createInteger(n4));
        NavLocation navLocation = null;
        GeoCoordinates geoCoordinates = (GeoCoordinates)this.geoCoordinatesHandlers.get(new Integer(n2));
        GeoCoordinates geoCoordinates2 = geoCoordinates = geoCoordinates == null ? (GeoCoordinates)this.geoCoordinatesHandlers.get(new Integer(n4)) : geoCoordinates;
        if (geoCoordinates == null) {
            this.logChannel.log(10000, "RemoteHMIAppsDestinationListener#keyPressed: No Geo Coordinates Handler found for the target model");
            return;
        }
        navLocation = geoCoordinates.extractGeoCoordinates(n2, n3, this.navigationEnv);
        if (navLocation == null) {
            navLocation = this.createDummyNavLocation();
            this.logChannel.log(100000, "RemoteHMIAppsDestinationListener#keyPressed: Location instance is null and dummy location is used");
        }
        if ((modelEntry = this.getSelectedModelEntry(n, ONLINE_RIGHT_DRAWER_ENTRIES_MODELS_FOR_DESTINATION)) == null) {
            this.logChannel.log(10000, "RemoteHMIAppsDestinationListener#keyPressed: Model entry for the selected application not found");
            return;
        }
        String string = modelEntry.getApplicationContext();
        int n6 = modelEntry.getNonLabelModel();
        this.logChannel.log(1000000, "RemoteHMIAppsDestinationListener#keyPressed: Selected navi mini application %1", (Object)string);
        final OptionModelApp optionModelApp = this.navigationEnv.getHMIService().getOptionModel(n6);
        if (navLocation == null) {
            this.logChannel.log(10000000, "RemoteHMIAppsDestinationListener#keyPressed: navLocation is null");
        } else if (this.onlineServiceProvider == null) {
            this.logChannel.log(10000, "RemoteHMIAppsDestinationListener#keyPressed: onlineServiceProvider is null");
        } else {
            this.onlineServiceProvider.startDestinationApp(navLocation, string, new TransitionCallback(){

                public void triggerTransition() {
                    optionModelApp.fireEvent(0);
                }
            });
        }
    }

    public void cleanUp() {
        this.navigationEvo = null;
    }

    public void keyReleased(int n, int n2, int n3, int n4, int n5) {
    }

    public void keyTyped(int n, int n2, int n3, int n4, int n5) {
    }

    public void customAction(int n, int n2, int n3, int n4, int n5) {
    }
}

