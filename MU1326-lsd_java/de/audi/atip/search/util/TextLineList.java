/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.search.util;

import de.esolutions.fw.util.commons.Buffer;
import java.util.ArrayList;
import org.dsi.ifc.search.Highlight;
import org.dsi.ifc.search.Token;

public class TextLineList {
    ArrayList tokens;

    public TextLineList() {
        this.tokens = new ArrayList();
    }

    public TextLineList(int n) {
        this.tokens = new ArrayList(n);
    }

    public void addText(String string) {
        this.tokens.add(string);
    }

    public void addToken(Token token) {
        this.tokens.add(token);
    }

    public String getText() {
        String string;
        Buffer buffer = new Buffer();
        if (this.tokens != null) {
            for (int i2 = 0; i2 < this.tokens.size(); ++i2) {
                Object object = this.tokens.get(i2);
                if (object instanceof Token) {
                    buffer.append(((Token)object).getToken());
                    continue;
                }
                buffer.append((String)object);
            }
        }
        return (string = buffer.toString()) != null ? string : "";
    }

    public int[] getTextHighlightIndices() {
        if (this.tokens == null) {
            return null;
        }
        int n = 0;
        for (int i2 = 0; i2 < this.tokens.size(); ++i2) {
            Token token;
            Highlight[] highlightArray;
            Object object = this.tokens.get(i2);
            if (object == null || !(object instanceof Token) || (highlightArray = (token = (Token)object).getHighlights()) == null) continue;
            n += highlightArray.length;
        }
        if (n == 0) {
            return null;
        }
        int[] nArray = new int[n * 2];
        int n2 = 0;
        int n3 = 0;
        for (int i3 = 0; i3 < this.tokens.size(); ++i3) {
            Token token = null;
            Highlight[] highlightArray = null;
            String string = null;
            if (this.tokens.get(i3) instanceof Token) {
                token = (Token)this.tokens.get(i3);
                highlightArray = token.getHighlights();
                string = token.getToken();
            } else {
                string = (String)this.tokens.get(i3);
            }
            if (highlightArray != null && string != null && highlightArray.length > 0) {
                int n4;
                int n5 = highlightArray.length;
                do {
                    n4 = 1;
                    for (int i4 = 0; i4 < n5 - 1; ++i4) {
                        if (highlightArray[i4].highlightStart <= highlightArray[i4 + 1].highlightStart) continue;
                        Highlight highlight = highlightArray[i4];
                        highlightArray[i4] = highlightArray[i4 + 1];
                        highlightArray[i4 + 1] = highlight;
                        n4 = i4 + 1;
                    }
                } while ((n5 = n4) > 1);
                for (n4 = 0; n4 < highlightArray.length; ++n4) {
                    if (highlightArray[n4] == null || highlightArray[n4].getHighlightStart() > highlightArray[n4].getHighlightEnd()) continue;
                    nArray[n3++] = n2 + highlightArray[n4].getHighlightStart();
                    nArray[n3++] = n2 + highlightArray[n4].getHighlightEnd();
                }
            }
            if (string == null) continue;
            n2 += string.length();
        }
        if (n3 == 0) {
            return null;
        }
        if (n3 == nArray.length) {
            return nArray;
        }
        int[] nArray2 = new int[n3];
        System.arraycopy((Object)nArray, 0, (Object)nArray2, 0, n3);
        return nArray2;
    }

    public int size() {
        return this.tokens.size();
    }

    public void clear() {
        this.tokens.clear();
    }
}

