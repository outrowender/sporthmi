.version 50 0 
.class public final super [37] 
.super [39] 
.implements [41] 
.field private volatile [42] [43] 
.field private volatile [44] [45] 

.method public [47] : [48] 
    .attribute [46] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [6] 
L4:     aload_0 
L5:     iconst_0 
L6:     putfield [7] 
L9:     aload_0 
L10:    iconst_m1 
L11:    putfield [8] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public synchronized [49] : [50] 
    .attribute [46] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [4] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public synchronized [51] : [52] 
    .attribute [46] .code stack 2 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     putfield [7] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public synchronized [53] : [54] 
    .attribute [46] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [5] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public synchronized [55] : [56] 
    .attribute [46] .code stack 2 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     putfield [8] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public synchronized [57] : [58] 
    .attribute [46] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [4] 
L4:     iconst_4 
L5:     if_icmpne L23 
L8:     aload_0 
L9:     getfield [5] 
L12:    bipush 7 
L14:    if_icmpne L21 
L17:    iconst_1 
L18:    goto L22 
L21:    iconst_0 
L22:    areturn 
L23:    aload_0 
L24:    getfield [4] 
L27:    iconst_2 
L28:    if_icmpeq L39 
L31:    aload_0 
L32:    getfield [4] 
L35:    iconst_3 
L36:    if_icmpne L41 
L39:    iconst_0 
L40:    areturn 
L41:    iconst_1 
L42:    areturn 
L43:    nop 
L44:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [9] 
.const [3] = Class [10] 
.const [4] = Field [11] [12] 
.const [5] = Field [13] [14] 
.const [6] = Method [15] [16] 
.const [7] = Field [17] [18] 
.const [8] = Field [19] [20] 
.const [9] = Utf8 de/audi/app/bap/PowerState 
.const [10] = Utf8 java/lang/Object 
.const [11] = Class [21] 
.const [12] = NameAndType [22] [23] 
.const [13] = Class [24] 
.const [14] = NameAndType [25] [26] 
.const [15] = Class [27] 
.const [16] = NameAndType [28] [29] 
.const [17] = Class [30] 
.const [18] = NameAndType [31] [32] 
.const [19] = Class [33] 
.const [20] = NameAndType [34] [35] 
.const [21] = Utf8 de/audi/app/bap/PowerState 
.const [22] = Utf8 powerState 
.const [23] = Utf8 I 
.const [24] = Utf8 de/audi/app/bap/PowerState 
.const [25] = Utf8 powerStateTrigger 
.const [26] = Utf8 I 
.const [27] = Utf8 java/lang/Object 
.const [28] = Utf8 <init> 
.const [29] = Utf8 ()V 
.const [30] = Utf8 de/audi/app/bap/PowerState 
.const [31] = Utf8 powerState 
.const [32] = Utf8 I 
.const [33] = Utf8 de/audi/app/bap/PowerState 
.const [34] = Utf8 powerStateTrigger 
.const [35] = Utf8 I 
.const [36] = Utf8 de/audi/app/bap/PowerState 
.const [37] = Class [36] 
.const [38] = Utf8 java/lang/Object 
.const [39] = Class [38] 
.const [40] = Utf8 de/audi/app/bap/IPowerState 
.const [41] = Class [40] 
.const [42] = Utf8 powerState 
.const [43] = Utf8 I 
.const [44] = Utf8 powerStateTrigger 
.const [45] = Utf8 I 
.const [46] = Utf8 Code 
.const [47] = Utf8 <init> 
.const [48] = Utf8 ()V 
.const [49] = Utf8 getPowerState 
.const [50] = Utf8 ()I 
.const [51] = Utf8 setPowerState 
.const [52] = Utf8 (I)V 
.const [53] = Utf8 getPowerStateTrigger 
.const [54] = Utf8 ()I 
.const [55] = Utf8 setPowerStateTrigger 
.const [56] = Utf8 (I)V 
.const [57] = Utf8 isPowerOn 
.const [58] = Utf8 ()Z 
.end class 
