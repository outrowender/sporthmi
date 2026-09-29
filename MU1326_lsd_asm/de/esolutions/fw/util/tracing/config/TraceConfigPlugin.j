.version 50 0 
.class public super [109] 
.super [111] 
.field private static final [112] [113] 

.method public annotation [115] : [116] 
    .attribute [114] .code stack 4 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     aload_3 
L4:     invokespecial [28] 
L7:     return 
L8:     
    .end code 
.end method 

.method public [117] : [118] 
    .attribute [114] .code stack 5 locals 4 
L0:     aload_0 
L1:     invokevirtual [23] 
L4:     astore_2 
L5:     aload_2 
L6:     ifnull L68 
        .catch [8] from L9 to L38 using L39 
        .catch [12] from L9 to L38 using L53 
L9:     aload_2 
L10:    invokestatic [2] 
L13:    astore_3 
L14:    aload_3 
L15:    invokevirtual [24] 
L18:    checkcast [3] 
L21:    astore_1 
L22:    getstatic [4] 
L25:    ldc [5] 
L27:    ldc [6] 
L29:    aload_2 
L30:    aload_0 
L31:    invokevirtual [25] 
L34:    invokestatic [7] 
L37:    aload_1 
L38:    areturn 
L39:    astore_3 
L40:    getstatic [9] 
L43:    ldc [5] 
L45:    ldc [10] 
L47:    aload_2 
L48:    invokestatic [11] 
L51:    aconst_null 
L52:    areturn 
L53:    astore_3 
L54:    getstatic [9] 
L57:    ldc [5] 
L59:    ldc [13] 
L61:    aload_2 
L62:    aload_3 
L63:    invokestatic [7] 
L66:    aconst_null 
L67:    areturn 
L68:    aload_0 
L69:    invokevirtual [26] 
L72:    astore_3 
L73:    aload_3 
L74:    ifnull L119 
L77:    invokestatic [14] 
L80:    aload_3 
L81:    invokevirtual [27] 
L84:    astore_1 
L85:    aload_1 
L86:    ifnonnull L102 
L89:    getstatic [9] 
L92:    ldc [5] 
L94:    ldc [15] 
L96:    aload_3 
L97:    invokestatic [11] 
L100:   aconst_null 
L101:   areturn 
L102:   getstatic [4] 
L105:   ldc [5] 
L107:   ldc [6] 
L109:   aload_3 
L110:   aload_0 
L111:   invokevirtual [25] 
L114:   invokestatic [7] 
L117:   aload_1 
L118:   areturn 
L119:   aload_0 
L120:   invokevirtual [25] 
L123:   astore 4 
L125:   invokestatic [14] 
L128:   aload 4 
L130:   invokevirtual [27] 
L133:   astore_1 
L134:   aload_1 
L135:   ifnull L156 
L138:   getstatic [4] 
L141:   ldc [5] 
L143:   ldc [6] 
L145:   aload 4 
L147:   aload_0 
L148:   invokevirtual [25] 
L151:   invokestatic [7] 
L154:   aload_1 
L155:   areturn 
L156:   getstatic [16] 
L159:   ldc [5] 
L161:   ldc [17] 
L163:   aload_0 
L164:   invokevirtual [25] 
L167:   invokestatic [11] 
L170:   aconst_null 
L171:   areturn 
L172:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [29] [30] 
.const [3] = Class [31] 
.const [4] = Field [32] [33] 
.const [5] = String [34] 
.const [6] = String [35] 
.const [7] = Method [36] [37] 
.const [8] = Class [38] 
.const [9] = Field [39] [40] 
.const [10] = String [41] 
.const [11] = Method [42] [43] 
.const [12] = Class [44] 
.const [13] = String [45] 
.const [14] = Method [46] [47] 
.const [15] = String [48] 
.const [16] = Field [49] [50] 
.const [17] = String [51] 
.const [18] = Class [52] 
.const [19] = Class [53] 
.const [20] = Class [54] 
.const [21] = Class [55] 
.const [22] = Class [56] 
.const [23] = Method [57] [58] 
.const [24] = Method [59] [60] 
.const [25] = Method [61] [62] 
.const [26] = Method [63] [64] 
.const [27] = Method [65] [66] 
.const [28] = Method [67] [68] 
.const [29] = Class [69] 
.const [30] = NameAndType [70] [71] 
.const [31] = Utf8 de/esolutions/fw/util/tracing/plugin/ITracePlugin 
.const [32] = Class [72] 
.const [33] = NameAndType [73] [74] 
.const [34] = Utf8 ConfigPlugin 
.const [35] = Utf8 'created plugin instance of %1 for %2' 
.const [36] = Class [75] 
.const [37] = NameAndType [76] [77] 
.const [38] = Utf8 java/lang/ClassNotFoundException 
.const [39] = Class [78] 
.const [40] = NameAndType [79] [80] 
.const [41] = Utf8 'plugin class %1 NOT FOUND!' 
.const [42] = Class [81] 
.const [43] = NameAndType [82] [83] 
.const [44] = Utf8 java/lang/Exception 
.const [45] = Utf8 "can't instantiate plugin class %1: %2" 
.const [46] = Class [84] 
.const [47] = NameAndType [85] [86] 
.const [48] = Utf8 "can't create default plugin: %1" 
.const [49] = Class [87] 
.const [50] = NameAndType [88] [89] 
.const [51] = Utf8 'ignoring plugin %1: neither class nor javaClass given!' 
.const [52] = Utf8 de/esolutions/fw/util/tracing/config/TraceConfigPlugin 
.const [53] = Utf8 de/esolutions/fw/util/tracing/config/TraceConfigElement 
.const [54] = Utf8 java/lang/Class 
.const [55] = Utf8 de/esolutions/fw/util/commons/traceme/TraceMe 
.const [56] = Utf8 de/esolutions/fw/util/tracing/plugin/PluginRegistry 
.const [57] = Class [90] 
.const [58] = NameAndType [91] [92] 
.const [59] = Class [93] 
.const [60] = NameAndType [94] [95] 
.const [61] = Class [96] 
.const [62] = NameAndType [97] [98] 
.const [63] = Class [99] 
.const [64] = NameAndType [100] [101] 
.const [65] = Class [102] 
.const [66] = NameAndType [103] [104] 
.const [67] = Class [105] 
.const [68] = NameAndType [106] [107] 
.const [69] = Utf8 java/lang/Class 
.const [70] = Utf8 forName 
.const [71] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [72] = Utf8 de/esolutions/fw/util/commons/traceme/TraceMe 
.const [73] = Utf8 INFO 
.const [74] = Utf8 I 
.const [75] = Utf8 de/esolutions/fw/util/commons/traceme/TraceMe 
.const [76] = Utf8 msg 
.const [77] = Utf8 (ILjava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [78] = Utf8 de/esolutions/fw/util/commons/traceme/TraceMe 
.const [79] = Utf8 ERROR 
.const [80] = Utf8 I 
.const [81] = Utf8 de/esolutions/fw/util/commons/traceme/TraceMe 
.const [82] = Utf8 msg 
.const [83] = Utf8 (ILjava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V 
.const [84] = Utf8 de/esolutions/fw/util/tracing/plugin/PluginRegistry 
.const [85] = Utf8 getInstance 
.const [86] = Utf8 ()Lde/esolutions/fw/util/tracing/plugin/PluginRegistry; 
.const [87] = Utf8 de/esolutions/fw/util/commons/traceme/TraceMe 
.const [88] = Utf8 WARN 
.const [89] = Utf8 I 
.const [90] = Utf8 de/esolutions/fw/util/tracing/config/TraceConfigPlugin 
.const [91] = Utf8 getPluginClassName 
.const [92] = Utf8 ()Ljava/lang/String; 
.const [93] = Utf8 java/lang/Class 
.const [94] = Utf8 newInstance 
.const [95] = Utf8 ()Ljava/lang/Object; 
.const [96] = Utf8 de/esolutions/fw/util/tracing/config/TraceConfigPlugin 
.const [97] = Utf8 getName 
.const [98] = Utf8 ()Ljava/lang/String; 
.const [99] = Utf8 de/esolutions/fw/util/tracing/config/TraceConfigPlugin 
.const [100] = Utf8 getDefaultClassName 
.const [101] = Utf8 ()Ljava/lang/String; 
.const [102] = Utf8 de/esolutions/fw/util/tracing/plugin/PluginRegistry 
.const [103] = Utf8 createPlugin 
.const [104] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/tracing/plugin/ITracePlugin; 
.const [105] = Utf8 de/esolutions/fw/util/tracing/config/TraceConfigElement 
.const [106] = Utf8 <init> 
.const [107] = Utf8 (Ljava/lang/String;Lde/esolutions/fw/util/config/ConfigValue;Lde/esolutions/fw/util/tracing/config/TraceConfig;)V 
.const [108] = Utf8 de/esolutions/fw/util/tracing/config/TraceConfigPlugin 
.const [109] = Class [108] 
.const [110] = Utf8 de/esolutions/fw/util/tracing/config/TraceConfigElement 
.const [111] = Class [110] 
.const [112] = Utf8 chn 
.const [113] = Utf8 Ljava/lang/String; 
.const [114] = Utf8 Code 
.const [115] = Utf8 <init> 
.const [116] = Utf8 (Ljava/lang/String;Lde/esolutions/fw/util/config/ConfigValue;Lde/esolutions/fw/util/tracing/config/TraceConfig;)V 
.const [117] = Utf8 createInstance 
.const [118] = Utf8 ()Lde/esolutions/fw/util/tracing/plugin/ITracePlugin; 
.end class 
