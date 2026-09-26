.version 50 0 
.class public super [79] 
.super [81] 
.implements [83] 
.field protected final [84] [85] 
.field protected [86] [87] 
.field private [88] [89] 

.method public [91] : [92] 
    .attribute [90] .code stack 5 locals 1 
L0:     aload_0 
L1:     invokespecial [14] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [16] 
L9:     aload_0 
L10:    new [17] 
L13:    dup 
L14:    iconst_0 
L15:    aload_0 
L16:    invokespecial [15] 
L19:    putfield [18] 
        .catch [4] from L22 to L28 using L31 
L22:    aload_0 
L23:    ldc [3] 
L25:    invokevirtual [10] 
L28:    goto L46 
L31:    astore_2 
L32:    aload_1 
L33:    sipush 10000 
L36:    ldc [5] 
L38:    invokevirtual [11] 
L41:    pop 
L42:    aload_2 
L43:    invokevirtual [12] 
L46:    return 
L47:    nop 
L48:    
    .end code 
.end method 

.method public [93] : [94] 
    .attribute [90] .code stack 2 locals 0 
L0:     aconst_null 
L1:     aload_0 
L2:     getfield [13] 
L5:     if_acmpeq L12 
L8:     iconst_1 
L9:     goto L13 
L12:    iconst_0 
L13:    areturn 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [95] : [96] 
    .attribute [90] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [19] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [97] : [98] 
    .attribute [90] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [9] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public enum [99] : [100] 
    .attribute [90] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public enum [101] : [102] 
    .attribute [90] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [20] 
.const [3] = String [21] 
.const [4] = Class [22] 
.const [5] = String [23] 
.const [6] = Class [24] 
.const [7] = Class [25] 
.const [8] = Class [26] 
.const [9] = Field [27] [28] 
.const [10] = Method [29] [30] 
.const [11] = Method [31] [32] 
.const [12] = Method [33] [34] 
.const [13] = Field [35] [36] 
.const [14] = Method [37] [38] 
.const [15] = Method [39] [40] 
.const [16] = Field [41] [42] 
.const [17] = Class [43] 
.const [18] = Field [44] [45] 
.const [19] = Field [46] [47] 
.const [20] = Utf8 de/esolutions/fw/comm/asi/hmisync/car/zeroemission/impl/ASIHMISyncCarZeroEmissionService 
.const [21] = Utf8 '1.1.00' 
.const [22] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [23] = Utf8 '[CarZeroEmissionASIProvider] Could not register ASI version!' 
.const [24] = Utf8 de/audi/app/car/sdis/CarZeroEmissionASIProvider 
.const [25] = Utf8 de/esolutions/fw/comm/asi/hmisync/car/zeroemission/impl/ASIHMISyncCarZeroEmissionAbstractBaseService 
.const [26] = Utf8 de/audi/atip/log/LogChannel 
.const [27] = Class [48] 
.const [28] = NameAndType [49] [50] 
.const [29] = Class [51] 
.const [30] = NameAndType [52] [53] 
.const [31] = Class [54] 
.const [32] = NameAndType [55] [56] 
.const [33] = Class [57] 
.const [34] = NameAndType [58] [59] 
.const [35] = Class [60] 
.const [36] = NameAndType [61] [62] 
.const [37] = Class [63] 
.const [38] = NameAndType [64] [65] 
.const [39] = Class [66] 
.const [40] = NameAndType [67] [68] 
.const [41] = Class [69] 
.const [42] = NameAndType [70] [71] 
.const [43] = Utf8 de/esolutions/fw/comm/asi/hmisync/car/zeroemission/impl/ASIHMISyncCarZeroEmissionService 
.const [44] = Class [72] 
.const [45] = NameAndType [73] [74] 
.const [46] = Class [75] 
.const [47] = NameAndType [76] [77] 
.const [48] = Utf8 de/audi/app/car/sdis/CarZeroEmissionASIProvider 
.const [49] = Utf8 asiService 
.const [50] = Utf8 Lde/esolutions/fw/comm/asi/hmisync/car/zeroemission/impl/ASIHMISyncCarZeroEmissionService; 
.const [51] = Utf8 de/audi/app/car/sdis/CarZeroEmissionASIProvider 
.const [52] = Utf8 updateASIVersion 
.const [53] = Utf8 (Ljava/lang/String;)V 
.const [54] = Utf8 de/audi/atip/log/LogChannel 
.const [55] = Utf8 log 
.const [56] = Utf8 (ILjava/lang/String;)Z 
.const [57] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [58] = Utf8 printStackTrace 
.const [59] = Utf8 ()V 
.const [60] = Utf8 de/audi/app/car/sdis/CarZeroEmissionASIProvider 
.const [61] = Utf8 zeroEmissionAccess 
.const [62] = Utf8 Lde/audi/app/car/common/sdis/interapp/ISDISZeroEmissionAccess; 
.const [63] = Utf8 de/esolutions/fw/comm/asi/hmisync/car/zeroemission/impl/ASIHMISyncCarZeroEmissionAbstractBaseService 
.const [64] = Utf8 <init> 
.const [65] = Utf8 ()V 
.const [66] = Utf8 de/esolutions/fw/comm/asi/hmisync/car/zeroemission/impl/ASIHMISyncCarZeroEmissionService 
.const [67] = Utf8 <init> 
.const [68] = Utf8 (ILde/esolutions/fw/comm/asi/hmisync/car/zeroemission/ASIHMISyncCarZeroEmissionS;)V 
.const [69] = Utf8 de/audi/app/car/sdis/CarZeroEmissionASIProvider 
.const [70] = Utf8 logChannel 
.const [71] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [72] = Utf8 de/audi/app/car/sdis/CarZeroEmissionASIProvider 
.const [73] = Utf8 asiService 
.const [74] = Utf8 Lde/esolutions/fw/comm/asi/hmisync/car/zeroemission/impl/ASIHMISyncCarZeroEmissionService; 
.const [75] = Utf8 de/audi/app/car/sdis/CarZeroEmissionASIProvider 
.const [76] = Utf8 zeroEmissionAccess 
.const [77] = Utf8 Lde/audi/app/car/common/sdis/interapp/ISDISZeroEmissionAccess; 
.const [78] = Utf8 de/audi/app/car/sdis/CarZeroEmissionASIProvider 
.const [79] = Class [78] 
.const [80] = Utf8 de/esolutions/fw/comm/asi/hmisync/car/zeroemission/impl/ASIHMISyncCarZeroEmissionAbstractBaseService 
.const [81] = Class [80] 
.const [82] = Utf8 de/audi/atip/agent/IASIProvider 
.const [83] = Class [82] 
.const [84] = Utf8 logChannel 
.const [85] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [86] = Utf8 zeroEmissionAccess 
.const [87] = Utf8 Lde/audi/app/car/common/sdis/interapp/ISDISZeroEmissionAccess; 
.const [88] = Utf8 asiService 
.const [89] = Utf8 Lde/esolutions/fw/comm/asi/hmisync/car/zeroemission/impl/ASIHMISyncCarZeroEmissionService; 
.const [90] = Utf8 Code 
.const [91] = Utf8 <init> 
.const [92] = Utf8 (Lde/audi/atip/log/LogChannel;)V 
.const [93] = Utf8 isZeroEmissionAccessAvailable 
.const [94] = Utf8 ()Z 
.const [95] = Utf8 setZeroEmissionAccess 
.const [96] = Utf8 (Lde/audi/app/car/common/sdis/interapp/ISDISZeroEmissionAccess;)V 
.const [97] = Utf8 getService 
.const [98] = Utf8 ()Lde/esolutions/fw/comm/core/IService; 
.const [99] = Utf8 attachStub 
.const [100] = Utf8 (Lde/esolutions/fw/comm/core/IStub;)V 
.const [101] = Utf8 detachStub 
.const [102] = Utf8 (Lde/esolutions/fw/comm/core/IStub;)V 
.end class 
