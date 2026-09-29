/*
 * Decompiled with CFR 0.152.
 */
package de.eso.widgets.preset;

import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;

public final class PresetLayoutConfigurator {
    private static final String TEMPLATE_NODE_ALL_IN_TOUCH;
    private static final String TEMPLATE_NODE_HORIZONTAL_SHORT;
    private static final String TEMPLATE_NODE_PATH_VERTICAL_SHORT;
    private static final String TEMPLATE_NODE_PATH_HORIZONTAL_LONG;
    private static String templateNodePath;
    public static final int PRESET_LAYOUT_NO_PRESET;
    public static final int PRESET_LAYOUT_SINGLE_ROW_HORIZONTAL;
    public static final int PRESET_LAYOUT_DOUBLE_ROW_HORIZONTAL;
    public static final int PRESET_LAYOUT_DOUBLE_ROW_VERTICAL;
    private int glassplateHeightTouch;
    private int glassplateHeightLongTouch;
    private int headlineX;
    private int headlineY;
    private int kbdType;
    private int x;
    private int y;
    private int width;

    public void init(int n, int n2) {
        IWidgetLogChannel.logPresetInput.log(1078071040, "PresetLayoutConfigurator#init kbdType: %1, presetlayout %2", (long)n, (long)n2);
        this.kbdType = n;
        int n3 = AbstractWidget.framework.getScreenRes();
        if (n3 == 2) {
            if (n == 6) {
                this.x = 78;
                this.y = 100;
                this.width = 907;
                this.glassplateHeightTouch = 103;
                this.glassplateHeightLongTouch = 234;
                this.headlineX = 0;
                this.headlineY = 0;
                templateNodePath = "Prefabs/sk_allInTouch";
            } else if (n2 == 8) {
                this.x = 214;
                this.y = 100;
                this.width = 770;
                this.glassplateHeightTouch = 103;
                this.glassplateHeightLongTouch = 234;
                this.headlineX = 0;
                this.headlineY = 5;
                templateNodePath = "Prefabs/sk_verticalShort";
            } else {
                this.x = 62;
                this.y = 135;
                this.width = 907;
                this.glassplateHeightTouch = 103;
                this.glassplateHeightLongTouch = 234;
                this.headlineX = 195;
                this.headlineY = 0;
                templateNodePath = "Prefabs/sk_horizontalLong";
            }
        } else if (n3 == 1) {
            if (n2 == 1) {
                this.x = 78;
                this.y = 135;
                this.width = 683;
                this.glassplateHeightTouch = 103;
                this.glassplateHeightLongTouch = 234;
                this.headlineX = 83;
                this.headlineY = 0;
                templateNodePath = "Prefabs/sk_horizontalLong";
            } else if (n2 == 8) {
                this.x = 213;
                this.y = 100;
                this.width = 548;
                this.glassplateHeightTouch = 103;
                this.glassplateHeightLongTouch = 234;
                this.headlineX = 0;
                this.headlineY = 5;
                templateNodePath = "Prefabs/sk_verticalShort";
            } else {
                this.x = 78;
                this.y = 117;
                this.width = 683;
                this.glassplateHeightTouch = 103;
                this.glassplateHeightLongTouch = 234;
                this.headlineX = 161;
                this.headlineY = 0;
                templateNodePath = "Prefabs/sk_horizontalShort";
            }
        } else if (n3 == 0) {
            this.x = 75;
            this.y = 65;
            this.width = 250;
            this.glassplateHeightTouch = 65;
            this.glassplateHeightLongTouch = 130;
            this.headlineX = 35;
            this.headlineY = -10;
            templateNodePath = "Prefabs/sk_horizontalShort";
        }
    }

    public int getGlassplateHeightLongTouch() {
        return this.glassplateHeightLongTouch;
    }

    public int getGlassplateHeightTouch() {
        return this.glassplateHeightTouch;
    }

    public int getHeadlineX() {
        return this.headlineX;
    }

    public int getHeadlineY() {
        return this.headlineY;
    }

    public int getKbdType() {
        return this.kbdType;
    }

    public String getTemplateNodePath() {
        return templateNodePath;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getWidth() {
        return this.width;
    }

    static {
        templateNodePath = "Prefabs/sk_allInTouch";
    }
}

