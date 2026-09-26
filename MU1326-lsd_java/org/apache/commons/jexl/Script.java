/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.jexl;

import org.apache.commons.jexl.JexlContext;

public interface Script {
    default public Object execute(JexlContext jexlContext) {
    }

    default public String getText() {
    }
}

