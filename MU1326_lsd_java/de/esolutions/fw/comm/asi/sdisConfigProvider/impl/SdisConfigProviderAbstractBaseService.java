/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.sdisConfigProvider.impl;

import de.esolutions.fw.comm.asi.sdisConfigProvider.SdisConfigProviderReply;
import de.esolutions.fw.comm.asi.sdisConfigProvider.SdisConfigProviderS;
import de.esolutions.fw.comm.attributes.AttributesBaseService;
import de.esolutions.fw.comm.attributes.IAttributeBitMapProvider;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.method.MethodException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public abstract class SdisConfigProviderAbstractBaseService
implements SdisConfigProviderS {
    private static final CallContext context = CallContext.getContext("ABSTRACTBASESERVICE.asi.sdisConfigProvider.SdisConfigProvider");
    private static final int attributesCount = 1;
    private String ASIVersion;
    private boolean ASIVersion_valid = false;
    private AttributesBaseService baseService;

    public static String copyString(String string) {
        if (string != null) {
            return new String(string);
        }
        return null;
    }

    public SdisConfigProviderAbstractBaseService() {
        AttributesBitMapProvider attributesBitMapProvider = new AttributesBitMapProvider();
        this.baseService = new AttributesBaseService("SdisConfigProvider", attributesBitMapProvider);
    }

    public synchronized void setNotification(long l, SdisConfigProviderReply sdisConfigProviderReply) {
        this.baseService.setNotification(l, (Object)sdisConfigProviderReply);
        this.sendAttributeUpdate(l, sdisConfigProviderReply);
    }

    public synchronized void setNotification(SdisConfigProviderReply sdisConfigProviderReply) {
        this.baseService.setNotification(sdisConfigProviderReply);
        this.sendAttributeUpdate(sdisConfigProviderReply);
    }

    public synchronized void setNotification(long[] lArray, SdisConfigProviderReply sdisConfigProviderReply) {
        this.baseService.setNotification(lArray, (Object)sdisConfigProviderReply);
        this.sendAttributeUpdate(lArray, sdisConfigProviderReply);
    }

    public synchronized void clearNotification(long l, SdisConfigProviderReply sdisConfigProviderReply) {
        this.baseService.clearNotification(l, (Object)sdisConfigProviderReply);
    }

    public synchronized void clearNotification(SdisConfigProviderReply sdisConfigProviderReply) {
        this.baseService.clearNotification(sdisConfigProviderReply);
    }

    public synchronized void clearNotification(long[] lArray, SdisConfigProviderReply sdisConfigProviderReply) {
        this.baseService.clearNotification(lArray, (Object)sdisConfigProviderReply);
    }

    private void sendAttributeUpdate(SdisConfigProviderReply sdisConfigProviderReply) {
        try {
            sdisConfigProviderReply.updateASIVersion(this.ASIVersion, this.ASIVersion_valid);
        }
        catch (MethodException methodException) {
            // empty catch block
        }
    }

    private void sendAttributeUpdate(long[] lArray, SdisConfigProviderReply sdisConfigProviderReply) {
        for (int i2 = 0; i2 < lArray.length; ++i2) {
            this.sendAttributeUpdate(lArray[i2], sdisConfigProviderReply);
        }
    }

    private void sendAttributeUpdate(long l, SdisConfigProviderReply sdisConfigProviderReply) {
        try {
            if (l == 6L) {
                sdisConfigProviderReply.updateASIVersion(this.ASIVersion, this.ASIVersion_valid);
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
        this.ASIVersion = SdisConfigProviderAbstractBaseService.copyString(string);
        this.ASIVersion_valid = bl;
        List list = this.baseService.getNotifications(6);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            SdisConfigProviderReply sdisConfigProviderReply = (SdisConfigProviderReply)iterator.next();
            try {
                sdisConfigProviderReply.updateASIVersion(string, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    private static class AttributesBitMapProvider
    implements IAttributeBitMapProvider {
        private final HashMap map = new HashMap();

        public AttributesBitMapProvider() {
            this.map.put(new Long(6L), new Integer(0));
        }

        public int getAttributeBit(long l) {
            Integer n = (Integer)this.map.get(new Long(l));
            return n;
        }

        public int getAttributesCount() {
            return 1;
        }
    }
}

