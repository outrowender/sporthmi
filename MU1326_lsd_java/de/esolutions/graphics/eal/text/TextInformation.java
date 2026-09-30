/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal.text;

import de.esolutions.graphics.eal.api.IManager;
import de.esolutions.graphics.eal.api.ITextLayoutResult;

public class TextInformation {
    private ITextLayoutResult result = null;
    private int[] glyphInformation = null;

    public TextInformation(IManager iManager, ITextLayoutResult iTextLayoutResult) {
        this.result = iTextLayoutResult;
        if (null != this.result && this.result.isValid()) {
            int n = (int)this.result.getGlyphCount() * 2;
            this.glyphInformation = new int[n];
            iManager.layoutGetWidth(this.result, this.glyphInformation, n);
        }
    }

    public GlyphInformation layoutGetWidth(int n) {
        if (null != this.glyphInformation) {
            GlyphInformation glyphInformation = new GlyphInformation();
            glyphInformation.start = this.glyphInformation[n * 2 + 0];
            glyphInformation.end = this.glyphInformation[n * 2 + 1];
            return glyphInformation;
        }
        return null;
    }

    public void dump() {
        if (null != this.glyphInformation) {
            System.out.println("glyphlist {");
            for (int i2 = 0; i2 < this.glyphInformation.length; i2 += 2) {
                System.out.println("\t" + i2 / 2 + " : {start=" + this.glyphInformation[i2] + ", end=" + this.glyphInformation[i2 + 1] + ", width=" + (this.glyphInformation[1] - this.glyphInformation[0]) + "}");
            }
            System.out.println("}");
        }
    }

    public void dispose() {
    }

    public static class GlyphInformation {
        public int start = 0;
        public int end = 0;
    }
}

