.version 50 0 
.class public super [95] 
.super [97] 
.field protected static final [98] [99] 
.field protected static final [100] [101] 
.field final [102] [103] 
.field protected static final [104] [105] 
.field protected static final [106] [107] 

.method public [109] : [110] 
    .attribute [108] .code stack 3 locals 0 
L0:     aload_0 
L1:     fconst_0 
L2:     iload_1 
L3:     invokespecial [15] 
L6:     aload_0 
L7:     iconst_m1 
L8:     putfield [19] 
L11:    aload_0 
L12:    iconst_1 
L13:    invokevirtual [7] 
L16:    return 
L17:    nop 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [111] : [112] 
    .attribute [108] .code stack 3 locals 0 
L0:     aload_0 
L1:     fload_1 
L2:     iload_2 
L3:     invokespecial [15] 
L6:     aload_0 
L7:     fload_1 
L8:     f2i 
L9:     putfield [19] 
L12:    aload_0 
L13:    iconst_1 
L14:    invokevirtual [7] 
L17:    return 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [113] : [114] 
    .attribute [108] .code stack 2 locals 0 
L0:     iload_1 
L1:     bipush 11 
L3:     if_icmpne L11 
L6:     aload_0 
L7:     invokevirtual [8] 
L10:    areturn 
L11:    iload_1 
L12:    bipush 12 
L14:    if_icmpne L26 
L17:    aload_0 
L18:    aload_0 
L19:    getfield [9] 
L22:    invokevirtual [10] 
L25:    areturn 
L26:    aload_0 
L27:    iload_1 
L28:    invokespecial [16] 
L31:    areturn 
L32:    
    .end code 
.end method 

.method protected [115] : [116] 
    .attribute [108] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [6] 
L4:     iconst_m1 
L5:     if_icmpne L22 
L8:     aload_1 
L9:     invokevirtual [11] 
L12:    aload_1 
L13:    ldc [2] 
L15:    invokevirtual [12] 
L18:    pop 
L19:    goto L33 
L22:    iload_2 
L23:    ifeq L33 
L26:    aload_0 
L27:    aload_1 
L28:    iload_2 
L29:    aload_3 
L30:    invokespecial [17] 
L33:    return 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 

.method public [117] : [118] 
    .attribute [108] .code stack 2 locals 0 
L0:     aload_0 
L1:     iconst_1 
L2:     invokespecial [18] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [119] : [120] 
    .attribute [108] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_0 
L2:     invokevirtual [13] 
L5:     invokevirtual [14] 
L8:     areturn 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [20] 
.const [3] = Class [21] 
.const [4] = Class [22] 
.const [5] = Class [23] 
.const [6] = Field [24] [25] 
.const [7] = Method [26] [27] 
.const [8] = Method [28] [29] 
.const [9] = Field [30] [31] 
.const [10] = Method [32] [33] 
.const [11] = Method [34] [35] 
.const [12] = Method [36] [37] 
.const [13] = Method [38] [39] 
.const [14] = Method [40] [41] 
.const [15] = Method [42] [43] 
.const [16] = Method [44] [45] 
.const [17] = Method [46] [47] 
.const [18] = Method [48] [49] 
.const [19] = Field [50] [51] 
.const [20] = Utf8 '---' 
.const [21] = Utf8 de/audi/app/car/core/bcme/CarBCmEConsumption 
.const [22] = Utf8 de/audi/atip/metrics/Consumption 
.const [23] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [24] = Class [52] 
.const [25] = NameAndType [53] [54] 
.const [26] = Class [55] 
.const [27] = NameAndType [56] [57] 
.const [28] = Class [58] 
.const [29] = NameAndType [59] [60] 
.const [30] = Class [61] 
.const [31] = NameAndType [62] [63] 
.const [32] = Class [64] 
.const [33] = NameAndType [65] [66] 
.const [34] = Class [67] 
.const [35] = NameAndType [68] [69] 
.const [36] = Class [70] 
.const [37] = NameAndType [71] [72] 
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
.const [52] = Utf8 de/audi/app/car/core/bcme/CarBCmEConsumption 
.const [53] = Utf8 consumptionValue 
.const [54] = Utf8 I 
.const [55] = Utf8 de/audi/app/car/core/bcme/CarBCmEConsumption 
.const [56] = Utf8 setUseInstanceUnit 
.const [57] = Utf8 (Z)V 
.const [58] = Utf8 de/audi/app/car/core/bcme/CarBCmEConsumption 
.const [59] = Utf8 getFormattedValue 
.const [60] = Utf8 ()Ljava/lang/String; 
.const [61] = Utf8 de/audi/app/car/core/bcme/CarBCmEConsumption 
.const [62] = Utf8 unit 
.const [63] = Utf8 I 
.const [64] = Utf8 de/audi/app/car/core/bcme/CarBCmEConsumption 
.const [65] = Utf8 getFormattedUnit 
.const [66] = Utf8 (I)Ljava/lang/String; 
.const [67] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [68] = Utf8 clear 
.const [69] = Utf8 ()V 
.const [70] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [71] = Utf8 append 
.const [72] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [73] = Utf8 de/audi/app/car/core/bcme/CarBCmEConsumption 
.const [74] = Utf8 getUnit 
.const [75] = Utf8 ()I 
.const [76] = Utf8 de/audi/app/car/core/bcme/CarBCmEConsumption 
.const [77] = Utf8 getValue 
.const [78] = Utf8 (I)F 
.const [79] = Utf8 de/audi/atip/metrics/Consumption 
.const [80] = Utf8 <init> 
.const [81] = Utf8 (FI)V 
.const [82] = Utf8 de/audi/atip/metrics/Consumption 
.const [83] = Utf8 format 
.const [84] = Utf8 (I)Ljava/lang/String; 
.const [85] = Utf8 de/audi/atip/metrics/Consumption 
.const [86] = Utf8 appendMantissa 
.const [87] = Utf8 (Lde/esolutions/fw/util/commons/Buffer;ILjava/lang/String;)V 
.const [88] = Utf8 de/audi/atip/metrics/Consumption 
.const [89] = Utf8 setUseInstanceUnit 
.const [90] = Utf8 (Z)V 
.const [91] = Utf8 de/audi/app/car/core/bcme/CarBCmEConsumption 
.const [92] = Utf8 consumptionValue 
.const [93] = Utf8 I 
.const [94] = Utf8 de/audi/app/car/core/bcme/CarBCmEConsumption 
.const [95] = Class [94] 
.const [96] = Utf8 de/audi/atip/metrics/Consumption 
.const [97] = Class [96] 
.const [98] = Utf8 UNDEFINED_CONSUMPTION_VALUE 
.const [99] = Utf8 I 
.const [100] = Utf8 TEXT_UNDEFINED_CONSUMPTION_VALUE 
.const [101] = Utf8 Ljava/lang/String; 
.const [102] = Utf8 consumptionValue 
.const [103] = Utf8 I 
.const [104] = Utf8 MODE_VALUE_ONLY 
.const [105] = Utf8 I 
.const [106] = Utf8 MODE_UNIT_ONLY 
.const [107] = Utf8 I 
.const [108] = Utf8 Code 
.const [109] = Utf8 <init> 
.const [110] = Utf8 (I)V 
.const [111] = Utf8 <init> 
.const [112] = Utf8 (FI)V 
.const [113] = Utf8 format 
.const [114] = Utf8 (I)Ljava/lang/String; 
.const [115] = Utf8 appendMantissa 
.const [116] = Utf8 (Lde/esolutions/fw/util/commons/Buffer;ILjava/lang/String;)V 
.const [117] = Utf8 setUseInstanceUnit 
.const [118] = Utf8 (Z)V 
.const [119] = Utf8 getValue 
.const [120] = Utf8 ()F 
.end class 
