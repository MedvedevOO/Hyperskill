package machine;

public class Cup {
    int water;
    int milk;
    int coffeeBeans;
    int price;

    public Cup(int water, int milk, int coffeeBeans, int price) {
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
        this.price = price;
    }

    public Cup(int water, int coffeeBeans, int price) {
        this.water = water;
        this.coffeeBeans = coffeeBeans;
        this.price = price;
    }
}
