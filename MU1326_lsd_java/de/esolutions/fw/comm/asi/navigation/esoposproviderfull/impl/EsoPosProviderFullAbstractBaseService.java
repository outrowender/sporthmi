/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.esoposproviderfull.impl;

import de.esolutions.fw.comm.asi.navigation.esoposproviderfull.EsoPosProviderFullReply;
import de.esolutions.fw.comm.asi.navigation.esoposproviderfull.EsoPosProviderFullS;
import de.esolutions.fw.comm.attributes.AttributesBaseService;
import de.esolutions.fw.comm.attributes.IAttributeBitMapProvider;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.method.MethodException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public abstract class EsoPosProviderFullAbstractBaseService
implements EsoPosProviderFullS {
    private static final CallContext context = CallContext.getContext("ABSTRACTBASESERVICE.asi.navigation.esoposproviderfull.EsoPosProviderFull");
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

    public EsoPosProviderFullAbstractBaseService() {
        AttributesBitMapProvider attributesBitMapProvider = new AttributesBitMapProvider();
        this.baseService = new AttributesBaseService("EsoPosProviderFull", attributesBitMapProvider);
    }

    public synchronized void setNotification(long l, EsoPosProviderFullReply esoPosProviderFullReply) {
        this.baseService.setNotification(l, (Object)esoPosProviderFullReply);
        this.sendAttributeUpdate(l, esoPosProviderFullReply);
    }

    public synchronized void setNotification(EsoPosProviderFullReply esoPosProviderFullReply) {
        this.baseService.setNotification(esoPosProviderFullReply);
        this.sendAttributeUpdate(esoPosProviderFullReply);
    }

    public synchronized void setNotification(long[] lArray, EsoPosProviderFullReply esoPosProviderFullReply) {
        this.baseService.setNotification(lArray, (Object)esoPosProviderFullReply);
        this.sendAttributeUpdate(lArray, esoPosProviderFullReply);
    }

    public synchronized void clearNotification(long l, EsoPosProviderFullReply esoPosProviderFullReply) {
        this.baseService.clearNotification(l, (Object)esoPosProviderFullReply);
    }

    public synchronized void clearNotification(EsoPosProviderFullReply esoPosProviderFullReply) {
        this.baseService.clearNotification(esoPosProviderFullReply);
    }

    public synchronized void clearNotification(long[] lArray, EsoPosProviderFullReply esoPosProviderFullReply) {
        this.baseService.clearNotification(lArray, (Object)esoPosProviderFullReply);
    }

    private void sendAttributeUpdate(EsoPosProviderFullReply esoPosProviderFullReply) {
        try {
            esoPosProviderFullReply.updateASIVersion(this.ASIVersion, this.ASIVersion_valid);
        }
        catch (MethodException methodException) {
            // empty catch block
        }
    }

    private void sendAttributeUpdate(long[] lArray, EsoPosProviderFullReply esoPosProviderFullReply) {
        for (int i2 = 0; i2 < lArray.length; ++i2) {
            this.sendAttributeUpdate(lArray[i2], esoPosProviderFullReply);
        }
    }

    private void sendAttributeUpdate(long l, EsoPosProviderFullReply esoPosProviderFullReply) {
        try {
            if (l == 19L) {
                esoPosProviderFullReply.updateASIVersion(this.ASIVersion, this.ASIVersion_valid);
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
        this.ASIVersion = EsoPosProviderFullAbstractBaseService.copyString(string);
        this.ASIVersion_valid = bl;
        List list = this.baseService.getNotifications(19);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            EsoPosProviderFullReply esoPosProviderFullReply = (EsoPosProviderFullReply)iterator.next();
            try {
                esoPosProviderFullReply.updateASIVersion(string, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    private static class AttributesBitMapProvider
    implements IAttributeBitMapProvider {
        private final HashMap map = new HashMap();

        public AttributesBitMapProvider() {
            this.map.put(new Long(19L), new Integer(0));
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

