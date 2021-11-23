package com.psj.designpatterns;

/**
 *
 * @author Pishaojun
 * @date 2021/11/23
 */

public class DecoratorPattern {
    public static void main(String[] args) {
        // 首先，我们需要一个基础饮料，红茶、绿茶或咖啡
        Beverage beverage = new GreenTea();
        // 开始装饰
        beverage = new Lemon(beverage); // 先加一份柠檬
        beverage = new Mango(beverage); // 再加一份芒果

        System.out.println(beverage.getDescription() + " 价格：￥" + beverage.cost());
        //"绿茶, 加柠檬, 加芒果 价格：￥16"
    }
}

class BlackTea extends Beverage {
    public String getDescription() {
        return "红茶";
    }
    public double cost() {
        return 10;
    }
}
class GreenTea extends Beverage {
    public String getDescription() {
        return "绿茶";
    }
    public double cost() {
        return 11;
    }
}

abstract class Beverage {
    // 返回描述
    public abstract String getDescription();
    // 返回价格
    public abstract double cost();
}

abstract class Condiment extends Beverage {

}

class Lemon extends Condiment {
    private Beverage bevarage;
    // 这里很关键，需要传入具体的饮料，如需要传入没有被装饰的红茶或绿茶，
    // 当然也可以传入已经装饰好的芒果绿茶，这样可以做芒果柠檬绿茶
    public Lemon(Beverage bevarage) {
        this.bevarage = bevarage;
    }
    public String getDescription() {
        // 装饰
        return bevarage.getDescription() + ", 加柠檬";
    }
    public double cost() {
        // 装饰
        return bevarage.cost() + 2; // 加柠檬需要 2 元
    }
}

class Mango extends Condiment {
    private Beverage bevarage;
    public Mango(Beverage bevarage) {
        this.bevarage = bevarage;
    }
    public String getDescription() {
        return bevarage.getDescription() + ", 加芒果";
    }
    public double cost() {
        return bevarage.cost() + 3; // 加芒果需要 3 元
    }
}