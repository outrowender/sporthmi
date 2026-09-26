.version 50 0 
.class super [33] 
.super [35] 
.field private [36] [37] 

.method public [39] : [40] 
    .attribute [38] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [6] 
L4:     aload_0 
L5:     aload_1 
L6:     invokeinterface [7] 0 
L11:    putfield [8] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [41] : [42] 
    .attribute [38] .code stack 2 locals 2 
L0:     aload_1 
L1:     checkcast [2] 
L4:     astore_2 
L5:     aload_0 
L6:     getfield [5] 
L9:     aload_2 
L10:    invokeinterface [7] 0 
L15:    if_icmpeq L22 
L18:    iconst_1 
L19:    goto L23 
L22:    iconst_0 
L23:    istore_3 
L24:    aload_0 
L25:    aload_2 
L26:    invokeinterface [7] 0 
L31:    putfield [8] 
L34:    iload_3 
L35:    areturn 
L36:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [9] 
.const [3] = Class [10] 
.const [4] = Class [11] 
.const [5] = Field [12] [13] 
.const [6] = Method [14] [15] 
.const [7] = InterfaceMethod [16] [17] 
.const [8] = Field [18] [19] 
.const [9] = Utf8 de/audi/atip/hmi/modelaccess/RangeModelGUI 
.const [10] = Utf8 de/audi/atip/statemachine/mediator/AbstractDataBuffer$RangeDataBuffer 
.const [11] = Utf8 de/audi/atip/statemachine/mediator/AbstractDataBuffer 
.const [12] = Class [20] 
.const [13] = NameAndType [21] [22] 
.const [14] = Class [23] 
.const [15] = NameAndType [24] [25] 
.const [16] = Class [26] 
.const [17] = NameAndType [27] [28] 
.const [18] = Class [29] 
.const [19] = NameAndType [30] [31] 
.const [20] = Utf8 de/audi/atip/statemachine/mediator/AbstractDataBuffer$RangeDataBuffer 
.const [21] = Utf8 value 
.const [22] = Utf8 I 
.const [23] = Utf8 de/audi/atip/statemachine/mediator/AbstractDataBuffer 
.const [24] = Utf8 <init> 
.const [25] = Utf8 ()V 
.const [26] = Utf8 de/audi/atip/hmi/modelaccess/RangeModelGUI 
.const [27] = Utf8 getValue 
.const [28] = Utf8 ()I 
.const [29] = Utf8 de/audi/atip/statemachine/mediator/AbstractDataBuffer$RangeDataBuffer 
.const [30] = Utf8 value 
.const [31] = Utf8 I 
.const [32] = Utf8 de/audi/atip/statemachine/mediator/AbstractDataBuffer$RangeDataBuffer 
.const [33] = Class [32] 
.const [34] = Utf8 de/audi/atip/statemachine/mediator/AbstractDataBuffer 
.const [35] = Class [34] 
.const [36] = Utf8 value 
.const [37] = Utf8 I 
.const [38] = Utf8 Code 
.const [39] = Utf8 <init> 
.const [40] = Utf8 (Lde/audi/atip/hmi/modelaccess/RangeModelGUI;)V 
.const [41] = Utf8 valueChanged 
.const [42] = Utf8 (Lde/audi/atip/hmi/model/HMIModel;)Z 
.end class 
