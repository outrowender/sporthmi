/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.jexl.parser;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;
import org.apache.commons.jexl.JexlContext;
import org.apache.commons.jexl.parser.Parser;
import org.apache.commons.jexl.parser.ParserVisitor;
import org.apache.commons.jexl.parser.SimpleNode;
import org.apache.commons.jexl.util.Introspector;
import org.apache.commons.jexl.util.introspection.Info;
import org.apache.commons.jexl.util.introspection.VelMethod;

public class ASTSizeFunction
extends SimpleNode {
    public ASTSizeFunction(int n) {
        super(n);
    }

    public ASTSizeFunction(Parser parser, int n) {
        super(parser, n);
    }

    public Object jjtAccept(ParserVisitor parserVisitor, Object object) {
        return parserVisitor.visit(this, object);
    }

    public Object value(JexlContext jexlContext) throws Exception {
        SimpleNode simpleNode = (SimpleNode)this.jjtGetChild(0);
        Object object = simpleNode.value(jexlContext);
        if (object == null) {
            throw new Exception("size() : null arg");
        }
        return new Integer(ASTSizeFunction.sizeOf(object));
    }

    public static int sizeOf(Object object) throws Exception {
        if (object instanceof Collection) {
            return ((Collection)object).size();
        }
        if (object.getClass().isArray()) {
            return Array.getLength(object);
        }
        if (object instanceof Map) {
            return ((Map)object).size();
        }
        if (object instanceof String) {
            return ((String)object).length();
        }
        Object[] objectArray = new Object[]{};
        Info info = new Info("", 1, 1);
        VelMethod velMethod = Introspector.getUberspect().getMethod(object, "size", objectArray, info);
        if (velMethod != null && velMethod.getReturnType() == Integer.TYPE) {
            Integer n = (Integer)velMethod.invoke(object, objectArray);
            return n;
        }
        throw new Exception("size() : unknown type : " + object.getClass());
    }
}

