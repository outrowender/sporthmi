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
import de.audi.app.navi.evo.online.RemoteHMIAppsBaseListener$ModelEntry;
import de.audi.app.navi.evo.online.RemoteHMIAppsDestinationListener$1;
import de.audi.atip.hmi.model.OptionModelListener;
import de.audi.atip.hmi.modelaccess.OptionModelApp;
import de.audi.atip.interapp.ADBRemoteHMIService;
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
    static final int WIDGET_ID_ADDRESS_INPUT_FORM;
    public static final RemoteHMIAppsBaseListener$ModelEntry[] ONLINE_RIGHT_DRAWER_ENTRIES_MODELS_FOR_DESTINATION;
    private NavigationEvo navigationEvo;

    public RemoteHMIAppsDestinationListener(NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory, OnlineSearchController onlineSearchController, NavigationEvo navigationEvo) {
        super(navigationEnv);
        this.navigationEvo = navigationEvo;
        this.putNavLocationExtractor(-367262208, new GeoCoordinatesPOIOnline(this.logChannel, onlineSearchController));
        this.putNavLocationExtractor(1, new GeoCoordinatesAddressInputForm(this.logChannel, navigationEvo.getAddressInputForm()));
        for (RemoteHMIAppsBaseListener$ModelEntry remoteHMIAppsBaseListener$ModelEntry : ONLINE_RIGHT_DRAWER_ENTRIES_MODELS_FOR_DESTINATION) {
            OptionModelApp optionModelApp = navigationEnv.getHMIService().getOptionModel(remoteHMIAppsBaseListener$ModelEntry.getNonLabelModel());
            optionModelApp.setListener(this, -1541470720);
            optionModelApp.setListener(this, -367262208);
            optionModelApp.setListener(this, 1948190208);
            optionModelApp.setListener(this, 1981744640);
            optionModelApp.setListener(this, -1876687360);
            optionModelApp.setListener(this, -199227904);
            optionModelApp.setListener(this, -1742862848);
            optionModelApp.setListener(this, -1608251904);
            optionModelApp.setListener(this, 908396032);
            optionModelApp.setListener(this, -1239480832);
            optionModelApp.setListener(this, 220202496);
            optionModelApp.setListener(this, 1595803136);
            optionModelApp.setListener(this, -1708915200);
            optionModelApp.setListener(this, -1792801280);
            optionModelApp.setCustomIDListener(this, 1);
        }
    }

    private void putNavLocationExtractor(int n, GeoCoordinates geoCoordinates) {
        this.geoCoordinatesHandlers.put(new Integer(n), geoCoordinates);
    }

    public void setGeoCoordinateForIntelliDest(GeoCoordinates geoCoordinates) {
        this.putNavLocationExtractor(-1541470720, geoCoordinates);
        this.putNavLocationExtractor(220202496, geoCoordinates);
    }

    public void setGeoCoordinateForFavorites(GeoCoordinates geoCoordinates) {
        this.putNavLocationExtractor(-1239480832, geoCoordinates);
    }

    public void setGeoCoordinateForPois(GeoCoordinates geoCoordinates) {
        this.putNavLocationExtractor(-1876687360, geoCoordinates);
        this.putNavLocationExtractor(-1708915200, geoCoordinates);
        this.putNavLocationExtractor(-1792801280, geoCoordinates);
        this.putNavLocationExtractor(-199227904, geoCoordinates);
    }

    public void setGeoCoordinatesForParentPois(GeoCoordinates geoCoordinates) {
        this.putNavLocationExtractor(1948190208, geoCoordinates);
        this.putNavLocationExtractor(1981744640, geoCoordinates);
    }

    public void setGeoCoordinateForAddressInputForm(GeoCoordinates geoCoordinates) {
        this.putNavLocationExtractor(-1742862848, geoCoordinates);
        this.putNavLocationExtractor(-1608251904, geoCoordinates);
        this.putNavLocationExtractor(908396032, geoCoordinates);
    }

    public void setGeoCoordinatesForADB(int n, GeoCoordinates geoCoordinates) {
        this.putNavLocationExtractor(n, geoCoordinates);
    }

    public void setGeoCoordinateForActiveDestinations(GeoCoordinates geoCoordinates) {
        this.putNavLocationExtractor(1595803136, geoCoordinates);
    }

    public void setADBModelListener(ADBRemoteHMIService aDBRemoteHMIService, LocationSerializer locationSerializer, ADBInterAppService aDBInterAppService) {
        ADBRemoteHMIService aDBRemoteHMIService2 = this.navigationEvo.getAdbRemoteHMIService();
        if (aDBRemoteHMIService2 == null) {
            this.logChannel.log(-1601830656, "RemoteHMIAppsDestinationListener#setADBModelsListener: ADBRemoteHMIService is null");
            return;
        }
        int[] nArray = aDBRemoteHMIService2.getListModelIDs();
        GeoCoordinatesADB geoCoordinatesADB = new GeoCoordinatesADB(this.navigationEnv.getLogChannel(), aDBRemoteHMIService2, locationSerializer, aDBInterAppService);
        this.setGeoCoordinatesForADB(nArray[0], geoCoordinatesADB);
        this.setGeoCoordinatesForADB(nArray[1], geoCoordinatesADB);
        for (RemoteHMIAppsBaseListener$ModelEntry remoteHMIAppsBaseListener$ModelEntry : ONLINE_RIGHT_DRAWER_ENTRIES_MODELS_FOR_DESTINATION) {
            OptionModelApp optionModelApp = this.navigationEnv.getHMIService().getOptionModel(remoteHMIAppsBaseListener$ModelEntry.getNonLabelModel());
            optionModelApp.setListener(this, nArray[0]);
            optionModelApp.setListener(this, nArray[1]);
        }
    }

    @Override
    public void keyPressed(int n, int n2, int n3, int n4, int n5) {
        RemoteHMIAppsBaseListener$ModelEntry remoteHMIAppsBaseListener$ModelEntry;
        this.logChannel.log(1078071040, "RemoteHMIAppsDestinationListener#keyPressed: Called with model id '%1', target model id '%2', target row '%3', target widget id '%4'", (Object)Util.createInteger(n), (Object)Util.createInteger(n2), (Object)Util.createInteger(n3), (Object)Util.createInteger(n4));
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
            this.logChannel.log(-1601830656, "RemoteHMIAppsDestinationListener#keyPressed: Location instance is null and dummy location is used");
        }
        if ((remoteHMIAppsBaseListener$ModelEntry = this.getSelectedModelEntry(n, ONLINE_RIGHT_DRAWER_ENTRIES_MODELS_FOR_DESTINATION)) == null) {
            this.logChannel.log(10000, "RemoteHMIAppsDestinationListener#keyPressed: Model entry for the selected application not found");
            return;
        }
        String string = remoteHMIAppsBaseListener$ModelEntry.getApplicationContext();
        int n6 = remoteHMIAppsBaseListener$ModelEntry.getNonLabelModel();
        this.logChannel.log(1078071040, "RemoteHMIAppsDestinationListener#keyPressed: Selected navi mini application %1", (Object)string);
        OptionModelApp optionModelApp = this.navigationEnv.getHMIService().getOptionModel(n6);
        if (navLocation == null) {
            this.logChannel.log(-2137614336, "RemoteHMIAppsDestinationListener#keyPressed: navLocation is null");
        } else if (this.onlineServiceProvider == null) {
            this.logChannel.log(10000, "RemoteHMIAppsDestinationListener#keyPressed: onlineServiceProvider is null");
        } else {
            this.onlineServiceProvider.startDestinationApp(navLocation, string, new RemoteHMIAppsDestinationListener$1(this, optionModelApp));
        }
    }

    public void cleanUp() {
        this.navigationEvo = null;
    }

    @Override
    public void keyReleased(int n, int n2, int n3, int n4, int n5) {
    }

    @Override
    public void keyTyped(int n, int n2, int n3, int n4, int n5) {
    }

    @Override
    public void customAction(int n, int n2, int n3, int n4, int n5) {
    }

    static {
        ONLINE_RIGHT_DRAWER_ENTRIES_MODELS_FOR_DESTINATION = new RemoteHMIAppsBaseListener$ModelEntry[]{new RemoteHMIAppsBaseListener$ModelEntry(1646134784, 1914570240), new RemoteHMIAppsBaseListener$ModelEntry(2115896832, 2048787968), new RemoteHMIAppsBaseListener$ModelEntry(2132674048, 2065565184), new RemoteHMIAppsBaseListener$ModelEntry(-2145516032, 2082342400), new RemoteHMIAppsBaseListener$ModelEntry(-2128738816, 2099119616), new RemoteHMIAppsBaseListener$ModelEntry(455083520, 287311360), new RemoteHMIAppsBaseListener$ModelEntry(471860736, 304088576), new RemoteHMIAppsBaseListener$ModelEntry(488637952, 320865792), new RemoteHMIAppsBaseListener$ModelEntry(505415168, 337643008), new RemoteHMIAppsBaseListener$ModelEntry(522192384, 354420224), new RemoteHMIAppsBaseListener$ModelEntry(0x20200600, 371197440), new RemoteHMIAppsBaseListener$ModelEntry(555746816, 387974656), new RemoteHMIAppsBaseListener$ModelEntry(0x22200600, 404751872), new RemoteHMIAppsBaseListener$ModelEntry(589301248, 421529088), new RemoteHMIAppsBaseListener$ModelEntry(606078464, 438306304)};
    }
}

