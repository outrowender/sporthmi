/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets.menu;

import de.esolutions.hmi.widgets.audi.base.AbstractRenderer;
import de.esolutions.hmi.widgets.audi.base.RedrawContext;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3D;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3DText;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.high.RedrawContextHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.AbstractRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.widgets.GlassplateController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.IMenuSDSNumbersRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuSDSNumbersController;

public class MenuSDSNumbersRendererHigh
extends AbstractRendererHigh
implements IMenuSDSNumbersRenderer {
    private static final IWrappedNode3DText[] NODES_EMPTY = new IWrappedNode3DText[0];
    private MenuSDSNumbersController controller;
    private IWrappedNode3D node;
    private IWrappedNode3DText[] numberNodes = NODES_EMPTY;

    public MenuSDSNumbersRendererHigh(MenuSDSNumbersController menuSDSNumbersController) {
        this.controller = menuSDSNumbersController;
    }

    @Override
    public AbstractWidgetController getAbstractController() {
        return this.controller;
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
        this.createNode(redrawContextHigh);
        this.createNumberNodes(redrawContextHigh);
        this.applyProperties(redrawContextHigh);
    }

    private void createNode(RedrawContextHigh redrawContextHigh) {
        if (this.node != null) {
            return;
        }
        this.node = this.getEALManager().createNode3D(redrawContextHigh.parentNode, "SDSNumbersRoot", this.getSdsNumbersWidth(), this.controller.getHeight());
        this.node.setClipping(true);
    }

    private void createNumberNodes(RedrawContextHigh redrawContextHigh) {
        int n = this.controller.getNumbersCount();
        if (this.numberNodes.length < n) {
            IWrappedNode3DText[] iWrappedNode3DTextArray = new IWrappedNode3DText[n];
            System.arraycopy((Object)this.numberNodes, 0, (Object)iWrappedNode3DTextArray, 0, this.numberNodes.length);
            for (int i2 = this.numberNodes.length; i2 < iWrappedNode3DTextArray.length; ++i2) {
                iWrappedNode3DTextArray[i2] = this.createNumberNode(redrawContextHigh, i2 + 1);
            }
            this.numberNodes = iWrappedNode3DTextArray;
        }
    }

    private IWrappedNode3DText createNumberNode(RedrawContextHigh redrawContextHigh, int n) {
        return this.getEALManager().createText3D(this.node, EALManager.createNodeName("sdsNumberText", n, (AbstractRenderer)this), String.valueOf(n), redrawContextHigh.getCurrentFont());
    }

    private void destroyNodes() {
        if (this.getEALManager() != null) {
            for (int i2 = 0; i2 < this.numberNodes.length; ++i2) {
                this.getEALManager().destroy(this.numberNodes[i2]);
            }
            this.getEALManager().destroy(this.node);
        }
        this.node = null;
        this.numberNodes = NODES_EMPTY;
    }

    protected void applyProperties(RedrawContextHigh redrawContextHigh) {
        int n;
        int n2 = this.controller.getNumbersCount();
        this.applyPropertiesOnVisibleNumbers(redrawContextHigh, n2);
        for (n = n2; n < this.numberNodes.length; ++n) {
            if (this.numberNodes[n] == null) continue;
            this.numberNodes[n].setVisible(false);
        }
        this.node.setVisible(true);
        n = this.controller.getX();
        this.node.setPosition(n -= this.getSdsNumbersWidth() / 2, this.controller.getY(), 0.0f);
        this.node.useClippingRectangle(true);
        this.node.setClippingRectangle(0.0f, 0.0f, this.getSdsNumbersWidth(), this.controller.getHeight());
        this.node.setClipping(true);
    }

    private int getSdsNumbersWidth() {
        GlassplateController glassplateController = this.controller.getGlassplate();
        if (glassplateController != null) {
            return glassplateController.getActiveSdsNumbersWidth() - glassplateController.getSdsNumbersGapWidth();
        }
        return 100;
    }

    private void applyPropertiesOnVisibleNumbers(RedrawContextHigh redrawContextHigh, int n) {
        int n2 = 0;
        int n3 = 0;
        for (int i2 = 0; i2 < n; ++i2) {
            int n4;
            this.applyProperties(this.numberNodes[i2], i2, redrawContextHigh);
            boolean bl = this.controller.isSdsNumberEnabled(i2);
            if (bl) {
                n4 = redrawContextHigh.getColor(1);
                n2 = EALManager.createColorCode(n4);
            } else if (!bl) {
                n4 = redrawContextHigh.getColor(2);
                n3 = EALManager.createColorCode(n4);
            }
            n4 = bl ? n2 : n3;
            this.numberNodes[i2].getInterfaceText().setColor(n4);
        }
    }

    private void applyProperties(IWrappedNode3DText iWrappedNode3DText, int n, RedrawContextHigh redrawContextHigh) {
        if (iWrappedNode3DText == null) {
            return;
        }
        if (!iWrappedNode3DText.isValid()) {
            logChannel3DEngine.log(10000, "MenuSDSNumbersRendererHigh#applyProperties: text node is invalid for index: %1", (long)n);
            return;
        }
        int n2 = this.controller.getNumberPositionsY()[n];
        float f2 = ((float)this.getSdsNumbersWidth() - iWrappedNode3DText.getWidth()) / 2.0f;
        iWrappedNode3DText.setPosition(f2, n2, 0.0f);
        iWrappedNode3DText.setVisible(true);
        iWrappedNode3DText.setOpacity(this.controller.getNumbersOpacity() * this.controller.getRenderOpacity());
        int n3 = redrawContextHigh.getColor(this.controller.getCurrentVisState());
        int n4 = EALManager.createColorCode(n3);
        iWrappedNode3DText.getInterfaceText().setColor(n4);
    }

    @Override
    public void disconnect() {
        this.destroyNodes();
        super.disconnect();
    }
}

