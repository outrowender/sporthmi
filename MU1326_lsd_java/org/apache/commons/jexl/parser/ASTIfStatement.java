/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.jexl.parser;

import org.apache.commons.jexl.JexlContext;
import org.apache.commons.jexl.parser.Parser;
import org.apache.commons.jexl.parser.ParserVisitor;
import org.apache.commons.jexl.parser.SimpleNode;
import org.apache.commons.jexl.util.Coercion;

public class ASTIfStatement
extends SimpleNode {
    private static final int ELSE_STATEMENT_INDEX = 2;

    public ASTIfStatement(int n) {
        super(n);
    }

    public ASTIfStatement(Parser parser, int n) {
        super(parser, n);
    }

    public Object jjtAccept(ParserVisitor parserVisitor, Object object) {
        return parserVisitor.visit(this, object);
    }

    public Object value(JexlContext jexlContext) throws Exception {
        Object object = null;
        Object object2 = ((SimpleNode)this.jjtGetChild(0)).value(jexlContext);
        if (Coercion.coerceBoolean(object2).booleanValue()) {
            object = ((SimpleNode)this.jjtGetChild(1)).value(jexlContext);
        } else if (this.jjtGetNumChildren() == 3) {
            object = ((SimpleNode)this.jjtGetChild(2)).value(jexlContext);
        }
        return object;
    }
}

