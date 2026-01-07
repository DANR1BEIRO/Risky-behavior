package test;

public class OuterClassTest {
    class InnerClassTest {
        private String test = "test inner class";

        public String getTest() {
            return test;
        }
    }
}

class Foo {
    public static void main(String[] args) {
        OuterClassTest outerObj = new OuterClassTest();
        OuterClassTest.InnerClassTest innerObj = outerObj.new InnerClassTest();
        System.out.println(innerObj.getTest());
    }
}

/**
 * You can instantiate an inner instance from code running outside the outer class, but you
 * have to use a special syntax. Chances are you’ll go through your entire Java life and never
 * need to make an inner class from outside
 */