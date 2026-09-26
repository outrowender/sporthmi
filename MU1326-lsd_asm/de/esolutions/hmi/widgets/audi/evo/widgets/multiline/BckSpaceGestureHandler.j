.version 50 0 
.class public super [272] 
.super [274] 
.field private [275] [276] 
.field private [277] [278] 
.field private [279] [280] 
.field private [281] [282] 
.field private [283] [284] 
.field private [285] [286] 
.field private [287] [288] 
.field private [289] [290] 
.field private [291] [292] 
.field private [293] [294] 
.field private [295] [296] 
.field private [297] [298] 

.method private [300] : [301] 
    .attribute [299] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [16] 
L4:     ifnull L45 
L7:     aload_0 
L8:     aload_0 
L9:     getfield [16] 
L12:    aload_0 
L13:    getfield [17] 
L16:    aload_0 
L17:    getfield [18] 
L20:    invokevirtual [19] 
L23:    putfield [36] 
L26:    aload_0 
L27:    aload_0 
L28:    getfield [16] 
L31:    aload_0 
L32:    getfield [17] 
L35:    aload_0 
L36:    getfield [20] 
L39:    invokevirtual [21] 
L42:    putfield [37] 
L45:    return 
L46:    nop 
L47:    nop 
L48:    
    .end code 
.end method 

.method public [302] : [303] 
    .attribute [299] .code stack 5 locals 0 
L0:     aload_0 
L1:     invokespecial [31] 
L4:     aload_0 
L5:     iload_1 
L6:     iconst_m1 
L7:     if_icmple L19 
L10:    iload_1 
L11:    iconst_3 
L12:    if_icmpge L19 
L15:    iload_1 
L16:    goto L20 
L19:    iconst_1 
L20:    putfield [35] 
L23:    aload_0 
L24:    aload_2 
L25:    putfield [38] 
L28:    aload_0 
L29:    invokestatic [2] 
L32:    putfield [34] 
L35:    aload_0 
L36:    getstatic [3] 
L39:    arraylength 
L40:    newarray float 
L42:    putfield [37] 
L45:    aload_0 
L46:    getstatic [4] 
L49:    arraylength 
L50:    newarray int 
L52:    putfield [36] 
L55:    aload_0 
L56:    getfield [16] 
L59:    ifnonnull L96 
L62:    getstatic [3] 
L65:    iconst_0 
L66:    aload_0 
L67:    getfield [18] 
L70:    iconst_0 
L71:    aload_0 
L72:    getfield [18] 
L75:    arraylength 
L76:    invokestatic [5] 
L79:    getstatic [4] 
L82:    iconst_0 
L83:    aload_0 
L84:    getfield [20] 
L87:    iconst_0 
L88:    aload_0 
L89:    getfield [20] 
L92:    arraylength 
L93:    invokestatic [5] 
L96:    return 
L97:    nop 
L98:    nop 
L99:    nop 
L100:   
    .end code 
.end method 

.method private [304] : [305] 
    .attribute [299] .code stack 4 locals 0 
L0:     iload_1 
L1:     ifeq L14 
L4:     iload_1 
L5:     aload_0 
L6:     getfield [18] 
L9:     iconst_0 
L10:    iaload 
L11:    if_icmple L27 
L14:    aload_0 
L15:    iconst_0 
L16:    putfield [39] 
L19:    aload_0 
L20:    iconst_1 
L21:    putfield [40] 
L24:    goto L194 
L27:    aload_0 
L28:    getfield [23] 
L31:    ifne L42 
L34:    aload_0 
L35:    iload_1 
L36:    putfield [39] 
L39:    goto L194 
L42:    iload_1 
L43:    aload_0 
L44:    getfield [23] 
L47:    if_icmpge L55 
L50:    aload_0 
L51:    iload_1 
L52:    putfield [39] 
L55:    aload_0 
L56:    iload_1 
L57:    i2f 
L58:    aload_0 
L59:    getfield [23] 
L62:    i2f 
L63:    fdiv 
L64:    putfield [41] 
L67:    aload_0 
L68:    getfield [25] 
L71:    aload_0 
L72:    getfield [20] 
L75:    iconst_0 
L76:    faload 
L77:    fcmpg 
L78:    ifgt L130 
L81:    aload_0 
L82:    getfield [23] 
L85:    aload_0 
L86:    getfield [18] 
L89:    iconst_1 
L90:    iaload 
L91:    if_icmpgt L130 
L94:    aload_0 
L95:    aload_0 
L96:    getfield [24] 
L99:    iconst_1 
L100:   iadd 
L101:   putfield [40] 
L104:   aload_0 
L105:   getfield [24] 
L108:   aload_0 
L109:   getfield [18] 
L112:   iconst_3 
L113:   iaload 
L114:   if_icmple L194 
L117:   aload_0 
L118:   aload_0 
L119:   getfield [18] 
L122:   iconst_3 
L123:   iaload 
L124:   putfield [40] 
L127:   goto L194 
L130:   aload_0 
L131:   getfield [25] 
L134:   aload_0 
L135:   getfield [20] 
L138:   iconst_2 
L139:   faload 
L140:   fcmpl 
L141:   iflt L152 
L144:   aload_0 
L145:   iconst_1 
L146:   putfield [40] 
L149:   goto L194 
L152:   aload_0 
L153:   getfield [25] 
L156:   aload_0 
L157:   getfield [20] 
L160:   iconst_1 
L161:   faload 
L162:   fcmpl 
L163:   iflt L194 
L166:   aload_0 
L167:   aload_0 
L168:   getfield [24] 
L171:   aload_0 
L172:   getfield [18] 
L175:   iconst_2 
L176:   iaload 
L177:   isub 
L178:   putfield [40] 
L181:   aload_0 
L182:   getfield [24] 
L185:   iconst_1 
L186:   if_icmpge L194 
L189:   aload_0 
L190:   iconst_1 
L191:   putfield [40] 
L194:   return 
L195:   nop 
L196:   
    .end code 
.end method 

.method public [306] : [307] 
    .attribute [299] .code stack 4 locals 2 
        .catch [0] from L0 to L239 using L251 
L0:     aload_0 
L1:     invokespecial [32] 
L4:     aload_0 
L5:     getfield [22] 
L8:     invokeinterface [42] 0 
L13:    ifeq L228 
L16:    aload_0 
L17:    iload_1 
L18:    invokespecial [33] 
L21:    aload_0 
L22:    getfield [22] 
L25:    invokeinterface [43] 0 
L30:    ifeq L135 
L33:    aload_0 
L34:    aload_0 
L35:    getfield [24] 
L38:    putfield [44] 
L41:    aload_0 
L42:    aload_0 
L43:    getfield [22] 
L46:    invokeinterface [45] 0 
L51:    putfield [46] 
L54:    aload_0 
L55:    getfield [26] 
L58:    aload_0 
L59:    getfield [27] 
L62:    if_icmpgt L93 
L65:    aload_0 
L66:    getfield [24] 
L69:    i2f 
L70:    aload_0 
L71:    getfield [20] 
L74:    iconst_3 
L75:    faload 
L76:    fmul 
L77:    aload_0 
L78:    getfield [20] 
L81:    iconst_4 
L82:    faload 
L83:    fadd 
L84:    aload_0 
L85:    getfield [27] 
L88:    i2f 
L89:    fcmpl 
L90:    iflt L101 
L93:    aload_0 
L94:    aload_0 
L95:    getfield [27] 
L98:    putfield [44] 
L101:   iconst_0 
L102:   istore_2 
L103:   iload_2 
L104:   aload_0 
L105:   getfield [26] 
L108:   if_icmpge L132 
L111:   aload_0 
L112:   getfield [22] 
L115:   invokeinterface [47] 0 
L120:   ifeq L126 
L123:   goto L132 
L126:   iinc 2 1 
L129:   goto L103 
L132:   goto L239 
L135:   aload_0 
L136:   aload_0 
L137:   getfield [24] 
L140:   aload_0 
L141:   getfield [18] 
L144:   iconst_4 
L145:   iaload 
L146:   imul 
L147:   putfield [44] 
L150:   aload_0 
L151:   iconst_0 
L152:   putfield [48] 
L155:   aload_0 
L156:   iconst_0 
L157:   putfield [49] 
L160:   aload_0 
L161:   getfield [28] 
L164:   aload_0 
L165:   getfield [29] 
L168:   iadd 
L169:   aload_0 
L170:   getfield [26] 
L173:   if_icmpge L239 
L176:   aload_0 
L177:   getfield [22] 
L180:   invokeinterface [50] 0 
L185:   istore_2 
L186:   aload_0 
L187:   getfield [22] 
L190:   invokeinterface [51] 0 
L195:   aload_0 
L196:   aload_0 
L197:   getfield [28] 
L200:   iload_2 
L201:   iadd 
L202:   aload_0 
L203:   getfield [22] 
L206:   invokeinterface [50] 0 
L211:   isub 
L212:   putfield [48] 
L215:   aload_0 
L216:   dup 
L217:   getfield [29] 
L220:   iconst_1 
L221:   iadd 
L222:   putfield [49] 
L225:   goto L160 
L228:   getstatic [6] 
L231:   ldc [7] 
L233:   ldc [8] 
L235:   invokevirtual [30] 
L238:   pop 
L239:   aload_0 
L240:   getfield [22] 
L243:   invokeinterface [52] 0 
L248:   goto L263 
        .catch [0] from L251 to L252 using L251 
L251:   astore_3 
L252:   aload_0 
L253:   getfield [22] 
L256:   invokeinterface [52] 0 
L261:   aload_3 
L262:   athrow 
L263:   return 
L264:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [53] [54] 
.const [3] = Field [55] [56] 
.const [4] = Field [57] [58] 
.const [5] = Method [59] [60] 
.const [6] = Field [61] [62] 
.const [7] = Int -2137614336 
.const [8] = String [63] 
.const [9] = Class [64] 
.const [10] = Class [65] 
.const [11] = Class [66] 
.const [12] = Class [67] 
.const [13] = Class [68] 
.const [14] = Class [69] 
.const [15] = Class [70] 
.const [16] = Field [71] [72] 
.const [17] = Field [73] [74] 
.const [18] = Field [75] [76] 
.const [19] = Method [77] [78] 
.const [20] = Field [79] [80] 
.const [21] = Method [81] [82] 
.const [22] = Field [83] [84] 
.const [23] = Field [85] [86] 
.const [24] = Field [87] [88] 
.const [25] = Field [89] [90] 
.const [26] = Field [91] [92] 
.const [27] = Field [93] [94] 
.const [28] = Field [95] [96] 
.const [29] = Field [97] [98] 
.const [30] = Method [99] [100] 
.const [31] = Method [101] [102] 
.const [32] = Method [103] [104] 
.const [33] = Method [105] [106] 
.const [34] = Field [107] [108] 
.const [35] = Field [109] [110] 
.const [36] = Field [111] [112] 
.const [37] = Field [113] [114] 
.const [38] = Field [115] [116] 
.const [39] = Field [117] [118] 
.const [40] = Field [119] [120] 
.const [41] = Field [121] [122] 
.const [42] = InterfaceMethod [123] [124] 
.const [43] = InterfaceMethod [125] [126] 
.const [44] = Field [127] [128] 
.const [45] = InterfaceMethod [129] [130] 
.const [46] = Field [131] [132] 
.const [47] = InterfaceMethod [133] [134] 
.const [48] = Field [135] [136] 
.const [49] = Field [137] [138] 
.const [50] = InterfaceMethod [139] [140] 
.const [51] = InterfaceMethod [141] [142] 
.const [52] = InterfaceMethod [143] [144] 
.const [53] = Class [145] 
.const [54] = NameAndType [146] [147] 
.const [55] = Class [148] 
.const [56] = NameAndType [149] [150] 
.const [57] = Class [151] 
.const [58] = NameAndType [152] [153] 
.const [59] = Class [154] 
.const [60] = NameAndType [155] [156] 
.const [61] = Class [157] 
.const [62] = NameAndType [158] [159] 
.const [63] = Utf8 'BckSpaceGestureHandler#BackspaceGesture lock could not acquire' 
.const [64] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/multiline/BckSpaceGestureHandler 
.const [65] = Utf8 java/lang/Object 
.const [66] = Utf8 de/audi/tghu/hmi/evo/BckSpaceGestureHandlerConfig 
.const [67] = Utf8 java/lang/System 
.const [68] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/multiline/FastDeleteHelper 
.const [69] = Utf8 de/esolutions/hmi/widgets/audi/base/IWidgetLogChannel 
.const [70] = Utf8 de/audi/atip/log/LogChannel 
.const [71] = Class [160] 
.const [72] = NameAndType [161] [162] 
.const [73] = Class [163] 
.const [74] = NameAndType [164] [165] 
.const [75] = Class [166] 
.const [76] = NameAndType [167] [168] 
.const [77] = Class [169] 
.const [78] = NameAndType [170] [171] 
.const [79] = Class [172] 
.const [80] = NameAndType [173] [174] 
.const [81] = Class [175] 
.const [82] = NameAndType [176] [177] 
.const [83] = Class [178] 
.const [84] = NameAndType [179] [180] 
.const [85] = Class [181] 
.const [86] = NameAndType [182] [183] 
.const [87] = Class [184] 
.const [88] = NameAndType [185] [186] 
.const [89] = Class [187] 
.const [90] = NameAndType [188] [189] 
.const [91] = Class [190] 
.const [92] = NameAndType [191] [192] 
.const [93] = Class [193] 
.const [94] = NameAndType [194] [195] 
.const [95] = Class [196] 
.const [96] = NameAndType [197] [198] 
.const [97] = Class [199] 
.const [98] = NameAndType [200] [201] 
.const [99] = Class [202] 
.const [100] = NameAndType [203] [204] 
.const [101] = Class [205] 
.const [102] = NameAndType [206] [207] 
.const [103] = Class [208] 
.const [104] = NameAndType [209] [210] 
.const [105] = Class [211] 
.const [106] = NameAndType [212] [213] 
.const [107] = Class [214] 
.const [108] = NameAndType [215] [216] 
.const [109] = Class [217] 
.const [110] = NameAndType [218] [219] 
.const [111] = Class [220] 
.const [112] = NameAndType [221] [222] 
.const [113] = Class [223] 
.const [114] = NameAndType [224] [225] 
.const [115] = Class [226] 
.const [116] = NameAndType [227] [228] 
.const [117] = Class [229] 
.const [118] = NameAndType [230] [231] 
.const [119] = Class [232] 
.const [120] = NameAndType [233] [234] 
.const [121] = Class [235] 
.const [122] = NameAndType [236] [237] 
.const [123] = Class [238] 
.const [124] = NameAndType [239] [240] 
.const [125] = Class [241] 
.const [126] = NameAndType [242] [243] 
.const [127] = Class [244] 
.const [128] = NameAndType [245] [246] 
.const [129] = Class [247] 
.const [130] = NameAndType [248] [249] 
.const [131] = Class [250] 
.const [132] = NameAndType [251] [252] 
.const [133] = Class [253] 
.const [134] = NameAndType [254] [255] 
.const [135] = Class [256] 
.const [136] = NameAndType [257] [258] 
.const [137] = Class [259] 
.const [138] = NameAndType [260] [261] 
.const [139] = Class [262] 
.const [140] = NameAndType [263] [264] 
.const [141] = Class [265] 
.const [142] = NameAndType [266] [267] 
.const [143] = Class [268] 
.const [144] = NameAndType [269] [270] 
.const [145] = Utf8 de/audi/tghu/hmi/evo/BckSpaceGestureHandlerConfig 
.const [146] = Utf8 getInstance 
.const [147] = Utf8 ()Lde/audi/tghu/hmi/evo/BckSpaceGestureHandlerConfig; 
.const [148] = Utf8 de/audi/tghu/hmi/evo/BckSpaceGestureHandlerConfig 
.const [149] = Utf8 INT_DEFAULT_CONFIG 
.const [150] = Utf8 [[I 
.const [151] = Utf8 de/audi/tghu/hmi/evo/BckSpaceGestureHandlerConfig 
.const [152] = Utf8 FLOAT_DEFAULT_CONFIG 
.const [153] = Utf8 [[F 
.const [154] = Utf8 java/lang/System 
.const [155] = Utf8 arraycopy 
.const [156] = Utf8 (Ljava/lang/Object;ILjava/lang/Object;II)V 
.const [157] = Utf8 de/esolutions/hmi/widgets/audi/base/IWidgetLogChannel 
.const [158] = Utf8 tpLogChannelKeypanel 
.const [159] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [160] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/multiline/BckSpaceGestureHandler 
.const [161] = Utf8 cfg 
.const [162] = Utf8 Lde/audi/tghu/hmi/evo/BckSpaceGestureHandlerConfig; 
.const [163] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/multiline/BckSpaceGestureHandler 
.const [164] = Utf8 m_kbdType 
.const [165] = Utf8 I 
.const [166] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/multiline/BckSpaceGestureHandler 
.const [167] = Utf8 iCfg 
.const [168] = Utf8 [I 
.const [169] = Utf8 de/audi/tghu/hmi/evo/BckSpaceGestureHandlerConfig 
.const [170] = Utf8 getConfigInts 
.const [171] = Utf8 (I[I)[I 
.const [172] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/multiline/BckSpaceGestureHandler 
.const [173] = Utf8 fCfg 
.const [174] = Utf8 [F 
.const [175] = Utf8 de/audi/tghu/hmi/evo/BckSpaceGestureHandlerConfig 
.const [176] = Utf8 getConfigFloats 
.const [177] = Utf8 (I[F)[F 
.const [178] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/multiline/BckSpaceGestureHandler 
.const [179] = Utf8 fastDeleteHelper 
.const [180] = Utf8 Lde/esolutions/hmi/widgets/audi/evo/widgets/multiline/FastDeleteHelper; 
.const [181] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/multiline/BckSpaceGestureHandler 
.const [182] = Utf8 minDeltaTime 
.const [183] = Utf8 I 
.const [184] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/multiline/BckSpaceGestureHandler 
.const [185] = Utf8 deleteSpeed 
.const [186] = Utf8 I 
.const [187] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/multiline/BckSpaceGestureHandler 
.const [188] = Utf8 factor 
.const [189] = Utf8 F 
.const [190] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/multiline/BckSpaceGestureHandler 
.const [191] = Utf8 numCharsToDelete 
.const [192] = Utf8 I 
.const [193] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/multiline/BckSpaceGestureHandler 
.const [194] = Utf8 numCharsInWord 
.const [195] = Utf8 I 
.const [196] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/multiline/BckSpaceGestureHandler 
.const [197] = Utf8 charsDeleted 
.const [198] = Utf8 I 
.const [199] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/multiline/BckSpaceGestureHandler 
.const [200] = Utf8 wordsDeleted 
.const [201] = Utf8 I 
.const [202] = Utf8 de/audi/atip/log/LogChannel 
.const [203] = Utf8 log 
.const [204] = Utf8 (ILjava/lang/String;)Z 
.const [205] = Utf8 java/lang/Object 
.const [206] = Utf8 <init> 
.const [207] = Utf8 ()V 
.const [208] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/multiline/BckSpaceGestureHandler 
.const [209] = Utf8 updateConfig 
.const [210] = Utf8 ()V 
.const [211] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/multiline/BckSpaceGestureHandler 
.const [212] = Utf8 updateDeleteSpeed 
.const [213] = Utf8 (I)V 
.const [214] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/multiline/BckSpaceGestureHandler 
.const [215] = Utf8 cfg 
.const [216] = Utf8 Lde/audi/tghu/hmi/evo/BckSpaceGestureHandlerConfig; 
.const [217] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/multiline/BckSpaceGestureHandler 
.const [218] = Utf8 m_kbdType 
.const [219] = Utf8 I 
.const [220] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/multiline/BckSpaceGestureHandler 
.const [221] = Utf8 iCfg 
.const [222] = Utf8 [I 
.const [223] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/multiline/BckSpaceGestureHandler 
.const [224] = Utf8 fCfg 
.const [225] = Utf8 [F 
.const [226] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/multiline/BckSpaceGestureHandler 
.const [227] = Utf8 fastDeleteHelper 
.const [228] = Utf8 Lde/esolutions/hmi/widgets/audi/evo/widgets/multiline/FastDeleteHelper; 
.const [229] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/multiline/BckSpaceGestureHandler 
.const [230] = Utf8 minDeltaTime 
.const [231] = Utf8 I 
.const [232] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/multiline/BckSpaceGestureHandler 
.const [233] = Utf8 deleteSpeed 
.const [234] = Utf8 I 
.const [235] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/multiline/BckSpaceGestureHandler 
.const [236] = Utf8 factor 
.const [237] = Utf8 F 
.const [238] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/multiline/FastDeleteHelper 
.const [239] = Utf8 lock 
.const [240] = Utf8 ()Z 
.const [241] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/multiline/FastDeleteHelper 
.const [242] = Utf8 isEditMode 
.const [243] = Utf8 ()Z 
.const [244] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/multiline/BckSpaceGestureHandler 
.const [245] = Utf8 numCharsToDelete 
.const [246] = Utf8 I 
.const [247] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/multiline/FastDeleteHelper 
.const [248] = Utf8 getWordLength 
.const [249] = Utf8 ()I 
.const [250] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/multiline/BckSpaceGestureHandler 
.const [251] = Utf8 numCharsInWord 
.const [252] = Utf8 I 
.const [253] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/multiline/FastDeleteHelper 
.const [254] = Utf8 deleteOneChar 
.const [255] = Utf8 ()Z 
.const [256] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/multiline/BckSpaceGestureHandler 
.const [257] = Utf8 charsDeleted 
.const [258] = Utf8 I 
.const [259] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/multiline/BckSpaceGestureHandler 
.const [260] = Utf8 wordsDeleted 
.const [261] = Utf8 I 
.const [262] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/multiline/FastDeleteHelper 
.const [263] = Utf8 getTextLength 
.const [264] = Utf8 ()I 
.const [265] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/multiline/FastDeleteHelper 
.const [266] = Utf8 deleteWordIncludingPrecedingWhitespaces 
.const [267] = Utf8 ()V 
.const [268] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/multiline/FastDeleteHelper 
.const [269] = Utf8 unlock 
.const [270] = Utf8 ()V 
.const [271] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/multiline/BckSpaceGestureHandler 
.const [272] = Class [271] 
.const [273] = Utf8 java/lang/Object 
.const [274] = Class [273] 
.const [275] = Utf8 fastDeleteHelper 
.const [276] = Utf8 Lde/esolutions/hmi/widgets/audi/evo/widgets/multiline/FastDeleteHelper; 
.const [277] = Utf8 numCharsToDelete 
.const [278] = Utf8 I 
.const [279] = Utf8 deleteSpeed 
.const [280] = Utf8 I 
.const [281] = Utf8 numCharsInWord 
.const [282] = Utf8 I 
.const [283] = Utf8 charsDeleted 
.const [284] = Utf8 I 
.const [285] = Utf8 wordsDeleted 
.const [286] = Utf8 I 
.const [287] = Utf8 minDeltaTime 
.const [288] = Utf8 I 
.const [289] = Utf8 factor 
.const [290] = Utf8 F 
.const [291] = Utf8 m_kbdType 
.const [292] = Utf8 I 
.const [293] = Utf8 cfg 
.const [294] = Utf8 Lde/audi/tghu/hmi/evo/BckSpaceGestureHandlerConfig; 
.const [295] = Utf8 fCfg 
.const [296] = Utf8 [F 
.const [297] = Utf8 iCfg 
.const [298] = Utf8 [I 
.const [299] = Utf8 Code 
.const [300] = Utf8 updateConfig 
.const [301] = Utf8 ()V 
.const [302] = Utf8 <init> 
.const [303] = Utf8 (ILde/esolutions/hmi/widgets/audi/evo/widgets/multiline/FastDeleteHelper;)V 
.const [304] = Utf8 updateDeleteSpeed 
.const [305] = Utf8 (I)V 
.const [306] = Utf8 backspaceGesture 
.const [307] = Utf8 (I)V 
.end class 
