/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base;

public interface TextToolExport {
    public static final int WIDTH_DESIRED = 0;
    public static final int WIDTH_ACTUAL = 1;
    public static final int HEIGHT_DESIRED = 2;
    public static final int HEIGHT_ACTUAL = 3;
    public static final String XML_TEXT_WIDTH_REF = "XMLTextWidthRef";

    public int[] getTextMaxDimension();
}

