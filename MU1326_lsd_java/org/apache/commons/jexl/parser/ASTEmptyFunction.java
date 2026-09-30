/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.jexl.parser;

import java.util.Collection;
import java.util.Map;
import org.apache.commons.jexl.JexlContext;
import org.apache.commons.jexl.parser.Parser;
import org.apache.commons.jexl.parser.ParserVisitor;
import org.apache.commons.jexl.parser.SimpleNode;

public class ASTEmptyFunction
extends SimpleNode {
    public ASTEmptyFunction(int n) {
        super(n);
    }

    public ASTEmptyFunction(Parser parser, int n) {
        super(parser, n);
    }

    public Object jjtAccept(ParserVisitor parserVisitor, Object object) {
        return parserVisitor.visit(this, object);
    }

    public Object value(JexlContext jexlContext) throws Exception {
        SimpleNode simpleNode = (SimpleNode)this.jjtGetChild(0);
        Object object = simpleNode.value(jexlContext);
        if (object == null) {
            return Boolean.TRUE;
        }
        if (object instanceof String && "".equals(object)) {
            return Boolean.TRUE;
        }
        if (object.getClass().isArray() && ((Object[])object).length == 0) {
            return Boolean.TRUE;
        }
        if (object instanceof Collection && ((Collection)object).isEmpty()) {
            return Boolean.TRUE;
        }
        if (object instanceof Map && ((Map)object).isEmpty()) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}

