/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.audi.atip.util.Util;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3DImage;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedTexture;
import de.esolutions.hmi.widgets.audi.base.eal.TextureDescription;
import de.esolutions.hmi.widgets.audi.evo.high.RedrawContextHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.CompositeRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.widgets.TitleBarRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.TitleBarWidget;

public class TitleBarRendererHigh
extends CompositeRendererHigh
implements TitleBarRenderer {
    private IWrappedNode3DImage separatorNode;
    private TextureDescription cachedSeparatorTextureDescription;
    private int separatorWidth;
    private int separatorHeight;

    public TitleBarRendererHigh(TitleBarWidget titleBarWidget) {
        super(titleBarWidget);
    }

    private TitleBarWidget getTitleBar() {
        return (TitleBarWidget)this.controller;
    }

    public int getSeparatorWidth() {
        this.updateSeparatorSize();
        return this.separatorWidth;
    }

    public int getSeparatorHeight() {
        this.updateSeparatorSize();
        return this.separatorHeight;
    }

    private void updateSeparatorSize() {
        TextureDescription textureDescription = this.getTextureDescription(0, true);
        if (Util.equals(this.cachedSeparatorTextureDescription, textureDescription)) {
            return;
        }
        if (textureDescription == null) {
            this.setSeparatorSize(null, 0, 0);
            return;
        }
        IWrappedTexture iWrappedTexture = textureDescription.getTexture(this);
        if (iWrappedTexture == null) {
            logChannel.log(100000, "TitleBarRendererHigh#updateSeparatorSize: Texture could not be loaded for content: %1", (Object)textureDescription);
            this.setSeparatorSize(textureDescription, 0, 0);
            return;
        }
        int n = iWrappedTexture.getWidth();
        int n2 = iWrappedTexture.getHeight();
        iWrappedTexture.releaseTexture(true, this);
        this.setSeparatorSize(textureDescription, n, n2);
    }

    private void setSeparatorSize(TextureDescription textureDescription, int n, int n2) {
        this.cachedSeparatorTextureDescription = textureDescription;
        this.separatorWidth = n;
        this.separatorHeight = n2;
    }

    protected void renderNode(RedrawContextHigh redrawContextHigh) {
        super.renderNode(redrawContextHigh);
        if (this.node != null && this.getTitleBar().hasSeparator()) {
            this.renderSeparatorNode();
        }
    }

    private void renderSeparatorNode() {
        TextureDescription textureDescription = this.getTextureDescription(0, true);
        if (textureDescription != null) {
            this.separatorNode = this.getEALManager().createImage3D(this.node, EALManager.createNodeName("titleBarSeparator", this), textureDescription, 0, true, (Object)this);
        }
    }

    protected void applyProperties(RedrawContextHigh redrawContextHigh) {
        super.applyProperties(redrawContextHigh);
        this.node.setOpacity(this.controller.getRenderOpacity() * this.getTitleBar().getNowPlayingOpacity());
        if (this.separatorNode != null) {
            boolean bl = this.getTitleBar().isSeparatorVisible();
            this.separatorNode.setOpacity((float)bl);
            this.separatorNode.setPosition(this.getTitleBar().getSeparatorX(), this.getTitleBar().getSeparatorY(), 0.0f);
            int n = redrawContextHigh.getColor(this.controller.getCurrentVisState());
            int n2 = EALManager.createColorCode(n);
            this.separatorNode.setModulateColor(n2);
        }
    }

    public void disconnect() {
        super.disconnect();
        this.resetCachedSize();
    }

    private void resetCachedSize() {
        this.separatorWidth = 0;
        this.separatorHeight = 0;
        this.cachedSeparatorTextureDescription = null;
    }

    protected void destroyNode() {
        EALManager eALManager = this.getEALManager();
        if (eALManager != null) {
            this.getEALManager().destroy(this.separatorNode);
        }
        this.separatorNode = null;
        super.destroyNode();
    }

    public IWrappedNode3DImage getSeparatorNode() {
        return this.separatorNode;
    }
}

