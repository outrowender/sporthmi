.version 50 0 
.class public super [147] 
.super [149] 
.field private [150] [151] 
.field private [152] [153] 
.field private [154] [155] 

.method public [157] : [158] 
    .attribute [156] .code stack 4 locals 0 
L0:     aload_0 
L1:     invokespecial [16] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [19] 
L9:     aload_0 
L10:    new [20] 
L13:    dup 
L14:    iconst_4 
L15:    invokespecial [17] 
L18:    putfield [21] 
L21:    return 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [159] : [160] 
    .attribute [156] .code stack 5 locals 2 
L0:     aload_0 
L1:     getfield [13] 
L4:     dup 
L5:     astore_3 
L6:     monitorenter 
        .catch [0] from L7 to L28 using L31 
L7:     aload_0 
L8:     getfield [13] 
L11:    aload_2 
L12:    new [22] 
L15:    dup 
L16:    iload_1 
L17:    invokespecial [18] 
L20:    invokeinterface [23] 0 
L25:    pop 
L26:    aload_3 
L27:    monitorexit 
L28:    goto L38 
        .catch [0] from L31 to L35 using L31 
L31:    astore 4 
L33:    aload_3 
L34:    monitorexit 
L35:    aload 4 
L37:    athrow 
L38:    aload_2 
L39:    aload_0 
L40:    getfield [12] 
L43:    iload_1 
L44:    invokeinterface [24] 0 
L49:    invokeinterface [25] 0 
L54:    return 
L55:    nop 
L56:    
    .end code 
.end method 

.method public [161] : [162] 
    .attribute [156] .code stack 2 locals 2 
L0:     aload_1 
L1:     ifnull L39 
L4:     aload_1 
L5:     aconst_null 
L6:     invokeinterface [25] 0 
L11:    aload_0 
L12:    getfield [13] 
L15:    dup 
L16:    astore_2 
L17:    monitorenter 
        .catch [0] from L18 to L31 using L34 
L18:    aload_0 
L19:    getfield [13] 
L22:    aload_1 
L23:    invokeinterface [26] 0 
L28:    pop 
L29:    aload_2 
L30:    monitorexit 
L31:    goto L39 
        .catch [0] from L34 to L37 using L34 
L34:    astore_3 
L35:    aload_2 
L36:    monitorexit 
L37:    aload_3 
L38:    athrow 
L39:    return 
L40:    
    .end code 
.end method 

.method public [163] : [164] 
    .attribute [156] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [27] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [165] : [166] 
    .attribute [156] .code stack 2 locals 0 
L0:     aload_0 
L1:     aconst_null 
L2:     putfield [27] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [167] : [168] 
    .attribute [156] .code stack 4 locals 6 
L0:     aload_0 
L1:     getfield [13] 
L4:     dup 
L5:     astore_2 
L6:     monitorenter 
        .catch [0] from L7 to L93 using L96 
L7:     aload_0 
L8:     getfield [13] 
L11:    invokeinterface [28] 0 
L16:    invokeinterface [29] 0 
L21:    astore_3 
L22:    aload_3 
L23:    invokeinterface [30] 0 
L28:    ifeq L91 
L31:    aload_3 
L32:    invokeinterface [31] 0 
L37:    checkcast [4] 
L40:    astore 4 
L42:    aload_0 
L43:    getfield [13] 
L46:    aload 4 
L48:    invokeinterface [32] 0 
L53:    checkcast [3] 
L56:    invokevirtual [15] 
L59:    istore 5 
L61:    iload 5 
L63:    iload_1 
L64:    if_icmpne L88 
L67:    aload_0 
L68:    getfield [12] 
L71:    iload_1 
L72:    invokeinterface [24] 0 
L77:    astore 6 
L79:    aload 4 
L81:    aload 6 
L83:    invokeinterface [25] 0 
L88:    goto L22 
L91:    aload_2 
L92:    monitorexit 
L93:    goto L103 
        .catch [0] from L96 to L100 using L96 
L96:    astore 7 
L98:    aload_2 
L99:    monitorexit 
L100:   aload 7 
L102:   athrow 
L103:   aload_0 
L104:   getfield [14] 
L107:   ifnull L130 
L110:   aload_0 
L111:   getfield [14] 
L114:   iload_1 
L115:   aload_0 
L116:   getfield [12] 
L119:   iload_1 
L120:   invokeinterface [24] 0 
L125:   invokeinterface [33] 0 
L130:   return 
L131:   nop 
L132:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [34] 
.const [3] = Class [35] 
.const [4] = Class [36] 
.const [5] = Class [37] 
.const [6] = Class [38] 
.const [7] = Class [39] 
.const [8] = Class [40] 
.const [9] = Class [41] 
.const [10] = Class [42] 
.const [11] = Class [43] 
.const [12] = Field [44] [45] 
.const [13] = Field [46] [47] 
.const [14] = Field [48] [49] 
.const [15] = Method [50] [51] 
.const [16] = Method [52] [53] 
.const [17] = Method [54] [55] 
.const [18] = Method [56] [57] 
.const [19] = Field [58] [59] 
.const [20] = Class [60] 
.const [21] = Field [61] [62] 
.const [22] = Class [63] 
.const [23] = InterfaceMethod [64] [65] 
.const [24] = InterfaceMethod [66] [67] 
.const [25] = InterfaceMethod [68] [69] 
.const [26] = InterfaceMethod [70] [71] 
.const [27] = Field [72] [73] 
.const [28] = InterfaceMethod [74] [75] 
.const [29] = InterfaceMethod [76] [77] 
.const [30] = InterfaceMethod [78] [79] 
.const [31] = InterfaceMethod [80] [81] 
.const [32] = InterfaceMethod [82] [83] 
.const [33] = InterfaceMethod [84] [85] 
.const [34] = Utf8 java/util/HashMap 
.const [35] = Utf8 java/lang/Integer 
.const [36] = Utf8 de/audi/atip/hmi/modelaccess/MetricsModelApp 
.const [37] = Utf8 de/audi/atip/interapp/cartrip/TripModelHandler 
.const [38] = Utf8 java/lang/Object 
.const [39] = Utf8 java/util/Map 
.const [40] = Utf8 de/audi/atip/interapp/cartrip/ITripDataProvider 
.const [41] = Utf8 java/util/Set 
.const [42] = Utf8 java/util/Iterator 
.const [43] = Utf8 de/audi/atip/interapp/cartrip/ITripListener 
.const [44] = Class [86] 
.const [45] = NameAndType [87] [88] 
.const [46] = Class [89] 
.const [47] = NameAndType [90] [91] 
.const [48] = Class [92] 
.const [49] = NameAndType [93] [94] 
.const [50] = Class [95] 
.const [51] = NameAndType [96] [97] 
.const [52] = Class [98] 
.const [53] = NameAndType [99] [100] 
.const [54] = Class [101] 
.const [55] = NameAndType [102] [103] 
.const [56] = Class [104] 
.const [57] = NameAndType [105] [106] 
.const [58] = Class [107] 
.const [59] = NameAndType [108] [109] 
.const [60] = Utf8 java/util/HashMap 
.const [61] = Class [110] 
.const [62] = NameAndType [111] [112] 
.const [63] = Utf8 java/lang/Integer 
.const [64] = Class [113] 
.const [65] = NameAndType [114] [115] 
.const [66] = Class [116] 
.const [67] = NameAndType [117] [118] 
.const [68] = Class [119] 
.const [69] = NameAndType [120] [121] 
.const [70] = Class [122] 
.const [71] = NameAndType [123] [124] 
.const [72] = Class [125] 
.const [73] = NameAndType [126] [127] 
.const [74] = Class [128] 
.const [75] = NameAndType [129] [130] 
.const [76] = Class [131] 
.const [77] = NameAndType [132] [133] 
.const [78] = Class [134] 
.const [79] = NameAndType [135] [136] 
.const [80] = Class [137] 
.const [81] = NameAndType [138] [139] 
.const [82] = Class [140] 
.const [83] = NameAndType [141] [142] 
.const [84] = Class [143] 
.const [85] = NameAndType [144] [145] 
.const [86] = Utf8 de/audi/atip/interapp/cartrip/TripModelHandler 
.const [87] = Utf8 dataProvider 
.const [88] = Utf8 Lde/audi/atip/interapp/cartrip/ITripDataProvider; 
.const [89] = Utf8 de/audi/atip/interapp/cartrip/TripModelHandler 
.const [90] = Utf8 model2DataType 
.const [91] = Utf8 Ljava/util/Map; 
.const [92] = Utf8 de/audi/atip/interapp/cartrip/TripModelHandler 
.const [93] = Utf8 listener 
.const [94] = Utf8 Lde/audi/atip/interapp/cartrip/ITripListener; 
.const [95] = Utf8 java/lang/Integer 
.const [96] = Utf8 intValue 
.const [97] = Utf8 ()I 
.const [98] = Utf8 java/lang/Object 
.const [99] = Utf8 <init> 
.const [100] = Utf8 ()V 
.const [101] = Utf8 java/util/HashMap 
.const [102] = Utf8 <init> 
.const [103] = Utf8 (I)V 
.const [104] = Utf8 java/lang/Integer 
.const [105] = Utf8 <init> 
.const [106] = Utf8 (I)V 
.const [107] = Utf8 de/audi/atip/interapp/cartrip/TripModelHandler 
.const [108] = Utf8 dataProvider 
.const [109] = Utf8 Lde/audi/atip/interapp/cartrip/ITripDataProvider; 
.const [110] = Utf8 de/audi/atip/interapp/cartrip/TripModelHandler 
.const [111] = Utf8 model2DataType 
.const [112] = Utf8 Ljava/util/Map; 
.const [113] = Utf8 java/util/Map 
.const [114] = Utf8 put 
.const [115] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 
.const [116] = Utf8 de/audi/atip/interapp/cartrip/ITripDataProvider 
.const [117] = Utf8 getTripDataValue 
.const [118] = Utf8 (I)Lde/audi/atip/metrics/AbstractMetrics; 
.const [119] = Utf8 de/audi/atip/hmi/modelaccess/MetricsModelApp 
.const [120] = Utf8 setMetric 
.const [121] = Utf8 (Lde/audi/atip/metrics/AbstractMetrics;)V 
.const [122] = Utf8 java/util/Map 
.const [123] = Utf8 remove 
.const [124] = Utf8 (Ljava/lang/Object;)Ljava/lang/Object; 
.const [125] = Utf8 de/audi/atip/interapp/cartrip/TripModelHandler 
.const [126] = Utf8 listener 
.const [127] = Utf8 Lde/audi/atip/interapp/cartrip/ITripListener; 
.const [128] = Utf8 java/util/Map 
.const [129] = Utf8 keySet 
.const [130] = Utf8 ()Ljava/util/Set; 
.const [131] = Utf8 java/util/Set 
.const [132] = Utf8 iterator 
.const [133] = Utf8 ()Ljava/util/Iterator; 
.const [134] = Utf8 java/util/Iterator 
.const [135] = Utf8 hasNext 
.const [136] = Utf8 ()Z 
.const [137] = Utf8 java/util/Iterator 
.const [138] = Utf8 next 
.const [139] = Utf8 ()Ljava/lang/Object; 
.const [140] = Utf8 java/util/Map 
.const [141] = Utf8 get 
.const [142] = Utf8 (Ljava/lang/Object;)Ljava/lang/Object; 
.const [143] = Utf8 de/audi/atip/interapp/cartrip/ITripListener 
.const [144] = Utf8 updateMetrics 
.const [145] = Utf8 (ILde/audi/atip/metrics/AbstractMetrics;)V 
.const [146] = Utf8 de/audi/atip/interapp/cartrip/TripModelHandler 
.const [147] = Class [146] 
.const [148] = Utf8 java/lang/Object 
.const [149] = Class [148] 
.const [150] = Utf8 dataProvider 
.const [151] = Utf8 Lde/audi/atip/interapp/cartrip/ITripDataProvider; 
.const [152] = Utf8 model2DataType 
.const [153] = Utf8 Ljava/util/Map; 
.const [154] = Utf8 listener 
.const [155] = Utf8 Lde/audi/atip/interapp/cartrip/ITripListener; 
.const [156] = Utf8 Code 
.const [157] = Utf8 <init> 
.const [158] = Utf8 (Lde/audi/atip/interapp/cartrip/ITripDataProvider;)V 
.const [159] = Utf8 registerTripDataModel 
.const [160] = Utf8 (ILde/audi/atip/hmi/modelaccess/MetricsModelApp;)V 
.const [161] = Utf8 deregisterTripDataModel 
.const [162] = Utf8 (Lde/audi/atip/hmi/modelaccess/MetricsModelApp;)V 
.const [163] = Utf8 registerListener 
.const [164] = Utf8 (Lde/audi/atip/interapp/cartrip/ITripListener;)V 
.const [165] = Utf8 resetListener 
.const [166] = Utf8 ()V 
.const [167] = Utf8 updateMetricsModel 
.const [168] = Utf8 (I)V 
.end class 
