/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.jexl.parser;

import java.lang.reflect.InvocationTargetException;
import org.apache.commons.jexl.JexlContext;
import org.apache.commons.jexl.parser.ASTIdentifier;
import org.apache.commons.jexl.parser.Parser;
import org.apache.commons.jexl.parser.ParserVisitor;
import org.apache.commons.jexl.parser.SimpleNode;
import org.apache.commons.jexl.util.Introspector;
import org.apache.commons.jexl.util.introspection.Info;
import org.apache.commons.jexl.util.introspection.VelMethod;

public class ASTMethod
extends SimpleNode {
    private static final Info DUMMY = new Info("", 1, 1);

    public ASTMethod(int n) {
        super(n);
    }

    public ASTMethod(Parser parser, int n) {
        super(parser, n);
    }

    public Object jjtAccept(ParserVisitor parserVisitor, Object object) {
        return parserVisitor.visit(this, object);
    }

    public Object execute(Object object, JexlContext jexlContext) throws Exception {
        String string = ((ASTIdentifier)this.jjtGetChild((int)0)).val;
        int n = this.jjtGetNumChildren() - 1;
        Object[] objectArray = new Object[n];
        try {
            for (int i2 = 0; i2 < n; ++i2) {
                objectArray[i2] = ((SimpleNode)this.jjtGetChild(i2 + 1)).value(jexlContext);
            }
            VelMethod velMethod = Introspector.getUberspect().getMethod(object, string, objectArray, DUMMY);
            if (velMethod == null) {
                for (int i3 = 0; i3 < objectArray.length; ++i3) {
                    Object object2 = objectArray[i3];
                    if (!(object2 instanceof Number)) continue;
                    objectArray[i3] = this.narrow((Number)object2);
                }
                velMethod = Introspector.getUberspect().getMethod(object, string, objectArray, DUMMY);
                if (velMethod == null) {
                    return null;
                }
            }
            return velMethod.invoke(object, objectArray);
        }
        catch (InvocationTargetException invocationTargetException) {
            Throwable throwable = invocationTargetException.getTargetException();
            if (throwable instanceof Exception) {
                throw (Exception)throwable;
            }
            throw invocationTargetException;
        }
    }

    private Number narrow(Number number) {
        if (number == null) {
            return number;
        }
        Number number2 = number;
        if (number instanceof Double || number instanceof Float) {
            double d2 = number.doubleValue();
            if (d2 <= 3.4028234663852886E38 && d2 >= (double)1.4E-45f) {
                number2 = new Float(number2.floatValue());
            }
        } else {
            long l = number.longValue();
            if (l <= 127L && l >= -128L) {
                number2 = new Byte((byte)l);
            } else if (l <= 32767L && l >= -32768L) {
                number2 = new Short((short)l);
            } else if (l <= Integer.MAX_VALUE && l >= Integer.MIN_VALUE) {
                number2 = new Integer((int)l);
            }
        }
        return number2;
    }
}

