.version 50 0 
.class public super [371] 
.super [373] 
.implements [375] 
.implements [377] 
.implements [379] 
.field private final [380] [381] 
.field private final [382] [383] 
.field private static [384] [385] 
.field private final [386] [387] 
.field public static final [388] [389] 

.method public [391] : [392] 
    .attribute [390] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [46] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [57] 
L9:     aload_0 
L10:    new [58] 
L13:    dup 
L14:    invokespecial [47] 
L17:    putfield [59] 
L20:    aload_0 
L21:    aload_2 
L22:    putfield [60] 
L25:    new [61] 
L28:    dup 
L29:    invokespecial [48] 
L32:    putstatic [49] 
L35:    getstatic [4] 
L38:    aload_0 
L39:    invokevirtual [34] 
L42:    aload_0 
L43:    invokestatic [5] 
L46:    return 
L47:    nop 
L48:    
    .end code 
.end method 

.method public [393] : [394] 
    .attribute [390] .code stack 2 locals 0 
L0:     aload_1 
L1:     invokevirtual [35] 
L4:     getstatic [4] 
L7:     invokeinterface [62] 0 
L12:    return 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [395] : [396] 
    .attribute [390] .code stack 2 locals 0 
L0:     aload_1 
L1:     invokevirtual [35] 
L4:     getstatic [4] 
L7:     invokeinterface [63] 0 
L12:    return 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [397] : [398] 
    .attribute [390] .code stack 6 locals 2 
L0:     new [64] 
L3:     dup 
L4:     invokespecial [50] 
L7:     astore_1 
L8:     new [65] 
L11:    dup 
L12:    iconst_0 
L13:    aload_0 
L14:    getfield [32] 
L17:    invokeinterface [66] 0 
L22:    aload_0 
L23:    getfield [31] 
L26:    ldc [8] 
L28:    invokespecial [51] 
L31:    astore_2 
L32:    aload_1 
L33:    aload_0 
L34:    getfield [31] 
L37:    aload_2 
L38:    invokevirtual [36] 
L41:    aload_1 
L42:    areturn 
L43:    nop 
L44:    
    .end code 
.end method 

.method public synchronized [399] : [400] 
    .attribute [390] .code stack 3 locals 6 
L0:     aload_0 
L1:     getfield [33] 
L4:     iload_1 
L5:     i2l 
L6:     invokeinterface [67] 0 
L11:    istore_2 
L12:    aload_0 
L13:    getfield [32] 
L16:    invokeinterface [68] 0 
L21:    astore_3 
L22:    aload_3 
L23:    invokeinterface [69] 0 
L28:    astore 4 
L30:    new [70] 
L33:    dup 
L34:    invokespecial [52] 
L37:    astore 5 
L39:    aload 4 
L41:    invokeinterface [71] 0 
L46:    ifeq L100 
L49:    aload 4 
L51:    invokeinterface [72] 0 
L56:    checkcast [10] 
L59:    astore 6 
L61:    aload 6 
L63:    invokeinterface [73] 0 
L68:    checkcast [11] 
L71:    astore 7 
L73:    aload 7 
L75:    iload_2 
L76:    invokevirtual [37] 
L79:    ifeq L97 
L82:    aload 5 
L84:    aload 6 
L86:    invokeinterface [75] 0 
L91:    invokeinterface [76] 0 
L96:    pop 
L97:    goto L39 
L100:   aload 5 
L102:   areturn 
L103:   nop 
L104:   
    .end code 
.end method 

.method public synchronized [401] : [402] 
    .attribute [390] .code stack 3 locals 3 
L0:     aload_3 
L1:     instanceof [12] 
L4:     ifeq L113 
L7:     aload_3 
L8:     checkcast [12] 
L11:    astore 4 
L13:    aload_0 
L14:    getfield [33] 
L17:    lload_1 
L18:    invokeinterface [67] 0 
L23:    istore 5 
L25:    aload_0 
L26:    getfield [32] 
L29:    aload 4 
L31:    invokeinterface [77] 0 
L36:    ifeq L65 
L39:    aload_0 
L40:    getfield [32] 
L43:    aload 4 
L45:    invokeinterface [78] 0 
L50:    checkcast [11] 
L53:    astore 6 
L55:    aload 6 
L57:    iload 5 
L59:    invokevirtual [38] 
L62:    goto L110 
L65:    new [74] 
L68:    dup 
L69:    aload_0 
L70:    getfield [33] 
L73:    invokeinterface [79] 0 
L78:    invokespecial [53] 
L81:    astore 6 
L83:    aload 6 
L85:    iload 5 
L87:    invokevirtual [38] 
L90:    aload_0 
L91:    getfield [32] 
L94:    aload 4 
L96:    aload 6 
L98:    invokeinterface [80] 0 
L103:   pop 
L104:   aload_0 
L105:   aload 4 
L107:   invokespecial [54] 
L110:   goto L123 
L113:   getstatic [13] 
L116:   iconst_5 
L117:   ldc [14] 
L119:   invokevirtual [39] 
L122:   pop 
L123:   return 
L124:   
    .end code 
.end method 

.method public synchronized [403] : [404] 
    .attribute [390] .code stack 3 locals 2 
L0:     aload_1 
L1:     instanceof [12] 
L4:     ifeq L97 
L7:     aload_1 
L8:     checkcast [12] 
L11:    astore_2 
L12:    aload_0 
L13:    getfield [32] 
L16:    aload_2 
L17:    invokeinterface [77] 0 
L22:    ifeq L51 
L25:    aload_0 
L26:    getfield [32] 
L29:    aload_2 
L30:    invokeinterface [78] 0 
L35:    checkcast [11] 
L38:    astore_3 
L39:    aload_3 
L40:    iconst_0 
L41:    aload_3 
L42:    invokevirtual [40] 
L45:    invokevirtual [41] 
L48:    goto L94 
L51:    new [74] 
L54:    dup 
L55:    aload_0 
L56:    getfield [33] 
L59:    invokeinterface [79] 0 
L64:    invokespecial [53] 
L67:    astore_3 
L68:    aload_3 
L69:    iconst_0 
L70:    aload_3 
L71:    invokevirtual [40] 
L74:    invokevirtual [41] 
L77:    aload_0 
L78:    getfield [32] 
L81:    aload_2 
L82:    aload_3 
L83:    invokeinterface [80] 0 
L88:    pop 
L89:    aload_0 
L90:    aload_2 
L91:    invokespecial [54] 
L94:    goto L107 
L97:    getstatic [13] 
L100:   iconst_5 
L101:   ldc [14] 
L103:   invokevirtual [39] 
L106:   pop 
L107:   return 
L108:   
    .end code 
.end method 

.method public synchronized [405] : [406] 
    .attribute [390] .code stack 5 locals 4 
L0:     aload_2 
L1:     instanceof [12] 
L4:     ifeq L176 
L7:     aload_2 
L8:     checkcast [12] 
L11:    astore_3 
L12:    aload_1 
L13:    arraylength 
L14:    newarray int 
L16:    astore 4 
L18:    iconst_0 
L19:    istore 5 
L21:    iload 5 
L23:    aload_1 
L24:    arraylength 
L25:    if_icmpge L52 
L28:    aload 4 
L30:    iload 5 
L32:    aload_0 
L33:    getfield [33] 
L36:    aload_1 
L37:    iload 5 
L39:    laload 
L40:    invokeinterface [67] 0 
L45:    iastore 
L46:    iinc 5 1 
L49:    goto L21 
L52:    aload_0 
L53:    getfield [32] 
L56:    aload_3 
L57:    invokeinterface [77] 0 
L62:    ifeq L110 
L65:    aload_0 
L66:    getfield [32] 
L69:    aload_3 
L70:    invokeinterface [78] 0 
L75:    checkcast [11] 
L78:    astore 5 
L80:    iconst_0 
L81:    istore 6 
L83:    iload 6 
L85:    aload 4 
L87:    arraylength 
L88:    if_icmpge L107 
L91:    aload 5 
L93:    aload 4 
L95:    iload 6 
L97:    iaload 
L98:    invokevirtual [38] 
L101:   iinc 6 1 
L104:   goto L83 
L107:   goto L173 
L110:   new [74] 
L113:   dup 
L114:   aload_0 
L115:   getfield [33] 
L118:   invokeinterface [79] 0 
L123:   invokespecial [53] 
L126:   astore 5 
L128:   iconst_0 
L129:   istore 6 
L131:   iload 6 
L133:   aload 4 
L135:   arraylength 
L136:   if_icmpge L155 
L139:   aload 5 
L141:   aload 4 
L143:   iload 6 
L145:   iaload 
L146:   invokevirtual [38] 
L149:   iinc 6 1 
L152:   goto L131 
L155:   aload_0 
L156:   getfield [32] 
L159:   aload_3 
L160:   aload 5 
L162:   invokeinterface [80] 0 
L167:   pop 
L168:   aload_0 
L169:   aload_3 
L170:   invokespecial [54] 
L173:   goto L186 
L176:   getstatic [13] 
L179:   iconst_5 
L180:   ldc [14] 
L182:   invokevirtual [39] 
L185:   pop 
L186:   return 
L187:   nop 
L188:   
    .end code 
.end method 

.method public synchronized [407] : [408] 
    .attribute [390] .code stack 3 locals 3 
L0:     aload_3 
L1:     instanceof [12] 
L4:     ifeq L65 
L7:     aload_3 
L8:     checkcast [12] 
L11:    astore 4 
L13:    aload_0 
L14:    getfield [33] 
L17:    lload_1 
L18:    invokeinterface [67] 0 
L23:    istore 5 
L25:    aload_0 
L26:    getfield [32] 
L29:    aload 4 
L31:    invokeinterface [77] 0 
L36:    ifeq L62 
L39:    aload_0 
L40:    getfield [32] 
L43:    aload 4 
L45:    invokeinterface [78] 0 
L50:    checkcast [11] 
L53:    astore 6 
L55:    aload 6 
L57:    iload 5 
L59:    invokevirtual [42] 
L62:    goto L75 
L65:    getstatic [13] 
L68:    iconst_5 
L69:    ldc [15] 
L71:    invokevirtual [39] 
L74:    pop 
L75:    return 
L76:    
    .end code 
.end method 

.method public synchronized [409] : [410] 
    .attribute [390] .code stack 3 locals 2 
L0:     aload_1 
L1:     instanceof [12] 
L4:     ifeq L46 
L7:     aload_1 
L8:     checkcast [12] 
L11:    astore_2 
L12:    aload_0 
L13:    getfield [32] 
L16:    aload_2 
L17:    invokeinterface [77] 0 
L22:    ifeq L43 
L25:    aload_0 
L26:    getfield [32] 
L29:    aload_2 
L30:    invokeinterface [78] 0 
L35:    checkcast [11] 
L38:    astore_3 
L39:    aload_3 
L40:    invokevirtual [43] 
L43:    goto L56 
L46:    getstatic [13] 
L49:    iconst_5 
L50:    ldc [15] 
L52:    invokevirtual [39] 
L55:    pop 
L56:    return 
L57:    nop 
L58:    nop 
L59:    nop 
L60:    
    .end code 
.end method 

.method public synchronized [411] : [412] 
    .attribute [390] .code stack 5 locals 4 
L0:     aload_2 
L1:     instanceof [12] 
L4:     ifeq L110 
L7:     aload_2 
L8:     checkcast [12] 
L11:    astore_3 
L12:    aload_1 
L13:    arraylength 
L14:    newarray int 
L16:    astore 4 
L18:    iconst_0 
L19:    istore 5 
L21:    iload 5 
L23:    aload_1 
L24:    arraylength 
L25:    if_icmpge L52 
L28:    aload 4 
L30:    iload 5 
L32:    aload_0 
L33:    getfield [33] 
L36:    aload_1 
L37:    iload 5 
L39:    laload 
L40:    invokeinterface [67] 0 
L45:    iastore 
L46:    iinc 5 1 
L49:    goto L21 
L52:    aload_0 
L53:    getfield [32] 
L56:    aload_3 
L57:    invokeinterface [77] 0 
L62:    ifeq L107 
L65:    aload_0 
L66:    getfield [32] 
L69:    aload_3 
L70:    invokeinterface [78] 0 
L75:    checkcast [11] 
L78:    astore 5 
L80:    iconst_0 
L81:    istore 6 
L83:    iload 6 
L85:    aload 4 
L87:    arraylength 
L88:    if_icmpge L107 
L91:    aload 5 
L93:    aload 4 
L95:    iload 6 
L97:    iaload 
L98:    invokevirtual [42] 
L101:   iinc 6 1 
L104:   goto L83 
L107:   goto L120 
L110:   getstatic [13] 
L113:   iconst_5 
L114:   ldc [15] 
L116:   invokevirtual [39] 
L119:   pop 
L120:   return 
L121:   nop 
L122:   nop 
L123:   nop 
L124:   
    .end code 
.end method 

.method public synchronized [413] : [414] 
    .attribute [390] .code stack 2 locals 1 
L0:     iload_2 
L1:     iconst_2 
L2:     if_icmpeq L10 
L5:     iload_2 
L6:     iconst_3 
L7:     if_icmpne L36 
L10:    aload_0 
L11:    aload_1 
L12:    invokespecial [56] 
L15:    astore_3 
L16:    aload_3 
L17:    ifnull L36 
L20:    aload_0 
L21:    aload_3 
L22:    invokevirtual [44] 
L25:    aload_0 
L26:    getfield [32] 
L29:    aload_3 
L30:    invokeinterface [81] 0 
L35:    pop 
L36:    return 
L37:    nop 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 

.method private [415] : [416] 
    .attribute [390] .code stack 3 locals 4 
L0:     aload_0 
L1:     getfield [32] 
L4:     invokeinterface [82] 0 
L9:     astore_2 
L10:    aload_2 
L11:    invokeinterface [69] 0 
L16:    astore_3 
L17:    aload_3 
L18:    invokeinterface [71] 0 
L23:    ifeq L79 
L26:    aload_3 
L27:    invokeinterface [72] 0 
L32:    astore 4 
L34:    aload 4 
L36:    instanceof [12] 
L39:    ifeq L66 
L42:    aload 4 
L44:    checkcast [12] 
L47:    astore 5 
L49:    aload_1 
L50:    aload 5 
L52:    invokeinterface [83] 0 
L57:    if_acmpne L63 
L60:    aload 5 
L62:    areturn 
L63:    goto L76 
L66:    getstatic [13] 
L69:    iconst_5 
L70:    ldc [16] 
L72:    invokevirtual [39] 
L75:    pop 
L76:    goto L17 
L79:    aconst_null 
L80:    areturn 
L81:    nop 
L82:    nop 
L83:    nop 
L84:    
    .end code 
.end method 

.method private [417] : [418] 
    .attribute [390] .code stack 2 locals 1 
L0:     aload_1 
L1:     invokeinterface [83] 0 
L6:     astore_2 
L7:     aload_2 
L8:     ifnull L16 
L11:    aload_2 
L12:    aload_0 
L13:    invokevirtual [45] 
L16:    return 
L17:    nop 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method static [419] : [420] 
    .attribute [390] .code stack 1 locals 0 
L0:     ldc [17] 
L2:     invokestatic [18] 
L5:     putstatic [55] 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [84] 
.const [3] = Class [85] 
.const [4] = Field [86] [87] 
.const [5] = Method [88] [89] 
.const [6] = Class [90] 
.const [7] = Class [91] 
.const [8] = String [92] 
.const [9] = Class [93] 
.const [10] = Class [94] 
.const [11] = Class [95] 
.const [12] = Class [96] 
.const [13] = Field [97] [98] 
.const [14] = String [99] 
.const [15] = String [100] 
.const [16] = String [101] 
.const [17] = String [102] 
.const [18] = Method [103] [104] 
.const [19] = Class [105] 
.const [20] = Class [106] 
.const [21] = Class [107] 
.const [22] = Class [108] 
.const [23] = Class [109] 
.const [24] = Class [110] 
.const [25] = Class [111] 
.const [26] = Class [112] 
.const [27] = Class [113] 
.const [28] = Class [114] 
.const [29] = Class [115] 
.const [30] = Class [116] 
.const [31] = Field [117] [118] 
.const [32] = Field [119] [120] 
.const [33] = Field [121] [122] 
.const [34] = Method [123] [124] 
.const [35] = Method [125] [126] 
.const [36] = Method [127] [128] 
.const [37] = Method [129] [130] 
.const [38] = Method [131] [132] 
.const [39] = Method [133] [134] 
.const [40] = Method [135] [136] 
.const [41] = Method [137] [138] 
.const [42] = Method [139] [140] 
.const [43] = Method [141] [142] 
.const [44] = Method [143] [144] 
.const [45] = Method [145] [146] 
.const [46] = Method [147] [148] 
.const [47] = Method [149] [150] 
.const [48] = Method [151] [152] 
.const [49] = Field [153] [154] 
.const [50] = Method [155] [156] 
.const [51] = Method [157] [158] 
.const [52] = Method [159] [160] 
.const [53] = Method [161] [162] 
.const [54] = Method [163] [164] 
.const [55] = Field [165] [166] 
.const [56] = Method [167] [168] 
.const [57] = Field [169] [170] 
.const [58] = Class [171] 
.const [59] = Field [172] [173] 
.const [60] = Field [174] [175] 
.const [61] = Class [176] 
.const [62] = InterfaceMethod [177] [178] 
.const [63] = InterfaceMethod [179] [180] 
.const [64] = Class [181] 
.const [65] = Class [182] 
.const [66] = InterfaceMethod [183] [184] 
.const [67] = InterfaceMethod [185] [186] 
.const [68] = InterfaceMethod [187] [188] 
.const [69] = InterfaceMethod [189] [190] 
.const [70] = Class [191] 
.const [71] = InterfaceMethod [192] [193] 
.const [72] = InterfaceMethod [194] [195] 
.const [73] = InterfaceMethod [196] [197] 
.const [74] = Class [198] 
.const [75] = InterfaceMethod [199] [200] 
.const [76] = InterfaceMethod [201] [202] 
.const [77] = InterfaceMethod [203] [204] 
.const [78] = InterfaceMethod [205] [206] 
.const [79] = InterfaceMethod [207] [208] 
.const [80] = InterfaceMethod [209] [210] 
.const [81] = InterfaceMethod [211] [212] 
.const [82] = InterfaceMethod [213] [214] 
.const [83] = InterfaceMethod [215] [216] 
.const [84] = Utf8 java/util/HashMap 
.const [85] = Utf8 de/esolutions/fw/comm/agent/diag/WeakRefAgentInfoProvider 
.const [86] = Class [217] 
.const [87] = NameAndType [218] [219] 
.const [88] = Class [220] 
.const [89] = NameAndType [221] [222] 
.const [90] = Utf8 de/esolutions/fw/comm/agent/diag/AgentInfoMap 
.const [91] = Utf8 de/esolutions/fw/comm/agent/diag/info/AttributeServiceInfo 
.const [92] = Utf8 Instance 
.const [93] = Utf8 java/util/ArrayList 
.const [94] = Utf8 java/util/Map$Entry 
.const [95] = Utf8 java/util/BitSet 
.const [96] = Utf8 de/esolutions/fw/comm/core/IProxyFrontend 
.const [97] = Class [223] 
.const [98] = NameAndType [224] [225] 
.const [99] = Utf8 'setNotification failed: ReplyProxy is no instance of IProxyFrontend!' 
.const [100] = Utf8 'clearNotification failed: ReplyProxy is no instance of IProxyFrontend!' 
.const [101] = Utf8 'findReplyByProxy failed: ReplyProxy is no instance of IProxyFrontend!' 
.const [102] = Utf8 'comm.attributes.baseservice' 
.const [103] = Class [226] 
.const [104] = NameAndType [227] [228] 
.const [105] = Utf8 de/esolutions/fw/comm/attributes/AttributesBaseService 
.const [106] = Utf8 java/lang/Object 
.const [107] = Utf8 de/esolutions/fw/comm/agent/Agent 
.const [108] = Utf8 de/esolutions/fw/comm/agent/IAgentDiagnosis 
.const [109] = Utf8 java/util/Map 
.const [110] = Utf8 de/esolutions/fw/comm/attributes/IAttributeBitMapProvider 
.const [111] = Utf8 java/util/Set 
.const [112] = Utf8 java/util/Iterator 
.const [113] = Utf8 java/util/List 
.const [114] = Utf8 de/esolutions/fw/util/tracing/TraceChannel 
.const [115] = Utf8 de/esolutions/fw/comm/core/Proxy 
.const [116] = Utf8 de/esolutions/fw/util/tracing/TraceClient 
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
.const [145] = Class [271] 
.const [146] = NameAndType [272] [273] 
.const [147] = Class [274] 
.const [148] = NameAndType [275] [276] 
.const [149] = Class [277] 
.const [150] = NameAndType [278] [279] 
.const [151] = Class [280] 
.const [152] = NameAndType [281] [282] 
.const [153] = Class [283] 
.const [154] = NameAndType [284] [285] 
.const [155] = Class [286] 
.const [156] = NameAndType [287] [288] 
.const [157] = Class [289] 
.const [158] = NameAndType [290] [291] 
.const [159] = Class [292] 
.const [160] = NameAndType [293] [294] 
.const [161] = Class [295] 
.const [162] = NameAndType [296] [297] 
.const [163] = Class [298] 
.const [164] = NameAndType [299] [300] 
.const [165] = Class [301] 
.const [166] = NameAndType [302] [303] 
.const [167] = Class [304] 
.const [168] = NameAndType [305] [306] 
.const [169] = Class [307] 
.const [170] = NameAndType [308] [309] 
.const [171] = Utf8 java/util/HashMap 
.const [172] = Class [310] 
.const [173] = NameAndType [311] [312] 
.const [174] = Class [313] 
.const [175] = NameAndType [314] [315] 
.const [176] = Utf8 de/esolutions/fw/comm/agent/diag/WeakRefAgentInfoProvider 
.const [177] = Class [316] 
.const [178] = NameAndType [317] [318] 
.const [179] = Class [319] 
.const [180] = NameAndType [320] [321] 
.const [181] = Utf8 de/esolutions/fw/comm/agent/diag/AgentInfoMap 
.const [182] = Utf8 de/esolutions/fw/comm/agent/diag/info/AttributeServiceInfo 
.const [183] = Class [322] 
.const [184] = NameAndType [323] [324] 
.const [185] = Class [325] 
.const [186] = NameAndType [326] [327] 
.const [187] = Class [328] 
.const [188] = NameAndType [329] [330] 
.const [189] = Class [331] 
.const [190] = NameAndType [332] [333] 
.const [191] = Utf8 java/util/ArrayList 
.const [192] = Class [334] 
.const [193] = NameAndType [335] [336] 
.const [194] = Class [337] 
.const [195] = NameAndType [338] [339] 
.const [196] = Class [340] 
.const [197] = NameAndType [341] [342] 
.const [198] = Utf8 java/util/BitSet 
.const [199] = Class [343] 
.const [200] = NameAndType [344] [345] 
.const [201] = Class [346] 
.const [202] = NameAndType [347] [348] 
.const [203] = Class [349] 
.const [204] = NameAndType [350] [351] 
.const [205] = Class [352] 
.const [206] = NameAndType [353] [354] 
.const [207] = Class [355] 
.const [208] = NameAndType [356] [357] 
.const [209] = Class [358] 
.const [210] = NameAndType [359] [360] 
.const [211] = Class [361] 
.const [212] = NameAndType [362] [363] 
.const [213] = Class [364] 
.const [214] = NameAndType [365] [366] 
.const [215] = Class [367] 
.const [216] = NameAndType [368] [369] 
.const [217] = Utf8 de/esolutions/fw/comm/attributes/AttributesBaseService 
.const [218] = Utf8 weakRefInfoProvider 
.const [219] = Utf8 Lde/esolutions/fw/comm/agent/diag/WeakRefAgentInfoProvider; 
.const [220] = Utf8 de/esolutions/fw/comm/agent/Agent 
.const [221] = Utf8 registerAgentStateListener 
.const [222] = Utf8 (Lde/esolutions/fw/comm/agent/IAgentStateListener;)V 
.const [223] = Utf8 de/esolutions/fw/comm/attributes/AttributesBaseService 
.const [224] = Utf8 TRACE 
.const [225] = Utf8 Lde/esolutions/fw/util/tracing/TraceChannel; 
.const [226] = Utf8 de/esolutions/fw/util/tracing/TraceClient 
.const [227] = Utf8 createTraceChannel 
.const [228] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/tracing/TraceChannel; 
.const [229] = Utf8 de/esolutions/fw/comm/attributes/AttributesBaseService 
.const [230] = Utf8 name 
.const [231] = Utf8 Ljava/lang/String; 
.const [232] = Utf8 de/esolutions/fw/comm/attributes/AttributesBaseService 
.const [233] = Utf8 notificationMap 
.const [234] = Utf8 Ljava/util/Map; 
.const [235] = Utf8 de/esolutions/fw/comm/attributes/AttributesBaseService 
.const [236] = Utf8 attributeMap 
.const [237] = Utf8 Lde/esolutions/fw/comm/attributes/IAttributeBitMapProvider; 
.const [238] = Utf8 de/esolutions/fw/comm/agent/diag/WeakRefAgentInfoProvider 
.const [239] = Utf8 registerIAgentInfoProvider 
.const [240] = Utf8 (Lde/esolutions/fw/comm/agent/IAgentInfoProvider;)V 
.const [241] = Utf8 de/esolutions/fw/comm/agent/Agent 
.const [242] = Utf8 getAgentDiagnosis 
.const [243] = Utf8 ()Lde/esolutions/fw/comm/agent/IAgentDiagnosis; 
.const [244] = Utf8 de/esolutions/fw/comm/agent/diag/AgentInfoMap 
.const [245] = Utf8 add 
.const [246] = Utf8 (Ljava/lang/String;Lde/esolutions/fw/comm/agent/diag/IInfoBase;)V 
.const [247] = Utf8 java/util/BitSet 
.const [248] = Utf8 get 
.const [249] = Utf8 (I)Z 
.const [250] = Utf8 java/util/BitSet 
.const [251] = Utf8 set 
.const [252] = Utf8 (I)V 
.const [253] = Utf8 de/esolutions/fw/util/tracing/TraceChannel 
.const [254] = Utf8 log 
.const [255] = Utf8 (SLjava/lang/String;)Z 
.const [256] = Utf8 java/util/BitSet 
.const [257] = Utf8 size 
.const [258] = Utf8 ()I 
.const [259] = Utf8 java/util/BitSet 
.const [260] = Utf8 set 
.const [261] = Utf8 (II)V 
.const [262] = Utf8 java/util/BitSet 
.const [263] = Utf8 clear 
.const [264] = Utf8 (I)V 
.const [265] = Utf8 java/util/BitSet 
.const [266] = Utf8 clear 
.const [267] = Utf8 ()V 
.const [268] = Utf8 de/esolutions/fw/comm/attributes/AttributesBaseService 
.const [269] = Utf8 clearNotification 
.const [270] = Utf8 (Ljava/lang/Object;)V 
.const [271] = Utf8 de/esolutions/fw/comm/core/Proxy 
.const [272] = Utf8 registerProxyListener 
.const [273] = Utf8 (Lde/esolutions/fw/comm/core/IProxyListener;)V 
.const [274] = Utf8 java/lang/Object 
.const [275] = Utf8 <init> 
.const [276] = Utf8 ()V 
.const [277] = Utf8 java/util/HashMap 
.const [278] = Utf8 <init> 
.const [279] = Utf8 ()V 
.const [280] = Utf8 de/esolutions/fw/comm/agent/diag/WeakRefAgentInfoProvider 
.const [281] = Utf8 <init> 
.const [282] = Utf8 ()V 
.const [283] = Utf8 de/esolutions/fw/comm/attributes/AttributesBaseService 
.const [284] = Utf8 weakRefInfoProvider 
.const [285] = Utf8 Lde/esolutions/fw/comm/agent/diag/WeakRefAgentInfoProvider; 
.const [286] = Utf8 de/esolutions/fw/comm/agent/diag/AgentInfoMap 
.const [287] = Utf8 <init> 
.const [288] = Utf8 ()V 
.const [289] = Utf8 de/esolutions/fw/comm/agent/diag/info/AttributeServiceInfo 
.const [290] = Utf8 <init> 
.const [291] = Utf8 (IILjava/lang/String;Ljava/lang/String;)V 
.const [292] = Utf8 java/util/ArrayList 
.const [293] = Utf8 <init> 
.const [294] = Utf8 ()V 
.const [295] = Utf8 java/util/BitSet 
.const [296] = Utf8 <init> 
.const [297] = Utf8 (I)V 
.const [298] = Utf8 de/esolutions/fw/comm/attributes/AttributesBaseService 
.const [299] = Utf8 registerProxyListener 
.const [300] = Utf8 (Lde/esolutions/fw/comm/core/IProxyFrontend;)V 
.const [301] = Utf8 de/esolutions/fw/comm/attributes/AttributesBaseService 
.const [302] = Utf8 TRACE 
.const [303] = Utf8 Lde/esolutions/fw/util/tracing/TraceChannel; 
.const [304] = Utf8 de/esolutions/fw/comm/attributes/AttributesBaseService 
.const [305] = Utf8 findReplyByProxy 
.const [306] = Utf8 (Lde/esolutions/fw/comm/core/Proxy;)Lde/esolutions/fw/comm/core/IProxyFrontend; 
.const [307] = Utf8 de/esolutions/fw/comm/attributes/AttributesBaseService 
.const [308] = Utf8 name 
.const [309] = Utf8 Ljava/lang/String; 
.const [310] = Utf8 de/esolutions/fw/comm/attributes/AttributesBaseService 
.const [311] = Utf8 notificationMap 
.const [312] = Utf8 Ljava/util/Map; 
.const [313] = Utf8 de/esolutions/fw/comm/attributes/AttributesBaseService 
.const [314] = Utf8 attributeMap 
.const [315] = Utf8 Lde/esolutions/fw/comm/attributes/IAttributeBitMapProvider; 
.const [316] = Utf8 de/esolutions/fw/comm/agent/IAgentDiagnosis 
.const [317] = Utf8 registerInfoProvider 
.const [318] = Utf8 (Lde/esolutions/fw/comm/agent/IAgentInfoProvider;)V 
.const [319] = Utf8 de/esolutions/fw/comm/agent/IAgentDiagnosis 
.const [320] = Utf8 unregisterInfoProvider 
.const [321] = Utf8 (Lde/esolutions/fw/comm/agent/IAgentInfoProvider;)V 
.const [322] = Utf8 java/util/Map 
.const [323] = Utf8 size 
.const [324] = Utf8 ()I 
.const [325] = Utf8 de/esolutions/fw/comm/attributes/IAttributeBitMapProvider 
.const [326] = Utf8 getAttributeBit 
.const [327] = Utf8 (J)I 
.const [328] = Utf8 java/util/Map 
.const [329] = Utf8 entrySet 
.const [330] = Utf8 ()Ljava/util/Set; 
.const [331] = Utf8 java/util/Set 
.const [332] = Utf8 iterator 
.const [333] = Utf8 ()Ljava/util/Iterator; 
.const [334] = Utf8 java/util/Iterator 
.const [335] = Utf8 hasNext 
.const [336] = Utf8 ()Z 
.const [337] = Utf8 java/util/Iterator 
.const [338] = Utf8 next 
.const [339] = Utf8 ()Ljava/lang/Object; 
.const [340] = Utf8 java/util/Map$Entry 
.const [341] = Utf8 getValue 
.const [342] = Utf8 ()Ljava/lang/Object; 
.const [343] = Utf8 java/util/Map$Entry 
.const [344] = Utf8 getKey 
.const [345] = Utf8 ()Ljava/lang/Object; 
.const [346] = Utf8 java/util/List 
.const [347] = Utf8 add 
.const [348] = Utf8 (Ljava/lang/Object;)Z 
.const [349] = Utf8 java/util/Map 
.const [350] = Utf8 containsKey 
.const [351] = Utf8 (Ljava/lang/Object;)Z 
.const [352] = Utf8 java/util/Map 
.const [353] = Utf8 get 
.const [354] = Utf8 (Ljava/lang/Object;)Ljava/lang/Object; 
.const [355] = Utf8 de/esolutions/fw/comm/attributes/IAttributeBitMapProvider 
.const [356] = Utf8 getAttributesCount 
.const [357] = Utf8 ()I 
.const [358] = Utf8 java/util/Map 
.const [359] = Utf8 put 
.const [360] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 
.const [361] = Utf8 java/util/Map 
.const [362] = Utf8 remove 
.const [363] = Utf8 (Ljava/lang/Object;)Ljava/lang/Object; 
.const [364] = Utf8 java/util/Map 
.const [365] = Utf8 keySet 
.const [366] = Utf8 ()Ljava/util/Set; 
.const [367] = Utf8 de/esolutions/fw/comm/core/IProxyFrontend 
.const [368] = Utf8 getProxy 
.const [369] = Utf8 ()Lde/esolutions/fw/comm/core/Proxy; 
.const [370] = Utf8 de/esolutions/fw/comm/attributes/AttributesBaseService 
.const [371] = Class [370] 
.const [372] = Utf8 java/lang/Object 
.const [373] = Class [372] 
.const [374] = Utf8 de/esolutions/fw/comm/agent/IAgentInfoProvider 
.const [375] = Class [374] 
.const [376] = Utf8 de/esolutions/fw/comm/core/IProxyListener 
.const [377] = Class [376] 
.const [378] = Utf8 de/esolutions/fw/comm/agent/IAgentStateListener 
.const [379] = Class [378] 
.const [380] = Utf8 name 
.const [381] = Utf8 Ljava/lang/String; 
.const [382] = Utf8 notificationMap 
.const [383] = Utf8 Ljava/util/Map; 
.const [384] = Utf8 weakRefInfoProvider 
.const [385] = Utf8 Lde/esolutions/fw/comm/agent/diag/WeakRefAgentInfoProvider; 
.const [386] = Utf8 attributeMap 
.const [387] = Utf8 Lde/esolutions/fw/comm/attributes/IAttributeBitMapProvider; 
.const [388] = Utf8 TRACE 
.const [389] = Utf8 Lde/esolutions/fw/util/tracing/TraceChannel; 
.const [390] = Utf8 Code 
.const [391] = Utf8 <init> 
.const [392] = Utf8 (Ljava/lang/String;Lde/esolutions/fw/comm/attributes/IAttributeBitMapProvider;)V 
.const [393] = Utf8 agentStarted 
.const [394] = Utf8 (Lde/esolutions/fw/comm/agent/Agent;)V 
.const [395] = Utf8 agentAboutToStop 
.const [396] = Utf8 (Lde/esolutions/fw/comm/agent/Agent;)V 
.const [397] = Utf8 getAgentInfoMap 
.const [398] = Utf8 ()Lde/esolutions/fw/comm/agent/diag/AgentInfoMap; 
.const [399] = Utf8 getNotifications 
.const [400] = Utf8 (I)Ljava/util/List; 
.const [401] = Utf8 setNotification 
.const [402] = Utf8 (JLjava/lang/Object;)V 
.const [403] = Utf8 setNotification 
.const [404] = Utf8 (Ljava/lang/Object;)V 
.const [405] = Utf8 setNotification 
.const [406] = Utf8 ([JLjava/lang/Object;)V 
.const [407] = Utf8 clearNotification 
.const [408] = Utf8 (JLjava/lang/Object;)V 
.const [409] = Utf8 clearNotification 
.const [410] = Utf8 (Ljava/lang/Object;)V 
.const [411] = Utf8 clearNotification 
.const [412] = Utf8 ([JLjava/lang/Object;)V 
.const [413] = Utf8 proxyStateChanged 
.const [414] = Utf8 (Lde/esolutions/fw/comm/core/Proxy;I)V 
.const [415] = Utf8 findReplyByProxy 
.const [416] = Utf8 (Lde/esolutions/fw/comm/core/Proxy;)Lde/esolutions/fw/comm/core/IProxyFrontend; 
.const [417] = Utf8 registerProxyListener 
.const [418] = Utf8 (Lde/esolutions/fw/comm/core/IProxyFrontend;)V 
.const [419] = Utf8 <clinit> 
.const [420] = Utf8 ()V 
.end class 
