-- DMD01_Account.SQL
-- 관리자, 교사, 학생 아이디 및 정보 더미 데이터
------------------------------------------------------------------------------------------------------------
-- 1. 관리자 아이디 더미 데이터(3개)(Login_seq 1 ~ 3)
------------------------------------------------------------------------------------------------------------
SELECT * FROM TBLLOGIN;
DELETE FROM tbllogin;
DROP SEQUENCE login_seq;
CREATE SEQUENCE login_seq;
INSERT INTO tblLogin VALUES (login_seq.nextVal, '이유진', '1234567', '1'); -- 1
INSERT INTO tblLogin VALUES (login_seq.nextVal, '홍요섭', '8912345', '1'); -- 2
INSERT INTO tblLogin VALUES (login_seq.nextVal, '장대호', '6789456', '1'); -- 3
------------------------------------------------------------------------------------------------------------
-- 2. 교사 아이디 더미 데이터(10개)(Login_seq 4 ~ 13)
------------------------------------------------------------------------------------------------------------
INSERT INTO tblLogin VALUES (login_seq.nextVal, '박세인', '1054687', '2'); -- 1
INSERT INTO tblLogin VALUES (login_seq.nextVal, '이응수', '1584652', '2'); -- 2
INSERT INTO tblLogin VALUES (login_seq.nextVal, '이창익', '1354682', '2'); -- 3
INSERT INTO tblLogin VALUES (login_seq.nextVal, '곽우신', '1854263', '2'); -- 4
INSERT INTO tblLogin VALUES (login_seq.nextVal, '이규미', '2068512', '2'); -- 5
INSERT INTO tblLogin VALUES (login_seq.nextVal, '김명선', '1150129', '2'); -- 6
INSERT INTO tblLogin VALUES (login_seq.nextVal, '김현룡', '1140752', '2'); -- 7
INSERT INTO tblLogin VALUES (login_seq.nextVal, '김호진', '1056434', '2'); -- 8
INSERT INTO tblLogin VALUES (login_seq.nextVal, '김대기', '1712350', '2'); -- 9
INSERT INTO tblLogin VALUES (login_seq.nextVal, '임정훈', '1656480', '2'); -- 10

------------------------------------------------------------------------------------------------------------
-- 3. 학생 아이디 더미 데이터 (Login_seq 14 ~ ?)
------------------------------------------------------------------------------------------------------------
INSERT INTO tblLogin VALUES (login_seq.nextVal, '김민성', '2725523', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '김서준', '2013176', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '강주혁', '2670101', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '김성주', '2336324', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '김승언', '1751192', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '김승현', '1905126', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '김지성', '2067703', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '문지원', '2334411', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '박민준', '1432932', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '이상민1', '1124300', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '진태호', '2853671', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '황준혁', '2217337', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '곽성훈', '1062650', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '김찬우', '2121144', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '박준민', '2706811', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '박창현', '1653800', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '서정혁', '1378219', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '우창범', '2745731', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '윤기욱', '2673684', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '이건혁', '2360953', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '김효진', '1504092', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '이주아', '1062054', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '조혜영', '1979080', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '최은서', '2942469', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '김이영', '2479199', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '박지유', '1440403', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '배윤경', '1297559', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '이하은', '1512070', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '정지원', '1223869', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '진혜린', '1382193', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '황의조', '1093163', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '김신욱', '1352892', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '권창훈', '1997997', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '나상호', '1022765', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '남태희', '2246861', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '손흥민', '2124380', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '이강인', '2392094', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '이재성', '1815589', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '정우영', '1266709', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '주세종', '1999128', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '황인범', '1313625', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '황희찬', '1399989', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '권경원', '1516101', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '김문환', '1452817', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '김민재', '1418906', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '김영권', '1103430', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '손화연', '1168641', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '지소연', '2420339', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '강채림', '2996144', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '김소은', '2794731', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '문미라', '2565457', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '박예은', '2019711', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '이세은', '2159645', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '이소담', '2202671', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '이영주', '2678216', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '장슬기', '2465324', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '장창', '2898298', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '조소현', '2208967', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '김진희', '2779508', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '김혜리', '2954653', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '김혜영', '2754176', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '어희진', '2395679', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '이효경', '2223509', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '임선주', '2342875', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '하은혜', '2030083', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '홍혜지', '2002717', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '강가애', '2454761', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '김민정', '2963633', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '민유경', '2250426', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '김대원', '1137446', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '엄원상', '1505758', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '오세훈', '1261828', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '이동준', '1900116', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '정우영1', '1046393', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '조규셩', '1465197', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '김동현', '1629468', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '김진규', '1231827', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '맹성웅', '1201792', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '백승호', '1085760', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '전세진', '1415853', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '정승원', '1455545', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '조영욱', '1496903', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '한찬희1', '1925381', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '강윤성', '1322001', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '김재우', '1847697', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '김진야', '1867350', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '김태현', '1371448', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '원두재', '1004748', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '윤종규', '1851797', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '이상민', '1345500', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '이유현', '1973036', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '정태욱', '1974691', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '송범근', '1434690', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '안주수', '1804038', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '허자웅', '1885781', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '강지우', '1059038', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '이은영', '1698497', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '이정민', '1937801', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '조미진', '1356487', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '천가람', '1129445', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '최다경', '1098300', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '추효주', '1305216', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '현슬기', '1129445', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '김수진', '1098300', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '김혜정', '1305216', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '박혜정', '1220937', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '정민영', '1708482', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '구채현', '1036140', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '김은솔', '2034212', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '노진영', '2510738', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '신보미', '2320122', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '윤현지', '2889428', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '이덕주', '2880483', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '정유진', '2159980', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '조민아', '2790138', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '김민영', '2254900', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '김수정', '2845805', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '이현주', '2302860', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '오현규', '2306151', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '정한민', '2995295', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '허율', '2908008', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '고영준', '2067221', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '권민재', '2783975', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '권혁규', '2244028', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '박건우', '2422256', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '안재준', '2701584', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '이강희', '2673735', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '황재환', '2314836', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '권성윤', '2988686', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '김상준', '2820728', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '김주환', '2486916', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '남윤재', '2493156', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '박진성', '2365139', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '오상준', '2576311', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '이진용', '2755932', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '조현택', '2090143', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '최세윤', '1918890', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '최원창', '1067358', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '김정훈', '1670639', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '백종범', '1258059', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '조성빈', '1697251', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '곽로영', '1394543', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '김가연', '2056916', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '박가현', '2088011', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '박수정', '2816121', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '박유정', '2261034', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '장진영', '2882676', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '전유경', '2822679', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '한보영', '2894781', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '홍채빈', '2175991', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '노하늘', '2572561', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '신혜빈', '2312438', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '윤민지', '2187741', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '황아현', '2054951', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '김민지', '2855353', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '김예은', '2432160', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '변혜진', '2857505', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '이현정', '2625888', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '정설아', '2295819', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '최민아', '2029975', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '박어진', '2930550', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '우서빈', '2350092', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '홍유진', '1474459', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '김용학', '1189424', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '문준호', '1650226', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '이종훈', '1267391', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '정상빈', '1605247', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '최민서', '1233460', '3');
---------------------------------------------------------------------------
-- 수료한 학생 아이디 더미 데이터
---------------------------------------------------------------------------
INSERT INTO tblLogin VALUES (login_seq.nextVal, '홍윤상', '1476973', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '백상훈', '1476973', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '엄지성', '1476973', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '오재혁', '1476973', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '윤석주', '1476973', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '김륜성', '1476973', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '방우진', '1476973', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '손호준', '1476973', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '유승현', '1476973', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '이준석', '1476973', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '이태석', '1476973', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '이한범', '1476973', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '홍서욱', '1476973', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '김준홍', '1476973', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '신송훈', '1476973', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '이승환', '1476973', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '박진영', '1476973', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '권지용', '1476973', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '최승현', '1476973', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '강대성', '1476973', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '동영배', '1476973', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '민선예', '1476973', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '박예은1', '1476973', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '김유빈', '1476973', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '우혜림', '1476973', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '배수지', '1476973', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '권유리', '1476973', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '윤두준', '1476973', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '이성열', '1476973', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '장현승', '1476973', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '이기광', '1476973', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '이채린', '1476973', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '공민지', '1476973', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '남우현', '1476973', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '유창현', '1476973', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '이창선', '1476973', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '김기범', '1476973', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '김효현', '1476973', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '정수영', '1476973', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '서주현', '1476973', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '전지윤', '1476973', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '김재경', '1476973', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '오승아', '1476973', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '이혁재', '1476973', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '김려욱', '1476973', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '박정수', '1476973', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '이동해', '1476973', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '이태민', '1476973', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '임슬옹', '1476973', '3');
INSERT INTO tblLogin VALUES (login_seq.nextVal, '우혜림2', '1476973', '3');
--------------------------------------------------------------------------------------------------------------------------------
-- 1. 관리자 정보 (3개)
--------------------------------------------------------------------------------------------------------------------------------
SELECT * FROM TBLADMINISTRATOR;
DELETE FROM TBLADMINISTRATOR;
INSERT INTO TBLADMINISTRATOR VALUES (1, '이유진', '970456-1234567', '010-0564-5752', 23, '서울시 강남구 역삼동', 'dbwls@naver.com'); -- 1
INSERT INTO TBLADMINISTRATOR VALUES (2, '홍요섭', '950425-8912345', '010-1234-5678', 25, '서울시 강남구 압구정동 ', 'dytjq@naver.com'); -- 2
INSERT INTO TBLADMINISTRATOR VALUES (3, '장대호', '930511-6789456', '010-1234-5678', 27, '서울시 강북구 미아동', 'eogh@naver.com'); -- 3

--------------------------------------------------------------------------------------------------------------------------------
-- 2. 선생님 정보 (state - 1. 강의예정 2. 강의중 3. 강의종료) (10개)
--------------------------------------------------------------------------------------------------------------------------------
SELECT * FROM TBLTEACHER;
DELETE FROM TBLTEACHER;
INSERT INTO TBLTEACHER VALUES (4, '박세인', '850313-1054687', '010-5485-2468', 35, '서울시 강서구 화곡동','dntls@gmail.com', 2); -- 1
INSERT INTO TBLTEACHER VALUES (5, '이응수', '790625-1584652', '010-2546-4532', 41, '인천시 중구 중앙동','dmdtn@gmail.com', 2); -- 2
INSERT INTO TBLTEACHER VALUES (6, '이창익', '840720-1354682', '010-9845-2157', 36, '경기도 성남시 수정구','ckddlr@gmail.com', 2); -- 3
INSERT INTO TBLTEACHER VALUES (7, '곽우신', '840914-1854263', '010-3654-4861', 36, '서울시 강북구 우이동','tpdls@naver.com', 2); -- 4
INSERT INTO TBLTEACHER VALUES (8, '이규미', '831021-2068512', '010-7498-5138', 37, '서울시 강남구 삼성동','rbal@naver.com', 2); -- 5
INSERT INTO TBLTEACHER VALUES (9, '김명선', '810929-1150129', '010-6482-4312', 45, '서울시 강동구 명일동','audtjs@naver.com', 2); -- 6
INSERT INTO TBLTEACHER VALUES (10, '김현룡', '840513-1140752', '010-1597-3578', 36, '경기도 하남시 창우동','gusfyd@gmail.com', 1); -- 7
INSERT INTO TBLTEACHER VALUES (11, '김호진', '870214-1056434', '010-9512-7531', 33, '경기도 광주시 경안동','ghwls@gmail.com', 1); -- 8
INSERT INTO TBLTEACHER VALUES (12, '김대기', '780524-1712350', '010-4567-7894', 42, '경기도 하남시 천현동','eorl@naver.com', 3); -- 9
INSERT INTO TBLTEACHER VALUES (13, '임정훈', '821211-1656480', '010-1679-9753', 38, '경기도 광주시 송정동','wjdgns@naver.com', 3); -- 10

--------------------------------------------------------------------------------------------------------------------------------
-- 3. 학생 정보 (제 1 강의실 30명)(Login seq : 14 부터)(employmentState : 1. 취업, 2. 수강중(미취업), 3. 수료 후 미취업 )
--------------------------------------------------------------------------------------------------------------------------------
SELECT * FROM TBLSTUDENT;
DELETE FROM TBLStudent;

INSERT INTO TBLSTUDENT VALUES (14, '김민성', '931106-2725523', '010-3705-1584', 21, '서울시 종로구 청운동', 'alstjd@naver.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (15, '김서준', '980412-2013176', '010-5451-2734', 21, '서울시 중구 무교동', 'tjwns@naver.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (16, '강주혁', '951224-2670101', '010-3155-8882', 21, '서울시 종로구 청운동', 'wngur@naver.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (17, '김성주', '920213-2336324', '010-0578-6582', 21, '경기도 성남시 수정구', 'tjdwn@naver.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (18, '김승언', '980501-1751192', '010-4032-6262', 21, '서울시 종로구 청운동', 'tmddjs@naver.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (19, '김승현', '940619-1905126', '010-7183-4628', 21, '경기도 성남시 수정구', 'tmdgus@naver.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (20, '김지성', '941221-2067703', '010-4221-5713', 21, '서울시 종로구 신교동', 'wltjd@naver.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (21, '문지원', '950725-2334411', '010-8745-7870', 21, '경기도 성남시 수정구', 'wldnjs@naver.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (22, '박민준', '940919-1432932', '010-4261-3170', 21, '서울시 종로구 신교동', 'alswns@naver.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (23, '이상민', '971008-1124300', '010-3377-0463', 21, '경기도 성남시 중원구', 'tkdals@naver.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (24, '진태호', '910408-2853671', '010-2843-3755', 21, '서울시 종로구 신교동', 'xogh@naver.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (25, '황준혁', '960320-2217337', '010-8828-7147', 21, '경기도 성남시 중원구', 'wnsgur@naver.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (26, '곽성훈', '990804-1062650', '010-3782-8042', 21, '서울시 종로구 궁정동', 'tjdgns@naver.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (27, '김찬우', '950120-2121144', '010-4162-0333', 25, '경기도 성남시 중원구', 'cksdn@naver.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (28, '박준민', '930818-2706811', '010-0127-4365', 27, '서울시 종로구 궁정동', 'wnsals@naver.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (29, '박창현', '950510-1653800', '010-5024-7722', 25, '경기도 하남시 천현동', 'ckdgus@naver.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (30, '서정혁', '961102-1378219', '010-7841-5432', 24, '서울시 종로구 궁정동', 'wjdgur@naver.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (31, '우창범', '960609-2745731', '010-4281-1354', 24, '경기도 하남시 천현동', 'ckdqja@naver.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (32, '윤기욱', '950207-2673684', '010-4876-7538', 24, '서울시 종로구 효자동', 'rldnr@naver.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (33, '이건혁', '940117-2360953', '010-1258-7035', 26, '경기도 하남시 천현동', 'rjsgur@naver.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (34, '김효진', '980508-1504092', '010-8431-8264', 22, '서울시 종로구 효자동', 'gywls@naver.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (35, '이주아', '961005-1062054', '010-6032-3442', 24, '경기도 하남시 하산곡동', 'wndk@naver.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (36, '조혜영', '960901-1979080', '010-4688-8532', 24, '경기도 하남시 하산곡동', 'gPdud@naver.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (37, '최은서', '980620-2942469', '010-4483-8434', 22, '서울시 종로구 효자동', 'dmstj@naver.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (38, '김이영', '910706-2479199', '010-7325-8452', 29, '경기도 하남시 창우동', 'dldud@naver.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (39, '박지유', '901019-1440403', '010-2387-1146', 30, '경기도 하남시 하산곡동', 'wldb@naver.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (40, '배윤경', '940417-1297559', '010-6331-0453', 26, '경기도 하남시 창우동', 'dbsrud@naver.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (41, '이하은', '960611-1512070', '010-1053-2351', 24, '서울시 중구 무교동', 'gkdms@naver.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (42, '정지원', '950213-1223869', '010-5830-2820', 25, '경기도 하남시 창우동', 'wldnjs@naver.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (43, '진혜린', '980708-1382193', '010-1565-5512', 22, '서울시 중구 무교동', 'gpfls@naver.com', 1, 2);

--------------------------------------------------------------------------------------------------------------------------------
-- 3. 학생 정보 (제 2 강의실 30명)
--------------------------------------------------------------------------------------------------------------------------------
INSERT INTO TBLSTUDENT VALUES (44, '황의조', '911109-1093163', '010-8255-0232', 29, '서울시 강남구 논현동 ', 'dmlwh@gmail.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (45, '김신욱', '960628-1352892', '010-7848-7107', 24, '서울시 강남구 서초동', 'tlsdnr@naver.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (46, '권창훈', '910528-1997997', '010-6711-6437', 29, '서울시 강남구 역삼동', 'ckdgns@gmail.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (47, '나상호', '970205-1022765', '010-0384-7864', 23, '서울시 강남구 대치동', 'tkdgh@gmail.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (48, '남태희', '941102-2246861', '010-8338-6003', 26, '서울시 강남구 신사동', 'xogml@naver.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (49, '손흥민', '910704-2124380', '010-5113-3318', 29, '서울시 강남구 압구정동', 'gmdals@gmail.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (50, '이강인', '981216-2392094', '010-4786-4844', 21, '서울시 강남구 개포동', 'rkddls@gmail.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (51, '이재성', '940115-1815589', '010-8645-2847', 26, '서울시 강남구 청담동', 'wotjd@gmail.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (52, '정우영', '910215-1266709', '010-1884-6106', 29, '인천 계양구 방축동', 'dndud@naver.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (53, '주세종', '920111-1999128', '010-6645-2036', 28, '인천 계양구 박촌동', 'tpwhd@gmail.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (54, '황인범', '900105-1313625', '010-2088-0008', 30, '인천 계양구 동양동', 'dlsqja@gmail.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (55, '황희찬', '940720-1399989', '010-7800-4306', 26, '인천 계양구 귤현동', 'gmlcks@gmail.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (56, '권경원', '981006-1516101', '010-5323-3623', 22, '인천 계양구 상야동', 'ruddnjs@naver.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (57, '김문환', '970816-1452817', '010-6106-4817', 23, '인천 계양구 하야동', 'ansghks@gmail.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (58, '김민재', '900416-1418906', '010-2732-0461', 30, '인천 계양구 평동', 'alswo@gmail.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (59, '김영권', '951114-1103430', '010-8067-0012', 25, '인천 계양구 장기동', 'dudrnjs@gmail.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (60, '손화연', '920822-1168641', '010-5788-7035', 29, '인천 계양구 작전동', 'ghkdus@gmail.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (61, '지소연', '950603-2420339', '010-6428-0348', 25, '인천 계양구 계산동', 'thdus@gmail.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (62, '강채림', '971227-2996144', '010-6166-0761', 23, '인천 계양구 이화동', 'cofla@gmail.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (63, '김소은', '941023-2794731', '010-5143-0336', 26, '경기도 김포시 운양동', 'thdms@naver.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (64, '문미라', '990415-2565457', '010-0605-8202', 21, '경기도 김포시 걸포동', 'alfk@gmail.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (65, '박예은', '960722-2019711', '010-3744-2704', 24, '경기도 김포시 장기동', 'dpdms@gmail.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (66, '이세은', '940312-2159645', '010-4607-3327', 26, '경기도 김포시 감정동', 'tpdms@gmail.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (67, '이소담', '940216-2202671', '010-1726-4843', 26, '경기도 김포시 사우동', 'theka@naver.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (68, '이영주', '980823-2678216', '010-1572-3883', 22, '경기도 김포시 풍무동', 'dudwn@gmail.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (69, '장슬기', '991023-2465324', '010-1321-2186', 21, '경기도 김포시 마산동', 'tmfrl@gmail.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (70, '장창', '950904-2898298', '010-0072-2425', 25, '경기도 김포시 북변동', 'wkdckd@naver.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (71, '조소현', '940404-2208967', '010-4131-0374', 26, '서울시 서초구 방배동', 'thgus@gmail.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (72, '김진희', '980125-2779508', '010-2135-8715', 22, '서울시 서초구 양재동', 'wlsgml@naver.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (73, '김혜리', '970217-2954653', '010-6668-1048', 23, '서울시 서초구 반포동', 'gpfl@gmail.com', 1, 2);

--------------------------------------------------------------------------------------------------------------------------------
-- 3. 학생 정보 (제 3 강의실 30명)
--------------------------------------------------------------------------------------------------------------------------------
INSERT INTO TBLSTUDENT VALUES (74, '김혜영', '971012-2754176', '010-7453-1205', 23, '서울시 서초구 우면동', 'gpdud@naver.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (75, '어희진', '971220-2395679', '010-2271-4736', 23, '서울시 서초구 원지동', 'gmlwls@naver.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (76, '이효경', '990706-2223509', '010-4781-7261', 20, '서울시 서초구 잠원동', 'gyrud@naver.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (77, '임선주', '921102-2342875', '010-5424-6328', 28, '서울시 서초구 서초동', 'tjswn@gmail.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (78, '하은혜', '940404-2030083', '010-1636-0818', 26, '서울시 서초구 내곡동', 'dmsgp@gmail.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (79, '홍혜지', '980913-2002717', '010-3032-0314', 22, '서울시 서초구 염곡동', 'gpwl@gmail.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (80, '강가애', '970126-2454761', '010-7448-7378', 23, '서울시 서초구 신원동', 'rkdo@naver.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (81, '김민정', '960827-2963633', '010-7340-5781', 24, '서울시 서초구 반포본동', 'alswjd@gmail.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (82, '민유경', '990706-2250426', '010-4800-7017', 20, '서울시 서초구 방배본동', 'dbrud@naver.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (83, '김대원', '930808-1137446', '010-0526-8132', 27, '서울시 강서구 염창동', 'eodnjs@naver.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (84, '엄원상', '970206-1505758', '010-2662-7316', 23, '서울시 강서구 등촌동', 'dnjstkd@naver.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (85, '오세훈', '910116-1261828', '010-7475-4124', 29, '서울시 강서구 화곡동', 'tpgns@gmail.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (86, '이동준', '960303-1900116', '010-0261-3066', 21, '서울시 강서구 가양동', 'ehdwns@gmail.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (87, '정우영', '901007-1046393', '010-2682-1185', 22, '서울시 강서구 마곡동', 'dndud@gmail.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (88, '조규셩', '930405-1465197', '010-0267-1621', 23, '서울시 강서구 내발산동', 'rbtud@naver.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (89, '김동현', '940107-1629468', '010-6213-1537', 24, '서울시 강서구 외발산동', 'ehdgus@gmail.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (90, '김진규', '970811-1231827', '010-2655-3181', 25, '서울시 강서구 공항동', 'wlsrb@naver.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (91, '맹성웅', '920601-1201792', '010-4252-3423', 26, '서울시 강서구 방화동', 'tjddnd@gmail.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (92, '백승호', '910520-1085760', '010-0530-7256', 27, '서울시 강서구 개화동', 'tmdgh@naver.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (93, '전세진', '980225-1415853', '010-2083-4317', 28, '서울시 강서구 과해동', 'tpwls@gmail.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (94, '정승원', '930219-1455545', '010-3472-6067', 29, '서울시 강서구 오곡동', 'tmddnjs@naver.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (95, '조영욱', '970522-1496903', '010-7478-8136', 21, '서울시 강서구 오쇠동', 'duddnr@gmail.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (96, '한찬희', '990601-1925381', '010-4257-7726', 22, '서울시 강서구 우장산동', 'cksgml@naver.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (97, '강윤성', '941122-1322001', '010-2283-8111', 23, '서울시 동작구 노량진동', 'dbstjd@gmail.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (98, '김재우', '970302-1847697', '010-0688-6850', 24, '서울시 동작구 상도동', 'wodn@gmail.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (99, '김진야', '980412-1867350', '010-8523-4561', 25, '서울시 동작구 흑석동', 'wlsdi@gmail.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (100, '김태현', '981020-1371448', '010-5181-7304', 26, '서울시 동작구 동작동', 'xogus@naver.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (101, '원두재', '900621-1004748', '010-1084-1275', 27, '서울시 동작구 사당동', 'enwo@naver.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (102, '윤종규', '950216-1851797', '010-2582-2404', 28, '서울시 동작구 대방동', 'whdrb@gmail.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (103, '이상민', '920701-1345500', '010-5472-5816', 29, '서울시 동작구 신대방동', 'tkdals@naver.com', 1, 2);

--------------------------------------------------------------------------------------------------------------------------------
-- 3. 학생 정보 (제 4 강의실 26명)
--------------------------------------------------------------------------------------------------------------------------------
INSERT INTO TBLSTUDENT VALUES (104, '이유현', '990805-1973036', '010-4766-1835', 21, '서울시 강서구 과해동', 'dbgus@gmail.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (105, '정태욱', '910213-1974691', '010-6365-8185', 22, '서울시 강서구 과해동', 'xodnr@naver.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (106, '송범근', '980815-1434690', '010-6508-6470', 23, '서울시 강서구 과해동', 'qjarms@gmnaverail.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (107, '안주수', '931015-1804038', '010-1352-5782', 24, '서울시 강서구 과해동', 'wntn@gmail.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (108, '허자웅', '940509-1885781', '010-7282-4032', 25, '서울시 동작구 신대방동', 'wkdmd@gmail.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (109, '강지우', '940211-1059038', '010-1357-7454', 26, '서울시 동작구 신대방동', 'wldn@naver.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (110, '이은영', '971204-1698497', '010-5148-7288', 27, '서울시 동작구 신대방동', 'dmsdud@naver.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (111, '이정민', '980406-1937801', '010-8557-3108', 28, '서울시 동작구 신대방동', 'wjdals@gmail.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (112, '조미진', '920705-1356487', '010-4366-1506', 29, '서울시 동작구 흑석동', 'alwls@gmail.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (113, '천가람', '900905-1129445', '010-1763-8825', 21, '서울시 동작구 흑석동', 'rkfka@naver.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (114, '최다경', '950615-1098300', '010-7153-2835', 22, '서울시 동작구 흑석동', 'ekrud@gmail.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (115, '추효주', '911227-1305216', '010-3038-3570', 23, '서울시 동작구 흑석동', 'gywn@naver.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (116, '현슬기', '900905-1129446', '010-3533-6720', 24, '서울시 강서구 과해동', 'tmfrl@gmail.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (117, '김수진', '950615-1098301', '010-0770-5508', 25, '서울시 강서구 과해동', 'tnwls@gmail.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (118, '김혜정', '911227-1305217', '010-3002-4555', 26, '서울시 강서구 과해동', 'gpwjd@naver.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (119, '박혜정', '920307-1220937', '010-0121-2125', 27, '서울시 강서구 과해동', 'gpwjd@gmail.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (120, '정민영', '950807-1708482', '010-8502-5878', 28, '서울시 동작구 사당동', 'alsdud@naver.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (121, '구채현', '991218-1036140', '010-7424-0386', 29, '서울시 동작구 사당동', 'cogus@gmail.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (122, '김은솔', '971215-2034212', '010-8343-4556', 21, '서울시 동작구 사당동', 'dmsthf@gmail.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (123, '노진영', '951019-2510738', '010-0734-4078', 22, '서울시 동작구 사당동', 'wlsdud@naver.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (124, '신보미', '950413-2320122', '010-4218-5624', 23, '서울시 동작구 동작동', 'qhal@gmail.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (125, '윤현지', '990709-2889428', '010-1138-3045', 24, '서울시 동작구 동작동', 'guswl@gmail.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (126, '이덕주', '911003-2880483', '010-2517-5802', 25, '서울시 동작구 동작동', 'ejrwn@naver.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (127, '정유진', '960627-2159980', '010-0227-4236', 26, '서울시 동작구 동작동', 'dbwls@gmail.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (128, '조민아', '990209-2790138', '010-6307-2811', 27, '서울시 서초구 우면동', 'alsdk@naver.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (129, '김민영', '991002-2254900', '010-0023-1530', 28, '서울시 서초구 우면동', 'alsdud@gmail.com', 1, 2);

--------------------------------------------------------------------------------------------------------------------------------
-- 3. 학생 정보 (제 5 강의실 26명)
--------------------------------------------------------------------------------------------------------------------------------
INSERT INTO TBLSTUDENT VALUES (130, '김수정', '990320-2845805', '010-2628-7025', 21, '인천 계양구 계산동', 'tnwjd@gmail.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (131, '이현주', '990217-2302860', '010-1782-4487', 22, '인천 계양구 계산동', 'guswn@naver.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (132, '오현규', '990710-2306151', '010-6528-0532', 23, '인천 계양구 이화동', 'gusrb@gmail.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (133, '정한민', '971110-2995295', '010-3065-5614', 24, '인천 계양구 이화동', 'gksals@gmail.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (134, '허율', '960521-2908008', '010-8147-0386', 25, '경기도 김포시 운양동', 'dbf@naver.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (135, '고영준', '950620-2067221', '010-1363-0865', 26, '경기도 김포시 운양동', 'dudwns@gmail.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (136, '권민재', '940518-2783975', '010-1354-2386', 27, '경기도 김포시 걸포동', 'alswo@gmail.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (137, '권혁규', '930515-2244028', '010-2057-2684', 28, '경기도 김포시 걸포동', 'gurrb@naver.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (138, '박건우', '990316-2422256', '010-6422-8173', 29, '경기도 김포시 장기동', 'rjsdn@gmail.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (139, '안재준', '970914-2701584', '010-6575-8023', 21, '경기도 김포시 장기동', 'wowns@gmail.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (140, '이강희', '921209-2673735', '010-2132-0515', 21, '경기도 김포시 감정동', 'rkdgml@naver.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (141, '황재환', '900618-2314836', '010-1748-6033', 22, '경기도 김포시 감정동', 'woghks@gmail.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (142, '권성윤', '970603-2988686', '010-4164-6350', 22, '경기도 김포시 사우동', 'tjddbs@naver.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (143, '김상준', '980713-2820728', '010-5176-4362', 23, '경기도 김포시 사우동', 'tkdwns@gmail.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (144, '김주환', '920206-2486916', '010-7250-2631', 23, '경기도 김포시 풍무동', 'wnghks@naver.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (145, '남윤재', '980811-2493156', '010-2601-6756', 24, '경기도 김포시 풍무동', 'dbswo@gmail.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (146, '박진성', '980627-2365139', '010-1407-2668', 24, '경기도 김포시 마산동', 'wlstjd@naver.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (147, '오상준', '970505-2576311', '010-5358-7307', 25, '경기도 김포시 마산동', 'tkdwns@gmail.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (148, '이진용', '950125-2755932', '010-1114-4216', 25, '경기도 김포시 북변동', 'wlsdyd@naver.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (149, '조현택', '910826-2090143', '010-7528-2336', 26, '경기도 김포시 북변동', 'gusxor@gmail.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (150, '최세윤', '921008-1918890', '010-5150-2800', 26, '서울시 서초구 방배동', 'tpdbs@gmail.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (151, '최원창', '920127-1067358', '010-4548-0427', 27, '서울시 서초구 방배동', 'dnjsckd@naver.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (152, '김정훈', '960528-1670639', '010-5204-6017', 27, '서울시 서초구 양재동', 'wjdgns@gmail.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (153, '백종범', '950314-1258059', '010-3386-4651', 28, '서울시 서초구 양재동', 'whdqjq@naver.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (154, '조성빈', '970708-1697251', '010-8726-7041', 28, '서울시 서초구 반포동', 'tjdqls@gmail.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (155, '곽로영', '970904-1394543', '010-1007-7162', 29, '서울시 서초구 반포동', 'fhdud@naver.com', 1, 2);
--------------------------------------------------------------------------------------------------------------------------------
-- 3. 학생 정보 (제 6 강의실 26명)
--------------------------------------------------------------------------------------------------------------------------------
INSERT INTO TBLSTUDENT VALUES (156, '김가연', '961118-2056916', '010-2320-3704', 21, '서울시 강남구 논현동', 'rkdus@naver.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (157, '박가현', '900119-2088011', '010-8668-8256', 22, '서울시 강남구 논현동', 'rkgus@naver.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (158, '박수정', '910324-2816121', '010-0282-1505', 23, '서울시 강남구 서초동', 'tnwjd@gmail.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (159, '박유정', '980706-2261034', '010-7736-0381', 24, '서울시 강남구 서초동', 'dbwjd@naver.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (160, '장진영', '950309-2882676', '010-5640-4571', 25, '서울시 강남구 역삼동', 'wlsdud@gmail.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (161, '전유경', '950304-2822679', '010-7760-3427', 26, '서울시 강남구 역삼동', 'dbrud@gmail.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (162, '한보영', '991108-2894781', '010-3274-1315', 27, '서울시 강남구 대치동', 'qhdud@naver.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (163, '홍채빈', '901009-2175991', '010-3624-3335', 28, '서울시 강남구 대치동', 'coqls@gmail.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (164, '노하늘', '960808-2572561', '010-6422-7424', 29, '서울시 강남구 신사동', 'gksmf@gmail.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (165, '신혜빈', '910310-2312438', '010-4633-8822', 21, '서울시 강남구 신사동', 'gpqls@naver.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (166, '윤민지', '960302-2187741', '010-5427-5481', 22, '서울시 강남구 압구정동', 'alswl@gmail.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (167, '황아현', '960507-2054951', '010-5766-2263', 23, '서울시 강남구 압구정동', 'dkgus@naver.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (168, '김민지', '950512-2855353', '010-3127-1007', 24, '서울시 강남구 개포동', 'alswl@gmail.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (169, '김예은', '900201-2432160', '010-0204-0664', 25, '서울시 강남구 개포동', 'dpdms@naver.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (170, '변혜진', '970815-2857505', '010-4088-1502', 26, '서울시 강남구 청담동', 'gpwls@gmail.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (171, '이현정', '970309-2625888', '010-5068-7512', 27, '서울시 강남구 청담동', 'guswjd@naver.com', 1, 2);
INSERT INTO TBLSTUDENT VALUES (172, '정설아', '940706-2295819', '010-0886-5405', 28, '인천 계양구 방축동', 'tjfdk@gmail.com', 1, 1);
INSERT INTO TBLSTUDENT VALUES (173, '최민아', '980104-2029975', '010-4362-4417', 29, '인천 계양구 방축동', 'alsdk@naver.com', 1, 1);
INSERT INTO TBLSTUDENT VALUES (174, '박어진', '950406-2930550', '010-1222-2726', 21, '인천 계양구 박촌동', 'djwls@naver.com', 1, 1);
INSERT INTO TBLSTUDENT VALUES (175, '우서빈', '930615-2350092', '010-1011-3104', 22, '인천 계양구 박촌동', 'tjqls@gmail.com', 1, 1);
INSERT INTO TBLSTUDENT VALUES (176, '홍유진', '980911-1474459', '010-1630-6870', 23, '인천 계양구 동양동', 'dbwls@gmail.com', 1, 1);
INSERT INTO TBLSTUDENT VALUES (177, '김용학', '960311-1189424', '010-8336-7670', 24, '인천 계양구 동양동', 'dydgkr@naver.com', 1, 1);
INSERT INTO TBLSTUDENT VALUES (178, '문준호', '920917-1650226', '010-7764-2781', 25, '인천 계양구 귤현동', 'wnsgh@gmail.com', 1, 1);
INSERT INTO TBLSTUDENT VALUES (179, '이종훈', '980927-1267391', '010-6245-2813', 26, '인천 계양구 귤현동', 'whdgns@naver.com', 1, 1);
INSERT INTO TBLSTUDENT VALUES (180, '정상빈', '900717-1605247', '010-2206-0101', 27, '인천 계양구 상야동', 'tkdqls@naver.com', 1, 1);
INSERT INTO TBLSTUDENT VALUES (181, '최민서', '900612-1233460', '010-3238-3573', 28, '인천 계양구 상야동', 'alstj@gmail.com', 1, 1);
--------------------------------------------------------------------------------------------------------------------------------
-- 3. 수료한 학생 정보 ( 50 명)
--------------------------------------------------------------------------------------------------------------------------------
INSERT INTO TBLSTUDENT VALUES (182, '홍윤상', '900804-1127507', '010-1124-3512', 21, '서울시 강서구 방화동', 'dbstkd@gmail.com', 1, 3);
INSERT INTO TBLSTUDENT VALUES (183, '백상훈', '970823-1997338', '010-7224-4270', 22, '서울시 강서구 방화동', 'tkdgns@gmail.com', 1, 3);
INSERT INTO TBLSTUDENT VALUES (184, '엄지성', '920819-1455075', '010-1044-6106', 23, '서울시 강서구 개화동', 'wltjd@gmail.com', 1, 3);
INSERT INTO TBLSTUDENT VALUES (185, '오재혁', '960127-1077451', '010-7510-4061', 24, '서울시 강서구 개화동', 'wogur@gmail.com', 1, 3);
INSERT INTO TBLSTUDENT VALUES (186, '윤석주', '901113-1915651', '010-3030-6686', 25, '서울시 서초구 우면동', 'tjrwn@gmail.com', 1, 3);
INSERT INTO TBLSTUDENT VALUES (187, '김륜성', '920814-1897121', '010-1677-7460', 26, '서울시 서초구 원지동', 'fbstjd@gmail.com', 1, 3);
INSERT INTO TBLSTUDENT VALUES (188, '방우진', '911221-1195919', '010-3263-0260', 27, '서울시 서초구 우면동', 'dnwls@gmail.com', 1, 3);
INSERT INTO TBLSTUDENT VALUES (189, '손호준', '921109-1661066', '010-0467-4077', 28, '서울시 서초구 원지동', 'ghwns@gmail.com', 1, 3);
INSERT INTO TBLSTUDENT VALUES (190, '유승현', '910707-1078206', '010-4113-8634', 29, '서울시 서초구 잠원동', 'tmdgus@gmail.com', 1, 3);
INSERT INTO TBLSTUDENT VALUES (191, '이준석', '971105-1024552', '010-0638-2172', 21, '서울시 서초구 내곡동', 'wnstjr@gmail.com', 1, 3);
INSERT INTO TBLSTUDENT VALUES (192, '이태석', '930407-1008595', '010-7051-2300', 21, '서울시 서초구 잠원동', 'xotjr@gmail.com', 1, 1);
INSERT INTO TBLSTUDENT VALUES (193, '이한범', '990724-1701319', '010-3301-0121', 22, '서울시 서초구 내곡동', 'gksqja@gmail.com', 1, 1);
INSERT INTO TBLSTUDENT VALUES (194, '홍서욱', '950103-1679531', '010-8025-2316', 22, '서울시 서초구 서초동', 'tjdnr@gmail.com', 1, 1);
INSERT INTO TBLSTUDENT VALUES (195, '김준홍', '920327-1757631', '010-8223-8768', 23, '서울시 서초구 염곡동', 'wnsghd@gmail.com', 1, 1);
INSERT INTO TBLSTUDENT VALUES (196, '신송훈', '981001-1758215', '010-6383-3541', 23, '서울시 서초구 서초동', 'thdgns@gmail.com', 1, 1);
INSERT INTO TBLSTUDENT VALUES (197, '이승환', '920920-1476971', '010-1184-6148', 24, '서울시 서초구 염곡동', 'tmdghks@gmail.com', 1, 1);
INSERT INTO TBLSTUDENT VALUES (198, '박진영', '920920-1476972', '010-1184-6148', 24, '서울시 서초구 염곡동', 'tmdghks@gmail.com', 1, 1);
INSERT INTO TBLSTUDENT VALUES (199, '권지용', '920920-1476953', '010-1184-6148', 24, '서울시 서초구 염곡동', 'tmdghks@gmail.com', 1, 1);
INSERT INTO TBLSTUDENT VALUES (200, '최승현', '920920-1476974', '010-1184-6148', 24, '서울시 서초구 염곡동', 'tmdghks@gmail.com', 1, 1);
INSERT INTO TBLSTUDENT VALUES (201, '강대성', '920920-1476975', '010-1184-6148', 24, '서울시 서초구 염곡동', 'tmdghks@gmail.com', 1, 1);
INSERT INTO TBLSTUDENT VALUES (202, '동영배', '920920-1476976', '010-1184-6148', 24, '서울시 서초구 염곡동', 'tmdghks@gmail.com', 1, 1);
INSERT INTO TBLSTUDENT VALUES (203, '민선예', '920920-1476977', '010-1184-6148', 24, '서울시 서초구 염곡동', 'tmdghks@gmail.com', 1, 1);
INSERT INTO TBLSTUDENT VALUES (204, '박예은', '920920-1476978', '010-1184-6148', 24, '서울시 서초구 염곡동', 'tmdghks@gmail.com', 1, 1);
INSERT INTO TBLSTUDENT VALUES (205, '김유빈', '920920-1476979', '010-1184-6148', 24, '서울시 서초구 염곡동', 'tmdghks@gmail.com', 1, 1);
INSERT INTO TBLSTUDENT VALUES (206, '우혜림', '920920-1476980', '010-1184-6148', 24, '서울시 서초구 염곡동', 'tmdghks@gmail.com', 1, 1);
INSERT INTO TBLSTUDENT VALUES (207, '배수지', '920920-1476981', '010-1184-6148', 24, '서울시 서초구 염곡동', 'tmdghks@gmail.com', 1, 1);
INSERT INTO TBLSTUDENT VALUES (208, '권유리', '920920-1476982', '010-1184-6148', 24, '서울시 서초구 염곡동', 'tmdghks@gmail.com', 1, 1);
INSERT INTO TBLSTUDENT VALUES (209, '윤두준', '920920-1476983', '010-1184-6148', 24, '서울시 서초구 염곡동', 'tmdghks@gmail.com', 1, 1);
INSERT INTO TBLSTUDENT VALUES (210, '이성열', '920920-1476985', '010-1184-6148', 24, '서울시 서초구 염곡동', 'tmdghks@gmail.com', 1, 1);
INSERT INTO TBLSTUDENT VALUES (211, '장현승', '920920-1476984', '010-1184-6148', 24, '서울시 서초구 염곡동', 'tmdghks@gmail.com', 1, 1);
INSERT INTO TBLSTUDENT VALUES (212, '이기광', '920920-1476986', '010-1184-6148', 24, '서울시 서초구 염곡동', 'tmdghks@gmail.com', 1, 1);
INSERT INTO TBLSTUDENT VALUES (213, '이채린', '920920-1476987', '010-1184-6148', 24, '서울시 서초구 염곡동', 'tmdghks@gmail.com', 1, 1);
INSERT INTO TBLSTUDENT VALUES (214, '공민지', '920920-1476988', '010-1184-6148', 24, '서울시 서초구 염곡동', 'tmdghks@gmail.com', 1, 1);
INSERT INTO TBLSTUDENT VALUES (215, '남우현', '920920-1476989', '010-1184-6148', 24, '서울시 서초구 염곡동', 'tmdghks@gmail.com', 1, 1);
INSERT INTO TBLSTUDENT VALUES (216, '유창현', '920920-1471235', '010-1184-6148', 24, '서울시 서초구 염곡동', 'tmdghks@gmail.com', 1, 1);
INSERT INTO TBLSTUDENT VALUES (217, '이창선', '920920-1476991', '010-1184-6148', 24, '서울시 서초구 염곡동', 'tmdghks@gmail.com', 1, 1);
INSERT INTO TBLSTUDENT VALUES (218, '김기범', '920920-1476992', '010-1184-6148', 24, '서울시 서초구 염곡동', 'tmdghks@gmail.com', 1, 1);
INSERT INTO TBLSTUDENT VALUES (219, '김효현', '920920-1476993', '010-1184-6148', 24, '서울시 서초구 염곡동', 'tmdghks@gmail.com', 1, 1);
INSERT INTO TBLSTUDENT VALUES (220, '정수영', '920920-1476994', '010-1184-6148', 24, '서울시 서초구 염곡동', 'tmdghks@gmail.com', 1, 1);
INSERT INTO TBLSTUDENT VALUES (221, '서주현', '920920-1476995', '010-1184-6148', 24, '서울시 서초구 염곡동', 'tmdghks@gmail.com', 1, 1);
INSERT INTO TBLSTUDENT VALUES (222, '전지윤', '920920-1476996', '010-1184-6148', 24, '서울시 서초구 염곡동', 'tmdghks@gmail.com', 1, 1);
INSERT INTO TBLSTUDENT VALUES (223, '김재경', '920920-1476997', '010-1184-6148', 24, '서울시 서초구 염곡동', 'tmdghks@gmail.com', 1, 1);
INSERT INTO TBLSTUDENT VALUES (224, '오승아', '920920-1476998', '010-1184-6148', 24, '서울시 서초구 염곡동', 'tmdghks@gmail.com', 1, 1);
INSERT INTO TBLSTUDENT VALUES (225, '이혁재', '920920-1476999', '010-1184-6148', 24, '서울시 서초구 염곡동', 'tmdghks@gmail.com', 1, 1);
INSERT INTO TBLSTUDENT VALUES (226, '김려욱', '920920-1476901', '010-1184-6148', 24, '서울시 서초구 염곡동', 'tmdghks@gmail.com', 1, 1);
INSERT INTO TBLSTUDENT VALUES (227, '박정수', '920920-1476902', '010-1184-6148', 24, '서울시 서초구 염곡동', 'tmdghks@gmail.com', 1, 1);
INSERT INTO TBLSTUDENT VALUES (228, '이동해', '920920-1476903', '010-1184-6148', 24, '서울시 서초구 염곡동', 'tmdghks@gmail.com', 1, 1);
INSERT INTO TBLSTUDENT VALUES (229, '이태민', '920920-1476904', '010-1184-6148', 24, '서울시 서초구 염곡동', 'tmdghks@gmail.com', 1, 1);
INSERT INTO TBLSTUDENT VALUES (230, '임슬옹', '920920-1476905', '010-1184-6148', 24, '서울시 서초구 염곡동', 'tmdghks@gmail.com', 1, 1);
INSERT INTO TBLSTUDENT VALUES (231, '우혜림', '920920-1476906', '010-1184-6148', 24, '서울시 서초구 염곡동', 'tmdghks@gmail.com', 1, 1);























































