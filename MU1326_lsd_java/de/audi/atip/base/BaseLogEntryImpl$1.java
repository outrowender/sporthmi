/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 */
package de.audi.atip.base;

import de.audi.atip.base.BaseLogEntryImpl;
import de.audi.atip.util.StringUtilities$Accessor;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.Formatter;

class BaseLogEntryImpl$1
implements StringUtilities$Accessor {
    private final /* synthetic */ BaseLogEntryImpl this$0;

    BaseLogEntryImpl$1(BaseLogEntryImpl baseLogEntryImpl) {
        this.this$0 = baseLogEntryImpl;
    }

    @Override
    public int getLength() {
        return 4;
    }

    @Override
    public void appendArg(Buffer buffer, int n, int n2) {
        int n3 = BaseLogEntryImpl.access$000(this.this$0) >> n * 3 & 7;
        switch (n3) {
            case 1: {
                BaseLogEntryImpl.access$200(this.this$0, buffer, BaseLogEntryImpl.access$100(this.this$0, n), n2);
                break;
            }
            case 6: {
                buffer.append((char)BaseLogEntryImpl.access$100(this.this$0, n));
                break;
            }
            case 5: {
                buffer.append(Double.toString((double)Double.longBitsToDouble((long)BaseLogEntryImpl.access$100(this.this$0, n))));
                break;
            }
            case 2: {
                Object object = BaseLogEntryImpl.access$300(this.this$0, n);
                Formatter.formatObject(buffer, object);
                break;
            }
            case 3: {
                buffer.append(true);
                break;
            }
            case 4: {
                buffer.append(false);
                break;
            }
            default: {
                buffer.append((Object)null);
            }
        }
    }
}

