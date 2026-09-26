.version 50 0 
.class public super [333] 
.super [335] 
.implements [337] 
.field private [338] [339] 
.field private [340] [341] 
.field private [342] [343] 
.field private [344] [345] 
.field private [346] [347] 
.field private [348] [349] 

.method public static [351] : [352] 
    .attribute [350] .code stack 6 locals 0 
L0:     new [61] 
L3:     dup 
L4:     aload_0 
L5:     aload_1 
L6:     aload_2 
L7:     iconst_0 
L8:     invokespecial [51] 
L11:    invokespecial [52] 
L14:    areturn 
L15:    nop 
L16:    
    .end code 
.end method 

.method public static [353] : [354] 
    .attribute [350] .code stack 6 locals 0 
L0:     new [61] 
L3:     dup 
L4:     aload_0 
L5:     aload_1 
L6:     aload_2 
L7:     iload_3 
L8:     invokespecial [51] 
L11:    invokespecial [52] 
L14:    areturn 
L15:    nop 
L16:    
    .end code 
.end method 

.method protected [355] : [356] 
    .attribute [350] .code stack 6 locals 0 
L0:     aload_0 
L1:     invokespecial [53] 
L4:     aload_0 
L5:     aconst_null 
L6:     putfield [62] 
L9:     aload_0 
L10:    iconst_0 
L11:    putfield [63] 
L14:    aload_0 
L15:    new [64] 
L18:    dup 
L19:    invokespecial [54] 
L22:    putfield [65] 
L25:    aload_0 
L26:    aload_2 
L27:    putfield [66] 
L30:    aload_0 
L31:    aload_1 
L32:    putfield [67] 
L35:    aload_0 
L36:    aload_3 
L37:    putfield [62] 
L40:    aload_0 
L41:    iload 4 
L43:    putfield [63] 
L46:    aload_0 
L47:    aload_1 
L48:    invokevirtual [38] 
L51:    iconst_1 
L52:    anewarray [4] 
L55:    dup 
L56:    iconst_0 
L57:    aload_1 
L58:    aastore 
L59:    aload_0 
L60:    invokestatic [5] 
L63:    putfield [68] 
L66:    return 
L67:    nop 
L68:    
    .end code 
.end method 

.method private interface [357] : [358] 
    .attribute [350] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [39] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method private interface [359] : [360] 
    .attribute [350] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [36] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [361] : [362] 
    .attribute [350] .code stack 6 locals 1 
L0:     aload_0 
L1:     getfield [34] 
L4:     ifeq L17 
L7:     new [69] 
L10:    dup 
L11:    invokespecial [55] 
L14:    invokevirtual [40] 
L17:    aload_0 
L18:    invokespecial [56] 
L21:    ifnull L50 
L24:    aload_0 
L25:    invokespecial [56] 
L28:    sipush 10000 
L31:    ldc [7] 
L33:    aload_0 
L34:    getfield [37] 
L37:    invokevirtual [41] 
L40:    aload_2 
L41:    invokevirtual [42] 
L44:    invokevirtual [43] 
L47:    goto L110 
L50:    getstatic [8] 
L53:    new [70] 
L56:    dup 
L57:    invokespecial [57] 
L60:    ldc [10] 
L62:    invokevirtual [44] 
L65:    aload_0 
L66:    getfield [37] 
L69:    invokevirtual [41] 
L72:    invokevirtual [44] 
L75:    ldc [11] 
L77:    invokevirtual [44] 
L80:    aload_2 
L81:    invokevirtual [42] 
L84:    invokevirtual [44] 
L87:    ldc [12] 
L89:    invokevirtual [44] 
L92:    aload_0 
L93:    getfield [33] 
L96:    invokevirtual [44] 
L99:    ldc [13] 
L101:   invokevirtual [44] 
L104:   invokevirtual [45] 
L107:   invokevirtual [46] 
L110:   aload_2 
L111:   invokevirtual [47] 
L114:   astore 4 
L116:   aload 4 
L118:   invokevirtual [48] 
L121:   ifeq L187 
L124:   aload 4 
L126:   getstatic [14] 
L129:   if_acmpne L141 
L132:   new [71] 
L135:   dup 
L136:   iconst_0 
L137:   invokespecial [58] 
L140:   areturn 
L141:   aload 4 
L143:   getstatic [16] 
L146:   if_acmpne L158 
L149:   new [72] 
L152:   dup 
L153:   lconst_0 
L154:   invokespecial [59] 
L157:   areturn 
L158:   aload 4 
L160:   getstatic [18] 
L163:   if_acmpne L175 
L166:   new [73] 
L169:   dup 
L170:   fconst_0 
L171:   invokespecial [60] 
L174:   areturn 
L175:   aload 4 
L177:   getstatic [20] 
L180:   if_acmpne L346 
L183:   getstatic [21] 
L186:   areturn 
L187:   aload 4 
L189:   invokevirtual [49] 
L192:   ifeq L247 
L195:   aload_0 
L196:   getfield [35] 
L199:   aload 4 
L201:   invokeinterface [74] 0 
L206:   ifne L235 
L209:   aload_0 
L210:   getfield [35] 
L213:   aload 4 
L215:   aload 4 
L217:   aload_0 
L218:   invokespecial [56] 
L221:   aload 4 
L223:   invokevirtual [41] 
L226:   invokestatic [22] 
L229:   invokeinterface [75] 0 
L234:   pop 
L235:   aload_0 
L236:   getfield [35] 
L239:   aload 4 
L241:   invokeinterface [76] 0 
L246:   areturn 
L247:   aload_0 
L248:   invokespecial [56] 
L251:   ifnull L285 
L254:   aload_0 
L255:   invokespecial [56] 
L258:   sipush 10000 
L261:   ldc [23] 
L263:   aload_0 
L264:   getfield [37] 
L267:   invokevirtual [41] 
L270:   aload_2 
L271:   invokevirtual [42] 
L274:   aload 4 
L276:   invokevirtual [41] 
L279:   invokevirtual [50] 
L282:   goto L346 
L285:   getstatic [8] 
L288:   new [70] 
L291:   dup 
L292:   invokespecial [57] 
L295:   ldc [10] 
L297:   invokevirtual [44] 
L300:   aload_0 
L301:   getfield [37] 
L304:   invokevirtual [41] 
L307:   invokevirtual [44] 
L310:   ldc [11] 
L312:   invokevirtual [44] 
L315:   aload_2 
L316:   invokevirtual [42] 
L319:   invokevirtual [44] 
L322:   ldc [24] 
L324:   invokevirtual [44] 
L327:   aload 4 
L329:   invokevirtual [41] 
L332:   invokevirtual [44] 
L335:   ldc [13] 
L337:   invokevirtual [44] 
L340:   invokevirtual [45] 
L343:   invokevirtual [46] 
L346:   aconst_null 
L347:   areturn 
L348:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [77] 
.const [3] = Class [78] 
.const [4] = Class [79] 
.const [5] = Method [80] [81] 
.const [6] = Class [82] 
.const [7] = String [83] 
.const [8] = Field [84] [85] 
.const [9] = Class [86] 
.const [10] = String [87] 
.const [11] = String [88] 
.const [12] = String [89] 
.const [13] = String [90] 
.const [14] = Field [91] [92] 
.const [15] = Class [93] 
.const [16] = Field [94] [95] 
.const [17] = Class [96] 
.const [18] = Field [97] [98] 
.const [19] = Class [99] 
.const [20] = Field [100] [101] 
.const [21] = Field [102] [103] 
.const [22] = Method [104] [105] 
.const [23] = String [106] 
.const [24] = String [107] 
.const [25] = Class [108] 
.const [26] = Class [109] 
.const [27] = Class [110] 
.const [28] = Class [111] 
.const [29] = Class [112] 
.const [30] = Class [113] 
.const [31] = Class [114] 
.const [32] = Class [115] 
.const [33] = Field [116] [117] 
.const [34] = Field [118] [119] 
.const [35] = Field [120] [121] 
.const [36] = Field [122] [123] 
.const [37] = Field [124] [125] 
.const [38] = Method [126] [127] 
.const [39] = Field [128] [129] 
.const [40] = Method [130] [131] 
.const [41] = Method [132] [133] 
.const [42] = Method [134] [135] 
.const [43] = Method [136] [137] 
.const [44] = Method [138] [139] 
.const [45] = Method [140] [141] 
.const [46] = Method [142] [143] 
.const [47] = Method [144] [145] 
.const [48] = Method [146] [147] 
.const [49] = Method [148] [149] 
.const [50] = Method [150] [151] 
.const [51] = Method [152] [153] 
.const [52] = Method [154] [155] 
.const [53] = Method [156] [157] 
.const [54] = Method [158] [159] 
.const [55] = Method [160] [161] 
.const [56] = Method [162] [163] 
.const [57] = Method [164] [165] 
.const [58] = Method [166] [167] 
.const [59] = Method [168] [169] 
.const [60] = Method [170] [171] 
.const [61] = Class [172] 
.const [62] = Field [173] [174] 
.const [63] = Field [175] [176] 
.const [64] = Class [177] 
.const [65] = Field [178] [179] 
.const [66] = Field [180] [181] 
.const [67] = Field [182] [183] 
.const [68] = Field [184] [185] 
.const [69] = Class [186] 
.const [70] = Class [187] 
.const [71] = Class [188] 
.const [72] = Class [189] 
.const [73] = Class [190] 
.const [74] = InterfaceMethod [191] [192] 
.const [75] = InterfaceMethod [193] [194] 
.const [76] = InterfaceMethod [195] [196] 
.const [77] = Utf8 de/audi/tghu/navi/app/map/utils/NullFactory 
.const [78] = Utf8 java/util/HashMap 
.const [79] = Utf8 java/lang/Class 
.const [80] = Class [197] 
.const [81] = NameAndType [198] [199] 
.const [82] = Utf8 de/audi/tghu/navi/app/map/utils/NullFactoryException 
.const [83] = Utf8 '%1#%2() - unexpected call' 
.const [84] = Class [200] 
.const [85] = NameAndType [201] [202] 
.const [86] = Utf8 java/lang/StringBuffer 
.const [87] = Utf8 'ERROR: ' 
.const [88] = Utf8 '#' 
.const [89] = Utf8 ' unexpected call [' 
.const [90] = Utf8 ']' 
.const [91] = Class [203] 
.const [92] = NameAndType [204] [205] 
.const [93] = Utf8 java/lang/Integer 
.const [94] = Class [206] 
.const [95] = NameAndType [207] [208] 
.const [96] = Utf8 java/lang/Long 
.const [97] = Class [209] 
.const [98] = NameAndType [210] [211] 
.const [99] = Utf8 java/lang/Float 
.const [100] = Class [212] 
.const [101] = NameAndType [213] [214] 
.const [102] = Class [215] 
.const [103] = NameAndType [216] [217] 
.const [104] = Class [218] 
.const [105] = NameAndType [219] [220] 
.const [106] = Utf8 '%1#%2() - can not fake %3' 
.const [107] = Utf8 ' can not fake [' 
.const [108] = Utf8 java/lang/Object 
.const [109] = Utf8 java/lang/reflect/Proxy 
.const [110] = Utf8 java/lang/reflect/Method 
.const [111] = Utf8 de/audi/atip/log/LogChannel 
.const [112] = Utf8 java/lang/System 
.const [113] = Utf8 java/io/PrintStream 
.const [114] = Utf8 java/lang/Boolean 
.const [115] = Utf8 java/util/Map 
.const [116] = Class [221] 
.const [117] = NameAndType [222] [223] 
.const [118] = Class [224] 
.const [119] = NameAndType [225] [226] 
.const [120] = Class [227] 
.const [121] = NameAndType [228] [229] 
.const [122] = Class [230] 
.const [123] = NameAndType [231] [232] 
.const [124] = Class [233] 
.const [125] = NameAndType [234] [235] 
.const [126] = Class [236] 
.const [127] = NameAndType [237] [238] 
.const [128] = Class [239] 
.const [129] = NameAndType [240] [241] 
.const [130] = Class [242] 
.const [131] = NameAndType [243] [244] 
.const [132] = Class [245] 
.const [133] = NameAndType [246] [247] 
.const [134] = Class [248] 
.const [135] = NameAndType [249] [250] 
.const [136] = Class [251] 
.const [137] = NameAndType [252] [253] 
.const [138] = Class [254] 
.const [139] = NameAndType [255] [256] 
.const [140] = Class [257] 
.const [141] = NameAndType [258] [259] 
.const [142] = Class [260] 
.const [143] = NameAndType [261] [262] 
.const [144] = Class [263] 
.const [145] = NameAndType [264] [265] 
.const [146] = Class [266] 
.const [147] = NameAndType [267] [268] 
.const [148] = Class [269] 
.const [149] = NameAndType [270] [271] 
.const [150] = Class [272] 
.const [151] = NameAndType [273] [274] 
.const [152] = Class [275] 
.const [153] = NameAndType [276] [277] 
.const [154] = Class [278] 
.const [155] = NameAndType [279] [280] 
.const [156] = Class [281] 
.const [157] = NameAndType [282] [283] 
.const [158] = Class [284] 
.const [159] = NameAndType [285] [286] 
.const [160] = Class [287] 
.const [161] = NameAndType [288] [289] 
.const [162] = Class [290] 
.const [163] = NameAndType [291] [292] 
.const [164] = Class [293] 
.const [165] = NameAndType [294] [295] 
.const [166] = Class [296] 
.const [167] = NameAndType [297] [298] 
.const [168] = Class [299] 
.const [169] = NameAndType [300] [301] 
.const [170] = Class [302] 
.const [171] = NameAndType [303] [304] 
.const [172] = Utf8 de/audi/tghu/navi/app/map/utils/NullFactory 
.const [173] = Class [305] 
.const [174] = NameAndType [306] [307] 
.const [175] = Class [308] 
.const [176] = NameAndType [309] [310] 
.const [177] = Utf8 java/util/HashMap 
.const [178] = Class [311] 
.const [179] = NameAndType [312] [313] 
.const [180] = Class [314] 
.const [181] = NameAndType [315] [316] 
.const [182] = Class [317] 
.const [183] = NameAndType [318] [319] 
.const [184] = Class [320] 
.const [185] = NameAndType [321] [322] 
.const [186] = Utf8 de/audi/tghu/navi/app/map/utils/NullFactoryException 
.const [187] = Utf8 java/lang/StringBuffer 
.const [188] = Utf8 java/lang/Integer 
.const [189] = Utf8 java/lang/Long 
.const [190] = Utf8 java/lang/Float 
.const [191] = Class [323] 
.const [192] = NameAndType [324] [325] 
.const [193] = Class [326] 
.const [194] = NameAndType [327] [328] 
.const [195] = Class [329] 
.const [196] = NameAndType [330] [331] 
.const [197] = Utf8 java/lang/reflect/Proxy 
.const [198] = Utf8 newProxyInstance 
.const [199] = Utf8 (Ljava/lang/ClassLoader;[Ljava/lang/Class;Ljava/lang/reflect/InvocationHandler;)Ljava/lang/Object; 
.const [200] = Utf8 java/lang/System 
.const [201] = Utf8 out 
.const [202] = Utf8 Ljava/io/PrintStream; 
.const [203] = Utf8 java/lang/Integer 
.const [204] = Utf8 TYPE 
.const [205] = Utf8 Ljava/lang/Class; 
.const [206] = Utf8 java/lang/Long 
.const [207] = Utf8 TYPE 
.const [208] = Utf8 Ljava/lang/Class; 
.const [209] = Utf8 java/lang/Float 
.const [210] = Utf8 TYPE 
.const [211] = Utf8 Ljava/lang/Class; 
.const [212] = Utf8 java/lang/Boolean 
.const [213] = Utf8 TYPE 
.const [214] = Utf8 Ljava/lang/Class; 
.const [215] = Utf8 java/lang/Boolean 
.const [216] = Utf8 FALSE 
.const [217] = Utf8 Ljava/lang/Boolean; 
.const [218] = Utf8 de/audi/tghu/navi/app/map/utils/NullFactory 
.const [219] = Utf8 create 
.const [220] = Utf8 (Ljava/lang/Class;Lde/audi/atip/log/LogChannel;Ljava/lang/String;)Ljava/lang/Object; 
.const [221] = Utf8 de/audi/tghu/navi/app/map/utils/NullFactory 
.const [222] = Utf8 name 
.const [223] = Utf8 Ljava/lang/String; 
.const [224] = Utf8 de/audi/tghu/navi/app/map/utils/NullFactory 
.const [225] = Utf8 printTrace 
.const [226] = Utf8 Z 
.const [227] = Utf8 de/audi/tghu/navi/app/map/utils/NullFactory 
.const [228] = Utf8 clzMap 
.const [229] = Utf8 Ljava/util/Map; 
.const [230] = Utf8 de/audi/tghu/navi/app/map/utils/NullFactory 
.const [231] = Utf8 logger 
.const [232] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [233] = Utf8 de/audi/tghu/navi/app/map/utils/NullFactory 
.const [234] = Utf8 clazz 
.const [235] = Utf8 Ljava/lang/Class; 
.const [236] = Utf8 java/lang/Class 
.const [237] = Utf8 getClassLoader 
.const [238] = Utf8 ()Ljava/lang/ClassLoader; 
.const [239] = Utf8 de/audi/tghu/navi/app/map/utils/NullFactory 
.const [240] = Utf8 obj 
.const [241] = Utf8 Ljava/lang/Object; 
.const [242] = Utf8 de/audi/tghu/navi/app/map/utils/NullFactoryException 
.const [243] = Utf8 printStackTrace 
.const [244] = Utf8 ()V 
.const [245] = Utf8 java/lang/Class 
.const [246] = Utf8 getName 
.const [247] = Utf8 ()Ljava/lang/String; 
.const [248] = Utf8 java/lang/reflect/Method 
.const [249] = Utf8 getName 
.const [250] = Utf8 ()Ljava/lang/String; 
.const [251] = Utf8 de/audi/atip/log/LogChannel 
.const [252] = Utf8 log 
.const [253] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [254] = Utf8 java/lang/StringBuffer 
.const [255] = Utf8 append 
.const [256] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [257] = Utf8 java/lang/StringBuffer 
.const [258] = Utf8 toString 
.const [259] = Utf8 ()Ljava/lang/String; 
.const [260] = Utf8 java/io/PrintStream 
.const [261] = Utf8 println 
.const [262] = Utf8 (Ljava/lang/String;)V 
.const [263] = Utf8 java/lang/reflect/Method 
.const [264] = Utf8 getReturnType 
.const [265] = Utf8 ()Ljava/lang/Class; 
.const [266] = Utf8 java/lang/Class 
.const [267] = Utf8 isPrimitive 
.const [268] = Utf8 ()Z 
.const [269] = Utf8 java/lang/Class 
.const [270] = Utf8 isInterface 
.const [271] = Utf8 ()Z 
.const [272] = Utf8 de/audi/atip/log/LogChannel 
.const [273] = Utf8 log 
.const [274] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [275] = Utf8 de/audi/tghu/navi/app/map/utils/NullFactory 
.const [276] = Utf8 <init> 
.const [277] = Utf8 (Ljava/lang/Class;Lde/audi/atip/log/LogChannel;Ljava/lang/String;Z)V 
.const [278] = Utf8 de/audi/tghu/navi/app/map/utils/NullFactory 
.const [279] = Utf8 getProxy 
.const [280] = Utf8 ()Ljava/lang/Object; 
.const [281] = Utf8 java/lang/Object 
.const [282] = Utf8 <init> 
.const [283] = Utf8 ()V 
.const [284] = Utf8 java/util/HashMap 
.const [285] = Utf8 <init> 
.const [286] = Utf8 ()V 
.const [287] = Utf8 de/audi/tghu/navi/app/map/utils/NullFactoryException 
.const [288] = Utf8 <init> 
.const [289] = Utf8 ()V 
.const [290] = Utf8 de/audi/tghu/navi/app/map/utils/NullFactory 
.const [291] = Utf8 getLogger 
.const [292] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [293] = Utf8 java/lang/StringBuffer 
.const [294] = Utf8 <init> 
.const [295] = Utf8 ()V 
.const [296] = Utf8 java/lang/Integer 
.const [297] = Utf8 <init> 
.const [298] = Utf8 (I)V 
.const [299] = Utf8 java/lang/Long 
.const [300] = Utf8 <init> 
.const [301] = Utf8 (J)V 
.const [302] = Utf8 java/lang/Float 
.const [303] = Utf8 <init> 
.const [304] = Utf8 (F)V 
.const [305] = Utf8 de/audi/tghu/navi/app/map/utils/NullFactory 
.const [306] = Utf8 name 
.const [307] = Utf8 Ljava/lang/String; 
.const [308] = Utf8 de/audi/tghu/navi/app/map/utils/NullFactory 
.const [309] = Utf8 printTrace 
.const [310] = Utf8 Z 
.const [311] = Utf8 de/audi/tghu/navi/app/map/utils/NullFactory 
.const [312] = Utf8 clzMap 
.const [313] = Utf8 Ljava/util/Map; 
.const [314] = Utf8 de/audi/tghu/navi/app/map/utils/NullFactory 
.const [315] = Utf8 logger 
.const [316] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [317] = Utf8 de/audi/tghu/navi/app/map/utils/NullFactory 
.const [318] = Utf8 clazz 
.const [319] = Utf8 Ljava/lang/Class; 
.const [320] = Utf8 de/audi/tghu/navi/app/map/utils/NullFactory 
.const [321] = Utf8 obj 
.const [322] = Utf8 Ljava/lang/Object; 
.const [323] = Utf8 java/util/Map 
.const [324] = Utf8 containsKey 
.const [325] = Utf8 (Ljava/lang/Object;)Z 
.const [326] = Utf8 java/util/Map 
.const [327] = Utf8 put 
.const [328] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 
.const [329] = Utf8 java/util/Map 
.const [330] = Utf8 get 
.const [331] = Utf8 (Ljava/lang/Object;)Ljava/lang/Object; 
.const [332] = Utf8 de/audi/tghu/navi/app/map/utils/NullFactory 
.const [333] = Class [332] 
.const [334] = Utf8 java/lang/Object 
.const [335] = Class [334] 
.const [336] = Utf8 java/lang/reflect/InvocationHandler 
.const [337] = Class [336] 
.const [338] = Utf8 logger 
.const [339] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [340] = Utf8 obj 
.const [341] = Utf8 Ljava/lang/Object; 
.const [342] = Utf8 clazz 
.const [343] = Utf8 Ljava/lang/Class; 
.const [344] = Utf8 name 
.const [345] = Utf8 Ljava/lang/String; 
.const [346] = Utf8 printTrace 
.const [347] = Utf8 Z 
.const [348] = Utf8 clzMap 
.const [349] = Utf8 Ljava/util/Map; 
.const [350] = Utf8 Code 
.const [351] = Utf8 create 
.const [352] = Utf8 (Ljava/lang/Class;Lde/audi/atip/log/LogChannel;Ljava/lang/String;)Ljava/lang/Object; 
.const [353] = Utf8 create 
.const [354] = Utf8 (Ljava/lang/Class;Lde/audi/atip/log/LogChannel;Ljava/lang/String;Z)Ljava/lang/Object; 
.const [355] = Utf8 <init> 
.const [356] = Utf8 (Ljava/lang/Class;Lde/audi/atip/log/LogChannel;Ljava/lang/String;Z)V 
.const [357] = Utf8 getProxy 
.const [358] = Utf8 ()Ljava/lang/Object; 
.const [359] = Utf8 getLogger 
.const [360] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [361] = Utf8 invoke 
.const [362] = Utf8 (Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object; 
.end class 
