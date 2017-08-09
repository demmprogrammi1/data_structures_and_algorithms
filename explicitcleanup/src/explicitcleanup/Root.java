package explicitcleanup;
class jopa {
public void play() {}
static void tune(jopa i) {
// ...
i.play();
}
}
// Wind objects are instruments
// because they have the same interface:
public class Root extends jopa {
public static void main(String[] args) {
Root flute = new Root();
jopa f=new Root();
System.out.print(f.getClass());
jopa.tune(flute); // Upcasting
}
}