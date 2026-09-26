.version 50 0 
.class public super [145] 
.super [147] 
.field private [148] [149] 
.field private [150] [151] 
.field private [152] [153] 

.method public [155] : [156] 
    .attribute [154] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [22] 
L4:     aload_0 
L5:     fconst_0 
L6:     putfield [26] 
L9:     aload_0 
L10:    iconst_0 
L11:    newarray float 
L13:    putfield [27] 
L16:    return 
L17:    nop 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method private [157] : [158] 
    .attribute [154] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [14] 
L4:     ifnonnull L8 
L7:     return 
L8:     aload_0 
L9:     getfield [14] 
L12:    instanceof [2] 
L15:    ifeq L29 
L18:    aload_0 
L19:    aload_0 
L20:    getfield [14] 
L23:    checkcast [2] 
L26:    invokespecial [23] 
L29:    return 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method private [159] : [160] 
    .attribute [154] .code stack 4 locals 0 
L0:     aload_0 
L1:     invokespecial [24] 
L4:     aload_0 
L5:     ldc [3] 
L7:     aload_1 
L8:     invokeinterface [28] 0 
L13:    aload_1 
L14:    invokeinterface [29] 0 
L19:    isub 
L20:    i2f 
L21:    fmul 
L22:    aload_1 
L23:    invokeinterface [30] 0 
L28:    aload_1 
L29:    invokeinterface [29] 0 
L34:    isub 
L35:    i2f 
L36:    fdiv 
L37:    invokevirtual [15] 
L40:    return 
L41:    nop 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 

.method private [161] : [162] 
    .attribute [154] .code stack 2 locals 0 
L0:     aload_0 
L1:     iconst_0 
L2:     newarray float 
L4:     putfield [27] 
L7:     return 
L8:     
    .end code 
.end method 

.method public [163] : [164] 
    .attribute [154] .code stack 5 locals 1 
L0:     aload_1 
L1:     invokevirtual [16] 
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
L38:    invokevirtual [17] 
L41:    goto L57 
L44:    getstatic [4] 
L47:    ldc [5] 
L49:    ldc [6] 
L51:    iload_2 
L52:    i2l 
L53:    invokevirtual [18] 
L56:    pop 
L57:    return 
L58:    nop 
L59:    nop 
L60:    
    .end code 
.end method 

.method public interface [165] : [166] 
    .attribute [154] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [12] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [167] : [168] 
    .attribute [154] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [13] 
L4:     arraylength 
L5:     areturn 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [169] : [170] 
    .attribute [154] .code stack 2 locals 0 
L0:     aload_0 
L1:     fload_1 
L2:     putfield [26] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [171] : [172] 
    .attribute [154] .code stack 2 locals 0 
L0:     aload_1 
L1:     ifnonnull L8 
L4:     iconst_0 
L5:     newarray float 
L7:     astore_1 
L8:     aload_0 
L9:     aload_1 
L10:    putfield [27] 
L13:    return 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [173] : [174] 
    .attribute [154] .code stack 7 locals 0 
L0:     iload_1 
L1:     ifge L12 
L4:     iload_1 
L5:     aload_0 
L6:     invokevirtual [19] 
L9:     if_icmpge L19 
L12:    aload_0 
L13:    getfield [13] 
L16:    iload_1 
L17:    faload 
L18:    areturn 
L19:    getstatic [4] 
L22:    ldc [5] 
L24:    ldc [7] 
L26:    iload_1 
L27:    i2l 
L28:    aload_0 
L29:    invokevirtual [19] 
L32:    i2l 
L33:    invokevirtual [20] 
L36:    pop 
L37:    fconst_0 
L38:    areturn 
L39:    nop 
L40:    
    .end code 
.end method 

.method public [175] : [176] 
    .attribute [154] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [31] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [177] : [178] 
    .attribute [154] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [21] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [32] 
.const [3] = Int 51266 
.const [4] = Field [33] [34] 
.const [5] = Int -1601830656 
.const [6] = String [35] 
.const [7] = String [36] 
.const [8] = Class [37] 
.const [9] = Class [38] 
.const [10] = Class [39] 
.const [11] = Class [40] 
.const [12] = Field [41] [42] 
.const [13] = Field [43] [44] 
.const [14] = Field [45] [46] 
.const [15] = Method [47] [48] 
.const [16] = Method [49] [50] 
.const [17] = Method [51] [52] 
.const [18] = Method [53] [54] 
.const [19] = Method [55] [56] 
.const [20] = Method [57] [58] 
.const [21] = Field [59] [60] 
.const [22] = Method [61] [62] 
.const [23] = Method [63] [64] 
.const [24] = Method [65] [66] 
.const [25] = Method [67] [68] 
.const [26] = Field [69] [70] 
.const [27] = Field [71] [72] 
.const [28] = InterfaceMethod [73] [74] 
.const [29] = InterfaceMethod [75] [76] 
.const [30] = InterfaceMethod [77] [78] 
.const [31] = Field [79] [80] 
.const [32] = Utf8 de/audi/atip/hmi/modelaccess/RangeModelGUI 
.const [33] = Class [81] 
.const [34] = NameAndType [82] [83] 
.const [35] = Utf8 'CircularGaugeController#processModelUpdateEvent untreated updateType: %1' 
.const [36] = Utf8 'CircularGaugeController#getPeakPercentageValue: peak index out of bounds: %1 (peak count = %2)' 
.const [37] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/sport/CircularGaugeController 
.const [38] = Utf8 de/esolutions/hmi/widgets/audi/base/widgets/AbstractWidgetController 
.const [39] = Utf8 de/audi/atip/hmi/event/ModelUpdateEvent 
.const [40] = Utf8 de/audi/atip/log/LogChannel 
.const [41] = Class [84] 
.const [42] = NameAndType [85] [86] 
.const [43] = Class [87] 
.const [44] = NameAndType [88] [89] 
.const [45] = Class [90] 
.const [46] = NameAndType [91] [92] 
.const [47] = Class [93] 
.const [48] = NameAndType [94] [95] 
.const [49] = Class [96] 
.const [50] = NameAndType [97] [98] 
.const [51] = Class [99] 
.const [52] = NameAndType [100] [101] 
.const [53] = Class [102] 
.const [54] = NameAndType [103] [104] 
.const [55] = Class [105] 
.const [56] = NameAndType [106] [107] 
.const [57] = Class [108] 
.const [58] = NameAndType [109] [110] 
.const [59] = Class [111] 
.const [60] = NameAndType [112] [113] 
.const [61] = Class [114] 
.const [62] = NameAndType [115] [116] 
.const [63] = Class [117] 
.const [64] = NameAndType [118] [119] 
.const [65] = Class [120] 
.const [66] = NameAndType [121] [122] 
.const [67] = Class [123] 
.const [68] = NameAndType [124] [125] 
.const [69] = Class [126] 
.const [70] = NameAndType [127] [128] 
.const [71] = Class [129] 
.const [72] = NameAndType [130] [131] 
.const [73] = Class [132] 
.const [74] = NameAndType [133] [134] 
.const [75] = Class [135] 
.const [76] = NameAndType [136] [137] 
.const [77] = Class [138] 
.const [78] = NameAndType [139] [140] 
.const [79] = Class [141] 
.const [80] = NameAndType [142] [143] 
.const [81] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/sport/CircularGaugeController 
.const [82] = Utf8 logChannel 
.const [83] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [84] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/sport/CircularGaugeController 
.const [85] = Utf8 sliderPercentageValue 
.const [86] = Utf8 F 
.const [87] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/sport/CircularGaugeController 
.const [88] = Utf8 peakPercentageValues 
.const [89] = Utf8 [F 
.const [90] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/sport/CircularGaugeController 
.const [91] = Utf8 model 
.const [92] = Utf8 Ljava/lang/Object; 
.const [93] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/sport/CircularGaugeController 
.const [94] = Utf8 setSliderPercentageValue 
.const [95] = Utf8 (F)V 
.const [96] = Utf8 de/audi/atip/hmi/event/ModelUpdateEvent 
.const [97] = Utf8 getUpdateType 
.const [98] = Utf8 ()I 
.const [99] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/sport/CircularGaugeController 
.const [100] = Utf8 setCompositesDirty 
.const [101] = Utf8 (Z)V 
.const [102] = Utf8 de/audi/atip/log/LogChannel 
.const [103] = Utf8 log 
.const [104] = Utf8 (ILjava/lang/String;J)Z 
.const [105] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/sport/CircularGaugeController 
.const [106] = Utf8 getPeakCount 
.const [107] = Utf8 ()I 
.const [108] = Utf8 de/audi/atip/log/LogChannel 
.const [109] = Utf8 log 
.const [110] = Utf8 (ILjava/lang/String;JJ)Z 
.const [111] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/sport/CircularGaugeController 
.const [112] = Utf8 renderer 
.const [113] = Utf8 Lde/esolutions/hmi/widgets/audi/base/widgets/IRenderer; 
.const [114] = Utf8 de/esolutions/hmi/widgets/audi/base/widgets/AbstractWidgetController 
.const [115] = Utf8 <init> 
.const [116] = Utf8 ()V 
.const [117] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/sport/CircularGaugeController 
.const [118] = Utf8 updateWithRangeModel 
.const [119] = Utf8 (Lde/audi/atip/hmi/modelaccess/RangeModelGUI;)V 
.const [120] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/sport/CircularGaugeController 
.const [121] = Utf8 clearPeaks 
.const [122] = Utf8 ()V 
.const [123] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/sport/CircularGaugeController 
.const [124] = Utf8 updateContent 
.const [125] = Utf8 ()V 
.const [126] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/sport/CircularGaugeController 
.const [127] = Utf8 sliderPercentageValue 
.const [128] = Utf8 F 
.const [129] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/sport/CircularGaugeController 
.const [130] = Utf8 peakPercentageValues 
.const [131] = Utf8 [F 
.const [132] = Utf8 de/audi/atip/hmi/modelaccess/RangeModelGUI 
.const [133] = Utf8 getValue 
.const [134] = Utf8 ()I 
.const [135] = Utf8 de/audi/atip/hmi/modelaccess/RangeModelGUI 
.const [136] = Utf8 getMinimum 
.const [137] = Utf8 ()I 
.const [138] = Utf8 de/audi/atip/hmi/modelaccess/RangeModelGUI 
.const [139] = Utf8 getMaximum 
.const [140] = Utf8 ()I 
.const [141] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/sport/CircularGaugeController 
.const [142] = Utf8 renderer 
.const [143] = Utf8 Lde/esolutions/hmi/widgets/audi/base/widgets/IRenderer; 
.const [144] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/sport/CircularGaugeController 
.const [145] = Class [144] 
.const [146] = Utf8 de/esolutions/hmi/widgets/audi/base/widgets/AbstractWidgetController 
.const [147] = Class [146] 
.const [148] = Utf8 renderer 
.const [149] = Utf8 Lde/esolutions/hmi/widgets/audi/base/widgets/IRenderer; 
.const [150] = Utf8 sliderPercentageValue 
.const [151] = Utf8 F 
.const [152] = Utf8 peakPercentageValues 
.const [153] = Utf8 [F 
.const [154] = Utf8 Code 
.const [155] = Utf8 <init> 
.const [156] = Utf8 ()V 
.const [157] = Utf8 updateContent 
.const [158] = Utf8 ()V 
.const [159] = Utf8 updateWithRangeModel 
.const [160] = Utf8 (Lde/audi/atip/hmi/modelaccess/RangeModelGUI;)V 
.const [161] = Utf8 clearPeaks 
.const [162] = Utf8 ()V 
.const [163] = Utf8 processModelUpdateEvent 
.const [164] = Utf8 (Lde/audi/atip/hmi/event/ModelUpdateEvent;)V 
.const [165] = Utf8 getSliderPercentageValue 
.const [166] = Utf8 ()F 
.const [167] = Utf8 getPeakCount 
.const [168] = Utf8 ()I 
.const [169] = Utf8 setSliderPercentageValue 
.const [170] = Utf8 (F)V 
.const [171] = Utf8 setPeakPercentageValues 
.const [172] = Utf8 ([F)V 
.const [173] = Utf8 getPeakPercentageValue 
.const [174] = Utf8 (I)F 
.const [175] = Utf8 setRenderer 
.const [176] = Utf8 (Lde/esolutions/hmi/widgets/audi/base/widgets/IRenderer;)V 
.const [177] = Utf8 getRenderer 
.const [178] = Utf8 ()Lde/esolutions/hmi/widgets/audi/base/widgets/IRenderer; 
.end class 
