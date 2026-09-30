/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.hmi.HMIImageConstantsSystem;
import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.model.HMIResourceLocator;
import de.audi.atip.hmi.model.IconCell;
import de.audi.atip.hmi.model.IntegerListCell;
import de.audi.atip.hmi.model.ResourceLocatorListCell;
import de.audi.atip.hmi.model.TextListCell;
import de.audi.atip.hmi.modelaccess.ChoiceModelGUI;
import de.audi.atip.hmi.modelaccess.HMIModelGUI;
import de.audi.atip.hmi.modelaccess.LabelModelGUI;
import de.audi.atip.hmi.modelaccess.ResourceLocatorModelGUI;
import de.audi.atip.util.Util;
import de.audi.tghu.hmi.evo.HMITerminalEvo;
import de.audi.tghu.hmi.evo.ILockingListener;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.animation.AnimationController;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.base.widgets.ModelStubController;
import de.esolutions.hmi.widgets.audi.evo.LockingManager;
import de.esolutions.hmi.widgets.audi.evo.widgets.IEmptyableWidget;
import de.esolutions.hmi.widgets.audi.evo.widgets.IStatusbarChild;
import de.esolutions.hmi.widgets.audi.evo.widgets.IconRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.list.ListItemWidget;

public class IconController
extends AbstractWidgetController
implements ListItemWidget,
IEmptyableWidget,
IStatusbarChild,
ILockingListener {
    public static final int DEFAULT_IMAGE_MODE_SINGLE = 0;
    public static final int DEFAULT_IMAGE_MODE_MULTI = 1;
    private IconRenderer renderer;
    private int defaultImageMode = 0;
    public static final int STATE_NO_CHANGE = 0;
    public static final int STATE_IMAGE_CHANGE = 1;
    public static final int STATE_COLOR_CHANGE = 2;
    private boolean imageCacheActivated = true;
    private boolean horizontalFlip;
    private int modelColumn = -1;
    private int selectedIndex;
    private Object content;
    private int[][] bitmapMapping;
    private static final boolean CACHE_IMAGE_IN_LRU = false;
    protected int processStateChange = 0;
    private boolean r8Distinction = false;
    private float opacityGuide = 1.0f;
    private int arabicX = Integer.MIN_VALUE;
    private int lockingAction;
    private boolean lockingActive;
    private float lockingShadingOpacity = (float)Integer.getInteger("imageOpacityIfLockingActive", 50).intValue() / 100.0f;
    private ModelStubController modelStubLockingShade;
    private ModelStubController modelStubLockingInvisible;
    private boolean isDrawerIcon;

    public IconController() {
        IWidgetLogChannel.logLocking.log(10000000, "IconController#IconController lockingOpacity=%1", (double)this.lockingShadingOpacity);
    }

    public IRenderer getRenderer() {
        return this.renderer;
    }

    public void setRenderer(IconRenderer iconRenderer) {
        this.renderer = iconRenderer;
    }

    protected void initializeWidget() {
        super.initializeWidget();
        this.checkForSportSkin();
        this.checkForR8Hack();
        this.updateContent();
    }

    private void checkForSportSkin() {
        if (this.hasBitmap(0)) {
            int n = ((HMITerminalEvo)((Object)this.terminal)).getSkin();
            int n2 = this.getBitmap(0);
            if (n2 == 400010 || n2 == HMIImageConstantsSystem.mib2_map_big_stage_darken_layer_tts) {
                this.setOnScreen(true);
                if (n == 1) {
                    this.bitmapIndices[0] = HMIImageConstantsSystem.mib2_map_big_stage_darken_layer_tts;
                    this.renderer.setScaleFactor(1.0f, 1.0f);
                    ((AnimationController)this.terminal.getIAnimationController()).setSportskinSmallStageMapGrid(this);
                } else {
                    this.bitmapIndices[0] = 400010;
                    this.renderer.setScaleFactor(10.0f, 10.0f);
                    ((AnimationController)this.terminal.getIAnimationController()).setSportskinSmallStageMapGrid(null);
                }
            }
        }
    }

    private void checkForR8Hack() {
        if (this.r8Distinction && this.isR8() && this.hasBitmap(1)) {
            this.bitmapIndices[0] = this.bitmapIndices[1];
        }
    }

    private boolean isR8() {
        return this.terminal != null && this.terminal.getCarCodingHelper() != null && this.terminal.getCarCodingHelper().isR8();
    }

    public void setR8Distinction(boolean bl) {
        this.r8Distinction = bl;
    }

    public void processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
        if (modelUpdateEvent == null) {
            return;
        }
        this.updateLockingAction(modelUpdateEvent);
        if (modelUpdateEvent.getModelId() == this.modelID) {
            int n = modelUpdateEvent.getUpdateType();
            if (n == 1 || n == 14) {
                this.updateContent();
            }
            if (n == 2) {
                this.invalidateParentLayout();
            }
        }
        super.processModelUpdateEvent(modelUpdateEvent);
    }

    public void updateContent() {
        Object object = this.calculateContent();
        boolean bl = !this.isEqualContent(this.content, object);
        this.content = object;
        if (bl) {
            this.setCompositesDirty(true);
            this.invalidateParentLayout();
        }
    }

    private boolean isEqualContent(Object object, Object object2) {
        if (object instanceof HMIResourceLocator && object2 instanceof HMIResourceLocator) {
            boolean bl;
            HMIResourceLocator hMIResourceLocator = (HMIResourceLocator)object;
            HMIResourceLocator hMIResourceLocator2 = (HMIResourceLocator)object2;
            if (hMIResourceLocator.getStatus() != hMIResourceLocator2.getStatus()) {
                return false;
            }
            boolean bl2 = hMIResourceLocator.getResourceURI() == HMIResourceLocator.UNDEFINED_URI;
            boolean bl3 = bl = hMIResourceLocator2.getResourceURI() == HMIResourceLocator.UNDEFINED_URI;
            if (bl2 != bl) {
                return false;
            }
        }
        return Util.equals(object, object2);
    }

    protected Object calculateContent() {
        if (this.model == null) {
            int n = this.processStateChange == 1 ? this.getCurrentVisState() : this.selectedIndex;
            return new Integer(n);
        }
        Object object = this.calculateModelContent();
        if (object == null) {
            int n;
            int n2 = n = this.processStateChange == 1 ? this.getCurrentVisState() : this.selectedIndex;
            if (this.hasBitmap(n)) {
                return Util.createInteger(n);
            }
        }
        return object;
    }

    protected Object calculateModelContent() {
        if (this.model instanceof HMIModelGUI && ((HMIModelGUI)this.model).getStatus() == 3) {
            return null;
        }
        if (this.model instanceof LabelModelGUI) {
            return ((LabelModelGUI)this.model).getText();
        }
        if (this.model instanceof ResourceLocatorModelGUI) {
            return this.calculateResourceLocatorContent(((ResourceLocatorModelGUI)this.model).getResourceLocator());
        }
        if (this.model instanceof ResourceLocatorListCell) {
            return this.calculateResourceLocatorContent(((ResourceLocatorListCell)this.model).getResourceLocator());
        }
        if (this.model instanceof HMIResourceLocator) {
            return this.calculateResourceLocatorContent((HMIResourceLocator)this.model);
        }
        if (this.model instanceof IconCell) {
            return this.calculateResourceLocatorContent(((IconCell)this.model).getResourceLocator());
        }
        if (this.model instanceof IntegerListCell) {
            return new Integer(((IntegerListCell)this.model).getValue());
        }
        if (this.model instanceof Integer) {
            return this.model;
        }
        if (this.model instanceof TextListCell) {
            return ((TextListCell)this.model).getText();
        }
        if (this.model instanceof String) {
            return this.model;
        }
        if (this.model instanceof ChoiceModelGUI) {
            return new Integer(((ChoiceModelGUI)this.model).getValue());
        }
        logChannel.log(100000, "Unknown model %2: %1", this.model, (long)this.modelID);
        return null;
    }

    private Object calculateResourceLocatorContent(HMIResourceLocator hMIResourceLocator) {
        if (hMIResourceLocator == null) {
            return null;
        }
        if (hMIResourceLocator.containsResourceID() || hMIResourceLocator.containsResourceURI()) {
            return hMIResourceLocator;
        }
        return null;
    }

    public Object getContent() {
        return this.content;
    }

    public boolean isCacheImageInLRU() {
        return false;
    }

    public int getBitmap(int n) {
        int n2 = this.getMappedBitmapIndex(n);
        return super.getBitmap(n2);
    }

    protected int getMappedBitmapIndex(int n) {
        if (this.bitmapMapping == null || this.bitmapMapping.length == 0) {
            return n;
        }
        for (int i2 = 0; i2 < this.bitmapMapping.length; ++i2) {
            int[] nArray = this.bitmapMapping[i2];
            if (nArray == null) continue;
            for (int i3 = 0; i3 < nArray.length; ++i3) {
                if (nArray[i3] != n) continue;
                return i2;
            }
        }
        logChannel.log(100000, "IconController.getMappedBitmapIndex: no mapping found for value: %1", (long)n);
        return -1;
    }

    public int[][] getBitmapMapping() {
        return this.bitmapMapping;
    }

    public void setBitmapMapping(int[][] nArray) {
        this.bitmapMapping = nArray;
    }

    public int getPreferredWidth() {
        if (this.preferredWidth != -1) {
            return this.preferredWidth;
        }
        if (this.renderer != null) {
            return this.renderer.getPreferredWidth();
        }
        return 0;
    }

    public int getPreferredHeight() {
        if (this.preferredHeight != -1) {
            return this.preferredHeight;
        }
        if (this.renderer != null) {
            return this.renderer.getPreferredHeight();
        }
        return 0;
    }

    public void setModelColumn(int n) {
        this.modelColumn = n;
    }

    public int getModelColumn() {
        return this.modelColumn;
    }

    public boolean isImageCacheActivated() {
        return this.imageCacheActivated;
    }

    public void setImageCacheActivated(boolean bl) {
        this.imageCacheActivated = bl;
    }

    public void setProcessStateChange(int n) {
        this.processStateChange = n;
    }

    public int getProcessStateChange() {
        return this.processStateChange;
    }

    public void setEnabled(boolean bl) {
        if (this.isEnabled() != bl) {
            super.setEnabled(bl);
            this.checkContentChange();
        }
    }

    public void setHighlighted(boolean bl) {
        if (this.isHighlighted() != bl) {
            super.setHighlighted(bl);
            this.checkContentChange();
        }
    }

    public void setFocused(boolean bl) {
        if (this.isFocused() != bl) {
            super.setFocused(bl);
            this.checkContentChange();
        }
    }

    private void checkContentChange() {
        if (this.processStateChange == 1) {
            this.updateContent();
        } else if (this.processStateChange == 2) {
            this.setCompositesDirty(true);
        }
    }

    public void setValue(int n) {
        this.selectedIndex = n;
        this.updateContent();
    }

    public String getDiagnosisText() {
        return this.renderer != null ? this.renderer.getDiagnosisText() : super.getDiagnosisText();
    }

    public boolean hasContent() {
        if (this.content instanceof Integer) {
            int n = (Integer)this.content;
            int n2 = this.getBitmap(n);
            return n2 != -1 && n2 != HMIImageConstantsSystem.empty_image;
        }
        return this.content != null && this.renderer != null;
    }

    public int getModelValue() {
        if (this.model != null && this.model instanceof ChoiceModelGUI) {
            return ((ChoiceModelGUI)this.model).getValue();
        }
        return -1;
    }

    public int getModelMin() {
        return -1;
    }

    public int getModelMax() {
        return -1;
    }

    public int getDefaultImageMode() {
        return this.defaultImageMode;
    }

    public void setDefaultImageMode(int n) {
        this.defaultImageMode = n;
    }

    public int getModelStatus() {
        if (this.model != null && this.model instanceof HMIModelGUI) {
            return ((HMIModelGUI)this.model).getStatus();
        }
        return 0;
    }

    public void disconnecting() {
        if (LockingManager.isRegisteredListener(this)) {
            LockingManager.deregisterListener(this);
            this.lockingActive = false;
        }
        super.disconnecting();
    }

    public void setViewSizeOpacity(float f2) {
        if (this.viewSizeOpacity != f2) {
            this.viewSizeOpacity = f2;
            this.setCompositesDirty(true);
        }
    }

    public float getRenderOpacity() {
        float f2 = super.getRenderOpacity() * this.opacityGuide;
        if (this.lockingActive) {
            if (this.lockingAction == 1) {
                f2 *= this.lockingShadingOpacity;
            } else if (this.lockingAction == 2) {
                f2 = 0.0f;
            }
            IWidgetLogChannel.logLocking.log(10000000, "IconController#getRenderOpacity return opacity=%1", (double)f2);
        }
        return f2;
    }

    public float getOpacityGuide() {
        return this.opacityGuide;
    }

    public void setOpacityGuide(float f2) {
        if (this.opacityGuide != f2) {
            this.setCompositesDirty(true);
            this.opacityGuide = f2;
        }
    }

    public void setArabicX(int n) {
        this.arabicX = n;
    }

    public int getX() {
        if (!this.isLTR() && this.arabicX != Integer.MIN_VALUE) {
            return this.arabicX;
        }
        return super.getX();
    }

    public boolean isHorizontalFlip() {
        return this.horizontalFlip;
    }

    public void setHorizontalFlip(boolean bl) {
        this.horizontalFlip = bl;
    }

    public void connected(InitializationContext initializationContext) {
        super.connected(initializationContext);
        if (this.modelStubLockingInvisible != null || this.modelStubLockingShade != null || this.isDrawerIcon) {
            this.calculateLockingAction();
            LockingManager.registerListener(this);
        }
        this.invalidateParentLayout();
        this.setCompositesDirty(true);
    }

    private void calculateLockingAction() {
        this.evaluateModelStub(this.modelStubLockingShade, 1);
        this.evaluateModelStub(this.modelStubLockingInvisible, 2);
        IWidgetLogChannel.logLocking.log(10000000, "IconController#calculateLockingAction new lockingAction=%1", (long)this.lockingAction);
    }

    private void evaluateModelStub(ModelStubController modelStubController, int n) {
        int n2;
        Object object;
        if (modelStubController != null && (object = modelStubController.getModel()) instanceof ChoiceModelGUI && (n2 = ((ChoiceModelGUI)object).getValue()) == 1) {
            this.lockingAction = n;
        }
    }

    public void add(AbstractWidget abstractWidget, int n) {
        if (abstractWidget instanceof ModelStubController) {
            if (n == 0x2000000) {
                this.modelStubLockingShade = (ModelStubController)abstractWidget;
            } else if (n == 0x4000000) {
                this.modelStubLockingInvisible = (ModelStubController)abstractWidget;
            }
        }
        super.add(abstractWidget);
    }

    public void isLockingActive(boolean bl, boolean bl2) {
        this.lockingActive = this.isDrawerIcon ? bl : bl && bl2;
        this.setCompositesDirty(true);
    }

    private void updateLockingAction(ModelUpdateEvent modelUpdateEvent) {
        int n = modelUpdateEvent.getModelId();
        if (this.modelStubLockingInvisible != null && n == this.modelStubLockingInvisible.getModelID() || this.modelStubLockingShade != null && n == this.modelStubLockingShade.getModelID()) {
            this.calculateLockingAction();
            this.setCompositesDirty(true);
        }
    }

    public void setIsDrawerIcon(boolean bl) {
        this.isDrawerIcon = bl;
    }

    public boolean isLockingActive() {
        return this.lockingActive;
    }

    public boolean isInterestedOnTimerEvents() {
        return false;
    }
}

