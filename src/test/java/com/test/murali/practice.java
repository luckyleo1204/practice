package com.test.murali;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.*;
import java.util.stream.Collectors;

public class practice {
   static WebDriver driver;
    @Test(enabled = true)
    public void test1() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","/Users/muralic/Desktop/selenium/driver/chromedriver");
        driver=new ChromeDriver();
        driver.get("https://money.rediff.com/gainers/bse/daily/groupa?src=gain_lose");
        String comapny="V-Mart Retail";
        //printPercentageChange(comapny);
        printPercentageGreaterThanGiven(5.00);
        Thread.sleep(5000);
        driver.quit();
    }

    @Test(enabled=true)
    public void test2() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","/Users/muralic/Desktop/selenium/driver/chromedriver");
        driver=new ChromeDriver();
        driver.get("https://www.guru99.com/");
        Thread.sleep(5000);
        String course="SAP";
        printSectionofGuru99(course);
        driver.quit();

    }

    @Test(enabled=false)
    public void test3(){
        System.setProperty("webdriver.chrome.driver","/Users/muralic/Desktop/selenium/driver/chromedriver");
        driver=new ChromeDriver();
        driver.get("https://demo.guru99.com/test/guru99home/");

        //Search element inside 'Popular course' which are sibling of control 'SELENIUM' ,Here first we will find a h2 whose text is ''A few of our most popular courses' ,then we move to its parent element which is a 'div' , inside this div we will find a link whose text is 'SELENIUM' then at last we will find all of the sibling elements of this link('SELENIUM')

        List <WebElement> dateBox = driver.findElements(By.xpath("//h2[contains(text(),'A few of our most popular courses')]/parent::div//div[//a[text()='SELENIUM']]/following-sibling::div[@class='rt-grid-2 rt-omega']"));

        //Print all the which are sibling of the the element named as 'SELENIUM' in 'Popular course'
        for (WebElement webElement : dateBox) {
            System.out.println(webElement.getText());
        }
        driver.close();
    }

    @Test(enabled = true)
    public void test7(){
        System.setProperty("webdriver.chrome.driver","/Users/muralic/Desktop/selenium/driver/chromedriver");
        driver=new ChromeDriver();
        driver.get("https://demo.guru99.com/test/guru99home/");
        printAlltheFollowing("Selenium");
    }

    @Test
    public void test4() {
        String a[] = {"Sachin_ind", "Nathan_aus", "Ashwin_ind"};
        Map<String, List<String>> map = new HashMap<>();
        List<String> l=new ArrayList<>();
        String b[]=null;
        for (int i = 0; i < a.length-1; i++) {
             b= a[i].split("_");
            if(map.containsKey(b[1])){
               // map.put(b[1],l.add(b[0]));
            }else{
                map.put(b[1],new ArrayList<>());
              //  map.get(b[1].add(b[0]));
            }
        }
//        Set<String> set1 = map.keySet();
//        Map<String, Integer> map1 = new HashMap<>();
//        for (String i : set1) {
//            if (map1.containsKey(i) == true) {
//                map1.put(i, map1.get(i) + 1);
//            } else {
//                map1.put(i, 1);
//            }
//        }
//        Set<String> set2=map.keySet();
//        for(String j:set2)
//            System.out.println(j+":"+map1.get(j));





    }

    @Test
    public void test6(){

           // Scanner sc=new Scanner(System.in);
            String A="java";
            String B="hello";

            System.out.println(A.length()+B.length());
            System.out.println(mcompare(A,B));
            System.out.print(A.substring(0,1).toUpperCase()+A.substring(1)+" "+
                    B.substring(0,1).toUpperCase()+B.substring(1));

        }

    @Test(enabled = false)
    public void test5(){
        Student s1 = new Student("Ram", "1", "Tennis");
        Student s2 = new Student("John", "3", "Caroms");
        Student s3 = new Student("John", "1", "Tennis");
        Student s4 = new Student("Neha", "3", "Caroms");
        Student s5 = new Student("Ram", "4", "Cricket");
        Student s6 = new Student("Ram", "2", "Chess");

        List<Student> l = new ArrayList<Student>(Arrays.asList(s1,s2,s3,s4,s5,s6));
        HashMap<String, List<String>> hm = new HashMap<String, List<String>>();

        for(Student s : l) {
            if (hm.containsKey(s.name)) {
                hm.get(s.name).add(s.sportId+"-"+s.sport);
            } else {
                hm.put(s.name, new ArrayList<String>());
                hm.get(s.name).add(s.sportId+"-"+s.sport);
            }
        }
        System.out.println(hm);

    }


    @Test
    public void sortBySteamInteger(){
        List<Integer> al=Arrays.asList(11,2,5,6,9,1);
        List<Integer> al2=al.stream()
                .sorted()
                .collect(Collectors.toList());
        al2.forEach(n-> System.out.print(n+"\t"));
    }

    @Test
    public void SortObject(){
        List<Player> players=Arrays.asList(
                new Player(10,"Murali",200.25,1),
                new Player(2,"Harshi",999.99,23),
                new Player(33,"Kushi",200.25,7),
                new Player(9,"Zen",99.99,9)
        );

       List<Player> sortByID= players.stream().sorted((p1,p2) -> p1.getId()-p2.getId()).collect(Collectors.toList());

        sortByID.forEach(n-> System.out.println(n+"\t"));

        System.out.println("=================================\n");
        List<Player> sortByName=players.stream().sorted((p1,p2) ->p1.getName().compareTo(p2.getName()))
                .collect(Collectors.toList());
        sortByName.forEach(n-> System.out.println(n+"\t"));

        System.out.println("=================================\n");
        List<Player> sortByRank=players.stream().sorted((p1,p2)->Integer.compare(p1.getRank(),p2.getRank()))
                .collect(Collectors.toList());
        sortByRank.forEach(n-> System.out.println(n+"\t"));

        System.out.println("===============ReverseList============");
        List<Player> sortByIDRev= players.stream().sorted((p1,p2) -> p2.getId()-p1.getId()).collect(Collectors.toList());

        sortByIDRev.forEach(n-> System.out.println(n+"\t"));
        System.out.println("=================================\n");
        List<Player> sortByNameRev=players.stream().sorted((p1,p2) ->p2.getName().compareTo(p1.getName()))
                .collect(Collectors.toList());
        sortByNameRev.forEach(n-> System.out.println(n+"\t"));

        System.out.println("=================================\n");
        List<Player> sortByRankRev=players.stream().sorted((p1,p2)->Integer.compare(p2.getRank(),p1.getRank()))
                .collect(Collectors.toList());
        sortByRankRev.forEach(n-> System.out.println(n+"\t"));
    }

    @Test
    public void sortByStreamString(){
        List<String> al=Arrays.asList("Murali","Kavitha","Harshith","Zen","Apple");
       List<String> al2= al.stream().sorted().collect(Collectors.toList());
       al2.forEach(n-> System.out.print(n+"\t"));
    }

    @Test
    public void removeDuplicate() {
        List<String> al = Arrays.asList("Murali", "Kavitha", "Apple", "Harshith", "Zen", "Apple", "Kavitha", "Murali");
        List<String> al2 = al.stream().distinct().collect(Collectors.toList());
        al2.forEach(n -> System.out.print(n + "\t"));
        System.out.println("\n============================\n");
        Set<String> al3 = al.stream().distinct().collect(Collectors.toSet());
        al3.forEach(n -> System.out.print(n + "\t"));
        System.out.println("\n===========Print in Reverse Order===============\n");
        List<String> al4 = al.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        al4.forEach(n -> System.out.print(n + "\t"));
    }


    class Player {

        // private member variables
        private int id;
        private String name;
        private double average;
        private int rank;

        public Player(int id, String name, double average, int rank) {
            this.id = id;
            this.name = name;
            this.average = average;
            this.rank = rank;
        }

        @Override
        public String toString() {
            return "Player{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", average=" + average +
                    ", rank=" + rank +
                    '}';
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getAverage() {
            return average;
        }

        public void setAverage(double average) {
            this.average = average;
        }

        public int getRank() {
            return rank;
        }

        public void setRank(int rank) {
            this.rank = rank;
        }
    }

    class Student {

        String name;
        String sport;
        String sportId;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSportId() {
            return sportId;
        }

        public void setSportId(String sportId) {
            this.sportId = sportId;
        }

        public String getSport() {
            return sport;
        }

        public void setSport(String sport) {
            this.sport = sport;
        }

        Student(String name, String sportId, String sport) {
            this.name = name;
            this.sportId = sportId;
            this.sport = sport;
        }

    }

    public static void printPercentageChange(String company){
        List<WebElement> al=driver.findElements(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr"));
        for(int i=1;i<al.size();i++) {
            if(al.get(i).findElement(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr["+i+"]/td[1]")).getText().equals(company)){
                System.out.println(al.get(i).findElement(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr["+i+"]/td[5]")).getText());
                break;
            }
        }
    }

    public static void printPercentageGreaterThanGiven(double percent){
        List<WebElement> al=driver.findElements(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr"));
        Map<String, Double> map=new HashMap<>();
        for(int i=1;i<al.size();i++) {
            String s[]=al.get(i).findElement(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr["+i+"]/td[5]")).getText().split("\\+");
            double x= Double.parseDouble(s[1]);
            if(x>percent){
               // System.out.println((al.get(i).findElement(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr["+i+"]/td[1]")).getText());
                map.put(al.get(i).findElement(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr["+i+"]/td[1]")).getText(),x);
            }
        }
        for(String k : map.keySet()){
            System.out.println("Key  :"+ k+"\tValue  :"+map.get(k));
        }
    }

    public static void printSectionofGuru99(String course){
        List<WebElement> al=driver.findElements(By.xpath("//h4/b[text()='"+course+"']//following::ul[1]/li"));
        for(WebElement i: al){
            System.out.println(i.getText());
        }
    }

    public static void printAlltheFollowing(String Name){
        List<WebElement> al=driver.findElements(By.xpath("//h2[contains(text(),'A few of our most popular courses')]/parent::div//div[//a[text()='SELENIUM']]/following-sibling::div[@class='rt-grid-2 rt-omega']"));
        al.forEach(a->System.out.print(a.getText()+"\t"));
    }
    public static String mcompare(String a, String b){
        String flag="No";
        if(a.length()!=b.length()){
            flag="No";
            return flag;
        }
        else{
            flag="yes";
            return flag;
        }

    }

}
