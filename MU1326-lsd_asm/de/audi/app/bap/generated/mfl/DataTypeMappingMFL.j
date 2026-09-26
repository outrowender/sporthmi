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
    .attribute [16] .code stack 2 locals 1 
L0:     iconst_3 
L1:     istore_3 
L2:     iload_1 
L3:     tableswitch 14 
            L44 
            L55 
            L66 
            L96 
            L96 
            L96 
            L77 
            default : L96 

L44:    iload_2 
L45:    bipush 7 
L47:    if_icmpne L98 
L50:    iconst_0 
L51:    istore_3 
L52:    goto L98 
L55:    iload_2 
L56:    bipush 7 
L58:    if_icmpne L98 
L61:    iconst_0 
L62:    istore_3 
L63:    goto L98 
L66:    iload_2 
L67:    bipush 7 
L69:    if_icmpne L98 
L72:    iconst_1 
L73:    istore_3 
L74:    goto L98 
L77:    iload_2 
L78:    bipush 8 
L80:    if_icmpne L85 
L83:    iconst_0 
L84:    istore_3 
L85:    iload_2 
L86:    bipush 9 
L88:    if_icmpne L98 
L91:    iconst_0 
L92:    istore_3 
L93:    goto L98 
L96:    iconst_3 
L97:    istore_3 
L98:    iload_3 
L99:    areturn 
L100:   
    .end code 
.end method 

.method public [21] : [22] 
    .attribute [16] .code stack 1 locals 1 
L0:     iconst_3 
L1:     istore_3 
L2:     iload_1 
L3:     lookupswitch 
            16 : L20 
            default : L29 

L20:    iload_2 
L21:    ifne L31 
L24:    iconst_1 
L25:    istore_3 
L26:    goto L31 
L29:    iconst_3 
L30:    istore_3 
L31:    iload_3 
L32:    areturn 
L33:    nop 
L34:    nop 
L35:    nop 
L36:    
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
.const [10] = Utf8 de/audi/app/bap/generated/mfl/DataTypeMappingMFL 
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
