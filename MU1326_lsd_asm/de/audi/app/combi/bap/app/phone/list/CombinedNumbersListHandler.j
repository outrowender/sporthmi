.version 50 0 
.class public super [128] 
.super [130] 

.method public [132] : [133] 
    .attribute [131] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     ldc [2] 
L4:     invokespecial [22] 
L7:     return 
L8:     
    .end code 
.end method 

.method public [134] : [135] 
    .attribute [131] .code stack 6 locals 0 
L0:     aload_0 
L1:     getfield [13] 
L4:     ldc [3] 
L6:     ldc [4] 
L8:     aload_0 
L9:     getfield [14] 
L12:    aload_1 
L13:    arraylength 
L14:    i2l 
L15:    invokevirtual [15] 
L18:    pop 
L19:    aload_0 
L20:    getfield [16] 
L23:    arraylength 
L24:    ifne L47 
L27:    aload_1 
L28:    arraylength 
L29:    ifne L47 
L32:    aload_0 
L33:    getfield [13] 
L36:    ldc [3] 
L38:    ldc [5] 
L40:    invokevirtual [17] 
L43:    pop 
L44:    goto L57 
L47:    aload_0 
L48:    aload_1 
L49:    putfield [25] 
L52:    aload_0 
L53:    invokevirtual [18] 
L56:    pop 
L57:    return 
L58:    nop 
L59:    nop 
L60:    
    .end code 
.end method 

.method public [136] : [137] 
    .attribute [131] .code stack 3 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     iload_2 
L3:     invokespecial [23] 
L6:     return 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [138] : [139] 
    .attribute [131] .code stack 3 locals 2 
L0:     aload_0 
L1:     getfield [13] 
L4:     ldc [3] 
L6:     ldc [6] 
L8:     invokevirtual [17] 
L11:    pop 
L12:    aload_0 
L13:    getfield [19] 
L16:    bipush 54 
L18:    invokevirtual [20] 
L21:    astore 5 
L23:    new [26] 
L26:    dup 
L27:    invokespecial [24] 
L30:    astore 6 
L32:    aload 6 
L34:    iload_1 
L35:    ifeq L42 
L38:    iconst_0 
L39:    goto L43 
L42:    iconst_1 
L43:    putfield [27] 
L46:    aload 6 
L48:    iload_2 
L49:    putfield [28] 
L52:    aload 6 
L54:    iload_3 
L55:    putfield [29] 
L58:    aload 6 
L60:    iload 4 
L62:    putfield [30] 
L65:    aload 5 
L67:    aload 6 
L69:    invokevirtual [21] 
L72:    return 
L73:    nop 
L74:    nop 
L75:    nop 
L76:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [31] 
.const [3] = Int -2137614336 
.const [4] = String [32] 
.const [5] = String [33] 
.const [6] = String [34] 
.const [7] = Class [35] 
.const [8] = Class [36] 
.const [9] = Class [37] 
.const [10] = Class [38] 
.const [11] = Class [39] 
.const [12] = Class [40] 
.const [13] = Field [41] [42] 
.const [14] = Field [43] [44] 
.const [15] = Method [45] [46] 
.const [16] = Field [47] [48] 
.const [17] = Method [49] [50] 
.const [18] = Method [51] [52] 
.const [19] = Field [53] [54] 
.const [20] = Method [55] [56] 
.const [21] = Method [57] [58] 
.const [22] = Method [59] [60] 
.const [23] = Method [61] [62] 
.const [24] = Method [63] [64] 
.const [25] = Field [65] [66] 
.const [26] = Class [67] 
.const [27] = Field [68] [69] 
.const [28] = Field [70] [71] 
.const [29] = Field [72] [73] 
.const [30] = Field [74] [75] 
.const [31] = Utf8 CombinedNumbersListHandler 
.const [32] = Utf8 '[%1#updateList] listSize=%2' 
.const [33] = Utf8 "[CombinedNumbersListHandler#updateList] list is still empty -> don't send ChangedArray" 
.const [34] = Utf8 '[CombinedNumbersListHandler#getNextListPosResult]' 
.const [35] = Utf8 de/vw/mib/bap/generated/telephone/serializer/GetNextListPos_Result 
.const [36] = Utf8 de/audi/app/combi/bap/app/phone/list/CombinedNumbersListHandler 
.const [37] = Utf8 de/audi/app/bap/fw/arrays/AbstractManagedListHandler 
.const [38] = Utf8 de/audi/atip/log/LogChannel 
.const [39] = Utf8 de/audi/app/bap/fw/AbstractBAPModuleFSG 
.const [40] = Utf8 de/audi/app/bap/fw/functiontypes/BAPFunctionMethodFSG 
.const [41] = Class [76] 
.const [42] = NameAndType [77] [78] 
.const [43] = Class [79] 
.const [44] = NameAndType [80] [81] 
.const [45] = Class [82] 
.const [46] = NameAndType [83] [84] 
.const [47] = Class [85] 
.const [48] = NameAndType [86] [87] 
.const [49] = Class [88] 
.const [50] = NameAndType [89] [90] 
.const [51] = Class [91] 
.const [52] = NameAndType [92] [93] 
.const [53] = Class [94] 
.const [54] = NameAndType [95] [96] 
.const [55] = Class [97] 
.const [56] = NameAndType [98] [99] 
.const [57] = Class [100] 
.const [58] = NameAndType [101] [102] 
.const [59] = Class [103] 
.const [60] = NameAndType [104] [105] 
.const [61] = Class [106] 
.const [62] = NameAndType [107] [108] 
.const [63] = Class [109] 
.const [64] = NameAndType [110] [111] 
.const [65] = Class [112] 
.const [66] = NameAndType [113] [114] 
.const [67] = Utf8 de/vw/mib/bap/generated/telephone/serializer/GetNextListPos_Result 
.const [68] = Class [115] 
.const [69] = NameAndType [116] [117] 
.const [70] = Class [118] 
.const [71] = NameAndType [119] [120] 
.const [72] = Class [121] 
.const [73] = NameAndType [122] [123] 
.const [74] = Class [124] 
.const [75] = NameAndType [125] [126] 
.const [76] = Utf8 de/audi/app/combi/bap/app/phone/list/CombinedNumbersListHandler 
.const [77] = Utf8 logChannel 
.const [78] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [79] = Utf8 de/audi/app/combi/bap/app/phone/list/CombinedNumbersListHandler 
.const [80] = Utf8 className 
.const [81] = Utf8 Ljava/lang/String; 
.const [82] = Utf8 de/audi/atip/log/LogChannel 
.const [83] = Utf8 log 
.const [84] = Utf8 (ILjava/lang/String;Ljava/lang/Object;J)Z 
.const [85] = Utf8 de/audi/app/combi/bap/app/phone/list/CombinedNumbersListHandler 
.const [86] = Utf8 list 
.const [87] = Utf8 [Lde/audi/atip/interapp/combi/bap/data/CombiBAPArrayElement; 
.const [88] = Utf8 de/audi/atip/log/LogChannel 
.const [89] = Utf8 log 
.const [90] = Utf8 (ILjava/lang/String;)Z 
.const [91] = Utf8 de/audi/app/combi/bap/app/phone/list/CombinedNumbersListHandler 
.const [92] = Utf8 sendFullRangeUpdate 
.const [93] = Utf8 ()Z 
.const [94] = Utf8 de/audi/app/combi/bap/app/phone/list/CombinedNumbersListHandler 
.const [95] = Utf8 moduleFsg 
.const [96] = Utf8 Lde/audi/app/bap/fw/AbstractBAPModuleFSG; 
.const [97] = Utf8 de/audi/app/bap/fw/AbstractBAPModuleFSG 
.const [98] = Utf8 getBAPFunctionMethodFSG 
.const [99] = Utf8 (I)Lde/audi/app/bap/fw/functiontypes/BAPFunctionMethodFSG; 
.const [100] = Utf8 de/audi/app/bap/fw/functiontypes/BAPFunctionMethodFSG 
.const [101] = Utf8 resultREQ 
.const [102] = Utf8 (Lde/vw/mib/bap/requests/ResultMethod;)V 
.const [103] = Utf8 de/audi/app/bap/fw/arrays/AbstractManagedListHandler 
.const [104] = Utf8 <init> 
.const [105] = Utf8 (Lde/audi/app/bap/fw/AbstractBAPModuleFSG;Ljava/lang/String;)V 
.const [106] = Utf8 de/audi/app/bap/fw/arrays/AbstractManagedListHandler 
.const [107] = Utf8 getNextListPosForConsecutiveIds 
.const [108] = Utf8 (II)V 
.const [109] = Utf8 de/vw/mib/bap/generated/telephone/serializer/GetNextListPos_Result 
.const [110] = Utf8 <init> 
.const [111] = Utf8 ()V 
.const [112] = Utf8 de/audi/app/combi/bap/app/phone/list/CombinedNumbersListHandler 
.const [113] = Utf8 list 
.const [114] = Utf8 [Lde/audi/atip/interapp/combi/bap/data/CombiBAPArrayElement; 
.const [115] = Utf8 de/vw/mib/bap/generated/telephone/serializer/GetNextListPos_Result 
.const [116] = Utf8 getNextListPos_Result 
.const [117] = Utf8 I 
.const [118] = Utf8 de/vw/mib/bap/generated/telephone/serializer/GetNextListPos_Result 
.const [119] = Utf8 currentPos 
.const [120] = Utf8 I 
.const [121] = Utf8 de/vw/mib/bap/generated/telephone/serializer/GetNextListPos_Result 
.const [122] = Utf8 nextPos 
.const [123] = Utf8 I 
.const [124] = Utf8 de/vw/mib/bap/generated/telephone/serializer/GetNextListPos_Result 
.const [125] = Utf8 absoluteListPos 
.const [126] = Utf8 I 
.const [127] = Utf8 de/audi/app/combi/bap/app/phone/list/CombinedNumbersListHandler 
.const [128] = Class [127] 
.const [129] = Utf8 de/audi/app/bap/fw/arrays/AbstractManagedListHandler 
.const [130] = Class [129] 
.const [131] = Utf8 Code 
.const [132] = Utf8 <init> 
.const [133] = Utf8 (Lde/audi/app/combi/bap/app/phone/CombiModulePhone;)V 
.const [134] = Utf8 updateList 
.const [135] = Utf8 ([Lde/audi/atip/interapp/combi/bap/data/CombiBAPArrayElement;)V 
.const [136] = Utf8 getNextListPos 
.const [137] = Utf8 (II)V 
.const [138] = Utf8 getNextListPosResult 
.const [139] = Utf8 (ZIII)V 
.end class 
