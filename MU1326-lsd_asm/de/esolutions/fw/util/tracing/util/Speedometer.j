.version 50 0 
.class public super [209] 
.super [211] 
.field private final [212] [213] 
.field private final [214] [215] 
.field private [216] [217] 
.field private [218] [219] 
.field private [220] [221] 
.field private [222] [223] 
.field private [224] [225] 
.field private [226] [227] 

.method public [229] : [230] 
    .attribute [228] .code stack 5 locals 1 
L0:     aload_0 
L1:     invokespecial [31] 
L4:     aload_0 
L5:     iload_1 
L6:     putfield [34] 
L9:     aload_0 
L10:    iload_1 
L11:    anewarray [2] 
L14:    putfield [36] 
L17:    iconst_0 
L18:    istore_2 
L19:    iload_2 
L20:    iload_1 
L21:    if_icmpge L44 
L24:    aload_0 
L25:    getfield [13] 
L28:    iload_2 
L29:    new [35] 
L32:    dup 
L33:    aconst_null 
L34:    invokespecial [32] 
L37:    aastore 
L38:    iinc 2 1 
L41:    goto L19 
L44:    aload_0 
L45:    invokevirtual [14] 
L48:    return 
L49:    nop 
L50:    nop 
L51:    nop 
L52:    
    .end code 
.end method 

.method public [231] : [232] 
    .attribute [228] .code stack 3 locals 0 
L0:     aload_0 
L1:     iconst_0 
L2:     putfield [37] 
L5:     aload_0 
L6:     iconst_0 
L7:     putfield [38] 
L10:    aload_0 
L11:    ldc2_w [44] 
L14:    putfield [39] 
L17:    aload_0 
L18:    lconst_0 
L19:    putfield [40] 
L22:    aload_0 
L23:    iconst_0 
L24:    putfield [41] 
L27:    aload_0 
L28:    lconst_0 
L29:    putfield [42] 
L32:    return 
L33:    nop 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 

.method public [233] : [234] 
    .attribute [228] .code stack 5 locals 2 
L0:     aload_0 
L1:     getfield [17] 
L4:     ldc2_w [44] 
L7:     lcmp 
L8:     ifne L17 
L11:    aload_0 
L12:    lload_1 
L13:    putfield [39] 
L16:    return 
L17:    lload_1 
L18:    aload_0 
L19:    getfield [17] 
L22:    lsub 
L23:    lstore 5 
L25:    aload_0 
L26:    lload_1 
L27:    putfield [39] 
L30:    lload 5 
L32:    lconst_0 
L33:    lcmp 
L34:    ifne L214 
L37:    aload_0 
L38:    getfield [15] 
L41:    aload_0 
L42:    getfield [12] 
L45:    if_icmpne L187 
L48:    aload_0 
L49:    getfield [13] 
L52:    aload_0 
L53:    getfield [16] 
L56:    aaload 
L57:    invokevirtual [21] 
L60:    lconst_0 
L61:    lcmp 
L62:    ifeq L171 
L65:    aload_0 
L66:    dup 
L67:    getfield [16] 
L70:    iconst_1 
L71:    iadd 
L72:    putfield [38] 
L75:    aload_0 
L76:    getfield [16] 
L79:    aload_0 
L80:    getfield [12] 
L83:    if_icmpne L91 
L86:    aload_0 
L87:    iconst_0 
L88:    putfield [38] 
L91:    aload_0 
L92:    dup 
L93:    getfield [18] 
L96:    aload_0 
L97:    getfield [13] 
L100:   aload_0 
L101:   getfield [16] 
L104:   aaload 
L105:   invokevirtual [21] 
L108:   lsub 
L109:   putfield [40] 
L112:   aload_0 
L113:   dup 
L114:   getfield [19] 
L117:   aload_0 
L118:   getfield [13] 
L121:   aload_0 
L122:   getfield [16] 
L125:   aaload 
L126:   invokevirtual [22] 
L129:   isub 
L130:   putfield [41] 
L133:   aload_0 
L134:   dup 
L135:   getfield [20] 
L138:   aload_0 
L139:   getfield [13] 
L142:   aload_0 
L143:   getfield [16] 
L146:   aaload 
L147:   invokevirtual [23] 
L150:   lsub 
L151:   putfield [42] 
L154:   aload_0 
L155:   getfield [13] 
L158:   aload_0 
L159:   getfield [16] 
L162:   aaload 
L163:   lconst_0 
L164:   lload_3 
L165:   invokevirtual [24] 
L168:   goto L357 
L171:   aload_0 
L172:   getfield [13] 
L175:   aload_0 
L176:   getfield [16] 
L179:   aaload 
L180:   lload_3 
L181:   invokevirtual [25] 
L184:   goto L357 
L187:   aload_0 
L188:   getfield [13] 
L191:   aload_0 
L192:   getfield [15] 
L195:   aaload 
L196:   lconst_0 
L197:   lload_3 
L198:   invokevirtual [24] 
L201:   aload_0 
L202:   dup 
L203:   getfield [15] 
L206:   iconst_1 
L207:   iadd 
L208:   putfield [37] 
L211:   goto L357 
L214:   aload_0 
L215:   getfield [15] 
L218:   aload_0 
L219:   getfield [12] 
L222:   if_icmpge L253 
L225:   aload_0 
L226:   getfield [13] 
L229:   aload_0 
L230:   getfield [15] 
L233:   aaload 
L234:   lload 5 
L236:   lload_3 
L237:   invokevirtual [24] 
L240:   aload_0 
L241:   dup 
L242:   getfield [15] 
L245:   iconst_1 
L246:   iadd 
L247:   putfield [37] 
L250:   goto L357 
L253:   aload_0 
L254:   dup 
L255:   getfield [18] 
L258:   aload_0 
L259:   getfield [13] 
L262:   aload_0 
L263:   getfield [16] 
L266:   aaload 
L267:   invokevirtual [21] 
L270:   lsub 
L271:   putfield [40] 
L274:   aload_0 
L275:   dup 
L276:   getfield [19] 
L279:   aload_0 
L280:   getfield [13] 
L283:   aload_0 
L284:   getfield [16] 
L287:   aaload 
L288:   invokevirtual [22] 
L291:   isub 
L292:   putfield [41] 
L295:   aload_0 
L296:   dup 
L297:   getfield [20] 
L300:   aload_0 
L301:   getfield [13] 
L304:   aload_0 
L305:   getfield [16] 
L308:   aaload 
L309:   invokevirtual [23] 
L312:   lsub 
L313:   putfield [42] 
L316:   aload_0 
L317:   getfield [13] 
L320:   aload_0 
L321:   getfield [16] 
L324:   aaload 
L325:   lload 5 
L327:   lload_3 
L328:   invokevirtual [24] 
L331:   aload_0 
L332:   dup 
L333:   getfield [16] 
L336:   iconst_1 
L337:   iadd 
L338:   putfield [38] 
L341:   aload_0 
L342:   getfield [16] 
L345:   aload_0 
L346:   getfield [12] 
L349:   if_icmpne L357 
L352:   aload_0 
L353:   iconst_0 
L354:   putfield [38] 
L357:   aload_0 
L358:   dup 
L359:   getfield [18] 
L362:   lload 5 
L364:   ladd 
L365:   putfield [40] 
L368:   aload_0 
L369:   dup 
L370:   getfield [19] 
L373:   iconst_1 
L374:   iadd 
L375:   putfield [41] 
L378:   aload_0 
L379:   dup 
L380:   getfield [20] 
L383:   lload_3 
L384:   ladd 
L385:   putfield [42] 
L388:   return 
L389:   nop 
L390:   nop 
L391:   nop 
L392:   
    .end code 
.end method 

.method public [235] : [236] 
    .attribute [228] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [19] 
L4:     ifne L9 
L7:     iconst_0 
L8:     areturn 
L9:     aload_0 
L10:    getfield [18] 
L13:    aload_0 
L14:    getfield [19] 
L17:    i2l 
L18:    ldiv 
L19:    l2i 
L20:    areturn 
L21:    nop 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [237] : [238] 
    .attribute [228] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [18] 
L4:     lconst_0 
L5:     lcmp 
L6:     ifne L11 
L9:     iconst_0 
L10:    areturn 
L11:    aload_0 
L12:    getfield [19] 
L15:    iload_1 
L16:    imul 
L17:    i2l 
L18:    aload_0 
L19:    getfield [18] 
L22:    ldiv 
L23:    l2i 
L24:    areturn 
L25:    nop 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [239] : [240] 
    .attribute [228] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [18] 
L4:     lconst_0 
L5:     lcmp 
L6:     ifne L11 
L9:     iconst_0 
L10:    areturn 
L11:    aload_0 
L12:    getfield [20] 
L15:    iload_1 
L16:    i2l 
L17:    lmul 
L18:    aload_0 
L19:    getfield [18] 
L22:    ldiv 
L23:    l2i 
L24:    areturn 
L25:    nop 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [241] : [242] 
    .attribute [228] .code stack 3 locals 2 
L0:     new [43] 
L3:     dup 
L4:     invokespecial [33] 
L7:     astore_1 
L8:     aload_1 
L9:     ldc [4] 
L11:    invokevirtual [26] 
L14:    pop 
L15:    iconst_0 
L16:    istore_2 
L17:    iload_2 
L18:    aload_0 
L19:    getfield [15] 
L22:    if_icmpge L64 
L25:    aload_1 
L26:    aload_0 
L27:    getfield [13] 
L30:    iload_2 
L31:    aaload 
L32:    invokevirtual [27] 
L35:    pop 
L36:    iload_2 
L37:    aload_0 
L38:    getfield [16] 
L41:    if_icmpne L51 
L44:    aload_1 
L45:    ldc [5] 
L47:    invokevirtual [26] 
L50:    pop 
L51:    aload_1 
L52:    ldc [6] 
L54:    invokevirtual [26] 
L57:    pop 
L58:    iinc 2 1 
L61:    goto L17 
L64:    aload_1 
L65:    ldc [7] 
L67:    invokevirtual [26] 
L70:    pop 
L71:    aload_1 
L72:    aload_0 
L73:    getfield [18] 
L76:    invokevirtual [28] 
L79:    pop 
L80:    aload_1 
L81:    ldc [8] 
L83:    invokevirtual [26] 
L86:    pop 
L87:    aload_1 
L88:    aload_0 
L89:    getfield [20] 
L92:    invokevirtual [28] 
L95:    pop 
L96:    aload_1 
L97:    ldc [9] 
L99:    invokevirtual [26] 
L102:   pop 
L103:   aload_1 
L104:   aload_0 
L105:   getfield [19] 
L108:   invokevirtual [29] 
L111:   pop 
L112:   aload_1 
L113:   invokevirtual [30] 
L116:   areturn 
L117:   nop 
L118:   nop 
L119:   nop 
L120:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [46] 
.const [3] = Class [47] 
.const [4] = String [48] 
.const [5] = String [49] 
.const [6] = String [50] 
.const [7] = String [51] 
.const [8] = String [52] 
.const [9] = String [53] 
.const [10] = Class [54] 
.const [11] = Class [55] 
.const [12] = Field [56] [57] 
.const [13] = Field [58] [59] 
.const [14] = Method [60] [61] 
.const [15] = Field [62] [63] 
.const [16] = Field [64] [65] 
.const [17] = Field [66] [67] 
.const [18] = Field [68] [69] 
.const [19] = Field [70] [71] 
.const [20] = Field [72] [73] 
.const [21] = Method [74] [75] 
.const [22] = Method [76] [77] 
.const [23] = Method [78] [79] 
.const [24] = Method [80] [81] 
.const [25] = Method [82] [83] 
.const [26] = Method [84] [85] 
.const [27] = Method [86] [87] 
.const [28] = Method [88] [89] 
.const [29] = Method [90] [91] 
.const [30] = Method [92] [93] 
.const [31] = Method [94] [95] 
.const [32] = Method [96] [97] 
.const [33] = Method [98] [99] 
.const [34] = Field [100] [101] 
.const [35] = Class [102] 
.const [36] = Field [103] [104] 
.const [37] = Field [105] [106] 
.const [38] = Field [107] [108] 
.const [39] = Field [109] [110] 
.const [40] = Field [111] [112] 
.const [41] = Field [113] [114] 
.const [42] = Field [115] [116] 
.const [43] = Class [117] 
.const [44] = Long -1L 
.const [46] = Utf8 de/esolutions/fw/util/tracing/util/Speedometer$Sample 
.const [47] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [48] = Utf8 '[' 
.const [49] = Utf8 '*' 
.const [50] = Utf8 ' ' 
.const [51] = Utf8 '] -> sd=' 
.const [52] = Utf8 ',sv=' 
.const [53] = Utf8 '/sc=' 
.const [54] = Utf8 de/esolutions/fw/util/tracing/util/Speedometer 
.const [55] = Utf8 java/lang/Object 
.const [56] = Class [118] 
.const [57] = NameAndType [119] [120] 
.const [58] = Class [121] 
.const [59] = NameAndType [122] [123] 
.const [60] = Class [124] 
.const [61] = NameAndType [125] [126] 
.const [62] = Class [127] 
.const [63] = NameAndType [128] [129] 
.const [64] = Class [130] 
.const [65] = NameAndType [131] [132] 
.const [66] = Class [133] 
.const [67] = NameAndType [134] [135] 
.const [68] = Class [136] 
.const [69] = NameAndType [137] [138] 
.const [70] = Class [139] 
.const [71] = NameAndType [140] [141] 
.const [72] = Class [142] 
.const [73] = NameAndType [143] [144] 
.const [74] = Class [145] 
.const [75] = NameAndType [146] [147] 
.const [76] = Class [148] 
.const [77] = NameAndType [149] [150] 
.const [78] = Class [151] 
.const [79] = NameAndType [152] [153] 
.const [80] = Class [154] 
.const [81] = NameAndType [155] [156] 
.const [82] = Class [157] 
.const [83] = NameAndType [158] [159] 
.const [84] = Class [160] 
.const [85] = NameAndType [161] [162] 
.const [86] = Class [163] 
.const [87] = NameAndType [164] [165] 
.const [88] = Class [166] 
.const [89] = NameAndType [167] [168] 
.const [90] = Class [169] 
.const [91] = NameAndType [170] [171] 
.const [92] = Class [172] 
.const [93] = NameAndType [173] [174] 
.const [94] = Class [175] 
.const [95] = NameAndType [176] [177] 
.const [96] = Class [178] 
.const [97] = NameAndType [179] [180] 
.const [98] = Class [181] 
.const [99] = NameAndType [182] [183] 
.const [100] = Class [184] 
.const [101] = NameAndType [185] [186] 
.const [102] = Utf8 de/esolutions/fw/util/tracing/util/Speedometer$Sample 
.const [103] = Class [187] 
.const [104] = NameAndType [188] [189] 
.const [105] = Class [190] 
.const [106] = NameAndType [191] [192] 
.const [107] = Class [193] 
.const [108] = NameAndType [194] [195] 
.const [109] = Class [196] 
.const [110] = NameAndType [197] [198] 
.const [111] = Class [199] 
.const [112] = NameAndType [200] [201] 
.const [113] = Class [202] 
.const [114] = NameAndType [203] [204] 
.const [115] = Class [205] 
.const [116] = NameAndType [206] [207] 
.const [117] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [118] = Utf8 de/esolutions/fw/util/tracing/util/Speedometer 
.const [119] = Utf8 capacity 
.const [120] = Utf8 I 
.const [121] = Utf8 de/esolutions/fw/util/tracing/util/Speedometer 
.const [122] = Utf8 samples 
.const [123] = Utf8 [Lde/esolutions/fw/util/tracing/util/Speedometer$Sample; 
.const [124] = Utf8 de/esolutions/fw/util/tracing/util/Speedometer 
.const [125] = Utf8 reset 
.const [126] = Utf8 ()V 
.const [127] = Utf8 de/esolutions/fw/util/tracing/util/Speedometer 
.const [128] = Utf8 size 
.const [129] = Utf8 I 
.const [130] = Utf8 de/esolutions/fw/util/tracing/util/Speedometer 
.const [131] = Utf8 pos 
.const [132] = Utf8 I 
.const [133] = Utf8 de/esolutions/fw/util/tracing/util/Speedometer 
.const [134] = Utf8 lastSampleTime 
.const [135] = Utf8 J 
.const [136] = Utf8 de/esolutions/fw/util/tracing/util/Speedometer 
.const [137] = Utf8 totalDelta 
.const [138] = Utf8 J 
.const [139] = Utf8 de/esolutions/fw/util/tracing/util/Speedometer 
.const [140] = Utf8 totalSamples 
.const [141] = Utf8 I 
.const [142] = Utf8 de/esolutions/fw/util/tracing/util/Speedometer 
.const [143] = Utf8 totalData 
.const [144] = Utf8 J 
.const [145] = Utf8 de/esolutions/fw/util/tracing/util/Speedometer$Sample 
.const [146] = Utf8 getDelta 
.const [147] = Utf8 ()J 
.const [148] = Utf8 de/esolutions/fw/util/tracing/util/Speedometer$Sample 
.const [149] = Utf8 getCounter 
.const [150] = Utf8 ()I 
.const [151] = Utf8 de/esolutions/fw/util/tracing/util/Speedometer$Sample 
.const [152] = Utf8 getDataSum 
.const [153] = Utf8 ()J 
.const [154] = Utf8 de/esolutions/fw/util/tracing/util/Speedometer$Sample 
.const [155] = Utf8 set 
.const [156] = Utf8 (JJ)V 
.const [157] = Utf8 de/esolutions/fw/util/tracing/util/Speedometer$Sample 
.const [158] = Utf8 add 
.const [159] = Utf8 (J)V 
.const [160] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [161] = Utf8 append 
.const [162] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [163] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [164] = Utf8 append 
.const [165] = Utf8 (Ljava/lang/Object;)Lde/esolutions/fw/util/commons/Buffer; 
.const [166] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [167] = Utf8 append 
.const [168] = Utf8 (J)Lde/esolutions/fw/util/commons/Buffer; 
.const [169] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [170] = Utf8 append 
.const [171] = Utf8 (I)Lde/esolutions/fw/util/commons/Buffer; 
.const [172] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [173] = Utf8 toString 
.const [174] = Utf8 ()Ljava/lang/String; 
.const [175] = Utf8 java/lang/Object 
.const [176] = Utf8 <init> 
.const [177] = Utf8 ()V 
.const [178] = Utf8 de/esolutions/fw/util/tracing/util/Speedometer$Sample 
.const [179] = Utf8 <init> 
.const [180] = Utf8 (Lde/esolutions/fw/util/tracing/util/Speedometer$1;)V 
.const [181] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [182] = Utf8 <init> 
.const [183] = Utf8 ()V 
.const [184] = Utf8 de/esolutions/fw/util/tracing/util/Speedometer 
.const [185] = Utf8 capacity 
.const [186] = Utf8 I 
.const [187] = Utf8 de/esolutions/fw/util/tracing/util/Speedometer 
.const [188] = Utf8 samples 
.const [189] = Utf8 [Lde/esolutions/fw/util/tracing/util/Speedometer$Sample; 
.const [190] = Utf8 de/esolutions/fw/util/tracing/util/Speedometer 
.const [191] = Utf8 size 
.const [192] = Utf8 I 
.const [193] = Utf8 de/esolutions/fw/util/tracing/util/Speedometer 
.const [194] = Utf8 pos 
.const [195] = Utf8 I 
.const [196] = Utf8 de/esolutions/fw/util/tracing/util/Speedometer 
.const [197] = Utf8 lastSampleTime 
.const [198] = Utf8 J 
.const [199] = Utf8 de/esolutions/fw/util/tracing/util/Speedometer 
.const [200] = Utf8 totalDelta 
.const [201] = Utf8 J 
.const [202] = Utf8 de/esolutions/fw/util/tracing/util/Speedometer 
.const [203] = Utf8 totalSamples 
.const [204] = Utf8 I 
.const [205] = Utf8 de/esolutions/fw/util/tracing/util/Speedometer 
.const [206] = Utf8 totalData 
.const [207] = Utf8 J 
.const [208] = Utf8 de/esolutions/fw/util/tracing/util/Speedometer 
.const [209] = Class [208] 
.const [210] = Utf8 java/lang/Object 
.const [211] = Class [210] 
.const [212] = Utf8 samples 
.const [213] = Utf8 [Lde/esolutions/fw/util/tracing/util/Speedometer$Sample; 
.const [214] = Utf8 capacity 
.const [215] = Utf8 I 
.const [216] = Utf8 size 
.const [217] = Utf8 I 
.const [218] = Utf8 pos 
.const [219] = Utf8 I 
.const [220] = Utf8 totalSamples 
.const [221] = Utf8 I 
.const [222] = Utf8 totalDelta 
.const [223] = Utf8 J 
.const [224] = Utf8 totalData 
.const [225] = Utf8 J 
.const [226] = Utf8 lastSampleTime 
.const [227] = Utf8 J 
.const [228] = Utf8 Code 
.const [229] = Utf8 <init> 
.const [230] = Utf8 (I)V 
.const [231] = Utf8 reset 
.const [232] = Utf8 ()V 
.const [233] = Utf8 addSample 
.const [234] = Utf8 (JJ)V 
.const [235] = Utf8 getDelta 
.const [236] = Utf8 ()I 
.const [237] = Utf8 getFrequency 
.const [238] = Utf8 (I)I 
.const [239] = Utf8 getDataRate 
.const [240] = Utf8 (I)I 
.const [241] = Utf8 toString 
.const [242] = Utf8 ()Ljava/lang/String; 
.end class 
