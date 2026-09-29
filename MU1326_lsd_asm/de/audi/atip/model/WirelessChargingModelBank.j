.version 50 0 
.class public super [54] 
.super [56] 
.implements [58] 
.implements [60] 

.method protected synchronized [62] : [63] 
    .attribute [61] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [8] 
L4:     iload_1 
L5:     aaload 
L6:     ifnonnull L42 
L9:     iload_1 
L10:    lookupswitch 
            default : L20 

L20:    invokestatic [2] 
L23:    sipush 10000 
L26:    ldc [3] 
L28:    aload_0 
L29:    getfield [9] 
L32:    ldc [4] 
L34:    imul 
L35:    iload_1 
L36:    iadd 
L37:    i2l 
L38:    invokevirtual [10] 
L41:    pop 
L42:    return 
L43:    nop 
L44:    
    .end code 
.end method 

.method public interface [64] : [65] 
    .attribute [61] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [11] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [66] : [67] 
    .attribute [61] .code stack 4 locals 0 
L0:     aload_0 
L1:     bipush 34 
L3:     iconst_1 
L4:     iconst_0 
L5:     invokespecial [12] 
L8:     aload_0 
L9:     iconst_0 
L10:    newarray int 
L12:    putfield [13] 
L15:    return 
L16:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [14] [15] 
.const [3] = String [16] 
.const [4] = Int -1601830656 
.const [5] = Class [17] 
.const [6] = Class [18] 
.const [7] = Class [19] 
.const [8] = Field [20] [21] 
.const [9] = Field [22] [23] 
.const [10] = Method [24] [25] 
.const [11] = Field [26] [27] 
.const [12] = Method [28] [29] 
.const [13] = Field [30] [31] 
.const [14] = Class [32] 
.const [15] = NameAndType [33] [34] 
.const [16] = Utf8 '[WirelessChargingModelBank#createModel()] model with ID %1 not found' 
.const [17] = Utf8 de/audi/atip/model/WirelessChargingModelBank 
.const [18] = Utf8 de/audi/atip/hmi/model/AbstractModelBank 
.const [19] = Utf8 de/audi/atip/log/LogChannel 
.const [20] = Class [35] 
.const [21] = NameAndType [36] [37] 
.const [22] = Class [38] 
.const [23] = NameAndType [39] [40] 
.const [24] = Class [41] 
.const [25] = NameAndType [42] [43] 
.const [26] = Class [44] 
.const [27] = NameAndType [45] [46] 
.const [28] = Class [47] 
.const [29] = NameAndType [48] [49] 
.const [30] = Class [50] 
.const [31] = NameAndType [51] [52] 
.const [32] = Utf8 de/audi/atip/model/WirelessChargingModelBank 
.const [33] = Utf8 getModelLogChannel 
.const [34] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [35] = Utf8 de/audi/atip/model/WirelessChargingModelBank 
.const [36] = Utf8 models 
.const [37] = Utf8 [Lde/audi/atip/hmi/model/HMIModel; 
.const [38] = Utf8 de/audi/atip/model/WirelessChargingModelBank 
.const [39] = Utf8 moduleID 
.const [40] = Utf8 I 
.const [41] = Utf8 de/audi/atip/log/LogChannel 
.const [42] = Utf8 log 
.const [43] = Utf8 (ILjava/lang/String;J)Z 
.const [44] = Utf8 de/audi/atip/model/WirelessChargingModelBank 
.const [45] = Utf8 modelIDs 
.const [46] = Utf8 [I 
.const [47] = Utf8 de/audi/atip/hmi/model/AbstractModelBank 
.const [48] = Utf8 <init> 
.const [49] = Utf8 (III)V 
.const [50] = Utf8 de/audi/atip/model/WirelessChargingModelBank 
.const [51] = Utf8 modelIDs 
.const [52] = Utf8 [I 
.const [53] = Utf8 de/audi/atip/model/WirelessChargingModelBank 
.const [54] = Class [53] 
.const [55] = Utf8 de/audi/atip/hmi/model/AbstractModelBank 
.const [56] = Class [55] 
.const [57] = Utf8 de/audi/atip/model/ICoreWirelessChargingModelBank 
.const [58] = Class [57] 
.const [59] = Utf8 de/audi/atip/model/IEvoWirelessChargingModelBank 
.const [60] = Class [59] 
.const [61] = Utf8 Code 
.const [62] = Utf8 createModel 
.const [63] = Utf8 (I)V 
.const [64] = Utf8 getAllModelIds 
.const [65] = Utf8 ()[I 
.const [66] = Utf8 <init> 
.const [67] = Utf8 ()V 
.end class 
