/*
 * Decompiled with CFR 0.152.
 */
package de.eso.widgets.preset;

import de.audi.atip.hmi.view.Screen;
import de.audi.atip.preset.Preset;
import de.audi.tghu.hmi.evo.IPresetPopupData;
import de.eso.widgets.preset.PresetPopupData;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.evo.ScreenWidgetEVO;

public class PresetProxy
extends AbstractWidgetController {
    private int executionType = 99;

    @Override
    public IPresetPopupData getPresetPopupData() {
        if (this.modelID == -1) {
            return null;
        }
        logPreset.log(1078071040, "PresetProxy#getPresetPopupData PresetProxy is used. model: %1, executionType: %2", (long)this.modelID, (long)this.executionType);
        return new PresetPopupData(0, this.getColor(), new Preset(1, this.modelID, 0, null, null, this.executionType), null, null, -1, null);
    }

    private int getColor() {
        int n = -1;
        Screen screen = this.initContext.getScreen();
        if (screen instanceof ScreenWidgetEVO) {
            ScreenWidgetEVO screenWidgetEVO = (ScreenWidgetEVO)screen;
            n = this.getColor(screenWidgetEVO, n);
        }
        logPreset.log(-2137614336, "PresetProxy#getColor color: %1", (long)n);
        return n;
    }

    private int getColor(ScreenWidgetEVO screenWidgetEVO, int n) {
        int[] nArray;
        int n2 = n;
        if (screenWidgetEVO != null && (nArray = screenWidgetEVO.getColorIndices()) != null && nArray.length > 1) {
            n2 = screenWidgetEVO.getCurrentColorPalette()[nArray[1]];
        }
        return n2;
    }

    public void setExecutionType(int n) {
        this.executionType = n;
    }

    @Override
    public IRenderer getRenderer() {
        return null;
    }
}

