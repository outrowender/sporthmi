.version 50 0 
.class public final super [360] 
.super [362] 
.implements [364] 
.field private [365] [366] 
.field private [367] [368] 
.field private [369] [370] 
.field private [371] [372] 
.field static synthetic [373] [374] 
.field static synthetic [375] [376] 
.field static synthetic [377] [378] 

.method public [380] : [381] 
    .attribute [379] .code stack 2 locals 0 
L0:     aload_0 
L1:     ldc [5] 
L3:     invokespecial [59] 
L6:     aload_0 
L7:     aconst_null 
L8:     putfield [71] 
L11:    return 
L12:    
    .end code 
.end method 

.method public interface [382] : [383] 
    .attribute [379] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [38] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method protected [384] : [385] 
    .attribute [379] .code stack 5 locals 1 
L0:     aload_0 
L1:     aload_0 
L2:     getfield [39] 
L5:     ldc [6] 
L7:     invokeinterface [72] 0 
L12:    putfield [73] 
L15:    aload_0 
L16:    getfield [40] 
L19:    ldc [7] 
L21:    ldc [8] 
L23:    invokevirtual [41] 
L26:    pop 
L27:    aload_0 
L28:    getfield [40] 
L31:    ldc [7] 
L33:    ldc [9] 
L35:    invokevirtual [41] 
L38:    pop 
L39:    aload_0 
L40:    new [74] 
L43:    dup 
L44:    aload_0 
L45:    getfield [39] 
L48:    invokespecial [60] 
L51:    putfield [71] 
L54:    aload_0 
L55:    aload_0 
L56:    getstatic [11] 
L59:    ifnonnull L74 
L62:    ldc [12] 
L64:    invokestatic [13] 
L67:    dup 
L68:    putstatic [61] 
L71:    goto L77 
L74:    getstatic [11] 
L77:    aload_0 
L78:    getfield [38] 
L81:    invokevirtual [42] 
L84:    iconst_0 
L85:    invokespecial [62] 
L88:    putfield [75] 
L91:    aload_0 
L92:    aload_0 
L93:    getstatic [11] 
L96:    ifnonnull L111 
L99:    ldc [12] 
L101:   invokestatic [13] 
L104:   dup 
L105:   putstatic [61] 
L108:   goto L114 
L111:   getstatic [11] 
L114:   aload_0 
L115:   getfield [38] 
L118:   invokevirtual [44] 
L121:   iconst_1 
L122:   invokespecial [62] 
L125:   putfield [76] 
L128:   new [77] 
L131:   dup 
L132:   aload_0 
L133:   getfield [46] 
L136:   getstatic [15] 
L139:   ifnonnull L154 
L142:   ldc [16] 
L144:   invokestatic [13] 
L147:   dup 
L148:   putstatic [63] 
L151:   goto L157 
L154:   getstatic [15] 
L157:   invokevirtual [47] 
L160:   aload_0 
L161:   invokespecial [64] 
L164:   astore_2 
L165:   aload_2 
L166:   invokevirtual [48] 
L169:   aload_0 
L170:   getfield [39] 
L173:   getstatic [15] 
L176:   ifnonnull L191 
L179:   ldc [16] 
L181:   invokestatic [13] 
L184:   dup 
L185:   putstatic [63] 
L188:   goto L194 
L191:   getstatic [15] 
L194:   invokevirtual [47] 
L197:   iconst_0 
L198:   invokeinterface [78] 0 
L203:   pop 
L204:   aload_0 
L205:   getfield [39] 
L208:   getstatic [15] 
L211:   ifnonnull L226 
L214:   ldc [16] 
L216:   invokestatic [13] 
L219:   dup 
L220:   putstatic [63] 
L223:   goto L229 
L226:   getstatic [15] 
L229:   invokevirtual [47] 
L232:   iconst_1 
L233:   invokeinterface [78] 0 
L238:   pop 
L239:   return 
L240:   
    .end code 
.end method 

.method public [386] : [387] 
    .attribute [379] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [40] 
L4:     ldc [7] 
L6:     ldc [17] 
L8:     invokevirtual [41] 
L11:    pop 
L12:    aload_0 
L13:    aload_0 
L14:    aload_0 
L15:    getfield [43] 
L18:    invokespecial [65] 
L21:    putfield [75] 
L24:    aload_0 
L25:    aload_0 
L26:    aload_0 
L27:    getfield [45] 
L30:    invokespecial [65] 
L33:    putfield [76] 
L36:    aload_0 
L37:    aload_1 
L38:    invokespecial [66] 
L41:    return 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 

.method public [388] : [389] 
    .attribute [379] .code stack 6 locals 2 
L0:     aload_0 
L1:     invokevirtual [49] 
L4:     aload_1 
L5:     invokeinterface [79] 0 
L10:    checkcast [18] 
L13:    astore_2 
L14:    aload_1 
L15:    ldc [19] 
L17:    invokeinterface [80] 0 
L22:    checkcast [20] 
L25:    invokevirtual [50] 
L28:    istore_3 
L29:    aload_0 
L30:    getfield [40] 
L33:    ldc [7] 
L35:    ldc [21] 
L37:    aload_2 
L38:    iload_3 
L39:    i2l 
L40:    invokevirtual [51] 
L43:    pop 
L44:    iload_3 
L45:    ifne L59 
L48:    aload_0 
L49:    getfield [38] 
L52:    aload_2 
L53:    invokevirtual [52] 
L56:    goto L72 
L59:    iload_3 
L60:    iconst_1 
L61:    if_icmpne L72 
L64:    aload_0 
L65:    getfield [38] 
L68:    aload_2 
L69:    invokevirtual [53] 
L72:    aload_2 
L73:    areturn 
L74:    nop 
L75:    nop 
L76:    
    .end code 
.end method 

.method public enum [390] : [391] 
    .attribute [379] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [392] : [393] 
    .attribute [379] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [40] 
L4:     ldc [7] 
L6:     ldc [22] 
L8:     aload_1 
L9:     aload_2 
L10:    invokevirtual [54] 
L13:    return 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method private [394] : [395] 
    .attribute [379] .code stack 7 locals 2 
L0:     aload_1 
L1:     invokevirtual [47] 
L4:     astore 4 
L6:     new [82] 
L9:     dup 
L10:    invokespecial [67] 
L13:    astore 5 
L15:    aload 5 
L17:    ldc [24] 
L19:    aload 4 
L21:    invokevirtual [55] 
L24:    pop 
L25:    aload 5 
L27:    ldc [19] 
L29:    new [81] 
L32:    dup 
L33:    iload_3 
L34:    invokespecial [68] 
L37:    invokevirtual [55] 
L40:    pop 
L41:    aload_0 
L42:    getfield [40] 
L45:    ldc [7] 
L47:    ldc [25] 
L49:    aload 4 
L51:    aload_2 
L52:    iload_3 
L53:    i2l 
L54:    invokevirtual [56] 
L57:    aload_0 
L58:    invokevirtual [49] 
L61:    getstatic [26] 
L64:    ifnonnull L79 
L67:    ldc [27] 
L69:    invokestatic [13] 
L72:    dup 
L73:    putstatic [69] 
L76:    goto L82 
L79:    getstatic [26] 
L82:    invokevirtual [47] 
L85:    aload_2 
L86:    aload 5 
L88:    invokeinterface [83] 0 
L93:    areturn 
L94:    nop 
L95:    nop 
L96:    
    .end code 
.end method 

.method private [396] : [397] 
    .attribute [379] .code stack 4 locals 0 
L0:     aload_1 
L1:     ifnull L23 
L4:     aload_0 
L5:     getfield [40] 
L8:     ldc [7] 
L10:    ldc [28] 
L12:    aload_1 
L13:    invokevirtual [57] 
L16:    pop 
L17:    aload_1 
L18:    invokeinterface [84] 0 
L23:    aconst_null 
L24:    areturn 
L25:    nop 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method static synthetic [398] : [399] 
    .attribute [379] .code stack 2 locals 1 
        .catch [3] from L0 to L4 using L5 
L0:     aload_0 
L1:     invokestatic [2] 
L4:     areturn 
L5:     astore_1 
L6:     new [70] 
L9:     dup 
L10:    invokespecial [58] 
L13:    aload_1 
L14:    invokevirtual [37] 
L17:    athrow 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [85] [86] 
.const [3] = Class [87] 
.const [4] = Class [88] 
.const [5] = String [89] 
.const [6] = String [90] 
.const [7] = Int -2137614336 
.const [8] = String [91] 
.const [9] = String [92] 
.const [10] = Class [93] 
.const [11] = Field [94] [95] 
.const [12] = String [96] 
.const [13] = Method [97] [98] 
.const [14] = Class [99] 
.const [15] = Field [100] [101] 
.const [16] = String [102] 
.const [17] = String [103] 
.const [18] = Class [104] 
.const [19] = String [105] 
.const [20] = Class [106] 
.const [21] = String [107] 
.const [22] = String [108] 
.const [23] = Class [109] 
.const [24] = String [110] 
.const [25] = String [111] 
.const [26] = Field [112] [113] 
.const [27] = String [114] 
.const [28] = String [115] 
.const [29] = Class [116] 
.const [30] = Class [117] 
.const [31] = Class [118] 
.const [32] = Class [119] 
.const [33] = Class [120] 
.const [34] = Class [121] 
.const [35] = Class [122] 
.const [36] = Class [123] 
.const [37] = Method [124] [125] 
.const [38] = Field [126] [127] 
.const [39] = Field [128] [129] 
.const [40] = Field [130] [131] 
.const [41] = Method [132] [133] 
.const [42] = Method [134] [135] 
.const [43] = Field [136] [137] 
.const [44] = Method [138] [139] 
.const [45] = Field [140] [141] 
.const [46] = Field [142] [143] 
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
.const [61] = Field [172] [173] 
.const [62] = Method [174] [175] 
.const [63] = Field [176] [177] 
.const [64] = Method [178] [179] 
.const [65] = Method [180] [181] 
.const [66] = Method [182] [183] 
.const [67] = Method [184] [185] 
.const [68] = Method [186] [187] 
.const [69] = Field [188] [189] 
.const [70] = Class [190] 
.const [71] = Field [191] [192] 
.const [72] = InterfaceMethod [193] [194] 
.const [73] = Field [195] [196] 
.const [74] = Class [197] 
.const [75] = Field [198] [199] 
.const [76] = Field [200] [201] 
.const [77] = Class [202] 
.const [78] = InterfaceMethod [203] [204] 
.const [79] = InterfaceMethod [205] [206] 
.const [80] = InterfaceMethod [207] [208] 
.const [81] = Class [209] 
.const [82] = Class [210] 
.const [83] = InterfaceMethod [211] [212] 
.const [84] = InterfaceMethod [213] [214] 
.const [85] = Class [215] 
.const [86] = NameAndType [216] [217] 
.const [87] = Utf8 java/lang/ClassNotFoundException 
.const [88] = Utf8 java/lang/NoClassDefFoundError 
.const [89] = Utf8 WavePlayer 
.const [90] = Utf8 'Fw.Waveplayer' 
.const [91] = Utf8 '[WavePlayerActivator#startLastMode] Called.' 
.const [92] = Utf8 '[WavePlayerActivator.start]' 
.const [93] = Utf8 de/audi/tghu/waveplayer/WavePlayerImpl 
.const [94] = Class [218] 
.const [95] = NameAndType [219] [220] 
.const [96] = Utf8 'org.dsi.ifc.waveplayer.DSIWavePlayerListener' 
.const [97] = Class [221] 
.const [98] = NameAndType [222] [223] 
.const [99] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [100] = Class [224] 
.const [101] = NameAndType [225] [226] 
.const [102] = Utf8 'org.dsi.ifc.waveplayer.DSIWavePlayer' 
.const [103] = Utf8 '[WavePlayerActivator.stop]' 
.const [104] = Utf8 org/dsi/ifc/waveplayer/DSIWavePlayer 
.const [105] = Utf8 DEVICE_INSTANCE 
.const [106] = Utf8 java/lang/Integer 
.const [107] = Utf8 '[WavePlayerActivator.addingService] %1 instance:%2' 
.const [108] = Utf8 '[WavePlayerActivator.removedService] %1 %2' 
.const [109] = Utf8 java/util/Hashtable 
.const [110] = Utf8 DEVICE_NAME 
.const [111] = Utf8 '[WavePlayerActivator.registerDSIListener] name:%1 listener:%2 instance:%3' 
.const [112] = Class [227] 
.const [113] = NameAndType [228] [229] 
.const [114] = Utf8 'org.dsi.ifc.base.DSIListener' 
.const [115] = Utf8 '[WavePlayerActivator.unregister] %1' 
.const [116] = Utf8 de/audi/tghu/waveplayer/WavePlayerActivator 
.const [117] = Utf8 de/audi/atip/activator/AbstractFrameworkActivator 
.const [118] = Utf8 java/lang/Class 
.const [119] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [120] = Utf8 de/audi/atip/log/LogChannel 
.const [121] = Utf8 org/osgi/framework/BundleContext 
.const [122] = Utf8 org/osgi/framework/ServiceReference 
.const [123] = Utf8 org/osgi/framework/ServiceRegistration 
.const [124] = Class [230] 
.const [125] = NameAndType [231] [232] 
.const [126] = Class [233] 
.const [127] = NameAndType [234] [235] 
.const [128] = Class [236] 
.const [129] = NameAndType [237] [238] 
.const [130] = Class [239] 
.const [131] = NameAndType [240] [241] 
.const [132] = Class [242] 
.const [133] = NameAndType [243] [244] 
.const [134] = Class [245] 
.const [135] = NameAndType [246] [247] 
.const [136] = Class [248] 
.const [137] = NameAndType [249] [250] 
.const [138] = Class [251] 
.const [139] = NameAndType [252] [253] 
.const [140] = Class [254] 
.const [141] = NameAndType [255] [256] 
.const [142] = Class [257] 
.const [143] = NameAndType [258] [259] 
.const [144] = Class [260] 
.const [145] = NameAndType [261] [262] 
.const [146] = Class [263] 
.const [147] = NameAndType [264] [265] 
.const [148] = Class [266] 
.const [149] = NameAndType [267] [268] 
.const [150] = Class [269] 
.const [151] = NameAndType [270] [271] 
.const [152] = Class [272] 
.const [153] = NameAndType [273] [274] 
.const [154] = Class [275] 
.const [155] = NameAndType [276] [277] 
.const [156] = Class [278] 
.const [157] = NameAndType [279] [280] 
.const [158] = Class [281] 
.const [159] = NameAndType [282] [283] 
.const [160] = Class [284] 
.const [161] = NameAndType [285] [286] 
.const [162] = Class [287] 
.const [163] = NameAndType [288] [289] 
.const [164] = Class [290] 
.const [165] = NameAndType [291] [292] 
.const [166] = Class [293] 
.const [167] = NameAndType [294] [295] 
.const [168] = Class [296] 
.const [169] = NameAndType [297] [298] 
.const [170] = Class [299] 
.const [171] = NameAndType [300] [301] 
.const [172] = Class [302] 
.const [173] = NameAndType [303] [304] 
.const [174] = Class [305] 
.const [175] = NameAndType [306] [307] 
.const [176] = Class [308] 
.const [177] = NameAndType [309] [310] 
.const [178] = Class [311] 
.const [179] = NameAndType [312] [313] 
.const [180] = Class [314] 
.const [181] = NameAndType [315] [316] 
.const [182] = Class [317] 
.const [183] = NameAndType [318] [319] 
.const [184] = Class [320] 
.const [185] = NameAndType [321] [322] 
.const [186] = Class [323] 
.const [187] = NameAndType [324] [325] 
.const [188] = Class [326] 
.const [189] = NameAndType [327] [328] 
.const [190] = Utf8 java/lang/NoClassDefFoundError 
.const [191] = Class [329] 
.const [192] = NameAndType [330] [331] 
.const [193] = Class [332] 
.const [194] = NameAndType [333] [334] 
.const [195] = Class [335] 
.const [196] = NameAndType [336] [337] 
.const [197] = Utf8 de/audi/tghu/waveplayer/WavePlayerImpl 
.const [198] = Class [338] 
.const [199] = NameAndType [339] [340] 
.const [200] = Class [341] 
.const [201] = NameAndType [342] [343] 
.const [202] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [203] = Class [344] 
.const [204] = NameAndType [345] [346] 
.const [205] = Class [347] 
.const [206] = NameAndType [348] [349] 
.const [207] = Class [350] 
.const [208] = NameAndType [351] [352] 
.const [209] = Utf8 java/lang/Integer 
.const [210] = Utf8 java/util/Hashtable 
.const [211] = Class [353] 
.const [212] = NameAndType [354] [355] 
.const [213] = Class [356] 
.const [214] = NameAndType [357] [358] 
.const [215] = Utf8 java/lang/Class 
.const [216] = Utf8 forName 
.const [217] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [218] = Utf8 de/audi/tghu/waveplayer/WavePlayerActivator 
.const [219] = Utf8 class$org$dsi$ifc$waveplayer$DSIWavePlayerListener 
.const [220] = Utf8 Ljava/lang/Class; 
.const [221] = Utf8 de/audi/tghu/waveplayer/WavePlayerActivator 
.const [222] = Utf8 class$ 
.const [223] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [224] = Utf8 de/audi/tghu/waveplayer/WavePlayerActivator 
.const [225] = Utf8 class$org$dsi$ifc$waveplayer$DSIWavePlayer 
.const [226] = Utf8 Ljava/lang/Class; 
.const [227] = Utf8 de/audi/tghu/waveplayer/WavePlayerActivator 
.const [228] = Utf8 class$org$dsi$ifc$base$DSIListener 
.const [229] = Utf8 Ljava/lang/Class; 
.const [230] = Utf8 java/lang/NoClassDefFoundError 
.const [231] = Utf8 initCause 
.const [232] = Utf8 (Ljava/lang/Throwable;)Ljava/lang/Throwable; 
.const [233] = Utf8 de/audi/tghu/waveplayer/WavePlayerActivator 
.const [234] = Utf8 wavePlayer 
.const [235] = Utf8 Lde/audi/tghu/waveplayer/WavePlayerImpl; 
.const [236] = Utf8 de/audi/tghu/waveplayer/WavePlayerActivator 
.const [237] = Utf8 framework 
.const [238] = Utf8 Lde/audi/atip/base/IFrameworkAccess; 
.const [239] = Utf8 de/audi/tghu/waveplayer/WavePlayerActivator 
.const [240] = Utf8 lc 
.const [241] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [242] = Utf8 de/audi/atip/log/LogChannel 
.const [243] = Utf8 log 
.const [244] = Utf8 (ILjava/lang/String;)Z 
.const [245] = Utf8 de/audi/tghu/waveplayer/WavePlayerImpl 
.const [246] = Utf8 getRingToneListener 
.const [247] = Utf8 ()Lorg/dsi/ifc/waveplayer/DSIWavePlayerListener; 
.const [248] = Utf8 de/audi/tghu/waveplayer/WavePlayerActivator 
.const [249] = Utf8 sRegDSIWavePlayerListenerRingTone 
.const [250] = Utf8 Lorg/osgi/framework/ServiceRegistration; 
.const [251] = Utf8 de/audi/tghu/waveplayer/WavePlayerImpl 
.const [252] = Utf8 getSystemToneListener 
.const [253] = Utf8 ()Lorg/dsi/ifc/waveplayer/DSIWavePlayerListener; 
.const [254] = Utf8 de/audi/tghu/waveplayer/WavePlayerActivator 
.const [255] = Utf8 sRegDSIWavePlayerListenerSystemTone 
.const [256] = Utf8 Lorg/osgi/framework/ServiceRegistration; 
.const [257] = Utf8 de/audi/tghu/waveplayer/WavePlayerActivator 
.const [258] = Utf8 bundleContext 
.const [259] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [260] = Utf8 java/lang/Class 
.const [261] = Utf8 getName 
.const [262] = Utf8 ()Ljava/lang/String; 
.const [263] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [264] = Utf8 'open' 
.const [265] = Utf8 ()V 
.const [266] = Utf8 de/audi/tghu/waveplayer/WavePlayerActivator 
.const [267] = Utf8 getBundleContext 
.const [268] = Utf8 ()Lorg/osgi/framework/BundleContext; 
.const [269] = Utf8 java/lang/Integer 
.const [270] = Utf8 intValue 
.const [271] = Utf8 ()I 
.const [272] = Utf8 de/audi/atip/log/LogChannel 
.const [273] = Utf8 log 
.const [274] = Utf8 (ILjava/lang/String;Ljava/lang/Object;J)Z 
.const [275] = Utf8 de/audi/tghu/waveplayer/WavePlayerImpl 
.const [276] = Utf8 registerRingTonePlayer 
.const [277] = Utf8 (Lorg/dsi/ifc/waveplayer/DSIWavePlayer;)V 
.const [278] = Utf8 de/audi/tghu/waveplayer/WavePlayerImpl 
.const [279] = Utf8 registerSystemTonePlayer 
.const [280] = Utf8 (Lorg/dsi/ifc/waveplayer/DSIWavePlayer;)V 
.const [281] = Utf8 de/audi/atip/log/LogChannel 
.const [282] = Utf8 log 
.const [283] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [284] = Utf8 java/util/Hashtable 
.const [285] = Utf8 put 
.const [286] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 
.const [287] = Utf8 de/audi/atip/log/LogChannel 
.const [288] = Utf8 log 
.const [289] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;J)V 
.const [290] = Utf8 de/audi/atip/log/LogChannel 
.const [291] = Utf8 log 
.const [292] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [293] = Utf8 java/lang/NoClassDefFoundError 
.const [294] = Utf8 <init> 
.const [295] = Utf8 ()V 
.const [296] = Utf8 de/audi/atip/activator/AbstractFrameworkActivator 
.const [297] = Utf8 <init> 
.const [298] = Utf8 (Ljava/lang/String;)V 
.const [299] = Utf8 de/audi/tghu/waveplayer/WavePlayerImpl 
.const [300] = Utf8 <init> 
.const [301] = Utf8 (Lde/audi/atip/base/IFrameworkAccess;)V 
.const [302] = Utf8 de/audi/tghu/waveplayer/WavePlayerActivator 
.const [303] = Utf8 class$org$dsi$ifc$waveplayer$DSIWavePlayerListener 
.const [304] = Utf8 Ljava/lang/Class; 
.const [305] = Utf8 de/audi/tghu/waveplayer/WavePlayerActivator 
.const [306] = Utf8 registerDSIListener 
.const [307] = Utf8 (Ljava/lang/Class;Lorg/dsi/ifc/base/DSIListener;I)Lorg/osgi/framework/ServiceRegistration; 
.const [308] = Utf8 de/audi/tghu/waveplayer/WavePlayerActivator 
.const [309] = Utf8 class$org$dsi$ifc$waveplayer$DSIWavePlayer 
.const [310] = Utf8 Ljava/lang/Class; 
.const [311] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [312] = Utf8 <init> 
.const [313] = Utf8 (Lorg/osgi/framework/BundleContext;Ljava/lang/String;Lorg/osgi/util/tracker/ServiceTrackerCustomizer;)V 
.const [314] = Utf8 de/audi/tghu/waveplayer/WavePlayerActivator 
.const [315] = Utf8 unregister 
.const [316] = Utf8 (Lorg/osgi/framework/ServiceRegistration;)Lorg/osgi/framework/ServiceRegistration; 
.const [317] = Utf8 de/audi/atip/activator/AbstractFrameworkActivator 
.const [318] = Utf8 stop 
.const [319] = Utf8 (Lorg/osgi/framework/BundleContext;)V 
.const [320] = Utf8 java/util/Hashtable 
.const [321] = Utf8 <init> 
.const [322] = Utf8 ()V 
.const [323] = Utf8 java/lang/Integer 
.const [324] = Utf8 <init> 
.const [325] = Utf8 (I)V 
.const [326] = Utf8 de/audi/tghu/waveplayer/WavePlayerActivator 
.const [327] = Utf8 class$org$dsi$ifc$base$DSIListener 
.const [328] = Utf8 Ljava/lang/Class; 
.const [329] = Utf8 de/audi/tghu/waveplayer/WavePlayerActivator 
.const [330] = Utf8 wavePlayer 
.const [331] = Utf8 Lde/audi/tghu/waveplayer/WavePlayerImpl; 
.const [332] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [333] = Utf8 getLogChannel 
.const [334] = Utf8 (Ljava/lang/String;)Lde/audi/atip/log/LogChannel; 
.const [335] = Utf8 de/audi/tghu/waveplayer/WavePlayerActivator 
.const [336] = Utf8 lc 
.const [337] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [338] = Utf8 de/audi/tghu/waveplayer/WavePlayerActivator 
.const [339] = Utf8 sRegDSIWavePlayerListenerRingTone 
.const [340] = Utf8 Lorg/osgi/framework/ServiceRegistration; 
.const [341] = Utf8 de/audi/tghu/waveplayer/WavePlayerActivator 
.const [342] = Utf8 sRegDSIWavePlayerListenerSystemTone 
.const [343] = Utf8 Lorg/osgi/framework/ServiceRegistration; 
.const [344] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [345] = Utf8 startDSIService 
.const [346] = Utf8 (Ljava/lang/String;I)Z 
.const [347] = Utf8 org/osgi/framework/BundleContext 
.const [348] = Utf8 getService 
.const [349] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [350] = Utf8 org/osgi/framework/ServiceReference 
.const [351] = Utf8 getProperty 
.const [352] = Utf8 (Ljava/lang/String;)Ljava/lang/Object; 
.const [353] = Utf8 org/osgi/framework/BundleContext 
.const [354] = Utf8 registerService 
.const [355] = Utf8 (Ljava/lang/String;Ljava/lang/Object;Ljava/util/Dictionary;)Lorg/osgi/framework/ServiceRegistration; 
.const [356] = Utf8 org/osgi/framework/ServiceRegistration 
.const [357] = Utf8 unregister 
.const [358] = Utf8 ()V 
.const [359] = Utf8 de/audi/tghu/waveplayer/WavePlayerActivator 
.const [360] = Class [359] 
.const [361] = Utf8 de/audi/atip/activator/AbstractFrameworkActivator 
.const [362] = Class [361] 
.const [363] = Utf8 org/osgi/util/tracker/ServiceTrackerCustomizer 
.const [364] = Class [363] 
.const [365] = Utf8 sRegDSIWavePlayerListenerRingTone 
.const [366] = Utf8 Lorg/osgi/framework/ServiceRegistration; 
.const [367] = Utf8 sRegDSIWavePlayerListenerSystemTone 
.const [368] = Utf8 Lorg/osgi/framework/ServiceRegistration; 
.const [369] = Utf8 lc 
.const [370] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [371] = Utf8 wavePlayer 
.const [372] = Utf8 Lde/audi/tghu/waveplayer/WavePlayerImpl; 
.const [373] = Utf8 class$org$dsi$ifc$waveplayer$DSIWavePlayerListener 
.const [374] = Utf8 Ljava/lang/Class; 
.const [375] = Utf8 class$org$dsi$ifc$waveplayer$DSIWavePlayer 
.const [376] = Utf8 Ljava/lang/Class; 
.const [377] = Utf8 class$org$dsi$ifc$base$DSIListener 
.const [378] = Utf8 Ljava/lang/Class; 
.const [379] = Utf8 Code 
.const [380] = Utf8 <init> 
.const [381] = Utf8 ()V 
.const [382] = Utf8 getService 
.const [383] = Utf8 ()Lde/audi/tghu/waveplayer/WavePlayerImpl; 
.const [384] = Utf8 startInternal 
.const [385] = Utf8 (Lorg/osgi/framework/BundleContext;)V 
.const [386] = Utf8 stop 
.const [387] = Utf8 (Lorg/osgi/framework/BundleContext;)V 
.const [388] = Utf8 addingService 
.const [389] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [390] = Utf8 modifiedService 
.const [391] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [392] = Utf8 removedService 
.const [393] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [394] = Utf8 registerDSIListener 
.const [395] = Utf8 (Ljava/lang/Class;Lorg/dsi/ifc/base/DSIListener;I)Lorg/osgi/framework/ServiceRegistration; 
.const [396] = Utf8 unregister 
.const [397] = Utf8 (Lorg/osgi/framework/ServiceRegistration;)Lorg/osgi/framework/ServiceRegistration; 
.const [398] = Utf8 class$ 
.const [399] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.end class 
