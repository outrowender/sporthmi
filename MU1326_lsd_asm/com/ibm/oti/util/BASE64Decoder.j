.version 50 0 
.class public super [39] 
.super [41] 
.field private static final [42] [43] 

.method private annotation [45] : [46] 
    .attribute [44] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [9] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [47] : [48] 
    .attribute [44] .code stack 4 locals 10 
L0:     aload_0 
L1:     arraylength 
L2:     iconst_1 
L3:     isub 
L4:     istore_1 
L5:     goto L11 
L8:     iinc 1 -1 
L11:    aload_0 
L12:    iload_1 
L13:    baload 
L14:    bipush 61 
L16:    if_icmpeq L8 
L19:    aload_0 
L20:    arraylength 
L21:    iconst_1 
L22:    isub 
L23:    iload_1 
L24:    isub 
L25:    istore_2 
L26:    aload_0 
L27:    arraylength 
L28:    bipush 6 
L30:    imul 
L31:    bipush 8 
L33:    idiv 
L34:    iload_2 
L35:    isub 
L36:    istore_3 
L37:    iload_3 
L38:    newarray byte 
L40:    astore 4 
L42:    iconst_0 
L43:    istore 5 
L45:    iconst_0 
L46:    istore 6 
L48:    iconst_0 
L49:    istore 7 
L51:    iload_1 
L52:    iconst_1 
L53:    iadd 
L54:    iconst_4 
L55:    idiv 
L56:    istore 8 
L58:    iconst_0 
L59:    istore 9 
L61:    goto L144 
L64:    iconst_0 
L65:    istore 7 
L67:    iconst_0 
L68:    istore 10 
L70:    goto L94 
L73:    iload 7 
L75:    bipush 6 
L77:    ishl 
L78:    aload_0 
L79:    iload 5 
L81:    iinc 5 1 
L84:    baload 
L85:    invokestatic [4] 
L88:    ior 
L89:    istore 7 
L91:    iinc 10 1 
L94:    iload 10 
L96:    iconst_4 
L97:    if_icmplt L73 
L100:   iload 6 
L102:   iconst_2 
L103:   iadd 
L104:   istore 10 
L106:   goto L131 
L109:   aload 4 
L111:   iload 10 
L113:   iload 7 
L115:   sipush 255 
L118:   iand 
L119:   i2b 
L120:   bastore 
L121:   iload 7 
L123:   bipush 8 
L125:   iushr 
L126:   istore 7 
L128:   iinc 10 -1 
L131:   iload 10 
L133:   iload 6 
L135:   if_icmpge L109 
L138:   iinc 6 3 
L141:   iinc 9 1 
L144:   iload 9 
L146:   iload 8 
L148:   if_icmplt L64 
L151:   iload_2 
L152:   tableswitch 1 
            L176 
            L267 
            default : L343 

L176:   iconst_0 
L177:   istore 7 
L179:   iconst_0 
L180:   istore 9 
L182:   goto L206 
L185:   iload 7 
L187:   bipush 6 
L189:   ishl 
L190:   aload_0 
L191:   iload 5 
L193:   iinc 5 1 
L196:   baload 
L197:   invokestatic [4] 
L200:   ior 
L201:   istore 7 
L203:   iinc 9 1 
L206:   iload 9 
L208:   iconst_3 
L209:   if_icmplt L185 
L212:   iload 7 
L214:   bipush 6 
L216:   ishl 
L217:   istore 7 
L219:   iload 7 
L221:   bipush 8 
L223:   iushr 
L224:   istore 7 
L226:   iload 6 
L228:   iconst_1 
L229:   iadd 
L230:   istore 9 
L232:   goto L257 
L235:   aload 4 
L237:   iload 9 
L239:   iload 7 
L241:   sipush 255 
L244:   iand 
L245:   i2b 
L246:   bastore 
L247:   iload 7 
L249:   bipush 8 
L251:   iushr 
L252:   istore 7 
L254:   iinc 9 -1 
L257:   iload 9 
L259:   iload 6 
L261:   if_icmpge L235 
L264:   goto L343 
L267:   iconst_0 
L268:   istore 7 
L270:   iconst_0 
L271:   istore 9 
L273:   goto L297 
L276:   iload 7 
L278:   bipush 6 
L280:   ishl 
L281:   aload_0 
L282:   iload 5 
L284:   iinc 5 1 
L287:   baload 
L288:   invokestatic [4] 
L291:   ior 
L292:   istore 7 
L294:   iinc 9 1 
L297:   iload 9 
L299:   iconst_2 
L300:   if_icmplt L276 
L303:   iload 7 
L305:   bipush 6 
L307:   ishl 
L308:   istore 7 
L310:   iload 7 
L312:   bipush 6 
L314:   ishl 
L315:   istore 7 
L317:   iload 7 
L319:   bipush 8 
L321:   iushr 
L322:   istore 7 
L324:   iload 7 
L326:   bipush 8 
L328:   iushr 
L329:   istore 7 
L331:   aload 4 
L333:   iload 6 
L335:   iload 7 
L337:   sipush 255 
L340:   iand 
L341:   i2b 
L342:   bastore 
L343:   aload 4 
L345:   areturn 
L346:   nop 
L347:   nop 
L348:   
    .end code 
.end method 

.method static [49] : [50] 
    .attribute [44] .code stack 4 locals 1 
L0:     iload_0 
L1:     i2c 
L2:     istore_1 
L3:     iload_1 
L4:     bipush 90 
L6:     if_icmpgt L20 
L9:     iload_1 
L10:    bipush 65 
L12:    if_icmplt L20 
L15:    iload_1 
L16:    bipush 65 
L18:    isub 
L19:    areturn 
L20:    iload_1 
L21:    bipush 122 
L23:    if_icmpgt L40 
L26:    iload_1 
L27:    bipush 97 
L29:    if_icmplt L40 
L32:    iload_1 
L33:    bipush 97 
L35:    isub 
L36:    bipush 26 
L38:    iadd 
L39:    areturn 
L40:    iload_1 
L41:    bipush 57 
L43:    if_icmpgt L60 
L46:    iload_1 
L47:    bipush 48 
L49:    if_icmplt L60 
L52:    iload_1 
L53:    bipush 48 
L55:    isub 
L56:    bipush 52 
L58:    iadd 
L59:    areturn 
L60:    iload_1 
L61:    tableswitch 43 
            L96 
            L102 
            L102 
            L102 
            L99 
            default : L102 

L96:    bipush 62 
L98:    areturn 
L99:    bipush 63 
L101:   areturn 
L102:   new [11] 
L105:   dup 
L106:   ldc [6] 
L108:   iload_1 
L109:   invokestatic [8] 
L112:   invokespecial [10] 
L115:   athrow 
L116:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [12] 
.const [3] = Class [13] 
.const [4] = Method [14] [15] 
.const [5] = Class [16] 
.const [6] = String [17] 
.const [7] = Class [18] 
.const [8] = Method [19] [20] 
.const [9] = Method [21] [22] 
.const [10] = Method [23] [24] 
.const [11] = Class [25] 
.const [12] = Utf8 com/ibm/oti/util/BASE64Decoder 
.const [13] = Utf8 java/lang/Object 
.const [14] = Class [26] 
.const [15] = NameAndType [27] [28] 
.const [16] = Utf8 java/lang/IllegalArgumentException 
.const [17] = Utf8 K008c 
.const [18] = Utf8 com/ibm/oti/util/Msg 
.const [19] = Class [29] 
.const [20] = NameAndType [30] [31] 
.const [21] = Class [32] 
.const [22] = NameAndType [33] [34] 
.const [23] = Class [35] 
.const [24] = NameAndType [36] [37] 
.const [25] = Utf8 java/lang/IllegalArgumentException 
.const [26] = Utf8 com/ibm/oti/util/BASE64Decoder 
.const [27] = Utf8 decodeDigit 
.const [28] = Utf8 (B)I 
.const [29] = Utf8 com/ibm/oti/util/Msg 
.const [30] = Utf8 getString 
.const [31] = Utf8 (Ljava/lang/String;C)Ljava/lang/String; 
.const [32] = Utf8 java/lang/Object 
.const [33] = Utf8 <init> 
.const [34] = Utf8 ()V 
.const [35] = Utf8 java/lang/IllegalArgumentException 
.const [36] = Utf8 <init> 
.const [37] = Utf8 (Ljava/lang/String;)V 
.const [38] = Utf8 com/ibm/oti/util/BASE64Decoder 
.const [39] = Class [38] 
.const [40] = Utf8 java/lang/Object 
.const [41] = Class [40] 
.const [42] = Utf8 equalSign 
.const [43] = Utf8 B 
.const [44] = Utf8 Code 
.const [45] = Utf8 <init> 
.const [46] = Utf8 ()V 
.const [47] = Utf8 decode 
.const [48] = Utf8 ([B)[B 
.const [49] = Utf8 decodeDigit 
.const [50] = Utf8 (B)I 
.end class 
