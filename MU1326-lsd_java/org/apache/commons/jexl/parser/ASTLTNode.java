/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.jexl.parser;

import org.apache.commons.jexl.JexlContext;
import org.apache.commons.jexl.parser.Parser;
import org.apache.commons.jexl.parser.ParserVisitor;
import org.apache.commons.jexl.parser.SimpleNode;
import org.apache.commons.jexl.util.Coercion;

public class ASTLTNode
extends SimpleNode {
    public ASTLTNode(int n) {
        super(n);
    }

    public ASTLTNode(Parser parser, int n) {
        super(parser, n);
    }

    @Override
    public Object jjtAccept(ParserVisitor parserVisitor, Object object) {
        return parserVisitor.visit(this, object);
    }

    @Override
    public Object value(JexlContext jexlContext) {
        Object object;
        Object object2 = ((SimpleNode)this.jjtGetChild(0)).value(jexlContext);
        if (object2 == (object = ((SimpleNode)this.jjtGetChild(1)).value(jexlContext)) || object2 == null || object == null) {
            return Boolean.FALSE;
        }
        if (Coercion.isFloatingPoint(object2) || Coercion.isFloatingPoint(object)) {
            double d2;
            double d3 = Coercion.coerceDouble(object2);
            return d3 < (d2 = Coercion.coerceDouble(object).doubleValue()) ? Boolean.TRUE : Boolean.FALSE;
        }
        if (Coercion.isNumberable(object2) || Coercion.isNumberable(object)) {
            long l;
            long l2 = Coercion.coerceLong(object2);
            return l2 < (l = Coercion.coerceLong(object).longValue()) ? Boolean.TRUE : Boolean.FALSE;
        }
        if (object2 instanceof String || object instanceof String) {
            String string;
            String string2 = object2.toString();
            return string2.compareTo(string = object.toString()) < 0 ? Boolean.TRUE : Boolean.FALSE;
        }
        if (object2 instanceof Comparable) {
            return ((Comparable)object2).compareTo(object) < 0 ? Boolean.TRUE : Boolean.FALSE;
        }
        if (object instanceof Comparable) {
            return ((Comparable)object).compareTo(object2) > 0 ? Boolean.TRUE : Boolean.FALSE;
        }
        throw new Exception("Invalid comparison : LT ");
    }
}

