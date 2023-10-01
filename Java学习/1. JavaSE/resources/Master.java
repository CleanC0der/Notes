public class Master{
    public void feed(Pets pet){
/*         if(pet instanceof Dogs){
            Dogs d = (Dogs)pet;
            d.eat();
        }else if(pet instanceof Cats){
            Cats c = (Cats)pet;
            c.eat();
        }else if(pet instanceof YingWu){
            YingWu y = (YingWu)pet;
            y.eat();
        } 
        这些代码不需要，这是向上转型，没有调用子类特有的方法，所以不需要向下转型。
        瞅瞅：调用的方法都是eat()，而学习的时候有个例子却不是这样。*/
        pet.eat();
        
    }
}