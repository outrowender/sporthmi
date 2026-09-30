/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.esolutions.hmi.widgets.audi.base.RedrawContext;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.eal.TextureDescription;
import de.esolutions.hmi.widgets.audi.evo.high.RedrawContextHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.IconRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.widgets.DiagnosisController;

public class DiagnosisRenderer
extends IconRendererHigh {
    private int m_color = -1;

    public DiagnosisRenderer(DiagnosisController diagnosisController) {
        super(diagnosisController);
        this.disableAllFormsOfCaching = true;
        this.setScaleMode(2);
    }

    public void render(RedrawContext redrawContext) {
        if (this.dirty) {
            if (!this.controller.shouldRender()) {
                if (this.node != null && this.node.isValid()) {
                    this.node.setVisible(false);
                }
            } else {
                RedrawContextHigh redrawContextHigh = (RedrawContextHigh)redrawContext;
                this.setDataChanges(redrawContextHigh);
                if (this.node != null && this.node.isValid()) {
                    this.getEALManager().moveToParent(this.node, redrawContextHigh.parentNode);
                    this.applyProperties(redrawContextHigh);
                }
            }
        }
    }

    private void setDataChanges(RedrawContextHigh redrawContextHigh) {
        boolean bl;
        TextureDescription textureDescription = this.calculateDisplayData(this.controller.getContent());
        int n = ((DiagnosisController)this.controller).getColor();
        boolean bl2 = !this.equalDisplayData(this.displayData, textureDescription);
        boolean bl3 = bl = this.m_color != n;
        if (bl2) {
            this.destroyNode();
            this.displayData = textureDescription;
            this.renderNode(redrawContextHigh);
            this.m_color = n;
        } else if (bl) {
            this.m_color = n;
        }
    }

    protected void applyProperties(RedrawContextHigh redrawContextHigh) {
        float[] fArray = this.calculateScaling(this.controller.getWidth(), this.controller.getHeight(), this.node.getUnscaledWidth(), this.node.getUnscaledHeight());
        this.node.setPosition(0.0f, 0.0f, 0.0f);
        this.node.setScale(fArray[0], fArray[1], 1.0f);
        this.node.setOpacity(this.controller.getRenderOpacity());
        int n = EALManager.createColorCode(this.m_color);
        this.node.setModulateColor(n);
        this.node.setVisible(true);
    }
}

