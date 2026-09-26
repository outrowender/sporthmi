/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.interapp;

import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.interapp.MediaServiceImpl;
import de.audi.app.media.interapp.MediaSlotInfoImpl;
import de.audi.app.media.osgi.AbstractMediaServiceListenerTracker;
import de.audi.app.media.source.IActivationContext;
import de.audi.app.media.source.ISourceSlot;
import de.audi.atip.interapp.media.IMediaServiceListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

class MediaServiceImpl$1
extends AbstractMediaServiceListenerTracker {
    private final /* synthetic */ MediaServiceImpl this$0;

    MediaServiceImpl$1(MediaServiceImpl mediaServiceImpl, IMediaTerminal iMediaTerminal) {
        this.this$0 = mediaServiceImpl;
        super(iMediaTerminal);
    }

    @Override
    protected void mediaServiceListenerAdded(IMediaServiceListener iMediaServiceListener) {
        int n;
        Object object;
        this.logger.main().log(-2137614336, "[%1.mediaServiceListenerAdded] '%2'", (Object)"MediaServiceImpl", (Object)iMediaServiceListener);
        HashMap hashMap = new HashMap();
        for (int i2 = 0; i2 < 14; ++i2) {
            object = this.getTerminal().getSourceController().getSource(i2);
            if (object == null || object.getType() == 4) continue;
            n = MediaServiceImpl.getMediaSourceIDOfISourceID(object.getType());
            if (object.isAvailable()) {
                try {
                    iMediaServiceListener.sourceAvailable(n, object.isAvailable());
                }
                catch (Exception exception) {
                    this.logger.main().log(-1601830656, "[%1.mediaServiceListenerAdded] %2", (Object)"MediaServiceImpl", (Throwable)exception);
                }
            }
            if (object.isEmpty()) continue;
            LinkedList linkedList = new LinkedList();
            hashMap.put(new Integer(n), linkedList);
            Iterator iterator = object.getSlots().iterator();
            while (iterator.hasNext()) {
                ISourceSlot iSourceSlot = (ISourceSlot)iterator.next();
                if (!iSourceSlot.isLoaded()) continue;
                linkedList.add(new MediaSlotInfoImpl(iSourceSlot));
            }
        }
        try {
            iMediaServiceListener.sourceListChanged(hashMap);
            IActivationContext iActivationContext = this.getTerminal().getSourceController().getActivationContext();
            if (iActivationContext != null && (object = iActivationContext.getSlot()) != null) {
                n = object.getState() == 1 ? 1 : 0;
                iMediaServiceListener.updateActiveSource(new MediaSlotInfoImpl((ISourceSlot)object), n != 0);
            }
        }
        catch (Exception exception) {
            this.logger.main().log(-1601830656, "[%1.mediaServiceListenerAdded] %2", (Object)"MediaServiceImpl", (Throwable)exception);
        }
    }
}

