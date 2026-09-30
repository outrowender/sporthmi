/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.jexl.parser;

import java.io.InputStream;
import java.io.Reader;
import java.util.Enumeration;
import java.util.Vector;
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
import org.apache.commons.jexl.parser.JJTParserState;
import org.apache.commons.jexl.parser.Node;
import org.apache.commons.jexl.parser.ParseException;
import org.apache.commons.jexl.parser.ParserConstants;
import org.apache.commons.jexl.parser.ParserTokenManager;
import org.apache.commons.jexl.parser.ParserTreeConstants;
import org.apache.commons.jexl.parser.SimpleCharStream;
import org.apache.commons.jexl.parser.SimpleNode;
import org.apache.commons.jexl.parser.Token;

public class Parser
implements ParserTreeConstants,
ParserConstants {
    protected JJTParserState jjtree = new JJTParserState();
    public ParserTokenManager token_source;
    SimpleCharStream jj_input_stream;
    public Token token;
    public Token jj_nt;
    private int jj_ntk;
    private Token jj_scanpos;
    private Token jj_lastpos;
    private int jj_la;
    public boolean lookingAhead = false;
    private boolean jj_semLA;
    private int jj_gen;
    private final int[] jj_la1 = new int[34];
    private final int[] jj_la1_0 = new int[]{23424, 23424, 4096, 22912, 196608, 196608, 786432, 786432, 0x100000, 0x200000, 0x400000, 0x7800000, 0x7800000, -134217728, -134217728, 0, 0, 0, 0, 22912, 22912, 384, 0, 512, 22912, 0, 0, 22912, 128, 0, 0, 16512, 16512, 384};
    private final int[] jj_la1_1 = new int[]{605813776, 605813776, 0x4000000, 604044304, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 7, 24, 24, 992, 992, 604044304, 604037120, 0x2000E000, 49152, 65536, 605748240, 262144, 0x400000, 604044304, 0x4000000, 0x800000, 0x4000000, 0x4000000, 0x4000000, 604037120};
    private final JJCalls[] jj_2_rtns = new JJCalls[9];
    private boolean jj_rescan = false;
    private int jj_gc = 0;
    private Vector jj_expentries = new Vector();
    private int[] jj_expentry;
    private int jj_kind = -1;
    private int[] jj_lasttokens = new int[100];
    private int jj_endpos;

    public SimpleNode parse(Reader reader) throws Exception {
        this.ReInit(reader);
        SimpleNode simpleNode = this.JexlScript();
        return simpleNode;
    }

    public final SimpleNode JexlScript() throws ParseException {
        ASTJexlScript aSTJexlScript = new ASTJexlScript(this, 0);
        boolean bl = true;
        this.jjtree.openNodeScope(aSTJexlScript);
        try {
            block8: while (true) {
                switch (this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
                    case 7: 
                    case 8: 
                    case 9: 
                    case 11: 
                    case 12: 
                    case 14: 
                    case 36: 
                    case 42: 
                    case 43: 
                    case 44: 
                    case 45: 
                    case 46: 
                    case 47: 
                    case 48: 
                    case 49: 
                    case 51: 
                    case 52: 
                    case 58: 
                    case 61: {
                        break;
                    }
                    default: {
                        this.jj_la1[0] = this.jj_gen;
                        break block8;
                    }
                }
                this.Statement();
            }
            this.jj_consume_token(0);
            this.jjtree.closeNodeScope((Node)aSTJexlScript, true);
            bl = false;
            ASTJexlScript aSTJexlScript2 = aSTJexlScript;
            return aSTJexlScript2;
        }
        catch (Throwable throwable) {
            if (bl) {
                this.jjtree.clearNodeScope(aSTJexlScript);
                bl = false;
            } else {
                this.jjtree.popNode();
            }
            if (throwable instanceof RuntimeException) {
                throw (RuntimeException)throwable;
            }
            if (throwable instanceof ParseException) {
                throw (ParseException)throwable;
            }
            throw (Error)throwable;
        }
        finally {
            if (bl) {
                this.jjtree.closeNodeScope((Node)aSTJexlScript, true);
            }
        }
    }

    public final void Block() throws ParseException {
        ASTBlock aSTBlock = new ASTBlock(this, 1);
        boolean bl = true;
        this.jjtree.openNodeScope(aSTBlock);
        try {
            this.jj_consume_token(9);
            block8: while (true) {
                switch (this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
                    case 7: 
                    case 8: 
                    case 9: 
                    case 11: 
                    case 12: 
                    case 14: 
                    case 36: 
                    case 42: 
                    case 43: 
                    case 44: 
                    case 45: 
                    case 46: 
                    case 47: 
                    case 48: 
                    case 49: 
                    case 51: 
                    case 52: 
                    case 58: 
                    case 61: {
                        break;
                    }
                    default: {
                        this.jj_la1[1] = this.jj_gen;
                        break block8;
                    }
                }
                this.Statement();
            }
            this.jj_consume_token(10);
        }
        catch (Throwable throwable) {
            if (bl) {
                this.jjtree.clearNodeScope(aSTBlock);
                bl = false;
            } else {
                this.jjtree.popNode();
            }
            if (throwable instanceof RuntimeException) {
                throw (RuntimeException)throwable;
            }
            if (throwable instanceof ParseException) {
                throw (ParseException)throwable;
            }
            throw (Error)throwable;
        }
        finally {
            if (bl) {
                this.jjtree.closeNodeScope((Node)aSTBlock, true);
            }
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final void EmptyFunction() throws ParseException {
        ASTEmptyFunction aSTEmptyFunction = new ASTEmptyFunction(this, 2);
        boolean bl = true;
        this.jjtree.openNodeScope(aSTEmptyFunction);
        try {
            this.jj_consume_token(11);
            switch (this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
                case 58: {
                    this.Reference();
                    return;
                }
                case 12: {
                    this.jj_consume_token(12);
                    this.Reference();
                    this.jj_consume_token(13);
                    return;
                }
                default: {
                    this.jj_la1[2] = this.jj_gen;
                    this.jj_consume_token(-1);
                    throw new ParseException();
                }
            }
        }
        catch (Throwable throwable) {
            if (bl) {
                this.jjtree.clearNodeScope(aSTEmptyFunction);
                bl = false;
            } else {
                this.jjtree.popNode();
            }
            if (throwable instanceof RuntimeException) {
                throw (RuntimeException)throwable;
            }
            if (!(throwable instanceof ParseException)) throw (Error)throwable;
            throw (ParseException)throwable;
        }
        finally {
            if (bl) {
                this.jjtree.closeNodeScope((Node)aSTEmptyFunction, true);
            }
        }
    }

    public final void SizeFunction() throws ParseException {
        ASTSizeFunction aSTSizeFunction = new ASTSizeFunction(this, 3);
        boolean bl = true;
        this.jjtree.openNodeScope(aSTSizeFunction);
        try {
            this.jj_consume_token(14);
            this.jj_consume_token(12);
            this.Reference();
            this.jj_consume_token(13);
        }
        catch (Throwable throwable) {
            if (bl) {
                this.jjtree.clearNodeScope(aSTSizeFunction);
                bl = false;
            } else {
                this.jjtree.popNode();
            }
            if (throwable instanceof RuntimeException) {
                throw (RuntimeException)throwable;
            }
            if (throwable instanceof ParseException) {
                throw (ParseException)throwable;
            }
            throw (Error)throwable;
        }
        finally {
            if (bl) {
                this.jjtree.closeNodeScope((Node)aSTSizeFunction, true);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final void Identifier() throws ParseException {
        ASTIdentifier aSTIdentifier = new ASTIdentifier(this, 4);
        boolean bl = true;
        this.jjtree.openNodeScope(aSTIdentifier);
        try {
            Token token = this.jj_consume_token(58);
            this.jjtree.closeNodeScope((Node)aSTIdentifier, true);
            bl = false;
            aSTIdentifier.val = token.image;
        }
        finally {
            if (bl) {
                this.jjtree.closeNodeScope((Node)aSTIdentifier, true);
            }
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final void Expression() throws ParseException {
        ASTExpression aSTExpression = new ASTExpression(this, 5);
        boolean bl = true;
        this.jjtree.openNodeScope(aSTExpression);
        try {
            if (this.jj_2_1(Integer.MAX_VALUE)) {
                this.Assignment();
                return;
            }
            switch (this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
                case 7: 
                case 8: 
                case 11: 
                case 12: 
                case 14: 
                case 36: 
                case 42: 
                case 43: 
                case 44: 
                case 45: 
                case 46: 
                case 47: 
                case 58: 
                case 61: {
                    this.ConditionalOrExpression();
                    return;
                }
                default: {
                    this.jj_la1[3] = this.jj_gen;
                    this.jj_consume_token(-1);
                    throw new ParseException();
                }
            }
        }
        catch (Throwable throwable) {
            if (bl) {
                this.jjtree.clearNodeScope(aSTExpression);
                bl = false;
            } else {
                this.jjtree.popNode();
            }
            if (throwable instanceof RuntimeException) {
                throw (RuntimeException)throwable;
            }
            if (!(throwable instanceof ParseException)) throw (Error)throwable;
            throw (ParseException)throwable;
        }
        finally {
            if (bl) {
                this.jjtree.closeNodeScope((Node)aSTExpression, true);
            }
        }
    }

    public final void Assignment() throws ParseException {
        ASTAssignment aSTAssignment = new ASTAssignment(this, 6);
        boolean bl = true;
        this.jjtree.openNodeScope(aSTAssignment);
        try {
            this.PrimaryExpression();
            this.jj_consume_token(15);
            this.Expression();
        }
        catch (Throwable throwable) {
            if (bl) {
                this.jjtree.clearNodeScope(aSTAssignment);
                bl = false;
            } else {
                this.jjtree.popNode();
            }
            if (throwable instanceof RuntimeException) {
                throw (RuntimeException)throwable;
            }
            if (throwable instanceof ParseException) {
                throw (ParseException)throwable;
            }
            throw (Error)throwable;
        }
        finally {
            if (bl) {
                this.jjtree.closeNodeScope((Node)aSTAssignment, 2);
            }
        }
    }

    public final void ConditionalOrExpression() throws ParseException {
        this.ConditionalAndExpression();
        block17: while (true) {
            switch (this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
                case 16: 
                case 17: {
                    break;
                }
                default: {
                    this.jj_la1[4] = this.jj_gen;
                    break block17;
                }
            }
            switch (this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
                case 16: {
                    this.jj_consume_token(16);
                    ASTOrNode aSTOrNode = new ASTOrNode(this, 8);
                    boolean bl = true;
                    this.jjtree.openNodeScope(aSTOrNode);
                    try {
                        this.ConditionalAndExpression();
                        continue block17;
                    }
                    catch (Throwable throwable) {
                        if (bl) {
                            this.jjtree.clearNodeScope(aSTOrNode);
                            bl = false;
                        } else {
                            this.jjtree.popNode();
                        }
                        if (throwable instanceof RuntimeException) {
                            throw (RuntimeException)throwable;
                        }
                        if (throwable instanceof ParseException) {
                            throw (ParseException)throwable;
                        }
                        throw (Error)throwable;
                    }
                    finally {
                        if (!bl) continue block17;
                        this.jjtree.closeNodeScope((Node)aSTOrNode, 2);
                        continue block17;
                    }
                }
                case 17: {
                    this.jj_consume_token(17);
                    ASTOrNode aSTOrNode = new ASTOrNode(this, 8);
                    boolean bl = true;
                    this.jjtree.openNodeScope(aSTOrNode);
                    try {
                        this.ConditionalAndExpression();
                        continue block17;
                    }
                    catch (Throwable throwable) {
                        if (bl) {
                            this.jjtree.clearNodeScope(aSTOrNode);
                            bl = false;
                        } else {
                            this.jjtree.popNode();
                        }
                        if (throwable instanceof RuntimeException) {
                            throw (RuntimeException)throwable;
                        }
                        if (throwable instanceof ParseException) {
                            throw (ParseException)throwable;
                        }
                        throw (Error)throwable;
                    }
                    finally {
                        if (!bl) continue block17;
                        this.jjtree.closeNodeScope((Node)aSTOrNode, 2);
                        continue block17;
                    }
                }
                default: {
                    this.jj_la1[5] = this.jj_gen;
                    this.jj_consume_token(-1);
                    throw new ParseException();
                }
            }
            break;
        }
    }

    public final void ConditionalAndExpression() throws ParseException {
        this.InclusiveOrExpression();
        block17: while (true) {
            switch (this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
                case 18: 
                case 19: {
                    break;
                }
                default: {
                    this.jj_la1[6] = this.jj_gen;
                    break block17;
                }
            }
            switch (this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
                case 18: {
                    this.jj_consume_token(18);
                    ASTAndNode aSTAndNode = new ASTAndNode(this, 9);
                    boolean bl = true;
                    this.jjtree.openNodeScope(aSTAndNode);
                    try {
                        this.InclusiveOrExpression();
                        continue block17;
                    }
                    catch (Throwable throwable) {
                        if (bl) {
                            this.jjtree.clearNodeScope(aSTAndNode);
                            bl = false;
                        } else {
                            this.jjtree.popNode();
                        }
                        if (throwable instanceof RuntimeException) {
                            throw (RuntimeException)throwable;
                        }
                        if (throwable instanceof ParseException) {
                            throw (ParseException)throwable;
                        }
                        throw (Error)throwable;
                    }
                    finally {
                        if (!bl) continue block17;
                        this.jjtree.closeNodeScope((Node)aSTAndNode, 2);
                        continue block17;
                    }
                }
                case 19: {
                    this.jj_consume_token(19);
                    ASTAndNode aSTAndNode = new ASTAndNode(this, 9);
                    boolean bl = true;
                    this.jjtree.openNodeScope(aSTAndNode);
                    try {
                        this.InclusiveOrExpression();
                        continue block17;
                    }
                    catch (Throwable throwable) {
                        if (bl) {
                            this.jjtree.clearNodeScope(aSTAndNode);
                            bl = false;
                        } else {
                            this.jjtree.popNode();
                        }
                        if (throwable instanceof RuntimeException) {
                            throw (RuntimeException)throwable;
                        }
                        if (throwable instanceof ParseException) {
                            throw (ParseException)throwable;
                        }
                        throw (Error)throwable;
                    }
                    finally {
                        if (!bl) continue block17;
                        this.jjtree.closeNodeScope((Node)aSTAndNode, 2);
                        continue block17;
                    }
                }
                default: {
                    this.jj_la1[7] = this.jj_gen;
                    this.jj_consume_token(-1);
                    throw new ParseException();
                }
            }
            break;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void InclusiveOrExpression() throws ParseException {
        this.ExclusiveOrExpression();
        while (true) {
            switch (this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
                case 20: {
                    break;
                }
                default: {
                    this.jj_la1[8] = this.jj_gen;
                    return;
                }
            }
            this.jj_consume_token(20);
            ASTBitwiseOrNode aSTBitwiseOrNode = new ASTBitwiseOrNode(this, 10);
            boolean bl = true;
            this.jjtree.openNodeScope(aSTBitwiseOrNode);
            try {
                this.ExclusiveOrExpression();
                continue;
            }
            catch (Throwable throwable) {
                if (bl) {
                    this.jjtree.clearNodeScope(aSTBitwiseOrNode);
                    bl = false;
                } else {
                    this.jjtree.popNode();
                }
                if (throwable instanceof RuntimeException) {
                    throw (RuntimeException)throwable;
                }
                if (!(throwable instanceof ParseException)) throw (Error)throwable;
                throw (ParseException)throwable;
            }
            finally {
                if (!bl) continue;
                this.jjtree.closeNodeScope((Node)aSTBitwiseOrNode, 2);
                continue;
            }
            break;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void ExclusiveOrExpression() throws ParseException {
        this.AndExpression();
        while (true) {
            switch (this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
                case 21: {
                    break;
                }
                default: {
                    this.jj_la1[9] = this.jj_gen;
                    return;
                }
            }
            this.jj_consume_token(21);
            ASTBitwiseXorNode aSTBitwiseXorNode = new ASTBitwiseXorNode(this, 11);
            boolean bl = true;
            this.jjtree.openNodeScope(aSTBitwiseXorNode);
            try {
                this.AndExpression();
                continue;
            }
            catch (Throwable throwable) {
                if (bl) {
                    this.jjtree.clearNodeScope(aSTBitwiseXorNode);
                    bl = false;
                } else {
                    this.jjtree.popNode();
                }
                if (throwable instanceof RuntimeException) {
                    throw (RuntimeException)throwable;
                }
                if (!(throwable instanceof ParseException)) throw (Error)throwable;
                throw (ParseException)throwable;
            }
            finally {
                if (!bl) continue;
                this.jjtree.closeNodeScope((Node)aSTBitwiseXorNode, 2);
                continue;
            }
            break;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void AndExpression() throws ParseException {
        this.EqualityExpression();
        while (true) {
            switch (this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
                case 22: {
                    break;
                }
                default: {
                    this.jj_la1[10] = this.jj_gen;
                    return;
                }
            }
            this.jj_consume_token(22);
            ASTBitwiseAndNode aSTBitwiseAndNode = new ASTBitwiseAndNode(this, 12);
            boolean bl = true;
            this.jjtree.openNodeScope(aSTBitwiseAndNode);
            try {
                this.EqualityExpression();
                continue;
            }
            catch (Throwable throwable) {
                if (bl) {
                    this.jjtree.clearNodeScope(aSTBitwiseAndNode);
                    bl = false;
                } else {
                    this.jjtree.popNode();
                }
                if (throwable instanceof RuntimeException) {
                    throw (RuntimeException)throwable;
                }
                if (!(throwable instanceof ParseException)) throw (Error)throwable;
                throw (ParseException)throwable;
            }
            finally {
                if (!bl) continue;
                this.jjtree.closeNodeScope((Node)aSTBitwiseAndNode, 2);
                continue;
            }
            break;
        }
    }

    public final void EqualityExpression() throws ParseException {
        this.RelationalExpression();
        block29: while (true) {
            switch (this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
                case 23: 
                case 24: 
                case 25: 
                case 26: {
                    break;
                }
                default: {
                    this.jj_la1[11] = this.jj_gen;
                    break block29;
                }
            }
            switch (this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
                case 23: {
                    this.jj_consume_token(23);
                    ASTEQNode aSTEQNode = new ASTEQNode(this, 13);
                    boolean bl = true;
                    this.jjtree.openNodeScope(aSTEQNode);
                    try {
                        this.RelationalExpression();
                        continue block29;
                    }
                    catch (Throwable throwable) {
                        if (bl) {
                            this.jjtree.clearNodeScope(aSTEQNode);
                            bl = false;
                        } else {
                            this.jjtree.popNode();
                        }
                        if (throwable instanceof RuntimeException) {
                            throw (RuntimeException)throwable;
                        }
                        if (throwable instanceof ParseException) {
                            throw (ParseException)throwable;
                        }
                        throw (Error)throwable;
                    }
                    finally {
                        if (!bl) continue block29;
                        this.jjtree.closeNodeScope((Node)aSTEQNode, 2);
                        continue block29;
                    }
                }
                case 24: {
                    this.jj_consume_token(24);
                    ASTEQNode aSTEQNode = new ASTEQNode(this, 13);
                    boolean bl = true;
                    this.jjtree.openNodeScope(aSTEQNode);
                    try {
                        this.RelationalExpression();
                        continue block29;
                    }
                    catch (Throwable throwable) {
                        if (bl) {
                            this.jjtree.clearNodeScope(aSTEQNode);
                            bl = false;
                        } else {
                            this.jjtree.popNode();
                        }
                        if (throwable instanceof RuntimeException) {
                            throw (RuntimeException)throwable;
                        }
                        if (throwable instanceof ParseException) {
                            throw (ParseException)throwable;
                        }
                        throw (Error)throwable;
                    }
                    finally {
                        if (!bl) continue block29;
                        this.jjtree.closeNodeScope((Node)aSTEQNode, 2);
                        continue block29;
                    }
                }
                case 25: {
                    this.jj_consume_token(25);
                    ASTNENode aSTNENode = new ASTNENode(this, 14);
                    boolean bl = true;
                    this.jjtree.openNodeScope(aSTNENode);
                    try {
                        this.RelationalExpression();
                        continue block29;
                    }
                    catch (Throwable throwable) {
                        if (bl) {
                            this.jjtree.clearNodeScope(aSTNENode);
                            bl = false;
                        } else {
                            this.jjtree.popNode();
                        }
                        if (throwable instanceof RuntimeException) {
                            throw (RuntimeException)throwable;
                        }
                        if (throwable instanceof ParseException) {
                            throw (ParseException)throwable;
                        }
                        throw (Error)throwable;
                    }
                    finally {
                        if (!bl) continue block29;
                        this.jjtree.closeNodeScope((Node)aSTNENode, 2);
                        continue block29;
                    }
                }
                case 26: {
                    this.jj_consume_token(26);
                    ASTNENode aSTNENode = new ASTNENode(this, 14);
                    boolean bl = true;
                    this.jjtree.openNodeScope(aSTNENode);
                    try {
                        this.RelationalExpression();
                        continue block29;
                    }
                    catch (Throwable throwable) {
                        if (bl) {
                            this.jjtree.clearNodeScope(aSTNENode);
                            bl = false;
                        } else {
                            this.jjtree.popNode();
                        }
                        if (throwable instanceof RuntimeException) {
                            throw (RuntimeException)throwable;
                        }
                        if (throwable instanceof ParseException) {
                            throw (ParseException)throwable;
                        }
                        throw (Error)throwable;
                    }
                    finally {
                        if (!bl) continue block29;
                        this.jjtree.closeNodeScope((Node)aSTNENode, 2);
                        continue block29;
                    }
                }
                default: {
                    this.jj_la1[12] = this.jj_gen;
                    this.jj_consume_token(-1);
                    throw new ParseException();
                }
            }
            break;
        }
    }

    public final void RelationalExpression() throws ParseException {
        this.AdditiveExpression();
        block53: while (true) {
            switch (this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
                case 27: 
                case 28: 
                case 29: 
                case 30: 
                case 31: 
                case 32: 
                case 33: 
                case 34: {
                    break;
                }
                default: {
                    this.jj_la1[13] = this.jj_gen;
                    break block53;
                }
            }
            switch (this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
                case 27: {
                    this.jj_consume_token(27);
                    ASTLTNode aSTLTNode = new ASTLTNode(this, 15);
                    boolean bl = true;
                    this.jjtree.openNodeScope(aSTLTNode);
                    try {
                        this.AdditiveExpression();
                        continue block53;
                    }
                    catch (Throwable throwable) {
                        if (bl) {
                            this.jjtree.clearNodeScope(aSTLTNode);
                            bl = false;
                        } else {
                            this.jjtree.popNode();
                        }
                        if (throwable instanceof RuntimeException) {
                            throw (RuntimeException)throwable;
                        }
                        if (throwable instanceof ParseException) {
                            throw (ParseException)throwable;
                        }
                        throw (Error)throwable;
                    }
                    finally {
                        if (!bl) continue block53;
                        this.jjtree.closeNodeScope((Node)aSTLTNode, 2);
                        continue block53;
                    }
                }
                case 28: {
                    this.jj_consume_token(28);
                    ASTLTNode aSTLTNode = new ASTLTNode(this, 15);
                    boolean bl = true;
                    this.jjtree.openNodeScope(aSTLTNode);
                    try {
                        this.AdditiveExpression();
                        continue block53;
                    }
                    catch (Throwable throwable) {
                        if (bl) {
                            this.jjtree.clearNodeScope(aSTLTNode);
                            bl = false;
                        } else {
                            this.jjtree.popNode();
                        }
                        if (throwable instanceof RuntimeException) {
                            throw (RuntimeException)throwable;
                        }
                        if (throwable instanceof ParseException) {
                            throw (ParseException)throwable;
                        }
                        throw (Error)throwable;
                    }
                    finally {
                        if (!bl) continue block53;
                        this.jjtree.closeNodeScope((Node)aSTLTNode, 2);
                        continue block53;
                    }
                }
                case 29: {
                    this.jj_consume_token(29);
                    ASTGTNode aSTGTNode = new ASTGTNode(this, 16);
                    boolean bl = true;
                    this.jjtree.openNodeScope(aSTGTNode);
                    try {
                        this.AdditiveExpression();
                        continue block53;
                    }
                    catch (Throwable throwable) {
                        if (bl) {
                            this.jjtree.clearNodeScope(aSTGTNode);
                            bl = false;
                        } else {
                            this.jjtree.popNode();
                        }
                        if (throwable instanceof RuntimeException) {
                            throw (RuntimeException)throwable;
                        }
                        if (throwable instanceof ParseException) {
                            throw (ParseException)throwable;
                        }
                        throw (Error)throwable;
                    }
                    finally {
                        if (!bl) continue block53;
                        this.jjtree.closeNodeScope((Node)aSTGTNode, 2);
                        continue block53;
                    }
                }
                case 30: {
                    this.jj_consume_token(30);
                    ASTGTNode aSTGTNode = new ASTGTNode(this, 16);
                    boolean bl = true;
                    this.jjtree.openNodeScope(aSTGTNode);
                    try {
                        this.AdditiveExpression();
                        continue block53;
                    }
                    catch (Throwable throwable) {
                        if (bl) {
                            this.jjtree.clearNodeScope(aSTGTNode);
                            bl = false;
                        } else {
                            this.jjtree.popNode();
                        }
                        if (throwable instanceof RuntimeException) {
                            throw (RuntimeException)throwable;
                        }
                        if (throwable instanceof ParseException) {
                            throw (ParseException)throwable;
                        }
                        throw (Error)throwable;
                    }
                    finally {
                        if (!bl) continue block53;
                        this.jjtree.closeNodeScope((Node)aSTGTNode, 2);
                        continue block53;
                    }
                }
                case 31: {
                    this.jj_consume_token(31);
                    ASTLENode aSTLENode = new ASTLENode(this, 17);
                    boolean bl = true;
                    this.jjtree.openNodeScope(aSTLENode);
                    try {
                        this.AdditiveExpression();
                        continue block53;
                    }
                    catch (Throwable throwable) {
                        if (bl) {
                            this.jjtree.clearNodeScope(aSTLENode);
                            bl = false;
                        } else {
                            this.jjtree.popNode();
                        }
                        if (throwable instanceof RuntimeException) {
                            throw (RuntimeException)throwable;
                        }
                        if (throwable instanceof ParseException) {
                            throw (ParseException)throwable;
                        }
                        throw (Error)throwable;
                    }
                    finally {
                        if (!bl) continue block53;
                        this.jjtree.closeNodeScope((Node)aSTLENode, 2);
                        continue block53;
                    }
                }
                case 32: {
                    this.jj_consume_token(32);
                    ASTLENode aSTLENode = new ASTLENode(this, 17);
                    boolean bl = true;
                    this.jjtree.openNodeScope(aSTLENode);
                    try {
                        this.AdditiveExpression();
                        continue block53;
                    }
                    catch (Throwable throwable) {
                        if (bl) {
                            this.jjtree.clearNodeScope(aSTLENode);
                            bl = false;
                        } else {
                            this.jjtree.popNode();
                        }
                        if (throwable instanceof RuntimeException) {
                            throw (RuntimeException)throwable;
                        }
                        if (throwable instanceof ParseException) {
                            throw (ParseException)throwable;
                        }
                        throw (Error)throwable;
                    }
                    finally {
                        if (!bl) continue block53;
                        this.jjtree.closeNodeScope((Node)aSTLENode, 2);
                        continue block53;
                    }
                }
                case 33: {
                    this.jj_consume_token(33);
                    ASTGENode aSTGENode = new ASTGENode(this, 18);
                    boolean bl = true;
                    this.jjtree.openNodeScope(aSTGENode);
                    try {
                        this.AdditiveExpression();
                        continue block53;
                    }
                    catch (Throwable throwable) {
                        if (bl) {
                            this.jjtree.clearNodeScope(aSTGENode);
                            bl = false;
                        } else {
                            this.jjtree.popNode();
                        }
                        if (throwable instanceof RuntimeException) {
                            throw (RuntimeException)throwable;
                        }
                        if (throwable instanceof ParseException) {
                            throw (ParseException)throwable;
                        }
                        throw (Error)throwable;
                    }
                    finally {
                        if (!bl) continue block53;
                        this.jjtree.closeNodeScope((Node)aSTGENode, 2);
                        continue block53;
                    }
                }
                case 34: {
                    this.jj_consume_token(34);
                    ASTGENode aSTGENode = new ASTGENode(this, 18);
                    boolean bl = true;
                    this.jjtree.openNodeScope(aSTGENode);
                    try {
                        this.AdditiveExpression();
                        continue block53;
                    }
                    catch (Throwable throwable) {
                        if (bl) {
                            this.jjtree.clearNodeScope(aSTGENode);
                            bl = false;
                        } else {
                            this.jjtree.popNode();
                        }
                        if (throwable instanceof RuntimeException) {
                            throw (RuntimeException)throwable;
                        }
                        if (throwable instanceof ParseException) {
                            throw (ParseException)throwable;
                        }
                        throw (Error)throwable;
                    }
                    finally {
                        if (!bl) continue block53;
                        this.jjtree.closeNodeScope((Node)aSTGENode, 2);
                        continue block53;
                    }
                }
                default: {
                    this.jj_la1[14] = this.jj_gen;
                    this.jj_consume_token(-1);
                    throw new ParseException();
                }
            }
            break;
        }
    }

    public final void AdditiveExpression() throws ParseException {
        this.MultiplicativeExpression();
        block17: while (true) {
            switch (this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
                case 35: 
                case 36: {
                    break;
                }
                default: {
                    this.jj_la1[15] = this.jj_gen;
                    break block17;
                }
            }
            switch (this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
                case 35: {
                    this.jj_consume_token(35);
                    ASTAddNode aSTAddNode = new ASTAddNode(this, 19);
                    boolean bl = true;
                    this.jjtree.openNodeScope(aSTAddNode);
                    try {
                        this.MultiplicativeExpression();
                        continue block17;
                    }
                    catch (Throwable throwable) {
                        if (bl) {
                            this.jjtree.clearNodeScope(aSTAddNode);
                            bl = false;
                        } else {
                            this.jjtree.popNode();
                        }
                        if (throwable instanceof RuntimeException) {
                            throw (RuntimeException)throwable;
                        }
                        if (throwable instanceof ParseException) {
                            throw (ParseException)throwable;
                        }
                        throw (Error)throwable;
                    }
                    finally {
                        if (!bl) continue block17;
                        this.jjtree.closeNodeScope((Node)aSTAddNode, 2);
                        continue block17;
                    }
                }
                case 36: {
                    this.jj_consume_token(36);
                    ASTSubtractNode aSTSubtractNode = new ASTSubtractNode(this, 20);
                    boolean bl = true;
                    this.jjtree.openNodeScope(aSTSubtractNode);
                    try {
                        this.MultiplicativeExpression();
                        continue block17;
                    }
                    catch (Throwable throwable) {
                        if (bl) {
                            this.jjtree.clearNodeScope(aSTSubtractNode);
                            bl = false;
                        } else {
                            this.jjtree.popNode();
                        }
                        if (throwable instanceof RuntimeException) {
                            throw (RuntimeException)throwable;
                        }
                        if (throwable instanceof ParseException) {
                            throw (ParseException)throwable;
                        }
                        throw (Error)throwable;
                    }
                    finally {
                        if (!bl) continue block17;
                        this.jjtree.closeNodeScope((Node)aSTSubtractNode, 2);
                        continue block17;
                    }
                }
                default: {
                    this.jj_la1[16] = this.jj_gen;
                    this.jj_consume_token(-1);
                    throw new ParseException();
                }
            }
            break;
        }
    }

    public final void MultiplicativeExpression() throws ParseException {
        this.UnaryExpression();
        block35: while (true) {
            switch (this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
                case 37: 
                case 38: 
                case 39: 
                case 40: 
                case 41: {
                    break;
                }
                default: {
                    this.jj_la1[17] = this.jj_gen;
                    break block35;
                }
            }
            switch (this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
                case 37: {
                    this.jj_consume_token(37);
                    ASTMulNode aSTMulNode = new ASTMulNode(this, 21);
                    boolean bl = true;
                    this.jjtree.openNodeScope(aSTMulNode);
                    try {
                        this.UnaryExpression();
                        continue block35;
                    }
                    catch (Throwable throwable) {
                        if (bl) {
                            this.jjtree.clearNodeScope(aSTMulNode);
                            bl = false;
                        } else {
                            this.jjtree.popNode();
                        }
                        if (throwable instanceof RuntimeException) {
                            throw (RuntimeException)throwable;
                        }
                        if (throwable instanceof ParseException) {
                            throw (ParseException)throwable;
                        }
                        throw (Error)throwable;
                    }
                    finally {
                        if (!bl) continue block35;
                        this.jjtree.closeNodeScope((Node)aSTMulNode, 2);
                        continue block35;
                    }
                }
                case 38: {
                    this.jj_consume_token(38);
                    ASTDivNode aSTDivNode = new ASTDivNode(this, 22);
                    boolean bl = true;
                    this.jjtree.openNodeScope(aSTDivNode);
                    try {
                        this.UnaryExpression();
                        continue block35;
                    }
                    catch (Throwable throwable) {
                        if (bl) {
                            this.jjtree.clearNodeScope(aSTDivNode);
                            bl = false;
                        } else {
                            this.jjtree.popNode();
                        }
                        if (throwable instanceof RuntimeException) {
                            throw (RuntimeException)throwable;
                        }
                        if (throwable instanceof ParseException) {
                            throw (ParseException)throwable;
                        }
                        throw (Error)throwable;
                    }
                    finally {
                        if (!bl) continue block35;
                        this.jjtree.closeNodeScope((Node)aSTDivNode, 2);
                        continue block35;
                    }
                }
                case 39: {
                    this.jj_consume_token(39);
                    ASTDivNode aSTDivNode = new ASTDivNode(this, 22);
                    boolean bl = true;
                    this.jjtree.openNodeScope(aSTDivNode);
                    try {
                        this.UnaryExpression();
                        continue block35;
                    }
                    catch (Throwable throwable) {
                        if (bl) {
                            this.jjtree.clearNodeScope(aSTDivNode);
                            bl = false;
                        } else {
                            this.jjtree.popNode();
                        }
                        if (throwable instanceof RuntimeException) {
                            throw (RuntimeException)throwable;
                        }
                        if (throwable instanceof ParseException) {
                            throw (ParseException)throwable;
                        }
                        throw (Error)throwable;
                    }
                    finally {
                        if (!bl) continue block35;
                        this.jjtree.closeNodeScope((Node)aSTDivNode, 2);
                        continue block35;
                    }
                }
                case 40: {
                    this.jj_consume_token(40);
                    ASTModNode aSTModNode = new ASTModNode(this, 23);
                    boolean bl = true;
                    this.jjtree.openNodeScope(aSTModNode);
                    try {
                        this.UnaryExpression();
                        continue block35;
                    }
                    catch (Throwable throwable) {
                        if (bl) {
                            this.jjtree.clearNodeScope(aSTModNode);
                            bl = false;
                        } else {
                            this.jjtree.popNode();
                        }
                        if (throwable instanceof RuntimeException) {
                            throw (RuntimeException)throwable;
                        }
                        if (throwable instanceof ParseException) {
                            throw (ParseException)throwable;
                        }
                        throw (Error)throwable;
                    }
                    finally {
                        if (!bl) continue block35;
                        this.jjtree.closeNodeScope((Node)aSTModNode, 2);
                        continue block35;
                    }
                }
                case 41: {
                    this.jj_consume_token(41);
                    ASTModNode aSTModNode = new ASTModNode(this, 23);
                    boolean bl = true;
                    this.jjtree.openNodeScope(aSTModNode);
                    try {
                        this.UnaryExpression();
                        continue block35;
                    }
                    catch (Throwable throwable) {
                        if (bl) {
                            this.jjtree.clearNodeScope(aSTModNode);
                            bl = false;
                        } else {
                            this.jjtree.popNode();
                        }
                        if (throwable instanceof RuntimeException) {
                            throw (RuntimeException)throwable;
                        }
                        if (throwable instanceof ParseException) {
                            throw (ParseException)throwable;
                        }
                        throw (Error)throwable;
                    }
                    finally {
                        if (!bl) continue block35;
                        this.jjtree.closeNodeScope((Node)aSTModNode, 2);
                        continue block35;
                    }
                }
                default: {
                    this.jj_la1[18] = this.jj_gen;
                    this.jj_consume_token(-1);
                    throw new ParseException();
                }
            }
            break;
        }
    }

    public final void UnaryExpression() throws ParseException {
        switch (this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
            case 36: {
                this.jj_consume_token(36);
                ASTUnaryMinusNode aSTUnaryMinusNode = new ASTUnaryMinusNode(this, 24);
                boolean bl = true;
                this.jjtree.openNodeScope(aSTUnaryMinusNode);
                try {
                    this.UnaryExpression();
                    break;
                }
                catch (Throwable throwable) {
                    if (bl) {
                        this.jjtree.clearNodeScope(aSTUnaryMinusNode);
                        bl = false;
                    } else {
                        this.jjtree.popNode();
                    }
                    if (throwable instanceof RuntimeException) {
                        throw (RuntimeException)throwable;
                    }
                    if (throwable instanceof ParseException) {
                        throw (ParseException)throwable;
                    }
                    throw (Error)throwable;
                }
                finally {
                    if (bl) {
                        this.jjtree.closeNodeScope((Node)aSTUnaryMinusNode, 1);
                    }
                }
            }
            case 42: {
                this.jj_consume_token(42);
                ASTBitwiseComplNode aSTBitwiseComplNode = new ASTBitwiseComplNode(this, 25);
                boolean bl = true;
                this.jjtree.openNodeScope(aSTBitwiseComplNode);
                try {
                    this.UnaryExpression();
                    break;
                }
                catch (Throwable throwable) {
                    if (bl) {
                        this.jjtree.clearNodeScope(aSTBitwiseComplNode);
                        bl = false;
                    } else {
                        this.jjtree.popNode();
                    }
                    if (throwable instanceof RuntimeException) {
                        throw (RuntimeException)throwable;
                    }
                    if (throwable instanceof ParseException) {
                        throw (ParseException)throwable;
                    }
                    throw (Error)throwable;
                }
                finally {
                    if (bl) {
                        this.jjtree.closeNodeScope((Node)aSTBitwiseComplNode, 1);
                    }
                }
            }
            case 43: {
                this.jj_consume_token(43);
                ASTNotNode aSTNotNode = new ASTNotNode(this, 26);
                boolean bl = true;
                this.jjtree.openNodeScope(aSTNotNode);
                try {
                    this.UnaryExpression();
                    break;
                }
                catch (Throwable throwable) {
                    if (bl) {
                        this.jjtree.clearNodeScope(aSTNotNode);
                        bl = false;
                    } else {
                        this.jjtree.popNode();
                    }
                    if (throwable instanceof RuntimeException) {
                        throw (RuntimeException)throwable;
                    }
                    if (throwable instanceof ParseException) {
                        throw (ParseException)throwable;
                    }
                    throw (Error)throwable;
                }
                finally {
                    if (bl) {
                        this.jjtree.closeNodeScope((Node)aSTNotNode, 1);
                    }
                }
            }
            case 44: {
                this.jj_consume_token(44);
                ASTNotNode aSTNotNode = new ASTNotNode(this, 26);
                boolean bl = true;
                this.jjtree.openNodeScope(aSTNotNode);
                try {
                    this.UnaryExpression();
                    break;
                }
                catch (Throwable throwable) {
                    if (bl) {
                        this.jjtree.clearNodeScope(aSTNotNode);
                        bl = false;
                    } else {
                        this.jjtree.popNode();
                    }
                    if (throwable instanceof RuntimeException) {
                        throw (RuntimeException)throwable;
                    }
                    if (throwable instanceof ParseException) {
                        throw (ParseException)throwable;
                    }
                    throw (Error)throwable;
                }
                finally {
                    if (bl) {
                        this.jjtree.closeNodeScope((Node)aSTNotNode, 1);
                    }
                }
            }
            case 7: 
            case 8: 
            case 11: 
            case 12: 
            case 14: 
            case 45: 
            case 46: 
            case 47: 
            case 58: 
            case 61: {
                this.PrimaryExpression();
                break;
            }
            default: {
                this.jj_la1[19] = this.jj_gen;
                this.jj_consume_token(-1);
                throw new ParseException();
            }
        }
    }

    public final void PrimaryExpression() throws ParseException {
        switch (this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
            case 7: 
            case 8: 
            case 45: 
            case 46: 
            case 47: 
            case 61: {
                this.Literal();
                break;
            }
            case 58: {
                this.Reference();
                break;
            }
            case 12: {
                this.jj_consume_token(12);
                this.Expression();
                this.jj_consume_token(13);
                break;
            }
            case 11: {
                this.EmptyFunction();
                break;
            }
            case 14: {
                this.SizeFunction();
                break;
            }
            default: {
                this.jj_la1[20] = this.jj_gen;
                this.jj_consume_token(-1);
                throw new ParseException();
            }
        }
    }

    public final void Literal() throws ParseException {
        switch (this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
            case 7: {
                this.IntegerLiteral();
                break;
            }
            case 8: {
                this.FloatLiteral();
                break;
            }
            case 46: 
            case 47: {
                this.BooleanLiteral();
                break;
            }
            case 61: {
                this.StringLiteral();
                break;
            }
            case 45: {
                this.NullLiteral();
                break;
            }
            default: {
                this.jj_la1[21] = this.jj_gen;
                this.jj_consume_token(-1);
                throw new ParseException();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final void NullLiteral() throws ParseException {
        ASTNullLiteral aSTNullLiteral = new ASTNullLiteral(this, 27);
        boolean bl = true;
        this.jjtree.openNodeScope(aSTNullLiteral);
        try {
            this.jj_consume_token(45);
        }
        finally {
            if (bl) {
                this.jjtree.closeNodeScope((Node)aSTNullLiteral, true);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final void BooleanLiteral() throws ParseException {
        switch (this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
            case 46: {
                ASTTrueNode aSTTrueNode = new ASTTrueNode(this, 28);
                boolean bl = true;
                this.jjtree.openNodeScope(aSTTrueNode);
                try {
                    this.jj_consume_token(46);
                    break;
                }
                finally {
                    if (bl) {
                        this.jjtree.closeNodeScope((Node)aSTTrueNode, true);
                    }
                }
            }
            case 47: {
                ASTFalseNode aSTFalseNode = new ASTFalseNode(this, 29);
                boolean bl = true;
                this.jjtree.openNodeScope(aSTFalseNode);
                try {
                    this.jj_consume_token(47);
                    break;
                }
                finally {
                    if (bl) {
                        this.jjtree.closeNodeScope((Node)aSTFalseNode, true);
                    }
                }
            }
            default: {
                this.jj_la1[22] = this.jj_gen;
                this.jj_consume_token(-1);
                throw new ParseException();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final void IntegerLiteral() throws ParseException {
        ASTIntegerLiteral aSTIntegerLiteral = new ASTIntegerLiteral(this, 30);
        boolean bl = true;
        this.jjtree.openNodeScope(aSTIntegerLiteral);
        try {
            Token token = this.jj_consume_token(7);
            this.jjtree.closeNodeScope((Node)aSTIntegerLiteral, true);
            bl = false;
            aSTIntegerLiteral.val = Integer.valueOf(token.image);
        }
        finally {
            if (bl) {
                this.jjtree.closeNodeScope((Node)aSTIntegerLiteral, true);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final void FloatLiteral() throws ParseException {
        ASTFloatLiteral aSTFloatLiteral = new ASTFloatLiteral(this, 31);
        boolean bl = true;
        this.jjtree.openNodeScope(aSTFloatLiteral);
        try {
            Token token = this.jj_consume_token(8);
            this.jjtree.closeNodeScope((Node)aSTFloatLiteral, true);
            bl = false;
            aSTFloatLiteral.val = Float.valueOf(token.image);
        }
        finally {
            if (bl) {
                this.jjtree.closeNodeScope((Node)aSTFloatLiteral, true);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final void StringLiteral() throws ParseException {
        ASTStringLiteral aSTStringLiteral = new ASTStringLiteral(this, 32);
        boolean bl = true;
        this.jjtree.openNodeScope(aSTStringLiteral);
        try {
            Token token = this.jj_consume_token(61);
            this.jjtree.closeNodeScope((Node)aSTStringLiteral, true);
            bl = false;
            aSTStringLiteral.literal = token.image.substring(1, token.image.length() - 1);
        }
        finally {
            if (bl) {
                this.jjtree.closeNodeScope((Node)aSTStringLiteral, true);
            }
        }
    }

    public final void Statement() throws ParseException {
        block0 : switch (this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
            case 48: {
                this.jj_consume_token(48);
                break;
            }
            case 9: {
                this.Block();
                break;
            }
            default: {
                this.jj_la1[23] = this.jj_gen;
                if (this.jj_2_2(Integer.MAX_VALUE)) {
                    this.ReferenceExpression();
                    break;
                }
                if (this.jj_2_3(Integer.MAX_VALUE)) {
                    this.StatementExpression();
                    break;
                }
                switch (this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
                    case 7: 
                    case 8: 
                    case 11: 
                    case 12: 
                    case 14: 
                    case 36: 
                    case 42: 
                    case 43: 
                    case 44: 
                    case 45: 
                    case 46: 
                    case 47: 
                    case 58: 
                    case 61: {
                        this.ExpressionExpression();
                        break block0;
                    }
                    case 49: {
                        this.IfStatement();
                        break block0;
                    }
                    case 52: {
                        this.ForeachStatement();
                        break block0;
                    }
                    case 51: {
                        this.WhileStatement();
                        break block0;
                    }
                }
                this.jj_la1[24] = this.jj_gen;
                this.jj_consume_token(-1);
                throw new ParseException();
            }
        }
    }

    public final void ExpressionExpression() throws ParseException {
        ASTExpressionExpression aSTExpressionExpression = new ASTExpressionExpression(this, 33);
        boolean bl = true;
        this.jjtree.openNodeScope(aSTExpressionExpression);
        try {
            this.Expression();
            this.jj_consume_token(48);
        }
        catch (Throwable throwable) {
            if (bl) {
                this.jjtree.clearNodeScope(aSTExpressionExpression);
                bl = false;
            } else {
                this.jjtree.popNode();
            }
            if (throwable instanceof RuntimeException) {
                throw (RuntimeException)throwable;
            }
            if (throwable instanceof ParseException) {
                throw (ParseException)throwable;
            }
            throw (Error)throwable;
        }
        finally {
            if (bl) {
                this.jjtree.closeNodeScope((Node)aSTExpressionExpression, true);
            }
        }
    }

    public final void StatementExpression() throws ParseException {
        ASTStatementExpression aSTStatementExpression = new ASTStatementExpression(this, 34);
        boolean bl = true;
        this.jjtree.openNodeScope(aSTStatementExpression);
        try {
            this.Assignment();
            this.jj_consume_token(48);
        }
        catch (Throwable throwable) {
            if (bl) {
                this.jjtree.clearNodeScope(aSTStatementExpression);
                bl = false;
            } else {
                this.jjtree.popNode();
            }
            if (throwable instanceof RuntimeException) {
                throw (RuntimeException)throwable;
            }
            if (throwable instanceof ParseException) {
                throw (ParseException)throwable;
            }
            throw (Error)throwable;
        }
        finally {
            if (bl) {
                this.jjtree.closeNodeScope((Node)aSTStatementExpression, true);
            }
        }
    }

    public final void ReferenceExpression() throws ParseException {
        ASTReferenceExpression aSTReferenceExpression = new ASTReferenceExpression(this, 35);
        boolean bl = true;
        this.jjtree.openNodeScope(aSTReferenceExpression);
        try {
            this.Reference();
            this.jj_consume_token(48);
        }
        catch (Throwable throwable) {
            if (bl) {
                this.jjtree.clearNodeScope(aSTReferenceExpression);
                bl = false;
            } else {
                this.jjtree.popNode();
            }
            if (throwable instanceof RuntimeException) {
                throw (RuntimeException)throwable;
            }
            if (throwable instanceof ParseException) {
                throw (ParseException)throwable;
            }
            throw (Error)throwable;
        }
        finally {
            if (bl) {
                this.jjtree.closeNodeScope((Node)aSTReferenceExpression, true);
            }
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final void IfStatement() throws ParseException {
        ASTIfStatement aSTIfStatement = new ASTIfStatement(this, 36);
        boolean bl = true;
        this.jjtree.openNodeScope(aSTIfStatement);
        try {
            this.jj_consume_token(49);
            this.jj_consume_token(12);
            this.Expression();
            this.jj_consume_token(13);
            this.Statement();
            switch (this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
                case 50: {
                    this.jj_consume_token(50);
                    this.Statement();
                    return;
                }
                default: {
                    this.jj_la1[25] = this.jj_gen;
                    return;
                }
            }
        }
        catch (Throwable throwable) {
            if (bl) {
                this.jjtree.clearNodeScope(aSTIfStatement);
                bl = false;
            } else {
                this.jjtree.popNode();
            }
            if (throwable instanceof RuntimeException) {
                throw (RuntimeException)throwable;
            }
            if (!(throwable instanceof ParseException)) throw (Error)throwable;
            throw (ParseException)throwable;
        }
        finally {
            if (bl) {
                this.jjtree.closeNodeScope((Node)aSTIfStatement, true);
            }
        }
    }

    public final void WhileStatement() throws ParseException {
        ASTWhileStatement aSTWhileStatement = new ASTWhileStatement(this, 37);
        boolean bl = true;
        this.jjtree.openNodeScope(aSTWhileStatement);
        try {
            this.jj_consume_token(51);
            this.jj_consume_token(12);
            this.Expression();
            this.jj_consume_token(13);
            this.Statement();
        }
        catch (Throwable throwable) {
            if (bl) {
                this.jjtree.clearNodeScope(aSTWhileStatement);
                bl = false;
            } else {
                this.jjtree.popNode();
            }
            if (throwable instanceof RuntimeException) {
                throw (RuntimeException)throwable;
            }
            if (throwable instanceof ParseException) {
                throw (ParseException)throwable;
            }
            throw (Error)throwable;
        }
        finally {
            if (bl) {
                this.jjtree.closeNodeScope((Node)aSTWhileStatement, true);
            }
        }
    }

    public final void ForeachStatement() throws ParseException {
        ASTForeachStatement aSTForeachStatement = new ASTForeachStatement(this, 38);
        boolean bl = true;
        this.jjtree.openNodeScope(aSTForeachStatement);
        try {
            this.jj_consume_token(52);
            this.jj_consume_token(12);
            this.Reference();
            this.jj_consume_token(53);
            this.Reference();
            this.jj_consume_token(13);
            this.Statement();
        }
        catch (Throwable throwable) {
            if (bl) {
                this.jjtree.clearNodeScope(aSTForeachStatement);
                bl = false;
            } else {
                this.jjtree.popNode();
            }
            if (throwable instanceof RuntimeException) {
                throw (RuntimeException)throwable;
            }
            if (throwable instanceof ParseException) {
                throw (ParseException)throwable;
            }
            throw (Error)throwable;
        }
        finally {
            if (bl) {
                this.jjtree.closeNodeScope((Node)aSTForeachStatement, true);
            }
        }
    }

    public final void Method() throws ParseException {
        ASTMethod aSTMethod = new ASTMethod(this, 39);
        boolean bl = true;
        this.jjtree.openNodeScope(aSTMethod);
        try {
            this.Identifier();
            this.jj_consume_token(12);
            block2 : switch (this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
                case 7: 
                case 8: 
                case 11: 
                case 12: 
                case 14: 
                case 36: 
                case 42: 
                case 43: 
                case 44: 
                case 45: 
                case 46: 
                case 47: 
                case 58: 
                case 61: {
                    this.Parameter();
                    while (true) {
                        switch (this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
                            case 54: {
                                break;
                            }
                            default: {
                                this.jj_la1[26] = this.jj_gen;
                                break block2;
                            }
                        }
                        this.jj_consume_token(54);
                        this.Parameter();
                    }
                }
                default: {
                    this.jj_la1[27] = this.jj_gen;
                }
            }
            this.jj_consume_token(13);
        }
        catch (Throwable throwable) {
            if (bl) {
                this.jjtree.clearNodeScope(aSTMethod);
                bl = false;
            } else {
                this.jjtree.popNode();
            }
            if (throwable instanceof RuntimeException) {
                throw (RuntimeException)throwable;
            }
            if (throwable instanceof ParseException) {
                throw (ParseException)throwable;
            }
            throw (Error)throwable;
        }
        finally {
            if (bl) {
                this.jjtree.closeNodeScope((Node)aSTMethod, true);
            }
        }
    }

    public final void ArrayAccess() throws ParseException {
        ASTArrayAccess aSTArrayAccess = new ASTArrayAccess(this, 40);
        boolean bl = true;
        this.jjtree.openNodeScope(aSTArrayAccess);
        try {
            this.Identifier();
            block12: while (true) {
                this.jj_consume_token(55);
                if (this.jj_2_4(3)) {
                    this.Expression();
                } else {
                    switch (this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
                        case 7: {
                            this.IntegerLiteral();
                            break;
                        }
                        case 58: {
                            this.Reference();
                            break;
                        }
                        default: {
                            this.jj_la1[28] = this.jj_gen;
                            this.jj_consume_token(-1);
                            throw new ParseException();
                        }
                    }
                }
                this.jj_consume_token(56);
                switch (this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
                    case 55: {
                        continue block12;
                    }
                }
                break;
            }
            this.jj_la1[29] = this.jj_gen;
        }
        catch (Throwable throwable) {
            if (bl) {
                this.jjtree.clearNodeScope(aSTArrayAccess);
                bl = false;
            } else {
                this.jjtree.popNode();
            }
            if (throwable instanceof RuntimeException) {
                throw (RuntimeException)throwable;
            }
            if (throwable instanceof ParseException) {
                throw (ParseException)throwable;
            }
            throw (Error)throwable;
        }
        finally {
            if (bl) {
                this.jjtree.closeNodeScope((Node)aSTArrayAccess, true);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final void SizeMethod() throws ParseException {
        ASTSizeMethod aSTSizeMethod = new ASTSizeMethod(this, 41);
        boolean bl = true;
        this.jjtree.openNodeScope(aSTSizeMethod);
        try {
            this.jj_consume_token(14);
            this.jj_consume_token(12);
            this.jj_consume_token(13);
        }
        finally {
            if (bl) {
                this.jjtree.closeNodeScope((Node)aSTSizeMethod, true);
            }
        }
    }

    public final void Reference() throws ParseException {
        ASTReference aSTReference = new ASTReference(this, 42);
        boolean bl = true;
        this.jjtree.openNodeScope(aSTReference);
        try {
            if (this.jj_2_5(Integer.MAX_VALUE)) {
                this.ArrayAccess();
            } else {
                switch (this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
                    case 58: {
                        this.Identifier();
                        break;
                    }
                    default: {
                        this.jj_la1[30] = this.jj_gen;
                        this.jj_consume_token(-1);
                        throw new ParseException();
                    }
                }
            }
            block16: while (this.jj_2_6(2)) {
                this.jj_consume_token(57);
                if (this.jj_2_8(Integer.MAX_VALUE)) {
                    this.ArrayAccess();
                    continue;
                }
                switch (this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
                    case 7: 
                    case 14: 
                    case 58: {
                        if (this.jj_2_7(3)) {
                            this.Method();
                            continue block16;
                        }
                        switch (this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
                            case 14: {
                                this.SizeMethod();
                                continue block16;
                            }
                            case 58: {
                                this.Identifier();
                                continue block16;
                            }
                            case 7: {
                                this.IntegerLiteral();
                                continue block16;
                            }
                        }
                        this.jj_la1[31] = this.jj_gen;
                        this.jj_consume_token(-1);
                        throw new ParseException();
                    }
                }
                this.jj_la1[32] = this.jj_gen;
                this.jj_consume_token(-1);
                throw new ParseException();
            }
        }
        catch (Throwable throwable) {
            if (bl) {
                this.jjtree.clearNodeScope(aSTReference);
                bl = false;
            } else {
                this.jjtree.popNode();
            }
            if (throwable instanceof RuntimeException) {
                throw (RuntimeException)throwable;
            }
            if (throwable instanceof ParseException) {
                throw (ParseException)throwable;
            }
            throw (Error)throwable;
        }
        finally {
            if (bl) {
                this.jjtree.closeNodeScope((Node)aSTReference, true);
            }
        }
    }

    public final void Parameter() throws ParseException {
        if (this.jj_2_9(3)) {
            this.Expression();
        } else {
            switch (this.jj_ntk == -1 ? this.jj_ntk() : this.jj_ntk) {
                case 7: 
                case 8: 
                case 45: 
                case 46: 
                case 47: 
                case 61: {
                    this.Literal();
                    break;
                }
                case 58: {
                    this.Reference();
                    break;
                }
                default: {
                    this.jj_la1[33] = this.jj_gen;
                    this.jj_consume_token(-1);
                    throw new ParseException();
                }
            }
        }
    }

    private final boolean jj_2_1(int n) {
        this.jj_la = n;
        this.jj_lastpos = this.jj_scanpos = this.token;
        boolean bl = !this.jj_3_1();
        this.jj_save(0, n);
        return bl;
    }

    private final boolean jj_2_2(int n) {
        this.jj_la = n;
        this.jj_lastpos = this.jj_scanpos = this.token;
        boolean bl = !this.jj_3_2();
        this.jj_save(1, n);
        return bl;
    }

    private final boolean jj_2_3(int n) {
        this.jj_la = n;
        this.jj_lastpos = this.jj_scanpos = this.token;
        boolean bl = !this.jj_3_3();
        this.jj_save(2, n);
        return bl;
    }

    private final boolean jj_2_4(int n) {
        this.jj_la = n;
        this.jj_lastpos = this.jj_scanpos = this.token;
        boolean bl = !this.jj_3_4();
        this.jj_save(3, n);
        return bl;
    }

    private final boolean jj_2_5(int n) {
        this.jj_la = n;
        this.jj_lastpos = this.jj_scanpos = this.token;
        boolean bl = !this.jj_3_5();
        this.jj_save(4, n);
        return bl;
    }

    private final boolean jj_2_6(int n) {
        this.jj_la = n;
        this.jj_lastpos = this.jj_scanpos = this.token;
        boolean bl = !this.jj_3_6();
        this.jj_save(5, n);
        return bl;
    }

    private final boolean jj_2_7(int n) {
        this.jj_la = n;
        this.jj_lastpos = this.jj_scanpos = this.token;
        boolean bl = !this.jj_3_7();
        this.jj_save(6, n);
        return bl;
    }

    private final boolean jj_2_8(int n) {
        this.jj_la = n;
        this.jj_lastpos = this.jj_scanpos = this.token;
        boolean bl = !this.jj_3_8();
        this.jj_save(7, n);
        return bl;
    }

    private final boolean jj_2_9(int n) {
        this.jj_la = n;
        this.jj_lastpos = this.jj_scanpos = this.token;
        boolean bl = !this.jj_3_9();
        this.jj_save(8, n);
        return bl;
    }

    private final boolean jj_3R_71() {
        if (this.jj_scan_token(17)) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        if (this.jj_3R_58()) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        return false;
    }

    private final boolean jj_3R_59() {
        Token token = this.jj_scanpos;
        if (this.jj_3R_70()) {
            this.jj_scanpos = token;
            if (this.jj_3R_71()) {
                return true;
            }
            if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
                return false;
            }
        } else if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        return false;
    }

    private final boolean jj_3R_70() {
        if (this.jj_scan_token(16)) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        if (this.jj_3R_58()) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        return false;
    }

    private final boolean jj_3R_64() {
        if (this.jj_scan_token(61)) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        return false;
    }

    private final boolean jj_3R_47() {
        Token token;
        block3: {
            if (this.jj_3R_58()) {
                return true;
            }
            if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
                return false;
            }
            do {
                token = this.jj_scanpos;
                if (this.jj_3R_59()) break block3;
            } while (this.jj_la != 0 || this.jj_scanpos != this.jj_lastpos);
            return false;
        }
        this.jj_scanpos = token;
        return false;
    }

    private final boolean jj_3_1() {
        if (this.jj_3R_15()) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        if (this.jj_scan_token(15)) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        return false;
    }

    private final boolean jj_3R_46() {
        if (this.jj_3R_15()) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        if (this.jj_scan_token(15)) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        if (this.jj_3R_17()) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        return false;
    }

    private final boolean jj_3R_34() {
        if (this.jj_3R_18()) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        return false;
    }

    private final boolean jj_3R_62() {
        if (this.jj_scan_token(8)) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        return false;
    }

    private final boolean jj_3R_36() {
        if (this.jj_3R_47()) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        return false;
    }

    private final boolean jj_3R_35() {
        if (this.jj_3R_46()) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        return false;
    }

    private final boolean jj_3R_17() {
        Token token = this.jj_scanpos;
        if (this.jj_3R_35()) {
            this.jj_scanpos = token;
            if (this.jj_3R_36()) {
                return true;
            }
            if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
                return false;
            }
        } else if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        return false;
    }

    private final boolean jj_3R_56() {
        if (this.jj_scan_token(12)) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        if (this.jj_3R_16()) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        if (this.jj_scan_token(13)) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        return false;
    }

    private final boolean jj_3R_37() {
        if (this.jj_scan_token(7)) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        return false;
    }

    private final boolean jj_3R_18() {
        if (this.jj_scan_token(58)) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        return false;
    }

    private final boolean jj_3R_73() {
        if (this.jj_scan_token(47)) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        return false;
    }

    private final boolean jj_3R_63() {
        Token token = this.jj_scanpos;
        if (this.jj_3R_72()) {
            this.jj_scanpos = token;
            if (this.jj_3R_73()) {
                return true;
            }
            if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
                return false;
            }
        } else if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        return false;
    }

    private final boolean jj_3R_72() {
        if (this.jj_scan_token(46)) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        return false;
    }

    private final boolean jj_3R_45() {
        if (this.jj_scan_token(14)) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        if (this.jj_scan_token(12)) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        if (this.jj_3R_16()) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        if (this.jj_scan_token(13)) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        return false;
    }

    private final boolean jj_3R_27() {
        if (this.jj_3R_16()) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        return false;
    }

    private final boolean jj_3R_65() {
        if (this.jj_scan_token(45)) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        return false;
    }

    private final boolean jj_3R_55() {
        if (this.jj_3R_16()) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        return false;
    }

    private final boolean jj_3R_41() {
        if (this.jj_3R_37()) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        return false;
    }

    private final boolean jj_3R_44() {
        if (this.jj_scan_token(11)) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        Token token = this.jj_scanpos;
        if (this.jj_3R_55()) {
            this.jj_scanpos = token;
            if (this.jj_3R_56()) {
                return true;
            }
            if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
                return false;
            }
        } else if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        return false;
    }

    private final boolean jj_3R_21() {
        if (this.jj_3R_16()) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        return false;
    }

    private final boolean jj_3R_54() {
        if (this.jj_3R_65()) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        return false;
    }

    private final boolean jj_3R_53() {
        if (this.jj_3R_64()) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        return false;
    }

    private final boolean jj_3R_67() {
        if (this.jj_3R_16()) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        return false;
    }

    private final boolean jj_3R_52() {
        if (this.jj_3R_63()) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        return false;
    }

    private final boolean jj_3R_61() {
        if (this.jj_3R_16()) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        return false;
    }

    private final boolean jj_3R_51() {
        if (this.jj_3R_62()) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        return false;
    }

    private final boolean jj_3R_43() {
        Token token = this.jj_scanpos;
        if (this.jj_3R_50()) {
            this.jj_scanpos = token;
            if (this.jj_3R_51()) {
                this.jj_scanpos = token;
                if (this.jj_3R_52()) {
                    this.jj_scanpos = token;
                    if (this.jj_3R_53()) {
                        this.jj_scanpos = token;
                        if (this.jj_3R_54()) {
                            return true;
                        }
                        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
                            return false;
                        }
                    } else if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
                        return false;
                    }
                } else if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
                    return false;
                }
            } else if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
                return false;
            }
        } else if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        return false;
    }

    private final boolean jj_3R_50() {
        if (this.jj_3R_37()) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        return false;
    }

    private final boolean jj_3R_26() {
        if (this.jj_3R_37()) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        return false;
    }

    private final boolean jj_3R_40() {
        if (this.jj_3R_18()) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        return false;
    }

    private final boolean jj_3R_20() {
        if (this.jj_3R_37()) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        return false;
    }

    private final boolean jj_3R_32() {
        if (this.jj_3R_45()) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        return false;
    }

    private final boolean jj_3R_60() {
        if (this.jj_3R_43()) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        return false;
    }

    private final boolean jj_3R_31() {
        if (this.jj_3R_44()) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        return false;
    }

    private final boolean jj_3R_30() {
        if (this.jj_scan_token(12)) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        if (this.jj_3R_17()) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        if (this.jj_scan_token(13)) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        return false;
    }

    private final boolean jj_3R_66() {
        if (this.jj_3R_37()) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        return false;
    }

    private final boolean jj_3R_29() {
        if (this.jj_3R_16()) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        return false;
    }

    private final boolean jj_3R_28() {
        if (this.jj_3R_43()) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        return false;
    }

    private final boolean jj_3R_15() {
        Token token = this.jj_scanpos;
        if (this.jj_3R_28()) {
            this.jj_scanpos = token;
            if (this.jj_3R_29()) {
                this.jj_scanpos = token;
                if (this.jj_3R_30()) {
                    this.jj_scanpos = token;
                    if (this.jj_3R_31()) {
                        this.jj_scanpos = token;
                        if (this.jj_3R_32()) {
                            return true;
                        }
                        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
                            return false;
                        }
                    } else if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
                        return false;
                    }
                } else if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
                    return false;
                }
            } else if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
                return false;
            }
        } else if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        return false;
    }

    private final boolean jj_3R_25() {
        if (this.jj_3R_17()) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        return false;
    }

    private final boolean jj_3R_39() {
        if (this.jj_3R_48()) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        return false;
    }

    private final boolean jj_3R_109() {
        if (this.jj_3R_15()) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        return false;
    }

    private final boolean jj_3R_19() {
        if (this.jj_3R_17()) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        return false;
    }

    private final boolean jj_3R_108() {
        if (this.jj_scan_token(44)) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        if (this.jj_3R_101()) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        return false;
    }

    private final boolean jj_3R_107() {
        if (this.jj_scan_token(43)) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        if (this.jj_3R_101()) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        return false;
    }

    private final boolean jj_3R_106() {
        if (this.jj_scan_token(42)) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        if (this.jj_3R_101()) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        return false;
    }

    private final boolean jj_3R_105() {
        if (this.jj_scan_token(36)) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        if (this.jj_3R_101()) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        return false;
    }

    private final boolean jj_3R_101() {
        Token token = this.jj_scanpos;
        if (this.jj_3R_105()) {
            this.jj_scanpos = token;
            if (this.jj_3R_106()) {
                this.jj_scanpos = token;
                if (this.jj_3R_107()) {
                    this.jj_scanpos = token;
                    if (this.jj_3R_108()) {
                        this.jj_scanpos = token;
                        if (this.jj_3R_109()) {
                            return true;
                        }
                        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
                            return false;
                        }
                    } else if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
                        return false;
                    }
                } else if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
                    return false;
                }
            } else if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
                return false;
            }
        } else if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        return false;
    }

    private final boolean jj_3R_78() {
        if (this.jj_scan_token(54)) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        if (this.jj_3R_49()) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        return false;
    }

    private final boolean jj_3R_114() {
        if (this.jj_scan_token(41)) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        if (this.jj_3R_101()) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        return false;
    }

    private final boolean jj_3_8() {
        if (this.jj_3R_18()) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        if (this.jj_scan_token(55)) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        Token token = this.jj_scanpos;
        if (this.jj_3R_25()) {
            this.jj_scanpos = token;
            if (this.jj_3R_26()) {
                this.jj_scanpos = token;
                if (this.jj_3R_27()) {
                    return true;
                }
                if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
                    return false;
                }
            } else if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
                return false;
            }
        } else if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        if (this.jj_scan_token(56)) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        return false;
    }

    private final boolean jj_3R_113() {
        if (this.jj_scan_token(40)) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        if (this.jj_3R_101()) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        return false;
    }

    private final boolean jj_3_9() {
        if (this.jj_3R_17()) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        return false;
    }

    private final boolean jj_3R_49() {
        Token token = this.jj_scanpos;
        if (this.jj_3_9()) {
            this.jj_scanpos = token;
            if (this.jj_3R_60()) {
                this.jj_scanpos = token;
                if (this.jj_3R_61()) {
                    return true;
                }
                if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
                    return false;
                }
            } else if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
                return false;
            }
        } else if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        return false;
    }

    private final boolean jj_3R_112() {
        if (this.jj_scan_token(39)) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        if (this.jj_3R_101()) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        return false;
    }

    private final boolean jj_3_4() {
        if (this.jj_3R_17()) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        return false;
    }

    private final boolean jj_3R_111() {
        if (this.jj_scan_token(38)) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        if (this.jj_3R_101()) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        return false;
    }

    private final boolean jj_3_5() {
        if (this.jj_3R_18()) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        if (this.jj_scan_token(55)) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        Token token = this.jj_scanpos;
        if (this.jj_3R_19()) {
            this.jj_scanpos = token;
            if (this.jj_3R_20()) {
                this.jj_scanpos = token;
                if (this.jj_3R_21()) {
                    return true;
                }
                if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
                    return false;
                }
            } else if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
                return false;
            }
        } else if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        if (this.jj_scan_token(56)) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        return false;
    }

    private final boolean jj_3_7() {
        if (this.jj_3R_24()) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        return false;
    }

    private final boolean jj_3R_110() {
        if (this.jj_scan_token(37)) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        if (this.jj_3R_101()) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        return false;
    }

    private final boolean jj_3R_102() {
        Token token = this.jj_scanpos;
        if (this.jj_3R_110()) {
            this.jj_scanpos = token;
            if (this.jj_3R_111()) {
                this.jj_scanpos = token;
                if (this.jj_3R_112()) {
                    this.jj_scanpos = token;
                    if (this.jj_3R_113()) {
                        this.jj_scanpos = token;
                        if (this.jj_3R_114()) {
                            return true;
                        }
                        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
                            return false;
                        }
                    } else if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
                        return false;
                    }
                } else if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
                    return false;
                }
            } else if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
                return false;
            }
        } else if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        return false;
    }

    private final boolean jj_3R_23() {
        Token token = this.jj_scanpos;
        if (this.jj_3_7()) {
            this.jj_scanpos = token;
            if (this.jj_3R_39()) {
                this.jj_scanpos = token;
                if (this.jj_3R_40()) {
                    this.jj_scanpos = token;
                    if (this.jj_3R_41()) {
                        return true;
                    }
                    if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
                        return false;
                    }
                } else if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
                    return false;
                }
            } else if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
                return false;
            }
        } else if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        return false;
    }

    private final boolean jj_3R_22() {
        if (this.jj_3R_38()) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        return false;
    }

    private final boolean jj_3R_57() {
        if (this.jj_scan_token(55)) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        Token token = this.jj_scanpos;
        if (this.jj_3_4()) {
            this.jj_scanpos = token;
            if (this.jj_3R_66()) {
                this.jj_scanpos = token;
                if (this.jj_3R_67()) {
                    return true;
                }
                if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
                    return false;
                }
            } else if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
                return false;
            }
        } else if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        if (this.jj_scan_token(56)) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        return false;
    }

    private final boolean jj_3R_91() {
        Token token;
        block3: {
            if (this.jj_3R_101()) {
                return true;
            }
            if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
                return false;
            }
            do {
                token = this.jj_scanpos;
                if (this.jj_3R_102()) break block3;
            } while (this.jj_la != 0 || this.jj_scanpos != this.jj_lastpos);
            return false;
        }
        this.jj_scanpos = token;
        return false;
    }

    private final boolean jj_3R_42() {
        Token token;
        block3: {
            if (this.jj_3R_49()) {
                return true;
            }
            if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
                return false;
            }
            do {
                token = this.jj_scanpos;
                if (this.jj_3R_78()) break block3;
            } while (this.jj_la != 0 || this.jj_scanpos != this.jj_lastpos);
            return false;
        }
        this.jj_scanpos = token;
        return false;
    }

    private final boolean jj_3_6() {
        if (this.jj_scan_token(57)) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        Token token = this.jj_scanpos;
        if (this.jj_3R_22()) {
            this.jj_scanpos = token;
            if (this.jj_3R_23()) {
                return true;
            }
            if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
                return false;
            }
        } else if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        return false;
    }

    private final boolean jj_3R_33() {
        if (this.jj_3R_38()) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        return false;
    }

    private final boolean jj_3R_48() {
        if (this.jj_scan_token(14)) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        if (this.jj_scan_token(12)) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        if (this.jj_scan_token(13)) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        return false;
    }

    private final boolean jj_3R_104() {
        if (this.jj_scan_token(36)) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        if (this.jj_3R_91()) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        return false;
    }

    private final boolean jj_3R_16() {
        Token token;
        block6: {
            token = this.jj_scanpos;
            if (this.jj_3R_33()) {
                this.jj_scanpos = token;
                if (this.jj_3R_34()) {
                    return true;
                }
                if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
                    return false;
                }
            } else if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
                return false;
            }
            do {
                token = this.jj_scanpos;
                if (this.jj_3_6()) break block6;
            } while (this.jj_la != 0 || this.jj_scanpos != this.jj_lastpos);
            return false;
        }
        this.jj_scanpos = token;
        return false;
    }

    private final boolean jj_3R_103() {
        if (this.jj_scan_token(35)) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        if (this.jj_3R_91()) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        return false;
    }

    private final boolean jj_3R_92() {
        Token token = this.jj_scanpos;
        if (this.jj_3R_103()) {
            this.jj_scanpos = token;
            if (this.jj_3R_104()) {
                return true;
            }
            if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
                return false;
            }
        } else if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        return false;
    }

    private final boolean jj_3R_85() {
        Token token;
        block3: {
            if (this.jj_3R_91()) {
                return true;
            }
            if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
                return false;
            }
            do {
                token = this.jj_scanpos;
                if (this.jj_3R_92()) break block3;
            } while (this.jj_la != 0 || this.jj_scanpos != this.jj_lastpos);
            return false;
        }
        this.jj_scanpos = token;
        return false;
    }

    private final boolean jj_3R_38() {
        Token token;
        block5: {
            if (this.jj_3R_18()) {
                return true;
            }
            if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
                return false;
            }
            if (this.jj_3R_57()) {
                return true;
            }
            if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
                return false;
            }
            do {
                token = this.jj_scanpos;
                if (this.jj_3R_57()) break block5;
            } while (this.jj_la != 0 || this.jj_scanpos != this.jj_lastpos);
            return false;
        }
        this.jj_scanpos = token;
        return false;
    }

    private final boolean jj_3R_100() {
        if (this.jj_scan_token(34)) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        if (this.jj_3R_85()) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        return false;
    }

    private final boolean jj_3R_99() {
        if (this.jj_scan_token(33)) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        if (this.jj_3R_85()) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        return false;
    }

    private final boolean jj_3R_24() {
        if (this.jj_3R_18()) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        if (this.jj_scan_token(12)) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        Token token = this.jj_scanpos;
        if (this.jj_3R_42()) {
            this.jj_scanpos = token;
        } else if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        if (this.jj_scan_token(13)) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        return false;
    }

    private final boolean jj_3R_98() {
        if (this.jj_scan_token(32)) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        if (this.jj_3R_85()) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        return false;
    }

    private final boolean jj_3R_97() {
        if (this.jj_scan_token(31)) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        if (this.jj_3R_85()) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        return false;
    }

    private final boolean jj_3R_96() {
        if (this.jj_scan_token(30)) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        if (this.jj_3R_85()) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        return false;
    }

    private final boolean jj_3R_95() {
        if (this.jj_scan_token(29)) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        if (this.jj_3R_85()) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        return false;
    }

    private final boolean jj_3R_94() {
        if (this.jj_scan_token(28)) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        if (this.jj_3R_85()) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        return false;
    }

    private final boolean jj_3R_93() {
        if (this.jj_scan_token(27)) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        if (this.jj_3R_85()) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        return false;
    }

    private final boolean jj_3R_86() {
        Token token = this.jj_scanpos;
        if (this.jj_3R_93()) {
            this.jj_scanpos = token;
            if (this.jj_3R_94()) {
                this.jj_scanpos = token;
                if (this.jj_3R_95()) {
                    this.jj_scanpos = token;
                    if (this.jj_3R_96()) {
                        this.jj_scanpos = token;
                        if (this.jj_3R_97()) {
                            this.jj_scanpos = token;
                            if (this.jj_3R_98()) {
                                this.jj_scanpos = token;
                                if (this.jj_3R_99()) {
                                    this.jj_scanpos = token;
                                    if (this.jj_3R_100()) {
                                        return true;
                                    }
                                    if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
                                        return false;
                                    }
                                } else if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
                                    return false;
                                }
                            } else if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
                                return false;
                            }
                        } else if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
                            return false;
                        }
                    } else if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
                        return false;
                    }
                } else if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
                    return false;
                }
            } else if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
                return false;
            }
        } else if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        return false;
    }

    private final boolean jj_3R_83() {
        Token token;
        block3: {
            if (this.jj_3R_85()) {
                return true;
            }
            if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
                return false;
            }
            do {
                token = this.jj_scanpos;
                if (this.jj_3R_86()) break block3;
            } while (this.jj_la != 0 || this.jj_scanpos != this.jj_lastpos);
            return false;
        }
        this.jj_scanpos = token;
        return false;
    }

    private final boolean jj_3R_90() {
        if (this.jj_scan_token(26)) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        if (this.jj_3R_83()) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        return false;
    }

    private final boolean jj_3R_89() {
        if (this.jj_scan_token(25)) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        if (this.jj_3R_83()) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        return false;
    }

    private final boolean jj_3R_88() {
        if (this.jj_scan_token(24)) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        if (this.jj_3R_83()) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        return false;
    }

    private final boolean jj_3R_87() {
        if (this.jj_scan_token(23)) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        if (this.jj_3R_83()) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        return false;
    }

    private final boolean jj_3R_84() {
        Token token = this.jj_scanpos;
        if (this.jj_3R_87()) {
            this.jj_scanpos = token;
            if (this.jj_3R_88()) {
                this.jj_scanpos = token;
                if (this.jj_3R_89()) {
                    this.jj_scanpos = token;
                    if (this.jj_3R_90()) {
                        return true;
                    }
                    if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
                        return false;
                    }
                } else if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
                    return false;
                }
            } else if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
                return false;
            }
        } else if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        return false;
    }

    private final boolean jj_3R_81() {
        Token token;
        block3: {
            if (this.jj_3R_83()) {
                return true;
            }
            if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
                return false;
            }
            do {
                token = this.jj_scanpos;
                if (this.jj_3R_84()) break block3;
            } while (this.jj_la != 0 || this.jj_scanpos != this.jj_lastpos);
            return false;
        }
        this.jj_scanpos = token;
        return false;
    }

    private final boolean jj_3R_82() {
        if (this.jj_scan_token(22)) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        if (this.jj_3R_81()) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        return false;
    }

    private final boolean jj_3R_79() {
        Token token;
        block3: {
            if (this.jj_3R_81()) {
                return true;
            }
            if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
                return false;
            }
            do {
                token = this.jj_scanpos;
                if (this.jj_3R_82()) break block3;
            } while (this.jj_la != 0 || this.jj_scanpos != this.jj_lastpos);
            return false;
        }
        this.jj_scanpos = token;
        return false;
    }

    private final boolean jj_3_3() {
        if (this.jj_3R_15()) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        if (this.jj_scan_token(15)) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        return false;
    }

    private final boolean jj_3_2() {
        if (this.jj_3R_16()) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        if (this.jj_scan_token(48)) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        return false;
    }

    private final boolean jj_3R_80() {
        if (this.jj_scan_token(21)) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        if (this.jj_3R_79()) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        return false;
    }

    private final boolean jj_3R_74() {
        Token token;
        block3: {
            if (this.jj_3R_79()) {
                return true;
            }
            if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
                return false;
            }
            do {
                token = this.jj_scanpos;
                if (this.jj_3R_80()) break block3;
            } while (this.jj_la != 0 || this.jj_scanpos != this.jj_lastpos);
            return false;
        }
        this.jj_scanpos = token;
        return false;
    }

    private final boolean jj_3R_75() {
        if (this.jj_scan_token(20)) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        if (this.jj_3R_74()) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        return false;
    }

    private final boolean jj_3R_68() {
        Token token;
        block3: {
            if (this.jj_3R_74()) {
                return true;
            }
            if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
                return false;
            }
            do {
                token = this.jj_scanpos;
                if (this.jj_3R_75()) break block3;
            } while (this.jj_la != 0 || this.jj_scanpos != this.jj_lastpos);
            return false;
        }
        this.jj_scanpos = token;
        return false;
    }

    private final boolean jj_3R_77() {
        if (this.jj_scan_token(19)) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        if (this.jj_3R_68()) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        return false;
    }

    private final boolean jj_3R_69() {
        Token token = this.jj_scanpos;
        if (this.jj_3R_76()) {
            this.jj_scanpos = token;
            if (this.jj_3R_77()) {
                return true;
            }
            if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
                return false;
            }
        } else if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        return false;
    }

    private final boolean jj_3R_76() {
        if (this.jj_scan_token(18)) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        if (this.jj_3R_68()) {
            return true;
        }
        if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
            return false;
        }
        return false;
    }

    private final boolean jj_3R_58() {
        Token token;
        block3: {
            if (this.jj_3R_68()) {
                return true;
            }
            if (this.jj_la == 0 && this.jj_scanpos == this.jj_lastpos) {
                return false;
            }
            do {
                token = this.jj_scanpos;
                if (this.jj_3R_69()) break block3;
            } while (this.jj_la != 0 || this.jj_scanpos != this.jj_lastpos);
            return false;
        }
        this.jj_scanpos = token;
        return false;
    }

    public Parser(InputStream inputStream) {
        int n;
        this.jj_input_stream = new SimpleCharStream(inputStream, 1, 1);
        this.token_source = new ParserTokenManager(this.jj_input_stream);
        this.token = new Token();
        this.jj_ntk = -1;
        this.jj_gen = 0;
        for (n = 0; n < 34; ++n) {
            this.jj_la1[n] = -1;
        }
        for (n = 0; n < this.jj_2_rtns.length; ++n) {
            this.jj_2_rtns[n] = new JJCalls();
        }
    }

    public void ReInit(InputStream inputStream) {
        int n;
        this.jj_input_stream.ReInit(inputStream, 1, 1);
        this.token_source.ReInit(this.jj_input_stream);
        this.token = new Token();
        this.jj_ntk = -1;
        this.jjtree.reset();
        this.jj_gen = 0;
        for (n = 0; n < 34; ++n) {
            this.jj_la1[n] = -1;
        }
        for (n = 0; n < this.jj_2_rtns.length; ++n) {
            this.jj_2_rtns[n] = new JJCalls();
        }
    }

    public Parser(Reader reader) {
        int n;
        this.jj_input_stream = new SimpleCharStream(reader, 1, 1);
        this.token_source = new ParserTokenManager(this.jj_input_stream);
        this.token = new Token();
        this.jj_ntk = -1;
        this.jj_gen = 0;
        for (n = 0; n < 34; ++n) {
            this.jj_la1[n] = -1;
        }
        for (n = 0; n < this.jj_2_rtns.length; ++n) {
            this.jj_2_rtns[n] = new JJCalls();
        }
    }

    public void ReInit(Reader reader) {
        int n;
        this.jj_input_stream.ReInit(reader, 1, 1);
        this.token_source.ReInit(this.jj_input_stream);
        this.token = new Token();
        this.jj_ntk = -1;
        this.jjtree.reset();
        this.jj_gen = 0;
        for (n = 0; n < 34; ++n) {
            this.jj_la1[n] = -1;
        }
        for (n = 0; n < this.jj_2_rtns.length; ++n) {
            this.jj_2_rtns[n] = new JJCalls();
        }
    }

    public Parser(ParserTokenManager parserTokenManager) {
        int n;
        this.token_source = parserTokenManager;
        this.token = new Token();
        this.jj_ntk = -1;
        this.jj_gen = 0;
        for (n = 0; n < 34; ++n) {
            this.jj_la1[n] = -1;
        }
        for (n = 0; n < this.jj_2_rtns.length; ++n) {
            this.jj_2_rtns[n] = new JJCalls();
        }
    }

    public void ReInit(ParserTokenManager parserTokenManager) {
        int n;
        this.token_source = parserTokenManager;
        this.token = new Token();
        this.jj_ntk = -1;
        this.jjtree.reset();
        this.jj_gen = 0;
        for (n = 0; n < 34; ++n) {
            this.jj_la1[n] = -1;
        }
        for (n = 0; n < this.jj_2_rtns.length; ++n) {
            this.jj_2_rtns[n] = new JJCalls();
        }
    }

    private final Token jj_consume_token(int n) throws ParseException {
        Token token = this.token;
        this.token = token.next != null ? this.token.next : (this.token.next = this.token_source.getNextToken());
        this.jj_ntk = -1;
        if (this.token.kind == n) {
            ++this.jj_gen;
            if (++this.jj_gc > 100) {
                this.jj_gc = 0;
                for (int i2 = 0; i2 < this.jj_2_rtns.length; ++i2) {
                    JJCalls jJCalls = this.jj_2_rtns[i2];
                    while (jJCalls != null) {
                        if (jJCalls.gen < this.jj_gen) {
                            jJCalls.first = null;
                        }
                        jJCalls = jJCalls.next;
                    }
                }
            }
            return this.token;
        }
        this.token = token;
        this.jj_kind = n;
        throw this.generateParseException();
    }

    private final boolean jj_scan_token(int n) {
        if (this.jj_scanpos == this.jj_lastpos) {
            --this.jj_la;
            if (this.jj_scanpos.next == null) {
                this.jj_scanpos = this.jj_scanpos.next = this.token_source.getNextToken();
                this.jj_lastpos = this.jj_scanpos.next;
            } else {
                this.jj_lastpos = this.jj_scanpos = this.jj_scanpos.next;
            }
        } else {
            this.jj_scanpos = this.jj_scanpos.next;
        }
        if (this.jj_rescan) {
            int n2 = 0;
            Token token = this.token;
            while (token != null && token != this.jj_scanpos) {
                ++n2;
                token = token.next;
            }
            if (token != null) {
                this.jj_add_error_token(n, n2);
            }
        }
        return this.jj_scanpos.kind != n;
    }

    public final Token getNextToken() {
        this.token = this.token.next != null ? this.token.next : (this.token.next = this.token_source.getNextToken());
        this.jj_ntk = -1;
        ++this.jj_gen;
        return this.token;
    }

    public final Token getToken(int n) {
        Token token = this.lookingAhead ? this.jj_scanpos : this.token;
        for (int i2 = 0; i2 < n; ++i2) {
            token = token.next != null ? token.next : (token.next = this.token_source.getNextToken());
        }
        return token;
    }

    private final int jj_ntk() {
        this.jj_nt = this.token.next;
        if (this.jj_nt == null) {
            this.token.next = this.token_source.getNextToken();
            this.jj_ntk = this.token.next.kind;
            return this.jj_ntk;
        }
        this.jj_ntk = this.jj_nt.kind;
        return this.jj_ntk;
    }

    private void jj_add_error_token(int n, int n2) {
        if (n2 >= 100) {
            return;
        }
        if (n2 == this.jj_endpos + 1) {
            this.jj_lasttokens[this.jj_endpos++] = n;
        } else if (this.jj_endpos != 0) {
            int n3;
            this.jj_expentry = new int[this.jj_endpos];
            for (n3 = 0; n3 < this.jj_endpos; ++n3) {
                this.jj_expentry[n3] = this.jj_lasttokens[n3];
            }
            n3 = 0;
            Enumeration enumeration = this.jj_expentries.elements();
            while (enumeration.hasMoreElements()) {
                int[] nArray = (int[])enumeration.nextElement();
                if (nArray.length != this.jj_expentry.length) continue;
                n3 = 1;
                for (int i2 = 0; i2 < this.jj_expentry.length; ++i2) {
                    if (nArray[i2] == this.jj_expentry[i2]) continue;
                    n3 = 0;
                    break;
                }
                if (n3 == 0) continue;
                break;
            }
            if (n3 == 0) {
                this.jj_expentries.addElement(this.jj_expentry);
            }
            if (n2 != 0) {
                this.jj_endpos = n2;
                this.jj_lasttokens[this.jj_endpos - 1] = n;
            }
        }
    }

    public final ParseException generateParseException() {
        int n;
        int n2;
        this.jj_expentries.removeAllElements();
        boolean[] blArray = new boolean[62];
        for (n2 = 0; n2 < 62; ++n2) {
            blArray[n2] = false;
        }
        if (this.jj_kind >= 0) {
            blArray[this.jj_kind] = true;
            this.jj_kind = -1;
        }
        for (n2 = 0; n2 < 34; ++n2) {
            if (this.jj_la1[n2] != this.jj_gen) continue;
            for (n = 0; n < 32; ++n) {
                if ((this.jj_la1_0[n2] & 1 << n) != 0) {
                    blArray[n] = true;
                }
                if ((this.jj_la1_1[n2] & 1 << n) == 0) continue;
                blArray[32 + n] = true;
            }
        }
        for (n2 = 0; n2 < 62; ++n2) {
            if (!blArray[n2]) continue;
            this.jj_expentry = new int[1];
            this.jj_expentry[0] = n2;
            this.jj_expentries.addElement(this.jj_expentry);
        }
        this.jj_endpos = 0;
        this.jj_rescan_token();
        this.jj_add_error_token(0, 0);
        int[][] nArrayArray = new int[this.jj_expentries.size()][];
        for (n = 0; n < this.jj_expentries.size(); ++n) {
            nArrayArray[n] = (int[])this.jj_expentries.elementAt(n);
        }
        return new ParseException(this.token, nArrayArray, tokenImage);
    }

    public final void enable_tracing() {
    }

    public final void disable_tracing() {
    }

    private final void jj_rescan_token() {
        this.jj_rescan = true;
        for (int i2 = 0; i2 < 9; ++i2) {
            JJCalls jJCalls = this.jj_2_rtns[i2];
            do {
                if (jJCalls.gen <= this.jj_gen) continue;
                this.jj_la = jJCalls.arg;
                this.jj_lastpos = this.jj_scanpos = jJCalls.first;
                switch (i2) {
                    case 0: {
                        this.jj_3_1();
                        break;
                    }
                    case 1: {
                        this.jj_3_2();
                        break;
                    }
                    case 2: {
                        this.jj_3_3();
                        break;
                    }
                    case 3: {
                        this.jj_3_4();
                        break;
                    }
                    case 4: {
                        this.jj_3_5();
                        break;
                    }
                    case 5: {
                        this.jj_3_6();
                        break;
                    }
                    case 6: {
                        this.jj_3_7();
                        break;
                    }
                    case 7: {
                        this.jj_3_8();
                        break;
                    }
                    case 8: {
                        this.jj_3_9();
                    }
                }
            } while ((jJCalls = jJCalls.next) != null);
        }
        this.jj_rescan = false;
    }

    private final void jj_save(int n, int n2) {
        JJCalls jJCalls = this.jj_2_rtns[n];
        while (jJCalls.gen > this.jj_gen) {
            if (jJCalls.next == null) {
                jJCalls = jJCalls.next = new JJCalls();
                break;
            }
            jJCalls = jJCalls.next;
        }
        jJCalls.gen = this.jj_gen + n2 - this.jj_la;
        jJCalls.first = this.token;
        jJCalls.arg = n2;
    }

    static final class JJCalls {
        int gen;
        Token first;
        int arg;
        JJCalls next;

        JJCalls() {
        }
    }
}

