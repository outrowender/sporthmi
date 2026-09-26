.version 50 0 
.class public super [377] 
.super [379] 
.field private static final [380] [381] 
.field private [382] [383] 

.method public [385] : [386] 
    .attribute [384] .code stack 7 locals 0 
L0:     aload_0 
L1:     new [34] 
L4:     dup 
L5:     ldc [3] 
L7:     iload_1 
L8:     ldc [4] 
L10:    ldc [5] 
L12:    invokespecial [28] 
L15:    invokespecial [29] 
L18:    aload_0 
L19:    aload_2 
L20:    putfield [35] 
L23:    return 
L24:    
    .end code 
.end method 

.method public [387] : [388] 
    .attribute [384] .code stack 2 locals 0 
L0:     new [36] 
L3:     dup 
L4:     invokespecial [30] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public [389] : [390] 
    .attribute [384] .code stack 1 locals 0 
L0:     getstatic [7] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method public [391] : [392] 
    .attribute [384] .code stack 7 locals 8 
        .catch [12] from L0 to L1569 using L1572 
L0:     iload_1 
L1:     tableswitch 0 
            L540 
            L1542 
            L1542 
            L412 
            L1542 
            L598 
            L1542 
            L646 
            L1542 
            L622 
            L1542 
            L1202 
            L1542 
            L1280 
            L1542 
            L802 
            L1542 
            L880 
            L1542 
            L1002 
            L1542 
            L1080 
            L1542 
            L1542 
            L376 
            L340 
            L1542 
            L1542 
            L514 
            L488 
            L1542 
            L1542 
            L680 
            L1542 
            L1114 
            L714 
            L1542 
            L914 
            L1542 
            L1358 
            L1392 
            L1426 
            L1542 
            L462 
            L436 
            L1542 
            L1542 
            L1496 
            L1450 
            L1542 
            L1542 
            L564 
            L1542 
            L1542 
            L1542 
            L1542 
            L1542 
            L1542 
            L1542 
            L1542 
            L1158 
            L1542 
            L1236 
            L1542 
            L758 
            L1542 
            L836 
            L1542 
            L958 
            L1542 
            L1036 
            L1542 
            L1542 
            L1542 
            L1542 
            L1542 
            L1542 
            L1542 
            L1542 
            L1542 
            L1314 
            default : L1542 

L340:   aload_2 
L341:   invokeinterface [37] 0 
L346:   lstore 7 
L348:   aload_2 
L349:   invokeinterface [38] 0 
L354:   astore 9 
L356:   aload_0 
L357:   getfield [23] 
L360:   lload 7 
L362:   aload 9 
L364:   aload_3 
L365:   checkcast [6] 
L368:   invokeinterface [39] 0 
L373:   goto L1569 
L376:   aload_2 
L377:   invokeinterface [38] 0 
L382:   astore 7 
L384:   aload_2 
L385:   invokeinterface [38] 0 
L390:   astore 8 
L392:   aload_0 
L393:   getfield [23] 
L396:   aload 7 
L398:   aload 8 
L400:   aload_3 
L401:   checkcast [6] 
L404:   invokeinterface [40] 0 
L409:   goto L1569 
L412:   aload_2 
L413:   invokestatic [8] 
L416:   astore 7 
L418:   aload_0 
L419:   getfield [23] 
L422:   aload 7 
L424:   aload_3 
L425:   checkcast [6] 
L428:   invokeinterface [41] 0 
L433:   goto L1569 
L436:   aload_2 
L437:   invokeinterface [37] 0 
L442:   lstore 7 
L444:   aload_0 
L445:   getfield [23] 
L448:   lload 7 
L450:   aload_3 
L451:   checkcast [6] 
L454:   invokeinterface [42] 0 
L459:   goto L1569 
L462:   aload_2 
L463:   invokeinterface [38] 0 
L468:   astore 7 
L470:   aload_0 
L471:   getfield [23] 
L474:   aload 7 
L476:   aload_3 
L477:   checkcast [6] 
L480:   invokeinterface [43] 0 
L485:   goto L1569 
L488:   aload_2 
L489:   invokeinterface [37] 0 
L494:   lstore 7 
L496:   aload_0 
L497:   getfield [23] 
L500:   lload 7 
L502:   aload_3 
L503:   checkcast [6] 
L506:   invokeinterface [44] 0 
L511:   goto L1569 
L514:   aload_2 
L515:   invokeinterface [38] 0 
L520:   astore 7 
L522:   aload_0 
L523:   getfield [23] 
L526:   aload 7 
L528:   aload_3 
L529:   checkcast [6] 
L532:   invokeinterface [45] 0 
L537:   goto L1569 
L540:   aload_2 
L541:   invokestatic [8] 
L544:   astore 7 
L546:   aload_0 
L547:   getfield [23] 
L550:   aload 7 
L552:   aload_3 
L553:   checkcast [6] 
L556:   invokeinterface [46] 0 
L561:   goto L1569 
L564:   aload_2 
L565:   invokestatic [8] 
L568:   astore 7 
L570:   aload_2 
L571:   invokeinterface [47] 0 
L576:   istore 8 
L578:   aload_0 
L579:   getfield [23] 
L582:   aload 7 
L584:   iload 8 
L586:   aload_3 
L587:   checkcast [6] 
L590:   invokeinterface [48] 0 
L595:   goto L1569 
L598:   aload_2 
L599:   invokestatic [8] 
L602:   astore 7 
L604:   aload_0 
L605:   getfield [23] 
L608:   aload 7 
L610:   aload_3 
L611:   checkcast [6] 
L614:   invokeinterface [49] 0 
L619:   goto L1569 
L622:   aload_2 
L623:   invokestatic [8] 
L626:   astore 7 
L628:   aload_0 
L629:   getfield [23] 
L632:   aload 7 
L634:   aload_3 
L635:   checkcast [6] 
L638:   invokeinterface [50] 0 
L643:   goto L1569 
L646:   aload_2 
L647:   invokestatic [8] 
L650:   astore 7 
L652:   aload_2 
L653:   invokeinterface [37] 0 
L658:   lstore 8 
L660:   aload_0 
L661:   getfield [23] 
L664:   aload 7 
L666:   lload 8 
L668:   aload_3 
L669:   checkcast [6] 
L672:   invokeinterface [51] 0 
L677:   goto L1569 
L680:   aload_2 
L681:   invokestatic [8] 
L684:   astore 7 
L686:   aload_2 
L687:   invokeinterface [37] 0 
L692:   lstore 8 
L694:   aload_0 
L695:   getfield [23] 
L698:   aload 7 
L700:   lload 8 
L702:   aload_3 
L703:   checkcast [6] 
L706:   invokeinterface [52] 0 
L711:   goto L1569 
L714:   aload_2 
L715:   invokestatic [8] 
L718:   astore 7 
L720:   aload_2 
L721:   invokeinterface [37] 0 
L726:   lstore 8 
L728:   aload_2 
L729:   invokeinterface [37] 0 
L734:   lstore 10 
L736:   aload_0 
L737:   getfield [23] 
L740:   aload 7 
L742:   lload 8 
L744:   lload 10 
L746:   aload_3 
L747:   checkcast [6] 
L750:   invokeinterface [53] 0 
L755:   goto L1569 
L758:   aload_2 
L759:   invokestatic [8] 
L762:   astore 7 
L764:   aload_2 
L765:   invokeinterface [37] 0 
L770:   lstore 8 
L772:   aload_2 
L773:   invokeinterface [54] 0 
L778:   istore 10 
L780:   aload_0 
L781:   getfield [23] 
L784:   aload 7 
L786:   lload 8 
L788:   iload 10 
L790:   aload_3 
L791:   checkcast [6] 
L794:   invokeinterface [55] 0 
L799:   goto L1569 
L802:   aload_2 
L803:   invokestatic [8] 
L806:   astore 7 
L808:   aload_2 
L809:   invokeinterface [37] 0 
L814:   lstore 8 
L816:   aload_0 
L817:   getfield [23] 
L820:   aload 7 
L822:   lload 8 
L824:   aload_3 
L825:   checkcast [6] 
L828:   invokeinterface [56] 0 
L833:   goto L1569 
L836:   aload_2 
L837:   invokestatic [8] 
L840:   astore 7 
L842:   aload_2 
L843:   invokeinterface [57] 0 
L848:   astore 8 
L850:   aload_2 
L851:   invokeinterface [54] 0 
L856:   istore 9 
L858:   aload_0 
L859:   getfield [23] 
L862:   aload 7 
L864:   aload 8 
L866:   iload 9 
L868:   aload_3 
L869:   checkcast [6] 
L872:   invokeinterface [58] 0 
L877:   goto L1569 
L880:   aload_2 
L881:   invokestatic [8] 
L884:   astore 7 
L886:   aload_2 
L887:   invokeinterface [57] 0 
L892:   astore 8 
L894:   aload_0 
L895:   getfield [23] 
L898:   aload 7 
L900:   aload 8 
L902:   aload_3 
L903:   checkcast [6] 
L906:   invokeinterface [59] 0 
L911:   goto L1569 
L914:   aload_2 
L915:   invokestatic [8] 
L918:   astore 7 
L920:   aload_2 
L921:   invokeinterface [37] 0 
L926:   lstore 8 
L928:   aload_2 
L929:   invokeinterface [38] 0 
L934:   astore 10 
L936:   aload_0 
L937:   getfield [23] 
L940:   aload 7 
L942:   lload 8 
L944:   aload 10 
L946:   aload_3 
L947:   checkcast [6] 
L950:   invokeinterface [60] 0 
L955:   goto L1569 
L958:   aload_2 
L959:   invokestatic [8] 
L962:   astore 7 
L964:   aload_2 
L965:   invokeinterface [37] 0 
L970:   lstore 8 
L972:   aload_2 
L973:   invokeinterface [54] 0 
L978:   istore 10 
L980:   aload_0 
L981:   getfield [23] 
L984:   aload 7 
L986:   lload 8 
L988:   iload 10 
L990:   aload_3 
L991:   checkcast [6] 
L994:   invokeinterface [61] 0 
L999:   goto L1569 
L1002:  aload_2 
L1003:  invokestatic [8] 
L1006:  astore 7 
L1008:  aload_2 
L1009:  invokeinterface [37] 0 
L1014:  lstore 8 
L1016:  aload_0 
L1017:  getfield [23] 
L1020:  aload 7 
L1022:  lload 8 
L1024:  aload_3 
L1025:  checkcast [6] 
L1028:  invokeinterface [62] 0 
L1033:  goto L1569 
L1036:  aload_2 
L1037:  invokestatic [8] 
L1040:  astore 7 
L1042:  aload_2 
L1043:  invokeinterface [57] 0 
L1048:  astore 8 
L1050:  aload_2 
L1051:  invokeinterface [54] 0 
L1056:  istore 9 
L1058:  aload_0 
L1059:  getfield [23] 
L1062:  aload 7 
L1064:  aload 8 
L1066:  iload 9 
L1068:  aload_3 
L1069:  checkcast [6] 
L1072:  invokeinterface [63] 0 
L1077:  goto L1569 
L1080:  aload_2 
L1081:  invokestatic [8] 
L1084:  astore 7 
L1086:  aload_2 
L1087:  invokeinterface [57] 0 
L1092:  astore 8 
L1094:  aload_0 
L1095:  getfield [23] 
L1098:  aload 7 
L1100:  aload 8 
L1102:  aload_3 
L1103:  checkcast [6] 
L1106:  invokeinterface [64] 0 
L1111:  goto L1569 
L1114:  aload_2 
L1115:  invokestatic [8] 
L1118:  astore 7 
L1120:  aload_2 
L1121:  invokeinterface [37] 0 
L1126:  lstore 8 
L1128:  aload_2 
L1129:  invokeinterface [65] 0 
L1134:  astore 10 
L1136:  aload_0 
L1137:  getfield [23] 
L1140:  aload 7 
L1142:  lload 8 
L1144:  aload 10 
L1146:  aload_3 
L1147:  checkcast [6] 
L1150:  invokeinterface [66] 0 
L1155:  goto L1569 
L1158:  aload_2 
L1159:  invokestatic [8] 
L1162:  astore 7 
L1164:  aload_2 
L1165:  invokeinterface [37] 0 
L1170:  lstore 8 
L1172:  aload_2 
L1173:  invokeinterface [54] 0 
L1178:  istore 10 
L1180:  aload_0 
L1181:  getfield [23] 
L1184:  aload 7 
L1186:  lload 8 
L1188:  iload 10 
L1190:  aload_3 
L1191:  checkcast [6] 
L1194:  invokeinterface [67] 0 
L1199:  goto L1569 
L1202:  aload_2 
L1203:  invokestatic [8] 
L1206:  astore 7 
L1208:  aload_2 
L1209:  invokeinterface [37] 0 
L1214:  lstore 8 
L1216:  aload_0 
L1217:  getfield [23] 
L1220:  aload 7 
L1222:  lload 8 
L1224:  aload_3 
L1225:  checkcast [6] 
L1228:  invokeinterface [68] 0 
L1233:  goto L1569 
L1236:  aload_2 
L1237:  invokestatic [8] 
L1240:  astore 7 
L1242:  aload_2 
L1243:  invokeinterface [57] 0 
L1248:  astore 8 
L1250:  aload_2 
L1251:  invokeinterface [54] 0 
L1256:  istore 9 
L1258:  aload_0 
L1259:  getfield [23] 
L1262:  aload 7 
L1264:  aload 8 
L1266:  iload 9 
L1268:  aload_3 
L1269:  checkcast [6] 
L1272:  invokeinterface [69] 0 
L1277:  goto L1569 
L1280:  aload_2 
L1281:  invokestatic [8] 
L1284:  astore 7 
L1286:  aload_2 
L1287:  invokeinterface [57] 0 
L1292:  astore 8 
L1294:  aload_0 
L1295:  getfield [23] 
L1298:  aload 7 
L1300:  aload 8 
L1302:  aload_3 
L1303:  checkcast [6] 
L1306:  invokeinterface [70] 0 
L1311:  goto L1569 
L1314:  aload_2 
L1315:  invokestatic [8] 
L1318:  astore 7 
L1320:  aload_2 
L1321:  invokeinterface [57] 0 
L1326:  astore 8 
L1328:  aload_2 
L1329:  invokeinterface [54] 0 
L1334:  istore 9 
L1336:  aload_0 
L1337:  getfield [23] 
L1340:  aload 7 
L1342:  aload 8 
L1344:  iload 9 
L1346:  aload_3 
L1347:  checkcast [6] 
L1350:  invokeinterface [71] 0 
L1355:  goto L1569 
L1358:  aload_2 
L1359:  invokestatic [8] 
L1362:  astore 7 
L1364:  aload_2 
L1365:  invokeinterface [57] 0 
L1370:  astore 8 
L1372:  aload_0 
L1373:  getfield [23] 
L1376:  aload 7 
L1378:  aload 8 
L1380:  aload_3 
L1381:  checkcast [6] 
L1384:  invokeinterface [72] 0 
L1389:  goto L1569 
L1392:  aload_2 
L1393:  invokestatic [8] 
L1396:  astore 7 
L1398:  aload_2 
L1399:  invokeinterface [57] 0 
L1404:  astore 8 
L1406:  aload_0 
L1407:  getfield [23] 
L1410:  aload 7 
L1412:  aload 8 
L1414:  aload_3 
L1415:  checkcast [6] 
L1418:  invokeinterface [73] 0 
L1423:  goto L1569 
L1426:  aload_2 
L1427:  invokestatic [8] 
L1430:  astore 7 
L1432:  aload_0 
L1433:  getfield [23] 
L1436:  aload 7 
L1438:  aload_3 
L1439:  checkcast [6] 
L1442:  invokeinterface [74] 0 
L1447:  goto L1569 
L1450:  aload_2 
L1451:  invokeinterface [37] 0 
L1456:  lstore 7 
L1458:  aload_2 
L1459:  invokeinterface [38] 0 
L1464:  astore 9 
L1466:  aload_2 
L1467:  invokeinterface [38] 0 
L1472:  astore 10 
L1474:  aload_0 
L1475:  getfield [23] 
L1478:  lload 7 
L1480:  aload 9 
L1482:  aload 10 
L1484:  aload_3 
L1485:  checkcast [6] 
L1488:  invokeinterface [75] 0 
L1493:  goto L1569 
L1496:  aload_2 
L1497:  invokeinterface [38] 0 
L1502:  astore 7 
L1504:  aload_2 
L1505:  invokeinterface [38] 0 
L1510:  astore 8 
L1512:  aload_2 
L1513:  invokeinterface [38] 0 
L1518:  astore 9 
L1520:  aload_0 
L1521:  getfield [23] 
L1524:  aload 7 
L1526:  aload 8 
L1528:  aload 9 
L1530:  aload_3 
L1531:  checkcast [6] 
L1534:  invokeinterface [76] 0 
L1539:  goto L1569 
L1542:  new [77] 
L1545:  dup 
L1546:  new [78] 
L1549:  dup 
L1550:  invokespecial [32] 
L1553:  ldc [11] 
L1555:  invokevirtual [24] 
L1558:  iload_1 
L1559:  invokevirtual [25] 
L1562:  invokevirtual [26] 
L1565:  invokespecial [33] 
L1568:  athrow 
L1569:  goto L1614 
L1572:  astore 7 
L1574:  new [77] 
L1577:  dup 
L1578:  new [78] 
L1581:  dup 
L1582:  invokespecial [32] 
L1585:  ldc [13] 
L1587:  invokevirtual [24] 
L1590:  iload_1 
L1591:  invokevirtual [25] 
L1594:  ldc [14] 
L1596:  invokevirtual [24] 
L1599:  aload 7 
L1601:  invokevirtual [27] 
L1604:  invokevirtual [24] 
L1607:  invokevirtual [26] 
L1610:  invokespecial [33] 
L1613:  athrow 
L1614:  return 
L1615:  nop 
L1616:  
    .end code 
.end method 

.method static [393] : [394] 
    .attribute [384] .code stack 1 locals 0 
L0:     ldc [15] 
L2:     invokestatic [16] 
L5:     putstatic [31] 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [79] 
.const [3] = String [80] 
.const [4] = String [81] 
.const [5] = String [82] 
.const [6] = Class [83] 
.const [7] = Field [84] [85] 
.const [8] = Method [86] [87] 
.const [9] = Class [88] 
.const [10] = Class [89] 
.const [11] = String [90] 
.const [12] = Class [91] 
.const [13] = String [92] 
.const [14] = String [93] 
.const [15] = String [94] 
.const [16] = Method [95] [96] 
.const [17] = Class [97] 
.const [18] = Class [98] 
.const [19] = Class [99] 
.const [20] = Class [100] 
.const [21] = Class [101] 
.const [22] = Class [102] 
.const [23] = Field [103] [104] 
.const [24] = Method [105] [106] 
.const [25] = Method [107] [108] 
.const [26] = Method [109] [110] 
.const [27] = Method [111] [112] 
.const [28] = Method [113] [114] 
.const [29] = Method [115] [116] 
.const [30] = Method [117] [118] 
.const [31] = Field [119] [120] 
.const [32] = Method [121] [122] 
.const [33] = Method [123] [124] 
.const [34] = Class [125] 
.const [35] = Field [126] [127] 
.const [36] = Class [128] 
.const [37] = InterfaceMethod [129] [130] 
.const [38] = InterfaceMethod [131] [132] 
.const [39] = InterfaceMethod [133] [134] 
.const [40] = InterfaceMethod [135] [136] 
.const [41] = InterfaceMethod [137] [138] 
.const [42] = InterfaceMethod [139] [140] 
.const [43] = InterfaceMethod [141] [142] 
.const [44] = InterfaceMethod [143] [144] 
.const [45] = InterfaceMethod [145] [146] 
.const [46] = InterfaceMethod [147] [148] 
.const [47] = InterfaceMethod [149] [150] 
.const [48] = InterfaceMethod [151] [152] 
.const [49] = InterfaceMethod [153] [154] 
.const [50] = InterfaceMethod [155] [156] 
.const [51] = InterfaceMethod [157] [158] 
.const [52] = InterfaceMethod [159] [160] 
.const [53] = InterfaceMethod [161] [162] 
.const [54] = InterfaceMethod [163] [164] 
.const [55] = InterfaceMethod [165] [166] 
.const [56] = InterfaceMethod [167] [168] 
.const [57] = InterfaceMethod [169] [170] 
.const [58] = InterfaceMethod [171] [172] 
.const [59] = InterfaceMethod [173] [174] 
.const [60] = InterfaceMethod [175] [176] 
.const [61] = InterfaceMethod [177] [178] 
.const [62] = InterfaceMethod [179] [180] 
.const [63] = InterfaceMethod [181] [182] 
.const [64] = InterfaceMethod [183] [184] 
.const [65] = InterfaceMethod [185] [186] 
.const [66] = InterfaceMethod [187] [188] 
.const [67] = InterfaceMethod [189] [190] 
.const [68] = InterfaceMethod [191] [192] 
.const [69] = InterfaceMethod [193] [194] 
.const [70] = InterfaceMethod [195] [196] 
.const [71] = InterfaceMethod [197] [198] 
.const [72] = InterfaceMethod [199] [200] 
.const [73] = InterfaceMethod [201] [202] 
.const [74] = InterfaceMethod [203] [204] 
.const [75] = InterfaceMethod [205] [206] 
.const [76] = InterfaceMethod [207] [208] 
.const [77] = Class [209] 
.const [78] = Class [210] 
.const [79] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [80] = Utf8 '03171582-f255-4991-b8ae-83f90521c08b' 
.const [81] = Utf8 '6e1d32e0-f75b-5b13-8215-fd985747e793' 
.const [82] = Utf8 'persistence.IPersistenceA' 
.const [83] = Utf8 de/esolutions/fw/comm/persistence/impl/IPersistenceAReplyProxy 
.const [84] = Class [211] 
.const [85] = NameAndType [212] [213] 
.const [86] = Class [214] 
.const [87] = NameAndType [215] [216] 
.const [88] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [89] = Utf8 java/lang/StringBuffer 
.const [90] = Utf8 'Invalid Method Id ' 
.const [91] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [92] = Utf8 'Deserialization failed: method=' 
.const [93] = Utf8 ', error=' 
.const [94] = Utf8 'STUB.persistence.IPersistenceA' 
.const [95] = Class [217] 
.const [96] = NameAndType [218] [219] 
.const [97] = Utf8 de/esolutions/fw/comm/persistence/impl/IPersistenceAService 
.const [98] = Utf8 de/esolutions/fw/comm/core/AbstractService 
.const [99] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [100] = Utf8 de/esolutions/fw/comm/persistence/IPersistenceAS 
.const [101] = Utf8 de/esolutions/fw/comm/persistence/impl/PartitionHandleSerializer 
.const [102] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [103] = Class [220] 
.const [104] = NameAndType [221] [222] 
.const [105] = Class [223] 
.const [106] = NameAndType [224] [225] 
.const [107] = Class [226] 
.const [108] = NameAndType [227] [228] 
.const [109] = Class [229] 
.const [110] = NameAndType [230] [231] 
.const [111] = Class [232] 
.const [112] = NameAndType [233] [234] 
.const [113] = Class [235] 
.const [114] = NameAndType [236] [237] 
.const [115] = Class [238] 
.const [116] = NameAndType [239] [240] 
.const [117] = Class [241] 
.const [118] = NameAndType [242] [243] 
.const [119] = Class [244] 
.const [120] = NameAndType [245] [246] 
.const [121] = Class [247] 
.const [122] = NameAndType [248] [249] 
.const [123] = Class [250] 
.const [124] = NameAndType [251] [252] 
.const [125] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [126] = Class [253] 
.const [127] = NameAndType [254] [255] 
.const [128] = Utf8 de/esolutions/fw/comm/persistence/impl/IPersistenceAReplyProxy 
.const [129] = Class [256] 
.const [130] = NameAndType [257] [258] 
.const [131] = Class [259] 
.const [132] = NameAndType [260] [261] 
.const [133] = Class [262] 
.const [134] = NameAndType [263] [264] 
.const [135] = Class [265] 
.const [136] = NameAndType [266] [267] 
.const [137] = Class [268] 
.const [138] = NameAndType [269] [270] 
.const [139] = Class [271] 
.const [140] = NameAndType [272] [273] 
.const [141] = Class [274] 
.const [142] = NameAndType [275] [276] 
.const [143] = Class [277] 
.const [144] = NameAndType [278] [279] 
.const [145] = Class [280] 
.const [146] = NameAndType [281] [282] 
.const [147] = Class [283] 
.const [148] = NameAndType [284] [285] 
.const [149] = Class [286] 
.const [150] = NameAndType [287] [288] 
.const [151] = Class [289] 
.const [152] = NameAndType [290] [291] 
.const [153] = Class [292] 
.const [154] = NameAndType [293] [294] 
.const [155] = Class [295] 
.const [156] = NameAndType [296] [297] 
.const [157] = Class [298] 
.const [158] = NameAndType [299] [300] 
.const [159] = Class [301] 
.const [160] = NameAndType [302] [303] 
.const [161] = Class [304] 
.const [162] = NameAndType [305] [306] 
.const [163] = Class [307] 
.const [164] = NameAndType [308] [309] 
.const [165] = Class [310] 
.const [166] = NameAndType [311] [312] 
.const [167] = Class [313] 
.const [168] = NameAndType [314] [315] 
.const [169] = Class [316] 
.const [170] = NameAndType [317] [318] 
.const [171] = Class [319] 
.const [172] = NameAndType [320] [321] 
.const [173] = Class [322] 
.const [174] = NameAndType [323] [324] 
.const [175] = Class [325] 
.const [176] = NameAndType [326] [327] 
.const [177] = Class [328] 
.const [178] = NameAndType [329] [330] 
.const [179] = Class [331] 
.const [180] = NameAndType [332] [333] 
.const [181] = Class [334] 
.const [182] = NameAndType [335] [336] 
.const [183] = Class [337] 
.const [184] = NameAndType [338] [339] 
.const [185] = Class [340] 
.const [186] = NameAndType [341] [342] 
.const [187] = Class [343] 
.const [188] = NameAndType [344] [345] 
.const [189] = Class [346] 
.const [190] = NameAndType [347] [348] 
.const [191] = Class [349] 
.const [192] = NameAndType [350] [351] 
.const [193] = Class [352] 
.const [194] = NameAndType [353] [354] 
.const [195] = Class [355] 
.const [196] = NameAndType [356] [357] 
.const [197] = Class [358] 
.const [198] = NameAndType [359] [360] 
.const [199] = Class [361] 
.const [200] = NameAndType [362] [363] 
.const [201] = Class [364] 
.const [202] = NameAndType [365] [366] 
.const [203] = Class [367] 
.const [204] = NameAndType [368] [369] 
.const [205] = Class [370] 
.const [206] = NameAndType [371] [372] 
.const [207] = Class [373] 
.const [208] = NameAndType [374] [375] 
.const [209] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [210] = Utf8 java/lang/StringBuffer 
.const [211] = Utf8 de/esolutions/fw/comm/persistence/impl/IPersistenceAService 
.const [212] = Utf8 context 
.const [213] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [214] = Utf8 de/esolutions/fw/comm/persistence/impl/PartitionHandleSerializer 
.const [215] = Utf8 getOptionalPartitionHandle 
.const [216] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lde/esolutions/fw/comm/persistence/PartitionHandle; 
.const [217] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [218] = Utf8 getContext 
.const [219] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/comm/core/CallContext; 
.const [220] = Utf8 de/esolutions/fw/comm/persistence/impl/IPersistenceAService 
.const [221] = Utf8 p_IPersistenceA 
.const [222] = Utf8 Lde/esolutions/fw/comm/persistence/IPersistenceAS; 
.const [223] = Utf8 java/lang/StringBuffer 
.const [224] = Utf8 append 
.const [225] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [226] = Utf8 java/lang/StringBuffer 
.const [227] = Utf8 append 
.const [228] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [229] = Utf8 java/lang/StringBuffer 
.const [230] = Utf8 toString 
.const [231] = Utf8 ()Ljava/lang/String; 
.const [232] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [233] = Utf8 getMessage 
.const [234] = Utf8 ()Ljava/lang/String; 
.const [235] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [236] = Utf8 <init> 
.const [237] = Utf8 (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V 
.const [238] = Utf8 de/esolutions/fw/comm/core/AbstractService 
.const [239] = Utf8 <init> 
.const [240] = Utf8 (Lde/esolutions/fw/comm/core/ServiceInstanceID;)V 
.const [241] = Utf8 de/esolutions/fw/comm/persistence/impl/IPersistenceAReplyProxy 
.const [242] = Utf8 <init> 
.const [243] = Utf8 ()V 
.const [244] = Utf8 de/esolutions/fw/comm/persistence/impl/IPersistenceAService 
.const [245] = Utf8 context 
.const [246] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [247] = Utf8 java/lang/StringBuffer 
.const [248] = Utf8 <init> 
.const [249] = Utf8 ()V 
.const [250] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [251] = Utf8 <init> 
.const [252] = Utf8 (Ljava/lang/String;)V 
.const [253] = Utf8 de/esolutions/fw/comm/persistence/impl/IPersistenceAService 
.const [254] = Utf8 p_IPersistenceA 
.const [255] = Utf8 Lde/esolutions/fw/comm/persistence/IPersistenceAS; 
.const [256] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [257] = Utf8 getUInt32 
.const [258] = Utf8 ()J 
.const [259] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [260] = Utf8 getOptionalString 
.const [261] = Utf8 ()Ljava/lang/String; 
.const [262] = Utf8 de/esolutions/fw/comm/persistence/IPersistenceAS 
.const [263] = Utf8 'open' 
.const [264] = Utf8 (JLjava/lang/String;Lde/esolutions/fw/comm/persistence/IPersistenceAReply;)V 
.const [265] = Utf8 de/esolutions/fw/comm/persistence/IPersistenceAS 
.const [266] = Utf8 'open' 
.const [267] = Utf8 (Ljava/lang/String;Ljava/lang/String;Lde/esolutions/fw/comm/persistence/IPersistenceAReply;)V 
.const [268] = Utf8 de/esolutions/fw/comm/persistence/IPersistenceAS 
.const [269] = Utf8 close 
.const [270] = Utf8 (Lde/esolutions/fw/comm/persistence/PartitionHandle;Lde/esolutions/fw/comm/persistence/IPersistenceAReply;)V 
.const [271] = Utf8 de/esolutions/fw/comm/persistence/IPersistenceAS 
.const [272] = Utf8 version 
.const [273] = Utf8 (JLde/esolutions/fw/comm/persistence/IPersistenceAReply;)V 
.const [274] = Utf8 de/esolutions/fw/comm/persistence/IPersistenceAS 
.const [275] = Utf8 version 
.const [276] = Utf8 (Ljava/lang/String;Lde/esolutions/fw/comm/persistence/IPersistenceAReply;)V 
.const [277] = Utf8 de/esolutions/fw/comm/persistence/IPersistenceAS 
.const [278] = Utf8 purge 
.const [279] = Utf8 (JLde/esolutions/fw/comm/persistence/IPersistenceAReply;)V 
.const [280] = Utf8 de/esolutions/fw/comm/persistence/IPersistenceAS 
.const [281] = Utf8 purge 
.const [282] = Utf8 (Ljava/lang/String;Lde/esolutions/fw/comm/persistence/IPersistenceAReply;)V 
.const [283] = Utf8 de/esolutions/fw/comm/persistence/IPersistenceAS 
.const [284] = Utf8 beginTransaction 
.const [285] = Utf8 (Lde/esolutions/fw/comm/persistence/PartitionHandle;Lde/esolutions/fw/comm/persistence/IPersistenceAReply;)V 
.const [286] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [287] = Utf8 getBool 
.const [288] = Utf8 ()Z 
.const [289] = Utf8 de/esolutions/fw/comm/persistence/IPersistenceAS 
.const [290] = Utf8 endTransaction 
.const [291] = Utf8 (Lde/esolutions/fw/comm/persistence/PartitionHandle;ZLde/esolutions/fw/comm/persistence/IPersistenceAReply;)V 
.const [292] = Utf8 de/esolutions/fw/comm/persistence/IPersistenceAS 
.const [293] = Utf8 endTransaction 
.const [294] = Utf8 (Lde/esolutions/fw/comm/persistence/PartitionHandle;Lde/esolutions/fw/comm/persistence/IPersistenceAReply;)V 
.const [295] = Utf8 de/esolutions/fw/comm/persistence/IPersistenceAS 
.const [296] = Utf8 flush 
.const [297] = Utf8 (Lde/esolutions/fw/comm/persistence/PartitionHandle;Lde/esolutions/fw/comm/persistence/IPersistenceAReply;)V 
.const [298] = Utf8 de/esolutions/fw/comm/persistence/IPersistenceAS 
.const [299] = Utf8 exists 
.const [300] = Utf8 (Lde/esolutions/fw/comm/persistence/PartitionHandle;JLde/esolutions/fw/comm/persistence/IPersistenceAReply;)V 
.const [301] = Utf8 de/esolutions/fw/comm/persistence/IPersistenceAS 
.const [302] = Utf8 remove 
.const [303] = Utf8 (Lde/esolutions/fw/comm/persistence/PartitionHandle;JLde/esolutions/fw/comm/persistence/IPersistenceAReply;)V 
.const [304] = Utf8 de/esolutions/fw/comm/persistence/IPersistenceAS 
.const [305] = Utf8 setInt 
.const [306] = Utf8 (Lde/esolutions/fw/comm/persistence/PartitionHandle;JJLde/esolutions/fw/comm/persistence/IPersistenceAReply;)V 
.const [307] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [308] = Utf8 getInt32 
.const [309] = Utf8 ()I 
.const [310] = Utf8 de/esolutions/fw/comm/persistence/IPersistenceAS 
.const [311] = Utf8 getInt 
.const [312] = Utf8 (Lde/esolutions/fw/comm/persistence/PartitionHandle;JILde/esolutions/fw/comm/persistence/IPersistenceAReply;)V 
.const [313] = Utf8 de/esolutions/fw/comm/persistence/IPersistenceAS 
.const [314] = Utf8 getInt 
.const [315] = Utf8 (Lde/esolutions/fw/comm/persistence/PartitionHandle;JLde/esolutions/fw/comm/persistence/IPersistenceAReply;)V 
.const [316] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [317] = Utf8 getOptionalUInt32VarArray 
.const [318] = Utf8 ()[J 
.const [319] = Utf8 de/esolutions/fw/comm/persistence/IPersistenceAS 
.const [320] = Utf8 getInts 
.const [321] = Utf8 (Lde/esolutions/fw/comm/persistence/PartitionHandle;[JILde/esolutions/fw/comm/persistence/IPersistenceAReply;)V 
.const [322] = Utf8 de/esolutions/fw/comm/persistence/IPersistenceAS 
.const [323] = Utf8 getInts 
.const [324] = Utf8 (Lde/esolutions/fw/comm/persistence/PartitionHandle;[JLde/esolutions/fw/comm/persistence/IPersistenceAReply;)V 
.const [325] = Utf8 de/esolutions/fw/comm/persistence/IPersistenceAS 
.const [326] = Utf8 setString 
.const [327] = Utf8 (Lde/esolutions/fw/comm/persistence/PartitionHandle;JLjava/lang/String;Lde/esolutions/fw/comm/persistence/IPersistenceAReply;)V 
.const [328] = Utf8 de/esolutions/fw/comm/persistence/IPersistenceAS 
.const [329] = Utf8 getString 
.const [330] = Utf8 (Lde/esolutions/fw/comm/persistence/PartitionHandle;JILde/esolutions/fw/comm/persistence/IPersistenceAReply;)V 
.const [331] = Utf8 de/esolutions/fw/comm/persistence/IPersistenceAS 
.const [332] = Utf8 getString 
.const [333] = Utf8 (Lde/esolutions/fw/comm/persistence/PartitionHandle;JLde/esolutions/fw/comm/persistence/IPersistenceAReply;)V 
.const [334] = Utf8 de/esolutions/fw/comm/persistence/IPersistenceAS 
.const [335] = Utf8 getStrings 
.const [336] = Utf8 (Lde/esolutions/fw/comm/persistence/PartitionHandle;[JILde/esolutions/fw/comm/persistence/IPersistenceAReply;)V 
.const [337] = Utf8 de/esolutions/fw/comm/persistence/IPersistenceAS 
.const [338] = Utf8 getStrings 
.const [339] = Utf8 (Lde/esolutions/fw/comm/persistence/PartitionHandle;[JLde/esolutions/fw/comm/persistence/IPersistenceAReply;)V 
.const [340] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [341] = Utf8 getOptionalUInt8VarArray 
.const [342] = Utf8 ()[S 
.const [343] = Utf8 de/esolutions/fw/comm/persistence/IPersistenceAS 
.const [344] = Utf8 setBlob 
.const [345] = Utf8 (Lde/esolutions/fw/comm/persistence/PartitionHandle;J[SLde/esolutions/fw/comm/persistence/IPersistenceAReply;)V 
.const [346] = Utf8 de/esolutions/fw/comm/persistence/IPersistenceAS 
.const [347] = Utf8 getBlob 
.const [348] = Utf8 (Lde/esolutions/fw/comm/persistence/PartitionHandle;JILde/esolutions/fw/comm/persistence/IPersistenceAReply;)V 
.const [349] = Utf8 de/esolutions/fw/comm/persistence/IPersistenceAS 
.const [350] = Utf8 getBlob 
.const [351] = Utf8 (Lde/esolutions/fw/comm/persistence/PartitionHandle;JLde/esolutions/fw/comm/persistence/IPersistenceAReply;)V 
.const [352] = Utf8 de/esolutions/fw/comm/persistence/IPersistenceAS 
.const [353] = Utf8 getBlobs 
.const [354] = Utf8 (Lde/esolutions/fw/comm/persistence/PartitionHandle;[JILde/esolutions/fw/comm/persistence/IPersistenceAReply;)V 
.const [355] = Utf8 de/esolutions/fw/comm/persistence/IPersistenceAS 
.const [356] = Utf8 getBlobs 
.const [357] = Utf8 (Lde/esolutions/fw/comm/persistence/PartitionHandle;[JLde/esolutions/fw/comm/persistence/IPersistenceAReply;)V 
.const [358] = Utf8 de/esolutions/fw/comm/persistence/IPersistenceAS 
.const [359] = Utf8 subscribe 
.const [360] = Utf8 (Lde/esolutions/fw/comm/persistence/PartitionHandle;[JILde/esolutions/fw/comm/persistence/IPersistenceAReply;)V 
.const [361] = Utf8 de/esolutions/fw/comm/persistence/IPersistenceAS 
.const [362] = Utf8 subscribe 
.const [363] = Utf8 (Lde/esolutions/fw/comm/persistence/PartitionHandle;[JLde/esolutions/fw/comm/persistence/IPersistenceAReply;)V 
.const [364] = Utf8 de/esolutions/fw/comm/persistence/IPersistenceAS 
.const [365] = Utf8 unsubscribe 
.const [366] = Utf8 (Lde/esolutions/fw/comm/persistence/PartitionHandle;[JLde/esolutions/fw/comm/persistence/IPersistenceAReply;)V 
.const [367] = Utf8 de/esolutions/fw/comm/persistence/IPersistenceAS 
.const [368] = Utf8 unsubscribeAll 
.const [369] = Utf8 (Lde/esolutions/fw/comm/persistence/PartitionHandle;Lde/esolutions/fw/comm/persistence/IPersistenceAReply;)V 
.const [370] = Utf8 de/esolutions/fw/comm/persistence/IPersistenceAS 
.const [371] = Utf8 convert 
.const [372] = Utf8 (JLjava/lang/String;Ljava/lang/String;Lde/esolutions/fw/comm/persistence/IPersistenceAReply;)V 
.const [373] = Utf8 de/esolutions/fw/comm/persistence/IPersistenceAS 
.const [374] = Utf8 convert 
.const [375] = Utf8 (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lde/esolutions/fw/comm/persistence/IPersistenceAReply;)V 
.const [376] = Utf8 de/esolutions/fw/comm/persistence/impl/IPersistenceAService 
.const [377] = Class [376] 
.const [378] = Utf8 de/esolutions/fw/comm/core/AbstractService 
.const [379] = Class [378] 
.const [380] = Utf8 context 
.const [381] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [382] = Utf8 p_IPersistenceA 
.const [383] = Utf8 Lde/esolutions/fw/comm/persistence/IPersistenceAS; 
.const [384] = Utf8 Code 
.const [385] = Utf8 <init> 
.const [386] = Utf8 (ILde/esolutions/fw/comm/persistence/IPersistenceAS;)V 
.const [387] = Utf8 createReplyProxy 
.const [388] = Utf8 ()Lde/esolutions/fw/comm/core/IProxyFrontend; 
.const [389] = Utf8 getCallContext 
.const [390] = Utf8 ()Lde/esolutions/fw/comm/core/CallContext; 
.const [391] = Utf8 handleCallMethod 
.const [392] = Utf8 (SLde/esolutions/fw/util/serializer/IDeserializer;Lde/esolutions/fw/comm/core/IProxyFrontend;)V 
.const [393] = Utf8 <clinit> 
.const [394] = Utf8 ()V 
.end class 
