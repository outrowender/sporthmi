/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.audi.atip.hmi.model.HMIResourceLocator;
import de.audi.atip.hmi.model.ResourceLocatorListCell;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.hmi.widgets.audi.base.HMIImage;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.eal.ITextureCache;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedTexture;
import de.esolutions.hmi.widgets.audi.base.eal.TextureDescription;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.high.RedrawContextHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.AbstractKanziTemplateRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.CoverStackController;
import de.esolutions.hmi.widgets.audi.evo.widgets.CoverStackRenderer;

public class CoverStackRendererKanziHigh
extends AbstractKanziTemplateRenderer
implements CoverStackRenderer {
    private static final int CACHE_SIZE;
    private static final String TEMPLATE_NODE_PATH;
    private CoverStackController controller;
    private static final boolean USE_IMAGE_SIZECHECK;
    private IWrappedTexture[] coverItems = new IWrappedTexture[6];
    private String[] coverPropertyNames = new String[]{"cs_coverPos0", "cs_coverPos1", "cs_coverPos2", "cs_coverPos3", "cs_coverPos4"};
    private ITextureCache coverTextureCache;
    private Buffer stringBuilder = new Buffer();
    private TextureDescription defaultTextureDescription;
    private boolean usePreviousTexture = false;

    public CoverStackRendererKanziHigh(CoverStackController coverStackController) {
        this.controller = coverStackController;
        for (int i2 = 0; i2 < this.coverItems.length; ++i2) {
            this.coverItems[i2] = null;
        }
    }

    @Override
    public void connect(InitializationContext initializationContext) {
        if (this.coverTextureCache == null) {
            this.coverTextureCache = this.getEALManager().createLRUCache(50, 100);
        }
        this.defaultTextureDescription = this.getDefaultTextureDescription();
        super.connect(initializationContext);
    }

    @Override
    protected String getTemplateNodePath() {
        return "Prefabs/coverStack";
    }

    @Override
    protected String getEALNodeName() {
        return "coverStack";
    }

    @Override
    public AbstractWidgetController getAbstractController() {
        return this.controller;
    }

    @Override
    protected void applyProperties(RedrawContextHigh redrawContextHigh) {
        int n = this.controller.getX();
        int n2 = this.controller.getY();
        this.node.setPosition(n, n2, 0.0f);
        this.node.setOpacity(this.controller.getRenderOpacity());
        if (!this.controller.shouldRender()) {
            return;
        }
        float f2 = this.controller.getNowPlayingAnimationProgress();
        this.setProperty("cs_nowPlaying", f2);
        if (this.controller.isOnlyUpdateOfNowPlayingProgressNeeded()) {
            this.controller.nowPlayingProgessUpdateDone(f2);
            return;
        }
        for (int i2 = 0; i2 < 5; ++i2) {
            int n3 = i2;
            if (i2 == 0) {
                if (this.shouldSetCrossfadeTexture()) {
                    ++n3;
                }
            } else {
                ++n3;
            }
            this.setupTexture(i2, n3);
            if (i2 == 0 && !this.controller.isCrossFadingActive()) {
                int n4 = n3 == 0 ? 1 : 0;
                this.setupTexture(i2, n4);
            }
            float f3 = this.controller.getTopMoveProgress();
            float f4 = (float)(i2 + 1) - f3;
            this.setProperty(this.coverPropertyNames[i2], f4);
        }
    }

    private void setupTexture(int n, int n2) {
        boolean bl;
        this.usePreviousTexture = false;
        TextureDescription textureDescription = this.getCoverTextureDescription(n);
        IWrappedTexture iWrappedTexture = null;
        if (textureDescription == null) {
            logChannelCoverStack.log(-2137614336, "CoverStackRendererKanziHigh#applyProperties:Texture description is null");
            iWrappedTexture = null;
        } else if (!this.controller.isUpdateState()) {
            logChannelCoverStack.log(-2137614336, "CoverStackRendererKanziHigh#applyProperties:Texture is not updated because of modelStauts waiting");
            iWrappedTexture = null;
            this.usePreviousTexture = true;
        } else {
            iWrappedTexture = textureDescription.getTexture(this);
            if (this.coverItems[n2] != null) {
                this.usePreviousTexture = true;
                if (iWrappedTexture != null) {
                    this.usePreviousTexture = false;
                    this.coverItems[n2].releaseTexture(true, this);
                    this.coverItems[n2] = iWrappedTexture;
                }
            } else {
                this.coverItems[n2] = iWrappedTexture;
            }
        }
        boolean bl2 = bl = n2 == 1;
        if (iWrappedTexture != null) {
            this.setTextureProperties(n, bl, iWrappedTexture);
        } else {
            IWrappedTexture iWrappedTexture2 = this.getDefaultTexture();
            if (iWrappedTexture2 == null) {
                logChannelCoverStack.log(10000, "CoverStackRendererKanziHigh#applyProperties: default texture can not be loaded. bitmapPath: %1", (Object)this.defaultTextureDescription);
            } else if (!this.usePreviousTexture) {
                if (this.coverItems[n2] != null) {
                    this.coverItems[n2].releaseTexture(true, this);
                }
                this.coverItems[n2] = iWrappedTexture2;
                this.setTextureProperties(n, bl, iWrappedTexture2);
            }
        }
    }

    private boolean shouldSetCrossfadeTexture() {
        return this.controller.getCrossFadeState() == 1;
    }

    private void releaseCoverItems() {
        for (int i2 = 0; i2 < this.coverItems.length; ++i2) {
            IWrappedTexture iWrappedTexture = this.coverItems[i2];
            if (iWrappedTexture != null) {
                iWrappedTexture.releaseTexture(true, this);
            }
            this.coverItems[i2] = null;
        }
    }

    private void setTextureProperties(int n, boolean bl, IWrappedTexture iWrappedTexture) {
        float f2;
        if (iWrappedTexture == null || !this.controller.isUpdateState()) {
            return;
        }
        this.setCrossFadingTexture(n, bl, iWrappedTexture);
        long l = iWrappedTexture.getWidth();
        long l2 = iWrappedTexture.getHeight();
        if (l == l2) {
            this.setTextureRatioProperty(n, 1.0f, 1.0f);
        } else if (l > l2) {
            f2 = (float)l2 / (float)l;
            this.setTextureRatioProperty(n, 1.0f, f2);
        } else {
            f2 = (float)l / (float)l2;
            this.setTextureRatioProperty(n, f2, 1.0f);
        }
        boolean bl2 = !this.controller.isExpandable() || this.controller.getNowPlayingAnimationProgress() == 1.0f;
        boolean bl3 = bl2 && n > 0;
        boolean bl4 = n >= this.controller.getCoverBitmaps().size();
        boolean bl5 = bl3 || bl4;
        boolean bl6 = !bl5;
        this.setProperty(this.concat("cs_coverVisible", n), (float)bl6);
    }

    private void setCrossFadingTexture(int n, boolean bl, IWrappedTexture iWrappedTexture) {
        if (this.controller.isCrossFadingActive()) {
            this.setProperty("cs_coverCrossfade", this.controller.getCrossFadingProgress());
            if (logChannelCoverStack.isDebug()) {
                logChannelCoverStack.log(-2137614336, "CoverStackRendererKanziHigh#setCrossFadingTexture crossFadingProgess: %1", (Object)String.valueOf(this.controller.getCrossFadingProgress()));
            }
        } else if (!(this.controller.getCrossFadingProgress() < 1.0f) || !(this.controller.getCrossFadingProgress() > 0.0f)) {
            this.setProperty("cs_coverCrossfade", this.controller.getCrossFadeState());
            if (logChannelCoverStack.isDebug()) {
                logChannelCoverStack.log(-2137614336, "CoverStackRendererKanziHigh#setCrossFadingTexture reset crossFadingProgess: %1 crossFadingState %2", (Object)String.valueOf(this.controller.getCrossFadingProgress()), (Object)String.valueOf(this.controller.getCrossFadeState()));
            }
        }
        String string = bl ? this.concat("cs_texture", n, "b") : this.concat("cs_texture", n);
        this.setProperty(string, iWrappedTexture.getTexture());
        if (logChannelCoverStack.isDebug()) {
            logChannelCoverStack.log(-2137614336, "CoverStackRendererKanziHigh#setCrossFadingTexture set Texture index: %1, crossfade: %3, state: %2", (long)n, (long)this.controller.getCrossFadeState(), bl);
            logChannelCoverStack.log(-2137614336, "CoverStackRendererKanziHigh#setCrossFadingTexture texture: %1 ", (Object)iWrappedTexture.getTexture());
        }
    }

    private void setTextureRatioProperty(int n, float f2, float f3) {
        if (this.controller.getCrossFadeState() == 0) {
            this.setProperty(this.concat("cs_coverAspect", n, "_X"), f2);
            this.setProperty(this.concat("cs_coverAspect", n, "_Y"), f3);
            if (logChannelCoverStack.isDebug()) {
                logChannelCoverStack.log(-2137614336, "CoverStackRendererKanziHigh#setTextureRatioProperty set ratio index: %1, state: %2 , %3, %4", (Object)String.valueOf(n), (Object)String.valueOf(this.controller.getCrossFadeState()));
            }
        } else if (n == 0) {
            this.setProperty(this.concat("cs_coverAspect", n, "b_X"), f2);
            this.setProperty(this.concat("cs_coverAspect", n, "b_Y"), f3);
            if (logChannelCoverStack.isDebug()) {
                logChannelCoverStack.log(-2137614336, "CoverStackRendererKanziHigh#setTextureRatioProperty set ratio index: %1, state: %2 , %3, %4", (Object)String.valueOf(n), (Object)String.valueOf(this.controller.getCrossFadeState()));
            }
        }
        if (!this.controller.isCrossFadingActive()) {
            if (this.controller.getCrossFadeState() == 1) {
                this.setProperty(this.concat("cs_coverAspect", n, "_X"), f2);
                this.setProperty(this.concat("cs_coverAspect", n, "_Y"), f3);
                logChannelCoverStack.log(-2137614336, "CoverStackRendererKanziHigh#setCrossFadingTexture reset textureA Ratio state: %1", (long)this.controller.getCrossFadeState());
            } else if (n == 0) {
                this.setProperty(this.concat("cs_coverAspect", n, "b_X"), f2);
                this.setProperty(this.concat("cs_coverAspect", n, "b_Y"), f3);
                logChannelCoverStack.log(-2137614336, "CoverStackRendererKanziHigh#setCrossFadingTexture reset textureB Ratio state: %1", (long)this.controller.getCrossFadeState());
            }
        }
    }

    private TextureDescription getCoverTextureDescription(int n) {
        TextureDescription textureDescription;
        if (n >= this.controller.getCoverBitmaps().size()) {
            return null;
        }
        TextureDescription textureDescription2 = this.getCoverTextureDescriptionFromModel(n);
        if (textureDescription2 != null && textureDescription2.isTextureCached()) {
            return textureDescription2;
        }
        TextureDescription textureDescription3 = textureDescription2;
        if (textureDescription3 == null) {
            textureDescription = this.getDefaultCoverTextureDescriptionFromModel(n);
            if (textureDescription != null && textureDescription.isTextureCached()) {
                return textureDescription;
            }
            textureDescription3 = textureDescription;
        }
        if (textureDescription3 == null || !this.controller.shouldLoadCoversBitmaps()) {
            textureDescription = this.defaultTextureDescription;
            if (textureDescription != null && textureDescription.isTextureCached()) {
                return textureDescription;
            }
            textureDescription3 = textureDescription;
        }
        return textureDescription3;
    }

    @Override
    public void disconnect() {
        super.disconnect();
        this.releaseCoverItems();
        this.defaultTextureDescription = null;
        this.getEALManager().destroy(this.coverTextureCache);
        this.coverTextureCache = null;
    }

    private TextureDescription getCoverTextureDescriptionFromModel(int n) {
        Object object = null;
        if (this.controller.getCoverBitmaps() != null && n < this.controller.getCoverBitmaps().size() && n >= 0) {
            object = this.controller.getCoverBitmaps().get(n);
        }
        if (object instanceof ResourceLocatorListCell && ((ResourceLocatorListCell)object).getResourceLocator().getResourceURI() != null) {
            return this.getCoverBitmapFromResourceLocator(((ResourceLocatorListCell)object).getResourceLocator());
        }
        if (object instanceof HMIResourceLocator && ((HMIResourceLocator)object).containsResourceURI()) {
            return this.getCoverBitmapFromResourceLocator((HMIResourceLocator)object);
        }
        if (object instanceof HMIResourceLocator && ((HMIResourceLocator)object).getResourceURI() == null && ((HMIResourceLocator)object).containsResourceID()) {
            return this.getDefaultCoverTextureDescriptionFromModel(((HMIResourceLocator)object).getResourceID());
        }
        if (object instanceof String) {
            return this.createTextureDescription(new HMIImage((String)object, 6), true);
        }
        if (object instanceof Integer) {
            return this.getTextureDescription((Integer)object, false, true);
        }
        if (object == null) {
            return null;
        }
        logChannelCoverStack.log(-1601830656, "CoverStackRendererKanziHigh#getCoverBitmap: unknown bitmap model: %1 ", object);
        return null;
    }

    private TextureDescription createTextureDescription(HMIImage hMIImage, boolean bl) {
        if (hMIImage == null) {
            return null;
        }
        return this.getEALManager().createTextureDescription(hMIImage, this.coverTextureCache, false, bl);
    }

    private TextureDescription getDefaultCoverTextureDescriptionFromModel(int n) {
        Object object = null;
        if (this.controller.getCoverBitmaps() != null && n < this.controller.getCoverBitmaps().size() && n >= 0) {
            object = this.controller.getCoverBitmaps().get(n);
        } else {
            logChannelCoverStack.log(10000, "CoverStackRendererKanziHigh#getDefaultCoverTextureDescriptionFromModel: illegal index: %1", (long)n);
        }
        if (object instanceof ResourceLocatorListCell) {
            int n2 = ((ResourceLocatorListCell)object).getResourceLocator().getResourceID();
            return this.getDefaultTextureDescription(n2);
        }
        if (object instanceof HMIResourceLocator) {
            int n3 = ((HMIResourceLocator)object).getResourceID();
            return this.getDefaultTextureDescription(n3);
        }
        return null;
    }

    private TextureDescription getCoverBitmapFromResourceLocator(HMIResourceLocator hMIResourceLocator) {
        if (hMIResourceLocator.containsResourceID() || hMIResourceLocator.containsResourceURI()) {
            if (hMIResourceLocator.getStatus() == 1) {
                logChannelCoverStack.log(10000, "CoverStackRendererKanziHigh#getCoverBitmapFromResourceLocator: ModelStatus of ResourceLocator %1 is waiting. Previous Cover will be displayed", (Object)hMIResourceLocator);
                this.usePreviousTexture = true;
                return null;
            }
            if (hMIResourceLocator.getResourceURI() == null && this.controller.getDefaultImageMode() == 1) {
                return this.getTextureDescription(hMIResourceLocator.getResourceID(), false, true);
            }
            return this.createTextureDescription(this.getEALManager().getHMIImage(hMIResourceLocator, this.controller.getInitContext().getScreenID(), false), true);
        }
        return null;
    }

    private TextureDescription getDefaultTextureDescription(int n) {
        int[] nArray = this.controller.getBitmapIndices();
        if (nArray == null || nArray.length == 0) {
            return null;
        }
        int n2 = nArray.length == 1 ? 0 : Math.abs(n) % (nArray.length - 1) + 1;
        if (this.controller.hasBitmap(n2)) {
            return this.getTextureDescription(n2, false);
        }
        return null;
    }

    private IWrappedTexture getDefaultTexture() {
        TextureDescription textureDescription = this.getDefaultTextureDescription();
        if (textureDescription == null) {
            return null;
        }
        return textureDescription.getTexture(this);
    }

    private TextureDescription getDefaultTextureDescription() {
        if (this.defaultTextureDescription != null) {
            return this.defaultTextureDescription;
        }
        int n = this.controller.getPrimaryBitmapsDefaultIndex();
        if (this.controller.hasBitmap(n)) {
            return this.getTextureDescription(n, false);
        }
        if (logChannelCoverStack.isDebug()) {
            logChannelCoverStack.log(-2137614336, "CoverStackRendererKanziHigh#getDefaultTextureDescription unable to set the defaultTextureDescription with index %1", (long)n);
        }
        return null;
    }

    private String concat(String string, int n) {
        this.stringBuilder.clear();
        this.stringBuilder.append(string).append(n);
        return this.stringBuilder.toString();
    }

    private String concat(String string, int n, String string2) {
        this.stringBuilder.clear();
        this.stringBuilder.append(string).append(n).append(string2);
        return this.stringBuilder.toString();
    }

    @Override
    protected int getKzbConstant() {
        return 4;
    }
}

