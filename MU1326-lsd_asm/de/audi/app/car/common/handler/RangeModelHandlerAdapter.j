.version 50 0 
.class public super [65] 
.super [67] 
.implements [69] 
.implements [71] 

.method protected [73] : [74] 
    .attribute [72] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     invokespecial [11] 
L6:     aload_1 
L7:     aload_0 
L8:     invokeinterface [12] 0 
L13:    return 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public enum [75] : [76] 
    .attribute [72] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [77] : [78] 
    .attribute [72] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokevirtual [6] 
L4:     iload_1 
L5:     if_icmpne L15 
L8:     aload_0 
L9:     iload_2 
L10:    iconst_m1 
L11:    imul 
L12:    invokevirtual [7] 
L15:    return 
L16:    
    .end code 
.end method 

.method public [79] : [80] 
    .attribute [72] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokevirtual [6] 
L4:     iload_1 
L5:     if_icmpne L13 
L8:     aload_0 
L9:     iload_2 
L10:    invokevirtual [7] 
L13:    return 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [81] : [82] 
    .attribute [72] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokevirtual [8] 
L4:     checkcast [2] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public [83] : [84] 
    .attribute [72] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokevirtual [9] 
L4:     checkcast [3] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public [85] : [86] 
    .attribute [72] .code stack 4 locals 0 
L0:     aload_0 
L1:     invokevirtual [10] 
L4:     iload_1 
L5:     iload_2 
L6:     iload_3 
L7:     invokeinterface [13] 0 
L12:    return 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [87] : [88] 
    .attribute [72] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokevirtual [10] 
L4:     iload_1 
L5:     invokeinterface [14] 0 
L10:    return 
L11:    nop 
L12:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [15] 
.const [3] = Class [16] 
.const [4] = Class [17] 
.const [5] = Class [18] 
.const [6] = Method [19] [20] 
.const [7] = Method [21] [22] 
.const [8] = Method [23] [24] 
.const [9] = Method [25] [26] 
.const [10] = Method [27] [28] 
.const [11] = Method [29] [30] 
.const [12] = InterfaceMethod [31] [32] 
.const [13] = InterfaceMethod [33] [34] 
.const [14] = InterfaceMethod [35] [36] 
.const [15] = Utf8 de/audi/atip/hmi/modelaccess/RangeModelApp 
.const [16] = Utf8 de/audi/app/car/common/handler/business/RangeModelEventBusiness 
.const [17] = Utf8 de/audi/app/car/common/handler/RangeModelHandlerAdapter 
.const [18] = Utf8 de/audi/app/car/common/handler/ButtonModelHandlerAdapter 
.const [19] = Class [37] 
.const [20] = NameAndType [38] [39] 
.const [21] = Class [40] 
.const [22] = NameAndType [41] [42] 
.const [23] = Class [43] 
.const [24] = NameAndType [44] [45] 
.const [25] = Class [46] 
.const [26] = NameAndType [47] [48] 
.const [27] = Class [49] 
.const [28] = NameAndType [50] [51] 
.const [29] = Class [52] 
.const [30] = NameAndType [53] [54] 
.const [31] = Class [55] 
.const [32] = NameAndType [56] [57] 
.const [33] = Class [58] 
.const [34] = NameAndType [59] [60] 
.const [35] = Class [61] 
.const [36] = NameAndType [62] [63] 
.const [37] = Utf8 de/audi/app/car/common/handler/RangeModelHandlerAdapter 
.const [38] = Utf8 getHandledModelID 
.const [39] = Utf8 ()I 
.const [40] = Utf8 de/audi/app/car/common/handler/RangeModelHandlerAdapter 
.const [41] = Utf8 updateOnAdjustment 
.const [42] = Utf8 (I)V 
.const [43] = Utf8 de/audi/app/car/common/handler/RangeModelHandlerAdapter 
.const [44] = Utf8 getHandledModel 
.const [45] = Utf8 ()Lde/audi/atip/hmi/modelaccess/HMIModelApp; 
.const [46] = Utf8 de/audi/app/car/common/handler/RangeModelHandlerAdapter 
.const [47] = Utf8 getBusiness 
.const [48] = Utf8 ()Lde/audi/app/car/common/handler/business/ModelEventBusiness; 
.const [49] = Utf8 de/audi/app/car/common/handler/RangeModelHandlerAdapter 
.const [50] = Utf8 getRangeModel 
.const [51] = Utf8 ()Lde/audi/atip/hmi/modelaccess/RangeModelApp; 
.const [52] = Utf8 de/audi/app/car/common/handler/ButtonModelHandlerAdapter 
.const [53] = Utf8 <init> 
.const [54] = Utf8 (Lde/audi/atip/hmi/modelaccess/ButtonModelApp;Lde/audi/atip/log/LogChannel;)V 
.const [55] = Utf8 de/audi/atip/hmi/modelaccess/RangeModelApp 
.const [56] = Utf8 setRangeListener 
.const [57] = Utf8 (Lde/audi/atip/hmi/model/RangeListener;)V 
.const [58] = Utf8 de/audi/atip/hmi/modelaccess/RangeModelApp 
.const [59] = Utf8 setLimits 
.const [60] = Utf8 (III)V 
.const [61] = Utf8 de/audi/atip/hmi/modelaccess/RangeModelApp 
.const [62] = Utf8 setValue 
.const [63] = Utf8 (I)V 
.const [64] = Utf8 de/audi/app/car/common/handler/RangeModelHandlerAdapter 
.const [65] = Class [64] 
.const [66] = Utf8 de/audi/app/car/common/handler/ButtonModelHandlerAdapter 
.const [67] = Class [66] 
.const [68] = Utf8 de/audi/atip/hmi/model/RangeListener 
.const [69] = Class [68] 
.const [70] = Utf8 de/audi/app/car/common/handler/RangeModelHandler 
.const [71] = Class [70] 
.const [72] = Utf8 Code 
.const [73] = Utf8 <init> 
.const [74] = Utf8 (Lde/audi/atip/hmi/modelaccess/RangeModelApp;Lde/audi/atip/log/LogChannel;)V 
.const [75] = Utf8 updateOnAdjustment 
.const [76] = Utf8 (I)V 
.const [77] = Utf8 decrement 
.const [78] = Utf8 (III)V 
.const [79] = Utf8 increment 
.const [80] = Utf8 (III)V 
.const [81] = Utf8 getRangeModel 
.const [82] = Utf8 ()Lde/audi/atip/hmi/modelaccess/RangeModelApp; 
.const [83] = Utf8 getRangeEventBusiness 
.const [84] = Utf8 ()Lde/audi/app/car/common/handler/business/RangeModelEventBusiness; 
.const [85] = Utf8 updateRangeModelLimits 
.const [86] = Utf8 (III)V 
.const [87] = Utf8 updateRangeModelValue 
.const [88] = Utf8 (I)V 
.end class 
