package bigUnsignedNumber;

/**
 * File Name: Cstring.java 
 * Implements C String
 * 
 * @author Jagadeesh Vasudevamurthy
 * @year 2016
 */
/*
 * To compile you require: CharArray.java, IntUtil.java RandomInt.java Cstring.java
 */

class Cstring {
  private CharArray d; //Infinite array of char
  static IntUtil u = new IntUtil();
  //YOU CANNOT add any data members
  //YOU CAN add any public or private function so that all the tests will pass
  
  public Cstring(){
	  d = new CharArray();
	  d.set(0, '\0');
  }
  
  public Cstring(char c){
	  d = new CharArray();
	  d.set(0, c);
	  d.set(1, '\0');
  }
  
  public Cstring(String s){
	  d = new CharArray();
	  
	  int counter;
	  
	  for ( counter = 0; counter < s.length(); ++counter){
		  d.set(counter, s.charAt(counter));
	  }
	  d.set(counter, '\0');
  }
  
  public void pLn(String s){
	  int counter = 0;
	  
	  System.out.print(s);
	  
	  do {
		  System.out.print(d.get(counter));
		  ++counter;
	  } while (d.get(counter) != '\0');
	  
	  System.out.println();
  }
  
  public char getCharAtIndex(int index){
	  
	  return d.get(index);
  }
  
  public void setToIndex(int index, char val){
	  d.set(index, val);
  }
  
  public Cstring clone(){
	  
	  Cstring cloneArray = new Cstring();
	  
	  int counter = 0;
	  
	  do{
		  
		  cloneArray.d.set(counter, d.get(counter));
		  counter++;
	  }while(d.get(counter) != '\0');
	  
	  cloneArray.d.set(counter, '\0');
	  return cloneArray;
  }
  
  public void reverse(){
	  int len = 0;
	  int counter = 0;
	  int backCounter = 0;
	  
	  //First Find the length
	  do {
		  backCounter++;
	  } while (d.get(backCounter) != '\0');
	  
	  len = backCounter;
	  
	  while (counter <= len /2 ){
		  d.swap(counter, backCounter);
		  counter++;
		  backCounter--;
	  }
	  
  }
  
  //Adding in Cstring Type
  public Cstring add(Cstring s){
	  Cstring tempArray = new Cstring();
	  
	  int counterFirstArray = 0;
	  int counterSecondArray = 0;
	  int counterTempArray = 0;
	  
	  //Find the length of First Array.
	  //Set the beginning of the second Array to the end of first Array
	  //Set the values of temp array from the first array
	  do {
		  tempArray.d.set(counterTempArray, d.get(counterFirstArray));
		  counterFirstArray++;
		  counterTempArray++;
	  } while(d.get(counterFirstArray) != '\0');
	  
	  //Now extend the TempArray with secondArray
	  do {
		  tempArray.d.set(counterTempArray, s.d.get(counterSecondArray));
		  counterSecondArray++;
		  counterTempArray++;
	  } while(s.d.get(counterSecondArray) != '\0');
	  
	  tempArray.d.set(counterTempArray, '\0');
	  
	  return tempArray;
	  
  }
  
  //Adding in String Type
  public Cstring add(String s){
	  Cstring tempArray = new Cstring();
	  
	  int counterFirstArray = 0;
	  int counterSecondArray = 0;
	  int counterTempArray = 0;
	  
	  //Find the length of First Array.
	  //Set the beginning of the second Array to the end of first Array
	  //Set the values of temp array from the first array
	  do {
		  tempArray.d.set(counterTempArray, d.get(counterFirstArray));
		  counterFirstArray++;
		  counterTempArray++;
	  } while(d.get(counterFirstArray) != '\0');
	  
	  //Now extend the TempArray with Given String
	  for (counterSecondArray = 0 ; counterSecondArray < s.length(); counterSecondArray++){
		  tempArray.d.set(counterTempArray, s.charAt(counterSecondArray));
		  counterTempArray++;
	  }
	  
	  tempArray.d.set(counterTempArray, '\0');
	  
	  return tempArray;	  
  }
  
  //Appending in Cstring type
  public void append(Cstring s){
	  
	  int counterFirstArray = 0;
	  int counterSecondArray = 0;
	  
	  //Finding the length of the initial array;
	  do {
		  counterFirstArray++;
	  } while (d.get(counterFirstArray) != '\0');
	  
	  
	  do {
		  d.set(counterFirstArray, s.d.get(counterSecondArray));
		  counterFirstArray++;
		  counterSecondArray++;
	  } while (s.d.get(counterSecondArray) != '\0');
	  
	  d.set(counterFirstArray, '\0');
  }
  
  //Appending in String type
  public void append(String s){
	  
	  int counterFirstArray = 0;
	  int counterSecondArray = 0;
	  
	  //Finding the length of the initial array;
	  do {
		  counterFirstArray++;
	  } while (d.get(counterFirstArray) != '\0');
	  
	  
	  for( counterSecondArray = 0; counterSecondArray < s.length(); counterSecondArray++){
		  d.set(counterFirstArray, s.charAt(counterSecondArray));
		  counterFirstArray++;
	  }
	  
	  d.set(counterFirstArray, '\0');
  }
  
  public int counter(){
	  int count = 0;
	  
	  //Finding the length of the initial array;
	  do {
		  count++;
	  } while (d.get(count) != '\0');
	  
	  return count;
	  
  }
  
  public boolean isEqual(Cstring s){
	  int counterFirstArray = 0;
	  int counterSecondArray = 0;
	  
	  boolean status = true;
	  
	  //First compare the lengths of First and Second Arrays
	  
	  //Length of First Array
	  do {
		  counterFirstArray++;
	  } while (d.get(counterFirstArray) != '\0');
	  
	//Length of Second Array
	  do {
		  counterSecondArray++;
	  } while (d.get(counterSecondArray) != '\0');
	  
	  if(counterFirstArray != counterSecondArray){
		  status = false;
		  return status;
	  } else {
		  //If lengths of two Cstrings are equal. 
		  // Compare the values one by one
		  for (int i = 0; i < counterFirstArray; i++){
			  if(d.get(i) != s.d.get(i)){
				  status = false;
				  return status;
			  }
		  }
	  }
	  return status;
  }
  
 public Cstring sum(Cstring big){
	  
	  int count = 0;
	  int countFirstArray = 0;
	  int countSecondArray = 0;
	  // int lastCounter = 0;
	  
	  //BigUnsignedNumber newB = new BigUnsignedNumber();
	  
	  Cstring firstS = new Cstring();
	  Cstring secondS = new Cstring();
	  Cstring addedS = new Cstring();
	  
	  //Compare the lengths of the Cstrings
	  /*do{
		  countFirstArray++;
	  }while(d.getCharAtIndex(countFirstArray) != '\0');
	  
	  do{
		  countSecondArray++;
	  }while(big.d.getCharAtIndex(countSecondArray) != '\0');*/
	  
	  countFirstArray = this.counter();
	  countSecondArray = big.counter();
	  
	  //newB = big;
	  
	  //reverse it to make a proper sum
	  // note in the final we need to reverse the sum again.
	  //big.reverse();
	  //this.reverse();
	  
	  //set the bigger one to firstS
	  if(countFirstArray >= countSecondArray){
		  secondS = big.clone();
		  firstS = this.clone();
	  } else {
		  firstS = big.clone();
		  secondS = this.clone();
	  }
	  
	  int excessElement = 0;
	  
	  
	  //Might be better to change to while loop
	  do {
		  //start from first index NOT from 0!
		  count++;
		  
		  // when the short array hits the maximum number
		  // long array still need value to sum thats why I converted it to 0
		  if(secondS.getCharAtIndex(count) == '\0'){
			  secondS.setToIndex(count, '0');
			  
			  if(firstS.getCharAtIndex(count) == '\0'){
				  // break;
				  if (excessElement == 0){
					  break; 
				  } else {
					  addedS.setToIndex(count, (char)(excessElement+'0'));
					  break;
				  }
			  }			  
		  }
		  
		  int c1 = (char)(firstS.getCharAtIndex(count)-'0');
		  int c2 = (char)(secondS.getCharAtIndex(count)-'0');
		  	  
		  int sum = c1+c2+excessElement;
		  
		  if (sum >= 10){
			  excessElement = sum/10; //			  
			  sum = sum%10; //take the last digit
		  } else {
			  excessElement = 0;
		  }
		  
		  addedS.setToIndex(count, (char)(sum+'0'));
		  
	  } while(firstS.getCharAtIndex(count) != '\0');
	  
	  //Reverse again to the original
	  //addedS.reverse();
	  //big.d.reverse();
	  //this.d.reverse();
	  
	  
	  //Add the items to BigUnsignedNumber
	  //finding the length of added Sum
	 /*do{
		 newB.setToIndex(lastCounter, addedS.getCharAtIndex(lastCounter));
		  lastCounter++;
	  } while (addedS.getCharAtIndex(lastCounter) != '\0');*/
	  
	  //return newB;
	  return addedS;
  }
 
 //NOTHING CAN BE CHANGED BELOW. EVERYTHING MUST WORK AS IS
  private static void testBasic() {
    Cstring a = new Cstring('b') ;
    a.pLn("a = ") ;
    Cstring b = new Cstring('7') ;
    b.pLn("b = ") ;
    Cstring c = new Cstring("123456789012345678901234567890123456789012345678901234567890") ;
    c.pLn("c = ") ;
    Cstring d = c.clone() ;
    d.pLn("d = ") ;
    Cstring e = new Cstring("A quick brown fox junped over a lazy dog") ;
    e.pLn("e = ") ;
    Cstring f = new Cstring("Gateman sees name garageman sees nametag") ;
    f.pLn("f =  ") ;
    f.reverse() ;
    f.pLn("f' = ") ;
  }
  
  private static void testAdd() {
    Cstring a = new Cstring("UCSC") ;
    Cstring b = new Cstring("Extension") ;
    Cstring c = a.add(b) ;
    a.pLn("a = ") ;
    b.pLn("b = ") ;
    c.pLn("c = ") ;
    Cstring d = c.add("USA") ;
    d.pLn("d = ") ;
    a.append(b) ;
    a.pLn("a+b = ") ;
    a.append("World") ;
    a.pLn("a+b+World = ") ;
  }
  
  private static void testEqual() {
    Cstring a = new Cstring("123456789012345678901234567890123456789012345678901234567890") ;
    a.pLn("a = ") ;
    Cstring b = new Cstring("123456789012345678901234567890123456789012345678901234567890") ;
    b.pLn("b = ") ;
    u.myassert(a.isEqual(b)) ;
    Cstring c = new Cstring("12345678901234567890123456789012345678901234567890123456789") ;
    c.pLn("c = ") ;
    u.myassert(a.isEqual(c) == false) ;
  }
  
  private static void testBench() {
    System.out.println("-----------Basic----------------");
    testBasic() ;
    System.out.println("-----------Addition----------------");
    testAdd() ;
    System.out.println("-----------Equal----------------");
    testEqual() ;
  }
  
  public static void main(String[] args) {
    System.out.println("Cstring.java");
    testBench();
    System.out.println("Cstring.java Done");
  }
  
}