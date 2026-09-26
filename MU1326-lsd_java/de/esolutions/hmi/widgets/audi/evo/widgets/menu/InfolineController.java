/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.menu;

import de.audi.atip.hmi.model.ChoiceModel;
import de.audi.atip.hmi.model.HMIModel;
import de.esolutions.hmi.widgets.audi.base.PreferredDynamicHeight;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.IInfoLineRenderer;

public class InfolineController
extends AbstractWidgetController
implements PreferredDynamicHeight {
    private IInfoLineRenderer renderer;
    private String text;

    @Override
    public IRenderer getRenderer() {
        return this.renderer;
    }

    public void setRenderer(IInfoLineRenderer iInfoLineRenderer) {
        this.renderer = iInfoLineRenderer;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String string) {
        this.text = string;
        this.setCompositesDirty(true);
    }

    public boolean isShownOnSmallStage() {
        return this.terminal.getViewSizeManager().getPreferredViewSize() == 1;
    }

    public boolean hasText() {
        return this.text != null;
    }

    @Override
    public int getPreferredHeight() {
        return this.getPreferredHeight(this.getWidth());
    }

    @Override
    public int getPreferredHeight(int n) {
        if (this.preferredHeight == -1 && this.renderer != null) {
            return this.renderer.getPreferredHeight(n);
        }
        return super.getPreferredHeight();
    }

    @Override
    public boolean isHeightDependentFromWidth() {
        return this.renderer != null && this.renderer.getAutoWrap() != -1;
    }

    public IInfoLineRenderer getInfolineRenderer() {
        return this.renderer;
    }

    public boolean isSettingsInfoline() {
        HMIModel hMIModel = framework.getHMIService().getModel(138);
        return hMIModel instanceof ChoiceModel && ((ChoiceModel)hMIModel).getValue() == 9;
    }
}

