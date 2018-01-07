package com.arover.diffdemo;

import java.util.Random;

/**
 * Created  on 12/28/16.
 */

public class DemoDataFactory {


    public static String genRandomAvatar() {
        return DUMMY_AVATARS[random.nextInt(DUMMY_AVATARS.length)];
    }

    public static String genRandomName() {
        return DUMMY_NAMES[random.nextInt(DUMMY_NAMES.length)];
    }

    public static String genRandomMidSizeImageUrl(){
        return DUMMY_POSTERS[random.nextInt(DUMMY_POSTERS.length)];
    }

    public static String genRandomTitle() {
        return DUMMY_TITLES[random.nextInt(DUMMY_TITLES.length)];
    }

    public static String genRandomUrl() {
        return "https://book.douban.com/subject/"+(26948872-random.nextInt(1000))+"/";
    }

    public static String genRandomDotName() {
        return DUMMY_DOT_NAMES[random.nextInt(DUMMY_DOT_NAMES.length)];
    }

    private static Random random = new Random();

    private static final String[] DUMMY_DOT_NAMES= new String[]{
            "颜值",
            "毒舌",
            "消瘦",
            "懒得鄙视",
            "老式马夹",
            "有爱心",
            "天蝎座",
            "红色iPhone",
            "女司机",
            "♑摩羯座️",
            "会写游记",
            "觉皇",
            "最美五姨",
            "爱喝奶茶"
    };

    private static final String[] DUMMY_POSTERS = new String[]{
            "https://img3.doubanio.com/view/photo/photo/public/p2398253181.jpg",
            "https://img1.doubanio.com/view/photo/photo/public/p2398253198.jpg",
            "https://img3.doubanio.com/view/photo/photo/public/p2398253190.jpg",
            "https://img3.doubanio.com/view/photo/photo/public/p2398253175.jpg",
            "https://img3.doubanio.com/view/photo/photo/public/p2175837425.jpg",
            "https://img3.doubanio.com/view/photo/photo/public/p2402069220.jpg",
            "https://img5.doubanio.com/view/photo/photo/public/p1188029166.jpg"
    };

    private static final String[] DUMMY_AVATARS = new String[]{
            "https://img3.doubanio.com/icon/ul150308580-1.jpg",
            "https://img5.doubanio.com/icon/ul72948612-86.jpg",
            "https://img1.doubanio.com/icon/ul53548460-37.jpg",
            "https://img3.doubanio.com/icon/ul46487686-20.jpg",
            "https://img1.doubanio.com/icon/ul51538885-48.jpg",
            "https://img3.doubanio.com/icon/ul79647559-5.jpg",
            "https://img1.doubanio.com/icon/ul54086143-48.jpg",
            "https://img3.doubanio.com/icon/ul55660976-15.jpg",
            "https://img3.doubanio.com/icon/ul133803840-20.jpg",
            "https://img3.doubanio.com/icon/ul132631230-10.jpg",
            "https://img1.doubanio.com/icon/ul48192914-8.jpg",
            "https://img3.doubanio.com/icon/ul93132512-14.jpg",
            "https://img1.doubanio.com/icon/ul44550705-7.jpg",
            "https://img3.doubanio.com/icon/ul136217240-2.jpg",
            "https://img3.doubanio.com/icon/ul70530788-12.jpg",
            "https://img3.doubanio.com/icon/ul27630529-2.jpg",
            "https://img3.doubanio.com/icon/ul147397448-3.jpg",
            "https://img3.doubanio.com/icon/ul146569446-5.jpg",
            "https://img1.doubanio.com/icon/ul136189348-48.jpg",
            "https://img3.doubanio.com/icon/ul75387038-2.jpg",
            "https://img3.doubanio.com/icon/ul149274706-23.jpg",
            "https://img5.doubanio.com/icon/ul143737479-6.jpg",
            "https://img3.doubanio.com/icon/ul102544434-4.jpg",
            "https://img1.doubanio.com/icon/ul4599322-29.jpg",
            "https://img1.doubanio.com/icon/ul149632937-8.jpg",
            "https://img1.doubanio.com/icon/ul136629033-7.jpg",
            "https://img3.doubanio.com/icon/ul121786509-53.jpg",
            "https://img3.doubanio.com/icon/ul149450460-1.jpg",
            "https://img5.doubanio.com/icon/ul143737479-6.jpg"
    };


    private static final String[] DUMMY_NAMES = new String[]{
            "叶华乐",
            "沙代亦",
            "丁淳静",
            "陈绮艳",
            "郁白萱",
            "经欣远",
            "都芷文",
            "应怀萍",
            "翁静云",
            "祖春枫",
            "简雪怡",
            "许月杉",
            "仉督文倩",
            "缪悦爱",
            "虞思卉",
            "有琴尔岚",
            "贝尔芙",
            "史涵雁",
            "唐问丝",
            "蓬清怡",
            "乌若烟",
            "蔡清莹",
            "秦飞风",
            "梁丘香梅",
            "束柔蔓",
            "仇痴香",
            "万芳蕤",
            "勾芳荃",
            "柯一瑾",
            "汪天籁",
            "闾丘优悠",
            "闻雅山",
            "邵怡畅",
            "俞孤松",
            "后佳楠",
            "钮书艺",
            "邢夏兰",
            "闻人华",
            "芝关海",
            "菡童雨萌",
            "戎桂华",
            "吴晓亦"
    };

    private static final String[] DUMMY_TITLES= new String[]{
            "Lorem ipsum dolor sit amet",
            "Consectetuer adipiscing elit",
            " Aenean commodo ligula eget dolor.",
            "Aenean massa. Cum sociis natoque penatibus et magnis ",
            "dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec,",
            "pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu",
            "In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo",
            "Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibus",
            "Vivamus elementum semper nisi. Aenean vulputate eleifend tellus",
            "A wonderful serenity has taken possession of my entire soul",
            ", like these sweet mornings of spring which I enjoy with my whole heart. ",
            "I am alone, and feel the charm of existence in this spot",
            "which was created for the bliss of souls like mine. I am so happy",
            "my dear friend, so absorbed in the exquisite sense of mere tranquil existence",
            "that I neglect my talents. I should be incapable of drawing a single stroke at the present moment",
            "and yet I feel that I never was a greater artist than now. When, while the lovely valley teems with"


    };
    
}
