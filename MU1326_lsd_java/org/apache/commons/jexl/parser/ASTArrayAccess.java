/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.jexl.parser;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Map;
import org.apache.commons.jexl.JexlContext;
import org.apache.commons.jexl.parser.ASTIdentifier;
import org.apache.commons.jexl.parser.Parser;
import org.apache.commons.jexl.parser.ParserVisitor;
import org.apache.commons.jexl.parser.SimpleNode;
import org.apache.commons.jexl.util.Coercion;
import org.apache.commons.jexl.util.Introspector;
import org.apache.commons.jexl.util.introspection.Info;
import org.apache.commons.jexl.util.introspection.VelPropertyGet;

public class ASTArrayAccess
extends SimpleNode {
    private static final Info DUMMY = new Info("", 1, 1);

    public ASTArrayAccess(int n) {
        super(n);
    }

    public ASTArrayAccess(Parser parser, int n) {
        super(parser, n);
    }

    public Object jjtAccept(ParserVisitor parserVisitor, Object object) {
        return parserVisitor.visit(this, object);
    }

    public Object execute(Object object, JexlContext jexlContext) throws Exception {
        ASTIdentifier aSTIdentifier = (ASTIdentifier)this.jjtGetChild(0);
        Object object2 = aSTIdentifier.execute(object, jexlContext);
        for (int i2 = 1; i2 < this.jjtGetNumChildren(); ++i2) {
            Object object3 = ((SimpleNode)this.jjtGetChild(i2)).value(jexlContext);
            if (object3 == null) {
                return null;
            }
            object2 = ASTArrayAccess.evaluateExpr(object2, object3);
        }
        return object2;
    }

    public Object value(JexlContext jexlContext) throws Exception {
        ASTIdentifier aSTIdentifier = (ASTIdentifier)this.jjtGetChild(0);
        Object object = aSTIdentifier.value(jexlContext);
        for (int i2 = 1; i2 < this.jjtGetNumChildren(); ++i2) {
            Object object2 = ((SimpleNode)this.jjtGetChild(i2)).value(jexlContext);
            if (object2 == null) {
                return null;
            }
            object = ASTArrayAccess.evaluateExpr(object, object2);
        }
        return object;
    }

    public static Object evaluateExpr(Object object, Object object2) throws Exception {
        if (object == null) {
            return null;
        }
        if (object2 == null) {
            return null;
        }
        if (object instanceof Map) {
            if (!((Map)object).containsKey(object2)) {
                return null;
            }
            return ((Map)object).get(object2);
        }
        if (object instanceof List) {
            int n = Coercion.coerceInteger(object2);
            try {
                return ((List)object).get(n);
            }
            catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                return null;
            }
        }
        if (object.getClass().isArray()) {
            int n = Coercion.coerceInteger(object2);
            try {
                return Array.get(object, n);
            }
            catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                return null;
            }
        }
        String string = object2.toString();
        VelPropertyGet velPropertyGet = Introspector.getUberspect().getPropertyGet(object, string, DUMMY);
        if (velPropertyGet != null) {
            return velPropertyGet.invoke(object);
        }
        throw new Exception("Unsupported object type for array [] accessor");
    }

    public String getIdentifierString() {
        return ((ASTIdentifier)this.jjtGetChild(0)).getIdentifierString();
    }
}

