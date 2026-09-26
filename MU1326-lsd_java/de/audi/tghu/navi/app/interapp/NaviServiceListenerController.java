/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.interapp;

import de.audi.atip.interapp.NaviService$POISDSListEntry;
import de.audi.atip.interapp.NaviServiceListener;
import de.audi.atip.interapp.SDSListEntry;
import de.audi.atip.log.LogChannel;
import de.audi.atip.metrics.DateMetric;
import de.audi.tghu.navi.app.AbstractNaviServiceComponent;
import de.audi.tghu.navi.app.interapp.INaviServiceListenerController;
import de.audi.tghu.navi.app.interapp.INaviServiceListenerObserver;
import de.audi.tghu.navi.app.interapp.NaviServiceListenerController$1;
import de.audi.tghu.navi.app.interapp.NaviServiceListenerController$10;
import de.audi.tghu.navi.app.interapp.NaviServiceListenerController$11;
import de.audi.tghu.navi.app.interapp.NaviServiceListenerController$12;
import de.audi.tghu.navi.app.interapp.NaviServiceListenerController$13;
import de.audi.tghu.navi.app.interapp.NaviServiceListenerController$14;
import de.audi.tghu.navi.app.interapp.NaviServiceListenerController$15;
import de.audi.tghu.navi.app.interapp.NaviServiceListenerController$16;
import de.audi.tghu.navi.app.interapp.NaviServiceListenerController$17;
import de.audi.tghu.navi.app.interapp.NaviServiceListenerController$18;
import de.audi.tghu.navi.app.interapp.NaviServiceListenerController$19;
import de.audi.tghu.navi.app.interapp.NaviServiceListenerController$2;
import de.audi.tghu.navi.app.interapp.NaviServiceListenerController$20;
import de.audi.tghu.navi.app.interapp.NaviServiceListenerController$21;
import de.audi.tghu.navi.app.interapp.NaviServiceListenerController$22;
import de.audi.tghu.navi.app.interapp.NaviServiceListenerController$23;
import de.audi.tghu.navi.app.interapp.NaviServiceListenerController$24;
import de.audi.tghu.navi.app.interapp.NaviServiceListenerController$25;
import de.audi.tghu.navi.app.interapp.NaviServiceListenerController$26;
import de.audi.tghu.navi.app.interapp.NaviServiceListenerController$27;
import de.audi.tghu.navi.app.interapp.NaviServiceListenerController$28;
import de.audi.tghu.navi.app.interapp.NaviServiceListenerController$29;
import de.audi.tghu.navi.app.interapp.NaviServiceListenerController$3;
import de.audi.tghu.navi.app.interapp.NaviServiceListenerController$30;
import de.audi.tghu.navi.app.interapp.NaviServiceListenerController$31;
import de.audi.tghu.navi.app.interapp.NaviServiceListenerController$32;
import de.audi.tghu.navi.app.interapp.NaviServiceListenerController$33;
import de.audi.tghu.navi.app.interapp.NaviServiceListenerController$34;
import de.audi.tghu.navi.app.interapp.NaviServiceListenerController$35;
import de.audi.tghu.navi.app.interapp.NaviServiceListenerController$36;
import de.audi.tghu.navi.app.interapp.NaviServiceListenerController$37;
import de.audi.tghu.navi.app.interapp.NaviServiceListenerController$38;
import de.audi.tghu.navi.app.interapp.NaviServiceListenerController$39;
import de.audi.tghu.navi.app.interapp.NaviServiceListenerController$4;
import de.audi.tghu.navi.app.interapp.NaviServiceListenerController$40;
import de.audi.tghu.navi.app.interapp.NaviServiceListenerController$41;
import de.audi.tghu.navi.app.interapp.NaviServiceListenerController$42;
import de.audi.tghu.navi.app.interapp.NaviServiceListenerController$43;
import de.audi.tghu.navi.app.interapp.NaviServiceListenerController$44;
import de.audi.tghu.navi.app.interapp.NaviServiceListenerController$45;
import de.audi.tghu.navi.app.interapp.NaviServiceListenerController$5;
import de.audi.tghu.navi.app.interapp.NaviServiceListenerController$6;
import de.audi.tghu.navi.app.interapp.NaviServiceListenerController$7;
import de.audi.tghu.navi.app.interapp.NaviServiceListenerController$8;
import de.audi.tghu.navi.app.interapp.NaviServiceListenerController$9;
import de.audi.tghu.navi.app.interapp.NaviServiceListenerController$IUpdateOperation;
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

    @Override
    public NaviServiceListener getNaviServiceListener() {
        return this;
    }

    @Override
    public void setTrackerUpdatesObserver(INaviServiceListenerObserver iNaviServiceListenerObserver) {
        this.naviServiceListenerObserver = iNaviServiceListenerObserver;
    }

    public void updateTmcMessagesAhead(TmcMessage[] tmcMessageArray) {
        this.tmcEventsAhead = tmcMessageArray.length;
        this.logChannel.log(-2137614336, "NaviServiceListenerController#updateTmcMessagesAhead: lastKnownDelay=%1, tmcEventsAhead=%2, distanceToNextTmcEvent=%3", this.lastKnownDelay, (long)this.tmcEventsAhead, this.distCcpToTmc);
        this.sendTrafficInformationToSDS();
    }

    public void updateDelayOnCurrentRoute(long l) {
        this.lastKnownDelay = l;
        this.logChannel.log(-2137614336, "NaviServiceListenerController#updateDelayOnCurrentRoute: lastKnownDelay=%1, tmcEventsAhead=%2, distanceToNextTmcEvent=%3", this.lastKnownDelay, (long)this.tmcEventsAhead, this.distCcpToTmc);
        this.sendTrafficInformationToSDS();
    }

    public void updateInfoForNextTmcEvent(long l, TmcMessage tmcMessage) {
        this.distCcpToTmc = l;
        this.logChannel.log(-2137614336, "NaviServiceListenerController#updateInfoForNextTmcEvent: lastKnownDelay=%1, tmcEventsAhead=%2, distanceToNextTmcEvent=%3", this.lastKnownDelay, (long)this.tmcEventsAhead, l);
        this.sendTrafficInformationToSDS();
    }

    private void sendTrafficInformationToSDS() {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(14808325, "NaviServiceListenerController#sendTrafficInformationToSDS: lastKnownDelay=%1, tmcEventsAhead=%2, distanceToNextTmcEvent=%3", this.lastKnownDelay, (long)this.tmcEventsAhead, this.distCcpToTmc);
        }
        DateMetric dateMetric = new DateMetric(new Date(this.lastKnownDelay), 5);
        int n = 1;
        this.updateTrafficSituation(this.lastKnownDelay > 0L, dateMetric, this.tmcEventsAhead, this.distCcpToTmc, n);
    }

    @Override
    public void updateRgActive(boolean bl) {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(14808325, "NaviServiceListenerController#updateRgActive: %1", bl);
        }
        this.traverseListeners(new NaviServiceListenerController$1(this, bl));
        if (bl) {
            return;
        }
        this.tmcEventsAhead = 0;
        this.distCcpToTmc = 0L;
        this.lastKnownDelay = 0L;
    }

    @Override
    protected String[] getTrackedService() {
        return new String[]{(class$de$audi$atip$interapp$NaviServiceListener == null ? (class$de$audi$atip$interapp$NaviServiceListener = NaviServiceListenerController.class$("de.audi.atip.interapp.NaviServiceListener")) : class$de$audi$atip$interapp$NaviServiceListener).getName()};
    }

    @Override
    protected boolean trackedServiceAdded(Object object) {
        this.logChannel.log(-2137614336, "NaviServiceListenerController#trackedServiceAdded( %1 )", object);
        if (object instanceof NaviServiceListener) {
            if (this.naviServiceListenerObserver != null) {
                this.naviServiceListenerObserver.listenerAdded((NaviServiceListener)object);
            }
            return true;
        }
        this.logChannel.log(-2137614336, "NaviServiceListenerController#trackedServiceAdded() - not a NaviServiceListener");
        return false;
    }

    @Override
    protected boolean trackedServiceRemoved(Object object) {
        this.logChannel.log(-2137614336, "NaviServiceListenerController#trackedServiceRemoved( %1 )", object);
        return object instanceof NaviServiceListener;
    }

    @Override
    protected void onStart() {
        this.logChannel.log(-2137614336, "NaviServiceListenerController#onStart( )");
    }

    @Override
    protected void onStop() {
        this.logChannel.log(-2137614336, "NaviServiceListenerController#onStop( )");
        this.naviServiceListenerObserver = null;
    }

    private void traverseListeners(NaviServiceListenerController$IUpdateOperation naviServiceListenerController$IUpdateOperation) {
        Object[] objectArray = null;
        if (this.tracker != null) {
            objectArray = this.tracker.getServices();
        }
        if (objectArray != null && objectArray.length > 0) {
            if (this.logChannel.isDebug2()) {
                this.logChannel.log(14808325, "NaviServiceListenerController#traverseListeners - length: %1", (long)objectArray.length);
            }
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                NaviServiceListener naviServiceListener = (NaviServiceListener)objectArray[i2];
                try {
                    naviServiceListenerController$IUpdateOperation.update(naviServiceListener);
                    continue;
                }
                catch (Exception exception) {
                    this.logChannel.log(10000, "NaviServiceListenerController#traverseListeners - error during update. - %1 - exception=%2", (Object)super.getClass().getName(), (Throwable)exception);
                }
            }
        }
    }

    @Override
    public void updateFavoriteDestinations(SDSListEntry[] sDSListEntryArray) {
        this.logChannel.log(1078071040, "NaviServiceListenerController#updateFavoriteDestinations - %1 favorites", (long)sDSListEntryArray.length);
        try {
            this.traverseListeners(new NaviServiceListenerController$2(this, sDSListEntryArray));
        }
        catch (Exception exception) {
            this.logChannel.log(10000, "NaviServiceListenerController#updateFavoriteDestinations - %1", (Throwable)exception);
        }
    }

    @Override
    public void updateLastDestinations(SDSListEntry[] sDSListEntryArray) {
        this.logChannel.log(1078071040, "NaviServiceListenerController#updateLastDestinations - %1 destinations", (long)sDSListEntryArray.length);
        this.traverseListeners(new NaviServiceListenerController$3(this, sDSListEntryArray));
    }

    @Override
    public void updateDestinationCountryCode(String string, String string2) {
        this.traverseListeners(new NaviServiceListenerController$4(this, string, string2));
    }

    @Override
    public void updateDestinationStateCode(String string, String string2) {
        this.traverseListeners(new NaviServiceListenerController$5(this, string, string2));
    }

    @Override
    public void updateFullyOperableStateChanged(boolean bl) {
        this.traverseListeners(new NaviServiceListenerController$6(this, bl));
    }

    @Override
    public void responseSetDestination(byte by) {
        this.traverseListeners(new NaviServiceListenerController$7(this, by));
    }

    @Override
    public void responseSetLocation(byte by) {
        this.traverseListeners(new NaviServiceListenerController$8(this, by));
    }

    @Override
    public void responseSetOneShotData(byte by) {
        this.traverseListeners(new NaviServiceListenerController$9(this, by));
    }

    @Override
    public void responseSetLocationPart(byte by) {
        this.traverseListeners(new NaviServiceListenerController$10(this, by));
    }

    @Override
    public void responseQueryLocationPartListLength(byte by, long l, String[] stringArray) {
        this.traverseListeners(new NaviServiceListenerController$11(this, by, l, stringArray));
    }

    @Override
    public void responseQuerySpelledLocationPartResultList(byte by, String[] stringArray, Object[] objectArray) {
        this.traverseListeners(new NaviServiceListenerController$12(this, by, stringArray, objectArray));
    }

    @Override
    public void responseSetSpelledLocationPart(byte by) {
        this.traverseListeners(new NaviServiceListenerController$13(this, by));
    }

    @Override
    public void responseValidateSpelledStreetName(byte by) {
        this.traverseListeners(new NaviServiceListenerController$14(this, by));
    }

    @Override
    public void responseSynchronizeSpeechCountryWithCurrentLDResult(byte by, boolean bl) {
        this.traverseListeners(new NaviServiceListenerController$15(this, by, bl));
    }

    @Override
    public void responseStartDestinationInput(byte by) {
        this.traverseListeners(new NaviServiceListenerController$16(this, by));
    }

    @Override
    public void responseTriggerAddressInputReturn(byte by) {
        this.traverseListeners(new NaviServiceListenerController$17(this, by));
    }

    @Override
    public void responseStartPoiSearchByName(byte by) {
        this.traverseListeners(new NaviServiceListenerController$18(this, by));
    }

    @Override
    public void responseFinishDestinationInput(byte by, byte by2) {
        this.traverseListeners(new NaviServiceListenerController$19(this, by, by2));
    }

    @Override
    public void responsePrepareRouteGuidance(byte by, byte by2) {
        this.traverseListeners(new NaviServiceListenerController$20(this, by, by2));
    }

    @Override
    public void responseCheckRouteGuidance(byte by) {
        this.traverseListeners(new NaviServiceListenerController$21(this, by));
    }

    @Override
    public void responseSetRouteOptionCalcType(byte by) {
        this.traverseListeners(new NaviServiceListenerController$22(this, by));
    }

    @Override
    public void responseSetRouteOptionDynamic(byte by) {
        this.traverseListeners(new NaviServiceListenerController$23(this, by));
    }

    @Override
    public void responseTriggerRouteGuidance(byte by) {
        this.traverseListeners(new NaviServiceListenerController$24(this, by));
    }

    @Override
    public void responseReduceRouteToFinalDestination(byte by) {
        this.traverseListeners(new NaviServiceListenerController$25(this, by));
    }

    @Override
    public void responseBlockRoute(byte by) {
        this.traverseListeners(new NaviServiceListenerController$26(this, by));
    }

    @Override
    public void responseUnblockRoute(byte by) {
        this.traverseListeners(new NaviServiceListenerController$27(this, by));
    }

    @Override
    public void responsePostCodeFormat(byte by, boolean bl) {
        this.traverseListeners(new NaviServiceListenerController$28(this, by, bl));
    }

    @Override
    public void responseSelectPOI(byte by, NaviService$POISDSListEntry[] naviService$POISDSListEntryArray) {
        this.traverseListeners(new NaviServiceListenerController$29(this, by, naviService$POISDSListEntryArray));
    }

    @Override
    public void responseSelectPOIbyListIndex(byte by) {
        this.traverseListeners(new NaviServiceListenerController$30(this, by));
    }

    @Override
    public void responseSelectTopPOI(byte by) {
        this.traverseListeners(new NaviServiceListenerController$31(this, by));
    }

    @Override
    public void responseCurrentSpeedLimit(byte by, int n, byte by2) {
        this.traverseListeners(new NaviServiceListenerController$32(this, by, n, by2));
    }

    @Override
    public void responseStopRouteGuidance(byte by) {
        this.traverseListeners(new NaviServiceListenerController$33(this, by));
    }

    @Override
    public void responseStartRouteGuidance(byte by) {
        this.traverseListeners(new NaviServiceListenerController$34(this, by));
    }

    @Override
    public void responseCalculateAlternativeRoutes(byte by) {
        this.traverseListeners(new NaviServiceListenerController$35(this, by));
    }

    @Override
    public void responseAddSelectedDestinationAtIndex(byte by) {
        this.traverseListeners(new NaviServiceListenerController$36(this, by));
    }

    @Override
    public void countryUpdated(String string, String string2) {
        this.logChannel.log(1078071040, "NaviServiceListenerController#countryUpdated( %1, %2 )", (Object)string, (Object)string2);
        this.updateDestinationCountryCode(string, string2);
    }

    @Override
    public void stateUpdated(String string, String string2) {
        this.logChannel.log(1078071040, "NaviServiceListenerController#stateUpdated( %1, %2 )", (Object)string, (Object)string2);
        this.updateDestinationStateCode(string, string2);
    }

    @Override
    public void responseSetLastDestination(byte by) {
        this.traverseListeners(new NaviServiceListenerController$37(this, by));
    }

    @Override
    public void responseSetFavoriteDestination(byte by) {
        this.traverseListeners(new NaviServiceListenerController$38(this, by));
    }

    @Override
    public void updateTrafficSituation(boolean bl, DateMetric dateMetric, int n, long l, int n2) {
        this.traverseListeners(new NaviServiceListenerController$39(this, bl, dateMetric, n, l, n2));
    }

    @Override
    public void responseIntelliDestination(byte by) {
        this.traverseListeners(new NaviServiceListenerController$40(this, by));
    }

    @Override
    public void updateResponseStartTrufflesSearch(byte by, int n, boolean bl, int n2) {
        this.logChannel.log(-2137614336, new StringBuffer().append(CLASS_NAME).append("#updateResponseStartTrufflesSearch  numberOfSearchResults: %2, navDBSearchEnded: %1 )").toString(), (Object)String.valueOf(bl), (long)n);
        this.traverseListeners(new NaviServiceListenerController$41(this, by, n, bl, n2));
    }

    @Override
    public void responseSelectAlternativeRoute(byte by) {
        this.traverseListeners(new NaviServiceListenerController$42(this, by));
    }

    @Override
    public void responseDialDetailsNumber(byte by) {
        this.traverseListeners(new NaviServiceListenerController$43(this, by));
    }

    @Override
    public void responseMapCodeResult(byte by) {
        this.traverseListeners(new NaviServiceListenerController$44(this, by));
    }

    @Override
    public void responseTelephoneNumberResult(byte by) {
        this.traverseListeners(new NaviServiceListenerController$45(this, by));
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

