package Quiz;

public interface Animal { public default String getName() { return null; } }
interface MammalInterface { public default String getName() { return null; } }
//abstract class Otter implements MammalInterface, Animal
//{
//
//    @Override
//    public String getName() {
//        return Mammal.super.getName();
//    }
//}