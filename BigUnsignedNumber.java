package bigUnsignedNumber;

/**
 * File Name: BigUnsignedNumber.java 
 * Infinite capacity Unsigned Number
 * 
 * @author Jagadeesh Vasudevamurthy
 * @year 2017
 */
/*
 * To compile you require: CharArray.java, IntUtil.java RandomInt.java Cstring.java  BigUnsignedNumber.java
 */

class BigUnsignedNumber {
  private Cstring d; //data
  static IntUtil u = new IntUtil();
  //YOU CANNOT add any data members
  //YOU CAN add any public or private function so that all the tests will pass
  
  
  //WRITE ALL THE REQUIRED PROCEDURE REQUIRED TO COMPILE AND RUN BigUnsignedNumberTester.java 
  //NOTHING CAN BE CHANGED IN BigUnsignedNumberTester.java
  
  //First I need 4 constructors for empty, int, char and String 
  public BigUnsignedNumber(){
	  d = new Cstring();
  }
  
  public BigUnsignedNumber(int i){
	  if (i < 0){
		  return;
	  }
	  
	  d= new Cstring();
	  
	  //if number = 0 then --> add an initial 0.
	  if (i == 0){
		  char c = (char)(i+'0');
		  Cstring s = new Cstring(c);
		  d.append(s);
	  } else {
		  int reminder;
		  int counter;
		  
		  counter = i;
		  
		  do {
			  //for taking the last digit
			  reminder = counter%10;
			  
			  //casting the last digit to char
			  char c = (char)(reminder+'0');
			  
			  //initiating a new Cstring with new char.
			  Cstring s = new Cstring(c);
			  
			  //appending the original Cstring with newly come Cstring which is the last digit in the number			  
			  d.append(s);
			  
			  //removing the ALREADY USED last digit. To gain the new Last digit in the next iteration.
			  counter /= 10;
		  } while (counter >= 1);
		  
		  //This is necessary because the initialized is the reverse version of the number. With d.reverse we reorganize to orginal version!
		  d.reverse();
	  }
  }
  
  public BigUnsignedNumber(char c){
	  //We first need to validate is this char is representing a number or not.
	  if (checkNumberValidation(c)){
		  d = new Cstring(c);
	  }
  }
  
  public BigUnsignedNumber(String s){
	  d= new Cstring(s);
  }
  
  public void pLn(String s){
	  d.pLn(s);
  }
  
  public BigUnsignedNumber clone(){
	  BigUnsignedNumber clonnedB = new BigUnsignedNumber();
	  
	  clonnedB.d = d.clone();
	  
	  return clonnedB;
  }
  
  public BigUnsignedNumber add(BigUnsignedNumber big){
	  
	  int count = 0;
	  int countFirstArray = 0;
	  int countSecondArray = 0;
	  int lastCounter = 0;
	  
	  BigUnsignedNumber newB = new BigUnsignedNumber();
	  
	  Cstring firstS = new Cstring();
	  Cstring secondS = new Cstring();
	  Cstring addedS = new Cstring();
	  
	  //Compare the lengths of the Cstrings
	  do{
		  countFirstArray++;
	  }while(d.getCharAtIndex(countFirstArray) != '\0');
	  
	  do{
		  countSecondArray++;
	  }while(big.d.getCharAtIndex(countSecondArray) != '\0');
	  
	  //newB = big;
	  
	  //reverse it to make a proper sum
	  // note in the final we need to reverse the sum again.
	  big.d.reverse();
	  this.d.reverse();
	  
	  //set the bigger one to firstS
	  if(countFirstArray >= countSecondArray){
		  secondS = big.d.clone();
		  firstS = this.d.clone();
	  } else {
		  firstS = big.d.clone();
		  secondS = this.d.clone();
	  }
	  
	  int excessElement = 0;
	  
	  
	  //Might be better to change to while loop
	  do {
		  //start from first index NOT from 0!
		  count++;
		  
		  // when the short array hits the maximum number
		  // long array still need value to sum that why I converted it to 0
		  if(secondS.getCharAtIndex(count) == '\0'){
			  secondS.setToIndex(count, '0');
			  
			  if(firstS.getCharAtIndex(count) == '\0'){				  
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
	  addedS.reverse();
	  big.d.reverse();
	  this.d.reverse();
	  
	  
	  //Add the items to BigUnsignedNumber
	  //finding the length of added Sum
	 do{
		 newB.d.setToIndex(lastCounter, addedS.getCharAtIndex(lastCounter));
		  lastCounter++;
	  } while (addedS.getCharAtIndex(lastCounter) != '\0');
	  
	  return newB;
  }

  public boolean isEqual(BigUnsignedNumber controlEqual){
	  
	  Cstring givenString = new Cstring();
	  Cstring controlString = new Cstring();
	  
	  givenString = this.d.clone();
	  controlString = controlEqual.d.clone();
	  
	  // While initializing I put a null at index = 0. To do this I had to do it for the controlString.
	  controlString.reverse();
	  controlString.reverse();
	  
	  return givenString.isEqual(controlString);
	  
  }
  
  public boolean isEqual(String controlEqual){
	  Cstring givenString = new Cstring();
	  Cstring controlString = new Cstring(controlEqual);
	  
	  givenString = this.d.clone();
	  
	  // While initializing I put a null at index = 0. To do this I had to do it for the controlString.
	  controlString.reverse();
	  controlString.reverse();
	  
	  return givenString.isEqual(controlString);
  }
  
  public boolean isEqual(int controlEqual){
	  Cstring givenString = new Cstring();
	  
	  BigUnsignedNumber controller = new BigUnsignedNumber(controlEqual);
	  
	  Cstring controlString = controller.d.clone(); 
	  
	  givenString = this.d.clone();
	  
	  // While initializing I put a null at index = 0. To do this I had to do it for the controlString.
	  controlString.reverse();
	  controlString.reverse();
	  
	  return givenString.isEqual(controlString);
  }
  
  public int size(){
	  int size = this.d.counter();
	  return size;
  }
  
  //MULTIPLACATION
  public BigUnsignedNumber mult(BigUnsignedNumber factor){
	  BigUnsignedNumber result = new BigUnsignedNumber();
	  
	  Cstring firstFactorString = new Cstring();
	  Cstring secondFactorString = new Cstring();
	  Cstring multipliedString = new Cstring();
	  Cstring tempMultipliedString = new Cstring();
	  
	  firstFactorString = this.d.clone();
	  secondFactorString = factor.d.clone();
	  
	  int firstCount = firstFactorString.counter();
	  int secondCount = secondFactorString.counter();
	  
	  //setting longer one to put it on top. 
	  // For readability longer one will be setted to first String always
	  if ( secondCount  > firstCount){
		  secondFactorString = this.d.clone();
		  firstFactorString = factor.d.clone();
	  }
	  
	  //Reversing
	  firstFactorString.reverse();
	  secondFactorString.reverse();
	  
	  
	  int lowerCount = 0;
	  
	  int charMultiplication = 0;
	  int shiftCount = 0;
	  int lastCounter = 0;
	  	  
	  // Each digit of the LOWER (second) number will be multiplied by all the digits of UPPER (first) number
	  do {
		  lowerCount++;
		  int upperCount = 0;
		  int multipliedStringCount = 0;
		  int excessElement = 0;
		  
		  // To understand if are in the end  
		  if (secondFactorString.getCharAtIndex(lowerCount) == '\0'){
			  break;
		  }
		  
		  // For shifting the result by 1 in each iteration of the lower factor. 
		  if (lowerCount > 1){
			  shiftCount++;
			  tempMultipliedString = multipliedString;
			  multipliedString = new Cstring();
			  
			  //Shifting
			  for (int i = 1; i <= shiftCount; i++){

				  multipliedStringCount++;
				  multipliedString.setToIndex(i, (char)(0+'0'));
			  }
		  }
		  
		  int lowerDigit = (char)( secondFactorString.getCharAtIndex(lowerCount)-'0');
		  
		  do {
			  upperCount++;
			  multipliedStringCount++;
			  
			// To understand if we are in the end  
			  if (firstFactorString.getCharAtIndex(upperCount) == '\0'){
				  if (excessElement == 0){
					  break; 
				  } else {
					  multipliedString.setToIndex(multipliedStringCount, (char)(excessElement+'0'));
					  break;
				  }
				  
			  }
			  
			  int upperDigit = (char)(firstFactorString.getCharAtIndex(upperCount)-'0');
			  
			  charMultiplication = lowerDigit*upperDigit + excessElement;
			  
			  if (charMultiplication >= 10){
				  excessElement = charMultiplication/10;
				  charMultiplication = charMultiplication%10;
			  } else {
				  excessElement = 0;
			  }
			  
			  multipliedString.setToIndex(multipliedStringCount, (char)(charMultiplication+'0'));
			  
			  
			  
		  } while (firstFactorString.getCharAtIndex(upperCount) != '\0');
		  
		  if (lowerCount > 1){
			  multipliedString = multipliedString.sum(tempMultipliedString);
		  }
		  
	  } while (secondFactorString.getCharAtIndex(lowerCount) != '\0');
		 
	  // Reverse to original
	  multipliedString.reverse();
	  
	  //Add the items to BigUnsignedNumber
	  //through the length of multipliedResult
	 do{
		 lastCounter++;
		 result.d.setToIndex(lastCounter, multipliedString.getCharAtIndex(lastCounter));
		  
	  } while (multipliedString.getCharAtIndex(lastCounter) != '\0');
	  
	  return result;
  }
  
  
  public static BigUnsignedNumber factorial(int number){
	  BigUnsignedNumber givenNumber = new BigUnsignedNumber(number);
	  BigUnsignedNumber result;
	  
	  if(number == 0){
		  result = new BigUnsignedNumber(1);
	  } else {
		  result = givenNumber.mult(BigUnsignedNumber.factorial(number-1));
	  }
	  return result;
  }
  
  //Recursive Factorial Test.
  public int recursiveFactorial(int number){
	  if (number == 0){
		  return 1;
	  } else {
		  return number*recursiveFactorial(number-1);
	  }
  }
  
  //LOOP - Non Recursive Factorial Test.
  public int fact(int number){
	  int result = 1;
	  
	  while (number > 1){
		  result = result*number*(number-1);
		  number-=2;
	  }	  
	  return result;
  }
  
  private boolean checkNumberValidation(char possibleNumber){
	  return (possibleNumber >= '0' && possibleNumber <= '9') ? true : false;
  }
  
  public static void main(String[] args) {
    System.out.println("BigUnsignedNumber.java");
    
    System.out.println("BigUnsignedNumber.java Done");
  } 
}
