.version 50 0 
.class public super [201] 
.super [203] 
.field private static final [204] [205] 
.field private final [206] [207] 

.method public [209] : [210] 
    .attribute [208] .code stack 4 locals 1 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     aload_3 
L4:     invokespecial [44] 
L7:     aload_0 
L8:     invokevirtual [35] 
L11:    ldc [2] 
L13:    invokeinterface [47] 0 
L18:    astore 4 
L20:    aload 4 
L22:    ifnull L41 
L25:    aload_0 
L26:    new [48] 
L29:    dup 
L30:    aload 4 
L32:    invokespecial [45] 
L35:    putfield [49] 
L38:    goto L46 
L41:    aload_0 
L42:    aconst_null 
L43:    putfield [49] 
L46:    return 
L47:    nop 
L48:    
    .end code 
.end method 

.method public interface [211] : [212] 
    .attribute [208] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [36] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [213] : [214] 
    .attribute [208] .code stack 5 locals 4 
L0:     aload_0 
L1:     invokevirtual [37] 
L4:     astore_2 
L5:     aload_2 
L6:     ifnull L68 
        .catch [10] from L9 to L38 using L39 
        .catch [14] from L9 to L38 using L53 
L9:     aload_2 
L10:    invokestatic [4] 
L13:    astore_3 
L14:    aload_3 
L15:    invokevirtual [38] 
L18:    checkcast [5] 
L21:    astore_1 
L22:    getstatic [6] 
L25:    ldc [7] 
L27:    ldc [8] 
L29:    aload_2 
L30:    aload_0 
L31:    invokevirtual [39] 
L34:    invokestatic [9] 
L37:    aload_1 
L38:    areturn 
L39:    astore_3 
L40:    getstatic [11] 
L43:    ldc [7] 
L45:    ldc [12] 
L47:    aload_2 
L48:    invokestatic [13] 
L51:    aconst_null 
L52:    areturn 
L53:    astore_3 
L54:    getstatic [11] 
L57:    ldc [7] 
L59:    ldc [15] 
L61:    aload_2 
L62:    aload_3 
L63:    invokestatic [9] 
L66:    aconst_null 
L67:    areturn 
L68:    aload_0 
L69:    invokevirtual [40] 
L72:    astore_3 
L73:    aload_3 
L74:    ifnull L119 
L77:    invokestatic [16] 
L80:    aload_3 
L81:    invokevirtual [41] 
L84:    astore_1 
L85:    aload_1 
L86:    ifnonnull L102 
L89:    getstatic [11] 
L92:    ldc [7] 
L94:    ldc [17] 
L96:    aload_3 
L97:    invokestatic [13] 
L100:   aconst_null 
L101:   areturn 
L102:   getstatic [6] 
L105:   ldc [7] 
L107:   ldc [8] 
L109:   aload_3 
L110:   aload_0 
L111:   invokevirtual [39] 
L114:   invokestatic [9] 
L117:   aload_1 
L118:   areturn 
L119:   aload_0 
L120:   invokevirtual [39] 
L123:   astore 4 
L125:   invokestatic [16] 
L128:   aload 4 
L130:   invokevirtual [41] 
L133:   astore_1 
L134:   aload_1 
L135:   ifnull L156 
L138:   getstatic [6] 
L141:   ldc [7] 
L143:   ldc [8] 
L145:   aload 4 
L147:   aload_0 
L148:   invokevirtual [39] 
L151:   invokestatic [9] 
L154:   aload_1 
L155:   areturn 
L156:   getstatic [11] 
L159:   ldc [7] 
L161:   ldc [18] 
L163:   aload_0 
L164:   invokevirtual [39] 
L167:   invokestatic [13] 
L170:   aconst_null 
L171:   areturn 
L172:   
    .end code 
.end method 

.method public [215] : [216] 
    .attribute [208] .code stack 3 locals 2 
L0:     aload_0 
L1:     invokevirtual [35] 
L4:     astore_2 
L5:     aload_2 
L6:     ldc [19] 
L8:     aload_1 
L9:     invokeinterface [50] 0 
L14:    astore_3 
L15:    aload_3 
L16:    ifnonnull L22 
L19:    ldc [20] 
L21:    astore_3 
L22:    aload_3 
L23:    new [51] 
L26:    dup 
L27:    invokespecial [46] 
L30:    invokestatic [22] 
L33:    astore_3 
L34:    aload_3 
L35:    areturn 
L36:    
    .end code 
.end method 

.method public [217] : [218] 
    .attribute [208] .code stack 3 locals 3 
L0:     aload_0 
L1:     invokevirtual [35] 
L4:     astore_3 
L5:     aload_3 
L6:     ldc [23] 
L8:     aload_1 
L9:     invokeinterface [50] 0 
L14:    astore 4 
L16:    aload 4 
L18:    ifnonnull L53 
L21:    aload_3 
L22:    ldc [24] 
L24:    iconst_0 
L25:    invokeinterface [52] 0 
L30:    istore 5 
L32:    iload 5 
L34:    ifeq L49 
L37:    aload_0 
L38:    invokevirtual [42] 
L41:    invokevirtual [43] 
L44:    astore 4 
L46:    goto L53 
L49:    ldc [25] 
L51:    astore 4 
L53:    aload 4 
L55:    aload_2 
L56:    invokestatic [26] 
L59:    astore 4 
L61:    aload 4 
L63:    areturn 
L64:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [53] 
.const [3] = Class [54] 
.const [4] = Method [55] [56] 
.const [5] = Class [57] 
.const [6] = Field [58] [59] 
.const [7] = String [60] 
.const [8] = String [61] 
.const [9] = Method [62] [63] 
.const [10] = Class [64] 
.const [11] = Field [65] [66] 
.const [12] = String [67] 
.const [13] = Method [68] [69] 
.const [14] = Class [70] 
.const [15] = String [71] 
.const [16] = Method [72] [73] 
.const [17] = String [74] 
.const [18] = String [75] 
.const [19] = String [76] 
.const [20] = String [77] 
.const [21] = Class [78] 
.const [22] = Method [79] [80] 
.const [23] = String [81] 
.const [24] = String [82] 
.const [25] = String [83] 
.const [26] = Method [84] [85] 
.const [27] = Class [86] 
.const [28] = Class [87] 
.const [29] = Class [88] 
.const [30] = Class [89] 
.const [31] = Class [90] 
.const [32] = Class [91] 
.const [33] = Class [92] 
.const [34] = Class [93] 
.const [35] = Method [94] [95] 
.const [36] = Field [96] [97] 
.const [37] = Method [98] [99] 
.const [38] = Method [100] [101] 
.const [39] = Method [102] [103] 
.const [40] = Method [104] [105] 
.const [41] = Method [106] [107] 
.const [42] = Method [108] [109] 
.const [43] = Method [110] [111] 
.const [44] = Method [112] [113] 
.const [45] = Method [114] [115] 
.const [46] = Method [116] [117] 
.const [47] = InterfaceMethod [118] [119] 
.const [48] = Class [120] 
.const [49] = Field [121] [122] 
.const [50] = InterfaceMethod [123] [124] 
.const [51] = Class [125] 
.const [52] = InterfaceMethod [126] [127] 
.const [53] = Utf8 levels 
.const [54] = Utf8 de/esolutions/fw/util/tracing/config/TraceConfigLevels 
.const [55] = Class [128] 
.const [56] = NameAndType [129] [130] 
.const [57] = Utf8 de/esolutions/fw/util/tracing/backend/ITraceBackend 
.const [58] = Class [131] 
.const [59] = NameAndType [132] [133] 
.const [60] = Utf8 ConfigBackend 
.const [61] = Utf8 'created backend instance of %1 for %2' 
.const [62] = Class [134] 
.const [63] = NameAndType [135] [136] 
.const [64] = Utf8 java/lang/ClassNotFoundException 
.const [65] = Class [137] 
.const [66] = NameAndType [138] [139] 
.const [67] = Utf8 'backend class %1 NOT FOUND!' 
.const [68] = Class [140] 
.const [69] = NameAndType [141] [142] 
.const [70] = Utf8 java/lang/Exception 
.const [71] = Utf8 "can't instantiate backend class %1: %2" 
.const [72] = Class [143] 
.const [73] = NameAndType [144] [145] 
.const [74] = Utf8 "can't create default backend: %1" 
.const [75] = Utf8 'ignoring backend %1: neither class nor javaClass given!' 
.const [76] = Utf8 outputDirectory 
.const [77] = Utf8 'esotrace_#yyyyMMdd_HHmmss#' 
.const [78] = Utf8 java/util/Date 
.const [79] = Class [146] 
.const [80] = NameAndType [147] [148] 
.const [81] = Utf8 fileName 
.const [82] = Utf8 useClientName 
.const [83] = Utf8 log 
.const [84] = Class [149] 
.const [85] = NameAndType [150] [151] 
.const [86] = Utf8 de/esolutions/fw/util/tracing/config/TraceConfigBackend 
.const [87] = Utf8 de/esolutions/fw/util/tracing/config/TraceConfigElement 
.const [88] = Utf8 de/esolutions/fw/util/config/query/IConfigQuery 
.const [89] = Utf8 java/lang/Class 
.const [90] = Utf8 de/esolutions/fw/util/commons/traceme/TraceMe 
.const [91] = Utf8 de/esolutions/fw/util/tracing/backend/BackendRegistry 
.const [92] = Utf8 de/esolutions/fw/util/commons/StringUtils 
.const [93] = Utf8 de/esolutions/fw/util/tracing/config/TraceConfig 
.const [94] = Class [152] 
.const [95] = NameAndType [153] [154] 
.const [96] = Class [155] 
.const [97] = NameAndType [156] [157] 
.const [98] = Class [158] 
.const [99] = NameAndType [159] [160] 
.const [100] = Class [161] 
.const [101] = NameAndType [162] [163] 
.const [102] = Class [164] 
.const [103] = NameAndType [165] [166] 
.const [104] = Class [167] 
.const [105] = NameAndType [168] [169] 
.const [106] = Class [170] 
.const [107] = NameAndType [171] [172] 
.const [108] = Class [173] 
.const [109] = NameAndType [174] [175] 
.const [110] = Class [176] 
.const [111] = NameAndType [177] [178] 
.const [112] = Class [179] 
.const [113] = NameAndType [180] [181] 
.const [114] = Class [182] 
.const [115] = NameAndType [183] [184] 
.const [116] = Class [185] 
.const [117] = NameAndType [186] [187] 
.const [118] = Class [188] 
.const [119] = NameAndType [189] [190] 
.const [120] = Utf8 de/esolutions/fw/util/tracing/config/TraceConfigLevels 
.const [121] = Class [191] 
.const [122] = NameAndType [192] [193] 
.const [123] = Class [194] 
.const [124] = NameAndType [195] [196] 
.const [125] = Utf8 java/util/Date 
.const [126] = Class [197] 
.const [127] = NameAndType [198] [199] 
.const [128] = Utf8 java/lang/Class 
.const [129] = Utf8 forName 
.const [130] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [131] = Utf8 de/esolutions/fw/util/commons/traceme/TraceMe 
.const [132] = Utf8 INFO 
.const [133] = Utf8 I 
.const [134] = Utf8 de/esolutions/fw/util/commons/traceme/TraceMe 
.const [135] = Utf8 msg 
.const [136] = Utf8 (ILjava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [137] = Utf8 de/esolutions/fw/util/commons/traceme/TraceMe 
.const [138] = Utf8 ERROR 
.const [139] = Utf8 I 
.const [140] = Utf8 de/esolutions/fw/util/commons/traceme/TraceMe 
.const [141] = Utf8 msg 
.const [142] = Utf8 (ILjava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V 
.const [143] = Utf8 de/esolutions/fw/util/tracing/backend/BackendRegistry 
.const [144] = Utf8 getInstance 
.const [145] = Utf8 ()Lde/esolutions/fw/util/tracing/backend/BackendRegistry; 
.const [146] = Utf8 de/esolutions/fw/util/commons/StringUtils 
.const [147] = Utf8 expandDateString 
.const [148] = Utf8 (Ljava/lang/String;Ljava/util/Date;)Ljava/lang/String; 
.const [149] = Utf8 de/esolutions/fw/util/commons/StringUtils 
.const [150] = Utf8 addSuffix 
.const [151] = Utf8 (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; 
.const [152] = Utf8 de/esolutions/fw/util/tracing/config/TraceConfigBackend 
.const [153] = Utf8 getQuery 
.const [154] = Utf8 ()Lde/esolutions/fw/util/config/query/IConfigQuery; 
.const [155] = Utf8 de/esolutions/fw/util/tracing/config/TraceConfigBackend 
.const [156] = Utf8 levels 
.const [157] = Utf8 Lde/esolutions/fw/util/tracing/config/TraceConfigLevels; 
.const [158] = Utf8 de/esolutions/fw/util/tracing/config/TraceConfigBackend 
.const [159] = Utf8 getPluginClassName 
.const [160] = Utf8 ()Ljava/lang/String; 
.const [161] = Utf8 java/lang/Class 
.const [162] = Utf8 newInstance 
.const [163] = Utf8 ()Ljava/lang/Object; 
.const [164] = Utf8 de/esolutions/fw/util/tracing/config/TraceConfigBackend 
.const [165] = Utf8 getName 
.const [166] = Utf8 ()Ljava/lang/String; 
.const [167] = Utf8 de/esolutions/fw/util/tracing/config/TraceConfigBackend 
.const [168] = Utf8 getDefaultClassName 
.const [169] = Utf8 ()Ljava/lang/String; 
.const [170] = Utf8 de/esolutions/fw/util/tracing/backend/BackendRegistry 
.const [171] = Utf8 createBackend 
.const [172] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/tracing/backend/ITraceBackend; 
.const [173] = Utf8 de/esolutions/fw/util/tracing/config/TraceConfigBackend 
.const [174] = Utf8 getTraceConfig 
.const [175] = Utf8 ()Lde/esolutions/fw/util/tracing/config/TraceConfig; 
.const [176] = Utf8 de/esolutions/fw/util/tracing/config/TraceConfig 
.const [177] = Utf8 getId 
.const [178] = Utf8 ()Ljava/lang/String; 
.const [179] = Utf8 de/esolutions/fw/util/tracing/config/TraceConfigElement 
.const [180] = Utf8 <init> 
.const [181] = Utf8 (Ljava/lang/String;Lde/esolutions/fw/util/config/ConfigValue;Lde/esolutions/fw/util/tracing/config/TraceConfig;)V 
.const [182] = Utf8 de/esolutions/fw/util/tracing/config/TraceConfigLevels 
.const [183] = Utf8 <init> 
.const [184] = Utf8 (Lde/esolutions/fw/util/config/ConfigValue;)V 
.const [185] = Utf8 java/util/Date 
.const [186] = Utf8 <init> 
.const [187] = Utf8 ()V 
.const [188] = Utf8 de/esolutions/fw/util/config/query/IConfigQuery 
.const [189] = Utf8 getDictionary 
.const [190] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/config/ConfigValue; 
.const [191] = Utf8 de/esolutions/fw/util/tracing/config/TraceConfigBackend 
.const [192] = Utf8 levels 
.const [193] = Utf8 Lde/esolutions/fw/util/tracing/config/TraceConfigLevels; 
.const [194] = Utf8 de/esolutions/fw/util/config/query/IConfigQuery 
.const [195] = Utf8 getStringValue 
.const [196] = Utf8 (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; 
.const [197] = Utf8 de/esolutions/fw/util/config/query/IConfigQuery 
.const [198] = Utf8 getBooleanValue 
.const [199] = Utf8 (Ljava/lang/String;Z)Z 
.const [200] = Utf8 de/esolutions/fw/util/tracing/config/TraceConfigBackend 
.const [201] = Class [200] 
.const [202] = Utf8 de/esolutions/fw/util/tracing/config/TraceConfigElement 
.const [203] = Class [202] 
.const [204] = Utf8 chn 
.const [205] = Utf8 Ljava/lang/String; 
.const [206] = Utf8 levels 
.const [207] = Utf8 Lde/esolutions/fw/util/tracing/config/TraceConfigLevels; 
.const [208] = Utf8 Code 
.const [209] = Utf8 <init> 
.const [210] = Utf8 (Ljava/lang/String;Lde/esolutions/fw/util/config/ConfigValue;Lde/esolutions/fw/util/tracing/config/TraceConfig;)V 
.const [211] = Utf8 getLevels 
.const [212] = Utf8 ()Lde/esolutions/fw/util/tracing/config/TraceConfigLevels; 
.const [213] = Utf8 createInstance 
.const [214] = Utf8 ()Lde/esolutions/fw/util/tracing/backend/ITraceBackend; 
.const [215] = Utf8 getOutputDirectory 
.const [216] = Utf8 (Ljava/lang/String;)Ljava/lang/String; 
.const [217] = Utf8 getFileName 
.const [218] = Utf8 (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; 
.end class 
