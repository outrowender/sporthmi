/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.mastercontrol.impl;

import de.esolutions.fw.comm.asi.hmisync.mastercontrol.ASIHMISyncMasterControlReply;
import de.esolutions.fw.comm.asi.hmisync.mastercontrol.ASIHMISyncMasterControlS;
import de.esolutions.fw.comm.attributes.AttributesBaseService;
import de.esolutions.fw.comm.attributes.IAttributeBitMapProvider;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.method.MethodException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public abstract class ASIHMISyncMasterControlAbstractBaseService
implements ASIHMISyncMasterControlS {
    private static final CallContext context = CallContext.getContext("ABSTRACTBASESERVICE.asi.hmisync.mastercontrol.ASIHMISyncMasterControl");
    private static final int attributesCount = 7;
    private String ASIVersion;
    private boolean ASIVersion_valid = false;
    private short[] RequestIDs;
    private boolean RequestIDs_valid = false;
    private short[] ReplyIDs;
    private boolean ReplyIDs_valid = false;
    private String HUVersion;
    private boolean HUVersion_valid = false;
    private String VIN;
    private boolean VIN_valid = false;
    private int LockState;
    private boolean LockState_valid = false;
    private int BlockState;
    private boolean BlockState_valid = false;
    private AttributesBaseService baseService;

    public static String copyString(String string) {
        if (string != null) {
            return new String(string);
        }
        return null;
    }

    public ASIHMISyncMasterControlAbstractBaseService() {
        AttributesBitMapProvider attributesBitMapProvider = new AttributesBitMapProvider();
        this.baseService = new AttributesBaseService("ASIHMISyncMasterControl", attributesBitMapProvider);
    }

    public synchronized void setNotification(long l, ASIHMISyncMasterControlReply aSIHMISyncMasterControlReply) {
        this.baseService.setNotification(l, (Object)aSIHMISyncMasterControlReply);
        this.sendAttributeUpdate(l, aSIHMISyncMasterControlReply);
    }

    public synchronized void setNotification(ASIHMISyncMasterControlReply aSIHMISyncMasterControlReply) {
        this.baseService.setNotification(aSIHMISyncMasterControlReply);
        this.sendAttributeUpdate(aSIHMISyncMasterControlReply);
    }

    public synchronized void setNotification(long[] lArray, ASIHMISyncMasterControlReply aSIHMISyncMasterControlReply) {
        this.baseService.setNotification(lArray, (Object)aSIHMISyncMasterControlReply);
        this.sendAttributeUpdate(lArray, aSIHMISyncMasterControlReply);
    }

    public synchronized void clearNotification(long l, ASIHMISyncMasterControlReply aSIHMISyncMasterControlReply) {
        this.baseService.clearNotification(l, (Object)aSIHMISyncMasterControlReply);
    }

    public synchronized void clearNotification(ASIHMISyncMasterControlReply aSIHMISyncMasterControlReply) {
        this.baseService.clearNotification(aSIHMISyncMasterControlReply);
    }

    public synchronized void clearNotification(long[] lArray, ASIHMISyncMasterControlReply aSIHMISyncMasterControlReply) {
        this.baseService.clearNotification(lArray, (Object)aSIHMISyncMasterControlReply);
    }

    private void sendAttributeUpdate(ASIHMISyncMasterControlReply aSIHMISyncMasterControlReply) {
        try {
            aSIHMISyncMasterControlReply.updateASIVersion(this.ASIVersion, this.ASIVersion_valid);
            aSIHMISyncMasterControlReply.updateRequestIDs(this.RequestIDs, this.RequestIDs_valid);
            aSIHMISyncMasterControlReply.updateReplyIDs(this.ReplyIDs, this.ReplyIDs_valid);
            aSIHMISyncMasterControlReply.updateHUVersion(this.HUVersion, this.HUVersion_valid);
            aSIHMISyncMasterControlReply.updateVIN(this.VIN, this.VIN_valid);
            aSIHMISyncMasterControlReply.updateLockState(this.LockState, this.LockState_valid);
            aSIHMISyncMasterControlReply.updateBlockState(this.BlockState, this.BlockState_valid);
        }
        catch (MethodException methodException) {
            // empty catch block
        }
    }

    private void sendAttributeUpdate(long[] lArray, ASIHMISyncMasterControlReply aSIHMISyncMasterControlReply) {
        for (int i2 = 0; i2 < lArray.length; ++i2) {
            this.sendAttributeUpdate(lArray[i2], aSIHMISyncMasterControlReply);
        }
    }

    private void sendAttributeUpdate(long l, ASIHMISyncMasterControlReply aSIHMISyncMasterControlReply) {
        try {
            if (l == 8L) {
                aSIHMISyncMasterControlReply.updateASIVersion(this.ASIVersion, this.ASIVersion_valid);
            } else if (l == 14L) {
                aSIHMISyncMasterControlReply.updateRequestIDs(this.RequestIDs, this.RequestIDs_valid);
            } else if (l == 13L) {
                aSIHMISyncMasterControlReply.updateReplyIDs(this.ReplyIDs, this.ReplyIDs_valid);
            } else if (l == 10L) {
                aSIHMISyncMasterControlReply.updateHUVersion(this.HUVersion, this.HUVersion_valid);
            } else if (l == 12L) {
                aSIHMISyncMasterControlReply.updateVIN(this.VIN, this.VIN_valid);
            } else if (l == 11L) {
                aSIHMISyncMasterControlReply.updateLockState(this.LockState, this.LockState_valid);
            } else if (l == 9L) {
                aSIHMISyncMasterControlReply.updateBlockState(this.BlockState, this.BlockState_valid);
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
        this.ASIVersion = ASIHMISyncMasterControlAbstractBaseService.copyString(string);
        this.ASIVersion_valid = bl;
        List list = this.baseService.getNotifications(8);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncMasterControlReply aSIHMISyncMasterControlReply = (ASIHMISyncMasterControlReply)iterator.next();
            try {
                aSIHMISyncMasterControlReply.updateASIVersion(string, bl);
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
        List list = this.baseService.getNotifications(14);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncMasterControlReply aSIHMISyncMasterControlReply = (ASIHMISyncMasterControlReply)iterator.next();
            try {
                aSIHMISyncMasterControlReply.updateRequestIDs(sArray, bl);
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
        List list = this.baseService.getNotifications(13);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncMasterControlReply aSIHMISyncMasterControlReply = (ASIHMISyncMasterControlReply)iterator.next();
            try {
                aSIHMISyncMasterControlReply.updateReplyIDs(sArray, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateHUVersion(String string) throws MethodException {
        this.updateHUVersion(string, true);
    }

    public void updateHUVersion(String string, boolean bl) throws MethodException {
        this.HUVersion = ASIHMISyncMasterControlAbstractBaseService.copyString(string);
        this.HUVersion_valid = bl;
        List list = this.baseService.getNotifications(10);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncMasterControlReply aSIHMISyncMasterControlReply = (ASIHMISyncMasterControlReply)iterator.next();
            try {
                aSIHMISyncMasterControlReply.updateHUVersion(string, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateVIN(String string) throws MethodException {
        this.updateVIN(string, true);
    }

    public void updateVIN(String string, boolean bl) throws MethodException {
        this.VIN = ASIHMISyncMasterControlAbstractBaseService.copyString(string);
        this.VIN_valid = bl;
        List list = this.baseService.getNotifications(12);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncMasterControlReply aSIHMISyncMasterControlReply = (ASIHMISyncMasterControlReply)iterator.next();
            try {
                aSIHMISyncMasterControlReply.updateVIN(string, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateLockState(int n) throws MethodException {
        this.updateLockState(n, true);
    }

    public void updateLockState(int n, boolean bl) throws MethodException {
        this.LockState = n;
        this.LockState_valid = bl;
        List list = this.baseService.getNotifications(11);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncMasterControlReply aSIHMISyncMasterControlReply = (ASIHMISyncMasterControlReply)iterator.next();
            try {
                aSIHMISyncMasterControlReply.updateLockState(n, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    public void updateBlockState(int n) throws MethodException {
        this.updateBlockState(n, true);
    }

    public void updateBlockState(int n, boolean bl) throws MethodException {
        this.BlockState = n;
        this.BlockState_valid = bl;
        List list = this.baseService.getNotifications(9);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncMasterControlReply aSIHMISyncMasterControlReply = (ASIHMISyncMasterControlReply)iterator.next();
            try {
                aSIHMISyncMasterControlReply.updateBlockState(n, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    private static class AttributesBitMapProvider
    implements IAttributeBitMapProvider {
        private final HashMap map = new HashMap();

        public AttributesBitMapProvider() {
            this.map.put(new Long(8L), new Integer(0));
            this.map.put(new Long(14L), new Integer(1));
            this.map.put(new Long(13L), new Integer(2));
            this.map.put(new Long(10L), new Integer(3));
            this.map.put(new Long(12L), new Integer(4));
            this.map.put(new Long(11L), new Integer(5));
            this.map.put(new Long(9L), new Integer(6));
        }

        public int getAttributeBit(long l) {
            Integer n = (Integer)this.map.get(new Long(l));
            return n;
        }

        public int getAttributesCount() {
            return 7;
        }
    }
}

