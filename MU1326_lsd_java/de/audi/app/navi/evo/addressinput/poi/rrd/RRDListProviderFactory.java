/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi.rrd;

import de.audi.app.navi.evo.addressinput.poi.rrd.IRRDListProviderFactory;
import de.audi.app.navi.evo.addressinput.poi.rrd.PoiOnlineResultRRDListProvider;
import de.audi.app.navi.evo.addressinput.poi.rrd.RemoteHMIResultRRDListProvider;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.Navigation;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.poi.rrd.IRRDListProvider;
import de.audi.tghu.navi.app.addressinput.poi.rrd.PoiResultRRDListProvider;
import de.audi.tghu.navi.app.guidance.IVehicle;

public class RRDListProviderFactory
implements IRRDListProviderFactory {
    private static final int FUELWARNING_IN_VICINITY = 1;
    private static final int FUELWARNING_ALONG_THE_ROUTE = 2;
    private final LogChannel logChannel;
    private Navigation navigation;
    private RemoteHMIResultRRDListProvider remoteHmiResultRRDListProvider;

    public RRDListProviderFactory(LogChannel logChannel, Navigation navigation) {
        this.logChannel = logChannel;
        this.navigation = navigation;
    }

    public IRRDListProvider getProviderForType(int n, NavigationEnv navigationEnv, IVehicle iVehicle) {
        IRRDListProvider iRRDListProvider = null;
        switch (n) {
            case 0: {
                this.logChannel.log(10000000, "RRDListProviderFactory return a Provider for Listtype = RRD_LISTTYPE_POIRESULT");
                iRRDListProvider = new PoiResultRRDListProvider(navigationEnv, 402576, iVehicle);
                break;
            }
            case 8: {
                this.logChannel.log(10000000, "RRDListProviderFactory return a Provider for Listtype = RRD_LISTTYPE_TPEGPOIRESULT");
                iRRDListProvider = new PoiResultRRDListProvider(navigationEnv, 402068, iVehicle);
                break;
            }
            case 1: {
                this.logChannel.log(10000000, "RRDListProviderFactory return a Provider for Listtype = RRD_LISTTYPE_POIRESULT_BRANDS");
                iRRDListProvider = new PoiResultRRDListProvider(navigationEnv, 402586, iVehicle);
                break;
            }
            case 4: {
                int n2 = navigationEnv.getChoiceModel(400976).getValue();
                this.logChannel.log(10000000, "RRDListProviderFactory return a Provider for Listtype = RRD_LISTTYPE_POI_NAME, NAV_P_O_I_SUBSTRING_SEARCH_CHOICE#value=%1", (long)n2);
                if (n2 == 0) {
                    iRRDListProvider = new PoiResultRRDListProvider(navigationEnv, 402581, iVehicle);
                    break;
                }
                iRRDListProvider = new PoiResultRRDListProvider(navigationEnv, 401652, iVehicle);
                break;
            }
            case 2: {
                this.logChannel.log(10000000, "RRDListProviderFactory return a Provider for Listtype = RRD_LISTTYPE_REMOTE_HMI");
                iRRDListProvider = new RemoteHMIResultRRDListProvider(navigationEnv, iVehicle, this.navigation);
                break;
            }
            case 5: {
                this.logChannel.log(10000000, "RRDListProviderFactory return a Provider for Listtype = RRD_LISTTYPE_POI_ONLINE");
                iRRDListProvider = new PoiOnlineResultRRDListProvider(navigationEnv, 400618, iVehicle);
                break;
            }
            case 6: {
                this.logChannel.log(10000000, "RRDListProviderFactory return a Provider for Listtype = RRD_LISTTYPE_POI_PARKING_NEAR_DESTINATION");
                iRRDListProvider = new PoiResultRRDListProvider(navigationEnv, 401311, iVehicle);
                break;
            }
            case 3: {
                this.logChannel.log(10000000, "RRDListProviderFactory return a Provider for Listtype = RRD_LISTTYPE_SDS");
                iRRDListProvider = new PoiResultRRDListProvider(navigationEnv, 3901, iVehicle);
                break;
            }
            case 7: {
                int n3 = navigationEnv.getChoiceModel(400639).getValue();
                this.logChannel.log(10000000, "RRDListProviderFactory#getProviderForType - select type depending on value of NAV_PETROL_STATION_SUFFIX_CHOICE=%1", (long)n3);
                if (n3 == 2) {
                    this.logChannel.log(10000000, "RRDListProviderFactory return a Provider for Listtype = RRD_LISTTYPE_POI_FUELWARNING - list is for ALONG_THE_ROUTE");
                    iRRDListProvider = new PoiResultRRDListProvider(navigationEnv, 401283, iVehicle);
                    break;
                }
                if (n3 == 1) {
                    this.logChannel.log(10000000, "RRDListProviderFactory return a Provider for Listtype = RRD_LISTTYPE_POI_FUELWARNING - list is for IN_VICINITY");
                    iRRDListProvider = new PoiResultRRDListProvider(navigationEnv, 401285, iVehicle);
                    break;
                }
                this.logChannel.log(10000000, "RRDListProviderFactory No Provider for listtype=%1 and value of NAV_PETROL_STATION_SUFFIX_CHOICE=%2 found", (long)n, (long)n3);
                break;
            }
            default: {
                this.logChannel.log(10000000, "RRDListProviderFactory No Provider for Listtype = %1 found", (long)n);
            }
        }
        return iRRDListProvider;
    }

    public void cleanUp() {
        this.navigation = null;
        this.remoteHmiResultRRDListProvider = null;
    }
}

