package com.chenxi.test;
import java.util.ArrayList;
import java.util.Scanner;
import com.chenxi.domain.student;

public class studentManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //创建集合容器对象
        ArrayList<student> list = new ArrayList<>();

        lo:
        while (true) {

            System.out.println("----欢迎来到学生查询系统----");
            System.out.println("1 添加学生");
            System.out.println("2 删除学生");
            System.out.println("3 修改学生");
            System.out.println("4 查看学生");
            System.out.println("5 退出");
            System.out.println("请输入您的选择：");

            int choice = sc.nextInt();
            switch (choice) {
            case 1:
                //System.out.println("添加学生");
                addStudent(list);//★用一个方法（addStudent）专门干添加学生的事，把键盘录入的学生信息封装为学生对象，再把学生对象添加到list集合中，★在VSCode使用开始修复（Ctrl+1），自动创建方法
                break;
            case 2:
                //System.out.println("删除学生");
                delStudent(list);
                break;
            case 3:
                //System.out.println("修改学生");
                updateStudent(list);
                break;
            case 4:
                //System.out.println("查看学生");
                queryStudent(list);
                break;
            case 5:
                System.out.println("感谢您的使用");
                break lo;
            default:
                System.out.println("您的输入有误");
                break;

            }
        }
        sc.close();
    }

    public static void updateStudent(ArrayList<student> list) {
        System.out.println("请输入您要修改的学号：");
        Scanner sc = new Scanner(System.in);
        String updateId = sc.next();
        int index = getIndex(list, updateId);
        if (index == -1) {
            System.out.println("您输入的学号不存在，请查询后重新输入");
            return;
        }else{
            System.out.println("请输入新的学生姓名：");
            String name = sc.next();
            System.out.println("请输入新的学生年龄：");
            int age = sc.nextInt();
            System.out.println("请输入新的学生生日：");
            String birthday = sc.next();
            student stu = new student(updateId, name, age, birthday);//封装成一个新的学生对象，学号仍为updateId
            list.set(index, stu);//调用集合的set方法完成修改
            System.out.println("修改成功");
        }


    }


    public static void delStudent(ArrayList<student> list) {
        System.out.println("请输入您要删除的学号：");
        Scanner sc = new Scanner(System.in);
        String delId = sc.next();
        int index = getIndex(list, delId);
        if (index == -1) {
            System.out.println("您输入的学号不存在，请查询后重新输入");
            return;
        }else{
            list.remove(index);
            System.out.println("删除成功");
        }



    }

    public static void queryStudent(ArrayList<student> list) {
        if (list.size() == 0) {
            System.out.println("无相关信息，请添加后重新查询");
            return;
        }
        System.out.println("学号\t姓名\t年龄\t生日");
        for (int i = 0; i < list.size(); i++) {
        student stu = list.get(i);//用student对象stu接收get的值
        System.out.println(stu.getId() + "\t" + stu.getName() + "\t\t" + stu.getAge() + "岁\t" + stu.getbirthday());

        }

    }

    public static void addStudent(ArrayList<student> list) {  //自动创建的添加学生方法为private，修改为public
        Scanner sc = new Scanner(System.in);
        String id; 
        while (true) {                          //用while（true）做出无限循环，把输入学号的步骤包裹进去
            System.out.println("请输入学号：");
            //String id = sc.next();      //为提升id的作用域，得把String id定义放到while（true）外面，在巡环用id赋值
            id = sc.next();
            int index = getIndex(list, id);
            if (index == -1) {
                break;                //根据方法getIndex的返回值来确定输入的学号是否存在，如果返回的是-1，可以录入，终止循环
            }
        }
        
        System.out.println("请输入学生姓名：");
        String name = sc.next();
        System.out.println("请输入学生年龄：");
        int age = sc.nextInt();
        System.out.println("请输入学生的生日：");
        String birthday = sc.next();
        student stu = new student(id, name, age, birthday); //★将键盘录入的信息封装为学生对象，用有参构造的方法
        list.add(stu);
        System.out.println("添加成功");
    }

    public static int getIndex(ArrayList<student> list, String id) {   //定义getIndex方法，接收一个集合对象（泛型<student>），再接收一个学生学号
        int index = -1;  //假设传入的学号在集合中不存在，index = -1
        
        for (int i = 0; i < list.size(); i++) {  //遍历集合获取每一个对象（stu），
            student stu = list.get(i);
            String sid = stu.getId();          //获取学号
            if (sid.equals(id)) {                //获取的学号sid 与查找的id比对
                index = i;                  // 存在，即让index记录正确的索引位置i
            }
        }
        return index;         //返还给调用者
    }
}