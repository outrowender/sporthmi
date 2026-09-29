/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal.text;

import de.esolutions.graphics.eal.api.IManager;
import de.esolutions.graphics.eal.api.ITextLayoutResult;
import de.esolutions.graphics.eal.text.TextInformation$GlyphInformation;

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

    public TextInformation$GlyphInformation layoutGetWidth(int n) {
        if (null != this.glyphInformation) {
            TextInformation$GlyphInformation textInformation$GlyphInformation = new TextInformation$GlyphInformation();
            textInformation$GlyphInformation.start = this.glyphInformation[n * 2 + 0];
            textInformation$GlyphInformation.end = this.glyphInformation[n * 2 + 1];
            return textInformation$GlyphInformation;
        }
        return null;
    }

    public void dump() {
        if (null != this.glyphInformation) {
            System.out.println("glyphlist {");
            for (int i2 = 0; i2 < this.glyphInformation.length; i2 += 2) {
                System.out.println(new StringBuffer().append("\t").append(i2 / 2).append(" : {start=").append(this.glyphInformation[i2]).append(", end=").append(this.glyphInformation[i2 + 1]).append(", width=").append(this.glyphInformation[1] - this.glyphInformation[0]).append("}").toString());
            }
            System.out.println("}");
        }
    }

    public void dispose() {
    }
}

