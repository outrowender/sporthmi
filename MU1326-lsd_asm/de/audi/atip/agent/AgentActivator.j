.version 50 0 
.class public super [281] 
.super [283] 
.field private [284] [285] 
.field private [286] [287] 
.field private [288] [289] 
.field private [290] [291] 
.field static synthetic [292] [293] 
.field static synthetic [294] [295] 

.method public [297] : [298] 
    .attribute [296] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [42] 
L4:     aload_0 
L5:     aconst_null 
L6:     putfield [52] 
L9:     aload_0 
L10:    aconst_null 
L11:    putfield [51] 
L14:    aload_0 
L15:    aconst_null 
L16:    putfield [54] 
L19:    aload_0 
L20:    aconst_null 
L21:    putfield [55] 
L24:    return 
L25:    nop 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method private final [299] : [300] 
    .attribute [296] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokevirtual [35] 
L4:     invokeinterface [56] 0 
L9:     aload_1 
L10:    invokeinterface [57] 0 
L15:    return 
L16:    
    .end code 
.end method 

.method public final [301] : [302] 
    .attribute [296] .code stack 9 locals 1 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [43] 
L5:     aload_0 
L6:     aload_0 
L7:     invokevirtual [35] 
L10:    ldc [5] 
L12:    invokeinterface [58] 0 
L17:    putfield [52] 
L20:    aload_0 
L21:    invokevirtual [35] 
L24:    invokeinterface [59] 0 
L29:    ifne L33 
L32:    return 
        .catch [17] from L33 to L158 using L161 
L33:    aload_0 
L34:    ldc [6] 
L36:    invokespecial [44] 
L39:    aload_0 
L40:    new [60] 
L43:    dup 
L44:    aload_0 
L45:    invokevirtual [35] 
L48:    invokespecial [45] 
L51:    putfield [51] 
L54:    aload_0 
L55:    aload_1 
L56:    getstatic [8] 
L59:    ifnonnull L74 
L62:    ldc [9] 
L64:    invokestatic [10] 
L67:    dup 
L68:    putstatic [46] 
L71:    goto L77 
L74:    getstatic [8] 
L77:    invokevirtual [36] 
L80:    aload_0 
L81:    getfield [30] 
L84:    aconst_null 
L85:    invokeinterface [61] 0 
L90:    putfield [54] 
L93:    aload_0 
L94:    new [62] 
L97:    dup 
L98:    aload_1 
L99:    iconst_1 
L100:   anewarray [12] 
L103:   dup 
L104:   iconst_0 
L105:   getstatic [13] 
L108:   ifnonnull L123 
L111:   ldc [14] 
L113:   invokestatic [10] 
L116:   dup 
L117:   putstatic [47] 
L120:   goto L126 
L123:   getstatic [13] 
L126:   invokevirtual [36] 
L129:   aastore 
L130:   new [63] 
L133:   dup 
L134:   aload_0 
L135:   aload_1 
L136:   invokespecial [48] 
L139:   invokespecial [49] 
L142:   putfield [55] 
L145:   aload_0 
L146:   getfield [34] 
L149:   invokevirtual [37] 
L152:   aload_0 
L153:   ldc [16] 
L155:   invokespecial [44] 
L158:   goto L202 
L161:   astore_2 
L162:   aload_0 
L163:   ldc [18] 
L165:   invokespecial [44] 
L168:   aload_0 
L169:   getfield [31] 
L172:   sipush 10000 
L175:   ldc [19] 
L177:   aload_2 
L178:   invokevirtual [38] 
L181:   pop 
L182:   aload_0 
L183:   invokevirtual [35] 
L186:   invokeinterface [64] 0 
L191:   aload_2 
L192:   ldc [20] 
L194:   iconst_0 
L195:   iconst_0 
L196:   iconst_0 
L197:   invokeinterface [65] 0 
L202:   return 
L203:   nop 
L204:   
    .end code 
.end method 

.method public final [303] : [304] 
    .attribute [296] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [34] 
L4:     ifnull L19 
L7:     aload_0 
L8:     getfield [34] 
L11:    invokevirtual [39] 
L14:    aload_0 
L15:    aconst_null 
L16:    putfield [55] 
L19:    aload_0 
L20:    getfield [33] 
L23:    ifnull L40 
L26:    aload_0 
L27:    getfield [33] 
L30:    invokeinterface [66] 0 
L35:    aload_0 
L36:    aconst_null 
L37:    putfield [54] 
L40:    aload_0 
L41:    getfield [30] 
L44:    ifnull L59 
L47:    aload_0 
L48:    getfield [30] 
L51:    invokevirtual [40] 
L54:    aload_0 
L55:    aconst_null 
L56:    putfield [51] 
L59:    aload_0 
L60:    aload_1 
L61:    invokespecial [50] 
L64:    return 
L65:    nop 
L66:    nop 
L67:    nop 
L68:    
    .end code 
.end method 

.method static synthetic [305] : [306] 
    .attribute [296] .code stack 2 locals 1 
        .catch [3] from L0 to L4 using L5 
L0:     aload_0 
L1:     invokestatic [2] 
L4:     areturn 
L5:     astore_1 
L6:     new [53] 
L9:     dup 
L10:    invokespecial [41] 
L13:    aload_1 
L14:    invokevirtual [32] 
L17:    athrow 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method static synthetic [307] : [308] 
    .attribute [296] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [31] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [309] : [310] 
    .attribute [296] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [30] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [67] [68] 
.const [3] = Class [69] 
.const [4] = Class [70] 
.const [5] = String [71] 
.const [6] = String [72] 
.const [7] = Class [73] 
.const [8] = Field [74] [75] 
.const [9] = String [76] 
.const [10] = Method [77] [78] 
.const [11] = Class [79] 
.const [12] = Class [80] 
.const [13] = Field [81] [82] 
.const [14] = String [83] 
.const [15] = Class [84] 
.const [16] = String [85] 
.const [17] = Class [86] 
.const [18] = String [87] 
.const [19] = String [88] 
.const [20] = String [89] 
.const [21] = Class [90] 
.const [22] = Class [91] 
.const [23] = Class [92] 
.const [24] = Class [93] 
.const [25] = Class [94] 
.const [26] = Class [95] 
.const [27] = Class [96] 
.const [28] = Class [97] 
.const [29] = Class [98] 
.const [30] = Field [99] [100] 
.const [31] = Field [101] [102] 
.const [32] = Method [103] [104] 
.const [33] = Field [105] [106] 
.const [34] = Field [107] [108] 
.const [35] = Method [109] [110] 
.const [36] = Method [111] [112] 
.const [37] = Method [113] [114] 
.const [38] = Method [115] [116] 
.const [39] = Method [117] [118] 
.const [40] = Method [119] [120] 
.const [41] = Method [121] [122] 
.const [42] = Method [123] [124] 
.const [43] = Method [125] [126] 
.const [44] = Method [127] [128] 
.const [45] = Method [129] [130] 
.const [46] = Field [131] [132] 
.const [47] = Field [133] [134] 
.const [48] = Method [135] [136] 
.const [49] = Method [137] [138] 
.const [50] = Method [139] [140] 
.const [51] = Field [141] [142] 
.const [52] = Field [143] [144] 
.const [53] = Class [145] 
.const [54] = Field [146] [147] 
.const [55] = Field [148] [149] 
.const [56] = InterfaceMethod [150] [151] 
.const [57] = InterfaceMethod [152] [153] 
.const [58] = InterfaceMethod [154] [155] 
.const [59] = InterfaceMethod [156] [157] 
.const [60] = Class [158] 
.const [61] = InterfaceMethod [159] [160] 
.const [62] = Class [161] 
.const [63] = Class [162] 
.const [64] = InterfaceMethod [163] [164] 
.const [65] = InterfaceMethod [165] [166] 
.const [66] = InterfaceMethod [167] [168] 
.const [67] = Class [169] 
.const [68] = NameAndType [170] [171] 
.const [69] = Utf8 java/lang/ClassNotFoundException 
.const [70] = Utf8 java/lang/NoClassDefFoundError 
.const [71] = Utf8 'Fw.Agent.Activator' 
.const [72] = Utf8 'start Agent service' 
.const [73] = Utf8 de/audi/atip/agent/AgentService 
.const [74] = Class [172] 
.const [75] = NameAndType [173] [174] 
.const [76] = Utf8 'de.esolutions.fw.util.commons.error.DumpInfoProvider' 
.const [77] = Class [175] 
.const [78] = NameAndType [176] [177] 
.const [79] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [80] = Utf8 java/lang/String 
.const [81] = Class [178] 
.const [82] = NameAndType [179] [180] 
.const [83] = Utf8 'de.audi.atip.agent.IASIProvider' 
.const [84] = Utf8 de/audi/atip/agent/AgentActivator$1 
.const [85] = Utf8 'started Agent service tracker' 
.const [86] = Utf8 java/lang/Throwable 
.const [87] = Utf8 'started Agent service tracker failed!' 
.const [88] = Utf8 'starting AgentService failed:' 
.const [89] = Utf8 'starting AgentService failed!' 
.const [90] = Utf8 de/audi/atip/agent/AgentActivator 
.const [91] = Utf8 de/audi/atip/activator/AbstractActivator 
.const [92] = Utf8 java/lang/Class 
.const [93] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [94] = Utf8 de/audi/atip/start/IStartupManager 
.const [95] = Utf8 org/osgi/framework/BundleContext 
.const [96] = Utf8 de/audi/atip/log/LogChannel 
.const [97] = Utf8 de/audi/atip/error/IErrorManager 
.const [98] = Utf8 org/osgi/framework/ServiceRegistration 
.const [99] = Class [181] 
.const [100] = NameAndType [182] [183] 
.const [101] = Class [184] 
.const [102] = NameAndType [185] [186] 
.const [103] = Class [187] 
.const [104] = NameAndType [188] [189] 
.const [105] = Class [190] 
.const [106] = NameAndType [191] [192] 
.const [107] = Class [193] 
.const [108] = NameAndType [194] [195] 
.const [109] = Class [196] 
.const [110] = NameAndType [197] [198] 
.const [111] = Class [199] 
.const [112] = NameAndType [200] [201] 
.const [113] = Class [202] 
.const [114] = NameAndType [203] [204] 
.const [115] = Class [205] 
.const [116] = NameAndType [206] [207] 
.const [117] = Class [208] 
.const [118] = NameAndType [209] [210] 
.const [119] = Class [211] 
.const [120] = NameAndType [212] [213] 
.const [121] = Class [214] 
.const [122] = NameAndType [215] [216] 
.const [123] = Class [217] 
.const [124] = NameAndType [218] [219] 
.const [125] = Class [220] 
.const [126] = NameAndType [221] [222] 
.const [127] = Class [223] 
.const [128] = NameAndType [224] [225] 
.const [129] = Class [226] 
.const [130] = NameAndType [227] [228] 
.const [131] = Class [229] 
.const [132] = NameAndType [230] [231] 
.const [133] = Class [232] 
.const [134] = NameAndType [233] [234] 
.const [135] = Class [235] 
.const [136] = NameAndType [236] [237] 
.const [137] = Class [238] 
.const [138] = NameAndType [239] [240] 
.const [139] = Class [241] 
.const [140] = NameAndType [242] [243] 
.const [141] = Class [244] 
.const [142] = NameAndType [245] [246] 
.const [143] = Class [247] 
.const [144] = NameAndType [248] [249] 
.const [145] = Utf8 java/lang/NoClassDefFoundError 
.const [146] = Class [250] 
.const [147] = NameAndType [251] [252] 
.const [148] = Class [253] 
.const [149] = NameAndType [254] [255] 
.const [150] = Class [256] 
.const [151] = NameAndType [257] [258] 
.const [152] = Class [259] 
.const [153] = NameAndType [260] [261] 
.const [154] = Class [262] 
.const [155] = NameAndType [263] [264] 
.const [156] = Class [265] 
.const [157] = NameAndType [266] [267] 
.const [158] = Utf8 de/audi/atip/agent/AgentService 
.const [159] = Class [268] 
.const [160] = NameAndType [269] [270] 
.const [161] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [162] = Utf8 de/audi/atip/agent/AgentActivator$1 
.const [163] = Class [271] 
.const [164] = NameAndType [272] [273] 
.const [165] = Class [274] 
.const [166] = NameAndType [275] [276] 
.const [167] = Class [277] 
.const [168] = NameAndType [278] [279] 
.const [169] = Utf8 java/lang/Class 
.const [170] = Utf8 forName 
.const [171] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [172] = Utf8 de/audi/atip/agent/AgentActivator 
.const [173] = Utf8 class$de$esolutions$fw$util$commons$error$DumpInfoProvider 
.const [174] = Utf8 Ljava/lang/Class; 
.const [175] = Utf8 de/audi/atip/agent/AgentActivator 
.const [176] = Utf8 class$ 
.const [177] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [178] = Utf8 de/audi/atip/agent/AgentActivator 
.const [179] = Utf8 class$de$audi$atip$agent$IASIProvider 
.const [180] = Utf8 Ljava/lang/Class; 
.const [181] = Utf8 de/audi/atip/agent/AgentActivator 
.const [182] = Utf8 agentService 
.const [183] = Utf8 Lde/audi/atip/agent/AgentService; 
.const [184] = Utf8 de/audi/atip/agent/AgentActivator 
.const [185] = Utf8 log 
.const [186] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [187] = Utf8 java/lang/NoClassDefFoundError 
.const [188] = Utf8 initCause 
.const [189] = Utf8 (Ljava/lang/Throwable;)Ljava/lang/Throwable; 
.const [190] = Utf8 de/audi/atip/agent/AgentActivator 
.const [191] = Utf8 sregAgent 
.const [192] = Utf8 Lorg/osgi/framework/ServiceRegistration; 
.const [193] = Utf8 de/audi/atip/agent/AgentActivator 
.const [194] = Utf8 agentTracker 
.const [195] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [196] = Utf8 de/audi/atip/agent/AgentActivator 
.const [197] = Utf8 getFramework 
.const [198] = Utf8 ()Lde/audi/atip/base/IFrameworkAccess; 
.const [199] = Utf8 java/lang/Class 
.const [200] = Utf8 getName 
.const [201] = Utf8 ()Ljava/lang/String; 
.const [202] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [203] = Utf8 'open' 
.const [204] = Utf8 ()V 
.const [205] = Utf8 de/audi/atip/log/LogChannel 
.const [206] = Utf8 log 
.const [207] = Utf8 (ILjava/lang/String;Ljava/lang/Throwable;)Z 
.const [208] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [209] = Utf8 close 
.const [210] = Utf8 ()V 
.const [211] = Utf8 de/audi/atip/agent/AgentService 
.const [212] = Utf8 cleanup 
.const [213] = Utf8 ()V 
.const [214] = Utf8 java/lang/NoClassDefFoundError 
.const [215] = Utf8 <init> 
.const [216] = Utf8 ()V 
.const [217] = Utf8 de/audi/atip/activator/AbstractActivator 
.const [218] = Utf8 <init> 
.const [219] = Utf8 ()V 
.const [220] = Utf8 de/audi/atip/activator/AbstractActivator 
.const [221] = Utf8 start 
.const [222] = Utf8 (Lorg/osgi/framework/BundleContext;)V 
.const [223] = Utf8 de/audi/atip/agent/AgentActivator 
.const [224] = Utf8 logStartupEvent 
.const [225] = Utf8 (Ljava/lang/String;)V 
.const [226] = Utf8 de/audi/atip/agent/AgentService 
.const [227] = Utf8 <init> 
.const [228] = Utf8 (Lde/audi/atip/base/IFrameworkAccess;)V 
.const [229] = Utf8 de/audi/atip/agent/AgentActivator 
.const [230] = Utf8 class$de$esolutions$fw$util$commons$error$DumpInfoProvider 
.const [231] = Utf8 Ljava/lang/Class; 
.const [232] = Utf8 de/audi/atip/agent/AgentActivator 
.const [233] = Utf8 class$de$audi$atip$agent$IASIProvider 
.const [234] = Utf8 Ljava/lang/Class; 
.const [235] = Utf8 de/audi/atip/agent/AgentActivator$1 
.const [236] = Utf8 <init> 
.const [237] = Utf8 (Lde/audi/atip/agent/AgentActivator;Lorg/osgi/framework/BundleContext;)V 
.const [238] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [239] = Utf8 <init> 
.const [240] = Utf8 (Lorg/osgi/framework/BundleContext;[Ljava/lang/String;Lorg/osgi/util/tracker/ServiceTrackerCustomizer;)V 
.const [241] = Utf8 de/audi/atip/activator/AbstractActivator 
.const [242] = Utf8 stop 
.const [243] = Utf8 (Lorg/osgi/framework/BundleContext;)V 
.const [244] = Utf8 de/audi/atip/agent/AgentActivator 
.const [245] = Utf8 agentService 
.const [246] = Utf8 Lde/audi/atip/agent/AgentService; 
.const [247] = Utf8 de/audi/atip/agent/AgentActivator 
.const [248] = Utf8 log 
.const [249] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [250] = Utf8 de/audi/atip/agent/AgentActivator 
.const [251] = Utf8 sregAgent 
.const [252] = Utf8 Lorg/osgi/framework/ServiceRegistration; 
.const [253] = Utf8 de/audi/atip/agent/AgentActivator 
.const [254] = Utf8 agentTracker 
.const [255] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [256] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [257] = Utf8 getStartupMgr 
.const [258] = Utf8 ()Lde/audi/atip/start/IStartupManager; 
.const [259] = Utf8 de/audi/atip/start/IStartupManager 
.const [260] = Utf8 logStartupEvent 
.const [261] = Utf8 (Ljava/lang/String;)V 
.const [262] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [263] = Utf8 getLogChannel 
.const [264] = Utf8 (Ljava/lang/String;)Lde/audi/atip/log/LogChannel; 
.const [265] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [266] = Utf8 isSDISEnabled 
.const [267] = Utf8 ()Z 
.const [268] = Utf8 org/osgi/framework/BundleContext 
.const [269] = Utf8 registerService 
.const [270] = Utf8 (Ljava/lang/String;Ljava/lang/Object;Ljava/util/Dictionary;)Lorg/osgi/framework/ServiceRegistration; 
.const [271] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [272] = Utf8 getErrorMgr 
.const [273] = Utf8 ()Lde/audi/atip/error/IErrorManager; 
.const [274] = Utf8 de/audi/atip/error/IErrorManager 
.const [275] = Utf8 handleError 
.const [276] = Utf8 (Ljava/lang/Throwable;Ljava/lang/String;III)V 
.const [277] = Utf8 org/osgi/framework/ServiceRegistration 
.const [278] = Utf8 unregister 
.const [279] = Utf8 ()V 
.const [280] = Utf8 de/audi/atip/agent/AgentActivator 
.const [281] = Class [280] 
.const [282] = Utf8 de/audi/atip/activator/AbstractActivator 
.const [283] = Class [282] 
.const [284] = Utf8 log 
.const [285] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [286] = Utf8 agentService 
.const [287] = Utf8 Lde/audi/atip/agent/AgentService; 
.const [288] = Utf8 sregAgent 
.const [289] = Utf8 Lorg/osgi/framework/ServiceRegistration; 
.const [290] = Utf8 agentTracker 
.const [291] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [292] = Utf8 class$de$esolutions$fw$util$commons$error$DumpInfoProvider 
.const [293] = Utf8 Ljava/lang/Class; 
.const [294] = Utf8 class$de$audi$atip$agent$IASIProvider 
.const [295] = Utf8 Ljava/lang/Class; 
.const [296] = Utf8 Code 
.const [297] = Utf8 <init> 
.const [298] = Utf8 ()V 
.const [299] = Utf8 logStartupEvent 
.const [300] = Utf8 (Ljava/lang/String;)V 
.const [301] = Utf8 start 
.const [302] = Utf8 (Lorg/osgi/framework/BundleContext;)V 
.const [303] = Utf8 stop 
.const [304] = Utf8 (Lorg/osgi/framework/BundleContext;)V 
.const [305] = Utf8 class$ 
.const [306] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [307] = Utf8 access$000 
.const [308] = Utf8 (Lde/audi/atip/agent/AgentActivator;)Lde/audi/atip/log/LogChannel; 
.const [309] = Utf8 access$100 
.const [310] = Utf8 (Lde/audi/atip/agent/AgentActivator;)Lde/audi/atip/agent/AgentService; 
.end class 
