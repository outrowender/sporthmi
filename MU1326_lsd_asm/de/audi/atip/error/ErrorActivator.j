.version 50 0 
.class public super [265] 
.super [267] 
.implements [269] 
.field private [270] [271] 
.field private [272] [273] 
.field private [274] [275] 
.field static synthetic [276] [277] 
.field static synthetic [278] [279] 
.field static synthetic [280] [281] 

.method public [283] : [284] 
    .attribute [282] .code stack 2 locals 0 
L0:     aload_0 
L1:     ldc [5] 
L3:     invokespecial [40] 
L6:     aload_0 
L7:     aconst_null 
L8:     putfield [51] 
L11:    return 
L12:    
    .end code 
.end method 

.method public interface [285] : [286] 
    .attribute [282] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [27] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method protected [287] : [288] 
    .attribute [282] .code stack 4 locals 0 
L0:     aload_0 
L1:     new [53] 
L4:     dup 
L5:     aload_0 
L6:     getfield [28] 
L9:     invokespecial [41] 
L12:    putfield [52] 
L15:    aload_0 
L16:    invokespecial [42] 
L19:    aload_0 
L20:    new [54] 
L23:    dup 
L24:    aload_0 
L25:    getfield [28] 
L28:    invokespecial [43] 
L31:    putfield [51] 
L34:    aload_0 
L35:    getfield [26] 
L38:    invokevirtual [29] 
L41:    return 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 

.method public [289] : [290] 
    .attribute [282] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [26] 
L4:     ifnull L19 
L7:     aload_0 
L8:     getfield [26] 
L11:    invokevirtual [30] 
L14:    aload_0 
L15:    aconst_null 
L16:    putfield [51] 
L19:    aload_0 
L20:    getfield [31] 
L23:    ifnull L38 
L26:    aload_0 
L27:    getfield [31] 
L30:    invokevirtual [32] 
L33:    aload_0 
L34:    aconst_null 
L35:    putfield [55] 
L38:    aload_0 
L39:    aconst_null 
L40:    putfield [52] 
L43:    aload_0 
L44:    aload_1 
L45:    invokespecial [44] 
L48:    return 
L49:    nop 
L50:    nop 
L51:    nop 
L52:    
    .end code 
.end method 

.method private [291] : [292] 
    .attribute [282] .code stack 9 locals 0 
L0:     aload_0 
L1:     new [56] 
L4:     dup 
L5:     aload_0 
L6:     invokevirtual [33] 
L9:     iconst_3 
L10:    anewarray [9] 
L13:    dup 
L14:    iconst_0 
L15:    getstatic [10] 
L18:    ifnonnull L33 
L21:    ldc [11] 
L23:    invokestatic [12] 
L26:    dup 
L27:    putstatic [45] 
L30:    goto L36 
L33:    getstatic [10] 
L36:    invokevirtual [34] 
L39:    aastore 
L40:    dup 
L41:    iconst_1 
L42:    getstatic [13] 
L45:    ifnonnull L60 
L48:    ldc [14] 
L50:    invokestatic [12] 
L53:    dup 
L54:    putstatic [46] 
L57:    goto L63 
L60:    getstatic [13] 
L63:    invokevirtual [34] 
L66:    aastore 
L67:    dup 
L68:    iconst_2 
L69:    getstatic [15] 
L72:    ifnonnull L87 
L75:    ldc [16] 
L77:    invokestatic [12] 
L80:    dup 
L81:    putstatic [47] 
L84:    goto L90 
L87:    getstatic [15] 
L90:    invokevirtual [34] 
L93:    aastore 
L94:    aload_0 
L95:    invokespecial [48] 
L98:    putfield [55] 
L101:   aload_0 
L102:   getfield [31] 
L105:   invokevirtual [35] 
L108:   return 
L109:   nop 
L110:   nop 
L111:   nop 
L112:   
    .end code 
.end method 

.method public [293] : [294] 
    .attribute [282] .code stack 4 locals 1 
L0:     aload_0 
L1:     invokevirtual [33] 
L4:     aload_1 
L5:     invokeinterface [57] 0 
L10:    astore_2 
L11:    aload_2 
L12:    instanceof [17] 
L15:    ifeq L32 
L18:    aload_0 
L19:    getfield [27] 
L22:    aload_2 
L23:    checkcast [17] 
L26:    invokevirtual [36] 
L29:    goto L96 
L32:    aload_2 
L33:    instanceof [18] 
L36:    ifeq L62 
L39:    aload_2 
L40:    checkcast [18] 
L43:    new [58] 
L46:    dup 
L47:    aload_0 
L48:    getfield [28] 
L51:    invokespecial [49] 
L54:    invokeinterface [59] 0 
L59:    goto L96 
L62:    aload_2 
L63:    instanceof [20] 
L66:    ifeq L83 
L69:    aload_0 
L70:    getfield [27] 
L73:    aload_2 
L74:    checkcast [20] 
L77:    invokevirtual [37] 
L80:    goto L96 
L83:    aload_0 
L84:    invokevirtual [33] 
L87:    aload_1 
L88:    invokeinterface [60] 0 
L93:    pop 
L94:    aconst_null 
L95:    astore_2 
L96:    aload_2 
L97:    areturn 
L98:    nop 
L99:    nop 
L100:   
    .end code 
.end method 

.method public enum [295] : [296] 
    .attribute [282] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [297] : [298] 
    .attribute [282] .code stack 2 locals 0 
L0:     aload_2 
L1:     instanceof [17] 
L4:     ifeq L21 
L7:     aload_0 
L8:     getfield [27] 
L11:    aload_2 
L12:    checkcast [17] 
L15:    invokevirtual [38] 
L18:    goto L36 
L21:    aload_2 
L22:    instanceof [20] 
L25:    ifeq L36 
L28:    aload_0 
L29:    getfield [27] 
L32:    aconst_null 
L33:    invokevirtual [37] 
L36:    aload_1 
L37:    ifnull L51 
L40:    aload_0 
L41:    invokevirtual [33] 
L44:    aload_1 
L45:    invokeinterface [60] 0 
L50:    pop 
L51:    return 
L52:    
    .end code 
.end method 

.method static synthetic [299] : [300] 
    .attribute [282] .code stack 2 locals 1 
        .catch [3] from L0 to L4 using L5 
L0:     aload_0 
L1:     invokestatic [2] 
L4:     areturn 
L5:     astore_1 
L6:     new [50] 
L9:     dup 
L10:    invokespecial [39] 
L13:    aload_1 
L14:    invokevirtual [25] 
L17:    athrow 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [61] [62] 
.const [3] = Class [63] 
.const [4] = Class [64] 
.const [5] = String [65] 
.const [6] = Class [66] 
.const [7] = Class [67] 
.const [8] = Class [68] 
.const [9] = Class [69] 
.const [10] = Field [70] [71] 
.const [11] = String [72] 
.const [12] = Method [73] [74] 
.const [13] = Field [75] [76] 
.const [14] = String [77] 
.const [15] = Field [78] [79] 
.const [16] = String [80] 
.const [17] = Class [81] 
.const [18] = Class [82] 
.const [19] = Class [83] 
.const [20] = Class [84] 
.const [21] = Class [85] 
.const [22] = Class [86] 
.const [23] = Class [87] 
.const [24] = Class [88] 
.const [25] = Method [89] [90] 
.const [26] = Field [91] [92] 
.const [27] = Field [93] [94] 
.const [28] = Field [95] [96] 
.const [29] = Method [97] [98] 
.const [30] = Method [99] [100] 
.const [31] = Field [101] [102] 
.const [32] = Method [103] [104] 
.const [33] = Method [105] [106] 
.const [34] = Method [107] [108] 
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
.const [45] = Field [129] [130] 
.const [46] = Field [131] [132] 
.const [47] = Field [133] [134] 
.const [48] = Method [135] [136] 
.const [49] = Method [137] [138] 
.const [50] = Class [139] 
.const [51] = Field [140] [141] 
.const [52] = Field [142] [143] 
.const [53] = Class [144] 
.const [54] = Class [145] 
.const [55] = Field [146] [147] 
.const [56] = Class [148] 
.const [57] = InterfaceMethod [149] [150] 
.const [58] = Class [151] 
.const [59] = InterfaceMethod [152] [153] 
.const [60] = InterfaceMethod [154] [155] 
.const [61] = Class [156] 
.const [62] = NameAndType [157] [158] 
.const [63] = Utf8 java/lang/ClassNotFoundException 
.const [64] = Utf8 java/lang/NoClassDefFoundError 
.const [65] = Utf8 FwError 
.const [66] = Utf8 de/audi/atip/error/ErrorManager 
.const [67] = Utf8 de/audi/atip/error/ErrorDumpTcpTrigger 
.const [68] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [69] = Utf8 java/lang/String 
.const [70] = Class [159] 
.const [71] = NameAndType [160] [161] 
.const [72] = Utf8 'de.esolutions.fw.util.commons.error.DumpInfoProvider' 
.const [73] = Class [162] 
.const [74] = NameAndType [163] [164] 
.const [75] = Class [165] 
.const [76] = NameAndType [166] [167] 
.const [77] = Utf8 'de.audi.atip.diag.sw.SwDiagnosisManager' 
.const [78] = Class [168] 
.const [79] = NameAndType [169] [170] 
.const [80] = Utf8 'de.audi.atip.log.LogSink' 
.const [81] = Utf8 de/esolutions/fw/util/commons/error/DumpInfoProvider 
.const [82] = Utf8 de/audi/atip/diag/sw/SwDiagnosisManager 
.const [83] = Utf8 de/mib/swdiagnosis/ErrorManagerDiag 
.const [84] = Utf8 de/audi/atip/log/SPISink 
.const [85] = Utf8 de/audi/atip/error/ErrorActivator 
.const [86] = Utf8 de/audi/atip/activator/AbstractFrameworkActivator 
.const [87] = Utf8 java/lang/Class 
.const [88] = Utf8 org/osgi/framework/BundleContext 
.const [89] = Class [171] 
.const [90] = NameAndType [172] [173] 
.const [91] = Class [174] 
.const [92] = NameAndType [175] [176] 
.const [93] = Class [177] 
.const [94] = NameAndType [178] [179] 
.const [95] = Class [180] 
.const [96] = NameAndType [181] [182] 
.const [97] = Class [183] 
.const [98] = NameAndType [184] [185] 
.const [99] = Class [186] 
.const [100] = NameAndType [187] [188] 
.const [101] = Class [189] 
.const [102] = NameAndType [190] [191] 
.const [103] = Class [192] 
.const [104] = NameAndType [193] [194] 
.const [105] = Class [195] 
.const [106] = NameAndType [196] [197] 
.const [107] = Class [198] 
.const [108] = NameAndType [199] [200] 
.const [109] = Class [201] 
.const [110] = NameAndType [202] [203] 
.const [111] = Class [204] 
.const [112] = NameAndType [205] [206] 
.const [113] = Class [207] 
.const [114] = NameAndType [208] [209] 
.const [115] = Class [210] 
.const [116] = NameAndType [211] [212] 
.const [117] = Class [213] 
.const [118] = NameAndType [214] [215] 
.const [119] = Class [216] 
.const [120] = NameAndType [217] [218] 
.const [121] = Class [219] 
.const [122] = NameAndType [220] [221] 
.const [123] = Class [222] 
.const [124] = NameAndType [223] [224] 
.const [125] = Class [225] 
.const [126] = NameAndType [226] [227] 
.const [127] = Class [228] 
.const [128] = NameAndType [229] [230] 
.const [129] = Class [231] 
.const [130] = NameAndType [232] [233] 
.const [131] = Class [234] 
.const [132] = NameAndType [235] [236] 
.const [133] = Class [237] 
.const [134] = NameAndType [238] [239] 
.const [135] = Class [240] 
.const [136] = NameAndType [241] [242] 
.const [137] = Class [243] 
.const [138] = NameAndType [244] [245] 
.const [139] = Utf8 java/lang/NoClassDefFoundError 
.const [140] = Class [246] 
.const [141] = NameAndType [247] [248] 
.const [142] = Class [249] 
.const [143] = NameAndType [250] [251] 
.const [144] = Utf8 de/audi/atip/error/ErrorManager 
.const [145] = Utf8 de/audi/atip/error/ErrorDumpTcpTrigger 
.const [146] = Class [252] 
.const [147] = NameAndType [253] [254] 
.const [148] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [149] = Class [255] 
.const [150] = NameAndType [256] [257] 
.const [151] = Utf8 de/mib/swdiagnosis/ErrorManagerDiag 
.const [152] = Class [258] 
.const [153] = NameAndType [259] [260] 
.const [154] = Class [261] 
.const [155] = NameAndType [262] [263] 
.const [156] = Utf8 java/lang/Class 
.const [157] = Utf8 forName 
.const [158] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [159] = Utf8 de/audi/atip/error/ErrorActivator 
.const [160] = Utf8 class$de$esolutions$fw$util$commons$error$DumpInfoProvider 
.const [161] = Utf8 Ljava/lang/Class; 
.const [162] = Utf8 de/audi/atip/error/ErrorActivator 
.const [163] = Utf8 class$ 
.const [164] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [165] = Utf8 de/audi/atip/error/ErrorActivator 
.const [166] = Utf8 class$de$audi$atip$diag$sw$SwDiagnosisManager 
.const [167] = Utf8 Ljava/lang/Class; 
.const [168] = Utf8 de/audi/atip/error/ErrorActivator 
.const [169] = Utf8 class$de$audi$atip$log$LogSink 
.const [170] = Utf8 Ljava/lang/Class; 
.const [171] = Utf8 java/lang/NoClassDefFoundError 
.const [172] = Utf8 initCause 
.const [173] = Utf8 (Ljava/lang/Throwable;)Ljava/lang/Throwable; 
.const [174] = Utf8 de/audi/atip/error/ErrorActivator 
.const [175] = Utf8 dumpTrigger 
.const [176] = Utf8 Lde/audi/atip/error/ErrorDumpTcpTrigger; 
.const [177] = Utf8 de/audi/atip/error/ErrorActivator 
.const [178] = Utf8 errorManager 
.const [179] = Utf8 Lde/audi/atip/error/ErrorManager; 
.const [180] = Utf8 de/audi/atip/error/ErrorActivator 
.const [181] = Utf8 framework 
.const [182] = Utf8 Lde/audi/atip/base/IFrameworkAccess; 
.const [183] = Utf8 de/audi/atip/error/ErrorDumpTcpTrigger 
.const [184] = Utf8 start 
.const [185] = Utf8 ()V 
.const [186] = Utf8 de/audi/atip/error/ErrorDumpTcpTrigger 
.const [187] = Utf8 stop 
.const [188] = Utf8 ()V 
.const [189] = Utf8 de/audi/atip/error/ErrorActivator 
.const [190] = Utf8 dumpInfoProviderTracker 
.const [191] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [192] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [193] = Utf8 close 
.const [194] = Utf8 ()V 
.const [195] = Utf8 de/audi/atip/error/ErrorActivator 
.const [196] = Utf8 getBundleContext 
.const [197] = Utf8 ()Lorg/osgi/framework/BundleContext; 
.const [198] = Utf8 java/lang/Class 
.const [199] = Utf8 getName 
.const [200] = Utf8 ()Ljava/lang/String; 
.const [201] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [202] = Utf8 'open' 
.const [203] = Utf8 ()V 
.const [204] = Utf8 de/audi/atip/error/ErrorManager 
.const [205] = Utf8 registerDumpInfoProvider 
.const [206] = Utf8 (Lde/esolutions/fw/util/commons/error/DumpInfoProvider;)V 
.const [207] = Utf8 de/audi/atip/error/ErrorManager 
.const [208] = Utf8 setSPISink 
.const [209] = Utf8 (Lde/audi/atip/log/SPISink;)V 
.const [210] = Utf8 de/audi/atip/error/ErrorManager 
.const [211] = Utf8 unregisterDumpInfoProvider 
.const [212] = Utf8 (Lde/esolutions/fw/util/commons/error/DumpInfoProvider;)V 
.const [213] = Utf8 java/lang/NoClassDefFoundError 
.const [214] = Utf8 <init> 
.const [215] = Utf8 ()V 
.const [216] = Utf8 de/audi/atip/activator/AbstractFrameworkActivator 
.const [217] = Utf8 <init> 
.const [218] = Utf8 (Ljava/lang/String;)V 
.const [219] = Utf8 de/audi/atip/error/ErrorManager 
.const [220] = Utf8 <init> 
.const [221] = Utf8 (Lde/audi/atip/base/IFrameworkAccess;)V 
.const [222] = Utf8 de/audi/atip/error/ErrorActivator 
.const [223] = Utf8 initTracker 
.const [224] = Utf8 ()V 
.const [225] = Utf8 de/audi/atip/error/ErrorDumpTcpTrigger 
.const [226] = Utf8 <init> 
.const [227] = Utf8 (Lde/audi/atip/base/IFrameworkAccess;)V 
.const [228] = Utf8 de/audi/atip/activator/AbstractFrameworkActivator 
.const [229] = Utf8 stop 
.const [230] = Utf8 (Lorg/osgi/framework/BundleContext;)V 
.const [231] = Utf8 de/audi/atip/error/ErrorActivator 
.const [232] = Utf8 class$de$esolutions$fw$util$commons$error$DumpInfoProvider 
.const [233] = Utf8 Ljava/lang/Class; 
.const [234] = Utf8 de/audi/atip/error/ErrorActivator 
.const [235] = Utf8 class$de$audi$atip$diag$sw$SwDiagnosisManager 
.const [236] = Utf8 Ljava/lang/Class; 
.const [237] = Utf8 de/audi/atip/error/ErrorActivator 
.const [238] = Utf8 class$de$audi$atip$log$LogSink 
.const [239] = Utf8 Ljava/lang/Class; 
.const [240] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [241] = Utf8 <init> 
.const [242] = Utf8 (Lorg/osgi/framework/BundleContext;[Ljava/lang/String;Lorg/osgi/util/tracker/ServiceTrackerCustomizer;)V 
.const [243] = Utf8 de/mib/swdiagnosis/ErrorManagerDiag 
.const [244] = Utf8 <init> 
.const [245] = Utf8 (Lde/audi/atip/base/IFrameworkAccess;)V 
.const [246] = Utf8 de/audi/atip/error/ErrorActivator 
.const [247] = Utf8 dumpTrigger 
.const [248] = Utf8 Lde/audi/atip/error/ErrorDumpTcpTrigger; 
.const [249] = Utf8 de/audi/atip/error/ErrorActivator 
.const [250] = Utf8 errorManager 
.const [251] = Utf8 Lde/audi/atip/error/ErrorManager; 
.const [252] = Utf8 de/audi/atip/error/ErrorActivator 
.const [253] = Utf8 dumpInfoProviderTracker 
.const [254] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [255] = Utf8 org/osgi/framework/BundleContext 
.const [256] = Utf8 getService 
.const [257] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [258] = Utf8 de/audi/atip/diag/sw/SwDiagnosisManager 
.const [259] = Utf8 addDiagGateway 
.const [260] = Utf8 (Lde/audi/atip/diag/sw/AbstractSwDiagnosis;)V 
.const [261] = Utf8 org/osgi/framework/BundleContext 
.const [262] = Utf8 ungetService 
.const [263] = Utf8 (Lorg/osgi/framework/ServiceReference;)Z 
.const [264] = Utf8 de/audi/atip/error/ErrorActivator 
.const [265] = Class [264] 
.const [266] = Utf8 de/audi/atip/activator/AbstractFrameworkActivator 
.const [267] = Class [266] 
.const [268] = Utf8 org/osgi/util/tracker/ServiceTrackerCustomizer 
.const [269] = Class [268] 
.const [270] = Utf8 errorManager 
.const [271] = Utf8 Lde/audi/atip/error/ErrorManager; 
.const [272] = Utf8 dumpInfoProviderTracker 
.const [273] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [274] = Utf8 dumpTrigger 
.const [275] = Utf8 Lde/audi/atip/error/ErrorDumpTcpTrigger; 
.const [276] = Utf8 class$de$esolutions$fw$util$commons$error$DumpInfoProvider 
.const [277] = Utf8 Ljava/lang/Class; 
.const [278] = Utf8 class$de$audi$atip$diag$sw$SwDiagnosisManager 
.const [279] = Utf8 Ljava/lang/Class; 
.const [280] = Utf8 class$de$audi$atip$log$LogSink 
.const [281] = Utf8 Ljava/lang/Class; 
.const [282] = Utf8 Code 
.const [283] = Utf8 <init> 
.const [284] = Utf8 ()V 
.const [285] = Utf8 getService 
.const [286] = Utf8 ()Lde/audi/atip/error/ErrorManager; 
.const [287] = Utf8 startInternal 
.const [288] = Utf8 (Lorg/osgi/framework/BundleContext;)V 
.const [289] = Utf8 stop 
.const [290] = Utf8 (Lorg/osgi/framework/BundleContext;)V 
.const [291] = Utf8 initTracker 
.const [292] = Utf8 ()V 
.const [293] = Utf8 addingService 
.const [294] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [295] = Utf8 modifiedService 
.const [296] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [297] = Utf8 removedService 
.const [298] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [299] = Utf8 class$ 
.const [300] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.end class 
