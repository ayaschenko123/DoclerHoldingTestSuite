package PageObjects;

public class DataProvider {

    //Site links Data Provider
    @org.testng.annotations.DataProvider(name = "links")
    public Object[][] links(){
        return new Object[][]{
                {"http://uitest.duodecadits.com/"},
                {"http://uitest.duodecadits.com/form.html"}
        };
    }

    @org.testng.annotations.DataProvider(name = "iconAndUrl")
    public Object[][] iconAndUrl(){
        return new Object[][]{
                {".//*[@id = 'form']","Form", "http://uitest.duodecadits.com/form.html"},
                {".//*[@id = 'home']","Home", "http://uitest.duodecadits.com/"}
        };
    }


    //Names for submission on Form Page
    @org.testng.annotations.DataProvider(name = "names")
    public Object[][] names(){
        return new Object[][]{
                {"John"},
                {"Sophia"},
                {"Charlie"},
                {"Emily"}
        };
    }
}
