.version 50 0 
.class public final super [11] 
.super [13] 
.implements [15] 

.method public annotation [17] : [18] 
    .attribute [16] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [3] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [19] : [20] 
    .attribute [16] .code stack 1 locals 1 
L0:     iconst_3 
L1:     istore_3 
L2:     iload_1 
L3:     lookupswitch 
            13 : L28 
            17 : L37 
            default : L46 

L28:    iload_2 
L29:    ifne L48 
L32:    iconst_0 
L33:    istore_3 
L34:    goto L48 
L37:    iload_2 
L38:    ifne L48 
L41:    iconst_1 
L42:    istore_3 
L43:    goto L48 
L46:    iconst_3 
L47:    istore_3 
L48:    iload_3 
L49:    areturn 
L50:    nop 
L51:    nop 
L52:    
    .end code 
.end method 

.method public [21] : [22] 
    .attribute [16] .code stack 2 locals 1 
L0:     iconst_3 
L1:     istore_3 
L2:     iload_1 
L3:     tableswitch 13 
            L60 
            L71 
            L82 
            L134 
            L93 
            L104 
            L134 
            L134 
            L134 
            L134 
            L123 
            default : L134 

L60:    iload_2 
L61:    bipush 9 
L63:    if_icmpne L136 
L66:    iconst_0 
L67:    istore_3 
L68:    goto L136 
L71:    iload_2 
L72:    bipush 9 
L74:    if_icmpne L136 
L77:    iconst_0 
L78:    istore_3 
L79:    goto L136 
L82:    iload_2 
L83:    bipush 9 
L85:    if_icmpne L136 
L88:    iconst_0 
L89:    istore_3 
L90:    goto L136 
L93:    iload_2 
L94:    bipush 9 
L96:    if_icmpne L136 
L99:    iconst_1 
L100:   istore_3 
L101:   goto L136 
L104:   iload_2 
L105:   bipush 10 
L107:   if_icmpne L112 
L110:   iconst_0 
L111:   istore_3 
L112:   iload_2 
L113:   bipush 11 
L115:   if_icmpne L136 
L118:   iconst_0 
L119:   istore_3 
L120:   goto L136 
L123:   iload_2 
L124:   bipush 9 
L126:   if_icmpne L136 
L129:   iconst_2 
L130:   istore_3 
L131:   goto L136 
L134:   iconst_3 
L135:   istore_3 
L136:   iload_3 
L137:   areturn 
L138:   nop 
L139:   nop 
L140:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [4] 
.const [3] = Method [5] [6] 
.const [4] = Utf8 java/lang/Object 
.const [5] = Class [7] 
.const [6] = NameAndType [8] [9] 
.const [7] = Utf8 java/lang/Object 
.const [8] = Utf8 <init> 
.const [9] = Utf8 ()V 
.const [10] = Utf8 de/audi/app/bap/generated/eni/DataTypeMappingENI 
.const [11] = Class [10] 
.const [12] = Utf8 java/lang/Object 
.const [13] = Class [12] 
.const [14] = Utf8 de/audi/app/bap/fw/request/IDataTypeMapping 
.const [15] = Class [14] 
.const [16] = Utf8 Code 
.const [17] = Utf8 <init> 
.const [18] = Utf8 ()V 
.const [19] = Utf8 getRequestDataType 
.const [20] = Utf8 (II)I 
.const [21] = Utf8 getIndicationDataType 
.const [22] = Utf8 (II)I 
.end class 
