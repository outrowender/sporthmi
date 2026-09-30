/*
 * Decompiled with CFR 0.152.
 */
package de.eso.vcard.b;

import de.eso.vcard.b.a;
import java.util.List;
import org.dsi.ifc.organizer.AdbEntry;

class b
implements de.eso.a.a.b {
    private final a a;

    b(a a2) {
        this.a = a2;
    }

    public void a(List list) {
        if (list != null && list.size() > 0) {
            de.eso.vcard.b.a.a(this.a, (AdbEntry)list.get(0));
        }
    }

    public int a() {
        return 1;
    }

    public int b() {
        return 1;
    }
}

