/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.jexl;

import org.apache.commons.jexl.JexlContext;

public interface Script {
    public Object execute(JexlContext var1) throws Exception;

    public String getText();
}

