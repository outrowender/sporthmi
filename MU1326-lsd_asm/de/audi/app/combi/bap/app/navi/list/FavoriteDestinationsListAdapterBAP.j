.version 50 0 
.class public super [119] 
.super [121] 

.method public [123] : [124] 
    .attribute [122] .code stack 4 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     bipush 30 
L4:     aload_2 
L5:     invokespecial [21] 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method protected [125] : [126] 
    .attribute [122] .code stack 3 locals 3 
L0:     aload_1 
L1:     bipush 15 
L3:     baload 
L4:     istore_2 
L5:     aload_1 
L6:     iconst_0 
L7:     baload 
L8:     ifne L17 
L11:    aload_1 
L12:    iconst_2 
L13:    baload 
L14:    ifeq L21 
L17:    iconst_1 
L18:    goto L22 
L21:    iconst_0 
L22:    istore_3 
L23:    aload_1 
L24:    iconst_0 
L25:    baload 
L26:    ifne L35 
L29:    aload_1 
L30:    iconst_1 
L31:    baload 
L32:    ifeq L39 
L35:    iconst_1 
L36:    goto L40 
L39:    iconst_0 
L40:    istore 4 
L42:    iload_2 
L43:    iload_3 
L44:    iload 4 
L46:    invokestatic [2] 
L49:    areturn 
L50:    nop 
L51:    nop 
L52:    
    .end code 
.end method 

.method protected [127] : [128] 
    .attribute [122] .code stack 4 locals 2 
L0:     new [26] 
L3:     dup 
L4:     aload_2 
L5:     invokespecial [22] 
L8:     astore_3 
L9:     aload_1 
L10:    instanceof [4] 
L13:    ifeq L56 
L16:    aload_1 
L17:    checkcast [4] 
L20:    astore 4 
L22:    aload_3 
L23:    aload 4 
L25:    invokevirtual [13] 
L28:    invokevirtual [14] 
L31:    aload_3 
L32:    aload 4 
L34:    invokevirtual [15] 
L37:    putfield [27] 
L40:    aload_3 
L41:    getfield [16] 
L44:    aload 4 
L46:    invokevirtual [17] 
L49:    invokevirtual [18] 
L52:    pop 
L53:    goto L73 
L56:    aload_0 
L57:    getfield [19] 
L60:    sipush 10000 
L63:    ldc [5] 
L65:    aload_1 
L66:    invokespecial [23] 
L69:    invokevirtual [20] 
L72:    pop 
L73:    aload_3 
L74:    areturn 
L75:    nop 
L76:    
    .end code 
.end method 

.method protected [129] : [130] 
    .attribute [122] .code stack 3 locals 1 
L0:     new [26] 
L3:     dup 
L4:     aload_1 
L5:     invokespecial [22] 
L8:     astore_3 
L9:     aload_3 
L10:    iload_2 
L11:    invokevirtual [14] 
L14:    aload_3 
L15:    areturn 
L16:    
    .end code 
.end method 

.method protected [131] : [132] 
    .attribute [122] .code stack 2 locals 0 
L0:     new [28] 
L3:     dup 
L4:     invokespecial [24] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method protected [133] : [134] 
    .attribute [122] .code stack 2 locals 0 
L0:     new [29] 
L3:     dup 
L4:     invokespecial [25] 
L7:     areturn 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [30] [31] 
.const [3] = Class [32] 
.const [4] = Class [33] 
.const [5] = String [34] 
.const [6] = Class [35] 
.const [7] = Class [36] 
.const [8] = Class [37] 
.const [9] = Class [38] 
.const [10] = Class [39] 
.const [11] = Class [40] 
.const [12] = Class [41] 
.const [13] = Method [42] [43] 
.const [14] = Method [44] [45] 
.const [15] = Method [46] [47] 
.const [16] = Field [48] [49] 
.const [17] = Method [50] [51] 
.const [18] = Method [52] [53] 
.const [19] = Field [54] [55] 
.const [20] = Method [56] [57] 
.const [21] = Method [58] [59] 
.const [22] = Method [60] [61] 
.const [23] = Method [62] [63] 
.const [24] = Method [64] [65] 
.const [25] = Method [66] [67] 
.const [26] = Class [68] 
.const [27] = Field [69] [70] 
.const [28] = Class [71] 
.const [29] = Class [72] 
.const [30] = Class [73] 
.const [31] = NameAndType [74] [75] 
.const [32] = Utf8 de/vw/mib/bap/generated/navsd/serializer/FavoriteDest_List_Data 
.const [33] = Utf8 de/audi/atip/interapp/combi/bap/navi/data/CombiBAPDestinationListEntry 
.const [34] = Utf8 '[FavoriteDestinationsListAdapterBAP#convertArrayElement] invalid element type: %1' 
.const [35] = Utf8 de/vw/mib/bap/generated/navsd/serializer/FavoriteDest_List_ChangedArray 
.const [36] = Utf8 de/vw/mib/bap/generated/navsd/serializer/FavoriteDest_List_StatusArray 
.const [37] = Utf8 de/audi/app/combi/bap/app/navi/list/FavoriteDestinationsListAdapterBAP 
.const [38] = Utf8 de/audi/app/bap/fw/arrays/AbstractListAdapterBAP 
.const [39] = Utf8 de/vw/mib/bap/datatypes/BAPString 
.const [40] = Utf8 java/lang/Object 
.const [41] = Utf8 de/audi/atip/log/LogChannel 
.const [42] = Class [76] 
.const [43] = NameAndType [77] [78] 
.const [44] = Class [79] 
.const [45] = NameAndType [80] [81] 
.const [46] = Class [82] 
.const [47] = NameAndType [83] [84] 
.const [48] = Class [85] 
.const [49] = NameAndType [86] [87] 
.const [50] = Class [88] 
.const [51] = NameAndType [89] [90] 
.const [52] = Class [91] 
.const [53] = NameAndType [92] [93] 
.const [54] = Class [94] 
.const [55] = NameAndType [95] [96] 
.const [56] = Class [97] 
.const [57] = NameAndType [98] [99] 
.const [58] = Class [100] 
.const [59] = NameAndType [101] [102] 
.const [60] = Class [103] 
.const [61] = NameAndType [104] [105] 
.const [62] = Class [106] 
.const [63] = NameAndType [107] [108] 
.const [64] = Class [109] 
.const [65] = NameAndType [110] [111] 
.const [66] = Class [112] 
.const [67] = NameAndType [113] [114] 
.const [68] = Utf8 de/vw/mib/bap/generated/navsd/serializer/FavoriteDest_List_Data 
.const [69] = Class [115] 
.const [70] = NameAndType [116] [117] 
.const [71] = Utf8 de/vw/mib/bap/generated/navsd/serializer/FavoriteDest_List_ChangedArray 
.const [72] = Utf8 de/vw/mib/bap/generated/navsd/serializer/FavoriteDest_List_StatusArray 
.const [73] = Utf8 de/audi/atip/interapp/combi/bap/navi/data/CombiBAPDestinationListEntry 
.const [74] = Utf8 getRecordAddress 
.const [75] = Utf8 (ZZZ)I 
.const [76] = Utf8 de/audi/atip/interapp/combi/bap/navi/data/CombiBAPDestinationListEntry 
.const [77] = Utf8 getPosID 
.const [78] = Utf8 ()I 
.const [79] = Utf8 de/vw/mib/bap/generated/navsd/serializer/FavoriteDest_List_Data 
.const [80] = Utf8 setPos 
.const [81] = Utf8 (I)V 
.const [82] = Utf8 de/audi/atip/interapp/combi/bap/navi/data/CombiBAPDestinationListEntry 
.const [83] = Utf8 getPOIType 
.const [84] = Utf8 ()I 
.const [85] = Utf8 de/vw/mib/bap/generated/navsd/serializer/FavoriteDest_List_Data 
.const [86] = Utf8 description 
.const [87] = Utf8 Lde/vw/mib/bap/datatypes/BAPString; 
.const [88] = Utf8 de/audi/atip/interapp/combi/bap/navi/data/CombiBAPDestinationListEntry 
.const [89] = Utf8 getDescription 
.const [90] = Utf8 ()Ljava/lang/String; 
.const [91] = Utf8 de/vw/mib/bap/datatypes/BAPString 
.const [92] = Utf8 setContent 
.const [93] = Utf8 (Ljava/lang/String;)Lde/vw/mib/bap/datatypes/BAPString; 
.const [94] = Utf8 de/audi/app/combi/bap/app/navi/list/FavoriteDestinationsListAdapterBAP 
.const [95] = Utf8 logChannel 
.const [96] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [97] = Utf8 de/audi/atip/log/LogChannel 
.const [98] = Utf8 log 
.const [99] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [100] = Utf8 de/audi/app/bap/fw/arrays/AbstractListAdapterBAP 
.const [101] = Utf8 <init> 
.const [102] = Utf8 (Lde/audi/app/bap/fw/AbstractBAPModuleFSG;ILde/audi/app/bap/fw/arrays/ArrayHandler;)V 
.const [103] = Utf8 de/vw/mib/bap/generated/navsd/serializer/FavoriteDest_List_Data 
.const [104] = Utf8 <init> 
.const [105] = Utf8 (Lde/vw/mib/bap/datatypes/ArrayHeader;)V 
.const [106] = Utf8 java/lang/Object 
.const [107] = Utf8 getClass 
.const [108] = Utf8 ()Ljava/lang/Class; 
.const [109] = Utf8 de/vw/mib/bap/generated/navsd/serializer/FavoriteDest_List_ChangedArray 
.const [110] = Utf8 <init> 
.const [111] = Utf8 ()V 
.const [112] = Utf8 de/vw/mib/bap/generated/navsd/serializer/FavoriteDest_List_StatusArray 
.const [113] = Utf8 <init> 
.const [114] = Utf8 ()V 
.const [115] = Utf8 de/vw/mib/bap/generated/navsd/serializer/FavoriteDest_List_Data 
.const [116] = Utf8 poi_Type 
.const [117] = Utf8 I 
.const [118] = Utf8 de/audi/app/combi/bap/app/navi/list/FavoriteDestinationsListAdapterBAP 
.const [119] = Class [118] 
.const [120] = Utf8 de/audi/app/bap/fw/arrays/AbstractListAdapterBAP 
.const [121] = Class [120] 
.const [122] = Utf8 Code 
.const [123] = Utf8 <init> 
.const [124] = Utf8 (Lde/audi/app/combi/bap/fw/AbstractCombiModule;Lde/audi/app/bap/fw/arrays/ArrayHandler;)V 
.const [125] = Utf8 getCommonRecordAddress 
.const [126] = Utf8 ([Z)I 
.const [127] = Utf8 convertArrayElement 
.const [128] = Utf8 (Lde/audi/atip/interapp/combi/bap/data/CombiBAPArrayElement;Lde/vw/mib/bap/datatypes/ArrayHeader;)Lde/vw/mib/bap/datatypes/BAPArrayElement; 
.const [129] = Utf8 createArrayElement 
.const [130] = Utf8 (Lde/vw/mib/bap/datatypes/ArrayHeader;I)Lde/vw/mib/bap/datatypes/BAPArrayElement; 
.const [131] = Utf8 createChangedArraySerializer 
.const [132] = Utf8 ()Lde/vw/mib/bap/requests/ChangedArray; 
.const [133] = Utf8 createStatusArraySerializer 
.const [134] = Utf8 ()Lde/vw/mib/bap/requests/StatusArray; 
.end class 
