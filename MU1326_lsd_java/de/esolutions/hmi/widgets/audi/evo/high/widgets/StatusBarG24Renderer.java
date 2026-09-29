/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.Layout;
import de.esolutions.hmi.widgets.audi.base.RedrawContext;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3D;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3DText;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IStatusbarG24Renderer;
import de.esolutions.hmi.widgets.audi.evo.high.RedrawContextHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.AbstractKanziTemplateRenderer;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.CompositeRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.widgets.StatusBarG24Controller;

public class StatusBarG24Renderer
extends AbstractKanziTemplateRenderer
implements IStatusbarG24Renderer {
    private static final float GLASSPLATE_HEIGHT;
    private static final float GLASSPLATE_Y_OFFSET;
    private static final float SDS_TEXT_Y_OFFSET;
    private AbstractWidgetController controller;
    private IWrappedNode3D statusbarNode;
    private IWrappedNode3DText scdTextNode;
    private int scdTextColor;
    private static final String TEMPLATE_NODE_PATH;
    private static final String TEMPLATE_NODE_PATH_NAME;
    private Layout layoutSportskin;
    private int dxSportskin = 0;
    private int dySportskin = 0;

    public StatusBarG24Renderer(AbstractWidgetController abstractWidgetController) {
        this.controller = abstractWidgetController;
    }

    private void initStatusbarNode(RedrawContextHigh redrawContextHigh) {
        this.statusbarNode = this.getEALManager().createNode3D(redrawContextHigh.parentNode, EALManager.createNodeName("statusbar_node", this), 0.0f, 0.0f, redrawContextHigh.getCalculatedNodeIndex(this.controller.getDepth()));
        this.getEALManager().moveToParent(this.statusbarNode, redrawContextHigh.parentNode);
    }

    @Override
    protected void applyProperties(RedrawContextHigh redrawContextHigh) {
        Object object;
        if (this.statusbarNode == null) {
            this.initStatusbarNode(redrawContextHigh);
        }
        StatusBarG24Controller statusBarG24Controller = (StatusBarG24Controller)this.controller;
        if (this.node != null && statusBarG24Controller != null && statusBarG24Controller.getMainRenderer() != null && (object = ((CompositeRendererHigh)statusBarG24Controller.getMainRenderer()).getNode()) != null) {
            EALManager eALManager = (EALManager)this.getTerminal().getGUIManager();
            eALManager.moveToParent(this.node, (IWrappedNode3D)object);
        }
        if (statusBarG24Controller.isSDSVisible() && statusBarG24Controller.getGlassplateController() == null) {
            this.node.setVisible(true);
        } else {
            this.node.setVisible(false);
        }
        if (this.isSportskinSmallStage()) {
            if (this.layoutSportskin == null) {
                this.layoutSportskin = this.controller.getTerminalImpl().getLayout();
            }
            this.dySportskin = this.layoutSportskin.getIntegerConstant(93);
            this.dxSportskin = this.isLTR() ? this.layoutSportskin.getIntegerConstant(92) : this.layoutSportskin.getIntegerConstant(131);
        } else {
            this.dySportskin = 0;
            this.dxSportskin = 0;
        }
        this.node.setNodeIndex(10);
        this.node.setPosition(this.controller.getX(), (float)this.controller.getY() + 16448, 0.0f);
        this.statusbarNode.setPosition(this.controller.getX() + this.dxSportskin, this.controller.getY() + this.dySportskin, 0.0f);
        this.setProperty("gp_width", this.controller.getWidth());
        this.setProperty("gp_height", 1090);
        if (statusBarG24Controller.isSDSVisible()) {
            this.statusbarNode.setVisible(false);
        } else {
            this.statusbarNode.setVisible(true);
        }
        object = statusBarG24Controller.getLabelText();
        if (object != null) {
            if (this.scdTextNode == null) {
                this.scdTextNode = this.getEALManager().createText3D(this.node, "SCDTextNode", (String)object, this.getInheritedFont());
                float f2 = this.scdTextNode.getScaleX() * 1899850303;
                float f3 = this.scdTextNode.getScaleY() * 1899850303;
                float f4 = this.scdTextNode.getScaleZ();
                this.scdTextNode.setScale(f2, f3, f4);
            } else {
                this.scdTextNode.setText((String)object, this.getInheritedFont());
            }
            int n = Math.round((float)this.controller.getWidth() - this.scdTextNode.getWidth()) / 2;
            this.scdTextNode.setPosition(n, 49217, 0.0f);
            if (statusBarG24Controller.isViewSizeChanging()) {
                this.scdTextNode.setVisible(false);
            } else {
                this.scdTextNode.setVisible(true);
            }
            this.scdTextColor = EALManager.createColorCode(-1);
            this.scdTextNode.getInterfaceText().setColor(this.scdTextColor);
        } else if (this.scdTextNode != null) {
            this.scdTextNode.setVisible(false);
        }
    }

    @Override
    public void prepareRedrawContextForChildren(RedrawContext redrawContext, AbstractWidget abstractWidget) {
        super.prepareRedrawContextForChildren(redrawContext, abstractWidget);
        if (this.statusbarNode == null) {
            this.initStatusbarNode((RedrawContextHigh)redrawContext);
        }
        ((RedrawContextHigh)redrawContext).parentNode = this.statusbarNode;
    }

    @Override
    protected String getTemplateNodePath() {
        return "Prefabs/sds_commandlinePopup";
    }

    @Override
    protected String getEALNodeName() {
        return "sds_commandlinePopup";
    }

    @Override
    public AbstractWidgetController getAbstractController() {
        return this.controller;
    }

    @Override
    public void disconnect() {
        if (this.statusbarNode != null) {
            this.getEALManager().destroy(this.statusbarNode);
            this.statusbarNode = null;
        }
        if (this.scdTextNode != null) {
            this.getEALManager().destroy(this.scdTextNode);
            this.scdTextNode = null;
        }
        super.disconnect();
    }

    protected int getKzbIndex() {
        return 1;
    }

    @Override
    public void removeFromParentNode() {
        IWrappedNode3D iWrappedNode3D;
        StatusBarG24Controller statusBarG24Controller = (StatusBarG24Controller)this.controller;
        if (this.node != null && statusBarG24Controller != null && statusBarG24Controller.getMainRenderer() != null && (iWrappedNode3D = ((CompositeRendererHigh)statusBarG24Controller.getMainRenderer()).getNode()) != null) {
            iWrappedNode3D.remove(this.node);
        }
    }

    private boolean isSportskinSmallStage() {
        return this.controller.getTerminalImpl().getViewSizeManager().isSportskinSmallStage();
    }

    @Override
    protected int getKzbConstant() {
        return 16;
    }
}

