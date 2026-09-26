.version 50 0 
.class public super [51] 
.super [53] 

.method protected [55] : [56] 
    .attribute [54] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_1 
L3:     invokevirtual [9] 
L6:     invokespecial [13] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [57] : [58] 
    .attribute [54] .code stack 5 locals 1 
L0:     aconst_null 
L1:     astore_3 
L2:     iload_1 
L3:     lookupswitch 
            default : L12 

L12:    aload_0 
L13:    getfield [10] 
L16:    sipush 10000 
L19:    ldc [2] 
L21:    aload_0 
L22:    getfield [11] 
L25:    iload_1 
L26:    invokestatic [3] 
L29:    invokevirtual [12] 
L32:    pop 
L33:    aload_3 
L34:    areturn 
L35:    nop 
L36:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [14] 
.const [3] = Method [15] [16] 
.const [4] = Class [17] 
.const [5] = Class [18] 
.const [6] = Class [19] 
.const [7] = Class [20] 
.const [8] = Class [21] 
.const [9] = Method [22] [23] 
.const [10] = Field [24] [25] 
.const [11] = Field [26] [27] 
.const [12] = Method [28] [29] 
.const [13] = Method [30] [31] 
.const [14] = Utf8 '[BAPIndicationHandlerPhone2#evaluateGetArrayIndication] function is not an array or not supported yet (%1)' 
.const [15] = Class [32] 
.const [16] = NameAndType [33] [34] 
.const [17] = Utf8 de/audi/app/combi/bap/app/phone2/BAPIndicationHandlerPhone2 
.const [18] = Utf8 de/audi/app/bap/generated/phone2/AbstractBAPIndicationHandlerPhone2 
.const [19] = Utf8 de/audi/app/combi/bap/app/phone2/CombiModulePhone2 
.const [20] = Utf8 de/audi/app/bap/utils/FunctionIDs 
.const [21] = Utf8 de/audi/atip/log/LogChannel 
.const [22] = Class [35] 
.const [23] = NameAndType [36] [37] 
.const [24] = Class [38] 
.const [25] = NameAndType [39] [40] 
.const [26] = Class [41] 
.const [27] = NameAndType [42] [43] 
.const [28] = Class [44] 
.const [29] = NameAndType [45] [46] 
.const [30] = Class [47] 
.const [31] = NameAndType [48] [49] 
.const [32] = Utf8 de/audi/app/bap/utils/FunctionIDs 
.const [33] = Utf8 getDescription 
.const [34] = Utf8 (II)Ljava/lang/String; 
.const [35] = Utf8 de/audi/app/combi/bap/app/phone2/CombiModulePhone2 
.const [36] = Utf8 getLogChannel 
.const [37] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [38] = Utf8 de/audi/app/combi/bap/app/phone2/BAPIndicationHandlerPhone2 
.const [39] = Utf8 logChannel 
.const [40] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [41] = Utf8 de/audi/app/combi/bap/app/phone2/BAPIndicationHandlerPhone2 
.const [42] = Utf8 lsgID 
.const [43] = Utf8 I 
.const [44] = Utf8 de/audi/atip/log/LogChannel 
.const [45] = Utf8 log 
.const [46] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [47] = Utf8 de/audi/app/bap/generated/phone2/AbstractBAPIndicationHandlerPhone2 
.const [48] = Utf8 <init> 
.const [49] = Utf8 (Lde/audi/app/bap/fw/AbstractBAPModuleFSG;Lde/audi/atip/log/LogChannel;)V 
.const [50] = Utf8 de/audi/app/combi/bap/app/phone2/BAPIndicationHandlerPhone2 
.const [51] = Class [50] 
.const [52] = Utf8 de/audi/app/bap/generated/phone2/AbstractBAPIndicationHandlerPhone2 
.const [53] = Class [52] 
.const [54] = Utf8 Code 
.const [55] = Utf8 <init> 
.const [56] = Utf8 (Lde/audi/app/combi/bap/app/phone2/CombiModulePhone2;)V 
.const [57] = Utf8 evaluateGetArrayIndication 
.const [58] = Utf8 (ILde/vw/mib/bap/requests/GetArray;)Lde/audi/app/bap/fw/arrays/GetArrayIndication; 
.end class 
