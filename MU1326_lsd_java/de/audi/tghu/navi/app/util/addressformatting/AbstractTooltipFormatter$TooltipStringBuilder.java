/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.util.addressformatting;

import de.audi.tghu.navi.app.util.Util;
import de.audi.tghu.navi.app.util.addressformatting.AbstractTooltipFormatter;
import de.esolutions.fw.util.commons.Buffer;

public class AbstractTooltipFormatter$TooltipStringBuilder {
    private final Buffer buffer = new Buffer();
    private boolean lineBreakRequested = false;
    private boolean separatorNeeded = false;
    private final /* synthetic */ AbstractTooltipFormatter this$0;

    public AbstractTooltipFormatter$TooltipStringBuilder(AbstractTooltipFormatter abstractTooltipFormatter) {
        this.this$0 = abstractTooltipFormatter;
    }

    public boolean addLineBreak() {
        if (this.buffer.length() > 0) {
            this.lineBreakRequested = true;
            this.separatorNeeded = false;
            return true;
        }
        return false;
    }

    public boolean addString(String string, String string2) {
        if (!Util.isEmpty(string)) {
            if (this.lineBreakRequested) {
                this.buffer.append('\n');
                this.lineBreakRequested = false;
            }
            if (this.separatorNeeded) {
                this.buffer.append(string2);
            }
            this.buffer.append(string);
            this.separatorNeeded = true;
            return true;
        }
        return false;
    }

    public boolean addString(String string) {
        return this.addString(string, ", ");
    }

    public boolean addStringWithoutComma(String string) {
        return this.addString(string, " ");
    }

    public boolean addStringWithoutSeparator(String string) {
        return this.addString(string, "");
    }

    public String toString() {
        if (this.buffer.length() == 0) {
            return null;
        }
        return this.buffer.toString();
    }

    public boolean isEmpty() {
        return this.buffer.length() == 0;
    }
}

