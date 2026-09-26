/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.audi.atip.util.Util;
import de.esolutions.hmi.widgets.audi.base.RedrawContext;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3D;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3DImage;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedTexture;
import de.esolutions.hmi.widgets.audi.base.eal.TextureDescription;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.high.RedrawContextHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.AbstractRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.AirSuspensionController;
import de.esolutions.hmi.widgets.audi.evo.widgets.IAirSuspensionRenderer;

public class AirSuspensionRendererHigh
extends AbstractRendererHigh
implements IAirSuspensionRenderer {
    private final AirSuspensionController controller;
    private IWrappedNode3D rootNode;
    private IWrappedNode3DImage[] placeholder;
    private IWrappedNode3DImage[] level;
    private IWrappedNode3DImage target;
    private TextureDescription cachedTextureDescription;
    private int cachedWidth;
    private static final int BAR_OFFSET;
    private static final int TOTAL_BARGROUP_HEIGHT;

    public AirSuspensionRendererHigh(AirSuspensionController airSuspensionController) {
        this.controller = airSuspensionController;
    }

    private void createNodes(RedrawContextHigh redrawContextHigh) {
        if (this.rootNode == null) {
            this.rootNode = this.getEALManager().createNode3D(redrawContextHigh.parentNode, "airSuspensionRootNode", this.controller.getWidth(), this.controller.getHeight());
        }
        if (this.placeholder == null) {
            this.placeholder = new IWrappedNode3DImage[5];
            this.level = new IWrappedNode3DImage[5];
            for (int i2 = 4; i2 >= 0; --i2) {
                this.placeholder[i2] = this.getEALManager().createImage3D(this.rootNode, "airSuspensionBarInactive", this.getTextureDescription(0, true), 0, true, (Object)this);
                this.placeholder[i2].setPosition(0.0f, 49 - 11 * i2, 0.0f);
                this.level[i2] = this.getEALManager().createImage3D(this.rootNode, "airSuspensionBarActive", this.getTextureDescription(1, true), 0, true, (Object)this);
                this.level[i2].setPosition(0.0f, 49 - 11 * i2, 0.0f);
                this.level[i2].setVisible(false);
            }
        }
    }

    private void applyChanges() {
        int n;
        if (this.placeholder == null) {
            return;
        }
        for (n = 0; n <= 4; ++n) {
            int n2 = this.controller.getCurrentLevel() - 1;
            boolean bl = this.controller.getActivityState() == 1;
            boolean bl2 = this.controller.getBlinkStatus() == 1;
            boolean bl3 = this.controller.getTargetLevel() - 1 > n2;
            this.level[n].setVisible(n <= n2);
            if (bl3 && n2 + 1 < 5 && bl) {
                this.level[n2 + 1].setVisible(bl && !bl2);
            }
            if (bl3 || n2 >= 5 || !bl) continue;
            this.level[n2].setVisible(bl && !bl2);
        }
        if (this.controller.getActivityState() == 1 && this.controller.getCurrentLevel() > 0) {
            TextureDescription textureDescription;
            if (this.target == null && (textureDescription = this.getTextureDescription(2, true)) != null) {
                this.target = this.getEALManager().createImage3D(this.rootNode, "airSuspensionBarInactive", textureDescription, 0, true, (Object)this);
            }
            if ((n = this.controller.getTargetLevel()) > 0 && n < 6) {
                this.target.setPosition(0.0f, 49 - 11 * (n - 1), 0.0f);
                this.target.setVisible(true);
            }
            if (!this.controller.isAnimating()) {
                this.controller.startAnimation();
            }
        } else {
            if (this.controller.isAnimating()) {
                this.controller.stopAnimation();
            }
            if (this.target != null) {
                this.target.setVisible(false);
            }
        }
    }

    @Override
    public void render(RedrawContext redrawContext) {
        if (!this.dirty) {
            return;
        }
        if (!this.controller.isVisible() || !this.controller.isOnScreen()) {
            if (this.controller.isAnimating()) {
                this.controller.stopAnimation();
            }
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

    @Override
    public AbstractWidgetController getAbstractController() {
        return this.controller;
    }

    @Override
    public void disconnect() {
        int n;
        super.disconnect();
        if (this.level != null) {
            for (n = 0; n < this.level.length; ++n) {
                if (this.level[n] == null) continue;
                this.getEALManager().destroy(this.level[n]);
            }
            this.level = null;
        }
        if (this.placeholder != null) {
            for (n = 0; n < this.placeholder.length; ++n) {
                if (this.placeholder[n] == null) continue;
                this.getEALManager().destroy(this.placeholder[n]);
            }
            this.placeholder = null;
        }
        if (this.rootNode != null) {
            this.getEALManager().destroy(this.rootNode);
            this.rootNode = null;
        }
        if (this.target != null) {
            this.getEALManager().destroy(this.target);
            this.target = null;
        }
        if (this.controller.isAnimating()) {
            this.controller.stopAnimation();
        }
        this.resetCachedSize();
    }

    private void resetCachedSize() {
        this.cachedWidth = 0;
        this.cachedTextureDescription = null;
    }

    @Override
    public int getPreferredWidth() {
        this.updateCachedSize();
        return this.cachedWidth;
    }

    private void updateCachedSize() {
        if (!this.controller.hasBitmap(2)) {
            return;
        }
        TextureDescription textureDescription = this.getTextureDescription(2, true);
        if (Util.equals(this.cachedTextureDescription, textureDescription)) {
            return;
        }
        if (textureDescription == null) {
            this.setCachedSize(null, 0);
            return;
        }
        IWrappedTexture iWrappedTexture = textureDescription.getTexture(this);
        if (iWrappedTexture == null) {
            logChannel.log(-1601830656, "AirSuspensionRendererHigh#updateCachedSize: Texture could not be loaded for content: %1", (Object)textureDescription);
            this.setCachedSize(textureDescription, 0);
            return;
        }
        int n = iWrappedTexture.getWidth();
        iWrappedTexture.releaseTexture(true, this);
        this.setCachedSize(textureDescription, n);
    }

    private void setCachedSize(TextureDescription textureDescription, int n) {
        this.cachedTextureDescription = textureDescription;
        this.cachedWidth = n;
    }

    @Override
    public int getPreferredHeight() {
        return 49;
    }
}

