/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.earlyfunc.core.aircondition;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.service.CarServiceProvider;
import de.audi.app.car.earlyfunc.core.aircondition.AbstractACSeatPopupComponent;
import de.audi.app.car.earlyfunc.core.aircondition.IACSeatConstants;
import de.audi.atip.hmi.view.IPartialPopupListener;
import de.audi.atip.log.LogChannel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.dsi.ifc.caraircondition.AirconContent;

public class ACSeatPartialPopupHandler
implements IPartialPopupListener {
    public static final int POPUP_INVALID = -1;
    private final ICarApplication application;
    private final AbstractACSeatPopupComponent component;
    private final LogChannel logChannel;
    private CarServiceProvider partialPopinServiceProvider;
    private Map visiblePPIDs;
    private Map pendingPPIDsForShow;
    private Map pendingPPIDsForCancel;
    private int[] popinIDsForCallbacks;
    private Object mutex = new Object();
    static /* synthetic */ Class class$de$audi$atip$hmi$view$IPartialPopupListener;

    public ACSeatPartialPopupHandler(ICarApplication iCarApplication, AbstractACSeatPopupComponent abstractACSeatPopupComponent, LogChannel logChannel) {
        this.application = iCarApplication;
        this.component = abstractACSeatPopupComponent;
        this.logChannel = logChannel;
        this.pendingPPIDsForShow = new HashMap();
        this.visiblePPIDs = new HashMap();
        this.pendingPPIDsForCancel = new HashMap();
    }

    public void init(int[] nArray) {
        this.initServiceProvider(nArray);
    }

    public void deinit() {
        this.deinitServiceProvider();
    }

    private void initServiceProvider(int[] nArray) {
        this.popinIDsForCallbacks = nArray;
        this.partialPopinServiceProvider = new CarServiceProvider((class$de$audi$atip$hmi$view$IPartialPopupListener == null ? (class$de$audi$atip$hmi$view$IPartialPopupListener = ACSeatPartialPopupHandler.class$("de.audi.atip.hmi.view.IPartialPopupListener")) : class$de$audi$atip$hmi$view$IPartialPopupListener).getName(), this, null, this.application.getBundleContext(), this.logChannel);
        this.logChannel.log(1000000, "[ACSeatPartialPopupHandler#initServiceProvider] start IPartialPopupListener Service");
        this.partialPopinServiceProvider.startService();
    }

    private void deinitServiceProvider() {
        this.partialPopinServiceProvider.stopService();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void partialPopupVisible(int n, int n2) {
        this.logChannel.log(1000000, "[ACSeatPartialPopupHandler#partialPopupVisible] id = %1", (long)n);
        boolean bl = false;
        Object object = this.mutex;
        synchronized (object) {
            Integer n3 = new Integer(this.component.getZoneFromPPID(n));
            if (this.visiblePPIDs.containsKey(n3) && this.get(this.visiblePPIDs, n3) != n) {
                this.visiblePPIDs.put(n3, new Integer(n));
                this.pendingPPIDsForShow.remove(n3);
                this.logChannel.log(1000000, "[ACSeatPartialPopupHandler#partialPopupVisible] Zone:%1 HMI(%2)->APP(): not sending show to FSG", (Object)n3, (long)n);
            } else {
                this.visiblePPIDs.put(n3, new Integer(n));
                this.pendingPPIDsForShow.remove(n3);
                if (!this.isWaitRequired(this.pendingPPIDsForShow, n3)) {
                    this.logChannel.log(1000000, "[ACSeatPartialPopupHandler#partialPopupVisible] Zone:%1 HMI(%2)->APP(): showAirconPopup", (Object)n3, (long)n);
                    AirconContent airconContent = this.builAirconContent(this.visiblePPIDs);
                    this.component.showAirconPopup(airconContent);
                } else {
                    this.logChannel.log(1000000, "[ACSeatPartialPopupHandler#partialPopupVisible] Zone:%1 HMI(%2)->APP(): waiting for mirror popup", (Object)n3, (long)n);
                }
            }
            if (this.pendingPPIDsForShow.isEmpty()) {
                bl = true;
            }
        }
        if (bl) {
            this.component.processNextRequest();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void partialPopupHidden(int n, int n2) {
        this.logChannel.log(1000000, "[ACSeatPartialPopupHandler#partialPopupHidden] id = %1", (long)n);
        boolean bl = false;
        Object object = this.mutex;
        synchronized (object) {
            Integer n3 = new Integer(this.component.getZoneFromPPID(n));
            if (this.pendingPPIDsForShow.containsKey(n3) && this.get(this.pendingPPIDsForShow, n3) == n && (!this.visiblePPIDs.containsKey(n3) || this.get(this.visiblePPIDs, n3) != n)) {
                this.logChannel.log(1000000, "[ACSeatPartialPopupHandler#partialPopupHidden] Zone:%1 HMI(%2)->APP(): showAirconPopup - NONE", (Object)n3, (long)n);
                this.pendingPPIDsForShow.remove(n3);
                if (this.pendingPPIDsForShow.isEmpty()) {
                    AirconContent airconContent = this.builAirconContent(this.visiblePPIDs);
                    this.component.showAirconPopup(airconContent);
                    if (this.pendingPPIDsForCancel.isEmpty()) {
                        bl = true;
                    }
                }
            }
            this.application.getFrameworkAccess().getHMIService().removePartialPopup(0, n);
        }
        if (bl) {
            this.component.processNextRequest();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void partialPopupRemoved(int n, int n2) {
        this.logChannel.log(1000000, "[ACSeatPartialPopupHandler#partialPopupRemoved] id = %1", (long)n);
        boolean bl = false;
        Object object = this.mutex;
        synchronized (object) {
            Integer n3 = new Integer(this.component.getZoneFromPPID(n));
            if (this.pendingPPIDsForShow.containsKey(n3)) {
                this.logChannel.log(1000000, "[ACSeatPartialPopupHandler#partialPopupRemoved] Zone:%1 HMI(%2)->APP(): not sending cancel to FSG", (Object)n3, (long)n);
                if (this.pendingPPIDsForCancel.containsKey(n3) && this.get(this.pendingPPIDsForCancel, n3) == n) {
                    this.logChannel.log(1000000, "[ACSeatPartialPopupHandler#partialPopupRemoved] Zone:%1 HMI(%2)->APP(): euque needed for pendingPPIDsForCancel, because popup has been canceled");
                    this.pendingPPIDsForCancel.remove(n3);
                }
                if (this.get(this.pendingPPIDsForShow, n3) == n) {
                    this.logChannel.log(1000000, "[ACSeatPartialPopupHandler#partialPopupRemoved] Zone:%1 HMI(%2)->APP(): euque needed for pendingPPIDsForShow, because popup has been canceled");
                    this.pendingPPIDsForShow.remove(n3);
                }
                if (this.pendingPPIDsForCancel.isEmpty() && this.pendingPPIDsForShow.isEmpty() || this.visiblePPIDs.isEmpty()) {
                    bl = true;
                }
            } else if (this.pendingPPIDsForCancel.isEmpty()) {
                if (!this.visiblePPIDs.isEmpty()) {
                    this.logChannel.log(1000000, "[ACSeatPartialPopupHandler#partialPopupRemoved] Zone:%1 HMI(%2)->APP(): cancelAirconPopup", (Object)n3, (long)n);
                    AirconContent airconContent = this.builAirconContent(this.visiblePPIDs);
                    this.visiblePPIDs.clear();
                    this.component.cancelAirconPopup(airconContent, 1);
                    bl = true;
                } else {
                    this.logChannel.log(1000000, "[ACSeatPartialPopupHandler#partialPopupRemoved] Zone:%1 HMI(%2)->APP(): Popup may have been previously canceled", (Object)n3, (long)n);
                }
            } else {
                this.visiblePPIDs.remove(n3);
                if (this.pendingPPIDsForCancel.size() == 1 || !this.isWaitRequired(this.visiblePPIDs, n3)) {
                    this.logChannel.log(1000000, "[ACSeatPartialPopupHandler#partialPopupRemoved] Zone:%1 HMI(%2)->APP(): cancelAirconPopup", (Object)n3, (long)n);
                    AirconContent airconContent = this.builAirconContent(this.pendingPPIDsForCancel);
                    this.pendingPPIDsForCancel.clear();
                    this.component.cancelAirconPopup(airconContent, 0);
                    bl = true;
                } else {
                    this.logChannel.log(1000000, "[ACSeatPartialPopupHandler#requestACPopup] Zone:%1 HMI(%2)->APP(): waiting for mirror popup", (Object)n3, (long)n);
                }
            }
        }
        if (bl) {
            this.component.processNextRequest();
        }
    }

    public int[] getPPIDsForCallbacks() {
        if (this.popinIDsForCallbacks == null) {
            return new int[0];
        }
        return this.popinIDsForCallbacks;
    }

    public void partialPopupListenerRegistered(int n, int n2, boolean bl) {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void requestACPopup(AirconContent airconContent) {
        boolean bl = false;
        Object object = this.mutex;
        synchronized (object) {
            this.processAirconZone(airconContent.getZone1(), IACSeatConstants.ZONE_1_MASK);
            this.processAirconZone(airconContent.getZone2(), IACSeatConstants.ZONE_2_MASK);
            this.processAirconZone(airconContent.getZone3(), IACSeatConstants.ZONE_3_MASK);
            this.processAirconZone(airconContent.getZone4(), IACSeatConstants.ZONE_4_MASK);
            if (this.pendingPPIDsForShow.isEmpty() && this.pendingPPIDsForCancel.isEmpty()) {
                bl = true;
            }
        }
        if (bl) {
            this.component.processNextRequest();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateACPopup(AirconContent airconContent) {
        boolean bl = false;
        Object object = this.mutex;
        synchronized (object) {
            this.processAirconZoneUpdate(airconContent.getZone1(), IACSeatConstants.ZONE_1_MASK);
            this.processAirconZoneUpdate(airconContent.getZone2(), IACSeatConstants.ZONE_2_MASK);
            this.processAirconZoneUpdate(airconContent.getZone3(), IACSeatConstants.ZONE_3_MASK);
            this.processAirconZoneUpdate(airconContent.getZone4(), IACSeatConstants.ZONE_4_MASK);
            if (this.pendingPPIDsForShow.isEmpty() && this.pendingPPIDsForCancel.isEmpty()) {
                bl = true;
            }
        }
        if (bl) {
            this.component.processNextRequest();
        }
    }

    private void processAirconZoneUpdate(int n, Integer n2) {
        if (n != 0 && this.visiblePPIDs.containsKey(n2)) {
            this.processAirconZone(n, n2);
        } else {
            this.logChannel.log(1000000, "[ACSeatPartialPopupHandler#processAirconZoneUpdate] Zone:%1 : Ignore update because no popup visible or requested popup is NONE", (Object)n2);
        }
    }

    private void processAirconZone(int n, Integer n2) {
        Integer n3 = this.component.getPPIDfromContent(n2, n);
        if (n != 0) {
            if (n3 == -1) {
                this.logChannel.log(1000000, "[ACSeatPartialPopupHandler#processAirconZone] Popup from Zone=%1 with DSI-ID=%2 is not supported", (Object)n2, (long)n);
                return;
            }
            if (!this.visiblePPIDs.containsKey(n2) || !n3.equals(this.visiblePPIDs.get(n2))) {
                if (this.visiblePPIDs.containsKey(n2)) {
                    this.application.getFrameworkAccess().getHMIService().removePartialPopup(0, this.get(this.visiblePPIDs, n2));
                }
                this.pendingPPIDsForShow.put(n2, n3);
                this.application.getFrameworkAccess().getHMIService().showPartialPopup(0, n3);
                this.logChannel.log(1000000, "[ACSeatPartialPopupHandler#processAirconZone] Zone:%1 APP(%2)->HMI(%3): showPartialPopup", (Object)n2, (long)n, (long)n3.intValue());
            } else {
                this.logChannel.log(1000000, "[ACSeatPartialPopupHandler#processAirconZone] Zone:%1 : Ignore update because popup already visible", (Object)n2);
            }
        } else if (this.visiblePPIDs.containsKey(n2)) {
            this.pendingPPIDsForCancel.put(n2, this.visiblePPIDs.get(n2));
            this.application.getFrameworkAccess().getHMIService().removePartialPopup(0, this.get(this.visiblePPIDs, n2));
            this.logChannel.log(1000000, "[ACSeatPartialPopupHandler#processAirconZone] Zone:%1 APP(%2)->HMI(%3): removePartialPopup", (Object)n2, (long)n, (long)((Integer)this.visiblePPIDs.get(n2)).intValue());
        } else {
            this.logChannel.log(1000000, "[ACSeatPartialPopupHandler#processAirconZone] Zone:%1 : Ignore update because no popup visible", (Object)n2);
        }
    }

    private AirconContent builAirconContent(Map map) {
        AirconContent airconContent = new AirconContent();
        airconContent.zone1 = map.containsKey(IACSeatConstants.ZONE_1_MASK) ? this.component.getDSIIdFromPPID(this.get(map, IACSeatConstants.ZONE_1_MASK)) : 0;
        airconContent.zone2 = map.containsKey(IACSeatConstants.ZONE_2_MASK) ? this.component.getDSIIdFromPPID(this.get(map, IACSeatConstants.ZONE_2_MASK)) : 0;
        airconContent.zone3 = map.containsKey(IACSeatConstants.ZONE_3_MASK) ? this.component.getDSIIdFromPPID(this.get(map, IACSeatConstants.ZONE_3_MASK)) : 0;
        airconContent.zone4 = map.containsKey(IACSeatConstants.ZONE_4_MASK) ? this.component.getDSIIdFromPPID(this.get(map, IACSeatConstants.ZONE_4_MASK)) : 0;
        return airconContent;
    }

    private int get(Map map, Integer n) {
        Integer n2 = (Integer)map.get(n);
        return n2 == null ? -1 : n2;
    }

    private boolean isWaitRequired(Map map, Integer n) {
        boolean bl = false;
        if (n.equals(IACSeatConstants.ZONE_1_MASK) && map.containsKey(IACSeatConstants.ZONE_2_MASK)) {
            bl = true;
        }
        if (n.equals(IACSeatConstants.ZONE_2_MASK) && map.containsKey(IACSeatConstants.ZONE_1_MASK)) {
            bl = true;
        }
        if (n.equals(IACSeatConstants.ZONE_3_MASK) && map.containsKey(IACSeatConstants.ZONE_4_MASK)) {
            bl = true;
        }
        if (n.equals(IACSeatConstants.ZONE_4_MASK) && map.containsKey(IACSeatConstants.ZONE_3_MASK)) {
            bl = true;
        }
        return bl;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void triggerEmergencyFlush() {
        Object object = this.mutex;
        synchronized (object) {
            HashMap hashMap = new HashMap();
            this.enqueuPopupsForFlush(hashMap, this.visiblePPIDs);
            this.enqueuPopupsForFlush(hashMap, this.pendingPPIDsForShow);
            this.visiblePPIDs.clear();
            this.pendingPPIDsForShow.clear();
            this.pendingPPIDsForCancel.clear();
            this.cancelPopupsFromQueue(hashMap);
        }
    }

    private void enqueuPopupsForFlush(Map map, Map map2) {
        Iterator iterator = map2.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            map.put(entry.getKey(), entry.getValue());
        }
    }

    private void cancelPopupsFromQueue(Map map) {
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            Integer n = (Integer)entry.getValue();
            this.application.getFrameworkAccess().getHMIService().removePartialPopup(0, n);
        }
    }

    public void informAboutPPCoordinates(int n, int n2, int n3, int n4, int n5, int n6) {
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

