/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sds.evo.syscall;

import de.audi.app.sdsmanager.syscall.SystemCallNames;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SystemCallNamesEvo
extends SystemCallNames {
    private static final Map SYSCALL_NAMES = SystemCallNamesEvo.createMap();

    private static Map createMap() {
        HashMap hashMap = new HashMap();
        return Collections.unmodifiableMap(hashMap);
    }

    @Override
    public String getName(int n) {
        String string = (String)SYSCALL_NAMES.get(new Integer(n));
        if (string == null) {
            string = super.getName(n);
        }
        return string == null ? new StringBuffer().append("SYSTEMCALL_").append(n).toString() : string;
    }
}

