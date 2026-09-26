.version 50 0 
.class public super abstract [74] 
.super [76] 

.method public [78] : [79] 
    .attribute [77] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     ldc [2] 
L4:     invokespecial [15] 
L7:     return 
L8:     
    .end code 
.end method 

.method public [80] : [81] 
    .attribute [77] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokevirtual [11] 
L4:     invokeinterface [16] 0 
L9:     aload_0 
L10:    invokeinterface [17] 0 
L15:    return 
L16:    
    .end code 
.end method 

.method public [82] : [83] 
    .attribute [77] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokevirtual [11] 
L4:     invokeinterface [16] 0 
L9:     aload_0 
L10:    invokeinterface [18] 0 
L15:    return 
L16:    
    .end code 
.end method 

.method public [84] : [85] 
    .attribute [77] .code stack 3 locals 0 
L0:     aload_2 
L1:     ifnonnull L18 
L4:     aload_0 
L5:     getfield [12] 
L8:     sipush 10000 
L11:    ldc [3] 
L13:    invokevirtual [13] 
L16:    pop 
L17:    return 
L18:    iload_1 
L19:    ldc [4] 
L21:    if_icmpne L34 
L24:    aload_0 
L25:    aload_2 
L26:    invokeinterface [19] 0 
L31:    invokevirtual [14] 
L34:    return 
L35:    nop 
L36:    
    .end code 
.end method 

.method protected abstract [86] : [87] 
    .attribute [77] .code stack 0 locals 0 
L0:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [20] 
.const [3] = String [21] 
.const [4] = Int 570425600 
.const [5] = Class [22] 
.const [6] = Class [23] 
.const [7] = Class [24] 
.const [8] = Class [25] 
.const [9] = Class [26] 
.const [10] = Class [27] 
.const [11] = Method [28] [29] 
.const [12] = Field [30] [31] 
.const [13] = Method [32] [33] 
.const [14] = Method [34] [35] 
.const [15] = Method [36] [37] 
.const [16] = InterfaceMethod [38] [39] 
.const [17] = InterfaceMethod [40] [41] 
.const [18] = InterfaceMethod [42] [43] 
.const [19] = InterfaceMethod [44] [45] 
.const [20] = Utf8 'App.Phone.Main' 
.const [21] = Utf8 'AbstractTelSAPUpgradeHandler#updateGlobalTelephoneStateProperty stateStruct is null' 
.const [22] = Utf8 de/audi/app/phone/core/AbstractTelSAPUpgradeHandler 
.const [23] = Utf8 de/audi/app/phone/core/AbstractPhoneComponent 
.const [24] = Utf8 de/audi/app/phone/core/ITelApplication 
.const [25] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneState 
.const [26] = Utf8 de/audi/atip/log/LogChannel 
.const [27] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [28] = Class [46] 
.const [29] = NameAndType [47] [48] 
.const [30] = Class [49] 
.const [31] = NameAndType [50] [51] 
.const [32] = Class [52] 
.const [33] = NameAndType [53] [54] 
.const [34] = Class [55] 
.const [35] = NameAndType [56] [57] 
.const [36] = Class [58] 
.const [37] = NameAndType [59] [60] 
.const [38] = Class [61] 
.const [39] = NameAndType [62] [63] 
.const [40] = Class [64] 
.const [41] = NameAndType [65] [66] 
.const [42] = Class [67] 
.const [43] = NameAndType [68] [69] 
.const [44] = Class [70] 
.const [45] = NameAndType [71] [72] 
.const [46] = Utf8 de/audi/app/phone/core/AbstractTelSAPUpgradeHandler 
.const [47] = Utf8 getApplication 
.const [48] = Utf8 ()Lde/audi/app/phone/core/ITelApplication; 
.const [49] = Utf8 de/audi/app/phone/core/AbstractTelSAPUpgradeHandler 
.const [50] = Utf8 log 
.const [51] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [52] = Utf8 de/audi/atip/log/LogChannel 
.const [53] = Utf8 log 
.const [54] = Utf8 (ILjava/lang/String;)Z 
.const [55] = Utf8 de/audi/app/phone/core/AbstractTelSAPUpgradeHandler 
.const [56] = Utf8 processSAPUpgradeActive 
.const [57] = Utf8 (Z)V 
.const [58] = Utf8 de/audi/app/phone/core/AbstractPhoneComponent 
.const [59] = Utf8 <init> 
.const [60] = Utf8 (Lde/audi/app/phone/core/ITelApplication;Ljava/lang/String;)V 
.const [61] = Utf8 de/audi/app/phone/core/ITelApplication 
.const [62] = Utf8 getGlobalTelephoneStateManager 
.const [63] = Utf8 ()Lde/audi/app/phone/core/state/IGlobalTelephoneState; 
.const [64] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneState 
.const [65] = Utf8 registerListener 
.const [66] = Utf8 (Lde/audi/app/phone/core/state/IGlobalTelephoneStateListener;)V 
.const [67] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneState 
.const [68] = Utf8 removeListener 
.const [69] = Utf8 (Lde/audi/app/phone/core/state/IGlobalTelephoneStateListener;)V 
.const [70] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [71] = Utf8 isSapUpgradeActive 
.const [72] = Utf8 ()Z 
.const [73] = Utf8 de/audi/app/phone/core/AbstractTelSAPUpgradeHandler 
.const [74] = Class [73] 
.const [75] = Utf8 de/audi/app/phone/core/AbstractPhoneComponent 
.const [76] = Class [75] 
.const [77] = Utf8 Code 
.const [78] = Utf8 <init> 
.const [79] = Utf8 (Lde/audi/app/phone/core/ITelApplication;)V 
.const [80] = Utf8 init 
.const [81] = Utf8 ()V 
.const [82] = Utf8 deinit 
.const [83] = Utf8 ()V 
.const [84] = Utf8 updateGlobalTelephoneStateProperty 
.const [85] = Utf8 (ILde/audi/app/phone/core/state/IGlobalTelephoneStateStruct;)V 
.const [86] = Utf8 processSAPUpgradeActive 
.const [87] = Utf8 (Z)V 
.end class 
