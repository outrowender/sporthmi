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
    private static final int FUELWARNING_IN_VICINITY;
    private static final int FUELWARNING_ALONG_THE_ROUTE;
    private final LogChannel logChannel;
    private Navigation navigation;
    private RemoteHMIResultRRDListProvider remoteHmiResultRRDListProvider;

    public RRDListProviderFactory(LogChannel logChannel, Navigation navigation) {
        this.logChannel = logChannel;
        this.navigation = navigation;
    }

    @Override
    public IRRDListProvider getProviderForType(int n, NavigationEnv navigationEnv, IVehicle iVehicle) {
        IRRDListProvider iRRDListProvider = null;
        switch (n) {
            case 0: {
                this.logChannel.log(-2137614336, "RRDListProviderFactory return a Provider for Listtype = RRD_LISTTYPE_POIRESULT");
                iRRDListProvider = new PoiResultRRDListProvider(navigationEnv, -1876687360, iVehicle);
                break;
            }
            case 8: {
                this.logChannel.log(-2137614336, "RRDListProviderFactory return a Provider for Listtype = RRD_LISTTYPE_TPEGPOIRESULT");
                iRRDListProvider = new PoiResultRRDListProvider(navigationEnv, -1809709568, iVehicle);
                break;
            }
            case 1: {
                this.logChannel.log(-2137614336, "RRDListProviderFactory return a Provider for Listtype = RRD_LISTTYPE_POIRESULT_BRANDS");
                iRRDListProvider = new PoiResultRRDListProvider(navigationEnv, -1708915200, iVehicle);
                break;
            }
            case 4: {
                int n2 = navigationEnv.getChoiceModel(1344144896).getValue();
                this.logChannel.log(-2137614336, "RRDListProviderFactory return a Provider for Listtype = RRD_LISTTYPE_POI_NAME, NAV_P_O_I_SUBSTRING_SEARCH_CHOICE#value=%1", (long)n2);
                if (n2 == 0) {
                    iRRDListProvider = new PoiResultRRDListProvider(navigationEnv, -1792801280, iVehicle);
                    break;
                }
                iRRDListProvider = new PoiResultRRDListProvider(navigationEnv, -199227904, iVehicle);
                break;
            }
            case 2: {
                this.logChannel.log(-2137614336, "RRDListProviderFactory return a Provider for Listtype = RRD_LISTTYPE_REMOTE_HMI");
                iRRDListProvider = new RemoteHMIResultRRDListProvider(navigationEnv, iVehicle, this.navigation);
                break;
            }
            case 5: {
                this.logChannel.log(-2137614336, "RRDListProviderFactory return a Provider for Listtype = RRD_LISTTYPE_POI_ONLINE");
                iRRDListProvider = new PoiOnlineResultRRDListProvider(navigationEnv, -367262208, iVehicle);
                break;
            }
            case 6: {
                this.logChannel.log(-2137614336, "RRDListProviderFactory return a Provider for Listtype = RRD_LISTTYPE_POI_PARKING_NEAR_DESTINATION");
                iRRDListProvider = new PoiResultRRDListProvider(navigationEnv, -1625356800, iVehicle);
                break;
            }
            case 3: {
                this.logChannel.log(-2137614336, "RRDListProviderFactory return a Provider for Listtype = RRD_LISTTYPE_SDS");
                iRRDListProvider = new PoiResultRRDListProvider(navigationEnv, 3901, iVehicle);
                break;
            }
            case 7: {
                int n3 = navigationEnv.getChoiceModel(-14940672).getValue();
                this.logChannel.log(-2137614336, "RRDListProviderFactory#getProviderForType - select type depending on value of NAV_PETROL_STATION_SUFFIX_CHOICE=%1", (long)n3);
                if (n3 == 2) {
                    this.logChannel.log(-2137614336, "RRDListProviderFactory return a Provider for Listtype = RRD_LISTTYPE_POI_FUELWARNING - list is for ALONG_THE_ROUTE");
                    iRRDListProvider = new PoiResultRRDListProvider(navigationEnv, -2095118848, iVehicle);
                    break;
                }
                if (n3 == 1) {
                    this.logChannel.log(-2137614336, "RRDListProviderFactory return a Provider for Listtype = RRD_LISTTYPE_POI_FUELWARNING - list is for IN_VICINITY");
                    iRRDListProvider = new PoiResultRRDListProvider(navigationEnv, -2061564416, iVehicle);
                    break;
                }
                this.logChannel.log(-2137614336, "RRDListProviderFactory No Provider for listtype=%1 and value of NAV_PETROL_STATION_SUFFIX_CHOICE=%2 found", (long)n, (long)n3);
                break;
            }
            default: {
                this.logChannel.log(-2137614336, "RRDListProviderFactory No Provider for Listtype = %1 found", (long)n);
            }
        }
        return iRRDListProvider;
    }

    @Override
    public void cleanUp() {
        this.navigation = null;
        this.remoteHmiResultRRDListProvider = null;
    }
}

