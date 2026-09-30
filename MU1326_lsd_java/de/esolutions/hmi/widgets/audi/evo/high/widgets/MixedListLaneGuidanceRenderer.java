/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.high.RedrawContextHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.AbstractKanziTemplateRenderer;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.MixedListLaneGuidanceController;

public class MixedListLaneGuidanceRenderer
extends AbstractKanziTemplateRenderer {
    private static final String EAL_NODE_NAME = "mixedListLaneGuidance";
    private static final String PREFAB_NAME = "Prefabs/LaneAssistBox_prefab";
    private static final String PROPERTY_LANE_COUNT = "lab_laneCount";
    private static final String[] PROPERTY_LANE_LANE_COUNT = MixedListLaneGuidanceRenderer.initLaneCountPropertyNames();
    private static final String[] PROPERTY_LANE_BACKGROUND = MixedListLaneGuidanceRenderer.initLaneBackgroundPropertyNames();
    private static final String[][] PROPERTY_LANE_ATLAS_INDEX = MixedListLaneGuidanceRenderer.initLaneAtlasIndexPropertyNames();
    private static final String[][] PROPERTY_LANE_COLOR = MixedListLaneGuidanceRenderer.initLaneColorPropertyNames();
    private static final int COL_GRAY = -10197916;
    private static final int COL_BLUE = -10835226;
    private int ealCol1;
    private int ealCol2;
    private boolean colorsInitialized;
    private MixedListLaneGuidanceController controller;

    public MixedListLaneGuidanceRenderer(MixedListLaneGuidanceController mixedListLaneGuidanceController) {
        this.controller = mixedListLaneGuidanceController;
    }

    protected void applyProperties(RedrawContextHigh redrawContextHigh) {
        if (!this.colorsInitialized) {
            this.ealCol1 = EALManager.createColorCode(-10197916);
            this.ealCol2 = EALManager.createColorCode(-10835226);
            this.colorsInitialized = true;
        }
        int n = this.controller.getX();
        int n2 = this.controller.getY();
        this.node.setPosition(n, n2, 0.0f);
        this.node.setVisible(this.controller.shouldRender());
        float f2 = 0.9166667f;
        float f3 = 0.8611111f;
        this.node.setScale(f2, f3, 1.0f);
        this.setProperty(PROPERTY_LANE_COUNT, this.controller.getLaneCount());
        mixedListItemLogCh.log(10000000, "MixedListLaneGuidanceRenderer#applyProperties laneCountr = %1", (long)this.controller.getLaneCount());
        MixedListLaneGuidanceController.LaneData[] laneDataArray = this.controller.getLaneData();
        if (laneDataArray != null) {
            int n3 = Math.min(6, laneDataArray.length);
            if (laneDataArray.length > 6) {
                mixedListItemLogCh.log(10000, "MixedListLaneGuidanceRenderer#applyProperties laneCount is %1", (long)laneDataArray.length);
            }
            for (int i2 = 0; i2 < n3; ++i2) {
                mixedListItemLogCh.log(10000000, "MixedListLaneGuidanceRenderer#applyProperties lane %1", (long)i2);
                MixedListLaneGuidanceController.LaneData laneData = laneDataArray[i2];
                this.setProperty(PROPERTY_LANE_LANE_COUNT[i2], laneData.getArrowCount());
                this.setProperty(PROPERTY_LANE_BACKGROUND[i2], laneData.getBackground());
                int[] nArray = laneData.getAtlasIndex();
                int[] nArray2 = laneData.getColors();
                if (nArray != null && nArray2 != null) {
                    for (int i3 = 0; i3 < nArray.length; ++i3) {
                        this.setProperty(PROPERTY_LANE_ATLAS_INDEX[i2][i3], nArray[i3]);
                        this.setColorProperty(PROPERTY_LANE_COLOR[i2][i3], this.calculateColor(nArray2[i3]));
                        mixedListItemLogCh.log(10000000, "MixedListLaneGuidanceRenderer#applyProperties atlasIndex = %1, color = %2", (long)nArray[i3], (long)nArray2[i3]);
                    }
                    continue;
                }
                mixedListItemLogCh.log(10000000, "MixedListLaneGuidanceRenderer#applyProperties Data is null: atlasIndex = %1, color = %2", (Object)nArray, (Object)nArray2);
            }
        }
    }

    private int calculateColor(int n) {
        return n == 0 ? this.ealCol1 : this.ealCol2;
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

    private static final String[] initLaneCountPropertyNames() {
        String[] stringArray = new String[6];
        for (int i2 = 0; i2 < 6; ++i2) {
            Buffer buffer = new Buffer();
            buffer.append("lane");
            buffer.append(i2 + 1);
            buffer.append("_laneCount");
            stringArray[i2] = buffer.toString();
        }
        return stringArray;
    }

    private static final String[][] initLaneAtlasIndexPropertyNames() {
        String[][] stringArray = new String[6][3];
        for (int i2 = 0; i2 < 6; ++i2) {
            for (int i3 = 0; i3 < 3; ++i3) {
                Buffer buffer = new Buffer();
                buffer.append("lane");
                buffer.append(i2 + 1);
                buffer.append("_");
                buffer.append(i3 + 1);
                buffer.append("_atlasIndex");
                stringArray[i2][i3] = buffer.toString();
            }
        }
        return stringArray;
    }

    private static final String[][] initLaneColorPropertyNames() {
        String[][] stringArray = new String[6][3];
        for (int i2 = 0; i2 < 6; ++i2) {
            for (int i3 = 0; i3 < 3; ++i3) {
                Buffer buffer = new Buffer();
                buffer.append("lane");
                buffer.append(i2 + 1);
                buffer.append("_");
                buffer.append(i3 + 1);
                buffer.append("_color");
                stringArray[i2][i3] = buffer.toString();
            }
        }
        return stringArray;
    }

    private static String[] initLaneBackgroundPropertyNames() {
        String[] stringArray = new String[6];
        for (int i2 = 0; i2 < 6; ++i2) {
            Buffer buffer = new Buffer();
            buffer.append("lane");
            buffer.append(i2 + 1);
            buffer.append("_pocketLane");
            stringArray[i2] = buffer.toString();
        }
        return stringArray;
    }
}

