/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.impl;

import de.esolutions.fw.comm.asi.hmisync.car.ASIHMISyncCarGenericReply;
import de.esolutions.fw.comm.asi.hmisync.car.ASIHMISyncCarGenericS;
import de.esolutions.fw.comm.attributes.AttributesBaseService;
import de.esolutions.fw.comm.attributes.IAttributeBitMapProvider;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.method.MethodException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public abstract class ASIHMISyncCarGenericAbstractBaseService
implements ASIHMISyncCarGenericS {
    private static final CallContext context = CallContext.getContext("ABSTRACTBASESERVICE.asi.hmisync.car.ASIHMISyncCarGeneric");
    private static final int attributesCount = 3;
    private String ASIVersion;
    private boolean ASIVersion_valid = false;
    private short[] RequestIDs;
    private boolean RequestIDs_valid = false;
    private short[] ReplyIDs;
    private boolean ReplyIDs_valid = false;
    private AttributesBaseService baseService;

    public static String copyString(String string) {
        if (string != null) {
            return new String(string);
        }
        return null;
    }

    public ASIHMISyncCarGenericAbstractBaseService() {
        AttributesBitMapProvider attributesBitMapProvider = new AttributesBitMapProvider();
        this.baseService = new AttributesBaseService("ASIHMISyncCarGeneric", attributesBitMapProvider);
    }

    public synchronized void setNotification(long l, ASIHMISyncCarGenericReply aSIHMISyncCarGenericReply) {
        this.baseService.setNotification(l, (Object)aSIHMISyncCarGenericReply);
        this.sendAttributeUpdate(l, aSIHMISyncCarGenericReply);
    }

    public synchronized void setNotification(ASIHMISyncCarGenericReply aSIHMISyncCarGenericReply) {
        this.baseService.setNotification(aSIHMISyncCarGenericReply);
        this.sendAttributeUpdate(aSIHMISyncCarGenericReply);
    }

    public synchronized void setNotification(long[] lArray, ASIHMISyncCarGenericReply aSIHMISyncCarGenericReply) {
        this.baseService.setNotification(lArray, (Object)aSIHMISyncCarGenericReply);
        this.sendAttributeUpdate(lArray, aSIHMISyncCarGenericReply);
    }

    public synchronized void clearNotification(long l, ASIHMISyncCarGenericReply aSIHMISyncCarGenericReply) {
        this.baseService.clearNotification(l, (Object)aSIHMISyncCarGenericReply);
    }

    public synchronized void clearNotification(ASIHMISyncCarGenericReply aSIHMISyncCarGenericReply) {
        this.baseService.clearNotification(aSIHMISyncCarGenericReply);
    }

    public synchronized void clearNotification(long[] lArray, ASIHMISyncCarGenericReply aSIHMISyncCarGenericReply) {
        this.baseService.clearNotification(lArray, (Object)aSIHMISyncCarGenericReply);
    }

    private void sendAttributeUpdate(ASIHMISyncCarGenericReply aSIHMISyncCarGenericReply) {
        try {
            aSIHMISyncCarGenericReply.updateASIVersion(this.ASIVersion, this.ASIVersion_valid);
            aSIHMISyncCarGenericReply.updateRequestIDs(this.RequestIDs, this.RequestIDs_valid);
            aSIHMISyncCarGenericReply.updateReplyIDs(this.ReplyIDs, this.ReplyIDs_valid);
        }
        catch (MethodException methodException) {
            // empty catch block
        }
    }

    private void sendAttributeUpdate(long[] lArray, ASIHMISyncCarGenericReply aSIHMISyncCarGenericReply) {
        for (int i2 = 0; i2 < lArray.length; ++i2) {
            this.sendAttributeUpdate(lArray[i2], aSIHMISyncCarGenericReply);
        }
    }

    private void sendAttributeUpdate(long l, ASIHMISyncCarGenericReply aSIHMISyncCarGenericReply) {
        try {
            if (l == 6L) {
                aSIHMISyncCarGenericReply.updateASIVersion(this.ASIVersion, this.ASIVersion_valid);
            } else if (l == 8L) {
                aSIHMISyncCarGenericReply.updateRequestIDs(this.RequestIDs, this.RequestIDs_valid);
            } else if (l == 7L) {
                aSIHMISyncCarGenericReply.updateReplyIDs(this.ReplyIDs, this.ReplyIDs_valid);
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
        this.ASIVersion = ASIHMISyncCarGenericAbstractBaseService.copyString(string);
        this.ASIVersion_valid = bl;
        List list = this.baseService.getNotifications(6);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarGenericReply aSIHMISyncCarGenericReply = (ASIHMISyncCarGenericReply)iterator.next();
            try {
                aSIHMISyncCarGenericReply.updateASIVersion(string, bl);
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
        List list = this.baseService.getNotifications(8);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarGenericReply aSIHMISyncCarGenericReply = (ASIHMISyncCarGenericReply)iterator.next();
            try {
                aSIHMISyncCarGenericReply.updateRequestIDs(sArray, bl);
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
        List list = this.baseService.getNotifications(7);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncCarGenericReply aSIHMISyncCarGenericReply = (ASIHMISyncCarGenericReply)iterator.next();
            try {
                aSIHMISyncCarGenericReply.updateReplyIDs(sArray, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    private static class AttributesBitMapProvider
    implements IAttributeBitMapProvider {
        private final HashMap map = new HashMap();

        public AttributesBitMapProvider() {
            this.map.put(new Long(6L), new Integer(0));
            this.map.put(new Long(8L), new Integer(1));
            this.map.put(new Long(7L), new Integer(2));
        }

        public int getAttributeBit(long l) {
            Integer n = (Integer)this.map.get(new Long(l));
            return n;
        }

        public int getAttributesCount() {
            return 3;
        }
    }
}

