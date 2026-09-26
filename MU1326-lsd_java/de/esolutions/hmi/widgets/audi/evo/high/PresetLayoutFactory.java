/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high;

import de.eso.widgets.preset.IPresetLayoutFactory;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.AxisConstraints;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.GridLayout;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.GridLayoutHints;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.CompositeRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.LabelRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.widgets.LabelController;
import de.esolutions.hmi.widgets.audi.evo.widgets.LayoutContainerController;

public class PresetLayoutFactory
implements IPresetLayoutFactory {
    @Override
    public LayoutContainerController getNotStorableContainer() {
        LabelController labelController = new LabelController();
        LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
        labelController.setRenderer(labelRendererHigh);
        labelController.setTextIds(new int[]{1141});
        GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
        GridLayout gridLayout = new GridLayout();
        gridLayout.setColumnConstraints(new AxisConstraints(1));
        gridLayout.setRowConstraints(new AxisConstraints(1));
        gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints}, new Object[]{labelController});
        LayoutContainerController layoutContainerController = new LayoutContainerController();
        CompositeRendererHigh compositeRendererHigh = new CompositeRendererHigh(layoutContainerController);
        layoutContainerController.setRenderer(compositeRendererHigh);
        layoutContainerController.setBounds(20, 121, 872, 107);
        layoutContainerController.setLayoutManager(gridLayout);
        layoutContainerController.add(labelController);
        return layoutContainerController;
    }
}

