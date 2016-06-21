import com.hpc.narm.RuleController;
import com.hpc.narm.RuleDB;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
//import static org.mockito.Mockito.*;
//import com.hpc.narm.*;



@PrepareForTest({RuleDB.class , RuleController.class})
@RunWith(PowerMockRunner.class)
public class RuleControllerTest {
    public static List rules=new ArrayList<>();
    @BeforeClass 
    public static void fakeDB() throws ParseException{
        
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        
        Map rule1 = new HashMap();
        ///define rule1
        rule1.put("cost_up",null);
        rule1.put("cost_down",null);
        rule1.put("country","Netherlands");
        rule1.put("date_up",null);
        rule1.put("date_down",null);
        rule1.put("kala_name","بنزین-قیر-نفت-گاز طبیعی");
        rule1.put("company",null);
        rule1.put("mass_up",null);
        rule1.put("mass_down",null);
        rule1.put("kala_number",null);
        rule1.put("price_up",null);
        rule1.put("price_down",null);
        rule1.put("id",1);
        
        /// rule 2
        Map rule2 = new HashMap();
        rule2.put("cost_up",null);
        rule2.put("cost_down",null);
        rule2.put("country",null);
        rule2.put("date_up",null);
        rule2.put("date_down",null);
        rule2.put("kala_name","گندم-برنج-حبوبات");
        rule2.put("company",null);
        rule2.put("mass_up",null);
        rule2.put("mass_down",null);
        rule2.put("kala_number",null);
        rule2.put("price_up",null);
        rule2.put("price_down",null);
        rule2.put("id",2);
        
        
        /// rule 3
        Map rule3 = new HashMap();
        rule3.put("cost_up",null);
        rule3.put("cost_down",null);
        rule3.put("country",null);
        rule3.put("date_up",(Date) formatter.parse("2016-06-18"));
        rule3.put("date_down",(Date) formatter.parse("2016-06-13"));
        rule3.put("kala_name","خودرو");
        rule3.put("company",null);
        rule3.put("mass_up",null);
        rule3.put("mass_down",null);
        rule3.put("kala_number",null);
        rule3.put("price_up",null);
        rule3.put("price_down",Long.valueOf("100000"));
        rule3.put("id",3);
        
        // rule 4
        Map rule4 = new HashMap();
        rule4.put("cost_up",Long.valueOf("99000"));
        rule4.put("cost_down",Long.valueOf("50000"));
        rule4.put("country",null);
        rule4.put("date_up",(Date) formatter.parse("2016-12-18"));
        rule4.put("date_down",null);
        rule4.put("kala_name",null);
        rule4.put("company",null);
        rule4.put("mass_up",null);
        rule4.put("mass_down",null);
        rule4.put("kala_number",null);
        rule4.put("price_up",null);
        rule4.put("price_down",Long.valueOf("7"));
        rule4.put("id",4);
        
        //rule 5
        Map rule5 = new HashMap();
        rule5.put("cost_up",null);
        rule5.put("cost_down",Long.valueOf("50000"));
        rule5.put("country",null);
        rule5.put("date_up",(Date) formatter.parse("2016-12-18"));
        rule5.put("date_down",null);
        rule5.put("kala_name","سیب قرمز");
        rule5.put("company",null);
        rule5.put("mass_up",null);
        rule5.put("mass_down",Double.valueOf("100"));
        rule5.put("kala_number",null);
        rule5.put("price_up",null);
        rule5.put("price_down",null);
        rule5.put("id",5);
        
        //rule 6
        Map rule6 = new HashMap();
        rule6.put("cost_up",Long.valueOf("20000"));
        rule6.put("cost_down",null);
        rule6.put("country",null);
        rule6.put("date_up",(Date) formatter.parse("2016-12-18"));
        rule6.put("date_down",(Date) formatter.parse("2016-12-11"));
        rule6.put("kala_name","آرد");
        rule6.put("company",null);
        rule6.put("mass_up",Double.valueOf("999.9"));
        rule6.put("mass_down",null);
        rule6.put("kala_number",null);
        rule6.put("price_up",null);
        rule6.put("price_down",null);
        rule6.put("id",6);
        
        //rule 7
        Map rule7 = new HashMap();
        rule7.put("cost_up",Long.valueOf("2000000"));
        rule7.put("cost_down",Long.valueOf("10000"));
        rule7.put("country",null);
        rule7.put("date_up",(Date) formatter.parse("2016-12-29"));
        rule7.put("date_down",(Date) formatter.parse("2016-06-11"));
        rule7.put("kala_name",null);
        rule7.put("company","Apple");
        rule7.put("mass_up",null);
        rule7.put("mass_down",Double.valueOf("3"));
        rule7.put("kala_number",null);
        rule7.put("price_up",null);
        rule7.put("price_down",null);
        rule7.put("id",7);
        
        //rule 8
        Map rule8 = new HashMap();
        rule8.put("cost_up",Long.valueOf("2000000"));
        rule8.put("cost_down",Long.valueOf("100"));
        rule8.put("country",null);
        rule8.put("date_up",(Date) formatter.parse("2016-12-29"));
        rule8.put("date_down",(Date) formatter.parse("2016-06-11"));
        rule8.put("kala_name","Iphone5-Iphone4-Iphone4s-Iphone5s-Iphone5c");
        rule8.put("company","Apple");
        rule8.put("mass_up",null);
        rule8.put("mass_down",Double.valueOf("7"));
        rule8.put("kala_number",null);
        rule8.put("price_up",null);
        rule8.put("price_down",null);
        rule8.put("id",8);
        
        //rule 9
        Map rule9 = new HashMap();
        rule9.put("cost_up",Long.valueOf("2000000"));
        rule9.put("cost_down",Long.valueOf("10000"));
        rule9.put("country",null);
        rule9.put("date_up",(Date) formatter.parse("2016-12-29"));
        rule9.put("date_down",(Date) formatter.parse("2016-06-11"));
        rule9.put("kala_name",null);
        rule9.put("company",null);
        rule9.put("mass_up",null);
        rule9.put("mass_down",null);
        rule9.put("kala_number","refx821");//every side by side
        rule9.put("price_up",null);
        rule9.put("price_down",null);
        rule9.put("id",9);
        
        //rule 10
        Map rule10 = new HashMap();
        rule10.put("cost_up",null);
        rule10.put("cost_down",null);
        rule10.put("country","Korea");
        rule10.put("date_up",null);
        rule10.put("date_down",(Date) formatter.parse("2016-06-12"));
        rule10.put("kala_name","refrigerator x12");
        rule10.put("company","LG");
        rule10.put("mass_up",null);
        rule10.put("mass_down",null);
        rule10.put("kala_number","refx821");//every side by side
        rule10.put("price_up",null);
        rule10.put("price_down",null);
        rule10.put("id",10);
        
        //rule 11
        Map rule11 = new HashMap();
        rule11.put("cost_up",null);
        rule11.put("cost_down",Long.valueOf("1000000"));
        rule11.put("country",null);
        rule11.put("date_up",null);
        rule11.put("date_down",null);
        rule11.put("kala_name",null);
        rule11.put("company",null);
        rule11.put("mass_up",null);
        rule11.put("mass_down",null);
        rule11.put("kala_number",null);
        rule11.put("price_up",null);
        rule11.put("price_down",null);
        rule11.put("id",11);
        
        //rule 12
        Map rule12 = new HashMap();
        rule12.put("cost_up",null);
        rule12.put("cost_down",null);
        rule12.put("country",null);
        rule12.put("date_up",null);
        rule12.put("date_down",null);
        rule12.put("kala_name",null);
        rule12.put("company",null);
        rule12.put("mass_up",null);
        rule12.put("mass_down",null);
        rule12.put("kala_number","mob23");//smartphone
        rule12.put("price_up",Long.valueOf("10000"));
        rule12.put("price_down",Long.valueOf("10000"));
        rule12.put("id",12);
        
        
        rules.add(rule1);
        rules.add(rule2);
        rules.add(rule3);
        rules.add(rule4);
        rules.add(rule5);
        rules.add(rule6);
        rules.add(rule7);
        rules.add(rule8);
        rules.add(rule9);
        rules.add(rule10);
        rules.add(rule11);
        rules.add(rule12);
    }
    
    //@InjectMocks
    //private RuleDB rdb;
    
    @Before
    public void mockDB() throws Exception{
        RuleDB rdb = PowerMockito.mock(RuleDB.class);
        PowerMockito.whenNew(RuleDB.class).withNoArguments().thenReturn(rdb);
        PowerMockito.when(rdb.getRules()).thenReturn(rules);  
    }
    
    @Test
    public void test1() throws Exception {
        RuleController rlc = RuleController.getRuleController();
        rlc.load();
        
        ///make input ready
        Map input = new HashMap();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        input.put("cost",Long.valueOf(1900000));
        input.put("country","Netherlands");
        input.put("date",(Date) formatter.parse("2016-06-12"));
        //input.put("date",null);
        input.put("kala_name","بنزین");
        input.put("company","Shell");
        input.put("mass",Double.valueOf("1900000"));
        input.put("kala_number","127xie");
        input.put("price",Long.valueOf(1));
        
        
        ///make answer ready
        List expected = new ArrayList();
        expected.add(1);
        expected.add(11);
        
        ///run
        List result = rlc.compare(input);
        
        //for (Object i : expected){
        //    
        //}
        assertThat(result, is(expected));
        //assertThat(result, is(not(expected)));
    }
    
    
    
    @Test
    public void test2() throws ParseException{
        RuleController rlc = RuleController.getRuleController();
        rlc.load();
        
        ///make input ready
        Map input = new HashMap();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        input.put("cost",Long.valueOf(1900000));
        input.put("country","USA");
        input.put("date",(Date) formatter.parse("2016-06-12"));
        //input.put("date",null);
        input.put("kala_name","گندم");
        input.put("company","Jones");
        input.put("mass",Double.valueOf("1900000"));
        input.put("kala_number","127xie");
        input.put("price",Long.valueOf(1));
        
        
        ///make answer ready
        List expected = new ArrayList();
        expected.add(2);
        expected.add(11);
        
        ///run
        List result = rlc.compare(input);
        
        //for (Object i : expected){
        //    
        //}
        assertThat(result, is(expected));
        //assertThat(result, is(not(expected)));
    }
    
    
    @Test
    public void test3() throws ParseException{
        RuleController rlc = RuleController.getRuleController();
        rlc.load();
        
        ///make input ready
        Map input = new HashMap();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        input.put("cost",Long.valueOf(220000));
        input.put("country","Germany");
        input.put("date",(Date) formatter.parse("2016-06-12"));
        //input.put("date",null);
        input.put("kala_name","خودرو");
        input.put("company","BMW");
        input.put("mass",Double.valueOf("2"));
        input.put("kala_number","12r7xie");
        input.put("price",Long.valueOf("110000"));
        
        
        ///make answer ready
        List expected = new ArrayList();
        
        ///run
        List result = rlc.compare(input);
        
        //for (Object i : expected){
        //    
        //}
        assertThat(result, is(expected));
        //assertThat(result, is(not(expected)));
    }
    
    @Test
    public void test4() throws ParseException{
        RuleController rlc = RuleController.getRuleController();
        rlc.load();
        
        ///make input ready
        Map input = new HashMap();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        input.put("cost",Long.valueOf(260000));
        input.put("country","France");
        input.put("date",(Date) formatter.parse("2016-06-13"));
        //input.put("date",null);
        input.put("kala_name","خودرو");
        input.put("company","Pegeout");
        input.put("mass",Double.valueOf("2"));
        input.put("kala_number","e56r7x4e");
        input.put("price",Long.valueOf("130000"));
        
        
        ///make answer ready
        List expected = new ArrayList();
        expected.add(3);
        
        ///run
        List result = rlc.compare(input);
        
        //for (Object i : expected){
        //    
        //}
        assertThat(result, is(expected));
    }
    
    @Test
    public void test5() throws ParseException{
        RuleController rlc = RuleController.getRuleController();
        rlc.load();
        
        ///make input ready
        Map input = new HashMap();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        input.put("cost",Long.valueOf(80000));
        input.put("country","China");
        input.put("date",(Date) formatter.parse("2016-06-12"));
        //input.put("date",null);
        input.put("kala_name","nescafe");
        input.put("company","Nestele");
        input.put("mass",Double.valueOf("10000"));
        input.put("kala_number","12r7xie");
        input.put("price",Long.valueOf("8"));
        
        
        ///make answer ready
        List expected = new ArrayList();
        expected.add(4);
        
        ///run
        List result = rlc.compare(input);
        
        //for (Object i : expected){
        //    
        //}
        assertThat(result, is(expected));
    }
    
    @Test
    public void test6() throws ParseException{
       RuleController rlc = RuleController.getRuleController();
        rlc.load();
        
        ///make input ready
        Map input = new HashMap();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        input.put("cost",Long.valueOf(80000));
        input.put("country","ّIraq");
        input.put("date",(Date) formatter.parse("2016-06-12"));
        //input.put("date",null);
        input.put("kala_name","حبوبات");
        input.put("company","شافی");
        input.put("mass",Double.valueOf("10000"));
        input.put("kala_number","12r7xie");
        input.put("price",Long.valueOf("8"));
        
        
        ///make answer ready
        List expected = new ArrayList();
        expected.add(2);
        expected.add(4);
        
        ///run
        List result = rlc.compare(input);
        
        //for (Object i : expected){
        //    
        //}
        assertThat(result, is(expected)); 
    }
    
    @Test
    public void test7() throws ParseException{
        RuleController rlc = RuleController.getRuleController();
        rlc.load();
        
        ///make input ready
        Map input = new HashMap();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        input.put("cost",Long.valueOf(69000));
        input.put("country","ّIraq");
        input.put("date",(Date) formatter.parse("2016-06-12"));
        //input.put("date",null);
        input.put("kala_name","حبوبات");
        input.put("company","شافی");
        input.put("mass",Double.valueOf("10000"));
        input.put("kala_number","12r7xie");
        input.put("price",Long.valueOf("6"));
        
        
        ///make answer ready
        List expected = new ArrayList();
        expected.add(2);
        //expected.add(4);
        
        ///run
        List result = rlc.compare(input);
        
        //for (Object i : expected){
        //    
        //}
        assertThat(result, is(expected));
    }
    
    @Test
    public void test8() throws ParseException{
        RuleController rlc = RuleController.getRuleController();
        rlc.load();
        
        ///make input ready
        Map input = new HashMap();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        input.put("cost",Long.valueOf(300000));
        input.put("country","ّIreland");
        input.put("date",(Date) formatter.parse("2016-06-12"));
        //input.put("date",null);
        input.put("kala_name","سیب قرمز");
        input.put("company","Danger");
        input.put("mass",Double.valueOf("100000"));
        input.put("kala_number","12r7xie");
        input.put("price",Long.valueOf("3"));
        
        
        ///make answer ready
        List expected = new ArrayList();
        expected.add(5);
        
        
        ///run
        List result = rlc.compare(input);
        
        //for (Object i : expected){
        //    
        //}
        assertThat(result, is(expected));
    }
    
    @Test
    public void test9() throws ParseException{
        RuleController rlc = RuleController.getRuleController();
        rlc.load();
        
        ///make input ready
        Map input = new HashMap();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        input.put("cost",Long.valueOf(20000));
        input.put("country","ّIreland");
        input.put("date",(Date) formatter.parse("2016-06-12"));
        //input.put("date",null);
        input.put("kala_name","آرد");
        input.put("company","Danger");
        input.put("mass",Double.valueOf("1000"));
        input.put("kala_number","12r7xie");
        input.put("price",Long.valueOf("20"));
        
        
        ///make answer ready
        List expected = new ArrayList();
        //expected.add(6);
        
        
        ///run
        List result = rlc.compare(input);
        
        //for (Object i : expected){
        //    
        //}
        assertThat(result, is(expected));
    }
    
    @Test
    public void test10() throws ParseException{
        RuleController rlc = RuleController.getRuleController();
        rlc.load();
        
        ///make input ready
        Map input = new HashMap();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        input.put("cost",Long.valueOf(75000));
        input.put("country","ّIreland");
        input.put("date",(Date) formatter.parse("2016-06-10"));
        //input.put("date",null);
        input.put("kala_name","آرد");
        input.put("company","Danger");
        input.put("mass",Double.valueOf("150"));
        input.put("kala_number","12r7xie");
        input.put("price",Long.valueOf("500"));
        
        
        ///make answer ready
        List expected = new ArrayList();
        expected.add(4);
        
        
        ///run
        List result = rlc.compare(input);
        
        //for (Object i : expected){
        //    
        //}
        assertThat(result, is(expected));
    }
    
    @Test
    public void test11() throws ParseException{
        RuleController rlc = RuleController.getRuleController();
        rlc.load();
        
        ///make input ready
        Map input = new HashMap();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        input.put("cost",Long.valueOf(65000));
        input.put("country","Netherlands");
        input.put("date",(Date) formatter.parse("2016-06-18"));
        //input.put("date",null);
        input.put("kala_name","قیر");
        input.put("company","PetroDeutch");
        input.put("mass",Double.valueOf("5000"));
        input.put("kala_number","12r7xie");
        input.put("price",Long.valueOf("13"));
        
        
        ///make answer ready
        List expected = new ArrayList();
        expected.add(1);
        expected.add(4);
        
        
        ///run
        List result = rlc.compare(input);
        
        //for (Object i : expected){
        //    
        //}
        assertThat(result, is(expected));
    }
    
    @Test
    public void test12() throws ParseException{
        RuleController rlc = RuleController.getRuleController();
        rlc.load();
        
        ///make input ready
        Map input = new HashMap();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        input.put("cost",Long.valueOf(65000));
        input.put("country","Netherlands");
        input.put("date",(Date) formatter.parse("2016-12-19"));
        //input.put("date",null);
        input.put("kala_name","قیر");
        input.put("company","PetroDeutch");
        input.put("mass",Double.valueOf("5000"));
        input.put("kala_number","12r7xie");
        input.put("price",Long.valueOf("13"));
        
        
        ///make answer ready
        List expected = new ArrayList();
        expected.add(1);
        //expected.add(4);
        
        
        ///run
        List result = rlc.compare(input);
        
        //for (Object i : expected){
        //    
        //}
        assertThat(result, is(expected));
    }
    
    @Test
    public void test13() throws ParseException{
        RuleController rlc = RuleController.getRuleController();
        rlc.load();
        
        ///make input ready
        Map input = new HashMap();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        input.put("cost",Long.valueOf(4500));
        input.put("country","Netherlands");
        input.put("date",(Date) formatter.parse("2016-06-21"));
        //input.put("date",null);
        input.put("kala_name","Iphone6");
        input.put("company","Apple");
        input.put("mass",Double.valueOf("10"));
        input.put("kala_number","12r7xie");
        input.put("price",Long.valueOf("450"));
        
        
        ///make answer ready
        List expected = new ArrayList();
        //expected.add(1);
        //expected.add(4);
        
        
        ///run
        List result = rlc.compare(input);
        
        //for (Object i : expected){
        //    
        //}
        assertThat(result, is(expected));
    }
    
    @Test
    public void test14() throws ParseException{
        RuleController rlc = RuleController.getRuleController();
        rlc.load();
        
        ///make input ready
        Map input = new HashMap();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        input.put("cost",Long.valueOf(45000));
        input.put("country","Netherlands");
        input.put("date",(Date) formatter.parse("2016-06-21"));
        //input.put("date",null);
        input.put("kala_name","Iphone6");
        input.put("company","Apple");
        input.put("mass",Double.valueOf("100"));
        input.put("kala_number","12r7xie");
        input.put("price",Long.valueOf("450"));
        
        
        ///make answer ready
        List expected = new ArrayList();
        expected.add(7);        
        
        ///run
        List result = rlc.compare(input);
        
        
        assertThat(result, is(expected));
    }
    
    @Test
    public void test15() throws ParseException{
        RuleController rlc = RuleController.getRuleController();
        rlc.load();
        
        ///make input ready
        Map input = new HashMap();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        input.put("cost",Long.valueOf(45000));
        input.put("country","Netherlands");
        input.put("date",(Date) formatter.parse("2016-06-21"));
        //input.put("date",null);
        input.put("kala_name","Iphone5");
        input.put("company","Apple");
        input.put("mass",Double.valueOf("100"));
        input.put("kala_number","12r7xie");
        input.put("price",Long.valueOf("450"));
        
        
        ///make answer ready
        List expected = new ArrayList();
        expected.add(7);
        expected.add(8);        
        
        ///run
        List result = rlc.compare(input);
        
        
        assertThat(result, is(expected));
    }
    
    @Test
    public void test16() throws ParseException{
        RuleController rlc = RuleController.getRuleController();
        rlc.load();
        
        ///make input ready
        Map input = new HashMap();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        input.put("cost",Long.valueOf(3150));
        input.put("country","Netherlands");
        input.put("date",(Date) formatter.parse("2016-06-21"));
        //input.put("date",null);
        input.put("kala_name","Iphone5");
        input.put("company","Apple");
        input.put("mass",Double.valueOf("7"));
        input.put("kala_number","12r7xie");
        input.put("price",Long.valueOf("450"));
        
        
        ///make answer ready
        List expected = new ArrayList();
        expected.add(8);        
        
        ///run
        List result = rlc.compare(input);
        
        
        assertThat(result, is(expected));
    }
    
    @Test
    public void test17() throws ParseException{
        RuleController rlc = RuleController.getRuleController();
        rlc.load();
        
        ///make input ready
        Map input = new HashMap();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        input.put("cost",Long.valueOf(50400));
        input.put("country","Netherlands");
        input.put("date",(Date) formatter.parse("2016-06-21"));
        //input.put("date",null);
        input.put("kala_name","Iphone5");
        input.put("company","Apple");
        input.put("mass",Double.valueOf("702"));
        input.put("kala_number","12r7xie");
        input.put("price",Long.valueOf("700"));
        
        
        ///make answer ready
        List expected = new ArrayList();
        expected.add(4);
        expected.add(7);
        expected.add(8);        
        
        ///run
        List result = rlc.compare(input);
        
        
        assertThat(result, is(expected));
    }
    
    @Test
    public void test18() throws ParseException{
        RuleController rlc = RuleController.getRuleController();
        rlc.load();
        
        ///make input ready
        Map input = new HashMap();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        input.put("cost",Long.valueOf(60000));
        input.put("country","Korea");
        input.put("date",(Date) formatter.parse("2016-06-21"));
        //input.put("date",null);
        input.put("kala_name","side A23");
        input.put("company","Samsung");
        input.put("mass",Double.valueOf("50"));
        input.put("kala_number","refx821");
        input.put("price",Long.valueOf("1200"));
        
        
        ///make answer ready
        List expected = new ArrayList();
        expected.add(4);
        expected.add(9);        
        
        ///run
        List result = rlc.compare(input);
        
        
        assertThat(result, is(expected));
    }
    
    @Test
    public void test19() throws ParseException{
        RuleController rlc = RuleController.getRuleController();
        rlc.load();
        
        ///make input ready
        Map input = new HashMap();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        input.put("cost",Long.valueOf(60000));
        input.put("country","Korea");
        input.put("date",(Date) formatter.parse("2016-06-21"));
        //input.put("date",null);
        input.put("kala_name","refrigerator x13");
        input.put("company","LG");
        input.put("mass",Double.valueOf("60"));
        input.put("kala_number","refx821");
        input.put("price",Long.valueOf("1000"));
        
        
        ///make answer ready
        List expected = new ArrayList();
        expected.add(4);
        expected.add(9);        
        
        ///run
        List result = rlc.compare(input);
        
        
        assertThat(result, is(expected));
    }
    
    @Test
    public void test20() throws ParseException{
        RuleController rlc = RuleController.getRuleController();
        rlc.load();
        
        ///make input ready
        Map input = new HashMap();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        input.put("cost",Long.valueOf(100000));
        input.put("country","Korea");
        input.put("date",(Date) formatter.parse("2016-06-21"));
        //input.put("date",null);
        input.put("kala_name","refrigerator x12");
        input.put("company","LG");
        input.put("mass",Double.valueOf("100"));
        input.put("kala_number","refx821");
        input.put("price",Long.valueOf("1000"));
        
        
        ///make answer ready
        List expected = new ArrayList();
        expected.add(9);
        expected.add(10);        
        
        ///run
        List result = rlc.compare(input);
        
        
        assertThat(result, is(expected));
    }
    
    @Test
    public void test21() throws ParseException{
        RuleController rlc = RuleController.getRuleController();
        rlc.load();
        
        ///make input ready
        Map input = new HashMap();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        input.put("cost",Long.valueOf(100000));
        input.put("country","Vietnam");
        input.put("date",(Date) formatter.parse("2016-06-21"));
        //input.put("date",null);
        input.put("kala_name","refrigerator x12");
        input.put("company","LG");
        input.put("mass",Double.valueOf("100"));
        input.put("kala_number","refx821");
        input.put("price",Long.valueOf("1000"));
        
        
        ///make answer ready
        List expected = new ArrayList();
        expected.add(9);
        //expected.add(10);        
        
        ///run
        List result = rlc.compare(input);
        
        
        assertThat(result, is(expected));
    }
    
    @Test
    public void test22() throws ParseException{
        RuleController rlc = RuleController.getRuleController();
        rlc.load();
        
        ///make input ready
        Map input = new HashMap();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        input.put("cost",Long.valueOf(999999));
        input.put("country","USA");
        input.put("date",(Date) formatter.parse("2010-06-21"));
        //input.put("date",null);
        input.put("kala_name","car f5");
        input.put("company","FIAT");
        input.put("mass",Double.valueOf("1"));
        input.put("kala_number","rdjx8301");
        input.put("price",Long.valueOf("999999"));
        
        
        ///make answer ready
        List expected = new ArrayList();
        //expected.add(9);
               
        
        ///run
        List result = rlc.compare(input);
        
        
        assertThat(result, is(expected));
    }
    
    @Test
    public void test23() throws ParseException{
        RuleController rlc = RuleController.getRuleController();
        rlc.load();
        
        ///make input ready
        Map input = new HashMap();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        input.put("cost",Long.valueOf(999999000));
        input.put("country","USA");
        input.put("date",(Date) formatter.parse("2019-06-21"));
        //input.put("date",null);
        input.put("kala_name","car f5");
        input.put("company","FIAT");
        input.put("mass",Double.valueOf("1000"));
        input.put("kala_number","rdjx8301");
        input.put("price",Long.valueOf("999999"));
        
        
        ///make answer ready
        List expected = new ArrayList();
        expected.add(11);
               
        
        ///run
        List result = rlc.compare(input);
        
        
        assertThat(result, is(expected));
    }
    
    @Test
    public void test24() throws ParseException{
      RuleController rlc = RuleController.getRuleController();
        rlc.load();
        
        ///make input ready
        Map input = new HashMap();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        input.put("cost",Long.valueOf(1500));
        input.put("country","Singapore");
        input.put("date",(Date) formatter.parse("2019-06-21"));
        //input.put("date",null);
        input.put("kala_name","x6 Gold");
        input.put("company","HTC");
        input.put("mass",Double.valueOf("1"));
        input.put("kala_number","mob23");
        input.put("price",Long.valueOf("1500"));
        
        
        ///make answer ready
        List expected = new ArrayList();
        //expected.add(12);
               
        
        ///run
        List result = rlc.compare(input);
        
        
        assertThat(result, is(expected));  
    }
    
    @Test
    public void test25() throws ParseException{
        RuleController rlc = RuleController.getRuleController();
        rlc.load();
        
        ///make input ready
        Map input = new HashMap();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        input.put("cost",Long.valueOf(20000));
        input.put("country","Singapore");
        input.put("date",(Date) formatter.parse("2019-06-21"));
        //input.put("date",null);
        input.put("kala_name","x7 Gold");
        input.put("company","HTC");
        input.put("mass",Double.valueOf("2"));
        input.put("kala_number","mob23");
        input.put("price",Long.valueOf("10000"));
        
        
        ///make answer ready
        List expected = new ArrayList();
        expected.add(12);
               
        
        ///run
        List result = rlc.compare(input);
        
        
        assertThat(result, is(expected));
    }
}
