/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.instance.impl;

import de.esolutions.fw.comm.asi.hmisync.instance.ASIHMISyncInstanceReply;
import de.esolutions.fw.comm.asi.hmisync.instance.ASIHMISyncInstanceS;
import de.esolutions.fw.comm.attributes.AttributesBaseService;
import de.esolutions.fw.comm.attributes.IAttributeBitMapProvider;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.method.MethodException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public abstract class ASIHMISyncInstanceAbstractBaseService
implements ASIHMISyncInstanceS {
    private static final CallContext context = CallContext.getContext("ABSTRACTBASESERVICE.asi.hmisync.instance.ASIHMISyncInstance");
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

    public ASIHMISyncInstanceAbstractBaseService() {
        AttributesBitMapProvider attributesBitMapProvider = new AttributesBitMapProvider();
        this.baseService = new AttributesBaseService("ASIHMISyncInstance", attributesBitMapProvider);
    }

    public synchronized void setNotification(long l, ASIHMISyncInstanceReply aSIHMISyncInstanceReply) {
        this.baseService.setNotification(l, (Object)aSIHMISyncInstanceReply);
        this.sendAttributeUpdate(l, aSIHMISyncInstanceReply);
    }

    public synchronized void setNotification(ASIHMISyncInstanceReply aSIHMISyncInstanceReply) {
        this.baseService.setNotification(aSIHMISyncInstanceReply);
        this.sendAttributeUpdate(aSIHMISyncInstanceReply);
    }

    public synchronized void setNotification(long[] lArray, ASIHMISyncInstanceReply aSIHMISyncInstanceReply) {
        this.baseService.setNotification(lArray, (Object)aSIHMISyncInstanceReply);
        this.sendAttributeUpdate(lArray, aSIHMISyncInstanceReply);
    }

    public synchronized void clearNotification(long l, ASIHMISyncInstanceReply aSIHMISyncInstanceReply) {
        this.baseService.clearNotification(l, (Object)aSIHMISyncInstanceReply);
    }

    public synchronized void clearNotification(ASIHMISyncInstanceReply aSIHMISyncInstanceReply) {
        this.baseService.clearNotification(aSIHMISyncInstanceReply);
    }

    public synchronized void clearNotification(long[] lArray, ASIHMISyncInstanceReply aSIHMISyncInstanceReply) {
        this.baseService.clearNotification(lArray, (Object)aSIHMISyncInstanceReply);
    }

    private void sendAttributeUpdate(ASIHMISyncInstanceReply aSIHMISyncInstanceReply) {
        try {
            aSIHMISyncInstanceReply.updateASIVersion(this.ASIVersion, this.ASIVersion_valid);
            aSIHMISyncInstanceReply.updateRequestIDs(this.RequestIDs, this.RequestIDs_valid);
            aSIHMISyncInstanceReply.updateReplyIDs(this.ReplyIDs, this.ReplyIDs_valid);
        }
        catch (MethodException methodException) {
            // empty catch block
        }
    }

    private void sendAttributeUpdate(long[] lArray, ASIHMISyncInstanceReply aSIHMISyncInstanceReply) {
        for (int i2 = 0; i2 < lArray.length; ++i2) {
            this.sendAttributeUpdate(lArray[i2], aSIHMISyncInstanceReply);
        }
    }

    private void sendAttributeUpdate(long l, ASIHMISyncInstanceReply aSIHMISyncInstanceReply) {
        try {
            if (l == 8L) {
                aSIHMISyncInstanceReply.updateASIVersion(this.ASIVersion, this.ASIVersion_valid);
            } else if (l == 10L) {
                aSIHMISyncInstanceReply.updateRequestIDs(this.RequestIDs, this.RequestIDs_valid);
            } else if (l == 9L) {
                aSIHMISyncInstanceReply.updateReplyIDs(this.ReplyIDs, this.ReplyIDs_valid);
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
        this.ASIVersion = ASIHMISyncInstanceAbstractBaseService.copyString(string);
        this.ASIVersion_valid = bl;
        List list = this.baseService.getNotifications(8);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncInstanceReply aSIHMISyncInstanceReply = (ASIHMISyncInstanceReply)iterator.next();
            try {
                aSIHMISyncInstanceReply.updateASIVersion(string, bl);
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
        List list = this.baseService.getNotifications(10);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncInstanceReply aSIHMISyncInstanceReply = (ASIHMISyncInstanceReply)iterator.next();
            try {
                aSIHMISyncInstanceReply.updateRequestIDs(sArray, bl);
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
        List list = this.baseService.getNotifications(9);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ASIHMISyncInstanceReply aSIHMISyncInstanceReply = (ASIHMISyncInstanceReply)iterator.next();
            try {
                aSIHMISyncInstanceReply.updateReplyIDs(sArray, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    private static class AttributesBitMapProvider
    implements IAttributeBitMapProvider {
        private final HashMap map = new HashMap();

        public AttributesBitMapProvider() {
            this.map.put(new Long(8L), new Integer(0));
            this.map.put(new Long(10L), new Integer(1));
            this.map.put(new Long(9L), new Integer(2));
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

