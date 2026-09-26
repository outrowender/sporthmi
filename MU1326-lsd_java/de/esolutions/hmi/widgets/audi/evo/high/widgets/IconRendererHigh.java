/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.audi.atip.hmi.HMIImageConstantsSystem;
import de.audi.atip.hmi.model.HMIResourceLocator;
import de.eso.IconExtractor.IconExtractor$Bitmap;
import de.esolutions.hmi.widgets.audi.base.Alignment;
import de.esolutions.hmi.widgets.audi.base.HMIImage;
import de.esolutions.hmi.widgets.audi.base.RedrawContext;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.eal.HMITerminalEAL;
import de.esolutions.hmi.widgets.audi.base.eal.ITextureCache;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3D;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3DImage;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedTexture;
import de.esolutions.hmi.widgets.audi.base.eal.TextureDescription;
import de.esolutions.hmi.widgets.audi.base.eal.TextureDescriptionGuideImage;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.high.RedrawContextHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.AbstractRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.IconLoader;
import de.esolutions.hmi.widgets.audi.evo.widgets.IconController;
import de.esolutions.hmi.widgets.audi.evo.widgets.IconRenderer;
import java.nio.ByteBuffer;

public class IconRendererHigh
extends AbstractRendererHigh
implements IconRenderer,
Alignment {
    private static final int ID_DYNAMIC_PROVIDER_LOGO;
    private static final int DEFAULT_WAIT_FOR_ICON_TIME;
    protected boolean disableAllFormsOfCaching = false;
    protected final IconController controller;
    protected IWrappedNode3DImage node;
    protected IWrappedNode3D groupNode;
    private int unscaledWidth;
    private int unscaledHeight;
    protected static final boolean USE_IMAGE_SIZECHECK;
    protected TextureDescription cachedSizeDisplayData;
    protected TextureDescription displayData;
    private float scaleY = 1.0f;
    private float scaleX = 1.0f;
    private int scaleMode = 0;
    private int autoscaleModification = 0;
    protected float rotationZ = 0.0f;
    protected float rotationY = 0.0f;
    protected int alignmentVert = 4;
    protected int alignmentHoriz = 1;
    private Object cachedContent;

    public IconRendererHigh(IconController iconController) {
        this.controller = iconController;
    }

    @Override
    public void setScaleFactor(float f2, float f3) {
        if (this.scaleX == f2 && this.scaleY == f3) {
            return;
        }
        this.scaleX = f2;
        this.scaleY = f3;
        this.dirty = true;
    }

    @Override
    public void setRotationZ(float f2) {
        float f3 = (float)Math.toRadians(f2);
        if (this.rotationZ == f3) {
            return;
        }
        this.rotationZ = (float)Math.toRadians(f2);
        this.dirty = true;
    }

    @Override
    public void setRotationY(float f2) {
        float f3 = (float)Math.toRadians(f2);
        if (this.rotationY == f3) {
            return;
        }
        this.rotationY = (float)Math.toRadians(f2);
        this.dirty = true;
    }

    @Override
    public void render(RedrawContext redrawContext) {
        if (!this.dirty) {
            return;
        }
        if (!this.controller.shouldRender()) {
            if (this.node != null) {
                this.node.setVisible(false);
            }
            return;
        }
        RedrawContextHigh redrawContextHigh = (RedrawContextHigh)redrawContext;
        TextureDescription textureDescription = this.calculateDisplayData(this.controller.getContent());
        if (!this.processDisplayData(redrawContextHigh, textureDescription)) {
            return;
        }
        if (this.node == null) {
            return;
        }
        this.getEALManager().moveToParent(this.groupNode, redrawContextHigh.parentNode);
        this.applyProperties(redrawContextHigh);
    }

    protected boolean processDisplayData(RedrawContextHigh redrawContextHigh, TextureDescription textureDescription) {
        if (!this.equalDisplayData(this.displayData, textureDescription)) {
            this.displayData = textureDescription;
            return this.updateNodeContent(redrawContextHigh);
        }
        return true;
    }

    protected boolean updateNodeContent(RedrawContextHigh redrawContextHigh) {
        if (this.node == null) {
            this.renderNode(redrawContextHigh);
            return true;
        }
        if (!this.isDisplayDataInitialized()) {
            this.node.setVisible(false);
            return false;
        }
        IWrappedTexture iWrappedTexture = this.displayData.getTexture(this);
        if (iWrappedTexture == null) {
            logChannel3DEngine.log(10000, "IconRendererHigh#render: Could not create texture from description '%1'", (Object)this.displayData);
            this.node.setVisible(false);
            return false;
        }
        this.node.setTexture(iWrappedTexture, true, this);
        iWrappedTexture.releaseTexture(false, this);
        int n = (int)this.node.getUnscaledWidth();
        int n2 = (int)this.node.getUnscaledHeight();
        this.setUnscaledSize(this.displayData, n, n2);
        return true;
    }

    protected TextureDescription calculateDisplayData(Object object) {
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
                return this.getTextureDescription(0, this.useEalAtlas());
            }
            if (hMIResourceLocator.getResourceURI() == null && this.controller.getDefaultImageMode() == 1) {
                return this.getTextureDescription(hMIResourceLocator.getResourceID(), this.useEalAtlas());
            }
            if (hMIResourceLocator.getResourceID() == 0x11000060) {
                Integer n = new Integer(hMIResourceLocator.getResourceID());
                logChannel3DEngine.log(-2137614336, "IconRendererHigh#updateContent Load icon with resourceID=%1 ", (long)hMIResourceLocator.getResourceID());
                return this.loadIcon(hMIResourceLocator.getResourceID(), n, this.getCache());
            }
            logChannel3DEngine.log(-2137614336, "IconRendererHigh#updateContent Load icon with resourceURI=%1 ", (Object)hMIResourceLocator.getResourceURI());
            HMIImage hMIImage = this.getEALManager().getHMIImage(hMIResourceLocator, this.controller.getInitContext().getScreenID(), this.controller.isCacheImageInLRU());
            if (hMIImage == null) {
                return null;
            }
            return eALManager.createTextureDescription(hMIImage, this.getCache(eALManager, 1), this.useEalAtlas(), true);
        }
        if (object instanceof String) {
            HMIImage hMIImage = new HMIImage((String)object, 6);
            return eALManager.createTextureDescription(hMIImage, this.getCache(eALManager, 1), this.useEalAtlas(), true);
        }
        if (object instanceof Integer) {
            return this.handleIntegerContent((Integer)object, eALManager);
        }
        logChannel.log(-1601830656, "Unknown content: %1", object);
        return null;
    }

    private TextureDescription loadIcon(int n, Integer n2, ITextureCache iTextureCache) {
        try {
            if (this.getTerminal().getFramework().isTarget()) {
                IconExtractor$Bitmap iconExtractor$Bitmap = IconLoader.getImage(n, 50);
                return this.createTextureDescription(n, n2, iconExtractor$Bitmap, iTextureCache);
            }
        }
        catch (Exception exception) {
            logChannel3DEngine.log(10000, "IconRendererHigh#updateContent Caught exception when getting bitmap with id = %2 from model %3. %1", (Object)exception.getMessage(), (long)n);
        }
        return null;
    }

    private ITextureCache getCache() {
        if (this.getTerminal() instanceof HMITerminalEAL) {
            EALManager eALManager = ((HMITerminalEAL)((Object)this.getTerminal())).getEALManager();
            return eALManager.getIconLabelCache();
        }
        return null;
    }

    private TextureDescription createTextureDescription(int n, Integer n2, IconExtractor$Bitmap iconExtractor$Bitmap, ITextureCache iTextureCache) {
        if (iconExtractor$Bitmap != null) {
            ByteBuffer byteBuffer = iconExtractor$Bitmap.getData();
            if (byteBuffer != null) {
                int n3 = iconExtractor$Bitmap.getWidth();
                int n4 = iconExtractor$Bitmap.getHeight();
                HMITerminalEAL hMITerminalEAL = (HMITerminalEAL)((Object)this.getTerminal());
                if (hMITerminalEAL != null) {
                    return hMITerminalEAL.getEALManager().createTextureDescription(byteBuffer, 6, n3, n4, iTextureCache, n2);
                }
            } else {
                logChannel3DEngine.log(10000, "IconRendererHigh#createTextureDescription Bitmap with id %1 is null.", (long)n);
            }
        } else {
            logChannel3DEngine.log(10000, "IconRendererHigh#createTextureDescription Bitmap with id %1 has no ByteBuffer.", (long)n);
        }
        return null;
    }

    protected TextureDescription handleIntegerContent(Integer n, EALManager eALManager) {
        int n2 = n;
        return this.getTextureDescription(n2, this.useEalAtlas());
    }

    protected ITextureCache getCache(EALManager eALManager, int n) {
        if (this.controller.isImageCacheActivated()) {
            return eALManager.getCache(n);
        }
        return null;
    }

    protected boolean equalDisplayData(Object object, Object object2) {
        if (object == null) {
            return object2 == null;
        }
        return object.equals(object2);
    }

    protected void renderNode(RedrawContextHigh redrawContextHigh) {
        if (!this.isDisplayDataInitialized()) {
            this.setUnscaledSize(null, 0, 0);
            return;
        }
        int n = redrawContextHigh.getCalculatedNodeIndex(this.controller.getDepth());
        if (this.groupNode == null) {
            this.groupNode = this.getEALManager().createNode3D(redrawContextHigh.parentNode, EALManager.createNodeName("icon_group", this), 0.0f, 0.0f, n);
        } else {
            this.groupNode.setNodeIndex(n);
        }
        this.node = this.getEALManager().createImage3D(this.groupNode, EALManager.createNodeName("icon", this), this.displayData, 0, true, (Object)this);
        if (this.node == null) {
            this.setUnscaledSize(this.displayData, 0, 0);
        } else {
            int n2 = (int)this.node.getUnscaledWidth();
            int n3 = (int)this.node.getUnscaledHeight();
            this.setUnscaledSize(this.displayData, n2, n3);
        }
    }

    protected boolean isDisplayDataInitialized() {
        return this.displayData != null;
    }

    protected boolean useEalAtlas() {
        return this.scaleX == 1.0f && this.scaleY == 1.0f && !this.disableAllFormsOfCaching;
    }

    protected void destroyNode() {
        EALManager eALManager = this.getEALManager();
        if (eALManager != null) {
            eALManager.destroy(this.node);
        }
        this.displayData = null;
        this.node = null;
    }

    protected void destroyGroupNode() {
        EALManager eALManager = this.getEALManager();
        if (eALManager != null) {
            eALManager.destroy(this.groupNode);
        }
        this.groupNode = null;
    }

    protected void calculatePosition(float[] fArray, RedrawContextHigh redrawContextHigh) {
        float f2 = 0.0f;
        if (this.displayData instanceof TextureDescriptionGuideImage) {
            TextureDescriptionGuideImage textureDescriptionGuideImage = (TextureDescriptionGuideImage)this.displayData;
            int n = textureDescriptionGuideImage.getIndex();
            if (!this.getEALManager().isLTR() && n == HMIImageConstantsSystem.carOPSbackground_Standalone_icon) {
                f2 = 41025;
            }
        }
        float f3 = IconRendererHigh.calculateNodeOffset(this.controller.getWidth(), this.node.getUnscaledWidth() * fArray[0], this.alignmentHoriz);
        float f4 = IconRendererHigh.calculateNodeOffset(this.controller.getHeight(), this.node.getUnscaledHeight() * fArray[1], this.alignmentVert);
        this.node.setPosition((float)this.controller.getX() + this.x0 + f3 + f2, (float)this.controller.getY() + this.y0 + f4, 0.0f);
    }

    protected void applyProperties(RedrawContextHigh redrawContextHigh) {
        if (!this.node.isValid()) {
            logChannel3DEngine.log(10000, "IconRendererHigh#applyProperties: icon node is invalid with bitmap: %1", (Object)this.displayData);
            return;
        }
        float[] fArray = IconRendererHigh.calculateScaling(this.controller.getWidth(), this.controller.getHeight(), this.node.getUnscaledWidth(), this.node.getUnscaledHeight(), this.scaleMode, this.scaleX, this.scaleY, this.autoscaleModification);
        this.calculatePosition(fArray, redrawContextHigh);
        this.node.setScale(fArray[0], fArray[1], 1.0f);
        this.node.setRotationZ(this.rotationZ);
        this.node.setRotationY(this.rotationY);
        this.node.setOpacity(this.controller.getRenderOpacity());
        this.node.setVisible(true);
        this.node.setHorizontalFlip(this.controller.isHorizontalFlip());
        if (this.controller.getProcessStateChange() == 2) {
            int n = redrawContextHigh.getColor(this.getColorIndex());
            int n2 = EALManager.createColorCode(n);
            this.node.setModulateColor(n2);
        }
    }

    private int getColorIndex() {
        int n = this.controller.getCurrentVisState();
        if (this.controller.isLockingActive()) {
            n = 2;
        }
        return n;
    }

    float[] calculateScaling(int n, int n2, float f2, float f3) {
        return IconRendererHigh.calculateScaling(n, n2, f2, f3, this.scaleMode, this.scaleX, this.scaleY, this.autoscaleModification);
    }

    public static float[] calculateScaling(int n, int n2, float f2, float f3, int n3, float f4, float f5, int n4) {
        if (n3 == 0) {
            return new float[]{f4, f5};
        }
        float f6 = IconRendererHigh.calculateAxisAutoscale(n, f2, n4);
        float f7 = IconRendererHigh.calculateAxisAutoscale(n2, f3, n4);
        switch (n3) {
            case 3: {
                return new float[]{f6, f7};
            }
            case 1: {
                float f8 = Math.min(f6, f7);
                return new float[]{f8, f8};
            }
            case 2: {
                float f9 = Math.max(f6, f7);
                return new float[]{f9, f9};
            }
        }
        logChannel.log(-1601830656, "IconRendererHigh#calculateScaling: unknown scaleMode: %1", (long)n3);
        return new float[]{f6, f7};
    }

    public static float calculateAxisAutoscale(int n, float f2, int n2) {
        float f3 = (float)Math.max(n, 1) / f2;
        switch (n2) {
            case 0: {
                return f3;
            }
            case 2: {
                return Math.min(f3, 1.0f);
            }
            case 1: {
                return Math.max(f3, 1.0f);
            }
        }
        logChannel.log(-1601830656, "IconRendererHigh#calculateAxisAutoscale: unknown autoscaleModification: %1", (long)n2);
        return f3;
    }

    static float calculateNodeOffset(int n, float f2, int n2) {
        switch (n2) {
            case 1: 
            case 4: 
            case 8: 
            case 9: {
                return 0.0f;
            }
            case 3: 
            case 6: {
                return (float)n - f2;
            }
            case 2: 
            case 5: 
            case 7: {
                return (int)((float)n - f2) / 2;
            }
        }
        logChannel.log(-1601830656, "IconRendererHigh#calculateNodeOffset: unknown alignment: %1", (long)n2);
        return 0.0f;
    }

    @Override
    public void disconnect() {
        this.destroyNode();
        this.destroyGroupNode();
        this.resetCachedSize();
        super.disconnect();
    }

    @Override
    public AbstractWidgetController getAbstractController() {
        return this.controller;
    }

    public IWrappedNode3DImage getNode() {
        return this.node;
    }

    public float getScaleX() {
        return this.scaleX;
    }

    public float getScaleY() {
        return this.scaleY;
    }

    private void updateCachedSize() {
        Object object = this.controller.getContent();
        if (object instanceof HMIResourceLocator && object.equals(this.cachedContent)) {
            return;
        }
        TextureDescription textureDescription = this.calculateDisplayData(object);
        if (this.equalDisplayData(this.cachedSizeDisplayData, textureDescription)) {
            return;
        }
        if (textureDescription == null) {
            logChannel.log(-1601830656, "IconRendererHigh#updateCachedSize: No image found for content: %1", object);
            this.setUnscaledSize(null, 0, 0);
            return;
        }
        this.cachedContent = object;
        this.loadDimensions(textureDescription, object);
    }

    protected void loadDimensions(TextureDescription textureDescription, Object object) {
        IWrappedTexture iWrappedTexture = textureDescription.getTexture(this);
        if (iWrappedTexture == null) {
            logChannel.log(-1601830656, "IconRendererHigh#updateCachedSize: Texture could not be loaded for content: %1", object);
            this.setUnscaledSize(textureDescription, 0, 0);
            return;
        }
        int n = iWrappedTexture.getWidth();
        int n2 = iWrappedTexture.getHeight();
        iWrappedTexture.releaseTexture(false, this);
        this.setUnscaledSize(textureDescription, n, n2);
    }

    protected void setUnscaledSize(TextureDescription textureDescription, int n, int n2) {
        this.unscaledWidth = n;
        this.unscaledHeight = n2;
        this.cachedSizeDisplayData = textureDescription;
    }

    private void resetCachedSize() {
        this.unscaledWidth = 0;
        this.unscaledHeight = 0;
        this.cachedSizeDisplayData = null;
        this.cachedContent = null;
    }

    @Override
    public int getPreferredWidth() {
        this.updateCachedSize();
        return (int)((float)this.unscaledWidth * this.scaleX + 63);
    }

    @Override
    public int getPreferredHeight() {
        this.updateCachedSize();
        return (int)((float)this.unscaledHeight * this.scaleY + 63);
    }

    @Override
    public String getDiagnosisText() {
        if (this.displayData == null) {
            return null;
        }
        Object object = this.displayData.getCacheKey();
        return String.valueOf(object);
    }

    @Override
    public void setAlignment(int n, int n2) {
        this.alignmentVert = n2;
        this.alignmentHoriz = n;
    }

    public int getAlignmentHoriz() {
        return this.alignmentHoriz;
    }

    public int getAlignmentVert() {
        return this.alignmentVert;
    }

    public int getScaleMode() {
        return this.scaleMode;
    }

    @Override
    public void setScaleMode(int n) {
        this.scaleMode = n;
    }

    public int getAutoscaleModification() {
        return this.autoscaleModification;
    }

    @Override
    public void setAutoscaleModification(int n) {
        this.autoscaleModification = n;
    }
}

