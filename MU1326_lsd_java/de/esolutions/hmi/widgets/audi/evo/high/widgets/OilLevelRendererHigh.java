/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.esolutions.hmi.widgets.audi.base.AbstractRenderer;
import de.esolutions.hmi.widgets.audi.base.RedrawContext;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3D;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3DImage;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.high.RedrawContextHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.AbstractRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.widgets.OilLevelController;

public class OilLevelRendererHigh
extends AbstractRendererHigh {
    private final OilLevelController controller;
    private IWrappedNode3D rootNode;
    private IWrappedNode3DImage frame;
    private IWrappedNode3DImage[] images;

    public OilLevelRendererHigh(OilLevelController oilLevelController) {
        this.controller = oilLevelController;
    }

    private void createNodes(RedrawContextHigh redrawContextHigh) {
        int n;
        if (this.rootNode == null) {
            this.rootNode = this.getEALManager().createNode3D(redrawContextHigh.parentNode, EALManager.createNodeName("oilLevelRootNode", this), this.controller.getWidth(), this.controller.getHeight());
            if (this.controller.isHorizontal()) {
                this.rootNode.setRotationZ(-90.0f);
            }
        }
        if (this.frame == null) {
            this.frame = this.getEALManager().createImage3D(this.rootNode, EALManager.createNodeName("oilLevelFrame", this), this.getTextureDescription(0, true), 0, true, (Object)this);
        }
        if (this.images != null && this.images.length - 1 != this.controller.getMaxBars()) {
            for (n = 0; n < this.images.length; ++n) {
                if (this.images[n] == null) continue;
                this.getEALManager().destroy(this.images[n]);
            }
            this.images = null;
        }
        if (this.images == null) {
            n = this.controller.getMaxBars();
            int n2 = n + 1;
            this.images = new IWrappedNode3DImage[n2];
            float f2 = this.controller.getBarOffset()[1];
            float f3 = this.controller.getBarOffset()[0];
            for (int i2 = 0; i2 < n; ++i2) {
                switch (n) {
                    case 6: {
                        this.images[i2] = this.getEALManager().createImage3D(this.rootNode, EALManager.createNodeName("AdBlueLevelBar6", i2, (AbstractRenderer)this), this.getTextureDescription(1, true), 0, true, (Object)this);
                        break;
                    }
                    case 12: {
                        this.images[i2] = this.getEALManager().createImage3D(this.rootNode, EALManager.createNodeName("AdBlueLevelBar12", i2, (AbstractRenderer)this), this.getTextureDescription(2, true), 0, true, (Object)this);
                        break;
                    }
                    case 10: {
                        if (i2 == 0 || i2 == 9) {
                            this.images[i2] = this.getEALManager().createImage3D(this.rootNode, EALManager.createNodeName("oilLevelBarOverfillUnderfill", i2, (AbstractRenderer)this), this.getTextureDescription(2, true), 0, true, (Object)this);
                            break;
                        }
                        this.images[i2] = this.getEALManager().createImage3D(this.rootNode, EALManager.createNodeName("oilLevelBar", i2, (AbstractRenderer)this), this.getTextureDescription(1, true), 0, true, (Object)this);
                        break;
                    }
                    default: {
                        logChannel.log(10000, "OilLevelRenderer#createNodes No case defined for maxBars = %1.", (long)n);
                    }
                }
                this.images[i2].setPosition(f3, f2, 0.0f);
                f2 += this.images[i2].getHeight();
            }
        }
    }

    private void applyChanges() {
        int n = this.controller.getMaxBars();
        if (this.images == null) {
            return;
        }
        for (int i2 = 1; i2 <= n; ++i2) {
            if (this.controller.getBarCount() < i2 || this.controller.getBarCount() == -1) {
                this.images[n - i2].setVisible(false);
                continue;
            }
            this.images[n - i2].setVisible(true);
        }
    }

    public void render(RedrawContext redrawContext) {
        if (!this.dirty) {
            return;
        }
        if (!this.controller.isVisible() || !this.controller.isOnScreen()) {
            if (this.rootNode != null) {
                this.rootNode.setVisible(false);
            }
            return;
        }
        RedrawContextHigh redrawContextHigh = (RedrawContextHigh)redrawContext;
        this.createNodes(redrawContextHigh);
        if (this.rootNode != null && this.rootNode.isValid()) {
            this.rootNode.setPosition(this.controller.getX(), this.controller.getY(), 0.0f);
            this.applyChanges();
            this.rootNode.setVisible(true);
        }
    }

    public AbstractWidgetController getAbstractController() {
        return this.controller;
    }

    public void disconnect() {
        super.disconnect();
        if (this.images != null) {
            for (int i2 = 0; i2 < this.images.length; ++i2) {
                if (this.images[i2] == null) continue;
                this.getEALManager().destroy(this.images[i2]);
            }
            this.images = null;
        }
        if (this.frame != null) {
            this.getEALManager().destroy(this.frame);
            this.frame = null;
        }
        if (this.rootNode != null) {
            this.getEALManager().destroy(this.rootNode);
            this.rootNode = null;
        }
    }
}

