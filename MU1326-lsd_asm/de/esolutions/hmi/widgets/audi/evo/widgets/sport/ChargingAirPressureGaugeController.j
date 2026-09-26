.version 50 0 
.class public super [135] 
.super [137] 
.field private [138] [139] 
.field private [140] [141] 

.method public annotation [143] : [144] 
    .attribute [142] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [23] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method private [145] : [146] 
    .attribute [142] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [15] 
L4:     ifnonnull L8 
L7:     return 
L8:     aload_0 
L9:     getfield [15] 
L12:    instanceof [2] 
L15:    ifeq L29 
L18:    aload_0 
L19:    aload_0 
L20:    getfield [15] 
L23:    checkcast [2] 
L26:    invokespecial [24] 
L29:    return 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method private [147] : [148] 
    .attribute [142] .code stack 4 locals 0 
L0:     aload_0 
L1:     ldc [3] 
L3:     aload_1 
L4:     invokeinterface [26] 0 
L9:     aload_1 
L10:    invokeinterface [27] 0 
L15:    isub 
L16:    i2f 
L17:    fmul 
L18:    aload_1 
L19:    invokeinterface [28] 0 
L24:    aload_1 
L25:    invokeinterface [27] 0 
L30:    isub 
L31:    i2f 
L32:    fdiv 
L33:    invokevirtual [16] 
L36:    return 
L37:    nop 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 

.method public [149] : [150] 
    .attribute [142] .code stack 5 locals 1 
L0:     aload_1 
L1:     invokevirtual [17] 
L4:     istore_2 
L5:     iload_2 
L6:     lookupswitch 
            1 : L32 
            4 : L32 
            default : L44 

L32:    aload_0 
L33:    invokespecial [25] 
L36:    aload_0 
L37:    iconst_1 
L38:    invokevirtual [18] 
L41:    goto L57 
L44:    getstatic [4] 
L47:    ldc [5] 
L49:    ldc [6] 
L51:    iload_2 
L52:    i2l 
L53:    invokevirtual [19] 
L56:    pop 
L57:    return 
L58:    nop 
L59:    nop 
L60:    
    .end code 
.end method 

.method public [151] : [152] 
    .attribute [142] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [29] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [153] : [154] 
    .attribute [142] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [20] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [155] : [156] 
    .attribute [142] .code stack 5 locals 0 
L0:     fload_1 
L1:     fconst_0 
L2:     fcmpg 
L3:     iflt L13 
L6:     fload_1 
L7:     ldc [3] 
L9:     fcmpl 
L10:    ifle L36 
L13:    getstatic [4] 
L16:    ldc [5] 
L18:    ldc [7] 
L20:    fload_1 
L21:    f2d 
L22:    invokevirtual [21] 
L25:    fload_1 
L26:    ldc [3] 
L28:    invokestatic [8] 
L31:    fconst_0 
L32:    invokestatic [9] 
L35:    fstore_1 
L36:    aload_0 
L37:    fload_1 
L38:    putfield [30] 
L41:    return 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 

.method public interface [157] : [158] 
    .attribute [142] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [22] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [31] 
.const [3] = Int 51266 
.const [4] = Field [32] [33] 
.const [5] = Int -1601830656 
.const [6] = String [34] 
.const [7] = String [35] 
.const [8] = Method [36] [37] 
.const [9] = Method [38] [39] 
.const [10] = Class [40] 
.const [11] = Class [41] 
.const [12] = Class [42] 
.const [13] = Class [43] 
.const [14] = Class [44] 
.const [15] = Field [45] [46] 
.const [16] = Method [47] [48] 
.const [17] = Method [49] [50] 
.const [18] = Method [51] [52] 
.const [19] = Method [53] [54] 
.const [20] = Field [55] [56] 
.const [21] = Method [57] [58] 
.const [22] = Field [59] [60] 
.const [23] = Method [61] [62] 
.const [24] = Method [63] [64] 
.const [25] = Method [65] [66] 
.const [26] = InterfaceMethod [67] [68] 
.const [27] = InterfaceMethod [69] [70] 
.const [28] = InterfaceMethod [71] [72] 
.const [29] = Field [73] [74] 
.const [30] = Field [75] [76] 
.const [31] = Utf8 de/audi/atip/hmi/modelaccess/RangeModelGUI 
.const [32] = Class [77] 
.const [33] = NameAndType [78] [79] 
.const [34] = Utf8 'ChargingAirPressureGaugeController#processModelUpdateEvent untreated updateType: %1' 
.const [35] = Utf8 'ChargingAirPressureGaugeController#setAirPressurePercentageValue %1' 
.const [36] = Class [80] 
.const [37] = NameAndType [81] [82] 
.const [38] = Class [83] 
.const [39] = NameAndType [84] [85] 
.const [40] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/sport/ChargingAirPressureGaugeController 
.const [41] = Utf8 de/esolutions/hmi/widgets/audi/base/widgets/AbstractWidgetController 
.const [42] = Utf8 de/audi/atip/hmi/event/ModelUpdateEvent 
.const [43] = Utf8 de/audi/atip/log/LogChannel 
.const [44] = Utf8 java/lang/Math 
.const [45] = Class [86] 
.const [46] = NameAndType [87] [88] 
.const [47] = Class [89] 
.const [48] = NameAndType [90] [91] 
.const [49] = Class [92] 
.const [50] = NameAndType [93] [94] 
.const [51] = Class [95] 
.const [52] = NameAndType [96] [97] 
.const [53] = Class [98] 
.const [54] = NameAndType [99] [100] 
.const [55] = Class [101] 
.const [56] = NameAndType [102] [103] 
.const [57] = Class [104] 
.const [58] = NameAndType [105] [106] 
.const [59] = Class [107] 
.const [60] = NameAndType [108] [109] 
.const [61] = Class [110] 
.const [62] = NameAndType [111] [112] 
.const [63] = Class [113] 
.const [64] = NameAndType [114] [115] 
.const [65] = Class [116] 
.const [66] = NameAndType [117] [118] 
.const [67] = Class [119] 
.const [68] = NameAndType [120] [121] 
.const [69] = Class [122] 
.const [70] = NameAndType [123] [124] 
.const [71] = Class [125] 
.const [72] = NameAndType [126] [127] 
.const [73] = Class [128] 
.const [74] = NameAndType [129] [130] 
.const [75] = Class [131] 
.const [76] = NameAndType [132] [133] 
.const [77] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/sport/ChargingAirPressureGaugeController 
.const [78] = Utf8 logChannel 
.const [79] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [80] = Utf8 java/lang/Math 
.const [81] = Utf8 min 
.const [82] = Utf8 (FF)F 
.const [83] = Utf8 java/lang/Math 
.const [84] = Utf8 max 
.const [85] = Utf8 (FF)F 
.const [86] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/sport/ChargingAirPressureGaugeController 
.const [87] = Utf8 model 
.const [88] = Utf8 Ljava/lang/Object; 
.const [89] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/sport/ChargingAirPressureGaugeController 
.const [90] = Utf8 setAirPressurePercentageValue 
.const [91] = Utf8 (F)V 
.const [92] = Utf8 de/audi/atip/hmi/event/ModelUpdateEvent 
.const [93] = Utf8 getUpdateType 
.const [94] = Utf8 ()I 
.const [95] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/sport/ChargingAirPressureGaugeController 
.const [96] = Utf8 setCompositesDirty 
.const [97] = Utf8 (Z)V 
.const [98] = Utf8 de/audi/atip/log/LogChannel 
.const [99] = Utf8 log 
.const [100] = Utf8 (ILjava/lang/String;J)Z 
.const [101] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/sport/ChargingAirPressureGaugeController 
.const [102] = Utf8 renderer 
.const [103] = Utf8 Lde/esolutions/hmi/widgets/audi/base/widgets/IRenderer; 
.const [104] = Utf8 de/audi/atip/log/LogChannel 
.const [105] = Utf8 log 
.const [106] = Utf8 (ILjava/lang/String;D)V 
.const [107] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/sport/ChargingAirPressureGaugeController 
.const [108] = Utf8 airPressurePercentageValue 
.const [109] = Utf8 F 
.const [110] = Utf8 de/esolutions/hmi/widgets/audi/base/widgets/AbstractWidgetController 
.const [111] = Utf8 <init> 
.const [112] = Utf8 ()V 
.const [113] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/sport/ChargingAirPressureGaugeController 
.const [114] = Utf8 updateWithRangeModel 
.const [115] = Utf8 (Lde/audi/atip/hmi/modelaccess/RangeModelGUI;)V 
.const [116] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/sport/ChargingAirPressureGaugeController 
.const [117] = Utf8 updateContent 
.const [118] = Utf8 ()V 
.const [119] = Utf8 de/audi/atip/hmi/modelaccess/RangeModelGUI 
.const [120] = Utf8 getValue 
.const [121] = Utf8 ()I 
.const [122] = Utf8 de/audi/atip/hmi/modelaccess/RangeModelGUI 
.const [123] = Utf8 getMinimum 
.const [124] = Utf8 ()I 
.const [125] = Utf8 de/audi/atip/hmi/modelaccess/RangeModelGUI 
.const [126] = Utf8 getMaximum 
.const [127] = Utf8 ()I 
.const [128] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/sport/ChargingAirPressureGaugeController 
.const [129] = Utf8 renderer 
.const [130] = Utf8 Lde/esolutions/hmi/widgets/audi/base/widgets/IRenderer; 
.const [131] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/sport/ChargingAirPressureGaugeController 
.const [132] = Utf8 airPressurePercentageValue 
.const [133] = Utf8 F 
.const [134] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/sport/ChargingAirPressureGaugeController 
.const [135] = Class [134] 
.const [136] = Utf8 de/esolutions/hmi/widgets/audi/base/widgets/AbstractWidgetController 
.const [137] = Class [136] 
.const [138] = Utf8 renderer 
.const [139] = Utf8 Lde/esolutions/hmi/widgets/audi/base/widgets/IRenderer; 
.const [140] = Utf8 airPressurePercentageValue 
.const [141] = Utf8 F 
.const [142] = Utf8 Code 
.const [143] = Utf8 <init> 
.const [144] = Utf8 ()V 
.const [145] = Utf8 updateContent 
.const [146] = Utf8 ()V 
.const [147] = Utf8 updateWithRangeModel 
.const [148] = Utf8 (Lde/audi/atip/hmi/modelaccess/RangeModelGUI;)V 
.const [149] = Utf8 processModelUpdateEvent 
.const [150] = Utf8 (Lde/audi/atip/hmi/event/ModelUpdateEvent;)V 
.const [151] = Utf8 setRenderer 
.const [152] = Utf8 (Lde/esolutions/hmi/widgets/audi/base/widgets/IRenderer;)V 
.const [153] = Utf8 getRenderer 
.const [154] = Utf8 ()Lde/esolutions/hmi/widgets/audi/base/widgets/IRenderer; 
.const [155] = Utf8 setAirPressurePercentageValue 
.const [156] = Utf8 (F)V 
.const [157] = Utf8 getAirPressurePercentageValue 
.const [158] = Utf8 ()F 
.end class 
