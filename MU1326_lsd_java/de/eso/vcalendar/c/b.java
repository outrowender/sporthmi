/*
 * Decompiled with CFR 0.152.
 */
package de.eso.vcalendar.c;

import de.eso.vcalendar.b.d;
import de.eso.vcalendar.c.a;
import java.util.List;

class b
implements de.eso.a.a.b {
    private final a a;

    b(a a2) {
        this.a = a2;
    }

    public void a(List list) {
        if (list != null && list.size() > 0) {
            de.eso.vcalendar.c.a.a(this.a, (d)list.get(0));
        }
    }

    public int a() {
        return 1;
    }

    public int b() {
        return 1;
    }
}

