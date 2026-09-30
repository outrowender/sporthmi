/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.jexl.parser;

import org.apache.commons.jexl.JexlContext;
import org.apache.commons.jexl.parser.Parser;
import org.apache.commons.jexl.parser.ParserVisitor;
import org.apache.commons.jexl.parser.SimpleNode;
import org.apache.commons.jexl.util.Coercion;

public class ASTMulNode
extends SimpleNode {
    public ASTMulNode(int n) {
        super(n);
    }

    public ASTMulNode(Parser parser, int n) {
        super(parser, n);
    }

    public Object jjtAccept(ParserVisitor parserVisitor, Object object) {
        return parserVisitor.visit(this, object);
    }

    public Object value(JexlContext jexlContext) throws Exception {
        Object object = ((SimpleNode)this.jjtGetChild(0)).value(jexlContext);
        Object object2 = ((SimpleNode)this.jjtGetChild(1)).value(jexlContext);
        if (object == null && object2 == null) {
            return new Byte(0);
        }
        if (object instanceof Float || object instanceof Double || object2 instanceof Float || object2 instanceof Double || object instanceof String && (((String)object).indexOf(".") != -1 || ((String)object).indexOf("e") != -1 || ((String)object).indexOf("E") != -1) || object2 instanceof String && (((String)object2).indexOf(".") != -1 || ((String)object2).indexOf("e") != -1 || ((String)object2).indexOf("E") != -1)) {
            Double d2 = Coercion.coerceDouble(object);
            Double d3 = Coercion.coerceDouble(object2);
            return new Double(d2 * d3);
        }
        Long l = Coercion.coerceLong(object);
        Long l2 = Coercion.coerceLong(object2);
        return new Long(l * l2);
    }
}

