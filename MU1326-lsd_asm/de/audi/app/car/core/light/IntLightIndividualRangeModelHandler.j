.version 50 0 
.class public super [125] 
.super [127] 
.field private [128] [129] 
.field private static final [130] [131] 

.method protected [133] : [134] 
    .attribute [132] .code stack 8 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     invokespecial [18] 
L6:     aload_0 
L7:     new [22] 
L10:    dup 
L11:    ldc [3] 
L13:    aload_1 
L14:    ldc_w [1] 
L17:    aload_2 
L18:    invokespecial [19] 
L21:    putfield [23] 
L24:    return 
L25:    nop 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [135] : [136] 
    .attribute [132] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokevirtual [12] 
L4:     ifnull L19 
L7:     aload_0 
L8:     invokevirtual [13] 
L11:    iload_1 
L12:    aload_0 
L13:    invokeinterface [24] 0 
L18:    pop 
L19:    return 
L20:    
    .end code 
.end method 

.method public [137] : [138] 
    .attribute [132] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokevirtual [12] 
L4:     ifnull L19 
L7:     aload_0 
L8:     invokevirtual [13] 
L11:    iload_1 
L12:    aload_0 
L13:    invokeinterface [25] 0 
L18:    pop 
L19:    return 
L20:    
    .end code 
.end method 

.method public [139] : [140] 
    .attribute [132] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokevirtual [12] 
L4:     ifnull L19 
L7:     aload_0 
L8:     invokevirtual [13] 
L11:    iload_1 
L12:    aload_0 
L13:    invokeinterface [26] 0 
L18:    pop 
L19:    return 
L20:    
    .end code 
.end method 

.method public [141] : [142] 
    .attribute [132] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokevirtual [12] 
L4:     ifnull L19 
L7:     aload_0 
L8:     invokevirtual [13] 
L11:    iload_1 
L12:    aload_0 
L13:    invokeinterface [27] 0 
L18:    pop 
L19:    return 
L20:    
    .end code 
.end method 

.method public [143] : [144] 
    .attribute [132] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [11] 
L4:     aload_0 
L5:     iload_1 
L6:     invokespecial [20] 
L9:     invokevirtual [14] 
L12:    return 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public interface [145] : [146] 
    .attribute [132] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [11] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method private [147] : [148] 
    .attribute [132] .code stack 7 locals 3 
L0:     aload_0 
L1:     invokevirtual [15] 
L4:     invokeinterface [28] 0 
L9:     istore_2 
L10:    iload_1 
L11:    istore_3 
L12:    iload_2 
L13:    ifle L56 
L16:    aload_0 
L17:    invokespecial [21] 
L20:    ifeq L56 
L23:    iload_1 
L24:    iload_2 
L25:    irem 
L26:    istore 4 
L28:    iload 4 
L30:    ifle L56 
L33:    iload_1 
L34:    iload_2 
L35:    iadd 
L36:    iload 4 
L38:    isub 
L39:    istore_3 
L40:    aload_0 
L41:    invokevirtual [16] 
L44:    ldc [4] 
L46:    ldc [5] 
L48:    iload_1 
L49:    i2l 
L50:    iload_3 
L51:    i2l 
L52:    invokevirtual [17] 
L55:    pop 
L56:    iload_3 
L57:    areturn 
L58:    nop 
L59:    nop 
L60:    
    .end code 
.end method 

.method private [149] : [150] 
    .attribute [132] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokevirtual [15] 
L4:     invokeinterface [28] 0 
L9:     bipush 20 
L11:    if_icmpne L18 
L14:    iconst_1 
L15:    goto L19 
L18:    iconst_0 
L19:    areturn 
L20:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [30] 
.const [3] = String [31] 
.const [4] = Int 1078071040 
.const [5] = String [32] 
.const [6] = Class [33] 
.const [7] = Class [34] 
.const [8] = Class [35] 
.const [9] = Class [36] 
.const [10] = Class [37] 
.const [11] = Field [38] [39] 
.const [12] = Method [40] [41] 
.const [13] = Method [42] [43] 
.const [14] = Method [44] [45] 
.const [15] = Method [46] [47] 
.const [16] = Method [48] [49] 
.const [17] = Method [50] [51] 
.const [18] = Method [52] [53] 
.const [19] = Method [54] [55] 
.const [20] = Method [56] [57] 
.const [21] = Method [58] [59] 
.const [22] = Class [60] 
.const [23] = Field [61] [62] 
.const [24] = InterfaceMethod [63] [64] 
.const [25] = InterfaceMethod [65] [66] 
.const [26] = InterfaceMethod [67] [68] 
.const [27] = InterfaceMethod [69] [70] 
.const [28] = InterfaceMethod [71] [72] 
.const [29] = Int -402456576 
.const [30] = Utf8 de/audi/app/car/core/app/RangeModelWatcherTimer 
.const [31] = Utf8 '' 
.const [32] = Utf8 '[IntLightIndividualRangeModelHandler#ceilToValidBrightness] Brightness value of %1 is not a multiple of the step width. Round up to next valid value: %2' 
.const [33] = Utf8 de/audi/app/car/core/light/IntLightIndividualRangeModelHandler 
.const [34] = Utf8 de/audi/app/car/common/handler/RangeModelHandlerAdapter 
.const [35] = Utf8 de/audi/app/car/common/handler/business/RangeModelEventBusiness 
.const [36] = Utf8 de/audi/atip/hmi/modelaccess/RangeModelApp 
.const [37] = Utf8 de/audi/atip/log/LogChannel 
.const [38] = Class [73] 
.const [39] = NameAndType [74] [75] 
.const [40] = Class [76] 
.const [41] = NameAndType [77] [78] 
.const [42] = Class [79] 
.const [43] = NameAndType [80] [81] 
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
.const [60] = Utf8 de/audi/app/car/core/app/RangeModelWatcherTimer 
.const [61] = Class [106] 
.const [62] = NameAndType [107] [108] 
.const [63] = Class [109] 
.const [64] = NameAndType [110] [111] 
.const [65] = Class [112] 
.const [66] = NameAndType [113] [114] 
.const [67] = Class [115] 
.const [68] = NameAndType [116] [117] 
.const [69] = Class [118] 
.const [70] = NameAndType [119] [120] 
.const [71] = Class [121] 
.const [72] = NameAndType [122] [123] 
.const [73] = Utf8 de/audi/app/car/core/light/IntLightIndividualRangeModelHandler 
.const [74] = Utf8 watchedModelTimer 
.const [75] = Utf8 Lde/audi/app/car/core/app/RangeModelWatcherTimer; 
.const [76] = Utf8 de/audi/app/car/core/light/IntLightIndividualRangeModelHandler 
.const [77] = Utf8 getBusiness 
.const [78] = Utf8 ()Lde/audi/app/car/common/handler/business/ModelEventBusiness; 
.const [79] = Utf8 de/audi/app/car/core/light/IntLightIndividualRangeModelHandler 
.const [80] = Utf8 getRangeEventBusiness 
.const [81] = Utf8 ()Lde/audi/app/car/common/handler/business/RangeModelEventBusiness; 
.const [82] = Utf8 de/audi/app/car/core/app/RangeModelWatcherTimer 
.const [83] = Utf8 setValidValue 
.const [84] = Utf8 (I)V 
.const [85] = Utf8 de/audi/app/car/core/light/IntLightIndividualRangeModelHandler 
.const [86] = Utf8 getRangeModel 
.const [87] = Utf8 ()Lde/audi/atip/hmi/modelaccess/RangeModelApp; 
.const [88] = Utf8 de/audi/app/car/core/light/IntLightIndividualRangeModelHandler 
.const [89] = Utf8 getLogChannel 
.const [90] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [91] = Utf8 de/audi/atip/log/LogChannel 
.const [92] = Utf8 log 
.const [93] = Utf8 (ILjava/lang/String;JJ)Z 
.const [94] = Utf8 de/audi/app/car/common/handler/RangeModelHandlerAdapter 
.const [95] = Utf8 <init> 
.const [96] = Utf8 (Lde/audi/atip/hmi/modelaccess/RangeModelApp;Lde/audi/atip/log/LogChannel;)V 
.const [97] = Utf8 de/audi/app/car/core/app/RangeModelWatcherTimer 
.const [98] = Utf8 <init> 
.const [99] = Utf8 (Ljava/lang/String;Lde/audi/atip/hmi/modelaccess/RangeModelApp;JLde/audi/atip/log/LogChannel;)V 
.const [100] = Utf8 de/audi/app/car/core/light/IntLightIndividualRangeModelHandler 
.const [101] = Utf8 ceilToValidBrightness 
.const [102] = Utf8 (I)I 
.const [103] = Utf8 de/audi/app/car/core/light/IntLightIndividualRangeModelHandler 
.const [104] = Utf8 isCeilingRequired 
.const [105] = Utf8 ()Z 
.const [106] = Utf8 de/audi/app/car/core/light/IntLightIndividualRangeModelHandler 
.const [107] = Utf8 watchedModelTimer 
.const [108] = Utf8 Lde/audi/app/car/core/app/RangeModelWatcherTimer; 
.const [109] = Utf8 de/audi/app/car/common/handler/business/RangeModelEventBusiness 
.const [110] = Utf8 processAdjustment 
.const [111] = Utf8 (ILde/audi/app/car/common/handler/RangeModelHandler;)Z 
.const [112] = Utf8 de/audi/app/car/common/handler/business/RangeModelEventBusiness 
.const [113] = Utf8 processKeyPressed 
.const [114] = Utf8 (ILde/audi/app/car/common/handler/ButtonModelHandler;)Z 
.const [115] = Utf8 de/audi/app/car/common/handler/business/RangeModelEventBusiness 
.const [116] = Utf8 processKeyReleased 
.const [117] = Utf8 (ILde/audi/app/car/common/handler/ButtonModelHandler;)Z 
.const [118] = Utf8 de/audi/app/car/common/handler/business/RangeModelEventBusiness 
.const [119] = Utf8 processKeyTyped 
.const [120] = Utf8 (ILde/audi/app/car/common/handler/ButtonModelHandler;)Z 
.const [121] = Utf8 de/audi/atip/hmi/modelaccess/RangeModelApp 
.const [122] = Utf8 getStep 
.const [123] = Utf8 ()I 
.const [124] = Utf8 de/audi/app/car/core/light/IntLightIndividualRangeModelHandler 
.const [125] = Class [124] 
.const [126] = Utf8 de/audi/app/car/common/handler/RangeModelHandlerAdapter 
.const [127] = Class [126] 
.const [128] = Utf8 watchedModelTimer 
.const [129] = Utf8 Lde/audi/app/car/core/app/RangeModelWatcherTimer; 
.const [130] = Utf8 STEP_SIZE_OF_BRIGHTNESS_ROTARIES_IN_RIGHT_DRAWER 
.const [131] = Utf8 I 
.const [132] = Utf8 Code 
.const [133] = Utf8 <init> 
.const [134] = Utf8 (Lde/audi/atip/hmi/modelaccess/RangeModelApp;Lde/audi/atip/log/LogChannel;)V 
.const [135] = Utf8 updateOnAdjustment 
.const [136] = Utf8 (I)V 
.const [137] = Utf8 updateOnKeyPressed 
.const [138] = Utf8 (I)V 
.const [139] = Utf8 updateOnKeyReleased 
.const [140] = Utf8 (I)V 
.const [141] = Utf8 updateOnKeyTyped 
.const [142] = Utf8 (I)V 
.const [143] = Utf8 updateRangeModelValue 
.const [144] = Utf8 (I)V 
.const [145] = Utf8 getModelWatcherTimer 
.const [146] = Utf8 ()Lde/audi/app/car/core/app/RangeModelWatcherTimer; 
.const [147] = Utf8 ceilToValidBrightness 
.const [148] = Utf8 (I)I 
.const [149] = Utf8 isCeilingRequired 
.const [150] = Utf8 ()Z 
.end class 
