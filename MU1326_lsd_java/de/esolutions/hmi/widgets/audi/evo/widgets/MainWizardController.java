/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.hmi.event.WheelButtonEvent;
import de.audi.atip.hmi.model.ChoiceModel;
import de.audi.atip.hmi.view.AnimationListener;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.hmi.evo.ILockingListener;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.RectangleParameters;
import de.esolutions.hmi.widgets.audi.base.Rectangular;
import de.esolutions.hmi.widgets.audi.base.ScreenMainArea;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.DrawerAnimationManager;
import de.esolutions.hmi.widgets.audi.evo.LockingManager;
import de.esolutions.hmi.widgets.audi.evo.widgets.AbstractPlaceholderMenuController;
import de.esolutions.hmi.widgets.audi.evo.widgets.PlaceholderMenuItem;

public class MainWizardController
extends AbstractPlaceholderMenuController
implements ScreenMainArea,
AnimationListener,
ILockingListener {
    private static final int VIEWPORT_SCROLL_ANIMATION_TYPE = 86;
    private static final int FOCUS_CURSOR_ANIMATION_TYPE = 87;
    private static final int SLOT_COUNT = 9;
    private static final float MAX_POSITION = 9.0f;
    private static final float MIN_CURSOR_POSITION = 3.0f;
    private static final float MAX_CURSOR_POSITION = 7.0f;
    private static final float MIN_ITEM_POSITION = 1.0f;
    private static final float MAX_ITEM_POSITION = 8.0f;
    private static final float ENTERTAINMENT_DRAWER_SCALING = 0.96f;
    private static final float PP_AND_ENTERTAINMENT_DRAWER_DARKENING = 0.3f;
    private static final int DRAWER_ANIMATION_MASK = 4144;
    private static final LogChannel LC;
    private int[][] mainWizardIconDecoratorMapping;
    private int[] mainWizardTextOffset;
    private float mainWizardDesaturation;
    private float mainWizardDarkening;
    private float mainWizardScaling;
    private boolean isLockingActive = false;
    private float lockingShadingOpacity = (float)Integer.getInteger("mainWizardIconOpacityIfLockingActive", 50).intValue() / 100.0f;

    protected void initializeWidget() {
        super.initializeWidget();
        if (this.mainWizardIconDecoratorMapping == null) {
            this.mainWizardIconDecoratorMapping = this.initContext.getLayout().getMainWizardIconDecoratorMapping();
        }
        if (this.mainWizardTextOffset == null) {
            this.mainWizardTextOffset = this.initContext.getLayout().getMainWizardTextOffset();
        }
    }

    public MainWizardController() {
        super(9, LC);
        IWidgetLogChannel.logLocking.log(10000000, "MainWizardController#MainWizardController lockingOpacity=%1", (double)this.lockingShadingOpacity);
    }

    public void connected(InitializationContext initializationContext) {
        super.connected(initializationContext);
        LockingManager.registerListener(this);
    }

    public void disconnecting() {
        if (LockingManager.isRegisteredListener(this)) {
            LockingManager.deregisterListener(this);
        }
        super.disconnecting();
    }

    protected int getViewportAnimationType() {
        return 86;
    }

    protected int getFocusCursorAnimationType() {
        return 87;
    }

    public PlaceholderMenuItem getFocusedItem() {
        if (this.focusCursor.getTargetItemEntry() == null) {
            return null;
        }
        return this.focusCursor.getTargetItemEntry().getItem();
    }

    public void showDrawerItem(boolean bl) {
        LC.log(10000, "MainWizardController#showDrawerItem should not be called");
        this.inOutPosition.setUnanimatedValue(1.0f);
        this.setCompositesDirty(true);
    }

    public void hideDrawerItem(boolean bl) {
        LC.log(10000, "MainWizardController#hideDrawerItem should not be called");
        this.inOutPosition.setUnanimatedValue(0.0f);
        this.setCompositesDirty(true);
    }

    public AbstractWidgetController getScreenAreaWidget() {
        return this;
    }

    public void setScreenChangeProgress(float f2) {
    }

    public void setScreenChangeTarget(int n) {
    }

    public void screenChangeFinished() {
    }

    public void setMainAreaState(int n, int n2, boolean bl) {
    }

    protected boolean inViewport(float f2, float f3) {
        return (double)f2 >= 0.0 && f2 <= 9.0f;
    }

    protected float getMaxCursorPosition() {
        return 7.0f;
    }

    protected float getMinCursorPosition() {
        return 3.0f;
    }

    protected float getMaxItemPosition() {
        return 8.0f;
    }

    protected float getMinItemPosition() {
        return 1.0f;
    }

    public boolean hasIdleTimer() {
        return false;
    }

    public void restartIdleTimer() {
    }

    public void cancelIdleTimer() {
    }

    public boolean isFocusableInSmallStage() {
        return false;
    }

    public void setFocusableInSmallStage(boolean bl) {
    }

    public void setNotFocusableIcon(AbstractWidgetController abstractWidgetController) {
    }

    public AbstractWidgetController getNotFocusableIcon() {
        return null;
    }

    public void initializeScreenChangeAnimation(Rectangular rectangular) {
    }

    public RectangleParameters getRectangleParameters() {
        return null;
    }

    public void setPPDesaturation(float f2) {
    }

    public void setMainAreaState(int n, int n2, int n3) {
    }

    public void drawerAnimationTargetChanged(float[] fArray, float[] fArray2, int n) {
    }

    public void setDrawerAnimation(float[] fArray, float[] fArray2, int n) {
        if (DrawerAnimationManager.Helper.hasFlag(n, 12)) {
            this.inOutPosition.setUnanimatedValue(1.0f - fArray[12]);
            this.setVisible(this.inOutPosition.getCurrent() > 0.0f);
            this.renderer.inOutPositionChanged();
        }
        if (DrawerAnimationManager.Helper.hasFlag(n, 5) || DrawerAnimationManager.Helper.hasFlag(n, 4)) {
            this.mainWizardDesaturation = Math.max(fArray[5], fArray[4]);
            this.mainWizardDarkening = 0.3f * fArray[5];
            if (DrawerAnimationManager.Helper.hasFlag(n, 4)) {
                this.mainWizardScaling = 0.96f + 0.04000002f * (1.0f - fArray[4]);
            }
        }
        this.setCompositesDirty(true);
    }

    public void drawerAnimationFinished(float[] fArray, float[] fArray2, int n) {
        this.setDrawerAnimation(fArray, fArray2, n);
    }

    public int getDrawerAnimationMask() {
        return 4144;
    }

    public void initializeDrawerAnimation(float[] fArray, float[] fArray2) {
        this.setDrawerAnimation(fArray, fArray2, this.getDrawerAnimationMask());
    }

    public int[][] getMainWizardIconDecoratorMapping() {
        return this.mainWizardIconDecoratorMapping;
    }

    public int[] getMainWizardTextOffset() {
        return this.mainWizardTextOffset;
    }

    public float getMainWizardScaling() {
        return this.mainWizardScaling;
    }

    public float getMainWizardDarkening() {
        return this.mainWizardDarkening;
    }

    public float getMainWizardDesaturation() {
        return this.mainWizardDesaturation;
    }

    public boolean hasVisibleFocusCursor() {
        return true;
    }

    public void keyTurned(WheelButtonEvent wheelButtonEvent) {
        PlaceholderMenuItem placeholderMenuItem;
        super.keyTurned(wheelButtonEvent);
        if (this.model instanceof ChoiceModel && (placeholderMenuItem = this.getFocusedItem()) != null) {
            ((ChoiceModel)this.model).setValue(placeholderMenuItem.getWidgetID());
        }
    }

    public void isLockingActive(boolean bl, boolean bl2) {
        this.isLockingActive = bl;
        this.setCompositesDirty(true);
    }

    public boolean isLockingActive() {
        return this.isLockingActive;
    }

    public float getLockingShadingOpacity() {
        return super.getRenderOpacity() * this.lockingShadingOpacity;
    }

    public boolean isLocked(PlaceholderMenuItem placeholderMenuItem) {
        return this.isLockingActive() && placeholderMenuItem.isLockable();
    }

    public boolean isInterestedOnTimerEvents() {
        return false;
    }

    static {
        if (AbstractWidget.framework != null) {
            LC = logChannelWizardController;
        } else {
            LC = null;
            System.err.println("MainWizardController: Warning: no framework available");
        }
    }
}

