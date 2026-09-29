.version 50 0 
.class public super [439] 
.super [441] 
.implements [443] 
.implements [445] 
.field private final [446] [447] 
.field private [448] [449] 
.field private [450] [451] 
.field private [452] [453] 
.field private [454] [455] 
.field static synthetic [456] [457] 

.method public [459] : [460] 
    .attribute [458] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [72] 
L4:     aload_0 
L5:     getstatic [5] 
L8:     putfield [85] 
L11:    aload_0 
L12:    new [86] 
L15:    dup 
L16:    invokespecial [73] 
L19:    putfield [87] 
L22:    aload_0 
L23:    getfield [52] 
L26:    iconst_0 
L27:    ldc [7] 
L29:    invokevirtual [54] 
L32:    pop 
L33:    aload_0 
L34:    getstatic [8] 
L37:    putfield [88] 
L40:    return 
L41:    nop 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 

.method public [461] : [462] 
    .attribute [458] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [89] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [463] : [464] 
    .attribute [458] .code stack 6 locals 0 
L0:     aload_0 
L1:     new [90] 
L4:     dup 
L5:     aload_0 
L6:     getfield [55] 
L9:     getstatic [10] 
L12:    ifnonnull L27 
L15:    ldc [11] 
L17:    invokestatic [12] 
L20:    dup 
L21:    putstatic [74] 
L24:    goto L30 
L27:    getstatic [10] 
L30:    invokevirtual [57] 
L33:    aload_0 
L34:    invokespecial [75] 
L37:    putfield [91] 
L40:    aload_0 
L41:    getfield [58] 
L44:    invokevirtual [59] 
L47:    return 
L48:    
    .end code 
.end method 

.method public [465] : [466] 
    .attribute [458] .code stack 2 locals 2 
L0:     aload_0 
L1:     getfield [58] 
L4:     invokevirtual [60] 
L7:     aload_0 
L8:     dup 
L9:     astore_1 
L10:    monitorenter 
        .catch [0] from L11 to L20 using L23 
L11:    aload_0 
L12:    getfield [53] 
L15:    invokevirtual [61] 
L18:    aload_1 
L19:    monitorexit 
L20:    goto L28 
        .catch [0] from L23 to L26 using L23 
L23:    astore_2 
L24:    aload_1 
L25:    monitorexit 
L26:    aload_2 
L27:    athrow 
L28:    return 
L29:    nop 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [467] : [468] 
    .attribute [458] .code stack 5 locals 2 
L0:     aload_0 
L1:     getfield [55] 
L4:     aload_1 
L5:     invokeinterface [92] 0 
L10:    astore_2 
L11:    aload_0 
L12:    aload_1 
L13:    invokespecial [76] 
L16:    astore_3 
L17:    aload_0 
L18:    getfield [52] 
L21:    iconst_0 
L22:    ldc [13] 
L24:    aload_3 
L25:    aload_2 
L26:    invokespecial [77] 
L29:    invokevirtual [57] 
L32:    invokevirtual [62] 
L35:    pop 
L36:    aload_0 
L37:    aload_3 
L38:    aload_2 
L39:    invokespecial [78] 
L42:    aload_2 
L43:    areturn 
L44:    
    .end code 
.end method 

.method public enum [469] : [470] 
    .attribute [458] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [471] : [472] 
    .attribute [458] .code stack 9 locals 5 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [76] 
L5:     astore_3 
L6:     aload_0 
L7:     aload_3 
L8:     aload_2 
L9:     invokespecial [79] 
L12:    aload_1 
L13:    ldc [14] 
L15:    invokeinterface [93] 0 
L20:    astore 4 
L22:    aload_1 
L23:    ldc [15] 
L25:    invokeinterface [93] 0 
L30:    astore 5 
L32:    aload_0 
L33:    getfield [55] 
L36:    aload_1 
L37:    invokeinterface [94] 0 
L42:    istore 6 
L44:    aload_0 
L45:    getfield [56] 
L48:    ifnull L84 
L51:    aload_0 
L52:    getfield [56] 
L55:    aload_3 
L56:    invokevirtual [63] 
L59:    astore 7 
L61:    aload 7 
L63:    ifnull L84 
L66:    aload_2 
L67:    instanceof [16] 
L70:    ifeq L84 
L73:    aload 7 
L75:    aload_2 
L76:    checkcast [16] 
L79:    invokeinterface [95] 0 
L84:    aload_0 
L85:    getfield [52] 
L88:    iconst_0 
L89:    ldc [17] 
L91:    aload 4 
L93:    aload 5 
L95:    aload_3 
L96:    new [96] 
L99:    dup 
L100:   iload 6 
L102:   invokespecial [80] 
L105:   invokevirtual [64] 
L108:   pop 
L109:   return 
L110:   nop 
L111:   nop 
L112:   
    .end code 
.end method 

.method private synchronized [473] : [474] 
    .attribute [458] .code stack 6 locals 3 
L0:     aload_0 
L1:     getfield [52] 
L4:     iconst_0 
L5:     ldc [19] 
L7:     aload_1 
L8:     iload_2 
L9:     invokestatic [20] 
L12:    invokevirtual [62] 
L15:    pop 
L16:    aconst_null 
L17:    astore_3 
L18:    aload_1 
L19:    iload_2 
L20:    invokestatic [21] 
L23:    astore 4 
L25:    aload_0 
L26:    getfield [53] 
L29:    aload 4 
L31:    invokevirtual [65] 
L34:    ifeq L88 
L37:    aload_0 
L38:    getfield [53] 
L41:    aload 4 
L43:    invokevirtual [66] 
L46:    checkcast [22] 
L49:    astore 5 
L51:    aload 5 
L53:    invokeinterface [97] 0 
L58:    astore_3 
L59:    aload_0 
L60:    getfield [52] 
L63:    iconst_0 
L64:    ldc [23] 
L66:    aload_1 
L67:    iload_2 
L68:    invokestatic [20] 
L71:    aload 5 
L73:    invokeinterface [98] 0 
L78:    invokestatic [20] 
L81:    invokevirtual [67] 
L84:    pop 
L85:    goto L104 
L88:    aload_0 
L89:    getfield [52] 
L92:    iconst_3 
L93:    ldc [24] 
L95:    aload_1 
L96:    iload_2 
L97:    invokestatic [20] 
L100:   invokevirtual [62] 
L103:   pop 
L104:   aload_3 
L105:   areturn 
L106:   nop 
L107:   nop 
L108:   
    .end code 
.end method 

.method private [475] : [476] 
    .attribute [458] .code stack 2 locals 3 
L0:     ldc [25] 
L2:     astore_2 
L3:     iconst_m1 
L4:     istore_3 
L5:     aload_1 
L6:     ldc [14] 
L8:     invokeinterface [93] 0 
L13:    ifnull L28 
L16:    aload_1 
L17:    ldc [14] 
L19:    invokeinterface [93] 0 
L24:    checkcast [26] 
L27:    astore_2 
L28:    aload_1 
L29:    ldc [15] 
L31:    invokeinterface [93] 0 
L36:    ifnull L58 
L39:    aload_1 
L40:    ldc [15] 
L42:    invokeinterface [93] 0 
L47:    checkcast [27] 
L50:    astore 4 
L52:    aload 4 
L54:    invokevirtual [68] 
L57:    istore_3 
L58:    aload_2 
L59:    iload_3 
L60:    invokestatic [21] 
L63:    astore 4 
L65:    aload 4 
L67:    areturn 
L68:    
    .end code 
.end method 

.method private synchronized [477] : [478] 
    .attribute [458] .code stack 5 locals 2 
L0:     aload_0 
L1:     getfield [52] 
L4:     iconst_0 
L5:     ldc [28] 
L7:     aload_1 
L8:     aload_2 
L9:     invokespecial [77] 
L12:    invokevirtual [57] 
L15:    invokevirtual [62] 
L18:    pop 
L19:    aload_0 
L20:    getfield [53] 
L23:    aload_1 
L24:    invokevirtual [65] 
L27:    ifeq L89 
L30:    aload_0 
L31:    getfield [52] 
L34:    iconst_0 
L35:    ldc [29] 
L37:    invokevirtual [54] 
L40:    pop 
L41:    aload_0 
L42:    getfield [53] 
L45:    aload_1 
L46:    invokevirtual [66] 
L49:    astore_3 
L50:    aload_3 
L51:    instanceof [22] 
L54:    ifeq L75 
L57:    aload_3 
L58:    checkcast [22] 
L61:    astore 4 
L63:    aload 4 
L65:    aload_2 
L66:    invokeinterface [100] 0 
L71:    pop 
L72:    goto L86 
L75:    aload_0 
L76:    getfield [52] 
L79:    iconst_3 
L80:    ldc [30] 
L82:    invokevirtual [54] 
L85:    pop 
L86:    goto L129 
L89:    aload_0 
L90:    getfield [52] 
L93:    iconst_0 
L94:    ldc [31] 
L96:    invokevirtual [54] 
L99:    pop 
L100:   new [101] 
L103:   dup 
L104:   invokespecial [81] 
L107:   invokestatic [33] 
L110:   astore_3 
L111:   aload_3 
L112:   aload_2 
L113:   invokeinterface [100] 0 
L118:   pop 
L119:   aload_0 
L120:   getfield [53] 
L123:   aload_1 
L124:   aload_3 
L125:   invokevirtual [69] 
L128:   pop 
L129:   aload_0 
L130:   getfield [52] 
L133:   iconst_0 
L134:   ldc [34] 
L136:   invokevirtual [54] 
L139:   pop 
L140:   return 
L141:   nop 
L142:   nop 
L143:   nop 
L144:   
    .end code 
.end method 

.method private synchronized [479] : [480] 
    .attribute [458] .code stack 7 locals 4 
L0:     aload_0 
L1:     getfield [52] 
L4:     iconst_0 
L5:     ldc [35] 
L7:     aload_1 
L8:     aload_2 
L9:     invokevirtual [62] 
L12:    pop 
L13:    aload_0 
L14:    getfield [53] 
L17:    aload_1 
L18:    invokevirtual [65] 
L21:    ifeq L150 
L24:    aload_0 
L25:    getfield [53] 
L28:    aload_1 
L29:    invokevirtual [66] 
L32:    checkcast [22] 
L35:    astore_3 
L36:    aload_3 
L37:    aload_2 
L38:    invokeinterface [102] 0 
L43:    istore 4 
L45:    iload 4 
L47:    ifne L107 
L50:    aload_0 
L51:    getfield [52] 
L54:    iconst_3 
L55:    ldc [36] 
L57:    aload_1 
L58:    aload_2 
L59:    invokevirtual [62] 
L62:    pop 
L63:    aload_3 
L64:    invokeinterface [103] 0 
L69:    astore 5 
L71:    aload 5 
L73:    invokeinterface [104] 0 
L78:    ifeq L107 
L81:    aload 5 
L83:    invokeinterface [105] 0 
L88:    astore 6 
L90:    aload_0 
L91:    getfield [52] 
L94:    iconst_0 
L95:    ldc [37] 
L97:    aload_1 
L98:    aload 6 
L100:   invokevirtual [62] 
L103:   pop 
L104:   goto L71 
L107:   aload_0 
L108:   getfield [52] 
L111:   iconst_0 
L112:   ldc [38] 
L114:   aload_1 
L115:   new [99] 
L118:   dup 
L119:   aload_3 
L120:   invokeinterface [98] 0 
L125:   invokespecial [82] 
L128:   invokevirtual [62] 
L131:   pop 
L132:   aload_3 
L133:   invokeinterface [98] 0 
L138:   ifne L150 
L141:   aload_0 
L142:   getfield [53] 
L145:   aload_1 
L146:   invokevirtual [70] 
L149:   pop 
L150:   return 
L151:   nop 
L152:   
    .end code 
.end method 

.method public [481] : [482] 
    .attribute [458] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     iload_2 
L3:     invokespecial [83] 
L6:     areturn 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [483] : [484] 
    .attribute [458] .code stack 2 locals 1 
        .catch [3] from L0 to L4 using L5 
L0:     aload_0 
L1:     invokestatic [2] 
L4:     areturn 
L5:     astore_1 
L6:     new [84] 
L9:     dup 
L10:    invokespecial [71] 
L13:    aload_1 
L14:    invokevirtual [51] 
L17:    athrow 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [106] [107] 
.const [3] = Class [108] 
.const [4] = Class [109] 
.const [5] = Field [110] [111] 
.const [6] = Class [112] 
.const [7] = String [113] 
.const [8] = Field [114] [115] 
.const [9] = Class [116] 
.const [10] = Field [117] [118] 
.const [11] = String [119] 
.const [12] = Method [120] [121] 
.const [13] = String [122] 
.const [14] = String [123] 
.const [15] = String [124] 
.const [16] = Class [125] 
.const [17] = String [126] 
.const [18] = Class [127] 
.const [19] = String [128] 
.const [20] = Method [129] [130] 
.const [21] = Method [131] [132] 
.const [22] = Class [133] 
.const [23] = String [134] 
.const [24] = String [135] 
.const [25] = String [136] 
.const [26] = Class [137] 
.const [27] = Class [138] 
.const [28] = String [139] 
.const [29] = String [140] 
.const [30] = String [141] 
.const [31] = String [142] 
.const [32] = Class [143] 
.const [33] = Method [144] [145] 
.const [34] = String [146] 
.const [35] = String [147] 
.const [36] = String [148] 
.const [37] = String [149] 
.const [38] = String [150] 
.const [39] = Class [151] 
.const [40] = Class [152] 
.const [41] = Class [153] 
.const [42] = Class [154] 
.const [43] = Class [155] 
.const [44] = Class [156] 
.const [45] = Class [157] 
.const [46] = Class [158] 
.const [47] = Class [159] 
.const [48] = Class [160] 
.const [49] = Class [161] 
.const [50] = Class [162] 
.const [51] = Method [163] [164] 
.const [52] = Field [165] [166] 
.const [53] = Field [167] [168] 
.const [54] = Method [169] [170] 
.const [55] = Field [171] [172] 
.const [56] = Field [173] [174] 
.const [57] = Method [175] [176] 
.const [58] = Field [177] [178] 
.const [59] = Method [179] [180] 
.const [60] = Method [181] [182] 
.const [61] = Method [183] [184] 
.const [62] = Method [185] [186] 
.const [63] = Method [187] [188] 
.const [64] = Method [189] [190] 
.const [65] = Method [191] [192] 
.const [66] = Method [193] [194] 
.const [67] = Method [195] [196] 
.const [68] = Method [197] [198] 
.const [69] = Method [199] [200] 
.const [70] = Method [201] [202] 
.const [71] = Method [203] [204] 
.const [72] = Method [205] [206] 
.const [73] = Method [207] [208] 
.const [74] = Field [209] [210] 
.const [75] = Method [211] [212] 
.const [76] = Method [213] [214] 
.const [77] = Method [215] [216] 
.const [78] = Method [217] [218] 
.const [79] = Method [219] [220] 
.const [80] = Method [221] [222] 
.const [81] = Method [223] [224] 
.const [82] = Method [225] [226] 
.const [83] = Method [227] [228] 
.const [84] = Class [229] 
.const [85] = Field [230] [231] 
.const [86] = Class [232] 
.const [87] = Field [233] [234] 
.const [88] = Field [235] [236] 
.const [89] = Field [237] [238] 
.const [90] = Class [239] 
.const [91] = Field [240] [241] 
.const [92] = InterfaceMethod [242] [243] 
.const [93] = InterfaceMethod [244] [245] 
.const [94] = InterfaceMethod [246] [247] 
.const [95] = InterfaceMethod [248] [249] 
.const [96] = Class [250] 
.const [97] = InterfaceMethod [251] [252] 
.const [98] = InterfaceMethod [253] [254] 
.const [99] = Class [255] 
.const [100] = InterfaceMethod [256] [257] 
.const [101] = Class [258] 
.const [102] = InterfaceMethod [259] [260] 
.const [103] = InterfaceMethod [261] [262] 
.const [104] = InterfaceMethod [263] [264] 
.const [105] = InterfaceMethod [265] [266] 
.const [106] = Class [267] 
.const [107] = NameAndType [268] [269] 
.const [108] = Utf8 java/lang/ClassNotFoundException 
.const [109] = Utf8 java/lang/NoClassDefFoundError 
.const [110] = Class [270] 
.const [111] = NameAndType [271] [272] 
.const [112] = Utf8 java/util/HashMap 
.const [113] = Utf8 'Using ListenerTrackerLocal ' 
.const [114] = Class [273] 
.const [115] = NameAndType [274] [275] 
.const [116] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [117] = Class [276] 
.const [118] = NameAndType [277] [278] 
.const [119] = Utf8 'org.dsi.ifc.base.DSIListener' 
.const [120] = Class [279] 
.const [121] = NameAndType [280] [281] 
.const [122] = Utf8 '%1: addingService: serviceName=%2 ' 
.const [123] = Utf8 DEVICE_NAME 
.const [124] = Utf8 DEVICE_INSTANCE 
.const [125] = Utf8 org/dsi/ifc/base/DSIListener 
.const [126] = Utf8 '%3: removedService: serviceName=%1, serviceInstance=%2, unget=%4' 
.const [127] = Utf8 java/lang/Boolean 
.const [128] = Utf8 'Search listeners for: serviceName=%1, serviceInstance=%2' 
.const [129] = Class [282] 
.const [130] = NameAndType [283] [284] 
.const [131] = Class [285] 
.const [132] = NameAndType [286] [287] 
.const [133] = Utf8 java/util/List 
.const [134] = Utf8 'Listeners found for: serviceName=%1, serviceInstance=%2, listeners=%3' 
.const [135] = Utf8 'No listeners found for: serviceName=%1, serviceInstance=%2' 
.const [136] = Utf8 '' 
.const [137] = Utf8 java/lang/String 
.const [138] = Utf8 java/lang/Integer 
.const [139] = Utf8 'adding service to map key=%1 service=%2 ' 
.const [140] = Utf8 ' key already exist, adding new service to list ' 
.const [141] = Utf8 ' something went wrong, object of wrong instance detected ' 
.const [142] = Utf8 ' key doesent exist, creating new servicemapentry ' 
.const [143] = Utf8 java/util/ArrayList 
.const [144] = Class [288] 
.const [145] = NameAndType [289] [290] 
.const [146] = Utf8 'added to map ' 
.const [147] = Utf8 '%1: removeServiceFromMap, service=%2 ' 
.const [148] = Utf8 '%1: service could not removed from listener with service=%2' 
.const [149] = Utf8 '%1: ServiceList service=%2' 
.const [150] = Utf8 '%1: removeServiceFromMap, list.size=%2' 
.const [151] = Utf8 de/esolutions/fw/dsi/admin/ListenerTrackerLocal 
.const [152] = Utf8 java/lang/Object 
.const [153] = Utf8 java/lang/Class 
.const [154] = Utf8 de/esolutions/fw/dsi/tracing/Channels 
.const [155] = Utf8 de/esolutions/fw/util/tracing/TraceChannel 
.const [156] = Utf8 de/esolutions/fw/dsi/AdapterActivator 
.const [157] = Utf8 org/osgi/framework/BundleContext 
.const [158] = Utf8 org/osgi/framework/ServiceReference 
.const [159] = Utf8 de/esolutions/fw/dsi/admin/DSIAdmin 
.const [160] = Utf8 de/esolutions/fw/dsi/base/IDispatcher 
.const [161] = Utf8 java/util/Collections 
.const [162] = Utf8 java/util/Iterator 
.const [163] = Class [291] 
.const [164] = NameAndType [292] [293] 
.const [165] = Class [294] 
.const [166] = NameAndType [295] [296] 
.const [167] = Class [297] 
.const [168] = NameAndType [298] [299] 
.const [169] = Class [300] 
.const [170] = NameAndType [301] [302] 
.const [171] = Class [303] 
.const [172] = NameAndType [304] [305] 
.const [173] = Class [306] 
.const [174] = NameAndType [307] [308] 
.const [175] = Class [309] 
.const [176] = NameAndType [310] [311] 
.const [177] = Class [312] 
.const [178] = NameAndType [313] [314] 
.const [179] = Class [315] 
.const [180] = NameAndType [316] [317] 
.const [181] = Class [318] 
.const [182] = NameAndType [319] [320] 
.const [183] = Class [321] 
.const [184] = NameAndType [322] [323] 
.const [185] = Class [324] 
.const [186] = NameAndType [325] [326] 
.const [187] = Class [327] 
.const [188] = NameAndType [328] [329] 
.const [189] = Class [330] 
.const [190] = NameAndType [331] [332] 
.const [191] = Class [333] 
.const [192] = NameAndType [334] [335] 
.const [193] = Class [336] 
.const [194] = NameAndType [337] [338] 
.const [195] = Class [339] 
.const [196] = NameAndType [340] [341] 
.const [197] = Class [342] 
.const [198] = NameAndType [343] [344] 
.const [199] = Class [345] 
.const [200] = NameAndType [346] [347] 
.const [201] = Class [348] 
.const [202] = NameAndType [349] [350] 
.const [203] = Class [351] 
.const [204] = NameAndType [352] [353] 
.const [205] = Class [354] 
.const [206] = NameAndType [355] [356] 
.const [207] = Class [357] 
.const [208] = NameAndType [358] [359] 
.const [209] = Class [360] 
.const [210] = NameAndType [361] [362] 
.const [211] = Class [363] 
.const [212] = NameAndType [364] [365] 
.const [213] = Class [366] 
.const [214] = NameAndType [367] [368] 
.const [215] = Class [369] 
.const [216] = NameAndType [370] [371] 
.const [217] = Class [372] 
.const [218] = NameAndType [373] [374] 
.const [219] = Class [375] 
.const [220] = NameAndType [376] [377] 
.const [221] = Class [378] 
.const [222] = NameAndType [379] [380] 
.const [223] = Class [381] 
.const [224] = NameAndType [382] [383] 
.const [225] = Class [384] 
.const [226] = NameAndType [385] [386] 
.const [227] = Class [387] 
.const [228] = NameAndType [388] [389] 
.const [229] = Utf8 java/lang/NoClassDefFoundError 
.const [230] = Class [390] 
.const [231] = NameAndType [391] [392] 
.const [232] = Utf8 java/util/HashMap 
.const [233] = Class [393] 
.const [234] = NameAndType [394] [395] 
.const [235] = Class [396] 
.const [236] = NameAndType [397] [398] 
.const [237] = Class [399] 
.const [238] = NameAndType [400] [401] 
.const [239] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [240] = Class [402] 
.const [241] = NameAndType [403] [404] 
.const [242] = Class [405] 
.const [243] = NameAndType [406] [407] 
.const [244] = Class [408] 
.const [245] = NameAndType [409] [410] 
.const [246] = Class [411] 
.const [247] = NameAndType [412] [413] 
.const [248] = Class [414] 
.const [249] = NameAndType [415] [416] 
.const [250] = Utf8 java/lang/Boolean 
.const [251] = Class [417] 
.const [252] = NameAndType [418] [419] 
.const [253] = Class [420] 
.const [254] = NameAndType [421] [422] 
.const [255] = Utf8 java/lang/Integer 
.const [256] = Class [423] 
.const [257] = NameAndType [424] [425] 
.const [258] = Utf8 java/util/ArrayList 
.const [259] = Class [426] 
.const [260] = NameAndType [427] [428] 
.const [261] = Class [429] 
.const [262] = NameAndType [430] [431] 
.const [263] = Class [432] 
.const [264] = NameAndType [433] [434] 
.const [265] = Class [435] 
.const [266] = NameAndType [436] [437] 
.const [267] = Utf8 java/lang/Class 
.const [268] = Utf8 forName 
.const [269] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [270] = Utf8 de/esolutions/fw/dsi/tracing/Channels 
.const [271] = Utf8 LISTENER_TRACKER 
.const [272] = Utf8 Lde/esolutions/fw/util/tracing/TraceChannel; 
.const [273] = Utf8 de/esolutions/fw/dsi/AdapterActivator 
.const [274] = Utf8 bundleContext 
.const [275] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [276] = Utf8 de/esolutions/fw/dsi/admin/ListenerTrackerLocal 
.const [277] = Utf8 class$org$dsi$ifc$base$DSIListener 
.const [278] = Utf8 Ljava/lang/Class; 
.const [279] = Utf8 de/esolutions/fw/dsi/admin/ListenerTrackerLocal 
.const [280] = Utf8 class$ 
.const [281] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [282] = Utf8 java/lang/String 
.const [283] = Utf8 valueOf 
.const [284] = Utf8 (I)Ljava/lang/String; 
.const [285] = Utf8 de/esolutions/fw/dsi/admin/DSIAdmin 
.const [286] = Utf8 generateMapKey 
.const [287] = Utf8 (Ljava/lang/String;I)Ljava/lang/String; 
.const [288] = Utf8 java/util/Collections 
.const [289] = Utf8 synchronizedList 
.const [290] = Utf8 (Ljava/util/List;)Ljava/util/List; 
.const [291] = Utf8 java/lang/NoClassDefFoundError 
.const [292] = Utf8 initCause 
.const [293] = Utf8 (Ljava/lang/Throwable;)Ljava/lang/Throwable; 
.const [294] = Utf8 de/esolutions/fw/dsi/admin/ListenerTrackerLocal 
.const [295] = Utf8 tracer 
.const [296] = Utf8 Lde/esolutions/fw/util/tracing/TraceChannel; 
.const [297] = Utf8 de/esolutions/fw/dsi/admin/ListenerTrackerLocal 
.const [298] = Utf8 serviceMap 
.const [299] = Utf8 Ljava/util/HashMap; 
.const [300] = Utf8 de/esolutions/fw/util/tracing/TraceChannel 
.const [301] = Utf8 log 
.const [302] = Utf8 (SLjava/lang/String;)Z 
.const [303] = Utf8 de/esolutions/fw/dsi/admin/ListenerTrackerLocal 
.const [304] = Utf8 bundleContext 
.const [305] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [306] = Utf8 de/esolutions/fw/dsi/admin/ListenerTrackerLocal 
.const [307] = Utf8 admin 
.const [308] = Utf8 Lde/esolutions/fw/dsi/admin/DSIAdmin; 
.const [309] = Utf8 java/lang/Class 
.const [310] = Utf8 getName 
.const [311] = Utf8 ()Ljava/lang/String; 
.const [312] = Utf8 de/esolutions/fw/dsi/admin/ListenerTrackerLocal 
.const [313] = Utf8 serviceTracker 
.const [314] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [315] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [316] = Utf8 'open' 
.const [317] = Utf8 ()V 
.const [318] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [319] = Utf8 close 
.const [320] = Utf8 ()V 
.const [321] = Utf8 java/util/HashMap 
.const [322] = Utf8 clear 
.const [323] = Utf8 ()V 
.const [324] = Utf8 de/esolutions/fw/util/tracing/TraceChannel 
.const [325] = Utf8 log 
.const [326] = Utf8 (SLjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)Z 
.const [327] = Utf8 de/esolutions/fw/dsi/admin/DSIAdmin 
.const [328] = Utf8 findDispatcher 
.const [329] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/dsi/base/IDispatcher; 
.const [330] = Utf8 de/esolutions/fw/util/tracing/TraceChannel 
.const [331] = Utf8 log 
.const [332] = Utf8 (SLjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z 
.const [333] = Utf8 java/util/HashMap 
.const [334] = Utf8 containsKey 
.const [335] = Utf8 (Ljava/lang/Object;)Z 
.const [336] = Utf8 java/util/HashMap 
.const [337] = Utf8 get 
.const [338] = Utf8 (Ljava/lang/Object;)Ljava/lang/Object; 
.const [339] = Utf8 de/esolutions/fw/util/tracing/TraceChannel 
.const [340] = Utf8 log 
.const [341] = Utf8 (SLjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z 
.const [342] = Utf8 java/lang/Integer 
.const [343] = Utf8 intValue 
.const [344] = Utf8 ()I 
.const [345] = Utf8 java/util/HashMap 
.const [346] = Utf8 put 
.const [347] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 
.const [348] = Utf8 java/util/HashMap 
.const [349] = Utf8 remove 
.const [350] = Utf8 (Ljava/lang/Object;)Ljava/lang/Object; 
.const [351] = Utf8 java/lang/NoClassDefFoundError 
.const [352] = Utf8 <init> 
.const [353] = Utf8 ()V 
.const [354] = Utf8 java/lang/Object 
.const [355] = Utf8 <init> 
.const [356] = Utf8 ()V 
.const [357] = Utf8 java/util/HashMap 
.const [358] = Utf8 <init> 
.const [359] = Utf8 ()V 
.const [360] = Utf8 de/esolutions/fw/dsi/admin/ListenerTrackerLocal 
.const [361] = Utf8 class$org$dsi$ifc$base$DSIListener 
.const [362] = Utf8 Ljava/lang/Class; 
.const [363] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [364] = Utf8 <init> 
.const [365] = Utf8 (Lorg/osgi/framework/BundleContext;Ljava/lang/String;Lorg/osgi/util/tracker/ServiceTrackerCustomizer;)V 
.const [366] = Utf8 de/esolutions/fw/dsi/admin/ListenerTrackerLocal 
.const [367] = Utf8 getMapKeyFromReference 
.const [368] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/String; 
.const [369] = Utf8 java/lang/Object 
.const [370] = Utf8 getClass 
.const [371] = Utf8 ()Ljava/lang/Class; 
.const [372] = Utf8 de/esolutions/fw/dsi/admin/ListenerTrackerLocal 
.const [373] = Utf8 addServiceToMap 
.const [374] = Utf8 (Ljava/lang/String;Ljava/lang/Object;)V 
.const [375] = Utf8 de/esolutions/fw/dsi/admin/ListenerTrackerLocal 
.const [376] = Utf8 removeServiceFromMap 
.const [377] = Utf8 (Ljava/lang/String;Ljava/lang/Object;)V 
.const [378] = Utf8 java/lang/Boolean 
.const [379] = Utf8 <init> 
.const [380] = Utf8 (Z)V 
.const [381] = Utf8 java/util/ArrayList 
.const [382] = Utf8 <init> 
.const [383] = Utf8 ()V 
.const [384] = Utf8 java/lang/Integer 
.const [385] = Utf8 <init> 
.const [386] = Utf8 (I)V 
.const [387] = Utf8 de/esolutions/fw/dsi/admin/ListenerTrackerLocal 
.const [388] = Utf8 getDSIListenerList 
.const [389] = Utf8 (Ljava/lang/String;I)[Ljava/lang/Object; 
.const [390] = Utf8 de/esolutions/fw/dsi/admin/ListenerTrackerLocal 
.const [391] = Utf8 tracer 
.const [392] = Utf8 Lde/esolutions/fw/util/tracing/TraceChannel; 
.const [393] = Utf8 de/esolutions/fw/dsi/admin/ListenerTrackerLocal 
.const [394] = Utf8 serviceMap 
.const [395] = Utf8 Ljava/util/HashMap; 
.const [396] = Utf8 de/esolutions/fw/dsi/admin/ListenerTrackerLocal 
.const [397] = Utf8 bundleContext 
.const [398] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [399] = Utf8 de/esolutions/fw/dsi/admin/ListenerTrackerLocal 
.const [400] = Utf8 admin 
.const [401] = Utf8 Lde/esolutions/fw/dsi/admin/DSIAdmin; 
.const [402] = Utf8 de/esolutions/fw/dsi/admin/ListenerTrackerLocal 
.const [403] = Utf8 serviceTracker 
.const [404] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [405] = Utf8 org/osgi/framework/BundleContext 
.const [406] = Utf8 getService 
.const [407] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [408] = Utf8 org/osgi/framework/ServiceReference 
.const [409] = Utf8 getProperty 
.const [410] = Utf8 (Ljava/lang/String;)Ljava/lang/Object; 
.const [411] = Utf8 org/osgi/framework/BundleContext 
.const [412] = Utf8 ungetService 
.const [413] = Utf8 (Lorg/osgi/framework/ServiceReference;)Z 
.const [414] = Utf8 de/esolutions/fw/dsi/base/IDispatcher 
.const [415] = Utf8 removeNotificationListener 
.const [416] = Utf8 (Lorg/dsi/ifc/base/DSIListener;)V 
.const [417] = Utf8 java/util/List 
.const [418] = Utf8 toArray 
.const [419] = Utf8 ()[Ljava/lang/Object; 
.const [420] = Utf8 java/util/List 
.const [421] = Utf8 size 
.const [422] = Utf8 ()I 
.const [423] = Utf8 java/util/List 
.const [424] = Utf8 add 
.const [425] = Utf8 (Ljava/lang/Object;)Z 
.const [426] = Utf8 java/util/List 
.const [427] = Utf8 remove 
.const [428] = Utf8 (Ljava/lang/Object;)Z 
.const [429] = Utf8 java/util/List 
.const [430] = Utf8 iterator 
.const [431] = Utf8 ()Ljava/util/Iterator; 
.const [432] = Utf8 java/util/Iterator 
.const [433] = Utf8 hasNext 
.const [434] = Utf8 ()Z 
.const [435] = Utf8 java/util/Iterator 
.const [436] = Utf8 next 
.const [437] = Utf8 ()Ljava/lang/Object; 
.const [438] = Utf8 de/esolutions/fw/dsi/admin/ListenerTrackerLocal 
.const [439] = Class [438] 
.const [440] = Utf8 java/lang/Object 
.const [441] = Class [440] 
.const [442] = Utf8 org/osgi/util/tracker/ServiceTrackerCustomizer 
.const [443] = Class [442] 
.const [444] = Utf8 de/esolutions/fw/dsi/admin/IListenerTracker 
.const [445] = Class [444] 
.const [446] = Utf8 tracer 
.const [447] = Utf8 Lde/esolutions/fw/util/tracing/TraceChannel; 
.const [448] = Utf8 bundleContext 
.const [449] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [450] = Utf8 serviceTracker 
.const [451] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [452] = Utf8 serviceMap 
.const [453] = Utf8 Ljava/util/HashMap; 
.const [454] = Utf8 admin 
.const [455] = Utf8 Lde/esolutions/fw/dsi/admin/DSIAdmin; 
.const [456] = Utf8 class$org$dsi$ifc$base$DSIListener 
.const [457] = Utf8 Ljava/lang/Class; 
.const [458] = Utf8 Code 
.const [459] = Utf8 <init> 
.const [460] = Utf8 ()V 
.const [461] = Utf8 setDSIAdmin 
.const [462] = Utf8 (Lde/esolutions/fw/dsi/admin/DSIAdmin;)V 
.const [463] = Utf8 'open' 
.const [464] = Utf8 ()V 
.const [465] = Utf8 close 
.const [466] = Utf8 ()V 
.const [467] = Utf8 addingService 
.const [468] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [469] = Utf8 modifiedService 
.const [470] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [471] = Utf8 removedService 
.const [472] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [473] = Utf8 getDSIListenerList 
.const [474] = Utf8 (Ljava/lang/String;I)[Ljava/lang/Object; 
.const [475] = Utf8 getMapKeyFromReference 
.const [476] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/String; 
.const [477] = Utf8 addServiceToMap 
.const [478] = Utf8 (Ljava/lang/String;Ljava/lang/Object;)V 
.const [479] = Utf8 removeServiceFromMap 
.const [480] = Utf8 (Ljava/lang/String;Ljava/lang/Object;)V 
.const [481] = Utf8 getDSIListener 
.const [482] = Utf8 (Ljava/lang/String;I)[Ljava/lang/Object; 
.const [483] = Utf8 class$ 
.const [484] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.end class 
