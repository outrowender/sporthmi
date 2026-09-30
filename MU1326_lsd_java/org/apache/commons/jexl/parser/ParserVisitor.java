/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.jexl.parser;

import org.apache.commons.jexl.parser.ASTAddNode;
import org.apache.commons.jexl.parser.ASTAndNode;
import org.apache.commons.jexl.parser.ASTArrayAccess;
import org.apache.commons.jexl.parser.ASTAssignment;
import org.apache.commons.jexl.parser.ASTBitwiseAndNode;
import org.apache.commons.jexl.parser.ASTBitwiseComplNode;
import org.apache.commons.jexl.parser.ASTBitwiseOrNode;
import org.apache.commons.jexl.parser.ASTBitwiseXorNode;
import org.apache.commons.jexl.parser.ASTBlock;
import org.apache.commons.jexl.parser.ASTDivNode;
import org.apache.commons.jexl.parser.ASTEQNode;
import org.apache.commons.jexl.parser.ASTEmptyFunction;
import org.apache.commons.jexl.parser.ASTExpression;
import org.apache.commons.jexl.parser.ASTExpressionExpression;
import org.apache.commons.jexl.parser.ASTFalseNode;
import org.apache.commons.jexl.parser.ASTFloatLiteral;
import org.apache.commons.jexl.parser.ASTForeachStatement;
import org.apache.commons.jexl.parser.ASTGENode;
import org.apache.commons.jexl.parser.ASTGTNode;
import org.apache.commons.jexl.parser.ASTIdentifier;
import org.apache.commons.jexl.parser.ASTIfStatement;
import org.apache.commons.jexl.parser.ASTIntegerLiteral;
import org.apache.commons.jexl.parser.ASTJexlScript;
import org.apache.commons.jexl.parser.ASTLENode;
import org.apache.commons.jexl.parser.ASTLTNode;
import org.apache.commons.jexl.parser.ASTMethod;
import org.apache.commons.jexl.parser.ASTModNode;
import org.apache.commons.jexl.parser.ASTMulNode;
import org.apache.commons.jexl.parser.ASTNENode;
import org.apache.commons.jexl.parser.ASTNotNode;
import org.apache.commons.jexl.parser.ASTNullLiteral;
import org.apache.commons.jexl.parser.ASTOrNode;
import org.apache.commons.jexl.parser.ASTReference;
import org.apache.commons.jexl.parser.ASTReferenceExpression;
import org.apache.commons.jexl.parser.ASTSizeFunction;
import org.apache.commons.jexl.parser.ASTSizeMethod;
import org.apache.commons.jexl.parser.ASTStatementExpression;
import org.apache.commons.jexl.parser.ASTStringLiteral;
import org.apache.commons.jexl.parser.ASTSubtractNode;
import org.apache.commons.jexl.parser.ASTTrueNode;
import org.apache.commons.jexl.parser.ASTUnaryMinusNode;
import org.apache.commons.jexl.parser.ASTWhileStatement;
import org.apache.commons.jexl.parser.SimpleNode;

public interface ParserVisitor {
    public Object visit(SimpleNode var1, Object var2);

    public Object visit(ASTJexlScript var1, Object var2);

    public Object visit(ASTBlock var1, Object var2);

    public Object visit(ASTEmptyFunction var1, Object var2);

    public Object visit(ASTSizeFunction var1, Object var2);

    public Object visit(ASTIdentifier var1, Object var2);

    public Object visit(ASTExpression var1, Object var2);

    public Object visit(ASTAssignment var1, Object var2);

    public Object visit(ASTOrNode var1, Object var2);

    public Object visit(ASTAndNode var1, Object var2);

    public Object visit(ASTBitwiseOrNode var1, Object var2);

    public Object visit(ASTBitwiseXorNode var1, Object var2);

    public Object visit(ASTBitwiseAndNode var1, Object var2);

    public Object visit(ASTEQNode var1, Object var2);

    public Object visit(ASTNENode var1, Object var2);

    public Object visit(ASTLTNode var1, Object var2);

    public Object visit(ASTGTNode var1, Object var2);

    public Object visit(ASTLENode var1, Object var2);

    public Object visit(ASTGENode var1, Object var2);

    public Object visit(ASTAddNode var1, Object var2);

    public Object visit(ASTSubtractNode var1, Object var2);

    public Object visit(ASTMulNode var1, Object var2);

    public Object visit(ASTDivNode var1, Object var2);

    public Object visit(ASTModNode var1, Object var2);

    public Object visit(ASTUnaryMinusNode var1, Object var2);

    public Object visit(ASTBitwiseComplNode var1, Object var2);

    public Object visit(ASTNotNode var1, Object var2);

    public Object visit(ASTNullLiteral var1, Object var2);

    public Object visit(ASTTrueNode var1, Object var2);

    public Object visit(ASTFalseNode var1, Object var2);

    public Object visit(ASTIntegerLiteral var1, Object var2);

    public Object visit(ASTFloatLiteral var1, Object var2);

    public Object visit(ASTStringLiteral var1, Object var2);

    public Object visit(ASTExpressionExpression var1, Object var2);

    public Object visit(ASTStatementExpression var1, Object var2);

    public Object visit(ASTReferenceExpression var1, Object var2);

    public Object visit(ASTIfStatement var1, Object var2);

    public Object visit(ASTWhileStatement var1, Object var2);

    public Object visit(ASTForeachStatement var1, Object var2);

    public Object visit(ASTMethod var1, Object var2);

    public Object visit(ASTArrayAccess var1, Object var2);

    public Object visit(ASTSizeMethod var1, Object var2);

    public Object visit(ASTReference var1, Object var2);
}

