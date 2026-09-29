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
import de.esolutions.hmi.widgets.audi.evo.high.widgets.MixedListLaneGuidanceController$LaneData;

public class MixedListLaneGuidanceRenderer
extends AbstractKanziTemplateRenderer {
    private static final String EAL_NODE_NAME;
    private static final String PREFAB_NAME;
    private static final String PROPERTY_LANE_COUNT;
    private static final String[] PROPERTY_LANE_LANE_COUNT;
    private static final String[] PROPERTY_LANE_BACKGROUND;
    private static final String[][] PROPERTY_LANE_ATLAS_INDEX;
    private static final String[][] PROPERTY_LANE_COLOR;
    private static final int COL_GRAY;
    private static final int COL_BLUE;
    private int ealCol1;
    private int ealCol2;
    private boolean colorsInitialized;
    private MixedListLaneGuidanceController controller;

    public MixedListLaneGuidanceRenderer(MixedListLaneGuidanceController mixedListLaneGuidanceController) {
        this.controller = mixedListLaneGuidanceController;
    }

    @Override
    protected void applyProperties(RedrawContextHigh redrawContextHigh) {
        if (!this.colorsInitialized) {
            this.ealCol1 = EALManager.createColorCode(0x646464FF);
            this.ealCol2 = EALManager.createColorCode(-425043201);
            this.colorsInitialized = true;
        }
        int n = this.controller.getX();
        int n2 = this.controller.getY();
        this.node.setPosition(n, n2, 0.0f);
        this.node.setVisible(this.controller.shouldRender());
        int n3 = -1414895041;
        int n4 = -948872129;
        this.node.setScale(n3, n4, 1.0f);
        this.setProperty("lab_laneCount", this.controller.getLaneCount());
        mixedListItemLogCh.log(-2137614336, "MixedListLaneGuidanceRenderer#applyProperties laneCountr = %1", (long)this.controller.getLaneCount());
        MixedListLaneGuidanceController$LaneData[] mixedListLaneGuidanceController$LaneDataArray = this.controller.getLaneData();
        if (mixedListLaneGuidanceController$LaneDataArray != null) {
            int n5 = Math.min(6, mixedListLaneGuidanceController$LaneDataArray.length);
            if (mixedListLaneGuidanceController$LaneDataArray.length > 6) {
                mixedListItemLogCh.log(10000, "MixedListLaneGuidanceRenderer#applyProperties laneCount is %1", (long)mixedListLaneGuidanceController$LaneDataArray.length);
            }
            for (int i2 = 0; i2 < n5; ++i2) {
                mixedListItemLogCh.log(-2137614336, "MixedListLaneGuidanceRenderer#applyProperties lane %1", (long)i2);
                MixedListLaneGuidanceController$LaneData mixedListLaneGuidanceController$LaneData = mixedListLaneGuidanceController$LaneDataArray[i2];
                this.setProperty(PROPERTY_LANE_LANE_COUNT[i2], mixedListLaneGuidanceController$LaneData.getArrowCount());
                this.setProperty(PROPERTY_LANE_BACKGROUND[i2], mixedListLaneGuidanceController$LaneData.getBackground());
                int[] nArray = mixedListLaneGuidanceController$LaneData.getAtlasIndex();
                int[] nArray2 = mixedListLaneGuidanceController$LaneData.getColors();
                if (nArray != null && nArray2 != null) {
                    for (int i3 = 0; i3 < nArray.length; ++i3) {
                        this.setProperty(PROPERTY_LANE_ATLAS_INDEX[i2][i3], nArray[i3]);
                        this.setColorProperty(PROPERTY_LANE_COLOR[i2][i3], this.calculateColor(nArray2[i3]));
                        mixedListItemLogCh.log(-2137614336, "MixedListLaneGuidanceRenderer#applyProperties atlasIndex = %1, color = %2", (long)nArray[i3], (long)nArray2[i3]);
                    }
                    continue;
                }
                mixedListItemLogCh.log(-2137614336, "MixedListLaneGuidanceRenderer#applyProperties Data is null: atlasIndex = %1, color = %2", (Object)nArray, (Object)nArray2);
            }
        }
    }

    private int calculateColor(int n) {
        return n == 0 ? this.ealCol1 : this.ealCol2;
    }

    @Override
    protected String getTemplateNodePath() {
        return "Prefabs/LaneAssistBox_prefab";
    }

    @Override
    protected String getEALNodeName() {
        return "mixedListLaneGuidance";
    }

    @Override
    protected int getKzbConstant() {
        return 20;
    }

    @Override
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

    static {
        PROPERTY_LANE_LANE_COUNT = MixedListLaneGuidanceRenderer.initLaneCountPropertyNames();
        PROPERTY_LANE_BACKGROUND = MixedListLaneGuidanceRenderer.initLaneBackgroundPropertyNames();
        PROPERTY_LANE_ATLAS_INDEX = MixedListLaneGuidanceRenderer.initLaneAtlasIndexPropertyNames();
        PROPERTY_LANE_COLOR = MixedListLaneGuidanceRenderer.initLaneColorPropertyNames();
    }
}

