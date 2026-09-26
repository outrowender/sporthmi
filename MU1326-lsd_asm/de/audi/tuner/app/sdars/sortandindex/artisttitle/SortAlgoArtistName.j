.version 50 0 
.class public super [55] 
.super [57] 

.method public [59] : [60] 
    .attribute [58] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     iconst_1 
L3:     invokespecial [13] 
L6:     return 
L7:     nop 
L8:     
    .end code 
.end method 

.method protected [61] : [62] 
    .attribute [58] .code stack 1 locals 0 
L0:     aload_1 
L1:     invokevirtual [7] 
L4:     getfield [8] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method protected [63] : [64] 
    .attribute [58] .code stack 3 locals 1 
L0:     aload_3 
L1:     aload_1 
L2:     invokevirtual [7] 
L5:     getfield [8] 
L8:     aload_2 
L9:     invokevirtual [7] 
L12:    getfield [8] 
L15:    invokevirtual [9] 
L18:    istore 4 
L20:    iload 4 
L22:    ifeq L28 
L25:    iload 4 
L27:    areturn 
L28:    aload_3 
L29:    aload_1 
L30:    invokevirtual [7] 
L33:    getfield [10] 
L36:    aload_2 
L37:    invokevirtual [7] 
L40:    getfield [10] 
L43:    invokevirtual [9] 
L46:    istore 4 
L48:    iload 4 
L50:    ifeq L56 
L53:    iload 4 
L55:    areturn 
L56:    aload_1 
L57:    invokevirtual [11] 
L60:    getfield [12] 
L63:    aload_2 
L64:    invokevirtual [11] 
L67:    getfield [12] 
L70:    isub 
L71:    areturn 
L72:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [14] 
.const [3] = Class [15] 
.const [4] = Class [16] 
.const [5] = Class [17] 
.const [6] = Class [18] 
.const [7] = Method [19] [20] 
.const [8] = Field [21] [22] 
.const [9] = Method [23] [24] 
.const [10] = Field [25] [26] 
.const [11] = Method [27] [28] 
.const [12] = Field [29] [30] 
.const [13] = Method [31] [32] 
.const [14] = Utf8 de/audi/tuner/app/sdars/sortandindex/artisttitle/AbstractArtistTitleComparatorAndIndexer 
.const [15] = Utf8 de/audi/tuner/app/sdars/ArtistTitleRow 
.const [16] = Utf8 org/dsi/ifc/sdars/RadioText 
.const [17] = Utf8 java/text/Collator 
.const [18] = Utf8 de/audi/tuner/app/sdars/StationInfoExt 
.const [19] = Class [33] 
.const [20] = NameAndType [34] [35] 
.const [21] = Class [36] 
.const [22] = NameAndType [37] [38] 
.const [23] = Class [39] 
.const [24] = NameAndType [40] [41] 
.const [25] = Class [42] 
.const [26] = NameAndType [43] [44] 
.const [27] = Class [45] 
.const [28] = NameAndType [46] [47] 
.const [29] = Class [48] 
.const [30] = NameAndType [49] [50] 
.const [31] = Class [51] 
.const [32] = NameAndType [52] [53] 
.const [33] = Utf8 de/audi/tuner/app/sdars/ArtistTitleRow 
.const [34] = Utf8 getRadioText 
.const [35] = Utf8 ()Lorg/dsi/ifc/sdars/RadioText; 
.const [36] = Utf8 org/dsi/ifc/sdars/RadioText 
.const [37] = Utf8 longArtistName 
.const [38] = Utf8 Ljava/lang/String; 
.const [39] = Utf8 java/text/Collator 
.const [40] = Utf8 compare 
.const [41] = Utf8 (Ljava/lang/String;Ljava/lang/String;)I 
.const [42] = Utf8 org/dsi/ifc/sdars/RadioText 
.const [43] = Utf8 longProgramTitle 
.const [44] = Utf8 Ljava/lang/String; 
.const [45] = Utf8 de/audi/tuner/app/sdars/ArtistTitleRow 
.const [46] = Utf8 getStation 
.const [47] = Utf8 ()Lde/audi/tuner/app/sdars/StationInfoExt; 
.const [48] = Utf8 de/audi/tuner/app/sdars/StationInfoExt 
.const [49] = Utf8 stationNumber 
.const [50] = Utf8 S 
.const [51] = Utf8 de/audi/tuner/app/sdars/sortandindex/artisttitle/AbstractArtistTitleComparatorAndIndexer 
.const [52] = Utf8 <init> 
.const [53] = Utf8 (Lde/audi/tuner/app/LanguageManager;Z)V 
.const [54] = Utf8 de/audi/tuner/app/sdars/sortandindex/artisttitle/SortAlgoArtistName 
.const [55] = Class [54] 
.const [56] = Utf8 de/audi/tuner/app/sdars/sortandindex/artisttitle/AbstractArtistTitleComparatorAndIndexer 
.const [57] = Class [56] 
.const [58] = Utf8 Code 
.const [59] = Utf8 <init> 
.const [60] = Utf8 (Lde/audi/tuner/app/LanguageManager;)V 
.const [61] = Utf8 getStringUsedForIndexing 
.const [62] = Utf8 (Lde/audi/tuner/app/sdars/ArtistTitleRow;)Ljava/lang/String; 
.const [63] = Utf8 compare 
.const [64] = Utf8 (Lde/audi/tuner/app/sdars/ArtistTitleRow;Lde/audi/tuner/app/sdars/ArtistTitleRow;Ljava/text/Collator;)I 
.end class 
