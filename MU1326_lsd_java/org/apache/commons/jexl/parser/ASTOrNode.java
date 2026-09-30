/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.jexl.parser;

import org.apache.commons.jexl.JexlContext;
import org.apache.commons.jexl.parser.Parser;
import org.apache.commons.jexl.parser.ParserVisitor;
import org.apache.commons.jexl.parser.SimpleNode;
import org.apache.commons.jexl.util.Coercion;

public class ASTOrNode
extends SimpleNode {
    public ASTOrNode(int n) {
        super(n);
    }

    public ASTOrNode(Parser parser, int n) {
        super(parser, n);
    }

    public Object jjtAccept(ParserVisitor parserVisitor, Object object) {
        return parserVisitor.visit(this, object);
    }

    public Object value(JexlContext jexlContext) throws Exception {
        Object object = ((SimpleNode)this.jjtGetChild(0)).value(jexlContext);
        boolean bl = Coercion.coerceBoolean(object);
        return bl || Coercion.coerceBoolean(((SimpleNode)this.jjtGetChild(1)).value(jexlContext)) != false ? Boolean.TRUE : Boolean.FALSE;
    }
}

