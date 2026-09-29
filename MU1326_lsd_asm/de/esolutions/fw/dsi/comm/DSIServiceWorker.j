.version 50 0 
.class public super [211] 
.super [213] 
.implements [215] 
.field private [216] [217] 
.field private final [218] [219] 
.field private final [220] [221] 
.field private [222] [223] 
.field private [224] [225] 
.field private static final [226] [227] 

.method public [229] : [230] 
    .attribute [228] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [34] 
L4:     aload_0 
L5:     iconst_0 
L6:     putfield [39] 
L9:     aload_0 
L10:    new [40] 
L13:    dup 
L14:    invokespecial [34] 
L17:    putfield [41] 
L20:    aload_0 
L21:    aload_1 
L22:    putfield [42] 
L25:    aload_0 
L26:    aload_2 
L27:    putfield [43] 
L30:    return 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [231] : [232] 
    .attribute [228] .code stack 5 locals 4 
L0:     iconst_0 
L1:     istore_1 
L2:     aload_0 
L3:     dup 
L4:     astore_2 
L5:     monitorenter 
        .catch [0] from L6 to L20 using L23 
L6:     aload_0 
L7:     dup 
L8:     getfield [21] 
L11:    iconst_1 
L12:    iadd 
L13:    dup_x1 
L14:    putfield [39] 
L17:    istore_1 
L18:    aload_2 
L19:    monitorexit 
L20:    goto L28 
        .catch [0] from L23 to L26 using L23 
L23:    astore_3 
L24:    aload_2 
L25:    monitorexit 
L26:    aload_3 
L27:    athrow 
L28:    iload_1 
L29:    iconst_1 
L30:    if_icmpne L114 
L33:    aload_0 
L34:    getfield [22] 
L37:    dup 
L38:    astore_2 
L39:    monitorenter 
        .catch [0] from L40 to L104 using L107 
L40:    getstatic [3] 
L43:    iconst_1 
L44:    ldc [4] 
L46:    aload_0 
L47:    getfield [23] 
L50:    invokevirtual [25] 
L53:    pop 
L54:    aload_0 
L55:    aload_0 
L56:    getfield [24] 
L59:    aload_0 
L60:    getfield [23] 
L63:    getstatic [5] 
L66:    invokeinterface [44] 0 
L71:    putfield [45] 
L74:    getstatic [3] 
L77:    iconst_2 
L78:    ldc [6] 
L80:    aload_0 
L81:    getfield [23] 
L84:    aload_0 
L85:    getfield [26] 
L88:    invokevirtual [27] 
L91:    invokevirtual [28] 
L94:    pop 
L95:    aload_0 
L96:    getfield [26] 
L99:    invokevirtual [29] 
L102:   aload_2 
L103:   monitorexit 
L104:   goto L114 
        .catch [0] from L107 to L111 using L107 
L107:   astore 4 
L109:   aload_2 
L110:   monitorexit 
L111:   aload 4 
L113:   athrow 
L114:   return 
L115:   nop 
L116:   
    .end code 
.end method 

.method public [233] : [234] 
    .attribute [228] .code stack 4 locals 4 
L0:     iconst_0 
L1:     istore_1 
L2:     aload_0 
L3:     dup 
L4:     astore_2 
L5:     monitorenter 
        .catch [0] from L6 to L35 using L38 
L6:     aload_0 
L7:     dup 
L8:     getfield [21] 
L11:    iconst_1 
L12:    isub 
L13:    putfield [39] 
L16:    aload_0 
L17:    getfield [21] 
L20:    ifge L28 
L23:    aload_0 
L24:    iconst_0 
L25:    putfield [39] 
L28:    aload_0 
L29:    getfield [21] 
L32:    istore_1 
L33:    aload_2 
L34:    monitorexit 
L35:    goto L43 
        .catch [0] from L38 to L41 using L38 
L38:    astore_3 
L39:    aload_2 
L40:    monitorexit 
L41:    aload_3 
L42:    athrow 
L43:    iload_1 
L44:    ifne L112 
L47:    aload_0 
L48:    getfield [22] 
L51:    dup 
L52:    astore_2 
L53:    monitorenter 
        .catch [0] from L54 to L102 using L105 
L54:    aload_0 
L55:    getfield [26] 
L58:    ifnull L100 
L61:    getstatic [3] 
L64:    iconst_1 
L65:    ldc [7] 
L67:    aload_0 
L68:    getfield [23] 
L71:    invokevirtual [25] 
L74:    pop 
L75:    aload_0 
L76:    getfield [26] 
L79:    invokevirtual [30] 
L82:    aload_0 
L83:    getfield [24] 
L86:    aload_0 
L87:    getfield [23] 
L90:    invokeinterface [46] 0 
L95:    aload_0 
L96:    aconst_null 
L97:    putfield [45] 
L100:   aload_2 
L101:   monitorexit 
L102:   goto L112 
        .catch [0] from L105 to L109 using L105 
L105:   astore 4 
L107:   aload_2 
L108:   monitorexit 
L109:   aload 4 
L111:   athrow 
L112:   return 
L113:   nop 
L114:   nop 
L115:   nop 
L116:   
    .end code 
.end method 

.method public synchronized [235] : [236] 
    .attribute [228] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [21] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [237] : [238] 
    .attribute [228] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [23] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [239] : [240] 
    .attribute [228] .code stack 5 locals 2 
L0:     getstatic [8] 
L3:     iconst_0 
L4:     ldc [9] 
L6:     aload_0 
L7:     getfield [23] 
L10:    aload_1 
L11:    invokevirtual [28] 
L14:    pop 
L15:    aload_0 
L16:    getfield [22] 
L19:    dup 
L20:    astore_2 
L21:    monitorenter 
        .catch [0] from L22 to L47 using L50 
L22:    aload_0 
L23:    getfield [26] 
L26:    ifnull L45 
L29:    aload_0 
L30:    getfield [26] 
L33:    new [47] 
L36:    dup 
L37:    aload_1 
L38:    invokespecial [36] 
L41:    invokevirtual [31] 
L44:    pop 
L45:    aload_2 
L46:    monitorexit 
L47:    goto L55 
        .catch [0] from L50 to L53 using L50 
L50:    astore_3 
L51:    aload_2 
L52:    monitorexit 
L53:    aload_3 
L54:    athrow 
L55:    getstatic [8] 
L58:    iconst_0 
L59:    ldc [11] 
L61:    aload_0 
L62:    getfield [23] 
L65:    aload_1 
L66:    invokevirtual [28] 
L69:    pop 
L70:    return 
L71:    nop 
L72:    
    .end code 
.end method 

.method public enum [241] : [242] 
    .attribute [228] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public enum [243] : [244] 
    .attribute [228] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public enum [245] : [246] 
    .attribute [228] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [247] : [248] 
    .attribute [228] .code stack 2 locals 0 
L0:     new [48] 
L3:     dup 
L4:     invokespecial [37] 
L7:     ldc [13] 
L9:     invokevirtual [32] 
L12:    aload_0 
L13:    getfield [23] 
L16:    invokevirtual [32] 
L19:    ldc [14] 
L21:    invokevirtual [32] 
L24:    invokevirtual [33] 
L27:    areturn 
L28:    
    .end code 
.end method 

.method static [249] : [250] 
    .attribute [228] .code stack 2 locals 0 
L0:     new [49] 
L3:     dup 
L4:     invokespecial [38] 
L7:     putstatic [35] 
L10:    return 
L11:    nop 
L12:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [50] 
.const [3] = Field [51] [52] 
.const [4] = String [53] 
.const [5] = Field [54] [55] 
.const [6] = String [56] 
.const [7] = String [57] 
.const [8] = Field [58] [59] 
.const [9] = String [60] 
.const [10] = Class [61] 
.const [11] = String [62] 
.const [12] = Class [63] 
.const [13] = String [64] 
.const [14] = String [65] 
.const [15] = Class [66] 
.const [16] = Class [67] 
.const [17] = Class [68] 
.const [18] = Class [69] 
.const [19] = Class [70] 
.const [20] = Class [71] 
.const [21] = Field [72] [73] 
.const [22] = Field [74] [75] 
.const [23] = Field [76] [77] 
.const [24] = Field [78] [79] 
.const [25] = Method [80] [81] 
.const [26] = Field [82] [83] 
.const [27] = Method [84] [85] 
.const [28] = Method [86] [87] 
.const [29] = Method [88] [89] 
.const [30] = Method [90] [91] 
.const [31] = Method [92] [93] 
.const [32] = Method [94] [95] 
.const [33] = Method [96] [97] 
.const [34] = Method [98] [99] 
.const [35] = Field [100] [101] 
.const [36] = Method [102] [103] 
.const [37] = Method [104] [105] 
.const [38] = Method [106] [107] 
.const [39] = Field [108] [109] 
.const [40] = Class [110] 
.const [41] = Field [111] [112] 
.const [42] = Field [113] [114] 
.const [43] = Field [115] [116] 
.const [44] = InterfaceMethod [117] [118] 
.const [45] = Field [119] [120] 
.const [46] = InterfaceMethod [121] [122] 
.const [47] = Class [123] 
.const [48] = Class [124] 
.const [49] = Class [125] 
.const [50] = Utf8 java/lang/Object 
.const [51] = Class [126] 
.const [52] = NameAndType [127] [128] 
.const [53] = Utf8 'creating dispatcher "%1"' 
.const [54] = Class [129] 
.const [55] = NameAndType [130] [131] 
.const [56] = Utf8 'starting service worker "%1" with dispatcher "%2"' 
.const [57] = Utf8 'Stopping ServiceWorker "%1"' 
.const [58] = Class [132] 
.const [59] = NameAndType [133] [134] 
.const [60] = Utf8 '-> Enqueing method call job to job dispatcher: name=%1, method=%2' 
.const [61] = Utf8 de/esolutions/fw/dsi/comm/DSIServiceWorker$ServiceJob 
.const [62] = Utf8 '<- Done enqueing method call job to job dispatcher: name=%1, method=%2' 
.const [63] = Utf8 java/lang/StringBuffer 
.const [64] = Utf8 'ServiceWorker [name=' 
.const [65] = Utf8 ']' 
.const [66] = Utf8 de/esolutions/fw/dsi/tracing/JobLogger 
.const [67] = Utf8 de/esolutions/fw/dsi/comm/DSIServiceWorker 
.const [68] = Utf8 de/esolutions/fw/dsi/tracing/Channels 
.const [69] = Utf8 de/esolutions/fw/util/tracing/TraceChannel 
.const [70] = Utf8 de/esolutions/fw/util/commons/job/IDispatcherManager 
.const [71] = Utf8 de/esolutions/fw/util/commons/job/DispatcherBase 
.const [72] = Class [135] 
.const [73] = NameAndType [136] [137] 
.const [74] = Class [138] 
.const [75] = NameAndType [139] [140] 
.const [76] = Class [141] 
.const [77] = NameAndType [142] [143] 
.const [78] = Class [144] 
.const [79] = NameAndType [145] [146] 
.const [80] = Class [147] 
.const [81] = NameAndType [148] [149] 
.const [82] = Class [150] 
.const [83] = NameAndType [151] [152] 
.const [84] = Class [153] 
.const [85] = NameAndType [154] [155] 
.const [86] = Class [156] 
.const [87] = NameAndType [157] [158] 
.const [88] = Class [159] 
.const [89] = NameAndType [160] [161] 
.const [90] = Class [162] 
.const [91] = NameAndType [163] [164] 
.const [92] = Class [165] 
.const [93] = NameAndType [166] [167] 
.const [94] = Class [168] 
.const [95] = NameAndType [169] [170] 
.const [96] = Class [171] 
.const [97] = NameAndType [172] [173] 
.const [98] = Class [174] 
.const [99] = NameAndType [175] [176] 
.const [100] = Class [177] 
.const [101] = NameAndType [178] [179] 
.const [102] = Class [180] 
.const [103] = NameAndType [181] [182] 
.const [104] = Class [183] 
.const [105] = NameAndType [184] [185] 
.const [106] = Class [186] 
.const [107] = NameAndType [187] [188] 
.const [108] = Class [189] 
.const [109] = NameAndType [190] [191] 
.const [110] = Utf8 java/lang/Object 
.const [111] = Class [192] 
.const [112] = NameAndType [193] [194] 
.const [113] = Class [195] 
.const [114] = NameAndType [196] [197] 
.const [115] = Class [198] 
.const [116] = NameAndType [199] [200] 
.const [117] = Class [201] 
.const [118] = NameAndType [202] [203] 
.const [119] = Class [204] 
.const [120] = NameAndType [205] [206] 
.const [121] = Class [207] 
.const [122] = NameAndType [208] [209] 
.const [123] = Utf8 de/esolutions/fw/dsi/comm/DSIServiceWorker$ServiceJob 
.const [124] = Utf8 java/lang/StringBuffer 
.const [125] = Utf8 de/esolutions/fw/dsi/tracing/JobLogger 
.const [126] = Utf8 de/esolutions/fw/dsi/tracing/Channels 
.const [127] = Utf8 DSI_ADMIN 
.const [128] = Utf8 Lde/esolutions/fw/util/tracing/TraceChannel; 
.const [129] = Utf8 de/esolutions/fw/dsi/comm/DSIServiceWorker 
.const [130] = Utf8 jobLogger 
.const [131] = Utf8 Lde/esolutions/fw/dsi/tracing/JobLogger; 
.const [132] = Utf8 de/esolutions/fw/dsi/tracing/Channels 
.const [133] = Utf8 SERVICEWORKER 
.const [134] = Utf8 Lde/esolutions/fw/util/tracing/TraceChannel; 
.const [135] = Utf8 de/esolutions/fw/dsi/comm/DSIServiceWorker 
.const [136] = Utf8 useCount 
.const [137] = Utf8 I 
.const [138] = Utf8 de/esolutions/fw/dsi/comm/DSIServiceWorker 
.const [139] = Utf8 jobDispatcherLock 
.const [140] = Utf8 Ljava/lang/Object; 
.const [141] = Utf8 de/esolutions/fw/dsi/comm/DSIServiceWorker 
.const [142] = Utf8 name 
.const [143] = Utf8 Ljava/lang/String; 
.const [144] = Utf8 de/esolutions/fw/dsi/comm/DSIServiceWorker 
.const [145] = Utf8 jobDispatcherManager 
.const [146] = Utf8 Lde/esolutions/fw/util/commons/job/IDispatcherManager; 
.const [147] = Utf8 de/esolutions/fw/util/tracing/TraceChannel 
.const [148] = Utf8 log 
.const [149] = Utf8 (SLjava/lang/String;Ljava/lang/Object;)Z 
.const [150] = Utf8 de/esolutions/fw/dsi/comm/DSIServiceWorker 
.const [151] = Utf8 jobDispatcher 
.const [152] = Utf8 Lde/esolutions/fw/util/commons/job/DispatcherBase; 
.const [153] = Utf8 de/esolutions/fw/util/commons/job/DispatcherBase 
.const [154] = Utf8 getName 
.const [155] = Utf8 ()Ljava/lang/String; 
.const [156] = Utf8 de/esolutions/fw/util/tracing/TraceChannel 
.const [157] = Utf8 log 
.const [158] = Utf8 (SLjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)Z 
.const [159] = Utf8 de/esolutions/fw/util/commons/job/DispatcherBase 
.const [160] = Utf8 start 
.const [161] = Utf8 ()V 
.const [162] = Utf8 de/esolutions/fw/util/commons/job/DispatcherBase 
.const [163] = Utf8 stop 
.const [164] = Utf8 ()V 
.const [165] = Utf8 de/esolutions/fw/util/commons/job/DispatcherBase 
.const [166] = Utf8 execute 
.const [167] = Utf8 (Ljava/lang/Object;)Lde/esolutions/fw/util/commons/job/Job; 
.const [168] = Utf8 java/lang/StringBuffer 
.const [169] = Utf8 append 
.const [170] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [171] = Utf8 java/lang/StringBuffer 
.const [172] = Utf8 toString 
.const [173] = Utf8 ()Ljava/lang/String; 
.const [174] = Utf8 java/lang/Object 
.const [175] = Utf8 <init> 
.const [176] = Utf8 ()V 
.const [177] = Utf8 de/esolutions/fw/dsi/comm/DSIServiceWorker 
.const [178] = Utf8 jobLogger 
.const [179] = Utf8 Lde/esolutions/fw/dsi/tracing/JobLogger; 
.const [180] = Utf8 de/esolutions/fw/dsi/comm/DSIServiceWorker$ServiceJob 
.const [181] = Utf8 <init> 
.const [182] = Utf8 (Lde/esolutions/fw/comm/core/IMethod;)V 
.const [183] = Utf8 java/lang/StringBuffer 
.const [184] = Utf8 <init> 
.const [185] = Utf8 ()V 
.const [186] = Utf8 de/esolutions/fw/dsi/tracing/JobLogger 
.const [187] = Utf8 <init> 
.const [188] = Utf8 ()V 
.const [189] = Utf8 de/esolutions/fw/dsi/comm/DSIServiceWorker 
.const [190] = Utf8 useCount 
.const [191] = Utf8 I 
.const [192] = Utf8 de/esolutions/fw/dsi/comm/DSIServiceWorker 
.const [193] = Utf8 jobDispatcherLock 
.const [194] = Utf8 Ljava/lang/Object; 
.const [195] = Utf8 de/esolutions/fw/dsi/comm/DSIServiceWorker 
.const [196] = Utf8 name 
.const [197] = Utf8 Ljava/lang/String; 
.const [198] = Utf8 de/esolutions/fw/dsi/comm/DSIServiceWorker 
.const [199] = Utf8 jobDispatcherManager 
.const [200] = Utf8 Lde/esolutions/fw/util/commons/job/IDispatcherManager; 
.const [201] = Utf8 de/esolutions/fw/util/commons/job/IDispatcherManager 
.const [202] = Utf8 createDispatcher 
.const [203] = Utf8 (Ljava/lang/String;Lde/esolutions/fw/util/commons/job/IJobLogger;)Lde/esolutions/fw/util/commons/job/DispatcherBase; 
.const [204] = Utf8 de/esolutions/fw/dsi/comm/DSIServiceWorker 
.const [205] = Utf8 jobDispatcher 
.const [206] = Utf8 Lde/esolutions/fw/util/commons/job/DispatcherBase; 
.const [207] = Utf8 de/esolutions/fw/util/commons/job/IDispatcherManager 
.const [208] = Utf8 destroyDispatcher 
.const [209] = Utf8 (Ljava/lang/String;)V 
.const [210] = Utf8 de/esolutions/fw/dsi/comm/DSIServiceWorker 
.const [211] = Class [210] 
.const [212] = Utf8 java/lang/Object 
.const [213] = Class [212] 
.const [214] = Utf8 de/esolutions/fw/dsi/comm/IDSIServiceWorker 
.const [215] = Class [214] 
.const [216] = Utf8 jobDispatcher 
.const [217] = Utf8 Lde/esolutions/fw/util/commons/job/DispatcherBase; 
.const [218] = Utf8 jobDispatcherManager 
.const [219] = Utf8 Lde/esolutions/fw/util/commons/job/IDispatcherManager; 
.const [220] = Utf8 name 
.const [221] = Utf8 Ljava/lang/String; 
.const [222] = Utf8 useCount 
.const [223] = Utf8 I 
.const [224] = Utf8 jobDispatcherLock 
.const [225] = Utf8 Ljava/lang/Object; 
.const [226] = Utf8 jobLogger 
.const [227] = Utf8 Lde/esolutions/fw/dsi/tracing/JobLogger; 
.const [228] = Utf8 Code 
.const [229] = Utf8 <init> 
.const [230] = Utf8 (Ljava/lang/String;Lde/esolutions/fw/util/commons/job/IDispatcherManager;)V 
.const [231] = Utf8 start 
.const [232] = Utf8 ()V 
.const [233] = Utf8 stop 
.const [234] = Utf8 ()V 
.const [235] = Utf8 getUseCount 
.const [236] = Utf8 ()I 
.const [237] = Utf8 getName 
.const [238] = Utf8 ()Ljava/lang/String; 
.const [239] = Utf8 enqueueCall 
.const [240] = Utf8 (Lde/esolutions/fw/comm/core/IMethod;)V 
.const [241] = Utf8 registerService 
.const [242] = Utf8 (Lde/esolutions/fw/comm/core/IService;)V 
.const [243] = Utf8 stubCountChanged 
.const [244] = Utf8 (Lde/esolutions/fw/comm/core/IService;I)V 
.const [245] = Utf8 unregisterService 
.const [246] = Utf8 (Lde/esolutions/fw/comm/core/IService;)V 
.const [247] = Utf8 toString 
.const [248] = Utf8 ()Ljava/lang/String; 
.const [249] = Utf8 <clinit> 
.const [250] = Utf8 ()V 
.end class 
