.version 50 0 
.class public super [95] 
.super [97] 

.method public annotation [99] : [100] 
    .attribute [98] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [17] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [101] : [102] 
    .attribute [98] .code stack 6 locals 3 
L0:     aconst_null 
L1:     astore_1 
L2:     aload_0 
L3:     instanceof [2] 
L6:     ifeq L53 
L9:     aload_0 
L10:    checkcast [2] 
L13:    checkcast [2] 
L16:    astore_2 
L17:    aload_2 
L18:    arraylength 
L19:    anewarray [3] 
L22:    astore_1 
L23:    iconst_0 
L24:    istore_3 
L25:    iload_3 
L26:    aload_1 
L27:    arraylength 
L28:    if_icmpge L50 
L31:    aload_1 
L32:    iload_3 
L33:    new [25] 
L36:    dup 
L37:    aload_2 
L38:    iload_3 
L39:    baload 
L40:    invokespecial [18] 
L43:    aastore 
L44:    iinc 3 1 
L47:    goto L25 
L50:    goto L356 
L53:    aload_0 
L54:    instanceof [5] 
L57:    ifeq L104 
L60:    aload_0 
L61:    checkcast [5] 
L64:    checkcast [5] 
L67:    astore_2 
L68:    aload_2 
L69:    arraylength 
L70:    anewarray [3] 
L73:    astore_1 
L74:    iconst_0 
L75:    istore_3 
L76:    iload_3 
L77:    aload_1 
L78:    arraylength 
L79:    if_icmpge L101 
L82:    aload_1 
L83:    iload_3 
L84:    new [26] 
L87:    dup 
L88:    aload_2 
L89:    iload_3 
L90:    baload 
L91:    invokespecial [19] 
L94:    aastore 
L95:    iinc 3 1 
L98:    goto L76 
L101:   goto L356 
L104:   aload_0 
L105:   instanceof [7] 
L108:   ifeq L155 
L111:   aload_0 
L112:   checkcast [7] 
L115:   checkcast [7] 
L118:   astore_2 
L119:   aload_2 
L120:   arraylength 
L121:   anewarray [3] 
L124:   astore_1 
L125:   iconst_0 
L126:   istore_3 
L127:   iload_3 
L128:   aload_1 
L129:   arraylength 
L130:   if_icmpge L152 
L133:   aload_1 
L134:   iload_3 
L135:   new [27] 
L138:   dup 
L139:   aload_2 
L140:   iload_3 
L141:   saload 
L142:   invokespecial [20] 
L145:   aastore 
L146:   iinc 3 1 
L149:   goto L127 
L152:   goto L356 
L155:   aload_0 
L156:   instanceof [9] 
L159:   ifeq L206 
L162:   aload_0 
L163:   checkcast [9] 
L166:   checkcast [9] 
L169:   astore_2 
L170:   aload_2 
L171:   arraylength 
L172:   anewarray [3] 
L175:   astore_1 
L176:   iconst_0 
L177:   istore_3 
L178:   iload_3 
L179:   aload_1 
L180:   arraylength 
L181:   if_icmpge L203 
L184:   aload_1 
L185:   iload_3 
L186:   new [28] 
L189:   dup 
L190:   aload_2 
L191:   iload_3 
L192:   iaload 
L193:   invokespecial [21] 
L196:   aastore 
L197:   iinc 3 1 
L200:   goto L178 
L203:   goto L356 
L206:   aload_0 
L207:   instanceof [11] 
L210:   ifeq L257 
L213:   aload_0 
L214:   checkcast [11] 
L217:   checkcast [11] 
L220:   astore_2 
L221:   aload_2 
L222:   arraylength 
L223:   anewarray [3] 
L226:   astore_1 
L227:   iconst_0 
L228:   istore_3 
L229:   iload_3 
L230:   aload_1 
L231:   arraylength 
L232:   if_icmpge L254 
L235:   aload_1 
L236:   iload_3 
L237:   new [29] 
L240:   dup 
L241:   aload_2 
L242:   iload_3 
L243:   laload 
L244:   invokespecial [22] 
L247:   aastore 
L248:   iinc 3 1 
L251:   goto L229 
L254:   goto L356 
L257:   aload_0 
L258:   instanceof [13] 
L261:   ifeq L308 
L264:   aload_0 
L265:   checkcast [13] 
L268:   checkcast [13] 
L271:   astore_2 
L272:   aload_2 
L273:   arraylength 
L274:   anewarray [3] 
L277:   astore_1 
L278:   iconst_0 
L279:   istore_3 
L280:   iload_3 
L281:   aload_1 
L282:   arraylength 
L283:   if_icmpge L305 
L286:   aload_1 
L287:   iload_3 
L288:   new [30] 
L291:   dup 
L292:   aload_2 
L293:   iload_3 
L294:   daload 
L295:   invokespecial [23] 
L298:   aastore 
L299:   iinc 3 1 
L302:   goto L280 
L305:   goto L356 
L308:   aload_0 
L309:   instanceof [15] 
L312:   ifeq L356 
L315:   aload_0 
L316:   checkcast [15] 
L319:   checkcast [15] 
L322:   astore_2 
L323:   aload_2 
L324:   arraylength 
L325:   anewarray [3] 
L328:   astore_1 
L329:   iconst_0 
L330:   istore_3 
L331:   iload_3 
L332:   aload_1 
L333:   arraylength 
L334:   if_icmpge L356 
L337:   aload_1 
L338:   iload_3 
L339:   new [31] 
L342:   dup 
L343:   aload_2 
L344:   iload_3 
L345:   faload 
L346:   invokespecial [24] 
L349:   aastore 
L350:   iinc 3 1 
L353:   goto L331 
L356:   aload_1 
L357:   areturn 
L358:   nop 
L359:   nop 
L360:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [32] 
.const [3] = Class [33] 
.const [4] = Class [34] 
.const [5] = Class [35] 
.const [6] = Class [36] 
.const [7] = Class [37] 
.const [8] = Class [38] 
.const [9] = Class [39] 
.const [10] = Class [40] 
.const [11] = Class [41] 
.const [12] = Class [42] 
.const [13] = Class [43] 
.const [14] = Class [44] 
.const [15] = Class [45] 
.const [16] = Class [46] 
.const [17] = Method [47] [48] 
.const [18] = Method [49] [50] 
.const [19] = Method [51] [52] 
.const [20] = Method [53] [54] 
.const [21] = Method [55] [56] 
.const [22] = Method [57] [58] 
.const [23] = Method [59] [60] 
.const [24] = Method [61] [62] 
.const [25] = Class [63] 
.const [26] = Class [64] 
.const [27] = Class [65] 
.const [28] = Class [66] 
.const [29] = Class [67] 
.const [30] = Class [68] 
.const [31] = Class [69] 
.const [32] = Utf8 [B 
.const [33] = Utf8 java/lang/Object 
.const [34] = Utf8 java/lang/Byte 
.const [35] = Utf8 [Z 
.const [36] = Utf8 java/lang/Boolean 
.const [37] = Utf8 [S 
.const [38] = Utf8 java/lang/Short 
.const [39] = Utf8 [I 
.const [40] = Utf8 java/lang/Integer 
.const [41] = Utf8 [J 
.const [42] = Utf8 java/lang/Long 
.const [43] = Utf8 [D 
.const [44] = Utf8 java/lang/Double 
.const [45] = Utf8 [F 
.const [46] = Utf8 java/lang/Float 
.const [47] = Class [70] 
.const [48] = NameAndType [71] [72] 
.const [49] = Class [73] 
.const [50] = NameAndType [74] [75] 
.const [51] = Class [76] 
.const [52] = NameAndType [77] [78] 
.const [53] = Class [79] 
.const [54] = NameAndType [80] [81] 
.const [55] = Class [82] 
.const [56] = NameAndType [83] [84] 
.const [57] = Class [85] 
.const [58] = NameAndType [86] [87] 
.const [59] = Class [88] 
.const [60] = NameAndType [89] [90] 
.const [61] = Class [91] 
.const [62] = NameAndType [92] [93] 
.const [63] = Utf8 java/lang/Byte 
.const [64] = Utf8 java/lang/Boolean 
.const [65] = Utf8 java/lang/Short 
.const [66] = Utf8 java/lang/Integer 
.const [67] = Utf8 java/lang/Long 
.const [68] = Utf8 java/lang/Double 
.const [69] = Utf8 java/lang/Float 
.const [70] = Utf8 java/lang/Object 
.const [71] = Utf8 <init> 
.const [72] = Utf8 ()V 
.const [73] = Utf8 java/lang/Byte 
.const [74] = Utf8 <init> 
.const [75] = Utf8 (B)V 
.const [76] = Utf8 java/lang/Boolean 
.const [77] = Utf8 <init> 
.const [78] = Utf8 (Z)V 
.const [79] = Utf8 java/lang/Short 
.const [80] = Utf8 <init> 
.const [81] = Utf8 (S)V 
.const [82] = Utf8 java/lang/Integer 
.const [83] = Utf8 <init> 
.const [84] = Utf8 (I)V 
.const [85] = Utf8 java/lang/Long 
.const [86] = Utf8 <init> 
.const [87] = Utf8 (J)V 
.const [88] = Utf8 java/lang/Double 
.const [89] = Utf8 <init> 
.const [90] = Utf8 (D)V 
.const [91] = Utf8 java/lang/Float 
.const [92] = Utf8 <init> 
.const [93] = Utf8 (F)V 
.const [94] = Utf8 de/esolutions/fw/util/commons/ArrayUtils 
.const [95] = Class [94] 
.const [96] = Utf8 java/lang/Object 
.const [97] = Class [96] 
.const [98] = Utf8 Code 
.const [99] = Utf8 <init> 
.const [100] = Utf8 ()V 
.const [101] = Utf8 toObjects 
.const [102] = Utf8 (Ljava/lang/Object;)[Ljava/lang/Object; 
.end class 
