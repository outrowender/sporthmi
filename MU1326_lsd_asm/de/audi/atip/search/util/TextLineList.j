.version 50 0 
.class public super [139] 
.super [141] 
.field [142] [143] 

.method public [145] : [146] 
    .attribute [144] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [25] 
L4:     aload_0 
L5:     new [29] 
L8:     dup 
L9:     invokespecial [26] 
L12:    putfield [30] 
L15:    return 
L16:    
    .end code 
.end method 

.method public [147] : [148] 
    .attribute [144] .code stack 4 locals 0 
L0:     aload_0 
L1:     invokespecial [25] 
L4:     aload_0 
L5:     new [29] 
L8:     dup 
L9:     iload_1 
L10:    invokespecial [27] 
L13:    putfield [30] 
L16:    return 
L17:    nop 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [149] : [150] 
    .attribute [144] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [12] 
L4:     aload_1 
L5:     invokevirtual [13] 
L8:     pop 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [151] : [152] 
    .attribute [144] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [12] 
L4:     aload_1 
L5:     invokevirtual [13] 
L8:     pop 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [153] : [154] 
    .attribute [144] .code stack 2 locals 3 
L0:     new [31] 
L3:     dup 
L4:     invokespecial [28] 
L7:     astore_1 
L8:     aload_0 
L9:     getfield [12] 
L12:    ifnull L74 
L15:    iconst_0 
L16:    istore_2 
L17:    iload_2 
L18:    aload_0 
L19:    getfield [12] 
L22:    invokevirtual [14] 
L25:    if_icmpge L74 
L28:    aload_0 
L29:    getfield [12] 
L32:    iload_2 
L33:    invokevirtual [15] 
L36:    astore_3 
L37:    aload_3 
L38:    instanceof [4] 
L41:    ifeq L59 
L44:    aload_1 
L45:    aload_3 
L46:    checkcast [4] 
L49:    invokevirtual [16] 
L52:    invokevirtual [17] 
L55:    pop 
L56:    goto L68 
L59:    aload_1 
L60:    aload_3 
L61:    checkcast [5] 
L64:    invokevirtual [17] 
L67:    pop 
L68:    iinc 2 1 
L71:    goto L17 
L74:    aload_1 
L75:    invokevirtual [18] 
L78:    astore_2 
L79:    aload_2 
L80:    ifnull L87 
L83:    aload_2 
L84:    goto L89 
L87:    ldc [6] 
L89:    areturn 
L90:    nop 
L91:    nop 
L92:    
    .end code 
.end method 

.method public [155] : [156] 
    .attribute [144] .code stack 5 locals 12 
L0:     aload_0 
L1:     getfield [12] 
L4:     ifnonnull L9 
L7:     aconst_null 
L8:     areturn 
L9:     iconst_0 
L10:    istore_1 
L11:    iconst_0 
L12:    istore_2 
L13:    iload_2 
L14:    aload_0 
L15:    getfield [12] 
L18:    invokevirtual [14] 
L21:    if_icmpge L74 
L24:    aload_0 
L25:    getfield [12] 
L28:    iload_2 
L29:    invokevirtual [15] 
L32:    astore_3 
L33:    aload_3 
L34:    ifnull L68 
L37:    aload_3 
L38:    instanceof [4] 
L41:    ifeq L68 
L44:    aload_3 
L45:    checkcast [4] 
L48:    astore 4 
L50:    aload 4 
L52:    invokevirtual [19] 
L55:    astore 5 
L57:    aload 5 
L59:    ifnull L68 
L62:    iload_1 
L63:    aload 5 
L65:    arraylength 
L66:    iadd 
L67:    istore_1 
L68:    iinc 2 1 
L71:    goto L13 
L74:    iload_1 
L75:    ifne L80 
L78:    aconst_null 
L79:    areturn 
L80:    iload_1 
L81:    iconst_2 
L82:    imul 
L83:    newarray int 
L85:    astore_2 
L86:    iconst_0 
L87:    istore_3 
L88:    iconst_0 
L89:    istore 4 
L91:    iconst_0 
L92:    istore 5 
L94:    iload 5 
L96:    aload_0 
L97:    getfield [12] 
L100:   invokevirtual [14] 
L103:   if_icmpge L379 
L106:   aconst_null 
L107:   astore 6 
L109:   aconst_null 
L110:   astore 7 
L112:   aconst_null 
L113:   astore 8 
L115:   aload_0 
L116:   getfield [12] 
L119:   iload 5 
L121:   invokevirtual [15] 
L124:   instanceof [4] 
L127:   ifeq L161 
L130:   aload_0 
L131:   getfield [12] 
L134:   iload 5 
L136:   invokevirtual [15] 
L139:   checkcast [4] 
L142:   astore 6 
L144:   aload 6 
L146:   invokevirtual [19] 
L149:   astore 7 
L151:   aload 6 
L153:   invokevirtual [16] 
L156:   astore 8 
L158:   goto L175 
L161:   aload_0 
L162:   getfield [12] 
L165:   iload 5 
L167:   invokevirtual [15] 
L170:   checkcast [5] 
L173:   astore 8 
L175:   aload 7 
L177:   ifnull L360 
L180:   aload 8 
L182:   ifnull L360 
L185:   aload 7 
L187:   arraylength 
L188:   ifle L360 
L191:   aload 7 
L193:   arraylength 
L194:   istore 9 
L196:   iconst_1 
L197:   istore 10 
L199:   iconst_0 
L200:   istore 11 
L202:   iload 11 
L204:   iload 9 
L206:   iconst_1 
L207:   isub 
L208:   if_icmpge L272 
L211:   aload 7 
L213:   iload 11 
L215:   aaload 
L216:   getfield [20] 
L219:   aload 7 
L221:   iload 11 
L223:   iconst_1 
L224:   iadd 
L225:   aaload 
L226:   getfield [20] 
L229:   if_icmple L266 
L232:   aload 7 
L234:   iload 11 
L236:   aaload 
L237:   astore 12 
L239:   aload 7 
L241:   iload 11 
L243:   aload 7 
L245:   iload 11 
L247:   iconst_1 
L248:   iadd 
L249:   aaload 
L250:   aastore 
L251:   aload 7 
L253:   iload 11 
L255:   iconst_1 
L256:   iadd 
L257:   aload 12 
L259:   aastore 
L260:   iload 11 
L262:   iconst_1 
L263:   iadd 
L264:   istore 10 
L266:   iinc 11 1 
L269:   goto L202 
L272:   iload 10 
L274:   istore 9 
L276:   iload 9 
L278:   iconst_1 
L279:   if_icmpgt L196 
L282:   iconst_0 
L283:   istore 10 
L285:   iload 10 
L287:   aload 7 
L289:   arraylength 
L290:   if_icmpge L360 
L293:   aload 7 
L295:   iload 10 
L297:   aaload 
L298:   ifnull L354 
L301:   aload 7 
L303:   iload 10 
L305:   aaload 
L306:   invokevirtual [21] 
L309:   aload 7 
L311:   iload 10 
L313:   aaload 
L314:   invokevirtual [22] 
L317:   if_icmpgt L354 
L320:   aload_2 
L321:   iload 4 
L323:   iinc 4 1 
L326:   iload_3 
L327:   aload 7 
L329:   iload 10 
L331:   aaload 
L332:   invokevirtual [21] 
L335:   iadd 
L336:   iastore 
L337:   aload_2 
L338:   iload 4 
L340:   iinc 4 1 
L343:   iload_3 
L344:   aload 7 
L346:   iload 10 
L348:   aaload 
L349:   invokevirtual [22] 
L352:   iadd 
L353:   iastore 
L354:   iinc 10 1 
L357:   goto L285 
L360:   aload 8 
L362:   ifnull L373 
L365:   iload_3 
L366:   aload 8 
L368:   invokevirtual [23] 
L371:   iadd 
L372:   istore_3 
L373:   iinc 5 1 
L376:   goto L94 
L379:   iload 4 
L381:   ifne L386 
L384:   aconst_null 
L385:   areturn 
L386:   iload 4 
L388:   aload_2 
L389:   arraylength 
L390:   if_icmpne L395 
L393:   aload_2 
L394:   areturn 
L395:   iload 4 
L397:   newarray int 
L399:   astore 5 
L401:   aload_2 
L402:   iconst_0 
L403:   aload 5 
L405:   iconst_0 
L406:   iload 4 
L408:   invokestatic [7] 
L411:   aload 5 
L413:   areturn 
L414:   nop 
L415:   nop 
L416:   
    .end code 
.end method 

.method public [157] : [158] 
    .attribute [144] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [12] 
L4:     invokevirtual [14] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public [159] : [160] 
    .attribute [144] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [12] 
L4:     invokevirtual [24] 
L7:     return 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [32] 
.const [3] = Class [33] 
.const [4] = Class [34] 
.const [5] = Class [35] 
.const [6] = String [36] 
.const [7] = Method [37] [38] 
.const [8] = Class [39] 
.const [9] = Class [40] 
.const [10] = Class [41] 
.const [11] = Class [42] 
.const [12] = Field [43] [44] 
.const [13] = Method [45] [46] 
.const [14] = Method [47] [48] 
.const [15] = Method [49] [50] 
.const [16] = Method [51] [52] 
.const [17] = Method [53] [54] 
.const [18] = Method [55] [56] 
.const [19] = Method [57] [58] 
.const [20] = Field [59] [60] 
.const [21] = Method [61] [62] 
.const [22] = Method [63] [64] 
.const [23] = Method [65] [66] 
.const [24] = Method [67] [68] 
.const [25] = Method [69] [70] 
.const [26] = Method [71] [72] 
.const [27] = Method [73] [74] 
.const [28] = Method [75] [76] 
.const [29] = Class [77] 
.const [30] = Field [78] [79] 
.const [31] = Class [80] 
.const [32] = Utf8 java/util/ArrayList 
.const [33] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [34] = Utf8 org/dsi/ifc/search/Token 
.const [35] = Utf8 java/lang/String 
.const [36] = Utf8 '' 
.const [37] = Class [81] 
.const [38] = NameAndType [82] [83] 
.const [39] = Utf8 de/audi/atip/search/util/TextLineList 
.const [40] = Utf8 java/lang/Object 
.const [41] = Utf8 org/dsi/ifc/search/Highlight 
.const [42] = Utf8 java/lang/System 
.const [43] = Class [84] 
.const [44] = NameAndType [85] [86] 
.const [45] = Class [87] 
.const [46] = NameAndType [88] [89] 
.const [47] = Class [90] 
.const [48] = NameAndType [91] [92] 
.const [49] = Class [93] 
.const [50] = NameAndType [94] [95] 
.const [51] = Class [96] 
.const [52] = NameAndType [97] [98] 
.const [53] = Class [99] 
.const [54] = NameAndType [100] [101] 
.const [55] = Class [102] 
.const [56] = NameAndType [103] [104] 
.const [57] = Class [105] 
.const [58] = NameAndType [106] [107] 
.const [59] = Class [108] 
.const [60] = NameAndType [109] [110] 
.const [61] = Class [111] 
.const [62] = NameAndType [112] [113] 
.const [63] = Class [114] 
.const [64] = NameAndType [115] [116] 
.const [65] = Class [117] 
.const [66] = NameAndType [118] [119] 
.const [67] = Class [120] 
.const [68] = NameAndType [121] [122] 
.const [69] = Class [123] 
.const [70] = NameAndType [124] [125] 
.const [71] = Class [126] 
.const [72] = NameAndType [127] [128] 
.const [73] = Class [129] 
.const [74] = NameAndType [130] [131] 
.const [75] = Class [132] 
.const [76] = NameAndType [133] [134] 
.const [77] = Utf8 java/util/ArrayList 
.const [78] = Class [135] 
.const [79] = NameAndType [136] [137] 
.const [80] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [81] = Utf8 java/lang/System 
.const [82] = Utf8 arraycopy 
.const [83] = Utf8 (Ljava/lang/Object;ILjava/lang/Object;II)V 
.const [84] = Utf8 de/audi/atip/search/util/TextLineList 
.const [85] = Utf8 tokens 
.const [86] = Utf8 Ljava/util/ArrayList; 
.const [87] = Utf8 java/util/ArrayList 
.const [88] = Utf8 add 
.const [89] = Utf8 (Ljava/lang/Object;)Z 
.const [90] = Utf8 java/util/ArrayList 
.const [91] = Utf8 size 
.const [92] = Utf8 ()I 
.const [93] = Utf8 java/util/ArrayList 
.const [94] = Utf8 get 
.const [95] = Utf8 (I)Ljava/lang/Object; 
.const [96] = Utf8 org/dsi/ifc/search/Token 
.const [97] = Utf8 getToken 
.const [98] = Utf8 ()Ljava/lang/String; 
.const [99] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [100] = Utf8 append 
.const [101] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [102] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [103] = Utf8 toString 
.const [104] = Utf8 ()Ljava/lang/String; 
.const [105] = Utf8 org/dsi/ifc/search/Token 
.const [106] = Utf8 getHighlights 
.const [107] = Utf8 ()[Lorg/dsi/ifc/search/Highlight; 
.const [108] = Utf8 org/dsi/ifc/search/Highlight 
.const [109] = Utf8 highlightStart 
.const [110] = Utf8 I 
.const [111] = Utf8 org/dsi/ifc/search/Highlight 
.const [112] = Utf8 getHighlightStart 
.const [113] = Utf8 ()I 
.const [114] = Utf8 org/dsi/ifc/search/Highlight 
.const [115] = Utf8 getHighlightEnd 
.const [116] = Utf8 ()I 
.const [117] = Utf8 java/lang/String 
.const [118] = Utf8 length 
.const [119] = Utf8 ()I 
.const [120] = Utf8 java/util/ArrayList 
.const [121] = Utf8 clear 
.const [122] = Utf8 ()V 
.const [123] = Utf8 java/lang/Object 
.const [124] = Utf8 <init> 
.const [125] = Utf8 ()V 
.const [126] = Utf8 java/util/ArrayList 
.const [127] = Utf8 <init> 
.const [128] = Utf8 ()V 
.const [129] = Utf8 java/util/ArrayList 
.const [130] = Utf8 <init> 
.const [131] = Utf8 (I)V 
.const [132] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [133] = Utf8 <init> 
.const [134] = Utf8 ()V 
.const [135] = Utf8 de/audi/atip/search/util/TextLineList 
.const [136] = Utf8 tokens 
.const [137] = Utf8 Ljava/util/ArrayList; 
.const [138] = Utf8 de/audi/atip/search/util/TextLineList 
.const [139] = Class [138] 
.const [140] = Utf8 java/lang/Object 
.const [141] = Class [140] 
.const [142] = Utf8 tokens 
.const [143] = Utf8 Ljava/util/ArrayList; 
.const [144] = Utf8 Code 
.const [145] = Utf8 <init> 
.const [146] = Utf8 ()V 
.const [147] = Utf8 <init> 
.const [148] = Utf8 (I)V 
.const [149] = Utf8 addText 
.const [150] = Utf8 (Ljava/lang/String;)V 
.const [151] = Utf8 addToken 
.const [152] = Utf8 (Lorg/dsi/ifc/search/Token;)V 
.const [153] = Utf8 getText 
.const [154] = Utf8 ()Ljava/lang/String; 
.const [155] = Utf8 getTextHighlightIndices 
.const [156] = Utf8 ()[I 
.const [157] = Utf8 size 
.const [158] = Utf8 ()I 
.const [159] = Utf8 clear 
.const [160] = Utf8 ()V 
.end class 
