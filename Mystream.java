package helloworld;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Comparator;



class Stock implements Comparable<Stock>{
	int id;
	String name;
	int price;
	double marcap;
	double debt;
	String sector;
	
	public Stock(int id,String name,int price,double marcap,double debt,String sector) {
		this.id=id;
		this.name=name;
		this.price=price;
		this.marcap=marcap;
		this.debt=debt;
		this.sector=sector;
	}
	
	public int getid() {
		return id;
	}
	public int getprice() {
		return price;
	}
	public double marcap() {
		return marcap;
	}
	public double debt() {
		return debt;
	}
	public String name() {
		return name;
	}
	public String sector() {
		return sector;
	}
	@Override
	public String toString() {
		return "Student1 [id=" + id + ", name=" + name + ", price=" + price + ", marketcapital=" + marcap + " ,Debt=" + debt + " ,sector=" + sector + "]";	
}

	@Override
	public int compareTo(Stock o) {
		if(this.id>o.getprice())
		{
		return 1;
		}
		else if(this.id<o.getprice())
		{
		return -1;
		}
		else
		{
		return 0;
		}

		
	}
}

	


public class Mystream {
	public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
	    Set<Object> seen = ConcurrentHashMap.newKeySet();
	    return t -> seen.add(keyExtractor.apply(t));
	}
	public static void main(String argus[]) {
		
			List<Stock> s = new ArrayList<Stock>();
			s.add(new Stock(32,"MRF",78000,4423.3,874.3,"TYER"));
			s.add(new Stock(1,"BAJAJ FINSERV",9234,44323.3,874.3,"FINACE"));
			s.add(new Stock(12,"TATA MOTOR",900,1533.3,374.3,"AUTOMOBLIES"));
			s.add(new Stock(54,"BAJAJ AUTO",2000,1234.32,104.3,"BIKES"));
			s.add(new Stock(62,"ZEE",500,4423.3,874.3,"ENTERIENMENT"));
			s.add(new Stock(823,"INFOSYS",1202,3423.3,1004.3,"SOFTWARE"));
			s.add(new Stock(232,"TCS",2123,4423.23,933.23,"SOFTWARE"));
			s.add(new Stock(432,"APPOLO TYRE",400,2345.34,434.3,"TYER"));
			s.add(new Stock(872,"REDDYMED",1274,2343.94,244.3,"MEDICAL"));
			s.add(new Stock(134,"PAYTM",734,982.32,874.3,"FINACE"));
			s.add(new Stock(98,"ITC",224,1232.23,324.4,"TOBACOO"));
			// displaying entire stock 
			for(Stock a:s) {
				System.out.println(a);
			}
			
			//count
			long count = s.stream().count();
			System.out.println("\n no of stocks in \n "+count);
			//filering out name of stock which price are more than 1000
			System.out.println("\n***** name of stock which  price are more than 1000******\n");
			s.stream().filter(i->i.getprice()>1000).forEach(names->System.out.println(names.name()));
			//filtering out name of stock which debt price are less than 200
			System.out.println("\n***** name of stock which debt price are less than 200******\n");
			s.stream().filter(i->i.debt()<300).forEach(hi->System.out.println(hi.name()));
			//map the sector to lowercase in stock and converting it into List of String using Collector
			System.out.println("\n*****using map for sector name in lowercase\n");
			List<String> oo=s.stream().distinct().map(ma->ma.sector().toLowerCase()).collect(Collectors.toList());
			oo.forEach(j->System.out.println(j));
			//distinct 
			System.out.println("\n*******using distinct for sector name\n");
			s.stream().filter(distinctByKey(e->e.sector())).forEach(kk->System.out.println(kk.sector()));;
			//using max we find highest price name of stock 
			System.out.println("\n******highest price name of stock****\n");
			Optional<Integer> hs = s.stream().map(v->v.getprice()).max((a,b)->a.compareTo(b));
			s.stream().filter(i->i.getprice()==hs.get()).forEach(u->System.out.println(u.name()+" == "+hs.get()));
			//using min we find lowest price name of stock
			System.out.println("\n*****lowest price name of stock****\n");
			Optional<Integer> ie = s.stream().map(v->v.getprice()).min((a,b)->a.compareTo(b));
			s.stream().filter(i->i.getprice()==ie.get()).forEach(u->System.out.println(u.name()+" == "+ie.get()));
			//sorting the stock with price
			System.out.println("\n******sorting stock accoring to it's price\n");
			List<Stock> ls3=s.stream().sorted().collect(Collectors.toList());
			ls3.forEach(s2->System.out.println(s2));
			
			
	}
}
