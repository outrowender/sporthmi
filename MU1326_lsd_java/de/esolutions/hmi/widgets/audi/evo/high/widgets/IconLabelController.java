/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.audi.atip.hmi.event.ATIPEvent;
import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.model.HMIResourceLocator;
import de.audi.atip.hmi.model.IconCell;
import de.audi.atip.hmi.modelaccess.ChoiceModelGUI;
import de.audi.atip.log.LogChannel;
import de.audi.atip.util.Util;
import de.eso.IconExtractor.IconExtractor;
import de.eso.IconExtractor.IconExtractor$Bitmap;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.eal.HMITerminalEAL;
import de.esolutions.hmi.widgets.audi.base.eal.ITextureCache;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedTexture;
import de.esolutions.hmi.widgets.audi.base.eal.MixedListKZBMerger;
import de.esolutions.hmi.widgets.audi.base.eal.TextureDescription;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.ByteBufferBackedInputStream;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.IconLabelRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.IconLoader;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.IconLoader$IIconLoadedCallBack;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.IconLoader$IconLoadedEvent;
import de.esolutions.hmi.widgets.audi.evo.widgets.IEmptyableWidget;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.list.ListItemWidget;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class IconLabelController
extends AbstractWidgetController
implements ListItemWidget,
IEmptyableWidget,
IconLoader$IIconLoadedCallBack {
    private static final int DEFAULT_WAIT_FOR_ICON_TIME;
    private static Map textureRecorder;
    private IconLabelRendererHigh renderer;
    private IconCell iconCell;
    private HMIResourceLocator resourceLocator;
    private int bitmapWidth;
    private int bitmapHeight;
    private IWrappedTexture content;
    private int modelColumn = -1;
    private int iconType = -1;
    private boolean dataChanged = false;
    private IconLoader iconLoader;

    @Override
    public void connected(InitializationContext initializationContext) {
        super.connected(initializationContext);
        this.updateContent();
    }

    @Override
    public void disconnecting() {
        iconLabelLogCh.log(-2137614336, "IconLabelController#disconnecting");
        if (!this.hasContent() && this.iconLoader != null) {
            this.iconLoader.cancelLoad(this.getID(), this);
        }
        if (this.content != null) {
            this.content.releaseTexture(true, this);
        }
        this.content = null;
        super.disconnecting();
    }

    public int getBitmapHeight() {
        return this.bitmapHeight;
    }

    public int getBitmapWidth() {
        return this.bitmapWidth;
    }

    private ITextureCache getCache() {
        if (this.getTerminal() instanceof HMITerminalEAL) {
            EALManager eALManager = ((HMITerminalEAL)this.getTerminal()).getEALManager();
            return eALManager.getIconLabelCache();
        }
        return null;
    }

    public IconCell getIconCell() {
        return this.iconCell;
    }

    public int getIconType() {
        return this.iconType;
    }

    public int getID() {
        if (this.resourceLocator != null) {
            return this.resourceLocator.getResourceID();
        }
        return -1;
    }

    @Override
    public int getPreferredWidth() {
        iconLabelLogCh.log(1078071040, "IconLabelController#getPreferredWidth Bitmap with width %1. preferred width: %2", (long)this.bitmapWidth, (long)this.preferredWidth);
        if (this.preferredWidth != -1) {
            return this.preferredWidth;
        }
        if (this.hasContent()) {
            return this.bitmapWidth;
        }
        if (this.renderer != null) {
            return this.renderer.getPreferredWidth();
        }
        return 0;
    }

    @Override
    public int getPreferredHeight() {
        iconLabelLogCh.log(1078071040, "IconLabelController#getPreferredHeight Bitmap with heigth %1. preferred height: %2", (long)this.bitmapHeight, (long)this.preferredHeight);
        if (this.preferredHeight != -1) {
            return this.preferredHeight;
        }
        if (this.hasContent()) {
            return this.bitmapHeight;
        }
        if (this.renderer != null) {
            return this.renderer.getPreferredHeight();
        }
        return 0;
    }

    @Override
    public IRenderer getRenderer() {
        return this.renderer;
    }

    public IWrappedTexture getTexture() {
        return this.content;
    }

    public static void logIconCellInfo(LogChannel logChannel, int n, IconCell iconCell, HMITerminalEAL hMITerminalEAL, int n2) {
        block5: {
            try {
                logChannel.log(n, "IconLabelController#logIconCellInfo IconCell info");
                logChannel.log(n, "Type %1", (long)iconCell.getType());
                logChannel.log(n, "Icon Text %1", (Object)iconCell.getIconText());
                logChannel.log(n, "Font Reference %1", (long)iconCell.getFontReference());
                logChannel.log(n, "Font Size %1", (long)iconCell.getFontSize());
                logChannel.log(n, "Font Size Type %1", (long)iconCell.getFontSizeType());
                logChannel.log(n, "Text Color %1", (long)iconCell.getTextColor());
                logChannel.log(n, "Delta X %1, Delta Y %2", (long)iconCell.getDeltaX(), (long)iconCell.getDeltaY());
                EALManager eALManager = hMITerminalEAL.getEALManager();
                HMIResourceLocator hMIResourceLocator = iconCell.getResourceLocator();
                logChannel.log(n, "IconLabelController#logIconCellInfo ResourceLocator info");
                logChannel.log(n, "Picture Config Use-Case %1", (long)hMIResourceLocator.getPictureConfigUseCase());
                logChannel.log(n, "Resource ID %1", (long)hMIResourceLocator.getResourceID());
                logChannel.log(n, "Resource URI %1", (Object)hMIResourceLocator.getResourceURI());
                logChannel.log(n, "EAL Path %1", (Object)eALManager.getHMIImage(hMIResourceLocator, n2, true));
                logChannel.log(n, "EAL Path %1", (Object)eALManager.getHMIImage(hMIResourceLocator.getResourceID(), n2));
                if (hMIResourceLocator.getResourceID() < 0) break block5;
                try {
                    IconExtractor$Bitmap iconExtractor$Bitmap = IconExtractor.getImage(hMIResourceLocator.getResourceID(), (long)0);
                    if (iconExtractor$Bitmap != null) {
                        int n3 = iconExtractor$Bitmap.getFormat();
                        int n4 = iconExtractor$Bitmap.getWidth();
                        int n5 = iconExtractor$Bitmap.getHeight();
                        logChannel.log(n, "width %1", (long)n4);
                        logChannel.log(n, "height %1", (long)n5);
                        logChannel.log(n, "format %1", (long)n3);
                        logChannel.log(n, "info %1", (Object)iconExtractor$Bitmap.getData().toString());
                        break block5;
                    }
                    logChannel.log(n, "Bitmap is null.");
                }
                catch (Exception exception) {
                    logChannel.log(n, "IconLabelController#logIconCellInfo Caught exception when getting bitmap %1", (Object)exception.getMessage());
                }
            }
            catch (Exception exception) {
                logChannel.log(-1601830656, "IconLabelController#logIconCellInfo Caught exception %1", (Object)exception.getMessage());
            }
        }
    }

    public boolean hasDataChanged(boolean bl) {
        boolean bl2 = this.dataChanged;
        if (bl) {
            this.dataChanged = false;
        }
        return bl2;
    }

    @Override
    public void processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
        iconLabelLogCh.log(-2137614336, "IconCellController#processModelUpdateEvent model = %1", this.model);
        if (!this.isConnected()) {
            iconLabelLogCh.log(-2137614336, "IconCellController#processModelUpdateEvent Widget is not connected. Return.");
            return;
        }
        this.updateContent();
    }

    public void setModelColumn(int n) {
        this.modelColumn = n;
    }

    @Override
    public int getModelColumn() {
        return this.modelColumn;
    }

    public static boolean isImageAvailable(IconCell iconCell) {
        HMIResourceLocator hMIResourceLocator;
        return iconCell != null && (hMIResourceLocator = iconCell.getResourceLocator()) != null && hMIResourceLocator.getResourceID() >= 0;
    }

    public void setRenderer(IconLabelRendererHigh iconLabelRendererHigh) {
        this.renderer = iconLabelRendererHigh;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void updateContent() {
        if (AbstractWidget.framework.isTarget() && !MixedListKZBMerger.isIconExtractorInitialized) {
            long l = System.currentTimeMillis();
            IconExtractor.initialize();
            long l2 = System.currentTimeMillis();
            mapOverlayLogCh.log(1078071040, "IconLabelController#updateContent IconExtractor initialization took %1 milliseconds", l2 - l);
            MixedListKZBMerger.isIconExtractorInitialized = true;
        }
        if (this.model instanceof ChoiceModelGUI) {
            this.resourceLocator = new HMIResourceLocator(((ChoiceModelGUI)this.model).getValue());
            this.iconType = 0;
            this.dataChanged = true;
            this.setCompositesDirty(true);
            this.invalidateParentLayout();
        } else if (this.model instanceof IconCell) {
            this.iconCell = (IconCell)this.model;
            this.resourceLocator = this.iconCell.getResourceLocator();
            this.iconType = this.iconCell.getType();
            this.setCompositesDirty(true);
            this.invalidateParentLayout();
        } else if (this.model == null) {
            this.iconCell = null;
            this.resourceLocator = null;
            this.iconType = -1;
            this.setCompositesDirty(true);
            this.invalidateParentLayout();
        }
        this.bitmapWidth = -1;
        this.bitmapHeight = -1;
        int n = this.getID();
        iconLabelLogCh.log(-2137614336, "IconLabelController#updateContent Resource ID = %1", (long)n);
        if (n >= 0) {
            Integer n2 = Util.createInteger(n);
            IWrappedTexture iWrappedTexture = null;
            ITextureCache iTextureCache = this.getCache();
            if (iTextureCache == null) {
                iconLabelLogCh.log(-1601830656, "IconLabelController#updateContent The cache has not been created yet!");
                return;
            }
            ITextureCache iTextureCache2 = iTextureCache;
            synchronized (iTextureCache2) {
                TextureDescription textureDescription = iTextureCache.getTextureDescriptionByKey(n2);
                if (textureDescription != null) {
                    iWrappedTexture = textureDescription.getTexture(this);
                    this.bitmapWidth = iWrappedTexture.getWidth();
                    this.bitmapHeight = iWrappedTexture.getHeight();
                    iconLabelLogCh.log(-2137614336, "IconLabelController#updateContent Texture with id = %1 found in cache. Width = %2, height = %3.", (long)n, (long)this.bitmapWidth, (long)this.bitmapHeight);
                } else if (this.shouldUseAsychronouseLoading()) {
                    iconLabelLogCh.log(-2137614336, "IconLabelController#updateContent Load icon %1 asynchronously", (long)n);
                    this.loadAsyncIcon(n, n2);
                } else {
                    iconLabelLogCh.log(-2137614336, "IconLabelController#updateContent Load icon %1 synchronously", (long)n);
                    iWrappedTexture = this.loadIcon(n, n2, iTextureCache);
                }
            }
            if (this.content != null) {
                this.content.releaseTexture(true, this);
            }
            this.logTextureInformation(n2, iWrappedTexture);
            this.content = iWrappedTexture;
        } else {
            if (this.content != null) {
                this.content.releaseTexture(true, this);
            }
            this.content = null;
        }
    }

    public final boolean shouldUseAsychronouseLoading() {
        return IconLabelController.isAsia();
    }

    private void loadAsyncIcon(int n, Integer n2) {
        this.iconLoader = IconLoader.getInstance();
        if (!this.iconLoader.isStarted()) {
            this.iconLoader.start();
        }
        this.iconLoader.loadImage(n, n2, this);
    }

    private IWrappedTexture loadIcon(int n, Integer n2, ITextureCache iTextureCache) {
        try {
            if (framework.isTarget()) {
                IconExtractor$Bitmap iconExtractor$Bitmap = IconLoader.getImage(n, 50);
                return this.createTextureDescription(n, n2, iconExtractor$Bitmap, iTextureCache);
            }
        }
        catch (Exception exception) {
            iconLabelLogCh.log(10000, "IconLabelController#updateContent Caught exception when getting bitmap with id = %2 from model %3. %1", (Object)exception.getMessage(), (long)n, (long)this.modelID);
        }
        return null;
    }

    @Override
    public List getDiagnosisChildren() {
        return null;
    }

    @Override
    public boolean hasContent() {
        return this.content != null;
    }

    @Override
    public void onIconLoaded(int n, Integer n2, IconExtractor$Bitmap iconExtractor$Bitmap) {
        iconLabelLogCh.log(-2137614336, "IconLabelController#onIconLoaded Bitmap with id %1 is coming in for widget %2.", (long)n, (long)this.hashCode());
        ITextureCache iTextureCache = this.getCache();
        if (iTextureCache.getTextureDescriptionByKey(n2) != null) {
            iconLabelLogCh.log(1078071040, "IconLabelController#onIconLoaded Bitmap with id %1 is existing in cache.", (long)n);
        }
        if (this.content != null) {
            this.content.releaseTexture(true, this);
        }
        this.content = this.createTextureDescription(n, n2, iconExtractor$Bitmap, iTextureCache);
        this.logTextureInformation(n2, this.content);
        this.refreshLayout();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private IWrappedTexture createTextureDescription(int n, Integer n2, IconExtractor$Bitmap iconExtractor$Bitmap, ITextureCache iTextureCache) {
        if (iconExtractor$Bitmap != null) {
            this.bitmapWidth = iconExtractor$Bitmap.getWidth();
            this.bitmapHeight = iconExtractor$Bitmap.getHeight();
            ByteBuffer byteBuffer = iconExtractor$Bitmap.getData();
            if (byteBuffer != null) {
                int n3 = iconExtractor$Bitmap.getWidth();
                int n4 = iconExtractor$Bitmap.getHeight();
                TextureDescription textureDescription = this.renderer.getEALManager().createTextureDescription(byteBuffer, 6, n3, n4, iTextureCache, n2);
                ITextureCache iTextureCache2 = iTextureCache;
                synchronized (iTextureCache2) {
                    return textureDescription.getTexture(this);
                }
            }
            iconLabelLogCh.log(10000, "IconLabelController#onIconLoaded Bitmap with id %1 is null.", (long)n);
        } else {
            iconLabelLogCh.log(10000, "IconLabelController#onIconLoaded Bitmap with id %1 has no ByteBuffer.", (long)n);
        }
        return null;
    }

    private void refreshLayout() {
        this.setCompositesDirty(true);
        this.invalidateParentLayout();
    }

    @Override
    public void processEvent(ATIPEvent aTIPEvent) {
        if (aTIPEvent instanceof IconLoader$IconLoadedEvent && this.isVisible()) {
            IconLoader$IconLoadedEvent iconLoader$IconLoadedEvent = (IconLoader$IconLoadedEvent)aTIPEvent;
            if (iconLoader$IconLoadedEvent.getImage() != null && iconLoader$IconLoadedEvent.getIconID() == this.getID()) {
                this.onIconLoaded(iconLoader$IconLoadedEvent.getIconID(), iconLoader$IconLoadedEvent.getIDInt(), iconLoader$IconLoadedEvent.getImage());
            } else {
                iconLabelLogCh.log(10000, "IconLabelController#processEvent Unmatched event coming in, epect %1 but back with %2", (long)this.getID(), (long)iconLoader$IconLoadedEvent.getIconID());
            }
            aTIPEvent.consume();
            this.triggerRepaint();
        }
    }

    private void logTextureInformation(Integer n, IWrappedTexture iWrappedTexture) {
        if (iWrappedTexture != null && iWrappedTexture.getTexture() != null && IWidgetLogChannel.iconLabelLogCh.isDebug()) {
            ByteBuffer byteBuffer = ByteBuffer.allocateDirect(iWrappedTexture.getRawImageSize());
            boolean bl = iWrappedTexture.getTexture().getData(byteBuffer);
            if (bl) {
                ByteBufferBackedInputStream byteBufferBackedInputStream = new ByteBufferBackedInputStream(byteBuffer);
                IconLoader.compareAndPut(n, byteBufferBackedInputStream, textureRecorder);
            } else {
                iconLabelLogCh.log(10000, "IconLabelController#logTextureInformation can not fetch texture data with id(%1)", (Object)n);
            }
        }
    }

    public static void dumpCache() {
        StringBuffer stringBuffer = new StringBuffer(55);
        stringBuffer.append("Texture context MD5 hash: [\r\n");
        Iterator iterator = textureRecorder.keySet().iterator();
        while (iterator.hasNext()) {
            Integer n = (Integer)iterator.next();
            String string = (String)textureRecorder.get(n);
            stringBuffer.append("\t{id = ");
            stringBuffer.append(n);
            stringBuffer.append(", hash = ");
            stringBuffer.append(string);
            stringBuffer.append("}\r\n");
        }
        stringBuffer.append(']');
        IWidgetLogChannel.iconLabelLogCh.log(-2137614336, stringBuffer.toString());
    }

    public boolean hasPlaceholderSettings() {
        return this.getPreferredWidth() > 0 && this.getPreferredHeight() > 0;
    }

    static {
        textureRecorder = new HashMap();
    }
}

