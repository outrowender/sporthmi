/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.eal;

import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.graphics.eal.api.INode2DLink;
import de.esolutions.graphics.eal.api.INode3DScene;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.eal.EALViewportsAndLayers$Helper;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedLayer;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3D;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedTexture;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedViewport;
import de.esolutions.hmi.widgets.audi.base.eal.TextureDescription;
import java.util.ArrayList;
import java.util.List;

public class WrappedViewport
implements IWrappedViewport,
IWidgetLogChannel {
    private static final LogChannel lc = IWidgetLogChannel.logChannel3DEngine;
    private boolean automaticallyCreated;
    private boolean offscreen;
    private EALManager ealManager;
    private INode2DLink link;
    private String name;
    private INode3DScene scene;
    private int width;
    private int height;
    private int index;
    private IWrappedTexture texture;
    private ArrayList layers;
    private boolean forceInvisible;

    public WrappedViewport(INode2DLink iNode2DLink, String string, INode3DScene iNode3DScene, int n, int n2, int n3, EALManager eALManager, boolean bl) {
        this.link = iNode2DLink;
        iNode2DLink.setVisible(false);
        this.name = string;
        this.scene = iNode3DScene;
        this.width = n;
        this.height = n2;
        this.index = n3;
        this.ealManager = eALManager;
        this.automaticallyCreated = bl;
        this.layers = new ArrayList();
    }

    @Override
    public void addLayer(IWrappedLayer iWrappedLayer) {
        logChannel3DEngineLayersAndViewports.log(-2137614336, "WrappedViewport#addLayer %1", (Object)iWrappedLayer);
        if (iWrappedLayer != null) {
            this.layers.add(iWrappedLayer);
            iWrappedLayer.setViewport(this);
            this.setVisible(iWrappedLayer.getNode().isVisible());
        }
    }

    @Override
    public void removeLayer(IWrappedLayer iWrappedLayer) {
        logChannel3DEngineLayersAndViewports.log(-2137614336, "WrappedViewport#removeLayer %1", (Object)iWrappedLayer);
        if (iWrappedLayer != null && this.layers.size() > 0) {
            this.layers.remove(iWrappedLayer);
            iWrappedLayer.setViewport(null);
            this.setVisible(false);
        }
    }

    @Override
    public int getLayerCount() {
        return this.layers.size();
    }

    @Override
    public IWrappedTexture enableOffscreen() {
        return this.enableOffscreen(this.width, this.height);
    }

    @Override
    public IWrappedTexture enableOffscreen(int n, int n2) {
        if (this.texture != null) {
            if (this.offscreen) {
                lc.log(1078071040, "WrappedViewport#enableOffscreen: layer %1 already offscreen", (Object)this.name);
                return this.texture;
            }
            lc.log(1078071040, "WrappedViewport#enableOffscreen: Reenabling offscreen texture for layer %1", (Object)this.name);
            if (this.ealManager.reEnableOffscreen(this)) {
                this.offscreen = true;
                if (EALViewportsAndLayers$Helper.isOnlyOffscreenViewport(this.index)) {
                    this.link.setVisible(true);
                }
                return this.texture;
            }
            lc.log(10000, "WrappedViewport#enableOffscreen: Could not reenable offscreen texture for layer %1", (Object)this.name);
            return null;
        }
        TextureDescription textureDescription = this.ealManager.createTextureDescription(this);
        this.texture = this.ealManager.enableOffscreen(this, textureDescription);
        if (this.texture == null) {
            lc.log(10000, "WrappedViewport#enableOffscreen: Could not create offscreen texture for layer %1", (Object)this.name);
        }
        if (EALViewportsAndLayers$Helper.isOnlyOffscreenViewport(this.index)) {
            this.link.setVisible(true);
        }
        this.offscreen = true;
        return this.texture;
    }

    @Override
    public void disableOffscreen() {
        if (EALViewportsAndLayers$Helper.isOnlyOffscreenViewport(this.index)) {
            this.link.setVisible(false);
        }
        if (!this.offscreen) {
            lc.log(1078071040, "WrappedViewport#enableOffscreen: layer %1 already onscreen", (Object)this.name);
            return;
        }
        lc.log(-2137614336, "WrappedViewport#disableOffscreen: Disposing old offscreen texture for layer %1", (Object)this.name);
        if (this.texture == null) {
            lc.log(-2137614336, "WrappedViewport#disableOffscreen: Offscreen texture for layer %1 was already disabled", (Object)this.name);
            this.offscreen = false;
            return;
        }
        if (this.ealManager.disableOffscreen(this.link)) {
            this.offscreen = false;
        } else {
            lc.log(10000, "WrappedViewport#disableOffscreen: Offscreen texture for layer %1 could not be disabled", (Object)this.name);
        }
    }

    @Override
    public void destroyTexture() {
        if (this.texture == null) {
            lc.log(-2137614336, "WrappedViewport#destroyTexture: Offscreen texture for layer %1 was already destroyed", (Object)this.name);
            return;
        }
        this.ealManager.destroy(this.texture);
        this.texture = null;
    }

    @Override
    public IWrappedTexture getTexture() {
        return this.texture;
    }

    @Override
    public boolean isAutomaticallyCreated() {
        return this.automaticallyCreated;
    }

    @Override
    public INode2DLink getLink() {
        return this.link;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public INode3DScene getScene() {
        return this.scene;
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    @Override
    public int getIndex() {
        return this.index;
    }

    @Override
    public void setVisible(boolean bl) {
        if (!bl && !this.forceInvisible) {
            for (int i2 = 0; i2 < this.layers.size(); ++i2) {
                IWrappedLayer iWrappedLayer = (IWrappedLayer)this.layers.get(i2);
                IWrappedNode3D iWrappedNode3D = iWrappedLayer.getNode();
                if (!iWrappedNode3D.isVisible()) continue;
                bl = true;
                break;
            }
        }
        if (this.link.isVisible() == bl) {
            if (logChannel3DEngineLayersAndViewports.isDebug()) {
                logChannel3DEngineLayersAndViewports.log(-2137614336, "WrappedViewport#setVisible: %2 no visibility change, visible = %1", bl, (Object)this);
            }
            return;
        }
        if (logChannel3DEngineLayersAndViewports.isInfo()) {
            logChannel3DEngineLayersAndViewports.log(1078071040, "WrappedViewport#setVisible: %2 visibility set to %1", bl, (Object)this);
        }
        this.link.setVisible(bl);
    }

    @Override
    public List getLayers() {
        return this.layers;
    }

    public String toString() {
        Buffer buffer = new Buffer(this.name.length() + 10);
        buffer.append("Viewport[").append(this.name).append(']');
        return buffer.toString();
    }

    @Override
    public void setForceInvisible(boolean bl) {
        this.forceInvisible = bl;
    }
}

