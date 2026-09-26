/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.tghu.hmi.evo.DrawerAnimationListener;
import de.esolutions.hmi.widgets.audi.base.AbstractScreenWidget;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.HMITerminalImpl;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.RedrawContext;
import de.esolutions.hmi.widgets.audi.base.WidgetRegistry;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.evo.HMITerminalEvoImpl;
import de.esolutions.hmi.widgets.audi.evo.ScreenWidgetEVO;
import de.esolutions.hmi.widgets.audi.evo.ViewSizeManager;
import de.esolutions.hmi.widgets.audi.evo.widgets.AbstractPartialPopupController;
import de.esolutions.hmi.widgets.audi.evo.widgets.ComboBoxController;
import de.esolutions.hmi.widgets.audi.evo.widgets.ContainerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.ViewSizeAnimationManager;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuController;
import java.util.List;

public class GlassplateController
extends AbstractWidgetController
implements DrawerAnimationListener {
    public static final float PROPERTY_OPACITY_SEMI_OPAQUE;
    public static final float PROPERTY_OPACITY_FULL_OPAQUE;
    private IRenderer renderer;
    private float propertyOpacity = 2.0f;
    private float propertyScale = 1.0f;
    private float minimized = 0.0f;
    private int separatorYPosition = 0;
    private boolean separatorVisible = false;
    private boolean isOptionGlassPlate = false;
    private WidgetRegistry widgetRegistry;
    private String scdText;
    private boolean scdExtensionVisible = false;
    private float sdsNumbersVisible = 0.0f;
    private int sdsNumbersWidth = 64;
    private int sdsNumbersWidthSmallStage = 38;
    private Boolean selectionDrawerIconVisible = null;
    private int sdsNumbersGapWidth = 4;
    private boolean isOptionDrawerOpen = false;
    private float offScreenOpacity = 1.0f;

    public void setRenderer(IRenderer iRenderer) {
        this.renderer = iRenderer;
    }

    @Override
    public IRenderer getRenderer() {
        return this.renderer;
    }

    public float getPropertyOpacity() {
        return this.propertyOpacity;
    }

    public void setPropertyOpacity(float f2) {
        this.propertyOpacity = f2;
    }

    public float getPropertyScale() {
        return this.propertyScale;
    }

    public void setPropertyScale(float f2) {
        this.propertyScale = f2;
    }

    public float getMinimized() {
        return this.minimized;
    }

    public void setMinimized(float f2) {
        if (this.minimized == f2) {
            return;
        }
        this.minimized = f2;
        this.setCompositesDirty(true);
    }

    public int getSeparatorYPosition() {
        return this.separatorYPosition;
    }

    public void setSeparatorYPosition(int n) {
        this.separatorYPosition = n;
    }

    public boolean getSeparatorVisible() {
        return this.separatorVisible;
    }

    public void setSeparatorVisible(boolean bl) {
        this.separatorVisible = bl;
    }

    public boolean isOptionGlassPlate() {
        return this.isOptionGlassPlate;
    }

    public void setOptionGlassPlate(boolean bl) {
        this.isOptionGlassPlate = bl;
    }

    @Override
    public void connected(InitializationContext initializationContext) {
        super.connected(initializationContext);
        this.checkForOptionScreen(initializationContext);
        this.terminal.getDrawerFocusManager().registerDrawerAnimationListener(this);
    }

    @Override
    protected void initializeWidget() {
        this.selectionDrawerIconVisible = null;
        this.widgetRegistry = ((HMITerminalImpl)this.getTerminal()).getWidgetRegistry();
        if (this.isMainAreaGlassplate()) {
            if (this.getParent() != null && this.getParent().getParent() != null && this.getParent().getParent().isVisible() && this.isVisible()) {
                this.widgetRegistry.registerWidget(this, 19, -1, this.initContext.getScreen());
            } else {
                IWidgetLogChannel.logChannel.log(-1601830656, "GlassplateController#initializeWidget Parent is not visible, glassplate was not registered.");
            }
        }
        super.initializeWidget();
    }

    private boolean isMainAreaGlassplate() {
        if (!(this.initContext.getScreen() instanceof AbstractScreenWidget)) {
            return false;
        }
        for (AbstractWidget abstractWidget = this.parent; abstractWidget != null; abstractWidget = abstractWidget.getParent()) {
            if (abstractWidget instanceof AbstractPartialPopupController) {
                return false;
            }
            if (!(abstractWidget instanceof ComboBoxController)) continue;
            return false;
        }
        return true;
    }

    @Override
    public void predisconnecting() {
        if (this.isMainAreaGlassplate()) {
            this.widgetRegistry.deRegisterWidget(this, 19, -1, this.initContext.getScreen());
        }
        super.predisconnecting();
    }

    private void checkForOptionScreen(InitializationContext initializationContext) {
        if (initializationContext.getScreen() instanceof AbstractScreenWidget) {
            AbstractWidget abstractWidget = (AbstractWidget)((Object)((AbstractScreenWidget)initializationContext.getScreen()).getMainArea());
            AbstractWidget abstractWidget2 = this.parent;
            boolean bl = false;
            for (int n = 0; abstractWidget2 != null && n < 1000; abstractWidget2 = abstractWidget2.getParent(), ++n) {
                if (abstractWidget2 != abstractWidget) continue;
                bl = true;
                break;
            }
            if (bl) {
                this.setOptionGlassPlate(((AbstractScreenWidget)initializationContext.getScreen()).getScreenMode() == 2);
            }
        }
    }

    @Override
    public void render(RedrawContext redrawContext) {
        this.initializeSelectionDrawerVisibleLazy();
        super.render(redrawContext);
    }

    private void initializeSelectionDrawerVisibleLazy() {
        if (this.selectionDrawerIconVisible == null) {
            this.selectionDrawerIconVisible = this.calculateSelectionDrawerIconVisible();
            logDrawer.log(-2137614336, "GlassplateController#initializeSelectionDrawerVisibleLazy: selection drawer icon visible: %1, screen: %2", (Object)this.selectionDrawerIconVisible, (long)this.getScreenId());
        }
    }

    private boolean calculateSelectionDrawerIconVisible() {
        if (this.isG24MMIKombi()) {
            return false;
        }
        if (!this.isMainAreaGlassplate()) {
            return false;
        }
        Object object = this.getTerminalImpl().getDrawerFocusManager().getSelectionDrawer();
        if (object == null) {
            return false;
        }
        if (object instanceof AbstractWidget) {
            return ((AbstractWidget)object).isVisible();
        }
        return false;
    }

    protected boolean isG24MMIKombi() {
        return AbstractWidget.isScreenResolution1440();
    }

    public boolean isSelectionDrawerIconVisible() {
        if (this.selectionDrawerIconVisible == null) {
            logChannel.log(10000, "GlassplateController#isSelectionDrawerIconVisible: not yet initialized");
            return false;
        }
        return this.selectionDrawerIconVisible;
    }

    public void setSCDExtensionVisible(boolean bl) {
        this.scdExtensionVisible = bl;
        if (!this.isOptionGlassPlate) {
            this.renderer.setCompositesDirty(true);
        }
    }

    public String getSCDText() {
        return this.scdText;
    }

    public void setSCDText(String string) {
        this.scdText = string;
    }

    @Override
    public void disconnecting() {
        this.terminal.getDrawerFocusManager().unregisterDrawerAnimationListener(this);
        this.scdExtensionVisible = false;
        this.setSCDText(null);
        super.disconnecting();
    }

    public boolean isScdExtensionVisible() {
        return this.scdExtensionVisible;
    }

    public float getOffScreenOpacity() {
        return this.offScreenOpacity;
    }

    private ContainerController getScreenAreaContainer(AbstractWidget abstractWidget) {
        if (abstractWidget == null) {
            return null;
        }
        if (abstractWidget instanceof ScreenWidgetEVO) {
            return null;
        }
        if (abstractWidget instanceof ContainerController && abstractWidget.getParent() instanceof ScreenWidgetEVO) {
            return (ContainerController)abstractWidget;
        }
        return this.getScreenAreaContainer(abstractWidget.getParent());
    }

    public void updateMenuOpacityOptionDrawerOpen() {
        float f2;
        float f3 = 0.0f;
        ContainerController containerController = this.getScreenAreaContainer(this.getParent());
        MenuController menuController = null;
        menuController = this.getParent() instanceof MenuController ? (MenuController)this.getParent() : this.findMenuControllerFromChildren(this.getParent());
        if (containerController != null && menuController != null && (f2 = containerController.getOptionDrawerOpacity()) > 0.0f) {
            f3 = 1.0f / f2;
            this.setOpacity(f3);
            this.offScreenOpacity = f2;
            menuController.setItemOpacityOptionDrawerOpen(f3);
        }
    }

    private MenuController findMenuControllerFromChildren(AbstractWidget abstractWidget) {
        if (abstractWidget == null) {
            return null;
        }
        List list = abstractWidget.getChildren();
        if (list != null) {
            int n = list.size();
            for (int i2 = 0; i2 < n; ++i2) {
                if (!(list.get(i2) instanceof MenuController)) continue;
                return (MenuController)list.get(i2);
            }
        }
        return null;
    }

    @Override
    public void setDrawerAnimation(float[] fArray, float[] fArray2, int n) {
        this.updateMenuOpacityOptionDrawerOpen();
    }

    @Override
    public void drawerAnimationFinished(float[] fArray, float[] fArray2, int n) {
        this.updateOptionDrawerState(fArray2);
        this.updateMenuOpacityOptionDrawerOpen();
    }

    @Override
    public int getDrawerAnimationMask() {
        return 4100;
    }

    @Override
    public void initializeDrawerAnimation(float[] fArray, float[] fArray2) {
        this.updateOptionDrawerState(fArray2);
        this.updateMenuOpacityOptionDrawerOpen();
    }

    @Override
    public void drawerAnimationTargetChanged(float[] fArray, float[] fArray2, int n) {
    }

    public boolean isOptionDrawerOpen() {
        return this.isOptionDrawerOpen;
    }

    private void updateOptionDrawerState(float[] fArray) {
        this.isOptionDrawerOpen = fArray[2] == 1.0f;
    }

    public float getSdsNumbersVisible() {
        return this.sdsNumbersVisible;
    }

    public void setSdsNumbersVisible(float f2) {
        if (this.sdsNumbersVisible == f2) {
            return;
        }
        this.sdsNumbersVisible = f2;
        this.setCompositesDirty(true);
    }

    public int getSdsNumbersWidth() {
        return this.sdsNumbersWidth;
    }

    public void setSdsNumbersWidth(int n) {
        this.sdsNumbersWidth = n;
    }

    public int getSdsNumbersGapWidth() {
        return this.sdsNumbersGapWidth;
    }

    public void setSdsNumbersGapWidth(int n) {
        this.sdsNumbersGapWidth = n;
    }

    public int getSdsNumbersWidthSmallStage() {
        return this.sdsNumbersWidthSmallStage;
    }

    public void setSdsNumbersWidthSmallStage(int n) {
        this.sdsNumbersWidthSmallStage = n;
    }

    public int getActiveSdsNumbersWidth() {
        if (this.isG24MMIKombi()) {
            float f2 = this.getSmallStageProgress();
            return this.sdsNumbersWidth + Math.round(f2 * (float)(this.sdsNumbersWidthSmallStage - this.sdsNumbersWidth));
        }
        return this.sdsNumbersWidth;
    }

    private float getSmallStageProgress() {
        HMITerminalEvoImpl hMITerminalEvoImpl = (HMITerminalEvoImpl)this.getTerminal();
        ViewSizeManager viewSizeManager = (ViewSizeManager)hMITerminalEvoImpl.getViewSizeManager();
        ViewSizeAnimationManager viewSizeAnimationManager = viewSizeManager.getViewSizeAnimationManager();
        float[] fArray = viewSizeAnimationManager.getCurrentWeights();
        return fArray[0];
    }
}

