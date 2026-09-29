/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.settings.etc;

import de.audi.app.settings.etc.ETCHandler;
import java.util.Comparator;
import org.dsi.ifc.tollcollect.TCPaymentInfo;

class ETCHandler$1
implements Comparator {
    private final /* synthetic */ ETCHandler this$0;

    ETCHandler$1(ETCHandler eTCHandler) {
        this.this$0 = eTCHandler;
    }

    @Override
    public int compare(Object object, Object object2) {
        long l;
        long l2 = ((TCPaymentInfo)object).getTimeStamp().getTime();
        if (l2 == (l = ((TCPaymentInfo)object2).getTimeStamp().getTime())) {
            return 0;
        }
        return l > l2 ? 1 : -1;
    }
}

