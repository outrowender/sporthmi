.version 50 0 
.class public super [335] 
.super [337] 
.field private final [338] [339] 
.field private final [340] [341] 
.field private final [342] [343] 
.field private final [344] [345] 
.field private final [346] [347] 
.field private [348] [349] 

.method public [351] : [352] 
    .attribute [350] .code stack 6 locals 0 
L0:     aload_0 
L1:     invokespecial [55] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [62] 
L9:     aload_0 
L10:    aload_2 
L11:    putfield [63] 
L14:    aload_0 
L15:    iload_3 
L16:    putfield [64] 
L19:    aload_0 
L20:    aload 4 
L22:    putfield [65] 
L25:    aload_0 
L26:    iload 5 
L28:    putfield [66] 
L31:    aload_0 
L32:    new [67] 
L35:    dup 
L36:    invokespecial [56] 
L39:    putfield [68] 
L42:    getstatic [3] 
L45:    iconst_1 
L46:    ldc [4] 
L48:    new [69] 
L51:    dup 
L52:    iload_3 
L53:    invokespecial [57] 
L56:    aload_2 
L57:    invokeinterface [70] 0 
L62:    invokevirtual [38] 
L65:    pop 
L66:    aload 4 
L68:    aload_2 
L69:    invokeinterface [71] 0 
L74:    getstatic [3] 
L77:    iconst_1 
L78:    ldc [6] 
L80:    new [69] 
L83:    dup 
L84:    iload_3 
L85:    invokespecial [57] 
L88:    aload_2 
L89:    invokeinterface [70] 0 
L94:    invokevirtual [38] 
L97:    pop 
L98:    return 
L99:    nop 
L100:   
    .end code 
.end method 

.method public synchronized [353] : [354] 
    .attribute [350] .code stack 6 locals 2 
L0:     getstatic [3] 
L3:     iconst_0 
L4:     ldc [7] 
L6:     new [69] 
L9:     dup 
L10:    aload_0 
L11:    getfield [34] 
L14:    invokespecial [57] 
L17:    aload_0 
L18:    getfield [33] 
L21:    invokeinterface [70] 0 
L26:    invokevirtual [38] 
L29:    pop 
L30:    aload_0 
L31:    getfield [37] 
L34:    invokevirtual [39] 
L37:    ifne L96 
L40:    getstatic [3] 
L43:    iconst_3 
L44:    ldc [8] 
L46:    new [69] 
L49:    dup 
L50:    aload_0 
L51:    getfield [37] 
L54:    invokevirtual [40] 
L57:    invokespecial [57] 
L60:    invokevirtual [41] 
L63:    pop 
L64:    aload_0 
L65:    getfield [37] 
L68:    invokevirtual [42] 
L71:    astore_1 
L72:    iconst_0 
L73:    istore_2 
L74:    iload_2 
L75:    aload_1 
L76:    arraylength 
L77:    if_icmpge L96 
L80:    aload_0 
L81:    aload_1 
L82:    iload_2 
L83:    aaload 
L84:    checkcast [9] 
L87:    invokevirtual [43] 
L90:    iinc 2 1 
L93:    goto L74 
L96:    aload_0 
L97:    getfield [35] 
L100:   aload_0 
L101:   getfield [33] 
L104:   invokeinterface [72] 0 
L109:   getstatic [3] 
L112:   iconst_0 
L113:   ldc [10] 
L115:   new [69] 
L118:   dup 
L119:   aload_0 
L120:   getfield [34] 
L123:   invokespecial [57] 
L126:   aload_0 
L127:   getfield [33] 
L130:   invokeinterface [70] 0 
L135:   invokevirtual [38] 
L138:   pop 
L139:   return 
L140:   
    .end code 
.end method 

.method public [355] : [356] 
    .attribute [350] .code stack 2 locals 0 
L0:     new [73] 
L3:     dup 
L4:     invokespecial [58] 
L7:     ldc [12] 
L9:     invokevirtual [44] 
L12:    aload_0 
L13:    getfield [34] 
L16:    invokevirtual [45] 
L19:    ldc [13] 
L21:    invokevirtual [44] 
L24:    invokevirtual [46] 
L27:    areturn 
L28:    
    .end code 
.end method 

.method public [357] : [358] 
    .attribute [350] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [33] 
L4:     invokeinterface [70] 0 
L9:     areturn 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public interface [359] : [360] 
    .attribute [350] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [33] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [361] : [362] 
    .attribute [350] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [35] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [363] : [364] 
    .attribute [350] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [34] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public synchronized [365] : [366] 
    .attribute [350] .code stack 10 locals 1 
L0:     aload_0 
L1:     getfield [37] 
L4:     aload_1 
L5:     invokevirtual [47] 
L8:     pop 
L9:     getstatic [3] 
L12:    iconst_0 
L13:    ldc [14] 
L15:    new [69] 
L18:    dup 
L19:    aload_0 
L20:    getfield [34] 
L23:    invokespecial [57] 
L26:    aload_0 
L27:    getfield [33] 
L30:    invokeinterface [70] 0 
L35:    new [69] 
L38:    dup 
L39:    aload_0 
L40:    getfield [37] 
L43:    invokevirtual [40] 
L46:    invokespecial [57] 
L49:    invokevirtual [48] 
L52:    pop 
L53:    getstatic [15] 
L56:    iconst_2 
L57:    ldc [16] 
L59:    new [74] 
L62:    dup 
L63:    aload_0 
L64:    getfield [36] 
L67:    invokespecial [59] 
L70:    aload_0 
L71:    getfield [33] 
L74:    invokeinterface [70] 0 
L79:    invokevirtual [49] 
L82:    new [69] 
L85:    dup 
L86:    aload_0 
L87:    getfield [33] 
L90:    invokeinterface [70] 0 
L95:    invokevirtual [50] 
L98:    invokespecial [57] 
L101:   new [69] 
L104:   dup 
L105:   aload_0 
L106:   getfield [37] 
L109:   invokevirtual [40] 
L112:   invokespecial [57] 
L115:   new [74] 
L118:   dup 
L119:   aload_1 
L120:   invokevirtual [51] 
L123:   invokespecial [59] 
L126:   invokevirtual [52] 
L129:   pop 
L130:   new [75] 
L133:   dup 
L134:   aload_0 
L135:   aload_1 
L136:   invokespecial [60] 
L139:   astore_2 
L140:   aload_0 
L141:   getfield [32] 
L144:   aload_0 
L145:   getfield [33] 
L148:   aload_0 
L149:   getfield [37] 
L152:   invokevirtual [40] 
L155:   aload_1 
L156:   aload_2 
L157:   invokeinterface [76] 0 
L162:   return 
L163:   nop 
L164:   
    .end code 
.end method 

.method public synchronized [367] : [368] 
    .attribute [350] .code stack 10 locals 2 
L0:     aload_0 
L1:     getfield [37] 
L4:     aload_1 
L5:     invokevirtual [53] 
L8:     istore_2 
L9:     getstatic [3] 
L12:    iconst_0 
L13:    ldc [19] 
L15:    new [69] 
L18:    dup 
L19:    aload_0 
L20:    getfield [34] 
L23:    invokespecial [57] 
L26:    aload_0 
L27:    getfield [33] 
L30:    invokeinterface [70] 0 
L35:    new [69] 
L38:    dup 
L39:    aload_0 
L40:    getfield [37] 
L43:    invokevirtual [40] 
L46:    invokespecial [57] 
L49:    invokevirtual [48] 
L52:    pop 
L53:    getstatic [15] 
L56:    iconst_2 
L57:    ldc [20] 
L59:    new [74] 
L62:    dup 
L63:    aload_0 
L64:    getfield [36] 
L67:    invokespecial [59] 
L70:    aload_0 
L71:    getfield [33] 
L74:    invokeinterface [70] 0 
L79:    invokevirtual [49] 
L82:    new [69] 
L85:    dup 
L86:    aload_0 
L87:    getfield [33] 
L90:    invokeinterface [70] 0 
L95:    invokevirtual [50] 
L98:    invokespecial [57] 
L101:   new [69] 
L104:   dup 
L105:   aload_0 
L106:   getfield [37] 
L109:   invokevirtual [40] 
L112:   invokespecial [57] 
L115:   new [74] 
L118:   dup 
L119:   aload_1 
L120:   invokevirtual [51] 
L123:   invokespecial [59] 
L126:   invokevirtual [52] 
L129:   pop 
L130:   new [77] 
L133:   dup 
L134:   aload_0 
L135:   invokespecial [61] 
L138:   astore_3 
L139:   iload_2 
L140:   ifeq L165 
L143:   aload_0 
L144:   getfield [32] 
L147:   aload_0 
L148:   getfield [33] 
L151:   aload_0 
L152:   getfield [37] 
L155:   invokevirtual [40] 
L158:   aload_1 
L159:   aload_3 
L160:   invokeinterface [78] 0 
L165:   return 
L166:   nop 
L167:   nop 
L168:   
    .end code 
.end method 

.method public synchronized [369] : [370] 
    .attribute [350] .code stack 8 locals 0 
L0:     aload_0 
L1:     getfield [35] 
L4:     aload_0 
L5:     getfield [33] 
L8:     aload_0 
L9:     getfield [37] 
L12:    invokevirtual [40] 
L15:    invokeinterface [79] 0 
L20:    getstatic [3] 
L23:    iconst_0 
L24:    ldc [22] 
L26:    new [69] 
L29:    dup 
L30:    aload_0 
L31:    getfield [34] 
L34:    invokespecial [57] 
L37:    aload_0 
L38:    getfield [33] 
L41:    invokeinterface [70] 0 
L46:    new [69] 
L49:    dup 
L50:    aload_0 
L51:    getfield [37] 
L54:    invokevirtual [40] 
L57:    invokespecial [57] 
L60:    invokevirtual [48] 
L63:    pop 
L64:    return 
L65:    nop 
L66:    nop 
L67:    nop 
L68:    
    .end code 
.end method 

.method public synchronized [371] : [372] 
    .attribute [350] .code stack 8 locals 0 
L0:     aload_0 
L1:     getfield [35] 
L4:     aload_0 
L5:     getfield [33] 
L8:     aload_0 
L9:     getfield [37] 
L12:    invokevirtual [40] 
L15:    invokeinterface [79] 0 
L20:    getstatic [3] 
L23:    iconst_0 
L24:    ldc [23] 
L26:    new [69] 
L29:    dup 
L30:    aload_0 
L31:    getfield [34] 
L34:    invokespecial [57] 
L37:    aload_0 
L38:    getfield [33] 
L41:    invokeinterface [70] 0 
L46:    new [69] 
L49:    dup 
L50:    aload_0 
L51:    getfield [37] 
L54:    invokevirtual [40] 
L57:    invokespecial [57] 
L60:    invokevirtual [48] 
L63:    pop 
L64:    aload_1 
L65:    invokevirtual [54] 
L68:    return 
L69:    nop 
L70:    nop 
L71:    nop 
L72:    
    .end code 
.end method 

.method public synchronized [373] : [374] 
    .attribute [350] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [37] 
L4:     invokevirtual [40] 
L7:     areturn 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [80] 
.const [3] = Field [81] [82] 
.const [4] = String [83] 
.const [5] = Class [84] 
.const [6] = String [85] 
.const [7] = String [86] 
.const [8] = String [87] 
.const [9] = Class [88] 
.const [10] = String [89] 
.const [11] = Class [90] 
.const [12] = String [91] 
.const [13] = String [92] 
.const [14] = String [93] 
.const [15] = Field [94] [95] 
.const [16] = String [96] 
.const [17] = Class [97] 
.const [18] = Class [98] 
.const [19] = String [99] 
.const [20] = String [100] 
.const [21] = Class [101] 
.const [22] = String [102] 
.const [23] = String [103] 
.const [24] = Class [104] 
.const [25] = Class [105] 
.const [26] = Class [106] 
.const [27] = Class [107] 
.const [28] = Class [108] 
.const [29] = Class [109] 
.const [30] = Class [110] 
.const [31] = Class [111] 
.const [32] = Field [112] [113] 
.const [33] = Field [114] [115] 
.const [34] = Field [116] [117] 
.const [35] = Field [118] [119] 
.const [36] = Field [120] [121] 
.const [37] = Field [122] [123] 
.const [38] = Method [124] [125] 
.const [39] = Method [126] [127] 
.const [40] = Method [128] [129] 
.const [41] = Method [130] [131] 
.const [42] = Method [132] [133] 
.const [43] = Method [134] [135] 
.const [44] = Method [136] [137] 
.const [45] = Method [138] [139] 
.const [46] = Method [140] [141] 
.const [47] = Method [142] [143] 
.const [48] = Method [144] [145] 
.const [49] = Method [146] [147] 
.const [50] = Method [148] [149] 
.const [51] = Method [150] [151] 
.const [52] = Method [152] [153] 
.const [53] = Method [154] [155] 
.const [54] = Method [156] [157] 
.const [55] = Method [158] [159] 
.const [56] = Method [160] [161] 
.const [57] = Method [162] [163] 
.const [58] = Method [164] [165] 
.const [59] = Method [166] [167] 
.const [60] = Method [168] [169] 
.const [61] = Method [170] [171] 
.const [62] = Field [172] [173] 
.const [63] = Field [174] [175] 
.const [64] = Field [176] [177] 
.const [65] = Field [178] [179] 
.const [66] = Field [180] [181] 
.const [67] = Class [182] 
.const [68] = Field [183] [184] 
.const [69] = Class [185] 
.const [70] = InterfaceMethod [186] [187] 
.const [71] = InterfaceMethod [188] [189] 
.const [72] = InterfaceMethod [190] [191] 
.const [73] = Class [192] 
.const [74] = Class [193] 
.const [75] = Class [194] 
.const [76] = InterfaceMethod [195] [196] 
.const [77] = Class [197] 
.const [78] = InterfaceMethod [198] [199] 
.const [79] = InterfaceMethod [200] [201] 
.const [80] = Utf8 java/util/ArrayList 
.const [81] = Class [202] 
.const [82] = NameAndType [203] [204] 
.const [83] = Utf8 '+ register worker for service=#%1:%2' 
.const [84] = Utf8 java/lang/Integer 
.const [85] = Utf8 '- register worker for service=#%1:%2' 
.const [86] = Utf8 '+ shutdown worker for service=#%1:%2' 
.const [87] = Utf8 'shutdown called but %1 stubs still attached!' 
.const [88] = Utf8 de/esolutions/fw/comm/agent/service/Stub 
.const [89] = Utf8 '- shutdown worker for service=#%1:%2' 
.const [90] = Utf8 java/lang/StringBuffer 
.const [91] = Utf8 '[Service #' 
.const [92] = Utf8 ']' 
.const [93] = Utf8 'service=#%1:%2 attach stub. count=%3' 
.const [94] = Class [205] 
.const [95] = NameAndType [206] [207] 
.const [96] = Utf8 "on='%1' event='interface' interface='%2:%3' info='client-connected' count='%4' home='%5'" 
.const [97] = Utf8 java/lang/Short 
.const [98] = Utf8 de/esolutions/fw/comm/agent/service/ServiceHandler$1 
.const [99] = Utf8 'service=#%1:%2 detach stub. count=%3' 
.const [100] = Utf8 "on='%1' event='interface' interface='%2:%3' info='client-disconnected' count='%4' home='%5'" 
.const [101] = Utf8 de/esolutions/fw/comm/agent/service/ServiceHandler$2 
.const [102] = Utf8 'service=#%1:%2 completed detach stub. count=%3' 
.const [103] = Utf8 'service=#%1:%2 completed attach stub. count=%3' 
.const [104] = Utf8 de/esolutions/fw/comm/agent/service/ServiceHandler 
.const [105] = Utf8 java/lang/Object 
.const [106] = Utf8 de/esolutions/fw/comm/agent/tracing/CommAgentTracing 
.const [107] = Utf8 de/esolutions/fw/comm/core/IService 
.const [108] = Utf8 de/esolutions/fw/util/tracing/TraceChannel 
.const [109] = Utf8 de/esolutions/fw/comm/core/IServiceWorker 
.const [110] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [111] = Utf8 de/esolutions/fw/comm/agent/service/IServiceHandlerListener 
.const [112] = Class [208] 
.const [113] = NameAndType [209] [210] 
.const [114] = Class [211] 
.const [115] = NameAndType [212] [213] 
.const [116] = Class [214] 
.const [117] = NameAndType [215] [216] 
.const [118] = Class [217] 
.const [119] = NameAndType [218] [219] 
.const [120] = Class [220] 
.const [121] = NameAndType [221] [222] 
.const [122] = Class [223] 
.const [123] = NameAndType [224] [225] 
.const [124] = Class [226] 
.const [125] = NameAndType [227] [228] 
.const [126] = Class [229] 
.const [127] = NameAndType [230] [231] 
.const [128] = Class [232] 
.const [129] = NameAndType [233] [234] 
.const [130] = Class [235] 
.const [131] = NameAndType [236] [237] 
.const [132] = Class [238] 
.const [133] = NameAndType [239] [240] 
.const [134] = Class [241] 
.const [135] = NameAndType [242] [243] 
.const [136] = Class [244] 
.const [137] = NameAndType [245] [246] 
.const [138] = Class [247] 
.const [139] = NameAndType [248] [249] 
.const [140] = Class [250] 
.const [141] = NameAndType [251] [252] 
.const [142] = Class [253] 
.const [143] = NameAndType [254] [255] 
.const [144] = Class [256] 
.const [145] = NameAndType [257] [258] 
.const [146] = Class [259] 
.const [147] = NameAndType [260] [261] 
.const [148] = Class [262] 
.const [149] = NameAndType [263] [264] 
.const [150] = Class [265] 
.const [151] = NameAndType [266] [267] 
.const [152] = Class [268] 
.const [153] = NameAndType [269] [270] 
.const [154] = Class [271] 
.const [155] = NameAndType [272] [273] 
.const [156] = Class [274] 
.const [157] = NameAndType [275] [276] 
.const [158] = Class [277] 
.const [159] = NameAndType [278] [279] 
.const [160] = Class [280] 
.const [161] = NameAndType [281] [282] 
.const [162] = Class [283] 
.const [163] = NameAndType [284] [285] 
.const [164] = Class [286] 
.const [165] = NameAndType [287] [288] 
.const [166] = Class [289] 
.const [167] = NameAndType [290] [291] 
.const [168] = Class [292] 
.const [169] = NameAndType [293] [294] 
.const [170] = Class [295] 
.const [171] = NameAndType [296] [297] 
.const [172] = Class [298] 
.const [173] = NameAndType [299] [300] 
.const [174] = Class [301] 
.const [175] = NameAndType [302] [303] 
.const [176] = Class [304] 
.const [177] = NameAndType [305] [306] 
.const [178] = Class [307] 
.const [179] = NameAndType [308] [309] 
.const [180] = Class [310] 
.const [181] = NameAndType [311] [312] 
.const [182] = Utf8 java/util/ArrayList 
.const [183] = Class [313] 
.const [184] = NameAndType [314] [315] 
.const [185] = Utf8 java/lang/Integer 
.const [186] = Class [316] 
.const [187] = NameAndType [317] [318] 
.const [188] = Class [319] 
.const [189] = NameAndType [320] [321] 
.const [190] = Class [322] 
.const [191] = NameAndType [323] [324] 
.const [192] = Utf8 java/lang/StringBuffer 
.const [193] = Utf8 java/lang/Short 
.const [194] = Utf8 de/esolutions/fw/comm/agent/service/ServiceHandler$1 
.const [195] = Class [325] 
.const [196] = NameAndType [326] [327] 
.const [197] = Utf8 de/esolutions/fw/comm/agent/service/ServiceHandler$2 
.const [198] = Class [328] 
.const [199] = NameAndType [329] [330] 
.const [200] = Class [331] 
.const [201] = NameAndType [332] [333] 
.const [202] = Utf8 de/esolutions/fw/comm/agent/tracing/CommAgentTracing 
.const [203] = Utf8 SERVICE 
.const [204] = Utf8 Lde/esolutions/fw/util/tracing/TraceChannel; 
.const [205] = Utf8 de/esolutions/fw/comm/agent/tracing/CommAgentTracing 
.const [206] = Utf8 COMM 
.const [207] = Utf8 Lde/esolutions/fw/util/tracing/TraceChannel; 
.const [208] = Utf8 de/esolutions/fw/comm/agent/service/ServiceHandler 
.const [209] = Utf8 listener 
.const [210] = Utf8 Lde/esolutions/fw/comm/agent/service/IServiceHandlerListener; 
.const [211] = Utf8 de/esolutions/fw/comm/agent/service/ServiceHandler 
.const [212] = Utf8 service 
.const [213] = Utf8 Lde/esolutions/fw/comm/core/IService; 
.const [214] = Utf8 de/esolutions/fw/comm/agent/service/ServiceHandler 
.const [215] = Utf8 serviceID 
.const [216] = Utf8 I 
.const [217] = Utf8 de/esolutions/fw/comm/agent/service/ServiceHandler 
.const [218] = Utf8 worker 
.const [219] = Utf8 Lde/esolutions/fw/comm/core/IServiceWorker; 
.const [220] = Utf8 de/esolutions/fw/comm/agent/service/ServiceHandler 
.const [221] = Utf8 myAgentID 
.const [222] = Utf8 S 
.const [223] = Utf8 de/esolutions/fw/comm/agent/service/ServiceHandler 
.const [224] = Utf8 stubList 
.const [225] = Utf8 Ljava/util/ArrayList; 
.const [226] = Utf8 de/esolutions/fw/util/tracing/TraceChannel 
.const [227] = Utf8 log 
.const [228] = Utf8 (SLjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)Z 
.const [229] = Utf8 java/util/ArrayList 
.const [230] = Utf8 isEmpty 
.const [231] = Utf8 ()Z 
.const [232] = Utf8 java/util/ArrayList 
.const [233] = Utf8 size 
.const [234] = Utf8 ()I 
.const [235] = Utf8 de/esolutions/fw/util/tracing/TraceChannel 
.const [236] = Utf8 log 
.const [237] = Utf8 (SLjava/lang/String;Ljava/lang/Object;)Z 
.const [238] = Utf8 java/util/ArrayList 
.const [239] = Utf8 toArray 
.const [240] = Utf8 ()[Ljava/lang/Object; 
.const [241] = Utf8 de/esolutions/fw/comm/agent/service/ServiceHandler 
.const [242] = Utf8 detachedStub 
.const [243] = Utf8 (Lde/esolutions/fw/comm/agent/service/Stub;)V 
.const [244] = Utf8 java/lang/StringBuffer 
.const [245] = Utf8 append 
.const [246] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [247] = Utf8 java/lang/StringBuffer 
.const [248] = Utf8 append 
.const [249] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [250] = Utf8 java/lang/StringBuffer 
.const [251] = Utf8 toString 
.const [252] = Utf8 ()Ljava/lang/String; 
.const [253] = Utf8 java/util/ArrayList 
.const [254] = Utf8 add 
.const [255] = Utf8 (Ljava/lang/Object;)Z 
.const [256] = Utf8 de/esolutions/fw/util/tracing/TraceChannel 
.const [257] = Utf8 log 
.const [258] = Utf8 (SLjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z 
.const [259] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [260] = Utf8 getServiceUUID 
.const [261] = Utf8 ()Lde/esolutions/fw/comm/core/ServiceUUID; 
.const [262] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [263] = Utf8 getHandle 
.const [264] = Utf8 ()I 
.const [265] = Utf8 de/esolutions/fw/comm/agent/service/Stub 
.const [266] = Utf8 getRemoteAgentID 
.const [267] = Utf8 ()S 
.const [268] = Utf8 de/esolutions/fw/util/tracing/TraceChannel 
.const [269] = Utf8 log 
.const [270] = Utf8 (SLjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z 
.const [271] = Utf8 java/util/ArrayList 
.const [272] = Utf8 remove 
.const [273] = Utf8 (Ljava/lang/Object;)Z 
.const [274] = Utf8 de/esolutions/fw/comm/agent/service/Stub 
.const [275] = Utf8 goLive 
.const [276] = Utf8 ()V 
.const [277] = Utf8 java/lang/Object 
.const [278] = Utf8 <init> 
.const [279] = Utf8 ()V 
.const [280] = Utf8 java/util/ArrayList 
.const [281] = Utf8 <init> 
.const [282] = Utf8 ()V 
.const [283] = Utf8 java/lang/Integer 
.const [284] = Utf8 <init> 
.const [285] = Utf8 (I)V 
.const [286] = Utf8 java/lang/StringBuffer 
.const [287] = Utf8 <init> 
.const [288] = Utf8 ()V 
.const [289] = Utf8 java/lang/Short 
.const [290] = Utf8 <init> 
.const [291] = Utf8 (S)V 
.const [292] = Utf8 de/esolutions/fw/comm/agent/service/ServiceHandler$1 
.const [293] = Utf8 <init> 
.const [294] = Utf8 (Lde/esolutions/fw/comm/agent/service/ServiceHandler;Lde/esolutions/fw/comm/agent/service/Stub;)V 
.const [295] = Utf8 de/esolutions/fw/comm/agent/service/ServiceHandler$2 
.const [296] = Utf8 <init> 
.const [297] = Utf8 (Lde/esolutions/fw/comm/agent/service/ServiceHandler;)V 
.const [298] = Utf8 de/esolutions/fw/comm/agent/service/ServiceHandler 
.const [299] = Utf8 listener 
.const [300] = Utf8 Lde/esolutions/fw/comm/agent/service/IServiceHandlerListener; 
.const [301] = Utf8 de/esolutions/fw/comm/agent/service/ServiceHandler 
.const [302] = Utf8 service 
.const [303] = Utf8 Lde/esolutions/fw/comm/core/IService; 
.const [304] = Utf8 de/esolutions/fw/comm/agent/service/ServiceHandler 
.const [305] = Utf8 serviceID 
.const [306] = Utf8 I 
.const [307] = Utf8 de/esolutions/fw/comm/agent/service/ServiceHandler 
.const [308] = Utf8 worker 
.const [309] = Utf8 Lde/esolutions/fw/comm/core/IServiceWorker; 
.const [310] = Utf8 de/esolutions/fw/comm/agent/service/ServiceHandler 
.const [311] = Utf8 myAgentID 
.const [312] = Utf8 S 
.const [313] = Utf8 de/esolutions/fw/comm/agent/service/ServiceHandler 
.const [314] = Utf8 stubList 
.const [315] = Utf8 Ljava/util/ArrayList; 
.const [316] = Utf8 de/esolutions/fw/comm/core/IService 
.const [317] = Utf8 getInstanceID 
.const [318] = Utf8 ()Lde/esolutions/fw/comm/core/ServiceInstanceID; 
.const [319] = Utf8 de/esolutions/fw/comm/core/IServiceWorker 
.const [320] = Utf8 registerService 
.const [321] = Utf8 (Lde/esolutions/fw/comm/core/IService;)V 
.const [322] = Utf8 de/esolutions/fw/comm/core/IServiceWorker 
.const [323] = Utf8 unregisterService 
.const [324] = Utf8 (Lde/esolutions/fw/comm/core/IService;)V 
.const [325] = Utf8 de/esolutions/fw/comm/agent/service/IServiceHandlerListener 
.const [326] = Utf8 serviceStubAttached 
.const [327] = Utf8 (Lde/esolutions/fw/comm/core/IService;ILde/esolutions/fw/comm/core/IStub;Lde/esolutions/fw/comm/agent/service/IServiceHandlerCallback;)V 
.const [328] = Utf8 de/esolutions/fw/comm/agent/service/IServiceHandlerListener 
.const [329] = Utf8 serviceStubDetached 
.const [330] = Utf8 (Lde/esolutions/fw/comm/core/IService;ILde/esolutions/fw/comm/core/IStub;Lde/esolutions/fw/comm/agent/service/IServiceHandlerCallback;)V 
.const [331] = Utf8 de/esolutions/fw/comm/core/IServiceWorker 
.const [332] = Utf8 stubCountChanged 
.const [333] = Utf8 (Lde/esolutions/fw/comm/core/IService;I)V 
.const [334] = Utf8 de/esolutions/fw/comm/agent/service/ServiceHandler 
.const [335] = Class [334] 
.const [336] = Utf8 java/lang/Object 
.const [337] = Class [336] 
.const [338] = Utf8 service 
.const [339] = Utf8 Lde/esolutions/fw/comm/core/IService; 
.const [340] = Utf8 serviceID 
.const [341] = Utf8 I 
.const [342] = Utf8 listener 
.const [343] = Utf8 Lde/esolutions/fw/comm/agent/service/IServiceHandlerListener; 
.const [344] = Utf8 worker 
.const [345] = Utf8 Lde/esolutions/fw/comm/core/IServiceWorker; 
.const [346] = Utf8 myAgentID 
.const [347] = Utf8 S 
.const [348] = Utf8 stubList 
.const [349] = Utf8 Ljava/util/ArrayList; 
.const [350] = Utf8 Code 
.const [351] = Utf8 <init> 
.const [352] = Utf8 (Lde/esolutions/fw/comm/agent/service/IServiceHandlerListener;Lde/esolutions/fw/comm/core/IService;ILde/esolutions/fw/comm/core/IServiceWorker;S)V 
.const [353] = Utf8 shutdown 
.const [354] = Utf8 ()V 
.const [355] = Utf8 toString 
.const [356] = Utf8 ()Ljava/lang/String; 
.const [357] = Utf8 getInstanceID 
.const [358] = Utf8 ()Lde/esolutions/fw/comm/core/ServiceInstanceID; 
.const [359] = Utf8 getService 
.const [360] = Utf8 ()Lde/esolutions/fw/comm/core/IService; 
.const [361] = Utf8 getServiceWorker 
.const [362] = Utf8 ()Lde/esolutions/fw/comm/core/IServiceWorker; 
.const [363] = Utf8 getServiceID 
.const [364] = Utf8 ()I 
.const [365] = Utf8 attachedStub 
.const [366] = Utf8 (Lde/esolutions/fw/comm/agent/service/Stub;)V 
.const [367] = Utf8 detachedStub 
.const [368] = Utf8 (Lde/esolutions/fw/comm/agent/service/Stub;)V 
.const [369] = Utf8 detachedStubComplete 
.const [370] = Utf8 ()V 
.const [371] = Utf8 attachtedStubComplete 
.const [372] = Utf8 (Lde/esolutions/fw/comm/agent/service/Stub;)V 
.const [373] = Utf8 getStubCount 
.const [374] = Utf8 ()I 
.end class 
