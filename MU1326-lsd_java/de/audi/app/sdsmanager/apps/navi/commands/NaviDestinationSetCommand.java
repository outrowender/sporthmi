/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.navi.commands;

import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.apps.navi.NaviSDSHandlerImpl;
import de.audi.app.sdsmanager.apps.navi.NaviSDSUtils;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.nbest.IPicklistSlot;
import de.audi.app.sdsmanager.nbest.NBestStorageAccess;
import de.audi.app.sdsmanager.oneshot.NaviOneshotHandler;
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.interapp.NaviService;
import de.audi.atip.interapp.NaviService$OneshotData;
import de.audi.atip.interapp.online.IOperatorCallSDSService;
import de.audi.atip.log.LogChannel;
import java.util.HashMap;
import java.util.Map;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.online.OperatorCallResult;
import org.dsi.ifc.organizer.AdbEntry;

public class NaviDestinationSetCommand
extends AbstractSystemCallCommand {
    private final NaviSDSHandlerImpl sdsHandler;
    private final IOperatorCallSDSService operatorCallService;
    protected final NaviService naviService;
    private final NBestStorageAccess nBestStorage;
    protected final byte destinationType;

    public NaviDestinationSetCommand(LogChannel logChannel, String string, SDSHandlerService sDSHandlerService, ISystemCallParameter[] iSystemCallParameterArray, NaviSDSHandlerImpl naviSDSHandlerImpl, NaviService naviService, IOperatorCallSDSService iOperatorCallSDSService, NBestStorageAccess nBestStorageAccess) {
        super(logChannel, string, sDSHandlerService);
        this.sdsHandler = naviSDSHandlerImpl;
        this.naviService = naviService;
        this.operatorCallService = iOperatorCallSDSService;
        this.nBestStorage = nBestStorageAccess;
        this.destinationType = (byte)SDSUtils.retrieveInteger(iSystemCallParameterArray, 0);
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "[%1#execute] destinationType=%2!", (Object)this.getName(), (long)this.destinationType);
        if (NaviSDSUtils.isOneShotActive(this.destinationType)) {
            this.sdsHandler.setSDSAddressInputMode((byte)1);
            this.processDestinationSetOneshot();
            return;
        }
        switch (this.destinationType) {
            case 23: {
                this.processDestinationSetPoiOnline();
                break;
            }
            case 26: {
                this.processDestinationSetPoiOneshot();
                break;
            }
            case 27: {
                this.processMyAudiContact();
                break;
            }
            case 29: 
            case 45: {
                this.processDestinationSetOperatorCall(2);
                break;
            }
            case 36: {
                this.processDestinationSetOperatorCall(1);
                break;
            }
            case 30: {
                this.processDestinationSetHnPatternsCNTW(true);
                break;
            }
            case 31: {
                this.processDestinationSetHnPatternsCNTW(false);
                break;
            }
            case 20: {
                this.processDestinationSetCountryAndState();
                break;
            }
            case 35: {
                this.processDestinationSetMapCodeNormalRoad();
                break;
            }
            case 42: {
                this.processDestinationSetMapCodeSpecialRoad();
                break;
            }
            case 37: 
            case 43: {
                this.processDestinationSetPhoneNumber();
                break;
            }
            default: {
                this.sdsHandler.setSDSAddressInputMode((byte)1);
                this.processDestinationSetStepByStep();
            }
        }
    }

    private void processDestinationSetPoiOnline() {
        this.logger.log(-2137614336, "[%1#processDestinationSetPoiOnline]", (Object)this.getName());
        this.sdsHandler.setSDSAddressInputMode((byte)4);
        NavLocation navLocation = this.sdsHandler.getPoiOnlineDestination();
        if (navLocation == null) {
            this.logger.log(10000, "[%1#processDestinationSetPoiOnline] navLocation is null!", (Object)this.getName());
            this.sendResult(3001);
            return;
        }
        SDSModelAccess.setListLineDataGetModel(this.naviService.getPoiName(navLocation));
        this.naviService.setLocation(navLocation);
    }

    private void processMyAudiContact() {
        this.logger.log(-2137614336, "[%1#processMyAudiContact]", (Object)this.getName());
        int n = Math.max(0, this.sdsHandlerService.getSelectedRow());
        AdbEntry adbEntry = this.sdsHandler.getCurrentMyAudiContact();
        this.logger.log(-2137614336, "[%1#processMyAudiContact] contact=%2, addressIndex=%3", (Object)this.getName(), (Object)(adbEntry == null ? "null" : adbEntry.getCombinedName()), (long)n);
        this.sendResult(3001);
    }

    private void processDestinationSetPoiOneshot() {
        this.logger.log(-2137614336, "[%1#processDestinationSetPoiOneshot] destinationType=%2", (Object)this.getName(), (long)this.destinationType);
        NaviService$OneshotData naviService$OneshotData = this.sdsHandler.getOneshotData((byte)1);
        String string = SDSUtils.isEmpty(naviService$OneshotData) ? "" : naviService$OneshotData.getText();
        String string2 = SDSUtils.isEmpty(naviService$OneshotData) ? "" : naviService$OneshotData.getStringId();
        SDSModelAccess.setOneshotCityLabel(string);
        NaviService$OneshotData naviService$OneshotData2 = this.sdsHandler.getOneshotData((byte)0);
        String string3 = SDSUtils.isEmpty(naviService$OneshotData2) ? "" : naviService$OneshotData2.getText();
        SDSModelAccess.setOneshotPoiLabel(string3);
        this.naviService.setCity(string, string2);
    }

    private void processDestinationSetOperatorCall(int n) {
        this.logger.log(-2137614336, "[%1#processDestinationSetOperatorCall] serviceType %2", (Object)this.getName(), (long)n);
        int n2 = this.destinationType == 45 ? 0 : this.sdsHandlerService.getSelectedRow();
        this.sdsHandler.setSDSAddressInputMode((byte)4);
        OperatorCallResult operatorCallResult = this.operatorCallService.getPoiOfIndexForSDS(n, n2);
        this.naviService.setLocation(operatorCallResult);
    }

    private void processDestinationSetHnPatternsCNTW(boolean bl) {
        int n = 0;
        if (bl) {
            n = this.nBestStorage.getLastRecogLine();
        }
        this.logger.log(-2137614336, "[%1#processDestinationSetHnPatternsCNTW] set line index %2", (Object)this.getName(), (long)n);
        this.naviService.setHouseNumberByIndex(n);
    }

    private void processDestinationSetOneshot() {
        this.logger.log(-2137614336, "[%1#processDestinationSetOneshot] destinationType=%2", (Object)this.getName(), (long)this.destinationType);
        NaviOneshotHandler naviOneshotHandler = this.sdsHandler.getOneshotHandler();
        if (naviOneshotHandler != null) {
            this.processDestinationSetOneshotViaHandler();
            return;
        }
        NaviService$OneshotData naviService$OneshotData = this.sdsHandler.getOneshotData((byte)0);
        NaviService$OneshotData naviService$OneshotData2 = this.sdsHandler.getOneshotData((byte)1);
        NaviService$OneshotData naviService$OneshotData3 = this.sdsHandler.getOneshotData((byte)2);
        String string = SDSUtils.isEmpty(naviService$OneshotData) ? "" : naviService$OneshotData.getText();
        String string2 = SDSUtils.isEmpty(naviService$OneshotData2) ? "" : naviService$OneshotData2.getText();
        String string3 = SDSUtils.isEmpty(naviService$OneshotData3) ? "" : naviService$OneshotData3.getText();
        SDSModelAccess.setOneshotCityLabel(string);
        SDSModelAccess.setOneshotStreetLabel(string2);
        SDSModelAccess.setOneshotHouseNRLabel(string3);
        HashMap hashMap = new HashMap(3);
        switch (this.destinationType) {
            case 10: 
            case 102: {
                hashMap.put("SDS_ONE_SHOT_CITY", naviService$OneshotData);
                hashMap.put("SDS_ONE_SHOT_STREET", naviService$OneshotData2);
                hashMap.put("SDS_ONE_SHOT_HOUSENUMBER", naviService$OneshotData3);
                break;
            }
            case 2: 
            case 101: {
                hashMap.put("SDS_ONE_SHOT_CITY", naviService$OneshotData);
                hashMap.put("SDS_ONE_SHOT_STREET", naviService$OneshotData2);
                break;
            }
            case 1: 
            case 22: 
            case 100: {
                hashMap.put("SDS_ONE_SHOT_CITY", naviService$OneshotData);
                break;
            }
            default: {
                this.logger.log(-1601830656, "[%1#processDestinationSetOneshot] Unhandled destType %2, sending ERROR!", (Object)this.getName(), (long)this.destinationType);
                this.sendResult(3001);
            }
        }
        this.logger.log(-2137614336, "[%1#processDestinationSetOneshot] sending OneShot-Map to NaviService: %2!", (Object)this.getName(), (Object)((Object)hashMap).toString());
        this.naviService.setOneShotData(hashMap);
    }

    private void processDestinationSetOneshotViaHandler() {
        this.logger.log(-2137614336, "[%1#processDestinationSetOneshotViaHandler] destinationType=%2", (Object)this.getName(), (long)this.destinationType);
        Map map = this.sdsHandler.getOneshotHandler().createOneshotDataMap(this.destinationType);
        if (SDSUtils.isEmpty(map)) {
            this.sendResult(3001);
            return;
        }
        this.logger.log(-2137614336, "[%1#processDestinationSetOneshot] sending OneShot-Map to NaviService: %2!", (Object)this.getName(), (Object)map.toString());
        this.naviService.setOneShotData(map);
    }

    private void processDestinationSetStepByStep() {
        this.logger.log(-2137614336, "[%1#processDestinationSetStepByStep] destinationType=%2", (Object)this.getName(), (long)this.destinationType);
        String string = SDSModelAccess.getListLineDataGetModel();
        String string2 = SDSModelAccess.getSlotModelID(1);
        NaviOneshotHandler naviOneshotHandler = this.sdsHandler.getOneshotHandler();
        if (naviOneshotHandler != null) {
            naviOneshotHandler.setOneshotLabelModelForDestinationType(this.destinationType, string);
        }
        this.logger.log(-2137614336, "[%1#processDestinationSetStepByStep] destSlot1=%2, destSlot1StringID=%3!", (Object)this.getName(), (Object)string, (Object)string2);
        switch (this.destinationType) {
            case 3: 
            case 12: {
                this.logger.log(-2137614336, "[%1#processDestinationSetStepByStep] Setting city!", (Object)this.getName());
                this.naviService.setCity(string, string2);
                SDSModelAccess.setOneshotCityLabel(string);
                break;
            }
            case 6: {
                this.logger.log(-2137614336, "[%1#processDestinationSetStepByStep] Setting center!", (Object)this.getName());
                this.naviService.setCenter();
                break;
            }
            case 4: {
                this.logger.log(-2137614336, "[%1#processDestinationSetStepByStep] Setting country!", (Object)this.getName());
                this.naviService.setCountry(string, string2);
                this.sdsHandler.setAIFCountry(true);
                break;
            }
            case 13: 
            case 15: {
                this.logger.log(-2137614336, "[%1#processDestinationSetStepByStep] Setting street!", (Object)this.getName());
                this.naviService.setStreet(string, string2);
                SDSModelAccess.setOneshotStreetLabel(string);
                break;
            }
            case 7: {
                this.logger.log(-2137614336, "[%1#processDestinationSetStepByStep] Setting house number!", (Object)this.getName());
                this.naviService.setHouseNumber(string, string2);
                SDSModelAccess.setOneshotHouseNRLabel(string);
                break;
            }
            case 19: {
                String string3 = SDSUtils.remove(string, ' ');
                this.logger.log(-2137614336, "[%1#processDestinationSetStepByStep] Setting ZIP code %2!", (Object)this.getName(), (Object)string3);
                this.naviService.setZIPCode(string3, string2);
                break;
            }
            case 5: {
                this.logger.log(-2137614336, "[%1#processDestinationSetStepByStep] Setting state!", (Object)this.getName());
                this.naviService.setState(string, string2);
                SDSModelAccess.setOneShotStateLabel(string);
                break;
            }
            case 8: 
            case 21: {
                this.logger.log(-2137614336, "[%1#processDestinationSetStepByStep] Setting junction!", (Object)this.getName());
                this.naviService.setJunction(string, string2);
                break;
            }
            case 32: {
                this.logger.log(-2137614336, "[%1#processDestinationSetStepByStep] Setting prefecture!", (Object)this.getName());
                this.naviService.setPrefecture(string, string2);
                break;
            }
            case 33: {
                this.logger.log(-2137614336, "[%1#processDestinationSetStepByStep] Setting place name!", (Object)this.getName());
                this.naviService.setPlacename(string, string2);
                break;
            }
            case 34: {
                this.logger.log(-2137614336, "[%1#processDestinationSetStepByStep] Setting chome!", (Object)this.getName());
                this.naviService.setChome(string, string2);
                break;
            }
            case 99: {
                this.logger.log(-2137614336, "[%1#processDestinationSetStepByStep] Updating detail screen info!", (Object)this.getName());
                this.naviService.updateDetailScreenInfo();
                break;
            }
            case 38: {
                this.logger.log(-2137614336, "[%1#processDestinationSetStepByStep] Setting province/metro!", (Object)this.getName());
                this.naviService.setProvince(string, string2);
                break;
            }
            case 39: {
                this.logger.log(-2137614336, "[%1#processDestinationSetStepByStep] Setting ward/general ward!", (Object)this.getName());
                this.naviService.setWard(string, string2);
                break;
            }
            case 40: {
                this.logger.log(-2137614336, "[%1#processDestinationSetStepByStep] Setting town!", (Object)this.getName());
                this.naviService.setSubmunicipaltownOrStreet(string, string2);
                break;
            }
            case 41: {
                this.logger.log(-2137614336, "[%1#processDestinationSetStepByStep] Setting village!", (Object)this.getName());
                this.naviService.setVillageAndStreet(string, string2);
                break;
            }
            default: {
                this.logger.log(-1601830656, "[%1#processDestinationSetStepByStep] Unhandled destType %2, sending ERROR!", (Object)this.getName(), (long)this.destinationType);
                this.sendResult(3001);
            }
        }
    }

    private void processDestinationSetCountryAndState() {
        this.logger.log(-2137614336, "[%1#processDestinationSetCountryAndState] destinationType=%2", (Object)this.getName(), (long)this.destinationType);
        IPicklistSlot iPicklistSlot = SDSUtils.getSelectedSlot(this.nBestStorage, this.logger, 0);
        if (iPicklistSlot == null) {
            this.sendResult(3001);
            return;
        }
        String string = iPicklistSlot.getText();
        String string2 = iPicklistSlot.getObjectStringID();
        SDSModelAccess.setOneShotCountryLabel(string);
        IPicklistSlot iPicklistSlot2 = SDSUtils.getSelectedSlot(this.nBestStorage, this.logger, 1);
        String string3 = iPicklistSlot2 == null ? "" : iPicklistSlot2.getText();
        String string4 = iPicklistSlot2 == null ? "" : iPicklistSlot2.getObjectStringID();
        SDSModelAccess.setOneShotStateLabel(string3);
        this.naviService.setCountryAndState(string, string2, string3, string4);
    }

    private void processDestinationSetMapCodeNormalRoad() {
        BaseListModelApp baseListModelApp = SDSModelAccess.getSDSNaviPicklistBaseList();
        int n = baseListModelApp.getLength();
        if (n == 1) {
            this.naviService.selectDisambiguatedMapCodeByIndex(0);
        } else if (n == 2) {
            if (baseListModelApp.getRow(0).getInteger(4) == 6) {
                this.naviService.selectDisambiguatedMapCodeByIndex(0);
            } else {
                this.naviService.selectDisambiguatedMapCodeByIndex(1);
            }
        } else {
            this.logger.log(-2137614336, "[%1#processDestinationSetMapCodeNormalRoad] invalid SDSNaviPicklistBaseList length: %2", (Object)this.getName(), (long)n);
        }
    }

    private void processDestinationSetMapCodeSpecialRoad() {
        BaseListModelApp baseListModelApp = SDSModelAccess.getSDSNaviPicklistBaseList();
        int n = baseListModelApp.getLength();
        if (n == 1) {
            this.naviService.selectDisambiguatedMapCodeByIndex(0);
        } else if (n == 2) {
            if (baseListModelApp.getRow(0).getInteger(4) != 6) {
                this.naviService.selectDisambiguatedMapCodeByIndex(0);
            } else {
                this.naviService.selectDisambiguatedMapCodeByIndex(1);
            }
        } else {
            this.logger.log(-2137614336, "[%1#processDestinationSetMapCodeSpecialRoad] invalid SDSNaviPicklistBaseList length: %2", (Object)this.getName(), (long)n);
        }
    }

    private void processDestinationSetPhoneNumber() {
        if (this.destinationType == 43) {
            this.naviService.selectTelephoneNumberByIndex(0);
        } else {
            int n = this.sdsHandlerService.getSelectedRow();
            this.logger.log(-2137614336, "[%1#execute] setting lineIndex = %2", (Object)this.getName(), (long)n);
            this.naviService.selectTelephoneNumberByIndex(n);
        }
    }

    protected void doPostResultAction() {
    }

    public void sdsDestinationSetResult(byte by) {
        this.logger.log(-2137614336, "[%1#sdsDestinationSetResult] result=%2", (Object)this.getName(), (long)by);
        if (by == 0 && this.destinationType == 19) {
            NavLocation navLocation = this.naviService.getCurrentNavLocation();
            if (navLocation == null) {
                this.logger.log(-1601830656, "[%1#sdsDestinationSetResult] NavLocation is null -> no street for ZIP set?", (Object)this.getName());
            } else {
                SDSModelAccess.setNavInfoForLevel(navLocation.getTown(), 1);
            }
        }
        this.sdsHandler.setPickListMode((byte)-1);
        int n = NaviSDSUtils.getGenericSDSResult(by);
        this.sendResult(n);
    }
}

