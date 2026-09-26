/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.navi;

import de.audi.app.sdsmanager.apps.ISDSApplication;
import de.audi.app.sdsmanager.grammar.ITTSASR;
import de.audi.app.sdsmanager.nbest.IPicklist;
import de.audi.app.sdsmanager.nbest.IPicklistElement;
import de.audi.app.sdsmanager.nbest.IPicklistSlot;
import de.audi.app.sdsmanager.oneshot.NaviOneshotHandler;
import de.audi.app.sdsmanager.oneshot.OneshotHandler;
import de.audi.atip.interapp.ADBSDSService;
import de.audi.atip.interapp.AppInfoKrService;
import de.audi.atip.interapp.MapService;
import de.audi.atip.interapp.NaviSDSPOIOnlineService;
import de.audi.atip.interapp.NaviSDSPOIOnlineServiceListener;
import de.audi.atip.interapp.NaviService;
import de.audi.atip.interapp.NaviService$OneshotData;
import de.audi.atip.interapp.NaviServiceListener;
import de.audi.atip.interapp.SDSListEntry;
import de.audi.atip.interapp.car.ICarRemainingRangeListener;
import de.audi.atip.interapp.online.IOnlineDestinationService;
import de.audi.atip.interapp.online.IOnlineSDSMyAudiService;
import de.audi.atip.interapp.online.IOperatorCallSDSService;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.speechrec.NBestList;
import org.dsi.ifc.speechrec.VDECapabilities;

public interface NaviSDSHandler
extends ISDSApplication,
ICarRemainingRangeListener {
    public static final byte LEVEL_1;
    public static final byte LEVEL_2;
    public static final byte LEVEL_3;
    public static final byte LEVEL_4;
    public static final byte MAX_LEVEL_SIZE;
    public static final byte POSTCODE_NUMERIC;
    public static final byte POSTCODE_ALPHANUMERIC;
    public static final byte LDC_HANDLING_NORMAL;
    public static final byte LDC_HANDLING_FORCE_LDC_IS_SL;
    public static final byte LDC_HANDLING_FORCE_LDC_IS_NOT_SL;

    default public void setNaviService(NaviService naviService) {
    }

    default public NaviService getNaviService() {
    }

    default public void setADBService(ADBSDSService aDBSDSService) {
    }

    default public void setOperatorCallService(IOperatorCallSDSService iOperatorCallSDSService) {
    }

    default public IOperatorCallSDSService getOperatorCallService() {
    }

    default public void unsetNaviService() {
    }

    default public void unsetADBService() {
    }

    default public void unsetOperatorCallService() {
    }

    default public void setOnlineDestinationService(IOnlineDestinationService iOnlineDestinationService) {
    }

    default public void unsetOnlineDestinationService() {
    }

    default public void setPOIOnlineService(NaviSDSPOIOnlineService naviSDSPOIOnlineService) {
    }

    default public void unsetPOIOnlineService() {
    }

    default public void setMapService(MapService mapService) {
    }

    default public void unsetMapService() {
    }

    default public void setMyAudiService(IOnlineSDSMyAudiService iOnlineSDSMyAudiService) {
    }

    default public void unsetMyAudiService() {
    }

    default public void responseVDECapabilities(int n, VDECapabilities vDECapabilities, String string) {
    }

    default public void reloadSUIVDERelatedGrammars() {
    }

    default public void reloadTruffleVDERelatedGrammars() {
    }

    default public void responseDeleteLastTrufflesSearchText(int n, NBestList nBestList) {
    }

    default public void responseClearTrufflesSearchHistory(int n) {
    }

    default public byte getSDSAddressInputMode() {
    }

    default public void setSDSAddressInputMode(byte by) {
    }

    default public boolean usesAltRouteCalc() {
    }

    default public void setUseAltRouteCalc(boolean bl) {
    }

    default public void markCurrentPOIUsedFor(byte by) {
    }

    default public void setSpeechDSIStatus(boolean bl) {
    }

    default public byte poiOnlineVoiceDataAvailable() {
    }

    default public NaviServiceListener getNaviServiceListener() {
    }

    default public NaviSDSPOIOnlineServiceListener getPOIOnlineServiceListener() {
    }

    default public void setSuggestions(boolean bl) {
    }

    default public void updateDestinationCountryCode(String string, String string2) {
    }

    default public void updateDestinationStateCode(String string, String string2) {
    }

    default public void setLastDestinations(SDSListEntry[] sDSListEntryArray) {
    }

    default public void setFavoriteDestinations(SDSListEntry[] sDSListEntryArray) {
    }

    default public String getLastDestination(long l) {
    }

    default public String getLastDestinationByIndex(int n) {
    }

    default public String getFavoriteDestination(long l) {
    }

    default public String getFavoriteDestinationByIndex(int n) {
    }

    default public NaviService$OneshotData getOneshotData(byte by) {
    }

    default public void setOneshotData(NaviService$OneshotData naviService$OneshotData, byte by) {
    }

    default public boolean setOneshotData(int n) {
    }

    default public void storeUniqueOneshotData(byte by, byte by2, int n, int n2, int n3) {
    }

    default public byte getNextPicklistSizeType(byte by, boolean bl) {
    }

    default public OneshotHandler initializeOneshotHandler(int n) {
    }

    default public NaviOneshotHandler getOneshotHandler() {
    }

    default public String[] getOneshotFilterStrings(byte by) {
    }

    default public boolean initializeEntryPicklist() {
    }

    default public void setMyAudiContacts(SDSListEntry[] sDSListEntryArray) {
    }

    default public void storeMyAudiContact(AdbEntry adbEntry) {
    }

    default public SDSListEntry getMyAudiContactById(long l) {
    }

    default public SDSListEntry getMyAudiContactByIndex(int n) {
    }

    default public AdbEntry getCurrentMyAudiContact() {
    }

    default public byte getPickListMode() {
    }

    default public void setTTSASR(ITTSASR iTTSASR) {
    }

    default public void setPoiOnlineDestination(NavLocation navLocation) {
    }

    default public NavLocation getPoiOnlineDestination() {
    }

    default public void setPickListMode(byte by) {
    }

    default public IPicklist getEntryPicklist() {
    }

    default public boolean storePOILineData(int n) {
    }

    default public boolean storePOIPickList(IPicklist iPicklist) {
    }

    default public boolean storeSUIData(IPicklistElement iPicklistElement, boolean bl) {
    }

    default public void setLDCHandling(byte by) {
    }

    default public void updateVDEMediumState(int n) {
    }

    default public void setSpokenHouseNumberUnresolved(IPicklistSlot iPicklistSlot) {
    }

    default public IPicklistSlot getSpokenHouseNumberUnresolved() {
    }

    default public void setAppInfoKrService(AppInfoKrService appInfoKrService) {
    }

    default public void unsetAppInfoKrService() {
    }

    default public void setAIFCountry(boolean bl) {
    }

    default public boolean getAIFCountry() {
    }

    default public NaviSDSPOIOnlineService getPOIOnlineService() {
    }
}

