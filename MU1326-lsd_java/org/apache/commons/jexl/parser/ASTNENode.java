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

public class ASTNENode
extends SimpleNode {
    public ASTNENode(int n) {
        super(n);
    }

    public ASTNENode(Parser parser, int n) {
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
            return Boolean.FALSE;
        }
        if (object == null || object2 == null) {
            return Boolean.TRUE;
        }
        if (object.getClass().equals(object2.getClass())) {
            return object.equals(object2) ? Boolean.FALSE : Boolean.TRUE;
        }
        if (object instanceof Float || object instanceof Double || object2 instanceof Float || object2 instanceof Double) {
            return Coercion.coerceDouble(object).equals((Object)Coercion.coerceDouble(object2)) ? Boolean.FALSE : Boolean.TRUE;
        }
        if (object instanceof Number || object2 instanceof Number || object instanceof Character || object2 instanceof Character) {
            return Coercion.coerceLong(object).equals(Coercion.coerceLong(object2)) ? Boolean.FALSE : Boolean.TRUE;
        }
        if (object instanceof Boolean || object2 instanceof Boolean) {
            return Coercion.coerceBoolean(object).equals(Coercion.coerceBoolean(object2)) ? Boolean.FALSE : Boolean.TRUE;
        }
        if (object instanceof String || object2 instanceof String) {
            return object.toString().equals(object2.toString()) ? Boolean.FALSE : Boolean.TRUE;
        }
        return object.equals(object2) ? Boolean.FALSE : Boolean.TRUE;
    }
}

