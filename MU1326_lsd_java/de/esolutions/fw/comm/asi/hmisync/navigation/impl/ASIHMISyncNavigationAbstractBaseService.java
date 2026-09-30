/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.navigation.impl;

import de.esolutions.fw.comm.asi.hmisync.navigation.ASIHMISyncNavigationReply;
import de.esolutions.fw.comm.asi.hmisync.navigation.ASIHMISyncNavigationS;
import de.esolutions.fw.comm.asi.hmisync.navigation.CarPosition;
import de.esolutions.fw.comm.asi.hmisync.navigation.DestinationInfo;
import de.esolutions.fw.comm.asi.hmisync.navigation.NextDestinationInfo;
import de.esolutions.fw.comm.attributes.AttributesBaseService;
import de.esolutions.fw.comm.attributes.IAttributeBitMapProvider;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.method.MethodException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public abstract class ASIHMISyncNavigationAbstractBaseService
implements ASIHMISyncNavigationS {
    private static final CallContext context = CallContext.getContext("ABSTRACTBASESERVICE.asi.hmisync.navigation.ASIHMISyncNavigation");
    private static final int attributesCount = 9;
    private String ASIVersion;
    private boolean ASIVersion_valid = false;
    private short[] RequestIDs;
    private boolean RequestIDs_valid = false;
    private short[] ReplyIDs;
    private boolean ReplyIDs_valid = false;
    private boolean RouteGuidanceActive;
    private boolean RouteGuidanceActive_valid = false;
    private CarPosition CarPosition;
    private boolean CarPosition_valid = false;
    private DestinationInfo[] DestinationInfo;
    private boolean DestinationInfo_valid = false;
    private DestinationInfo[] DestinationsForGuidance;
    private boolean DestinationsForGuidance_valid = false;
    private NextDestinationInfo NextDestinationInfo;
    private boolean NextDestinationInfo_valid = false;
    private boolean NightDesignRequested;
    private boolean NightDesignRequested_valid = false;
    private AttributesBaseService baseService;

    public static String copyString(String string) {
        if (string != null) {
            return new String(string);
        }
        return null;
    }

    public static CarPosition copyCarPosition(CarPosition carPosition) {
        if (carPosition == null) {
            return null;
        }
        CarPosition carPosition2 = new CarPosition();
        carPosition2.longitude = carPosition.longitude;
        carPosition2.latitude = carPosition.latitude;
        carPosition2.angle = carPosition.angle;
        carPosition2.speed = carPosition.speed;
        carPosition2.height = carPosition.height;
        return carPosition2;
    }

    public static DestinationInfo copyDestinationInfo(DestinationInfo destinationInfo) {
        if (destinationInfo == null) {
            return null;
        }
        DestinationInfo destinationInfo2 = new DestinationInfo();
        destinationInfo2.longitude = destinationInfo.longitude;
        destinationInfo2.latitude = destinationInfo.latitude;
        destinationInfo2.country = ASIHMISyncNavigationAbstractBaseService.copyString(destinationInfo.country);
        destinationInfo2.city = ASIHMISyncNavigationAbstractBaseService.copyString(destinationInfo.city);
        destinationInfo2.street = ASIHMISyncNavigationAbstractBaseService.copyString(destinationInfo.street);
        destinationInfo2.junction = ASIHMISyncNavigationAbstractBaseService.copyString(destinationInfo.junction);
        destinationInfo2.housenumber = ASIHMISyncNavigationAbstractBaseService.copyString(destinationInfo.housenumber);
        destinationInfo2.poiName = ASIHMISyncNavigationAbstractBaseService.copyString(destinationInfo.poiName);
        if (destinationInfo.formattedDestination != null) {
            destinationInfo2.formattedDestination = new String[destinationInfo.formattedDestination.length];
            for (int i2 = 0; i2 < destinationInfo.formattedDestination.length; ++i2) {
                destinationInfo2.formattedDestination[i2] = ASIHMISyncNavigationAbstractBaseService.copyString(destinationInfo.formattedDestination[i2]);
            }
        } else {
            destinationInfo2.formattedDestination = null;
        }
        destinationInfo2.distanceFromStartOfDestinationToFinalDestination = destinationInfo.distanceFromStartOfDestinationToFinalDestination;
        destinationInfo2.distanceFromEndOfDestinationToFinalDestination = destinationInfo.distanceFromEndOfDestinationToFinalDestination;
        destinationInfo2.remainingTravelTimeToFinalDestination = destinationInfo.remainingTravelTimeToFinalDestination;
        return destinationInfo2;
    }

    public static NextDestinationInfo copyNextDestinationInfo(NextDestinationInfo nextDestinationInfo) {
        if (nextDestinationInfo == null) {
            return null;
        }
        NextDestinationInfo nextDestinationInfo2 = new NextDestinationInfo();
        nextDestinationInfo2.destinationIndex = nextDestinationInfo.destinationIndex;
        nextDestinationInfo2.distanceToNextDestination = nextDestinationInfo.distanceToNextDestination;
        nextDestinationInfo2.timeToNextDestiantion = nextDestinationInfo.timeToNextDestiantion;
        return nextDestinationInfo2;
    }

    public ASIHMISyncNavigationAbstractBaseService() {
        AttributesBitMapProvider attributesBitMapProvider = new AttributesBitMapProvider();
        this.baseService = new AttributesBaseService("ASIHMISyncNavigation", attributesBitMapProvider);
    }

    public synchronized void setNotification(long l, ASIHMISyncNavigationReply aSIHMISyncNavigationReply) {
        this.baseService.setNotification(l, (Object)aSIHMISyncNavigationReply);
        this.sendAttributeUpdate(l, aSIHMISyncNavigationReply);
    }

    public synchronized void setNotification(ASIHMISyncNavigationReply aSIHMISyncNavigationReply) {
        this.baseService.setNotification(aSIHMISyncNavigationReply);
        this.sendAttributeUpdate(aSIHMISyncNavigationReply);
    }

    public synchronized void setNotification(long[] lArray, ASIHMISyncNavigationReply aSIHMISyncNavigationReply) {
        this.baseService.setNotification(lArray, (Object)aSIHMISyncNavigationReply);
        this.sendAttributeUpdate(lArray, aSIHMISyncNavigationReply);
    }

    public synchronized void clearNotification(long l, ASIHMISyncNavigationReply aSIHMISyncNavigationReply) {
        this.baseService.clearNotification(l, (Object)aSIHMISyncNavigationReply);
    }

    public synchronized void clearNotification(ASIHMISyncNavigationReply aSIHMISyncNavigationReply) {
        this.baseService.clearNotification(aSIHMISyncNavigationReply);
    }

    public synchronized void clearNotification(long[] lArray, ASIHMISyncNavigationReply aSIHMISyncNavigationReply) {
        this.baseService.clearNotification(lArray, (Object)aSIHMISyncNavigationReply);
    }

    private void sendAttributeUpdate(ASIHMISyncNavigationReply aSIHMISyncNavigationReply) {
        try {
            aSIHMISyncNavigationReply.updateASIVersion(this.ASIVersion, this.ASIVersion_valid);
            aSIHMISyncNavigationReply.updateRequestIDs(this.RequestIDs, this.RequestIDs_valid);
            aSIHMISyncNavigationReply.updateReplyIDs(this.ReplyIDs, this.ReplyIDs_valid);
            aSIHMISyncNavigationReply.updateRouteGuidanceActive(this.RouteGuidanceActive, this.RouteGuidanceActive_valid);
            aSIHMISyncNavigationReply.updateCarPosition(this.CarPosition, this.CarPosition_valid);
            aSIHMISyncNavigationReply.updateDestinationInfo(this.DestinationInfo, this.DestinationInfo_valid);
            aSIHMISyncNavigationReply.updateDestinationsForGuidance(this.DestinationsForGuidance, this.DestinationsForGuidance_valid);
            aSIHMISyncNavigationReply.updateNextDestinationInfo(this.NextDestinationInfo, this.NextDestinationInfo_valid);
            aSIHMISyncNavigationReply.updateNightDesignRequested(this.NightDesignRequested, this.NightDesignRequested_valid);
        }
        catch (MethodException methodException) {
            // empty catch block
        }
    }

    private void sendAttributeUpdate(long[] lArray, ASIHMISyncNavigationReply aSIHMISyncNavigationReply) {
        for (int i2 = 0; i2 < lArray.length; ++i2) {
            this.sendAttributeUpdate(lArray[i2], aSIHMISyncNavigationReply);
        }
    }

    private void sendAttributeUpdate(long l, ASIHMISyncNavigationReply aSIHMISyncNavigationReply) {
        try {
            if (l == 10L) {
                aSIHMISyncNavigationReply.updateASIVersion(this.ASIVersion, this.ASIVersion_valid);
            } else if (l == 19L) {
                aSIHMISyncNavigationReply.updateRequestIDs(this.RequestIDs, this.RequestIDs_valid);
            } else if (l == 18L) {
                aSIHMISyncNavigationReply.updateReplyIDs(this.ReplyIDs, this.ReplyIDs_valid);
            } else if (l == 16L) {
                aSIHMISyncNavigationReply.updateRouteGuidanceActive(this.RouteGuidanceActive, this.RouteGuidanceActive_valid);
            } else if (l == 11L) {
                aSIHMISyncNavigationReply.updateCarPosition(this.CarPosition, this.CarPosition_valid);
            } else if (l == 12L) {
                aSIHMISyncNavigationReply.updateDestinationInfo(this.DestinationInfo, this.DestinationInfo_valid);
            } else if (l == 13L) {
                aSIHMISyncNavigationReply.updateDestinationsForGuidance(this.DestinationsForGuidance, this.DestinationsForGuidance_valid);
            } else if (l == 15L) {
                aSIHMISyncNavigationReply.updateNextDestinationInfo(this.NextDestinationInfo, this.NextDestinationInfo_valid);
            } else if (l == 17L) {
                aSIHMISyncNavigationReply.updateNightDesignRequested(this.NightDesignRequested, this.NightDesignRequested_valid);
            } else {
                System.out.println("unexpected");
            }
        }
        catch (MethodException methodException) {
            // empty catch block
        }
    }

    public void updateASIVersion(String string) throws MethodException {
        this.updateASIVersion(string, true);
    }

    public void updateASIVersion(String string, boolean bl) throws MethodException {
        this.ASIVersion = ASIHMISyncNavigationAbstractBaseService.copyString(string);
        this.ASIVersion_valid = bl;
        List list = this.baseService.getNotifications(10);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncNavigationReply aSIHMISyncNavigationReply = (ASIHMISyncNavigationReply)iterator.next();
            try {
                aSIHMISyncNavigationReply.updateASIVersion(string, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateRequestIDs(short[] sArray) throws MethodException {
        this.updateRequestIDs(sArray, true);
    }

    public void updateRequestIDs(short[] sArray, boolean bl) throws MethodException {
        if (sArray != null) {
            this.RequestIDs = new short[sArray.length];
            System.arraycopy((Object)sArray, 0, (Object)this.RequestIDs, 0, sArray.length);
        } else {
            this.RequestIDs = null;
        }
        this.RequestIDs_valid = bl;
        List list = this.baseService.getNotifications(19);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncNavigationReply aSIHMISyncNavigationReply = (ASIHMISyncNavigationReply)iterator.next();
            try {
                aSIHMISyncNavigationReply.updateRequestIDs(sArray, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateReplyIDs(short[] sArray) throws MethodException {
        this.updateReplyIDs(sArray, true);
    }

    public void updateReplyIDs(short[] sArray, boolean bl) throws MethodException {
        if (sArray != null) {
            this.ReplyIDs = new short[sArray.length];
            System.arraycopy((Object)sArray, 0, (Object)this.ReplyIDs, 0, sArray.length);
        } else {
            this.ReplyIDs = null;
        }
        this.ReplyIDs_valid = bl;
        List list = this.baseService.getNotifications(18);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncNavigationReply aSIHMISyncNavigationReply = (ASIHMISyncNavigationReply)iterator.next();
            try {
                aSIHMISyncNavigationReply.updateReplyIDs(sArray, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateRouteGuidanceActive(boolean bl) throws MethodException {
        this.updateRouteGuidanceActive(bl, true);
    }

    public void updateRouteGuidanceActive(boolean bl, boolean bl2) throws MethodException {
        this.RouteGuidanceActive = bl;
        this.RouteGuidanceActive_valid = bl2;
        List list = this.baseService.getNotifications(16);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncNavigationReply aSIHMISyncNavigationReply = (ASIHMISyncNavigationReply)iterator.next();
            try {
                aSIHMISyncNavigationReply.updateRouteGuidanceActive(bl, bl2);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateCarPosition(CarPosition carPosition) throws MethodException {
        this.updateCarPosition(carPosition, true);
    }

    public void updateCarPosition(CarPosition carPosition, boolean bl) throws MethodException {
        this.CarPosition = ASIHMISyncNavigationAbstractBaseService.copyCarPosition(carPosition);
        this.CarPosition_valid = bl;
        List list = this.baseService.getNotifications(11);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncNavigationReply aSIHMISyncNavigationReply = (ASIHMISyncNavigationReply)iterator.next();
            try {
                aSIHMISyncNavigationReply.updateCarPosition(carPosition, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateDestinationInfo(DestinationInfo[] destinationInfoArray) throws MethodException {
        this.updateDestinationInfo(destinationInfoArray, true);
    }

    public void updateDestinationInfo(DestinationInfo[] destinationInfoArray, boolean bl) throws MethodException {
        if (destinationInfoArray != null) {
            this.DestinationInfo = new DestinationInfo[destinationInfoArray.length];
            for (int i2 = 0; i2 < destinationInfoArray.length; ++i2) {
                this.DestinationInfo[i2] = ASIHMISyncNavigationAbstractBaseService.copyDestinationInfo(destinationInfoArray[i2]);
            }
        } else {
            this.DestinationInfo = null;
        }
        this.DestinationInfo_valid = bl;
        List list = this.baseService.getNotifications(12);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncNavigationReply aSIHMISyncNavigationReply = (ASIHMISyncNavigationReply)iterator.next();
            try {
                aSIHMISyncNavigationReply.updateDestinationInfo(destinationInfoArray, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateDestinationsForGuidance(DestinationInfo[] destinationInfoArray) throws MethodException {
        this.updateDestinationsForGuidance(destinationInfoArray, true);
    }

    public void updateDestinationsForGuidance(DestinationInfo[] destinationInfoArray, boolean bl) throws MethodException {
        if (destinationInfoArray != null) {
            this.DestinationsForGuidance = new DestinationInfo[destinationInfoArray.length];
            for (int i2 = 0; i2 < destinationInfoArray.length; ++i2) {
                this.DestinationsForGuidance[i2] = ASIHMISyncNavigationAbstractBaseService.copyDestinationInfo(destinationInfoArray[i2]);
            }
        } else {
            this.DestinationsForGuidance = null;
        }
        this.DestinationsForGuidance_valid = bl;
        List list = this.baseService.getNotifications(13);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncNavigationReply aSIHMISyncNavigationReply = (ASIHMISyncNavigationReply)iterator.next();
            try {
                aSIHMISyncNavigationReply.updateDestinationsForGuidance(destinationInfoArray, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateNextDestinationInfo(NextDestinationInfo nextDestinationInfo) throws MethodException {
        this.updateNextDestinationInfo(nextDestinationInfo, true);
    }

    public void updateNextDestinationInfo(NextDestinationInfo nextDestinationInfo, boolean bl) throws MethodException {
        this.NextDestinationInfo = ASIHMISyncNavigationAbstractBaseService.copyNextDestinationInfo(nextDestinationInfo);
        this.NextDestinationInfo_valid = bl;
        List list = this.baseService.getNotifications(15);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncNavigationReply aSIHMISyncNavigationReply = (ASIHMISyncNavigationReply)iterator.next();
            try {
                aSIHMISyncNavigationReply.updateNextDestinationInfo(nextDestinationInfo, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateNightDesignRequested(boolean bl) throws MethodException {
        this.updateNightDesignRequested(bl, true);
    }

    public void updateNightDesignRequested(boolean bl, boolean bl2) throws MethodException {
        this.NightDesignRequested = bl;
        this.NightDesignRequested_valid = bl2;
        List list = this.baseService.getNotifications(17);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncNavigationReply aSIHMISyncNavigationReply = (ASIHMISyncNavigationReply)iterator.next();
            try {
                aSIHMISyncNavigationReply.updateNightDesignRequested(bl, bl2);
            }
            catch (MethodException methodException) {}
        }
    }

    private static class AttributesBitMapProvider
    implements IAttributeBitMapProvider {
        private final HashMap map = new HashMap();

        public AttributesBitMapProvider() {
            this.map.put(new Long(10L), new Integer(0));
            this.map.put(new Long(19L), new Integer(1));
            this.map.put(new Long(18L), new Integer(2));
            this.map.put(new Long(16L), new Integer(3));
            this.map.put(new Long(11L), new Integer(4));
            this.map.put(new Long(12L), new Integer(5));
            this.map.put(new Long(13L), new Integer(6));
            this.map.put(new Long(15L), new Integer(7));
            this.map.put(new Long(17L), new Integer(8));
        }

        public int getAttributeBit(long l) {
            Integer n = (Integer)this.map.get(new Long(l));
            return n;
        }

        public int getAttributesCount() {
            return 9;
        }
    }
}

