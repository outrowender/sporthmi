.version 50 0 
.class super [149] 
.super [151] 
.field private static final [152] [153] 
.field static final [154] [155] 
.field static final [156] [157] 
.field static final [158] [159] 
.field private [160] [161] 
.field private [162] [163] 
.field private [164] [165] 
.field private [166] [167] 
.field private [168] [169] 
.field [170] [171] 
.field [172] [173] 
.field private [174] [175] 

.method [177] : [178] 
    .attribute [176] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [18] 
L4:     aload_0 
L5:     sipush 1024 
L8:     newarray char 
L10:    putfield [22] 
L13:    aload_0 
L14:    iconst_0 
L15:    putfield [23] 
L18:    aload_0 
L19:    iconst_0 
L20:    putfield [24] 
L23:    aload_0 
L24:    iconst_0 
L25:    putfield [25] 
L28:    aload_0 
L29:    bipush 120 
L31:    newarray char 
L33:    putfield [26] 
L36:    aload_0 
L37:    aload_1 
L38:    putfield [27] 
L41:    return 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 

.method private [179] : [180] 
    .attribute [176] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [11] 
L4:     aload_0 
L5:     getfield [10] 
L8:     if_icmpne L49 
L11:    aload_0 
L12:    aload_0 
L13:    getfield [14] 
L16:    aload_0 
L17:    getfield [9] 
L20:    invokevirtual [15] 
L23:    dup_x1 
L24:    putfield [23] 
L27:    iconst_m1 
L28:    if_icmpne L44 
L31:    aload_0 
L32:    iconst_m1 
L33:    putfield [24] 
L36:    aload_0 
L37:    iconst_1 
L38:    putfield [25] 
L41:    goto L76 
L44:    aload_0 
L45:    iconst_0 
L46:    putfield [24] 
L49:    aload_0 
L50:    getfield [9] 
L53:    aload_0 
L54:    dup 
L55:    getfield [11] 
L58:    dup_x1 
L59:    iconst_1 
L60:    iadd 
L61:    putfield [24] 
L64:    caload 
L65:    bipush 10 
L67:    if_icmpne L73 
L70:    goto L76 
L73:    goto L0 
L76:    return 
L77:    nop 
L78:    nop 
L79:    nop 
L80:    
    .end code 
.end method 

.method private [181] : [182] 
    .attribute [176] .code stack 5 locals 2 
L0:     iconst_0 
L1:     istore_1 
L2:     aload_0 
L3:     getfield [11] 
L6:     aload_0 
L7:     getfield [10] 
L10:    if_icmpne L51 
L13:    aload_0 
L14:    aload_0 
L15:    getfield [14] 
L18:    aload_0 
L19:    getfield [9] 
L22:    invokevirtual [15] 
L25:    dup_x1 
L26:    putfield [23] 
L29:    iconst_m1 
L30:    if_icmpne L46 
L33:    aload_0 
L34:    iconst_m1 
L35:    putfield [24] 
L38:    aload_0 
L39:    iconst_1 
L40:    putfield [25] 
L43:    goto L88 
L46:    aload_0 
L47:    iconst_0 
L48:    putfield [24] 
L51:    aload_0 
L52:    getfield [9] 
L55:    aload_0 
L56:    dup 
L57:    getfield [11] 
L60:    dup_x1 
L61:    iconst_1 
L62:    iadd 
L63:    putfield [24] 
L66:    caload 
L67:    istore_2 
L68:    iload_2 
L69:    bipush 47 
L71:    if_icmpne L83 
L74:    iload_1 
L75:    bipush 42 
L77:    if_icmpne L83 
L80:    goto L88 
L83:    iload_2 
L84:    istore_1 
L85:    goto L2 
L88:    return 
L89:    nop 
L90:    nop 
L91:    nop 
L92:    
    .end code 
.end method 

.method interface [183] : [184] 
    .attribute [176] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [12] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method [185] : [186] 
    .attribute [176] .code stack 6 locals 5 
L0:     iconst_0 
L1:     istore_1 
L2:     bipush 32 
L4:     istore_2 
L5:     iconst_0 
L6:     istore 4 
        .catch [4] from L8 to L344 using L344 
L8:     aload_0 
L9:     getfield [11] 
L12:    aload_0 
L13:    getfield [10] 
L16:    if_icmpne L57 
L19:    aload_0 
L20:    aload_0 
L21:    getfield [14] 
L24:    aload_0 
L25:    getfield [9] 
L28:    invokevirtual [15] 
L31:    dup_x1 
L32:    putfield [23] 
L35:    iconst_m1 
L36:    if_icmpne L52 
L39:    aload_0 
L40:    iconst_m1 
L41:    putfield [24] 
L44:    aload_0 
L45:    iconst_1 
L46:    putfield [25] 
L49:    goto L350 
L52:    aload_0 
L53:    iconst_0 
L54:    putfield [24] 
L57:    aload_0 
L58:    getfield [9] 
L61:    aload_0 
L62:    dup 
L63:    getfield [11] 
L66:    dup_x1 
L67:    iconst_1 
L68:    iadd 
L69:    putfield [24] 
L72:    caload 
L73:    istore_3 
L74:    iload_3 
L75:    bipush 10 
L77:    if_icmpeq L92 
L80:    iload_3 
L81:    bipush 13 
L83:    if_icmpeq L92 
L86:    iload_3 
L87:    bipush 9 
L89:    if_icmpne L95 
L92:    bipush 32 
L94:    istore_3 
L95:    iload_3 
L96:    bipush 92 
L98:    if_icmpne L113 
L101:   iload_2 
L102:   bipush 92 
L104:   if_icmpne L113 
L107:   bipush 32 
L109:   istore_2 
L110:   goto L338 
L113:   iload_1 
L114:   ifeq L135 
L117:   iload_3 
L118:   bipush 34 
L120:   if_icmpne L285 
L123:   iload_2 
L124:   bipush 92 
L126:   if_icmpeq L285 
L129:   goto L350 
L132:   goto L285 
L135:   iload_3 
L136:   bipush 32 
L138:   if_icmpne L152 
L141:   iload 4 
L143:   ifne L350 
L146:   goto L338 
L149:   goto L350 
L152:   iload_3 
L153:   bipush 59 
L155:   if_icmpeq L176 
L158:   iload_3 
L159:   bipush 44 
L161:   if_icmpeq L176 
L164:   iload_3 
L165:   bipush 123 
L167:   if_icmpeq L176 
L170:   iload_3 
L171:   bipush 125 
L173:   if_icmpne L201 
L176:   iload 4 
L178:   ifne L188 
L181:   aload_0 
L182:   iload_3 
L183:   putfield [28] 
L186:   iconst_0 
L187:   areturn 
L188:   aload_0 
L189:   dup 
L190:   getfield [11] 
L193:   iconst_1 
L194:   isub 
L195:   putfield [24] 
L198:   goto L350 
L201:   iload_3 
L202:   bipush 34 
L204:   if_icmpne L236 
L207:   iload_2 
L208:   bipush 92 
L210:   if_icmpeq L236 
L213:   iload 4 
L215:   ifle L231 
L218:   aload_0 
L219:   dup 
L220:   getfield [11] 
L223:   iconst_1 
L224:   isub 
L225:   putfield [24] 
L228:   goto L350 
L231:   iconst_1 
L232:   istore_1 
L233:   goto L338 
L236:   iload_3 
L237:   bipush 47 
L239:   if_icmpne L261 
L242:   iload_2 
L243:   bipush 47 
L245:   if_icmpne L261 
L248:   iconst_0 
L249:   istore 4 
L251:   aload_0 
L252:   invokespecial [19] 
L255:   bipush 32 
L257:   istore_2 
L258:   goto L338 
L261:   iload_3 
L262:   bipush 42 
L264:   if_icmpne L285 
L267:   iload_2 
L268:   bipush 47 
L270:   if_icmpne L285 
L273:   iinc 4 -1 
L276:   iload_3 
L277:   istore_2 
L278:   aload_0 
L279:   invokespecial [20] 
L282:   goto L338 
L285:   iload 4 
L287:   aload_0 
L288:   getfield [13] 
L291:   arraylength 
L292:   if_icmpne L325 
L295:   aload_0 
L296:   getfield [13] 
L299:   arraylength 
L300:   iconst_2 
L301:   imul 
L302:   newarray char 
L304:   astore 5 
L306:   aload_0 
L307:   getfield [13] 
L310:   iconst_0 
L311:   aload 5 
L313:   iconst_0 
L314:   iload 4 
L316:   invokestatic [7] 
L319:   aload_0 
L320:   aload 5 
L322:   putfield [26] 
L325:   aload_0 
L326:   getfield [13] 
L329:   iload 4 
L331:   iinc 4 1 
L334:   iload_3 
L335:   castore 
L336:   iload_3 
L337:   istore_2 
L338:   goto L8 
L341:   goto L350 
L344:   pop 
L345:   aload_0 
L346:   iconst_1 
L347:   putfield [25] 
L350:   aload_0 
L351:   new [29] 
L354:   dup 
L355:   aload_0 
L356:   getfield [13] 
L359:   iconst_0 
L360:   iload 4 
L362:   invokespecial [21] 
L365:   putfield [30] 
L368:   iload_1 
L369:   ifeq L374 
L372:   iconst_2 
L373:   areturn 
L374:   iconst_1 
L375:   areturn 
L376:   
    .end code 
.end method 

.method [187] : [188] 
    .attribute [176] .code stack 2 locals 0 
L0:     goto L21 
L3:     aload_0 
L4:     invokevirtual [17] 
L7:     ifne L21 
L10:    aload_0 
L11:    getfield [16] 
L14:    iload_1 
L15:    if_icmpne L21 
L18:    goto L28 
L21:    aload_0 
L22:    getfield [12] 
L25:    ifeq L3 
L28:    return 
L29:    nop 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [31] 
.const [3] = Class [32] 
.const [4] = Class [33] 
.const [5] = Class [34] 
.const [6] = Class [35] 
.const [7] = Method [36] [37] 
.const [8] = Class [38] 
.const [9] = Field [39] [40] 
.const [10] = Field [41] [42] 
.const [11] = Field [43] [44] 
.const [12] = Field [45] [46] 
.const [13] = Field [47] [48] 
.const [14] = Field [49] [50] 
.const [15] = Method [51] [52] 
.const [16] = Field [53] [54] 
.const [17] = Method [55] [56] 
.const [18] = Method [57] [58] 
.const [19] = Method [59] [60] 
.const [20] = Method [61] [62] 
.const [21] = Method [63] [64] 
.const [22] = Field [65] [66] 
.const [23] = Field [67] [68] 
.const [24] = Field [69] [70] 
.const [25] = Field [71] [72] 
.const [26] = Field [73] [74] 
.const [27] = Field [75] [76] 
.const [28] = Field [77] [78] 
.const [29] = Class [79] 
.const [30] = Field [80] [81] 
.const [31] = Utf8 com/ibm/oti/util/DefaultPolicy$PolicyTokenizer 
.const [32] = Utf8 java/lang/Object 
.const [33] = Utf8 java/io/IOException 
.const [34] = Utf8 java/io/InputStreamReader 
.const [35] = Utf8 java/lang/System 
.const [36] = Class [82] 
.const [37] = NameAndType [83] [84] 
.const [38] = Utf8 java/lang/String 
.const [39] = Class [85] 
.const [40] = NameAndType [86] [87] 
.const [41] = Class [88] 
.const [42] = NameAndType [89] [90] 
.const [43] = Class [91] 
.const [44] = NameAndType [92] [93] 
.const [45] = Class [94] 
.const [46] = NameAndType [95] [96] 
.const [47] = Class [97] 
.const [48] = NameAndType [98] [99] 
.const [49] = Class [100] 
.const [50] = NameAndType [101] [102] 
.const [51] = Class [103] 
.const [52] = NameAndType [104] [105] 
.const [53] = Class [106] 
.const [54] = NameAndType [107] [108] 
.const [55] = Class [109] 
.const [56] = NameAndType [110] [111] 
.const [57] = Class [112] 
.const [58] = NameAndType [113] [114] 
.const [59] = Class [115] 
.const [60] = NameAndType [116] [117] 
.const [61] = Class [118] 
.const [62] = NameAndType [119] [120] 
.const [63] = Class [121] 
.const [64] = NameAndType [122] [123] 
.const [65] = Class [124] 
.const [66] = NameAndType [125] [126] 
.const [67] = Class [127] 
.const [68] = NameAndType [128] [129] 
.const [69] = Class [130] 
.const [70] = NameAndType [131] [132] 
.const [71] = Class [133] 
.const [72] = NameAndType [134] [135] 
.const [73] = Class [136] 
.const [74] = NameAndType [137] [138] 
.const [75] = Class [139] 
.const [76] = NameAndType [140] [141] 
.const [77] = Class [142] 
.const [78] = NameAndType [143] [144] 
.const [79] = Utf8 java/lang/String 
.const [80] = Class [145] 
.const [81] = NameAndType [146] [147] 
.const [82] = Utf8 java/lang/System 
.const [83] = Utf8 arraycopy 
.const [84] = Utf8 (Ljava/lang/Object;ILjava/lang/Object;II)V 
.const [85] = Utf8 com/ibm/oti/util/DefaultPolicy$PolicyTokenizer 
.const [86] = Utf8 inbuf 
.const [87] = Utf8 [C 
.const [88] = Utf8 com/ibm/oti/util/DefaultPolicy$PolicyTokenizer 
.const [89] = Utf8 inbufCount 
.const [90] = Utf8 I 
.const [91] = Utf8 com/ibm/oti/util/DefaultPolicy$PolicyTokenizer 
.const [92] = Utf8 inbufPos 
.const [93] = Utf8 I 
.const [94] = Utf8 com/ibm/oti/util/DefaultPolicy$PolicyTokenizer 
.const [95] = Utf8 endOfFile 
.const [96] = Utf8 Z 
.const [97] = Utf8 com/ibm/oti/util/DefaultPolicy$PolicyTokenizer 
.const [98] = Utf8 buf 
.const [99] = Utf8 [C 
.const [100] = Utf8 com/ibm/oti/util/DefaultPolicy$PolicyTokenizer 
.const [101] = Utf8 policyData 
.const [102] = Utf8 Ljava/io/InputStreamReader; 
.const [103] = Utf8 java/io/InputStreamReader 
.const [104] = Utf8 read 
.const [105] = Utf8 ([C)I 
.const [106] = Utf8 com/ibm/oti/util/DefaultPolicy$PolicyTokenizer 
.const [107] = Utf8 cval 
.const [108] = Utf8 C 
.const [109] = Utf8 com/ibm/oti/util/DefaultPolicy$PolicyTokenizer 
.const [110] = Utf8 nextToken 
.const [111] = Utf8 ()I 
.const [112] = Utf8 java/lang/Object 
.const [113] = Utf8 <init> 
.const [114] = Utf8 ()V 
.const [115] = Utf8 com/ibm/oti/util/DefaultPolicy$PolicyTokenizer 
.const [116] = Utf8 ignoreToEOL 
.const [117] = Utf8 ()V 
.const [118] = Utf8 com/ibm/oti/util/DefaultPolicy$PolicyTokenizer 
.const [119] = Utf8 findEndOfComment 
.const [120] = Utf8 ()V 
.const [121] = Utf8 java/lang/String 
.const [122] = Utf8 <init> 
.const [123] = Utf8 ([CII)V 
.const [124] = Utf8 com/ibm/oti/util/DefaultPolicy$PolicyTokenizer 
.const [125] = Utf8 inbuf 
.const [126] = Utf8 [C 
.const [127] = Utf8 com/ibm/oti/util/DefaultPolicy$PolicyTokenizer 
.const [128] = Utf8 inbufCount 
.const [129] = Utf8 I 
.const [130] = Utf8 com/ibm/oti/util/DefaultPolicy$PolicyTokenizer 
.const [131] = Utf8 inbufPos 
.const [132] = Utf8 I 
.const [133] = Utf8 com/ibm/oti/util/DefaultPolicy$PolicyTokenizer 
.const [134] = Utf8 endOfFile 
.const [135] = Utf8 Z 
.const [136] = Utf8 com/ibm/oti/util/DefaultPolicy$PolicyTokenizer 
.const [137] = Utf8 buf 
.const [138] = Utf8 [C 
.const [139] = Utf8 com/ibm/oti/util/DefaultPolicy$PolicyTokenizer 
.const [140] = Utf8 policyData 
.const [141] = Utf8 Ljava/io/InputStreamReader; 
.const [142] = Utf8 com/ibm/oti/util/DefaultPolicy$PolicyTokenizer 
.const [143] = Utf8 cval 
.const [144] = Utf8 C 
.const [145] = Utf8 com/ibm/oti/util/DefaultPolicy$PolicyTokenizer 
.const [146] = Utf8 sval 
.const [147] = Utf8 Ljava/lang/String; 
.const [148] = Utf8 com/ibm/oti/util/DefaultPolicy$PolicyTokenizer 
.const [149] = Class [148] 
.const [150] = Utf8 java/lang/Object 
.const [151] = Class [150] 
.const [152] = Utf8 EOL 
.const [153] = Utf8 I 
.const [154] = Utf8 TOK_CHAR 
.const [155] = Utf8 I 
.const [156] = Utf8 TOK_STRING 
.const [157] = Utf8 I 
.const [158] = Utf8 TOK_QUOTEDSTRING 
.const [159] = Utf8 I 
.const [160] = Utf8 policyData 
.const [161] = Utf8 Ljava/io/InputStreamReader; 
.const [162] = Utf8 inbuf 
.const [163] = Utf8 [C 
.const [164] = Utf8 inbufCount 
.const [165] = Utf8 I 
.const [166] = Utf8 inbufPos 
.const [167] = Utf8 I 
.const [168] = Utf8 endOfFile 
.const [169] = Utf8 Z 
.const [170] = Utf8 sval 
.const [171] = Utf8 Ljava/lang/String; 
.const [172] = Utf8 cval 
.const [173] = Utf8 C 
.const [174] = Utf8 buf 
.const [175] = Utf8 [C 
.const [176] = Utf8 Code 
.const [177] = Utf8 <init> 
.const [178] = Utf8 (Ljava/io/InputStreamReader;)V 
.const [179] = Utf8 ignoreToEOL 
.const [180] = Utf8 ()V 
.const [181] = Utf8 findEndOfComment 
.const [182] = Utf8 ()V 
.const [183] = Utf8 isAtEOF 
.const [184] = Utf8 ()Z 
.const [185] = Utf8 nextToken 
.const [186] = Utf8 ()I 
.const [187] = Utf8 skipTokens 
.const [188] = Utf8 (C)V 
.end class 
