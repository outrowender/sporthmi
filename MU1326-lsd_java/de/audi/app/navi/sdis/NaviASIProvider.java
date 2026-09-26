/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.sdis;

import de.audi.app.navi.sdis.NaviASIProvider$1;
import de.audi.app.navi.sdis.NaviASIProvider$2;
import de.audi.app.navi.sdis.NaviASIProvider$3;
import de.audi.app.navi.sdis.NaviASIProvider$NaviTabletServiceListener;
import de.audi.atip.agent.IASIProvider;
import de.audi.atip.interapp.NavigationUtilities;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.sdis.INaviTabletService;
import de.audi.tghu.navi.app.util.Util;
import de.esolutions.fw.comm.asi.hmisync.navigation.ASIHMISyncNavigationReply;
import de.esolutions.fw.comm.asi.hmisync.navigation.DestinationInfo;
import de.esolutions.fw.comm.asi.hmisync.navigation.impl.ASIHMISyncNavigationAbstractBaseService;
import de.esolutions.fw.comm.asi.hmisync.navigation.impl.ASIHMISyncNavigationService;
import de.esolutions.fw.comm.core.IService;
import de.esolutions.fw.comm.core.IStub;
import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.global.NavLocation;

public class NaviASIProvider
extends ASIHMISyncNavigationAbstractBaseService
implements IASIProvider {
    private final ASIHMISyncNavigationService naviService;
    private INaviTabletService tabletService;
    private final LogChannel logger;
    final NaviASIProvider$NaviTabletServiceListener naviTabletServiceListener = new NaviASIProvider$NaviTabletServiceListener(this, null);
    private volatile boolean startGuidanceSequenceActive = false;

    public NaviASIProvider(LogChannel logChannel) {
        this.logger = logChannel;
        this.naviService = new ASIHMISyncNavigationService(0, this);
        try {
            this.updateASIVersion("2.1.00");
            this.updateRequestIDs(new short[]{0, 1, 2, 5, 6, 7, 8});
            this.updateReplyIDs(new short[]{9, 10, 11, 12, 13, 15, 18, 19, 16});
        }
        catch (MethodException methodException) {
            logChannel.log(10000, "MediaSDISPlayerASIProvider - could not register ASI version!");
            methodException.printStackTrace();
        }
    }

    @Override
    public IService getService() {
        return this.naviService;
    }

    public void setTabletService(INaviTabletService iNaviTabletService) {
        this.tabletService = iNaviTabletService;
    }

    @Override
    public void startGuidanceToDestinations(DestinationInfo[] destinationInfoArray, ASIHMISyncNavigationReply aSIHMISyncNavigationReply) {
        if (this.tabletService == null || !this.tabletService.isReady()) {
            this.logger.log(-1601830656, "NaviASIProvider#startGuidanceToDestinations declined, tabletServcie not ready!");
            this.startGuidanceSequenceActive = false;
            aSIHMISyncNavigationReply.startGuidanceToDestinationsResult(2);
            return;
        }
        if (!this.startGuidanceSequenceActive) {
            this.startGuidanceSequenceActive = true;
            NaviASIProvider$1 naviASIProvider$1 = new NaviASIProvider$1(this, "NaviASIProvider - REPLY SDIS GuidanceStatus", aSIHMISyncNavigationReply);
            NaviASIProvider$2 naviASIProvider$2 = new NaviASIProvider$2(this, "NaviASIProvider - REPLY SDIS GuidanceStatus", aSIHMISyncNavigationReply);
            NavLocation[] navLocationArray = new NavLocation[destinationInfoArray.length];
            for (int i2 = 0; i2 < destinationInfoArray.length; ++i2) {
                this.logger.log(-2137614336, "NaviASIProvider transform DestinationInfo to NavLocation DestinationInfo = %1", (Object)destinationInfoArray[i2]);
                navLocationArray[i2] = Util.getLocationFromGeoPos(NavigationUtilities.degreeToWgs84(destinationInfoArray[i2].longitude), NavigationUtilities.degreeToWgs84(destinationInfoArray[i2].latitude));
            }
            CommandList commandList = this.tabletService.getTransformCommandList(navLocationArray);
            commandList.add(new NaviASIProvider$3(this, destinationInfoArray, naviASIProvider$1, naviASIProvider$2));
            commandList.setErrorCommand(naviASIProvider$2);
            commandList.execute("NaviASIProvider#startGuidanceToDestinations");
            this.updateDestinationsForGuidance(destinationInfoArray);
        } else {
            this.logger.log(-1601830656, "NaviASIProvider#startGuidanceToDestinations() - guidance request already active, sending error");
            aSIHMISyncNavigationReply.startGuidanceToDestinationsResult(2);
        }
    }

    @Override
    public void attachStub(IStub iStub) {
        this.logger.log(1078071040, "'%1'", (Object)iStub);
    }

    @Override
    public void detachStub(IStub iStub) {
        this.logger.log(1078071040, "'%1'", (Object)iStub);
    }

    static /* synthetic */ boolean access$102(NaviASIProvider naviASIProvider, boolean bl) {
        naviASIProvider.startGuidanceSequenceActive = bl;
        return naviASIProvider.startGuidanceSequenceActive;
    }

    static /* synthetic */ INaviTabletService access$200(NaviASIProvider naviASIProvider) {
        return naviASIProvider.tabletService;
    }

    static /* synthetic */ LogChannel access$300(NaviASIProvider naviASIProvider) {
        return naviASIProvider.logger;
    }
}

