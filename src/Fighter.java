public class Fighter {
    String name;
    int health;
    int weight;
    int damage;
    double dodge;

    public Fighter (String name, int health, int weight, int damage, double dodge){
        this.name = name;
        this.health = health;
        this.weight = weight;
        this.damage = damage;
        this.dodge = dodge;
    }

    public void hit(Fighter foe) {
        System.out.println(this.name + " ->punch-> " + foe.name);
        if (!foe.isDodged()) {
            foe.decreaseHealth(this.damage);
            System.out.println(foe.name + "'s health: " + foe.health);
        } else {
            System.out.println(foe.name + " dodged the attack!");
        }
        System.out.println("--------------------");
    }

    public void decreaseHealth(int amount) {
        this.health -= amount;
        if (this.health < 0) {
            this.health = 0;
        }
    }

    public boolean isDodged(){
        double randomValue = Math.random() * 100;
        return randomValue <= this.dodge;
    }

}