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

public class ASTUnaryMinusNode
extends SimpleNode {
    public ASTUnaryMinusNode(int n) {
        super(n);
    }

    public ASTUnaryMinusNode(Parser parser, int n) {
        super(parser, n);
    }

    @Override
    public Object jjtAccept(ParserVisitor parserVisitor, Object object) {
        return parserVisitor.visit(this, object);
    }

    @Override
    public Object value(JexlContext jexlContext) {
        Object object = ((SimpleNode)this.jjtGetChild(0)).value(jexlContext);
        if (object instanceof Byte) {
            byte by = (Byte)object;
            return new Byte(-by);
        }
        if (object instanceof Short) {
            short s = (Short)object;
            return new Short(-s);
        }
        if (object instanceof Integer) {
            int n = (Integer)object;
            return new Integer(-n);
        }
        if (object instanceof Long) {
            long l = (Long)object;
            return new Long(-l);
        }
        if (object instanceof Float) {
            float f2 = ((Float)object).floatValue();
            return new Float(-f2);
        }
        if (object instanceof Double) {
            double d2 = (Double)object;
            return new Double(-d2);
        }
        throw new Exception("expression not a number");
    }
}

