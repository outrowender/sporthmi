/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.eal;

import de.audi.atip.hmi.event.ATIPEvent;
import de.audi.atip.util.Util;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.graphics.eal.FlagImage;
import de.esolutions.graphics.eal.FlagTexture;
import de.esolutions.graphics.eal.api.IImage;
import de.esolutions.graphics.eal.api.IManager;
import de.esolutions.graphics.eal.api.ITexture;
import de.esolutions.graphics.eal.utility.CImageStorage;
import de.esolutions.hmi.widgets.audi.base.HMIImage;
import de.esolutions.hmi.widgets.audi.base.eal.AbstractTextureDescription;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.eal.ITextureCache;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedTexture;
import de.esolutions.hmi.widgets.audi.base.eal.WrappedTexture;
import de.esolutions.hmi.widgets.audi.base.eal.async.AsyncImageListener;
import de.esolutions.hmi.widgets.audi.base.eal.async.ITexDescrAsyncStates;
import de.esolutions.hmi.widgets.audi.base.eal.async.IUpdatableReceiver;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TextureDescriptionAsyncImage
extends AbstractTextureDescription
implements ITexDescrAsyncStates {
    protected int actualState = 0;
    protected final HMIImage hmiImage;
    protected boolean useEalAtlas = false;
    protected boolean useSizeCheck = false;
    protected Integer guideIndex = null;
    protected AsyncImageListener listener;
    protected CImageStorage imageStorage;
    protected IImage iimage = null;
    protected IWrappedTexture wrappedTexture = null;
    protected HashSet receivers = new HashSet(3);

    public TextureDescriptionAsyncImage(EALManager eALManager, HMIImage hMIImage) {
        this(eALManager, eALManager.getCache(3), hMIImage);
    }

    public TextureDescriptionAsyncImage(EALManager eALManager, HMIImage hMIImage, boolean bl) {
        this(eALManager, eALManager.getCache(3), hMIImage, false, bl);
    }

    public TextureDescriptionAsyncImage(EALManager eALManager, ITextureCache iTextureCache, HMIImage hMIImage) {
        this(eALManager, iTextureCache, hMIImage, false);
    }

    public TextureDescriptionAsyncImage(EALManager eALManager, int n, boolean bl, int n2) {
        this(eALManager, eALManager.getCache(0), eALManager.getHMIImage(n, n2), bl);
        this.guideIndex = Util.createInteger(n);
    }

    public TextureDescriptionAsyncImage(EALManager eALManager, ITextureCache iTextureCache, HMIImage hMIImage, boolean bl) {
        this(eALManager, iTextureCache, hMIImage, bl, true);
    }

    public TextureDescriptionAsyncImage(EALManager eALManager, ITextureCache iTextureCache, HMIImage hMIImage, boolean bl, boolean bl2) {
        super(eALManager, iTextureCache);
        this.hmiImage = hMIImage;
        this.useEalAtlas = bl;
        this.useSizeCheck = bl2;
    }

    public void abortLoading() {
        if (this.actualState == 1) {
            this.receivers.clear();
            this.abortEALLoading();
        } else {
            this.handleUnusedIImage();
        }
    }

    protected void abortEALLoading() {
        if (this.imageStorage != null && !this.imageStorage.remove(this.hmiImage.hashCode())) {
            logImageAsync.log(10000000, "TextureDescriptionAsyncImage#abortEALLoading abort was too late. Image will be cached if possible.");
        } else {
            this.resetLoadingState();
        }
    }

    private void callbackReceivers(ATIPEvent aTIPEvent) {
        this.handleUnusedIImage();
        if (this.receivers != null && !this.receivers.isEmpty()) {
            Iterator iterator = this.receivers.iterator();
            IUpdatableReceiver iUpdatableReceiver = null;
            logImageAsync.log(10000000, "TextureDescriptionAsyncImage#callbackReceivers notify listeners - %1", (Object)this);
            while ((iUpdatableReceiver = iterator.hasNext() ? (IUpdatableReceiver)iterator.next() : null) != null) {
                iUpdatableReceiver.resourceLoadedCallback(1, this, aTIPEvent);
            }
        }
    }

    protected boolean checkSize() {
        if (this.checkSize(this.hmiImage.getPath(), this.useSizeCheck)) {
            this.actualState = -1;
            if (this.imgDimensions[0] == 0 && this.imgDimensions[1] == 0) {
                logImageAsync.log(10000, "TextureDescriptionAsyncImage#checkSize the given image could not be found.");
            } else {
                logImageAsync.log(10000, "TextureDescriptionAsyncImage#checkSize error during scaling occured.");
            }
            return true;
        }
        return false;
    }

    public IWrappedTexture createTexture() {
        switch (this.actualState) {
            case -1: {
                this.receivers = null;
                this.freeImageStorage();
                return null;
            }
            case 0: {
                if (this.checkSize()) {
                    return null;
                }
                this.requestImage();
                this.actualState = 1;
                break;
            }
            case 2: {
                if (this.iimage == null) {
                    logImageAsync.log(10000, "TextureDescriptionAsyncImage#createTexture StateChange to ImageLoaded is invalid.");
                    return null;
                }
                this.wrappedTexture = this.convertImageToWrappedTexture();
                this.receivers = null;
                this.actualState = 3;
                break;
            }
        }
        return this.wrappedTexture;
    }

    protected IWrappedTexture convertImageToWrappedTexture() {
        FlagTexture flagTexture = EALManager.getTextureFlags(this.hmiImage.getFormat(), this.useEalAtlas);
        ITexture iTexture = this.ealManager.createTexture(this.iimage, flagTexture);
        this.freeImageStorage();
        if (iTexture == null) {
            logImageAsync.log(10000, "TextureDescriptionAsyncImage#convertImageToWrappedTexture could not create texture for %1", (Object)this);
            return null;
        }
        this.wrappedTexture = new WrappedTexture(iTexture, this, this.ealManager);
        logImageAsync.log(10000000, "TextureDescriptionAsyncImage#convertImageToWrappedTexture image converted to texture: %1", (Object)this);
        return this.wrappedTexture;
    }

    private void freeImageStorage() {
        this.listener = null;
        if (this.imageStorage != null) {
            this.imageStorage.destroy();
            this.iimage = null;
            this.imageStorage = null;
        }
    }

    public ITextureCache getCache() {
        if (this.actualState >= 2) {
            return super.getCache();
        }
        return null;
    }

    public Object getCacheKey() {
        if (this.guideIndex != null) {
            return this.guideIndex;
        }
        return this.getPath();
    }

    public int getDepthsInByte() {
        return HMIImage.getNumBytesPerPixel(this.hmiImage.getFormat());
    }

    public FlagImage getImageFlags() {
        return EALManager.getImageFlags(this.hmiImage.getFormat());
    }

    public Set getIUpdatableReceiver() {
        return Collections.unmodifiableSet(this.receivers);
    }

    public AsyncImageListener getListener() {
        return this.listener;
    }

    public int getLoadingState() {
        return this.actualState;
    }

    public String getPath() {
        return this.hmiImage.getPath();
    }

    public IWrappedTexture getTexture(Object object) {
        if (this.receivers != null && this.actualState < 2) {
            this.receivers.add(object);
        }
        return super.getTexture(object);
    }

    public int[] getUnscaledDimension() {
        return this.getUnscaledDimension(this.hmiImage.getPath());
    }

    protected void handleUnusedIImage() {
        if ((this.receivers == null || this.receivers.isEmpty()) && this.iimage != null) {
            ITextureCache iTextureCache = super.getCache();
            if (iTextureCache != null) {
                logImageAsync.log(10000000, "TextureDescriptionAsyncImage#handleUnusedIImage move unwanted texture to cache: %1", (Object)this);
                IWrappedTexture iWrappedTexture = this.ealManager.getTexture(this, this);
                iTextureCache.release(iWrappedTexture, this);
            } else {
                logImageAsync.log(10000000, "TextureDescriptionAsyncImage#handleUnusedIImage clear unwanted texture");
                this.resetLoadingState();
            }
        }
    }

    public boolean preventRTLFlip() {
        return this.hmiImage.getPreventRTLFlipFlag();
    }

    public boolean removeReceiver(Object object) {
        if (this.receivers == null) {
            logImageAsync.log(100000000, "TextureDescriptionAsnycImage#removeReceiver loading process already finished. TD: %1", (Object)this);
            return true;
        }
        if (!this.receivers.remove(object)) {
            logImageAsync.log(10000000, "TextureDescriptionAsnycImage#removeReceiver Object %1 is not listed (anymore) to be called back for texture %2", object, (Object)this);
            return false;
        }
        if (this.receivers.size() == 0) {
            this.abortLoading();
        }
        return true;
    }

    protected void requestImage() {
        int n = this.hmiImage.hashCode();
        FlagImage flagImage = EALManager.getImageFlags(this.hmiImage.getFormat());
        IManager iManager = EALManager.getManager();
        this.listener = new AsyncImageListener(this.ealManager.getTerminal().getTerminalID());
        this.imageStorage = new CImageStorage(iManager, this.listener);
        this.listener.addTextureDescription(this);
        if (this.useSizeCheck && this.imgDimensions[0] > 0 && this.imgDimensions[1] > 0) {
            this.imageStorage.add(n, this.hmiImage.getPath(), flagImage, Math.round((float)this.imgDimensions[0] * this.scaling), Math.round((float)this.imgDimensions[1] * this.scaling));
        } else {
            this.imageStorage.add(n, this.hmiImage.getPath(), flagImage);
        }
        logImageAsync.log(10000000, "TextureDescriptionAsyncImage#requestImage image requested: %1", (Object)this);
        this.imageStorage.flush();
    }

    public void resetLoadingState() {
        this.actualState = 0;
        if (this.wrappedTexture != null) {
            this.ealManager.destroy(this.wrappedTexture);
            this.wrappedTexture = null;
        }
        if (this.receivers != null) {
            this.receivers.clear();
        } else {
            this.receivers = new HashSet(3);
        }
        this.freeImageStorage();
    }

    protected IImage retrievedAsyncImage() {
        if (this.imageStorage != null) {
            return this.imageStorage.get(this.hmiImage.hashCode());
        }
        return null;
    }

    public void updateRessources(AsyncImageListener.UpdateEvent updateEvent) {
        int n = updateEvent.getState();
        switch (n) {
            case -1: {
                this.actualState = -1;
                this.freeImageStorage();
                logImageAsync.log(100000, "TextureDescriptionAsyncImage#updateRessources loading error occured for %1", (Object)this);
                break;
            }
            case 2: {
                this.iimage = this.retrievedAsyncImage();
                this.actualState = 2;
                logImageAsync.log(10000000, "TextureDescriptionAsyncImage#updateRessources image loaded: %1", (Object)this);
                break;
            }
            default: {
                logImageAsync.log(100000, "TextureDescriptionAsyncImage#updateRessources untreated loadingState: %1", (long)n);
            }
        }
        this.callbackReceivers(updateEvent);
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("TextureDescriptionAsyncImage [getCacheKey()=");
        buffer.append(this.getCacheKey());
        buffer.append("]\n");
        buffer.append("Loading State:");
        switch (this.actualState) {
            case -1: {
                buffer.append("LOADING_STATE_ERROR");
                break;
            }
            case 0: {
                buffer.append("LOADING_STATE_IDLE");
                break;
            }
            case 1: {
                buffer.append("LOADING_STATE_REQUESTED");
                break;
            }
            case 2: {
                buffer.append("LOADING_STATE_IMAGE_LOADED");
                break;
            }
            case 3: {
                buffer.append("LOADING_STATE_FINISHED");
                break;
            }
            default: {
                buffer.append("Unknown State");
            }
        }
        return buffer.toString();
    }
}

