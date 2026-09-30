/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.ui.mib2;

import de.audi.remotehmi.util.EnumHelper;
import de.audi.remotehmi.util.EnumParser;
import java.util.List;

public class ScrollMode {
    private static final EnumHelper enumHelper = new EnumHelper();
    public static final ScrollMode SCROLL_MODE_PAGE = new ScrollMode("page", 0);
    public static final ScrollMode SCROLL_MODE_PAGE_90_PERCENT = new ScrollMode("page90percent", 1);
    public static final ScrollMode SCROLL_MODE_NEXT_LINK = new ScrollMode("nextLink", 2);
    public static final ScrollMode SCROLL_MODE_6_STEPS = new ScrollMode("6steps", 3);
    public static final ScrollMode SCROLL_MODE_5_STEPS = new ScrollMode("5steps", 4);
    public static final ScrollMode SCROLL_MODE_KEYS = new ScrollMode("keys", 5);
    public static final ScrollMode SCROLL_MODE_FREE;
    public static final ScrollMode DEFAULT_SCROLLMODE;
    private static final int SCROLL_MODE_PAGE_INTValue = 0;
    private static final int SCROLL_MODE_PAGE_90_PERCENT_INTValue = 1;
    private static final int SCROLL_MODE_NEXT_LINK_INTValue = 2;
    private static final int SCROLL_MODE_6_STEPS_INTValue = 3;
    private static final int SCROLL_MODE_5_STEPS_INTValue = 4;
    private static final int SCROLL_MODE_KEYS_INTValue = 5;
    private static final int SCROLL_MODE_FREE_INTValue = 7;
    private final String name;
    private final int intValue;

    private ScrollMode(String string, int n) {
        this.name = string;
        this.intValue = n;
        enumHelper.addInstance(string, this);
    }

    public static final List values() {
        return enumHelper.values();
    }

    public static final ScrollMode valueOf(String string) {
        return (ScrollMode)enumHelper.valueOf(string);
    }

    public String toString() {
        return this.name;
    }

    public int getIntValue() {
        return this.intValue;
    }

    public static final EnumParser getParser() {
        return enumHelper.getParser();
    }

    public static final ScrollMode forIntValue(int n) {
        switch (n) {
            case 0: {
                return SCROLL_MODE_PAGE;
            }
            case 1: {
                return SCROLL_MODE_PAGE_90_PERCENT;
            }
            case 4: {
                return SCROLL_MODE_5_STEPS;
            }
            case 3: {
                return SCROLL_MODE_6_STEPS;
            }
            case 5: {
                return SCROLL_MODE_KEYS;
            }
            case 2: {
                return SCROLL_MODE_NEXT_LINK;
            }
            case 7: {
                return SCROLL_MODE_FREE;
            }
        }
        return SCROLL_MODE_FREE;
    }

    static {
        DEFAULT_SCROLLMODE = SCROLL_MODE_FREE = new ScrollMode("free", 7);
    }
}

