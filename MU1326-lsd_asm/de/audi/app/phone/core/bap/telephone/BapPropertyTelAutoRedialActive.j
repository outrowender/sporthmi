.version 50 0 
.class public super [44] 
.super [46] 

.method public annotation [48] : [49] 
    .attribute [47] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     invokespecial [11] 
L6:     return 
L7:     nop 
L8:     
    .end code 
.end method 

.method protected [50] : [51] 
    .attribute [47] .code stack 2 locals 0 
L0:     iload_1 
L1:     ldc [2] 
L3:     if_icmpeq L18 
L6:     iload_1 
L7:     ldc [3] 
L9:     if_icmpeq L18 
L12:    iload_1 
L13:    ldc [4] 
L15:    if_icmpne L22 
L18:    iconst_1 
L19:    goto L23 
L22:    iconst_0 
L23:    areturn 
L24:    
    .end code 
.end method 

.method protected [52] : [53] 
    .attribute [47] .code stack 2 locals 3 
L0:     aload_0 
L1:     invokevirtual [9] 
L4:     astore_1 
L5:     aload_0 
L6:     invokevirtual [10] 
L9:     astore_2 
L10:    aload_2 
L11:    ifnull L32 
L14:    aload_1 
L15:    ifnull L32 
L18:    aload_1 
L19:    invokeinterface [12] 0 
L24:    istore_3 
L25:    aload_2 
L26:    iload_3 
L27:    invokeinterface [13] 0 
L32:    return 
L33:    nop 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int 83886336 
.const [3] = Int 83886592 
.const [4] = Int 83886848 
.const [5] = Class [14] 
.const [6] = Class [15] 
.const [7] = Class [16] 
.const [8] = Class [17] 
.const [9] = Method [18] [19] 
.const [10] = Method [20] [21] 
.const [11] = Method [22] [23] 
.const [12] = InterfaceMethod [24] [25] 
.const [13] = InterfaceMethod [26] [27] 
.const [14] = Utf8 de/audi/app/phone/core/bap/telephone/BapPropertyTelAutoRedialActive 
.const [15] = Utf8 de/audi/app/phone/core/bap/AbstractTel1EnqueuedBAPPropertyHandler 
.const [16] = Utf8 de/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState 
.const [17] = Utf8 de/audi/atip/interapp/combi/bap/phone/CombiBAPServicePhone 
.const [18] = Class [28] 
.const [19] = NameAndType [29] [30] 
.const [20] = Class [31] 
.const [21] = NameAndType [32] [33] 
.const [22] = Class [34] 
.const [23] = NameAndType [35] [36] 
.const [24] = Class [37] 
.const [25] = NameAndType [38] [39] 
.const [26] = Class [40] 
.const [27] = NameAndType [41] [42] 
.const [28] = Utf8 de/audi/app/phone/core/bap/telephone/BapPropertyTelAutoRedialActive 
.const [29] = Utf8 getCallLeadingDeviceState 
.const [30] = Utf8 ()Lde/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState; 
.const [31] = Utf8 de/audi/app/phone/core/bap/telephone/BapPropertyTelAutoRedialActive 
.const [32] = Utf8 getCombiService 
.const [33] = Utf8 ()Lde/audi/atip/interapp/combi/bap/phone/CombiBAPServicePhone; 
.const [34] = Utf8 de/audi/app/phone/core/bap/AbstractTel1EnqueuedBAPPropertyHandler 
.const [35] = Utf8 <init> 
.const [36] = Utf8 (Lde/audi/app/phone/core/ITelApplication;Lde/esolutions/fw/util/commons/job/DispatcherBase;)V 
.const [37] = Utf8 de/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState 
.const [38] = Utf8 isAutomaticRedialActive 
.const [39] = Utf8 ()Z 
.const [40] = Utf8 de/audi/atip/interapp/combi/bap/phone/CombiBAPServicePhone 
.const [41] = Utf8 updateAutomaticRedialActive 
.const [42] = Utf8 (Z)V 
.const [43] = Utf8 de/audi/app/phone/core/bap/telephone/BapPropertyTelAutoRedialActive 
.const [44] = Class [43] 
.const [45] = Utf8 de/audi/app/phone/core/bap/AbstractTel1EnqueuedBAPPropertyHandler 
.const [46] = Class [45] 
.const [47] = Utf8 Code 
.const [48] = Utf8 <init> 
.const [49] = Utf8 (Lde/audi/app/phone/core/ITelApplication;Lde/esolutions/fw/util/commons/job/DispatcherBase;)V 
.const [50] = Utf8 doProcessGlobalTelephoneStateUpdate 
.const [51] = Utf8 (ILde/audi/app/phone/core/state/IGlobalTelephoneStateStruct;)Z 
.const [52] = Utf8 updateAsync 
.const [53] = Utf8 ()V 
.end class 
