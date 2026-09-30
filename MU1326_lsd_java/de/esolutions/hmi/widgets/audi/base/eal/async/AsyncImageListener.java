/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.eal.async;

import de.audi.atip.hmi.event.ATIPEvent;
import de.audi.atip.hmi.event.ATIPEventListener;
import de.audi.atip.util.Util;
import de.audi.tghu.hmi.evo.IHMIServiceEvo;
import de.esolutions.graphics.eal.utility.IImageStorageListener;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.eal.ITextureCache;
import de.esolutions.hmi.widgets.audi.base.eal.TextureDescription;
import de.esolutions.hmi.widgets.audi.base.eal.TextureDescriptionAsyncImage;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class AsyncImageListener
extends IImageStorageListener
implements ATIPEventListener {
    protected int terminalID = -1;
    protected HashMap tdMap = new HashMap(5);

    public AsyncImageListener(int n) {
        this.terminalID = n;
    }

    public AsyncImageListener(int n, TextureDescriptionAsyncImage textureDescriptionAsyncImage) {
        this(n);
        this.addTextureDescription(textureDescriptionAsyncImage);
    }

    public void addTextureDescription(TextureDescriptionAsyncImage textureDescriptionAsyncImage) {
        this.tdMap.put(Util.createInteger(textureDescriptionAsyncImage.hashCode()), textureDescriptionAsyncImage);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void process(IImageStorageListener.enType_t enType_t2, long l) {
        AsyncImageListener asyncImageListener = this;
        synchronized (asyncImageListener) {
            int n = -1;
            if (!IImageStorageListener.enType_t.TYPE_ERROR.equals(enType_t2)) {
                n = 2;
            }
            AbstractWidget.framework.getHMIService().getEventDispatcher().postEvent(new UpdateEvent(this, (int)l, n));
        }
    }

    private boolean isTextureCached(TextureDescription textureDescription) {
        ITextureCache iTextureCache = textureDescription.getCache();
        return iTextureCache == null ? false : iTextureCache.isTextureCached(textureDescription);
    }

    public void processEvent(ATIPEvent aTIPEvent) {
        if (aTIPEvent instanceof UpdateEvent) {
            UpdateEvent updateEvent = (UpdateEvent)aTIPEvent;
            if (updateEvent.state == -1) {
                TextureDescriptionAsyncImage textureDescriptionAsyncImage = (TextureDescriptionAsyncImage)this.tdMap.get(Util.createInteger(updateEvent.getID()));
                if (!this.isTextureCached(textureDescriptionAsyncImage)) {
                    textureDescriptionAsyncImage.updateRessources(updateEvent);
                }
                this.tdMap.remove(Util.createInteger(updateEvent.getID()));
            } else if (this.tdMap.size() > 0) {
                IHMIServiceEvo iHMIServiceEvo;
                Collection collection = this.tdMap.values();
                Iterator iterator = collection.iterator();
                TextureDescriptionAsyncImage textureDescriptionAsyncImage = null;
                while (iterator.hasNext()) {
                    textureDescriptionAsyncImage = (TextureDescriptionAsyncImage)iterator.next();
                    if (this.isTextureCached(textureDescriptionAsyncImage)) continue;
                    textureDescriptionAsyncImage.updateRessources(updateEvent);
                }
                this.tdMap.clear();
                if (aTIPEvent.isConsumed() && (iHMIServiceEvo = AbstractWidget.hmiService) != null) {
                    iHMIServiceEvo.getRootWindow(this.terminalID).repaint();
                }
            } else {
                AbstractWidget.logImageAsync.log(1000000, "AsyncImageListener#processEvent No image could be loaded successfully.");
            }
        }
    }

    public class UpdateEvent
    extends ATIPEvent {
        private int state;

        protected UpdateEvent(ATIPEventListener aTIPEventListener, int n, int n2) {
            super(aTIPEventListener, n);
            this.state = n2;
        }

        public int getState() {
            return this.state;
        }
    }
}

