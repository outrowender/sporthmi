.version 50 0 
.class public super [39] 
.super [41] 

.method public [43] : [44] 
    .attribute [42] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     iconst_1 
L3:     invokespecial [9] 
L6:     return 
L7:     nop 
L8:     
    .end code 
.end method 

.method protected [45] : [46] 
    .attribute [42] .code stack 1 locals 0 
L0:     aload_1 
L1:     invokevirtual [5] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method protected [47] : [48] 
    .attribute [42] .code stack 3 locals 2 
L0:     aload_1 
L1:     invokevirtual [5] 
L4:     astore 4 
L6:     aload_2 
L7:     invokevirtual [5] 
L10:    astore 5 
L12:    aload_1 
L13:    getfield [6] 
L16:    aload_2 
L17:    getfield [6] 
L20:    if_icmpeq L32 
L23:    aload_3 
L24:    aload 4 
L26:    aload 5 
L28:    invokevirtual [7] 
L31:    areturn 
L32:    aload_1 
L33:    getfield [8] 
L36:    aload_2 
L37:    getfield [8] 
L40:    isub 
L41:    areturn 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [10] 
.const [3] = Class [11] 
.const [4] = Class [12] 
.const [5] = Method [13] [14] 
.const [6] = Field [15] [16] 
.const [7] = Method [17] [18] 
.const [8] = Field [19] [20] 
.const [9] = Method [21] [22] 
.const [10] = Utf8 de/audi/tuner/app/sdars/sortandindex/station/AbstractIStationInfoComparatorAndIndexer 
.const [11] = Utf8 de/audi/tuner/app/sdars/StationInfoExt 
.const [12] = Utf8 java/text/Collator 
.const [13] = Class [23] 
.const [14] = NameAndType [24] [25] 
.const [15] = Class [26] 
.const [16] = NameAndType [27] [28] 
.const [17] = Class [29] 
.const [18] = NameAndType [30] [31] 
.const [19] = Class [32] 
.const [20] = NameAndType [33] [34] 
.const [21] = Class [35] 
.const [22] = NameAndType [36] [37] 
.const [23] = Utf8 de/audi/tuner/app/sdars/StationInfoExt 
.const [24] = Utf8 getShortCategory 
.const [25] = Utf8 ()Ljava/lang/String; 
.const [26] = Utf8 de/audi/tuner/app/sdars/StationInfoExt 
.const [27] = Utf8 categoryNumber 
.const [28] = Utf8 S 
.const [29] = Utf8 java/text/Collator 
.const [30] = Utf8 compare 
.const [31] = Utf8 (Ljava/lang/String;Ljava/lang/String;)I 
.const [32] = Utf8 de/audi/tuner/app/sdars/StationInfoExt 
.const [33] = Utf8 stationNumber 
.const [34] = Utf8 S 
.const [35] = Utf8 de/audi/tuner/app/sdars/sortandindex/station/AbstractIStationInfoComparatorAndIndexer 
.const [36] = Utf8 <init> 
.const [37] = Utf8 (Lde/audi/tuner/app/LanguageManager;Z)V 
.const [38] = Utf8 de/audi/tuner/app/sdars/sortandindex/station/SortAlgoCatAndStNumber 
.const [39] = Class [38] 
.const [40] = Utf8 de/audi/tuner/app/sdars/sortandindex/station/AbstractIStationInfoComparatorAndIndexer 
.const [41] = Class [40] 
.const [42] = Utf8 Code 
.const [43] = Utf8 <init> 
.const [44] = Utf8 (Lde/audi/tuner/app/LanguageManager;)V 
.const [45] = Utf8 getStringUsedForIndexing 
.const [46] = Utf8 (Lde/audi/tuner/app/sdars/StationInfoExt;)Ljava/lang/String; 
.const [47] = Utf8 compare 
.const [48] = Utf8 (Lde/audi/tuner/app/sdars/StationInfoExt;Lde/audi/tuner/app/sdars/StationInfoExt;Ljava/text/Collator;)I 
.end class 
