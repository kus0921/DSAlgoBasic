package Quiz;

public abstract class Bird {
    private void fly() {
        System.out.println("Bird is flying");
    }

    public static void main(String[] args) {
        Pelican bird = new Pelican();
        bird.fly();
    }
}

class Pelican extends Bird {

    protected void fly() {
        System.out.println("Pelican is flying");
    }
}
