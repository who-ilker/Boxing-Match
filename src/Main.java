public class Main {
    public static void main(String[] args){
        Fighter Ali = new Fighter("M. Ali", 90, 105, 18, 40);
        Fighter Tyson = new Fighter("Tyson", 100, 100, 27, 15);

        Ring match1 = new Ring(Ali, Tyson, 110, 100);

        match1.run();

    }
}
