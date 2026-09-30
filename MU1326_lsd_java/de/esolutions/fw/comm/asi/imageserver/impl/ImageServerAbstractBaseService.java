/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.imageserver.impl;

import de.esolutions.fw.comm.asi.imageserver.ImageServerReply;
import de.esolutions.fw.comm.asi.imageserver.ImageServerS;
import de.esolutions.fw.comm.attributes.AttributesBaseService;
import de.esolutions.fw.comm.attributes.IAttributeBitMapProvider;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.method.MethodException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public abstract class ImageServerAbstractBaseService
implements ImageServerS {
    private static final CallContext context = CallContext.getContext("ABSTRACTBASESERVICE.asi.imageserver.ImageServer");
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

    public ImageServerAbstractBaseService() {
        AttributesBitMapProvider attributesBitMapProvider = new AttributesBitMapProvider();
        this.baseService = new AttributesBaseService("ImageServer", attributesBitMapProvider);
    }

    public synchronized void setNotification(long l, ImageServerReply imageServerReply) {
        this.baseService.setNotification(l, (Object)imageServerReply);
        this.sendAttributeUpdate(l, imageServerReply);
    }

    public synchronized void setNotification(ImageServerReply imageServerReply) {
        this.baseService.setNotification(imageServerReply);
        this.sendAttributeUpdate(imageServerReply);
    }

    public synchronized void setNotification(long[] lArray, ImageServerReply imageServerReply) {
        this.baseService.setNotification(lArray, (Object)imageServerReply);
        this.sendAttributeUpdate(lArray, imageServerReply);
    }

    public synchronized void clearNotification(long l, ImageServerReply imageServerReply) {
        this.baseService.clearNotification(l, (Object)imageServerReply);
    }

    public synchronized void clearNotification(ImageServerReply imageServerReply) {
        this.baseService.clearNotification(imageServerReply);
    }

    public synchronized void clearNotification(long[] lArray, ImageServerReply imageServerReply) {
        this.baseService.clearNotification(lArray, (Object)imageServerReply);
    }

    private void sendAttributeUpdate(ImageServerReply imageServerReply) {
        try {
            imageServerReply.updateASIVersion(this.ASIVersion, this.ASIVersion_valid);
        }
        catch (MethodException methodException) {
            // empty catch block
        }
    }

    private void sendAttributeUpdate(long[] lArray, ImageServerReply imageServerReply) {
        for (int i2 = 0; i2 < lArray.length; ++i2) {
            this.sendAttributeUpdate(lArray[i2], imageServerReply);
        }
    }

    private void sendAttributeUpdate(long l, ImageServerReply imageServerReply) {
        try {
            if (l == 23L) {
                imageServerReply.updateASIVersion(this.ASIVersion, this.ASIVersion_valid);
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
        this.ASIVersion = ImageServerAbstractBaseService.copyString(string);
        this.ASIVersion_valid = bl;
        List list = this.baseService.getNotifications(23);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ImageServerReply imageServerReply = (ImageServerReply)iterator.next();
            try {
                imageServerReply.updateASIVersion(string, bl);
            }
            catch (MethodException methodException) {}
        }
    }

    private static class AttributesBitMapProvider
    implements IAttributeBitMapProvider {
        private final HashMap map = new HashMap();

        public AttributesBitMapProvider() {
            this.map.put(new Long(23L), new Integer(0));
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

