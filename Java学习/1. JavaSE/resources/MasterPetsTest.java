public class MasterPetsTest{
    public static void main(String[] args){
        Master m = new Master();
        Dogs dogs = new Dogs();
        Cats cats = new Cats();
        YingWu yingWu = new YingWu();
        m.feed(dogs);
        m.feed(cats);
        m.feed(yingWu);
    }
}