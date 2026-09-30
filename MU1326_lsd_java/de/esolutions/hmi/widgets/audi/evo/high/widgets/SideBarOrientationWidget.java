/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.modelaccess.ChoiceModelGUI;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.CompositeRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.IconRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.widgets.CompositeRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.IconController;
import de.esolutions.hmi.widgets.audi.evo.widgets.LabelController;
import de.esolutions.hmi.widgets.audi.evo.widgets.LayoutContainerController;

public class SideBarOrientationWidget
extends AbstractWidgetController {
    private LayoutContainerController intermediateRotationNode;
    private IconController compassIcon;
    private LabelController northLabel;
    private CompositeRenderer renderer;
    private int orientation;
    private boolean isSetUp = false;

    public void add(AbstractWidget abstractWidget) {
        abstractWidget.setChainedAction(3, 17);
        if (abstractWidget instanceof IconController) {
            if (this.intermediateRotationNode == null) {
                this.intermediateRotationNode = new LayoutContainerController();
                CompositeRendererHigh compositeRendererHigh = new CompositeRendererHigh(this.intermediateRotationNode);
                this.intermediateRotationNode.setRenderer(compositeRendererHigh);
                this.add(this.intermediateRotationNode);
                this.intermediateRotationNode.add(abstractWidget);
                this.compassIcon = (IconController)abstractWidget;
                this.intermediateRotationNode.setBounds(abstractWidget.getX(), abstractWidget.getY(), 0, 0);
            } else {
                sideBarLogChannel.log(100000, "SideBarOrientationWidget#add Compass icon was already added to the widget.");
            }
        } else {
            if (abstractWidget instanceof LabelController) {
                this.northLabel = (LabelController)abstractWidget;
            }
            super.add(abstractWidget);
        }
    }

    public void connected(InitializationContext initializationContext) {
        super.connected(initializationContext);
        if (!this.isSetUp) {
            int n = this.compassIcon.getPreferredWidth();
            int n2 = this.compassIcon.getPreferredHeight();
            int n3 = n / 2;
            int n4 = n2 / 2;
            this.compassIcon.setBounds(-n3, -n4, 0, 0);
            this.intermediateRotationNode.setX(this.intermediateRotationNode.getX() + n3);
            this.intermediateRotationNode.setY(this.intermediateRotationNode.getY() + n4);
            float f2 = 0.5f * (float)(n % 2);
            float f3 = 0.5f * (float)(n2 % 2);
            IconRendererHigh iconRendererHigh = (IconRendererHigh)this.compassIcon.getRenderer();
            iconRendererHigh.setFloatingPointOffset(-f2, -f3);
            CompositeRendererHigh compositeRendererHigh = (CompositeRendererHigh)this.intermediateRotationNode.getRenderer();
            compositeRendererHigh.setFloatingPointOffset(f2, f3);
            this.isSetUp = true;
        }
        this.updateValue();
    }

    public int getPreferredWidth() {
        int n = Math.min(this.intermediateRotationNode.getX(), this.northLabel.getX());
        int n2 = Math.max(this.intermediateRotationNode.getX() + this.intermediateRotationNode.getPreferredWidth(), this.northLabel.getX() + this.northLabel.getPreferredWidth());
        return n2 - n;
    }

    public int getPreferredHeight() {
        int n = Math.min(this.intermediateRotationNode.getY(), this.northLabel.getY());
        int n2 = Math.max(this.intermediateRotationNode.getY() + this.intermediateRotationNode.getPreferredHeight(), this.northLabel.getY() + this.northLabel.getPreferredHeight());
        return n2 - n;
    }

    public IRenderer getRenderer() {
        return this.renderer;
    }

    public void processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
        this.updateValue();
    }

    public void setRenderer(CompositeRenderer compositeRenderer) {
        this.renderer = compositeRenderer;
    }

    private void updateValue() {
        int n;
        if (this.model instanceof ChoiceModelGUI && this.orientation != (n = ((ChoiceModelGUI)this.model).getValue())) {
            this.orientation = n;
            sideBarLogChannel.log(10000000, "SideBarOrientationWidget#updateValue Orientation changed: orientation = %1", (long)this.orientation);
            ((CompositeRendererHigh)this.intermediateRotationNode.getRenderer()).setRotationZ(this.orientation);
            this.intermediateRotationNode.setCompositesDirty(true);
        }
    }
}

