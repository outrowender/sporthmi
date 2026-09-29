.version 50 0 
.class super [71] 
.super [73] 

.method annotation [75] : [76] 
    .attribute [74] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [18] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method [77] : [78] 
    .attribute [74] .code stack 1 locals 0 
L0:     getstatic [5] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method [79] : [80] 
    .attribute [74] .code stack 1 locals 0 
L0:     getstatic [6] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method [81] : [82] 
    .attribute [74] .code stack 1 locals 0 
L0:     getstatic [7] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method public [83] : [84] 
    .attribute [74] .code stack 5 locals 12 
L0:     iconst_0 
L1:     istore 4 
L3:     iload_3 
L4:     iload_2 
L5:     iadd 
L6:     istore_3 
L7:     iload_2 
L8:     istore 5 
L10:    goto L61 
L13:    aload_1 
L14:    iload 5 
L16:    caload 
L17:    istore 6 
L19:    iload 6 
L21:    sipush 128 
L24:    if_icmplt L49 
L27:    iload 6 
L29:    sipush 165 
L32:    if_icmpeq L49 
L35:    iload 6 
L37:    ldc [8] 
L39:    if_icmplt L55 
L42:    iload 6 
L44:    ldc [9] 
L46:    if_icmpgt L55 
L49:    iinc 4 1 
L52:    goto L58 
L55:    iinc 4 2 
L58:    iinc 5 1 
L61:    iload 5 
L63:    iload_3 
L64:    if_icmplt L13 
L67:    iconst_0 
L68:    istore 5 
L70:    aload_0 
L71:    invokevirtual [15] 
L74:    astore 6 
L76:    aload_0 
L77:    invokevirtual [16] 
L80:    astore 7 
L82:    iload 4 
L84:    newarray byte 
L86:    astore 8 
L88:    iload_2 
L89:    istore 9 
L91:    goto L303 
L94:    aload_1 
L95:    iload 9 
L97:    caload 
L98:    istore 10 
L100:   iload 10 
L102:   sipush 128 
L105:   if_icmpge L122 
L108:   aload 8 
L110:   iload 5 
L112:   iinc 5 1 
L115:   iload 10 
L117:   i2b 
L118:   bastore 
L119:   goto L300 
L122:   aload 6 
L124:   iload 10 
L126:   invokestatic [11] 
L129:   istore 11 
L131:   iload 11 
L133:   iconst_m1 
L134:   if_icmpne L150 
L137:   aload 8 
L139:   iload 5 
L141:   iinc 5 1 
L144:   bipush 63 
L146:   bastore 
L147:   goto L300 
L150:   aload 7 
L152:   iload 11 
L154:   invokevirtual [17] 
L157:   istore 12 
L159:   iload 12 
L161:   bipush 8 
L163:   ishr 
L164:   i2b 
L165:   istore 13 
L167:   iload 13 
L169:   ifle L185 
L172:   aload 8 
L174:   iload 5 
L176:   iinc 5 1 
L179:   bipush 63 
L181:   bastore 
L182:   goto L300 
L185:   iload 13 
L187:   ifge L289 
L190:   iload 13 
L192:   bipush -96 
L194:   if_icmplt L289 
L197:   iload 13 
L199:   sipush 160 
L202:   isub 
L203:   i2b 
L204:   istore 14 
L206:   aload 8 
L208:   iload 5 
L210:   iinc 5 1 
L213:   iload 14 
L215:   iconst_1 
L216:   iadd 
L217:   iconst_1 
L218:   ishr 
L219:   iload 14 
L221:   bipush 63 
L223:   if_icmpge L232 
L226:   sipush 128 
L229:   goto L235 
L232:   sipush 192 
L235:   iadd 
L236:   i2b 
L237:   bastore 
L238:   iload 12 
L240:   sipush 160 
L243:   isub 
L244:   i2b 
L245:   istore 15 
L247:   aload 8 
L249:   iload 5 
L251:   iinc 5 1 
L254:   iload 15 
L256:   iload 14 
L258:   iconst_2 
L259:   irem 
L260:   ifeq L280 
L263:   iload 15 
L265:   bipush 63 
L267:   if_icmple L275 
L270:   bipush 64 
L272:   goto L283 
L275:   bipush 63 
L277:   goto L283 
L280:   sipush 158 
L283:   iadd 
L284:   i2b 
L285:   bastore 
L286:   goto L300 
L289:   aload 8 
L291:   iload 5 
L293:   iinc 5 1 
L296:   iload 12 
L298:   i2b 
L299:   bastore 
L300:   iinc 9 1 
L303:   iload 9 
L305:   iload_3 
L306:   if_icmplt L94 
L309:   iload 5 
L311:   aload 8 
L313:   arraylength 
L314:   if_icmpge L338 
L317:   iload 5 
L319:   newarray byte 
L321:   astore 9 
L323:   aload 8 
L325:   iconst_0 
L326:   aload 9 
L328:   iconst_0 
L329:   iload 5 
L331:   invokestatic [14] 
L334:   aload 9 
L336:   astore 8 
L338:   aload 8 
L340:   areturn 
L341:   nop 
L342:   nop 
L343:   nop 
L344:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [19] 
.const [3] = Class [20] 
.const [4] = Class [21] 
.const [5] = Field [22] [23] 
.const [6] = Field [24] [25] 
.const [7] = Field [26] [27] 
.const [8] = Int 1644101632 
.const [9] = Int -1610678272 
.const [10] = Class [28] 
.const [11] = Method [29] [30] 
.const [12] = Class [31] 
.const [13] = Class [32] 
.const [14] = Method [33] [34] 
.const [15] = Method [35] [36] 
.const [16] = Method [37] [38] 
.const [17] = Method [39] [40] 
.const [18] = Method [41] [42] 
.const [19] = Utf8 com/ibm/oti/io/CharacterConverter_SJIS 
.const [20] = Utf8 com/ibm/oti/io/CharacterConverterSJIS 
.const [21] = Utf8 com/ibm/oti/io/CharacterConverter_EUC_JP 
.const [22] = Class [43] 
.const [23] = NameAndType [44] [45] 
.const [24] = Class [46] 
.const [25] = NameAndType [47] [48] 
.const [26] = Class [49] 
.const [27] = NameAndType [50] [51] 
.const [28] = Utf8 com/ibm/oti/util/BinarySearch 
.const [29] = Class [52] 
.const [30] = NameAndType [53] [54] 
.const [31] = Utf8 java/lang/String 
.const [32] = Utf8 java/lang/System 
.const [33] = Class [55] 
.const [34] = NameAndType [56] [57] 
.const [35] = Class [58] 
.const [36] = NameAndType [59] [60] 
.const [37] = Class [61] 
.const [38] = NameAndType [62] [63] 
.const [39] = Class [64] 
.const [40] = NameAndType [65] [66] 
.const [41] = Class [67] 
.const [42] = NameAndType [68] [69] 
.const [43] = Utf8 com/ibm/oti/io/CharacterConverter_EUC_JP 
.const [44] = Utf8 jis208 
.const [45] = Utf8 Ljava/lang/String; 
.const [46] = Utf8 com/ibm/oti/io/CharacterConverter_EUC_JP 
.const [47] = Utf8 keys 
.const [48] = Utf8 Ljava/lang/String; 
.const [49] = Utf8 com/ibm/oti/io/CharacterConverter_EUC_JP 
.const [50] = Utf8 values 
.const [51] = Utf8 Ljava/lang/String; 
.const [52] = Utf8 com/ibm/oti/util/BinarySearch 
.const [53] = Utf8 binarySearch 
.const [54] = Utf8 (Ljava/lang/String;C)I 
.const [55] = Utf8 java/lang/System 
.const [56] = Utf8 arraycopy 
.const [57] = Utf8 (Ljava/lang/Object;ILjava/lang/Object;II)V 
.const [58] = Utf8 com/ibm/oti/io/CharacterConverter_SJIS 
.const [59] = Utf8 getCharTableKeys 
.const [60] = Utf8 ()Ljava/lang/String; 
.const [61] = Utf8 com/ibm/oti/io/CharacterConverter_SJIS 
.const [62] = Utf8 getCharTableValues 
.const [63] = Utf8 ()Ljava/lang/String; 
.const [64] = Utf8 java/lang/String 
.const [65] = Utf8 charAt 
.const [66] = Utf8 (I)C 
.const [67] = Utf8 com/ibm/oti/io/CharacterConverterSJIS 
.const [68] = Utf8 <init> 
.const [69] = Utf8 ()V 
.const [70] = Utf8 com/ibm/oti/io/CharacterConverter_SJIS 
.const [71] = Class [70] 
.const [72] = Utf8 com/ibm/oti/io/CharacterConverterSJIS 
.const [73] = Class [72] 
.const [74] = Utf8 Code 
.const [75] = Utf8 <init> 
.const [76] = Utf8 ()V 
.const [77] = Utf8 getByteTable 
.const [78] = Utf8 ()Ljava/lang/String; 
.const [79] = Utf8 getCharTableKeys 
.const [80] = Utf8 ()Ljava/lang/String; 
.const [81] = Utf8 getCharTableValues 
.const [82] = Utf8 ()Ljava/lang/String; 
.const [83] = Utf8 convert 
.const [84] = Utf8 ([CII)[B 
.end class 
