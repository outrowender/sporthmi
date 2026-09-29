/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.jexl.parser;

public interface ParserTreeConstants {
    public static final int JJTJEXLSCRIPT;
    public static final int JJTBLOCK;
    public static final int JJTEMPTYFUNCTION;
    public static final int JJTSIZEFUNCTION;
    public static final int JJTIDENTIFIER;
    public static final int JJTEXPRESSION;
    public static final int JJTASSIGNMENT;
    public static final int JJTVOID;
    public static final int JJTORNODE;
    public static final int JJTANDNODE;
    public static final int JJTBITWISEORNODE;
    public static final int JJTBITWISEXORNODE;
    public static final int JJTBITWISEANDNODE;
    public static final int JJTEQNODE;
    public static final int JJTNENODE;
    public static final int JJTLTNODE;
    public static final int JJTGTNODE;
    public static final int JJTLENODE;
    public static final int JJTGENODE;
    public static final int JJTADDNODE;
    public static final int JJTSUBTRACTNODE;
    public static final int JJTMULNODE;
    public static final int JJTDIVNODE;
    public static final int JJTMODNODE;
    public static final int JJTUNARYMINUSNODE;
    public static final int JJTBITWISECOMPLNODE;
    public static final int JJTNOTNODE;
    public static final int JJTNULLLITERAL;
    public static final int JJTTRUENODE;
    public static final int JJTFALSENODE;
    public static final int JJTINTEGERLITERAL;
    public static final int JJTFLOATLITERAL;
    public static final int JJTSTRINGLITERAL;
    public static final int JJTEXPRESSIONEXPRESSION;
    public static final int JJTSTATEMENTEXPRESSION;
    public static final int JJTREFERENCEEXPRESSION;
    public static final int JJTIFSTATEMENT;
    public static final int JJTWHILESTATEMENT;
    public static final int JJTFOREACHSTATEMENT;
    public static final int JJTMETHOD;
    public static final int JJTARRAYACCESS;
    public static final int JJTSIZEMETHOD;
    public static final int JJTREFERENCE;
    public static final String[] jjtNodeName;

    static {
        jjtNodeName = new String[]{"JexlScript", "Block", "EmptyFunction", "SizeFunction", "Identifier", "Expression", "Assignment", "void", "OrNode", "AndNode", "BitwiseOrNode", "BitwiseXorNode", "BitwiseAndNode", "EQNode", "NENode", "LTNode", "GTNode", "LENode", "GENode", "AddNode", "SubtractNode", "MulNode", "DivNode", "ModNode", "UnaryMinusNode", "BitwiseComplNode", "NotNode", "NullLiteral", "TrueNode", "FalseNode", "IntegerLiteral", "FloatLiteral", "StringLiteral", "ExpressionExpression", "StatementExpression", "ReferenceExpression", "IfStatement", "WhileStatement", "ForeachStatement", "Method", "ArrayAccess", "SizeMethod", "Reference"};
    }
}

