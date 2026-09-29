.version 50 0 
.class public super [475] 
.super [477] 
.implements [479] 
.field private [480] [481] 
.field private [482] [483] 
.field private [484] [485] 
.field private [486] [487] 
.field private [488] [489] 
.field private [490] [491] 
.field static synthetic [492] [493] 
.field static synthetic [494] [495] 
.field static synthetic [496] [497] 
.field static synthetic [498] [499] 
.field static synthetic [500] [501] 
.field static synthetic [502] [503] 

.method public [505] : [506] 
    .attribute [504] .code stack 3 locals 0 
L0:     aload_0 
L1:     ldc [5] 
L3:     invokespecial [83] 
L6:     aload_0 
L7:     new [97] 
L10:    dup 
L11:    invokespecial [84] 
L14:    putfield [98] 
L17:    return 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public interface [507] : [508] 
    .attribute [504] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [57] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method protected [509] : [510] 
    .attribute [504] .code stack 6 locals 2 
L0:     aload_0 
L1:     aload_0 
L2:     getfield [58] 
L5:     ldc [7] 
L7:     invokeinterface [100] 0 
L12:    putfield [101] 
L15:    aload_0 
L16:    new [102] 
L19:    dup 
L20:    aload_0 
L21:    getfield [58] 
L24:    invokespecial [85] 
L27:    putfield [99] 
L30:    new [103] 
L33:    dup 
L34:    invokespecial [86] 
L37:    astore_2 
L38:    aload_2 
L39:    ldc [10] 
L41:    getstatic [11] 
L44:    ifnonnull L59 
L47:    ldc [12] 
L49:    invokestatic [13] 
L52:    dup 
L53:    putstatic [87] 
L56:    goto L62 
L59:    getstatic [11] 
L62:    invokevirtual [60] 
L65:    invokevirtual [61] 
L68:    pop 
L69:    aload_2 
L70:    ldc [14] 
L72:    new [104] 
L75:    dup 
L76:    iconst_0 
L77:    invokespecial [88] 
L80:    invokevirtual [61] 
L83:    pop 
L84:    aload_0 
L85:    aload_1 
L86:    getstatic [16] 
L89:    ifnonnull L104 
L92:    ldc [17] 
L94:    invokestatic [13] 
L97:    dup 
L98:    putstatic [89] 
L101:   goto L107 
L104:   getstatic [16] 
L107:   invokevirtual [60] 
L110:   aload_0 
L111:   getfield [57] 
L114:   ldc [18] 
L116:   invokevirtual [62] 
L119:   aload_2 
L120:   invokeinterface [105] 0 
L125:   putfield [106] 
L128:   aload_0 
L129:   aload_1 
L130:   putfield [107] 
L133:   iconst_3 
L134:   anewarray [19] 
L137:   dup 
L138:   iconst_0 
L139:   getstatic [20] 
L142:   ifnonnull L157 
L145:   ldc [21] 
L147:   invokestatic [13] 
L150:   dup 
L151:   putstatic [90] 
L154:   goto L160 
L157:   getstatic [20] 
L160:   invokevirtual [60] 
L163:   aastore 
L164:   dup 
L165:   iconst_1 
L166:   getstatic [22] 
L169:   ifnonnull L184 
L172:   ldc [23] 
L174:   invokestatic [13] 
L177:   dup 
L178:   putstatic [91] 
L181:   goto L187 
L184:   getstatic [22] 
L187:   invokevirtual [60] 
L190:   aastore 
L191:   dup 
L192:   iconst_2 
L193:   getstatic [24] 
L196:   ifnonnull L211 
L199:   ldc [25] 
L201:   invokestatic [13] 
L204:   dup 
L205:   putstatic [92] 
L208:   goto L214 
L211:   getstatic [24] 
L214:   invokevirtual [60] 
L217:   aastore 
L218:   astore_3 
L219:   aload_0 
L220:   new [108] 
L223:   dup 
L224:   aload_1 
L225:   aload_3 
L226:   aload_0 
L227:   invokespecial [93] 
L230:   putfield [109] 
L233:   aload_0 
L234:   getfield [65] 
L237:   invokevirtual [66] 
L240:   aload_0 
L241:   getfield [58] 
L244:   getstatic [22] 
L247:   ifnonnull L262 
L250:   ldc [23] 
L252:   invokestatic [13] 
L255:   dup 
L256:   putstatic [91] 
L259:   goto L265 
L262:   getstatic [22] 
L265:   invokevirtual [60] 
L268:   iconst_0 
L269:   invokeinterface [110] 0 
L274:   pop 
L275:   return 
L276:   
    .end code 
.end method 

.method public [511] : [512] 
    .attribute [504] .code stack 2 locals 3 
L0:     aload_0 
L1:     getfield [63] 
L4:     ifnull L21 
L7:     aload_0 
L8:     getfield [63] 
L11:    invokeinterface [111] 0 
L16:    aload_0 
L17:    aconst_null 
L18:    putfield [106] 
L21:    aload_0 
L22:    getfield [56] 
L25:    ifnull L83 
L28:    iconst_0 
L29:    istore_2 
L30:    iload_2 
L31:    aload_0 
L32:    getfield [56] 
L35:    invokevirtual [67] 
L38:    if_icmpge L76 
L41:    aload_0 
L42:    getfield [56] 
L45:    iload_2 
L46:    invokevirtual [68] 
L49:    astore_3 
L50:    aload_3 
L51:    instanceof [27] 
L54:    ifeq L70 
L57:    aload_3 
L58:    checkcast [27] 
L61:    astore 4 
L63:    aload 4 
L65:    invokeinterface [111] 0 
L70:    iinc 2 1 
L73:    goto L30 
L76:    aload_0 
L77:    getfield [56] 
L80:    invokevirtual [69] 
L83:    aload_0 
L84:    getfield [65] 
L87:    ifnull L102 
L90:    aload_0 
L91:    getfield [65] 
L94:    invokevirtual [70] 
L97:    aload_0 
L98:    aconst_null 
L99:    putfield [109] 
L102:   aload_0 
L103:   aconst_null 
L104:   putfield [101] 
L107:   aload_0 
L108:   aload_1 
L109:   invokespecial [94] 
L112:   return 
L113:   nop 
L114:   nop 
L115:   nop 
L116:   
    .end code 
.end method 

.method public [513] : [514] 
    .attribute [504] .code stack 5 locals 2 
L0:     aload_0 
L1:     getfield [71] 
L4:     aload_1 
L5:     invokeinterface [112] 0 
L10:    astore_2 
L11:    aload_2 
L12:    instanceof [28] 
L15:    ifeq L80 
L18:    aload_1 
L19:    ldc [29] 
L21:    invokeinterface [113] 0 
L26:    checkcast [19] 
L29:    astore_3 
L30:    aload_0 
L31:    getfield [59] 
L34:    ldc [30] 
L36:    ldc [31] 
L38:    aload_2 
L39:    aload_3 
L40:    invokevirtual [72] 
L43:    aload_0 
L44:    getfield [57] 
L47:    aload_2 
L48:    aload_3 
L49:    invokevirtual [73] 
L52:    ifne L68 
L55:    aload_0 
L56:    getfield [71] 
L59:    aload_1 
L60:    invokeinterface [114] 0 
L65:    pop 
L66:    aconst_null 
L67:    areturn 
L68:    aload_0 
L69:    aload_0 
L70:    getfield [64] 
L73:    aload_3 
L74:    invokevirtual [74] 
L77:    goto L188 
L80:    aload_2 
L81:    instanceof [32] 
L84:    ifeq L127 
L87:    aload_0 
L88:    getfield [59] 
L91:    ldc [30] 
L93:    ldc [33] 
L95:    aload_2 
L96:    ldc [18] 
L98:    invokevirtual [72] 
L101:   aload_0 
L102:   getfield [57] 
L105:   aload_2 
L106:   ldc [18] 
L108:   invokevirtual [73] 
L111:   ifne L188 
L114:   aload_0 
L115:   getfield [71] 
L118:   aload_1 
L119:   invokeinterface [114] 0 
L124:   pop 
L125:   aconst_null 
L126:   areturn 
L127:   aload_2 
L128:   instanceof [34] 
L131:   ifeq L161 
L134:   aload_0 
L135:   getfield [59] 
L138:   ldc [30] 
L140:   ldc [35] 
L142:   aload_2 
L143:   invokevirtual [75] 
L146:   pop 
L147:   aload_0 
L148:   getfield [57] 
L151:   aload_2 
L152:   checkcast [34] 
L155:   invokevirtual [76] 
L158:   goto L188 
L161:   aload_0 
L162:   getfield [59] 
L165:   sipush 10000 
L168:   ldc [36] 
L170:   aload_2 
L171:   invokevirtual [75] 
L174:   pop 
L175:   aload_0 
L176:   invokevirtual [77] 
L179:   aload_1 
L180:   invokeinterface [114] 0 
L185:   pop 
L186:   aconst_null 
L187:   areturn 
L188:   aload_2 
L189:   areturn 
L190:   nop 
L191:   nop 
L192:   
    .end code 
.end method 

.method public enum [515] : [516] 
    .attribute [504] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [517] : [518] 
    .attribute [504] .code stack 4 locals 0 
L0:     aload_2 
L1:     instanceof [34] 
L4:     ifeq L31 
L7:     aload_0 
L8:     getfield [59] 
L11:    ldc [30] 
L13:    ldc [37] 
L15:    aload_2 
L16:    invokevirtual [75] 
L19:    pop 
L20:    aload_0 
L21:    getfield [57] 
L24:    aload_2 
L25:    checkcast [34] 
L28:    invokevirtual [78] 
L31:    aload_0 
L32:    getfield [71] 
L35:    aload_1 
L36:    invokeinterface [114] 0 
L41:    pop 
L42:    return 
L43:    nop 
L44:    
    .end code 
.end method 

.method protected [519] : [520] 
    .attribute [504] .code stack 5 locals 1 
L0:     aload_2 
L1:     ifnonnull L16 
L4:     aload_0 
L5:     getfield [59] 
L8:     ldc [38] 
L10:    ldc [39] 
L12:    invokevirtual [79] 
L15:    pop 
L16:    aload_1 
L17:    ifnonnull L33 
L20:    aload_0 
L21:    getfield [59] 
L24:    ldc [38] 
L26:    ldc [40] 
L28:    aload_2 
L29:    invokevirtual [75] 
L32:    pop 
L33:    new [103] 
L36:    dup 
L37:    invokespecial [86] 
L40:    astore_3 
L41:    aload_3 
L42:    ldc [41] 
L44:    ldc [42] 
L46:    invokevirtual [80] 
L49:    pop 
L50:    aload_3 
L51:    ldc [43] 
L53:    new [104] 
L56:    dup 
L57:    bipush 23 
L59:    invokespecial [88] 
L62:    invokevirtual [80] 
L65:    pop 
L66:    aload_0 
L67:    getfield [56] 
L70:    aload_1 
L71:    getstatic [44] 
L74:    ifnonnull L89 
L77:    ldc [45] 
L79:    invokestatic [13] 
L82:    dup 
L83:    putstatic [95] 
L86:    goto L92 
L89:    getstatic [44] 
L92:    invokevirtual [60] 
L95:    aload_0 
L96:    getfield [57] 
L99:    aload_2 
L100:   invokevirtual [62] 
L103:   aload_3 
L104:   invokeinterface [105] 0 
L109:   invokevirtual [81] 
L112:   pop 
L113:   aload_0 
L114:   getfield [59] 
L117:   ldc [30] 
L119:   ldc [46] 
L121:   aload_2 
L122:   invokevirtual [75] 
L125:   pop 
L126:   return 
L127:   nop 
L128:   
    .end code 
.end method 

.method static synthetic [521] : [522] 
    .attribute [504] .code stack 2 locals 1 
        .catch [3] from L0 to L4 using L5 
L0:     aload_0 
L1:     invokestatic [2] 
L4:     areturn 
L5:     astore_1 
L6:     new [96] 
L9:     dup 
L10:    invokespecial [82] 
L13:    aload_1 
L14:    invokevirtual [55] 
L17:    athrow 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [115] [116] 
.const [3] = Class [117] 
.const [4] = Class [118] 
.const [5] = String [119] 
.const [6] = Class [120] 
.const [7] = String [121] 
.const [8] = Class [122] 
.const [9] = Class [123] 
.const [10] = String [124] 
.const [11] = Field [125] [126] 
.const [12] = String [127] 
.const [13] = Method [128] [129] 
.const [14] = String [130] 
.const [15] = Class [131] 
.const [16] = Field [132] [133] 
.const [17] = String [134] 
.const [18] = String [135] 
.const [19] = Class [136] 
.const [20] = Field [137] [138] 
.const [21] = String [139] 
.const [22] = Field [140] [141] 
.const [23] = String [142] 
.const [24] = Field [143] [144] 
.const [25] = String [145] 
.const [26] = Class [146] 
.const [27] = Class [147] 
.const [28] = Class [148] 
.const [29] = String [149] 
.const [30] = Int 1078071040 
.const [31] = String [150] 
.const [32] = Class [151] 
.const [33] = String [152] 
.const [34] = Class [153] 
.const [35] = String [154] 
.const [36] = String [155] 
.const [37] = String [156] 
.const [38] = Int -1601830656 
.const [39] = String [157] 
.const [40] = String [158] 
.const [41] = String [159] 
.const [42] = String [160] 
.const [43] = String [161] 
.const [44] = Field [162] [163] 
.const [45] = String [164] 
.const [46] = String [165] 
.const [47] = Class [166] 
.const [48] = Class [167] 
.const [49] = Class [168] 
.const [50] = Class [169] 
.const [51] = Class [170] 
.const [52] = Class [171] 
.const [53] = Class [172] 
.const [54] = Class [173] 
.const [55] = Method [174] [175] 
.const [56] = Field [176] [177] 
.const [57] = Field [178] [179] 
.const [58] = Field [180] [181] 
.const [59] = Field [182] [183] 
.const [60] = Method [184] [185] 
.const [61] = Method [186] [187] 
.const [62] = Method [188] [189] 
.const [63] = Field [190] [191] 
.const [64] = Field [192] [193] 
.const [65] = Field [194] [195] 
.const [66] = Method [196] [197] 
.const [67] = Method [198] [199] 
.const [68] = Method [200] [201] 
.const [69] = Method [202] [203] 
.const [70] = Method [204] [205] 
.const [71] = Field [206] [207] 
.const [72] = Method [208] [209] 
.const [73] = Method [210] [211] 
.const [74] = Method [212] [213] 
.const [75] = Method [214] [215] 
.const [76] = Method [216] [217] 
.const [77] = Method [218] [219] 
.const [78] = Method [220] [221] 
.const [79] = Method [222] [223] 
.const [80] = Method [224] [225] 
.const [81] = Method [226] [227] 
.const [82] = Method [228] [229] 
.const [83] = Method [230] [231] 
.const [84] = Method [232] [233] 
.const [85] = Method [234] [235] 
.const [86] = Method [236] [237] 
.const [87] = Field [238] [239] 
.const [88] = Method [240] [241] 
.const [89] = Field [242] [243] 
.const [90] = Field [244] [245] 
.const [91] = Field [246] [247] 
.const [92] = Field [248] [249] 
.const [93] = Method [250] [251] 
.const [94] = Method [252] [253] 
.const [95] = Field [254] [255] 
.const [96] = Class [256] 
.const [97] = Class [257] 
.const [98] = Field [258] [259] 
.const [99] = Field [260] [261] 
.const [100] = InterfaceMethod [262] [263] 
.const [101] = Field [264] [265] 
.const [102] = Class [266] 
.const [103] = Class [267] 
.const [104] = Class [268] 
.const [105] = InterfaceMethod [269] [270] 
.const [106] = Field [271] [272] 
.const [107] = Field [273] [274] 
.const [108] = Class [275] 
.const [109] = Field [276] [277] 
.const [110] = InterfaceMethod [278] [279] 
.const [111] = InterfaceMethod [280] [281] 
.const [112] = InterfaceMethod [282] [283] 
.const [113] = InterfaceMethod [284] [285] 
.const [114] = InterfaceMethod [286] [287] 
.const [115] = Class [288] 
.const [116] = NameAndType [289] [290] 
.const [117] = Utf8 java/lang/ClassNotFoundException 
.const [118] = Utf8 java/lang/NoClassDefFoundError 
.const [119] = Utf8 FwCache 
.const [120] = Utf8 java/util/ArrayList 
.const [121] = Utf8 'Fw.Cache.Activator' 
.const [122] = Utf8 de/audi/tghu/storagecache/CacheHandlerImpl 
.const [123] = Utf8 java/util/Hashtable 
.const [124] = Utf8 DEVICE_NAME 
.const [125] = Class [291] 
.const [126] = NameAndType [292] [293] 
.const [127] = Utf8 'org.dsi.ifc.carvehiclestates.DSICarVehicleStatesListener' 
.const [128] = Class [294] 
.const [129] = NameAndType [295] [296] 
.const [130] = Utf8 DEVICE_INSTANCE 
.const [131] = Utf8 java/lang/Integer 
.const [132] = Class [297] 
.const [133] = NameAndType [298] [299] 
.const [134] = Utf8 'org.dsi.ifc.base.DSIListener' 
.const [135] = Utf8 service_dsi_presetlayout 
.const [136] = Utf8 java/lang/String 
.const [137] = Class [300] 
.const [138] = NameAndType [301] [302] 
.const [139] = Utf8 'de.audi.atip.interapp.online.IOnlineService' 
.const [140] = Class [303] 
.const [141] = NameAndType [304] [305] 
.const [142] = Utf8 'org.dsi.ifc.carvehiclestates.DSICarVehicleStates' 
.const [143] = Class [306] 
.const [144] = NameAndType [307] [308] 
.const [145] = Utf8 'de.audi.atip.storagecache.CacheEventListener' 
.const [146] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [147] = Utf8 org/osgi/framework/ServiceRegistration 
.const [148] = Utf8 de/audi/atip/interapp/online/IOnlineService 
.const [149] = Utf8 ONLINE_APP_ID 
.const [150] = Utf8 'Setting Service=%1 ServiceID = %2' 
.const [151] = Utf8 org/dsi/ifc/carvehiclestates/DSICarVehicleStates 
.const [152] = Utf8 'Setting DSI Service=%1 ServiceID = %2' 
.const [153] = Utf8 de/audi/atip/storagecache/CacheEventListener 
.const [154] = Utf8 'Adding Service=%1' 
.const [155] = Utf8 'track unwanted service=%1' 
.const [156] = Utf8 'Removing Service=%1' 
.const [157] = Utf8 'CacheActivator#registerOTCWMsgListener(): serviceId is null.' 
.const [158] = Utf8 'CacheActivator#registerOTCWMsgListener(): Context is null. %1 not registered as message listener.' 
.const [159] = Utf8 ApplicationName 
.const [160] = Utf8 AppOnline 
.const [161] = Utf8 moduleID 
.const [162] = Class [309] 
.const [163] = NameAndType [310] [311] 
.const [164] = Utf8 'de.audi.atip.msg.MsgListener' 
.const [165] = Utf8 'CacheActivator#registerOTCWMsgListener(): Register %1 as message listener.' 
.const [166] = Utf8 de/audi/tghu/storagecache/CacheActivator 
.const [167] = Utf8 de/audi/atip/activator/AbstractFrameworkActivator 
.const [168] = Utf8 java/lang/Class 
.const [169] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [170] = Utf8 java/util/Dictionary 
.const [171] = Utf8 org/osgi/framework/BundleContext 
.const [172] = Utf8 org/osgi/framework/ServiceReference 
.const [173] = Utf8 de/audi/atip/log/LogChannel 
.const [174] = Class [312] 
.const [175] = NameAndType [313] [314] 
.const [176] = Class [315] 
.const [177] = NameAndType [316] [317] 
.const [178] = Class [318] 
.const [179] = NameAndType [319] [320] 
.const [180] = Class [321] 
.const [181] = NameAndType [322] [323] 
.const [182] = Class [324] 
.const [183] = NameAndType [325] [326] 
.const [184] = Class [327] 
.const [185] = NameAndType [328] [329] 
.const [186] = Class [330] 
.const [187] = NameAndType [331] [332] 
.const [188] = Class [333] 
.const [189] = NameAndType [334] [335] 
.const [190] = Class [336] 
.const [191] = NameAndType [337] [338] 
.const [192] = Class [339] 
.const [193] = NameAndType [340] [341] 
.const [194] = Class [342] 
.const [195] = NameAndType [343] [344] 
.const [196] = Class [345] 
.const [197] = NameAndType [346] [347] 
.const [198] = Class [348] 
.const [199] = NameAndType [349] [350] 
.const [200] = Class [351] 
.const [201] = NameAndType [352] [353] 
.const [202] = Class [354] 
.const [203] = NameAndType [355] [356] 
.const [204] = Class [357] 
.const [205] = NameAndType [358] [359] 
.const [206] = Class [360] 
.const [207] = NameAndType [361] [362] 
.const [208] = Class [363] 
.const [209] = NameAndType [364] [365] 
.const [210] = Class [366] 
.const [211] = NameAndType [367] [368] 
.const [212] = Class [369] 
.const [213] = NameAndType [370] [371] 
.const [214] = Class [372] 
.const [215] = NameAndType [373] [374] 
.const [216] = Class [375] 
.const [217] = NameAndType [376] [377] 
.const [218] = Class [378] 
.const [219] = NameAndType [379] [380] 
.const [220] = Class [381] 
.const [221] = NameAndType [382] [383] 
.const [222] = Class [384] 
.const [223] = NameAndType [385] [386] 
.const [224] = Class [387] 
.const [225] = NameAndType [388] [389] 
.const [226] = Class [390] 
.const [227] = NameAndType [391] [392] 
.const [228] = Class [393] 
.const [229] = NameAndType [394] [395] 
.const [230] = Class [396] 
.const [231] = NameAndType [397] [398] 
.const [232] = Class [399] 
.const [233] = NameAndType [400] [401] 
.const [234] = Class [402] 
.const [235] = NameAndType [403] [404] 
.const [236] = Class [405] 
.const [237] = NameAndType [406] [407] 
.const [238] = Class [408] 
.const [239] = NameAndType [409] [410] 
.const [240] = Class [411] 
.const [241] = NameAndType [412] [413] 
.const [242] = Class [414] 
.const [243] = NameAndType [415] [416] 
.const [244] = Class [417] 
.const [245] = NameAndType [418] [419] 
.const [246] = Class [420] 
.const [247] = NameAndType [421] [422] 
.const [248] = Class [423] 
.const [249] = NameAndType [424] [425] 
.const [250] = Class [426] 
.const [251] = NameAndType [427] [428] 
.const [252] = Class [429] 
.const [253] = NameAndType [430] [431] 
.const [254] = Class [432] 
.const [255] = NameAndType [433] [434] 
.const [256] = Utf8 java/lang/NoClassDefFoundError 
.const [257] = Utf8 java/util/ArrayList 
.const [258] = Class [435] 
.const [259] = NameAndType [436] [437] 
.const [260] = Class [438] 
.const [261] = NameAndType [439] [440] 
.const [262] = Class [441] 
.const [263] = NameAndType [442] [443] 
.const [264] = Class [444] 
.const [265] = NameAndType [445] [446] 
.const [266] = Utf8 de/audi/tghu/storagecache/CacheHandlerImpl 
.const [267] = Utf8 java/util/Hashtable 
.const [268] = Utf8 java/lang/Integer 
.const [269] = Class [447] 
.const [270] = NameAndType [448] [449] 
.const [271] = Class [450] 
.const [272] = NameAndType [451] [452] 
.const [273] = Class [453] 
.const [274] = NameAndType [454] [455] 
.const [275] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [276] = Class [456] 
.const [277] = NameAndType [457] [458] 
.const [278] = Class [459] 
.const [279] = NameAndType [460] [461] 
.const [280] = Class [462] 
.const [281] = NameAndType [463] [464] 
.const [282] = Class [465] 
.const [283] = NameAndType [466] [467] 
.const [284] = Class [468] 
.const [285] = NameAndType [469] [470] 
.const [286] = Class [471] 
.const [287] = NameAndType [472] [473] 
.const [288] = Utf8 java/lang/Class 
.const [289] = Utf8 forName 
.const [290] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [291] = Utf8 de/audi/tghu/storagecache/CacheActivator 
.const [292] = Utf8 class$org$dsi$ifc$carvehiclestates$DSICarVehicleStatesListener 
.const [293] = Utf8 Ljava/lang/Class; 
.const [294] = Utf8 de/audi/tghu/storagecache/CacheActivator 
.const [295] = Utf8 class$ 
.const [296] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [297] = Utf8 de/audi/tghu/storagecache/CacheActivator 
.const [298] = Utf8 class$org$dsi$ifc$base$DSIListener 
.const [299] = Utf8 Ljava/lang/Class; 
.const [300] = Utf8 de/audi/tghu/storagecache/CacheActivator 
.const [301] = Utf8 class$de$audi$atip$interapp$online$IOnlineService 
.const [302] = Utf8 Ljava/lang/Class; 
.const [303] = Utf8 de/audi/tghu/storagecache/CacheActivator 
.const [304] = Utf8 class$org$dsi$ifc$carvehiclestates$DSICarVehicleStates 
.const [305] = Utf8 Ljava/lang/Class; 
.const [306] = Utf8 de/audi/tghu/storagecache/CacheActivator 
.const [307] = Utf8 class$de$audi$atip$storagecache$CacheEventListener 
.const [308] = Utf8 Ljava/lang/Class; 
.const [309] = Utf8 de/audi/tghu/storagecache/CacheActivator 
.const [310] = Utf8 class$de$audi$atip$msg$MsgListener 
.const [311] = Utf8 Ljava/lang/Class; 
.const [312] = Utf8 java/lang/NoClassDefFoundError 
.const [313] = Utf8 initCause 
.const [314] = Utf8 (Ljava/lang/Throwable;)Ljava/lang/Throwable; 
.const [315] = Utf8 de/audi/tghu/storagecache/CacheActivator 
.const [316] = Utf8 sRegOTCWStates 
.const [317] = Utf8 Ljava/util/ArrayList; 
.const [318] = Utf8 de/audi/tghu/storagecache/CacheActivator 
.const [319] = Utf8 cacheHandler 
.const [320] = Utf8 Lde/audi/tghu/storagecache/CacheHandlerImpl; 
.const [321] = Utf8 de/audi/tghu/storagecache/CacheActivator 
.const [322] = Utf8 framework 
.const [323] = Utf8 Lde/audi/atip/base/IFrameworkAccess; 
.const [324] = Utf8 de/audi/tghu/storagecache/CacheActivator 
.const [325] = Utf8 log 
.const [326] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [327] = Utf8 java/lang/Class 
.const [328] = Utf8 getName 
.const [329] = Utf8 ()Ljava/lang/String; 
.const [330] = Utf8 java/util/Dictionary 
.const [331] = Utf8 put 
.const [332] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 
.const [333] = Utf8 de/audi/tghu/storagecache/CacheHandlerImpl 
.const [334] = Utf8 getWorker 
.const [335] = Utf8 (Ljava/lang/String;)Lde/audi/tghu/storagecache/CacheWorker; 
.const [336] = Utf8 de/audi/tghu/storagecache/CacheActivator 
.const [337] = Utf8 sRegCVState 
.const [338] = Utf8 Lorg/osgi/framework/ServiceRegistration; 
.const [339] = Utf8 de/audi/tghu/storagecache/CacheActivator 
.const [340] = Utf8 context 
.const [341] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [342] = Utf8 de/audi/tghu/storagecache/CacheActivator 
.const [343] = Utf8 tracker 
.const [344] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [345] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [346] = Utf8 'open' 
.const [347] = Utf8 ()V 
.const [348] = Utf8 java/util/ArrayList 
.const [349] = Utf8 size 
.const [350] = Utf8 ()I 
.const [351] = Utf8 java/util/ArrayList 
.const [352] = Utf8 get 
.const [353] = Utf8 (I)Ljava/lang/Object; 
.const [354] = Utf8 java/util/ArrayList 
.const [355] = Utf8 clear 
.const [356] = Utf8 ()V 
.const [357] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [358] = Utf8 close 
.const [359] = Utf8 ()V 
.const [360] = Utf8 de/audi/tghu/storagecache/CacheActivator 
.const [361] = Utf8 bundleContext 
.const [362] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [363] = Utf8 de/audi/atip/log/LogChannel 
.const [364] = Utf8 log 
.const [365] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [366] = Utf8 de/audi/tghu/storagecache/CacheHandlerImpl 
.const [367] = Utf8 registerService 
.const [368] = Utf8 (Ljava/lang/Object;Ljava/lang/String;)Z 
.const [369] = Utf8 de/audi/tghu/storagecache/CacheActivator 
.const [370] = Utf8 registerOTCWMsgListener 
.const [371] = Utf8 (Lorg/osgi/framework/BundleContext;Ljava/lang/String;)V 
.const [372] = Utf8 de/audi/atip/log/LogChannel 
.const [373] = Utf8 log 
.const [374] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [375] = Utf8 de/audi/tghu/storagecache/CacheHandlerImpl 
.const [376] = Utf8 addListener 
.const [377] = Utf8 (Lde/audi/atip/storagecache/CacheEventListener;)V 
.const [378] = Utf8 de/audi/tghu/storagecache/CacheActivator 
.const [379] = Utf8 getBundleContext 
.const [380] = Utf8 ()Lorg/osgi/framework/BundleContext; 
.const [381] = Utf8 de/audi/tghu/storagecache/CacheHandlerImpl 
.const [382] = Utf8 removeListener 
.const [383] = Utf8 (Lde/audi/atip/storagecache/CacheEventListener;)V 
.const [384] = Utf8 de/audi/atip/log/LogChannel 
.const [385] = Utf8 log 
.const [386] = Utf8 (ILjava/lang/String;)Z 
.const [387] = Utf8 java/util/Hashtable 
.const [388] = Utf8 put 
.const [389] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 
.const [390] = Utf8 java/util/ArrayList 
.const [391] = Utf8 add 
.const [392] = Utf8 (Ljava/lang/Object;)Z 
.const [393] = Utf8 java/lang/NoClassDefFoundError 
.const [394] = Utf8 <init> 
.const [395] = Utf8 ()V 
.const [396] = Utf8 de/audi/atip/activator/AbstractFrameworkActivator 
.const [397] = Utf8 <init> 
.const [398] = Utf8 (Ljava/lang/String;)V 
.const [399] = Utf8 java/util/ArrayList 
.const [400] = Utf8 <init> 
.const [401] = Utf8 ()V 
.const [402] = Utf8 de/audi/tghu/storagecache/CacheHandlerImpl 
.const [403] = Utf8 <init> 
.const [404] = Utf8 (Lde/audi/atip/base/IFrameworkAccess;)V 
.const [405] = Utf8 java/util/Hashtable 
.const [406] = Utf8 <init> 
.const [407] = Utf8 ()V 
.const [408] = Utf8 de/audi/tghu/storagecache/CacheActivator 
.const [409] = Utf8 class$org$dsi$ifc$carvehiclestates$DSICarVehicleStatesListener 
.const [410] = Utf8 Ljava/lang/Class; 
.const [411] = Utf8 java/lang/Integer 
.const [412] = Utf8 <init> 
.const [413] = Utf8 (I)V 
.const [414] = Utf8 de/audi/tghu/storagecache/CacheActivator 
.const [415] = Utf8 class$org$dsi$ifc$base$DSIListener 
.const [416] = Utf8 Ljava/lang/Class; 
.const [417] = Utf8 de/audi/tghu/storagecache/CacheActivator 
.const [418] = Utf8 class$de$audi$atip$interapp$online$IOnlineService 
.const [419] = Utf8 Ljava/lang/Class; 
.const [420] = Utf8 de/audi/tghu/storagecache/CacheActivator 
.const [421] = Utf8 class$org$dsi$ifc$carvehiclestates$DSICarVehicleStates 
.const [422] = Utf8 Ljava/lang/Class; 
.const [423] = Utf8 de/audi/tghu/storagecache/CacheActivator 
.const [424] = Utf8 class$de$audi$atip$storagecache$CacheEventListener 
.const [425] = Utf8 Ljava/lang/Class; 
.const [426] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [427] = Utf8 <init> 
.const [428] = Utf8 (Lorg/osgi/framework/BundleContext;[Ljava/lang/String;Lorg/osgi/util/tracker/ServiceTrackerCustomizer;)V 
.const [429] = Utf8 de/audi/atip/activator/AbstractFrameworkActivator 
.const [430] = Utf8 stop 
.const [431] = Utf8 (Lorg/osgi/framework/BundleContext;)V 
.const [432] = Utf8 de/audi/tghu/storagecache/CacheActivator 
.const [433] = Utf8 class$de$audi$atip$msg$MsgListener 
.const [434] = Utf8 Ljava/lang/Class; 
.const [435] = Utf8 de/audi/tghu/storagecache/CacheActivator 
.const [436] = Utf8 sRegOTCWStates 
.const [437] = Utf8 Ljava/util/ArrayList; 
.const [438] = Utf8 de/audi/tghu/storagecache/CacheActivator 
.const [439] = Utf8 cacheHandler 
.const [440] = Utf8 Lde/audi/tghu/storagecache/CacheHandlerImpl; 
.const [441] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [442] = Utf8 getLogChannel 
.const [443] = Utf8 (Ljava/lang/String;)Lde/audi/atip/log/LogChannel; 
.const [444] = Utf8 de/audi/tghu/storagecache/CacheActivator 
.const [445] = Utf8 log 
.const [446] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [447] = Utf8 org/osgi/framework/BundleContext 
.const [448] = Utf8 registerService 
.const [449] = Utf8 (Ljava/lang/String;Ljava/lang/Object;Ljava/util/Dictionary;)Lorg/osgi/framework/ServiceRegistration; 
.const [450] = Utf8 de/audi/tghu/storagecache/CacheActivator 
.const [451] = Utf8 sRegCVState 
.const [452] = Utf8 Lorg/osgi/framework/ServiceRegistration; 
.const [453] = Utf8 de/audi/tghu/storagecache/CacheActivator 
.const [454] = Utf8 context 
.const [455] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [456] = Utf8 de/audi/tghu/storagecache/CacheActivator 
.const [457] = Utf8 tracker 
.const [458] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [459] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [460] = Utf8 startDSIService 
.const [461] = Utf8 (Ljava/lang/String;I)Z 
.const [462] = Utf8 org/osgi/framework/ServiceRegistration 
.const [463] = Utf8 unregister 
.const [464] = Utf8 ()V 
.const [465] = Utf8 org/osgi/framework/BundleContext 
.const [466] = Utf8 getService 
.const [467] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [468] = Utf8 org/osgi/framework/ServiceReference 
.const [469] = Utf8 getProperty 
.const [470] = Utf8 (Ljava/lang/String;)Ljava/lang/Object; 
.const [471] = Utf8 org/osgi/framework/BundleContext 
.const [472] = Utf8 ungetService 
.const [473] = Utf8 (Lorg/osgi/framework/ServiceReference;)Z 
.const [474] = Utf8 de/audi/tghu/storagecache/CacheActivator 
.const [475] = Class [474] 
.const [476] = Utf8 de/audi/atip/activator/AbstractFrameworkActivator 
.const [477] = Class [476] 
.const [478] = Utf8 org/osgi/util/tracker/ServiceTrackerCustomizer 
.const [479] = Class [478] 
.const [480] = Utf8 tracker 
.const [481] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [482] = Utf8 cacheHandler 
.const [483] = Utf8 Lde/audi/tghu/storagecache/CacheHandlerImpl; 
.const [484] = Utf8 log 
.const [485] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [486] = Utf8 sRegCVState 
.const [487] = Utf8 Lorg/osgi/framework/ServiceRegistration; 
.const [488] = Utf8 context 
.const [489] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [490] = Utf8 sRegOTCWStates 
.const [491] = Utf8 Ljava/util/ArrayList; 
.const [492] = Utf8 class$org$dsi$ifc$carvehiclestates$DSICarVehicleStatesListener 
.const [493] = Utf8 Ljava/lang/Class; 
.const [494] = Utf8 class$org$dsi$ifc$base$DSIListener 
.const [495] = Utf8 Ljava/lang/Class; 
.const [496] = Utf8 class$de$audi$atip$interapp$online$IOnlineService 
.const [497] = Utf8 Ljava/lang/Class; 
.const [498] = Utf8 class$org$dsi$ifc$carvehiclestates$DSICarVehicleStates 
.const [499] = Utf8 Ljava/lang/Class; 
.const [500] = Utf8 class$de$audi$atip$storagecache$CacheEventListener 
.const [501] = Utf8 Ljava/lang/Class; 
.const [502] = Utf8 class$de$audi$atip$msg$MsgListener 
.const [503] = Utf8 Ljava/lang/Class; 
.const [504] = Utf8 Code 
.const [505] = Utf8 <init> 
.const [506] = Utf8 (Lde/audi/atip/base/FwServices;)V 
.const [507] = Utf8 getService 
.const [508] = Utf8 ()Lde/audi/tghu/storagecache/CacheHandlerImpl; 
.const [509] = Utf8 startInternal 
.const [510] = Utf8 (Lorg/osgi/framework/BundleContext;)V 
.const [511] = Utf8 stop 
.const [512] = Utf8 (Lorg/osgi/framework/BundleContext;)V 
.const [513] = Utf8 addingService 
.const [514] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [515] = Utf8 modifiedService 
.const [516] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [517] = Utf8 removedService 
.const [518] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [519] = Utf8 registerOTCWMsgListener 
.const [520] = Utf8 (Lorg/osgi/framework/BundleContext;Ljava/lang/String;)V 
.const [521] = Utf8 class$ 
.const [522] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.end class 
