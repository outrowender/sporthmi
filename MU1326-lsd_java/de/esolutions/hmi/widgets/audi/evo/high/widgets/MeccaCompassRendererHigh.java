/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.esolutions.graphics.eal.api.INode;
import de.esolutions.graphics.eal.api.INode2D;
import de.esolutions.graphics.eal.api.ITexture;
import de.esolutions.hmi.widgets.audi.base.RedrawContext;
import de.esolutions.hmi.widgets.audi.base.eal.EALPropertyCache;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3DImage;
import de.esolutions.hmi.widgets.audi.base.eal.TextureDescription;
import de.esolutions.hmi.widgets.audi.base.eal.TextureDescriptionDummy;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.high.RedrawContextHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.AbstractRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.MeccaCompassController;

public class MeccaCompassRendererHigh
extends AbstractRendererHigh {
    private static final String MECCA_ANGEL;
    private static final String MECCA_CONTROL;
    private static final String MECCA_FBO;
    private final EALPropertyCache propertyCache = new EALPropertyCache();
    private final MeccaCompassController controller;
    private INode2D mekkaControlNode;
    private ITexture textureFBO;
    private IWrappedNode3DImage imageNode;
    private boolean resourcesLoaded = false;

    public MeccaCompassRendererHigh(MeccaCompassController meccaCompassController) {
        this.controller = meccaCompassController;
    }

    @Override
    public void render(RedrawContext redrawContext) {
        RedrawContextHigh redrawContextHigh = (RedrawContextHigh)redrawContext;
        if (this.getAbstractController().shouldRender()) {
            if (!this.resourcesLoaded) {
                this.loadResources(redrawContextHigh);
            }
            if (!this.resourcesLoaded) {
                return;
            }
            this.applyVisibility(true);
            this.applyProperties(redrawContextHigh);
        } else {
            if (!this.resourcesLoaded) {
                return;
            }
            this.applyVisibility(false);
        }
    }

    private void loadResources(RedrawContextHigh redrawContextHigh) {
        Object object;
        this.mekkaControlNode = this.getEALManager().getShortcutNode2D("mekka_controls");
        if (this.mekkaControlNode == null) {
            object = this.getEALManager().mergeProject(11, 0, this.getInitContext().getScreenID());
            if (object == null) {
                logChannel.log(10000, "MeccaCompassRendererHigh#loadResources: no resources for Mecca Controller found");
                return;
            }
            ((INode2D)object).dispose();
            this.mekkaControlNode = this.getEALManager().getShortcutNode2D("mekka_controls");
            if (this.mekkaControlNode == null) {
                logChannel.log(10000, "MeccaCompassRendererHigh#loadResources: no resources for Mecca Controller found");
                return;
            }
        }
        if (this.imageNode == null) {
            if (this.textureFBO == null) {
                this.textureFBO = this.getEALManager().getShortcutTexture("mekka_FBO");
            }
            if (this.textureFBO != null) {
                object = new TextureDescriptionDummy(this.textureFBO, this.getEALManager());
                this.imageNode = this.getEALManager().createImage3D(redrawContextHigh.parentNode, "MECCA_FBO", (TextureDescription)object, 0, false, (Object)this);
            }
        }
        this.resourcesLoaded = true;
    }

    protected void applyProperties(RedrawContextHigh redrawContextHigh) {
        float f2 = this.controller.getMeccaAngle();
        if (this.imageNode != null) {
            this.imageNode.setPosition(this.controller.getX(), this.controller.getY(), 0.0f);
        }
        this.propertyCache.setProperty((INode)this.mekkaControlNode, "mc_angle", f2);
        this.invalidatePartialRendering();
    }

    protected void applyVisibility(boolean bl) {
        if (this.mekkaControlNode != null) {
            this.mekkaControlNode.setVisible(bl);
        }
    }

    public void invalidatePartialRendering() {
        if (this.mekkaControlNode != null) {
            this.mekkaControlNode.invalidateObject();
        }
        if (this.imageNode != null) {
            this.imageNode.invalidateObject();
        }
    }

    private void destroyNodes() {
        this.propertyCache.clearAll();
        if (this.imageNode != null) {
            this.getEALManager().destroy(this.imageNode);
            this.imageNode = null;
        }
        if (this.textureFBO != null) {
            this.textureFBO.dispose();
            this.textureFBO = null;
        }
        if (this.mekkaControlNode != null) {
            this.mekkaControlNode.dispose();
            this.mekkaControlNode = null;
        }
        this.resourcesLoaded = false;
    }

    @Override
    public void disconnect() {
        this.destroyNodes();
        super.disconnect();
    }

    @Override
    public AbstractWidgetController getAbstractController() {
        return this.controller;
    }

    public int getPreferredWidth() {
        return 0;
    }

    public int getPreferredHeight() {
        return 0;
    }
}

