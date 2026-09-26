/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3D;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.high.RedrawContextHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.AbstractKanziTemplateRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.RadioButtonController;
import de.esolutions.hmi.widgets.audi.evo.widgets.RadioButtonRenderer;

public class RadioButtonRendererHigh
extends AbstractKanziTemplateRenderer
implements RadioButtonRenderer {
    private static int PwDiv2M1;
    private static int PhDiv2M1;
    private static final String TEMPLATE_NODE_PATH;
    private static final String EAL_NODE_NAME;
    private final RadioButtonController controller;
    private boolean m_firstFrame = true;
    private IWrappedNode3D m_overlayImage = null;
    private IWrappedNode3D m_imgParentNode = null;

    public RadioButtonRendererHigh(RadioButtonController radioButtonController) {
        this.controller = radioButtonController;
    }

    @Override
    public void connect(InitializationContext initializationContext) {
        super.connect(initializationContext);
        this.m_firstFrame = true;
        PwDiv2M1 = this.getPreferredWidth() / 2 - 1;
        PhDiv2M1 = this.getPreferredHeight() / 2 - 1;
    }

    private void initImageNode(RedrawContextHigh redrawContextHigh) {
        if (this.m_imgParentNode == null) {
            this.m_imgParentNode = this.getEALManager().createNode3D(this.node.getParent(), EALManager.createNodeName("OverlayRotaryImageParent", this), this.getPreferredWidth(), this.getPreferredHeight());
            if (this.m_imgParentNode == null || !this.m_imgParentNode.isValid()) {
                this.getEALManager().destroy(this.m_imgParentNode);
                this.m_imgParentNode = null;
            } else {
                this.m_imgParentNode.setVisible(true);
            }
        }
        if (this.m_imgParentNode != null && this.m_overlayImage == null && this.controller.getBitmapIndices() != null && this.controller.getBitmapIndices().length > 0) {
            this.m_overlayImage = this.getEALManager().createImage3D(this.m_imgParentNode, EALManager.createNodeName("OverlayRotaryImage", this), this.getTextureDescription(0, true), 0, true, (Object)this);
            if (this.m_overlayImage == null || !this.m_overlayImage.isValid()) {
                this.getEALManager().destroy(this.m_overlayImage);
                this.m_overlayImage = null;
            } else {
                this.m_overlayImage.setVisible(true);
                this.m_overlayImage.setPosition(-this.m_overlayImage.getWidth() / 2.0f, -this.m_overlayImage.getHeight() / 2.0f, 0.0f);
            }
        }
    }

    @Override
    protected void applyProperties(RedrawContextHigh redrawContextHigh) {
        if (this.controller != null && this.node != null) {
            this.initImageNode(redrawContextHigh);
            int n = this.controller.getX();
            int n2 = this.controller.getY();
            this.setProperty("itemDisabled", this.controller.getAnimatedDisabled());
            this.setProperty("rb_on", this.controller.getAnimatedSelected());
            this.node.setPosition(n, n2, 0.0f);
            this.node.setOpacity(this.controller.getRenderOpacity());
            if (this.m_firstFrame) {
                this.controller.updateRModelValues(true);
                this.m_firstFrame = false;
            }
            if (this.m_overlayImage != null) {
                int[] nArray = this.controller.getRangeOverlayBounds();
                float f2 = this.getEALManager().isLTR() ? this.controller.getRangeIconRotationValue() : 1.0f - this.controller.getRangeIconRotationValue();
                float f3 = this.wrapValue(nArray[0] + Math.round(f2 * (float)nArray[2]));
                float f4 = 0.0f;
                if (AbstractWidget.framework.getScreenRes() == 0) {
                    f4 = 49215;
                }
                this.m_imgParentNode.setPosition((float)(n + PwDiv2M1) + f4, (float)(n2 + PhDiv2M1) + f4, 0.0f);
                this.m_imgParentNode.setRotationZ(-f3);
                this.m_overlayImage.setOpacity(this.controller.getAnimatedSelected());
            }
        }
    }

    @Override
    public void disconnect() {
        if (this.getEALManager() != null) {
            this.getEALManager().destroy(this.m_overlayImage);
            this.m_overlayImage = null;
            this.getEALManager().destroy(this.m_imgParentNode);
            this.m_imgParentNode = null;
        }
        super.disconnect();
    }

    protected int wrapValue(int n) {
        return n % 360;
    }

    @Override
    protected String getTemplateNodePath() {
        return "Prefabs/radioButton";
    }

    @Override
    protected String getEALNodeName() {
        return "radiobutton";
    }

    @Override
    public AbstractWidgetController getAbstractController() {
        return this.controller;
    }

    @Override
    public int getPreferredWidth() {
        return this.getTerminal().getLayout().getIntegerConstant(126);
    }

    @Override
    public int getPreferredHeight() {
        return this.getTerminal().getLayout().getIntegerConstant(127);
    }

    @Override
    protected int getKzbConstant() {
        return 6;
    }
}

