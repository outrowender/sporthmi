/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.IPresetPopupHeadlineRenderer;

public class PresetPopupHeadlineController
extends AbstractWidgetController {
    private static final int NO_ICON = 99;
    private IPresetPopupHeadlineRenderer presetPopupHeadlineRenderer;
    private float focusedPreset = 0.0f;
    private int cursorColor = -1;
    private int[] presetIcons = new int[]{99, 99, 99, 99, 99, 99, 99, 99};
    private boolean glowActive;
    private String templateNodePath;

    public void setRenderer(IPresetPopupHeadlineRenderer iPresetPopupHeadlineRenderer) {
        this.presetPopupHeadlineRenderer = iPresetPopupHeadlineRenderer;
    }

    public IRenderer getRenderer() {
        return this.presetPopupHeadlineRenderer;
    }

    public void setFocusedPreset(int n, int n2, int n3) {
        this.focusedPreset = n;
        this.cursorColor = n2;
        this.setCompositesDirty(true);
        if (n < 0 || n >= this.presetIcons.length) {
            return;
        }
        this.presetIcons[n] = n3;
    }

    public float getFocusedPreset() {
        return this.focusedPreset;
    }

    public int getFocusedPresetCursorColor() {
        return this.cursorColor;
    }

    public int getPresetIconType(int n) {
        if (n < 0 || n >= this.presetIcons.length) {
            return 99;
        }
        return this.presetIcons[n];
    }

    public void setSavedIconTypes(int[] nArray) {
        if (nArray != null && nArray.length == this.presetIcons.length) {
            this.presetIcons = nArray;
        }
    }

    public void activateGlowOnActivePreset() {
        this.glowActive = true;
    }

    public void deactivateGlowOnActivePreset() {
        this.glowActive = false;
    }

    public boolean isGlowActive() {
        return this.glowActive;
    }

    public String getTemplateNodePath() {
        return this.templateNodePath;
    }

    public void setTemplateNodePath(String string) {
        this.templateNodePath = string;
    }

    public void resetTemplateNode() {
        this.presetPopupHeadlineRenderer.resetTemplateInstanceNode();
    }
}

