/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.jexl;

import java.io.StringReader;
import org.apache.commons.jexl.Expression;
import org.apache.commons.jexl.ExpressionImpl;
import org.apache.commons.jexl.parser.ASTExpressionExpression;
import org.apache.commons.jexl.parser.ASTForeachStatement;
import org.apache.commons.jexl.parser.ASTIfStatement;
import org.apache.commons.jexl.parser.ASTReferenceExpression;
import org.apache.commons.jexl.parser.ASTStatementExpression;
import org.apache.commons.jexl.parser.ASTWhileStatement;
import org.apache.commons.jexl.parser.ParseException;
import org.apache.commons.jexl.parser.Parser;
import org.apache.commons.jexl.parser.SimpleNode;
import org.apache.commons.jexl.parser.TokenMgrError;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ExpressionFactory {
    protected static Log log = LogFactory.getLog("org.apache.commons.jexl.ExpressionFactory");
    protected static Parser parser = new Parser(new StringReader(";"));
    protected static ExpressionFactory ef = new ExpressionFactory();

    private ExpressionFactory() {
    }

    protected static ExpressionFactory getInstance() {
        return ef;
    }

    public static Expression createExpression(String string) {
        return ExpressionFactory.getInstance().createNewExpression(string);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected Expression createNewExpression(String string) {
        SimpleNode simpleNode;
        String string2 = this.cleanExpression(string);
        Object object = parser;
        synchronized (object) {
            log.debug(new StringBuffer().append("Parsing expression: ").append(string2).toString());
            try {
                simpleNode = parser.parse(new StringReader(string2));
            }
            catch (TokenMgrError tokenMgrError) {
                throw new ParseException(tokenMgrError.getMessage());
            }
        }
        if (simpleNode.jjtGetNumChildren() > 1 && log.isWarnEnabled()) {
            log.warn(new StringBuffer().append("The JEXL Expression created will be a reference to the first expression from the supplied script: \"").append(string).append("\" ").toString());
        }
        if ((object = (SimpleNode)simpleNode.jjtGetChild(0)) instanceof ASTReferenceExpression || object instanceof ASTExpressionExpression || object instanceof ASTStatementExpression || object instanceof ASTIfStatement || object instanceof ASTWhileStatement || object instanceof ASTForeachStatement) {
            return new ExpressionImpl(string, (SimpleNode)object);
        }
        log.error(new StringBuffer().append("Invalid Expression, node of type: ").append(object.getClass().getName()).toString());
        throw new Exception("Invalid Expression: not a Reference, Expression, Statement or If");
    }

    private String cleanExpression(String string) {
        String string2 = string.trim();
        if (!string2.endsWith(";")) {
            string2 = new StringBuffer().append(string2).append(";").toString();
        }
        return string2;
    }
}

