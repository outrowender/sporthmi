.version 50 0 
.class public super abstract [67] 
.super [69] 
.field private static final [70] [71] 

.method public [73] : [74] 
    .attribute [72] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     ldc [2] 
L4:     invokespecial [14] 
L7:     return 
L8:     
    .end code 
.end method 

.method public [75] : [76] 
    .attribute [72] .code stack 1 locals 0 
L0:     ldc [3] 
L2:     areturn 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [77] : [78] 
    .attribute [72] .code stack 10 locals 0 
L0:     iconst_1 
L1:     anewarray [4] 
L4:     dup 
L5:     iconst_0 
L6:     new [17] 
L9:     dup 
L10:    iconst_0 
L11:    iconst_1 
L12:    newarray int 
L14:    dup 
L15:    iconst_0 
L16:    bipush 65 
L18:    iastore 
L19:    iconst_0 
L20:    newarray int 
L22:    invokespecial [15] 
L25:    aastore 
L26:    areturn 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [79] : [80] 
    .attribute [72] .code stack 4 locals 1 
L0:     iload_2 
L1:     iconst_1 
L2:     if_icmpne L42 
L5:     new [18] 
L8:     dup 
L9:     aload_1 
L10:    invokevirtual [11] 
L13:    aload_1 
L14:    invokevirtual [12] 
L17:    ifne L24 
L20:    iconst_1 
L21:    goto L25 
L24:    iconst_2 
L25:    invokespecial [16] 
L28:    astore_3 
L29:    aload_0 
L30:    sipush 406 
L33:    invokevirtual [13] 
L36:    aload_3 
L37:    invokeinterface [19] 0 
L42:    return 
L43:    nop 
L44:    
    .end code 
.end method 

.method public [81] : [82] 
    .attribute [72] .code stack 2 locals 0 
L0:     aload_0 
L1:     sipush 406 
L4:     invokevirtual [13] 
L7:     checkcast [6] 
L10:    areturn 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [83] : [84] 
    .attribute [72] .code stack 1 locals 0 
L0:     aconst_null 
L1:     areturn 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method protected enum [85] : [86] 
    .attribute [72] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method protected enum [87] : [88] 
    .attribute [72] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method protected enum [89] : [90] 
    .attribute [72] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method protected enum [91] : [92] 
    .attribute [72] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [20] 
.const [3] = String [21] 
.const [4] = Class [22] 
.const [5] = Class [23] 
.const [6] = Class [24] 
.const [7] = Class [25] 
.const [8] = Class [26] 
.const [9] = Class [27] 
.const [10] = Class [28] 
.const [11] = Method [29] [30] 
.const [12] = Method [31] [32] 
.const [13] = Method [33] [34] 
.const [14] = Method [35] [36] 
.const [15] = Method [37] [38] 
.const [16] = Method [39] [40] 
.const [17] = Class [41] 
.const [18] = Class [42] 
.const [19] = InterfaceMethod [43] [44] 
.const [20] = Utf8 'App.Car.BC' 
.const [21] = Utf8 Boardcomputer 
.const [22] = Utf8 de/audi/app/car/common/comp/CarDSIAttributesSet 
.const [23] = Utf8 de/audi/atip/metrics/Temperature 
.const [24] = Utf8 de/audi/atip/hmi/model/MetricsModel 
.const [25] = Utf8 de/audi/app/car/core/kombi/AbstractBCComponent 
.const [26] = Utf8 de/audi/app/car/common/adapter/AbstractDSICarKombiAdapter 
.const [27] = Utf8 org/dsi/ifc/global/CarBCTemperature 
.const [28] = Utf8 de/audi/atip/hmi/modelaccess/MetricsModelApp 
.const [29] = Class [45] 
.const [30] = NameAndType [46] [47] 
.const [31] = Class [48] 
.const [32] = NameAndType [49] [50] 
.const [33] = Class [51] 
.const [34] = NameAndType [52] [53] 
.const [35] = Class [54] 
.const [36] = NameAndType [55] [56] 
.const [37] = Class [57] 
.const [38] = NameAndType [58] [59] 
.const [39] = Class [60] 
.const [40] = NameAndType [61] [62] 
.const [41] = Utf8 de/audi/app/car/common/comp/CarDSIAttributesSet 
.const [42] = Utf8 de/audi/atip/metrics/Temperature 
.const [43] = Class [63] 
.const [44] = NameAndType [64] [65] 
.const [45] = Utf8 org/dsi/ifc/global/CarBCTemperature 
.const [46] = Utf8 getTemperatureValue 
.const [47] = Utf8 ()F 
.const [48] = Utf8 org/dsi/ifc/global/CarBCTemperature 
.const [49] = Utf8 getTemperatureUnit 
.const [50] = Utf8 ()I 
.const [51] = Utf8 de/audi/app/car/core/kombi/AbstractBCComponent 
.const [52] = Utf8 getMetricsModel 
.const [53] = Utf8 (I)Lde/audi/atip/hmi/modelaccess/MetricsModelApp; 
.const [54] = Utf8 de/audi/app/car/common/adapter/AbstractDSICarKombiAdapter 
.const [55] = Utf8 <init> 
.const [56] = Utf8 (Lde/audi/app/car/common/app/ICarApplication;Ljava/lang/String;)V 
.const [57] = Utf8 de/audi/app/car/common/comp/CarDSIAttributesSet 
.const [58] = Utf8 <init> 
.const [59] = Utf8 (I[I[I)V 
.const [60] = Utf8 de/audi/atip/metrics/Temperature 
.const [61] = Utf8 <init> 
.const [62] = Utf8 (FI)V 
.const [63] = Utf8 de/audi/atip/hmi/modelaccess/MetricsModelApp 
.const [64] = Utf8 setMetric 
.const [65] = Utf8 (Lde/audi/atip/metrics/AbstractMetrics;)V 
.const [66] = Utf8 de/audi/app/car/core/kombi/AbstractBCComponent 
.const [67] = Class [66] 
.const [68] = Utf8 de/audi/app/car/common/adapter/AbstractDSICarKombiAdapter 
.const [69] = Class [68] 
.const [70] = Utf8 LOGCHANNEL_NAME 
.const [71] = Utf8 Ljava/lang/String; 
.const [72] = Utf8 Code 
.const [73] = Utf8 <init> 
.const [74] = Utf8 (Lde/audi/app/car/common/app/ICarApplication;)V 
.const [75] = Utf8 getName 
.const [76] = Utf8 ()Ljava/lang/String; 
.const [77] = Utf8 getDSIAttributesSets 
.const [78] = Utf8 ()[Lde/audi/app/car/common/comp/CarDSIAttributesSet; 
.const [79] = Utf8 updateBCOutsideTemperature 
.const [80] = Utf8 (Lorg/dsi/ifc/global/CarBCTemperature;I)V 
.const [81] = Utf8 getTemperatureMetrics 
.const [82] = Utf8 ()Lde/audi/atip/hmi/model/MetricsModel; 
.const [83] = Utf8 getCurrentViewOptions 
.const [84] = Utf8 ()Ljava/lang/String; 
.const [85] = Utf8 initModels 
.const [86] = Utf8 ()V 
.const [87] = Utf8 deinitModels 
.const [88] = Utf8 ()V 
.const [89] = Utf8 initVisibility 
.const [90] = Utf8 ()V 
.const [91] = Utf8 deinitVisibility 
.const [92] = Utf8 ()V 
.end class 
