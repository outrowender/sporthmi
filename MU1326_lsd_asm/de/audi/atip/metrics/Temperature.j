.version 50 0 
.class public super [252] 
.super [254] 
.field public static final [255] [256] 
.field public static final [257] [258] 
.field public static final [259] [260] 
.field private static final [261] [262] 
.field private static final [263] [264] 
.field private static final [265] [266] 
.field private static final [267] [268] 
.field private static [269] [270] 
.field public static final [271] [272] 
.field public static final [273] [274] 
.field public static final [275] [276] 
.field public static final [277] [278] 
.field private static final [279] [280] 
.field private static final [281] [282] 
.field private static [283] [284] 

.method public [286] : [287] 
    .attribute [285] .code stack 3 locals 0 
L0:     aload_0 
L1:     fload_1 
L2:     iload_2 
L3:     invokespecial [43] 
L6:     aload_0 
L7:     invokespecial [44] 
L10:    return 
L11:    nop 
L12:    
    .end code 
.end method 

.method protected final [288] : [289] 
    .attribute [285] .code stack 2 locals 0 
L0:     fload_1 
L1:     ldc [2] 
L3:     fadd 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method protected final [290] : [291] 
    .attribute [285] .code stack 2 locals 0 
L0:     fload_1 
L1:     ldc [2] 
L3:     fsub 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method protected final [292] : [293] 
    .attribute [285] .code stack 4 locals 0 
L0:     fload_1 
L1:     f2d 
L2:     ldc2_w [57] 
L5:     dmul 
L6:     d2f 
L7:     ldc [3] 
L9:     fadd 
L10:    areturn 
L11:    nop 
L12:    
    .end code 
.end method 

.method protected final [294] : [295] 
    .attribute [285] .code stack 2 locals 0 
L0:     fload_1 
L1:     ldc [3] 
L3:     fsub 
L4:     ldc [4] 
L6:     fdiv 
L7:     areturn 
L8:     
    .end code 
.end method 

.method protected final [296] : [297] 
    .attribute [285] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [28] 
L4:     lookupswitch 
            2 : L32 
            3 : L47 
            default : L62 

L32:    aload_0 
L33:    aload_0 
L34:    aload_0 
L35:    getfield [29] 
L38:    invokespecial [45] 
L41:    putfield [53] 
L44:    goto L62 
L47:    aload_0 
L48:    aload_0 
L49:    aload_0 
L50:    getfield [29] 
L53:    invokespecial [46] 
L56:    putfield [53] 
L59:    goto L62 
L62:    return 
L63:    nop 
L64:    
    .end code 
.end method 

.method public static [298] : [299] 
    .attribute [285] .code stack 2 locals 0 
L0:     iload_0 
L1:     iconst_1 
L2:     if_icmpeq L15 
L5:     iload_0 
L6:     iconst_2 
L7:     if_icmpeq L15 
L10:    iload_0 
L11:    iconst_3 
L12:    if_icmpne L19 
L15:    iconst_1 
L16:    goto L20 
L19:    iconst_0 
L20:    areturn 
L21:    nop 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method protected static [300] : [301] 
    .attribute [285] .code stack 2 locals 0 
L0:     iload_0 
L1:     bipush 31 
L3:     if_icmpeq L24 
L6:     iload_0 
L7:     bipush 33 
L9:     if_icmpeq L24 
L12:    iload_0 
L13:    bipush 34 
L15:    if_icmpeq L24 
L18:    iload_0 
L19:    bipush 32 
L21:    if_icmpne L28 
L24:    iconst_1 
L25:    goto L29 
L28:    iconst_0 
L29:    areturn 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method public static [302] : [303] 
    .attribute [285] .code stack 2 locals 0 
L0:     iload_0 
L1:     invokestatic [5] 
L4:     ifne L15 
L7:     new [54] 
L10:    dup 
L11:    invokespecial [47] 
L14:    athrow 
L15:    iload_0 
L16:    putstatic [48] 
L19:    return 
L20:    
    .end code 
.end method 

.method public static [304] : [305] 
    .attribute [285] .code stack 1 locals 0 
L0:     getstatic [7] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method public [306] : [307] 
    .attribute [285] .code stack 2 locals 0 
L0:     aload_0 
L1:     fload_1 
L2:     putfield [53] 
L5:     aload_0 
L6:     invokespecial [44] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [308] : [309] 
    .attribute [285] .code stack 3 locals 0 
L0:     iload_2 
L1:     lookupswitch 
            2 : L28 
            3 : L40 
            default : L52 

L28:    aload_0 
L29:    aload_0 
L30:    fload_1 
L31:    invokespecial [45] 
L34:    putfield [53] 
L37:    goto L52 
L40:    aload_0 
L41:    aload_0 
L42:    fload_1 
L43:    invokespecial [46] 
L46:    putfield [53] 
L49:    goto L52 
L52:    return 
L53:    nop 
L54:    nop 
L55:    nop 
L56:    
    .end code 
.end method 

.method public [310] : [311] 
    .attribute [285] .code stack 2 locals 0 
L0:     aload_0 
L1:     getstatic [7] 
L4:     invokevirtual [30] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public [312] : [313] 
    .attribute [285] .code stack 2 locals 0 
L0:     iload_1 
L1:     invokestatic [5] 
L4:     ifne L15 
L7:     new [54] 
L10:    dup 
L11:    invokespecial [47] 
L14:    athrow 
L15:    aload_0 
L16:    iload_1 
L17:    invokevirtual [30] 
L20:    areturn 
L21:    nop 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method protected [314] : [315] 
    .attribute [285] .code stack 2 locals 0 
L0:     iload_1 
L1:     lookupswitch 
            2 : L28 
            3 : L37 
            default : L46 

L28:    aload_0 
L29:    aload_0 
L30:    getfield [29] 
L33:    invokespecial [49] 
L36:    areturn 
L37:    aload_0 
L38:    aload_0 
L39:    getfield [29] 
L42:    invokespecial [50] 
L45:    areturn 
L46:    aload_0 
L47:    getfield [29] 
L50:    areturn 
L51:    nop 
L52:    
    .end code 
.end method 

.method public [316] : [317] 
    .attribute [285] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [31] 
L4:     ifeq L16 
L7:     aload_0 
L8:     aload_0 
L9:     getfield [28] 
L12:    invokevirtual [32] 
L15:    areturn 
L16:    aload_0 
L17:    getstatic [7] 
L20:    invokevirtual [32] 
L23:    areturn 
L24:    
    .end code 
.end method 

.method public [318] : [319] 
    .attribute [285] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [31] 
L4:     ifeq L17 
L7:     aload_0 
L8:     aload_0 
L9:     getfield [28] 
L12:    iload_1 
L13:    invokevirtual [33] 
L16:    areturn 
L17:    aload_0 
L18:    getstatic [7] 
L21:    iload_1 
L22:    invokevirtual [33] 
L25:    areturn 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [320] : [321] 
    .attribute [285] .code stack 3 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     bipush 31 
L4:     invokevirtual [33] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public [322] : [323] 
    .attribute [285] .code stack 4 locals 7 
L0:     iload_1 
L1:     invokestatic [5] 
L4:     ifne L15 
L7:     new [54] 
L10:    dup 
L11:    invokespecial [47] 
L14:    athrow 
L15:    iload_2 
L16:    invokestatic [8] 
L19:    ifne L30 
L22:    new [54] 
L25:    dup 
L26:    invokespecial [47] 
L29:    athrow 
L30:    new [55] 
L33:    dup 
L34:    invokespecial [51] 
L37:    astore_3 
L38:    iconst_0 
L39:    istore 5 
L41:    iconst_1 
L42:    istore 7 
L44:    iload_1 
L45:    tableswitch 1 
            L141 
            L97 
            L72 
            default : L141 

L72:    aload_0 
L73:    aload_0 
L74:    getfield [29] 
L77:    invokespecial [50] 
L80:    fstore 6 
L82:    fload 6 
L84:    f2i 
L85:    istore 4 
L87:    bipush 34 
L89:    istore 8 
L91:    iconst_m1 
L92:    istore 9 
L94:    goto L220 
L97:    aload_0 
L98:    aload_0 
L99:    getfield [29] 
L102:   invokespecial [49] 
L105:   fstore 6 
L107:   fload 6 
L109:   fconst_0 
L110:   fcmpg 
L111:   ifge L124 
L114:   ldc [10] 
L116:   fload 6 
L118:   fmul 
L119:   fstore 6 
L121:   iconst_m1 
L122:   istore 7 
L124:   fload 6 
L126:   invokestatic [11] 
L129:   istore 4 
L131:   bipush 33 
L133:   istore 8 
L135:   iconst_m1 
L136:   istore 9 
L138:   goto L220 
L141:   aload_0 
L142:   getfield [29] 
L145:   fconst_0 
L146:   fcmpl 
L147:   iflt L159 
L150:   aload_0 
L151:   getfield [29] 
L154:   fstore 6 
L156:   goto L171 
L159:   ldc [10] 
L161:   aload_0 
L162:   getfield [29] 
L165:   fmul 
L166:   fstore 6 
L168:   iconst_m1 
L169:   istore 7 
L171:   fload 6 
L173:   f2i 
L174:   istore 4 
L176:   fload 6 
L178:   ldc [12] 
L180:   fmul 
L181:   f2d 
L182:   ldc2_w [59] 
L185:   dadd 
L186:   d2i 
L187:   iload 4 
L189:   bipush 10 
L191:   imul 
L192:   isub 
L193:   istore 5 
L195:   iload 4 
L197:   iload 5 
L199:   bipush 10 
L201:   idiv 
L202:   iadd 
L203:   istore 4 
L205:   iload 5 
L207:   bipush 10 
L209:   irem 
L210:   istore 5 
L212:   bipush 35 
L214:   istore 8 
L216:   bipush 36 
L218:   istore 9 
L220:   iload_2 
L221:   bipush 32 
L223:   if_icmpne L247 
L226:   aload_3 
L227:   iload 7 
L229:   iload 4 
L231:   imul 
L232:   invokevirtual [34] 
L235:   iload 8 
L237:   invokestatic [13] 
L240:   invokevirtual [35] 
L243:   pop 
L244:   goto L344 
L247:   iload_2 
L248:   bipush 34 
L250:   if_icmpne L269 
L253:   aload_3 
L254:   iload 8 
L256:   invokestatic [13] 
L259:   invokevirtual [36] 
L262:   invokevirtual [35] 
L265:   pop 
L266:   goto L344 
L269:   iload 4 
L271:   ifne L297 
L274:   iload 7 
L276:   iconst_m1 
L277:   if_icmpne L297 
L280:   aload_3 
L281:   ldc [14] 
L283:   invokevirtual [35] 
L286:   pop 
L287:   aload_3 
L288:   iload 4 
L290:   invokevirtual [34] 
L293:   pop 
L294:   goto L307 
L297:   aload_3 
L298:   iload 7 
L300:   iload 4 
L302:   imul 
L303:   invokevirtual [34] 
L306:   pop 
L307:   iload 9 
L309:   iconst_m1 
L310:   if_icmpeq L328 
L313:   aload_3 
L314:   bipush 36 
L316:   invokestatic [13] 
L319:   invokevirtual [35] 
L322:   iload 5 
L324:   invokevirtual [34] 
L327:   pop 
L328:   iload_2 
L329:   bipush 31 
L331:   if_icmpne L344 
L334:   aload_3 
L335:   iload 8 
L337:   invokestatic [13] 
L340:   invokevirtual [35] 
L343:   pop 
L344:   aload_0 
L345:   getfield [37] 
L348:   aload_3 
L349:   invokestatic [15] 
L352:   ifne L363 
L355:   aload_0 
L356:   aload_3 
L357:   invokevirtual [38] 
L360:   putfield [56] 
L363:   aload_0 
L364:   getfield [37] 
L367:   areturn 
L368:   
    .end code 
.end method 

.method protected static [324] : [325] 
    .attribute [285] .code stack 1 locals 1 
L0:     iload_0 
L1:     invokestatic [16] 
L4:     astore_1 
L5:     aload_1 
L6:     ifnonnull L67 
L9:     iload_0 
L10:    tableswitch 33 
            L52 
            L46 
            L40 
            L58 
            default : L64 

L40:    ldc [17] 
L42:    astore_1 
L43:    goto L67 
L46:    ldc [18] 
L48:    astore_1 
L49:    goto L67 
L52:    ldc [19] 
L54:    astore_1 
L55:    goto L67 
L58:    ldc [20] 
L60:    astore_1 
L61:    goto L67 
L64:    ldc [21] 
L66:    astore_1 
L67:    aload_1 
L68:    areturn 
L69:    nop 
L70:    nop 
L71:    nop 
L72:    
    .end code 
.end method 

.method public [326] : [327] 
    .attribute [285] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_0 
L2:     getfield [31] 
L5:     ifeq L15 
L8:     aload_0 
L9:     getfield [28] 
L12:    goto L18 
L15:    getstatic [7] 
L18:    invokevirtual [39] 
L21:    areturn 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [328] : [329] 
    .attribute [285] .code stack 3 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     bipush 34 
L4:     invokevirtual [33] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public [330] : [331] 
    .attribute [285] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_0 
L2:     getfield [31] 
L5:     ifeq L15 
L8:     aload_0 
L9:     getfield [28] 
L12:    goto L18 
L15:    getstatic [7] 
L18:    invokevirtual [40] 
L21:    areturn 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [332] : [333] 
    .attribute [285] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokevirtual [41] 
L4:     ifeq L17 
L7:     aload_0 
L8:     iload_1 
L9:     bipush 33 
L11:    invokevirtual [33] 
L14:    goto L21 
L17:    aload_0 
L18:    invokevirtual [42] 
L21:    areturn 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [334] : [335] 
    .attribute [285] .code stack 1 locals 0 
L0:     getstatic [22] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method static [336] : [337] 
    .attribute [285] .code stack 1 locals 0 
L0:     ldc [23] 
L2:     putstatic [52] 
L5:     iconst_1 
L6:     putstatic [48] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int 865306691 
.const [3] = Int 66 
.const [4] = Int 1718019647 
.const [5] = Method [61] [62] 
.const [6] = Class [63] 
.const [7] = Field [64] [65] 
.const [8] = Method [66] [67] 
.const [9] = Class [68] 
.const [10] = Int 32959 
.const [11] = Method [69] [70] 
.const [12] = Int 8257 
.const [13] = Method [71] [72] 
.const [14] = String [73] 
.const [15] = Method [74] [75] 
.const [16] = Method [76] [77] 
.const [17] = String [78] 
.const [18] = String [79] 
.const [19] = String [80] 
.const [20] = String [81] 
.const [21] = String [82] 
.const [22] = Field [83] [84] 
.const [23] = String [85] 
.const [24] = Class [86] 
.const [25] = Class [87] 
.const [26] = Class [88] 
.const [27] = Class [89] 
.const [28] = Field [90] [91] 
.const [29] = Field [92] [93] 
.const [30] = Method [94] [95] 
.const [31] = Field [96] [97] 
.const [32] = Method [98] [99] 
.const [33] = Method [100] [101] 
.const [34] = Method [102] [103] 
.const [35] = Method [104] [105] 
.const [36] = Method [106] [107] 
.const [37] = Field [108] [109] 
.const [38] = Method [110] [111] 
.const [39] = Method [112] [113] 
.const [40] = Method [114] [115] 
.const [41] = Method [116] [117] 
.const [42] = Method [118] [119] 
.const [43] = Method [120] [121] 
.const [44] = Method [122] [123] 
.const [45] = Method [124] [125] 
.const [46] = Method [126] [127] 
.const [47] = Method [128] [129] 
.const [48] = Field [130] [131] 
.const [49] = Method [132] [133] 
.const [50] = Method [134] [135] 
.const [51] = Method [136] [137] 
.const [52] = Field [138] [139] 
.const [53] = Field [140] [141] 
.const [54] = Class [142] 
.const [55] = Class [143] 
.const [56] = Field [144] [145] 
.const [57] = Double +0x1CCCCCCCCCCCCDp-52 
.const [59] = Double +0x10000000000000p-53 
.const [61] = Class [146] 
.const [62] = NameAndType [147] [148] 
.const [63] = Utf8 java/lang/IllegalArgumentException 
.const [64] = Class [149] 
.const [65] = NameAndType [150] [151] 
.const [66] = Class [152] 
.const [67] = NameAndType [153] [154] 
.const [68] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [69] = Class [155] 
.const [70] = NameAndType [156] [157] 
.const [71] = Class [158] 
.const [72] = NameAndType [159] [160] 
.const [73] = Utf8 '-' 
.const [74] = Class [161] 
.const [75] = NameAndType [162] [163] 
.const [76] = Class [164] 
.const [77] = NameAndType [165] [166] 
.const [78] = Utf8 ' \xb0C' 
.const [79] = Utf8 ' K' 
.const [80] = Utf8 ' \xb0F' 
.const [81] = Utf8 ',' 
.const [82] = Utf8 '' 
.const [83] = Class [167] 
.const [84] = NameAndType [168] [169] 
.const [85] = Utf8 '---' 
.const [86] = Utf8 de/audi/atip/metrics/Temperature 
.const [87] = Utf8 de/audi/atip/metrics/AbstractMetrics 
.const [88] = Utf8 java/lang/Math 
.const [89] = Utf8 java/lang/String 
.const [90] = Class [170] 
.const [91] = NameAndType [171] [172] 
.const [92] = Class [173] 
.const [93] = NameAndType [174] [175] 
.const [94] = Class [176] 
.const [95] = NameAndType [177] [178] 
.const [96] = Class [179] 
.const [97] = NameAndType [180] [181] 
.const [98] = Class [182] 
.const [99] = NameAndType [183] [184] 
.const [100] = Class [185] 
.const [101] = NameAndType [186] [187] 
.const [102] = Class [188] 
.const [103] = NameAndType [189] [190] 
.const [104] = Class [191] 
.const [105] = NameAndType [192] [193] 
.const [106] = Class [194] 
.const [107] = NameAndType [195] [196] 
.const [108] = Class [197] 
.const [109] = NameAndType [198] [199] 
.const [110] = Class [200] 
.const [111] = NameAndType [201] [202] 
.const [112] = Class [203] 
.const [113] = NameAndType [204] [205] 
.const [114] = Class [206] 
.const [115] = NameAndType [207] [208] 
.const [116] = Class [209] 
.const [117] = NameAndType [210] [211] 
.const [118] = Class [212] 
.const [119] = NameAndType [213] [214] 
.const [120] = Class [215] 
.const [121] = NameAndType [216] [217] 
.const [122] = Class [218] 
.const [123] = NameAndType [219] [220] 
.const [124] = Class [221] 
.const [125] = NameAndType [222] [223] 
.const [126] = Class [224] 
.const [127] = NameAndType [225] [226] 
.const [128] = Class [227] 
.const [129] = NameAndType [228] [229] 
.const [130] = Class [230] 
.const [131] = NameAndType [231] [232] 
.const [132] = Class [233] 
.const [133] = NameAndType [234] [235] 
.const [134] = Class [236] 
.const [135] = NameAndType [237] [238] 
.const [136] = Class [239] 
.const [137] = NameAndType [240] [241] 
.const [138] = Class [242] 
.const [139] = NameAndType [243] [244] 
.const [140] = Class [245] 
.const [141] = NameAndType [246] [247] 
.const [142] = Utf8 java/lang/IllegalArgumentException 
.const [143] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [144] = Class [248] 
.const [145] = NameAndType [249] [250] 
.const [146] = Utf8 de/audi/atip/metrics/Temperature 
.const [147] = Utf8 unitIsValid 
.const [148] = Utf8 (I)Z 
.const [149] = Utf8 de/audi/atip/metrics/Temperature 
.const [150] = Utf8 systemUnit 
.const [151] = Utf8 I 
.const [152] = Utf8 de/audi/atip/metrics/Temperature 
.const [153] = Utf8 modeIsValid 
.const [154] = Utf8 (I)Z 
.const [155] = Utf8 java/lang/Math 
.const [156] = Utf8 round 
.const [157] = Utf8 (F)I 
.const [158] = Utf8 de/audi/atip/metrics/Temperature 
.const [159] = Utf8 getText 
.const [160] = Utf8 (I)Ljava/lang/String; 
.const [161] = Utf8 de/audi/atip/metrics/Temperature 
.const [162] = Utf8 contentEquals 
.const [163] = Utf8 (Ljava/lang/String;Lde/esolutions/fw/util/commons/Buffer;)Z 
.const [164] = Utf8 de/audi/atip/metrics/AbstractMetrics 
.const [165] = Utf8 getText 
.const [166] = Utf8 (I)Ljava/lang/String; 
.const [167] = Utf8 de/audi/atip/metrics/Temperature 
.const [168] = Utf8 TEXT_INVALID 
.const [169] = Utf8 Ljava/lang/String; 
.const [170] = Utf8 de/audi/atip/metrics/Temperature 
.const [171] = Utf8 unit 
.const [172] = Utf8 I 
.const [173] = Utf8 de/audi/atip/metrics/Temperature 
.const [174] = Utf8 value 
.const [175] = Utf8 F 
.const [176] = Utf8 de/audi/atip/metrics/Temperature 
.const [177] = Utf8 getValueInUnit 
.const [178] = Utf8 (I)F 
.const [179] = Utf8 de/audi/atip/metrics/Temperature 
.const [180] = Utf8 useInstanceUnit 
.const [181] = Utf8 Z 
.const [182] = Utf8 de/audi/atip/metrics/Temperature 
.const [183] = Utf8 format 
.const [184] = Utf8 (I)Ljava/lang/String; 
.const [185] = Utf8 de/audi/atip/metrics/Temperature 
.const [186] = Utf8 format 
.const [187] = Utf8 (II)Ljava/lang/String; 
.const [188] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [189] = Utf8 append 
.const [190] = Utf8 (I)Lde/esolutions/fw/util/commons/Buffer; 
.const [191] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [192] = Utf8 append 
.const [193] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [194] = Utf8 java/lang/String 
.const [195] = Utf8 trim 
.const [196] = Utf8 ()Ljava/lang/String; 
.const [197] = Utf8 de/audi/atip/metrics/Temperature 
.const [198] = Utf8 lastFormat 
.const [199] = Utf8 Ljava/lang/String; 
.const [200] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [201] = Utf8 toString 
.const [202] = Utf8 ()Ljava/lang/String; 
.const [203] = Utf8 de/audi/atip/metrics/Temperature 
.const [204] = Utf8 getFormattedUnit 
.const [205] = Utf8 (I)Ljava/lang/String; 
.const [206] = Utf8 de/audi/atip/metrics/Temperature 
.const [207] = Utf8 getFormattedValue 
.const [208] = Utf8 (I)Ljava/lang/String; 
.const [209] = Utf8 de/audi/atip/metrics/Temperature 
.const [210] = Utf8 isMetricvalid 
.const [211] = Utf8 ()Z 
.const [212] = Utf8 de/audi/atip/metrics/Temperature 
.const [213] = Utf8 getInvalidText 
.const [214] = Utf8 ()Ljava/lang/String; 
.const [215] = Utf8 de/audi/atip/metrics/AbstractMetrics 
.const [216] = Utf8 <init> 
.const [217] = Utf8 (FI)V 
.const [218] = Utf8 de/audi/atip/metrics/Temperature 
.const [219] = Utf8 importValue 
.const [220] = Utf8 ()V 
.const [221] = Utf8 de/audi/atip/metrics/Temperature 
.const [222] = Utf8 fahrenheit2celsius 
.const [223] = Utf8 (F)F 
.const [224] = Utf8 de/audi/atip/metrics/Temperature 
.const [225] = Utf8 kelvin2celsius 
.const [226] = Utf8 (F)F 
.const [227] = Utf8 java/lang/IllegalArgumentException 
.const [228] = Utf8 <init> 
.const [229] = Utf8 ()V 
.const [230] = Utf8 de/audi/atip/metrics/Temperature 
.const [231] = Utf8 systemUnit 
.const [232] = Utf8 I 
.const [233] = Utf8 de/audi/atip/metrics/Temperature 
.const [234] = Utf8 celsius2fahrenheit 
.const [235] = Utf8 (F)F 
.const [236] = Utf8 de/audi/atip/metrics/Temperature 
.const [237] = Utf8 celsius2kelvin 
.const [238] = Utf8 (F)F 
.const [239] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [240] = Utf8 <init> 
.const [241] = Utf8 ()V 
.const [242] = Utf8 de/audi/atip/metrics/Temperature 
.const [243] = Utf8 TEXT_INVALID 
.const [244] = Utf8 Ljava/lang/String; 
.const [245] = Utf8 de/audi/atip/metrics/Temperature 
.const [246] = Utf8 value 
.const [247] = Utf8 F 
.const [248] = Utf8 de/audi/atip/metrics/Temperature 
.const [249] = Utf8 lastFormat 
.const [250] = Utf8 Ljava/lang/String; 
.const [251] = Utf8 de/audi/atip/metrics/Temperature 
.const [252] = Class [251] 
.const [253] = Utf8 de/audi/atip/metrics/AbstractMetrics 
.const [254] = Class [253] 
.const [255] = Utf8 CELSIUS 
.const [256] = Utf8 I 
.const [257] = Utf8 FAHRENHEIT 
.const [258] = Utf8 I 
.const [259] = Utf8 KELVIN 
.const [260] = Utf8 I 
.const [261] = Utf8 TEXT_FAHRENHEIT 
.const [262] = Utf8 Ljava/lang/String; 
.const [263] = Utf8 TEXT_KELVIN 
.const [264] = Utf8 Ljava/lang/String; 
.const [265] = Utf8 TEXT_CELSIUS 
.const [266] = Utf8 Ljava/lang/String; 
.const [267] = Utf8 TEXT_NEGATIVE 
.const [268] = Utf8 Ljava/lang/String; 
.const [269] = Utf8 TEXT_INVALID 
.const [270] = Utf8 Ljava/lang/String; 
.const [271] = Utf8 MODE_DEFAULT 
.const [272] = Utf8 I 
.const [273] = Utf8 MODE_RDK 
.const [274] = Utf8 I 
.const [275] = Utf8 MODE_VALUE_ONLY 
.const [276] = Utf8 I 
.const [277] = Utf8 MODE_UNIT_ONLY 
.const [278] = Utf8 I 
.const [279] = Utf8 NEGATIVE_SIGN 
.const [280] = Utf8 I 
.const [281] = Utf8 CELSIUS2KELVIN 
.const [282] = Utf8 F 
.const [283] = Utf8 systemUnit 
.const [284] = Utf8 I 
.const [285] = Utf8 Code 
.const [286] = Utf8 <init> 
.const [287] = Utf8 (FI)V 
.const [288] = Utf8 celsius2kelvin 
.const [289] = Utf8 (F)F 
.const [290] = Utf8 kelvin2celsius 
.const [291] = Utf8 (F)F 
.const [292] = Utf8 celsius2fahrenheit 
.const [293] = Utf8 (F)F 
.const [294] = Utf8 fahrenheit2celsius 
.const [295] = Utf8 (F)F 
.const [296] = Utf8 importValue 
.const [297] = Utf8 ()V 
.const [298] = Utf8 unitIsValid 
.const [299] = Utf8 (I)Z 
.const [300] = Utf8 modeIsValid 
.const [301] = Utf8 (I)Z 
.const [302] = Utf8 setSystemUnit 
.const [303] = Utf8 (I)V 
.const [304] = Utf8 getSystemUnit 
.const [305] = Utf8 ()I 
.const [306] = Utf8 setValue 
.const [307] = Utf8 (F)V 
.const [308] = Utf8 setValue 
.const [309] = Utf8 (FI)V 
.const [310] = Utf8 getValue 
.const [311] = Utf8 ()F 
.const [312] = Utf8 getValue 
.const [313] = Utf8 (I)F 
.const [314] = Utf8 getValueInUnit 
.const [315] = Utf8 (I)F 
.const [316] = Utf8 format 
.const [317] = Utf8 ()Ljava/lang/String; 
.const [318] = Utf8 formatWithMetricsMode 
.const [319] = Utf8 (I)Ljava/lang/String; 
.const [320] = Utf8 format 
.const [321] = Utf8 (I)Ljava/lang/String; 
.const [322] = Utf8 format 
.const [323] = Utf8 (II)Ljava/lang/String; 
.const [324] = Utf8 getText 
.const [325] = Utf8 (I)Ljava/lang/String; 
.const [326] = Utf8 getFormattedMetricUnit 
.const [327] = Utf8 ()Ljava/lang/String; 
.const [328] = Utf8 getFormattedUnit 
.const [329] = Utf8 (I)Ljava/lang/String; 
.const [330] = Utf8 getFormattedValue 
.const [331] = Utf8 ()Ljava/lang/String; 
.const [332] = Utf8 getFormattedValue 
.const [333] = Utf8 (I)Ljava/lang/String; 
.const [334] = Utf8 getInvalidText 
.const [335] = Utf8 ()Ljava/lang/String; 
.const [336] = Utf8 <clinit> 
.const [337] = Utf8 ()V 
.end class 
