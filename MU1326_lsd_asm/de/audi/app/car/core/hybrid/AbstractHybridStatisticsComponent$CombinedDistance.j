.version 50 0 
.class public super [103] 
.super [105] 
.field private [106] [107] 
.field private [108] [109] 
.field private [110] [111] 
.field private final synthetic [112] [113] 

.method protected [115] : [116] 
    .attribute [114] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [18] 
L5:     aload_0 
L6:     invokespecial [17] 
L9:     aload_0 
L10:    dconst_0 
L11:    putfield [19] 
L14:    aload_0 
L15:    dconst_0 
L16:    putfield [20] 
L19:    aload_0 
L20:    dconst_0 
L21:    putfield [21] 
L24:    return 
L25:    nop 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method protected [117] : [118] 
    .attribute [114] .code stack 5 locals 0 
L0:     aload_0 
L1:     iload_3 
L2:     ifeq L14 
L5:     aload_0 
L6:     getfield [9] 
L9:     dload_1 
L10:    dadd 
L11:    goto L15 
L14:    dload_1 
L15:    putfield [19] 
L18:    return 
L19:    nop 
L20:    
    .end code 
.end method 

.method protected [119] : [120] 
    .attribute [114] .code stack 5 locals 0 
L0:     aload_0 
L1:     iload_3 
L2:     ifeq L14 
L5:     aload_0 
L6:     getfield [10] 
L9:     dload_1 
L10:    dadd 
L11:    goto L15 
L14:    dload_1 
L15:    putfield [20] 
L18:    return 
L19:    nop 
L20:    
    .end code 
.end method 

.method protected [121] : [122] 
    .attribute [114] .code stack 5 locals 0 
L0:     aload_0 
L1:     iload_3 
L2:     ifeq L14 
L5:     aload_0 
L6:     getfield [11] 
L9:     dload_1 
L10:    dadd 
L11:    goto L15 
L14:    dload_1 
L15:    putfield [21] 
L18:    return 
L19:    nop 
L20:    
    .end code 
.end method 

.method protected interface [123] : [124] 
    .attribute [114] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [9] 
L4:     freturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method protected interface [125] : [126] 
    .attribute [114] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [10] 
L4:     freturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method protected interface [127] : [128] 
    .attribute [114] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [11] 
L4:     freturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method protected [129] : [130] 
    .attribute [114] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [9] 
L4:     aload_0 
L5:     getfield [10] 
L8:     dadd 
L9:     aload_0 
L10:    getfield [11] 
L13:    dadd 
L14:    freturn 
L15:    nop 
L16:    
    .end code 
.end method 

.method protected [131] : [132] 
    .attribute [114] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [9] 
L4:     ldc2_w [22] 
L7:     dmul 
L8:     invokestatic [2] 
L11:    l2f 
L12:    ldc [3] 
L14:    fdiv 
L15:    areturn 
L16:    
    .end code 
.end method 

.method protected [133] : [134] 
    .attribute [114] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [10] 
L4:     ldc2_w [22] 
L7:     dmul 
L8:     invokestatic [2] 
L11:    l2f 
L12:    ldc [3] 
L14:    fdiv 
L15:    areturn 
L16:    
    .end code 
.end method 

.method protected [135] : [136] 
    .attribute [114] .code stack 3 locals 1 
L0:     aload_0 
L1:     invokevirtual [12] 
L4:     aload_0 
L5:     invokevirtual [13] 
L8:     aload_0 
L9:     invokevirtual [14] 
L12:    fadd 
L13:    fsub 
L14:    fstore_1 
L15:    fload_1 
L16:    fconst_0 
L17:    fcmpg 
L18:    ifge L23 
L21:    fconst_0 
L22:    fstore_1 
L23:    fload_1 
L24:    areturn 
L25:    nop 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method protected [137] : [138] 
    .attribute [114] .code stack 4 locals 0 
L0:     aload_0 
L1:     invokevirtual [13] 
L4:     aload_0 
L5:     invokevirtual [14] 
L8:     fadd 
L9:     f2d 
L10:    aload_0 
L11:    getfield [11] 
L14:    dadd 
L15:    invokestatic [2] 
L18:    l2f 
L19:    areturn 
L20:    
    .end code 
.end method 

.method protected [139] : [140] 
    .attribute [114] .code stack 3 locals 1 
L0:     aload_0 
L1:     invokevirtual [12] 
L4:     fstore_1 
L5:     fload_1 
L6:     fconst_0 
L7:     fcmpl 
L8:     ifle L29 
L11:    ldc [4] 
L13:    aload_0 
L14:    invokevirtual [13] 
L17:    aload_0 
L18:    invokevirtual [12] 
L21:    fdiv 
L22:    fmul 
L23:    invokestatic [5] 
L26:    goto L30 
L29:    iconst_0 
L30:    areturn 
L31:    nop 
L32:    
    .end code 
.end method 

.method protected [141] : [142] 
    .attribute [114] .code stack 3 locals 1 
L0:     aload_0 
L1:     invokevirtual [12] 
L4:     fstore_1 
L5:     fload_1 
L6:     fconst_0 
L7:     fcmpl 
L8:     ifle L29 
L11:    ldc [4] 
L13:    aload_0 
L14:    invokevirtual [14] 
L17:    aload_0 
L18:    invokevirtual [12] 
L21:    fdiv 
L22:    fmul 
L23:    invokestatic [5] 
L26:    goto L30 
L29:    iconst_0 
L30:    areturn 
L31:    nop 
L32:    
    .end code 
.end method 

.method protected [143] : [144] 
    .attribute [114] .code stack 3 locals 0 
L0:     ldc [4] 
L2:     aload_0 
L3:     invokevirtual [15] 
L6:     aload_0 
L7:     invokevirtual [16] 
L10:    iadd 
L11:    i2f 
L12:    fsub 
L13:    f2i 
L14:    areturn 
L15:    nop 
L16:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [24] [25] 
.const [3] = Int 8257 
.const [4] = Int 51266 
.const [5] = Method [26] [27] 
.const [6] = Class [28] 
.const [7] = Class [29] 
.const [8] = Class [30] 
.const [9] = Field [31] [32] 
.const [10] = Field [33] [34] 
.const [11] = Field [35] [36] 
.const [12] = Method [37] [38] 
.const [13] = Method [39] [40] 
.const [14] = Method [41] [42] 
.const [15] = Method [43] [44] 
.const [16] = Method [45] [46] 
.const [17] = Method [47] [48] 
.const [18] = Field [49] [50] 
.const [19] = Field [51] [52] 
.const [20] = Field [53] [54] 
.const [21] = Field [55] [56] 
.const [22] = Double +0x14000000000000p-49 
.const [24] = Class [57] 
.const [25] = NameAndType [58] [59] 
.const [26] = Class [60] 
.const [27] = NameAndType [61] [62] 
.const [28] = Utf8 de/audi/app/car/core/hybrid/AbstractHybridStatisticsComponent$CombinedDistance 
.const [29] = Utf8 java/lang/Object 
.const [30] = Utf8 java/lang/Math 
.const [31] = Class [63] 
.const [32] = NameAndType [64] [65] 
.const [33] = Class [66] 
.const [34] = NameAndType [67] [68] 
.const [35] = Class [69] 
.const [36] = NameAndType [70] [71] 
.const [37] = Class [72] 
.const [38] = NameAndType [73] [74] 
.const [39] = Class [75] 
.const [40] = NameAndType [76] [77] 
.const [41] = Class [78] 
.const [42] = NameAndType [79] [80] 
.const [43] = Class [81] 
.const [44] = NameAndType [82] [83] 
.const [45] = Class [84] 
.const [46] = NameAndType [85] [86] 
.const [47] = Class [87] 
.const [48] = NameAndType [88] [89] 
.const [49] = Class [90] 
.const [50] = NameAndType [91] [92] 
.const [51] = Class [93] 
.const [52] = NameAndType [94] [95] 
.const [53] = Class [96] 
.const [54] = NameAndType [97] [98] 
.const [55] = Class [99] 
.const [56] = NameAndType [100] [101] 
.const [57] = Utf8 java/lang/Math 
.const [58] = Utf8 round 
.const [59] = Utf8 (D)J 
.const [60] = Utf8 java/lang/Math 
.const [61] = Utf8 round 
.const [62] = Utf8 (F)I 
.const [63] = Utf8 de/audi/app/car/core/hybrid/AbstractHybridStatisticsComponent$CombinedDistance 
.const [64] = Utf8 distanceCombustion 
.const [65] = Utf8 D 
.const [66] = Utf8 de/audi/app/car/core/hybrid/AbstractHybridStatisticsComponent$CombinedDistance 
.const [67] = Utf8 distanceElectrical 
.const [68] = Utf8 D 
.const [69] = Utf8 de/audi/app/car/core/hybrid/AbstractHybridStatisticsComponent$CombinedDistance 
.const [70] = Utf8 distanceEfficiency 
.const [71] = Utf8 D 
.const [72] = Utf8 de/audi/app/car/core/hybrid/AbstractHybridStatisticsComponent$CombinedDistance 
.const [73] = Utf8 getTotalDistanceDisp 
.const [74] = Utf8 ()F 
.const [75] = Utf8 de/audi/app/car/core/hybrid/AbstractHybridStatisticsComponent$CombinedDistance 
.const [76] = Utf8 getDistanceCombustionDisp 
.const [77] = Utf8 ()F 
.const [78] = Utf8 de/audi/app/car/core/hybrid/AbstractHybridStatisticsComponent$CombinedDistance 
.const [79] = Utf8 getDistanceElectricalDisp 
.const [80] = Utf8 ()F 
.const [81] = Utf8 de/audi/app/car/core/hybrid/AbstractHybridStatisticsComponent$CombinedDistance 
.const [82] = Utf8 getDistanceCombustionAsPercent 
.const [83] = Utf8 ()I 
.const [84] = Utf8 de/audi/app/car/core/hybrid/AbstractHybridStatisticsComponent$CombinedDistance 
.const [85] = Utf8 getDistanceElectricalAsPercent 
.const [86] = Utf8 ()I 
.const [87] = Utf8 java/lang/Object 
.const [88] = Utf8 <init> 
.const [89] = Utf8 ()V 
.const [90] = Utf8 de/audi/app/car/core/hybrid/AbstractHybridStatisticsComponent$CombinedDistance 
.const [91] = Utf8 this$0 
.const [92] = Utf8 Lde/audi/app/car/core/hybrid/AbstractHybridStatisticsComponent; 
.const [93] = Utf8 de/audi/app/car/core/hybrid/AbstractHybridStatisticsComponent$CombinedDistance 
.const [94] = Utf8 distanceCombustion 
.const [95] = Utf8 D 
.const [96] = Utf8 de/audi/app/car/core/hybrid/AbstractHybridStatisticsComponent$CombinedDistance 
.const [97] = Utf8 distanceElectrical 
.const [98] = Utf8 D 
.const [99] = Utf8 de/audi/app/car/core/hybrid/AbstractHybridStatisticsComponent$CombinedDistance 
.const [100] = Utf8 distanceEfficiency 
.const [101] = Utf8 D 
.const [102] = Utf8 de/audi/app/car/core/hybrid/AbstractHybridStatisticsComponent$CombinedDistance 
.const [103] = Class [102] 
.const [104] = Utf8 java/lang/Object 
.const [105] = Class [104] 
.const [106] = Utf8 distanceCombustion 
.const [107] = Utf8 D 
.const [108] = Utf8 distanceElectrical 
.const [109] = Utf8 D 
.const [110] = Utf8 distanceEfficiency 
.const [111] = Utf8 D 
.const [112] = Utf8 this$0 
.const [113] = Utf8 Lde/audi/app/car/core/hybrid/AbstractHybridStatisticsComponent; 
.const [114] = Utf8 Code 
.const [115] = Utf8 <init> 
.const [116] = Utf8 (Lde/audi/app/car/core/hybrid/AbstractHybridStatisticsComponent;)V 
.const [117] = Utf8 setDistanceCombustion 
.const [118] = Utf8 (DZ)V 
.const [119] = Utf8 setDistanceElectrical 
.const [120] = Utf8 (DZ)V 
.const [121] = Utf8 setDistanceEfficiency 
.const [122] = Utf8 (DZ)V 
.const [123] = Utf8 getDistanceCombustion 
.const [124] = Utf8 ()D 
.const [125] = Utf8 getDistanceElectrical 
.const [126] = Utf8 ()D 
.const [127] = Utf8 getDistanceEfficiency 
.const [128] = Utf8 ()D 
.const [129] = Utf8 getTotalDistance 
.const [130] = Utf8 ()D 
.const [131] = Utf8 getDistanceCombustionDisp 
.const [132] = Utf8 ()F 
.const [133] = Utf8 getDistanceElectricalDisp 
.const [134] = Utf8 ()F 
.const [135] = Utf8 getDistanceEfficiencyDisp 
.const [136] = Utf8 ()F 
.const [137] = Utf8 getTotalDistanceDisp 
.const [138] = Utf8 ()F 
.const [139] = Utf8 getDistanceCombustionAsPercent 
.const [140] = Utf8 ()I 
.const [141] = Utf8 getDistanceElectricalAsPercent 
.const [142] = Utf8 ()I 
.const [143] = Utf8 getDistanceEfficiencyAsPercent 
.const [144] = Utf8 ()I 
.end class 
