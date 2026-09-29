/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.scxml;

import java.util.List;
import java.util.Map;

public interface EventDispatcher {
    default public void cancel(String string) {
    }

    default public void send(String string, String string2, String string3, String string4, Map map, Object object, long l, List list) {
    }
}

