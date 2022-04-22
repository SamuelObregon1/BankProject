import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;


public class Bankaccount extends Person {
	private static int accountNum =0;
	private int AccountNumber;
	private float balance;
	private double intrest_rate;
	private ArrayList<Person> Holder = new ArrayList<>();
	public Bankaccount(){
		balance = 0;
		intrest_rate = 5.0;
		AccountNumber= ++accountNum;
	}
	public Bankaccount(String f,String l,String a,int s,int ac ,float b){
		super( f, l, a, s);
		AccountNumber++;
		balance = b;
		//intrest_rate= i;
	}
	public int getAccountNumber() {
		return AccountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.AccountNumber = accountNumber;
	}

	public void setHolder(ArrayList<Person> holder) {
		Holder = holder;
	}
	public ArrayList<Person> getHolder() {
		return Holder;
	}
	public static int getAccountNum() {
		return accountNum;
	}
	public static void setAccountNum(int accountNum) {
		Bankaccount.accountNum = accountNum;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	public double getIntrest_rate() {
		return intrest_rate;
	}
	public void setIntrest_rate(double intrest_rate) {
		this.intrest_rate = intrest_rate;
	}
	public void payintrest(float i){
		setBalance(getBalance()*i*12);
		System.out.println("Your new balance is "+balance);
	}
	public void depoist(float d){
		if(d<0){
			System.out.println("can deposit negative numbers");
		}
		else {
			setBalance(getBalance()+d);
		}
	}
	public void withdraw(float w){

		if(getBalance() <0){
			System.out.println("you dont have the cash");
		}else if(getBalance() <w){
			System.out.print("ERROR! you cant withdraw more than what you have ");
		}else{
			System.out.println("Successfully withdrawal "+w);
			//System.out.print("Current Balance: " );
			setBalance(getBalance()-w);
		}
	}
	// Note to self always spell toString() with a capital S because in abstract collections this caused an error in displaying
	public String toString(){
		String str ="Account Number: "+  this.getAccountNumber()+ "\n" +super.toString()+ "\n"+" Current balance: "+"$"+balance+"\n";
		return str;
	}

	public void readBalance(Scanner kb) {
		System.out.print("Enter Current Balance: ");
		float b = kb.nextFloat();
		setBalance(b);
	}
	public void addholder(Person p) {
		Scanner kb = new Scanner(System.in);
		p.read(kb);

		Holder.add(p);

	}
}
