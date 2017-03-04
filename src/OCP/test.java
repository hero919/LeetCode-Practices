package OCP;

/**
 * Created by zeqingzhang on 11/26/16.
 */
public class test {
    public int testVariable(){
        int v1;




        return 2;
    }



    public static void main(String[] args){
        test t = new test();

        System.out.println(t.testVariable());
    }
}


interface a{
    void hello();
}

interface b extends a{}

class c implements b{

    @Override
    public void hello() {

    }
}
