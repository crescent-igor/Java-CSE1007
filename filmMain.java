import java.util.*;

class film{
    String name,lang,lead,category;
    int duration;
    film(){
        System.out.println("Default constructor");
    }
    film(String n, String l, String le, String cat, int d){
        System.out.println("Parametrized constructor");
        this.name = n;
        this.lang = l;
        this.lead = le;
        this.category = cat;
        this.duration = d;
        System.out.println("Name: "+this.name);
        System.out.println("Language: "+this.lang);
        System.out.println("Lead Actor: "+this.lead);
        System.out.println("Category: "+this.category);
        System.out.println("Duration: "+this.duration);
    }
    public void get(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter details:");
        this.name = sc.next();
        this.lang = sc.next();
        this.lead = sc.next();
        this.category = sc.next();
        this.duration = sc.nextInt();
    }
    public void display(){
        System.out.println("Name: "+this.name);
        System.out.println("Language: "+this.lang);
        System.out.println("Lead Actor: "+this.lead);
        System.out.println("Category: "+this.category);
        System.out.println("Duration: "+this.duration);
    }

}
class filmMain{
    public static void main(String args[]){
        film f = new film();
        film f1 = new film("titanic","english","Kate Winslet","Romance",2);
        f.get();
        f.display();
    }
}