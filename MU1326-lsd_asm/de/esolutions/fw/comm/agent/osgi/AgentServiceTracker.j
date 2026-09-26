.version 50 0 
.class public super [209] 
.super [211] 
.implements [213] 
.field private static final [214] [215] 
.field private final [216] [217] 
.field private final [218] [219] 
.field private final [220] [221] 
.field static synthetic [222] [223] 

.method public [225] : [226] 
    .attribute [224] .code stack 6 locals 0 
L0:     aload_0 
L1:     invokespecial [37] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [43] 
L9:     aload_0 
L10:    aload_2 
L11:    putfield [44] 
L14:    aload_0 
L15:    new [45] 
L18:    dup 
L19:    aload_2 
L20:    getstatic [6] 
L23:    ifnonnull L38 
L26:    ldc [7] 
L28:    invokestatic [8] 
L31:    dup 
L32:    putstatic [38] 
L35:    goto L41 
L38:    getstatic [6] 
L41:    invokevirtual [28] 
L44:    aload_0 
L45:    invokespecial [39] 
L48:    putfield [46] 
L51:    return 
L52:    
    .end code 
.end method 

.method public [227] : [228] 
    .attribute [224] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [29] 
L4:     invokevirtual [30] 
L7:     return 
L8:     
    .end code 
.end method 

.method public [229] : [230] 
    .attribute [224] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [29] 
L4:     invokevirtual [31] 
L7:     return 
L8:     
    .end code 
.end method 

.method public [231] : [232] 
    .attribute [224] .code stack 5 locals 3 
L0:     aload_0 
L1:     getfield [27] 
L4:     aload_1 
L5:     invokeinterface [47] 0 
L10:    astore_2 
L11:    aload_2 
L12:    instanceof [9] 
L15:    ifeq L86 
L18:    aload_2 
L19:    checkcast [9] 
L22:    astore_3 
L23:    getstatic [10] 
L26:    iconst_0 
L27:    ldc [11] 
L29:    aload_3 
L30:    invokeinterface [48] 0 
L35:    invokevirtual [32] 
L38:    pop 
        .catch [12] from L39 to L47 using L50 
L39:    aload_0 
L40:    getfield [26] 
L43:    aload_3 
L44:    invokevirtual [33] 
L47:    goto L70 
L50:    astore 4 
L52:    getstatic [10] 
L55:    iconst_4 
L56:    ldc [13] 
L58:    aload_3 
L59:    invokeinterface [48] 0 
L64:    aload 4 
L66:    invokevirtual [34] 
L69:    pop 
L70:    getstatic [10] 
L73:    iconst_0 
L74:    ldc [14] 
L76:    aload_3 
L77:    invokeinterface [48] 0 
L82:    invokevirtual [32] 
L85:    pop 
L86:    aload_2 
L87:    areturn 
L88:    
    .end code 
.end method 

.method public enum [233] : [234] 
    .attribute [224] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [235] : [236] 
    .attribute [224] .code stack 5 locals 2 
L0:     aload_0 
L1:     getfield [27] 
L4:     aload_1 
L5:     invokeinterface [49] 0 
L10:    pop 
L11:    aload_2 
L12:    instanceof [9] 
L15:    ifeq L86 
L18:    aload_2 
L19:    checkcast [9] 
L22:    astore_3 
L23:    getstatic [10] 
L26:    iconst_0 
L27:    ldc [15] 
L29:    aload_3 
L30:    invokeinterface [48] 0 
L35:    invokevirtual [32] 
L38:    pop 
        .catch [12] from L39 to L47 using L50 
L39:    aload_0 
L40:    getfield [26] 
L43:    aload_3 
L44:    invokevirtual [35] 
L47:    goto L70 
L50:    astore 4 
L52:    getstatic [10] 
L55:    iconst_4 
L56:    ldc [16] 
L58:    aload_3 
L59:    invokeinterface [48] 0 
L64:    aload 4 
L66:    invokevirtual [34] 
L69:    pop 
L70:    getstatic [10] 
L73:    iconst_0 
L74:    ldc [17] 
L76:    aload_3 
L77:    invokeinterface [48] 0 
L82:    invokevirtual [32] 
L85:    pop 
L86:    return 
L87:    nop 
L88:    
    .end code 
.end method 

.method static synthetic [237] : [238] 
    .attribute [224] .code stack 2 locals 1 
        .catch [3] from L0 to L4 using L5 
L0:     aload_0 
L1:     invokestatic [2] 
L4:     areturn 
L5:     astore_1 
L6:     new [42] 
L9:     dup 
L10:    invokespecial [36] 
L13:    aload_1 
L14:    invokevirtual [25] 
L17:    athrow 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method static [239] : [240] 
    .attribute [224] .code stack 3 locals 0 
L0:     new [50] 
L3:     dup 
L4:     ldc [19] 
L6:     invokespecial [41] 
L9:     putstatic [40] 
L12:    return 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [51] [52] 
.const [3] = Class [53] 
.const [4] = Class [54] 
.const [5] = Class [55] 
.const [6] = Field [56] [57] 
.const [7] = String [58] 
.const [8] = Method [59] [60] 
.const [9] = Class [61] 
.const [10] = Field [62] [63] 
.const [11] = String [64] 
.const [12] = Class [65] 
.const [13] = String [66] 
.const [14] = String [67] 
.const [15] = String [68] 
.const [16] = String [69] 
.const [17] = String [70] 
.const [18] = Class [71] 
.const [19] = String [72] 
.const [20] = Class [73] 
.const [21] = Class [74] 
.const [22] = Class [75] 
.const [23] = Class [76] 
.const [24] = Class [77] 
.const [25] = Method [78] [79] 
.const [26] = Field [80] [81] 
.const [27] = Field [82] [83] 
.const [28] = Method [84] [85] 
.const [29] = Field [86] [87] 
.const [30] = Method [88] [89] 
.const [31] = Method [90] [91] 
.const [32] = Method [92] [93] 
.const [33] = Method [94] [95] 
.const [34] = Method [96] [97] 
.const [35] = Method [98] [99] 
.const [36] = Method [100] [101] 
.const [37] = Method [102] [103] 
.const [38] = Field [104] [105] 
.const [39] = Method [106] [107] 
.const [40] = Field [108] [109] 
.const [41] = Method [110] [111] 
.const [42] = Class [112] 
.const [43] = Field [113] [114] 
.const [44] = Field [115] [116] 
.const [45] = Class [117] 
.const [46] = Field [118] [119] 
.const [47] = InterfaceMethod [120] [121] 
.const [48] = InterfaceMethod [122] [123] 
.const [49] = InterfaceMethod [124] [125] 
.const [50] = Class [126] 
.const [51] = Class [127] 
.const [52] = NameAndType [128] [129] 
.const [53] = Utf8 java/lang/ClassNotFoundException 
.const [54] = Utf8 java/lang/NoClassDefFoundError 
.const [55] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [56] = Class [130] 
.const [57] = NameAndType [131] [132] 
.const [58] = Utf8 'de.esolutions.fw.comm.core.IService' 
.const [59] = Class [133] 
.const [60] = NameAndType [134] [135] 
.const [61] = Utf8 de/esolutions/fw/comm/core/IService 
.const [62] = Class [136] 
.const [63] = NameAndType [137] [138] 
.const [64] = Utf8 '+ registering IService %1' 
.const [65] = Utf8 java/lang/Exception 
.const [66] = Utf8 'Failed Service Registration for IService %1: %2' 
.const [67] = Utf8 '- registering IService %1' 
.const [68] = Utf8 '+ unregistering IService %1' 
.const [69] = Utf8 'Failed Service Unregistration for IService %1: %2' 
.const [70] = Utf8 '- unregistering IService %1' 
.const [71] = Utf8 de/esolutions/fw/util/tracing/TraceChannel 
.const [72] = Utf8 'comm.agent.osgi.ServiceTracker' 
.const [73] = Utf8 de/esolutions/fw/comm/agent/osgi/AgentServiceTracker 
.const [74] = Utf8 java/lang/Object 
.const [75] = Utf8 java/lang/Class 
.const [76] = Utf8 org/osgi/framework/BundleContext 
.const [77] = Utf8 de/esolutions/fw/comm/agent/Agent 
.const [78] = Class [139] 
.const [79] = NameAndType [140] [141] 
.const [80] = Class [142] 
.const [81] = NameAndType [143] [144] 
.const [82] = Class [145] 
.const [83] = NameAndType [146] [147] 
.const [84] = Class [148] 
.const [85] = NameAndType [149] [150] 
.const [86] = Class [151] 
.const [87] = NameAndType [152] [153] 
.const [88] = Class [154] 
.const [89] = NameAndType [155] [156] 
.const [90] = Class [157] 
.const [91] = NameAndType [158] [159] 
.const [92] = Class [160] 
.const [93] = NameAndType [161] [162] 
.const [94] = Class [163] 
.const [95] = NameAndType [164] [165] 
.const [96] = Class [166] 
.const [97] = NameAndType [167] [168] 
.const [98] = Class [169] 
.const [99] = NameAndType [170] [171] 
.const [100] = Class [172] 
.const [101] = NameAndType [173] [174] 
.const [102] = Class [175] 
.const [103] = NameAndType [176] [177] 
.const [104] = Class [178] 
.const [105] = NameAndType [179] [180] 
.const [106] = Class [181] 
.const [107] = NameAndType [182] [183] 
.const [108] = Class [184] 
.const [109] = NameAndType [185] [186] 
.const [110] = Class [187] 
.const [111] = NameAndType [188] [189] 
.const [112] = Utf8 java/lang/NoClassDefFoundError 
.const [113] = Class [190] 
.const [114] = NameAndType [191] [192] 
.const [115] = Class [193] 
.const [116] = NameAndType [194] [195] 
.const [117] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [118] = Class [196] 
.const [119] = NameAndType [197] [198] 
.const [120] = Class [199] 
.const [121] = NameAndType [200] [201] 
.const [122] = Class [202] 
.const [123] = NameAndType [203] [204] 
.const [124] = Class [205] 
.const [125] = NameAndType [206] [207] 
.const [126] = Utf8 de/esolutions/fw/util/tracing/TraceChannel 
.const [127] = Utf8 java/lang/Class 
.const [128] = Utf8 forName 
.const [129] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [130] = Utf8 de/esolutions/fw/comm/agent/osgi/AgentServiceTracker 
.const [131] = Utf8 class$de$esolutions$fw$comm$core$IService 
.const [132] = Utf8 Ljava/lang/Class; 
.const [133] = Utf8 de/esolutions/fw/comm/agent/osgi/AgentServiceTracker 
.const [134] = Utf8 class$ 
.const [135] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [136] = Utf8 de/esolutions/fw/comm/agent/osgi/AgentServiceTracker 
.const [137] = Utf8 trace 
.const [138] = Utf8 Lde/esolutions/fw/util/tracing/TraceChannel; 
.const [139] = Utf8 java/lang/NoClassDefFoundError 
.const [140] = Utf8 initCause 
.const [141] = Utf8 (Ljava/lang/Throwable;)Ljava/lang/Throwable; 
.const [142] = Utf8 de/esolutions/fw/comm/agent/osgi/AgentServiceTracker 
.const [143] = Utf8 agent 
.const [144] = Utf8 Lde/esolutions/fw/comm/agent/Agent; 
.const [145] = Utf8 de/esolutions/fw/comm/agent/osgi/AgentServiceTracker 
.const [146] = Utf8 bundleContext 
.const [147] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [148] = Utf8 java/lang/Class 
.const [149] = Utf8 getName 
.const [150] = Utf8 ()Ljava/lang/String; 
.const [151] = Utf8 de/esolutions/fw/comm/agent/osgi/AgentServiceTracker 
.const [152] = Utf8 tracker 
.const [153] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [154] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [155] = Utf8 'open' 
.const [156] = Utf8 ()V 
.const [157] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [158] = Utf8 close 
.const [159] = Utf8 ()V 
.const [160] = Utf8 de/esolutions/fw/util/tracing/TraceChannel 
.const [161] = Utf8 log 
.const [162] = Utf8 (SLjava/lang/String;Ljava/lang/Object;)Z 
.const [163] = Utf8 de/esolutions/fw/comm/agent/Agent 
.const [164] = Utf8 registerService 
.const [165] = Utf8 (Lde/esolutions/fw/comm/core/IService;)V 
.const [166] = Utf8 de/esolutions/fw/util/tracing/TraceChannel 
.const [167] = Utf8 log 
.const [168] = Utf8 (SLjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)Z 
.const [169] = Utf8 de/esolutions/fw/comm/agent/Agent 
.const [170] = Utf8 unregisterService 
.const [171] = Utf8 (Lde/esolutions/fw/comm/core/IService;)V 
.const [172] = Utf8 java/lang/NoClassDefFoundError 
.const [173] = Utf8 <init> 
.const [174] = Utf8 ()V 
.const [175] = Utf8 java/lang/Object 
.const [176] = Utf8 <init> 
.const [177] = Utf8 ()V 
.const [178] = Utf8 de/esolutions/fw/comm/agent/osgi/AgentServiceTracker 
.const [179] = Utf8 class$de$esolutions$fw$comm$core$IService 
.const [180] = Utf8 Ljava/lang/Class; 
.const [181] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [182] = Utf8 <init> 
.const [183] = Utf8 (Lorg/osgi/framework/BundleContext;Ljava/lang/String;Lorg/osgi/util/tracker/ServiceTrackerCustomizer;)V 
.const [184] = Utf8 de/esolutions/fw/comm/agent/osgi/AgentServiceTracker 
.const [185] = Utf8 trace 
.const [186] = Utf8 Lde/esolutions/fw/util/tracing/TraceChannel; 
.const [187] = Utf8 de/esolutions/fw/util/tracing/TraceChannel 
.const [188] = Utf8 <init> 
.const [189] = Utf8 (Ljava/lang/String;)V 
.const [190] = Utf8 de/esolutions/fw/comm/agent/osgi/AgentServiceTracker 
.const [191] = Utf8 agent 
.const [192] = Utf8 Lde/esolutions/fw/comm/agent/Agent; 
.const [193] = Utf8 de/esolutions/fw/comm/agent/osgi/AgentServiceTracker 
.const [194] = Utf8 bundleContext 
.const [195] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [196] = Utf8 de/esolutions/fw/comm/agent/osgi/AgentServiceTracker 
.const [197] = Utf8 tracker 
.const [198] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [199] = Utf8 org/osgi/framework/BundleContext 
.const [200] = Utf8 getService 
.const [201] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [202] = Utf8 de/esolutions/fw/comm/core/IService 
.const [203] = Utf8 getInstanceID 
.const [204] = Utf8 ()Lde/esolutions/fw/comm/core/ServiceInstanceID; 
.const [205] = Utf8 org/osgi/framework/BundleContext 
.const [206] = Utf8 ungetService 
.const [207] = Utf8 (Lorg/osgi/framework/ServiceReference;)Z 
.const [208] = Utf8 de/esolutions/fw/comm/agent/osgi/AgentServiceTracker 
.const [209] = Class [208] 
.const [210] = Utf8 java/lang/Object 
.const [211] = Class [210] 
.const [212] = Utf8 org/osgi/util/tracker/ServiceTrackerCustomizer 
.const [213] = Class [212] 
.const [214] = Utf8 trace 
.const [215] = Utf8 Lde/esolutions/fw/util/tracing/TraceChannel; 
.const [216] = Utf8 agent 
.const [217] = Utf8 Lde/esolutions/fw/comm/agent/Agent; 
.const [218] = Utf8 bundleContext 
.const [219] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [220] = Utf8 tracker 
.const [221] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [222] = Utf8 class$de$esolutions$fw$comm$core$IService 
.const [223] = Utf8 Ljava/lang/Class; 
.const [224] = Utf8 Code 
.const [225] = Utf8 <init> 
.const [226] = Utf8 (Lde/esolutions/fw/comm/agent/Agent;Lorg/osgi/framework/BundleContext;)V 
.const [227] = Utf8 'open' 
.const [228] = Utf8 ()V 
.const [229] = Utf8 close 
.const [230] = Utf8 ()V 
.const [231] = Utf8 addingService 
.const [232] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [233] = Utf8 modifiedService 
.const [234] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [235] = Utf8 removedService 
.const [236] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [237] = Utf8 class$ 
.const [238] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [239] = Utf8 <clinit> 
.const [240] = Utf8 ()V 
.end class 
