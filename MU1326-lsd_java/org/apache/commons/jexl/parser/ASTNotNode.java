/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.jexl.parser;

import org.apache.commons.jexl.JexlContext;
import org.apache.commons.jexl.parser.Parser;
import org.apache.commons.jexl.parser.ParserVisitor;
import org.apache.commons.jexl.parser.SimpleNode;
import org.apache.commons.jexl.util.Coercion;

public class ASTNotNode
extends SimpleNode {
    public ASTNotNode(int n) {
        super(n);
    }

    public ASTNotNode(Parser parser, int n) {
        super(parser, n);
    }

    @Override
    public Object jjtAccept(ParserVisitor parserVisitor, Object object) {
        return parserVisitor.visit(this, object);
    }

    @Override
    public Object value(JexlContext jexlContext) {
        Object object = ((SimpleNode)this.jjtGetChild(0)).value(jexlContext);
        Boolean bl = Coercion.coerceBoolean(object);
        if (bl != null) {
            return bl != false ? Boolean.FALSE : Boolean.TRUE;
        }
        throw new Exception("expression not boolean valued");
    }
}

