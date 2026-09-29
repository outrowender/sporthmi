.version 50 0 
.class public super [140] 
.super [142] 
.field private [143] [144] 
.field private [145] [146] 

.method public [148] : [149] 
    .attribute [147] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_3 
L3:     invokespecial [23] 
L6:     aload_0 
L7:     iconst_0 
L8:     putfield [25] 
L11:    aload_0 
L12:    iconst_0 
L13:    putfield [26] 
L16:    aload_0 
L17:    iload_2 
L18:    putfield [26] 
L21:    return 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [150] : [151] 
    .attribute [147] .code stack 7 locals 1 
L0:     aload_0 
L1:     getfield [14] 
L4:     ifle L67 
L7:     aload_2 
L8:     invokeinterface [27] 0 
L13:    invokeinterface [28] 0 
L18:    iload_1 
L19:    iadd 
L20:    istore_3 
L21:    aload_0 
L22:    invokevirtual [16] 
L25:    ldc [2] 
L27:    ldc [3] 
L29:    aload_0 
L30:    getfield [14] 
L33:    i2l 
L34:    iload_3 
L35:    i2l 
L36:    invokevirtual [17] 
L39:    pop 
L40:    aload_0 
L41:    invokespecial [24] 
L44:    aload_0 
L45:    getfield [14] 
L48:    iload_3 
L49:    invokeinterface [29] 0 
L54:    aload_2 
L55:    checkcast [4] 
L58:    invokevirtual [18] 
L61:    iload_3 
L62:    invokevirtual [19] 
L65:    iconst_1 
L66:    areturn 
L67:    iconst_0 
L68:    areturn 
L69:    nop 
L70:    nop 
L71:    nop 
L72:    
    .end code 
.end method 

.method public [152] : [153] 
    .attribute [147] .code stack 5 locals 0 
L0:     aload_0 
L1:     invokevirtual [16] 
L4:     invokevirtual [20] 
L7:     ifeq L29 
L10:    aload_0 
L11:    invokevirtual [16] 
L14:    ldc [2] 
L16:    ldc [5] 
L18:    aload_2 
L19:    invokeinterface [30] 0 
L24:    i2l 
L25:    invokevirtual [21] 
L28:    pop 
L29:    aload_0 
L30:    getfield [15] 
L33:    ifeq L46 
L36:    aload_0 
L37:    invokespecial [24] 
L40:    iconst_1 
L41:    invokeinterface [31] 0 
L46:    aload_2 
L47:    invokeinterface [32] 0 
L52:    iconst_1 
L53:    areturn 
L54:    nop 
L55:    nop 
L56:    
    .end code 
.end method 

.method private [154] : [155] 
    .attribute [147] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokevirtual [22] 
L4:     checkcast [6] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public [156] : [157] 
    .attribute [147] .code stack 2 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     putfield [25] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [158] : [159] 
    .attribute [147] .code stack 2 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     putfield [26] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int 1078071040 
.const [3] = String [33] 
.const [4] = Class [34] 
.const [5] = String [35] 
.const [6] = Class [36] 
.const [7] = Class [37] 
.const [8] = Class [38] 
.const [9] = Class [39] 
.const [10] = Class [40] 
.const [11] = Class [41] 
.const [12] = Class [42] 
.const [13] = Class [43] 
.const [14] = Field [44] [45] 
.const [15] = Field [46] [47] 
.const [16] = Method [48] [49] 
.const [17] = Method [50] [51] 
.const [18] = Method [52] [53] 
.const [19] = Method [54] [55] 
.const [20] = Method [56] [57] 
.const [21] = Method [58] [59] 
.const [22] = Method [60] [61] 
.const [23] = Method [62] [63] 
.const [24] = Method [64] [65] 
.const [25] = Field [66] [67] 
.const [26] = Field [68] [69] 
.const [27] = InterfaceMethod [70] [71] 
.const [28] = InterfaceMethod [72] [73] 
.const [29] = InterfaceMethod [74] [75] 
.const [30] = InterfaceMethod [76] [77] 
.const [31] = InterfaceMethod [78] [79] 
.const [32] = InterfaceMethod [80] [81] 
.const [33] = Utf8 '[IntLightIndividualBrightnessRangeBusiness] dsi.setIntLightIlluminationSet: %1 value = %2' 
.const [34] = Utf8 de/audi/app/car/core/light/IntLightIndividualRangeModelHandler 
.const [35] = Utf8 '[IntLightIndividualBrightnessRangeBusiness#processKeyPressed] Key has been pressd for modelID = %1' 
.const [36] = Utf8 org/dsi/ifc/carlight/DSICarLight 
.const [37] = Utf8 de/audi/app/car/core/light/IntLightIndividualBrightnessRangeBusiness 
.const [38] = Utf8 de/audi/app/car/common/handler/business/RangeModelEventBusinessAdapter 
.const [39] = Utf8 de/audi/app/car/common/handler/RangeModelHandler 
.const [40] = Utf8 de/audi/atip/hmi/modelaccess/RangeModelApp 
.const [41] = Utf8 de/audi/atip/log/LogChannel 
.const [42] = Utf8 de/audi/app/car/core/app/RangeModelWatcherTimer 
.const [43] = Utf8 de/audi/app/car/common/handler/ButtonModelHandler 
.const [44] = Class [82] 
.const [45] = NameAndType [83] [84] 
.const [46] = Class [85] 
.const [47] = NameAndType [86] [87] 
.const [48] = Class [88] 
.const [49] = NameAndType [89] [90] 
.const [50] = Class [91] 
.const [51] = NameAndType [92] [93] 
.const [52] = Class [94] 
.const [53] = NameAndType [95] [96] 
.const [54] = Class [97] 
.const [55] = NameAndType [98] [99] 
.const [56] = Class [100] 
.const [57] = NameAndType [101] [102] 
.const [58] = Class [103] 
.const [59] = NameAndType [104] [105] 
.const [60] = Class [106] 
.const [61] = NameAndType [107] [108] 
.const [62] = Class [109] 
.const [63] = NameAndType [110] [111] 
.const [64] = Class [112] 
.const [65] = NameAndType [113] [114] 
.const [66] = Class [115] 
.const [67] = NameAndType [116] [117] 
.const [68] = Class [118] 
.const [69] = NameAndType [119] [120] 
.const [70] = Class [121] 
.const [71] = NameAndType [122] [123] 
.const [72] = Class [124] 
.const [73] = NameAndType [125] [126] 
.const [74] = Class [127] 
.const [75] = NameAndType [128] [129] 
.const [76] = Class [130] 
.const [77] = NameAndType [131] [132] 
.const [78] = Class [133] 
.const [79] = NameAndType [134] [135] 
.const [80] = Class [136] 
.const [81] = NameAndType [137] [138] 
.const [82] = Utf8 de/audi/app/car/core/light/IntLightIndividualBrightnessRangeBusiness 
.const [83] = Utf8 illuminationSetNumber 
.const [84] = Utf8 I 
.const [85] = Utf8 de/audi/app/car/core/light/IntLightIndividualBrightnessRangeBusiness 
.const [86] = Utf8 profileMode 
.const [87] = Utf8 Z 
.const [88] = Utf8 de/audi/app/car/core/light/IntLightIndividualBrightnessRangeBusiness 
.const [89] = Utf8 getLogChannel 
.const [90] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [91] = Utf8 de/audi/atip/log/LogChannel 
.const [92] = Utf8 log 
.const [93] = Utf8 (ILjava/lang/String;JJ)Z 
.const [94] = Utf8 de/audi/app/car/core/light/IntLightIndividualRangeModelHandler 
.const [95] = Utf8 getModelWatcherTimer 
.const [96] = Utf8 ()Lde/audi/app/car/core/app/RangeModelWatcherTimer; 
.const [97] = Utf8 de/audi/app/car/core/app/RangeModelWatcherTimer 
.const [98] = Utf8 setTempValue 
.const [99] = Utf8 (I)V 
.const [100] = Utf8 de/audi/atip/log/LogChannel 
.const [101] = Utf8 isInfo 
.const [102] = Utf8 ()Z 
.const [103] = Utf8 de/audi/atip/log/LogChannel 
.const [104] = Utf8 log 
.const [105] = Utf8 (ILjava/lang/String;J)Z 
.const [106] = Utf8 de/audi/app/car/core/light/IntLightIndividualBrightnessRangeBusiness 
.const [107] = Utf8 getDSI 
.const [108] = Utf8 ()Lorg/dsi/ifc/base/DSIBase; 
.const [109] = Utf8 de/audi/app/car/common/handler/business/RangeModelEventBusinessAdapter 
.const [110] = Utf8 <init> 
.const [111] = Utf8 (Lorg/dsi/ifc/base/DSIBase;Lde/audi/atip/log/LogChannel;)V 
.const [112] = Utf8 de/audi/app/car/core/light/IntLightIndividualBrightnessRangeBusiness 
.const [113] = Utf8 getDSICarLight 
.const [114] = Utf8 ()Lorg/dsi/ifc/carlight/DSICarLight; 
.const [115] = Utf8 de/audi/app/car/core/light/IntLightIndividualBrightnessRangeBusiness 
.const [116] = Utf8 illuminationSetNumber 
.const [117] = Utf8 I 
.const [118] = Utf8 de/audi/app/car/core/light/IntLightIndividualBrightnessRangeBusiness 
.const [119] = Utf8 profileMode 
.const [120] = Utf8 Z 
.const [121] = Utf8 de/audi/app/car/common/handler/RangeModelHandler 
.const [122] = Utf8 getRangeModel 
.const [123] = Utf8 ()Lde/audi/atip/hmi/modelaccess/RangeModelApp; 
.const [124] = Utf8 de/audi/atip/hmi/modelaccess/RangeModelApp 
.const [125] = Utf8 getValue 
.const [126] = Utf8 ()I 
.const [127] = Utf8 org/dsi/ifc/carlight/DSICarLight 
.const [128] = Utf8 setIntLightIlluminationSet 
.const [129] = Utf8 (II)V 
.const [130] = Utf8 de/audi/app/car/common/handler/ButtonModelHandler 
.const [131] = Utf8 getHandledModelID 
.const [132] = Utf8 ()I 
.const [133] = Utf8 org/dsi/ifc/carlight/DSICarLight 
.const [134] = Utf8 setIntLightActiveProfile 
.const [135] = Utf8 (I)V 
.const [136] = Utf8 de/audi/app/car/common/handler/ButtonModelHandler 
.const [137] = Utf8 fireEvent 
.const [138] = Utf8 ()V 
.const [139] = Utf8 de/audi/app/car/core/light/IntLightIndividualBrightnessRangeBusiness 
.const [140] = Class [139] 
.const [141] = Utf8 de/audi/app/car/common/handler/business/RangeModelEventBusinessAdapter 
.const [142] = Class [141] 
.const [143] = Utf8 illuminationSetNumber 
.const [144] = Utf8 I 
.const [145] = Utf8 profileMode 
.const [146] = Utf8 Z 
.const [147] = Utf8 Code 
.const [148] = Utf8 <init> 
.const [149] = Utf8 (Lorg/dsi/ifc/base/DSIBase;ZLde/audi/atip/log/LogChannel;)V 
.const [150] = Utf8 processAdjustment 
.const [151] = Utf8 (ILde/audi/app/car/common/handler/RangeModelHandler;)Z 
.const [152] = Utf8 processKeyPressed 
.const [153] = Utf8 (ILde/audi/app/car/common/handler/ButtonModelHandler;)Z 
.const [154] = Utf8 getDSICarLight 
.const [155] = Utf8 ()Lorg/dsi/ifc/carlight/DSICarLight; 
.const [156] = Utf8 setIlluminationSetNumber 
.const [157] = Utf8 (I)V 
.const [158] = Utf8 setProfilesMode 
.const [159] = Utf8 (Z)V 
.end class 
