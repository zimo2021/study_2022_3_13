package javatest;

import java.util.*;//代表导入util中的所有方法 用“*”代表所有

//案例二月天 即键盘输入某年 输出这一年的二月有多少天
//public class Test {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int yeah = sc.nextInt();
//        Calendar c = Calendar.getInstance();
//        c.set(yeah, 2, 1);//这里设置的是这一年的3月1日 由于month是从0开始的 所以设置成2 3月一日的前一天就是二月的最后一天
//        c.add(Calendar.DATE, -1);
//        int date = c.get(Calendar.DATE);
//        System.out.println(yeah + "年共有" + date + "天");//可以了
//    }
//}


//java异常处理之try..catch
//public  class Test {
//    public static void main(String[] args) {
//        System.out.println("开始");
//        method();
//        System.out.println("结束");
//    }
//    public static void method(){
//        int[] a={1,2,3};
//        System.out.println(a[3]);
//    }
//}
    /*
    开始
Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3
	at javatest.Test.method(Test.java:29)
	at javatest.Test.main(Test.java:24)
    可以看到程序并没有执行到结束  可开发过程中不能因为一个异常影响了整段代码的执行 所以我们要自己定义异常
     */
//public  class Test {
//    public static void main(String[] args) {
//            System.out.println("开始");
//            method();
//            System.out.println("结束");
//        }
//    public static void method() {
//        try {
//            int[] a = {1, 2, 3};
//            System.out.println(a[3]);//如果这里发生异常 则会产生一个异常对象 传递给e
//        }catch (ArrayIndexOutOfBoundsException e){
//            //System.out.println("程序异常"); 但这样就不能给出提示了 所以我们使用函数
//            e.printStackTrace();
//        }
//        /*
//        开始
//        程序异常
//        结束 //可以输出结束了
//
//        换成函数后
//        开始
//        结束//也可以输出结束
//        java.lang.ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3
//            at javatest.Test.method(Test.java:48)
//            at javatest.Test.main(Test.java:42)
//         */
//    }
//}

//ArrayIndexOutOfBoundsException 是Throwable 的子类
//Throwable的成员方法
//public class Test {
//    public static void main(String[] args) {
//        System.out.println("开始");
//        method();
//        System.out.println("结束");
//    }
//    public static void method() {
//        try {
//            int[] a = {1, 2, 3};
//            System.out.println(a[3]);
//        }catch (ArrayIndexOutOfBoundsException e){
//            //方法一:getMessage()
//           // System.out.println(e.getMessage());
//            /*
//            开始
//            Index 3 out of bounds for length 3
//            结束
//
//             */
//            //方法二：toString
//           //System.out.println(e.toString());
//            /*
//            开始
//            java.lang.ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3
//            结束
//             */
//            //方法三 printStackTrace()
//            e.printStackTrace();
//            /*
//            开始
//            结束
//            java.lang.ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3
//                at javatest.Test.method(Test.java:79)
//                at javatest.Test.main(Test.java:73)
//             */
//              一般使用方法三
//        }
//    }
//}

/*
编译时异常和运行时异常的区别
运行时异常：运行时出现的异常 RuntimeException
编译时异常：编译过程中出现的异常 Exception(报异常但不一定会出错 只是有可能出错)

 */

//public class Test {
//    public static void main(String[] args) {
//        try {
//            String s = "2018-11-11";
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//            Date d = sdf.parse(s);// 报异常：ParseException（编译时异常）
//            System.out.println(d);
//        }catch (ParseException p){
//            p.printStackTrace();//Sun Nov 11 00:00:00 CST 2018
//        }
//    }
//}


//通过throws进行异常处理
/*
编译时异常必须经过处理：有两种处理方案 try...catch或throws 运用throws进行处理将来谁调用谁处理
运行时异常可以不处理，出现问题回来修改代码  但可以做这个操作使异常不影响后面的运行
 */
//public class Test {
//    public static void main(String[] args) throws ParseException{//
//        //编译时异常：
//        String s="2018-11-11";
//        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
//        Date d=sdf.parse(s);
//        System.out.println("开始");
//        method();
//        System.out.println(s);
//        System.out.println("结束");
//    }
//    public static void method() throws ArrayIndexOutOfBoundsException{//这样代码也不输出结束 如果要继续执行 还得try..catch
//        //运行时异常（可以不处理，出现问题回来修改代码）
//        int[] a={1,2,3};
//        System.out.println(a[3]);
//    }
//}

//自定义异常 就像Exception一样
//class scoreException extends Exception{
//    public scoreException(){}
//    public scoreException(String message){
//        super(message);
//    }
//}
//
//class teaCher{
//    public static void checkScore(int score)throws scoreException{
//        if(score<0||score>100){
//            //throw new scoreException();//无提示信息
//            throw new scoreException("你的分数有误");
//        }
//        else{
//            System.out.println("分数正常");
//        }
//    }
//}
//
//public class Test {
//    public static void main(String[] args) throws scoreException{
//        Scanner sc=new Scanner(System.in);
//        int score=sc.nextInt();
//        teaCher.checkScore(score);//可以了
//    }
//}

//Collection集合的概述和基本使用
/*
Cpllection集合是一个接口 （Interface Collection<E>）不可直接创建对象
ArrayList是其对象 我们通过多态来创建对象
 */
//public class Test {
//    public static void main(String[] args) {
//        Collection<String> c=new ArrayList<String>();
//        c.add("hello");
//        c.add("world");
//        System.out.println(c);//[hello, world]  说明ArrayList中重写了toString方法
//    }
//}

//Collection集合常用方法
/*
boolean add():添加元素
boolean remove(Object 0):移除指定元素o
void clear();清空集合
boolean contians(Object o):判定集合中是否存在元素o
boolean isEmpty();判断集合是否为空
int size();集合中元素的个数
 */

//Collection集合的遍历 使用迭代器iterator
//public class Test {
//    public static void main(String[] args) {
//        Collection<String>c=new ArrayList<String>();
//        c.add("hello");
//        c.add("world");
//        c.add("java");
//        Iterator it=c.iterator();
//        while(it.hasNext()){//hasNext()方法  判断it是否还有next
//            Object s=it.next();//系统提示不能使用String类型 需使用Object类型 因为Object类为所有类的祖先类
//            //next方法 返回迭代器的下一个值
//            System.out.println(s);//hello world java
//        }
//    }
//}

//Collection集合存储学生对象
//class student{
//    private String name;
//    private int age;
//
//    public student(String name, int age) {
//        this.name = name;
//        this.age = age;
//    }
//
//    public student() {
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//}
//public class Test {
//    public static void main(String[] args) {
//        Collection<student>c=new ArrayList<student>();
//        student s1=new student("林青霞",18);
//        student s2=new student("张曼玉",20);
//        student s3=new student("王祖贤",20);
//        c.add(s1);
//        c.add(s2);
//        c.add(s3);
//        Iterator it=c.iterator();
//        while(it.hasNext()){
//            student s= (student) it.next();
//            System.out.println(s.getName()+" "+s.getAge());
//            /*
//            林青霞 18
//            张曼玉 20
//            王祖贤 20
//
//             */
//        }
//    }
//}


//List集合的特点
/*
Lise也是一个接口 不可直接创建对象
有序：存储和取出的顺序相同
可重复：不像Set集合，Lise集合允许重复元素存在
 */

//public class Test {
//    public static void main(String[] args) {
//        List<String> list=new ArrayList<String>();
//        list.add("hello");
//        list.add("world");
//        list.add("java");
//        list.add("java");
//        Iterator<String> it = list.iterator();
//        while(it.hasNext()){
//            String s = it.next();
//            System.out.println(s);//可以
//        }
//    }
//}


//List集合的特有方法
/*
void add(int index,element);向指定位置插入元素element
E remove(int index);删除指定位置元素 返回该元素
E set(int index,element);修改指定位置元素，返回修改元素
E get(int index);返回修改索引处的元素
 */

//public class Test {
//    public static void main(String[] args) {
//        List<String> list=new ArrayList<>();
//        list.add("hello");
//        list.add("world");
//        list.add("java");
//        System.out.println(list);//[hello, world, java]
////        list.add(1,"javaee");
////        System.out.println(list);//[hello, javaee, world, java]
////        System.out.println(list.remove(1));
////        System.out.println(list);
//        /*
//        [hello, world, java]
//        world
//        [hello, java]
//         */
////        System.out.println(list.set(1,"javaee"));
////        System.out.println(list);
//        /*
//        [hello, world, java]
//        world
//        [hello, javaee, java]
//         */
//        for(int i=0;i<list.size();i++){
//            System.out.println(list.get(i));
//        }
//        /*
//        [hello, world, java]
//        hello
//        world
//        java
//         */
//    }
//}


//列表迭代器
/*
listIterator:可以沿任意方向遍历列表
其中有hasNext()方法和hasPrevious()方法
有next()方法和privious()方法
 */
//public class Test {
//    public static void main(String[] args) {
//        List<String>list=new ArrayList<>();
//        list.add("hello");
//        list.add("world");
//        list.add("java");
//        ListIterator<String> ite = list.listIterator();
//        while(ite.hasNext()){
//            String s= ite.next();
//            System.out.println(s);//
//        }
//        while(ite.hasPrevious()){
//            String p = ite.previous();
//            System.out.println(p);
//        }
//        while(ite.hasNext()){
//            String s = ite.next();
//            if(s.equals("world")){
//                ite.add("javaee");//listIterator迭代器可以直接添加在后面   而直接用iterator则不可以
//            }
//        }
//        System.out.println(list);//[hello, world, javaee, java]
//    }
//}


//增强for循环for(auto: mylist); 和c++差不多
//public class Test {
//    public static void main(String[] args) {
////        int[] a={1,2,3};
////        for(int aa:a){
////            System.out.println(aa);//1 2 3
////        }
//
////        String[] s={"hello","world","java"};
////        for(String ss:s){
////            System.out.println(ss);//hello world java
////        }
//
//        List<String> list=new ArrayList<>();
//        list.add("hello");
//        list.add("world");
//        list.add("java");
//        for(String s:list){
//            System.out.println(s);//hello world java
//            list.add("javaee");//ConcurrentModificationException:并发修改异常
//        }
//    }
//}

//List集合子类：ArrayList()(底层是数组)和LinkedList(底层是链表)
//public class Test {
//    public static void main(String[] args) {
//        List<String> list=new ArrayList<>();
//        list.add("hello");
//        list.add("world");
//        list.add("java");
//        for(String s:list){
//            System.out.println(s);//hello world java
//        }
//        List<String> llist=new LinkedList<String>();
//        llist.add("hello");
//        llist.add("world");
//        llist.add("java");
//
//        for(String s:llist){
//            System.out.println(s);//hello world java
//        }
//    }
//}


//LinkedList集合中的特有功能
/*
void addFirst(E e)在链表开头添加元素e
void addLast(E e)链表结尾添加元素e
E getFirst();返回链表的第一个元素
E getLast();返回链表的最后一个元素
E removeFirst();删除链表第一个元素 并返回该元素
E removeLast();删除链表的最后一个元素 并返回该元素
 */

//public class Test {
//    public static void main(String[] args) {
//        LinkedList<String>list=new LinkedList<>();//List<String>list=new LinkedList<>();
//        // 因为上面的功能是LinkedList的特有功能 父类List中并没有
//        list.add("hello");
//        list.add("world");
//        list.add("java");
//        //void addFirst(E e)在链表开头添加元素e
//        //void addLast(E e)链表结尾添加元素e
////        list.addFirst("javaee");//添加在了前面
////        list.addLast("javase");//加在后面 和add()效果相同
//        //其他功能暂不演示
//        for(String s:list){
//            System.out.println(s);
//        }
//    }
//}

//Set集合概述和特点
/*
Set集合不包含重复元素
没有get方法
Set集合是一个接口不能直接创建对象
这里我们使用其子类HashSet()来创建对象
其中HashSet对集合中的迭代顺序不做保证（即存储顺序和输入顺序可能不同）
 */
//public class Test {
//    public static void main(String[] args) {
//        Set<String> set=new HashSet<>();
////        set.add("hello");
////        set.add("world");
////        set.add("java");
////        for(String s:set){
////            System.out.println(s);//world java hello 存储顺序和输入顺序可能不同
////        }
//        set.add("hello");
//        set.add("world");
//        set.add("java");
//        set.add("hello");
//        for(String s:set){
//            System.out.println(s);//world java hello set集合中只有一个hello
//        }
//    }
//}

//哈希值
/*
哈希值是JDK根据对象算出来的int类型的数值
Object类中有一个方法可以得到对象的哈希值（public int hashCode();）
同一个对象多次调用hashCode()方法计算的哈希值相同
一般情况下 不同对象调用hashCode()方法计算的哈希值不同
 */
//public class Test {
//    public static void main(String[] args) {
//        String s="hello";
//        String s2="world";
//        System.out.println(s.hashCode());//99162322
//        System.out.println(s2.hashCode());//113318802
//        String s3="重地";
//        String s4="通话";
//        System.out.println(s3.hashCode());//1179395
//        System.out.println(s4.hashCode());//1179395 哈希冲突
//        String s5="坚持";
//        System.out.println(s5.hashCode());//718567
//    }
//}

//HashSet集合概述和特点
/*
1，底层是哈希表
2，对集合的迭代顺序不做任何保证
3.没有get()方法
4，不包含重复元素
 */
//public class Test {
//    public static void main(String[] args) {
//        HashSet<String>hashSet=new HashSet<>();
//        hashSet.add("hello");
//        hashSet.add("world");
//        hashSet.add("java");
//        for(String s:hashSet){
//            System.out.println(s.hashCode());//
//            System.out.println(s);
//            /*
//            113318802
//            world
//            3254818
//            java
//            99162322
//            hello
//            没有任何顺序啊
//             */
//        }
//    }
//}


//HashSet集合储存学生对象并遍历
//class student{
//    private int age;
//    private String name;
//
//    public student(int age, String name) {
//        this.age = age;
//        this.name = name;
//    }
//
//    public student() {
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        student student = (student) o;
//
//        if (age != student.age) return false;
//        return name != null ? name.equals(student.name) : student.name == null;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = age;
//        result = 31 * result + (name != null ? name.hashCode() : 0);
//        return result;
//    }
//}
//
//public class Test {
//    public static void main(String[] args) {
//        HashSet<student>hs=new HashSet<>();
//        student s1=new student(19,"林青霞");
//        student s2=new student(20,"张曼玉");
//        student s3=new student(21,"王祖贤");
//        student s4=new student(21,"王祖贤");
//
//        hs.add(s1);
//        hs.add(s2);
//        hs.add(s3);
//        hs.add(s4);
//        for(student s:hs){
//            System.out.println(s.getName()+" "+s.getAge());
//            /*
//            张曼玉 20
//            林青霞 19
//            王祖贤 21
//            王祖贤 21  可以发现 即使s3和s4内容完全相同 s4也成功添加进了hs(这是因为HashSet中的Hashcode和equals方法判定和我们
//            期待的不同  所以我们要在Student类中从写这两个方法 直接alt+enter自动生成即可)
//            //从写后
//            王祖贤 21
//            林青霞 19
//            张曼玉 20
//             */
//        }
//    }
//}


//LinkedHashSet()
/*
由链表和哈希表实现的Set接口
由链表保证元素有序 即存入和取出的顺序一致
由哈希表保证元素唯一 即没有重复元素
 */

//public class Test {
//    public static void main(String[] args) {
//        LinkedHashSet<String> linkedHashSet =new LinkedHashSet<>();
//        linkedHashSet.add("Hello");
//        linkedHashSet.add("world");
//        linkedHashSet.add("java");
//        linkedHashSet.add("java");
//        for(String s:linkedHashSet){
//            System.out.println(s);//Hello world java 只有一个java
//        }
//    }
//}

//TreeSet集合概述和特点
/*
元素有序，按照一定的规则进行排序，具体的排序方式取决于排序方法
无参构造：TreeSet():按自然顺序排序
带参构造：TreeSet(Comparator comparator)根据指定的比较器进行排序
没有get()方法 ，不能通过普通的for循环遍历、
由于是Set集合 所以不能包含重复元素
 */

//public class Test {
//    public static void main(String[] args) {
//        TreeSet<Integer> treeSet=new TreeSet<>();//注意<>中只能为包装类型 所以要用int的包装类而不能用int
//        treeSet.add(10);
//        treeSet.add(30);
//        treeSet.add(20);
//        treeSet.add(50);
//        treeSet.add(40);
//        treeSet.add(40);
//        for(Integer i:treeSet){
//            System.out.println(i);//10 20 30 40 50  只有一个40 不能包含重复元素
//        }
//    }
//}

//自然排序Comparable
/*
TreeSet(Comparator comparator)构造一个新的空树集，根据指定的比较器进行排序。
存储学生对象并遍历：首先按照年龄排序 年龄相同就按姓名首元素排序
如果TreeSet集合（无参构造）储存自定义对象 要重写CompareTo方法（实现Comparable接口)
重写方法时 一定要注意排序规则的主次进行排序
 */
//class student implements Comparable{
//    private String name;
//    private int age;
//
//    public student() {
//    }
//
//    public student(String name, int age) {
//        this.name = name;
//        this.age = age;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    @Override
//    public int compareTo(Object s) {//类似与c++里sort中自定义排序
//        //return 0;
//        //return 1;
//        student s1=(student) s;
//        int num=this.age-s1.age;
//        int num1=num==0?this.name.compareTo(s1.name):num;
//        return num1;
//    }
//}
//public class Test {
//    public static void main(String[] args) {
//        TreeSet<student> ts=new TreeSet<>();
//        student s1=new student("xisi",19);
//        student s2=new student("diaochan",20);
//        student s3=new student("yangyuhuan",18);
//        student s4=new student("wangzhaojun",21);
//        student s5=new student("linqingxia",21);
//        ts.add(s1);
//        ts.add(s2);
//        ts.add(s3);
//        ts.add(s4);
//        ts.add(s5);
//        for(student s:ts){
//           // System.out.println(s.getName()+" "+s.getAge());//没有重写CompareTo方法时：.ClassCastException（异常）
//            //System.out.println(s.getName()+" "+s.getAge());//return为0时只有一个元素被存入集合
//           // System.out.println(s.getName()+" "+s.getAge());//return为1是全部添加了（有多少加多少）
//            System.out.println(s.getName()+" "+s.getAge());//重写了compareTo方法后
//            //先按年龄排序 年龄相同则按名字首字母排序
//            /*
//            yangyuhuan 18
//            xisi 19
//            diaochan 20
//            linqingxia 21
//            wangzhaojun 21
//
//             */
//        }
//
//    }
//}

//比较器Comparator的使用
/*
这里是TreeSet()的带参构造方法
这里要重写Comparator方法 即在构造时重写
 */

//
//class student {
//    private String name;
//    private int age;
//    public student() {
//    }
//
//    public student(String name, int age) {
//        this.name = name;
//        this.age = age;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//
//}
//public class Test {
//    public static void main(String[] args) {
//        TreeSet<student> ts=new TreeSet<student>(new Comparator<student>() {//创建匿名对象
//            @Override
//            public int compare(student s1, student s2) {//这里是后面的元素调用与前面的比
//                int num=s1.getAge()-s2.getAge();
//                int num1=num==0?s1.getName().compareTo(s2.getName()):num;
//                return num1;
//            }
//        });//在这里重写Comparator方法
//        student s1=new student("xisi",19);
//        student s2=new student("diaochan",20);
//        student s3=new student("yangyuhuan",18);
//        student s4=new student("wangzhaojun",21);
//        student s5=new student("linqingxia",21);
//        student s6=new student("linqingxia",21);
//        ts.add(s1);
//        ts.add(s2);
//        ts.add(s3);
//        ts.add(s4);
//        ts.add(s5);
//        ts.add(s6);
//        for(student s:ts){
//            System.out.println(s.getName()+" "+s.getAge());
//            /*
//            yangyuhuan 18
//            xisi 19
//            diaochan 20
//            linqingxia 21
//            wangzhaojun 21//只有一个林青霞
//             */
//        }
//
//    }
//}

//不重复的随机数
//public class Test {
//    public static void main(String[] args) {
////        Set<Integer>set=new HashSet<>();
//        TreeSet<Integer>set=new TreeSet<>();
//        Random r=new Random();
//        while(set.size()<10){
//            int i = r.nextInt(20) + 1;//创建一个1到20的随机数
//            set.add(i);//添加 如果有重复的则无法添加
//        }
//        for(Integer i:set){
//           // System.out.println(i);//可以了  但用HashSet数字不会排序
//            System.out.println(i);//用TreeSet数字将排序
//        }
//    }
//}

//泛型
/*
好处：把运行是的问题提前到了编译时期
2.避免了强制类型转换
 */
//public class Test {
//    public static void main(String[] args) {
//        //List list=new ArrayList();//此处没有添加泛型 默认为Object类型
//        List<String>list=new ArrayList<>();
//        list.add("hello");
//        list.add("world");
//        list.add("java");
//       // list.add(100);//没有添加泛型之前 这里不会报错
//       // list.add(100);//添加泛型后 这里报错
//       // Iterator it = list.iterator();//未添加泛型前的迭代器
//        Iterator<String> it = list.iterator();//添加泛型后的迭代器
//        while(it.hasNext()){
//           // Object s = it.next();//没有添加泛型时 自动补全s为Object类型
//            //如果一定要将s定义为String类型 则需要强转
//           // String s=(String)it.next();
//            String s = it.next();//添加泛型后就不需要强转
//            System.out.println(s);//但这样会出错  因为int类型不能转为String 类型 报错：ClassCastException
//
//        }
//    }
//}


//泛型类和泛型方法
//class student<T> {//类似于函数模板
//    private T data;
//
//    public T getData() {
//        return data;
//    }
//
//    public void setData(T data) {
//        this.data = data;
//    }
//}
//
//public class Test {
//    public static void main(String[] args) {
//        student<String> s = new student<>();//根据<>中的类型定义T
//        s.setData("hello");
//        System.out.println(s.getData());//hello
//
//        student<Integer> s1 = new student<>();
//        s1.setData(10);
//        System.out.println(s1.getData());//10
//
//    }
//}


//泛型方法 修饰符<T> 返回值类型方法名（T 变量名）
//普通方法（多态）
//class student{
//    public static void show(int a){
//        System.out.println(a);
//    }
//    public static void show(String a){
//        System.out.println(a);
//    }
//}

//用泛型类改进
//class student<T>{
//    public void show(T t){
//        System.out.println(t);
//    }
//}

//用泛型方法改进
//class student{
//    public static<T> void show(T t){
//        System.out.println(t);
//    }
//}
//public class Test {
//    public static void main(String[] args) {
////        student.show(10);//10
////        student.show("hello");//hello
////        student<String>s=new student<>();//但这样每次都要定义类型 比较麻烦
////        s.show("hell0");
////        student<Integer>s1=new student<>();
////        s1.show(10);
//        student.show("hello");
//        System.out.println(10);//系统根据传入数据定义T
//    }
//}

//泛型接口
//interface student<T> {//定义一个泛型接口
//    void show(T t);
//}
//
//class Generic<T> implements student<T> {//实现接口时<T>也要写上
//    @Override
//    public void show(T t) {
//        System.out.println(t);
//    }
//}
//
//public class Test {
//    public static void main(String[] args) {
//        Generic<String> g1 = new Generic<>();
//        g1.show("hello");//hello
//        Generic<Integer> g2 = new Generic<>();
//        g2.show(10);//10
//    }
//}

//类型通配符 为了表示各种泛型List的父类 可以使用类型通配符<?>

//public class Test {
//    public static void main(String[] args) {
//        /*
//        继承关系
//        java.lang.Object
//            java.lang.Number
//                java.lang.Integer
//         */
////        List<?>list=new ArrayList<Object>();
////        List<?>list1=new ArrayList<Number>();
////        List<?>list2=new ArrayList<Integer>();//都没问题
//
//
//        //类型通配符上限<?extends>
//       // List<?extends Number>list=new ArrayList<Object>();//报错 因为Number为上限 这里只能填Nnmber或其子类
////        List<?extends Number>list1=new ArrayList<Number>();
////        List<?extends Number>list2=new ArrayList<Integer>();
//
//        //类型通配符下限<?super>
////         List<?super Number>list=new ArrayList<Object>();
////        List<?super Number>list1=new ArrayList<Number>();
////        List<?super Number>list2=new ArrayList<Integer>();//报错 因为Number为下限 这里只能填Nnmber或其子父类
//
//
//    }
//}

//可变参数
//public class Test {
//    public static void main(String[] args) {
//        System.out.println(sum(10,20));
//        System.out.println(sum(10,20,30));
//        System.out.println(sum(10,20,30,40));
//        System.out.println(sum(10,20,30,40,50));
//    }
////    public static int sum(int a,int b){
////        return a+b;
////    }
////    public static int sum(int a,int b,int c){
////        return a+b+c;
////    }
////    public static int sum(int a,int b,int c,int d){
////        return a+b+c+d;
////    }
////    public static int sum(int a,int b,int c,int d,int e){//这样可以是可以  不过太麻烦
////        return a+b+c+d+e;
////    }
//    //可变参数改进
////    public static int sum(int... a){//这里的a其实是一个数组
////        int sum=0;
////        for(int i:a){
////            sum+=i;
////        }
////        return sum;//可以了
////    }
//    //如果传入的参数不只一种类型（其中包含可变参数） 可变惨参数放在最后
//    //    public static int sum( String s,int... a){//这里的a其实是一个数组
////        int sum=0;
////        for(int i:a){
////            sum+=i;
////        }
////        return sum;//可以了
////    }
//}


//泛型：可变参数的使用
/*
Array工具类中有一个静态方法asList 不可增删 可以修改
List接口中有一个静态方法of  不可增删改
Set接口中有一个静态方法of  不可增删 没有修改方法 在给定元素时不可给重复元素
 */

//public class Test {
//    public static void main(String[] args) {
////       List<String> list=Arrays.asList("hello","world","java");
////       //list.remove("hello");//UnsupportedOperationException 不支持操作
////        //list.add("hello");//UnsupportedOperationException 不支持操作
////        list.set(1,"java");//这个操作可以
////       for(String s:list){
////           System.out.println(s);
////       }
//
//
////        List<String> list=List.of("hello","world","java");
////        //list.remove("hello");//UnsupportedOperationException 不支持操作
////        //list.add("hello");//UnsupportedOperationException 不支持操作
////       //list.set(1,"java");//UnsupportedOperationException 不支持操作
////        for(String s:list){
////            System.out.println(s);
////        }
//
//       // Set<String>set=Set.of("hello","world","java");
//       // set.add("hell0");//UnsupportedOperationException 不支持操作
//        //set.remove("hello");//UnsupportedOperationException 不支持操作
//    }
//}







