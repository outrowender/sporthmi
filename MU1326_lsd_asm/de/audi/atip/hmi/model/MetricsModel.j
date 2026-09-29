.version 50 0 
.class public super [209] 
.super [211] 
.implements [213] 
.implements [215] 
.field private volatile [216] [217] 
.field private [218] [219] 

.method public [221] : [222] 
    .attribute [220] .code stack 3 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     iconst_0 
L3:     invokespecial [40] 
L6:     aload_0 
L7:     getstatic [2] 
L10:    putfield [45] 
L13:    return 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [223] : [224] 
    .attribute [220] .code stack 3 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     iconst_0 
L3:     invokespecial [40] 
L6:     aload_0 
L7:     getstatic [2] 
L10:    putfield [45] 
L13:    aload_0 
L14:    aload_2 
L15:    putfield [46] 
L18:    return 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [225] : [226] 
    .attribute [220] .code stack 3 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     iload_2 
L3:     invokespecial [40] 
L6:     aload_0 
L7:     getstatic [2] 
L10:    putfield [45] 
L13:    aload_0 
L14:    aload_3 
L15:    putfield [46] 
L18:    return 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [227] : [228] 
    .attribute [220] .code stack 2 locals 0 
L0:     aload_0 
L1:     getstatic [2] 
L4:     putfield [45] 
L7:     return 
L8:     
    .end code 
.end method 

.method public [229] : [230] 
    .attribute [220] .code stack 3 locals 2 
L0:     new [47] 
L3:     dup 
L4:     bipush 100 
L6:     invokespecial [41] 
L9:     astore_1 
L10:    aload_1 
L11:    aload_0 
L12:    invokespecial [42] 
L15:    invokevirtual [23] 
L18:    pop 
        .catch [9] from L19 to L114 using L117 
L19:    aload_1 
L20:    ldc [4] 
L22:    invokevirtual [23] 
L25:    pop 
L26:    aload_1 
L27:    aload_0 
L28:    getfield [22] 
L31:    invokespecial [43] 
L34:    invokevirtual [24] 
L37:    pop 
L38:    aload_1 
L39:    ldc [5] 
L41:    invokevirtual [23] 
L44:    pop 
L45:    aload_1 
L46:    aload_0 
L47:    getfield [22] 
L50:    invokevirtual [25] 
L53:    invokevirtual [26] 
L56:    pop 
L57:    aload_1 
L58:    ldc [6] 
L60:    invokevirtual [23] 
L63:    pop 
L64:    aload_1 
L65:    aload_0 
L66:    getfield [22] 
L69:    invokevirtual [27] 
L72:    invokevirtual [28] 
L75:    pop 
L76:    aload_1 
L77:    ldc [7] 
L79:    invokevirtual [23] 
L82:    pop 
L83:    aload_1 
L84:    aload_0 
L85:    getfield [22] 
L88:    invokevirtual [29] 
L91:    invokevirtual [23] 
L94:    pop 
L95:    aload_1 
L96:    ldc [8] 
L98:    invokevirtual [23] 
L101:   pop 
L102:   aload_1 
L103:   aload_0 
L104:   getfield [22] 
L107:   invokevirtual [30] 
L110:   invokevirtual [23] 
L113:   pop 
L114:   goto L125 
L117:   astore_2 
L118:   aload_1 
L119:   ldc [10] 
L121:   invokevirtual [23] 
L124:   pop 
L125:   aload_1 
L126:   ldc [11] 
L128:   invokevirtual [23] 
L131:   pop 
L132:   aload_1 
L133:   aload_0 
L134:   getfield [21] 
L137:   invokevirtual [24] 
L140:   pop 
L141:   aload_1 
L142:   invokevirtual [31] 
L145:   areturn 
L146:   nop 
L147:   nop 
L148:   
    .end code 
.end method 

.method public [231] : [232] 
    .attribute [220] .code stack 1 locals 0 
L0:     bipush 9 
L2:     areturn 
L3:     nop 
L4:     
    .end code 
.end method 

.method protected [233] : [234] 
    .attribute [220] .code stack 6 locals 3 
L0:     aload_0 
L1:     getfield [32] 
L4:     dup 
L5:     astore_2 
L6:     monitorenter 
        .catch [0] from L7 to L27 using L30 
L7:     aload_1 
L8:     checkcast [12] 
L11:    astore_3 
L12:    aload_0 
L13:    aload_3 
L14:    getfield [22] 
L17:    putfield [46] 
L20:    aload_0 
L21:    aload_1 
L22:    invokespecial [44] 
L25:    aload_2 
L26:    monitorexit 
L27:    goto L37 
        .catch [0] from L30 to L34 using L30 
        .catch [13] from L0 to L37 using L40 
L30:    astore 4 
L32:    aload_2 
L33:    monitorexit 
L34:    aload 4 
L36:    athrow 
L37:    goto L74 
L40:    astore_2 
L41:    aload_0 
L42:    getfield [33] 
L45:    sipush 10000 
L48:    ldc [14] 
L50:    aload_1 
L51:    aload_0 
L52:    getfield [34] 
L55:    i2l 
L56:    invokevirtual [35] 
L59:    pop 
L60:    aload_0 
L61:    getfield [33] 
L64:    sipush 10000 
L67:    ldc [15] 
L69:    aload_2 
L70:    invokevirtual [36] 
L73:    pop 
L74:    return 
L75:    nop 
L76:    
    .end code 
.end method 

.method public [235] : [236] 
    .attribute [220] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [22] 
L4:     ifnonnull L11 
L7:     iconst_1 
L8:     goto L12 
L11:    iconst_0 
L12:    areturn 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public interface [237] : [238] 
    .attribute [220] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [22] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [239] : [240] 
    .attribute [220] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     ifnull L9 
L5:     aload_1 
L6:     goto L12 
L9:     getstatic [2] 
L12:    putfield [45] 
L15:    return 
L16:    
    .end code 
.end method 

.method public [241] : [242] 
    .attribute [220] .code stack 2 locals 2 
L0:     aload_0 
L1:     getfield [32] 
L4:     dup 
L5:     astore_2 
L6:     monitorenter 
        .catch [0] from L7 to L18 using L21 
L7:     aload_0 
L8:     aload_1 
L9:     putfield [46] 
L12:    aload_0 
L13:    invokevirtual [37] 
L16:    aload_2 
L17:    monitorexit 
L18:    goto L26 
        .catch [0] from L21 to L24 using L21 
L21:    astore_3 
L22:    aload_2 
L23:    monitorexit 
L24:    aload_3 
L25:    athrow 
L26:    aload_0 
L27:    iconst_1 
L28:    invokevirtual [38] 
L31:    return 
L32:    
    .end code 
.end method 

.method public [243] : [244] 
    .attribute [220] .code stack 2 locals 0 
L0:     aload_0 
L1:     bipush 13 
L3:     invokevirtual [38] 
L6:     return 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [245] : [246] 
    .attribute [220] .code stack 3 locals 3 
        .catch [13] from L0 to L14 using L17 
L0:     aload_0 
L1:     getfield [21] 
L4:     aload_0 
L5:     getfield [34] 
L8:     iload_1 
L9:     invokeinterface [48] 0 
L14:    goto L25 
L17:    astore 4 
L19:    aload_0 
L20:    aload 4 
L22:    invokevirtual [39] 
L25:    return 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Field [49] [50] 
.const [3] = Class [51] 
.const [4] = String [52] 
.const [5] = String [53] 
.const [6] = String [54] 
.const [7] = String [55] 
.const [8] = String [56] 
.const [9] = Class [57] 
.const [10] = String [58] 
.const [11] = String [59] 
.const [12] = Class [60] 
.const [13] = Class [61] 
.const [14] = String [62] 
.const [15] = String [63] 
.const [16] = Class [64] 
.const [17] = Class [65] 
.const [18] = Class [66] 
.const [19] = Class [67] 
.const [20] = Class [68] 
.const [21] = Field [69] [70] 
.const [22] = Field [71] [72] 
.const [23] = Method [73] [74] 
.const [24] = Method [75] [76] 
.const [25] = Method [77] [78] 
.const [26] = Method [79] [80] 
.const [27] = Method [81] [82] 
.const [28] = Method [83] [84] 
.const [29] = Method [85] [86] 
.const [30] = Method [87] [88] 
.const [31] = Method [89] [90] 
.const [32] = Field [91] [92] 
.const [33] = Field [93] [94] 
.const [34] = Field [95] [96] 
.const [35] = Method [97] [98] 
.const [36] = Method [99] [100] 
.const [37] = Method [101] [102] 
.const [38] = Method [103] [104] 
.const [39] = Method [105] [106] 
.const [40] = Method [107] [108] 
.const [41] = Method [109] [110] 
.const [42] = Method [111] [112] 
.const [43] = Method [113] [114] 
.const [44] = Method [115] [116] 
.const [45] = Field [117] [118] 
.const [46] = Field [119] [120] 
.const [47] = Class [121] 
.const [48] = InterfaceMethod [122] [123] 
.const [49] = Class [124] 
.const [50] = NameAndType [125] [126] 
.const [51] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [52] = Utf8 '\nMetrics - Metric: ' 
.const [53] = Utf8 '\nMetrics - Value: ' 
.const [54] = Utf8 '\nMetrics - Unit: ' 
.const [55] = Utf8 '\nMetrics - Formatted Value: ' 
.const [56] = Utf8 '\nMetrics - Formatted Unit: ' 
.const [57] = Utf8 java/lang/NullPointerException 
.const [58] = Utf8 '\nMetrics: null' 
.const [59] = Utf8 '\nMetricsListener: ' 
.const [60] = Utf8 de/audi/atip/hmi/model/MetricsModel 
.const [61] = Utf8 java/lang/Exception 
.const [62] = Utf8 '(%2) MetricsModel.copy( %1 ) failed! ' 
.const [63] = Utf8 'ERROR: ' 
.const [64] = Utf8 de/audi/atip/hmi/model/AbstractModel 
.const [65] = Utf8 java/lang/Object 
.const [66] = Utf8 de/audi/atip/metrics/AbstractMetrics 
.const [67] = Utf8 de/audi/atip/log/LogChannel 
.const [68] = Utf8 de/audi/atip/hmi/model/MetricsListener 
.const [69] = Class [127] 
.const [70] = NameAndType [128] [129] 
.const [71] = Class [130] 
.const [72] = NameAndType [131] [132] 
.const [73] = Class [133] 
.const [74] = NameAndType [134] [135] 
.const [75] = Class [136] 
.const [76] = NameAndType [137] [138] 
.const [77] = Class [139] 
.const [78] = NameAndType [140] [141] 
.const [79] = Class [142] 
.const [80] = NameAndType [143] [144] 
.const [81] = Class [145] 
.const [82] = NameAndType [146] [147] 
.const [83] = Class [148] 
.const [84] = NameAndType [149] [150] 
.const [85] = Class [151] 
.const [86] = NameAndType [152] [153] 
.const [87] = Class [154] 
.const [88] = NameAndType [155] [156] 
.const [89] = Class [157] 
.const [90] = NameAndType [158] [159] 
.const [91] = Class [160] 
.const [92] = NameAndType [161] [162] 
.const [93] = Class [163] 
.const [94] = NameAndType [164] [165] 
.const [95] = Class [166] 
.const [96] = NameAndType [167] [168] 
.const [97] = Class [169] 
.const [98] = NameAndType [170] [171] 
.const [99] = Class [172] 
.const [100] = NameAndType [173] [174] 
.const [101] = Class [175] 
.const [102] = NameAndType [176] [177] 
.const [103] = Class [178] 
.const [104] = NameAndType [179] [180] 
.const [105] = Class [181] 
.const [106] = NameAndType [182] [183] 
.const [107] = Class [184] 
.const [108] = NameAndType [185] [186] 
.const [109] = Class [187] 
.const [110] = NameAndType [188] [189] 
.const [111] = Class [190] 
.const [112] = NameAndType [191] [192] 
.const [113] = Class [193] 
.const [114] = NameAndType [194] [195] 
.const [115] = Class [196] 
.const [116] = NameAndType [197] [198] 
.const [117] = Class [199] 
.const [118] = NameAndType [200] [201] 
.const [119] = Class [202] 
.const [120] = NameAndType [203] [204] 
.const [121] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [122] = Class [205] 
.const [123] = NameAndType [206] [207] 
.const [124] = Utf8 de/audi/atip/hmi/model/MetricsModel 
.const [125] = Utf8 DUMMY_LISTENER 
.const [126] = Utf8 Lde/audi/atip/hmi/model/FallbackListener; 
.const [127] = Utf8 de/audi/atip/hmi/model/MetricsModel 
.const [128] = Utf8 metricsListener 
.const [129] = Utf8 Lde/audi/atip/hmi/model/MetricsListener; 
.const [130] = Utf8 de/audi/atip/hmi/model/MetricsModel 
.const [131] = Utf8 metric 
.const [132] = Utf8 Lde/audi/atip/metrics/AbstractMetrics; 
.const [133] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [134] = Utf8 append 
.const [135] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [136] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [137] = Utf8 append 
.const [138] = Utf8 (Ljava/lang/Object;)Lde/esolutions/fw/util/commons/Buffer; 
.const [139] = Utf8 de/audi/atip/metrics/AbstractMetrics 
.const [140] = Utf8 getValue 
.const [141] = Utf8 ()F 
.const [142] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [143] = Utf8 append 
.const [144] = Utf8 (F)Lde/esolutions/fw/util/commons/Buffer; 
.const [145] = Utf8 de/audi/atip/metrics/AbstractMetrics 
.const [146] = Utf8 getUnit 
.const [147] = Utf8 ()I 
.const [148] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [149] = Utf8 append 
.const [150] = Utf8 (I)Lde/esolutions/fw/util/commons/Buffer; 
.const [151] = Utf8 de/audi/atip/metrics/AbstractMetrics 
.const [152] = Utf8 getFormattedValue 
.const [153] = Utf8 ()Ljava/lang/String; 
.const [154] = Utf8 de/audi/atip/metrics/AbstractMetrics 
.const [155] = Utf8 getFormattedMetricUnit 
.const [156] = Utf8 ()Ljava/lang/String; 
.const [157] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [158] = Utf8 toString 
.const [159] = Utf8 ()Ljava/lang/String; 
.const [160] = Utf8 de/audi/atip/hmi/model/MetricsModel 
.const [161] = Utf8 mutex 
.const [162] = Utf8 Ljava/lang/Object; 
.const [163] = Utf8 de/audi/atip/hmi/model/MetricsModel 
.const [164] = Utf8 lc 
.const [165] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [166] = Utf8 de/audi/atip/hmi/model/MetricsModel 
.const [167] = Utf8 id 
.const [168] = Utf8 I 
.const [169] = Utf8 de/audi/atip/log/LogChannel 
.const [170] = Utf8 log 
.const [171] = Utf8 (ILjava/lang/String;Ljava/lang/Object;J)Z 
.const [172] = Utf8 de/audi/atip/log/LogChannel 
.const [173] = Utf8 log 
.const [174] = Utf8 (ILjava/lang/String;Ljava/lang/Throwable;)Z 
.const [175] = Utf8 de/audi/atip/hmi/model/MetricsModel 
.const [176] = Utf8 stateChanged 
.const [177] = Utf8 ()V 
.const [178] = Utf8 de/audi/atip/hmi/model/MetricsModel 
.const [179] = Utf8 fireModelUpdateEvent 
.const [180] = Utf8 (I)V 
.const [181] = Utf8 de/audi/atip/hmi/model/MetricsModel 
.const [182] = Utf8 handleListenerException 
.const [183] = Utf8 (Ljava/lang/Exception;)V 
.const [184] = Utf8 de/audi/atip/hmi/model/AbstractModel 
.const [185] = Utf8 <init> 
.const [186] = Utf8 (II)V 
.const [187] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [188] = Utf8 <init> 
.const [189] = Utf8 (I)V 
.const [190] = Utf8 de/audi/atip/hmi/model/AbstractModel 
.const [191] = Utf8 dumpContent 
.const [192] = Utf8 ()Ljava/lang/String; 
.const [193] = Utf8 java/lang/Object 
.const [194] = Utf8 getClass 
.const [195] = Utf8 ()Ljava/lang/Class; 
.const [196] = Utf8 de/audi/atip/hmi/model/AbstractModel 
.const [197] = Utf8 copy 
.const [198] = Utf8 (Lde/audi/atip/hmi/model/AbstractModel;)V 
.const [199] = Utf8 de/audi/atip/hmi/model/MetricsModel 
.const [200] = Utf8 metricsListener 
.const [201] = Utf8 Lde/audi/atip/hmi/model/MetricsListener; 
.const [202] = Utf8 de/audi/atip/hmi/model/MetricsModel 
.const [203] = Utf8 metric 
.const [204] = Utf8 Lde/audi/atip/metrics/AbstractMetrics; 
.const [205] = Utf8 de/audi/atip/hmi/model/MetricsListener 
.const [206] = Utf8 metricsUpdated 
.const [207] = Utf8 (II)V 
.const [208] = Utf8 de/audi/atip/hmi/model/MetricsModel 
.const [209] = Class [208] 
.const [210] = Utf8 de/audi/atip/hmi/model/AbstractModel 
.const [211] = Class [210] 
.const [212] = Utf8 de/audi/atip/hmi/modelaccess/MetricsModelGUI 
.const [213] = Class [212] 
.const [214] = Utf8 de/audi/atip/hmi/modelaccess/MetricsModelApp 
.const [215] = Class [214] 
.const [216] = Utf8 metricsListener 
.const [217] = Utf8 Lde/audi/atip/hmi/model/MetricsListener; 
.const [218] = Utf8 metric 
.const [219] = Utf8 Lde/audi/atip/metrics/AbstractMetrics; 
.const [220] = Utf8 Code 
.const [221] = Utf8 <init> 
.const [222] = Utf8 (I)V 
.const [223] = Utf8 <init> 
.const [224] = Utf8 (ILde/audi/atip/metrics/AbstractMetrics;)V 
.const [225] = Utf8 <init> 
.const [226] = Utf8 (IILde/audi/atip/metrics/AbstractMetrics;)V 
.const [227] = Utf8 resetListener 
.const [228] = Utf8 ()V 
.const [229] = Utf8 dumpContent 
.const [230] = Utf8 ()Ljava/lang/String; 
.const [231] = Utf8 getModelType 
.const [232] = Utf8 ()I 
.const [233] = Utf8 copy 
.const [234] = Utf8 (Lde/audi/atip/hmi/model/AbstractModel;)V 
.const [235] = Utf8 isEmpty 
.const [236] = Utf8 ()Z 
.const [237] = Utf8 getMetric 
.const [238] = Utf8 ()Lde/audi/atip/metrics/AbstractMetrics; 
.const [239] = Utf8 setMetricsListener 
.const [240] = Utf8 (Lde/audi/atip/hmi/model/MetricsListener;)V 
.const [241] = Utf8 setMetric 
.const [242] = Utf8 (Lde/audi/atip/metrics/AbstractMetrics;)V 
.const [243] = Utf8 formatChanged 
.const [244] = Utf8 ()V 
.const [245] = Utf8 metricsUpdated 
.const [246] = Utf8 (I)V 
.end class 
