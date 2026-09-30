/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.hmi.view.IScreenData;
import de.audi.atip.hmi.view.Screen;
import de.audi.tghu.hmi.evo.DrawerAnimationListener;
import de.audi.tghu.hmi.evo.IDrawerControllerEvo;
import de.audi.tghu.hmi.evo.IDrawerFocusManagerEvo;
import de.audi.tghu.hmi.evo.IDrawerListener;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.Layout;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.AbstractPartialPopupController;
import de.esolutions.hmi.widgets.audi.evo.widgets.CursorRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.DrawerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.WaitAnimController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuController;

public class CursorController
extends AbstractWidgetController
implements DrawerAnimationListener,
IDrawerListener {
    public static final int IDX_WAV_X = 0;
    public static final int IDX_WAV_Y = 1;
    public static final int IDX_WAIT_ANIM_LOW_BOUND = -1;
    public static final int IDX_WAIT_ANIM_OFF_NO_OPT_ICON = 0;
    public static final int IDX_WAIT_ANIM_OFF_WITH_OPT_ICON = 1;
    public static final int IDX_WAIT_ANIM_HIGH_BOUND = 2;
    private int[][] layoutWaitAnimationOffsets = new int[][]{{-31, 17}, {-54, 17}};
    private int layoutWaitAnimKZBH = 24;
    private CursorRenderer renderer = null;
    protected WaitAnimController waitAnimationController = null;
    protected boolean waitAnimRunning = false;
    protected boolean retryWaitAnimationControllerInit = true;
    private int waitAnimOffsetIdx = 1;
    private boolean grayedOut;
    private int drawerAnimationMask = 5;
    private boolean isDesaturationAllowed = true;
    private boolean isLayerFrontOfDrawers = false;
    public boolean isChildOfPartialPopup;
    protected IDrawerFocusManagerEvo drawerFocusManager;
    private boolean registeredAsDrawerListener;

    public boolean isGrayedOut() {
        return this.grayedOut;
    }

    public void connected(InitializationContext initializationContext) {
        super.connected(initializationContext);
        boolean bl = this.isDesaturationAllowed = !this.shouldNotAllowDesaturation();
        if (this.terminal != null && this.isDesaturationAllowed) {
            this.drawerFocusManager = this.terminal.getDrawerFocusManager();
            if (this.drawerFocusManager != null && !this.registeredAsDrawerListener) {
                this.drawerFocusManager.addDrawerListener(this);
                this.registeredAsDrawerListener = true;
                this.drawerFocusManager.registerDrawerAnimationListener(this);
            }
        }
        this.calculateDrawerAnimationMask();
        Layout layout = this.getTerminalImpl().getLayout();
        this.layoutWaitAnimKZBH = layout.getDistance(193);
        this.layoutWaitAnimationOffsets = new int[][]{{layout.getDistance(210), layout.getDistance(212)}, {layout.getDistance(211), layout.getDistance(212)}};
    }

    private boolean shouldNotAllowDesaturation() {
        if (this.getParent().getParent() != null && this.getParent().getParent().getParent() != null && this.getParent().getParent().getParent() instanceof AbstractPartialPopupController) {
            AbstractPartialPopupController abstractPartialPopupController = (AbstractPartialPopupController)this.getParent().getParent().getParent();
            this.isChildOfPartialPopup = true;
            this.isLayerFrontOfDrawers = abstractPartialPopupController.getlayer() == 1;
        }
        return this.terminal != null && this.terminal.getDrawerFocusManager() != null && this.isLayerFrontOfDrawers;
    }

    public IRenderer getRenderer() {
        return this.renderer;
    }

    private void setWaitAnimWidgetPos(int n) {
        if (this.waitAnimationController != null) {
            this.waitAnimationController.setX(this.x + this.width + this.layoutWaitAnimationOffsets[n][0]);
            int n2 = Math.min(this.layoutWaitAnimationOffsets[n][1], (this.height - this.layoutWaitAnimKZBH) / 2);
            this.waitAnimationController.setY(this.y + n2);
            this.waitAnimationController.setCompositesDirty(true);
        }
    }

    public void setWaitAnimOffsetIdx(int n) {
        int n2;
        int n3 = n2 = n > -1 && n < 2 ? n : 1;
        if (n2 != this.waitAnimOffsetIdx) {
            this.waitAnimOffsetIdx = n2;
            this.setWaitAnimWidgetPos(this.waitAnimOffsetIdx);
        }
    }

    public void setRenderer(CursorRenderer cursorRenderer) {
        this.renderer = cursorRenderer;
    }

    public void setBounds(int n, int n2, int n3, int n4) {
        if (this.hasBounds(n, n2, n3, n4)) {
            return;
        }
        super.setBounds(n, n2, n3, n4);
        this.setWaitAnimWidgetPos(this.waitAnimOffsetIdx);
    }

    public void setX(int n) {
        if (this.x == n) {
            return;
        }
        super.setX(n);
        this.setWaitAnimWidgetPos(this.waitAnimOffsetIdx);
    }

    public void setY(int n) {
        if (this.y == n) {
            return;
        }
        super.setY(n);
        this.setWaitAnimWidgetPos(this.waitAnimOffsetIdx);
    }

    public void setWidth(int n) {
        if (this.width == n) {
            return;
        }
        super.setWidth(n);
        this.setWaitAnimWidgetPos(this.waitAnimOffsetIdx);
    }

    public void setHeight(int n) {
        if (this.height == n) {
            return;
        }
        super.setHeight(n);
        this.setWaitAnimWidgetPos(this.waitAnimOffsetIdx);
    }

    public boolean getWaitAnimRunning() {
        return this.waitAnimationController != null ? this.waitAnimationController.isVisible() : this.waitAnimRunning;
    }

    public void setWaitAnimRunning(boolean bl) {
        this.waitAnimRunning = bl;
        if (this.waitAnimationController != null) {
            this.waitAnimationController.setVisible(bl);
        }
    }

    public void setWaitAnimOffsetX(int n) {
    }

    public void setWaitAnimOffsetY(int n) {
    }

    protected boolean isPartOfMainArea(AbstractWidget abstractWidget) {
        if (abstractWidget == null) {
            return false;
        }
        if (abstractWidget instanceof MenuController) {
            return ((MenuController)abstractWidget).isMainAreaMenu();
        }
        return this.isPartOfMainArea(abstractWidget.getParent());
    }

    protected boolean supportsWaitAnimationWidget() {
        return false;
    }

    public WaitAnimController getWaitAnimationController() {
        if (this.isConnected() && this.retryWaitAnimationControllerInit && this.waitAnimationController == null && this.supportsWaitAnimationWidget() && this.isPartOfMainArea(this)) {
            this.waitAnimationController = new WaitAnimController(true);
            this.terminal.getWidgetRegistry().addActiveWaitAnimController(this.waitAnimationController);
            this.add(this.waitAnimationController);
            this.waitAnimationController.setVisible(this.waitAnimRunning);
            this.setWaitAnimWidgetPos(this.waitAnimOffsetIdx);
        }
        return this.waitAnimationController;
    }

    public void releaseWaitAnimCtrl(boolean bl) {
        this.retryWaitAnimationControllerInit = bl;
        if (this.waitAnimationController != null) {
            if (this.terminal.getWidgetRegistry().getActiveWaitAnimControllers().contains(this.waitAnimationController)) {
                this.terminal.getWidgetRegistry().getActiveWaitAnimControllers().remove(this.waitAnimationController);
            }
            this.waitAnimationController.setVisible(false);
            this.remove(this.waitAnimationController);
            this.waitAnimationController = null;
            this.setCompositesDirty(true);
        }
    }

    public void predisconnecting() {
        if (this.terminal != null && this.terminal.getDrawerFocusManager() != null) {
            this.terminal.getDrawerFocusManager().unregisterDrawerAnimationListener(this);
        }
        super.predisconnecting();
        this.releaseWaitAnimCtrl(this.retryWaitAnimationControllerInit);
    }

    public void disconnecting() {
        if (this.drawerFocusManager != null && this.isDesaturationAllowed) {
            this.drawerFocusManager.unregisterDrawerAnimationListener(this);
            this.drawerFocusManager.removeDrawerListener(this);
            this.registeredAsDrawerListener = false;
        }
        super.disconnecting();
    }

    public void initializeDrawerAnimation(float[] fArray, float[] fArray2) {
        this.setDrawerAnimation(fArray, fArray2, this.getDrawerAnimationMask());
    }

    public void drawerAnimationTargetChanged(float[] fArray, float[] fArray2, int n) {
    }

    public void setDrawerAnimation(float[] fArray, float[] fArray2, int n) {
        if (!this.isDesaturationAllowed) {
            this.grayedOut = false;
        } else {
            float f2;
            if (this.isInSelectionDrawer() || this.isInOptionDrawer() || this.isInEntertainmentDrawer()) {
                f2 = fArray[13];
            } else if (this.isChildOfPartialPopup) {
                f2 = Math.max(fArray[2], fArray[0]);
                f2 = Math.max(f2, fArray[4]);
            } else {
                f2 = fArray[11];
            }
            this.grayedOut = f2 > 0.0f;
        }
        this.setCompositesDirty(true);
    }

    public void drawerAnimationFinished(float[] fArray, float[] fArray2, int n) {
        this.setDrawerAnimation(fArray, fArray2, n);
    }

    public int getDrawerAnimationMask() {
        return this.drawerAnimationMask;
    }

    private void calculateDrawerAnimationMask() {
        this.drawerAnimationMask = 0;
        if (this.isLayerFrontOfDrawers) {
            return;
        }
        if (this.getInitContext() != null && this.getInitContext().getScreen() instanceof DrawerController) {
            this.drawerAnimationMask = 8192;
        } else if (this.isChildOfPartialPopup) {
            this.drawerAnimationMask = 21;
        }
        this.drawerAnimationMask |= 0x800;
    }

    public void optionDrawerActivated(IScreenData iScreenData, Screen screen, IDrawerControllerEvo iDrawerControllerEvo) {
    }

    public void screenSet(IScreenData iScreenData, Screen screen) {
        if (this.isDesaturationAllowed && this.isConnected()) {
            this.drawerFocusManager.unregisterDrawerAnimationListener(this);
            this.drawerFocusManager.registerDrawerAnimationListener(this);
        }
    }

    public void optionDrawerLocked(Boolean bl) {
    }
}

