/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.interapp;

import de.audi.atip.interapp.NaviService;
import de.audi.atip.interapp.NaviServiceListener;
import de.audi.atip.interapp.SDSListEntry;
import de.audi.atip.log.LogChannel;
import de.audi.atip.metrics.DateMetric;
import de.audi.tghu.navi.app.AbstractNaviServiceComponent;
import de.audi.tghu.navi.app.interapp.INaviServiceListenerController;
import de.audi.tghu.navi.app.interapp.INaviServiceListenerObserver;
import de.audi.tghu.navi.app.navobserver.ICountryStateUpdatedObserver;
import de.audi.tghu.navi.app.util.Util;
import java.util.Date;
import org.dsi.ifc.tmc.TmcMessage;

public class NaviServiceListenerController
extends AbstractNaviServiceComponent
implements NaviServiceListener,
INaviServiceListenerController,
ICountryStateUpdatedObserver {
    private static final String CLASS_NAME = Util.getClassNameFromPackageName(class$de$audi$tghu$navi$app$interapp$NaviServiceListenerController == null ? (class$de$audi$tghu$navi$app$interapp$NaviServiceListenerController = NaviServiceListenerController.class$("de.audi.tghu.navi.app.interapp.NaviServiceListenerController")) : class$de$audi$tghu$navi$app$interapp$NaviServiceListenerController);
    private INaviServiceListenerObserver naviServiceListenerObserver;
    private int tmcEventsAhead;
    private long distCcpToTmc;
    private long lastKnownDelay;
    static /* synthetic */ Class class$de$audi$tghu$navi$app$interapp$NaviServiceListenerController;
    static /* synthetic */ Class class$de$audi$atip$interapp$NaviServiceListener;

    public NaviServiceListenerController(LogChannel logChannel) {
        super(logChannel);
    }

    public NaviServiceListener getNaviServiceListener() {
        return this;
    }

    public void setTrackerUpdatesObserver(INaviServiceListenerObserver iNaviServiceListenerObserver) {
        this.naviServiceListenerObserver = iNaviServiceListenerObserver;
    }

    public void updateTmcMessagesAhead(TmcMessage[] tmcMessageArray) {
        this.tmcEventsAhead = tmcMessageArray.length;
        this.logChannel.log(10000000, "NaviServiceListenerController#updateTmcMessagesAhead: lastKnownDelay=%1, tmcEventsAhead=%2, distanceToNextTmcEvent=%3", this.lastKnownDelay, (long)this.tmcEventsAhead, this.distCcpToTmc);
        this.sendTrafficInformationToSDS();
    }

    public void updateDelayOnCurrentRoute(long l) {
        this.lastKnownDelay = l;
        this.logChannel.log(10000000, "NaviServiceListenerController#updateDelayOnCurrentRoute: lastKnownDelay=%1, tmcEventsAhead=%2, distanceToNextTmcEvent=%3", this.lastKnownDelay, (long)this.tmcEventsAhead, this.distCcpToTmc);
        this.sendTrafficInformationToSDS();
    }

    public void updateInfoForNextTmcEvent(long l, TmcMessage tmcMessage) {
        this.distCcpToTmc = l;
        this.logChannel.log(10000000, "NaviServiceListenerController#updateInfoForNextTmcEvent: lastKnownDelay=%1, tmcEventsAhead=%2, distanceToNextTmcEvent=%3", this.lastKnownDelay, (long)this.tmcEventsAhead, l);
        this.sendTrafficInformationToSDS();
    }

    private void sendTrafficInformationToSDS() {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(100000000, "NaviServiceListenerController#sendTrafficInformationToSDS: lastKnownDelay=%1, tmcEventsAhead=%2, distanceToNextTmcEvent=%3", this.lastKnownDelay, (long)this.tmcEventsAhead, this.distCcpToTmc);
        }
        DateMetric dateMetric = new DateMetric(new Date(this.lastKnownDelay), 5);
        int n = 1;
        this.updateTrafficSituation(this.lastKnownDelay > 0L, dateMetric, this.tmcEventsAhead, this.distCcpToTmc, n);
    }

    public void updateRgActive(final boolean bl) {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(100000000, "NaviServiceListenerController#updateRgActive: %1", bl);
        }
        this.traverseListeners(new IUpdateOperation(){

            public void update(NaviServiceListener naviServiceListener) {
                naviServiceListener.updateRgActive(bl);
            }
        });
        if (bl) {
            return;
        }
        this.tmcEventsAhead = 0;
        this.distCcpToTmc = 0L;
        this.lastKnownDelay = 0L;
    }

    protected String[] getTrackedService() {
        return new String[]{(class$de$audi$atip$interapp$NaviServiceListener == null ? (class$de$audi$atip$interapp$NaviServiceListener = NaviServiceListenerController.class$("de.audi.atip.interapp.NaviServiceListener")) : class$de$audi$atip$interapp$NaviServiceListener).getName()};
    }

    protected boolean trackedServiceAdded(Object object) {
        this.logChannel.log(10000000, "NaviServiceListenerController#trackedServiceAdded( %1 )", object);
        if (object instanceof NaviServiceListener) {
            if (this.naviServiceListenerObserver != null) {
                this.naviServiceListenerObserver.listenerAdded((NaviServiceListener)object);
            }
            return true;
        }
        this.logChannel.log(10000000, "NaviServiceListenerController#trackedServiceAdded() - not a NaviServiceListener");
        return false;
    }

    protected boolean trackedServiceRemoved(Object object) {
        this.logChannel.log(10000000, "NaviServiceListenerController#trackedServiceRemoved( %1 )", object);
        return object instanceof NaviServiceListener;
    }

    protected void onStart() {
        this.logChannel.log(10000000, "NaviServiceListenerController#onStart( )");
    }

    protected void onStop() {
        this.logChannel.log(10000000, "NaviServiceListenerController#onStop( )");
        this.naviServiceListenerObserver = null;
    }

    private void traverseListeners(IUpdateOperation iUpdateOperation) {
        Object[] objectArray = null;
        if (this.tracker != null) {
            objectArray = this.tracker.getServices();
        }
        if (objectArray != null && objectArray.length > 0) {
            if (this.logChannel.isDebug2()) {
                this.logChannel.log(100000000, "NaviServiceListenerController#traverseListeners - length: %1", (long)objectArray.length);
            }
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                NaviServiceListener naviServiceListener = (NaviServiceListener)objectArray[i2];
                try {
                    iUpdateOperation.update(naviServiceListener);
                    continue;
                }
                catch (Exception exception) {
                    this.logChannel.log(10000, "NaviServiceListenerController#traverseListeners - error during update. - %1 - exception=%2", (Object)naviServiceListener.getClass().getName(), (Throwable)exception);
                }
            }
        }
    }

    public void updateFavoriteDestinations(final SDSListEntry[] sDSListEntryArray) {
        this.logChannel.log(1000000, "NaviServiceListenerController#updateFavoriteDestinations - %1 favorites", (long)sDSListEntryArray.length);
        try {
            this.traverseListeners(new IUpdateOperation(){

                public void update(NaviServiceListener naviServiceListener) {
                    naviServiceListener.updateFavoriteDestinations(sDSListEntryArray);
                }
            });
        }
        catch (Exception exception) {
            this.logChannel.log(10000, "NaviServiceListenerController#updateFavoriteDestinations - %1", (Throwable)exception);
        }
    }

    public void updateLastDestinations(final SDSListEntry[] sDSListEntryArray) {
        this.logChannel.log(1000000, "NaviServiceListenerController#updateLastDestinations - %1 destinations", (long)sDSListEntryArray.length);
        this.traverseListeners(new IUpdateOperation(){

            public void update(NaviServiceListener naviServiceListener) {
                naviServiceListener.updateLastDestinations(sDSListEntryArray);
            }
        });
    }

    public void updateDestinationCountryCode(final String string, final String string2) {
        this.traverseListeners(new IUpdateOperation(){

            public void update(NaviServiceListener naviServiceListener) {
                naviServiceListener.updateDestinationCountryCode(string, string2);
            }
        });
    }

    public void updateDestinationStateCode(final String string, final String string2) {
        this.traverseListeners(new IUpdateOperation(){

            public void update(NaviServiceListener naviServiceListener) {
                naviServiceListener.updateDestinationStateCode(string, string2);
            }
        });
    }

    public void updateFullyOperableStateChanged(final boolean bl) {
        this.traverseListeners(new IUpdateOperation(){

            public void update(NaviServiceListener naviServiceListener) {
                naviServiceListener.updateFullyOperableStateChanged(bl);
            }
        });
    }

    public void responseSetDestination(final byte by) {
        this.traverseListeners(new IUpdateOperation(){

            public void update(NaviServiceListener naviServiceListener) {
                naviServiceListener.responseSetDestination(by);
            }
        });
    }

    public void responseSetLocation(final byte by) {
        this.traverseListeners(new IUpdateOperation(){

            public void update(NaviServiceListener naviServiceListener) {
                naviServiceListener.responseSetLocation(by);
            }
        });
    }

    public void responseSetOneShotData(final byte by) {
        this.traverseListeners(new IUpdateOperation(){

            public void update(NaviServiceListener naviServiceListener) {
                naviServiceListener.responseSetOneShotData(by);
            }
        });
    }

    public void responseSetLocationPart(final byte by) {
        this.traverseListeners(new IUpdateOperation(){

            public void update(NaviServiceListener naviServiceListener) {
                naviServiceListener.responseSetLocationPart(by);
            }
        });
    }

    public void responseQueryLocationPartListLength(final byte by, final long l, final String[] stringArray) {
        this.traverseListeners(new IUpdateOperation(){

            public void update(NaviServiceListener naviServiceListener) {
                naviServiceListener.responseQueryLocationPartListLength(by, l, stringArray);
            }
        });
    }

    public void responseQuerySpelledLocationPartResultList(final byte by, final String[] stringArray, final Object[] objectArray) {
        this.traverseListeners(new IUpdateOperation(){

            public void update(NaviServiceListener naviServiceListener) {
                naviServiceListener.responseQuerySpelledLocationPartResultList(by, stringArray, objectArray);
            }
        });
    }

    public void responseSetSpelledLocationPart(final byte by) {
        this.traverseListeners(new IUpdateOperation(){

            public void update(NaviServiceListener naviServiceListener) {
                naviServiceListener.responseSetSpelledLocationPart(by);
            }
        });
    }

    public void responseValidateSpelledStreetName(final byte by) {
        this.traverseListeners(new IUpdateOperation(){

            public void update(NaviServiceListener naviServiceListener) {
                naviServiceListener.responseValidateSpelledStreetName(by);
            }
        });
    }

    public void responseSynchronizeSpeechCountryWithCurrentLDResult(final byte by, final boolean bl) {
        this.traverseListeners(new IUpdateOperation(){

            public void update(NaviServiceListener naviServiceListener) {
                naviServiceListener.responseSynchronizeSpeechCountryWithCurrentLDResult(by, bl);
            }
        });
    }

    public void responseStartDestinationInput(final byte by) {
        this.traverseListeners(new IUpdateOperation(){

            public void update(NaviServiceListener naviServiceListener) {
                naviServiceListener.responseStartDestinationInput(by);
            }
        });
    }

    public void responseTriggerAddressInputReturn(final byte by) {
        this.traverseListeners(new IUpdateOperation(){

            public void update(NaviServiceListener naviServiceListener) {
                naviServiceListener.responseTriggerAddressInputReturn(by);
            }
        });
    }

    public void responseStartPoiSearchByName(final byte by) {
        this.traverseListeners(new IUpdateOperation(){

            public void update(NaviServiceListener naviServiceListener) {
                naviServiceListener.responseStartPoiSearchByName(by);
            }
        });
    }

    public void responseFinishDestinationInput(final byte by, final byte by2) {
        this.traverseListeners(new IUpdateOperation(){

            public void update(NaviServiceListener naviServiceListener) {
                naviServiceListener.responseFinishDestinationInput(by, by2);
            }
        });
    }

    public void responsePrepareRouteGuidance(final byte by, final byte by2) {
        this.traverseListeners(new IUpdateOperation(){

            public void update(NaviServiceListener naviServiceListener) {
                naviServiceListener.responsePrepareRouteGuidance(by, by2);
            }
        });
    }

    public void responseCheckRouteGuidance(final byte by) {
        this.traverseListeners(new IUpdateOperation(){

            public void update(NaviServiceListener naviServiceListener) {
                naviServiceListener.responseCheckRouteGuidance(by);
            }
        });
    }

    public void responseSetRouteOptionCalcType(final byte by) {
        this.traverseListeners(new IUpdateOperation(){

            public void update(NaviServiceListener naviServiceListener) {
                naviServiceListener.responseSetRouteOptionCalcType(by);
            }
        });
    }

    public void responseSetRouteOptionDynamic(final byte by) {
        this.traverseListeners(new IUpdateOperation(){

            public void update(NaviServiceListener naviServiceListener) {
                naviServiceListener.responseSetRouteOptionDynamic(by);
            }
        });
    }

    public void responseTriggerRouteGuidance(final byte by) {
        this.traverseListeners(new IUpdateOperation(){

            public void update(NaviServiceListener naviServiceListener) {
                naviServiceListener.responseTriggerRouteGuidance(by);
            }
        });
    }

    public void responseReduceRouteToFinalDestination(final byte by) {
        this.traverseListeners(new IUpdateOperation(){

            public void update(NaviServiceListener naviServiceListener) {
                naviServiceListener.responseReduceRouteToFinalDestination(by);
            }
        });
    }

    public void responseBlockRoute(final byte by) {
        this.traverseListeners(new IUpdateOperation(){

            public void update(NaviServiceListener naviServiceListener) {
                naviServiceListener.responseBlockRoute(by);
            }
        });
    }

    public void responseUnblockRoute(final byte by) {
        this.traverseListeners(new IUpdateOperation(){

            public void update(NaviServiceListener naviServiceListener) {
                naviServiceListener.responseUnblockRoute(by);
            }
        });
    }

    public void responsePostCodeFormat(final byte by, final boolean bl) {
        this.traverseListeners(new IUpdateOperation(){

            public void update(NaviServiceListener naviServiceListener) {
                naviServiceListener.responsePostCodeFormat(by, bl);
            }
        });
    }

    public void responseSelectPOI(final byte by, final NaviService.POISDSListEntry[] pOISDSListEntryArray) {
        this.traverseListeners(new IUpdateOperation(){

            public void update(NaviServiceListener naviServiceListener) {
                naviServiceListener.responseSelectPOI(by, pOISDSListEntryArray);
            }
        });
    }

    public void responseSelectPOIbyListIndex(final byte by) {
        this.traverseListeners(new IUpdateOperation(){

            public void update(NaviServiceListener naviServiceListener) {
                naviServiceListener.responseSelectPOIbyListIndex(by);
            }
        });
    }

    public void responseSelectTopPOI(final byte by) {
        this.traverseListeners(new IUpdateOperation(){

            public void update(NaviServiceListener naviServiceListener) {
                naviServiceListener.responseSelectTopPOI(by);
            }
        });
    }

    public void responseCurrentSpeedLimit(final byte by, final int n, final byte by2) {
        this.traverseListeners(new IUpdateOperation(){

            public void update(NaviServiceListener naviServiceListener) {
                naviServiceListener.responseCurrentSpeedLimit(by, n, by2);
            }
        });
    }

    public void responseStopRouteGuidance(final byte by) {
        this.traverseListeners(new IUpdateOperation(){

            public void update(NaviServiceListener naviServiceListener) {
                naviServiceListener.responseStopRouteGuidance(by);
            }
        });
    }

    public void responseStartRouteGuidance(final byte by) {
        this.traverseListeners(new IUpdateOperation(){

            public void update(NaviServiceListener naviServiceListener) {
                naviServiceListener.responseStartRouteGuidance(by);
            }
        });
    }

    public void responseCalculateAlternativeRoutes(final byte by) {
        this.traverseListeners(new IUpdateOperation(){

            public void update(NaviServiceListener naviServiceListener) {
                naviServiceListener.responseCalculateAlternativeRoutes(by);
            }
        });
    }

    public void responseAddSelectedDestinationAtIndex(final byte by) {
        this.traverseListeners(new IUpdateOperation(){

            public void update(NaviServiceListener naviServiceListener) {
                naviServiceListener.responseAddSelectedDestinationAtIndex(by);
            }
        });
    }

    public void countryUpdated(String string, String string2) {
        this.logChannel.log(1000000, "NaviServiceListenerController#countryUpdated( %1, %2 )", (Object)string, (Object)string2);
        this.updateDestinationCountryCode(string, string2);
    }

    public void stateUpdated(String string, String string2) {
        this.logChannel.log(1000000, "NaviServiceListenerController#stateUpdated( %1, %2 )", (Object)string, (Object)string2);
        this.updateDestinationStateCode(string, string2);
    }

    public void responseSetLastDestination(final byte by) {
        this.traverseListeners(new IUpdateOperation(){

            public void update(NaviServiceListener naviServiceListener) {
                naviServiceListener.responseSetLastDestination(by);
            }
        });
    }

    public void responseSetFavoriteDestination(final byte by) {
        this.traverseListeners(new IUpdateOperation(){

            public void update(NaviServiceListener naviServiceListener) {
                naviServiceListener.responseSetFavoriteDestination(by);
            }
        });
    }

    public void updateTrafficSituation(final boolean bl, final DateMetric dateMetric, final int n, final long l, final int n2) {
        this.traverseListeners(new IUpdateOperation(){

            public void update(NaviServiceListener naviServiceListener) {
                naviServiceListener.updateTrafficSituation(bl, dateMetric, n, l, n2);
            }
        });
    }

    public void responseIntelliDestination(final byte by) {
        this.traverseListeners(new IUpdateOperation(){

            public void update(NaviServiceListener naviServiceListener) {
                naviServiceListener.responseIntelliDestination(by);
            }
        });
    }

    public void updateResponseStartTrufflesSearch(final byte by, final int n, final boolean bl, final int n2) {
        this.logChannel.log(10000000, new StringBuffer().append(CLASS_NAME).append("#updateResponseStartTrufflesSearch  numberOfSearchResults: %2, navDBSearchEnded: %1 )").toString(), (Object)String.valueOf(bl), (long)n);
        this.traverseListeners(new IUpdateOperation(){

            public void update(NaviServiceListener naviServiceListener) {
                naviServiceListener.updateResponseStartTrufflesSearch(by, n, bl, n2);
            }
        });
    }

    public void responseSelectAlternativeRoute(final byte by) {
        this.traverseListeners(new IUpdateOperation(){

            public void update(NaviServiceListener naviServiceListener) {
                naviServiceListener.responseSelectAlternativeRoute(by);
            }
        });
    }

    public void responseDialDetailsNumber(final byte by) {
        this.traverseListeners(new IUpdateOperation(){

            public void update(NaviServiceListener naviServiceListener) {
                naviServiceListener.responseDialDetailsNumber(by);
            }
        });
    }

    public void responseMapCodeResult(final byte by) {
        this.traverseListeners(new IUpdateOperation(){

            public void update(NaviServiceListener naviServiceListener) {
                naviServiceListener.responseMapCodeResult(by);
            }
        });
    }

    public void responseTelephoneNumberResult(final byte by) {
        this.traverseListeners(new IUpdateOperation(){

            public void update(NaviServiceListener naviServiceListener) {
                naviServiceListener.responseTelephoneNumberResult(by);
            }
        });
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    private static interface IUpdateOperation {
        public void update(NaviServiceListener var1);
    }
}

