.version 50 0 
.class public super [146] 
.super [148] 
.field private [149] [150] 
.field private [151] [152] 
.field private [153] [154] 

.method public [156] : [157] 
    .attribute [155] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [27] 
L4:     aload_0 
L5:     iconst_2 
L6:     putfield [30] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method private [158] : [159] 
    .attribute [155] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [16] 
L4:     ifnonnull L8 
L7:     return 
L8:     aload_0 
L9:     getfield [16] 
L12:    instanceof [2] 
L15:    ifeq L34 
L18:    aload_0 
L19:    aload_0 
L20:    getfield [16] 
L23:    checkcast [2] 
L26:    invokeinterface [31] 0 
L31:    invokespecial [28] 
L34:    return 
L35:    nop 
L36:    
    .end code 
.end method 

.method private [160] : [161] 
    .attribute [155] .code stack 4 locals 1 
L0:     aload_1 
L1:     ifnonnull L16 
L4:     getstatic [3] 
L7:     ldc [4] 
L9:     ldc [5] 
L11:    invokevirtual [17] 
L14:    pop 
L15:    return 
L16:    aload_1 
L17:    instanceof [6] 
L20:    ifne L36 
L23:    getstatic [3] 
L26:    ldc [4] 
L28:    ldc [7] 
L30:    aload_1 
L31:    invokevirtual [18] 
L34:    pop 
L35:    return 
L36:    aload_1 
L37:    checkcast [6] 
L40:    astore_2 
L41:    aload_2 
L42:    invokevirtual [19] 
L45:    lookupswitch 
            1 : L72 
            2 : L72 
            default : L91 

L72:    aload_0 
L73:    aload_2 
L74:    invokevirtual [19] 
L77:    aload_2 
L78:    aload_2 
L79:    invokevirtual [19] 
L82:    invokevirtual [20] 
L85:    invokevirtual [21] 
L88:    goto L107 
L91:    getstatic [3] 
L94:    ldc [4] 
L96:    ldc [8] 
L98:    aload_1 
L99:    invokevirtual [22] 
L102:   invokevirtual [18] 
L105:   pop 
L106:   return 
L107:   return 
L108:   
    .end code 
.end method 

.method public [162] : [163] 
    .attribute [155] .code stack 4 locals 0 
L0:     aload_1 
L1:     invokevirtual [23] 
L4:     lookupswitch 
            1 : L32 
            13 : L32 
            default : L44 

L32:    aload_0 
L33:    invokespecial [29] 
L36:    aload_0 
L37:    iconst_1 
L38:    invokevirtual [24] 
L41:    goto L56 
L44:    getstatic [3] 
L47:    ldc [4] 
L49:    ldc [9] 
L51:    aload_1 
L52:    invokevirtual [18] 
L55:    pop 
L56:    return 
L57:    nop 
L58:    nop 
L59:    nop 
L60:    
    .end code 
.end method 

.method public [164] : [165] 
    .attribute [155] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [32] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [166] : [167] 
    .attribute [155] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [25] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [168] : [169] 
    .attribute [155] .code stack 2 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     putfield [30] 
L5:     aload_0 
L6:     fload_2 
L7:     putfield [33] 
L10:    return 
L11:    nop 
L12:    
    .end code 
.end method 

.method public interface [170] : [171] 
    .attribute [155] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [15] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [172] : [173] 
    .attribute [155] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [26] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [34] 
.const [3] = Field [35] [36] 
.const [4] = Int -1601830656 
.const [5] = String [37] 
.const [6] = Class [38] 
.const [7] = String [39] 
.const [8] = String [40] 
.const [9] = String [41] 
.const [10] = Class [42] 
.const [11] = Class [43] 
.const [12] = Class [44] 
.const [13] = Class [45] 
.const [14] = Class [46] 
.const [15] = Field [47] [48] 
.const [16] = Field [49] [50] 
.const [17] = Method [51] [52] 
.const [18] = Method [53] [54] 
.const [19] = Method [55] [56] 
.const [20] = Method [57] [58] 
.const [21] = Method [59] [60] 
.const [22] = Method [61] [62] 
.const [23] = Method [63] [64] 
.const [24] = Method [65] [66] 
.const [25] = Field [67] [68] 
.const [26] = Field [69] [70] 
.const [27] = Method [71] [72] 
.const [28] = Method [73] [74] 
.const [29] = Method [75] [76] 
.const [30] = Field [77] [78] 
.const [31] = InterfaceMethod [79] [80] 
.const [32] = Field [81] [82] 
.const [33] = Field [83] [84] 
.const [34] = Utf8 de/audi/atip/hmi/modelaccess/MetricsModelGUI 
.const [35] = Class [85] 
.const [36] = NameAndType [86] [87] 
.const [37] = Utf8 'OilTemperatureGaugeController#updateWithMetrics: metric is null' 
.const [38] = Utf8 de/audi/atip/metrics/Temperature 
.const [39] = Utf8 'OilTemperatureGaugeController#updateWithMetrics: metric must be Temperature: %1' 
.const [40] = Utf8 'Unsupported temperature unit: %1' 
.const [41] = Utf8 'OilTemperatureGaugeController#processModelUpdateEvent: ignore model update event (%1) here' 
.const [42] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/sport/OilTemperatureGaugeController 
.const [43] = Utf8 de/esolutions/hmi/widgets/audi/base/widgets/AbstractWidgetController 
.const [44] = Utf8 de/audi/atip/log/LogChannel 
.const [45] = Utf8 de/audi/atip/metrics/AbstractMetrics 
.const [46] = Utf8 de/audi/atip/hmi/event/ModelUpdateEvent 
.const [47] = Class [88] 
.const [48] = NameAndType [89] [90] 
.const [49] = Class [91] 
.const [50] = NameAndType [92] [93] 
.const [51] = Class [94] 
.const [52] = NameAndType [95] [96] 
.const [53] = Class [97] 
.const [54] = NameAndType [98] [99] 
.const [55] = Class [100] 
.const [56] = NameAndType [101] [102] 
.const [57] = Class [103] 
.const [58] = NameAndType [104] [105] 
.const [59] = Class [106] 
.const [60] = NameAndType [107] [108] 
.const [61] = Class [109] 
.const [62] = NameAndType [110] [111] 
.const [63] = Class [112] 
.const [64] = NameAndType [113] [114] 
.const [65] = Class [115] 
.const [66] = NameAndType [116] [117] 
.const [67] = Class [118] 
.const [68] = NameAndType [119] [120] 
.const [69] = Class [121] 
.const [70] = NameAndType [122] [123] 
.const [71] = Class [124] 
.const [72] = NameAndType [125] [126] 
.const [73] = Class [127] 
.const [74] = NameAndType [128] [129] 
.const [75] = Class [130] 
.const [76] = NameAndType [131] [132] 
.const [77] = Class [133] 
.const [78] = NameAndType [134] [135] 
.const [79] = Class [136] 
.const [80] = NameAndType [137] [138] 
.const [81] = Class [139] 
.const [82] = NameAndType [140] [141] 
.const [83] = Class [142] 
.const [84] = NameAndType [143] [144] 
.const [85] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/sport/OilTemperatureGaugeController 
.const [86] = Utf8 logChannel 
.const [87] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [88] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/sport/OilTemperatureGaugeController 
.const [89] = Utf8 temperatureUnit 
.const [90] = Utf8 I 
.const [91] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/sport/OilTemperatureGaugeController 
.const [92] = Utf8 model 
.const [93] = Utf8 Ljava/lang/Object; 
.const [94] = Utf8 de/audi/atip/log/LogChannel 
.const [95] = Utf8 log 
.const [96] = Utf8 (ILjava/lang/String;)Z 
.const [97] = Utf8 de/audi/atip/log/LogChannel 
.const [98] = Utf8 log 
.const [99] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [100] = Utf8 de/audi/atip/metrics/Temperature 
.const [101] = Utf8 getUnit 
.const [102] = Utf8 ()I 
.const [103] = Utf8 de/audi/atip/metrics/Temperature 
.const [104] = Utf8 getValue 
.const [105] = Utf8 (I)F 
.const [106] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/sport/OilTemperatureGaugeController 
.const [107] = Utf8 setTemperatureValues 
.const [108] = Utf8 (IF)V 
.const [109] = Utf8 de/audi/atip/metrics/AbstractMetrics 
.const [110] = Utf8 getFormattedMetricUnit 
.const [111] = Utf8 ()Ljava/lang/String; 
.const [112] = Utf8 de/audi/atip/hmi/event/ModelUpdateEvent 
.const [113] = Utf8 getUpdateType 
.const [114] = Utf8 ()I 
.const [115] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/sport/OilTemperatureGaugeController 
.const [116] = Utf8 setCompositesDirty 
.const [117] = Utf8 (Z)V 
.const [118] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/sport/OilTemperatureGaugeController 
.const [119] = Utf8 renderer 
.const [120] = Utf8 Lde/esolutions/hmi/widgets/audi/base/widgets/IRenderer; 
.const [121] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/sport/OilTemperatureGaugeController 
.const [122] = Utf8 temperature 
.const [123] = Utf8 F 
.const [124] = Utf8 de/esolutions/hmi/widgets/audi/base/widgets/AbstractWidgetController 
.const [125] = Utf8 <init> 
.const [126] = Utf8 ()V 
.const [127] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/sport/OilTemperatureGaugeController 
.const [128] = Utf8 updateWithMetrics 
.const [129] = Utf8 (Lde/audi/atip/metrics/AbstractMetrics;)V 
.const [130] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/sport/OilTemperatureGaugeController 
.const [131] = Utf8 updateContent 
.const [132] = Utf8 ()V 
.const [133] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/sport/OilTemperatureGaugeController 
.const [134] = Utf8 temperatureUnit 
.const [135] = Utf8 I 
.const [136] = Utf8 de/audi/atip/hmi/modelaccess/MetricsModelGUI 
.const [137] = Utf8 getMetric 
.const [138] = Utf8 ()Lde/audi/atip/metrics/AbstractMetrics; 
.const [139] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/sport/OilTemperatureGaugeController 
.const [140] = Utf8 renderer 
.const [141] = Utf8 Lde/esolutions/hmi/widgets/audi/base/widgets/IRenderer; 
.const [142] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/sport/OilTemperatureGaugeController 
.const [143] = Utf8 temperature 
.const [144] = Utf8 F 
.const [145] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/sport/OilTemperatureGaugeController 
.const [146] = Class [145] 
.const [147] = Utf8 de/esolutions/hmi/widgets/audi/base/widgets/AbstractWidgetController 
.const [148] = Class [147] 
.const [149] = Utf8 temperature 
.const [150] = Utf8 F 
.const [151] = Utf8 temperatureUnit 
.const [152] = Utf8 I 
.const [153] = Utf8 renderer 
.const [154] = Utf8 Lde/esolutions/hmi/widgets/audi/base/widgets/IRenderer; 
.const [155] = Utf8 Code 
.const [156] = Utf8 <init> 
.const [157] = Utf8 ()V 
.const [158] = Utf8 updateContent 
.const [159] = Utf8 ()V 
.const [160] = Utf8 updateWithMetrics 
.const [161] = Utf8 (Lde/audi/atip/metrics/AbstractMetrics;)V 
.const [162] = Utf8 processModelUpdateEvent 
.const [163] = Utf8 (Lde/audi/atip/hmi/event/ModelUpdateEvent;)V 
.const [164] = Utf8 setRenderer 
.const [165] = Utf8 (Lde/esolutions/hmi/widgets/audi/base/widgets/IRenderer;)V 
.const [166] = Utf8 getRenderer 
.const [167] = Utf8 ()Lde/esolutions/hmi/widgets/audi/base/widgets/IRenderer; 
.const [168] = Utf8 setTemperatureValues 
.const [169] = Utf8 (IF)V 
.const [170] = Utf8 getTemperatureUnit 
.const [171] = Utf8 ()I 
.const [172] = Utf8 getTemperature 
.const [173] = Utf8 ()F 
.end class 
