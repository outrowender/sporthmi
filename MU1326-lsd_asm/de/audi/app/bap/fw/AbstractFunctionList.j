.version 50 0 
.class public super abstract [31] 
.super [33] 
.field protected [34] [35] 

.method public annotation [37] : [38] 
    .attribute [36] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [7] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method protected abstract [39] : [40] 
    .attribute [36] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method protected abstract [41] : [42] 
    .attribute [36] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method public abstract [43] : [44] 
    .attribute [36] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method public abstract [45] : [46] 
    .attribute [36] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method public abstract [47] : [48] 
    .attribute [36] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method public abstract [49] : [50] 
    .attribute [36] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method public [51] : [52] 
    .attribute [36] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [4] 
L4:     iload_1 
L5:     baload 
L6:     areturn 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [53] : [54] 
    .attribute [36] .code stack 2 locals 0 
L0:     iload_1 
L1:     ifle L16 
L4:     iload_1 
L5:     aload_0 
L6:     invokevirtual [5] 
L9:     if_icmpgt L16 
L12:    iconst_1 
L13:    goto L17 
L16:    iconst_0 
L17:    areturn 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [55] : [56] 
    .attribute [36] .code stack 2 locals 0 
L0:     iload_1 
L1:     aload_0 
L2:     invokevirtual [6] 
L5:     if_icmplt L20 
L8:     iload_1 
L9:     aload_0 
L10:    invokevirtual [5] 
L13:    if_icmpgt L20 
L16:    iconst_1 
L17:    goto L21 
L20:    iconst_0 
L21:    areturn 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [8] 
.const [3] = Class [9] 
.const [4] = Field [10] [11] 
.const [5] = Method [12] [13] 
.const [6] = Method [14] [15] 
.const [7] = Method [16] [17] 
.const [8] = Utf8 de/audi/app/bap/fw/AbstractFunctionList 
.const [9] = Utf8 java/lang/Object 
.const [10] = Class [18] 
.const [11] = NameAndType [19] [20] 
.const [12] = Class [21] 
.const [13] = NameAndType [22] [23] 
.const [14] = Class [24] 
.const [15] = NameAndType [25] [26] 
.const [16] = Class [27] 
.const [17] = NameAndType [28] [29] 
.const [18] = Utf8 de/audi/app/bap/fw/AbstractFunctionList 
.const [19] = Utf8 functionSupported 
.const [20] = Utf8 [Z 
.const [21] = Utf8 de/audi/app/bap/fw/AbstractFunctionList 
.const [22] = Utf8 getMaxFctID 
.const [23] = Utf8 ()I 
.const [24] = Utf8 de/audi/app/bap/fw/AbstractFunctionList 
.const [25] = Utf8 getMinModuleSpecificFctID 
.const [26] = Utf8 ()I 
.const [27] = Utf8 java/lang/Object 
.const [28] = Utf8 <init> 
.const [29] = Utf8 ()V 
.const [30] = Utf8 de/audi/app/bap/fw/AbstractFunctionList 
.const [31] = Class [30] 
.const [32] = Utf8 java/lang/Object 
.const [33] = Class [32] 
.const [34] = Utf8 functionSupported 
.const [35] = Utf8 [Z 
.const [36] = Utf8 Code 
.const [37] = Utf8 <init> 
.const [38] = Utf8 ()V 
.const [39] = Utf8 getMinModuleSpecificFctID 
.const [40] = Utf8 ()I 
.const [41] = Utf8 getMaxFctID 
.const [42] = Utf8 ()I 
.const [43] = Utf8 getGetAllFctID 
.const [44] = Utf8 ()I 
.const [45] = Utf8 getBAPConfigBAPFctID 
.const [46] = Utf8 ()I 
.const [47] = Utf8 getFctListBAPFctID 
.const [48] = Utf8 ()I 
.const [49] = Utf8 getOperationStateBAPFctID 
.const [50] = Utf8 ()I 
.const [51] = Utf8 isFunctionSupported 
.const [52] = Utf8 (I)Z 
.const [53] = Utf8 isInRange 
.const [54] = Utf8 (I)Z 
.const [55] = Utf8 isInModuleSpecificRange 
.const [56] = Utf8 (I)Z 
.end class 
