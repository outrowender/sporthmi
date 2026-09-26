.version 50 0 
.class public super [280] 
.super [282] 
.field private static final [283] [284] 
.field private static final [285] [286] 
.field private static final [287] [288] 
.field private static [289] [290] 
.field public static final [291] [292] 
.field public static final [293] [294] 
.field public static final [295] [296] 
.field public static final [297] [298] 
.field public static final [299] [300] 
.field private static final [301] [302] 
.field public static final [303] [304] 
.field public static final [305] [306] 
.field private [307] [308] 
.field private [309] [310] 

.method public [312] : [313] 
    .attribute [311] .code stack 3 locals 0 
L0:     aload_0 
L1:     fload_1 
L2:     iload_2 
L3:     invokespecial [48] 
L6:     aload_0 
L7:     invokespecial [49] 
L10:    aload_0 
L11:    iconst_0 
L12:    putfield [56] 
L15:    aload_0 
L16:    iconst_2 
L17:    putfield [57] 
L20:    return 
L21:    nop 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method protected final [314] : [315] 
    .attribute [311] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [31] 
L4:     lookupswitch 
            2 : L24 
            default : L39 

L24:    aload_0 
L25:    aload_0 
L26:    aload_0 
L27:    getfield [32] 
L30:    invokespecial [50] 
L33:    putfield [58] 
L36:    goto L39 
L39:    return 
L40:    
    .end code 
.end method 

.method protected final [316] : [317] 
    .attribute [311] .code stack 2 locals 0 
L0:     fload_1 
L1:     ldc [2] 
L3:     fmul 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method protected final [318] : [319] 
    .attribute [311] .code stack 2 locals 0 
L0:     fload_1 
L1:     ldc [2] 
L3:     fdiv 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [320] : [321] 
    .attribute [311] .code stack 2 locals 0 
L0:     iload_0 
L1:     iconst_1 
L2:     if_icmpeq L10 
L5:     iload_0 
L6:     iconst_2 
L7:     if_icmpne L14 
L10:    iconst_1 
L11:    goto L15 
L14:    iconst_0 
L15:    areturn 
L16:    
    .end code 
.end method 

.method public static [322] : [323] 
    .attribute [311] .code stack 2 locals 0 
L0:     iload_0 
L1:     iconst_1 
L2:     if_icmpeq L15 
L5:     iload_0 
L6:     iconst_3 
L7:     if_icmpeq L15 
L10:    iload_0 
L11:    iconst_2 
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

.method public [324] : [325] 
    .attribute [311] .code stack 2 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     putfield [56] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [326] : [327] 
    .attribute [311] .code stack 2 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     putfield [57] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [328] : [329] 
    .attribute [311] .code stack 2 locals 0 
L0:     aload_0 
L1:     fload_1 
L2:     putfield [58] 
L5:     aload_0 
L6:     invokespecial [49] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public interface [330] : [331] 
    .attribute [311] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [32] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [332] : [333] 
    .attribute [311] .code stack 2 locals 0 
L0:     iload_1 
L1:     lookupswitch 
            1 : L37 
            2 : L28 
            default : L37 

L28:    aload_0 
L29:    aload_0 
L30:    getfield [32] 
L33:    invokespecial [51] 
L36:    areturn 
L37:    aload_0 
L38:    getfield [32] 
L41:    areturn 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 

.method public [334] : [335] 
    .attribute [311] .code stack 4 locals 9 
L0:     iload_2 
L1:     invokestatic [3] 
L4:     ifeq L14 
L7:     iload_1 
L8:     invokestatic [4] 
L11:    ifne L50 
L14:    new [59] 
L17:    dup 
L18:    new [60] 
L21:    dup 
L22:    invokespecial [52] 
L25:    ldc [7] 
L27:    invokevirtual [33] 
L30:    iload_2 
L31:    invokevirtual [34] 
L34:    ldc [8] 
L36:    invokevirtual [33] 
L39:    iload_1 
L40:    invokevirtual [34] 
L43:    invokevirtual [35] 
L46:    invokespecial [53] 
L49:    athrow 
L50:    new [61] 
L53:    dup 
L54:    invokespecial [54] 
L57:    astore_3 
L58:    iload_2 
L59:    iconst_1 
L60:    if_icmpeq L68 
L63:    iload_2 
L64:    iconst_2 
L65:    if_icmpne L389 
L68:    aload_0 
L69:    invokevirtual [36] 
L72:    ifeq L380 
L75:    aload_0 
L76:    iload_1 
L77:    invokevirtual [37] 
L80:    fstore 4 
L82:    fload 4 
L84:    f2i 
L85:    istore 5 
L87:    ldc2_w [62] 
L90:    aload_0 
L91:    getfield [30] 
L94:    i2d 
L95:    invokestatic [10] 
L98:    d2i 
L99:    istore 6 
L101:   fload 4 
L103:   iload 6 
L105:   i2f 
L106:   fmul 
L107:   invokestatic [11] 
L110:   f2d 
L111:   ldc2_w [64] 
L114:   dadd 
L115:   d2i 
L116:   iload 5 
L118:   iload 6 
L120:   imul 
L121:   invokestatic [12] 
L124:   isub 
L125:   istore 7 
L127:   iload 5 
L129:   iload 7 
L131:   iload 6 
L133:   idiv 
L134:   iadd 
L135:   istore 5 
L137:   iload 7 
L139:   iload 6 
L141:   irem 
L142:   istore 7 
L144:   iload 5 
L146:   ifne L168 
L149:   fload 4 
L151:   fconst_0 
L152:   fcmpg 
L153:   ifge L168 
L156:   iload 7 
L158:   ifeq L168 
L161:   aload_3 
L162:   ldc [13] 
L164:   invokevirtual [38] 
L167:   pop 
L168:   aload_3 
L169:   iload 5 
L171:   invokevirtual [39] 
L174:   pop 
L175:   new [61] 
L178:   dup 
L179:   invokespecial [54] 
L182:   astore 8 
L184:   aload_0 
L185:   getfield [29] 
L188:   ifne L278 
L191:   fload 4 
L193:   iload 6 
L195:   i2f 
L196:   fmul 
L197:   invokestatic [11] 
L200:   ldc [14] 
L202:   fadd 
L203:   iload 5 
L205:   iload 6 
L207:   imul 
L208:   invokestatic [12] 
L211:   i2f 
L212:   fsub 
L213:   iload 6 
L215:   i2f 
L216:   fdiv 
L217:   fstore 9 
L219:   fload 9 
L221:   ldc [15] 
L223:   fmul 
L224:   f2i 
L225:   istore 10 
L227:   aload_0 
L228:   getfield [30] 
L231:   istore 11 
L233:   iload 11 
L235:   ifle L275 
L238:   aload 8 
L240:   iload 10 
L242:   invokevirtual [39] 
L245:   pop 
L246:   fload 9 
L248:   ldc [15] 
L250:   fmul 
L251:   fload 9 
L253:   ldc [15] 
L255:   fmul 
L256:   f2i 
L257:   i2f 
L258:   fsub 
L259:   fstore 9 
L261:   fload 9 
L263:   ldc [15] 
L265:   fmul 
L266:   f2i 
L267:   istore 10 
L269:   iinc 11 -1 
L272:   goto L233 
L275:   goto L345 
L278:   aload_0 
L279:   getfield [29] 
L282:   iconst_1 
L283:   if_icmpne L338 
L286:   aload 8 
L288:   iload 7 
L290:   invokestatic [16] 
L293:   invokevirtual [38] 
L296:   pop 
L297:   aload 8 
L299:   invokevirtual [40] 
L302:   ifle L345 
L305:   aload 8 
L307:   aload 8 
L309:   invokevirtual [40] 
L312:   iconst_1 
L313:   isub 
L314:   invokevirtual [41] 
L317:   bipush 48 
L319:   if_icmpne L345 
L322:   aload 8 
L324:   aload 8 
L326:   invokevirtual [40] 
L329:   iconst_1 
L330:   isub 
L331:   invokevirtual [42] 
L334:   pop 
L335:   goto L297 
L338:   aload_3 
L339:   iload 7 
L341:   invokevirtual [39] 
L344:   pop 
L345:   aload_0 
L346:   getfield [30] 
L349:   ifle L377 
L352:   aload 8 
L354:   invokevirtual [40] 
L357:   ifle L377 
L360:   aload_3 
L361:   bipush 93 
L363:   invokestatic [17] 
L366:   invokevirtual [38] 
L369:   pop 
L370:   aload_3 
L371:   aload 8 
L373:   invokevirtual [43] 
L376:   pop 
L377:   goto L389 
L380:   aload_3 
L381:   aload_0 
L382:   invokevirtual [44] 
L385:   invokevirtual [38] 
L388:   pop 
L389:   iload_2 
L390:   iconst_1 
L391:   if_icmpeq L399 
L394:   iload_2 
L395:   iconst_3 
L396:   if_icmpne L435 
L399:   iload_1 
L400:   iconst_1 
L401:   if_icmpne L409 
L404:   bipush 91 
L406:   goto L411 
L409:   bipush 92 
L411:   invokestatic [17] 
L414:   astore 4 
L416:   iload_2 
L417:   iconst_3 
L418:   if_icmpne L428 
L421:   aload 4 
L423:   invokevirtual [45] 
L426:   astore 4 
L428:   aload_3 
L429:   aload 4 
L431:   invokevirtual [38] 
L434:   pop 
L435:   aload_3 
L436:   invokevirtual [46] 
L439:   areturn 
L440:   
    .end code 
.end method 

.method public [336] : [337] 
    .attribute [311] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_0 
L2:     getfield [31] 
L5:     iconst_1 
L6:     invokevirtual [47] 
L9:     areturn 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [338] : [339] 
    .attribute [311] .code stack 3 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     iconst_1 
L3:     invokevirtual [47] 
L6:     areturn 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [340] : [341] 
    .attribute [311] .code stack 3 locals 0 
L0:     aload_0 
L1:     iconst_1 
L2:     iconst_3 
L3:     invokevirtual [47] 
L6:     areturn 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [342] : [343] 
    .attribute [311] .code stack 3 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     iconst_3 
L3:     invokevirtual [47] 
L6:     areturn 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [344] : [345] 
    .attribute [311] .code stack 3 locals 0 
L0:     aload_0 
L1:     iconst_1 
L2:     iconst_2 
L3:     invokevirtual [47] 
L6:     areturn 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [346] : [347] 
    .attribute [311] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokevirtual [36] 
L4:     ifeq L16 
L7:     aload_0 
L8:     iload_1 
L9:     iconst_2 
L10:    invokevirtual [47] 
L13:    goto L20 
L16:    aload_0 
L17:    invokevirtual [44] 
L20:    areturn 
L21:    nop 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method protected static [348] : [349] 
    .attribute [311] .code stack 1 locals 1 
L0:     iload_0 
L1:     invokestatic [18] 
L4:     astore_1 
L5:     aload_1 
L6:     ifnonnull L57 
L9:     iload_0 
L10:    tableswitch 91 
            L36 
            L42 
            L48 
            default : L54 

L36:    ldc [19] 
L38:    astore_1 
L39:    goto L57 
L42:    ldc [20] 
L44:    astore_1 
L45:    goto L57 
L48:    ldc [21] 
L50:    astore_1 
L51:    goto L57 
L54:    ldc [22] 
L56:    astore_1 
L57:    aload_1 
L58:    areturn 
L59:    nop 
L60:    
    .end code 
.end method 

.method public [350] : [351] 
    .attribute [311] .code stack 1 locals 0 
L0:     getstatic [23] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method static [352] : [353] 
    .attribute [311] .code stack 1 locals 0 
L0:     ldc [24] 
L2:     putstatic [55] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int -1007346623 
.const [3] = Method [66] [67] 
.const [4] = Method [68] [69] 
.const [5] = Class [70] 
.const [6] = Class [71] 
.const [7] = String [72] 
.const [8] = String [73] 
.const [9] = Class [74] 
.const [10] = Method [75] [76] 
.const [11] = Method [77] [78] 
.const [12] = Method [79] [80] 
.const [13] = String [81] 
.const [14] = Int 63 
.const [15] = Int 8257 
.const [16] = Method [82] [83] 
.const [17] = Method [84] [85] 
.const [18] = Method [86] [87] 
.const [19] = String [88] 
.const [20] = String [89] 
.const [21] = String [90] 
.const [22] = String [91] 
.const [23] = Field [92] [93] 
.const [24] = String [94] 
.const [25] = Class [95] 
.const [26] = Class [96] 
.const [27] = Class [97] 
.const [28] = Class [98] 
.const [29] = Field [99] [100] 
.const [30] = Field [101] [102] 
.const [31] = Field [103] [104] 
.const [32] = Field [105] [106] 
.const [33] = Method [107] [108] 
.const [34] = Method [109] [110] 
.const [35] = Method [111] [112] 
.const [36] = Method [113] [114] 
.const [37] = Method [115] [116] 
.const [38] = Method [117] [118] 
.const [39] = Method [119] [120] 
.const [40] = Method [121] [122] 
.const [41] = Method [123] [124] 
.const [42] = Method [125] [126] 
.const [43] = Method [127] [128] 
.const [44] = Method [129] [130] 
.const [45] = Method [131] [132] 
.const [46] = Method [133] [134] 
.const [47] = Method [135] [136] 
.const [48] = Method [137] [138] 
.const [49] = Method [139] [140] 
.const [50] = Method [141] [142] 
.const [51] = Method [143] [144] 
.const [52] = Method [145] [146] 
.const [53] = Method [147] [148] 
.const [54] = Method [149] [150] 
.const [55] = Field [151] [152] 
.const [56] = Field [153] [154] 
.const [57] = Field [155] [156] 
.const [58] = Field [157] [158] 
.const [59] = Class [159] 
.const [60] = Class [160] 
.const [61] = Class [161] 
.const [62] = Double +0x14000000000000p-49 
.const [64] = Double +0x10000000000000p-53 
.const [66] = Class [162] 
.const [67] = NameAndType [163] [164] 
.const [68] = Class [165] 
.const [69] = NameAndType [166] [167] 
.const [70] = Utf8 java/lang/IllegalArgumentException 
.const [71] = Utf8 java/lang/StringBuffer 
.const [72] = Utf8 'Bad parameter mode:' 
.const [73] = Utf8 ' unit:' 
.const [74] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [75] = Class [168] 
.const [76] = NameAndType [169] [170] 
.const [77] = Class [171] 
.const [78] = NameAndType [172] [173] 
.const [79] = Class [174] 
.const [80] = NameAndType [175] [176] 
.const [81] = Utf8 '-' 
.const [82] = Class [177] 
.const [83] = NameAndType [178] [179] 
.const [84] = Class [180] 
.const [85] = NameAndType [181] [182] 
.const [86] = Class [183] 
.const [87] = NameAndType [184] [185] 
.const [88] = Utf8 ' g' 
.const [89] = Utf8 ' m/s\xb2' 
.const [90] = Utf8 '.' 
.const [91] = Utf8 '' 
.const [92] = Class [186] 
.const [93] = NameAndType [187] [188] 
.const [94] = Utf8 '---' 
.const [95] = Utf8 de/audi/atip/metrics/Acceleration 
.const [96] = Utf8 de/audi/atip/metrics/AbstractMetrics 
.const [97] = Utf8 java/lang/Math 
.const [98] = Utf8 java/lang/String 
.const [99] = Class [189] 
.const [100] = NameAndType [190] [191] 
.const [101] = Class [192] 
.const [102] = NameAndType [193] [194] 
.const [103] = Class [195] 
.const [104] = NameAndType [196] [197] 
.const [105] = Class [198] 
.const [106] = NameAndType [199] [200] 
.const [107] = Class [201] 
.const [108] = NameAndType [202] [203] 
.const [109] = Class [204] 
.const [110] = NameAndType [205] [206] 
.const [111] = Class [207] 
.const [112] = NameAndType [208] [209] 
.const [113] = Class [210] 
.const [114] = NameAndType [211] [212] 
.const [115] = Class [213] 
.const [116] = NameAndType [214] [215] 
.const [117] = Class [216] 
.const [118] = NameAndType [217] [218] 
.const [119] = Class [219] 
.const [120] = NameAndType [220] [221] 
.const [121] = Class [222] 
.const [122] = NameAndType [223] [224] 
.const [123] = Class [225] 
.const [124] = NameAndType [226] [227] 
.const [125] = Class [228] 
.const [126] = NameAndType [229] [230] 
.const [127] = Class [231] 
.const [128] = NameAndType [232] [233] 
.const [129] = Class [234] 
.const [130] = NameAndType [235] [236] 
.const [131] = Class [237] 
.const [132] = NameAndType [238] [239] 
.const [133] = Class [240] 
.const [134] = NameAndType [241] [242] 
.const [135] = Class [243] 
.const [136] = NameAndType [244] [245] 
.const [137] = Class [246] 
.const [138] = NameAndType [247] [248] 
.const [139] = Class [249] 
.const [140] = NameAndType [250] [251] 
.const [141] = Class [252] 
.const [142] = NameAndType [253] [254] 
.const [143] = Class [255] 
.const [144] = NameAndType [256] [257] 
.const [145] = Class [258] 
.const [146] = NameAndType [259] [260] 
.const [147] = Class [261] 
.const [148] = NameAndType [262] [263] 
.const [149] = Class [264] 
.const [150] = NameAndType [265] [266] 
.const [151] = Class [267] 
.const [152] = NameAndType [268] [269] 
.const [153] = Class [270] 
.const [154] = NameAndType [271] [272] 
.const [155] = Class [273] 
.const [156] = NameAndType [274] [275] 
.const [157] = Class [276] 
.const [158] = NameAndType [277] [278] 
.const [159] = Utf8 java/lang/IllegalArgumentException 
.const [160] = Utf8 java/lang/StringBuffer 
.const [161] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [162] = Utf8 de/audi/atip/metrics/Acceleration 
.const [163] = Utf8 modeIsValid 
.const [164] = Utf8 (I)Z 
.const [165] = Utf8 de/audi/atip/metrics/Acceleration 
.const [166] = Utf8 unitIsValid 
.const [167] = Utf8 (I)Z 
.const [168] = Utf8 java/lang/Math 
.const [169] = Utf8 pow 
.const [170] = Utf8 (DD)D 
.const [171] = Utf8 java/lang/Math 
.const [172] = Utf8 abs 
.const [173] = Utf8 (F)F 
.const [174] = Utf8 java/lang/Math 
.const [175] = Utf8 abs 
.const [176] = Utf8 (I)I 
.const [177] = Utf8 java/lang/String 
.const [178] = Utf8 valueOf 
.const [179] = Utf8 (I)Ljava/lang/String; 
.const [180] = Utf8 de/audi/atip/metrics/Acceleration 
.const [181] = Utf8 getText 
.const [182] = Utf8 (I)Ljava/lang/String; 
.const [183] = Utf8 de/audi/atip/metrics/AbstractMetrics 
.const [184] = Utf8 getText 
.const [185] = Utf8 (I)Ljava/lang/String; 
.const [186] = Utf8 de/audi/atip/metrics/Acceleration 
.const [187] = Utf8 TEXT_INVALID 
.const [188] = Utf8 Ljava/lang/String; 
.const [189] = Utf8 de/audi/atip/metrics/Acceleration 
.const [190] = Utf8 numberOfDecimalPlacesFormat 
.const [191] = Utf8 I 
.const [192] = Utf8 de/audi/atip/metrics/Acceleration 
.const [193] = Utf8 numberOfDecimalPlaces 
.const [194] = Utf8 I 
.const [195] = Utf8 de/audi/atip/metrics/Acceleration 
.const [196] = Utf8 unit 
.const [197] = Utf8 I 
.const [198] = Utf8 de/audi/atip/metrics/Acceleration 
.const [199] = Utf8 value 
.const [200] = Utf8 F 
.const [201] = Utf8 java/lang/StringBuffer 
.const [202] = Utf8 append 
.const [203] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [204] = Utf8 java/lang/StringBuffer 
.const [205] = Utf8 append 
.const [206] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [207] = Utf8 java/lang/StringBuffer 
.const [208] = Utf8 toString 
.const [209] = Utf8 ()Ljava/lang/String; 
.const [210] = Utf8 de/audi/atip/metrics/Acceleration 
.const [211] = Utf8 isMetricvalid 
.const [212] = Utf8 ()Z 
.const [213] = Utf8 de/audi/atip/metrics/Acceleration 
.const [214] = Utf8 getValue 
.const [215] = Utf8 (I)F 
.const [216] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [217] = Utf8 append 
.const [218] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [219] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [220] = Utf8 append 
.const [221] = Utf8 (I)Lde/esolutions/fw/util/commons/Buffer; 
.const [222] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [223] = Utf8 length 
.const [224] = Utf8 ()I 
.const [225] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [226] = Utf8 charAt 
.const [227] = Utf8 (I)C 
.const [228] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [229] = Utf8 deleteCharAt 
.const [230] = Utf8 (I)Lde/esolutions/fw/util/commons/Buffer; 
.const [231] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [232] = Utf8 append 
.const [233] = Utf8 (Ljava/lang/Object;)Lde/esolutions/fw/util/commons/Buffer; 
.const [234] = Utf8 de/audi/atip/metrics/Acceleration 
.const [235] = Utf8 getInvalidText 
.const [236] = Utf8 ()Ljava/lang/String; 
.const [237] = Utf8 java/lang/String 
.const [238] = Utf8 trim 
.const [239] = Utf8 ()Ljava/lang/String; 
.const [240] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [241] = Utf8 toString 
.const [242] = Utf8 ()Ljava/lang/String; 
.const [243] = Utf8 de/audi/atip/metrics/Acceleration 
.const [244] = Utf8 format 
.const [245] = Utf8 (II)Ljava/lang/String; 
.const [246] = Utf8 de/audi/atip/metrics/AbstractMetrics 
.const [247] = Utf8 <init> 
.const [248] = Utf8 (FI)V 
.const [249] = Utf8 de/audi/atip/metrics/Acceleration 
.const [250] = Utf8 importValue 
.const [251] = Utf8 ()V 
.const [252] = Utf8 de/audi/atip/metrics/Acceleration 
.const [253] = Utf8 meterPerSquareSec2g 
.const [254] = Utf8 (F)F 
.const [255] = Utf8 de/audi/atip/metrics/Acceleration 
.const [256] = Utf8 g2meterPerSquaresec 
.const [257] = Utf8 (F)F 
.const [258] = Utf8 java/lang/StringBuffer 
.const [259] = Utf8 <init> 
.const [260] = Utf8 ()V 
.const [261] = Utf8 java/lang/IllegalArgumentException 
.const [262] = Utf8 <init> 
.const [263] = Utf8 (Ljava/lang/String;)V 
.const [264] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [265] = Utf8 <init> 
.const [266] = Utf8 ()V 
.const [267] = Utf8 de/audi/atip/metrics/Acceleration 
.const [268] = Utf8 TEXT_INVALID 
.const [269] = Utf8 Ljava/lang/String; 
.const [270] = Utf8 de/audi/atip/metrics/Acceleration 
.const [271] = Utf8 numberOfDecimalPlacesFormat 
.const [272] = Utf8 I 
.const [273] = Utf8 de/audi/atip/metrics/Acceleration 
.const [274] = Utf8 numberOfDecimalPlaces 
.const [275] = Utf8 I 
.const [276] = Utf8 de/audi/atip/metrics/Acceleration 
.const [277] = Utf8 value 
.const [278] = Utf8 F 
.const [279] = Utf8 de/audi/atip/metrics/Acceleration 
.const [280] = Class [279] 
.const [281] = Utf8 de/audi/atip/metrics/AbstractMetrics 
.const [282] = Class [281] 
.const [283] = Utf8 TEXT_NEGATIVE 
.const [284] = Utf8 Ljava/lang/String; 
.const [285] = Utf8 TEXT_G 
.const [286] = Utf8 Ljava/lang/String; 
.const [287] = Utf8 TEXT_METER_PER_SQUARE_SEC 
.const [288] = Utf8 Ljava/lang/String; 
.const [289] = Utf8 TEXT_INVALID 
.const [290] = Utf8 Ljava/lang/String; 
.const [291] = Utf8 G 
.const [292] = Utf8 I 
.const [293] = Utf8 METER_PER_SQUARE_SEC 
.const [294] = Utf8 I 
.const [295] = Utf8 MODE_DEFAULT 
.const [296] = Utf8 I 
.const [297] = Utf8 MODE_VALUE 
.const [298] = Utf8 I 
.const [299] = Utf8 MODE_UNIT 
.const [300] = Utf8 I 
.const [301] = Utf8 G2METER_PER_SQUARE_SEC 
.const [302] = Utf8 F 
.const [303] = Utf8 NO_OF_DECIMAL_PLACES_FIXED 
.const [304] = Utf8 I 
.const [305] = Utf8 NO_OF_DECIMAL_PLACES_FLOATING 
.const [306] = Utf8 I 
.const [307] = Utf8 numberOfDecimalPlacesFormat 
.const [308] = Utf8 I 
.const [309] = Utf8 numberOfDecimalPlaces 
.const [310] = Utf8 I 
.const [311] = Utf8 Code 
.const [312] = Utf8 <init> 
.const [313] = Utf8 (FI)V 
.const [314] = Utf8 importValue 
.const [315] = Utf8 ()V 
.const [316] = Utf8 g2meterPerSquaresec 
.const [317] = Utf8 (F)F 
.const [318] = Utf8 meterPerSquareSec2g 
.const [319] = Utf8 (F)F 
.const [320] = Utf8 unitIsValid 
.const [321] = Utf8 (I)Z 
.const [322] = Utf8 modeIsValid 
.const [323] = Utf8 (I)Z 
.const [324] = Utf8 setNumberOfDecimalPlacesFormat 
.const [325] = Utf8 (I)V 
.const [326] = Utf8 setNumberOfDecimalPlaces 
.const [327] = Utf8 (I)V 
.const [328] = Utf8 setValue 
.const [329] = Utf8 (F)V 
.const [330] = Utf8 getValue 
.const [331] = Utf8 ()F 
.const [332] = Utf8 getValue 
.const [333] = Utf8 (I)F 
.const [334] = Utf8 format 
.const [335] = Utf8 (II)Ljava/lang/String; 
.const [336] = Utf8 format 
.const [337] = Utf8 ()Ljava/lang/String; 
.const [338] = Utf8 format 
.const [339] = Utf8 (I)Ljava/lang/String; 
.const [340] = Utf8 getFormattedMetricUnit 
.const [341] = Utf8 ()Ljava/lang/String; 
.const [342] = Utf8 getFormattedUnit 
.const [343] = Utf8 (I)Ljava/lang/String; 
.const [344] = Utf8 getFormattedValue 
.const [345] = Utf8 ()Ljava/lang/String; 
.const [346] = Utf8 getFormattedValue 
.const [347] = Utf8 (I)Ljava/lang/String; 
.const [348] = Utf8 getText 
.const [349] = Utf8 (I)Ljava/lang/String; 
.const [350] = Utf8 getInvalidText 
.const [351] = Utf8 ()Ljava/lang/String; 
.const [352] = Utf8 <clinit> 
.const [353] = Utf8 ()V 
.end class 
