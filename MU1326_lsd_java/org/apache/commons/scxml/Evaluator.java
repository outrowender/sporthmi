/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.scxml;

import org.apache.commons.scxml.Context;
import org.apache.commons.scxml.SCXMLExpressionException;
import org.w3c.dom.Node;

public interface Evaluator {
    public Object eval(Context var1, String var2) throws SCXMLExpressionException;

    public Boolean evalCond(Context var1, String var2) throws SCXMLExpressionException;

    public Node evalLocation(Context var1, String var2) throws SCXMLExpressionException;

    public Context newContext(Context var1);
}

