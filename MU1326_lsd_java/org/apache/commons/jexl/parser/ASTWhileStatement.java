/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.jexl.parser;

import org.apache.commons.jexl.JexlContext;
import org.apache.commons.jexl.parser.Parser;
import org.apache.commons.jexl.parser.ParserVisitor;
import org.apache.commons.jexl.parser.SimpleNode;
import org.apache.commons.jexl.util.Coercion;

public class ASTWhileStatement
extends SimpleNode {
    public ASTWhileStatement(int n) {
        super(n);
    }

    public ASTWhileStatement(Parser parser, int n) {
        super(parser, n);
    }

    @Override
    public Object jjtAccept(ParserVisitor parserVisitor, Object object) {
        return parserVisitor.visit(this, object);
    }

    @Override
    public Object value(JexlContext jexlContext) {
        Object object = null;
        SimpleNode simpleNode = (SimpleNode)this.jjtGetChild(0);
        while (Coercion.coerceBoolean(simpleNode.value(jexlContext)).booleanValue()) {
            object = ((SimpleNode)this.jjtGetChild(1)).value(jexlContext);
        }
        return object;
    }
}

