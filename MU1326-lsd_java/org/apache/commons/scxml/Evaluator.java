/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.scxml;

import org.apache.commons.scxml.Context;
import org.w3c.dom.Node;

public interface Evaluator {
    default public Object eval(Context context, String string) {
    }

    default public Boolean evalCond(Context context, String string) {
    }

    default public Node evalLocation(Context context, String string) {
    }

    default public Context newContext(Context context) {
    }
}

