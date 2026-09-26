/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.audi.atip.hmi.view.AnimationListener;
import de.esolutions.graphics.eal.api.IMaterial;
import de.esolutions.graphics.eal.api.IProperty;
import de.esolutions.graphics.eal.api.ITextureShared;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.RedrawContext;
import de.esolutions.hmi.widgets.audi.base.animation.AbstractAnimation;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3DImage;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedTexture;
import de.esolutions.hmi.widgets.audi.base.eal.TextureDescription;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.high.RedrawContextHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.AbstractRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.widgets.ISharedTextureRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.SharedTextureController;
import java.nio.ByteBuffer;

public class SharedTextureRendererHigh
extends AbstractRendererHigh
implements AnimationListener,
ISharedTextureRenderer {
    protected final SharedTextureController controller;
    private IWrappedNode3DImage node;
    private IWrappedTexture sharedTexture;
    private boolean connected;
    private AbstractAnimation updateAnimation;
    private static IMaterial alphaMaskMaterial;

    public SharedTextureRendererHigh(SharedTextureController sharedTextureController) {
        this.controller = sharedTextureController;
    }

    @Override
    public void connect(InitializationContext initializationContext) {
        logWidgetSharedTexture.log(-2137614336, "SharedTextureRendererHigh#connect");
        super.connect(initializationContext);
        this.connected = true;
    }

    private void startUpdateAnimation() {
        if (!this.connected) {
            return;
        }
        if (this.updateAnimation == null) {
            this.updateAnimation = (AbstractAnimation)this.getTerminal().getIAnimationController().getIAnimation(1);
            this.updateAnimation.addListener(this);
            this.updateAnimation.setBlockRepaint(false);
        }
        if (!this.updateAnimation.isAnimating()) {
            this.updateAnimation.startEndlessAnimation(this.controller.getUpdateInterval(), this.controller);
        }
    }

    private void stopUpdateAnimation() {
        if (!this.connected) {
            return;
        }
        if (this.updateAnimation != null && this.updateAnimation.isAnimating()) {
            this.updateAnimation.stopAnimation();
        }
        this.updateAnimation = null;
    }

    @Override
    public void setVisible(boolean bl) {
        if (this.controller.getUpdateMode() == 2) {
            if (bl) {
                this.updateSharedTexture();
                this.startUpdateAnimation();
            } else {
                this.stopUpdateAnimation();
            }
        }
    }

    private void setupAlphaMask() {
        if (alphaMaskMaterial == null) {
            alphaMaskMaterial = this.getEALManager().createMaterial("Prefabs/MaterialLibrary", "Materials/AlphaMask/AlphaMask", 10, -1);
        }
        if (alphaMaskMaterial == null || !alphaMaskMaterial.isValid()) {
            logWidgetSharedTexture.log(10000, "SharedTextureRendererHigh#setupAlphaMask: AlphaMask material not valid");
            return;
        }
        TextureDescription textureDescription = this.getTextureDescription(0, false);
        if (textureDescription == null) {
            logWidgetSharedTexture.log(10000, "SharedTextureRendererHigh#setupAlphaMask: could not get texture description");
            return;
        }
        IWrappedTexture iWrappedTexture = textureDescription.getTexture(this);
        if (iWrappedTexture == null) {
            logWidgetSharedTexture.log(10000, "SharedTextureRendererHigh#setupAlphaMask: could not load mask texture");
            return;
        }
        boolean bl = this.node.getImageNode().setMaterial(alphaMaskMaterial);
        if (!bl) {
            logWidgetSharedTexture.log(10000, "SharedTextureRendererHigh#setupAlphaMask: could not set alpha mask material to imagenode");
            iWrappedTexture.releaseTexture(true, this);
            return;
        }
        IProperty iProperty = alphaMaskMaterial.getProperty("tex_AlphaMask");
        if (!iProperty.isValid()) {
            logWidgetSharedTexture.log(10000, "SharedTextureRendererHigh#setupAlphaMask: could not get MaskTexture Property");
            iProperty.dispose();
            iWrappedTexture.releaseTexture(true, this);
            return;
        }
        bl = iProperty.set(iWrappedTexture.getTexture());
        if (!bl) {
            logWidgetSharedTexture.log(10000, "SharedTextureRendererHigh#setupAlphaMask: could not set texture to alpha mask material");
            iProperty.dispose();
            iWrappedTexture.releaseTexture(true, this);
            return;
        }
        iProperty.dispose();
    }

    @Override
    public void render(RedrawContext redrawContext) {
        if (!this.dirty) {
            return;
        }
        if (!this.controller.shouldRender()) {
            if (this.node != null) {
                this.node.setVisible(false);
            }
            return;
        }
        RedrawContextHigh redrawContextHigh = (RedrawContextHigh)redrawContext;
        if (this.node == null) {
            logWidgetSharedTexture.log(-2137614336, "SharedTextureRendererHigh#render creating node for first time");
            if (this.getTerminal().getFramework().isSimulator()) {
                ByteBuffer byteBuffer = ByteBuffer.allocateDirect(this.controller.getWidth() * this.controller.getHeight() * 4);
                for (int i2 = 0; i2 < this.controller.getHeight(); ++i2) {
                    for (int i3 = 0; i3 < this.controller.getWidth(); ++i3) {
                        byte by = -112;
                        if (i2 % 16 - 7 > 0) {
                            if (i3 % 16 - 7 > 0) {
                                by = 112;
                            }
                        } else if (i3 % 16 - 7 <= 0) {
                            by = 112;
                        }
                        byteBuffer.put(by);
                        byteBuffer.put(by);
                        byteBuffer.put(by);
                        byteBuffer.put((byte)-1);
                    }
                }
                byteBuffer.rewind();
                TextureDescription textureDescription = this.getEALManager().createTextureDescription(byteBuffer, 6, this.controller.getWidth(), this.controller.getHeight(), null, null);
                this.node = this.getEALManager().createImage3D(redrawContextHigh.parentNode, EALManager.createNodeName("sharedTextureNodeSim", this), textureDescription, 0, true, (Object)this);
            } else {
                TextureDescription textureDescription = this.getEALManager().createTextureDescription(EALManager.createNodeName("sharedTexture", this), this.controller.getWidth(), this.controller.getHeight());
                this.sharedTexture = textureDescription.getTexture(this);
                if (this.sharedTexture != null) {
                    int n = redrawContext.getCalculatedNodeIndex(this.controller.getDepth());
                    this.node = this.getEALManager().createImage3D(redrawContextHigh.parentNode, EALManager.createNodeName("sharedTextureNode", this), this.sharedTexture, n, true, (Object)this);
                    this.updateSharedTexture();
                    if (this.controller.getUpdateMode() == 2) {
                        this.startUpdateAnimation();
                    }
                }
            }
            if (this.controller.hasBitmap(0)) {
                this.setupAlphaMask();
            }
        }
        this.applyProperties(redrawContextHigh);
    }

    @Override
    public void updateSharedTexture() {
        if (this.sharedTexture != null) {
            if (logWidgetSharedTexture.isDebug()) {
                logWidgetSharedTexture.log(-2137614336, "SharedTextureRendererHigh#updateSharedTexture, using capture rect: %1, displayableID %2", this.controller.useCaptureRect(), (long)this.controller.getDisplayableID());
            }
            ITextureShared iTextureShared = (ITextureShared)this.sharedTexture.getTexture();
            if (this.controller.useCaptureRect()) {
                int[] nArray = this.controller.getCaptureRect();
                iTextureShared.updateFromDisplayable(this.controller.getDisplayableID(), nArray[0], nArray[1], nArray[2], nArray[3]);
            } else {
                iTextureShared.updateFromDisplayable(this.controller.getDisplayableID());
            }
            this.controller.setCompositesDirty(true);
            if (this.node != null) {
                this.node.invalidateObject();
            } else {
                logWidgetSharedTexture.log(-2137614336, "SharedTextureRendererHigh#updateSharedTexture, node is null -> cannot invalidate partial rendering");
            }
        }
    }

    protected void destroyNode() {
        logWidgetSharedTexture.log(-2137614336, "SharedTextureRendererHigh#destroyNode");
        EALManager eALManager = this.getEALManager();
        if (eALManager != null) {
            eALManager.destroy(this.node);
        }
        this.node = null;
        this.sharedTexture = null;
    }

    protected void applyProperties(RedrawContextHigh redrawContextHigh) {
        if (this.node == null || !this.node.isValid()) {
            logWidgetSharedTexture.log(10000, "SharedTextureRendererHigh#applyProperties: node is invalid");
            return;
        }
        this.node.setPosition(this.controller.getX(), this.controller.getY(), 0.0f);
        this.node.setOpacity(this.controller.getRenderOpacity());
        this.node.setVisible(true);
        this.applyMirrorStatus(this.node);
    }

    @Override
    public void disconnect() {
        this.stopUpdateAnimation();
        this.connected = false;
        this.destroyNode();
        super.disconnect();
    }

    @Override
    public AbstractWidgetController getAbstractController() {
        return this.controller;
    }

    @Override
    public void animate(int n, float f2, int n2) {
        this.updateSharedTexture();
    }

    @Override
    public void animationStarted(int n, int n2) {
    }

    @Override
    public void animationFinished(int n, int n2) {
    }

    @Override
    public void setHMIBackgroundOpaque(boolean bl) {
        this.getEALManager().setClearMethod(bl ? 2 : 0);
    }
}

