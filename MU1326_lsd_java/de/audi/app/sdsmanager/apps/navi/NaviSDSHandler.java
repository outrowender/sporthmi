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
    public static final byte LEVEL_1 = 0;
    public static final byte LEVEL_2 = 1;
    public static final byte LEVEL_3 = 2;
    public static final byte LEVEL_4 = 3;
    public static final byte MAX_LEVEL_SIZE = 4;
    public static final byte POSTCODE_NUMERIC = 0;
    public static final byte POSTCODE_ALPHANUMERIC = 1;
    public static final byte LDC_HANDLING_NORMAL = 0;
    public static final byte LDC_HANDLING_FORCE_LDC_IS_SL = 1;
    public static final byte LDC_HANDLING_FORCE_LDC_IS_NOT_SL = 2;

    public void setNaviService(NaviService var1);

    public NaviService getNaviService();

    public void setADBService(ADBSDSService var1);

    public void setOperatorCallService(IOperatorCallSDSService var1);

    public IOperatorCallSDSService getOperatorCallService();

    public void unsetNaviService();

    public void unsetADBService();

    public void unsetOperatorCallService();

    public void setOnlineDestinationService(IOnlineDestinationService var1);

    public void unsetOnlineDestinationService();

    public void setPOIOnlineService(NaviSDSPOIOnlineService var1);

    public void unsetPOIOnlineService();

    public void setMapService(MapService var1);

    public void unsetMapService();

    public void setMyAudiService(IOnlineSDSMyAudiService var1);

    public void unsetMyAudiService();

    public void responseVDECapabilities(int var1, VDECapabilities var2, String var3);

    public void reloadSUIVDERelatedGrammars();

    public void reloadTruffleVDERelatedGrammars();

    public void responseDeleteLastTrufflesSearchText(int var1, NBestList var2);

    public void responseClearTrufflesSearchHistory(int var1);

    public byte getSDSAddressInputMode();

    public void setSDSAddressInputMode(byte var1);

    public boolean usesAltRouteCalc();

    public void setUseAltRouteCalc(boolean var1);

    public void markCurrentPOIUsedFor(byte var1);

    public void setSpeechDSIStatus(boolean var1);

    public byte poiOnlineVoiceDataAvailable();

    public NaviServiceListener getNaviServiceListener();

    public NaviSDSPOIOnlineServiceListener getPOIOnlineServiceListener();

    public void setSuggestions(boolean var1);

    public void updateDestinationCountryCode(String var1, String var2);

    public void updateDestinationStateCode(String var1, String var2);

    public void setLastDestinations(SDSListEntry[] var1);

    public void setFavoriteDestinations(SDSListEntry[] var1);

    public String getLastDestination(long var1);

    public String getLastDestinationByIndex(int var1);

    public String getFavoriteDestination(long var1);

    public String getFavoriteDestinationByIndex(int var1);

    public NaviService.OneshotData getOneshotData(byte var1);

    public void setOneshotData(NaviService.OneshotData var1, byte var2);

    public boolean setOneshotData(int var1);

    public void storeUniqueOneshotData(byte var1, byte var2, int var3, int var4, int var5);

    public byte getNextPicklistSizeType(byte var1, boolean var2);

    public OneshotHandler initializeOneshotHandler(int var1);

    public NaviOneshotHandler getOneshotHandler();

    public String[] getOneshotFilterStrings(byte var1);

    public boolean initializeEntryPicklist();

    public void setMyAudiContacts(SDSListEntry[] var1);

    public void storeMyAudiContact(AdbEntry var1);

    public SDSListEntry getMyAudiContactById(long var1);

    public SDSListEntry getMyAudiContactByIndex(int var1);

    public AdbEntry getCurrentMyAudiContact();

    public byte getPickListMode();

    public void setTTSASR(ITTSASR var1);

    public void setPoiOnlineDestination(NavLocation var1);

    public NavLocation getPoiOnlineDestination();

    public void setPickListMode(byte var1);

    public IPicklist getEntryPicklist();

    public boolean storePOILineData(int var1);

    public boolean storePOIPickList(IPicklist var1);

    public boolean storeSUIData(IPicklistElement var1, boolean var2);

    public void setLDCHandling(byte var1);

    public void updateVDEMediumState(int var1);

    public void setSpokenHouseNumberUnresolved(IPicklistSlot var1);

    public IPicklistSlot getSpokenHouseNumberUnresolved();

    public void setAppInfoKrService(AppInfoKrService var1);

    public void unsetAppInfoKrService();

    public void setAIFCountry(boolean var1);

    public boolean getAIFCountry();

    public NaviSDSPOIOnlineService getPOIOnlineService();
}

