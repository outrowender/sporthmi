/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.sdis;

import de.audi.atip.agent.IASIProvider;
import de.audi.atip.interapp.NavigationUtilities;
import de.audi.atip.interapp.locationaccessor.IMyLocationAccessor;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.sdis.INaviTabletService;
import de.audi.tghu.navi.app.sdis.INaviTabletServiceListener;
import de.audi.tghu.navi.app.util.Util;
import de.audi.tghu.navi.app.util.addressformatting.AddressFormatter;
import de.esolutions.fw.comm.asi.hmisync.navigation.ASIHMISyncNavigationReply;
import de.esolutions.fw.comm.asi.hmisync.navigation.CarPosition;
import de.esolutions.fw.comm.asi.hmisync.navigation.DestinationInfo;
import de.esolutions.fw.comm.asi.hmisync.navigation.NextDestinationInfo;
import de.esolutions.fw.comm.asi.hmisync.navigation.impl.ASIHMISyncNavigationAbstractBaseService;
import de.esolutions.fw.comm.asi.hmisync.navigation.impl.ASIHMISyncNavigationService;
import de.esolutions.fw.comm.core.IService;
import de.esolutions.fw.comm.core.IStub;
import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.NavRouteListData;
import org.dsi.ifc.navigation.PosPosition;
import org.dsi.ifc.navigation.RgInfoForNextDestination;

public class NaviASIProvider
extends ASIHMISyncNavigationAbstractBaseService
implements IASIProvider {
    private final ASIHMISyncNavigationService naviService;
    private INaviTabletService tabletService;
    private final LogChannel logger;
    final NaviTabletServiceListener naviTabletServiceListener = new NaviTabletServiceListener();
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

    public IService getService() {
        return this.naviService;
    }

    public void setTabletService(INaviTabletService iNaviTabletService) {
        this.tabletService = iNaviTabletService;
    }

    public void startGuidanceToDestinations(final DestinationInfo[] destinationInfoArray, final ASIHMISyncNavigationReply aSIHMISyncNavigationReply) throws MethodException {
        if (this.tabletService == null || !this.tabletService.isReady()) {
            this.logger.log(100000, "NaviASIProvider#startGuidanceToDestinations declined, tabletServcie not ready!");
            this.startGuidanceSequenceActive = false;
            aSIHMISyncNavigationReply.startGuidanceToDestinationsResult(2);
            return;
        }
        if (!this.startGuidanceSequenceActive) {
            this.startGuidanceSequenceActive = true;
            final NavCommand navCommand = new NavCommand("NaviASIProvider - REPLY SDIS GuidanceStatus"){

                public void execute() {
                    try {
                        aSIHMISyncNavigationReply.startGuidanceToDestinationsResult(0);
                        NaviASIProvider.this.updateDestinationsForGuidance(null);
                        this.getCommandList().commandFinished();
                    }
                    catch (MethodException methodException) {
                        this.logger.log(100000, "ReplyCommand failed", (Throwable)methodException);
                        this.getCommandList().commandAborted(methodException);
                    }
                    NaviASIProvider.this.startGuidanceSequenceActive = false;
                }
            };
            final NavCommand navCommand2 = new NavCommand("NaviASIProvider - REPLY SDIS GuidanceStatus"){

                public void execute() {
                    try {
                        aSIHMISyncNavigationReply.startGuidanceToDestinationsResult(2);
                        NaviASIProvider.this.updateDestinationsForGuidance(null);
                        this.getCommandList().commandFinished();
                    }
                    catch (MethodException methodException) {
                        this.logger.log(100000, "ReplyCommand failed", (Throwable)methodException);
                        this.getCommandList().commandAborted(methodException);
                    }
                    NaviASIProvider.this.startGuidanceSequenceActive = false;
                }
            };
            NavLocation[] navLocationArray = new NavLocation[destinationInfoArray.length];
            for (int i2 = 0; i2 < destinationInfoArray.length; ++i2) {
                this.logger.log(10000000, "NaviASIProvider transform DestinationInfo to NavLocation DestinationInfo = %1", (Object)destinationInfoArray[i2]);
                navLocationArray[i2] = Util.getLocationFromGeoPos(NavigationUtilities.degreeToWgs84(destinationInfoArray[i2].longitude), NavigationUtilities.degreeToWgs84(destinationInfoArray[i2].latitude));
            }
            CommandList commandList = this.tabletService.getTransformCommandList(navLocationArray);
            commandList.add(new NavCommand(){

                public void execute() {
                    NavLocation[] navLocationArray = (NavLocation[])this.getCommandList().get("NavLocationArray");
                    for (int i2 = 0; i2 < destinationInfoArray.length; ++i2) {
                        if (Util.isEmpty(destinationInfoArray[i2].poiName)) continue;
                        Util.setDescriptionOnLocation(navLocationArray[i2], destinationInfoArray[i2].poiName);
                    }
                    NaviASIProvider.this.tabletService.startGuidanceToDestinations(navLocationArray, navCommand, navCommand2);
                    this.getCommandList().commandFinished();
                }
            });
            commandList.setErrorCommand(navCommand2);
            commandList.execute("NaviASIProvider#startGuidanceToDestinations");
            this.updateDestinationsForGuidance(destinationInfoArray);
        } else {
            this.logger.log(100000, "NaviASIProvider#startGuidanceToDestinations() - guidance request already active, sending error");
            aSIHMISyncNavigationReply.startGuidanceToDestinationsResult(2);
        }
    }

    public void attachStub(IStub iStub) {
        this.logger.log(1000000, "'%1'", (Object)iStub);
    }

    public void detachStub(IStub iStub) {
        this.logger.log(1000000, "'%1'", (Object)iStub);
    }

    private class NaviTabletServiceListener
    implements INaviTabletServiceListener {
        private NaviTabletServiceListener() {
        }

        public void updateCarPosition(PosPosition posPosition) {
            if (NaviASIProvider.this.logger.isDebug2()) {
                NaviASIProvider.this.logger.log(100000000, "NaviTabletServiceListener#updateCarPosition %1", (Object)posPosition);
            }
            CarPosition carPosition = new CarPosition();
            carPosition.angle = posPosition.directionAngle;
            carPosition.height = posPosition.height;
            carPosition.latitude = NavigationUtilities.wgs84ToDegree(posPosition.latitude);
            carPosition.longitude = NavigationUtilities.wgs84ToDegree(posPosition.longitude);
            carPosition.speed = this.convertFromcmsToms(posPosition.speed);
            try {
                NaviASIProvider.this.updateCarPosition(carPosition);
            }
            catch (MethodException methodException) {
                NaviASIProvider.this.logger.log(10000, "NaviTabletServiceListener#updateCarPosition ", (Throwable)methodException);
            }
        }

        private int convertFromcmsToms(int n) {
            return n / 100;
        }

        public void updateRouteGuidanceActive(boolean bl) {
            try {
                NaviASIProvider.this.updateRouteGuidanceActive(bl);
            }
            catch (MethodException methodException) {
                NaviASIProvider.this.logger.log(10000, "NaviTabletServiceListener#updateRouteGuidanceActive ", (Throwable)methodException);
            }
        }

        public void updateDestinationInfo(NavRouteListData[] navRouteListDataArray, NavLocation[] navLocationArray, NavigationEnv navigationEnv) {
            DestinationInfo[] destinationInfoArray = new DestinationInfo[navLocationArray.length];
            for (int i2 = 0; i2 < navLocationArray.length; ++i2) {
                DestinationInfo destinationInfo;
                NavLocation navLocation = navLocationArray[i2];
                NavRouteListData navRouteListData = navRouteListDataArray[i2];
                IMyLocationAccessor iMyLocationAccessor = Util.getLocationAccessor(navLocation);
                String[] stringArray = new String[]{AddressFormatter.formatOneLine(navLocation, navigationEnv).getFirstLineAsText()};
                destinationInfoArray[i2] = destinationInfo = new DestinationInfo(NavigationUtilities.wgs84ToDegree(iMyLocationAccessor.getLongitude()), NavigationUtilities.wgs84ToDegree(iMyLocationAccessor.getLatitude()), iMyLocationAccessor.getCountry(), iMyLocationAccessor.getTown(), iMyLocationAccessor.getStreet(), iMyLocationAccessor.getJunction(), iMyLocationAccessor.getHousenumber(), iMyLocationAccessor.getPoiName(), stringArray, navRouteListData.getStartDistance(), navRouteListData.getEndDistance(), navRouteListData.getRemainingTravelTime());
            }
            try {
                NaviASIProvider.this.updateDestinationInfo(destinationInfoArray);
            }
            catch (MethodException methodException) {
                NaviASIProvider.this.logger.log(10000, "NaviTabletServiceListener#updateRouteGuidanceActive ", (Throwable)methodException);
            }
        }

        public void updateNextDestinationInfo(RgInfoForNextDestination rgInfoForNextDestination) {
            NextDestinationInfo nextDestinationInfo = new NextDestinationInfo();
            nextDestinationInfo.destinationIndex = rgInfoForNextDestination.destinationIndex;
            nextDestinationInfo.distanceToNextDestination = rgInfoForNextDestination.distanceToNextDest;
            nextDestinationInfo.timeToNextDestiantion = rgInfoForNextDestination.timeToNextDest * 1000L;
            try {
                NaviASIProvider.this.updateNextDestinationInfo(nextDestinationInfo);
            }
            catch (MethodException methodException) {
                NaviASIProvider.this.logger.log(10000, "NaviTabletServiceListener#updateNextDestinationInfo ", (Throwable)methodException);
            }
        }
    }
}

