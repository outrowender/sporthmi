.version 50 0 
.class public super [94] 
.super [96] 

.method public [98] : [99] 
    .attribute [97] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     ldc [2] 
L4:     invokespecial [16] 
L7:     return 
L8:     
    .end code 
.end method 

.method public [100] : [101] 
    .attribute [97] .code stack 3 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     iload_2 
L3:     invokespecial [17] 
L6:     return 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [102] : [103] 
    .attribute [97] .code stack 3 locals 2 
L0:     aload_0 
L1:     getfield [11] 
L4:     ldc [3] 
L6:     ldc [4] 
L8:     invokevirtual [12] 
L11:    pop 
L12:    aload_0 
L13:    getfield [13] 
L16:    bipush 54 
L18:    invokevirtual [14] 
L21:    astore 5 
L23:    new [19] 
L26:    dup 
L27:    invokespecial [18] 
L30:    astore 6 
L32:    aload 6 
L34:    iload_1 
L35:    ifeq L42 
L38:    iconst_0 
L39:    goto L43 
L42:    iconst_1 
L43:    putfield [20] 
L46:    aload 6 
L48:    iload_2 
L49:    putfield [21] 
L52:    aload 6 
L54:    iload_3 
L55:    putfield [22] 
L58:    aload 6 
L60:    iload 4 
L62:    putfield [23] 
L65:    aload 5 
L67:    aload 6 
L69:    invokevirtual [15] 
L72:    return 
L73:    nop 
L74:    nop 
L75:    nop 
L76:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [24] 
.const [3] = Int -2137614336 
.const [4] = String [25] 
.const [5] = Class [26] 
.const [6] = Class [27] 
.const [7] = Class [28] 
.const [8] = Class [29] 
.const [9] = Class [30] 
.const [10] = Class [31] 
.const [11] = Field [32] [33] 
.const [12] = Method [34] [35] 
.const [13] = Field [36] [37] 
.const [14] = Method [38] [39] 
.const [15] = Method [40] [41] 
.const [16] = Method [42] [43] 
.const [17] = Method [44] [45] 
.const [18] = Method [46] [47] 
.const [19] = Class [48] 
.const [20] = Field [49] [50] 
.const [21] = Field [51] [52] 
.const [22] = Field [53] [54] 
.const [23] = Field [55] [56] 
.const [24] = Utf8 FavoriteNumbersListHandler 
.const [25] = Utf8 '[FavoriteNumbersListHandler#getNextListPosResult]' 
.const [26] = Utf8 de/vw/mib/bap/generated/telephone/serializer/GetNextListPos_Result 
.const [27] = Utf8 de/audi/app/combi/bap/app/phone/list/FavoriteNumbersListHandler 
.const [28] = Utf8 de/audi/app/bap/fw/arrays/AbstractManagedListHandler 
.const [29] = Utf8 de/audi/atip/log/LogChannel 
.const [30] = Utf8 de/audi/app/bap/fw/AbstractBAPModuleFSG 
.const [31] = Utf8 de/audi/app/bap/fw/functiontypes/BAPFunctionMethodFSG 
.const [32] = Class [57] 
.const [33] = NameAndType [58] [59] 
.const [34] = Class [60] 
.const [35] = NameAndType [61] [62] 
.const [36] = Class [63] 
.const [37] = NameAndType [64] [65] 
.const [38] = Class [66] 
.const [39] = NameAndType [67] [68] 
.const [40] = Class [69] 
.const [41] = NameAndType [70] [71] 
.const [42] = Class [72] 
.const [43] = NameAndType [73] [74] 
.const [44] = Class [75] 
.const [45] = NameAndType [76] [77] 
.const [46] = Class [78] 
.const [47] = NameAndType [79] [80] 
.const [48] = Utf8 de/vw/mib/bap/generated/telephone/serializer/GetNextListPos_Result 
.const [49] = Class [81] 
.const [50] = NameAndType [82] [83] 
.const [51] = Class [84] 
.const [52] = NameAndType [85] [86] 
.const [53] = Class [87] 
.const [54] = NameAndType [88] [89] 
.const [55] = Class [90] 
.const [56] = NameAndType [91] [92] 
.const [57] = Utf8 de/audi/app/combi/bap/app/phone/list/FavoriteNumbersListHandler 
.const [58] = Utf8 logChannel 
.const [59] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [60] = Utf8 de/audi/atip/log/LogChannel 
.const [61] = Utf8 log 
.const [62] = Utf8 (ILjava/lang/String;)Z 
.const [63] = Utf8 de/audi/app/combi/bap/app/phone/list/FavoriteNumbersListHandler 
.const [64] = Utf8 moduleFsg 
.const [65] = Utf8 Lde/audi/app/bap/fw/AbstractBAPModuleFSG; 
.const [66] = Utf8 de/audi/app/bap/fw/AbstractBAPModuleFSG 
.const [67] = Utf8 getBAPFunctionMethodFSG 
.const [68] = Utf8 (I)Lde/audi/app/bap/fw/functiontypes/BAPFunctionMethodFSG; 
.const [69] = Utf8 de/audi/app/bap/fw/functiontypes/BAPFunctionMethodFSG 
.const [70] = Utf8 resultREQ 
.const [71] = Utf8 (Lde/vw/mib/bap/requests/ResultMethod;)V 
.const [72] = Utf8 de/audi/app/bap/fw/arrays/AbstractManagedListHandler 
.const [73] = Utf8 <init> 
.const [74] = Utf8 (Lde/audi/app/bap/fw/AbstractBAPModuleFSG;Ljava/lang/String;)V 
.const [75] = Utf8 de/audi/app/bap/fw/arrays/AbstractManagedListHandler 
.const [76] = Utf8 getNextListPosForConsecutiveIds 
.const [77] = Utf8 (II)V 
.const [78] = Utf8 de/vw/mib/bap/generated/telephone/serializer/GetNextListPos_Result 
.const [79] = Utf8 <init> 
.const [80] = Utf8 ()V 
.const [81] = Utf8 de/vw/mib/bap/generated/telephone/serializer/GetNextListPos_Result 
.const [82] = Utf8 getNextListPos_Result 
.const [83] = Utf8 I 
.const [84] = Utf8 de/vw/mib/bap/generated/telephone/serializer/GetNextListPos_Result 
.const [85] = Utf8 currentPos 
.const [86] = Utf8 I 
.const [87] = Utf8 de/vw/mib/bap/generated/telephone/serializer/GetNextListPos_Result 
.const [88] = Utf8 nextPos 
.const [89] = Utf8 I 
.const [90] = Utf8 de/vw/mib/bap/generated/telephone/serializer/GetNextListPos_Result 
.const [91] = Utf8 absoluteListPos 
.const [92] = Utf8 I 
.const [93] = Utf8 de/audi/app/combi/bap/app/phone/list/FavoriteNumbersListHandler 
.const [94] = Class [93] 
.const [95] = Utf8 de/audi/app/bap/fw/arrays/AbstractManagedListHandler 
.const [96] = Class [95] 
.const [97] = Utf8 Code 
.const [98] = Utf8 <init> 
.const [99] = Utf8 (Lde/audi/app/combi/bap/app/phone/CombiModulePhone;)V 
.const [100] = Utf8 getNextListPos 
.const [101] = Utf8 (II)V 
.const [102] = Utf8 getNextListPosResult 
.const [103] = Utf8 (ZIII)V 
.end class 
