/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.audi.atip.hmi.view.AnimationListener;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.animation.AbstractAnimation;
import de.esolutions.hmi.widgets.audi.base.animation.AbstractAnimationController;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.PictureViewer;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.PictureWallIconRenderer;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.PictureWallLineController;
import de.esolutions.hmi.widgets.audi.evo.widgets.FocusCursorController;
import de.esolutions.hmi.widgets.audi.evo.widgets.LayoutContainerController;

public class PictureWallIconController
extends AbstractWidgetController
implements AnimationListener {
    private int modelRow;
    private int column = -1;
    private LayoutContainerController frontLayer;
    private FocusCursorController magnifierCursor;
    private PictureWallIconRenderer renderer;
    private PictureWallLineController parentController;
    private AbstractAnimation animation;
    public static final int ANIMATION_TYPE = 94;
    private static final int STATE_SMALL = 0;
    private static final int STATE_SCALE_UP = 1;
    private static final int STATE_SCALE_DOWN = 2;
    private static final int STATE_LARGE = 3;
    private int state = 0;
    protected int x_small;
    protected int y_small;
    protected int x_large;
    protected int y_large;

    public void animate(int n, float f2, int n2) {
        float f3;
        pictureWallLogCh.log(10000000, "PictureWallIconController#animate value = %1", (double)f2);
        if (f2 > 950.0f) {
            f2 = 1000.0f;
        }
        float f4 = f2 / 1000.0f;
        float f5 = 1.0f - f4;
        if (this.state == 2) {
            f3 = f5;
            f5 = f4;
            f4 = f3;
        }
        f3 = f5 * (float)this.x_small + f4 * (float)this.x_large;
        float f6 = f5 * (float)this.y_small + f4 * (float)this.y_large;
        float f7 = f5 * 105.0f + f4 * 310.0f;
        float f8 = f5 * 74.0f + f4 * 208.0f;
        this.setBounds((int)f3, (int)f6, (int)f7, (int)f8);
        this.magnifierCursor.setBounds((int)f3, (int)f6 + 1, (int)f7, (int)f8 - 2);
    }

    public void animationStarted(int n, int n2) {
    }

    public void animationFinished(int n, int n2) {
        pictureWallLogCh.log(10000000, "PictureWallIconController#animationFinished column = %1, state = %2", (long)this.column, (long)this.state);
        switch (this.state) {
            case 1: {
                this.setState(true);
                break;
            }
            case 2: {
                this.setState(false);
                break;
            }
            default: {
                pictureWallLogCh.log(10000, "PictureWallIconController#animationFinished No case defined for state = %1.", (long)this.state);
            }
        }
    }

    public void connected(InitializationContext initializationContext) {
        super.connected(initializationContext);
    }

    public void disconnecting() {
        if (this.animation != null && this.animation.isAnimating()) {
            this.animation.stopAnimation();
        }
        super.disconnecting();
    }

    private AbstractAnimation getAnimation(int n) {
        if (this.animation == null || this.animation.getType() != n) {
            this.animation = (AbstractAnimation)this.getAnimationController().getIAnimation(n);
            this.animation.addListener(this);
        }
        return this.animation;
    }

    private AbstractAnimationController getAnimationController() {
        return (AbstractAnimationController)this.getTerminal().getIAnimationController();
    }

    public int getColumn() {
        return this.column;
    }

    public int getModelRow() {
        return this.modelRow;
    }

    public PictureWallLineController getParentController() {
        return this.parentController;
    }

    public IRenderer getRenderer() {
        return this.renderer;
    }

    public void hideLargePreview(int n, boolean bl) {
        pictureWallLogCh.log(10000000, "PictureWallIconController#hideLargePreview state = %1", (long)this.state);
        if (this.state != 0) {
            if (bl) {
                this.state = 2;
                this.startAnimation(94);
            } else {
                this.setState(false);
            }
        }
    }

    public boolean isLarge() {
        return this.state == 3 || this.state == 1 || this.state == 2;
    }

    public boolean isSmall() {
        return this.state == 0;
    }

    public boolean isUpscaling() {
        return this.state == 1;
    }

    public boolean isScaling() {
        return this.state == 1 || this.state == 2;
    }

    public boolean isEmpty() {
        return this.renderer.isEmpty();
    }

    private void moveToBackLayer() {
        PictureWallIconRenderer pictureWallIconRenderer = this.renderer;
        this.renderer = null;
        this.frontLayer.remove(this);
        this.renderer = pictureWallIconRenderer;
        this.parentController.add(this);
        this.magnifierCursor.setVisible(false);
    }

    private void moveToFrontLayer() {
        PictureViewer pictureViewer = this.parentController.getParentController().getParentController();
        int n = this.parentController.getRow();
        this.frontLayer = pictureViewer.getLineOnFrontLayer(n);
        PictureWallIconRenderer pictureWallIconRenderer = this.renderer;
        this.renderer = null;
        this.parentController.remove(this);
        this.renderer = pictureWallIconRenderer;
        this.frontLayer.add(this);
        this.magnifierCursor = pictureViewer.getMagnifierCursor(this.column);
        AbstractWidget abstractWidget = this.magnifierCursor.getParent();
        if (abstractWidget != null) {
            abstractWidget.remove(this.magnifierCursor);
        }
        this.frontLayer.add(this.magnifierCursor);
        this.magnifierCursor.setVisible(true);
    }

    public void setBounds(int n, int n2, int n3, int n4) {
        super.setBounds(n, n2, n3, n4);
    }

    public void setColumn(int n) {
        this.column = n;
    }

    public void setHueAndSaturation(boolean bl) {
        this.renderer.setHueAndSaturation(bl);
    }

    public void setModelRow(int n) {
        this.modelRow = n;
    }

    public void setParentController(PictureWallLineController pictureWallLineController) {
        this.parentController = pictureWallLineController;
    }

    public void setRenderer(PictureWallIconRenderer pictureWallIconRenderer) {
        this.renderer = pictureWallIconRenderer;
    }

    private void setState(boolean bl) {
        pictureWallLogCh.log(10000000, "PictureWallIconController#setState large = %1", bl);
        if (bl) {
            this.setBounds(this.x_large, this.y_large, 310, 208);
            this.magnifierCursor.setBounds(this.x_large, this.y_large + 1, 310, 206);
            if (this.state == 0) {
                this.moveToFrontLayer();
            }
            if (this.state != 3) {
                PictureWallIconRenderer pictureWallIconRenderer = (PictureWallIconRenderer)this.getRenderer();
                pictureWallIconRenderer.showSmallOverlay(false);
                pictureWallIconRenderer.showLargeOverlay(true);
            }
            this.state = 3;
        } else {
            this.setBounds(this.x_small, this.y_small, 105, 74);
            PictureWallIconRenderer pictureWallIconRenderer = (PictureWallIconRenderer)this.getRenderer();
            pictureWallIconRenderer.showLargeOverlay(false);
            pictureWallIconRenderer.showSmallOverlay(true);
            if (this.state != 0) {
                this.moveToBackLayer();
            }
            this.state = 0;
        }
    }

    public void showLargePreview(int n) {
        if (this.state == 0) {
            this.x_small = this.getX();
            this.y_small = this.getY();
            this.moveToFrontLayer();
        }
        if (this.state != 3) {
            PictureWallIconRenderer pictureWallIconRenderer = (PictureWallIconRenderer)this.getRenderer();
            pictureWallIconRenderer.showSmallOverlay(false);
            pictureWallIconRenderer.showLargeOverlay(true);
            this.state = 1;
            this.startAnimation(94);
        }
    }

    private void startAnimation(int n) {
        if (this.isConnected() && (this.animation == null || !this.animation.isAnimating())) {
            this.getAnimation(n);
            this.animation.startDynamicAnimation(0.0f, 1000.0f, n, false, this);
        }
    }
}

