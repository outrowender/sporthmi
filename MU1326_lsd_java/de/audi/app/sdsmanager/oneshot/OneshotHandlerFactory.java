/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.oneshot;

import de.audi.app.sdsmanager.common.Logger;
import de.audi.app.sdsmanager.nbest.IPicklist;
import de.audi.app.sdsmanager.oneshot.IOneshotPicklistHandling;
import de.audi.app.sdsmanager.oneshot.MediaG2POneshotHandler;
import de.audi.app.sdsmanager.oneshot.NaviOneshotHandler;
import de.audi.app.sdsmanager.oneshot.OneshotDestinationTypeMapperJP;
import de.audi.app.sdsmanager.oneshot.OneshotDestinationTypeMapperKR;
import de.audi.app.sdsmanager.oneshot.OneshotDestinationTypeMapperMediaG2P;
import de.audi.app.sdsmanager.oneshot.OneshotDestinationTypeMapperVDE;
import de.audi.app.sdsmanager.oneshot.OneshotFilterStrategy;
import de.audi.app.sdsmanager.oneshot.OneshotHandler;
import de.audi.app.sdsmanager.oneshot.OneshotListModeMapperMediaG2P;
import de.audi.app.sdsmanager.oneshot.OneshotListModeMapperPoiCity;
import de.audi.app.sdsmanager.oneshot.OneshotListModeMapperVDE;
import de.audi.app.sdsmanager.oneshot.OneshotListModeMapperVDEEUNAR;
import de.audi.app.sdsmanager.oneshot.OneshotPicklistHandlingCN;
import de.audi.app.sdsmanager.oneshot.OneshotPicklistHandlingJP;
import de.audi.app.sdsmanager.oneshot.OneshotPicklistHandlingKR;
import de.audi.app.sdsmanager.oneshot.OneshotPicklistHandlingPOICity;
import de.audi.app.sdsmanager.oneshot.OneshotPicklistHandlingVDE;
import de.audi.app.sdsmanager.oneshot.OneshotVDEEUNARFilterStrategy;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.HMIService;

public class OneshotHandlerFactory {
    private OneshotHandler[] usecases = new OneshotHandler[4];

    public OneshotHandlerFactory(IFrameworkAccess iFrameworkAccess) {
        HMIService hMIService = iFrameworkAccess.getHMIService();
        this.usecases[0] = iFrameworkAccess.isCn() || iFrameworkAccess.isTaiwan() ? new NaviOneshotHandler(hMIService, 3, new OneshotPicklistHandlingCN(hMIService), new OneshotListModeMapperVDEEUNAR(), new OneshotDestinationTypeMapperVDE(), new OneshotFilterStrategy(Logger.getAppNaviLog()), new String[]{"SDS_ONE_SHOT_CITY", "SDS_ONE_SHOT_STREET", "SDS_ONE_SHOT_HOUSENUMBER"}, new int[]{295, 297, 296}) : (iFrameworkAccess.isJp() ? new NaviOneshotHandler(hMIService, 5, new OneshotPicklistHandlingJP(hMIService), new OneshotListModeMapperVDE(), new OneshotDestinationTypeMapperJP(), new OneshotFilterStrategy(Logger.getAppNaviLog()), new String[]{"SDS_ONE_SHOT_PREFECTURE", "SDS_ONE_SHOT_CITY", "SDS_ONE_SHOT_PLACENAME", "SDS_ONE_SHOT_CHOME", "SDS_ONE_SHOT_HOUSENUMBER"}, new int[]{4279, 4278, 4280, 4281, 4282}) : (iFrameworkAccess.isKorea() ? new NaviOneshotHandler(hMIService, 5, new OneshotPicklistHandlingKR(hMIService), new OneshotListModeMapperVDE(), new OneshotDestinationTypeMapperKR(), new OneshotFilterStrategy(Logger.getAppNaviLog()), new String[]{"SDS_ONE_SHOT_PROVINCE", "SDS_ONE_SHOT_CITY", "SDS_ONE_SHOT_SUBMUNICIPALTOWN_AND_STREET", "SDS_ONE_SHOT_VILLAGE_AND_STREET", "SDS_ONE_SHOT_HOUSENUMBER"}, new int[]{4279, 4278, 4280, 4281, 4282}) : new NaviOneshotHandler(hMIService, 3, new OneshotPicklistHandlingVDE(hMIService), new OneshotListModeMapperVDEEUNAR(), new OneshotDestinationTypeMapperVDE(), new OneshotVDEEUNARFilterStrategy(Logger.getAppNaviLog()), new String[]{"SDS_ONE_SHOT_CITY", "SDS_ONE_SHOT_STREET", "SDS_ONE_SHOT_HOUSENUMBER"}, new int[]{295, 297, 296})));
        this.usecases[1] = new NaviOneshotHandler(hMIService, 2, new OneshotPicklistHandlingPOICity(hMIService), new OneshotListModeMapperPoiCity(), new OneshotDestinationTypeMapperVDE(), new OneshotFilterStrategy(Logger.getAppNaviLog()), new String[]{"SDS_ONE_SHOT_CITY", "SDS_ONE_SHOT_STREET", "SDS_ONE_SHOT_HOUSENUMBER"}, new int[]{3936, 295});
        this.usecases[2] = new MediaG2POneshotHandler(hMIService, 3, new IOneshotPicklistHandling(){

            public void handlePicklistTitle(int n) {
            }

            public int getSlotLevelOffset() {
                return 0;
            }
        }, new OneshotListModeMapperMediaG2P(), new OneshotDestinationTypeMapperMediaG2P(), new OneshotFilterStrategy(Logger.getAppMediaLog()), new int[]{4279, 4278, 4280});
        this.usecases[3] = this.usecases[2];
    }

    public OneshotHandler initializeUsecase(int n, IPicklist iPicklist) {
        if (n >= this.usecases.length) {
            return null;
        }
        OneshotHandler oneshotHandler = this.usecases[n];
        if (oneshotHandler == null) {
            return null;
        }
        oneshotHandler.initialize(iPicklist);
        return oneshotHandler;
    }
}

