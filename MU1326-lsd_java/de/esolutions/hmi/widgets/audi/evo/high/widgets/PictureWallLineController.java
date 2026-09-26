/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.audi.atip.hmi.model.HMIResourceLocator;
import de.audi.atip.util.Util;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3D;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.CompositeRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.PictureWallController;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.PictureWallIconController;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.PictureWallIconRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.LayoutContainerController;

public class PictureWallLineController
extends LayoutContainerController {
    private int visibleRow = -1;
    private boolean isSetUp = false;
    public PictureWallIconController[] icons;
    private boolean[] valid;
    private HMIResourceLocator[] data;
    private PictureWallController parentController;

    public void bringToFront() {
        CompositeRendererHigh compositeRendererHigh = (CompositeRendererHigh)this.getRenderer();
        IWrappedNode3D iWrappedNode3D = compositeRendererHigh.getNode();
        if (iWrappedNode3D == null) {
            return;
        }
        IWrappedNode3D iWrappedNode3D2 = iWrappedNode3D.getParent();
        if (iWrappedNode3D2 == null) {
            return;
        }
        iWrappedNode3D2.remove(iWrappedNode3D);
        iWrappedNode3D2.add(iWrappedNode3D);
    }

    @Override
    public void connected(InitializationContext initializationContext) {
        super.connected(initializationContext);
        this.setUpWidget();
    }

    private static PictureWallIconController createPictureWallIcon() {
        PictureWallIconController pictureWallIconController = new PictureWallIconController();
        PictureWallIconRenderer pictureWallIconRenderer = new PictureWallIconRenderer(pictureWallIconController);
        pictureWallIconController.setRenderer(pictureWallIconRenderer);
        return pictureWallIconController;
    }

    private void setUpWidget() {
        if (!this.isSetUp) {
            this.isSetUp = true;
            if (this.icons == null) {
                this.icons = new PictureWallIconController[4];
                for (int i2 = 0; i2 < this.icons.length; ++i2) {
                    this.icons[i2] = PictureWallLineController.createPictureWallIcon();
                    this.icons[i2].setParentController(this);
                    this.icons[i2].setBitmaps(this.bitmapIndices);
                    this.icons[i2].setColumn(i2);
                    PictureWallIconRenderer pictureWallIconRenderer = (PictureWallIconRenderer)this.icons[i2].getRenderer();
                    pictureWallIconRenderer.setScaleMode(3);
                    this.add(this.icons[i2]);
                }
            }
            if (this.valid == null) {
                this.valid = new boolean[4];
            }
            if (this.data == null) {
                this.data = new HMIResourceLocator[4];
            }
            float f2 = (float)(this.getWidth() - 420) / 16448;
            for (int i3 = 0; i3 < this.icons.length; ++i3) {
                this.icons[i3].setWidth(105);
                this.icons[i3].setHeight(74);
                this.icons[i3].setX((int)((float)i3 * (53826 + f2)));
            }
        }
    }

    public PictureWallController getParentController() {
        return this.parentController;
    }

    public int getRow() {
        return this.visibleRow;
    }

    public void hideLargePreview(int n, boolean bl) {
        this.icons[n].hideLargePreview(n, bl);
    }

    public void setHueAndSaturation(boolean bl) {
        for (int i2 = 0; i2 < 4; ++i2) {
            this.icons[i2].setHueAndSaturation(bl);
        }
    }

    public void setParentController(PictureWallController pictureWallController) {
        this.parentController = pictureWallController;
    }

    public void setRow(int n) {
        this.visibleRow = n;
    }

    protected void setPictureAt(int n, int n2, HMIResourceLocator hMIResourceLocator) {
        if (this.icons != null) {
            boolean bl;
            HMIResourceLocator hMIResourceLocator2 = this.data[n];
            HMIResourceLocator hMIResourceLocator3 = hMIResourceLocator;
            boolean bl2 = bl = !Util.equals(hMIResourceLocator2, hMIResourceLocator3);
            if (bl) {
                pictureWallLogCh.log(-2137614336, "PictureWallLineController#setPictureAt row = %1, column = %2", (long)this.visibleRow, (long)n);
                pictureWallLogCh.log(-2137614336, "PictureWallLineController#setPictureAt oldData = %1, newData = %2", (Object)hMIResourceLocator2, (Object)hMIResourceLocator3);
                this.data[n] = hMIResourceLocator3;
                this.icons[n].setModel(hMIResourceLocator3);
                this.icons[n].setCompositesDirty(true);
                this.icons[n].setModelRow(n2);
            }
        }
    }

    public void showLargePreview(int n) {
        PictureWallIconController pictureWallIconController = this.icons[n];
        if (!pictureWallIconController.isEmpty()) {
            pictureWallIconController.x_large = PictureWallController.X_POS_LARGE_IMAGES[n] - this.getX();
            pictureWallIconController.y_large = 56 - this.getY();
            pictureWallIconController.showLargePreview(n);
        }
    }
}

