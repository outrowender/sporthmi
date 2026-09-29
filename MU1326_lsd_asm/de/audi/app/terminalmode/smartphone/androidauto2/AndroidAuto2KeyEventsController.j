.version 50 0 
.class public final super [384] 
.super [386] 
.implements [388] 
.field private static final [389] [390] 
.field private volatile [391] [392] 
.field private final [393] [394] 
.field private final [395] [396] 
.field private final [397] [398] 

.method public [400] : [401] 
    .attribute [399] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [67] 
L4:     aload_0 
L5:     iconst_3 
L6:     newarray boolean 
L8:     putfield [74] 
L11:    aload_0 
L12:    aload_1 
L13:    putfield [75] 
L16:    aload_0 
L17:    aload_2 
L18:    putfield [76] 
L21:    return 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [402] : [403] 
    .attribute [399] .code stack 6 locals 1 
L0:     aload_1 
L1:     invokestatic [2] 
L4:     ifeq L57 
L7:     aconst_null 
L8:     aload_0 
L9:     getfield [48] 
L12:    if_acmpne L16 
L15:    return 
L16:    aload_0 
L17:    getfield [47] 
L20:    ldc [3] 
L22:    ldc [4] 
L24:    ldc [5] 
L26:    aload_0 
L27:    getfield [48] 
L30:    invokevirtual [49] 
L33:    aload_0 
L34:    getfield [46] 
L37:    aload_0 
L38:    aload_0 
L39:    getfield [48] 
L42:    invokespecial [68] 
L45:    iconst_1 
L46:    invokeinterface [78] 0 
L51:    aload_0 
L52:    aconst_null 
L53:    putfield [77] 
L56:    return 
L57:    aload_0 
L58:    aload_1 
L59:    invokespecial [68] 
L62:    istore_3 
L63:    iconst_0 
L64:    iload_3 
L65:    if_icmpne L83 
L68:    aload_0 
L69:    getfield [47] 
L72:    ldc [3] 
L74:    ldc [6] 
L76:    ldc [5] 
L78:    invokevirtual [50] 
L81:    pop 
L82:    return 
L83:    aload_0 
L84:    getfield [47] 
L87:    ldc [3] 
L89:    ldc [7] 
L91:    ldc [5] 
L93:    iload_3 
L94:    i2l 
L95:    invokevirtual [51] 
L98:    pop 
L99:    aload_1 
L100:   invokestatic [8] 
L103:   ifeq L111 
L106:   aload_0 
L107:   aload_1 
L108:   putfield [77] 
L111:   aload_0 
L112:   getfield [46] 
L115:   iload_3 
L116:   aload_0 
L117:   aload_2 
L118:   invokespecial [69] 
L121:   invokeinterface [78] 0 
L126:   return 
L127:   nop 
L128:   
    .end code 
.end method 

.method public [404] : [405] 
    .attribute [399] .code stack 8 locals 3 
L0:     aload_0 
L1:     getfield [47] 
L4:     ldc [3] 
L6:     ldc [9] 
L8:     ldc [5] 
L10:    invokevirtual [50] 
L13:    pop 
L14:    iload_2 
L15:    anewarray [10] 
L18:    astore 8 
L20:    iload_2 
L21:    iconst_1 
L22:    if_icmplt L41 
L25:    aload 8 
L27:    iconst_0 
L28:    new [79] 
L31:    dup 
L32:    iload 4 
L34:    iload 5 
L36:    iconst_0 
L37:    invokespecial [70] 
L40:    aastore 
L41:    iload_2 
L42:    iconst_2 
L43:    if_icmplt L80 
L46:    aload_0 
L47:    iload 4 
L49:    iload 5 
L51:    iload 6 
L53:    iload 7 
L55:    invokespecial [71] 
L58:    astore 9 
L60:    aload 8 
L62:    iconst_1 
L63:    new [79] 
L66:    dup 
L67:    aload 9 
L69:    iconst_0 
L70:    iaload 
L71:    aload 9 
L73:    iconst_1 
L74:    iaload 
L75:    iconst_1 
L76:    invokespecial [70] 
L79:    aastore 
L80:    aload_0 
L81:    getfield [47] 
L84:    invokevirtual [52] 
L87:    ifeq L238 
L90:    iload_2 
L91:    iconst_1 
L92:    if_icmplt L128 
L95:    aload_0 
L96:    getfield [47] 
L99:    ldc [3] 
L101:   ldc [11] 
L103:   ldc [5] 
L105:   aload 8 
L107:   iconst_0 
L108:   aaload 
L109:   invokevirtual [53] 
L112:   i2l 
L113:   aload 8 
L115:   iconst_0 
L116:   aaload 
L117:   invokevirtual [54] 
L120:   i2l 
L121:   invokevirtual [55] 
L124:   pop 
L125:   goto L238 
L128:   iload_2 
L129:   iconst_2 
L130:   if_icmplt L238 
L133:   new [80] 
L136:   dup 
L137:   bipush 50 
L139:   invokespecial [72] 
L142:   astore 9 
L144:   aload 9 
L146:   aload 8 
L148:   iconst_0 
L149:   aaload 
L150:   invokevirtual [53] 
L153:   invokevirtual [56] 
L156:   pop 
L157:   aload 9 
L159:   bipush 47 
L161:   invokevirtual [57] 
L164:   pop 
L165:   aload 9 
L167:   aload 8 
L169:   iconst_0 
L170:   aaload 
L171:   invokevirtual [54] 
L174:   invokevirtual [56] 
L177:   pop 
L178:   aload 9 
L180:   bipush 32 
L182:   invokevirtual [57] 
L185:   pop 
L186:   aload 9 
L188:   aload 8 
L190:   iconst_1 
L191:   aaload 
L192:   invokevirtual [53] 
L195:   invokevirtual [56] 
L198:   pop 
L199:   aload 9 
L201:   bipush 47 
L203:   invokevirtual [57] 
L206:   pop 
L207:   aload 9 
L209:   aload 8 
L211:   iconst_1 
L212:   aaload 
L213:   invokevirtual [54] 
L216:   invokevirtual [56] 
L219:   pop 
L220:   aload_0 
L221:   getfield [47] 
L224:   ldc [3] 
L226:   ldc [13] 
L228:   ldc [5] 
L230:   aload 9 
L232:   invokevirtual [58] 
L235:   invokevirtual [49] 
L238:   iconst_0 
L239:   istore 10 
L241:   aload_0 
L242:   getfield [45] 
L245:   iload_1 
L246:   baload 
L247:   ifne L263 
L250:   aload_0 
L251:   getfield [45] 
L254:   iload_1 
L255:   iconst_1 
L256:   bastore 
L257:   iconst_0 
L258:   istore 10 
L260:   goto L283 
L263:   iload_2 
L264:   ifne L280 
L267:   aload_0 
L268:   getfield [45] 
L271:   iload_1 
L272:   iconst_0 
L273:   bastore 
L274:   iconst_1 
L275:   istore 10 
L277:   goto L283 
L280:   iconst_2 
L281:   istore 10 
L283:   aload_0 
L284:   getfield [46] 
L287:   aload_0 
L288:   iload_1 
L289:   invokespecial [73] 
L292:   aload 8 
L294:   iload 10 
L296:   iconst_0 
L297:   invokeinterface [81] 0 
L302:   return 
L303:   nop 
L304:   
    .end code 
.end method 

.method public [406] : [407] 
    .attribute [399] .code stack 7 locals 5 
L0:     aload_0 
L1:     getfield [47] 
L4:     ldc [3] 
L6:     ldc [14] 
L8:     ldc [5] 
L10:    aload_1 
L11:    arraylength 
L12:    invokestatic [15] 
L15:    aload_1 
L16:    iconst_0 
L17:    aaload 
L18:    invokevirtual [59] 
L21:    aload_1 
L22:    arraylength 
L23:    anewarray [10] 
L26:    astore_2 
L27:    iconst_0 
L28:    istore 4 
L30:    iconst_0 
L31:    istore 5 
L33:    iload 5 
L35:    aload_1 
L36:    arraylength 
L37:    if_icmpge L75 
L40:    aload_1 
L41:    iload 5 
L43:    aaload 
L44:    astore 6 
L46:    aload_2 
L47:    iload 5 
L49:    new [79] 
L52:    dup 
L53:    aload 6 
L55:    invokevirtual [60] 
L58:    aload 6 
L60:    invokevirtual [61] 
L63:    iload 5 
L65:    invokespecial [70] 
L68:    aastore 
L69:    iinc 5 1 
L72:    goto L33 
L75:    aload_1 
L76:    iconst_0 
L77:    aaload 
L78:    invokevirtual [62] 
L81:    tableswitch 0 
            L108 
            L114 
            L120 
            default : L120 

L108:   iconst_0 
L109:   istore 4 
L111:   goto L123 
L114:   iconst_1 
L115:   istore 4 
L117:   goto L123 
L120:   iconst_2 
L121:   istore 4 
L123:   aload_0 
L124:   getfield [46] 
L127:   aload_1 
L128:   iconst_0 
L129:   aaload 
L130:   invokevirtual [63] 
L133:   ifeq L140 
L136:   iconst_1 
L137:   goto L141 
L140:   iconst_0 
L141:   aload_2 
L142:   iload 4 
L144:   iconst_0 
L145:   invokeinterface [81] 0 
L150:   return 
L151:   nop 
L152:   
    .end code 
.end method 

.method private [408] : [409] 
    .attribute [399] .code stack 6 locals 2 
L0:     iload 4 
L2:     bipush 100 
L4:     if_icmple L14 
L7:     iload 4 
L9:     bipush 100 
L11:    isub 
L12:    istore 4 
L14:    iload_1 
L15:    i2d 
L16:    iload 4 
L18:    bipush 100 
L20:    idiv 
L21:    i2d 
L22:    invokestatic [16] 
L25:    iload 4 
L27:    i2d 
L28:    dmul 
L29:    dadd 
L30:    d2i 
L31:    istore 5 
L33:    iload_2 
L34:    i2d 
L35:    iload 4 
L37:    bipush 100 
L39:    idiv 
L40:    i2d 
L41:    invokestatic [17] 
L44:    iload 4 
L46:    i2d 
L47:    dmul 
L48:    dadd 
L49:    d2i 
L50:    istore 6 
L52:    iconst_2 
L53:    newarray int 
L55:    dup 
L56:    iconst_0 
L57:    iload 5 
L59:    iastore 
L60:    dup 
L61:    iconst_1 
L62:    iload 6 
L64:    iastore 
L65:    areturn 
L66:    nop 
L67:    nop 
L68:    
    .end code 
.end method 

.method public [410] : [411] 
    .attribute [399] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [46] 
L4:     iload_1 
L5:     invokeinterface [82] 0 
L10:    return 
L11:    nop 
L12:    
    .end code 
.end method 

.method private [412] : [413] 
    .attribute [399] .code stack 5 locals 0 
L0:     aload_1 
L1:     getstatic [18] 
L4:     invokevirtual [64] 
L7:     ifeq L12 
L10:    iconst_0 
L11:    areturn 
L12:    aload_1 
L13:    getstatic [19] 
L16:    invokevirtual [64] 
L19:    ifeq L24 
L22:    iconst_1 
L23:    areturn 
L24:    aload_0 
L25:    getfield [47] 
L28:    ldc [3] 
L30:    ldc [20] 
L32:    ldc [5] 
L34:    aload_1 
L35:    invokevirtual [49] 
L38:    iconst_m1 
L39:    areturn 
L40:    
    .end code 
.end method 

.method private [414] : [415] 
    .attribute [399] .code stack 5 locals 0 
L0:     aload_1 
L1:     getstatic [21] 
L4:     invokevirtual [65] 
L7:     ifeq L12 
L10:    iconst_4 
L11:    areturn 
L12:    aload_1 
L13:    getstatic [22] 
L16:    invokevirtual [65] 
L19:    ifeq L25 
L22:    bipush 23 
L24:    areturn 
L25:    aload_1 
L26:    getstatic [23] 
L29:    getstatic [24] 
L32:    invokevirtual [66] 
L35:    ifeq L41 
L38:    bipush 19 
L40:    areturn 
L41:    aload_1 
L42:    getstatic [25] 
L45:    getstatic [26] 
L48:    invokevirtual [66] 
L51:    ifeq L57 
L54:    bipush 22 
L56:    areturn 
L57:    aload_1 
L58:    getstatic [27] 
L61:    getstatic [28] 
L64:    invokevirtual [66] 
L67:    ifeq L73 
L70:    bipush 20 
L72:    areturn 
L73:    aload_1 
L74:    getstatic [29] 
L77:    getstatic [30] 
L80:    invokevirtual [66] 
L83:    ifeq L89 
L86:    bipush 21 
L88:    areturn 
L89:    aload_1 
L90:    getstatic [31] 
L93:    invokevirtual [65] 
L96:    ifeq L101 
L99:    iconst_2 
L100:   areturn 
L101:   aload_1 
L102:   getstatic [32] 
L105:   invokevirtual [65] 
L108:   ifeq L113 
L111:   iconst_1 
L112:   areturn 
L113:   aload_0 
L114:   getfield [47] 
L117:   ldc [3] 
L119:   ldc [33] 
L121:   ldc [5] 
L123:   aload_1 
L124:   invokevirtual [49] 
L127:   iconst_0 
L128:   areturn 
L129:   nop 
L130:   nop 
L131:   nop 
L132:   
    .end code 
.end method 

.method private [416] : [417] 
    .attribute [399] .code stack 1 locals 0 
L0:     iload_1 
L1:     tableswitch 0 
            L30 
            L30 
            L28 
            default : L30 

L28:    iconst_1 
L29:    areturn 
L30:    iconst_0 
L31:    areturn 
L32:    
    .end code 
.end method 

.method public [418] : [419] 
    .attribute [399] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [47] 
L4:     ldc [3] 
L6:     ldc [34] 
L8:     ldc [5] 
L10:    invokevirtual [50] 
L13:    pop 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [83] [84] 
.const [3] = Int 1078071040 
.const [4] = String [85] 
.const [5] = String [86] 
.const [6] = String [87] 
.const [7] = String [88] 
.const [8] = Method [89] [90] 
.const [9] = String [91] 
.const [10] = Class [92] 
.const [11] = String [93] 
.const [12] = Class [94] 
.const [13] = String [95] 
.const [14] = String [96] 
.const [15] = Method [97] [98] 
.const [16] = Method [99] [100] 
.const [17] = Method [101] [102] 
.const [18] = Field [103] [104] 
.const [19] = Field [105] [106] 
.const [20] = String [107] 
.const [21] = Field [108] [109] 
.const [22] = Field [110] [111] 
.const [23] = Field [112] [113] 
.const [24] = Field [114] [115] 
.const [25] = Field [116] [117] 
.const [26] = Field [118] [119] 
.const [27] = Field [120] [121] 
.const [28] = Field [122] [123] 
.const [29] = Field [124] [125] 
.const [30] = Field [126] [127] 
.const [31] = Field [128] [129] 
.const [32] = Field [130] [131] 
.const [33] = String [132] 
.const [34] = String [133] 
.const [35] = Class [134] 
.const [36] = Class [135] 
.const [37] = Class [136] 
.const [38] = Class [137] 
.const [39] = Class [138] 
.const [40] = Class [139] 
.const [41] = Class [140] 
.const [42] = Class [141] 
.const [43] = Class [142] 
.const [44] = Class [143] 
.const [45] = Field [144] [145] 
.const [46] = Field [146] [147] 
.const [47] = Field [148] [149] 
.const [48] = Field [150] [151] 
.const [49] = Method [152] [153] 
.const [50] = Method [154] [155] 
.const [51] = Method [156] [157] 
.const [52] = Method [158] [159] 
.const [53] = Method [160] [161] 
.const [54] = Method [162] [163] 
.const [55] = Method [164] [165] 
.const [56] = Method [166] [167] 
.const [57] = Method [168] [169] 
.const [58] = Method [170] [171] 
.const [59] = Method [172] [173] 
.const [60] = Method [174] [175] 
.const [61] = Method [176] [177] 
.const [62] = Method [178] [179] 
.const [63] = Method [180] [181] 
.const [64] = Method [182] [183] 
.const [65] = Method [184] [185] 
.const [66] = Method [186] [187] 
.const [67] = Method [188] [189] 
.const [68] = Method [190] [191] 
.const [69] = Method [192] [193] 
.const [70] = Method [194] [195] 
.const [71] = Method [196] [197] 
.const [72] = Method [198] [199] 
.const [73] = Method [200] [201] 
.const [74] = Field [202] [203] 
.const [75] = Field [204] [205] 
.const [76] = Field [206] [207] 
.const [77] = Field [208] [209] 
.const [78] = InterfaceMethod [210] [211] 
.const [79] = Class [212] 
.const [80] = Class [213] 
.const [81] = InterfaceMethod [214] [215] 
.const [82] = InterfaceMethod [216] [217] 
.const [83] = Class [218] 
.const [84] = NameAndType [219] [220] 
.const [85] = Utf8 '[%1.updateKey] joystick middle position, release button %2' 
.const [86] = Utf8 TerminalModeDSIKeyEventsController 
.const [87] = Utf8 '[%1.updateKey] unknown key id' 
.const [88] = Utf8 '[%1.updateKey] %2' 
.const [89] = Class [221] 
.const [90] = NameAndType [222] [223] 
.const [91] = Utf8 '[%1.updateTouchEvent]' 
.const [92] = Utf8 org/dsi/ifc/androidauto2/TouchEvent 
.const [93] = Utf8 '[%1.updateTouchEvent] %2/%3' 
.const [94] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [95] = Utf8 '[%1.updateTouchEvent] %2' 
.const [96] = Utf8 '[%1.updateTouchEvents] %2 %3' 
.const [97] = Class [224] 
.const [98] = NameAndType [225] [226] 
.const [99] = Class [227] 
.const [100] = NameAndType [228] [229] 
.const [101] = Class [230] 
.const [102] = NameAndType [231] [232] 
.const [103] = Class [233] 
.const [104] = NameAndType [234] [235] 
.const [105] = Class [236] 
.const [106] = NameAndType [237] [238] 
.const [107] = Utf8 '[%1.getKeyState] Unsupported key state %2' 
.const [108] = Class [239] 
.const [109] = NameAndType [240] [241] 
.const [110] = Class [242] 
.const [111] = NameAndType [243] [244] 
.const [112] = Class [245] 
.const [113] = NameAndType [246] [247] 
.const [114] = Class [248] 
.const [115] = NameAndType [249] [250] 
.const [116] = Class [251] 
.const [117] = NameAndType [252] [253] 
.const [118] = Class [254] 
.const [119] = NameAndType [255] [256] 
.const [120] = Class [257] 
.const [121] = NameAndType [258] [259] 
.const [122] = Class [260] 
.const [123] = NameAndType [261] [262] 
.const [124] = Class [263] 
.const [125] = NameAndType [264] [265] 
.const [126] = Class [266] 
.const [127] = NameAndType [267] [268] 
.const [128] = Class [269] 
.const [129] = NameAndType [270] [271] 
.const [130] = Class [272] 
.const [131] = NameAndType [273] [274] 
.const [132] = Utf8 '[%1.getKeyId] Unsupport %2' 
.const [133] = Utf8 '[%1.updateCharacterEvent]' 
.const [134] = Utf8 de/audi/app/terminalmode/smartphone/androidauto2/AndroidAuto2KeyEventsController 
.const [135] = Utf8 java/lang/Object 
.const [136] = Utf8 de/audi/app/terminalmode/TerminalModeUtils 
.const [137] = Utf8 de/audi/atip/log/LogChannel 
.const [138] = Utf8 org/dsi/ifc/androidauto2/DSIAndroidAuto2 
.const [139] = Utf8 java/lang/Integer 
.const [140] = Utf8 de/audi/app/terminalmode/keyevents/TouchEvent 
.const [141] = Utf8 java/lang/Math 
.const [142] = Utf8 de/audi/app/terminalmode/keyevents/KeyState 
.const [143] = Utf8 de/audi/app/terminalmode/keyevents/Key 
.const [144] = Class [275] 
.const [145] = NameAndType [276] [277] 
.const [146] = Class [278] 
.const [147] = NameAndType [279] [280] 
.const [148] = Class [281] 
.const [149] = NameAndType [282] [283] 
.const [150] = Class [284] 
.const [151] = NameAndType [285] [286] 
.const [152] = Class [287] 
.const [153] = NameAndType [288] [289] 
.const [154] = Class [290] 
.const [155] = NameAndType [291] [292] 
.const [156] = Class [293] 
.const [157] = NameAndType [294] [295] 
.const [158] = Class [296] 
.const [159] = NameAndType [297] [298] 
.const [160] = Class [299] 
.const [161] = NameAndType [300] [301] 
.const [162] = Class [302] 
.const [163] = NameAndType [303] [304] 
.const [164] = Class [305] 
.const [165] = NameAndType [306] [307] 
.const [166] = Class [308] 
.const [167] = NameAndType [309] [310] 
.const [168] = Class [311] 
.const [169] = NameAndType [312] [313] 
.const [170] = Class [314] 
.const [171] = NameAndType [315] [316] 
.const [172] = Class [317] 
.const [173] = NameAndType [318] [319] 
.const [174] = Class [320] 
.const [175] = NameAndType [321] [322] 
.const [176] = Class [323] 
.const [177] = NameAndType [324] [325] 
.const [178] = Class [326] 
.const [179] = NameAndType [327] [328] 
.const [180] = Class [329] 
.const [181] = NameAndType [330] [331] 
.const [182] = Class [332] 
.const [183] = NameAndType [333] [334] 
.const [184] = Class [335] 
.const [185] = NameAndType [336] [337] 
.const [186] = Class [338] 
.const [187] = NameAndType [339] [340] 
.const [188] = Class [341] 
.const [189] = NameAndType [342] [343] 
.const [190] = Class [344] 
.const [191] = NameAndType [345] [346] 
.const [192] = Class [347] 
.const [193] = NameAndType [348] [349] 
.const [194] = Class [350] 
.const [195] = NameAndType [351] [352] 
.const [196] = Class [353] 
.const [197] = NameAndType [354] [355] 
.const [198] = Class [356] 
.const [199] = NameAndType [357] [358] 
.const [200] = Class [359] 
.const [201] = NameAndType [360] [361] 
.const [202] = Class [362] 
.const [203] = NameAndType [363] [364] 
.const [204] = Class [365] 
.const [205] = NameAndType [366] [367] 
.const [206] = Class [368] 
.const [207] = NameAndType [369] [370] 
.const [208] = Class [371] 
.const [209] = NameAndType [372] [373] 
.const [210] = Class [374] 
.const [211] = NameAndType [375] [376] 
.const [212] = Utf8 org/dsi/ifc/androidauto2/TouchEvent 
.const [213] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [214] = Class [377] 
.const [215] = NameAndType [378] [379] 
.const [216] = Class [380] 
.const [217] = NameAndType [381] [382] 
.const [218] = Utf8 de/audi/app/terminalmode/TerminalModeUtils 
.const [219] = Utf8 isJoystickMiddleposition 
.const [220] = Utf8 (Lde/audi/app/terminalmode/keyevents/Key;)Z 
.const [221] = Utf8 de/audi/app/terminalmode/TerminalModeUtils 
.const [222] = Utf8 isJoystick 
.const [223] = Utf8 (Lde/audi/app/terminalmode/keyevents/Key;)Z 
.const [224] = Utf8 java/lang/Integer 
.const [225] = Utf8 toString 
.const [226] = Utf8 (I)Ljava/lang/String; 
.const [227] = Utf8 java/lang/Math 
.const [228] = Utf8 acos 
.const [229] = Utf8 (D)D 
.const [230] = Utf8 java/lang/Math 
.const [231] = Utf8 asin 
.const [232] = Utf8 (D)D 
.const [233] = Utf8 de/audi/app/terminalmode/keyevents/KeyState 
.const [234] = Utf8 PRESSED 
.const [235] = Utf8 Lde/audi/app/terminalmode/keyevents/KeyState; 
.const [236] = Utf8 de/audi/app/terminalmode/keyevents/KeyState 
.const [237] = Utf8 RELEASED 
.const [238] = Utf8 Lde/audi/app/terminalmode/keyevents/KeyState; 
.const [239] = Utf8 de/audi/app/terminalmode/keyevents/Key 
.const [240] = Utf8 BACK 
.const [241] = Utf8 Lde/audi/app/terminalmode/keyevents/Key; 
.const [242] = Utf8 de/audi/app/terminalmode/keyevents/Key 
.const [243] = Utf8 DDS_SELECT 
.const [244] = Utf8 Lde/audi/app/terminalmode/keyevents/Key; 
.const [245] = Utf8 de/audi/app/terminalmode/keyevents/Key 
.const [246] = Utf8 JS_NORTH 
.const [247] = Utf8 Lde/audi/app/terminalmode/keyevents/Key; 
.const [248] = Utf8 de/audi/app/terminalmode/keyevents/Key 
.const [249] = Utf8 SOFTKEY_SOUTHWEST 
.const [250] = Utf8 Lde/audi/app/terminalmode/keyevents/Key; 
.const [251] = Utf8 de/audi/app/terminalmode/keyevents/Key 
.const [252] = Utf8 JS_EAST 
.const [253] = Utf8 Lde/audi/app/terminalmode/keyevents/Key; 
.const [254] = Utf8 de/audi/app/terminalmode/keyevents/Key 
.const [255] = Utf8 SOFTKEY_NORTHEAST 
.const [256] = Utf8 Lde/audi/app/terminalmode/keyevents/Key; 
.const [257] = Utf8 de/audi/app/terminalmode/keyevents/Key 
.const [258] = Utf8 JS_SOUTH 
.const [259] = Utf8 Lde/audi/app/terminalmode/keyevents/Key; 
.const [260] = Utf8 de/audi/app/terminalmode/keyevents/Key 
.const [261] = Utf8 SOFTKEY_SOUTHEAST 
.const [262] = Utf8 Lde/audi/app/terminalmode/keyevents/Key; 
.const [263] = Utf8 de/audi/app/terminalmode/keyevents/Key 
.const [264] = Utf8 JS_WEST 
.const [265] = Utf8 Lde/audi/app/terminalmode/keyevents/Key; 
.const [266] = Utf8 de/audi/app/terminalmode/keyevents/Key 
.const [267] = Utf8 SOFTKEY_NORTHWEST 
.const [268] = Utf8 Lde/audi/app/terminalmode/keyevents/Key; 
.const [269] = Utf8 de/audi/app/terminalmode/keyevents/Key 
.const [270] = Utf8 SOFTKEY_EAST 
.const [271] = Utf8 Lde/audi/app/terminalmode/keyevents/Key; 
.const [272] = Utf8 de/audi/app/terminalmode/keyevents/Key 
.const [273] = Utf8 SOFTKEY_WEST 
.const [274] = Utf8 Lde/audi/app/terminalmode/keyevents/Key; 
.const [275] = Utf8 de/audi/app/terminalmode/smartphone/androidauto2/AndroidAuto2KeyEventsController 
.const [276] = Utf8 downState 
.const [277] = Utf8 [Z 
.const [278] = Utf8 de/audi/app/terminalmode/smartphone/androidauto2/AndroidAuto2KeyEventsController 
.const [279] = Utf8 dsi 
.const [280] = Utf8 Lorg/dsi/ifc/androidauto2/DSIAndroidAuto2; 
.const [281] = Utf8 de/audi/app/terminalmode/smartphone/androidauto2/AndroidAuto2KeyEventsController 
.const [282] = Utf8 lc 
.const [283] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [284] = Utf8 de/audi/app/terminalmode/smartphone/androidauto2/AndroidAuto2KeyEventsController 
.const [285] = Utf8 lastJoystickkey 
.const [286] = Utf8 Lde/audi/app/terminalmode/keyevents/Key; 
.const [287] = Utf8 de/audi/atip/log/LogChannel 
.const [288] = Utf8 log 
.const [289] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [290] = Utf8 de/audi/atip/log/LogChannel 
.const [291] = Utf8 log 
.const [292] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [293] = Utf8 de/audi/atip/log/LogChannel 
.const [294] = Utf8 log 
.const [295] = Utf8 (ILjava/lang/String;Ljava/lang/Object;J)Z 
.const [296] = Utf8 de/audi/atip/log/LogChannel 
.const [297] = Utf8 isDebug 
.const [298] = Utf8 ()Z 
.const [299] = Utf8 org/dsi/ifc/androidauto2/TouchEvent 
.const [300] = Utf8 getX 
.const [301] = Utf8 ()I 
.const [302] = Utf8 org/dsi/ifc/androidauto2/TouchEvent 
.const [303] = Utf8 getY 
.const [304] = Utf8 ()I 
.const [305] = Utf8 de/audi/atip/log/LogChannel 
.const [306] = Utf8 log 
.const [307] = Utf8 (ILjava/lang/String;Ljava/lang/Object;JJ)Z 
.const [308] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [309] = Utf8 append 
.const [310] = Utf8 (I)Lde/esolutions/fw/util/commons/Buffer; 
.const [311] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [312] = Utf8 append 
.const [313] = Utf8 (C)Lde/esolutions/fw/util/commons/Buffer; 
.const [314] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [315] = Utf8 toString 
.const [316] = Utf8 ()Ljava/lang/String; 
.const [317] = Utf8 de/audi/atip/log/LogChannel 
.const [318] = Utf8 log 
.const [319] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [320] = Utf8 de/audi/app/terminalmode/keyevents/TouchEvent 
.const [321] = Utf8 getCurrentX 
.const [322] = Utf8 ()I 
.const [323] = Utf8 de/audi/app/terminalmode/keyevents/TouchEvent 
.const [324] = Utf8 getCurrentY 
.const [325] = Utf8 ()I 
.const [326] = Utf8 de/audi/app/terminalmode/keyevents/TouchEvent 
.const [327] = Utf8 getTouchState 
.const [328] = Utf8 ()I 
.const [329] = Utf8 de/audi/app/terminalmode/keyevents/TouchEvent 
.const [330] = Utf8 isTouchScreen 
.const [331] = Utf8 ()Z 
.const [332] = Utf8 de/audi/app/terminalmode/keyevents/KeyState 
.const [333] = Utf8 is 
.const [334] = Utf8 (Ljava/lang/Object;)Z 
.const [335] = Utf8 de/audi/app/terminalmode/keyevents/Key 
.const [336] = Utf8 is 
.const [337] = Utf8 (Ljava/lang/Object;)Z 
.const [338] = Utf8 de/audi/app/terminalmode/keyevents/Key 
.const [339] = Utf8 isOneOf 
.const [340] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)Z 
.const [341] = Utf8 java/lang/Object 
.const [342] = Utf8 <init> 
.const [343] = Utf8 ()V 
.const [344] = Utf8 de/audi/app/terminalmode/smartphone/androidauto2/AndroidAuto2KeyEventsController 
.const [345] = Utf8 getKeyId 
.const [346] = Utf8 (Lde/audi/app/terminalmode/keyevents/Key;)I 
.const [347] = Utf8 de/audi/app/terminalmode/smartphone/androidauto2/AndroidAuto2KeyEventsController 
.const [348] = Utf8 getKeyState 
.const [349] = Utf8 (Lde/audi/app/terminalmode/keyevents/KeyState;)I 
.const [350] = Utf8 org/dsi/ifc/androidauto2/TouchEvent 
.const [351] = Utf8 <init> 
.const [352] = Utf8 (III)V 
.const [353] = Utf8 de/audi/app/terminalmode/smartphone/androidauto2/AndroidAuto2KeyEventsController 
.const [354] = Utf8 calcSecondCorr 
.const [355] = Utf8 (IIII)[I 
.const [356] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [357] = Utf8 <init> 
.const [358] = Utf8 (I)V 
.const [359] = Utf8 de/audi/app/terminalmode/smartphone/androidauto2/AndroidAuto2KeyEventsController 
.const [360] = Utf8 getDSITouchInputId 
.const [361] = Utf8 (I)I 
.const [362] = Utf8 de/audi/app/terminalmode/smartphone/androidauto2/AndroidAuto2KeyEventsController 
.const [363] = Utf8 downState 
.const [364] = Utf8 [Z 
.const [365] = Utf8 de/audi/app/terminalmode/smartphone/androidauto2/AndroidAuto2KeyEventsController 
.const [366] = Utf8 dsi 
.const [367] = Utf8 Lorg/dsi/ifc/androidauto2/DSIAndroidAuto2; 
.const [368] = Utf8 de/audi/app/terminalmode/smartphone/androidauto2/AndroidAuto2KeyEventsController 
.const [369] = Utf8 lc 
.const [370] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [371] = Utf8 de/audi/app/terminalmode/smartphone/androidauto2/AndroidAuto2KeyEventsController 
.const [372] = Utf8 lastJoystickkey 
.const [373] = Utf8 Lde/audi/app/terminalmode/keyevents/Key; 
.const [374] = Utf8 org/dsi/ifc/androidauto2/DSIAndroidAuto2 
.const [375] = Utf8 postButtonEvent 
.const [376] = Utf8 (II)V 
.const [377] = Utf8 org/dsi/ifc/androidauto2/DSIAndroidAuto2 
.const [378] = Utf8 postTouchEvent 
.const [379] = Utf8 (I[Lorg/dsi/ifc/androidauto2/TouchEvent;II)V 
.const [380] = Utf8 org/dsi/ifc/androidauto2/DSIAndroidAuto2 
.const [381] = Utf8 postRotaryEvent 
.const [382] = Utf8 (I)V 
.const [383] = Utf8 de/audi/app/terminalmode/smartphone/androidauto2/AndroidAuto2KeyEventsController 
.const [384] = Class [383] 
.const [385] = Utf8 java/lang/Object 
.const [386] = Class [385] 
.const [387] = Utf8 de/audi/app/terminalmode/keyevents/ITerminalModeDSIKeyEventsController 
.const [388] = Class [387] 
.const [389] = Utf8 LOGCLASS 
.const [390] = Utf8 Ljava/lang/String; 
.const [391] = Utf8 lastJoystickkey 
.const [392] = Utf8 Lde/audi/app/terminalmode/keyevents/Key; 
.const [393] = Utf8 downState 
.const [394] = Utf8 [Z 
.const [395] = Utf8 dsi 
.const [396] = Utf8 Lorg/dsi/ifc/androidauto2/DSIAndroidAuto2; 
.const [397] = Utf8 lc 
.const [398] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [399] = Utf8 Code 
.const [400] = Utf8 <init> 
.const [401] = Utf8 (Lorg/dsi/ifc/androidauto2/DSIAndroidAuto2;Lde/audi/atip/log/LogChannel;)V 
.const [402] = Utf8 updateKey 
.const [403] = Utf8 (Lde/audi/app/terminalmode/keyevents/Key;Lde/audi/app/terminalmode/keyevents/KeyState;)V 
.const [404] = Utf8 updateTouchEvent 
.const [405] = Utf8 (IIIIIII)V 
.const [406] = Utf8 updateTouchEvents 
.const [407] = Utf8 ([Lde/audi/app/terminalmode/keyevents/TouchEvent;)V 
.const [408] = Utf8 calcSecondCorr 
.const [409] = Utf8 (IIII)[I 
.const [410] = Utf8 updateRotary 
.const [411] = Utf8 (I)V 
.const [412] = Utf8 getKeyState 
.const [413] = Utf8 (Lde/audi/app/terminalmode/keyevents/KeyState;)I 
.const [414] = Utf8 getKeyId 
.const [415] = Utf8 (Lde/audi/app/terminalmode/keyevents/Key;)I 
.const [416] = Utf8 getDSITouchInputId 
.const [417] = Utf8 (I)I 
.const [418] = Utf8 updateCharacterEvent 
.const [419] = Utf8 ([Ljava/lang/String;[I)V 
.end class 
