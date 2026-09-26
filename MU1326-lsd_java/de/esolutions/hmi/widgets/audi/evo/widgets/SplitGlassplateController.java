/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import java.util.List;

public class SplitGlassplateController
extends AbstractWidgetController {
    private IRenderer renderer;
    private int separatorPosition;
    private boolean verticalLineVisible = false;
    private int screenHeight;

    @Override
    public void connected(InitializationContext initializationContext) {
        super.connected(initializationContext);
        this.terminal.getWidgetRegistry().setParkingDisclaimerHandler(this.getDisclaimer());
        this.screenHeight = this.terminal.getLayout().getDistance(2);
    }

    @Override
    public void disconnecting() {
        this.terminal.getWidgetRegistry().setParkingDisclaimerHandler(null);
        super.disconnecting();
    }

    public void setRenderer(IRenderer iRenderer) {
        this.renderer = iRenderer;
    }

    @Override
    public IRenderer getRenderer() {
        return this.renderer;
    }

    public int getSeparatorPosition() {
        return this.separatorPosition;
    }

    public void setSeparatorPosition(int n) {
        this.separatorPosition = n;
    }

    public void setVerticalLineVisible(boolean bl) {
        this.verticalLineVisible = bl;
    }

    public boolean isVerticalLineVisible() {
        return this.verticalLineVisible;
    }

    public AbstractWidgetController getDisclaimer() {
        List list = this.getChildren();
        return (AbstractWidgetController)(list == null || list.isEmpty() ? null : list.get(0));
    }

    public void enableDisclaimer(boolean bl) {
        AbstractWidgetController abstractWidgetController = this.getDisclaimer();
        if (abstractWidgetController != null) {
            abstractWidgetController.setVisible(bl);
        }
    }

    public boolean isDisclaimerEnabled() {
        AbstractWidgetController abstractWidgetController = this.getDisclaimer();
        return abstractWidgetController != null ? abstractWidgetController.isVisible() : false;
    }

    public int getScreenHeight() {
        return this.screenHeight;
    }
}

