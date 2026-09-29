/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo;

import de.audi.atip.util.Util;

public class LineElement {
    public static final int ALIGN_TABULATOR;
    public Object node;
    public boolean focusable;
    public final int configuredWidth;
    private int width = -1;
    public int widthActual;
    public int height = -1;
    public int h_align = -1;
    public int v_align = -1;
    public int x = 0;
    public String text;
    public int bitmapIndex = -1;
    public int fontIndex = 0;
    public int tabulatorIndex = -1;
    public int space = 0;
    public boolean lineBreak;
    private int lineIndex;
    public Object font;
    public int nodeX;
    public int nodeY;
    public String nodeText;
    public boolean nodeVisible = true;

    public boolean identical(Object object) {
        if (object instanceof LineElement) {
            LineElement lineElement = (LineElement)object;
            boolean bl = Util.equals(this.text, lineElement.text);
            boolean bl2 = this.focusable == lineElement.focusable;
            boolean bl3 = this.fontIndex == lineElement.fontIndex;
            boolean bl4 = this.space == lineElement.space;
            boolean bl5 = this.tabulatorIndex == lineElement.tabulatorIndex;
            boolean bl6 = this.v_align == lineElement.v_align;
            boolean bl7 = this.h_align == lineElement.h_align;
            boolean bl8 = this.configuredWidth == lineElement.configuredWidth;
            return bl && bl2 && bl3 && bl4 && bl5 && bl6 && bl7 && bl8;
        }
        return false;
    }

    public LineElement() {
        this.configuredWidth = -1;
    }

    public LineElement(String string) {
        this();
        this.text = string;
    }

    public LineElement(String string, boolean bl) {
        this(string);
        this.focusable = bl;
    }

    public LineElement(String string, int n) {
        this(string);
        this.fontIndex = n;
    }

    public LineElement(String string, int n, int n2) {
        this(string, n);
        this.space = n2;
    }

    public LineElement(String string, int n, int n2, boolean bl) {
        this(string, n);
        if (n2 != -1) {
            this.tabulatorIndex = n2;
            this.h_align = 20;
        }
        if (bl) {
            this.v_align = 4;
        }
    }

    public LineElement(String string, int n, boolean bl, int n2) {
        this(string, n);
        this.space = n2;
        this.lineBreak = bl;
    }

    public LineElement(String string, int n, int n2, int n3, boolean bl) {
        this(string, n, n3, bl);
        this.space = n2;
    }

    public LineElement(String string, boolean bl, int n, int n2) {
        this.configuredWidth = n;
        this.text = string;
        this.setWidth(n);
        this.h_align = n2;
        this.focusable = bl;
    }

    public int getLineIndex() {
        return this.lineIndex;
    }

    public void setLineIndex(int n) {
        this.lineIndex = n;
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int n) {
        this.width = n;
    }
}

