.version 50 0 
.class public super abstract [92] 
.super [94] 
.field protected static final [95] [96] 
.field protected static final [97] [98] 
.field protected static final [99] [100] 
.field protected static final [101] [102] 
.field protected [103] [104] 

.method public annotation [106] : [107] 
    .attribute [105] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [16] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [108] : [109] 
    .attribute [105] .code stack 7 locals 4 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [17] 
L5:     aload_1 
L6:     invokevirtual [12] 
L9:     astore_2 
L10:    aload_2 
L11:    invokeinterface [18] 0 
L16:    invokeinterface [19] 0 
L21:    bipush 22 
L23:    invokeinterface [20] 0 
L28:    istore_3 
L29:    aload_2 
L30:    invokeinterface [21] 0 
L35:    iconst_4 
L36:    if_icmpne L51 
L39:    iload_3 
L40:    ifeq L47 
L43:    iconst_3 
L44:    goto L68 
L47:    iconst_2 
L48:    goto L68 
L51:    aload_2 
L52:    sipush 523 
L55:    invokeinterface [22] 0 
L60:    ifne L67 
L63:    iconst_0 
L64:    goto L68 
L67:    iconst_1 
L68:    istore 4 
L70:    aload_2 
L71:    sipush 442 
L74:    invokeinterface [22] 0 
L79:    istore 5 
L81:    aload_0 
L82:    getfield [11] 
L85:    invokevirtual [13] 
L88:    ldc [2] 
L90:    ldc [3] 
L92:    iload 4 
L94:    i2l 
L95:    iload 5 
L97:    i2l 
L98:    invokevirtual [14] 
L101:   pop 
L102:   aload_0 
L103:   iload 4 
L105:   iload 5 
L107:   invokevirtual [15] 
L110:   return 
L111:   nop 
L112:   
    .end code 
.end method 

.method protected abstract [110] : [111] 
    .attribute [105] .code stack 0 locals 0 
L0:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int -2137614336 
.const [3] = String [23] 
.const [4] = Class [24] 
.const [5] = Class [25] 
.const [6] = Class [26] 
.const [7] = Class [27] 
.const [8] = Class [28] 
.const [9] = Class [29] 
.const [10] = Class [30] 
.const [11] = Field [31] [32] 
.const [12] = Method [33] [34] 
.const [13] = Method [35] [36] 
.const [14] = Method [37] [38] 
.const [15] = Method [39] [40] 
.const [16] = Method [41] [42] 
.const [17] = Field [43] [44] 
.const [18] = InterfaceMethod [45] [46] 
.const [19] = InterfaceMethod [47] [48] 
.const [20] = InterfaceMethod [49] [50] 
.const [21] = InterfaceMethod [51] [52] 
.const [22] = InterfaceMethod [53] [54] 
.const [23] = Utf8 '[AbstractFunctionListFSG#AbstractFunctionListFSG] variant: %1 region: %2' 
.const [24] = Utf8 de/audi/app/bap/fw/AbstractFunctionListFSG 
.const [25] = Utf8 de/audi/app/bap/fw/AbstractFunctionList 
.const [26] = Utf8 de/audi/app/bap/fw/AbstractBAPModuleFSG 
.const [27] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [28] = Utf8 de/audi/atip/sysapp/carcoding/ISysConstManager 
.const [29] = Utf8 de/audi/atip/sysapp/carcoding/CarFuncAdap 
.const [30] = Utf8 de/audi/atip/log/LogChannel 
.const [31] = Class [55] 
.const [32] = NameAndType [56] [57] 
.const [33] = Class [58] 
.const [34] = NameAndType [59] [60] 
.const [35] = Class [61] 
.const [36] = NameAndType [62] [63] 
.const [37] = Class [64] 
.const [38] = NameAndType [65] [66] 
.const [39] = Class [67] 
.const [40] = NameAndType [68] [69] 
.const [41] = Class [70] 
.const [42] = NameAndType [71] [72] 
.const [43] = Class [73] 
.const [44] = NameAndType [74] [75] 
.const [45] = Class [76] 
.const [46] = NameAndType [77] [78] 
.const [47] = Class [79] 
.const [48] = NameAndType [80] [81] 
.const [49] = Class [82] 
.const [50] = NameAndType [83] [84] 
.const [51] = Class [85] 
.const [52] = NameAndType [86] [87] 
.const [53] = Class [88] 
.const [54] = NameAndType [89] [90] 
.const [55] = Utf8 de/audi/app/bap/fw/AbstractFunctionListFSG 
.const [56] = Utf8 moduleFsg 
.const [57] = Utf8 Lde/audi/app/bap/fw/AbstractBAPModuleFSG; 
.const [58] = Utf8 de/audi/app/bap/fw/AbstractBAPModuleFSG 
.const [59] = Utf8 getFrameworkAccess 
.const [60] = Utf8 ()Lde/audi/atip/base/IFrameworkAccess; 
.const [61] = Utf8 de/audi/app/bap/fw/AbstractBAPModuleFSG 
.const [62] = Utf8 getLogChannel 
.const [63] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [64] = Utf8 de/audi/atip/log/LogChannel 
.const [65] = Utf8 log 
.const [66] = Utf8 (ILjava/lang/String;JJ)Z 
.const [67] = Utf8 de/audi/app/bap/fw/AbstractFunctionListFSG 
.const [68] = Utf8 initFunctionListStatusWithVariantAndRegion 
.const [69] = Utf8 (II)V 
.const [70] = Utf8 de/audi/app/bap/fw/AbstractFunctionList 
.const [71] = Utf8 <init> 
.const [72] = Utf8 ()V 
.const [73] = Utf8 de/audi/app/bap/fw/AbstractFunctionListFSG 
.const [74] = Utf8 moduleFsg 
.const [75] = Utf8 Lde/audi/app/bap/fw/AbstractBAPModuleFSG; 
.const [76] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [77] = Utf8 getSysConstManager 
.const [78] = Utf8 ()Lde/audi/atip/sysapp/carcoding/ISysConstManager; 
.const [79] = Utf8 de/audi/atip/sysapp/carcoding/ISysConstManager 
.const [80] = Utf8 getCarFuncAdaptation 
.const [81] = Utf8 ()Lde/audi/atip/sysapp/carcoding/CarFuncAdap; 
.const [82] = Utf8 de/audi/atip/sysapp/carcoding/CarFuncAdap 
.const [83] = Utf8 isMenuDisplayActivated 
.const [84] = Utf8 (S)Z 
.const [85] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [86] = Utf8 getKombiType 
.const [87] = Utf8 ()I 
.const [88] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [89] = Utf8 getSysConst 
.const [90] = Utf8 (I)I 
.const [91] = Utf8 de/audi/app/bap/fw/AbstractFunctionListFSG 
.const [92] = Class [91] 
.const [93] = Utf8 de/audi/app/bap/fw/AbstractFunctionList 
.const [94] = Class [93] 
.const [95] = Utf8 AUDI_VARIANT_STD 
.const [96] = Utf8 I 
.const [97] = Utf8 AUDI_VARIANT_HIGH_PREM 
.const [98] = Utf8 I 
.const [99] = Utf8 AUDI_VARIANT_MMIKOMBI 
.const [100] = Utf8 I 
.const [101] = Utf8 AUDI_VARIANT_MMIKOMBI_HUD 
.const [102] = Utf8 I 
.const [103] = Utf8 moduleFsg 
.const [104] = Utf8 Lde/audi/app/bap/fw/AbstractBAPModuleFSG; 
.const [105] = Utf8 Code 
.const [106] = Utf8 <init> 
.const [107] = Utf8 ()V 
.const [108] = Utf8 init 
.const [109] = Utf8 (Lde/audi/app/bap/fw/AbstractBAPModuleFSG;)V 
.const [110] = Utf8 initFunctionListStatusWithVariantAndRegion 
.const [111] = Utf8 (II)V 
.end class 
