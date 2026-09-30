/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.zeroemission.impl;

import de.esolutions.fw.comm.asi.hmisync.car.zeroemission.ASIHMISyncCarZeroEmissionReply;
import de.esolutions.fw.comm.asi.hmisync.car.zeroemission.ASIHMISyncCarZeroEmissionS;
import de.esolutions.fw.comm.asi.hmisync.car.zeroemission.ZeroEmissionEntry;
import de.esolutions.fw.comm.attributes.AttributesBaseService;
import de.esolutions.fw.comm.attributes.IAttributeBitMapProvider;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.method.MethodException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public abstract class ASIHMISyncCarZeroEmissionAbstractBaseService
implements ASIHMISyncCarZeroEmissionS {
    private static final CallContext context = CallContext.getContext("ABSTRACTBASESERVICE.asi.hmisync.car.zeroemission.ASIHMISyncCarZeroEmission");
    private static final int attributesCount = 6;
    private String ASIVersion;
    private boolean ASIVersion_valid = false;
    private short[] RequestIDs;
    private boolean RequestIDs_valid = false;
    private short[] ReplyIDs;
    private boolean ReplyIDs_valid = false;
    private int ZEVisibilityState;
    private boolean ZEVisibilityState_valid = false;
    private ZeroEmissionEntry[] ZeroEmissionValues;
    private boolean ZeroEmissionValues_valid = false;
    private ZeroEmissionEntry CurrentZeroEmissionValue;
    private boolean CurrentZeroEmissionValue_valid = false;
    private AttributesBaseService baseService;

    public static String copyString(String string) {
        if (string != null) {
            return new String(string);
        }
        return null;
    }

    public static ZeroEmissionEntry copyZeroEmissionEntry(ZeroEmissionEntry zeroEmissionEntry) {
        if (zeroEmissionEntry == null) {
            return null;
        }
        ZeroEmissionEntry zeroEmissionEntry2 = new ZeroEmissionEntry();
        if (zeroEmissionEntry.values != null) {
            zeroEmissionEntry2.values = new short[zeroEmissionEntry.values.length];
            System.arraycopy((Object)zeroEmissionEntry.values, 0, (Object)zeroEmissionEntry2.values, 0, zeroEmissionEntry2.values.length);
        } else {
            zeroEmissionEntry2.values = null;
        }
        zeroEmissionEntry2.state = zeroEmissionEntry.state;
        return zeroEmissionEntry2;
    }

    public ASIHMISyncCarZeroEmissionAbstractBaseService() {
        AttributesBitMapProvider attributesBitMapProvider = new AttributesBitMapProvider();
        this.baseService = new AttributesBaseService("ASIHMISyncCarZeroEmission", attributesBitMapProvider);
    }

    public synchronized void setNotification(long l, ASIHMISyncCarZeroEmissionReply aSIHMISyncCarZeroEmissionReply) {
        this.baseService.setNotification(l, (Object)aSIHMISyncCarZeroEmissionReply);
        this.sendAttributeUpdate(l, aSIHMISyncCarZeroEmissionReply);
    }

    public synchronized void setNotification(ASIHMISyncCarZeroEmissionReply aSIHMISyncCarZeroEmissionReply) {
        this.baseService.setNotification(aSIHMISyncCarZeroEmissionReply);
        this.sendAttributeUpdate(aSIHMISyncCarZeroEmissionReply);
    }

    public synchronized void setNotification(long[] lArray, ASIHMISyncCarZeroEmissionReply aSIHMISyncCarZeroEmissionReply) {
        this.baseService.setNotification(lArray, (Object)aSIHMISyncCarZeroEmissionReply);
        this.sendAttributeUpdate(lArray, aSIHMISyncCarZeroEmissionReply);
    }

    public synchronized void clearNotification(long l, ASIHMISyncCarZeroEmissionReply aSIHMISyncCarZeroEmissionReply) {
        this.baseService.clearNotification(l, (Object)aSIHMISyncCarZeroEmissionReply);
    }

    public synchronized void clearNotification(ASIHMISyncCarZeroEmissionReply aSIHMISyncCarZeroEmissionReply) {
        this.baseService.clearNotification(aSIHMISyncCarZeroEmissionReply);
    }

    public synchronized void clearNotification(long[] lArray, ASIHMISyncCarZeroEmissionReply aSIHMISyncCarZeroEmissionReply) {
        this.baseService.clearNotification(lArray, (Object)aSIHMISyncCarZeroEmissionReply);
    }

    private void sendAttributeUpdate(ASIHMISyncCarZeroEmissionReply aSIHMISyncCarZeroEmissionReply) {
        try {
            aSIHMISyncCarZeroEmissionReply.updateASIVersion(this.ASIVersion, this.ASIVersion_valid);
            aSIHMISyncCarZeroEmissionReply.updateRequestIDs(this.RequestIDs, this.RequestIDs_valid);
            aSIHMISyncCarZeroEmissionReply.updateReplyIDs(this.ReplyIDs, this.ReplyIDs_valid);
            aSIHMISyncCarZeroEmissionReply.updateZEVisibilityState(this.ZEVisibilityState, this.ZEVisibilityState_valid);
            aSIHMISyncCarZeroEmissionReply.updateZeroEmissionValues(this.ZeroEmissionValues, this.ZeroEmissionValues_valid);
            aSIHMISyncCarZeroEmissionReply.updateCurrentZeroEmissionValue(this.CurrentZeroEmissionValue, this.CurrentZeroEmissionValue_valid);
        }
        catch (MethodException methodException) {
            // empty catch block
        }
    }

    private void sendAttributeUpdate(long[] lArray, ASIHMISyncCarZeroEmissionReply aSIHMISyncCarZeroEmissionReply) {
        for (int i2 = 0; i2 < lArray.length; ++i2) {
            this.sendAttributeUpdate(lArray[i2], aSIHMISyncCarZeroEmissionReply);
        }
    }

    private void sendAttributeUpdate(long l, ASIHMISyncCarZeroEmissionReply aSIHMISyncCarZeroEmissionReply) {
        try {
            if (l == 6L) {
                aSIHMISyncCarZeroEmissionReply.updateASIVersion(this.ASIVersion, this.ASIVersion_valid);
            } else if (l == 9L) {
                aSIHMISyncCarZeroEmissionReply.updateRequestIDs(this.RequestIDs, this.RequestIDs_valid);
            } else if (l == 8L) {
                aSIHMISyncCarZeroEmissionReply.updateReplyIDs(this.ReplyIDs, this.ReplyIDs_valid);
            } else if (l == 11L) {
                aSIHMISyncCarZeroEmissionReply.updateZEVisibilityState(this.ZEVisibilityState, this.ZEVisibilityState_valid);
            } else if (l == 10L) {
                aSIHMISyncCarZeroEmissionReply.updateZeroEmissionValues(this.ZeroEmissionValues, this.ZeroEmissionValues_valid);
            } else if (l == 7L) {
                aSIHMISyncCarZeroEmissionReply.updateCurrentZeroEmissionValue(this.CurrentZeroEmissionValue, this.CurrentZeroEmissionValue_valid);
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
        this.ASIVersion = ASIHMISyncCarZeroEmissionAbstractBaseService.copyString(string);
        this.ASIVersion_valid = bl;
        List list = this.baseService.getNotifications(6);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarZeroEmissionReply aSIHMISyncCarZeroEmissionReply = (ASIHMISyncCarZeroEmissionReply)iterator.next();
            try {
                aSIHMISyncCarZeroEmissionReply.updateASIVersion(string, bl);
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
        List list = this.baseService.getNotifications(9);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarZeroEmissionReply aSIHMISyncCarZeroEmissionReply = (ASIHMISyncCarZeroEmissionReply)iterator.next();
            try {
                aSIHMISyncCarZeroEmissionReply.updateRequestIDs(sArray, bl);
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
        List list = this.baseService.getNotifications(8);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarZeroEmissionReply aSIHMISyncCarZeroEmissionReply = (ASIHMISyncCarZeroEmissionReply)iterator.next();
            try {
                aSIHMISyncCarZeroEmissionReply.updateReplyIDs(sArray, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateZEVisibilityState(int n) throws MethodException {
        this.updateZEVisibilityState(n, true);
    }

    public void updateZEVisibilityState(int n, boolean bl) throws MethodException {
        this.ZEVisibilityState = n;
        this.ZEVisibilityState_valid = bl;
        List list = this.baseService.getNotifications(11);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarZeroEmissionReply aSIHMISyncCarZeroEmissionReply = (ASIHMISyncCarZeroEmissionReply)iterator.next();
            try {
                aSIHMISyncCarZeroEmissionReply.updateZEVisibilityState(n, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateZeroEmissionValues(ZeroEmissionEntry[] zeroEmissionEntryArray) throws MethodException {
        this.updateZeroEmissionValues(zeroEmissionEntryArray, true);
    }

    public void updateZeroEmissionValues(ZeroEmissionEntry[] zeroEmissionEntryArray, boolean bl) throws MethodException {
        if (zeroEmissionEntryArray != null) {
            this.ZeroEmissionValues = new ZeroEmissionEntry[zeroEmissionEntryArray.length];
            for (int i2 = 0; i2 < zeroEmissionEntryArray.length; ++i2) {
                this.ZeroEmissionValues[i2] = ASIHMISyncCarZeroEmissionAbstractBaseService.copyZeroEmissionEntry(zeroEmissionEntryArray[i2]);
            }
        } else {
            this.ZeroEmissionValues = null;
        }
        this.ZeroEmissionValues_valid = bl;
        List list = this.baseService.getNotifications(10);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarZeroEmissionReply aSIHMISyncCarZeroEmissionReply = (ASIHMISyncCarZeroEmissionReply)iterator.next();
            try {
                aSIHMISyncCarZeroEmissionReply.updateZeroEmissionValues(zeroEmissionEntryArray, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateCurrentZeroEmissionValue(ZeroEmissionEntry zeroEmissionEntry) throws MethodException {
        this.updateCurrentZeroEmissionValue(zeroEmissionEntry, true);
    }

    public void updateCurrentZeroEmissionValue(ZeroEmissionEntry zeroEmissionEntry, boolean bl) throws MethodException {
        this.CurrentZeroEmissionValue = ASIHMISyncCarZeroEmissionAbstractBaseService.copyZeroEmissionEntry(zeroEmissionEntry);
        this.CurrentZeroEmissionValue_valid = bl;
        List list = this.baseService.getNotifications(7);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarZeroEmissionReply aSIHMISyncCarZeroEmissionReply = (ASIHMISyncCarZeroEmissionReply)iterator.next();
            try {
                aSIHMISyncCarZeroEmissionReply.updateCurrentZeroEmissionValue(zeroEmissionEntry, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    private static class AttributesBitMapProvider
    implements IAttributeBitMapProvider {
        private final HashMap map = new HashMap();

        public AttributesBitMapProvider() {
            this.map.put(new Long(6L), new Integer(0));
            this.map.put(new Long(9L), new Integer(1));
            this.map.put(new Long(8L), new Integer(2));
            this.map.put(new Long(11L), new Integer(3));
            this.map.put(new Long(10L), new Integer(4));
            this.map.put(new Long(7L), new Integer(5));
        }

        public int getAttributeBit(long l) {
            Integer n = (Integer)this.map.get(new Long(l));
            return n;
        }

        public int getAttributesCount() {
            return 6;
        }
    }
}

