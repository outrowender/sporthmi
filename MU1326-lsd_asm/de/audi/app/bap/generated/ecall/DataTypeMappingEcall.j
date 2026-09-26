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
L3:     lookupswitch 
            13 : L28 
            18 : L37 
            default : L47 

L28:    iload_2 
L29:    ifne L49 
L32:    iconst_0 
L33:    istore_3 
L34:    goto L49 
L37:    iload_2 
L38:    iconst_4 
L39:    if_icmpne L49 
L42:    iconst_0 
L43:    istore_3 
L44:    goto L49 
L47:    iconst_3 
L48:    istore_3 
L49:    iload_3 
L50:    areturn 
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
            L68 
            L180 
            L79 
            L180 
            L180 
            L90 
            L109 
            L128 
            L180 
            L180 
            L139 
            L150 
            L161 
            default : L180 

L68:    iload_2 
L69:    bipush 9 
L71:    if_icmpne L182 
L74:    iconst_0 
L75:    istore_3 
L76:    goto L182 
L79:    iload_2 
L80:    bipush 9 
L82:    if_icmpne L182 
L85:    iconst_0 
L86:    istore_3 
L87:    goto L182 
L90:    iload_2 
L91:    bipush 10 
L93:    if_icmpne L98 
L96:    iconst_0 
L97:    istore_3 
L98:    iload_2 
L99:    bipush 11 
L101:   if_icmpne L182 
L104:   iconst_0 
L105:   istore_3 
L106:   goto L182 
L109:   iload_2 
L110:   bipush 10 
L112:   if_icmpne L117 
L115:   iconst_0 
L116:   istore_3 
L117:   iload_2 
L118:   bipush 11 
L120:   if_icmpne L182 
L123:   iconst_0 
L124:   istore_3 
L125:   goto L182 
L128:   iload_2 
L129:   bipush 9 
L131:   if_icmpne L182 
L134:   iconst_0 
L135:   istore_3 
L136:   goto L182 
L139:   iload_2 
L140:   bipush 9 
L142:   if_icmpne L182 
L145:   iconst_0 
L146:   istore_3 
L147:   goto L182 
L150:   iload_2 
L151:   bipush 9 
L153:   if_icmpne L182 
L156:   iconst_2 
L157:   istore_3 
L158:   goto L182 
L161:   iload_2 
L162:   bipush 10 
L164:   if_icmpne L169 
L167:   iconst_0 
L168:   istore_3 
L169:   iload_2 
L170:   bipush 11 
L172:   if_icmpne L182 
L175:   iconst_0 
L176:   istore_3 
L177:   goto L182 
L180:   iconst_3 
L181:   istore_3 
L182:   iload_3 
L183:   areturn 
L184:   
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
.const [10] = Utf8 de/audi/app/bap/generated/ecall/DataTypeMappingEcall 
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
