.version 50 0 
.class public super [303] 
.super [305] 
.field private static final [306] [307] 
.field private final [308] [309] 

.method public [311] : [312] 
    .attribute [310] .code stack 4 locals 0 
L0:     aload_0 
L1:     invokespecial [42] 
L4:     aload_0 
L5:     new [50] 
L8:     dup 
L9:     iconst_5 
L10:    invokespecial [43] 
L13:    putfield [51] 
L16:    return 
L17:    nop 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [313] : [314] 
    .attribute [310] .code stack 2 locals 0 
L0:     aload_1 
L1:     ifnull L13 
L4:     aload_1 
L5:     invokeinterface [52] 0 
L10:    ifeq L14 
L13:    return 
L14:    aload_0 
L15:    aload_1 
L16:    invokespecial [44] 
L19:    return 
L20:    
    .end code 
.end method 

.method private [315] : [316] 
    .attribute [310] .code stack 4 locals 5 
L0:     aload_0 
L1:     getfield [28] 
L4:     invokevirtual [29] 
L7:     aload_1 
L8:     invokeinterface [53] 0 
L13:    istore_2 
L14:    iconst_0 
L15:    istore_3 
L16:    iload_3 
L17:    iload_2 
L18:    if_icmpge L96 
L21:    aload_1 
L22:    iload_3 
L23:    invokeinterface [54] 0 
L28:    checkcast [3] 
L31:    astore 4 
L33:    iconst_0 
L34:    istore 5 
L36:    aload 4 
L38:    invokestatic [4] 
L41:    ifeq L79 
L44:    aconst_null 
L45:    astore 6 
L47:    iload_3 
L48:    iconst_1 
L49:    iadd 
L50:    iload_2 
L51:    if_icmpge L68 
L54:    aload_1 
L55:    iload_3 
L56:    iconst_1 
L57:    iadd 
L58:    invokeinterface [54] 0 
L63:    checkcast [3] 
L66:    astore 6 
L68:    aload_0 
L69:    aload_1 
L70:    aload 4 
L72:    aload 6 
L74:    invokespecial [45] 
L77:    istore 5 
L79:    iload 5 
L81:    ifeq L90 
L84:    iinc 3 2 
L87:    goto L93 
L90:    iinc 3 1 
L93:    goto L16 
L96:    aload_0 
L97:    getfield [28] 
L100:   invokevirtual [30] 
L103:   ifne L111 
L106:   aload_0 
L107:   aload_1 
L108:   invokespecial [46] 
L111:   return 
L112:   
    .end code 
.end method 

.method private [317] : [318] 
    .attribute [310] .code stack 4 locals 8 
L0:     aload_0 
L1:     getfield [28] 
L4:     invokevirtual [31] 
L7:     invokeinterface [56] 0 
L12:    astore_2 
L13:    aload_2 
L14:    invokeinterface [57] 0 
L19:    ifeq L222 
L22:    aload_2 
L23:    invokeinterface [58] 0 
L28:    checkcast [5] 
L31:    astore_3 
L32:    aload_0 
L33:    getfield [28] 
L36:    aload_3 
L37:    invokevirtual [32] 
L40:    checkcast [6] 
L43:    astore 4 
L45:    aconst_null 
L46:    aload 4 
L48:    if_acmpeq L219 
L51:    aload 4 
L53:    invokeinterface [52] 0 
L58:    ifne L219 
L61:    iconst_0 
L62:    istore 5 
L64:    iload 5 
L66:    aload 4 
L68:    invokeinterface [53] 0 
L73:    if_icmpge L219 
L76:    aload 4 
L78:    iload 5 
L80:    invokeinterface [54] 0 
L85:    checkcast [3] 
L88:    astore 6 
L90:    aload 6 
L92:    invokevirtual [33] 
L95:    invokestatic [7] 
L98:    astore 7 
L100:   aload_1 
L101:   aload 6 
L103:   invokeinterface [59] 0 
L108:   istore 8 
L110:   new [55] 
L113:   dup 
L114:   aload_3 
L115:   iconst_0 
L116:   invokevirtual [34] 
L119:   aload 6 
L121:   invokevirtual [35] 
L124:   invokespecial [47] 
L127:   astore 9 
L129:   iload 8 
L131:   iconst_4 
L132:   if_icmpne L143 
L135:   aload_1 
L136:   iconst_3 
L137:   invokeinterface [60] 0 
L142:   pop 
L143:   aload 7 
L145:   invokestatic [8] 
L148:   ifeq L172 
L151:   aload_1 
L152:   aload_1 
L153:   aload 6 
L155:   invokeinterface [59] 0 
L160:   iconst_1 
L161:   iadd 
L162:   aload 9 
L164:   invokeinterface [61] 0 
L169:   goto L213 
L172:   aload 7 
L174:   invokestatic [9] 
L177:   ifeq L199 
L180:   aload_1 
L181:   aload_1 
L182:   aload 6 
L184:   invokeinterface [59] 0 
L189:   aload 9 
L191:   invokeinterface [61] 0 
L196:   goto L213 
L199:   getstatic [10] 
L202:   sipush 10000 
L205:   ldc [11] 
L207:   aload 7 
L209:   invokevirtual [36] 
L212:   pop 
L213:   iinc 5 1 
L216:   goto L64 
L219:   goto L13 
L222:   return 
L223:   nop 
L224:   
    .end code 
.end method 

.method private static [319] : [320] 
    .attribute [310] .code stack 1 locals 1 
L0:     aload_0 
L1:     invokevirtual [33] 
L4:     invokestatic [7] 
L7:     astore_1 
L8:     aload_1 
L9:     invokestatic [12] 
L12:    areturn 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method private [321] : [322] 
    .attribute [310] .code stack 3 locals 0 
L0:     aconst_null 
L1:     aload_3 
L2:     if_acmpne L13 
L5:     aload_0 
L6:     aload_2 
L7:     invokespecial [48] 
L10:    goto L49 
L13:    aload_3 
L14:    invokestatic [4] 
L17:    ifeq L44 
L20:    aload_2 
L21:    aload_3 
L22:    invokestatic [13] 
L25:    ifeq L36 
L28:    aload_1 
L29:    aload_2 
L30:    aload_3 
L31:    invokestatic [14] 
L34:    iconst_1 
L35:    areturn 
L36:    aload_0 
L37:    aload_2 
L38:    invokespecial [48] 
L41:    goto L49 
L44:    aload_0 
L45:    aload_2 
L46:    invokespecial [48] 
L49:    iconst_0 
L50:    areturn 
L51:    nop 
L52:    
    .end code 
.end method 

.method private [323] : [324] 
    .attribute [310] .code stack 3 locals 3 
L0:     aload_1 
L1:     invokevirtual [33] 
L4:     invokestatic [7] 
L7:     astore_2 
L8:     aconst_null 
L9:     astore_3 
L10:    aload_0 
L11:    getfield [28] 
L14:    aload_2 
L15:    invokevirtual [37] 
L18:    ifeq L70 
L21:    aload_0 
L22:    getfield [28] 
L25:    aload_2 
L26:    invokevirtual [32] 
L29:    checkcast [6] 
L32:    astore_3 
L33:    aconst_null 
L34:    aload_3 
L35:    if_acmpeq L58 
L38:    aload_3 
L39:    invokeinterface [52] 0 
L44:    ifne L58 
L47:    aload_3 
L48:    iconst_0 
L49:    invokeinterface [60] 0 
L54:    pop 
L55:    goto L121 
L58:    aload_0 
L59:    getfield [28] 
L62:    aload_2 
L63:    invokevirtual [38] 
L66:    pop 
L67:    goto L121 
L70:    aload_2 
L71:    invokestatic [15] 
L74:    astore 4 
L76:    aload_0 
L77:    getfield [28] 
L80:    aload 4 
L82:    invokevirtual [32] 
L85:    checkcast [6] 
L88:    astore_3 
L89:    aconst_null 
L90:    aload_3 
L91:    if_acmpne L113 
L94:    new [62] 
L97:    dup 
L98:    invokespecial [49] 
L101:   astore_3 
L102:   aload_0 
L103:   getfield [28] 
L106:   aload 4 
L108:   aload_3 
L109:   invokevirtual [39] 
L112:   pop 
L113:   aload_3 
L114:   aload_1 
L115:   invokeinterface [63] 0 
L120:   pop 
L121:   return 
L122:   nop 
L123:   nop 
L124:   
    .end code 
.end method 

.method private static [325] : [326] 
    .attribute [310] .code stack 2 locals 1 
L0:     aload_0 
L1:     invokevirtual [35] 
L4:     istore_2 
L5:     aload_0 
L6:     aload_1 
L7:     invokevirtual [35] 
L10:    invokevirtual [40] 
L13:    aload_1 
L14:    iload_2 
L15:    invokevirtual [40] 
L18:    return 
L19:    nop 
L20:    
    .end code 
.end method 

.method private static [327] : [328] 
    .attribute [310] .code stack 2 locals 2 
L0:     aload_0 
L1:     invokevirtual [33] 
L4:     invokestatic [7] 
L7:     astore_2 
L8:     aload_1 
L9:     invokevirtual [33] 
L12:    invokestatic [7] 
L15:    astore_3 
L16:    aload_3 
L17:    aload_2 
L18:    invokestatic [15] 
L21:    invokevirtual [41] 
L24:    areturn 
L25:    nop 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method private static [329] : [330] 
    .attribute [310] .code stack 4 locals 1 
L0:     aload_1 
L1:     invokevirtual [33] 
L4:     invokestatic [7] 
L7:     astore_3 
L8:     aload_3 
L9:     invokestatic [8] 
L12:    ifne L38 
L15:    aload_1 
L16:    aload_2 
L17:    invokestatic [17] 
L20:    aload_0 
L21:    aload_0 
L22:    aload_1 
L23:    invokeinterface [59] 0 
L28:    aload_0 
L29:    aload_2 
L30:    invokeinterface [59] 0 
L35:    invokestatic [18] 
L38:    return 
L39:    nop 
L40:    
    .end code 
.end method 

.method public [331] : [332] 
    .attribute [310] .code stack 1 locals 0 
L0:     ldc [19] 
L2:     areturn 
L3:     nop 
L4:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [64] 
.const [3] = Class [65] 
.const [4] = Method [66] [67] 
.const [5] = Class [68] 
.const [6] = Class [69] 
.const [7] = Method [70] [71] 
.const [8] = Method [72] [73] 
.const [9] = Method [74] [75] 
.const [10] = Field [76] [77] 
.const [11] = String [78] 
.const [12] = Method [79] [80] 
.const [13] = Method [81] [82] 
.const [14] = Method [83] [84] 
.const [15] = Method [85] [86] 
.const [16] = Class [87] 
.const [17] = Method [88] [89] 
.const [18] = Method [90] [91] 
.const [19] = String [92] 
.const [20] = Class [93] 
.const [21] = Class [94] 
.const [22] = Class [95] 
.const [23] = Class [96] 
.const [24] = Class [97] 
.const [25] = Class [98] 
.const [26] = Class [99] 
.const [27] = Class [100] 
.const [28] = Field [101] [102] 
.const [29] = Method [103] [104] 
.const [30] = Method [105] [106] 
.const [31] = Method [107] [108] 
.const [32] = Method [109] [110] 
.const [33] = Method [111] [112] 
.const [34] = Method [113] [114] 
.const [35] = Method [115] [116] 
.const [36] = Method [117] [118] 
.const [37] = Method [119] [120] 
.const [38] = Method [121] [122] 
.const [39] = Method [123] [124] 
.const [40] = Method [125] [126] 
.const [41] = Method [127] [128] 
.const [42] = Method [129] [130] 
.const [43] = Method [131] [132] 
.const [44] = Method [133] [134] 
.const [45] = Method [135] [136] 
.const [46] = Method [137] [138] 
.const [47] = Method [139] [140] 
.const [48] = Method [141] [142] 
.const [49] = Method [143] [144] 
.const [50] = Class [145] 
.const [51] = Field [146] [147] 
.const [52] = InterfaceMethod [148] [149] 
.const [53] = InterfaceMethod [150] [151] 
.const [54] = InterfaceMethod [152] [153] 
.const [55] = Class [154] 
.const [56] = InterfaceMethod [155] [156] 
.const [57] = InterfaceMethod [157] [158] 
.const [58] = InterfaceMethod [159] [160] 
.const [59] = InterfaceMethod [161] [162] 
.const [60] = InterfaceMethod [163] [164] 
.const [61] = InterfaceMethod [165] [166] 
.const [62] = Class [167] 
.const [63] = InterfaceMethod [168] [169] 
.const [64] = Utf8 java/util/HashMap 
.const [65] = Utf8 de/esolutions/hmi/widgets/audi/evo/prpframework/RecognizerResult 
.const [66] = Class [170] 
.const [67] = NameAndType [171] [172] 
.const [68] = Utf8 java/lang/String 
.const [69] = Utf8 java/util/List 
.const [70] = Class [173] 
.const [71] = NameAndType [174] [175] 
.const [72] = Class [176] 
.const [73] = NameAndType [177] [178] 
.const [74] = Class [179] 
.const [75] = NameAndType [180] [181] 
.const [76] = Class [182] 
.const [77] = NameAndType [183] [184] 
.const [78] = Utf8 'CompletionCounterpartLowCapitalCaseJPRule#checkCounterpart: No Confirm of Low or Capital Case letter for the character %1' 
.const [79] = Class [185] 
.const [80] = NameAndType [186] [187] 
.const [81] = Class [188] 
.const [82] = NameAndType [189] [190] 
.const [83] = Class [191] 
.const [84] = NameAndType [192] [193] 
.const [85] = Class [194] 
.const [86] = NameAndType [195] [196] 
.const [87] = Utf8 java/util/ArrayList 
.const [88] = Class [197] 
.const [89] = NameAndType [198] [199] 
.const [90] = Class [200] 
.const [91] = NameAndType [201] [202] 
.const [92] = Utf8 'Upper Lower Case Handling Rule(JP)' 
.const [93] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/asia/prpframework/UpperLowerCaseHandlingJPRule 
.const [94] = Utf8 de/esolutions/hmi/widgets/audi/evo/prpframework/AbstractPRPRule 
.const [95] = Utf8 java/util/Set 
.const [96] = Utf8 java/util/Iterator 
.const [97] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/asia/AbstractToneAndCaseTogglingTable 
.const [98] = Utf8 de/esolutions/hmi/widgets/audi/base/IWidgetLogChannel 
.const [99] = Utf8 de/audi/atip/log/LogChannel 
.const [100] = Utf8 java/util/Collections 
.const [101] = Class [203] 
.const [102] = NameAndType [204] [205] 
.const [103] = Class [206] 
.const [104] = NameAndType [207] [208] 
.const [105] = Class [209] 
.const [106] = NameAndType [210] [211] 
.const [107] = Class [212] 
.const [108] = NameAndType [213] [214] 
.const [109] = Class [215] 
.const [110] = NameAndType [216] [217] 
.const [111] = Class [218] 
.const [112] = NameAndType [219] [220] 
.const [113] = Class [221] 
.const [114] = NameAndType [222] [223] 
.const [115] = Class [224] 
.const [116] = NameAndType [225] [226] 
.const [117] = Class [227] 
.const [118] = NameAndType [228] [229] 
.const [119] = Class [230] 
.const [120] = NameAndType [231] [232] 
.const [121] = Class [233] 
.const [122] = NameAndType [234] [235] 
.const [123] = Class [236] 
.const [124] = NameAndType [237] [238] 
.const [125] = Class [239] 
.const [126] = NameAndType [240] [241] 
.const [127] = Class [242] 
.const [128] = NameAndType [243] [244] 
.const [129] = Class [245] 
.const [130] = NameAndType [246] [247] 
.const [131] = Class [248] 
.const [132] = NameAndType [249] [250] 
.const [133] = Class [251] 
.const [134] = NameAndType [252] [253] 
.const [135] = Class [254] 
.const [136] = NameAndType [255] [256] 
.const [137] = Class [257] 
.const [138] = NameAndType [258] [259] 
.const [139] = Class [260] 
.const [140] = NameAndType [261] [262] 
.const [141] = Class [263] 
.const [142] = NameAndType [264] [265] 
.const [143] = Class [266] 
.const [144] = NameAndType [267] [268] 
.const [145] = Utf8 java/util/HashMap 
.const [146] = Class [269] 
.const [147] = NameAndType [270] [271] 
.const [148] = Class [272] 
.const [149] = NameAndType [273] [274] 
.const [150] = Class [275] 
.const [151] = NameAndType [276] [277] 
.const [152] = Class [278] 
.const [153] = NameAndType [279] [280] 
.const [154] = Utf8 de/esolutions/hmi/widgets/audi/evo/prpframework/RecognizerResult 
.const [155] = Class [281] 
.const [156] = NameAndType [282] [283] 
.const [157] = Class [284] 
.const [158] = NameAndType [285] [286] 
.const [159] = Class [287] 
.const [160] = NameAndType [288] [289] 
.const [161] = Class [290] 
.const [162] = NameAndType [291] [292] 
.const [163] = Class [293] 
.const [164] = NameAndType [294] [295] 
.const [165] = Class [296] 
.const [166] = NameAndType [297] [298] 
.const [167] = Utf8 java/util/ArrayList 
.const [168] = Class [299] 
.const [169] = NameAndType [300] [301] 
.const [170] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/asia/prpframework/UpperLowerCaseHandlingJPRule 
.const [171] = Utf8 hasCaseVariant 
.const [172] = Utf8 (Lde/esolutions/hmi/widgets/audi/evo/prpframework/RecognizerResult;)Z 
.const [173] = Utf8 java/lang/String 
.const [174] = Utf8 valueOf 
.const [175] = Utf8 (C)Ljava/lang/String; 
.const [176] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/asia/AbstractToneAndCaseTogglingTable 
.const [177] = Utf8 isCapitalCase 
.const [178] = Utf8 (Ljava/lang/String;)Z 
.const [179] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/asia/AbstractToneAndCaseTogglingTable 
.const [180] = Utf8 isLowCase 
.const [181] = Utf8 (Ljava/lang/String;)Z 
.const [182] = Utf8 de/esolutions/hmi/widgets/audi/base/IWidgetLogChannel 
.const [183] = Utf8 spellerLogChannel 
.const [184] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [185] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/asia/AbstractToneAndCaseTogglingTable 
.const [186] = Utf8 hasCaseVariance 
.const [187] = Utf8 (Ljava/lang/String;)Z 
.const [188] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/asia/prpframework/UpperLowerCaseHandlingJPRule 
.const [189] = Utf8 isInCaseVarianceGroup 
.const [190] = Utf8 (Lde/esolutions/hmi/widgets/audi/evo/prpframework/RecognizerResult;Lde/esolutions/hmi/widgets/audi/evo/prpframework/RecognizerResult;)Z 
.const [191] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/asia/prpframework/UpperLowerCaseHandlingJPRule 
.const [192] = Utf8 checkCaseSequence 
.const [193] = Utf8 (Ljava/util/List;Lde/esolutions/hmi/widgets/audi/evo/prpframework/RecognizerResult;Lde/esolutions/hmi/widgets/audi/evo/prpframework/RecognizerResult;)V 
.const [194] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/asia/AbstractToneAndCaseTogglingTable 
.const [195] = Utf8 getOppositeCaseCharacterAsString 
.const [196] = Utf8 (Ljava/lang/String;)Ljava/lang/String; 
.const [197] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/asia/prpframework/UpperLowerCaseHandlingJPRule 
.const [198] = Utf8 swapConfidence 
.const [199] = Utf8 (Lde/esolutions/hmi/widgets/audi/evo/prpframework/RecognizerResult;Lde/esolutions/hmi/widgets/audi/evo/prpframework/RecognizerResult;)V 
.const [200] = Utf8 java/util/Collections 
.const [201] = Utf8 swap 
.const [202] = Utf8 (Ljava/util/List;II)V 
.const [203] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/asia/prpframework/UpperLowerCaseHandlingJPRule 
.const [204] = Utf8 cachedCaseChars 
.const [205] = Utf8 Ljava/util/HashMap; 
.const [206] = Utf8 java/util/HashMap 
.const [207] = Utf8 clear 
.const [208] = Utf8 ()V 
.const [209] = Utf8 java/util/HashMap 
.const [210] = Utf8 isEmpty 
.const [211] = Utf8 ()Z 
.const [212] = Utf8 java/util/HashMap 
.const [213] = Utf8 keySet 
.const [214] = Utf8 ()Ljava/util/Set; 
.const [215] = Utf8 java/util/HashMap 
.const [216] = Utf8 get 
.const [217] = Utf8 (Ljava/lang/Object;)Ljava/lang/Object; 
.const [218] = Utf8 de/esolutions/hmi/widgets/audi/evo/prpframework/RecognizerResult 
.const [219] = Utf8 getCharacter 
.const [220] = Utf8 ()C 
.const [221] = Utf8 java/lang/String 
.const [222] = Utf8 charAt 
.const [223] = Utf8 (I)C 
.const [224] = Utf8 de/esolutions/hmi/widgets/audi/evo/prpframework/RecognizerResult 
.const [225] = Utf8 getConfidence 
.const [226] = Utf8 ()I 
.const [227] = Utf8 de/audi/atip/log/LogChannel 
.const [228] = Utf8 log 
.const [229] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [230] = Utf8 java/util/HashMap 
.const [231] = Utf8 containsKey 
.const [232] = Utf8 (Ljava/lang/Object;)Z 
.const [233] = Utf8 java/util/HashMap 
.const [234] = Utf8 remove 
.const [235] = Utf8 (Ljava/lang/Object;)Ljava/lang/Object; 
.const [236] = Utf8 java/util/HashMap 
.const [237] = Utf8 put 
.const [238] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 
.const [239] = Utf8 de/esolutions/hmi/widgets/audi/evo/prpframework/RecognizerResult 
.const [240] = Utf8 setConfidence 
.const [241] = Utf8 (I)V 
.const [242] = Utf8 java/lang/String 
.const [243] = Utf8 equals 
.const [244] = Utf8 (Ljava/lang/Object;)Z 
.const [245] = Utf8 de/esolutions/hmi/widgets/audi/evo/prpframework/AbstractPRPRule 
.const [246] = Utf8 <init> 
.const [247] = Utf8 ()V 
.const [248] = Utf8 java/util/HashMap 
.const [249] = Utf8 <init> 
.const [250] = Utf8 (I)V 
.const [251] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/asia/prpframework/UpperLowerCaseHandlingJPRule 
.const [252] = Utf8 checkCounterpart 
.const [253] = Utf8 (Ljava/util/List;)V 
.const [254] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/asia/prpframework/UpperLowerCaseHandlingJPRule 
.const [255] = Utf8 checkRecognizedCharacters 
.const [256] = Utf8 (Ljava/util/List;Lde/esolutions/hmi/widgets/audi/evo/prpframework/RecognizerResult;Lde/esolutions/hmi/widgets/audi/evo/prpframework/RecognizerResult;)Z 
.const [257] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/asia/prpframework/UpperLowerCaseHandlingJPRule 
.const [258] = Utf8 createTheMissingCase 
.const [259] = Utf8 (Ljava/util/List;)V 
.const [260] = Utf8 de/esolutions/hmi/widgets/audi/evo/prpframework/RecognizerResult 
.const [261] = Utf8 <init> 
.const [262] = Utf8 (CI)V 
.const [263] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/asia/prpframework/UpperLowerCaseHandlingJPRule 
.const [264] = Utf8 checkMissingCase 
.const [265] = Utf8 (Lde/esolutions/hmi/widgets/audi/evo/prpframework/RecognizerResult;)V 
.const [266] = Utf8 java/util/ArrayList 
.const [267] = Utf8 <init> 
.const [268] = Utf8 ()V 
.const [269] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/asia/prpframework/UpperLowerCaseHandlingJPRule 
.const [270] = Utf8 cachedCaseChars 
.const [271] = Utf8 Ljava/util/HashMap; 
.const [272] = Utf8 java/util/List 
.const [273] = Utf8 isEmpty 
.const [274] = Utf8 ()Z 
.const [275] = Utf8 java/util/List 
.const [276] = Utf8 size 
.const [277] = Utf8 ()I 
.const [278] = Utf8 java/util/List 
.const [279] = Utf8 get 
.const [280] = Utf8 (I)Ljava/lang/Object; 
.const [281] = Utf8 java/util/Set 
.const [282] = Utf8 iterator 
.const [283] = Utf8 ()Ljava/util/Iterator; 
.const [284] = Utf8 java/util/Iterator 
.const [285] = Utf8 hasNext 
.const [286] = Utf8 ()Z 
.const [287] = Utf8 java/util/Iterator 
.const [288] = Utf8 next 
.const [289] = Utf8 ()Ljava/lang/Object; 
.const [290] = Utf8 java/util/List 
.const [291] = Utf8 indexOf 
.const [292] = Utf8 (Ljava/lang/Object;)I 
.const [293] = Utf8 java/util/List 
.const [294] = Utf8 remove 
.const [295] = Utf8 (I)Ljava/lang/Object; 
.const [296] = Utf8 java/util/List 
.const [297] = Utf8 add 
.const [298] = Utf8 (ILjava/lang/Object;)V 
.const [299] = Utf8 java/util/List 
.const [300] = Utf8 add 
.const [301] = Utf8 (Ljava/lang/Object;)Z 
.const [302] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/asia/prpframework/UpperLowerCaseHandlingJPRule 
.const [303] = Class [302] 
.const [304] = Utf8 de/esolutions/hmi/widgets/audi/evo/prpframework/AbstractPRPRule 
.const [305] = Class [304] 
.const [306] = Utf8 MAX_ALTERNATIVE_LENGTH 
.const [307] = Utf8 I 
.const [308] = Utf8 cachedCaseChars 
.const [309] = Utf8 Ljava/util/HashMap; 
.const [310] = Utf8 Code 
.const [311] = Utf8 <init> 
.const [312] = Utf8 ()V 
.const [313] = Utf8 execute 
.const [314] = Utf8 (Ljava/util/List;Ljava/lang/Object;Z)V 
.const [315] = Utf8 checkCounterpart 
.const [316] = Utf8 (Ljava/util/List;)V 
.const [317] = Utf8 createTheMissingCase 
.const [318] = Utf8 (Ljava/util/List;)V 
.const [319] = Utf8 hasCaseVariant 
.const [320] = Utf8 (Lde/esolutions/hmi/widgets/audi/evo/prpframework/RecognizerResult;)Z 
.const [321] = Utf8 checkRecognizedCharacters 
.const [322] = Utf8 (Ljava/util/List;Lde/esolutions/hmi/widgets/audi/evo/prpframework/RecognizerResult;Lde/esolutions/hmi/widgets/audi/evo/prpframework/RecognizerResult;)Z 
.const [323] = Utf8 checkMissingCase 
.const [324] = Utf8 (Lde/esolutions/hmi/widgets/audi/evo/prpframework/RecognizerResult;)V 
.const [325] = Utf8 swapConfidence 
.const [326] = Utf8 (Lde/esolutions/hmi/widgets/audi/evo/prpframework/RecognizerResult;Lde/esolutions/hmi/widgets/audi/evo/prpframework/RecognizerResult;)V 
.const [327] = Utf8 isInCaseVarianceGroup 
.const [328] = Utf8 (Lde/esolutions/hmi/widgets/audi/evo/prpframework/RecognizerResult;Lde/esolutions/hmi/widgets/audi/evo/prpframework/RecognizerResult;)Z 
.const [329] = Utf8 checkCaseSequence 
.const [330] = Utf8 (Ljava/util/List;Lde/esolutions/hmi/widgets/audi/evo/prpframework/RecognizerResult;Lde/esolutions/hmi/widgets/audi/evo/prpframework/RecognizerResult;)V 
.const [331] = Utf8 getRuleName 
.const [332] = Utf8 ()Ljava/lang/String; 
.end class 
