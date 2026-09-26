/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.mmicombi.IViewSizeManager;
import de.audi.tghu.hmi.evo.HMITerminalEvo;
import de.esolutions.hmi.widgets.audi.base.AbstractScreenWidget;
import de.esolutions.hmi.widgets.audi.evo.widgets.CursorController;
import de.esolutions.hmi.widgets.audi.evo.widgets.IViewSizeAnimatable;

public class FocusCursorController
extends CursorController
implements IViewSizeAnimatable {
    private boolean optionsIconVisibleForViewSize = true;
    private boolean optionsIconVisible = true;
    private boolean optionsIconVisibleForOnline = false;
    private boolean optionsIconVisibleForFocusedItem = true;
    private float borderTopVisible = 1.0f;
    private float borderBottomVisible = 1.0f;
    private boolean moveMode = false;
    private int optionIconYOffset;
    private boolean lockingActive = false;

    private void updateWaitAnimIconPos() {
        this.setWaitAnimOffsetIdx(this.shouldShowOptionsIcon() ? 1 : 0);
    }

    @Override
    protected void initializeWidget() {
        super.initializeWidget();
        this.updateForViewSize();
    }

    public boolean isOptionsIconVisible() {
        return this.optionsIconVisible;
    }

    public void setOptionsIconVisible(boolean bl) {
        if (this.optionsIconVisible != bl) {
            this.setCompositesDirty(true);
        }
        this.optionsIconVisible = bl;
    }

    public void setOptionsIconVisibleForOnline(boolean bl) {
        if (this.optionsIconVisibleForOnline != bl) {
            this.setCompositesDirty(true);
        }
        this.optionsIconVisibleForOnline = bl;
    }

    public boolean isOptionsIconVisibleForViewSize() {
        return this.optionsIconVisibleForViewSize;
    }

    public boolean shouldShowOptionsIcon() {
        return (this.optionsIconVisible || this.optionsIconVisibleForOnline) && this.optionsIconVisibleForFocusedItem && this.optionsIconVisibleForViewSize;
    }

    public boolean shouldShowOptionsIconForAnyItem() {
        return (this.optionsIconVisible || this.optionsIconVisibleForOnline) && this.optionsIconVisibleForViewSize;
    }

    @Override
    public void setViewSizeAnimation(float f2, float[] fArray, float[] fArray2, boolean bl) {
        if (f2 < 0x6666663F && f2 > -791884739) {
            this.updateForViewSize();
        }
    }

    @Override
    public void setViewSizeAnimationFinished(float[] fArray, boolean bl) {
        this.updateForViewSize();
    }

    private void updateForViewSize() {
        if (this.isConnected()) {
            IViewSizeManager iViewSizeManager = this.getTerminalImpl().getViewSizeManager();
            if (iViewSizeManager != null) {
                boolean bl = false;
                if (this.initContext.getScreen() instanceof AbstractScreenWidget) {
                    AbstractScreenWidget abstractScreenWidget = (AbstractScreenWidget)this.initContext.getScreen();
                    boolean bl2 = bl = abstractScreenWidget.getSmallStageType() == 3;
                }
                if (bl) {
                    this.setOptionsIconVisibleForViewSize(true);
                } else {
                    int n;
                    boolean bl3 = false;
                    bl3 = this.isSportSkin() ? !this.isSportSkinSmallStage() : (n = iViewSizeManager.getCurrentViewSize()) == 2;
                    this.setOptionsIconVisibleForViewSize(bl3);
                }
            }
            this.updateWaitAnimIconPos();
        }
    }

    private boolean isSportSkinSmallStage() {
        return this.getTerminalImpl().getViewSizeManager().isSportskinSmallStage();
    }

    private boolean isSportSkin() {
        return ((HMITerminalEvo)((Object)this.getTerminalImpl())).getSkin() == 1;
    }

    public void setOptionsIconVisibleForViewSize(boolean bl) {
        if (this.optionsIconVisibleForViewSize == bl) {
            return;
        }
        this.setCompositesDirty(true);
        this.optionsIconVisibleForViewSize = bl;
    }

    @Override
    protected boolean supportsWaitAnimationWidget() {
        return true;
    }

    public float getBorderTopVisible() {
        return this.borderTopVisible;
    }

    public void setBorderTopVisible(float f2) {
        if (this.borderTopVisible != f2) {
            this.borderTopVisible = f2;
            this.setCompositesDirty(true);
        }
    }

    public float getBorderBottomVisible() {
        return this.borderBottomVisible;
    }

    public void setBorderBottomVisible(float f2) {
        if (this.borderBottomVisible != f2) {
            this.borderBottomVisible = f2;
            this.setCompositesDirty(true);
        }
    }

    public boolean isMoveMode() {
        return this.moveMode;
    }

    public void setMoveMode(boolean bl) {
        if (this.moveMode != bl) {
            this.setCompositesDirty(true);
        }
        this.moveMode = bl;
    }

    public boolean isOptionsIconVisibleForFocusedItem() {
        return this.optionsIconVisibleForFocusedItem;
    }

    public void setOptionsIconVisibleForFocusedItem(boolean bl) {
        if (this.optionsIconVisibleForFocusedItem != bl) {
            this.setCompositesDirty(true);
        }
        this.optionsIconVisibleForFocusedItem = bl;
    }

    public void setOptionIconYOffset(int n) {
        this.optionIconYOffset = n;
    }

    public int getOptionIconYOffset() {
        return this.optionIconYOffset;
    }

    @Override
    public void viewSizeTargetChanged(float[] fArray, float[] fArray2, boolean bl) {
    }

    public void waitIconVisibilityChanged() {
        this.setCompositesDirty(true);
    }

    @Override
    public void viewSizeAnimationStarted(float f2, float[] fArray, float[] fArray2) {
    }

    @Override
    public void optionDrawerLocked(Boolean bl) {
        if (bl != null) {
            logLocking.log(1078071040, "FocusCursorController#optionDrawerLocked locked=%1", (Object)bl);
            this.lockingActive = bl;
            this.setCompositesDirty(true);
        }
    }

    public boolean isLockingActive() {
        return this.lockingActive;
    }
}

