/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.modelaccess.ChoiceModelGUI;
import de.audi.atip.hmi.view.Screen;
import de.audi.tghu.hmi.evo.DrawerAnimationListener;
import de.esolutions.hmi.widgets.audi.base.AbstractScreenWidget;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.HMITerminalImpl;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.WidgetRegistry;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.base.widgets.IStatusbarG24Renderer;
import de.esolutions.hmi.widgets.audi.base.widgets.LayoutContainer;
import de.esolutions.hmi.widgets.audi.evo.InstructionTextContoller;
import de.esolutions.hmi.widgets.audi.evo.ScreenWidgetEVO;
import de.esolutions.hmi.widgets.audi.evo.ViewSizeManager;
import de.esolutions.hmi.widgets.audi.evo.widgets.AbstractStatusBarController;
import de.esolutions.hmi.widgets.audi.evo.widgets.GlassplateController;
import de.esolutions.hmi.widgets.audi.evo.widgets.IViewSizeAnimatable;
import de.esolutions.hmi.widgets.audi.evo.widgets.LabelController;
import de.esolutions.hmi.widgets.audi.evo.widgets.LabelRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.LayoutContainerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.PartialPopupController;
import de.esolutions.hmi.widgets.audi.evo.widgets.ViewSizeAnimationManager;
import java.util.ArrayList;
import java.util.List;

public class StatusBarG24Controller
extends AbstractStatusBarController
implements IViewSizeAnimatable,
LayoutContainer,
DrawerAnimationListener {
    private static final int SDS_GAP_TEXT_GLASSPLATE_BIG_STAGE;
    private static final int SDS_GAP_TEXT_GLASSPLATE_SMALL_STAGE;
    private int currentLabelIndex = 0;
    private int currentDrawerState = 16;
    private List sdsLabelList;
    private boolean isViewSizeChanging;
    private IRenderer mainRenderer;
    private WidgetRegistry widgetRegistry;
    private AbstractScreenWidget screen;

    @Override
    protected void initializeWidget() {
        super.initializeWidget();
        this.widgetRegistry = ((HMITerminalImpl)this.getTerminal()).getWidgetRegistry();
        if (this.sdsLabelList == null) {
            this.sdsLabelList = new ArrayList();
        }
        this.hideSDS();
    }

    @Override
    public void connected(InitializationContext initializationContext) {
        super.connected(initializationContext);
        this.terminal.getDrawerFocusManager().registerDrawerAnimationListener(this);
    }

    @Override
    public void predisconnecting() {
        if (this.initContext.getScreen() instanceof AbstractScreenWidget) {
            this.widgetRegistry.deRegisterWidget(this, 20, -1, this.initContext.getScreen());
        }
        this.terminal.getDrawerFocusManager().unregisterDrawerAnimationListener(this);
        super.predisconnecting();
    }

    public void addSDSLabel(LabelController labelController) {
        if (this.sdsLabelList == null) {
            this.sdsLabelList = new ArrayList();
        }
        this.sdsLabelList.add(labelController);
        super.add(labelController);
    }

    @Override
    public void processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
        if (this.terminal.getFramework().getKombiType() == 4) {
            logMessagingStatusBar.log(-2137614336, "StatusBarG24Controller#processModelUpdateEvent called");
            if (this.isSDSVisible()) {
                this.setSDSVisible(true);
                this.setAllIconVisibility(false);
            } else {
                PartialPopupController partialPopupController = (PartialPopupController)this.terminal.getPartialPopupManagerEvo().getPartialPopup(101);
                this.notifyNewMainArea(partialPopupController);
                if (this.currentDrawerState == 16) {
                    this.doRightGroupPriorisation();
                }
                this.setSDSVisible(false);
            }
            super.processModelUpdateEvent(modelUpdateEvent);
        }
        this.setCompositesDirty(true);
    }

    @Override
    public void updateContent() {
        logMessagingStatusBar.log(-2137614336, "StatusBarG24Controller#updateContent called");
        if (!this.isSDSVisible() && this.currentDrawerState == 16) {
            this.doRightGroupPriorisation();
        }
    }

    @Override
    public void updateIconVisibility(boolean bl) {
        super.updateIconVisibility(bl);
        if (this.rightGroupContainer != null) {
            this.rightGroupContainer.layout();
        }
    }

    @Override
    public boolean isSDSVisible() {
        boolean bl = ((ChoiceModelGUI)this.model).getValue() != 0;
        logMessagingStatusBar.log(-2137614336, "StatusBarG24Controller#isSDSVisible SDS visibility is %1", bl);
        return bl;
    }

    public void notifyNewMainArea(AbstractWidgetController abstractWidgetController) {
        if (abstractWidgetController == null) {
            if (this.renderer instanceof IStatusbarG24Renderer) {
                ((IStatusbarG24Renderer)this.renderer).removeFromParentNode();
                this.mainRenderer = null;
            } else {
                logMessagingStatusBar.log(10000, "StatusBarG24Controller#notifyNewMainArea wrong renderer modeled %1, should be IStatusbarG24Renderer", (Object)this.renderer);
            }
        } else {
            this.mainRenderer = abstractWidgetController.getRenderer();
        }
    }

    public IRenderer getMainRenderer() {
        return this.mainRenderer;
    }

    @Override
    public void setViewSizeAnimation(float f2, float[] fArray, float[] fArray2, boolean bl) {
        if (!this.isViewSizeChanging()) {
            logMessagingStatusBar.log(-2137614336, "StatusBarG24Controller#setViewSizeAnimation Triggered view size changing");
            this.setViewSizeChanging(true);
            if (!this.isScreenshotType()) {
                this.setAllIconVisibility(false);
            } else {
                this.setLocalPartOpacity(0.0f);
            }
            GlassplateController glassplateController = this.getGlassplateController();
            if (glassplateController != null && !this.isScreenshotType()) {
                glassplateController.setSCDText(null);
            }
        }
        if (this.isScreenshotType()) {
            this.setLocalPartOpacity(1.0f - fArray[0]);
            this.rightGroupContainer.setBounds(this.x + iconGap, this.rightGroupContainer.getY(), this.width - iconGap * 2, this.rightGroupContainer.getHeight());
            this.setBounds(this.x + iconGap, this.rightGroupContainer.getY(), this.width - iconGap * 2, this.rightGroupContainer.getHeight());
        }
    }

    @Override
    public void setBounds(int n, int n2, int n3, int n4) {
        if (this.isScreenshotType()) {
            super.setBounds(this.getCoordinateSets()[1], this.getCoordinateSets()[2], this.getCoordinateSets()[3], this.getCoordinateSets()[4]);
            this.rightGroupContainer.layout();
        } else {
            super.setBounds(n, n2, n3, n4);
        }
    }

    @Override
    public void setViewSizeAnimationFinished(float[] fArray, boolean bl) {
        logMessagingStatusBar.log(-2137614336, "StatusBarG24Controller#setViewSizeAnimationFinished called");
        this.rightGroupContainer.setBounds(this.getX(), this.getY() + yOffsetIcon, this.getWidth() - gapScreenBorder, 36);
        this.setViewSizeChanging(false);
        if (!this.isSDSVisible()) {
            if (this.currentDrawerState == 16 && !this.isScreenshotType()) {
                this.doRightGroupPriorisation();
            }
        } else {
            GlassplateController glassplateController = this.getGlassplateController();
            if (glassplateController != null && !this.isScreenshotType()) {
                glassplateController.setSCDText(this.getLabelText());
            }
        }
        if (this.isScreenshotType()) {
            this.setLocalPartOpacity(1.0f - fArray[0]);
        }
        this.setCompositesDirty(true);
    }

    @Override
    public void doRightGroupPriorisation() {
        if (this.terminal != null && this.terminal.getDrawerFocusManager() != null) {
            this.terminal.getDrawerFocusManager().initializeDrawerAnimation(this);
            super.doRightGroupPriorisation();
        }
    }

    @Override
    public void viewSizeTargetChanged(float[] fArray, float[] fArray2, boolean bl) {
    }

    @Override
    public void invalidateLayout(AbstractWidget abstractWidget) {
        logMessagingStatusBar.log(-2137614336, "StatusBarG24Controller#invalidateLayout called");
        if (this.terminal != null && this.terminal.getFramework().getKombiType() == 4) {
            if (this.isSDSVisible()) {
                this.calcActiveSDSLabel();
            } else if (!this.isViewSizeChanging()) {
                this.doRightGroupPriorisation();
            }
            if (this.isSDSVisible()) {
                GlassplateController glassplateController = this.getGlassplateController();
                if (glassplateController != null) {
                    glassplateController.setSCDText(this.getLabelText());
                    glassplateController.setCompositesDirty(true);
                }
                this.setCompositesDirty(true);
            }
        }
    }

    private void calcActiveSDSLabel() {
        for (int i2 = 0; i2 < this.sdsLabelList.size(); ++i2) {
            LabelController labelController = (LabelController)this.sdsLabelList.get(i2);
            if (!labelController.isVisible()) continue;
            this.currentLabelIndex = i2;
            logMessagingStatusBar.log(-2137614336, "StatusBarG24Controller#calcActiveSDSLabel Active SDS label set to %1: %2 ", (Object)String.valueOf(i2), (Object)labelController.getText());
            labelController.setOpacity(0.0f);
            return;
        }
    }

    private void setSDSVisible(boolean bl) {
        GlassplateController glassplateController = this.getGlassplateController();
        if (glassplateController != null) {
            glassplateController.setSCDExtensionVisible(bl);
            this.updateContent();
            if (bl) {
                glassplateController.setSCDText(this.getLabelText());
            } else {
                glassplateController.setSCDText(null);
            }
        } else {
            logMessagingStatusBar.log(-1601830656, "StatusbarG24Controller#setSDSVisible -> could not show SmallCommandDisplay. No Glassplate is registered for this Screen");
            return;
        }
        glassplateController.setCompositesDirty(true);
        this.setCompositesDirty(true);
    }

    private void hideSDS() {
        for (int i2 = 0; i2 < this.sdsLabelList.size(); ++i2) {
            ((LabelController)this.sdsLabelList.get(i2)).setVisible(false);
        }
    }

    private boolean isSmallStage() {
        ViewSizeManager viewSizeManager = (ViewSizeManager)this.terminal.getViewSizeManager();
        ViewSizeAnimationManager viewSizeAnimationManager = viewSizeManager.getViewSizeAnimationManager();
        float[] fArray = viewSizeAnimationManager.getCurrentWeights();
        int n = Math.round(fArray[0]);
        return (float)n == ScreenWidgetEVO.SMALL_STAGE[0];
    }

    private boolean isScreenshotType() {
        if (this.screen == null) {
            return false;
        }
        return this.screen.getSmallStageType() == 3;
    }

    public String getLabelText() {
        this.calcActiveSDSLabel();
        LabelController labelController = (LabelController)this.sdsLabelList.get(this.currentLabelIndex);
        int n = this.getWidth();
        n = this.isSmallStage() ? (n -= 28) : (n -= 34);
        labelController.setWidth(n);
        String string = labelController.getText();
        return ((LabelRenderer)labelController.getRenderer()).calculateDisplayData(string, true);
    }

    @Override
    protected void handleFocusChanged(int n, int n2, int n3) {
        super.handleFocusChanged(n, n2, n3);
    }

    public GlassplateController getGlassplateController() {
        try {
            if (this.getTerminal() == null) {
                return null;
            }
            Screen screen = this.getTerminal().getIAnimationController().getConnectedMainScreen();
            GlassplateController glassplateController = (GlassplateController)this.widgetRegistry.getWidget(19, -1, screen);
            if (glassplateController == null) {
                return null;
            }
            if (glassplateController.getParent() != null && glassplateController.getParent().getParent() instanceof InstructionTextContoller) {
                logMessagingStatusBar.log(-1601830656, "StatusbarG24Controller#getGlassplateController could not getGlassplateController from WidgetRegistry. Reason: parent is InstructionText");
                return null;
            }
            return glassplateController;
        }
        catch (Exception exception) {
            logMessagingStatusBar.log(10000, "StatusbarG24Controller#getGlassplateController could not getGlassplateController from WidgetRegistry. Reason: %1", (Throwable)exception);
            return null;
        }
    }

    public void newScreenConnected() {
        this.setSDSVisible(this.isSDSVisible());
    }

    public void setDrawerState(int n) {
        this.currentDrawerState = n;
        switch (n) {
            case 16: {
                logMessagingStatusBar.log(-2137614336, "StatusBarG24Controller#setDrawerState Set current drawer state to STATE_MAIN_AREA");
                if (this.isSDSVisible()) break;
                this.doRightGroupPriorisation();
                break;
            }
            case 8: {
                logMessagingStatusBar.log(-2137614336, "StatusBarG24Controller#setDrawerState Set current drawer state to STATE_OPTION_MENU");
                break;
            }
            case 4: {
                logMessagingStatusBar.log(-2137614336, "StatusBarG24Controller#setDrawerState Set current drawer state to STATE_SELECTION_MENU");
                break;
            }
            default: {
                logMessagingStatusBar.log(-1601830656, "StatusBarG24Controller#setDrawerState Set current drawer to unknown state");
            }
        }
    }

    @Override
    public void initializeDrawerAnimation(float[] fArray, float[] fArray2) {
        this.setDrawerAnimation(fArray, fArray2, this.getDrawerAnimationMask());
    }

    @Override
    public void drawerAnimationTargetChanged(float[] fArray, float[] fArray2, int n) {
    }

    @Override
    public void setDrawerAnimation(float[] fArray, float[] fArray2, int n) {
        logMessagingStatusBar.log(-2137614336, "StatusBarG24Controller#setDrawerAnimation called");
        if (!this.isSDSVisible()) {
            if (fArray2[12] == 0.0f) {
                logMessagingStatusBar.log(-2137614336, "StatusBarG24Controller#setDrawerAnimation - running a SCREEN_FADE_IN Animation");
                float f2 = Math.max(fArray[2], fArray[0]);
                if (!this.isScreenshotType()) {
                    logMessagingStatusBar.log(-2137614336, "StatusBarG24Controller#setDrawerAnimation - isScreenshotType() == false --> Setting opacity to %1", (double)(1.0f - f2));
                    this.setLocalPartOpacity(1.0f - f2);
                } else if (!this.isSmallStage()) {
                    logMessagingStatusBar.log(-2137614336, "StatusBarG24Controller#setDrawerAnimation - isSmallStage() == false --> Setting opacity to %1", (double)(1.0f - f2));
                    this.setLocalPartOpacity(1.0f - f2);
                }
            } else {
                logMessagingStatusBar.log(-2137614336, "StatusBarG24Controller#setDrawerAnimation - running not a SCREEN_FADE_IN Animation (else path) --> Setting opacity to 0");
                this.setLocalPartOpacity(0.0f);
            }
        }
    }

    @Override
    public void drawerAnimationFinished(float[] fArray, float[] fArray2, int n) {
    }

    @Override
    public int getDrawerAnimationMask() {
        return 4101;
    }

    @Override
    public boolean isViewSizeChanging() {
        return this.isViewSizeChanging;
    }

    public void setViewSizeChanging(boolean bl) {
        this.isViewSizeChanging = bl;
    }

    public void setScreen(AbstractScreenWidget abstractScreenWidget) {
        this.screen = abstractScreenWidget;
    }

    @Override
    protected LayoutContainerController getRightGroupContainer() {
        LayoutContainerController layoutContainerController = new LayoutContainerController();
        layoutContainerController.setBounds(this.getX(), this.getY() + yOffsetIcon, this.getWidth() - gapScreenBorder, 36);
        layoutContainerController.setHasDynamicLayout(true);
        return layoutContainerController;
    }

    @Override
    protected LayoutContainerController getLeftGroupContainer() {
        return null;
    }

    @Override
    protected int getCurrentGapWidth() {
        return 0;
    }

    @Override
    public int getMinGapWidth() {
        return 0;
    }

    @Override
    public void viewSizeAnimationStarted(float f2, float[] fArray, float[] fArray2) {
    }
}

