/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo;

import de.audi.app.navi.evo.phonenumber.IPhonenumberService;
import de.audi.app.navi.evo.rml.RMLListener;
import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.interapp.online.IOnlineDestinationService;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.INavigationInputModeManager;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.IAddressInputForm;
import de.audi.tghu.navi.app.addressinput.poi.IPoiService;
import de.audi.tghu.navi.app.addressinput.tpegpoi.ITpegPOIService;
import de.audi.tghu.navi.app.destinationimport.NaviMyAudiImportImpl;
import de.audi.tghu.navi.app.di.mapcode.IMapcodeService;
import de.audi.tghu.navi.app.geocoordinput.GeoCoordInputManager;
import de.audi.tghu.navi.app.map.MapInterface;
import de.audi.tghu.navi.app.poi.online.IOnlineSearchForm;
import de.audi.tghu.navi.app.search.IntelliDestAccess;

public class NavigationContextHmiListener
implements ChoiceListener {
    private static final int MAP_CONTEXT_IDX_MAP = 0;
    private static final int MAP_CONTEXT_IDX_TRAFFIC = 1;
    private static final int MAP_CONTEXT_IDX_RML = 2;
    private static final int MAP_CONTEXT_IDX_POI_ALONG_ROUTE = 3;
    private static final int MAP_CONTEXT_IDX_TRAFFIC_VICS_JP = 4;
    private static final int MAP_CONTEXT_IDX_TPEG_MINI_MAPS_KR = 5;
    private static final int DEST_CONTEXT_IDX_INTELLIDEST = 0;
    private static final int DEST_CONTEXT_IDX_ADDRESSINPUT = 1;
    private static final int DEST_CONTEXT_IDX_FAVORITES = 2;
    private static final int DEST_CONTEXT_IDX_ADDRESSBOOK = 3;
    private static final int DEST_CONTEXT_IDX_POI = 4;
    private static final int DEST_CONTEXT_IDX_ONLINESEARCH = 5;
    private static final int DEST_CONTEXT_IDX_MYAUDI = 6;
    private static final int DEST_CONTEXT_IDX_PICNAV = 7;
    private static final int DEST_CONTEXT_IDX_GEOCOORDINATES = 8;
    private static final int DEST_CONTEXT_IDX_GAS_STATIONS = 9;
    private static final int DEST_CONTEXT_IDX_OPERATOR_CALL_CN = 10;
    private static final int DEST_CONTEXT_IDX_TPEG_POI_KR = 11;
    private static final int DEST_CONTEXT_IDX_TELEPHONE_JP_KR = 12;
    private static final int DEST_CONTEXT_IDX_MAPCODE_JP = 13;
    private final NavigationEnv env;
    private final INavigationInputModeManager navigationInputModeManager;
    private final IAddressInputForm addressInputService;
    private final GeoCoordInputManager geoCoordInputManager;
    private final IOnlineSearchForm onlineSearchForm;
    private final RMLListener rmlListener;
    private final IPoiService poiService;
    private final IMapcodeService mapcodeService;
    private final IPhonenumberService phonenumberService;
    private final ITpegPOIService tpegPOIService;
    private final IntelliDestAccess intelliDestController;
    private IOnlineDestinationService onlineDestinationService;
    private final NaviMyAudiImportImpl myAudiImporter;
    private final LogChannel logChannel;
    private final MapInterface mapInterface;

    public NavigationContextHmiListener(NavigationEnv navigationEnv, IAddressInputForm iAddressInputForm, GeoCoordInputManager geoCoordInputManager, IOnlineSearchForm iOnlineSearchForm, RMLListener rMLListener, IPoiService iPoiService, IMapcodeService iMapcodeService, IPhonenumberService iPhonenumberService, ITpegPOIService iTpegPOIService, IOnlineDestinationService iOnlineDestinationService, IntelliDestAccess intelliDestAccess, NaviMyAudiImportImpl naviMyAudiImportImpl, MapInterface mapInterface) {
        this.env = navigationEnv;
        this.navigationInputModeManager = navigationEnv.getInputModeManager();
        this.addressInputService = iAddressInputForm;
        this.geoCoordInputManager = geoCoordInputManager;
        this.onlineSearchForm = iOnlineSearchForm;
        this.rmlListener = rMLListener;
        this.poiService = iPoiService;
        this.mapcodeService = iMapcodeService;
        this.phonenumberService = iPhonenumberService;
        this.tpegPOIService = iTpegPOIService;
        this.onlineDestinationService = iOnlineDestinationService;
        this.intelliDestController = intelliDestAccess;
        this.myAudiImporter = naviMyAudiImportImpl;
        this.logChannel = navigationEnv.getLogChannel();
        this.mapInterface = mapInterface;
        this.listen();
    }

    private final void listen() {
        this.env.getChoiceModel(401415).setChoiceListener(this);
        this.env.getChoiceModel(401416).setChoiceListener(this);
    }

    public void itemSelected(int n, int n2, int n3, int n4) {
        this.logChannel.log(10000000, "NavigationContextHmiListener#itemSelected(modelID=%1, itemID=%2)", (long)n, (long)n2);
        if (n == 401415) {
            this.handleMapContextChange(n2);
        } else if (n == 401416) {
            this.handleDestContextChange(n2);
        } else {
            this.logChannel.log(100000, "NavigationContextHmiListener#itemSelected - unsupported modelID: %1", (long)n);
        }
        this.env.getChoiceModel(n).setValue(n2);
        this.env.getChoiceModel(n).fireEvent(n4);
    }

    private void handleMapContextChange(int n) {
        if (n != 0 && n != 1 && n != 4 && n != 5) {
            if (n == 2) {
                this.setInputModeManagerToStartRouteGuidanceStatus();
                this.rmlListener.enterRMLScreen();
            } else if (n == 3) {
                this.setInputModeManagerToStartRouteGuidanceStatus();
                this.setInputModeChoiceToNavigationValue();
                this.poiService.startPoiWithSearchContextAlongRoute();
            } else {
                this.logChannel.log(100000, "NavigationContextHmiListener#handleMapContextChange - unsupported itemID: %1", (long)n);
            }
        }
    }

    public void handleDestContextChange(int n) {
        this.mapInterface.getPreviewMap().setStoreFocusForEnterOnce(true);
        if (n == 0) {
            this.intelliDestController.enterDestinationContext(0);
            this.setInputModeManagerToStartRouteGuidanceStatus();
        } else if (n == 1) {
            this.setInputModeChoiceToNavigationValue();
            this.env.getChoiceModel(401824).setValue(0);
            this.setInputModeManagerToStartRouteGuidanceStatus();
            this.addressInputService.start();
        } else if (n == 2) {
            this.intelliDestController.enterDestinationContext(2);
            this.setInputModeManagerToStartRouteGuidanceStatus();
        } else if (n == 3) {
            this.env.getChoiceModel(401416).setValue(n);
        } else if (n == 4) {
            this.setInputModeManagerToStartRouteGuidanceStatus();
            this.setInputModeChoiceToNavigationValue();
            this.poiService.startPoiWithSearchContextLocationVicinity();
        } else if (n == 5) {
            this.setInputModeManagerToStartRouteGuidanceStatus();
            this.onlineSearchForm.enterOnlineSearchForm();
        } else if (n == 6) {
            this.setInputModeManagerToStartRouteGuidanceStatus();
            if (this.onlineDestinationService != null) {
                this.onlineDestinationService.enterOnlineDestinationHandling();
                this.myAudiImporter.enterOnlineDestinationHandling();
            } else {
                this.logChannel.log(10000, "NavigationContextHmiListener#handleDestContextChange onlineDestinationService is null");
            }
        } else if (n != 7) {
            if (n == 8) {
                this.setInputModeManagerToStartRouteGuidanceStatus();
                this.setInputModeChoiceToNavigationValue();
                this.geoCoordInputManager.enterWithCCPAsCoordinates();
            } else if (n != 9) {
                if (n == 10) {
                    this.setInputModeManagerToStartRouteGuidanceStatus();
                } else if (n == 11) {
                    this.setInputModeManagerToStartRouteGuidanceStatus();
                    this.setInputModeChoiceToNavigationValue();
                    if (this.tpegPOIService != null) {
                        this.tpegPOIService.startTpegPOI();
                    } else {
                        this.logChannel.log(100000, "NavigationContextHmiListener#handleDestContextChange - no TPEG POI service is available.");
                    }
                } else if (n == 12) {
                    this.setInputModeManagerToStartRouteGuidanceStatus();
                    this.setInputModeChoiceToNavigationValue();
                    if (this.phonenumberService != null) {
                        this.phonenumberService.enterPhonenumberScreen();
                    } else {
                        this.logChannel.log(100000, "NavigationContextHmiListener#handleDestContextChange - no phone number service is available.");
                    }
                } else if (n == 13) {
                    this.setInputModeManagerToStartRouteGuidanceStatus();
                    this.setInputModeChoiceToNavigationValue();
                    if (this.mapcodeService != null) {
                        this.mapcodeService.enterMapcodeScreen();
                    } else {
                        this.logChannel.log(100000, "NavigationContextHmiListener#handleDestContextChange - no map code service is available.");
                    }
                } else {
                    this.logChannel.log(100000, "NavigationContextHmiListener#handleDestContextChange - unsupported itemID: %1", (long)n);
                }
            }
        }
    }

    private void setInputModeChoiceToNavigationValue() {
        this.env.getChoiceModel(170).setValue(0);
    }

    private void setInputModeManagerToStartRouteGuidanceStatus() {
        this.navigationInputModeManager.setInputMode(0, this.env);
    }

    public void keyPressed(int n, int n2, int n3) {
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void keyTyped(int n, int n2, int n3) {
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }

    public void itemFocused(int n, int n2, int n3, int n4) {
        this.logChannel.log(10000000, "NavigationContextHmiListener#itemFocused(modelID=%1, itemID=%2)", (long)n, (long)n2);
    }

    public void setOnlineDestinationService(IOnlineDestinationService iOnlineDestinationService) {
        this.onlineDestinationService = iOnlineDestinationService;
    }
}

