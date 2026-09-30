/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.ui.mib2.grid;

import de.audi.remotehmi.ui.mib2.grid.IGridCell;
import de.audi.remotehmi.ui.mib2.grid.IStyleableText;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface IPorscheGridCell
extends IGridCell,
IStyleableText {
    public static final int STYLE_PREVIEW = 3;
    public static final int STYLE_HIGHLIGHTED = 4;
    public static final int STYLE_DESCRIPTION = 5;
    public static final int TYPE_SHORTCUT = 50;
    public static final int TYPE_FORMATTED_TEXT = 51;
    public static final int TYPE_LABEL_IMAGE = 52;
    public static final List porscheDescription = Collections.unmodifiableList(Arrays.asList(new String[]{"shortcut", "formattedText", "labelImage"}));
    public static final int COLOR_WHITE = 0;
    public static final int COLOR_GRAY = 1;
    public static final int COLOR_GREEN = 2;
    public static final int COLOR_ORANGE = 3;
    public static final int COLOR_RED = 4;
    public static final int COLOR_DEFAULT = 0;
    public static final Map colors = new HashMap(){
        private static final long serialVersionUID = 8774891373874452584L;
        {
            this.put("white", new Integer(0));
            this.put("gray", new Integer(1));
            this.put("green", new Integer(2));
            this.put("orange", new Integer(3));
            this.put("red", new Integer(4));
        }
    };

    public List getTokens();

    public void setTokens(List var1);

    public String getSecondLocalLocation();

    public void setSecondLocalLocation(String var1);

    public String getSecondStringValue();

    public void setSecondStringValue(String var1);

    public int getColor();

    public void setColor(int var1);
}

