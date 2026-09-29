/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.audi.atip.hmi.HMIImageConstantsSystem;
import de.audi.atip.hmi.event.ATIPEvent;
import de.audi.atip.hmi.model.HMIResourceLocator;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.HMIImage;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedTexture;
import de.esolutions.hmi.widgets.audi.base.eal.TextureDescription;
import de.esolutions.hmi.widgets.audi.base.eal.async.ITexDescrAsyncStates;
import de.esolutions.hmi.widgets.audi.base.eal.async.IUpdatableReceiver;
import de.esolutions.hmi.widgets.audi.base.eal.async.TextureDescriptionManager;
import de.esolutions.hmi.widgets.audi.evo.high.RedrawContextHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.IconRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.widgets.IconController;

public class IconRendererHighAsync
extends IconRendererHigh
implements IUpdatableReceiver {
    protected boolean isTextureLoaded = false;
    protected int lastLoadingState = -3;

    public IconRendererHighAsync(IconController iconController) {
        super(iconController);
    }

    @Override
    protected void destroyNode() {
        if (this.displayData != null) {
            TextureDescriptionManager.getInstance().cancelRequest(this.displayData, this);
        }
        this.isTextureLoaded = false;
        this.lastLoadingState = -3;
        super.destroyNode();
    }

    @Override
    protected void loadDimensions(TextureDescription textureDescription, Object object) {
        int n;
        int n2;
        IWrappedTexture iWrappedTexture = textureDescription.getCachedTexture(this);
        if (iWrappedTexture != null) {
            n2 = iWrappedTexture.getWidth();
            n = iWrappedTexture.getHeight();
            iWrappedTexture.releaseTexture(false, this);
        } else {
            int[] nArray = textureDescription.getUnscaledDimension();
            n2 = nArray[0];
            n = nArray[1];
        }
        this.setUnscaledSize(textureDescription, n2, n);
    }

    @Override
    protected boolean processDisplayData(RedrawContextHigh redrawContextHigh, TextureDescription textureDescription) {
        if (textureDescription instanceof ITexDescrAsyncStates) {
            int n;
            boolean bl = false;
            if (!this.equalDisplayData(this.displayData, textureDescription)) {
                TextureDescriptionManager.getInstance().cancelRequest(this.displayData, this);
                this.displayData = textureDescription;
                IWrappedTexture iWrappedTexture = this.displayData.getTexture(this);
                if (iWrappedTexture != null) {
                    logImageAsync.log(-2137614336, "IconRendererHighAsync#processDisplayData given texture already loaded: %1", (Object)this.displayData);
                    iWrappedTexture.releaseTexture(false, this);
                } else {
                    logImageAsync.log(-2137614336, "IconRendererHighAsync#processDisplayData Texture has been requested: %1", (Object)this.displayData);
                }
                bl = true;
            }
            if (this.lastLoadingState != (n = ((ITexDescrAsyncStates)this.displayData).getLoadingState())) {
                this.lastLoadingState = n;
                this.isTextureLoaded = n == 2 || n == 3;
                bl = true;
            }
            if (bl) {
                return this.updateNodeContent(redrawContextHigh);
            }
            return this.isTextureLoaded;
        }
        this.isTextureLoaded = true;
        return super.processDisplayData(redrawContextHigh, textureDescription);
    }

    protected TextureDescription getTextureDescriptionAsync(int n, boolean bl) {
        return this.getTextureDescriptionAsync(n, bl, false);
    }

    protected TextureDescription getTextureDescriptionAsync(int n, boolean bl, boolean bl2) {
        EALManager eALManager = this.getEALManager();
        if (eALManager == null) {
            return null;
        }
        int n2 = this.getAbstractController().getBitmap(n);
        if (n2 >= 0 && AbstractWidget.hmiService != null) {
            return eALManager.createTextureDescriptionAsync(n2, bl, this.getInitContext().getScreenID());
        }
        return eALManager.createTextureDescriptionAsync(HMIImageConstantsSystem.empty_image, bl, this.getInitContext().getScreenID());
    }

    protected TextureDescription handleIntegerContent(Integer n, EALManager eALManager, boolean bl) {
        int n2 = n;
        return bl ? this.getTextureDescriptionAsync(n2, this.useEalAtlas()) : this.getTextureDescription(n2, this.useEalAtlas());
    }

    @Override
    protected TextureDescription calculateDisplayData(Object object) {
        return this.calculateDisplayData(object, true);
    }

    protected TextureDescription calculateDisplayData(Object object, boolean bl) {
        if (!this.controller.isConnected()) {
            return null;
        }
        EALManager eALManager = this.getEALManager();
        if (object == null) {
            return null;
        }
        if (object instanceof HMIResourceLocator) {
            HMIResourceLocator hMIResourceLocator = (HMIResourceLocator)object;
            if (hMIResourceLocator.getStatus() == 1) {
                return bl ? this.getTextureDescriptionAsync(0, this.useEalAtlas()) : this.getTextureDescription(0, this.useEalAtlas());
            }
            if (hMIResourceLocator.getResourceURI() == null && this.controller.getDefaultImageMode() == 1) {
                return bl ? this.getTextureDescriptionAsync(hMIResourceLocator.getResourceID(), this.useEalAtlas()) : this.getTextureDescription(hMIResourceLocator.getResourceID(), this.useEalAtlas());
            }
            HMIImage hMIImage = this.getEALManager().getHMIImage(hMIResourceLocator, this.controller.getInitContext().getScreenID(), this.controller.isCacheImageInLRU());
            if (hMIImage == null) {
                return null;
            }
            return bl ? eALManager.createTextureDescriptionAsync(hMIImage, this.getCache(eALManager, 3), this.useEalAtlas(), true) : eALManager.createTextureDescription(hMIImage, this.getCache(eALManager, 1), this.useEalAtlas(), true);
        }
        if (object instanceof String) {
            HMIImage hMIImage = new HMIImage((String)object, 6);
            return bl ? eALManager.createTextureDescriptionAsync(hMIImage, this.getCache(eALManager, 3), this.useEalAtlas(), true) : eALManager.createTextureDescription(hMIImage, this.getCache(eALManager, 1), this.useEalAtlas(), true);
        }
        if (object instanceof Integer) {
            return this.handleIntegerContent((Integer)object, eALManager, bl);
        }
        AbstractWidget.logImageAsync.log(-1601830656, "Unknown content: %1", object);
        return null;
    }

    @Override
    protected boolean isDisplayDataInitialized() {
        return this.displayData != null && this.isTextureLoaded;
    }

    @Override
    protected boolean updateNodeContent(RedrawContextHigh redrawContextHigh) {
        if (!this.controller.isImageCacheActivated() && this.displayData instanceof ITexDescrAsyncStates && ((ITexDescrAsyncStates)this.displayData).getLoadingState() == -1) {
            ((ITexDescrAsyncStates)this.displayData).resetLoadingState();
        }
        return super.updateNodeContent(redrawContextHigh);
    }

    @Override
    public void resourceLoadedCallback(int n, Object object, ATIPEvent aTIPEvent) {
        if (n == 1) {
            this.controller.setCompositesDirty(true);
            aTIPEvent.consume();
        }
    }
}

