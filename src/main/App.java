package main;

import model.Meal;
import model.Result;

import java.util.*;

public class App {
    public  void  bestCharge(HashMap<Meal,Integer> menu){
        Result result=halfprice(menu);
        Integer fullCutprice=fullCut(result.getCutPrice()+result.getTotalPrice());
        System.out.println("-----------------------------------");
        if(result.getTotalPrice()<=fullCutprice){
            if(result.getCutPrice()!=0){
                System.out.println("Promotion used:");
                System.out.println(result.getResultString());
                System.out.println("-----------------------------------");
            }
            System.out.println("Total: "+result.getTotalPrice()+" yuan");
            System.out.println("===================================");
        }else {
            System.out.println("Promotion used:");
            System.out.println("Deduct 6 yuan when the order reaches 30 yuan, saving 6 yuan");
            System.out.println("-----------------------------------");
            System.out.println("Total: "+fullCutprice+" yuan");
            System.out.println("===================================");
        }
    }

    /**
     * 将输入进去的字符串转化为HaspMap，存储菜与点的数量
     * @param mealList
     * @return
     */
    public HashMap<Meal,Integer> creatMenu(HashMap<String,Meal> mealList){
        Scanner input=new Scanner(System.in);
        HashMap<Meal,Integer> menu=new HashMap<>();
        HashMap<Meal,Integer> tempMeal=null;
        System.out.println("please enter meal one by one, press Enter to next, type nothing to finish");
        String meals= input.nextLine();
        while ( meals != null && !meals.equals("")) {
            String[] temp = meals.split(" ");
            Meal meal=mealList.get(temp[0]);
            if(meal==null){
                System.out.println("your order "+temp[0]+" is not exist");
            }
            else if(menu.get(meal)==null){
                menu.put(meal,Integer.parseInt(temp[2]));
            }else{
                Integer mealNum=menu.get(meal);
                menu.put(meal,Integer.parseInt(temp[2])+mealNum);
            }
            meals= input.nextLine();
        }
        return menu;
    }

    /**
     * 进行半价折扣的优惠计算
     * @param menu
     * @return
     */
    public Result halfprice(HashMap<Meal,Integer> menu){
        Iterator iterator=menu.keySet().iterator();
        List<String> cutMeal=new ArrayList<>();
        Integer total=0;
        Integer cut=0;
        Meal meal=null;
        Integer num=0;
        System.out.println("============= Order details =============");
        while(iterator.hasNext()){
           meal= (Meal) iterator.next();
           num = menu.get(meal);
           System.out.println(meal.getName()+" x " + num + " = " + num*meal.getPrice() + " yuan ");

           if(meal.isHalfPrice()){
               meal.setPrice(meal.getPrice()/2);
               cut += meal.getPrice()*num;
               cutMeal.add(meal.getName());
           }
           total += meal.getPrice()*num;
        }
        StringBuffer pro=new StringBuffer("Half price for certain dishes (");
        for(int i=0;i<cutMeal.size();i++){
            if(i!=cutMeal.size()-1){
                pro.append(cutMeal.get(i)+" and ");
            }else {
                pro.append(cutMeal.get(i)+"), saving "+cut+" yuan");
            }
        }
        Result result = new Result(pro,total,cut);
        return result;
    }

    public Integer fullCut(Integer price){
        if(price >= 30){
            return price-6;
        }
        return price;
    }
}
