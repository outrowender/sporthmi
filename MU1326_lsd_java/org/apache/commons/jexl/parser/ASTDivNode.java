/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 */
package org.apache.commons.jexl.parser;

import org.apache.commons.jexl.JexlContext;
import org.apache.commons.jexl.parser.Parser;
import org.apache.commons.jexl.parser.ParserVisitor;
import org.apache.commons.jexl.parser.SimpleNode;
import org.apache.commons.jexl.util.Coercion;

public class ASTDivNode
extends SimpleNode {
    public ASTDivNode(int n) {
        super(n);
    }

    public ASTDivNode(Parser parser, int n) {
        super(parser, n);
    }

    @Override
    public Object jjtAccept(ParserVisitor parserVisitor, Object object) {
        return parserVisitor.visit(this, object);
    }

    @Override
    public Object value(JexlContext jexlContext) {
        Object object = ((SimpleNode)this.jjtGetChild(0)).value(jexlContext);
        Object object2 = ((SimpleNode)this.jjtGetChild(1)).value(jexlContext);
        if (object == null && object2 == null) {
            return new Byte(0);
        }
        Double d2 = Coercion.coerceDouble(object);
        Double d3 = Coercion.coerceDouble(object2);
        if (d3 == 0.0) {
            return new Double(0.0);
        }
        return new Double(d2 / d3);
    }
}

