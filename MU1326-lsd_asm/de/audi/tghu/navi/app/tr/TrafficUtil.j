.version 50 0 
.class public super [124] 
.super [126] 
.field public static final [127] [128] 
.field public static final [129] [130] 
.field public static final [131] [132] 
.field public static final [133] [134] 

.method public annotation [136] : [137] 
    .attribute [135] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [25] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [138] : [139] 
    .attribute [135] .code stack 2 locals 0 
L0:     aload_0 
L1:     ldc [2] 
L3:     invokevirtual [11] 
L6:     invokeinterface [26] 0 
L11:    iconst_1 
L12:    if_icmpne L19 
L15:    iconst_1 
L16:    goto L20 
L19:    iconst_0 
L20:    areturn 
L21:    nop 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public static [140] : [141] 
    .attribute [135] .code stack 3 locals 4 
L0:     aload_0 
L1:     ifnonnull L6 
L4:     iconst_m1 
L5:     areturn 
L6:     aload_0 
L7:     invokevirtual [12] 
L10:    istore_1 
L11:    aload_0 
L12:    iload_1 
L13:    iconst_0 
L14:    invokestatic [3] 
L17:    istore_2 
L18:    iload_2 
L19:    ifeq L24 
L22:    iload_2 
L23:    areturn 
L24:    aload_0 
L25:    invokevirtual [13] 
L28:    istore_3 
L29:    aload_0 
L30:    iload_3 
L31:    iconst_0 
L32:    invokestatic [3] 
L35:    istore_2 
L36:    iload_2 
L37:    ifeq L42 
L40:    iload_2 
L41:    areturn 
L42:    iload_1 
L43:    iload_3 
L44:    aload_0 
L45:    invokestatic [4] 
L48:    istore 4 
L50:    aload_0 
L51:    iload 4 
L53:    iconst_0 
L54:    invokestatic [3] 
L57:    istore_2 
L58:    iload_2 
L59:    areturn 
L60:    
    .end code 
.end method 

.method public static [142] : [143] 
    .attribute [135] .code stack 2 locals 1 
L0:     aload_0 
L1:     ifnonnull L9 
L4:     iconst_0 
L5:     istore_3 
L6:     goto L149 
L9:     iload_1 
L10:    tableswitch 0 
            L40 
            L45 
            L79 
            L113 
            default : L147 

L40:    iconst_0 
L41:    istore_3 
L42:    goto L149 
L45:    iload_2 
L46:    iconst_1 
L47:    if_icmpne L58 
L50:    aload_0 
L51:    invokevirtual [14] 
L54:    istore_3 
L55:    goto L149 
L58:    iload_2 
L59:    iconst_2 
L60:    if_icmpne L71 
L63:    aload_0 
L64:    invokevirtual [15] 
L67:    istore_3 
L68:    goto L149 
L71:    aload_0 
L72:    invokevirtual [16] 
L75:    istore_3 
L76:    goto L149 
L79:    iload_2 
L80:    iconst_1 
L81:    if_icmpne L92 
L84:    aload_0 
L85:    invokevirtual [17] 
L88:    istore_3 
L89:    goto L149 
L92:    iload_2 
L93:    iconst_2 
L94:    if_icmpne L105 
L97:    aload_0 
L98:    invokevirtual [18] 
L101:   istore_3 
L102:   goto L149 
L105:   aload_0 
L106:   invokevirtual [19] 
L109:   istore_3 
L110:   goto L149 
L113:   iload_2 
L114:   iconst_1 
L115:   if_icmpne L126 
L118:   aload_0 
L119:   invokevirtual [20] 
L122:   istore_3 
L123:   goto L149 
L126:   iload_2 
L127:   iconst_2 
L128:   if_icmpne L139 
L131:   aload_0 
L132:   invokevirtual [21] 
L135:   istore_3 
L136:   goto L149 
L139:   aload_0 
L140:   invokevirtual [22] 
L143:   istore_3 
L144:   goto L149 
L147:   iconst_0 
L148:   istore_3 
L149:   iload_3 
L150:   areturn 
L151:   nop 
L152:   
    .end code 
.end method 

.method public static [144] : [145] 
    .attribute [135] .code stack 2 locals 1 
L0:     iload_0 
L1:     iconst_1 
L2:     if_icmpeq L10 
L5:     iload_1 
L6:     iconst_1 
L7:     if_icmpne L30 
L10:    iload_0 
L11:    iconst_2 
L12:    if_icmpeq L20 
L15:    iload_1 
L16:    iconst_2 
L17:    if_icmpne L25 
L20:    iconst_3 
L21:    istore_3 
L22:    goto L32 
L25:    iconst_2 
L26:    istore_3 
L27:    goto L32 
L30:    iconst_1 
L31:    istore_3 
L32:    iload_3 
L33:    areturn 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 

.method public static [146] : [147] 
    .attribute [135] .code stack 1 locals 0 
L0:     iload_0 
L1:     tableswitch 2 
            L516 
            L518 
            L521 
            L524 
            L527 
            L530 
            L533 
            L536 
            L539 
            L542 
            L545 
            L548 
            L551 
            L554 
            L557 
            L560 
            L563 
            L566 
            L569 
            L572 
            L575 
            L578 
            L581 
            L585 
            L589 
            L593 
            L597 
            L872 
            L605 
            L607 
            L610 
            L613 
            L616 
            L619 
            L622 
            L625 
            L628 
            L631 
            L634 
            L637 
            L640 
            L643 
            L646 
            L649 
            L652 
            L655 
            L658 
            L661 
            L664 
            L667 
            L670 
            L674 
            L678 
            L682 
            L872 
            L872 
            L872 
            L872 
            L872 
            L694 
            L696 
            L699 
            L702 
            L705 
            L708 
            L711 
            L714 
            L717 
            L720 
            L723 
            L726 
            L729 
            L732 
            L735 
            L738 
            L741 
            L744 
            L747 
            L750 
            L753 
            L756 
            L759 
            L763 
            L767 
            L771 
            L775 
            L872 
            L783 
            L785 
            L788 
            L791 
            L794 
            L797 
            L800 
            L803 
            L806 
            L809 
            L812 
            L815 
            L818 
            L821 
            L824 
            L827 
            L830 
            L833 
            L836 
            L839 
            L842 
            L845 
            L848 
            L852 
            L856 
            L860 
            L872 
            L872 
            L872 
            L872 
            L872 
            L872 
            L779 
            L601 
            L864 
            L868 
            L686 
            L690 
            default : L872 

L516:   iconst_5 
L517:   areturn 
L518:   bipush 10 
L520:   areturn 
L521:   bipush 15 
L523:   areturn 
L524:   bipush 20 
L526:   areturn 
L527:   bipush 25 
L529:   areturn 
L530:   bipush 30 
L532:   areturn 
L533:   bipush 35 
L535:   areturn 
L536:   bipush 40 
L538:   areturn 
L539:   bipush 45 
L541:   areturn 
L542:   bipush 50 
L544:   areturn 
L545:   bipush 55 
L547:   areturn 
L548:   bipush 60 
L550:   areturn 
L551:   bipush 65 
L553:   areturn 
L554:   bipush 70 
L556:   areturn 
L557:   bipush 75 
L559:   areturn 
L560:   bipush 80 
L562:   areturn 
L563:   bipush 85 
L565:   areturn 
L566:   bipush 90 
L568:   areturn 
L569:   bipush 95 
L571:   areturn 
L572:   bipush 100 
L574:   areturn 
L575:   bipush 110 
L577:   areturn 
L578:   bipush 120 
L580:   areturn 
L581:   sipush 130 
L584:   areturn 
L585:   sipush 140 
L588:   areturn 
L589:   sipush 150 
L592:   areturn 
L593:   sipush 160 
L596:   areturn 
L597:   sipush 200 
L600:   areturn 
L601:   sipush 250 
L604:   areturn 
L605:   iconst_5 
L606:   areturn 
L607:   bipush 10 
L609:   areturn 
L610:   bipush 15 
L612:   areturn 
L613:   bipush 20 
L615:   areturn 
L616:   bipush 25 
L618:   areturn 
L619:   bipush 30 
L621:   areturn 
L622:   bipush 35 
L624:   areturn 
L625:   bipush 40 
L627:   areturn 
L628:   bipush 45 
L630:   areturn 
L631:   bipush 50 
L633:   areturn 
L634:   bipush 55 
L636:   areturn 
L637:   bipush 60 
L639:   areturn 
L640:   bipush 65 
L642:   areturn 
L643:   bipush 70 
L645:   areturn 
L646:   bipush 75 
L648:   areturn 
L649:   bipush 80 
L651:   areturn 
L652:   bipush 85 
L654:   areturn 
L655:   bipush 90 
L657:   areturn 
L658:   bipush 95 
L660:   areturn 
L661:   bipush 100 
L663:   areturn 
L664:   bipush 110 
L666:   areturn 
L667:   bipush 120 
L669:   areturn 
L670:   sipush 130 
L673:   areturn 
L674:   sipush 140 
L677:   areturn 
L678:   sipush 150 
L681:   areturn 
L682:   sipush 160 
L685:   areturn 
L686:   sipush 200 
L689:   areturn 
L690:   sipush 250 
L693:   areturn 
L694:   iconst_5 
L695:   areturn 
L696:   bipush 10 
L698:   areturn 
L699:   bipush 15 
L701:   areturn 
L702:   bipush 20 
L704:   areturn 
L705:   bipush 25 
L707:   areturn 
L708:   bipush 30 
L710:   areturn 
L711:   bipush 35 
L713:   areturn 
L714:   bipush 40 
L716:   areturn 
L717:   bipush 45 
L719:   areturn 
L720:   bipush 50 
L722:   areturn 
L723:   bipush 55 
L725:   areturn 
L726:   bipush 60 
L728:   areturn 
L729:   bipush 65 
L731:   areturn 
L732:   bipush 70 
L734:   areturn 
L735:   bipush 75 
L737:   areturn 
L738:   bipush 80 
L740:   areturn 
L741:   bipush 85 
L743:   areturn 
L744:   bipush 90 
L746:   areturn 
L747:   bipush 95 
L749:   areturn 
L750:   bipush 100 
L752:   areturn 
L753:   bipush 110 
L755:   areturn 
L756:   bipush 120 
L758:   areturn 
L759:   sipush 130 
L762:   areturn 
L763:   sipush 140 
L766:   areturn 
L767:   sipush 150 
L770:   areturn 
L771:   sipush 160 
L774:   areturn 
L775:   sipush 200 
L778:   areturn 
L779:   sipush 250 
L782:   areturn 
L783:   iconst_5 
L784:   areturn 
L785:   bipush 10 
L787:   areturn 
L788:   bipush 15 
L790:   areturn 
L791:   bipush 20 
L793:   areturn 
L794:   bipush 25 
L796:   areturn 
L797:   bipush 30 
L799:   areturn 
L800:   bipush 35 
L802:   areturn 
L803:   bipush 40 
L805:   areturn 
L806:   bipush 45 
L808:   areturn 
L809:   bipush 50 
L811:   areturn 
L812:   bipush 55 
L814:   areturn 
L815:   bipush 60 
L817:   areturn 
L818:   bipush 65 
L820:   areturn 
L821:   bipush 70 
L823:   areturn 
L824:   bipush 75 
L826:   areturn 
L827:   bipush 80 
L829:   areturn 
L830:   bipush 85 
L832:   areturn 
L833:   bipush 90 
L835:   areturn 
L836:   bipush 95 
L838:   areturn 
L839:   bipush 100 
L841:   areturn 
L842:   bipush 110 
L844:   areturn 
L845:   bipush 120 
L847:   areturn 
L848:   sipush 130 
L851:   areturn 
L852:   sipush 140 
L855:   areturn 
L856:   sipush 150 
L859:   areturn 
L860:   sipush 160 
L863:   areturn 
L864:   sipush 200 
L867:   areturn 
L868:   sipush 250 
L871:   areturn 
L872:   iconst_0 
L873:   areturn 
L874:   nop 
L875:   nop 
L876:   
    .end code 
.end method 

.method public static [148] : [149] 
    .attribute [135] .code stack 1 locals 0 
L0:     aload_0 
L1:     ifnonnull L6 
L4:     iconst_0 
L5:     areturn 
L6:     aload_0 
L7:     invokevirtual [23] 
L10:    invokevirtual [24] 
L13:    areturn 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int -1591933440 
.const [3] = Method [27] [28] 
.const [4] = Method [29] [30] 
.const [5] = Class [31] 
.const [6] = Class [32] 
.const [7] = Class [33] 
.const [8] = Class [34] 
.const [9] = Class [35] 
.const [10] = Class [36] 
.const [11] = Method [37] [38] 
.const [12] = Method [39] [40] 
.const [13] = Method [41] [42] 
.const [14] = Method [43] [44] 
.const [15] = Method [45] [46] 
.const [16] = Method [47] [48] 
.const [17] = Method [49] [50] 
.const [18] = Method [51] [52] 
.const [19] = Method [53] [54] 
.const [20] = Method [55] [56] 
.const [21] = Method [57] [58] 
.const [22] = Method [59] [60] 
.const [23] = Method [61] [62] 
.const [24] = Method [63] [64] 
.const [25] = Method [65] [66] 
.const [26] = InterfaceMethod [67] [68] 
.const [27] = Class [69] 
.const [28] = NameAndType [70] [71] 
.const [29] = Class [72] 
.const [30] = NameAndType [73] [74] 
.const [31] = Utf8 de/audi/tghu/navi/app/tr/TrafficUtil 
.const [32] = Utf8 java/lang/Object 
.const [33] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [34] = Utf8 de/audi/atip/hmi/modelaccess/ChoiceModelApp 
.const [35] = Utf8 org/dsi/ifc/trafficregulation/TrafficSignInformation 
.const [36] = Utf8 org/dsi/ifc/trafficregulation/SpeedLimitInfo 
.const [37] = Class [75] 
.const [38] = NameAndType [76] [77] 
.const [39] = Class [78] 
.const [40] = NameAndType [79] [80] 
.const [41] = Class [81] 
.const [42] = NameAndType [82] [83] 
.const [43] = Class [84] 
.const [44] = NameAndType [85] [86] 
.const [45] = Class [87] 
.const [46] = NameAndType [88] [89] 
.const [47] = Class [90] 
.const [48] = NameAndType [91] [92] 
.const [49] = Class [93] 
.const [50] = NameAndType [94] [95] 
.const [51] = Class [96] 
.const [52] = NameAndType [97] [98] 
.const [53] = Class [99] 
.const [54] = NameAndType [100] [101] 
.const [55] = Class [102] 
.const [56] = NameAndType [103] [104] 
.const [57] = Class [105] 
.const [58] = NameAndType [106] [107] 
.const [59] = Class [108] 
.const [60] = NameAndType [109] [110] 
.const [61] = Class [111] 
.const [62] = NameAndType [112] [113] 
.const [63] = Class [114] 
.const [64] = NameAndType [115] [116] 
.const [65] = Class [117] 
.const [66] = NameAndType [118] [119] 
.const [67] = Class [120] 
.const [68] = NameAndType [121] [122] 
.const [69] = Utf8 de/audi/tghu/navi/app/tr/TrafficUtil 
.const [70] = Utf8 getSignID 
.const [71] = Utf8 (Lorg/dsi/ifc/trafficregulation/TrafficSignInformation;II)I 
.const [72] = Utf8 de/audi/tghu/navi/app/tr/TrafficUtil 
.const [73] = Utf8 getThirdPrioritySign 
.const [74] = Utf8 (IILorg/dsi/ifc/trafficregulation/TrafficSignInformation;)I 
.const [75] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [76] = Utf8 getChoiceModel 
.const [77] = Utf8 (I)Lde/audi/atip/hmi/modelaccess/ChoiceModelApp; 
.const [78] = Utf8 org/dsi/ifc/trafficregulation/TrafficSignInformation 
.const [79] = Utf8 getHighestPrioritySign 
.const [80] = Utf8 ()I 
.const [81] = Utf8 org/dsi/ifc/trafficregulation/TrafficSignInformation 
.const [82] = Utf8 getSecondHighestPrioritySign 
.const [83] = Utf8 ()I 
.const [84] = Utf8 org/dsi/ifc/trafficregulation/TrafficSignInformation 
.const [85] = Utf8 getAdditionalSignOne 
.const [86] = Utf8 ()I 
.const [87] = Utf8 org/dsi/ifc/trafficregulation/TrafficSignInformation 
.const [88] = Utf8 getWarningSignOne 
.const [89] = Utf8 ()I 
.const [90] = Utf8 org/dsi/ifc/trafficregulation/TrafficSignInformation 
.const [91] = Utf8 getTrafficSignOne 
.const [92] = Utf8 ()I 
.const [93] = Utf8 org/dsi/ifc/trafficregulation/TrafficSignInformation 
.const [94] = Utf8 getAdditionalSignTwo 
.const [95] = Utf8 ()I 
.const [96] = Utf8 org/dsi/ifc/trafficregulation/TrafficSignInformation 
.const [97] = Utf8 getWarningSignTwo 
.const [98] = Utf8 ()I 
.const [99] = Utf8 org/dsi/ifc/trafficregulation/TrafficSignInformation 
.const [100] = Utf8 getTrafficSignTwo 
.const [101] = Utf8 ()I 
.const [102] = Utf8 org/dsi/ifc/trafficregulation/TrafficSignInformation 
.const [103] = Utf8 getAdditionalSignThree 
.const [104] = Utf8 ()I 
.const [105] = Utf8 org/dsi/ifc/trafficregulation/TrafficSignInformation 
.const [106] = Utf8 getWarningSignThree 
.const [107] = Utf8 ()I 
.const [108] = Utf8 org/dsi/ifc/trafficregulation/TrafficSignInformation 
.const [109] = Utf8 getTrafficSignThree 
.const [110] = Utf8 ()I 
.const [111] = Utf8 org/dsi/ifc/trafficregulation/TrafficSignInformation 
.const [112] = Utf8 getHighestPrioritySpeedLimit 
.const [113] = Utf8 ()Lorg/dsi/ifc/trafficregulation/SpeedLimitInfo; 
.const [114] = Utf8 org/dsi/ifc/trafficregulation/SpeedLimitInfo 
.const [115] = Utf8 getSpeedUnit 
.const [116] = Utf8 ()I 
.const [117] = Utf8 java/lang/Object 
.const [118] = Utf8 <init> 
.const [119] = Utf8 ()V 
.const [120] = Utf8 de/audi/atip/hmi/modelaccess/ChoiceModelApp 
.const [121] = Utf8 getValue 
.const [122] = Utf8 ()I 
.const [123] = Utf8 de/audi/tghu/navi/app/tr/TrafficUtil 
.const [124] = Class [123] 
.const [125] = Utf8 java/lang/Object 
.const [126] = Class [125] 
.const [127] = Utf8 NO_SIGN 
.const [128] = Utf8 I 
.const [129] = Utf8 TYPE_TRAFFIC_SIGN 
.const [130] = Utf8 I 
.const [131] = Utf8 TYPE_ADDITIONAL_SIGN 
.const [132] = Utf8 I 
.const [133] = Utf8 TYPE_WARNING_SIGN 
.const [134] = Utf8 I 
.const [135] = Utf8 Code 
.const [136] = Utf8 <init> 
.const [137] = Utf8 ()V 
.const [138] = Utf8 isTrafficRegulationInfoEnabled 
.const [139] = Utf8 (Lde/audi/tghu/navi/app/NavigationEnv;)Z 
.const [140] = Utf8 retrieveCurrentSignID 
.const [141] = Utf8 (Lorg/dsi/ifc/trafficregulation/TrafficSignInformation;)I 
.const [142] = Utf8 getSignID 
.const [143] = Utf8 (Lorg/dsi/ifc/trafficregulation/TrafficSignInformation;II)I 
.const [144] = Utf8 getThirdPrioritySign 
.const [145] = Utf8 (IILorg/dsi/ifc/trafficregulation/TrafficSignInformation;)I 
.const [146] = Utf8 extractSpeedLimitFromSignID 
.const [147] = Utf8 (I)I 
.const [148] = Utf8 extractSpeedLimitUnitFromSign 
.const [149] = Utf8 (Lorg/dsi/ifc/trafficregulation/TrafficSignInformation;)I 
.end class 
