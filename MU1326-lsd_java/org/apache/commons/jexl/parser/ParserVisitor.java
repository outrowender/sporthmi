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
    default public Object visit(SimpleNode simpleNode, Object object) {
    }

    default public Object visit(ASTJexlScript aSTJexlScript, Object object) {
    }

    default public Object visit(ASTBlock aSTBlock, Object object) {
    }

    default public Object visit(ASTEmptyFunction aSTEmptyFunction, Object object) {
    }

    default public Object visit(ASTSizeFunction aSTSizeFunction, Object object) {
    }

    default public Object visit(ASTIdentifier aSTIdentifier, Object object) {
    }

    default public Object visit(ASTExpression aSTExpression, Object object) {
    }

    default public Object visit(ASTAssignment aSTAssignment, Object object) {
    }

    default public Object visit(ASTOrNode aSTOrNode, Object object) {
    }

    default public Object visit(ASTAndNode aSTAndNode, Object object) {
    }

    default public Object visit(ASTBitwiseOrNode aSTBitwiseOrNode, Object object) {
    }

    default public Object visit(ASTBitwiseXorNode aSTBitwiseXorNode, Object object) {
    }

    default public Object visit(ASTBitwiseAndNode aSTBitwiseAndNode, Object object) {
    }

    default public Object visit(ASTEQNode aSTEQNode, Object object) {
    }

    default public Object visit(ASTNENode aSTNENode, Object object) {
    }

    default public Object visit(ASTLTNode aSTLTNode, Object object) {
    }

    default public Object visit(ASTGTNode aSTGTNode, Object object) {
    }

    default public Object visit(ASTLENode aSTLENode, Object object) {
    }

    default public Object visit(ASTGENode aSTGENode, Object object) {
    }

    default public Object visit(ASTAddNode aSTAddNode, Object object) {
    }

    default public Object visit(ASTSubtractNode aSTSubtractNode, Object object) {
    }

    default public Object visit(ASTMulNode aSTMulNode, Object object) {
    }

    default public Object visit(ASTDivNode aSTDivNode, Object object) {
    }

    default public Object visit(ASTModNode aSTModNode, Object object) {
    }

    default public Object visit(ASTUnaryMinusNode aSTUnaryMinusNode, Object object) {
    }

    default public Object visit(ASTBitwiseComplNode aSTBitwiseComplNode, Object object) {
    }

    default public Object visit(ASTNotNode aSTNotNode, Object object) {
    }

    default public Object visit(ASTNullLiteral aSTNullLiteral, Object object) {
    }

    default public Object visit(ASTTrueNode aSTTrueNode, Object object) {
    }

    default public Object visit(ASTFalseNode aSTFalseNode, Object object) {
    }

    default public Object visit(ASTIntegerLiteral aSTIntegerLiteral, Object object) {
    }

    default public Object visit(ASTFloatLiteral aSTFloatLiteral, Object object) {
    }

    default public Object visit(ASTStringLiteral aSTStringLiteral, Object object) {
    }

    default public Object visit(ASTExpressionExpression aSTExpressionExpression, Object object) {
    }

    default public Object visit(ASTStatementExpression aSTStatementExpression, Object object) {
    }

    default public Object visit(ASTReferenceExpression aSTReferenceExpression, Object object) {
    }

    default public Object visit(ASTIfStatement aSTIfStatement, Object object) {
    }

    default public Object visit(ASTWhileStatement aSTWhileStatement, Object object) {
    }

    default public Object visit(ASTForeachStatement aSTForeachStatement, Object object) {
    }

    default public Object visit(ASTMethod aSTMethod, Object object) {
    }

    default public Object visit(ASTArrayAccess aSTArrayAccess, Object object) {
    }

    default public Object visit(ASTSizeMethod aSTSizeMethod, Object object) {
    }

    default public Object visit(ASTReference aSTReference, Object object) {
    }
}

