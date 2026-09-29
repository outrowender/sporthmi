/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi;

import de.audi.atip.log.LogChannel;
import de.audi.atip.phone.ITelService;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchArea;
import de.audi.tghu.navi.app.addressinput.poi.sequences.CallPhoneNumberSequence;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.TextUtil;
import de.audi.tghu.navi.app.util.Util;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIValueListElement;
import org.dsi.ifc.navigation.ValueListStatus;

public class PoiUtil {
    public static boolean isPoi24h(NavLocation navLocation) {
        int n = Util.getLocationAccessor(navLocation).getAdditionalFlags();
        return (n & 1) == 1;
    }

    public static boolean isPoi24h(LIValueListElement lIValueListElement) {
        return (lIValueListElement.getAdditionalFlags() & 1) == 1;
    }

    public static boolean isPayByCreditCardPossible(LIValueListElement lIValueListElement) {
        return (lIValueListElement.getAdditionalFlags() & 0x20) == 32;
    }

    public static boolean isDieselAvailable(LIValueListElement lIValueListElement) {
        return (lIValueListElement.getAdditionalFlags() & 8) == 8;
    }

    public static boolean hasTravelGuideAdditionalInfo(LIValueListElement lIValueListElement) {
        return (lIValueListElement.getAdditionalFlags() & 4) == 4;
    }

    public static void appendPoi24hMarker(Buffer buffer) {
        buffer.append(TextUtil.getPoi24hMarker());
    }

    public static NavLocation getLocation(PoiSearchArea poiSearchArea, NavigationEnv navigationEnv) {
        navigationEnv.getPOILogChannel().log(-2137614336, "PoiUtil#getLocation() - searchContext: %1", (long)poiSearchArea.getSearchContext());
        NavLocation navLocation = null;
        switch (poiSearchArea.getSearchContext()) {
            case 0: {
                navLocation = Util.getDynamicVicinityLocation();
                navLocation = PoiUtil.transformLocationBySurrounding(navLocation);
                break;
            }
            case 1: {
                navLocation = null;
                break;
            }
            case 2: 
            case 3: 
            case 4: {
                navLocation = poiSearchArea.getLocation();
                if (navLocation == null || !navLocation.isPositionValid()) {
                    navigationEnv.getPOILogChannel().log(10000, "PoiUtil#getLocation() - failed to resolve navigable destination: %1!", (Object)LocationFormatter.formatLocationShort(navLocation));
                    navLocation = null;
                    break;
                }
                navLocation = PoiUtil.transformLocationBySurrounding(navLocation);
                break;
            }
            case 5: {
                navLocation = poiSearchArea.getLocation();
                if (navLocation != null && !Util.isEmpty(navLocation.getCountry())) break;
                navLocation = null;
                navigationEnv.getPOILogChannel().log(10000, "PoiUtil#getLocation() - failed to resolve navigable destination: %1!", (Object)LocationFormatter.formatLocationShort(navLocation));
                break;
            }
            default: {
                navigationEnv.getPOILogChannel().log(10000, "PoiUtil#getLocation() - failed to resolve PoiSearchArea: %1!", (long)poiSearchArea.getSearchContext());
                navLocation = null;
            }
        }
        navigationEnv.getPOILogChannel().log(-2137614336, "PoiUtil#getLocation() - location: %1", (Object)navLocation);
        return navLocation;
    }

    private static NavLocation transformLocationBySurrounding(NavLocation navLocation) {
        int n = navLocation.getLongitude();
        int n2 = navLocation.getLatitude();
        navLocation = Util.getLocationFromGeoPos(n, n2);
        return navLocation;
    }

    public static void callPoi(NavLocation navLocation, NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory, ITelService iTelService) {
        LogChannel logChannel = navigationEnv.getPOILogChannel();
        logChannel.log(-2137614336, "PoiUtil#callPoi - location=%1", (Object)navLocation);
        CallPhoneNumberSequence callPhoneNumberSequence = new CallPhoneNumberSequence(iCommandListFactory);
        callPhoneNumberSequence.start(logChannel, navLocation, iTelService);
    }

    public static void callPoi(LIValueListElement lIValueListElement, NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory, ITelService iTelService) {
        LogChannel logChannel = navigationEnv.getPOILogChannel();
        logChannel.log(-2137614336, "PoiUtil#callPoi - liValueListElement=%1", (Object)lIValueListElement);
        CallPhoneNumberSequence callPhoneNumberSequence = new CallPhoneNumberSequence(iCommandListFactory);
        callPhoneNumberSequence.start(logChannel, lIValueListElement, iTelService);
    }

    public static boolean checkIfPoiIsCallable(NavLocation navLocation, NavigationEnv navigationEnv) {
        LogChannel logChannel = navigationEnv.getPOILogChannel();
        logChannel.log(-2137614336, "PoiUtil#checkIfPoiIsCallable for location=%1", (Object)LocationFormatter.formatLocationShort(navLocation));
        String string = LocationFormatter.getPhoneNumber(navLocation);
        if (Util.isEmpty(string)) {
            logChannel.log(-2137614336, "PoiUtil#checkIfPoiIsCallable - location has NO phonenumber");
            return false;
        }
        logChannel.log(-2137614336, "PoiUtil#checkIfPoiIsCallable - location has phonenumber %1", (Object)string);
        return true;
    }

    public static boolean useFreeTextSearch(NavigationEnv navigationEnv) {
        return navigationEnv.getFramework().getSysConst(4433) == 0;
    }

    public static boolean useNvcTextSearch(NavigationEnv navigationEnv) {
        return navigationEnv.getFramework().getSysConst(4433) == 1;
    }

    public static boolean substringSearchStarted(ValueListStatus valueListStatus) {
        return valueListStatus != null && PoiUtil.substringSearchIsRunning(valueListStatus) && valueListStatus.getDistance() == 0 && valueListStatus.getNumberOfAvailableItems() == 0;
    }

    public static boolean substringSearchIsRunning(ValueListStatus valueListStatus) {
        return valueListStatus != null && valueListStatus.getStatus() == 2;
    }

    public static boolean substringSearchHasItems(int n, ValueListStatus valueListStatus) {
        return valueListStatus != null && valueListStatus.getNumberOfAvailableItems() >= n;
    }

    public static boolean substringSearchEnded(ValueListStatus valueListStatus) {
        return valueListStatus != null && valueListStatus.getStatus() == 3;
    }
}

