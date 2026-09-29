/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.eal.async;

import de.audi.atip.hmi.event.ATIPEvent;
import de.audi.atip.hmi.event.ATIPEventListener;
import de.audi.atip.util.Util;
import de.audi.tghu.hmi.evo.IHMIServiceEvo;
import de.esolutions.graphics.eal.utility.IImageStorageListener;
import de.esolutions.graphics.eal.utility.IImageStorageListener$enType_t;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.eal.ITextureCache;
import de.esolutions.hmi.widgets.audi.base.eal.TextureDescription;
import de.esolutions.hmi.widgets.audi.base.eal.TextureDescriptionAsyncImage;
import de.esolutions.hmi.widgets.audi.base.eal.async.AsyncImageListener$UpdateEvent;
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
    @Override
    public void process(IImageStorageListener$enType_t iImageStorageListener$enType_t, long l) {
        AsyncImageListener asyncImageListener = this;
        synchronized (asyncImageListener) {
            int n = -1;
            if (!IImageStorageListener$enType_t.TYPE_ERROR.equals(iImageStorageListener$enType_t)) {
                n = 2;
            }
            AbstractWidget.framework.getHMIService().getEventDispatcher().postEvent(new AsyncImageListener$UpdateEvent(this, this, (int)l, n));
        }
    }

    private boolean isTextureCached(TextureDescription textureDescription) {
        ITextureCache iTextureCache = textureDescription.getCache();
        return iTextureCache == null ? false : iTextureCache.isTextureCached(textureDescription);
    }

    @Override
    public void processEvent(ATIPEvent aTIPEvent) {
        if (aTIPEvent instanceof AsyncImageListener$UpdateEvent) {
            AsyncImageListener$UpdateEvent asyncImageListener$UpdateEvent = (AsyncImageListener$UpdateEvent)aTIPEvent;
            if (AsyncImageListener$UpdateEvent.access$000(asyncImageListener$UpdateEvent) == -1) {
                TextureDescriptionAsyncImage textureDescriptionAsyncImage = (TextureDescriptionAsyncImage)this.tdMap.get(Util.createInteger(asyncImageListener$UpdateEvent.getID()));
                if (!this.isTextureCached(textureDescriptionAsyncImage)) {
                    textureDescriptionAsyncImage.updateRessources(asyncImageListener$UpdateEvent);
                }
                this.tdMap.remove(Util.createInteger(asyncImageListener$UpdateEvent.getID()));
            } else if (this.tdMap.size() > 0) {
                IHMIServiceEvo iHMIServiceEvo;
                Collection collection = this.tdMap.values();
                Iterator iterator = collection.iterator();
                TextureDescriptionAsyncImage textureDescriptionAsyncImage = null;
                while (iterator.hasNext()) {
                    textureDescriptionAsyncImage = (TextureDescriptionAsyncImage)iterator.next();
                    if (this.isTextureCached(textureDescriptionAsyncImage)) continue;
                    textureDescriptionAsyncImage.updateRessources(asyncImageListener$UpdateEvent);
                }
                this.tdMap.clear();
                if (aTIPEvent.isConsumed() && (iHMIServiceEvo = AbstractWidget.hmiService) != null) {
                    iHMIServiceEvo.getRootWindow(this.terminalID).repaint();
                }
            } else {
                AbstractWidget.logImageAsync.log(1078071040, "AsyncImageListener#processEvent No image could be loaded successfully.");
            }
        }
    }
}

