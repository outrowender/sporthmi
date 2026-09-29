.version 50 0 
.class public super [63] 
.super [65] 
.field public static final [66] [67] 
.field public static final [68] [69] 
.field public static final [70] [71] 
.field public static final [72] [73] 
.field public static final [74] [75] 
.field private final [76] [77] 
.field private final [78] [79] 
.field private final [80] [81] 

.method public [83] : [84] 
    .attribute [82] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [9] 
L4:     aload_0 
L5:     aload_1 
L6:     sipush 466 
L9:     invokeinterface [10] 0 
L14:    putfield [11] 
L17:    aload_0 
L18:    aload_1 
L19:    sipush 469 
L22:    invokeinterface [10] 0 
L27:    putfield [12] 
L30:    aload_0 
L31:    aload_1 
L32:    sipush 467 
L35:    invokeinterface [10] 0 
L40:    putfield [13] 
L43:    return 
L44:    
    .end code 
.end method 

.method public [85] : [86] 
    .attribute [82] .code stack 1 locals 1 
L0:     aload_0 
L1:     getfield [5] 
L4:     tableswitch 3 
            L40 
            L74 
            L211 
            L211 
            L148 
            default : L211 

L40:    aload_0 
L41:    getfield [6] 
L44:    lookupswitch 
            7 : L64 
            default : L69 

L64:    iconst_3 
L65:    istore_1 
L66:    goto L213 
L69:    iconst_m1 
L70:    istore_1 
L71:    goto L213 
L74:    aload_0 
L75:    getfield [6] 
L78:    lookupswitch 
            2 : L104 
            9 : L138 
            default : L143 

L104:   aload_0 
L105:   getfield [7] 
L108:   lookupswitch 
            6 : L128 
            default : L133 

L128:   iconst_2 
L129:   istore_1 
L130:   goto L213 
L133:   iconst_m1 
L134:   istore_1 
L135:   goto L213 
L138:   iconst_1 
L139:   istore_1 
L140:   goto L213 
L143:   iconst_m1 
L144:   istore_1 
L145:   goto L213 
L148:   aload_0 
L149:   getfield [6] 
L152:   lookupswitch 
            3 : L172 
            default : L206 

L172:   aload_0 
L173:   getfield [7] 
L176:   lookupswitch 
            6 : L196 
            default : L201 

L196:   iconst_0 
L197:   istore_1 
L198:   goto L213 
L201:   iconst_m1 
L202:   istore_1 
L203:   goto L213 
L206:   iconst_m1 
L207:   istore_1 
L208:   goto L213 
L211:   iconst_m1 
L212:   istore_1 
L213:   iload_1 
L214:   areturn 
L215:   nop 
L216:   
    .end code 
.end method 

.method public [87] : [88] 
    .attribute [82] .code stack 2 locals 0 
L0:     iconst_0 
L1:     aload_0 
L2:     invokevirtual [8] 
L5:     if_icmpeq L24 
L8:     iconst_1 
L9:     aload_0 
L10:    invokevirtual [8] 
L13:    if_icmpeq L24 
L16:    iconst_2 
L17:    aload_0 
L18:    invokevirtual [8] 
L21:    if_icmpne L28 
L24:    iconst_1 
L25:    goto L29 
L28:    iconst_0 
L29:    areturn 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [89] : [90] 
    .attribute [82] .code stack 2 locals 0 
L0:     iconst_3 
L1:     aload_0 
L2:     invokevirtual [8] 
L5:     if_icmpne L12 
L8:     iconst_1 
L9:     goto L13 
L12:    iconst_0 
L13:    areturn 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [14] 
.const [3] = Class [15] 
.const [4] = Class [16] 
.const [5] = Field [17] [18] 
.const [6] = Field [19] [20] 
.const [7] = Field [21] [22] 
.const [8] = Method [23] [24] 
.const [9] = Method [25] [26] 
.const [10] = InterfaceMethod [27] [28] 
.const [11] = Field [29] [30] 
.const [12] = Field [31] [32] 
.const [13] = Field [33] [34] 
.const [14] = Utf8 de/audi/app/earlyfunc/core/hybrid/CarNetworkPlatformInfo 
.const [15] = Utf8 java/lang/Object 
.const [16] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [17] = Class [35] 
.const [18] = NameAndType [36] [37] 
.const [19] = Class [38] 
.const [20] = NameAndType [39] [40] 
.const [21] = Class [41] 
.const [22] = NameAndType [42] [43] 
.const [23] = Class [44] 
.const [24] = NameAndType [45] [46] 
.const [25] = Class [47] 
.const [26] = NameAndType [48] [49] 
.const [27] = Class [50] 
.const [28] = NameAndType [51] [52] 
.const [29] = Class [53] 
.const [30] = NameAndType [54] [55] 
.const [31] = Class [56] 
.const [32] = NameAndType [57] [58] 
.const [33] = Class [59] 
.const [34] = NameAndType [60] [61] 
.const [35] = Utf8 de/audi/app/earlyfunc/core/hybrid/CarNetworkPlatformInfo 
.const [36] = Utf8 carClass 
.const [37] = Utf8 I 
.const [38] = Utf8 de/audi/app/earlyfunc/core/hybrid/CarNetworkPlatformInfo 
.const [39] = Utf8 carGeneration 
.const [40] = Utf8 I 
.const [41] = Utf8 de/audi/app/earlyfunc/core/hybrid/CarNetworkPlatformInfo 
.const [42] = Utf8 carDerivate 
.const [43] = Utf8 I 
.const [44] = Utf8 de/audi/app/earlyfunc/core/hybrid/CarNetworkPlatformInfo 
.const [45] = Utf8 getCarType 
.const [46] = Utf8 ()I 
.const [47] = Utf8 java/lang/Object 
.const [48] = Utf8 <init> 
.const [49] = Utf8 ()V 
.const [50] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [51] = Utf8 getSysConst 
.const [52] = Utf8 (I)I 
.const [53] = Utf8 de/audi/app/earlyfunc/core/hybrid/CarNetworkPlatformInfo 
.const [54] = Utf8 carClass 
.const [55] = Utf8 I 
.const [56] = Utf8 de/audi/app/earlyfunc/core/hybrid/CarNetworkPlatformInfo 
.const [57] = Utf8 carGeneration 
.const [58] = Utf8 I 
.const [59] = Utf8 de/audi/app/earlyfunc/core/hybrid/CarNetworkPlatformInfo 
.const [60] = Utf8 carDerivate 
.const [61] = Utf8 I 
.const [62] = Utf8 de/audi/app/earlyfunc/core/hybrid/CarNetworkPlatformInfo 
.const [63] = Class [62] 
.const [64] = Utf8 java/lang/Object 
.const [65] = Class [64] 
.const [66] = Utf8 CAR_TYPE_DEFAULT 
.const [67] = Utf8 I 
.const [68] = Utf8 CAR_TYPE_AU736 
.const [69] = Utf8 I 
.const [70] = Utf8 CAR_TYPE_AU49X 
.const [71] = Utf8 I 
.const [72] = Utf8 CAR_TYPE_AU426 
.const [73] = Utf8 I 
.const [74] = Utf8 CAR_TYPE_AU37x 
.const [75] = Utf8 I 
.const [76] = Utf8 carClass 
.const [77] = Utf8 I 
.const [78] = Utf8 carGeneration 
.const [79] = Utf8 I 
.const [80] = Utf8 carDerivate 
.const [81] = Utf8 I 
.const [82] = Utf8 Code 
.const [83] = Utf8 <init> 
.const [84] = Utf8 (Lde/audi/atip/base/IFrameworkAccess;)V 
.const [85] = Utf8 getCarType 
.const [86] = Utf8 ()I 
.const [87] = Utf8 isMLBEvo 
.const [88] = Utf8 ()Z 
.const [89] = Utf8 isAU37x 
.const [90] = Utf8 ()Z 
.end class 
