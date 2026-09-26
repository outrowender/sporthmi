.version 50 0 
.class public super [27] 
.super [29] 

.method public [31] : [32] 
    .attribute [30] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     iconst_1 
L3:     invokespecial [7] 
L6:     return 
L7:     nop 
L8:     
    .end code 
.end method 

.method protected [33] : [34] 
    .attribute [30] .code stack 1 locals 0 
L0:     aload_1 
L1:     getfield [5] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method protected [35] : [36] 
    .attribute [30] .code stack 3 locals 0 
L0:     aload_1 
L1:     getfield [5] 
L4:     ifnonnull L9 
L7:     iconst_1 
L8:     areturn 
L9:     aload_2 
L10:    getfield [5] 
L13:    ifnonnull L18 
L16:    iconst_m1 
L17:    areturn 
L18:    aload_3 
L19:    aload_1 
L20:    getfield [5] 
L23:    aload_2 
L24:    getfield [5] 
L27:    invokevirtual [6] 
L30:    areturn 
L31:    nop 
L32:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [8] 
.const [3] = Class [9] 
.const [4] = Class [10] 
.const [5] = Field [11] [12] 
.const [6] = Method [13] [14] 
.const [7] = Method [15] [16] 
.const [8] = Utf8 de/audi/tuner/app/sdars/sortandindex/station/AbstractIStationInfoComparatorAndIndexer 
.const [9] = Utf8 de/audi/tuner/app/sdars/StationInfoExt 
.const [10] = Utf8 java/text/Collator 
.const [11] = Class [17] 
.const [12] = NameAndType [18] [19] 
.const [13] = Class [20] 
.const [14] = NameAndType [21] [22] 
.const [15] = Class [23] 
.const [16] = NameAndType [24] [25] 
.const [17] = Utf8 de/audi/tuner/app/sdars/StationInfoExt 
.const [18] = Utf8 shortLabel 
.const [19] = Utf8 Ljava/lang/String; 
.const [20] = Utf8 java/text/Collator 
.const [21] = Utf8 compare 
.const [22] = Utf8 (Ljava/lang/String;Ljava/lang/String;)I 
.const [23] = Utf8 de/audi/tuner/app/sdars/sortandindex/station/AbstractIStationInfoComparatorAndIndexer 
.const [24] = Utf8 <init> 
.const [25] = Utf8 (Lde/audi/tuner/app/LanguageManager;Z)V 
.const [26] = Utf8 de/audi/tuner/app/sdars/sortandindex/station/SortAlgoName 
.const [27] = Class [26] 
.const [28] = Utf8 de/audi/tuner/app/sdars/sortandindex/station/AbstractIStationInfoComparatorAndIndexer 
.const [29] = Class [28] 
.const [30] = Utf8 Code 
.const [31] = Utf8 <init> 
.const [32] = Utf8 (Lde/audi/tuner/app/LanguageManager;)V 
.const [33] = Utf8 getStringUsedForIndexing 
.const [34] = Utf8 (Lde/audi/tuner/app/sdars/StationInfoExt;)Ljava/lang/String; 
.const [35] = Utf8 compare 
.const [36] = Utf8 (Lde/audi/tuner/app/sdars/StationInfoExt;Lde/audi/tuner/app/sdars/StationInfoExt;Ljava/text/Collator;)I 
.end class 
