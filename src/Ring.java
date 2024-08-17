public class Ring {
    Fighter f1;
    Fighter f2;
    int maxWeight;
    int minWeight;
    boolean isF1Turn;

    public Ring(Fighter f1, Fighter f2, int maxWeight, int minWeight) {
        this.f1 = f1;
        this.f2 = f2;
        this.maxWeight = maxWeight;
        this.minWeight = minWeight;
    }

    public void run() {
        if (isCheckWeight()) {
            System.out.println("The fight is starting!");
            // İlk kimin saldıracağını belirle
            if (Math.random() < 0.5) {
                System.out.println(this.f1.name + " starts first!");
                isF1Turn = true;
            } else {
                System.out.println(this.f2.name + " starts first!");
                isF1Turn = false;
            }

            while (isCheckAlive(this.f1) && isCheckAlive(this.f2)) {
                if (isF1Turn) {
                    this.f1.hit(this.f2);
                    if (!isCheckAlive(this.f2)) {
                        printWinInfo(this.f1, this.f2);
                        break;
                    }
                } else {
                    this.f2.hit(this.f1);
                    if (!isCheckAlive(this.f1)) {
                        printWinInfo(this.f2, this.f1);
                        break;
                    }
                }
                isF1Turn = !isF1Turn;
            }
        } else {
            System.out.println("Fighters' weights do not match the allowed range.");
        }
    }

    public void printWinInfo(Fighter winnerFighter, Fighter loserFighter) {
        System.out.println("**************");
        System.out.println(winnerFighter.name + " won! Remaining health: " + winnerFighter.health);
        System.out.println(loserFighter.name + " lost that fight...");
        System.out.println("**************");
    }

    // Sağlık durumunu kontrol etme metodu
    public boolean isCheckAlive(Fighter f) {
        return f.health > 0;
    }

    public boolean isCheckWeight() {
        return (this.f1.weight >= minWeight && this.f1.weight <= maxWeight) && (this.f2.weight >= minWeight && this.f2.weight <= maxWeight);
    }
}
