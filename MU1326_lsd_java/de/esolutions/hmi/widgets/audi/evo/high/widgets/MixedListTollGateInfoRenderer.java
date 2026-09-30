/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.high.RedrawContextHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.AbstractKanziTemplateRenderer;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.MixedListTollGateInfoController;

public class MixedListTollGateInfoRenderer
extends AbstractKanziTemplateRenderer {
    private static final String EAL_NODE_NAME = "mixedListTollGateInfo";
    private static final String PREFAB_NAME = "Prefabs/ETC_AssistBox_prefab";
    private static final String PROPERTY_LANE_COUNT = "etc_laneCount";
    private static final String[] PROPERTY_ATLAS_INDEX = MixedListTollGateInfoRenderer.initAtlasIndexPropertyNames();
    private MixedListTollGateInfoController controller;

    public MixedListTollGateInfoRenderer(MixedListTollGateInfoController mixedListTollGateInfoController) {
        this.controller = mixedListTollGateInfoController;
    }

    protected void applyProperties(RedrawContextHigh redrawContextHigh) {
        int n = this.controller.getX();
        int n2 = this.controller.getY();
        this.node.setPosition(n, n2, 0.0f);
        this.node.setVisible(this.controller.shouldRender());
        this.setProperty(PROPERTY_LANE_COUNT, this.controller.getLaneCount());
        mixedListItemLogCh.log(10000000, "MixedListLaneGuidanceRenderer#applyProperties laneCountr = %1", (long)this.controller.getLaneCount());
        int[] nArray = this.controller.getAtlasIndex();
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            this.setProperty(PROPERTY_ATLAS_INDEX[i2], nArray[i2]);
        }
    }

    protected String getTemplateNodePath() {
        return PREFAB_NAME;
    }

    protected String getEALNodeName() {
        return EAL_NODE_NAME;
    }

    protected int getKzbConstant() {
        return 20;
    }

    public AbstractWidgetController getAbstractController() {
        return this.controller;
    }

    private static final String[] initAtlasIndexPropertyNames() {
        String[] stringArray = new String[12];
        for (int i2 = 0; i2 < 12; ++i2) {
            Buffer buffer = new Buffer();
            buffer.append("etc_lane");
            buffer.append(i2 + 1);
            buffer.append("_atlasIndex");
            stringArray[i2] = buffer.toString();
        }
        return stringArray;
    }
}

