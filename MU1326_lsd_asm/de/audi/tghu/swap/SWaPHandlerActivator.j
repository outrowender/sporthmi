.version 50 0 
.class public super [336] 
.super [338] 
.implements [340] 
.field private [341] [342] 
.field private [343] [344] 
.field private [345] [346] 
.field private [347] [348] 
.field private [349] [350] 
.field static synthetic [351] [352] 
.field static synthetic [353] [354] 
.field static synthetic [355] [356] 
.field static synthetic [357] [358] 

.method public [360] : [361] 
    .attribute [359] .code stack 2 locals 0 
L0:     aload_0 
L1:     ldc [5] 
L3:     invokespecial [55] 
L6:     aload_0 
L7:     aload_1 
L8:     putfield [66] 
L11:    return 
L12:    
    .end code 
.end method 

.method public interface [362] : [363] 
    .attribute [359] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [39] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method protected [364] : [365] 
    .attribute [359] .code stack 6 locals 2 
L0:     aload_0 
L1:     aload_0 
L2:     getfield [40] 
L5:     ldc [6] 
L7:     invokeinterface [68] 0 
L12:    putfield [69] 
L15:    aload_0 
L16:    new [70] 
L19:    dup 
L20:    aload_0 
L21:    getfield [40] 
L24:    invokespecial [56] 
L27:    putfield [67] 
L30:    new [71] 
L33:    dup 
L34:    invokespecial [57] 
L37:    astore_2 
L38:    aload_2 
L39:    ldc [9] 
L41:    getstatic [10] 
L44:    ifnonnull L59 
L47:    ldc [11] 
L49:    invokestatic [12] 
L52:    dup 
L53:    putstatic [58] 
L56:    goto L62 
L59:    getstatic [10] 
L62:    invokevirtual [42] 
L65:    invokevirtual [43] 
L68:    pop 
L69:    aload_2 
L70:    ldc [13] 
L72:    new [72] 
L75:    dup 
L76:    iconst_0 
L77:    invokespecial [59] 
L80:    invokevirtual [43] 
L83:    pop 
L84:    aload_0 
L85:    aload_1 
L86:    getstatic [15] 
L89:    ifnonnull L104 
L92:    ldc [16] 
L94:    invokestatic [12] 
L97:    dup 
L98:    putstatic [60] 
L101:   goto L107 
L104:   getstatic [15] 
L107:   invokevirtual [42] 
L110:   aload_0 
L111:   getfield [39] 
L114:   aload_2 
L115:   invokeinterface [73] 0 
L120:   putfield [74] 
L123:   iconst_2 
L124:   anewarray [17] 
L127:   dup 
L128:   iconst_0 
L129:   getstatic [18] 
L132:   ifnonnull L147 
L135:   ldc [19] 
L137:   invokestatic [12] 
L140:   dup 
L141:   putstatic [61] 
L144:   goto L150 
L147:   getstatic [18] 
L150:   invokevirtual [42] 
L153:   aastore 
L154:   dup 
L155:   iconst_1 
L156:   getstatic [20] 
L159:   ifnonnull L174 
L162:   ldc [21] 
L164:   invokestatic [12] 
L167:   dup 
L168:   putstatic [62] 
L171:   goto L177 
L174:   getstatic [20] 
L177:   invokevirtual [42] 
L180:   aastore 
L181:   astore_3 
L182:   aload_0 
L183:   new [75] 
L186:   dup 
L187:   aload_0 
L188:   getfield [45] 
L191:   aload_3 
L192:   aload_0 
L193:   invokespecial [63] 
L196:   putfield [76] 
L199:   aload_0 
L200:   getfield [46] 
L203:   invokevirtual [47] 
L206:   aload_0 
L207:   getfield [40] 
L210:   getstatic [18] 
L213:   ifnonnull L228 
L216:   ldc [19] 
L218:   invokestatic [12] 
L221:   dup 
L222:   putstatic [61] 
L225:   goto L231 
L228:   getstatic [18] 
L231:   invokevirtual [42] 
L234:   iconst_0 
L235:   invokeinterface [77] 0 
L240:   pop 
L241:   return 
L242:   nop 
L243:   nop 
L244:   
    .end code 
.end method 

.method public [366] : [367] 
    .attribute [359] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [44] 
L4:     ifnull L21 
L7:     aload_0 
L8:     getfield [44] 
L11:    invokeinterface [78] 0 
L16:    aload_0 
L17:    aconst_null 
L18:    putfield [74] 
L21:    aload_0 
L22:    getfield [46] 
L25:    ifnull L40 
L28:    aload_0 
L29:    getfield [46] 
L32:    invokevirtual [48] 
L35:    aload_0 
L36:    aconst_null 
L37:    putfield [76] 
L40:    aload_0 
L41:    aconst_null 
L42:    putfield [69] 
L45:    aload_0 
L46:    aload_1 
L47:    invokespecial [64] 
L50:    return 
L51:    nop 
L52:    
    .end code 
.end method 

.method public [368] : [369] 
    .attribute [359] .code stack 4 locals 1 
L0:     aload_0 
L1:     getfield [45] 
L4:     aload_1 
L5:     invokeinterface [79] 0 
L10:    astore_2 
L11:    aload_2 
L12:    instanceof [23] 
L15:    ifeq L45 
L18:    aload_0 
L19:    getfield [41] 
L22:    ldc [24] 
L24:    ldc [25] 
L26:    aload_2 
L27:    invokevirtual [49] 
L30:    pop 
L31:    aload_0 
L32:    getfield [39] 
L35:    aload_2 
L36:    checkcast [23] 
L39:    invokevirtual [50] 
L42:    goto L106 
L45:    aload_2 
L46:    instanceof [26] 
L49:    ifeq L79 
L52:    aload_0 
L53:    getfield [41] 
L56:    ldc [24] 
L58:    ldc [27] 
L60:    aload_2 
L61:    invokevirtual [49] 
L64:    pop 
L65:    aload_0 
L66:    getfield [39] 
L69:    aload_2 
L70:    checkcast [26] 
L73:    invokevirtual [51] 
L76:    goto L106 
L79:    aload_0 
L80:    getfield [41] 
L83:    sipush 10000 
L86:    ldc [28] 
L88:    aload_2 
L89:    invokevirtual [49] 
L92:    pop 
L93:    aload_0 
L94:    invokevirtual [52] 
L97:    aload_1 
L98:    invokeinterface [80] 0 
L103:   pop 
L104:   aconst_null 
L105:   areturn 
L106:   aload_2 
L107:   areturn 
L108:   
    .end code 
.end method 

.method public enum [370] : [371] 
    .attribute [359] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [372] : [373] 
    .attribute [359] .code stack 4 locals 0 
L0:     aload_2 
L1:     instanceof [26] 
L4:     ifeq L31 
L7:     aload_0 
L8:     getfield [41] 
L11:    ldc [24] 
L13:    ldc [29] 
L15:    aload_2 
L16:    invokevirtual [49] 
L19:    pop 
L20:    aload_0 
L21:    getfield [39] 
L24:    aload_2 
L25:    checkcast [26] 
L28:    invokevirtual [53] 
L31:    aload_0 
L32:    getfield [45] 
L35:    aload_1 
L36:    invokeinterface [80] 0 
L41:    pop 
L42:    return 
L43:    nop 
L44:    
    .end code 
.end method 

.method static synthetic [374] : [375] 
    .attribute [359] .code stack 2 locals 1 
        .catch [3] from L0 to L4 using L5 
L0:     aload_0 
L1:     invokestatic [2] 
L4:     areturn 
L5:     astore_1 
L6:     new [65] 
L9:     dup 
L10:    invokespecial [54] 
L13:    aload_1 
L14:    invokevirtual [38] 
L17:    athrow 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [81] [82] 
.const [3] = Class [83] 
.const [4] = Class [84] 
.const [5] = String [85] 
.const [6] = String [86] 
.const [7] = Class [87] 
.const [8] = Class [88] 
.const [9] = String [89] 
.const [10] = Field [90] [91] 
.const [11] = String [92] 
.const [12] = Method [93] [94] 
.const [13] = String [95] 
.const [14] = Class [96] 
.const [15] = Field [97] [98] 
.const [16] = String [99] 
.const [17] = Class [100] 
.const [18] = Field [101] [102] 
.const [19] = String [103] 
.const [20] = Field [104] [105] 
.const [21] = String [106] 
.const [22] = Class [107] 
.const [23] = Class [108] 
.const [24] = Int 1078071040 
.const [25] = String [109] 
.const [26] = Class [110] 
.const [27] = String [111] 
.const [28] = String [112] 
.const [29] = String [113] 
.const [30] = Class [114] 
.const [31] = Class [115] 
.const [32] = Class [116] 
.const [33] = Class [117] 
.const [34] = Class [118] 
.const [35] = Class [119] 
.const [36] = Class [120] 
.const [37] = Class [121] 
.const [38] = Method [122] [123] 
.const [39] = Field [124] [125] 
.const [40] = Field [126] [127] 
.const [41] = Field [128] [129] 
.const [42] = Method [130] [131] 
.const [43] = Method [132] [133] 
.const [44] = Field [134] [135] 
.const [45] = Field [136] [137] 
.const [46] = Field [138] [139] 
.const [47] = Method [140] [141] 
.const [48] = Method [142] [143] 
.const [49] = Method [144] [145] 
.const [50] = Method [146] [147] 
.const [51] = Method [148] [149] 
.const [52] = Method [150] [151] 
.const [53] = Method [152] [153] 
.const [54] = Method [154] [155] 
.const [55] = Method [156] [157] 
.const [56] = Method [158] [159] 
.const [57] = Method [160] [161] 
.const [58] = Field [162] [163] 
.const [59] = Method [164] [165] 
.const [60] = Field [166] [167] 
.const [61] = Field [168] [169] 
.const [62] = Field [170] [171] 
.const [63] = Method [172] [173] 
.const [64] = Method [174] [175] 
.const [65] = Class [176] 
.const [66] = Field [177] [178] 
.const [67] = Field [179] [180] 
.const [68] = InterfaceMethod [181] [182] 
.const [69] = Field [183] [184] 
.const [70] = Class [185] 
.const [71] = Class [186] 
.const [72] = Class [187] 
.const [73] = InterfaceMethod [188] [189] 
.const [74] = Field [190] [191] 
.const [75] = Class [192] 
.const [76] = Field [193] [194] 
.const [77] = InterfaceMethod [195] [196] 
.const [78] = InterfaceMethod [197] [198] 
.const [79] = InterfaceMethod [199] [200] 
.const [80] = InterfaceMethod [201] [202] 
.const [81] = Class [203] 
.const [82] = NameAndType [204] [205] 
.const [83] = Utf8 java/lang/ClassNotFoundException 
.const [84] = Utf8 java/lang/NoClassDefFoundError 
.const [85] = Utf8 FwSWaPDSI 
.const [86] = Utf8 'Fw.SWaP.Activator' 
.const [87] = Utf8 de/audi/tghu/swap/SWaPHandlerImpl 
.const [88] = Utf8 java/util/Hashtable 
.const [89] = Utf8 DEVICE_NAME 
.const [90] = Class [206] 
.const [91] = NameAndType [207] [208] 
.const [92] = Utf8 'org.dsi.ifc.swap.DSISWaPListener' 
.const [93] = Class [209] 
.const [94] = NameAndType [210] [211] 
.const [95] = Utf8 DEVICE_INSTANCE 
.const [96] = Utf8 java/lang/Integer 
.const [97] = Class [212] 
.const [98] = NameAndType [213] [214] 
.const [99] = Utf8 'org.dsi.ifc.base.DSIListener' 
.const [100] = Utf8 java/lang/String 
.const [101] = Class [215] 
.const [102] = NameAndType [216] [217] 
.const [103] = Utf8 'org.dsi.ifc.swap.DSISWaP' 
.const [104] = Class [218] 
.const [105] = NameAndType [219] [220] 
.const [106] = Utf8 'de.audi.atip.swap.SWaPEventListener' 
.const [107] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [108] = Utf8 org/dsi/ifc/swap/DSISWaP 
.const [109] = Utf8 'Setting DSI Service=%1' 
.const [110] = Utf8 de/audi/atip/swap/SWaPEventListener 
.const [111] = Utf8 'Adding Service=%1' 
.const [112] = Utf8 'track unwanted service=%1' 
.const [113] = Utf8 'Removing Service=%1' 
.const [114] = Utf8 de/audi/tghu/swap/SWaPHandlerActivator 
.const [115] = Utf8 de/audi/atip/activator/AbstractFrameworkActivator 
.const [116] = Utf8 java/lang/Class 
.const [117] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [118] = Utf8 java/util/Dictionary 
.const [119] = Utf8 org/osgi/framework/BundleContext 
.const [120] = Utf8 org/osgi/framework/ServiceRegistration 
.const [121] = Utf8 de/audi/atip/log/LogChannel 
.const [122] = Class [221] 
.const [123] = NameAndType [222] [223] 
.const [124] = Class [224] 
.const [125] = NameAndType [225] [226] 
.const [126] = Class [227] 
.const [127] = NameAndType [228] [229] 
.const [128] = Class [230] 
.const [129] = NameAndType [231] [232] 
.const [130] = Class [233] 
.const [131] = NameAndType [234] [235] 
.const [132] = Class [236] 
.const [133] = NameAndType [237] [238] 
.const [134] = Class [239] 
.const [135] = NameAndType [240] [241] 
.const [136] = Class [242] 
.const [137] = NameAndType [243] [244] 
.const [138] = Class [245] 
.const [139] = NameAndType [246] [247] 
.const [140] = Class [248] 
.const [141] = NameAndType [249] [250] 
.const [142] = Class [251] 
.const [143] = NameAndType [252] [253] 
.const [144] = Class [254] 
.const [145] = NameAndType [255] [256] 
.const [146] = Class [257] 
.const [147] = NameAndType [258] [259] 
.const [148] = Class [260] 
.const [149] = NameAndType [261] [262] 
.const [150] = Class [263] 
.const [151] = NameAndType [264] [265] 
.const [152] = Class [266] 
.const [153] = NameAndType [267] [268] 
.const [154] = Class [269] 
.const [155] = NameAndType [270] [271] 
.const [156] = Class [272] 
.const [157] = NameAndType [273] [274] 
.const [158] = Class [275] 
.const [159] = NameAndType [276] [277] 
.const [160] = Class [278] 
.const [161] = NameAndType [279] [280] 
.const [162] = Class [281] 
.const [163] = NameAndType [282] [283] 
.const [164] = Class [284] 
.const [165] = NameAndType [285] [286] 
.const [166] = Class [287] 
.const [167] = NameAndType [288] [289] 
.const [168] = Class [290] 
.const [169] = NameAndType [291] [292] 
.const [170] = Class [293] 
.const [171] = NameAndType [294] [295] 
.const [172] = Class [296] 
.const [173] = NameAndType [297] [298] 
.const [174] = Class [299] 
.const [175] = NameAndType [300] [301] 
.const [176] = Utf8 java/lang/NoClassDefFoundError 
.const [177] = Class [302] 
.const [178] = NameAndType [303] [304] 
.const [179] = Class [305] 
.const [180] = NameAndType [306] [307] 
.const [181] = Class [308] 
.const [182] = NameAndType [309] [310] 
.const [183] = Class [311] 
.const [184] = NameAndType [312] [313] 
.const [185] = Utf8 de/audi/tghu/swap/SWaPHandlerImpl 
.const [186] = Utf8 java/util/Hashtable 
.const [187] = Utf8 java/lang/Integer 
.const [188] = Class [314] 
.const [189] = NameAndType [315] [316] 
.const [190] = Class [317] 
.const [191] = NameAndType [318] [319] 
.const [192] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [193] = Class [320] 
.const [194] = NameAndType [321] [322] 
.const [195] = Class [323] 
.const [196] = NameAndType [324] [325] 
.const [197] = Class [326] 
.const [198] = NameAndType [327] [328] 
.const [199] = Class [329] 
.const [200] = NameAndType [330] [331] 
.const [201] = Class [332] 
.const [202] = NameAndType [333] [334] 
.const [203] = Utf8 java/lang/Class 
.const [204] = Utf8 forName 
.const [205] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [206] = Utf8 de/audi/tghu/swap/SWaPHandlerActivator 
.const [207] = Utf8 class$org$dsi$ifc$swap$DSISWaPListener 
.const [208] = Utf8 Ljava/lang/Class; 
.const [209] = Utf8 de/audi/tghu/swap/SWaPHandlerActivator 
.const [210] = Utf8 class$ 
.const [211] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [212] = Utf8 de/audi/tghu/swap/SWaPHandlerActivator 
.const [213] = Utf8 class$org$dsi$ifc$base$DSIListener 
.const [214] = Utf8 Ljava/lang/Class; 
.const [215] = Utf8 de/audi/tghu/swap/SWaPHandlerActivator 
.const [216] = Utf8 class$org$dsi$ifc$swap$DSISWaP 
.const [217] = Utf8 Ljava/lang/Class; 
.const [218] = Utf8 de/audi/tghu/swap/SWaPHandlerActivator 
.const [219] = Utf8 class$de$audi$atip$swap$SWaPEventListener 
.const [220] = Utf8 Ljava/lang/Class; 
.const [221] = Utf8 java/lang/NoClassDefFoundError 
.const [222] = Utf8 initCause 
.const [223] = Utf8 (Ljava/lang/Throwable;)Ljava/lang/Throwable; 
.const [224] = Utf8 de/audi/tghu/swap/SWaPHandlerActivator 
.const [225] = Utf8 swapHandler 
.const [226] = Utf8 Lde/audi/tghu/swap/SWaPHandlerImpl; 
.const [227] = Utf8 de/audi/tghu/swap/SWaPHandlerActivator 
.const [228] = Utf8 framework 
.const [229] = Utf8 Lde/audi/atip/base/IFrameworkAccess; 
.const [230] = Utf8 de/audi/tghu/swap/SWaPHandlerActivator 
.const [231] = Utf8 log 
.const [232] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [233] = Utf8 java/lang/Class 
.const [234] = Utf8 getName 
.const [235] = Utf8 ()Ljava/lang/String; 
.const [236] = Utf8 java/util/Dictionary 
.const [237] = Utf8 put 
.const [238] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 
.const [239] = Utf8 de/audi/tghu/swap/SWaPHandlerActivator 
.const [240] = Utf8 sRegSWaP 
.const [241] = Utf8 Lorg/osgi/framework/ServiceRegistration; 
.const [242] = Utf8 de/audi/tghu/swap/SWaPHandlerActivator 
.const [243] = Utf8 bundleContext 
.const [244] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [245] = Utf8 de/audi/tghu/swap/SWaPHandlerActivator 
.const [246] = Utf8 tracker 
.const [247] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [248] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [249] = Utf8 'open' 
.const [250] = Utf8 ()V 
.const [251] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [252] = Utf8 close 
.const [253] = Utf8 ()V 
.const [254] = Utf8 de/audi/atip/log/LogChannel 
.const [255] = Utf8 log 
.const [256] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [257] = Utf8 de/audi/tghu/swap/SWaPHandlerImpl 
.const [258] = Utf8 setDSI 
.const [259] = Utf8 (Lorg/dsi/ifc/swap/DSISWaP;)V 
.const [260] = Utf8 de/audi/tghu/swap/SWaPHandlerImpl 
.const [261] = Utf8 addListener 
.const [262] = Utf8 (Lde/audi/atip/swap/SWaPEventListener;)V 
.const [263] = Utf8 de/audi/tghu/swap/SWaPHandlerActivator 
.const [264] = Utf8 getBundleContext 
.const [265] = Utf8 ()Lorg/osgi/framework/BundleContext; 
.const [266] = Utf8 de/audi/tghu/swap/SWaPHandlerImpl 
.const [267] = Utf8 removeListener 
.const [268] = Utf8 (Lde/audi/atip/swap/SWaPEventListener;)V 
.const [269] = Utf8 java/lang/NoClassDefFoundError 
.const [270] = Utf8 <init> 
.const [271] = Utf8 ()V 
.const [272] = Utf8 de/audi/atip/activator/AbstractFrameworkActivator 
.const [273] = Utf8 <init> 
.const [274] = Utf8 (Ljava/lang/String;)V 
.const [275] = Utf8 de/audi/tghu/swap/SWaPHandlerImpl 
.const [276] = Utf8 <init> 
.const [277] = Utf8 (Lde/audi/atip/base/IFrameworkAccess;)V 
.const [278] = Utf8 java/util/Hashtable 
.const [279] = Utf8 <init> 
.const [280] = Utf8 ()V 
.const [281] = Utf8 de/audi/tghu/swap/SWaPHandlerActivator 
.const [282] = Utf8 class$org$dsi$ifc$swap$DSISWaPListener 
.const [283] = Utf8 Ljava/lang/Class; 
.const [284] = Utf8 java/lang/Integer 
.const [285] = Utf8 <init> 
.const [286] = Utf8 (I)V 
.const [287] = Utf8 de/audi/tghu/swap/SWaPHandlerActivator 
.const [288] = Utf8 class$org$dsi$ifc$base$DSIListener 
.const [289] = Utf8 Ljava/lang/Class; 
.const [290] = Utf8 de/audi/tghu/swap/SWaPHandlerActivator 
.const [291] = Utf8 class$org$dsi$ifc$swap$DSISWaP 
.const [292] = Utf8 Ljava/lang/Class; 
.const [293] = Utf8 de/audi/tghu/swap/SWaPHandlerActivator 
.const [294] = Utf8 class$de$audi$atip$swap$SWaPEventListener 
.const [295] = Utf8 Ljava/lang/Class; 
.const [296] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [297] = Utf8 <init> 
.const [298] = Utf8 (Lorg/osgi/framework/BundleContext;[Ljava/lang/String;Lorg/osgi/util/tracker/ServiceTrackerCustomizer;)V 
.const [299] = Utf8 de/audi/atip/activator/AbstractFrameworkActivator 
.const [300] = Utf8 stop 
.const [301] = Utf8 (Lorg/osgi/framework/BundleContext;)V 
.const [302] = Utf8 de/audi/tghu/swap/SWaPHandlerActivator 
.const [303] = Utf8 fwService 
.const [304] = Utf8 Lde/audi/atip/base/FwServices; 
.const [305] = Utf8 de/audi/tghu/swap/SWaPHandlerActivator 
.const [306] = Utf8 swapHandler 
.const [307] = Utf8 Lde/audi/tghu/swap/SWaPHandlerImpl; 
.const [308] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [309] = Utf8 getLogChannel 
.const [310] = Utf8 (Ljava/lang/String;)Lde/audi/atip/log/LogChannel; 
.const [311] = Utf8 de/audi/tghu/swap/SWaPHandlerActivator 
.const [312] = Utf8 log 
.const [313] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [314] = Utf8 org/osgi/framework/BundleContext 
.const [315] = Utf8 registerService 
.const [316] = Utf8 (Ljava/lang/String;Ljava/lang/Object;Ljava/util/Dictionary;)Lorg/osgi/framework/ServiceRegistration; 
.const [317] = Utf8 de/audi/tghu/swap/SWaPHandlerActivator 
.const [318] = Utf8 sRegSWaP 
.const [319] = Utf8 Lorg/osgi/framework/ServiceRegistration; 
.const [320] = Utf8 de/audi/tghu/swap/SWaPHandlerActivator 
.const [321] = Utf8 tracker 
.const [322] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [323] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [324] = Utf8 startDSIService 
.const [325] = Utf8 (Ljava/lang/String;I)Z 
.const [326] = Utf8 org/osgi/framework/ServiceRegistration 
.const [327] = Utf8 unregister 
.const [328] = Utf8 ()V 
.const [329] = Utf8 org/osgi/framework/BundleContext 
.const [330] = Utf8 getService 
.const [331] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [332] = Utf8 org/osgi/framework/BundleContext 
.const [333] = Utf8 ungetService 
.const [334] = Utf8 (Lorg/osgi/framework/ServiceReference;)Z 
.const [335] = Utf8 de/audi/tghu/swap/SWaPHandlerActivator 
.const [336] = Class [335] 
.const [337] = Utf8 de/audi/atip/activator/AbstractFrameworkActivator 
.const [338] = Class [337] 
.const [339] = Utf8 org/osgi/util/tracker/ServiceTrackerCustomizer 
.const [340] = Class [339] 
.const [341] = Utf8 tracker 
.const [342] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [343] = Utf8 fwService 
.const [344] = Utf8 Lde/audi/atip/base/FwServices; 
.const [345] = Utf8 swapHandler 
.const [346] = Utf8 Lde/audi/tghu/swap/SWaPHandlerImpl; 
.const [347] = Utf8 sRegSWaP 
.const [348] = Utf8 Lorg/osgi/framework/ServiceRegistration; 
.const [349] = Utf8 log 
.const [350] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [351] = Utf8 class$org$dsi$ifc$swap$DSISWaPListener 
.const [352] = Utf8 Ljava/lang/Class; 
.const [353] = Utf8 class$org$dsi$ifc$base$DSIListener 
.const [354] = Utf8 Ljava/lang/Class; 
.const [355] = Utf8 class$org$dsi$ifc$swap$DSISWaP 
.const [356] = Utf8 Ljava/lang/Class; 
.const [357] = Utf8 class$de$audi$atip$swap$SWaPEventListener 
.const [358] = Utf8 Ljava/lang/Class; 
.const [359] = Utf8 Code 
.const [360] = Utf8 <init> 
.const [361] = Utf8 (Lde/audi/atip/base/FwServices;)V 
.const [362] = Utf8 getService 
.const [363] = Utf8 ()Lde/audi/atip/swap/SWaPHandler; 
.const [364] = Utf8 startInternal 
.const [365] = Utf8 (Lorg/osgi/framework/BundleContext;)V 
.const [366] = Utf8 stop 
.const [367] = Utf8 (Lorg/osgi/framework/BundleContext;)V 
.const [368] = Utf8 addingService 
.const [369] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [370] = Utf8 modifiedService 
.const [371] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [372] = Utf8 removedService 
.const [373] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [374] = Utf8 class$ 
.const [375] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.end class 
