/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.ui.mib2.grid;

import de.audi.remotehmi.ui.mib2.grid.IGridCell;
import de.audi.remotehmi.ui.mib2.grid.IPorscheGridCell$1;
import de.audi.remotehmi.ui.mib2.grid.IStyleableText;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public interface IPorscheGridCell
extends IGridCell,
IStyleableText {
    public static final int STYLE_PREVIEW;
    public static final int STYLE_HIGHLIGHTED;
    public static final int STYLE_DESCRIPTION;
    public static final int TYPE_SHORTCUT;
    public static final int TYPE_FORMATTED_TEXT;
    public static final int TYPE_LABEL_IMAGE;
    public static final List porscheDescription;
    public static final int COLOR_WHITE;
    public static final int COLOR_GRAY;
    public static final int COLOR_GREEN;
    public static final int COLOR_ORANGE;
    public static final int COLOR_RED;
    public static final int COLOR_DEFAULT;
    public static final Map colors;

    default public List getTokens() {
    }

    default public void setTokens(List list) {
    }

    default public String getSecondLocalLocation() {
    }

    default public void setSecondLocalLocation(String string) {
    }

    default public String getSecondStringValue() {
    }

    default public void setSecondStringValue(String string) {
    }

    default public int getColor() {
    }

    default public void setColor(int n) {
    }

    static {
        porscheDescription = Collections.unmodifiableList(Arrays.asList(new String[]{"shortcut", "formattedText", "labelImage"}));
        colors = new IPorscheGridCell$1();
    }
}

